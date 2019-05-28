package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgu implements Callable<List<zzjz>> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;

    zzgu(zzgn zzgn, String str, String str2, String str3) {
        this.zzanf = zzgn;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(69116);
        this.zzanf.zzajp.zzkx();
        List zzb = this.zzanf.zzajp.zzix().zzb(this.zzanj, this.zzanh, this.zzani);
        AppMethodBeat.o(69116);
        return zzb;
    }
}
