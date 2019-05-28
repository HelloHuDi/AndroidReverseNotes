package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

public abstract class zzze {
    private static volatile boolean zzbrg = false;
    int zzbrd;
    private int zzbre;
    private boolean zzbrf;

    private zzze() {
        this.zzbrd = 100;
        this.zzbre = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzbrf = false;
    }

    /* synthetic */ zzze(zzzf zzzf) {
        this();
    }

    static zzze zza(byte[] bArr, int i, int i2, boolean z) {
        zzzg zzzg = new zzzg(bArr, i, i2, false, null);
        try {
            zzzg.zzaf(i2);
            return zzzg;
        } catch (zzzt e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzsz();
}
