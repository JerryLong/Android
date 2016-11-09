package com.dralong.demo.ui.permission;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import com.dralong.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 运行时权限详解
 *
 * 简书: http://www.jianshu.com/p/b3f196b741fa
 */
public class RuntimePermisionActivity extends AppCompatActivity {
    @BindView(R.id.permission_r_txt)
    TextView mTxt;

    private final int CAMERA_REQUEST_CODE = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permision);
        ButterKnife.bind(this);
    }

    void onClick(View view) {
        requestPermissions();
    }

    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 第一次请求权限时,向用户解释为什么需要这个权限，用户如果拒绝，下一次请求shouldShowRequestPermissionRationale()返回true
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                new AlertDialog.Builder(this)
                        .setMessage("申请存储空间权限")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //申请存储空间权限
                                ActivityCompat.requestPermissions(RuntimePermisionActivity.this,
                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_REQUEST_CODE);
                            }
                        })
                        .show();
            } else {
                //申请存储空间权限
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_REQUEST_CODE);
            }
        } else {
            mTxt.setTextColor(Color.GREEN);
            mTxt.setText("存储空间权限已申请");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mTxt.setTextColor(Color.GREEN);
                mTxt.setText("存储空间权限已申请");
            } else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    mTxt.setTextColor(Color.RED);
                    mTxt.setText("存储空间权限已被禁止");
                }
            }
        }
    }
}
