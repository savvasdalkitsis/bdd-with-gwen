package com.savvasdalkitsis.bdd.gwen.module;

import com.savvasdalkitsis.bdd.gwen.FilerApplication;

public class ApplicationModule {
    private static FilerApplication application;

    public static FilerApplication application() {
        return application;
    }

    public static void setApplicationReference(FilerApplication application) {
        ApplicationModule.application = application;
    }
}
