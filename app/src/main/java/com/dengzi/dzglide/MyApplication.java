
package com.dengzi.dzglide;

import android.app.Application;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dengzi.dzglide.custommodule.MyAppGlideModule;

/**
 * @author Djk
 * @Title:
 * @Time: 2017/11/22.
 * @Version:1.0.0
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public RequestOptions mOptions;
    private MyAppGlideModule appGlideModule;

    public static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initGlideModule();
        initOptions();
    }

    private void initGlideModule() {
        appGlideModule = new MyAppGlideModule();
    }

    private void initOptions() {
        mOptions = RequestOptions
                .placeholderOf(R.drawable.loading)// 占位符
                .error(R.drawable.error)// 错误图
                .diskCacheStrategy(DiskCacheStrategy.NONE)// 不用本地缓存
                .skipMemoryCache(true);// 禁用内存缓存
    }
}
