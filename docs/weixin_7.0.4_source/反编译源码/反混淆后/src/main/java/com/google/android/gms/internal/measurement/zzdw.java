package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdw implements Runnable {
    private final /* synthetic */ String zzadi;
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzdu zzadk;

    zzdw(zzdu zzdu, String str, long j) {
        this.zzadk = zzdu;
        this.zzadi = str;
        this.zzadj = j;
    }

    public final void run() {
        AppMethodBeat.m2504i(68523);
        zzdu.zzb(this.zzadk, this.zzadi, this.zzadj);
        AppMethodBeat.m2505o(68523);
    }
}
