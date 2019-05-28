package com.google.android.exoplayer2.p105f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C41591a;
import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.j */
public final class C17661j extends C41591a implements Callback {
    private boolean beE;
    private boolean beF;
    private final C8692k bef;
    private final Handler bfa;
    private final C17662a blf;
    private final C41608g blg;
    private int blh;
    private Format bli;
    private C41606e blj;
    private C41610h blk;
    private C41611i bll;
    private C41611i blm;
    private int bln;

    /* renamed from: com.google.android.exoplayer2.f.j$a */
    public interface C17662a {
        /* renamed from: t */
        void mo2645t(List<C32044a> list);
    }

    public C17661j(C17662a c17662a, Looper looper) {
        this(c17662a, looper, C41608g.bld);
    }

    private C17661j(C17662a c17662a, Looper looper, C41608g c41608g) {
        super(3);
        AppMethodBeat.m2504i(95657);
        this.blf = (C17662a) C45039a.checkNotNull(c17662a);
        this.bfa = looper == null ? null : new Handler(looper, this);
        this.blg = c41608g;
        this.bef = new C8692k();
        AppMethodBeat.m2505o(95657);
    }

    /* renamed from: b */
    public final int mo19256b(Format format) {
        AppMethodBeat.m2504i(95658);
        if (this.blg.mo66737g(format)) {
            AppMethodBeat.m2505o(95658);
            return 4;
        } else if (C37265i.m62524aJ(format.aOd)) {
            AppMethodBeat.m2505o(95658);
            return 1;
        } else {
            AppMethodBeat.m2505o(95658);
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo32348a(Format[] formatArr, long j) {
        AppMethodBeat.m2504i(95659);
        this.bli = formatArr[0];
        if (this.blj != null) {
            this.blh = 1;
            AppMethodBeat.m2505o(95659);
            return;
        }
        this.blj = this.blg.mo66738k(this.bli);
        AppMethodBeat.m2505o(95659);
    }

    /* renamed from: f */
    public final void mo32350f(long j, long j2) {
        C25533e b;
        AppMethodBeat.m2504i(95661);
        if (this.beF) {
            AppMethodBeat.m2505o(95661);
            return;
        }
        if (this.blm == null) {
            this.blj.mo19179ai(j);
            try {
                this.blm = (C41611i) this.blj.mo19143qJ();
            } catch (C41607f e) {
                b = C25533e.m40358b(e, this.index);
                AppMethodBeat.m2505o(95661);
                throw b;
            }
        }
        if (this.state != 2) {
            AppMethodBeat.m2505o(95661);
            return;
        }
        boolean z;
        if (this.bll != null) {
            long sK = m27527sK();
            z = false;
            while (sK <= j) {
                this.bln++;
                sK = m27527sK();
                z = true;
            }
        } else {
            z = false;
        }
        if (this.blm != null) {
            if (this.blm.mo42774qG()) {
                if (!z && m27527sK() == Long.MAX_VALUE) {
                    if (this.blh == 2) {
                        m27526sJ();
                    } else {
                        m27524sH();
                        this.beF = true;
                    }
                }
            } else if (this.blm.aSk <= j) {
                if (this.bll != null) {
                    this.bll.release();
                }
                this.bll = this.blm;
                this.blm = null;
                this.bln = this.bll.mo2575aj(j);
                z = true;
            }
        }
        if (z) {
            m27528x(this.bll.mo2576ak(j));
        }
        if (this.blh == 2) {
            AppMethodBeat.m2505o(95661);
            return;
        }
        while (!this.beE) {
            if (this.blk == null) {
                this.blk = (C41610h) this.blj.mo19142qI();
                if (this.blk == null) {
                    AppMethodBeat.m2505o(95661);
                    return;
                }
            }
            if (this.blh == 1) {
                this.blk.flags = 4;
                this.blj.mo19140ad(this.blk);
                this.blk = null;
                this.blh = 2;
                AppMethodBeat.m2505o(95661);
                return;
            }
            try {
                int a = mo66727a(this.bef, (C32022e) this.blk, false);
                if (a == -4) {
                    if (this.blk.mo42774qG()) {
                        this.beE = true;
                    } else {
                        this.blk.aOr = this.bef.aOv.aOr;
                        this.blk.mo52317qL();
                    }
                    this.blj.mo19140ad(this.blk);
                    this.blk = null;
                } else if (a == -3) {
                    AppMethodBeat.m2505o(95661);
                    return;
                }
            } catch (C41607f e2) {
                b = C25533e.m40358b(e2, this.index);
                AppMethodBeat.m2505o(95661);
                throw b;
            }
        }
        AppMethodBeat.m2505o(95661);
    }

    /* renamed from: pK */
    public final void mo32353pK() {
        AppMethodBeat.m2504i(95662);
        this.bli = null;
        m27528x(Collections.emptyList());
        m27525sI();
        AppMethodBeat.m2505o(95662);
    }

    /* renamed from: qf */
    public final boolean mo32354qf() {
        return this.beF;
    }

    public final boolean isReady() {
        return true;
    }

    /* renamed from: sH */
    private void m27524sH() {
        AppMethodBeat.m2504i(95663);
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
        AppMethodBeat.m2505o(95663);
    }

    /* renamed from: sI */
    private void m27525sI() {
        AppMethodBeat.m2504i(95664);
        m27524sH();
        this.blj.release();
        this.blj = null;
        this.blh = 0;
        AppMethodBeat.m2505o(95664);
    }

    /* renamed from: sJ */
    private void m27526sJ() {
        AppMethodBeat.m2504i(95665);
        m27525sI();
        this.blj = this.blg.mo66738k(this.bli);
        AppMethodBeat.m2505o(95665);
    }

    /* renamed from: sK */
    private long m27527sK() {
        AppMethodBeat.m2504i(95666);
        if (this.bln == -1 || this.bln >= this.bll.mo2578sG()) {
            AppMethodBeat.m2505o(95666);
            return Long.MAX_VALUE;
        }
        long et = this.bll.mo2577et(this.bln);
        AppMethodBeat.m2505o(95666);
        return et;
    }

    /* renamed from: x */
    private void m27528x(List<C32044a> list) {
        AppMethodBeat.m2504i(95667);
        if (this.bfa != null) {
            this.bfa.obtainMessage(0, list).sendToTarget();
            AppMethodBeat.m2505o(95667);
            return;
        }
        m27529y(list);
        AppMethodBeat.m2505o(95667);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(95668);
        switch (message.what) {
            case 0:
                m27529y((List) message.obj);
                AppMethodBeat.m2505o(95668);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95668);
                throw illegalStateException;
        }
    }

    /* renamed from: y */
    private void m27529y(List<C32044a> list) {
        AppMethodBeat.m2504i(95669);
        this.blf.mo2645t(list);
        AppMethodBeat.m2505o(95669);
    }

    /* renamed from: b */
    public final void mo32349b(long j, boolean z) {
        AppMethodBeat.m2504i(95660);
        m27528x(Collections.emptyList());
        this.beE = false;
        this.beF = false;
        if (this.blh != 0) {
            m27526sJ();
            AppMethodBeat.m2505o(95660);
            return;
        }
        m27524sH();
        this.blj.flush();
        AppMethodBeat.m2505o(95660);
    }
}
