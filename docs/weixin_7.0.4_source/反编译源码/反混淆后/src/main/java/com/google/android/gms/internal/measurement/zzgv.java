package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgv implements Callable<List<zzed>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;

    zzgv(zzgn zzgn, zzdz zzdz, String str, String str2) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
        this.zzanh = str;
        this.zzani = str2;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(69117);
        this.zzanf.zzajp.zzkx();
        List zzc = this.zzanf.zzajp.zzix().zzc(this.zzane.packageName, this.zzanh, this.zzani);
        AppMethodBeat.m2505o(69117);
        return zzc;
    }
}
