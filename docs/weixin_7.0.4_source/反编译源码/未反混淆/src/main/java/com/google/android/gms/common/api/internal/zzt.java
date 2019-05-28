package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzt implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzt(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzt(zzr zzr, zzs zzs) {
        this(zzr);
    }

    public final void zzb(int i, boolean z) {
        AppMethodBeat.i(60976);
        this.zzgc.zzga.lock();
        try {
            if (this.zzgc.zzfz || this.zzgc.zzfy == null || !this.zzgc.zzfy.isSuccess()) {
                this.zzgc.zzfz = false;
                zzr.zza(this.zzgc, i, z);
                return;
            }
            this.zzgc.zzfz = true;
            this.zzgc.zzfs.onConnectionSuspended(i);
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60976);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60976);
        }
    }

    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(60974);
        this.zzgc.zzga.lock();
        try {
            zzr.zza(this.zzgc, bundle);
            this.zzgc.zzfx = ConnectionResult.RESULT_SUCCESS;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60974);
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.i(60975);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfx = connectionResult;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(60975);
        }
    }
}
