package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaf extends RegisterListenerMethod<zzhg, OnCapabilityChangedListener> {
    private final IntentFilter[] zzba;
    private final OnCapabilityChangedListener zzby;
    private final ListenerHolder<CapabilityListener> zzbz;

    private zzaf(OnCapabilityChangedListener onCapabilityChangedListener, IntentFilter[] intentFilterArr, ListenerHolder<OnCapabilityChangedListener> listenerHolder) {
        super(listenerHolder);
        this.zzby = onCapabilityChangedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    /* synthetic */ zzaf(OnCapabilityChangedListener onCapabilityChangedListener, IntentFilter[] intentFilterArr, ListenerHolder listenerHolder, zzad zzad) {
        this(onCapabilityChangedListener, intentFilterArr, listenerHolder);
    }

    public final /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(70987);
        ((zzhg) anyClient).zza(new zzgh(taskCompletionSource), this.zzby, this.zzbz, this.zzba);
        AppMethodBeat.o(70987);
    }
}
