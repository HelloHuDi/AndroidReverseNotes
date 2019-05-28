package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzxc {
    private final String zzbnr;
    private final Uri zzbns;
    private final String zzbnt;
    private final String zzbnu;
    private final boolean zzbnv;
    private final boolean zzbnw;

    public zzxc(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private zzxc(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.zzbnr = null;
        this.zzbns = uri;
        this.zzbnt = str2;
        this.zzbnu = str3;
        this.zzbnv = false;
        this.zzbnw = false;
    }

    public final zzws<Double> zzb(String str, double d) {
        AppMethodBeat.i(69774);
        zzws zzb = zzws.zza(this, str, d);
        AppMethodBeat.o(69774);
        return zzb;
    }

    public final zzws<Integer> zzd(String str, int i) {
        AppMethodBeat.i(69773);
        zzws zzb = zzws.zza(this, str, i);
        AppMethodBeat.o(69773);
        return zzb;
    }

    public final zzws<Long> zze(String str, long j) {
        AppMethodBeat.i(69771);
        zzws zzb = zzws.zza(this, str, j);
        AppMethodBeat.o(69771);
        return zzb;
    }

    public final zzws<Boolean> zzf(String str, boolean z) {
        AppMethodBeat.i(69772);
        zzws zzb = zzws.zza(this, str, z);
        AppMethodBeat.o(69772);
        return zzb;
    }

    public final zzws<String> zzv(String str, String str2) {
        AppMethodBeat.i(69775);
        zzws zzb = zzws.zza(this, str, str2);
        AppMethodBeat.o(69775);
        return zzb;
    }
}
