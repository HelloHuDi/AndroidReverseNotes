package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.c.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements a {
    private final e awf;
    private final com.bumptech.glide.c.b.a.b awk;

    public b(e eVar, com.bumptech.glide.c.b.a.b bVar) {
        this.awf = eVar;
        this.awk = bVar;
    }

    public final Bitmap b(int i, int i2, Config config) {
        AppMethodBeat.i(92307);
        Bitmap h = this.awf.h(i, i2, config);
        AppMethodBeat.o(92307);
        return h;
    }

    public final void f(Bitmap bitmap) {
        AppMethodBeat.i(92308);
        this.awf.g(bitmap);
        AppMethodBeat.o(92308);
    }

    public final byte[] da(int i) {
        AppMethodBeat.i(92309);
        byte[] bArr;
        if (this.awk == null) {
            bArr = new byte[i];
            AppMethodBeat.o(92309);
            return bArr;
        }
        bArr = (byte[]) this.awk.a(i, byte[].class);
        AppMethodBeat.o(92309);
        return bArr;
    }

    public final void g(byte[] bArr) {
        AppMethodBeat.i(92310);
        if (this.awk == null) {
            AppMethodBeat.o(92310);
            return;
        }
        this.awk.put(bArr);
        AppMethodBeat.o(92310);
    }

    public final int[] db(int i) {
        AppMethodBeat.i(92311);
        int[] iArr;
        if (this.awk == null) {
            iArr = new int[i];
            AppMethodBeat.o(92311);
            return iArr;
        }
        iArr = (int[]) this.awk.a(i, int[].class);
        AppMethodBeat.o(92311);
        return iArr;
    }

    public final void k(int[] iArr) {
        AppMethodBeat.i(92312);
        if (this.awk == null) {
            AppMethodBeat.o(92312);
            return;
        }
        this.awk.put(iArr);
        AppMethodBeat.o(92312);
    }
}
