package com.savvasdalkitsis.bddwithgwen.filer.module;

import com.savvasdalkitsis.bddwithgwen.filer.FilerApplication;

public class ApplicationModule {
    private static FilerApplication application;

    public static FilerApplication application() {
        return application;
    }

    public static void setApplicationReference(FilerApplication application) {
        ApplicationModule.application = application;
    }
}
