package com.ann.http;

import android.content.Context;

import com.ann.http.iml.SubscriberOnNextListener;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anliyuan on 2017/11/10.
 */

public class ProgressSubscriber<T> implements Observer<T> {
    private static final String TAG = ProgressSubscriber.class.getSimpleName();
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable d = null;

    /**
     * 封装了ProgressDialog的观察者类，在开始之前显示progress，完成之后dismiss progress
     *
     * @param context                   context
     * @param mSubscriberOnNextListener onNext方法的回调接口
     * @param cancelable                点击progress是否可取消
     * @param progressText              进度条要显示的文字
     */
    public ProgressSubscriber(Context context, SubscriberOnNextListener mSubscriberOnNextListener, boolean
            cancelable, boolean show, String progressText) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        if (show) {
            mProgressDialogHandler = new ProgressDialogHandler(context, cancelable, true);
            mProgressDialogHandler.setTipMsg(progressText);
        }
    }


    /**
     * 显示progress
     */
    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    /**
     * dismiss progress
     */
    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG)
                    .sendToTarget();
            mProgressDialogHandler = null;
            unSubscribe();
        }
    }


    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        showProgressDialog();
    }


    private void unSubscribe() {
        if (d.isDisposed()) d.dispose();
    }

    @Override
    public void onNext(T t) {
        dismissProgressDialog();
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //TODO 异常处理
        dismissProgressDialog();
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onError();
            unSubscribe();
        }
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
        unSubscribe();
    }
}
