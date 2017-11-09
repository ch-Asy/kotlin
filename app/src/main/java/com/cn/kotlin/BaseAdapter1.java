//package com.cn.kotlin;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//
//import java.util.HashMap;
//
//import butterknife.ButterKnife;
//
///**
// * @author:Sh
// * @date:2017/3/29
// * @desc: Adapter 基类
// **/
//public abstract class BaseAdapter1<T> extends BaseAdapter {
//
//    protected Activity mContext;
//    protected T mData;
//    HashMap<Integer, View> lmap = new HashMap<Integer, View>();
//    public BaseAdapter1(Activity context) {
//        mContext = context;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        BaseHolder holder = null;
//
//        if (lmap.get(position) == null) {
//            holder = getHolder(mContext);
//            convertView = LayoutInflater.from(mContext).inflate(getView(), parent,false);
//            ButterKnife.bind(holder, convertView);//用butterKnife绑定
//            convertView.setTag(holder);
//        } else {
//
//            convertView = lmap.get(position);
//            holder = (BaseHolder) convertView.getTag();
//        }
//        holder.setData(mContext,position, mData);//将数据传给holder
//        return convertView;
//    }
//
//    /**
//     * 返回对应的holder类
//     *
//     * @param context 引用
//     * @return 返回对应的holder子类，需要继承自BaseHolder
//     */
//    protected abstract BaseHolder getHolder(Context context);
//
//    /**
//     * @return 返回布局的资源文件id
//     */
//    protected abstract int getView();
//
//    /**
//     * 设置数据
//     *
//     * @param data 对应的数据
//     */
//    public void setData(T data) {
//        mData = data;
//    }
//
//
//}
//
