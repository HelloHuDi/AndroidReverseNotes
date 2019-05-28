package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzal implements ConnectionProgressReportCallbacks {
    private final Api<?> mApi;
    private final boolean zzfo;
    private final WeakReference<zzaj> zzhw;

    public zzal(zzaj zzaj, Api<?> api, boolean z) {
        AppMethodBeat.i(60750);
        this.zzhw = new WeakReference(zzaj);
        this.mApi = api;
        this.zzfo = z;
        AppMethodBeat.o(60750);
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean z = false;
        AppMethodBeat.i(60751);
        zzaj zzaj = (zzaj) this.zzhw.get();
        if (zzaj == null) {
            AppMethodBeat.o(60751);
            return;
        }
        if (Looper.myLooper() == zzaj.zzhf.zzfq.getLooper()) {
            z = true;
        }
        Preconditions.checkState(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zzaj.zzga.lock();
        try {
            if (zzaj.zza(zzaj, 0)) {
                if (!connectionResult.isSuccess()) {
                    zzaj.zza(zzaj, connectionResult, this.mApi, this.zzfo);
                }
                if (zzaj.zzk(zzaj)) {
                    zzaj.zzj(zzaj);
                }
                zzaj.zzga.unlock();
                AppMethodBeat.o(60751);
            }
        } finally {
            zzaj.zzga.unlock();
            AppMethodBeat.o(60751);
        }
    }
}
