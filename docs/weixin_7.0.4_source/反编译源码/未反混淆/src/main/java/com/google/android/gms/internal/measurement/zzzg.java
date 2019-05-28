package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzg extends zzze {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbrh;
    private int zzbri;
    private int zzbrj;
    private int zzbrk;

    private zzzg(byte[] bArr, int i, int i2, boolean z) {
        super();
        AppMethodBeat.i(3558);
        this.zzbrk = BaseClientBuilder.API_PRIORITY_OTHER;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzbrj = this.pos;
        this.zzbrh = z;
        AppMethodBeat.o(3558);
    }

    /* synthetic */ zzzg(byte[] bArr, int i, int i2, boolean z, zzzf zzzf) {
        this(bArr, i, i2, false);
    }

    private final void zzta() {
        this.limit += this.zzbri;
        int i = this.limit - this.zzbrj;
        if (i > this.zzbrk) {
            this.zzbri = i - this.zzbrk;
            this.limit -= this.zzbri;
            return;
        }
        this.zzbri = 0;
    }

    public final int zzaf(int i) {
        AppMethodBeat.i(3559);
        zzzt zztn;
        if (i < 0) {
            zztn = zzzt.zztn();
            AppMethodBeat.o(3559);
            throw zztn;
        }
        int zzsz = zzsz() + i;
        int i2 = this.zzbrk;
        if (zzsz > i2) {
            zztn = zzzt.zztm();
            AppMethodBeat.o(3559);
            throw zztn;
        }
        this.zzbrk = zzsz;
        zzta();
        AppMethodBeat.o(3559);
        return i2;
    }

    public final int zzsz() {
        return this.pos - this.zzbrj;
    }
}
