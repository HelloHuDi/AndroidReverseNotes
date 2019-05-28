package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzau extends UnregisterListenerMethod<zzhg, ChannelCallback> {
    @Nullable
    private final String zzce;
    private final ChannelListener zzcf;

    zzau(ChannelListener channelListener, @Nullable String str, ListenerKey<ChannelCallback> listenerKey) {
        super(listenerKey);
        this.zzcf = channelListener;
        this.zzce = str;
    }

    public final /* synthetic */ void unregisterListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(71037);
        ((zzhg) anyClient).zza(new zzgg(taskCompletionSource), this.zzcf, this.zzce);
        AppMethodBeat.o(71037);
    }
}
