package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgw implements Callable<List<zzed>> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;

    zzgw(zzgn zzgn, String str, String str2, String str3) {
        this.zzanf = zzgn;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(69118);
        this.zzanf.zzajp.zzkx();
        List zzc = this.zzanf.zzajp.zzix().zzc(this.zzanj, this.zzanh, this.zzani);
        AppMethodBeat.m2505o(69118);
        return zzc;
    }
}
