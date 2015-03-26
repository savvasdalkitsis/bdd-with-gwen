package com.savvasdalkitsis.bddwithgwen.filer.module.model;

import com.savvasdalkitsis.bddwithgwen.filer.android.ToastMessageDisplayer;
import com.savvasdalkitsis.bddwithgwen.filer.model.MessageDisplayer;

import static com.savvasdalkitsis.bddwithgwen.filer.module.ApplicationModule.application;

public class MessageDisplayerModule {
    public static MessageDisplayer messageDisplayer() {
        return new ToastMessageDisplayer(application());
    }

}
