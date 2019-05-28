package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhn implements Notifier<ChannelListener> {
    private final /* synthetic */ zzaw zzav;

    zzhn(zzaw zzaw) {
        this.zzav = zzaw;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        AppMethodBeat.m2504i(71433);
        this.zzav.zza((ChannelListener) obj);
        AppMethodBeat.m2505o(71433);
    }

    public final void onNotifyListenerFailed() {
    }
}
