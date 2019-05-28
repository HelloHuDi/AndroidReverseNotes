package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.c.b.d;
import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.c.d.e;
import com.google.android.exoplayer2.c.d.g;
import com.google.android.exoplayer2.c.f.a;
import com.google.android.exoplayer2.c.f.p;
import com.google.android.exoplayer2.c.f.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class c implements h {
    private static final Constructor<? extends e> aSK;
    private int aSL;
    private int aSM;
    private int aSN;
    private int aSO;
    private int aSP = 1;
    private int aSQ;

    static {
        AppMethodBeat.i(94858);
        Constructor constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
        }
        aSK = constructor;
        AppMethodBeat.o(94858);
    }

    public final synchronized e[] ra() {
        e[] eVarArr;
        int i = 11;
        synchronized (this) {
            AppMethodBeat.i(94857);
            if (aSK != null) {
                i = 12;
            }
            eVarArr = new e[i];
            eVarArr[0] = new d(this.aSL);
            eVarArr[1] = new e(this.aSN);
            eVarArr[2] = new g(this.aSM);
            eVarArr[3] = new b(this.aSO);
            eVarArr[4] = new com.google.android.exoplayer2.c.f.c();
            eVarArr[5] = new a();
            eVarArr[6] = new u(this.aSP, this.aSQ);
            eVarArr[7] = new com.google.android.exoplayer2.c.a.b();
            eVarArr[8] = new com.google.android.exoplayer2.c.e.c();
            eVarArr[9] = new p();
            eVarArr[10] = new com.google.android.exoplayer2.c.g.a();
            if (aSK != null) {
                try {
                    eVarArr[11] = (e) aSK.newInstance(new Object[0]);
                } catch (Exception e) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unexpected error creating FLAC extractor", e);
                    AppMethodBeat.o(94857);
                    throw illegalStateException;
                }
            }
            AppMethodBeat.o(94857);
        }
        return eVarArr;
    }
}
