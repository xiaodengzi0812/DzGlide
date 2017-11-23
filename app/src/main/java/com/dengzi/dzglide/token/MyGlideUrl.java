package com.dengzi.dzglide.token;

import com.bumptech.glide.load.model.GlideUrl;

/**
 * @author Djk
 * @Title: 过滤图片Url中带Token
 * 同一张图片,带不同的Token缓存就失效了,所以我们在处理缓存的时候要过滤掉Token
 * @Time: 2017/11/21.
 * @Version:1.0.0
 */
public class MyGlideUrl extends GlideUrl {
    private String mUrl;

    public MyGlideUrl(String url) {
        super(url);
        mUrl = url;
    }

    @Override
    public String getCacheKey() {
        return mUrl.replace(findTokenParam(), "");
    }

    /**
     * 过滤Token
     *
     * @return 过滤掉Token之后的图片地址
     */
    private String findTokenParam() {
        String tokenParam = "";
        int tokenKeyIndex = mUrl.indexOf("?token=") >= 0 ? mUrl.indexOf("?token=") : mUrl.indexOf("&token=");
        if (tokenKeyIndex != -1) {
            int nextAndIndex = mUrl.indexOf("&", tokenKeyIndex + 1);
            if (nextAndIndex != -1) {
                tokenParam = mUrl.substring(tokenKeyIndex + 1, nextAndIndex + 1);
            } else {
                tokenParam = mUrl.substring(tokenKeyIndex);
            }
        }
        return tokenParam;
    }
}
