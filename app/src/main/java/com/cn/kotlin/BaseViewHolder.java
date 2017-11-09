package com.cn.kotlin;

import android.support.v7.widget.RecyclerView;
import android.view.View;


import butterknife.ButterKnife;

/**
 * ViewHolder的基类，该类给每个条目设置了点击事件，子类具体实现相应的点击事件只需实现onItemClick方法即可。
 * Created by wang on 2016/8/9 9:24.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    // 在父类的构造中已经给View设置了点击事件，点击事件的具体实现只需实现onItemClick方法即可

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
//        AutoUtils.autoSize(itemView);
        //给每个条目设置点击事件
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(v, getAdapterPosition());
            }
        });
    }

    /**
     * 绑定ViewHolder，具体子类具体实现
     *
     * @param position position
     */
    public abstract void onBindViewHolder(int position);

    /**
     * RecyclerView每个条目的点击事件
     *
     * @param view     RecyclerView的一个条目
     * @param position 第几个条目被点击了
     */
    public abstract void onItemClick(View view, int position);
}
