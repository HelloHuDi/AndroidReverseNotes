package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfd extends UnregisterListenerMethod<zzhg, OnMessageReceivedListener> {
    private final OnMessageReceivedListener zzej;

    private zzfd(OnMessageReceivedListener onMessageReceivedListener, ListenerKey<OnMessageReceivedListener> listenerKey) {
        super(listenerKey);
        this.zzej = onMessageReceivedListener;
    }

    public final /* synthetic */ void unregisterListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(71309);
        ((zzhg) anyClient).zza(new zzgg(taskCompletionSource), this.zzej);
        AppMethodBeat.o(71309);
    }
}
