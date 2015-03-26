package com.savvasdalkitsis.bddwithgwen.filer;

import android.app.Application;

import com.savvasdalkitsis.bddwithgwen.filer.module.ApplicationModule;

public class FilerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationModule.setApplicationReference(this);
    }
}
