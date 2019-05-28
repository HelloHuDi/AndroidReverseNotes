package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgt implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;

    zzgt(zzgn zzgn, zzdz zzdz, String str, String str2) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
        this.zzanh = str;
        this.zzani = str2;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(69115);
        this.zzanf.zzajp.zzkx();
        List zzb = this.zzanf.zzajp.zzix().zzb(this.zzane.packageName, this.zzanh, this.zzani);
        AppMethodBeat.o(69115);
        return zzb;
    }
}
