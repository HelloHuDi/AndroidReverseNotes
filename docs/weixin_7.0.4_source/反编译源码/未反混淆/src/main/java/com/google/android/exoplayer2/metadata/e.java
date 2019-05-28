package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.a implements Callback {
    private boolean beE;
    private final c beY;
    private final a beZ;
    private final k bef;
    private final Handler bfa;
    private final d bfb;
    private final Metadata[] bfc;
    private final long[] bfd;
    private int bfe;
    private int bff;
    private a bfg;

    public interface a {
        void b(Metadata metadata);
    }

    public e(a aVar, Looper looper) {
        this(aVar, looper, c.beX);
    }

    private e(a aVar, Looper looper, c cVar) {
        super(4);
        AppMethodBeat.i(95349);
        this.beZ = (a) com.google.android.exoplayer2.i.a.checkNotNull(aVar);
        this.bfa = looper == null ? null : new Handler(looper, this);
        this.beY = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.bef = new k();
        this.bfb = new d();
        this.bfc = new Metadata[5];
        this.bfd = new long[5];
        AppMethodBeat.o(95349);
    }

    public final int b(Format format) {
        AppMethodBeat.i(95350);
        if (this.beY.g(format)) {
            AppMethodBeat.o(95350);
            return 4;
        }
        AppMethodBeat.o(95350);
        return 0;
    }

    public final void a(Format[] formatArr, long j) {
        AppMethodBeat.i(95351);
        this.bfg = this.beY.h(formatArr[0]);
        AppMethodBeat.o(95351);
    }

    public final void b(long j, boolean z) {
        AppMethodBeat.i(95352);
        rN();
        this.beE = false;
        AppMethodBeat.o(95352);
    }

    public final void f(long j, long j2) {
        AppMethodBeat.i(95353);
        if (!this.beE && this.bff < 5) {
            this.bfb.clear();
            if (a(this.bef, (com.google.android.exoplayer2.b.e) this.bfb, false) == -4) {
                if (this.bfb.qG()) {
                    this.beE = true;
                } else if (!this.bfb.qF()) {
                    this.bfb.aOr = this.bef.aOv.aOr;
                    this.bfb.qL();
                    try {
                        int i = (this.bfe + this.bff) % 5;
                        this.bfc[i] = this.bfg.a(this.bfb);
                        this.bfd[i] = this.bfb.aSk;
                        this.bff++;
                    } catch (b e) {
                        com.google.android.exoplayer2.e b = com.google.android.exoplayer2.e.b(e, this.index);
                        AppMethodBeat.o(95353);
                        throw b;
                    }
                }
            }
        }
        if (this.bff > 0 && this.bfd[this.bfe] <= j) {
            Object obj = this.bfc[this.bfe];
            if (this.bfa != null) {
                this.bfa.obtainMessage(0, obj).sendToTarget();
            } else {
                d(obj);
            }
            this.bfc[this.bfe] = null;
            this.bfe = (this.bfe + 1) % 5;
            this.bff--;
        }
        AppMethodBeat.o(95353);
    }

    public final void pK() {
        AppMethodBeat.i(95354);
        rN();
        this.bfg = null;
        AppMethodBeat.o(95354);
    }

    public final boolean qf() {
        return this.beE;
    }

    public final boolean isReady() {
        return true;
    }

    private void rN() {
        AppMethodBeat.i(95355);
        Arrays.fill(this.bfc, null);
        this.bfe = 0;
        this.bff = 0;
        AppMethodBeat.o(95355);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(95356);
        switch (message.what) {
            case 0:
                d((Metadata) message.obj);
                AppMethodBeat.o(95356);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95356);
                throw illegalStateException;
        }
    }

    private void d(Metadata metadata) {
        AppMethodBeat.i(95357);
        this.beZ.b(metadata);
        AppMethodBeat.o(95357);
    }
}
