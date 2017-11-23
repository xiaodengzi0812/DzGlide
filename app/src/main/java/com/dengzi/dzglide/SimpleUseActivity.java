package com.dengzi.dzglide;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.dengzi.dzglide.custommodule.GlideApp;

import java.io.File;

/**
 * @Title: 简单使用
 * @Author: djk
 * @Time: 2017/11/21
 * @Version:1.0.0
 */
public class SimpleUseActivity extends AppCompatActivity {
    private String mImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511245796453&di=eca647d5a3d073e402eab855a8a1d318&imgtype=0&src=http%3A%2F%2Fpic31.nipic.com%2F20130719%2F13231189_014518621159_2.gif";
    private ImageView mImageView;
    private RequestOptions mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mOptions = MyApplication.getInstance().mOptions;
    }

    // 加载网络图片
    public void loadWebImage(View view) {
        GlideApp.with(this)
                .asDrawable()
                .transition(DrawableTransitionOptions.withCrossFade(1100))// 变换效果
                .transition(DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
                .load(mImageUrl)
                .into(mImageView);

       /* Glide.with(this)
                .asBitmap()
                .transition(BitmapTransitionOptions.withCrossFade())// 变换效果
                .load(mImageUrl)
                .apply(mOptions)
                .into(mImageView);*/
    }

    // 加载Gif图片
    public void loadGifImage(View view) {
        // 可以添加 .asGif(), 也可以不加,Glide会去判断是不是gif图片
        Glide.with(this).load(mImageUrl).apply(mOptions).into(mImageView);
    }

    // 加载本地图片
    public void loadDiskImage(View view) {
        // 可以直接加载一个本地路径
        String imagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "dengzi.jpg";
        Glide.with(this)
                .asBitmap()
                .load(imagePath)
                .apply(mOptions).into(mImageView);
    }

    // 加载资源图片
    public void loadResImage(View view) {
        // 直接加载一个资源id
        int resource = R.drawable.dengzi;
        Glide.with(this).load(resource).apply(mOptions).into(mImageView);
    }
}
