package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzag extends UnregisterListenerMethod<zzhg, OnCapabilityChangedListener> {
    private final OnCapabilityChangedListener zzby;

    private zzag(OnCapabilityChangedListener onCapabilityChangedListener, ListenerKey<OnCapabilityChangedListener> listenerKey) {
        super(listenerKey);
        this.zzby = onCapabilityChangedListener;
    }

    /* synthetic */ zzag(OnCapabilityChangedListener onCapabilityChangedListener, ListenerKey listenerKey, zzad zzad) {
        this(onCapabilityChangedListener, listenerKey);
    }

    public final /* synthetic */ void unregisterListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.m2504i(70988);
        ((zzhg) anyClient).zza(new zzgg(taskCompletionSource), this.zzby);
        AppMethodBeat.m2505o(70988);
    }
}
