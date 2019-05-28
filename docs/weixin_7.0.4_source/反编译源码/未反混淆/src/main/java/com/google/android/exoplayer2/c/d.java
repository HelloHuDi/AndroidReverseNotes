package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class d implements m {
    public final void f(Format format) {
    }

    public final int a(f fVar, int i, boolean z) {
        AppMethodBeat.i(94859);
        int dF = fVar.dF(i);
        if (dF != -1) {
            AppMethodBeat.o(94859);
            return dF;
        } else if (z) {
            AppMethodBeat.o(94859);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(94859);
            throw eOFException;
        }
    }

    public final void a(l lVar, int i) {
        AppMethodBeat.i(94860);
        lVar.eM(i);
        AppMethodBeat.o(94860);
    }

    public final void a(long j, int i, int i2, int i3, a aVar) {
    }
}
