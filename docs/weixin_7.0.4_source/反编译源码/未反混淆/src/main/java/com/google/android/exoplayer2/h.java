package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.i;
import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h implements f {
    private final r[] aMQ;
    final com.google.android.exoplayer2.g.h aMR;
    private final g aMS;
    private final i aMT;
    final CopyOnWriteArraySet<a> aMU;
    private final b aMV;
    private final w.a aMW;
    boolean aMX;
    boolean aMY;
    int aMZ;
    int aNa;
    int aNb;
    w aNc;
    Object aNd;
    p aNe;
    g aNf;
    p aNg;
    i.b aNh;
    int aNi;
    int aNj;
    long aNk;
    private final Handler eventHandler;
    boolean isLoading;
    private int repeatMode;

    @SuppressLint({"HandlerLeak"})
    public h(r[] rVarArr, com.google.android.exoplayer2.g.h hVar, m mVar) {
        AppMethodBeat.i(94778);
        new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(v.brM).append("]");
        com.google.android.exoplayer2.i.a.checkState(rVarArr.length > 0);
        this.aMQ = (r[]) com.google.android.exoplayer2.i.a.checkNotNull(rVarArr);
        this.aMR = (com.google.android.exoplayer2.g.h) com.google.android.exoplayer2.i.a.checkNotNull(hVar);
        this.aMY = false;
        this.repeatMode = 0;
        this.aMZ = 1;
        this.aMU = new CopyOnWriteArraySet();
        this.aMS = new g(new f[rVarArr.length]);
        this.aNc = w.aPb;
        this.aMV = new b();
        this.aMW = new w.a();
        this.aNe = p.bhZ;
        this.aNf = this.aMS;
        this.aNg = p.aOC;
        this.eventHandler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(94777);
                h hVar = h.this;
                Iterator it;
                Iterator it2;
                Iterator it3;
                switch (message.what) {
                    case 0:
                        hVar.aNb--;
                        AppMethodBeat.o(94777);
                        return;
                    case 1:
                        hVar.aMZ = message.arg1;
                        it = hVar.aMU.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).c(hVar.aMY, hVar.aMZ);
                        }
                        AppMethodBeat.o(94777);
                        return;
                    case 2:
                        boolean z;
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        hVar.isLoading = z;
                        it = hVar.aMU.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).aH(hVar.isLoading);
                        }
                        AppMethodBeat.o(94777);
                        return;
                    case 3:
                        if (hVar.aNb == 0) {
                            i iVar = (i) message.obj;
                            hVar.aMX = true;
                            hVar.aNe = iVar.bpG;
                            hVar.aNf = iVar.bpH;
                            hVar.aMR.ae(iVar.info);
                            it2 = hVar.aMU.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                            AppMethodBeat.o(94777);
                            return;
                        }
                        break;
                    case 4:
                        int i = hVar.aNa - 1;
                        hVar.aNa = i;
                        if (i == 0) {
                            hVar.aNh = (i.b) message.obj;
                            if (hVar.aNc.isEmpty()) {
                                hVar.aNj = 0;
                                hVar.aNi = 0;
                                hVar.aNk = 0;
                            }
                            if (message.arg1 != 0) {
                                it = hVar.aMU.iterator();
                                while (it.hasNext()) {
                                    ((a) it.next()).qe();
                                }
                                AppMethodBeat.o(94777);
                                return;
                            }
                        }
                        break;
                    case 5:
                        if (hVar.aNa == 0) {
                            hVar.aNh = (i.b) message.obj;
                            it = hVar.aMU.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).qe();
                            }
                            AppMethodBeat.o(94777);
                            return;
                        }
                        break;
                    case 6:
                        d dVar = (d) message.obj;
                        hVar.aNa -= dVar.aNX;
                        if (hVar.aNb == 0) {
                            hVar.aNc = dVar.aNc;
                            hVar.aNd = dVar.aNd;
                            hVar.aNh = dVar.aNh;
                            if (hVar.aNa == 0 && hVar.aNc.isEmpty()) {
                                hVar.aNj = 0;
                                hVar.aNi = 0;
                                hVar.aNk = 0;
                            }
                            it2 = hVar.aMU.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                            AppMethodBeat.o(94777);
                            return;
                        }
                        break;
                    case 7:
                        p pVar = (p) message.obj;
                        if (!hVar.aNg.equals(pVar)) {
                            hVar.aNg = pVar;
                            it3 = hVar.aMU.iterator();
                            while (it3.hasNext()) {
                                ((a) it3.next()).a(pVar);
                            }
                            AppMethodBeat.o(94777);
                            return;
                        }
                        break;
                    case 8:
                        e eVar = (e) message.obj;
                        it3 = hVar.aMU.iterator();
                        while (it3.hasNext()) {
                            ((a) it3.next()).a(eVar);
                        }
                        AppMethodBeat.o(94777);
                        return;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(94777);
                        throw illegalStateException;
                }
                AppMethodBeat.o(94777);
            }
        };
        this.aNh = new i.b(0);
        this.aMT = new i(rVarArr, hVar, mVar, this.aMY, this.repeatMode, this.eventHandler, this.aNh, this);
        AppMethodBeat.o(94778);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(94779);
        this.aMU.add(aVar);
        AppMethodBeat.o(94779);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(94780);
        this.aMU.remove(aVar);
        AppMethodBeat.o(94780);
    }

    public final int pO() {
        return this.aMZ;
    }

    public final void aE(boolean z) {
        AppMethodBeat.i(94782);
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
                ((a) it.next()).c(z, this.aMZ);
            }
        }
        AppMethodBeat.o(94782);
    }

    public final boolean pP() {
        return this.aMY;
    }

    public final void setRepeatMode(int i) {
        AppMethodBeat.i(94783);
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.aMT.handler.obtainMessage(12, i, 0).sendToTarget();
            Iterator it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(94783);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void seekTo(long j) {
        AppMethodBeat.i(94784);
        int pQ = pQ();
        if (pQ < 0 || (!this.aNc.isEmpty() && pQ >= this.aNc.qg())) {
            l lVar = new l(this.aNc, pQ, j);
            AppMethodBeat.o(94784);
            throw lVar;
        }
        this.aNa++;
        this.aNi = pQ;
        if (this.aNc.isEmpty()) {
            this.aNj = 0;
        } else {
            long j2;
            this.aNc.a(pQ, this.aMV);
            if (j == -9223372036854775807L) {
                j2 = this.aMV.aPq;
            } else {
                j2 = b.x(j);
            }
            int i = this.aMV.aPo;
            long j3 = this.aMV.aPr + j2;
            j2 = this.aNc.a(i, this.aMW, false).aOz;
            while (j2 != -9223372036854775807L && j3 >= j2 && i < this.aMV.aPp) {
                j3 -= j2;
                i++;
                j2 = this.aNc.a(i, this.aMW, false).aOz;
            }
            this.aNj = i;
        }
        if (j == -9223372036854775807L) {
            this.aNk = 0;
            this.aMT.a(this.aNc, pQ, -9223372036854775807L);
            AppMethodBeat.o(94784);
            return;
        }
        this.aNk = j;
        this.aMT.a(this.aNc, pQ, b.x(j));
        Iterator it = this.aMU.iterator();
        while (it.hasNext()) {
            ((a) it.next()).qe();
        }
        AppMethodBeat.o(94784);
    }

    public final void stop() {
        AppMethodBeat.i(94785);
        this.aMT.handler.sendEmptyMessage(5);
        AppMethodBeat.o(94785);
    }

    public final void release() {
        AppMethodBeat.i(94786);
        new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(v.brM).append("] [").append(j.qa()).append("]");
        this.aMT.release();
        this.eventHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(94786);
    }

    public final void a(c... cVarArr) {
        AppMethodBeat.i(94787);
        i iVar = this.aMT;
        if (!iVar.released) {
            iVar.aNx++;
            iVar.handler.obtainMessage(11, cVarArr).sendToTarget();
        }
        AppMethodBeat.o(94787);
    }

    public final void b(c... cVarArr) {
        AppMethodBeat.i(94788);
        this.aMT.b(cVarArr);
        AppMethodBeat.o(94788);
    }

    private int pQ() {
        AppMethodBeat.i(94789);
        int i;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            i = this.aNi;
            AppMethodBeat.o(94789);
            return i;
        }
        i = this.aNc.a(this.aNh.aNQ.bhq, this.aMW, false).aNV;
        AppMethodBeat.o(94789);
        return i;
    }

    public final long getDuration() {
        AppMethodBeat.i(94790);
        if (this.aNc.isEmpty()) {
            AppMethodBeat.o(94790);
            return -9223372036854775807L;
        }
        boolean z;
        if (!this.aNc.isEmpty() && this.aNa == 0 && this.aNh.aNQ.sh()) {
            z = true;
        } else {
            z = false;
        }
        long w;
        if (z) {
            com.google.android.exoplayer2.source.i.b bVar = this.aNh.aNQ;
            this.aNc.a(bVar.bhq, this.aMW, false);
            w = b.w(this.aMW.bb(bVar.bhr, bVar.bhs));
            AppMethodBeat.o(94790);
            return w;
        }
        w = b.w(this.aNc.a(pQ(), this.aMV).aOz);
        AppMethodBeat.o(94790);
        return w;
    }

    public final long getCurrentPosition() {
        AppMethodBeat.i(94791);
        long j;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            j = this.aNk;
            AppMethodBeat.o(94791);
            return j;
        }
        j = z(this.aNh.aNT);
        AppMethodBeat.o(94791);
        return j;
    }

    public final long getBufferedPosition() {
        AppMethodBeat.i(94792);
        long j;
        if (this.aNc.isEmpty() || this.aNa > 0) {
            j = this.aNk;
            AppMethodBeat.o(94792);
            return j;
        }
        j = z(this.aNh.aNU);
        AppMethodBeat.o(94792);
        return j;
    }

    public final int getBufferedPercentage() {
        AppMethodBeat.i(94793);
        if (this.aNc.isEmpty()) {
            AppMethodBeat.o(94793);
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            AppMethodBeat.o(94793);
            return 0;
        } else if (duration == 0) {
            AppMethodBeat.o(94793);
            return 100;
        } else {
            int u = v.u((int) ((bufferedPosition * 100) / duration), 0, 100);
            AppMethodBeat.o(94793);
            return u;
        }
    }

    private long z(long j) {
        AppMethodBeat.i(94794);
        long w = b.w(j);
        if (!this.aNh.aNQ.sh()) {
            this.aNc.a(this.aNh.aNQ.bhq, this.aMW, false);
            w += b.w(this.aMW.aPd);
        }
        AppMethodBeat.o(94794);
        return w;
    }

    public final void a(com.google.android.exoplayer2.source.i iVar) {
        Iterator it;
        AppMethodBeat.i(94781);
        if (!(this.aNc.isEmpty() && this.aNd == null)) {
            this.aNc = w.aPb;
            this.aNd = null;
            it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.aMX) {
            this.aMX = false;
            this.aNe = p.bhZ;
            this.aNf = this.aMS;
            this.aMR.ae(null);
            it = this.aMU.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.aNb++;
        this.aMT.handler.obtainMessage(0, 1, 0, iVar).sendToTarget();
        AppMethodBeat.o(94781);
    }
}
