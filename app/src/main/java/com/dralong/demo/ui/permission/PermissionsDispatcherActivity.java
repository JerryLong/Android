package com.dralong.demo.ui.permission;

import android.Manifest;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dralong.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


/**
 * @NeedsPermission 当申请的权限被用户允许后，调用此方法。
 * @OnShowRationale 当第一次申请权限时，用户选择拒绝，再次申请时调用此方法，在此方法中提示用户为什么需要这个权限。
 * @OnPermissionDenied 当申请的权限被用户拒绝后，调用此方法
 * @OnNeverAskAgain 当用户点击不再询问后，调用此方法。
 */
@RuntimePermissions
public class PermissionsDispatcherActivity extends AppCompatActivity {
    @BindView(R.id.permission_d_txt)
    TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_dispatcher);
        ButterKnife.bind(this);
    }
    void onClick(View view) {
        PermissionsDispatcherActivityPermissionsDispatcher.needsPermissionWithCheck(this);
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void needsPermission() {
        mTxt.setTextColor(Color.GREEN);
        mTxt.setText("存储空间权限已申请成功");
    }

    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showRationale(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("申请存储空间权限")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //再次执行请求
                        request.proceed();
                    }
                })
                .show();
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void permissionDenied() {
        mTxt.setTextColor(Color.RED);
        mTxt.setText("权限被拒绝");
    }

    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void neverAskAgain() {
        mTxt.setTextColor(Color.YELLOW);
        mTxt.setText("不再询问");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsDispatcherActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
