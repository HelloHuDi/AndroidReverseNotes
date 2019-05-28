package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m.C8663a;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.d */
public final class C36683d implements C32041m {
    /* renamed from: f */
    public final void mo42836f(Format format) {
    }

    /* renamed from: a */
    public final int mo42832a(C45026f c45026f, int i, boolean z) {
        AppMethodBeat.m2504i(94859);
        int dF = c45026f.mo59481dF(i);
        if (dF != -1) {
            AppMethodBeat.m2505o(94859);
            return dF;
        } else if (z) {
            AppMethodBeat.m2505o(94859);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.m2505o(94859);
            throw eOFException;
        }
    }

    /* renamed from: a */
    public final void mo42835a(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(94860);
        c32065l.mo52369eM(i);
        AppMethodBeat.m2505o(94860);
    }

    /* renamed from: a */
    public final void mo42834a(long j, int i, int i2, int i3, C8663a c8663a) {
    }
}
