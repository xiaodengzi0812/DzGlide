package com.dengzi.dzglide.transformdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dengzi.dzglide.R;
import com.dengzi.dzglide.transformdemo.MyAdapter.Type;

import java.util.ArrayList;
import java.util.List;

public class TransformDemoActivity extends AppCompatActivity {
    private List<Type> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_demo);
        initData();
        initRecycler();
    }

    private void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, mDataList));
    }

    private void initData() {
        mDataList.add(Type.Mask);
        mDataList.add(Type.NinePatchMask);
        mDataList.add(Type.CropTop);
        mDataList.add(Type.CropCenter);
        mDataList.add(Type.CropBottom);
        mDataList.add(Type.CropSquare);
        mDataList.add(Type.CropCircle);
        mDataList.add(Type.ColorFilter);
        mDataList.add(Type.Grayscale);
        mDataList.add(Type.RoundedCorners);
        mDataList.add(Type.Blur);
        mDataList.add(Type.Toon);
        mDataList.add(Type.Sepia);
        mDataList.add(Type.Contrast);
        mDataList.add(Type.Invert);
        mDataList.add(Type.Pixel);
        mDataList.add(Type.Sketch);
        mDataList.add(Type.Swirl);
        mDataList.add(Type.Brightness);
        mDataList.add(Type.Kuawahara);
        mDataList.add(Type.Vignette);
    }
}
