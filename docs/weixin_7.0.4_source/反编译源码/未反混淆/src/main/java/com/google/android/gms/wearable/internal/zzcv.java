package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcv extends RegisterListenerMethod<zzhg, OnDataChangedListener> {
    private final IntentFilter[] zzba;
    private final ListenerHolder<DataListener> zzbz;
    private final OnDataChangedListener zzdk;

    private zzcv(OnDataChangedListener onDataChangedListener, IntentFilter[] intentFilterArr, ListenerHolder<OnDataChangedListener> listenerHolder) {
        super(listenerHolder);
        this.zzdk = onDataChangedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    public final /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(71173);
        ((zzhg) anyClient).zza(new zzgh(taskCompletionSource), this.zzdk, this.zzbz, this.zzba);
        AppMethodBeat.o(71173);
    }
}
