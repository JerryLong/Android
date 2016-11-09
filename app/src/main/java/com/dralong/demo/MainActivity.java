package com.dralong.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dralong.demo.adapter.CommonAdapter;
import com.dralong.demo.adapter.DividerDecoration;
import com.dralong.demo.adapter.MultiItemTypeAdapter;
import com.dralong.demo.adapter.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_recycler)
    RecyclerView mRecycler;
    CommonAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerDecoration(this));
        mAdapter=new CommonAdapter<HashMap<String, Object>>(this,R.layout.item_main_adapter, (List<HashMap<String, Object>>) setItem()) {
            @Override
            protected void convert(ViewHolder holder, HashMap<String, Object> obj, int position) {
                holder.setText(R.id.item_main_txt,obj.get("title").toString());
            }
        };
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object obj, int position) {
                HashMap<String, Object> item = (HashMap<String, Object>) obj;
                Intent intent = (Intent) item.get("intent");
                startActivity(intent);
            }
        });
        mRecycler.setAdapter(mAdapter);
    }
    private List<? extends Map<String, ?>> setItem() {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//        createItem(list, "6.0 运行时权限", PermissionActivity.class);
//        createItem(list, "转场动画", TransitionActivity.class);
        return list;
    }
    private void createItem(List<HashMap<String, Object>> list, String title,
                            Class<?> object) {
        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("title", title);
        item.put("intent", new Intent(this, object));
        list.add(item);
    }
}
