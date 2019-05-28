package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdx implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzdu zzadk;

    zzdx(zzdu zzdu, long j) {
        this.zzadk = zzdu;
        this.zzadj = j;
    }

    public final void run() {
        AppMethodBeat.i(68524);
        zzdu.zza(this.zzadk, this.zzadj);
        AppMethodBeat.o(68524);
    }
}
