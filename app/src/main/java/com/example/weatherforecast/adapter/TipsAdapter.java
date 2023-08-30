package com.example.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.Bean.OtherTipsBean;
import com.example.weatherforecast.R;

import java.util.List;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.TipsViewHolder> {

    private Context mContext;
    private List<OtherTipsBean> mTipsBeans;

    public TipsAdapter(Context context, List<OtherTipsBean> mTipsBeans) {
        this.mContext = context;
        this.mTipsBeans = mTipsBeans;
    }

    @NonNull
    @Override
    public TipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tips_item_layout, parent, false);

        return new TipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipsViewHolder holder, int position) {
        OtherTipsBean otherTipsBean = mTipsBeans.get(position);
        holder.tvTitle.setText(otherTipsBean.getTitle());
        holder.tvDesc.setText(otherTipsBean.getDesc());
        holder.tvLevel.setText(otherTipsBean.getLevel());

    }

    @Override
    public int getItemCount() {
        if (mTipsBeans == null)
            return 0;
        return mTipsBeans.size();
    }

    class TipsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDesc, tvLevel;
        public TipsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvLevel = itemView.findViewById(R.id.tv_level);
        }
    }
}
