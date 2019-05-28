package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzas implements ConnectionCallbacks, OnConnectionFailedListener {
    private final /* synthetic */ zzaj zzhv;

    private zzas(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    /* synthetic */ zzas(zzaj zzaj, zzak zzak) {
        this(zzaj);
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.m2504i(60759);
        this.zzhv.zzhn.signIn(new zzaq(this.zzhv));
        AppMethodBeat.m2505o(60759);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(60760);
        this.zzhv.zzga.lock();
        try {
            if (zzaj.zzb(this.zzhv, connectionResult)) {
                zzaj.zzi(this.zzhv);
                zzaj.zzj(this.zzhv);
            } else {
                zzaj.zza(this.zzhv, connectionResult);
            }
            this.zzhv.zzga.unlock();
            AppMethodBeat.m2505o(60760);
        } catch (Throwable th) {
            this.zzhv.zzga.unlock();
            AppMethodBeat.m2505o(60760);
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
