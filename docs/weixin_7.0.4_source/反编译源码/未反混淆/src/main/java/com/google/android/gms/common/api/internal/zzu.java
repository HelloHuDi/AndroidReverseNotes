package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzu implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzu(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzu(zzr zzr, zzs zzs) {
        this(zzr);
    }

    public final void zzb(int i, boolean z) {
        AppMethodBeat.i(60979);
        this.zzgc.zzga.lock();
        try {
            if (this.zzgc.zzfz) {
                this.zzgc.zzfz = false;
                zzr.zza(this.zzgc, i, z);
                return;
            }
            this.zzgc.zzfz = true;
            this.zzgc.zzfr.onConnectionSuspended(i);
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60979);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60979);
        }
    }

    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(60977);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfy = ConnectionResult.RESULT_SUCCESS;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60977);
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.i(60978);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfy = connectionResult;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60978);
        }
    }
}
