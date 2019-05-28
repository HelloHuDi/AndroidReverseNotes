package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzax implements ConnectionCallbacks {
    private final /* synthetic */ zzav zzit;
    private final /* synthetic */ AtomicReference zziu;
    private final /* synthetic */ StatusPendingResult zziv;

    zzax(zzav zzav, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zzit = zzav;
        this.zziu = atomicReference;
        this.zziv = statusPendingResult;
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.m2504i(60810);
        zzav.zza(this.zzit, (GoogleApiClient) this.zziu.get(), this.zziv, true);
        AppMethodBeat.m2505o(60810);
    }

    public final void onConnectionSuspended(int i) {
    }
}
