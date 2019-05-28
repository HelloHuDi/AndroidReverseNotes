package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class j extends com.google.android.exoplayer2.a implements Callback {
    private boolean beE;
    private boolean beF;
    private final k bef;
    private final Handler bfa;
    private final a blf;
    private final g blg;
    private int blh;
    private Format bli;
    private e blj;
    private h blk;
    private i bll;
    private i blm;
    private int bln;

    public interface a {
        void t(List<a> list);
    }

    public j(a aVar, Looper looper) {
        this(aVar, looper, g.bld);
    }

    private j(a aVar, Looper looper, g gVar) {
        super(3);
        AppMethodBeat.i(95657);
        this.blf = (a) com.google.android.exoplayer2.i.a.checkNotNull(aVar);
        this.bfa = looper == null ? null : new Handler(looper, this);
        this.blg = gVar;
        this.bef = new k();
        AppMethodBeat.o(95657);
    }

    public final int b(Format format) {
        AppMethodBeat.i(95658);
        if (this.blg.g(format)) {
            AppMethodBeat.o(95658);
            return 4;
        } else if (i.aJ(format.aOd)) {
            AppMethodBeat.o(95658);
            return 1;
        } else {
            AppMethodBeat.o(95658);
            return 0;
        }
    }

    public final void a(Format[] formatArr, long j) {
        AppMethodBeat.i(95659);
        this.bli = formatArr[0];
        if (this.blj != null) {
            this.blh = 1;
            AppMethodBeat.o(95659);
            return;
        }
        this.blj = this.blg.k(this.bli);
        AppMethodBeat.o(95659);
    }

    public final void f(long j, long j2) {
        e b;
        AppMethodBeat.i(95661);
        if (this.beF) {
            AppMethodBeat.o(95661);
            return;
        }
        if (this.blm == null) {
            this.blj.ai(j);
            try {
                this.blm = (i) this.blj.qJ();
            } catch (f e) {
                b = e.b(e, this.index);
                AppMethodBeat.o(95661);
                throw b;
            }
        }
        if (this.state != 2) {
            AppMethodBeat.o(95661);
            return;
        }
        boolean z;
        if (this.bll != null) {
            long sK = sK();
            z = false;
            while (sK <= j) {
                this.bln++;
                sK = sK();
                z = true;
            }
        } else {
            z = false;
        }
        if (this.blm != null) {
            if (this.blm.qG()) {
                if (!z && sK() == Long.MAX_VALUE) {
                    if (this.blh == 2) {
                        sJ();
                    } else {
                        sH();
                        this.beF = true;
                    }
                }
            } else if (this.blm.aSk <= j) {
                if (this.bll != null) {
                    this.bll.release();
                }
                this.bll = this.blm;
                this.blm = null;
                this.bln = this.bll.aj(j);
                z = true;
            }
        }
        if (z) {
            x(this.bll.ak(j));
        }
        if (this.blh == 2) {
            AppMethodBeat.o(95661);
            return;
        }
        while (!this.beE) {
            if (this.blk == null) {
                this.blk = (h) this.blj.qI();
                if (this.blk == null) {
                    AppMethodBeat.o(95661);
                    return;
                }
            }
            if (this.blh == 1) {
                this.blk.flags = 4;
                this.blj.ad(this.blk);
                this.blk = null;
                this.blh = 2;
                AppMethodBeat.o(95661);
                return;
            }
            try {
                int a = a(this.bef, (com.google.android.exoplayer2.b.e) this.blk, false);
                if (a == -4) {
                    if (this.blk.qG()) {
                        this.beE = true;
                    } else {
                        this.blk.aOr = this.bef.aOv.aOr;
                        this.blk.qL();
                    }
                    this.blj.ad(this.blk);
                    this.blk = null;
                } else if (a == -3) {
                    AppMethodBeat.o(95661);
                    return;
                }
            } catch (f e2) {
                b = e.b(e2, this.index);
                AppMethodBeat.o(95661);
                throw b;
            }
        }
        AppMethodBeat.o(95661);
    }

    public final void pK() {
        AppMethodBeat.i(95662);
        this.bli = null;
        x(Collections.emptyList());
        sI();
        AppMethodBeat.o(95662);
    }

    public final boolean qf() {
        return this.beF;
    }

    public final boolean isReady() {
        return true;
    }

    private void sH() {
        AppMethodBeat.i(95663);
        this.blk = null;
        this.bln = -1;
        if (this.bll != null) {
            this.bll.release();
            this.bll = null;
        }
        if (this.blm != null) {
            this.blm.release();
            this.blm = null;
        }
        AppMethodBeat.o(95663);
    }

    private void sI() {
        AppMethodBeat.i(95664);
        sH();
        this.blj.release();
        this.blj = null;
        this.blh = 0;
        AppMethodBeat.o(95664);
    }

    private void sJ() {
        AppMethodBeat.i(95665);
        sI();
        this.blj = this.blg.k(this.bli);
        AppMethodBeat.o(95665);
    }

    private long sK() {
        AppMethodBeat.i(95666);
        if (this.bln == -1 || this.bln >= this.bll.sG()) {
            AppMethodBeat.o(95666);
            return Long.MAX_VALUE;
        }
        long et = this.bll.et(this.bln);
        AppMethodBeat.o(95666);
        return et;
    }

    private void x(List<a> list) {
        AppMethodBeat.i(95667);
        if (this.bfa != null) {
            this.bfa.obtainMessage(0, list).sendToTarget();
            AppMethodBeat.o(95667);
            return;
        }
        y(list);
        AppMethodBeat.o(95667);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(95668);
        switch (message.what) {
            case 0:
                y((List) message.obj);
                AppMethodBeat.o(95668);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95668);
                throw illegalStateException;
        }
    }

    private void y(List<a> list) {
        AppMethodBeat.i(95669);
        this.blf.t(list);
        AppMethodBeat.o(95669);
    }

    public final void b(long j, boolean z) {
        AppMethodBeat.i(95660);
        x(Collections.emptyList());
        this.beE = false;
        this.beF = false;
        if (this.blh != 0) {
            sJ();
            AppMethodBeat.o(95660);
            return;
        }
        sH();
        this.blj.flush();
        AppMethodBeat.o(95660);
    }
}
