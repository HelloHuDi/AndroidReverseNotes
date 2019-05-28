package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzhd implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzhd(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(69125);
        this.zzanf.zzajp.zzkx();
        List zzbb = this.zzanf.zzajp.zzix().zzbb(this.zzane.packageName);
        AppMethodBeat.m2505o(69125);
        return zzbb;
    }
}
