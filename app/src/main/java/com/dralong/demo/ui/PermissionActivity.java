package com.dralong.demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dralong.demo.R;
import com.dralong.demo.ui.permission.PermissionsDispatcherActivity;
import com.dralong.demo.ui.permission.RuntimePermisionActivity;

/**
 * 运行时权限详解
 *
 * 简书: http://www.jianshu.com/p/b3f196b741fa
 */
public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }
    void onClick(View view) {
        if (view.getId() == R.id.permission_pd) {
            startActivity(new Intent(this, PermissionsDispatcherActivity.class));
        } else if (view.getId() == R.id.permission_rp) {
            startActivity(new Intent(this, RuntimePermisionActivity.class));
        }
    }
}
