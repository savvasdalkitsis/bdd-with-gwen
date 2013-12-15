package com.savvasdalkitsis.bdd.gwen.filer.module;

import com.savvasdalkitsis.bdd.gwen.filer.FilerApplication;

public class ApplicationModule {
    private static FilerApplication application;

    public static FilerApplication application() {
        return application;
    }

    public static void setApplicationReference(FilerApplication application) {
        ApplicationModule.application = application;
    }
}
