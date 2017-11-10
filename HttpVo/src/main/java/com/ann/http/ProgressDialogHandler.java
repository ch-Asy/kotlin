package com.ann.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.ann.http.widget.LoadDialog;


/**
 * Created by wang on 2016/8/25 14:40.
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;



    private Context context;
    private boolean cancelable;

    /**
     * Progress进度条要显示的文字
     */
    private String tigMsg;
    private boolean isShow ;

    public ProgressDialogHandler(Context context, boolean cancelable, boolean isShow) {
        this.context = context;
        this.cancelable = cancelable;
        this.isShow = isShow;

    }


    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                if (isShow) {
                    LoadDialog.show(context, tigMsg,cancelable);
                }
                break;
            case DISMISS_PROGRESS_DIALOG:
                if (isShow) {
                    LoadDialog.dismiss(context);
                }
                break;
        }
    }


    /**
     * 设置进度条的文字
     *
     * @param text 进度条显示的文字
     */
    public void setTipMsg(String text) {
        tigMsg = text;
    }




}
