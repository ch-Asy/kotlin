package com.cn.kotlin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by anliyuan on 2017/7/26.
 */

public abstract class BaseHeaderAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    public final int ITEM_VIEW_TYPE_HEADER = 0;
    public final int ITEM_VIEW_TYPE_ITEM = 1;
    private View header;
    public int headerSize = 0;
    public List<T> lists;

    public BaseHeaderAdapter(List<T> lists, View header) {
        if (header != null) {
            headerSize = 1;
            this.header = header;
        }
        this.lists = lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            return new HeaderHolder(header);
        }
        return Holder(inflate(parent,viewType),viewType);
    }

    public abstract View inflate(ViewGroup parent, int viewType);

    public abstract BaseViewHolder Holder(View view, int viewType);


    @Override
    public int getItemCount() {
        if (lists == null) {
            return headerSize;
        }
        return lists.size() + headerSize;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (isHeader(position)) {
            return;
        }
        holder.onBindViewHolder(position - headerSize);
    }

    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }

    public boolean isHeader(int position) {
        if (headerSize == 0) {
            return false;
        }
        return position == 0;
    }


    public class HeaderHolder extends BaseViewHolder {


        public HeaderHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBindViewHolder(int position) {

        }

        @Override
        public void onItemClick(View view, int position) {

        }
    }
}
