package com.savvasdalkitsis.bdd.gwen.model;

import android.content.Context;
import android.widget.Toast;

public class ToastMessageDisplayer implements MessageDisplayer {

    private final Context context;

    public ToastMessageDisplayer(Context context) {
        this.context = context;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
