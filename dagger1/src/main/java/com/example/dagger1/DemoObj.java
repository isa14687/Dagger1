package com.example.dagger1;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 套用的建構式標記  @Inject
 * 若有帶入參數，會從 @Provides 自動帶入，或是自行以@Named 指定
 */
public class DemoObj {
    private String string;

    public DemoObj(@Named("string1") String string, @Named("string3") String string2) {
        super();
        this.string = string;
        Log.e("init", "參數數量:    2");
        Log.e("init", "參數1   " + string);
        Log.e("init", "參數2   " + string2);
    }


    public DemoObj() {
        Log.e("init", "無參數");
    }

    @Inject
    public DemoObj(DemoModule demoModule) {
        Log.e("init", "demoModule  " + demoModule);
    }

    public String getDemoString() {
        return string;
    }
}
