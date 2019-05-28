package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzho implements Notifier<CapabilityListener> {
    private final /* synthetic */ zzah zzfr;

    zzho(zzah zzah) {
        this.zzfr = zzah;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        AppMethodBeat.m2504i(71434);
        ((CapabilityListener) obj).onCapabilityChanged(this.zzfr);
        AppMethodBeat.m2505o(71434);
    }

    public final void onNotifyListenerFailed() {
    }
}
