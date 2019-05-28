package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbw implements DataApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.m2504i(71119);
        PendingResult zza = zzb.zza(googleApiClient, new zzce(intentFilterArr), dataListener);
        AppMethodBeat.m2505o(71119);
        return zza;
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener) {
        AppMethodBeat.m2504i(71117);
        PendingResult zza = zza(googleApiClient, dataListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED")});
        AppMethodBeat.m2505o(71117);
        return zza;
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener, Uri uri, int i) {
        AppMethodBeat.m2504i(71118);
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        PendingResult zza = zza(googleApiClient, dataListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", uri, i)});
        AppMethodBeat.m2505o(71118);
        return zza;
    }

    public final PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.m2504i(71113);
        PendingResult deleteDataItems = deleteDataItems(googleApiClient, uri, 0);
        AppMethodBeat.m2505o(71113);
        return deleteDataItems;
    }

    public final PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(71114);
        Asserts.checkNotNull(uri, "uri must not be null");
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcb(this, googleApiClient, uri, i));
        AppMethodBeat.m2505o(71114);
        return enqueue;
    }

    public final PendingResult<DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.m2504i(71109);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzby(this, googleApiClient, uri));
        AppMethodBeat.m2505o(71109);
        return enqueue;
    }

    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(71110);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbz(this, googleApiClient));
        AppMethodBeat.m2505o(71110);
        return enqueue;
    }

    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.m2504i(71111);
        PendingResult dataItems = getDataItems(googleApiClient, uri, 0);
        AppMethodBeat.m2505o(71111);
        return dataItems;
    }

    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(71112);
        Asserts.checkNotNull(uri, "uri must not be null");
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzca(this, googleApiClient, uri, i));
        AppMethodBeat.m2505o(71112);
        return enqueue;
    }

    public final PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset) {
        AppMethodBeat.m2504i(71115);
        IllegalArgumentException illegalArgumentException;
        if (asset == null) {
            illegalArgumentException = new IllegalArgumentException("asset is null");
            AppMethodBeat.m2505o(71115);
            throw illegalArgumentException;
        } else if (asset.getDigest() == null) {
            illegalArgumentException = new IllegalArgumentException("invalid asset");
            AppMethodBeat.m2505o(71115);
            throw illegalArgumentException;
        } else if (asset.getData() != null) {
            illegalArgumentException = new IllegalArgumentException("invalid asset");
            AppMethodBeat.m2505o(71115);
            throw illegalArgumentException;
        } else {
            ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcc(this, googleApiClient, asset));
            AppMethodBeat.m2505o(71115);
            return enqueue;
        }
    }

    public final PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        AppMethodBeat.m2504i(71116);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcd(this, googleApiClient, dataItemAsset));
        AppMethodBeat.m2505o(71116);
        return enqueue;
    }

    public final PendingResult<DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        AppMethodBeat.m2504i(71108);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbx(this, googleApiClient, putDataRequest));
        AppMethodBeat.m2505o(71108);
        return enqueue;
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataListener dataListener) {
        AppMethodBeat.m2504i(71120);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcf(this, googleApiClient, dataListener));
        AppMethodBeat.m2505o(71120);
        return enqueue;
    }
}
