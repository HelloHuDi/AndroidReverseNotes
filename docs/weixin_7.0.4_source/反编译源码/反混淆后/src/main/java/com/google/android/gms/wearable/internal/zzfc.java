package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfc extends RegisterListenerMethod<zzhg, OnMessageReceivedListener> {
    private final IntentFilter[] zzba;
    private final ListenerHolder<MessageListener> zzbz;
    private final OnMessageReceivedListener zzej;

    private zzfc(OnMessageReceivedListener onMessageReceivedListener, IntentFilter[] intentFilterArr, ListenerHolder<OnMessageReceivedListener> listenerHolder) {
        super(listenerHolder);
        this.zzej = onMessageReceivedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    public final /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.m2504i(71308);
        ((zzhg) anyClient).zza(new zzgh(taskCompletionSource), this.zzej, this.zzbz, this.zzba);
        AppMethodBeat.m2505o(71308);
    }
}
