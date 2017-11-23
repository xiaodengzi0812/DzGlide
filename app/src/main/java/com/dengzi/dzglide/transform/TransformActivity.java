package com.dengzi.dzglide.transform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.dengzi.dzglide.MyApplication;
import com.dengzi.dzglide.R;


/**
 * @Title: 图片变换功能
 * @Author: djk
 * @Time: 2017/11/21
 * @Version:1.0.0
 */
public class TransformActivity extends AppCompatActivity {
    private String mImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511325654889&di=9d691f573269f089c3f184a228c2e795&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F77094b36acaf2edd0bf8b939871001e9380193d1.jpg";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);
        mImageView = (ImageView) findViewById(R.id.image_view);
    }

    private void loadImage(RequestOptions options) {
        Glide.with(this)
                .load(mImageUrl)
                .apply(options)
                .into(mImageView);
    }

    // 图片基本适配,不会撑满全屏
    public void transformSimpleClick(View view) {
        RequestOptions options = MyApplication.getInstance().mOptions.clone()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);// 这里将图片尺寸设置为图片的大小,不会撑满全屏
        loadImage(options);
    }

    // 圆形
    public void circleClick(View view) {
        RequestOptions options = MyApplication.getInstance().mOptions.clone()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)// 这里将图片尺寸设置为图片的大小,不会撑满全屏
                .circleCrop();// 圆形图片
        loadImage(options);
    }

    // 圆角
    public void roundClick(View view) {
        RequestOptions options = MyApplication.getInstance().mOptions.clone()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)// 这里将图片尺寸设置为图片的大小,不会撑满全屏
                .transform(new RoundedCorners(20));// 圆角图片
        loadImage(options);
    }
}
