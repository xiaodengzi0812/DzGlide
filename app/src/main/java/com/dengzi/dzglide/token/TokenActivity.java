package com.dengzi.dzglide.token;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.dengzi.dzglide.MyApplication;
import com.dengzi.dzglide.R;

/**
 * @Title: Target使用
 * @Author: djk
 * @Time: 2017/11/21
 * @Version:1.0.0
 */
public class TokenActivity extends AppCompatActivity {
    private String mImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511245796453&di=eca647d5a3d073e402eab855a8a1d318&imgtype=0&src=http%3A%2F%2Fpic31.nipic.com%2F20130719%2F13231189_014518621159_2.gif";
    private ImageView mImageView;
    private RequestOptions mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mOptions = MyApplication.getInstance().mOptions.clone();
    }

    // tokenClick
    public void tokenClick(View view) {
        Glide.with(this)
                .asBitmap()
                .load(new MyGlideUrl(mImageUrl))// 这里添加一个我们自定义的GlideUrl,将Token过滤掉
                .listener(new RequestListener<Bitmap>() {// 我们还可以添加一个图片加载监听
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                        // 加载失败的回调
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                        // 加载成功的回调
                        return false;
                    }
                })
                .apply(mOptions)
                .into(mImageView);
    }
}
