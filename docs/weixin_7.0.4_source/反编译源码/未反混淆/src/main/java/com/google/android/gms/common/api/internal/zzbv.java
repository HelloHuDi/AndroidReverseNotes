package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;

public final class zzbv {
    public final RegisterListenerMethod<AnyClient, ?> zzlt;
    public final UnregisterListenerMethod<AnyClient, ?> zzlu;

    public zzbv(RegisterListenerMethod<AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<AnyClient, ?> unregisterListenerMethod) {
        this.zzlt = registerListenerMethod;
        this.zzlu = unregisterListenerMethod;
    }
}
