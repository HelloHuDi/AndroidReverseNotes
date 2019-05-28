package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf implements BaseConnectionCallbacks {
    private final /* synthetic */ ConnectionCallbacks zztd;

    zzf(ConnectionCallbacks connectionCallbacks) {
        this.zztd = connectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(61404);
        this.zztd.onConnected(bundle);
        AppMethodBeat.o(61404);
    }

    public final void onConnectionSuspended(int i) {
        AppMethodBeat.i(61405);
        this.zztd.onConnectionSuspended(i);
        AppMethodBeat.o(61405);
    }
}
