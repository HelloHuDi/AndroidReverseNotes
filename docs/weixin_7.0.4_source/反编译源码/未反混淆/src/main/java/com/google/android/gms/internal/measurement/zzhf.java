package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ String zzanm;
    private final /* synthetic */ String zzann;
    private final /* synthetic */ long zzano;

    zzhf(zzgn zzgn, String str, String str2, String str3, long j) {
        this.zzanf = zzgn;
        this.zzanm = str;
        this.zzanj = str2;
        this.zzann = str3;
        this.zzano = j;
    }

    public final void run() {
        AppMethodBeat.i(69127);
        if (this.zzanm == null) {
            this.zzanf.zzajp.zzla().zzfy().zza(this.zzanj, null);
            AppMethodBeat.o(69127);
            return;
        }
        this.zzanf.zzajp.zzla().zzfy().zza(this.zzanj, new zzie(this.zzann, this.zzanm, this.zzano));
        AppMethodBeat.o(69127);
    }
}
