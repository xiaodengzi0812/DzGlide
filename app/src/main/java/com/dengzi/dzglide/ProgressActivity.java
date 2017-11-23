package com.dengzi.dzglide;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.dengzi.dzglide.glideokhttp.ProgressInterceptor;
import com.dengzi.dzglide.glideokhttp.ProgressListener;

/**
 * @author Djk
 * @Title: 带进度条的图片加载
 * @Time: 2017/11/23.
 * @Version:1.0.0
 */
public class ProgressActivity extends AppCompatActivity {
    private String mImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511414463265&di=b4f9eefd517d7deef59e16549a2c49d9&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201501%2F10%2F20150110210743_xXcB8.gif";
    private ImageView mImageView;
    private RequestOptions mOptions;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mOptions = MyApplication.getInstance().mOptions;
        initProgress();
    }

    private void initProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("加载中");
    }

    // 加载图片
    public void loadImage(View view) {
        ProgressInterceptor.addListener(mImageUrl, new ProgressListener() {
            @Override
            public void onProgress(int progress) {
                progressDialog.setProgress(progress);
            }
        });

        Glide.with(this)
                .load(mImageUrl)
                .apply(mOptions)
                .into(new DrawableImageViewTarget(mImageView) {
                    @Override
                    public void onLoadStarted(Drawable placeholder) {
                        super.onLoadStarted(placeholder);
                        progressDialog.show();
                    }

                    @Override
                    public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                        progressDialog.dismiss();
                        ProgressInterceptor.removeListener(mImageUrl);
                    }
                });
    }
}
