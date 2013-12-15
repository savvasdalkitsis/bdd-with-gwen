package com.savvasdalkitsis.bdd.gwen.filer;

import android.app.Application;
import com.savvasdalkitsis.bdd.gwen.filer.module.ApplicationModule;

public class FilerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationModule.setApplicationReference(this);
    }
}
