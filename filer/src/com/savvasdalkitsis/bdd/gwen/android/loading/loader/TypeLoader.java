package com.savvasdalkitsis.bdd.gwen.android.loading.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;


public class TypeLoader<T> extends AsyncTaskLoader<T> {

    private DataRetriever<T> dataRetriever;
    protected T result;

    public TypeLoader(Context context, DataRetriever<T> dataRetriever) {
        super(context);
        this.dataRetriever = dataRetriever;
    }

    @Override
    public T loadInBackground() {
        try {
            result = dataRetriever.retrieveData();
        } catch (final Exception e) {
            Log.e(TypeLoader.class.getName(), "Error retrieving data", e);
        }

        return result;
    }

    @Override
    public void deliverResult(final T data) {
        if (isReset()) {
            return;
        }

        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        if (result != null) {
            deliverResult(result);
        }
        if (takeContentChanged() || result == null) {
            forceLoad();
        }
    }


    @Override
    protected void onReset() {
        super.onReset();
        result = null;
    }
}