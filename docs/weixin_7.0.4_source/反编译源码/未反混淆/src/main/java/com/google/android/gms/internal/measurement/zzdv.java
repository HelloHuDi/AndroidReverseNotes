package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdv implements Runnable {
    private final /* synthetic */ String zzadi;
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzdu zzadk;

    zzdv(zzdu zzdu, String str, long j) {
        this.zzadk = zzdu;
        this.zzadi = str;
        this.zzadj = j;
    }

    public final void run() {
        AppMethodBeat.i(68522);
        zzdu.zza(this.zzadk, this.zzadi, this.zzadj);
        AppMethodBeat.o(68522);
    }
}
