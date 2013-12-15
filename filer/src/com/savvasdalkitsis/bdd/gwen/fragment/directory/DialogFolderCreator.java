package com.savvasdalkitsis.bdd.gwen.fragment.directory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;
import com.savvasdalkitsis.bdd.gwen.model.directory.FolderCreationListener;
import com.savvasdalkitsis.bdd.gwen.model.directory.FolderCreator;

import java.io.File;

public class DialogFolderCreator implements FolderCreator {

    private Context themedContext;

    public DialogFolderCreator(Context themedContext) {
        this.themedContext = themedContext;
    }

    @Override
    public void createNewFolder(final String basePath, final FolderCreationListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(themedContext);
        builder.setTitle("Create new folder");
        builder.setMessage("Enter folder name");

        final EditText input = new EditText(themedContext);
        input.setPadding(20, 20, 20, 20);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String folderName = input.getText().toString();
                if (create(basePath, folderName)) {
                    listener.onNewFolderCreated();
                } else {
                    listener.onNewFolderCreationFailed();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private boolean create(String basePath, String folderName) {
        File base = new File(basePath);
        return new File(base, folderName).mkdir();
    }
}
