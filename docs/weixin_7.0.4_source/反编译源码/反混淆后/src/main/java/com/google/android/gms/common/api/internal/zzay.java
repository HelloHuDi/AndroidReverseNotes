package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzay implements OnConnectionFailedListener {
    private final /* synthetic */ StatusPendingResult zziv;

    zzay(zzav zzav, StatusPendingResult statusPendingResult) {
        this.zziv = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(60811);
        this.zziv.setResult(new Status(8));
        AppMethodBeat.m2505o(60811);
    }
}
