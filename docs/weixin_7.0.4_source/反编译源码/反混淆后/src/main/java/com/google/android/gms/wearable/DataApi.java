package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public interface DataApi {
    public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    @Deprecated
    public interface DataListener {
        void onDataChanged(DataEventBuffer dataEventBuffer);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }

    @Deprecated
    public interface DataItemResult extends Result {
        DataItem getDataItem();
    }

    @Deprecated
    public interface DeleteDataItemsResult extends Result {
        int getNumDeleted();
    }

    @Deprecated
    public interface GetFdForAssetResult extends Releasable, Result {
        ParcelFileDescriptor getFd();

        InputStream getInputStream();
    }

    PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener);

    PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener, Uri uri, int i);

    PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri);

    PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i);

    PendingResult<DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri);

    PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient);

    PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri);

    PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri, int i);

    PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset);

    PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset);

    PendingResult<DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest);

    PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataListener dataListener);
}
