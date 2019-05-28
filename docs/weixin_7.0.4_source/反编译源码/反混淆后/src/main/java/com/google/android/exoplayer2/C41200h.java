package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C32067q.C32068a;
import com.google.android.exoplayer2.C37253f.C37248c;
import com.google.android.exoplayer2.C45043i.C25542b;
import com.google.android.exoplayer2.C45043i.C41616d;
import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.C45054w.C17695b;
import com.google.android.exoplayer2.p109g.C17663i;
import com.google.android.exoplayer2.p109g.C25538h;
import com.google.android.exoplayer2.p109g.C37259g;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C41631p;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.exoplayer2.h */
final class C41200h implements C37253f {
    private final C32069r[] aMQ;
    final C25538h aMR;
    private final C37259g aMS;
    private final C45043i aMT;
    final CopyOnWriteArraySet<C32068a> aMU;
    private final C17695b aMV;
    private final C17694a aMW;
    boolean aMX;
    boolean aMY;
    int aMZ;
    int aNa;
    int aNb;
    C45054w aNc;
    Object aNd;
    C41631p aNe;
    C37259g aNf;
    C45045p aNg;
    C25542b aNh;
    int aNi;
    int aNj;
    long aNk;
    private final Handler eventHandler;
    boolean isLoading;
    private int repeatMode;

    @SuppressLint({"HandlerLeak"})
    public C41200h(C32069r[] c32069rArr, C25538h c25538h, C8693m c8693m) {
        AppMethodBeat.m2504i(94778);
        new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(C17675v.brM).append("]");
        C45039a.checkState(c32069rArr.length > 0);
        this.aMQ = (C32069r[]) C45039a.checkNotNull(c32069rArr);
        this.aMR = (C25538h) C45039a.checkNotNull(c25538h);
        this.aMY = false;
        this.repeatMode = 0;
        this.aMZ = 1;
        this.aMU = new CopyOnWriteArraySet();
        this.aMS = new C37259g(new C45035f[c32069rArr.length]);
        this.aNc = C45054w.aPb;
        this.aMV = new C17695b();
        this.aMW = new C17694a();
        this.aNe = C41631p.bhZ;
        this.aNf = this.aMS;
        this.aNg = C45045p.aOC;
        this.eventHandler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(94777);
                C41200h c41200h = C41200h.this;
                Iterator it;
                Iterator it2;
                Iterator it3;
                switch (message.what) {
                    case 0:
                        c41200h.aNb--;
                        AppMethodBeat.m2505o(94777);
                        return;
                    case 1:
                        c41200h.aMZ = message.arg1;
                        it = c41200h.aMU.iterator();
                        while (it.hasNext()) {
                            ((C32068a) it.next()).mo26017c(c41200h.aMY, c41200h.aMZ);
                        }
                        AppMethodBeat.m2505o(94777);
                        return;
                    case 2:
                        boolean z;
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c41200h.isLoading = z;
                        it = c41200h.aMU.iterator();
                        while (it.hasNext()) {
                            ((C32068a) it.next()).mo26016aH(c41200h.isLoading);
                        }
                        AppMethodBeat.m2505o(94777);
                        return;
                    case 3:
                        if (c41200h.aNb == 0) {
                            C17663i c17663i = (C17663i) message.obj;
                            c41200h.aMX = true;
                            c41200h.aNe = c17663i.bpG;
                            c41200h.aNf = c17663i.bpH;
                            c41200h.aMR.mo42793ae(c17663i.info);
                            it2 = c41200h.aMU.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                            AppMethodBeat.m2505o(94777);
                            return;
                        }
                        break;
                    case 4:
                        int i = c41200h.aNa - 1;
                        c41200h.aNa = i;
                        if (i == 0) {
                            c41200h.aNh = (C25542b) message.obj;
                            if (c41200h.aNc.isEmpty()) {
                                c41200h.aNj = 0;
                                c41200h.aNi = 0;
                                c41200h.aNk = 0;
                            }
                            if (message.arg1 != 0) {
                                it = c41200h.aMU.iterator();
                                while (it.hasNext()) {
                                    ((C32068a) it.next()).mo26018qe();
                                }
                                AppMethodBeat.m2505o(94777);
                                return;
                            }
                        }
                        break;
                    case 5:
                        if (c41200h.aNa == 0) {
                            c41200h.aNh = (C25542b) message.obj;
                            it = c41200h.aMU.iterator();
                            while (it.hasNext()) {
                                ((C32068a) it.next()).mo26018qe();
                            }
                            AppMethodBeat.m2505o(94777);
                            return;
                        }
                        break;
                    case 6:
                        C41616d c41616d = (C41616d) message.obj;
                        c41200h.aNa -= c41616d.aNX;
                        if (c41200h.aNb == 0) {
                            c41200h.aNc = c41616d.aNc;
                            c41200h.aNd = c41616d.aNd;
                            c41200h.aNh = c41616d.aNh;
                            if (c41200h.aNa == 0 && c41200h.aNc.isEmpty()) {
                                c41200h.aNj = 0;
                                c41200h.aNi = 0;
                                c41200h.aNk = 0;
                            }
                            it2 = c41200h.aMU.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                            AppMethodBeat.m2505o(94777);
                            return;
                        }
                        break;
                    case 7:
                        C45045p c45045p = (C45045p) message.obj;
                        if (!c41200h.aNg.equals(c45045p)) {
                            c41200h.aNg = c45045p;
                            it3 = c41200h.aMU.iterator();
                            while (it3.hasNext()) {
                                ((C32068a) it3.next()).mo26015a(c45045p);
                            }
                            AppMethodBeat.m2505o(94777);
                            return;
                        }
                        break;
                    case 8:
                        C25533e c25533e = (C25533e) message.obj;
                        it3 = c41200h.aMU.iterator();
                        while (it3.hasNext()) {
                            ((C32068a) it3.next()).mo26014a(c25533e);
                        }
                        AppMethodBeat.m2505o(94777);
                        return;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.m2505o(94777);
                        throw illegalStateException;
                }
                AppMethodBeat.m2505o(94777);
            }
        };
        this.aNh = new C25542b(0);
        this.aMT = new C45043i(c32069rArr, c25538h, c8693m, this.aMY, this.repeatMode, this.eventHandler, this.aNh, this);
        AppMethodBeat.m2505o(94778);
    }

    /* renamed from: a */
    public final void mo2615a(C32068a c32068a) {
        AppMethodBeat.m2504i(94779);
        this.aMU.add(c32068a);
        AppMethodBeat.m2505o(94779);
    }

    /* renamed from: b */
    public final void mo2619b(C32068a c32068a) {
        AppMethodBeat.m2504i(94780);
        this.aMU.remove(c32068a);
        AppMethodBeat.m2505o(94780);
    }

    /* renamed from: pO */
    public final int mo2626pO() {
        return this.aMZ;
    }

    /* renamed from: aE */
    public final void mo2618aE(boolean z) {
        AppMethodBeat.m2504i(94782);
        if (this.aMY != z) {
            int i;
            this.aMY = z;
            Handler handler = this.aMT.handler;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(1, i, 0).sendToTarget();
            Iterator it = this.aMU.iterator();
            while (it.hasNext()) {
                ((C32068a) it.next()).mo26017c(z, this.aMZ);
            }
        }
        AppMethodBeat.m2505o(94782);
    }

    /* renamed from: pP */
    public final boolean mo2627pP() {
        return this.aMY;
    }

    public final void setRepeatMode(int i) {
        AppMethodBeat.m2504i(94783);
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.aMT.handler.obtainMessage(12, i, 0).sendToTarget();
            Iterator it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(94783);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void seekTo(long j) {
        AppMethodBeat.m2504i(94784);
        int pQ = m71699pQ();
        if (pQ < 0 || (!this.aNc.isEmpty() && pQ >= this.aNc.mo42830qg())) {
            C25545l c25545l = new C25545l(this.aNc, pQ, j);
            AppMethodBeat.m2505o(94784);
            throw c25545l;
        }
        this.aNa++;
        this.aNi = pQ;
        if (this.aNc.isEmpty()) {
            this.aNj = 0;
        } else {
            long j2;
            this.aNc.mo72574a(pQ, this.aMV);
            if (j == -9223372036854775807L) {
                j2 = this.aMV.aPq;
            } else {
                j2 = C17628b.m27434x(j);
            }
            int i = this.aMV.aPo;
            long j3 = this.aMV.aPr + j2;
            j2 = this.aNc.mo42826a(i, this.aMW, false).aOz;
            while (j2 != -9223372036854775807L && j3 >= j2 && i < this.aMV.aPp) {
                j3 -= j2;
                i++;
                j2 = this.aNc.mo42826a(i, this.aMW, false).aOz;
            }
            this.aNj = i;
        }
        if (j == -9223372036854775807L) {
            this.aNk = 0;
            this.aMT.mo72555a(this.aNc, pQ, -9223372036854775807L);
            AppMethodBeat.m2505o(94784);
            return;
        }
        this.aNk = j;
        this.aMT.mo72555a(this.aNc, pQ, C17628b.m27434x(j));
        Iterator it = this.aMU.iterator();
        while (it.hasNext()) {
            ((C32068a) it.next()).mo26018qe();
        }
        AppMethodBeat.m2505o(94784);
    }

    public final void stop() {
        AppMethodBeat.m2504i(94785);
        this.aMT.handler.sendEmptyMessage(5);
        AppMethodBeat.m2505o(94785);
    }

    public final void release() {
        AppMethodBeat.m2504i(94786);
        new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(C17675v.brM).append("] [").append(C8691j.m15429qa()).append("]");
        this.aMT.release();
        this.eventHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(94786);
    }

    /* renamed from: a */
    public final void mo2617a(C37248c... c37248cArr) {
        AppMethodBeat.m2504i(94787);
        C45043i c45043i = this.aMT;
        if (!c45043i.released) {
            c45043i.aNx++;
            c45043i.handler.obtainMessage(11, c37248cArr).sendToTarget();
        }
        AppMethodBeat.m2505o(94787);
    }

    /* renamed from: b */
    public final void mo2620b(C37248c... c37248cArr) {
        AppMethodBeat.m2504i(94788);
        this.aMT.mo72556b(c37248cArr);
        AppMethodBeat.m2505o(94788);
    }

    /* renamed from: pQ */
    private int m71699pQ() {
        AppMethodBeat.m2504i(94789);
        int i;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            i = this.aNi;
            AppMethodBeat.m2505o(94789);
            return i;
        }
        i = this.aNc.mo42826a(this.aNh.aNQ.bhq, this.aMW, false).aNV;
        AppMethodBeat.m2505o(94789);
        return i;
    }

    public final long getDuration() {
        AppMethodBeat.m2504i(94790);
        if (this.aNc.isEmpty()) {
            AppMethodBeat.m2505o(94790);
            return -9223372036854775807L;
        }
        boolean z;
        if (!this.aNc.isEmpty() && this.aNa == 0 && this.aNh.aNQ.mo72570sh()) {
            z = true;
        } else {
            z = false;
        }
        long w;
        if (z) {
            C45051b c45051b = this.aNh.aNQ;
            this.aNc.mo42826a(c45051b.bhq, this.aMW, false);
            w = C17628b.m27433w(this.aMW.mo32397bb(c45051b.bhr, c45051b.bhs));
            AppMethodBeat.m2505o(94790);
            return w;
        }
        w = C17628b.m27433w(this.aNc.mo72574a(m71699pQ(), this.aMV).aOz);
        AppMethodBeat.m2505o(94790);
        return w;
    }

    public final long getCurrentPosition() {
        AppMethodBeat.m2504i(94791);
        long j;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            j = this.aNk;
            AppMethodBeat.m2505o(94791);
            return j;
        }
        j = m71700z(this.aNh.aNT);
        AppMethodBeat.m2505o(94791);
        return j;
    }

    public final long getBufferedPosition() {
        AppMethodBeat.m2504i(94792);
        long j;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            j = this.aNk;
            AppMethodBeat.m2505o(94792);
            return j;
        }
        j = m71700z(this.aNh.aNU);
        AppMethodBeat.m2505o(94792);
        return j;
    }

    public final int getBufferedPercentage() {
        AppMethodBeat.m2504i(94793);
        if (this.aNc.isEmpty()) {
            AppMethodBeat.m2505o(94793);
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            AppMethodBeat.m2505o(94793);
            return 0;
        } else if (duration == 0) {
            AppMethodBeat.m2505o(94793);
            return 100;
        } else {
            int u = C17675v.m27578u((int) ((bufferedPosition * 100) / duration), 0, 100);
            AppMethodBeat.m2505o(94793);
            return u;
        }
    }

    /* renamed from: z */
    private long m71700z(long j) {
        AppMethodBeat.m2504i(94794);
        long w = C17628b.m27433w(j);
        if (!this.aNh.aNQ.mo72570sh()) {
            this.aNc.mo42826a(this.aNh.aNQ.bhq, this.aMW, false);
            w += C17628b.m27433w(this.aMW.aPd);
        }
        AppMethodBeat.m2505o(94794);
        return w;
    }

    /* renamed from: a */
    public final void mo2616a(C45052i c45052i) {
        Iterator it;
        AppMethodBeat.m2504i(94781);
        if (!(this.aNc.isEmpty() && this.aNd == null)) {
            this.aNc = C45054w.aPb;
            this.aNd = null;
            it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.aMX) {
            this.aMX = false;
            this.aNe = C41631p.bhZ;
            this.aNf = this.aMS;
            this.aMR.mo42793ae(null);
            it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.aNb++;
        this.aMT.handler.obtainMessage(0, 1, 0, c45052i).sendToTarget();
        AppMethodBeat.m2505o(94781);
    }
}
