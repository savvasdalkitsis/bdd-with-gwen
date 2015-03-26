package com.savvasdalkitsis.bddwithgwen.filer.android;

import android.content.Context;
import android.widget.Toast;

import com.savvasdalkitsis.bddwithgwen.filer.model.MessageDisplayer;

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
