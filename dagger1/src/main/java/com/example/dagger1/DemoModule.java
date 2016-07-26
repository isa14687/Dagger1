package com.example.dagger1;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 若使用 @Provides，需標註 @Module
 */

@Module(
        //註入的class
        injects = MainActivity.class,
        //有 @Provides 未使用時先聲明
        library = true,
        //帶入 Provides
        includes = ＤemoIncludeModule.class
)
public class DemoModule {
    private Context context;

    public DemoModule(Context context) {
        super();
        this.context = context;
    }

    /**
     * @Provides 注入的提供者
     * @Singleton 回傳單例
     * 名稱不重要，重點是回傳變數型態
     */

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    @Provides
    @Named("string1")
    public String provideString1() {
        return "providerString";
    }

    @Provides
    @Named("string2")
    public String provideString2() {
        return "providerString2";
    }

    @Provides
    @Named("string3")
    public String provideString3() {
        return "providerString3";
    }

    @Provides
    public int provideInt() {
        return 12345;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public DemoModule provideDemoModule() {
        return new DemoModule(context);
    }

}
