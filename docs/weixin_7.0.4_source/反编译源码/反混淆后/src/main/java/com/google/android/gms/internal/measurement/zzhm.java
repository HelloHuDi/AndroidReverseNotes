package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhm implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ Object zzanx;
    private final /* synthetic */ long zzany;

    zzhm(zzhk zzhk, String str, String str2, Object obj, long j) {
        this.zzanw = zzhk;
        this.zzanh = str;
        this.val$name = str2;
        this.zzanx = obj;
        this.zzany = j;
    }

    public final void run() {
        AppMethodBeat.m2504i(69218);
        zzhk.zza(this.zzanw, this.zzanh, this.val$name, this.zzanx, this.zzany);
        AppMethodBeat.m2505o(69218);
    }
}
