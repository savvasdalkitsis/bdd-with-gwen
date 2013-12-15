package com.savvasdalkitsis.bdd.gwen.filer.android.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.savvasdalkitsis.bdd.gwen.filer.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntryHandler;

import java.io.File;

import static com.savvasdalkitsis.bdd.gwen.filer.module.factory.FactoryModule.directoryDisplayerFactory;

public class FilerActivity extends Activity {

    private static final String PARAM_INITIAL_PATH = "com.savvasdalkitsis.bdd.gwen.filer.PARAM_INITIAL_PATH";
    private Factory<FragmentManager,DirectoryEntryHandler> directoryDisplayerFactory;

    @SuppressWarnings("UnusedDeclaration")
    public FilerActivity() {
        this(directoryDisplayerFactory());
    }

    public FilerActivity(Factory<FragmentManager, DirectoryEntryHandler> directoryDisplayerFactory) {
        this.directoryDisplayerFactory = directoryDisplayerFactory;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filer);

        if (savedInstanceState == null) {
            directoryDisplayerFactory.create(getFragmentManager()).handle(initialDirectory());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    private DirectoryEntry initialDirectory() {
        return DirectoryEntry.directoryFrom(directoryPath());
    }

    private File directoryPath() {
        String initialPath = getIntent().getStringExtra(PARAM_INITIAL_PATH);
        if (!TextUtils.isEmpty(initialPath)) {
            return new File(initialPath);
        }
        return Environment.getExternalStorageDirectory();
    }
}
