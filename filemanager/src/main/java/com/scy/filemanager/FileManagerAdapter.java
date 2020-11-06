package com.scy.filemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/11/5 15:52
 */
public class FileManagerAdapter extends RecyclerView.Adapter<FileManagerAdapter.ViewHolder> {

    private Context mContext;
    private List<ChoiceBean> choiceBeans;

    public FileManagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<ChoiceBean> choiceBeans) {
        this.choiceBeans = choiceBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.filemanager_rvitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivIcon.setImageResource(choiceBeans.get(position).getImageId());
        holder.tvName.setText(choiceBeans.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return choiceBeans != null ? choiceBeans.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.filemanager_rvitem_icon);
            tvName = itemView.findViewById(R.id.filemanager_rvitem_name);
        }
    }
}
