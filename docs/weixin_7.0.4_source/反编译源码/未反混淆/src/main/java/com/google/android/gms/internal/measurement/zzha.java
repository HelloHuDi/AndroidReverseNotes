package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class zzha implements Callable<byte[]> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzeu zzank;

    zzha(zzgn zzgn, zzeu zzeu, String str) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzanj = str;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(69122);
        this.zzanf.zzajp.zzkx();
        byte[] zza = this.zzanf.zzajp.zza(this.zzank, this.zzanj);
        AppMethodBeat.o(69122);
        return zza;
    }
}
