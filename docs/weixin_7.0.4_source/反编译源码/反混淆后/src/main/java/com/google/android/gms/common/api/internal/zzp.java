package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> mApi;
    private final boolean zzfo;
    private zzq zzfp;

    public zzp(Api<?> api, boolean z) {
        this.mApi = api;
        this.zzfo = z;
    }

    private final void zzy() {
        AppMethodBeat.m2504i(60945);
        Preconditions.checkNotNull(this.zzfp, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        AppMethodBeat.m2505o(60945);
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.m2504i(60942);
        zzy();
        this.zzfp.onConnected(bundle);
        AppMethodBeat.m2505o(60942);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(60944);
        zzy();
        this.zzfp.zza(connectionResult, this.mApi, this.zzfo);
        AppMethodBeat.m2505o(60944);
    }

    public final void onConnectionSuspended(int i) {
        AppMethodBeat.m2504i(60943);
        zzy();
        this.zzfp.onConnectionSuspended(i);
        AppMethodBeat.m2505o(60943);
    }

    public final void zza(zzq zzq) {
        this.zzfp = zzq;
    }
}
