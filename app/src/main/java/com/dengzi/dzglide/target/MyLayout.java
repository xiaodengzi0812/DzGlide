package com.dengzi.dzglide.target;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * @author Djk
 * @Title: 自定义布局加载图片(Glide自定义ViewTarget的使用)
 * @Time: 2017/11/21.
 * @Version:1.0.0
 */
public class MyLayout extends RelativeLayout {

    private ViewTarget<MyLayout, Drawable> viewTarget;

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewTarget = new ViewTarget<MyLayout, Drawable>(this) {
            @Override
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                MyLayout myLayout = getView();
                myLayout.setImageAsBackground(drawable);
            }
        };
    }

    public ViewTarget<MyLayout, Drawable> getTarget() {
        return viewTarget;
    }

    public void setImageAsBackground(Drawable resource) {
        setBackground(resource);
    }

}