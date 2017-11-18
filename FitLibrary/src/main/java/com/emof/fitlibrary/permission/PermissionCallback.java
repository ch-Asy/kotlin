package com.emof.fitlibrary.permission;

import java.io.Serializable;

public interface PermissionCallback extends Serializable {

    void onClose();//用户关闭申请

    void onFinish();//完成申请

    void onDeny(String permission, int position);

    void onGuarantee(String permission, int position);
}