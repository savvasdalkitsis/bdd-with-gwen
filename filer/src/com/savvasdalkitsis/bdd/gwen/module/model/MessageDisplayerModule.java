package com.savvasdalkitsis.bdd.gwen.module.model;

import com.savvasdalkitsis.bdd.gwen.model.MessageDisplayer;
import com.savvasdalkitsis.bdd.gwen.model.ToastMessageDisplayer;

import static com.savvasdalkitsis.bdd.gwen.module.ApplicationModule.application;

public class MessageDisplayerModule {
    public static MessageDisplayer messageDisplayer() {
        return new ToastMessageDisplayer(application());
    }

}
