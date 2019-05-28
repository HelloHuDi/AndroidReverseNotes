package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg implements BaseOnConnectionFailedListener {
    private final /* synthetic */ OnConnectionFailedListener zzte;

    zzg(OnConnectionFailedListener onConnectionFailedListener) {
        this.zzte = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(61406);
        this.zzte.onConnectionFailed(connectionResult);
        AppMethodBeat.m2505o(61406);
    }
}
