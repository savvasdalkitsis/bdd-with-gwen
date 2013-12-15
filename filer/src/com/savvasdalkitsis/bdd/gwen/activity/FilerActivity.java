package com.savvasdalkitsis.bdd.gwen.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Environment;
import com.savvasdalkitsis.bdd.gwen.R;
import com.savvasdalkitsis.bdd.gwen.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntryHandler;

import static com.savvasdalkitsis.bdd.gwen.module.factory.FactoryModule.directoryDisplayerFactory;

public class FilerActivity extends Activity {

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
        return DirectoryEntry.directoryFrom(Environment.getExternalStorageDirectory());
    }
}
