package com.savvasdalkitsis.bdd.gwen.filer.module.model;

import com.savvasdalkitsis.bdd.gwen.filer.model.MessageDisplayer;
import com.savvasdalkitsis.bdd.gwen.filer.android.ToastMessageDisplayer;

import static com.savvasdalkitsis.bdd.gwen.filer.module.ApplicationModule.application;

public class MessageDisplayerModule {
    public static MessageDisplayer messageDisplayer() {
        return new ToastMessageDisplayer(application());
    }

}
