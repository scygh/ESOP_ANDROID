package com.scy.filemanager;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/11/5 16:25
 */
public class ChoiceBean {
    private String name;
    private int imageId;

    public ChoiceBean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
