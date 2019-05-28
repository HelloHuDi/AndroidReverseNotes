package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzic implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzany;
    private final /* synthetic */ Bundle zzaoe;
    private final /* synthetic */ boolean zzaof;
    private final /* synthetic */ boolean zzaog;
    private final /* synthetic */ boolean zzaoh;

    zzic(zzhk zzhk, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.zzanw = zzhk;
        this.zzanh = str;
        this.val$name = str2;
        this.zzany = j;
        this.zzaoe = bundle;
        this.zzaof = z;
        this.zzaog = z2;
        this.zzaoh = z3;
        this.zzanj = str3;
    }

    public final void run() {
        AppMethodBeat.m2504i(69234);
        zzhk.zza(this.zzanw, this.zzanh, this.val$name, this.zzany, this.zzaoe, this.zzaof, this.zzaog, this.zzaoh, this.zzanj);
        AppMethodBeat.m2505o(69234);
    }
}
