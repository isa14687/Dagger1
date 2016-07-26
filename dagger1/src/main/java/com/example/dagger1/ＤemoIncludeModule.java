package com.example.dagger1;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @Provides 需要代入參數的情況
 */
@Module(
        library = true,
        //參數需要由外部的class提供
        complete = false
)
public class ＤemoIncludeModule {

    public ＤemoIncludeModule() {
        super();
    }

    @Provides
    @Named("indString")
    public String provideString(int s) {
        Log.e("s1", "i get s1 " + s);
        return "include string";
    }

    @Provides
    public Button provideButton(Context context) {
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        Button v = new Button(context);
        v.setText("我是include");
        v.setLayoutParams(params);
        return v;
    }
}
