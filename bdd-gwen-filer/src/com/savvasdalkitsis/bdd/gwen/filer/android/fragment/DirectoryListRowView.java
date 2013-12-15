package com.savvasdalkitsis.bdd.gwen.filer.android.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.common.collect.ImmutableMap;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry;

import java.util.Map;

public class DirectoryListRowView extends FrameLayout {

    private static final Map<DirectoryEntry.Type, Integer> ICONS = ImmutableMap.of(
            DirectoryEntry.Type.FILE, R.drawable.file,
            DirectoryEntry.Type.DIRECTORY, R.drawable.folder
    );
    private TextView name;
    private ImageView icon;

    public DirectoryListRowView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.view_directory_row, this, true);
        name = (TextView) root.findViewById(R.id.name);
        icon = (ImageView) root.findViewById(R.id.icon);
    }

    public DirectoryListRowView bindTo(DirectoryEntry directoryEntry) {
        name.setText(directoryEntry.getShortName());
        icon.setImageResource(ICONS.get(directoryEntry.getType()));
        return this;
    }
}
