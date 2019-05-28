package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.Wearable.WearableOptions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class DataClient extends GoogleApi<WearableOptions> {
    public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    public interface OnDataChangedListener extends DataListener {
        void onDataChanged(DataEventBuffer dataEventBuffer);
    }

    public static abstract class GetFdForAssetResponse implements Releasable {
        public abstract ParcelFileDescriptor getFdForAsset();

        public abstract InputStream getInputStream();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }

    public DataClient(Activity activity, Settings settings) {
        super(activity, Wearable.API, null, settings);
    }

    public DataClient(Context context, Settings settings) {
        super(context, Wearable.API, null, settings);
    }

    public abstract Task<Void> addListener(OnDataChangedListener onDataChangedListener);

    public abstract Task<Void> addListener(OnDataChangedListener onDataChangedListener, Uri uri, int i);

    public abstract Task<Integer> deleteDataItems(Uri uri);

    public abstract Task<Integer> deleteDataItems(Uri uri, int i);

    public abstract Task<DataItem> getDataItem(Uri uri);

    public abstract Task<DataItemBuffer> getDataItems();

    public abstract Task<DataItemBuffer> getDataItems(Uri uri);

    public abstract Task<DataItemBuffer> getDataItems(Uri uri, int i);

    public abstract Task<GetFdForAssetResponse> getFdForAsset(Asset asset);

    public abstract Task<GetFdForAssetResponse> getFdForAsset(DataItemAsset dataItemAsset);

    public abstract Task<DataItem> putDataItem(PutDataRequest putDataRequest);

    public abstract Task<Boolean> removeListener(OnDataChangedListener onDataChangedListener);
}
