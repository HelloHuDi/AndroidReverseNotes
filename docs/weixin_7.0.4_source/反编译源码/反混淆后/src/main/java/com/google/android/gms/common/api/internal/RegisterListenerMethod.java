package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends AnyClient, L> {
    private final ListenerHolder<L> zzls;

    @KeepForSdk
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this.zzls = listenerHolder;
    }

    @KeepForSdk
    public void clearListener() {
        this.zzls.clear();
    }

    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.zzls.getListenerKey();
    }

    @KeepForSdk
    public abstract void registerListener(A a, TaskCompletionSource<Void> taskCompletionSource);
}
