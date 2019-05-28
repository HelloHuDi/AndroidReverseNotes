package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzat extends RegisterListenerMethod<zzhg, ChannelCallback> {
    private final IntentFilter[] zzba;
    @Nullable
    private final String zzce;
    private final ChannelListener zzcf;
    private final ListenerHolder<ChannelListener> zzci;

    zzat(ChannelListener channelListener, @Nullable String str, IntentFilter[] intentFilterArr, ListenerHolder<ChannelCallback> listenerHolder, ListenerHolder<ChannelListener> listenerHolder2) {
        super(listenerHolder);
        this.zzcf = channelListener;
        this.zzba = intentFilterArr;
        this.zzce = str;
        this.zzci = listenerHolder2;
    }

    public final /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(71036);
        ((zzhg) anyClient).zza(new zzgh(taskCompletionSource), this.zzcf, this.zzci, this.zzce, this.zzba);
        AppMethodBeat.o(71036);
    }
}
