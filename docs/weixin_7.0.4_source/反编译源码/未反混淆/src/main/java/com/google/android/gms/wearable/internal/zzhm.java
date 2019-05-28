package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhm implements Notifier<MessageListener> {
    private final /* synthetic */ zzfe zzap;

    zzhm(zzfe zzfe) {
        this.zzap = zzfe;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        AppMethodBeat.i(71432);
        ((MessageListener) obj).onMessageReceived(this.zzap);
        AppMethodBeat.o(71432);
    }

    public final void onNotifyListenerFailed() {
    }
}
