package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzx implements Runnable {
    private final zzt zzch;
    private final zzz zzci;

    zzx(zzt zzt, zzz zzz) {
        this.zzch = zzt;
        this.zzci = zzz;
    }

    public final void run() {
        AppMethodBeat.i(57616);
        this.zzch.zzg(this.zzci.zzck);
        AppMethodBeat.o(57616);
    }
}
