package com.dengzi.dzglide.target;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.dengzi.dzglide.MyApplication;
import com.dengzi.dzglide.R;

/**
 * @Title: Target使用
 * @Author: djk
 * @Time: 2017/11/21
 * @Version:1.0.0
 */
public class TargetUseActivity extends AppCompatActivity {
    private String mImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511245796453&di=eca647d5a3d073e402eab855a8a1d318&imgtype=0&src=http%3A%2F%2Fpic31.nipic.com%2F20130719%2F13231189_014518621159_2.gif";
    private String mBgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511325654889&di=9d691f573269f089c3f184a228c2e795&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F77094b36acaf2edd0bf8b939871001e9380193d1.jpg";
    private ImageView mImageView;
    private MyLayout mTargetLayout;
    private RequestOptions mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mTargetLayout = (MyLayout) findViewById(R.id.target_view);
        mOptions = MyApplication.getInstance().mOptions;
    }

    SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            mImageView.setImageBitmap(bitmap);
        }
    };

    // simpleTarget
    public void simpleTargetClick(View view) {
        mTargetLayout.setBackground(null);
        mImageView.setVisibility(View.VISIBLE);
        Glide.with(this).asBitmap().load(mImageUrl).apply(mOptions).into(simpleTarget);
    }

    // viewTarget
    public void viewTargetClick(View view) {
        mImageView.setVisibility(View.GONE);
        Glide.with(this).load(mBgUrl).apply(mOptions).into(mTargetLayout.getTarget());
    }
}
