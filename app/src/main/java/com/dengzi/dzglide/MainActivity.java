package com.dengzi.dzglide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dengzi.dzglide.target.TargetUseActivity;
import com.dengzi.dzglide.token.TokenActivity;
import com.dengzi.dzglide.transform.TransformActivity;
import com.dengzi.dzglide.transformdemo.TransformDemoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleClick(View view) {
        startActivity(new Intent(MainActivity.this, SimpleUseActivity.class));
    }

    public void targetClick(View view) {
        startActivity(new Intent(MainActivity.this, TargetUseActivity.class));
    }

    public void tokenClick(View view) {
        startActivity(new Intent(MainActivity.this, TokenActivity.class));
    }

    public void transformClick(View view) {
        startActivity(new Intent(MainActivity.this, TransformActivity.class));
    }

    public void transformDemoClick(View view) {
        startActivity(new Intent(MainActivity.this, TransformDemoActivity.class));
    }

    public void progressClick(View view) {
        startActivity(new Intent(MainActivity.this, ProgressActivity.class));
    }
}
