package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcj extends DataClient {
    private final DataApi zzdi = new zzbw();

    public zzcj(Activity activity, Settings settings) {
        super(activity, settings);
        AppMethodBeat.m2504i(71141);
        AppMethodBeat.m2505o(71141);
    }

    public zzcj(Context context, Settings settings) {
        super(context, settings);
        AppMethodBeat.m2504i(71140);
        AppMethodBeat.m2505o(71140);
    }

    private final Task<Void> zza(OnDataChangedListener onDataChangedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.m2504i(71153);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener");
        Task doRegisterEventListener = doRegisterEventListener(new zzcv(onDataChangedListener, intentFilterArr, createListenerHolder), new zzcw(onDataChangedListener, createListenerHolder.getListenerKey(), null));
        AppMethodBeat.m2505o(71153);
        return doRegisterEventListener;
    }

    public final Task<Void> addListener(OnDataChangedListener onDataChangedListener) {
        AppMethodBeat.m2504i(71151);
        Task zza = zza(onDataChangedListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED")});
        AppMethodBeat.m2505o(71151);
        return zza;
    }

    public final Task<Void> addListener(OnDataChangedListener onDataChangedListener, Uri uri, int i) {
        AppMethodBeat.m2504i(71152);
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        Task zza = zza(onDataChangedListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", uri, i)});
        AppMethodBeat.m2505o(71152);
        return zza;
    }

    public final Task<Integer> deleteDataItems(Uri uri) {
        AppMethodBeat.m2504i(71147);
        Task toTask = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), uri), zzcp.zzbx);
        AppMethodBeat.m2505o(71147);
        return toTask;
    }

    public final Task<Integer> deleteDataItems(Uri uri, int i) {
        AppMethodBeat.m2504i(71148);
        Task toTask = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), uri, i), zzcq.zzbx);
        AppMethodBeat.m2505o(71148);
        return toTask;
    }

    public final Task<DataItem> getDataItem(Uri uri) {
        AppMethodBeat.m2504i(71143);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getDataItem(asGoogleApiClient(), uri), zzcl.zzbx);
        AppMethodBeat.m2505o(71143);
        return toTask;
    }

    public final Task<DataItemBuffer> getDataItems() {
        AppMethodBeat.m2504i(71144);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient()), zzcm.zzbx);
        AppMethodBeat.m2505o(71144);
        return toTask;
    }

    public final Task<DataItemBuffer> getDataItems(Uri uri) {
        AppMethodBeat.m2504i(71145);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), uri), zzcn.zzbx);
        AppMethodBeat.m2505o(71145);
        return toTask;
    }

    public final Task<DataItemBuffer> getDataItems(Uri uri, int i) {
        AppMethodBeat.m2504i(71146);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), uri, i), zzco.zzbx);
        AppMethodBeat.m2505o(71146);
        return toTask;
    }

    public final Task<GetFdForAssetResponse> getFdForAsset(Asset asset) {
        AppMethodBeat.m2504i(71149);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), asset), zzcr.zzbx);
        AppMethodBeat.m2505o(71149);
        return toTask;
    }

    public final Task<GetFdForAssetResponse> getFdForAsset(DataItemAsset dataItemAsset) {
        AppMethodBeat.m2504i(71150);
        Task toTask = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), dataItemAsset), zzcs.zzbx);
        AppMethodBeat.m2505o(71150);
        return toTask;
    }

    public final Task<DataItem> putDataItem(PutDataRequest putDataRequest) {
        AppMethodBeat.m2504i(71142);
        Task toTask = PendingResultUtil.toTask(this.zzdi.putDataItem(asGoogleApiClient(), putDataRequest), zzck.zzbx);
        AppMethodBeat.m2505o(71142);
        return toTask;
    }

    public final Task<Boolean> removeListener(OnDataChangedListener onDataChangedListener) {
        AppMethodBeat.m2504i(71154);
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener").getListenerKey());
        AppMethodBeat.m2505o(71154);
        return doUnregisterEventListener;
    }
}
