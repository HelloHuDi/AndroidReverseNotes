package com.google.android.exoplayer2.p110h;

import android.net.Uri;
import com.google.android.exoplayer2.p110h.C41613s.C32059c;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.google.android.exoplayer2.h.t */
public final class C41614t<T> implements C32059c {
    private final C0867f aSF;
    public final C17665i bib;
    private final C37263a<? extends T> bqU;
    private volatile boolean bqV;
    public volatile long bqW;
    public volatile T result;
    public final int type = 4;

    /* renamed from: com.google.android.exoplayer2.h.t$a */
    public interface C37263a<T> {
        /* renamed from: b */
        T mo59506b(Uri uri, InputStream inputStream);
    }

    public C41614t(C0867f c0867f, Uri uri, C37263a<? extends T> c37263a) {
        AppMethodBeat.m2504i(95856);
        this.aSF = c0867f;
        this.bib = new C17665i(uri);
        this.bqU = c37263a;
        AppMethodBeat.m2505o(95856);
    }

    /* renamed from: se */
    public final void mo19287se() {
        this.bqV = true;
    }

    /* renamed from: sf */
    public final boolean mo19288sf() {
        return this.bqV;
    }

    /* renamed from: sg */
    public final void mo19289sg() {
        AppMethodBeat.m2504i(95857);
        C25540h c25540h = new C25540h(this.aSF, this.bib);
        try {
            c25540h.mo42798tn();
            this.result = this.bqU.mo59506b(this.aSF.getUri(), c25540h);
        } finally {
            this.bqW = c25540h.bpO;
            C17675v.closeQuietly(c25540h);
            AppMethodBeat.m2505o(95857);
        }
    }
}
