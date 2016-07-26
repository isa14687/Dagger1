package com.example.dagger1;

import android.app.Application;

import dagger.ObjectGraph;

public class DemoApplication extends Application {
    ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        //創建對象圖
        //用於管理module
        graph = ObjectGraph.create(
                new DemoModule(this)
        );
    }

    public void inject(Object obj) {
        //注入
        graph.inject(obj);
    }
}
