package com.dralong.demo.ui;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.widget.ImageView;

import com.dralong.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransitionDetailActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE = TransitionDetailActivity.class.getSimpleName() + ".IMAGE";
    @BindView(R.id.transition_detail_img)
    ImageView mImage;
    @BindView(R.id.fab)
    FloatingActionButton mFloatingButton;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int imageResId = getIntent().getExtras().getInt(EXTRA_IMAGE);
        mImage.setImageResource(imageResId);
        if (savedInstanceState == null) {
            mFloatingButton.setScaleX(0);
            mFloatingButton.setScaleY(0);
            getWindow().getEnterTransition().addListener(new CustomTransitionListener() {
                @Override
                public void onTransitionEnd(Transition transition) {
                    getWindow().getEnterTransition().removeListener(this);
                    mFloatingButton.animate().scaleX(1).scaleY(1);
                }
            });
        }
    }
    /**
     * 自定义的一个监听器。
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    class CustomTransitionListener implements Transition.TransitionListener, Animator.AnimatorListener {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

        @Override
        public void onTransitionStart(Transition transition) {

        }

        @Override
        public void onTransitionEnd(Transition transition) {

        }

        @Override
        public void onTransitionCancel(Transition transition) {

        }

        @Override
        public void onTransitionPause(Transition transition) {

        }

        @Override
        public void onTransitionResume(Transition transition) {

        }
    }
}
