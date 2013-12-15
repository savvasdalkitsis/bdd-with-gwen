package com.savvasdalkitsis.bdd.gwen.filer.android.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryContents;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry;

public class DirectoryListAdapter extends BaseAdapter{

    private DirectoryContents directoryContents;

    public DirectoryListAdapter(DirectoryContents directoryContents) {
        this.directoryContents = directoryContents;
    }

    @Override
    public int getCount() {
        return directoryContents.itemCount();
    }

    @Override
    public DirectoryEntry getItem(int position) {
        return directoryContents.getEntry(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getDirectoryListRow(convertView, parent)
                .bindTo(getItem(position));
    }

    private DirectoryListRowView getDirectoryListRow(View convertView, ViewGroup parent) {
        DirectoryListRowView row = (DirectoryListRowView) convertView;
        if (convertView == null) {
            row = new DirectoryListRowView(parent.getContext());
        }
        return row;
    }
}
