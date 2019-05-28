package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.p101c.p102d.C36681g;
import com.google.android.exoplayer2.p101c.p102d.C8647e;
import com.google.android.exoplayer2.p101c.p103e.C17639c;
import com.google.android.exoplayer2.p101c.p104f.C0849p;
import com.google.android.exoplayer2.p101c.p104f.C37238c;
import com.google.android.exoplayer2.p101c.p104f.C37243u;
import com.google.android.exoplayer2.p101c.p104f.C8656a;
import com.google.android.exoplayer2.p101c.p1160c.C45021b;
import com.google.android.exoplayer2.p101c.p1370g.C41598a;
import com.google.android.exoplayer2.p101c.p795a.C17631b;
import com.google.android.exoplayer2.p101c.p796b.C41594d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

/* renamed from: com.google.android.exoplayer2.c.c */
public final class C45022c implements C32039h {
    private static final Constructor<? extends C32034e> aSK;
    private int aSL;
    private int aSM;
    private int aSN;
    private int aSO;
    private int aSP = 1;
    private int aSQ;

    static {
        AppMethodBeat.m2504i(94858);
        Constructor constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(C32034e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
        }
        aSK = constructor;
        AppMethodBeat.m2505o(94858);
    }

    /* renamed from: ra */
    public final synchronized C32034e[] mo2572ra() {
        C32034e[] c32034eArr;
        int i = 11;
        synchronized (this) {
            AppMethodBeat.m2504i(94857);
            if (aSK != null) {
                i = 12;
            }
            c32034eArr = new C32034e[i];
            c32034eArr[0] = new C41594d(this.aSL);
            c32034eArr[1] = new C8647e(this.aSN);
            c32034eArr[2] = new C36681g(this.aSM);
            c32034eArr[3] = new C45021b(this.aSO);
            c32034eArr[4] = new C37238c();
            c32034eArr[5] = new C8656a();
            c32034eArr[6] = new C37243u(this.aSP, this.aSQ);
            c32034eArr[7] = new C17631b();
            c32034eArr[8] = new C17639c();
            c32034eArr[9] = new C0849p();
            c32034eArr[10] = new C41598a();
            if (aSK != null) {
                try {
                    c32034eArr[11] = (C32034e) aSK.newInstance(new Object[0]);
                } catch (Exception e) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unexpected error creating FLAC extractor", e);
                    AppMethodBeat.m2505o(94857);
                    throw illegalStateException;
                }
            }
            AppMethodBeat.m2505o(94857);
        }
        return c32034eArr;
    }
}
