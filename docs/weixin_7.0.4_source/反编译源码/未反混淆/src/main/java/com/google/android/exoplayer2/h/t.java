package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class t<T> implements c {
    private final f aSF;
    public final i bib;
    private final a<? extends T> bqU;
    private volatile boolean bqV;
    public volatile long bqW;
    public volatile T result;
    public final int type = 4;

    public interface a<T> {
        T b(Uri uri, InputStream inputStream);
    }

    public t(f fVar, Uri uri, a<? extends T> aVar) {
        AppMethodBeat.i(95856);
        this.aSF = fVar;
        this.bib = new i(uri);
        this.bqU = aVar;
        AppMethodBeat.o(95856);
    }

    public final void se() {
        this.bqV = true;
    }

    public final boolean sf() {
        return this.bqV;
    }

    public final void sg() {
        AppMethodBeat.i(95857);
        h hVar = new h(this.aSF, this.bib);
        try {
            hVar.tn();
            this.result = this.bqU.b(this.aSF.getUri(), hVar);
        } finally {
            this.bqW = hVar.bpO;
            v.closeQuietly(hVar);
            AppMethodBeat.o(95857);
        }
    }
}
