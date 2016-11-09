package com.dralong.demo.ui;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.dralong.demo.R;
import com.dralong.demo.adapter.CommonAdapter;
import com.dralong.demo.adapter.MultiItemTypeAdapter;
import com.dralong.demo.adapter.base.ViewHolder;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Android 转场动画
 */
public class TransitionActivity extends AppCompatActivity {
    @BindView(R.id.main_recycler)
    RecyclerView mRecycler;
    CommonAdapter mAdapter;

    Integer[] imgs=new Integer[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecycler.setLayoutManager(new GridLayoutManager(this,2));
//        mRecycler.addItemDecoration(new DividerDecoration(this));
        mAdapter=new CommonAdapter<Integer>(this,R.layout.item_transition_img_adapter, Arrays.asList(imgs)) {

            @Override
            protected void convert(ViewHolder holder, Integer integer, int position) {
                holder.setImageResource(R.id.item_transition_img,integer);
            }
        };
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object obj, int position) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TransitionActivity.this, view, getString(R.string.image_transition_name));
                ImageView imageView= (ImageView) view.findViewById(R.id.item_transition_img);
                Intent intent = new Intent(TransitionActivity.this, TransitionDetailActivity.class);
                intent.putExtra(TransitionDetailActivity.EXTRA_IMAGE,imgs[position]);
                startActivity(intent, options.toBundle());
            }
        });
        mRecycler.setAdapter(mAdapter);
    }
}
