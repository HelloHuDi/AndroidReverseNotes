package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzyz extends zzzc {
    private final int zzbra;
    private final int zzbrb;

    zzyz(byte[] bArr, int i, int i2) {
        super(bArr);
        AppMethodBeat.i(3552);
        zzyw.zzb(i, i + i2, bArr.length);
        this.zzbra = i;
        this.zzbrb = i2;
        AppMethodBeat.o(3552);
    }

    public final int size() {
        return this.zzbrb;
    }

    public final byte zzae(int i) {
        AppMethodBeat.i(3553);
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            byte b = this.zzbrc[this.zzbra + i];
            AppMethodBeat.o(3553);
            return b;
        } else if (i < 0) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            AppMethodBeat.o(3553);
            throw arrayIndexOutOfBoundsException;
        } else {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + size);
            AppMethodBeat.o(3553);
            throw arrayIndexOutOfBoundsException2;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzsy() {
        return this.zzbra;
    }
}
