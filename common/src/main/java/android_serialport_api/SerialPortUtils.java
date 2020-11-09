package android_serialport_api;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class SerialPortUtils {

    private final String TAG = "SerialPortUtils";
    public boolean serialPortStatus = false; //是否打开串口标志
    public String data_;
    public boolean threadStatus; //线程状态，为了安全终止线程

    public SerialPort serialPort = null;
    public InputStream inputStream = null;
    public OutputStream outputStream = null;
    public ChangeTool changeTool = new ChangeTool();


    /**
     * 打开串口
     *
     * @return serialPort串口对象
     */
    public SerialPort openSerialPort(String path, int baudrate) {
        try {
            serialPort = new SerialPort(new File(path), baudrate, 0);// TODO: 2019/7/28  打开串口异常，path需修改,流报空指针
            this.serialPortStatus = true;
            threadStatus = false; //线程状态

            //获取打开的串口中的输入输出流，以便于串口数据的收发
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
            ReadThread readThread = new ReadThread();
            readThread.start(); //开始线程监控是否有数据要接收
        } catch (IOException e) {
            Log.d(TAG, "openSerialPort: 打开串口异常：" + e.toString());
            return serialPort;
        }
        Log.d(TAG, "openSerialPort: 打开串口成功");
        return serialPort;
    }

    /**
     * 关闭串口
     */
    public void closeSerialPort() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            this.serialPortStatus = false;
            this.threadStatus = true; //线程状态
            if (serialPort != null) {
                serialPort.close();
            }
        } catch (IOException e) {
            Log.e(TAG, "closeSerialPort: 关闭串口异常：" + e.toString());
            return;
        }
        Log.d(TAG, "closeSerialPort: 关闭串口成功");
    }

    /**
     * 发送串口指令（字符串）
     *
     * @param data String数据指令
     */
    public void sendSerialPort(String data) {
        Log.d(TAG, "sendSerialPort: 发送数据");
        try {
            byte[] sendData = ChangeTool.HexToByteArr(data.replace(" ", ""));
            this.data_ = new String(sendData); //byte[]转string
            if (sendData.length > 0) {
                outputStream.write(sendData);
                outputStream.write('\n');
                //outputStream.write('\r'+'\n');
                outputStream.flush();
                Log.d(TAG, "sendSerialPort: 串口数据发送成功");
            }
        } catch (IOException e) {
            Log.e(TAG, "sendSerialPort: 串口数据发送失败：" + e.toString());
        }

    }

    public void sendSerialPort(int data) {
        String hexString = Integer.toHexString(data);
        Log.d(TAG, "sendSerialPort: 发送数据" + hexString);
        try {
            outputStream.write(data);
            outputStream.flush();
            Log.d(TAG, "sendSerialPort: 串口数据发送成功");
        } catch (IOException e) {
            Log.e(TAG, "sendSerialPort: 串口数据发送失败：" + e.toString());
        }

    }

    /**
     * 单开一线程，来读数据
     */
    private class ReadThread extends Thread {
        @Override
        public void run() {
            super.run();
            //判断进程是否在运行，更安全的结束进程
            while (!threadStatus) {
                Log.d(TAG, "进入线程run");
                //64   1024
                byte[] buffer = new byte[64];
                int size; //读取数据的大小
                try {
                    size = inputStream.read(buffer);
                    if (size > 0) {
                        Log.d(TAG, "run: 接收到了数据：" + changeTool.ByteArrToHex(buffer));
                        Log.d(TAG, "run: 接收到了数据大小：" + String.valueOf(size));
                        if (onDataReceiveListener != null) {
                            onDataReceiveListener.onDataReceive(buffer, size);
                        } else {
                            Log.e(TAG, "onDataReceiveListener = null");
                        }
                    }
                } catch (IOException e) {
                    Log.e(TAG, "run: 数据读取异常：" + e.toString());
                }
            }

        }
    }

    public OnDataReceiveListener onDataReceiveListener = null;

    public interface OnDataReceiveListener {
        void onDataReceive(byte[] buffer, int size);
    }

    public void setOnDataReceiveListener(OnDataReceiveListener dataReceiveListener) {
        onDataReceiveListener = dataReceiveListener;
    }

    public void setOnDataReceiveListenerNull() {
        onDataReceiveListener = null;
    }


}
