package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class i implements Callback, com.google.android.exoplayer2.g.h.a, com.google.android.exoplayer2.source.h.a, com.google.android.exoplayer2.source.i.a {
    private final r[] aMQ;
    private final h aMR;
    private final com.google.android.exoplayer2.w.b aMV;
    private final com.google.android.exoplayer2.w.a aMW;
    private boolean aMY;
    private int aNA;
    private c aNB;
    private long aNC;
    private a aND;
    private a aNE;
    private a aNF;
    private w aNc;
    private p aNg;
    private b aNh;
    private final s[] aNm;
    private final m aNn;
    private final q aNo;
    private final HandlerThread aNp;
    private final f aNq;
    private final n aNr;
    private r aNs;
    private com.google.android.exoplayer2.i.h aNt;
    private com.google.android.exoplayer2.source.i aNu;
    private r[] aNv;
    private boolean aNw;
    int aNx;
    private int aNy;
    private long aNz;
    private final Handler eventHandler;
    final Handler handler;
    private boolean isLoading;
    boolean released;
    private int repeatMode;
    private int state = 1;

    static final class a {
        private final r[] aMQ;
        private final h aMR;
        public final com.google.android.exoplayer2.source.h aNG;
        public final Object aNH;
        public final l[] aNI;
        public final boolean[] aNJ;
        public final long aNK;
        public com.google.android.exoplayer2.n.a aNL;
        public boolean aNM;
        public a aNN;
        public com.google.android.exoplayer2.g.i aNO;
        private com.google.android.exoplayer2.g.i aNP;
        private final s[] aNm;
        final m aNn;
        private final com.google.android.exoplayer2.source.i aNu;
        public final int index;
        public boolean prepared;

        public a(r[] rVarArr, s[] sVarArr, long j, h hVar, m mVar, com.google.android.exoplayer2.source.i iVar, Object obj, int i, com.google.android.exoplayer2.n.a aVar) {
            com.google.android.exoplayer2.source.h cVar;
            AppMethodBeat.i(94795);
            this.aMQ = rVarArr;
            this.aNm = sVarArr;
            this.aNK = j;
            this.aMR = hVar;
            this.aNn = mVar;
            this.aNu = iVar;
            this.aNH = com.google.android.exoplayer2.i.a.checkNotNull(obj);
            this.index = i;
            this.aNL = aVar;
            this.aNI = new l[rVarArr.length];
            this.aNJ = new boolean[rVarArr.length];
            com.google.android.exoplayer2.source.h a = iVar.a(aVar.aOx, mVar.pN());
            if (aVar.aOy != Long.MIN_VALUE) {
                cVar = new com.google.android.exoplayer2.source.c(a, true);
                cVar.i(0, aVar.aOy);
            } else {
                cVar = a;
            }
            this.aNG = cVar;
            AppMethodBeat.o(94795);
        }

        public final long pX() {
            return this.index == 0 ? this.aNK : this.aNK - this.aNL.aNR;
        }

        public final boolean pY() {
            AppMethodBeat.i(94796);
            if (!this.prepared || (this.aNM && this.aNG.rU() != Long.MIN_VALUE)) {
                AppMethodBeat.o(94796);
                return false;
            }
            AppMethodBeat.o(94796);
            return true;
        }

        public final boolean y(long j) {
            long rV;
            AppMethodBeat.i(94797);
            if (this.prepared) {
                rV = this.aNG.rV();
            } else {
                rV = 0;
            }
            if (rV == Long.MIN_VALUE) {
                AppMethodBeat.o(94797);
                return false;
            }
            boolean y = this.aNn.y(rV - (j - pX()));
            AppMethodBeat.o(94797);
            return y;
        }

        public final boolean pZ() {
            AppMethodBeat.i(94799);
            com.google.android.exoplayer2.g.i a = this.aMR.a(this.aNm, this.aNG.rS());
            if (a.a(this.aNP)) {
                AppMethodBeat.o(94799);
                return false;
            }
            this.aNO = a;
            AppMethodBeat.o(94799);
            return true;
        }

        public final long D(long j) {
            AppMethodBeat.i(94800);
            long a = a(j, false, new boolean[this.aMQ.length]);
            AppMethodBeat.o(94800);
            return a;
        }

        public final long a(long j, boolean z, boolean[] zArr) {
            int i;
            AppMethodBeat.i(94801);
            g gVar = this.aNO.bpH;
            for (i = 0; i < gVar.length; i++) {
                boolean[] zArr2 = this.aNJ;
                boolean z2 = !z && this.aNO.a(this.aNP, i);
                zArr2[i] = z2;
            }
            long a = this.aNG.a(gVar.ti(), this.aNJ, this.aNI, zArr, j);
            this.aNP = this.aNO;
            this.aNM = false;
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aNI.length) {
                    if (this.aNI[i2] != null) {
                        com.google.android.exoplayer2.i.a.checkState(gVar.bpE[i2] != null);
                        this.aNM = true;
                    } else {
                        com.google.android.exoplayer2.i.a.checkState(gVar.bpE[i2] == null);
                    }
                    i = i2 + 1;
                } else {
                    this.aNn.a(this.aMQ, gVar);
                    AppMethodBeat.o(94801);
                    return a;
                }
            }
        }

        public final void release() {
            AppMethodBeat.i(94802);
            try {
                if (this.aNL.aOy != Long.MIN_VALUE) {
                    this.aNu.b(((com.google.android.exoplayer2.source.c) this.aNG).aNG);
                    AppMethodBeat.o(94802);
                    return;
                }
                this.aNu.b(this.aNG);
                AppMethodBeat.o(94802);
            } catch (RuntimeException e) {
                AppMethodBeat.o(94802);
            }
        }

        public final void C(long j) {
            AppMethodBeat.i(94798);
            this.aNG.Y(j - pX());
            AppMethodBeat.o(94798);
        }
    }

    static final class c {
        public final int aNV;
        public final long aNW;
        public final w aNc;

        public c(w wVar, int i, long j) {
            this.aNc = wVar;
            this.aNV = i;
            this.aNW = j;
        }
    }

    public static final class b {
        public final com.google.android.exoplayer2.source.i.b aNQ;
        public final long aNR;
        public final long aNS;
        public volatile long aNT;
        public volatile long aNU;

        public b(long j) {
            this(new com.google.android.exoplayer2.source.i.b(0), j);
            AppMethodBeat.i(94803);
            AppMethodBeat.o(94803);
        }

        public b(com.google.android.exoplayer2.source.i.b bVar, long j) {
            this(bVar, j, -9223372036854775807L);
        }

        public b(com.google.android.exoplayer2.source.i.b bVar, long j, long j2) {
            this.aNQ = bVar;
            this.aNR = j;
            this.aNS = j2;
            this.aNT = j;
            this.aNU = j;
        }
    }

    public static final class d {
        public final int aNX;
        public final w aNc;
        public final Object aNd;
        public final b aNh;

        public d(w wVar, Object obj, b bVar, int i) {
            this.aNc = wVar;
            this.aNd = obj;
            this.aNh = bVar;
            this.aNX = i;
        }
    }

    public i(r[] rVarArr, h hVar, m mVar, boolean z, int i, Handler handler, b bVar, f fVar) {
        AppMethodBeat.i(94804);
        this.aMQ = rVarArr;
        this.aMR = hVar;
        this.aNn = mVar;
        this.aMY = z;
        this.repeatMode = i;
        this.eventHandler = handler;
        this.aNh = bVar;
        this.aNq = fVar;
        this.aNm = new s[rVarArr.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            rVarArr[i2].setIndex(i2);
            this.aNm[i2] = rVarArr[i2].pC();
        }
        this.aNo = new q();
        this.aNv = new r[0];
        this.aMV = new com.google.android.exoplayer2.w.b();
        this.aMW = new com.google.android.exoplayer2.w.a();
        this.aNr = new n();
        hVar.bpF = this;
        this.aNg = p.aOC;
        this.aNp = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.aNp.start();
        this.handler = new Handler(this.aNp.getLooper(), this);
        AppMethodBeat.o(94804);
    }

    public final void a(w wVar, int i, long j) {
        AppMethodBeat.i(94805);
        this.handler.obtainMessage(3, new c(wVar, i, j)).sendToTarget();
        AppMethodBeat.o(94805);
    }

    public final synchronized void b(com.google.android.exoplayer2.f.c... cVarArr) {
        AppMethodBeat.i(94806);
        if (this.released) {
            AppMethodBeat.o(94806);
        } else {
            int i = this.aNx;
            this.aNx = i + 1;
            this.handler.obtainMessage(11, cVarArr).sendToTarget();
            Object obj = null;
            while (this.aNy <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            AppMethodBeat.o(94806);
        }
    }

    public final synchronized void release() {
        AppMethodBeat.i(94807);
        if (this.released) {
            AppMethodBeat.o(94807);
        } else {
            this.handler.sendEmptyMessage(6);
            Object obj = null;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            this.aNp.quit();
            AppMethodBeat.o(94807);
        }
    }

    public final void a(w wVar, Object obj) {
        AppMethodBeat.i(94808);
        this.handler.obtainMessage(7, Pair.create(wVar, obj)).sendToTarget();
        AppMethodBeat.o(94808);
    }

    public final void a(com.google.android.exoplayer2.source.h hVar) {
        AppMethodBeat.i(94809);
        this.handler.obtainMessage(8, hVar).sendToTarget();
        AppMethodBeat.o(94809);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0268 A:{LOOP_START, Catch:{ all -> 0x0881, e -> 0x008c, IOException -> 0x00dc, RuntimeException -> 0x010a }, LOOP:2: B:109:0x0268->B:113:0x0282} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x06e2 A:{Catch:{ all -> 0x0881, e -> 0x008c, IOException -> 0x00dc, RuntimeException -> 0x010a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(94810);
        long pX;
        long longValue;
        com.google.android.exoplayer2.source.i.b g;
        int i;
        try {
            Object obj;
            boolean z;
            n nVar;
            com.google.android.exoplayer2.n.a a;
            int a2;
            int i2;
            int intValue;
            com.google.android.exoplayer2.source.i.b bVar;
            int i3;
            a aVar;
            r rVar;
            Object obj2;
            a aVar2;
            long rU;
            Pair a3;
            int i4;
            a aVar3;
            a aVar4;
            com.google.android.exoplayer2.source.h hVar;
            switch (message.what) {
                case 0:
                    com.google.android.exoplayer2.source.i iVar = (com.google.android.exoplayer2.source.i) message.obj;
                    if (message.arg1 != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    this.eventHandler.sendEmptyMessage(0);
                    aG(true);
                    this.aNn.pL();
                    if (obj != null) {
                        this.aNh = new b(-9223372036854775807L);
                    } else {
                        this.aNh = new b(this.aNh.aNQ, this.aNh.aNT, this.aNh.aNS);
                    }
                    this.aNu = iVar;
                    if (iVar != null) {
                        iVar.a(this.aNq, (com.google.android.exoplayer2.source.i.a) this);
                    }
                    setState(2);
                    this.handler.sendEmptyMessage(2);
                    AppMethodBeat.o(94810);
                    return true;
                case 1:
                    if (message.arg1 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.aNw = false;
                    this.aMY = z;
                    if (!z) {
                        pS();
                        pT();
                    } else if (this.state == 3) {
                        pR();
                        this.handler.sendEmptyMessage(2);
                    } else if (this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 2:
                    Object obj3;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.aNc != null || this.aNu == null) {
                        if (this.aND == null) {
                            nVar = this.aNr;
                            b bVar2 = this.aNh;
                            a = nVar.a(bVar2.aNQ, bVar2.aNS, bVar2.aNR);
                        } else {
                            if (!this.aND.aNL.aOB && this.aND.pY() && this.aND.aNL.aOz != -9223372036854775807L && (this.aNF == null || this.aND.index - this.aNF.index != 100)) {
                                n nVar2 = this.aNr;
                                com.google.android.exoplayer2.n.a aVar5 = this.aND.aNL;
                                pX = this.aND.pX();
                                long j = this.aNC;
                                if (aVar5.aOA) {
                                    a2 = nVar2.aNc.a(aVar5.aOx.bhq, nVar2.aMW, nVar2.aMV, nVar2.repeatMode);
                                    if (a2 == -1) {
                                        a = null;
                                    } else {
                                        i2 = nVar2.aNc.a(a2, nVar2.aMW, false).aNV;
                                        if (nVar2.aNc.a(i2, nVar2.aMV).aPo == a2) {
                                            Pair a4 = nVar2.aNc.a(nVar2.aMV, nVar2.aMW, i2, -9223372036854775807L, Math.max(0, (aVar5.aOz + pX) - j));
                                            if (a4 == null) {
                                                a = null;
                                            } else {
                                                intValue = ((Integer) a4.first).intValue();
                                                longValue = ((Long) a4.second).longValue();
                                                a2 = intValue;
                                            }
                                        } else {
                                            longValue = 0;
                                        }
                                        a = nVar2.a(nVar2.g(a2, longValue), longValue, longValue);
                                    }
                                } else {
                                    bVar = aVar5.aOx;
                                    if (bVar.sh()) {
                                        i3 = bVar.bhr;
                                        nVar2.aNc.a(bVar.bhq, nVar2.aMW, false);
                                        intValue = nVar2.aMW.aPf[i3];
                                        if (intValue == -1) {
                                            a = null;
                                        } else {
                                            i2 = bVar.bhs + 1;
                                            if (i2 >= intValue) {
                                                intValue = nVar2.aMW.G(aVar5.aNS);
                                                if (intValue == -1) {
                                                    pX = Long.MIN_VALUE;
                                                } else {
                                                    pX = nVar2.aMW.aPe[intValue];
                                                }
                                                a = nVar2.c(bVar.bhq, aVar5.aNS, pX);
                                            } else if (nVar2.aMW.ba(i3, i2)) {
                                                a = nVar2.b(bVar.bhq, i3, i2, aVar5.aNS);
                                            } else {
                                                a = null;
                                            }
                                        }
                                    } else if (aVar5.aOy != Long.MIN_VALUE) {
                                        i3 = nVar2.aMW.F(aVar5.aOy);
                                        if (nVar2.aMW.ba(i3, 0)) {
                                            a = nVar2.b(bVar.bhq, i3, 0, aVar5.aOy);
                                        } else {
                                            a = null;
                                        }
                                    } else {
                                        i3 = nVar2.aMW.qi();
                                        if (i3 != 0) {
                                            if (nVar2.aMW.aPe[i3 - 1] == Long.MIN_VALUE && !nVar2.aMW.dy(i3 - 1) && nVar2.aMW.ba(i3 - 1, 0)) {
                                                a = nVar2.b(bVar.bhq, i3 - 1, 0, nVar2.aMW.aOz);
                                            }
                                        }
                                        a = null;
                                    }
                                }
                            }
                            if (this.aND != null || this.aND.pY()) {
                                aF(false);
                            } else if (!(this.aND == null || this.isLoading)) {
                                pW();
                            }
                            if (this.aNF != null) {
                                while (this.aNF != this.aNE && this.aNC >= this.aNF.aNN.aNK) {
                                    this.aNF.release();
                                    b(this.aNF.aNN);
                                    this.aNh = new b(this.aNF.aNL.aOx, this.aNF.aNL.aNR, this.aNF.aNL.aNS);
                                    pT();
                                    this.eventHandler.obtainMessage(5, this.aNh).sendToTarget();
                                }
                                r rVar2;
                                l lVar;
                                if (this.aNE.aNL.aOB) {
                                    for (a2 = 0; a2 < this.aMQ.length; a2++) {
                                        rVar2 = this.aMQ[a2];
                                        lVar = this.aNE.aNI[a2];
                                        if (lVar != null && rVar2.pE() == lVar && rVar2.pF()) {
                                            rVar2.pG();
                                        }
                                    }
                                } else {
                                    a2 = 0;
                                    while (a2 < this.aMQ.length) {
                                        rVar2 = this.aMQ[a2];
                                        lVar = this.aNE.aNI[a2];
                                        if (rVar2.pE() == lVar && (lVar == null || rVar2.pF())) {
                                            a2++;
                                        }
                                    }
                                    if (this.aNE.aNN != null && this.aNE.aNN.prepared) {
                                        com.google.android.exoplayer2.g.i iVar2 = this.aNE.aNO;
                                        this.aNE = this.aNE.aNN;
                                        com.google.android.exoplayer2.g.i iVar3 = this.aNE.aNO;
                                        obj = this.aNE.aNG.rT() != -9223372036854775807L ? 1 : null;
                                        for (intValue = 0; intValue < this.aMQ.length; intValue++) {
                                            r rVar3 = this.aMQ[intValue];
                                            if (iVar2.bpH.bpE[intValue] != null) {
                                                if (obj == null) {
                                                    if (!rVar3.pH()) {
                                                        f fVar = iVar3.bpH.bpE[intValue];
                                                        obj3 = iVar2.bpI[intValue];
                                                        t tVar = iVar3.bpI[intValue];
                                                        if (fVar != null && tVar.equals(obj3)) {
                                                            Format[] formatArr = new Format[fVar.length()];
                                                            for (i3 = 0; i3 < formatArr.length; i3++) {
                                                                formatArr[i3] = fVar.eG(i3);
                                                            }
                                                            rVar3.a(formatArr, this.aNE.aNI[intValue], this.aNE.pX());
                                                        }
                                                    }
                                                }
                                                rVar3.pG();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a == null) {
                            this.aNu.rX();
                        } else {
                            int i5;
                            if (this.aND == null) {
                                pX = 60000000;
                            } else {
                                pX = this.aND.pX() + this.aND.aNL.aOz;
                            }
                            if (this.aND == null) {
                                i5 = 0;
                            } else {
                                i5 = this.aND.index + 1;
                            }
                            aVar = new a(this.aMQ, this.aNm, pX, this.aMR, this.aNn, this.aNu, this.aNc.a(a.aOx.bhq, this.aMW, true).aNH, i5, a);
                            if (this.aND != null) {
                                this.aND.aNN = aVar;
                            }
                            this.aND = aVar;
                            this.aND.aNG.a(this, a.aNR);
                            aF(true);
                        }
                        if (this.aND != null) {
                            break;
                        }
                        aF(false);
                        if (this.aNF != null) {
                        }
                    } else {
                        this.aNu.rX();
                    }
                    if (this.aNF == null) {
                        pV();
                        e(elapsedRealtime, 10);
                    } else {
                        t.beginSection("doSomeWork");
                        pT();
                        this.aNF.aNG.W(this.aNh.aNT);
                        obj3 = 1;
                        z = true;
                        for (r rVar4 : this.aNv) {
                            rVar4.f(this.aNC, this.aNz);
                            obj3 = (obj3 == null || !rVar4.qf()) ? null : 1;
                            obj2 = (rVar4.isReady() || rVar4.qf()) ? 1 : null;
                            if (obj2 == null) {
                                rVar4.pI();
                            }
                            if (!z || obj2 == null) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            pV();
                        }
                        if (this.aNt != null) {
                            p qC = this.aNt.qC();
                            if (!qC.equals(this.aNg)) {
                                this.aNg = qC;
                                this.aNo.a(this.aNt);
                                this.eventHandler.obtainMessage(7, qC).sendToTarget();
                            }
                        }
                        pX = this.aNF.aNL.aOz;
                        if (obj3 != null && ((pX == -9223372036854775807L || pX <= this.aNh.aNT) && this.aNF.aNL.aOB)) {
                            setState(4);
                            pS();
                        } else if (this.state == 2) {
                            if (this.aNv.length > 0) {
                                if (z) {
                                    aVar2 = this.aND;
                                    boolean z2 = this.aNw;
                                    pX = this.aNC;
                                    if (aVar2.prepared) {
                                        rU = aVar2.aNG.rU();
                                    } else {
                                        rU = aVar2.aNL.aNR;
                                    }
                                    if (rU == Long.MIN_VALUE) {
                                        if (aVar2.aNL.aOB) {
                                            z = true;
                                            if (z) {
                                                z = true;
                                            }
                                        } else {
                                            rU = aVar2.aNL.aOz;
                                        }
                                    }
                                    z = aVar2.aNn.c(rU - (pX - aVar2.pX()), z2);
                                    if (z) {
                                    }
                                }
                                z = false;
                            } else {
                                z = B(pX);
                            }
                            if (z) {
                                setState(3);
                                if (this.aMY) {
                                    pR();
                                }
                            }
                        } else if (this.state == 3) {
                            if (this.aNv.length <= 0) {
                                z = B(pX);
                            }
                            if (!z) {
                                this.aNw = this.aMY;
                                setState(2);
                                pS();
                            }
                        }
                        if (this.state == 2) {
                            for (r pI : this.aNv) {
                                pI.pI();
                            }
                        }
                        if ((this.aMY && this.state == 3) || this.state == 2) {
                            e(elapsedRealtime, 10);
                        } else if (this.aNv.length == 0 || this.state == 4) {
                            this.handler.removeMessages(2);
                        } else {
                            e(elapsedRealtime, 1000);
                        }
                        t.endSection();
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 3:
                    c cVar = (c) message.obj;
                    if (this.aNc == null) {
                        this.aNA++;
                        this.aNB = cVar;
                    } else {
                        a3 = a(cVar);
                        if (a3 == null) {
                            this.aNh = new b(0);
                            this.eventHandler.obtainMessage(4, 1, 0, this.aNh).sendToTarget();
                            this.aNh = new b(-9223372036854775807L);
                            setState(4);
                            aG(false);
                        } else {
                            i4 = cVar.aNW == -9223372036854775807L ? 1 : 0;
                            i3 = ((Integer) a3.first).intValue();
                            pX = ((Long) a3.second).longValue();
                            g = this.aNr.g(i3, pX);
                            if (g.sh()) {
                                longValue = 0;
                                i = 1;
                            } else {
                                longValue = pX;
                                i = i4;
                            }
                            if (g.equals(this.aNh.aNQ) && longValue / 1000 == this.aNh.aNT / 1000) {
                                this.aNh = new b(g, longValue, pX);
                                this.eventHandler.obtainMessage(4, i != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
                            } else {
                                long a5 = a(g, longValue);
                                i4 = i | (longValue != a5 ? 1 : 0);
                                this.aNh = new b(g, a5, pX);
                                this.eventHandler.obtainMessage(4, i4 != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
                            }
                        }
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 4:
                    p pVar = (p) message.obj;
                    if (this.aNt != null) {
                        pVar = this.aNt.b(pVar);
                    } else {
                        pVar = this.aNo.b(pVar);
                    }
                    this.aNg = pVar;
                    this.eventHandler.obtainMessage(7, pVar).sendToTarget();
                    AppMethodBeat.o(94810);
                    return true;
                case 5:
                    pU();
                    AppMethodBeat.o(94810);
                    return true;
                case 6:
                    ms();
                    AppMethodBeat.o(94810);
                    return true;
                case 7:
                    Pair pair = (Pair) message.obj;
                    w wVar = this.aNc;
                    this.aNc = (w) pair.first;
                    this.aNr.aNc = this.aNc;
                    Object obj4 = pair.second;
                    if (wVar != null) {
                        intValue = this.aNh.aNQ.bhq;
                        a aVar6 = this.aNF != null ? this.aNF : this.aND;
                        if (aVar6 != null || intValue < wVar.qh()) {
                            i4 = this.aNc.ac(aVar6 == null ? wVar.a(intValue, this.aMW, true).aNH : aVar6.aNH);
                            if (i4 == -1) {
                                a2 = a(intValue, wVar, this.aNc);
                                if (a2 == -1) {
                                    c(obj4, 0);
                                } else {
                                    a3 = dv(this.aNc.a(a2, this.aMW, false).aNV);
                                    i3 = ((Integer) a3.first).intValue();
                                    pX = ((Long) a3.second).longValue();
                                    this.aNc.a(i3, this.aMW, true);
                                    if (aVar6 != null) {
                                        obj2 = this.aMW.aNH;
                                        aVar6.aNL = aVar6.aNL.qd();
                                        aVar3 = aVar6;
                                        while (aVar3.aNN != null) {
                                            aVar3 = aVar3.aNN;
                                            if (aVar3.aNH.equals(obj2)) {
                                                aVar3.aNL = this.aNr.a(aVar3.aNL, i3);
                                            } else {
                                                aVar3.aNL = aVar3.aNL.qd();
                                            }
                                        }
                                    }
                                    bVar = new com.google.android.exoplayer2.source.i.b(i3);
                                    this.aNh = new b(bVar, a(bVar, pX));
                                }
                            } else {
                                if (i4 != intValue) {
                                    b bVar3 = this.aNh;
                                    b bVar4 = new b(bVar3.aNQ.em(i4), bVar3.aNR, bVar3.aNS);
                                    bVar4.aNT = bVar3.aNT;
                                    bVar4.aNU = bVar3.aNU;
                                    this.aNh = bVar4;
                                }
                                if (this.aNh.aNQ.sh()) {
                                    g = this.aNr.g(i4, this.aNh.aNS);
                                    if (!(g.sh() && g.bhs == this.aNh.aNQ.bhs)) {
                                        this.aNh = new b(g, a(g, this.aNh.aNS), g.sh() ? this.aNh.aNS : -9223372036854775807L);
                                    }
                                }
                                if (aVar6 != null) {
                                    aVar = a(aVar6, i4);
                                    i3 = i4;
                                    while (aVar.aNN != null) {
                                        aVar4 = aVar.aNN;
                                        i3 = this.aNc.a(i3, this.aMW, this.aMV, this.repeatMode);
                                        if (i3 == -1 || !aVar4.aNH.equals(this.aNc.a(i3, this.aMW, true).aNH)) {
                                            obj = (this.aNE == null || this.aNE.index >= aVar4.index) ? null : 1;
                                            if (obj == null) {
                                                this.aNh = new b(this.aNF.aNL.aOx, a(this.aNF.aNL.aOx, this.aNh.aNT), this.aNh.aNS);
                                            } else {
                                                this.aND = aVar;
                                                this.aND.aNN = null;
                                                a(aVar4);
                                            }
                                        } else {
                                            aVar = a(aVar4, i3);
                                        }
                                    }
                                }
                            }
                        }
                        d(obj4, 0);
                    } else if (this.aNA > 0) {
                        a3 = a(this.aNB);
                        i4 = this.aNA;
                        this.aNA = 0;
                        this.aNB = null;
                        if (a3 == null) {
                            c(obj4, i4);
                        } else {
                            i3 = ((Integer) a3.first).intValue();
                            pX = ((Long) a3.second).longValue();
                            g = this.aNr.g(i3, pX);
                            if (g.sh()) {
                                longValue = 0;
                            } else {
                                longValue = pX;
                            }
                            this.aNh = new b(g, longValue, pX);
                            d(obj4, i4);
                        }
                    } else {
                        if (this.aNh.aNR == -9223372036854775807L) {
                            if (this.aNc.isEmpty()) {
                                c(obj4, 0);
                            } else {
                                a3 = dv(0);
                                i3 = ((Integer) a3.first).intValue();
                                pX = ((Long) a3.second).longValue();
                                g = this.aNr.g(i3, pX);
                                if (g.sh()) {
                                    longValue = 0;
                                } else {
                                    longValue = pX;
                                }
                                this.aNh = new b(g, longValue, pX);
                            }
                        }
                        d(obj4, 0);
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 8:
                    hVar = (com.google.android.exoplayer2.source.h) message.obj;
                    if (this.aND != null && this.aND.aNG == hVar) {
                        a aVar7 = this.aND;
                        aVar7.prepared = true;
                        aVar7.pZ();
                        longValue = aVar7.D(aVar7.aNL.aNR);
                        a = aVar7.aNL;
                        aVar7.aNL = new com.google.android.exoplayer2.n.a(a.aOx, longValue, a.aOy, a.aNS, a.aOz, a.aOA, a.aOB);
                        if (this.aNF == null) {
                            this.aNE = this.aND;
                            A(this.aNE.aNL.aNR);
                            b(this.aNE);
                        }
                        pW();
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 9:
                    hVar = (com.google.android.exoplayer2.source.h) message.obj;
                    if (this.aND != null && this.aND.aNG == hVar) {
                        pW();
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 10:
                    if (this.aNF != null) {
                        obj = 1;
                        aVar4 = this.aNF;
                        while (aVar4 != null && aVar4.prepared) {
                            if (aVar4.pZ()) {
                                if (obj != null) {
                                    z = this.aNE != this.aNF;
                                    a(this.aNF.aNN);
                                    this.aNF.aNN = null;
                                    this.aND = this.aNF;
                                    this.aNE = this.aNF;
                                    boolean[] zArr = new boolean[this.aMQ.length];
                                    rU = this.aNF.a(this.aNh.aNT, z, zArr);
                                    if (rU != this.aNh.aNT) {
                                        this.aNh.aNT = rU;
                                        A(rU);
                                    }
                                    a2 = 0;
                                    boolean[] zArr2 = new boolean[this.aMQ.length];
                                    for (i3 = 0; i3 < this.aMQ.length; i3++) {
                                        rVar4 = this.aMQ[i3];
                                        zArr2[i3] = rVar4.getState() != 0;
                                        l lVar2 = this.aNF.aNI[i3];
                                        if (lVar2 != null) {
                                            a2++;
                                        }
                                        if (zArr2[i3]) {
                                            if (lVar2 != rVar4.pE()) {
                                                if (rVar4 == this.aNs) {
                                                    if (lVar2 == null) {
                                                        this.aNo.a(this.aNt);
                                                    }
                                                    this.aNt = null;
                                                    this.aNs = null;
                                                }
                                                a(rVar4);
                                                rVar4.disable();
                                            } else if (zArr[i3]) {
                                                rVar4.v(this.aNC);
                                            }
                                        }
                                    }
                                    this.eventHandler.obtainMessage(3, aVar4.aNO).sendToTarget();
                                    b(zArr2, a2);
                                } else {
                                    this.aND = aVar4;
                                    for (aVar3 = this.aND.aNN; aVar3 != null; aVar3 = aVar3.aNN) {
                                        aVar3.release();
                                    }
                                    this.aND.aNN = null;
                                    if (this.aND.prepared) {
                                        this.aND.D(Math.max(this.aND.aNL.aNR, this.aNC - this.aND.pX()));
                                    }
                                }
                                pW();
                                pT();
                                this.handler.sendEmptyMessage(2);
                            } else {
                                if (aVar4 == this.aNE) {
                                    obj = null;
                                }
                                aVar4 = aVar4.aNN;
                            }
                        }
                    }
                    AppMethodBeat.o(94810);
                    return true;
                case 11:
                    c((com.google.android.exoplayer2.f.c[]) message.obj);
                    AppMethodBeat.o(94810);
                    return true;
                case 12:
                    intValue = message.arg1;
                    this.repeatMode = intValue;
                    this.aNr.repeatMode = intValue;
                    if (this.aNF != null) {
                        aVar3 = this.aNF;
                    } else {
                        aVar3 = this.aND;
                    }
                    if (aVar3 != null) {
                        while (true) {
                            i2 = this.aNc.a(aVar3.aNL.aOx.bhq, this.aMW, this.aMV, intValue);
                            aVar2 = aVar3;
                            while (aVar2.aNN != null && !aVar2.aNL.aOA) {
                                aVar2 = aVar2.aNN;
                            }
                            if (i2 == -1 || aVar2.aNN == null || aVar2.aNN.aNL.aOx.bhq != i2) {
                                i2 = this.aND.index;
                            } else {
                                aVar3 = aVar2.aNN;
                            }
                        }
                        i2 = this.aND.index;
                        if (this.aNE != null) {
                            intValue = this.aNE.index;
                        } else {
                            intValue = -1;
                        }
                        if (aVar2.aNN != null) {
                            a(aVar2.aNN);
                            aVar2.aNN = null;
                        }
                        nVar = this.aNr;
                        com.google.android.exoplayer2.n.a aVar8 = aVar2.aNL;
                        aVar2.aNL = nVar.a(aVar8, aVar8.aOx);
                        if ((i2 <= aVar2.index ? 1 : null) == null) {
                            this.aND = aVar2;
                        }
                        obj = (intValue == -1 || intValue > aVar2.index) ? null : 1;
                        if (obj == null && this.aNF != null) {
                            g = this.aNF.aNL.aOx;
                            this.aNh = new b(g, a(g, this.aNh.aNT), this.aNh.aNS);
                        }
                    }
                    AppMethodBeat.o(94810);
                    return true;
                default:
                    AppMethodBeat.o(94810);
                    return false;
            }
        } catch (e e) {
            this.eventHandler.obtainMessage(8, e).sendToTarget();
            pU();
            AppMethodBeat.o(94810);
            return true;
        } catch (IOException e2) {
            this.eventHandler.obtainMessage(8, e.a(e2)).sendToTarget();
            pU();
            AppMethodBeat.o(94810);
            return true;
        } catch (RuntimeException e3) {
            this.eventHandler.obtainMessage(8, e.a(e3)).sendToTarget();
            pU();
            AppMethodBeat.o(94810);
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.aNh = new b(g, longValue, pX);
            this.eventHandler.obtainMessage(4, i != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
            AppMethodBeat.o(94810);
        }
    }

    private void setState(int i) {
        AppMethodBeat.i(94811);
        if (this.state != i) {
            this.state = i;
            this.eventHandler.obtainMessage(1, i, 0).sendToTarget();
        }
        AppMethodBeat.o(94811);
    }

    private void aF(boolean z) {
        AppMethodBeat.i(94812);
        if (this.isLoading != z) {
            int i;
            this.isLoading = z;
            Handler handler = this.eventHandler;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(2, i, 0).sendToTarget();
        }
        AppMethodBeat.o(94812);
    }

    private void pR() {
        int i = 0;
        AppMethodBeat.i(94813);
        this.aNw = false;
        this.aNo.start();
        r[] rVarArr = this.aNv;
        int length = rVarArr.length;
        while (i < length) {
            rVarArr[i].start();
            i++;
        }
        AppMethodBeat.o(94813);
    }

    private void pS() {
        AppMethodBeat.i(94814);
        this.aNo.stop();
        for (r a : this.aNv) {
            a(a);
        }
        AppMethodBeat.o(94814);
    }

    private void pT() {
        AppMethodBeat.i(94815);
        if (this.aNF == null) {
            AppMethodBeat.o(94815);
            return;
        }
        long rT = this.aNF.aNG.rT();
        if (rT != -9223372036854775807L) {
            A(rT);
        } else {
            if (this.aNs == null || this.aNs.qf()) {
                this.aNC = this.aNo.qy();
            } else {
                this.aNC = this.aNt.qy();
                this.aNo.ai(this.aNC);
            }
            rT = this.aNC - this.aNF.pX();
        }
        this.aNh.aNT = rT;
        this.aNz = SystemClock.elapsedRealtime() * 1000;
        if (this.aNv.length == 0) {
            rT = Long.MIN_VALUE;
        } else {
            rT = this.aNF.aNG.rU();
        }
        b bVar = this.aNh;
        if (rT == Long.MIN_VALUE) {
            rT = this.aNF.aNL.aOz;
        }
        bVar.aNU = rT;
        AppMethodBeat.o(94815);
    }

    private void e(long j, long j2) {
        AppMethodBeat.i(94816);
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
            AppMethodBeat.o(94816);
            return;
        }
        this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        AppMethodBeat.o(94816);
    }

    private long a(com.google.android.exoplayer2.source.i.b bVar, long j) {
        a aVar;
        AppMethodBeat.i(94817);
        pS();
        this.aNw = false;
        setState(2);
        if (this.aNF != null) {
            a aVar2 = this.aNF;
            aVar = null;
            while (aVar2 != null) {
                if (aVar == null && a(bVar, j, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.release();
                }
                aVar2 = aVar2.aNN;
            }
        } else if (this.aND != null) {
            this.aND.release();
            aVar = null;
        } else {
            aVar = null;
        }
        if (!(this.aNF == aVar && this.aNF == this.aNE)) {
            for (r disable : this.aNv) {
                disable.disable();
            }
            this.aNv = new r[0];
            this.aNt = null;
            this.aNs = null;
            this.aNF = null;
        }
        if (aVar != null) {
            aVar.aNN = null;
            this.aND = aVar;
            this.aNE = aVar;
            b(aVar);
            if (this.aNF.aNM) {
                j = this.aNF.aNG.X(j);
            }
            A(j);
            pW();
        } else {
            this.aND = null;
            this.aNE = null;
            this.aNF = null;
            A(j);
        }
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(94817);
        return j;
    }

    private boolean a(com.google.android.exoplayer2.source.i.b bVar, long j, a aVar) {
        AppMethodBeat.i(94818);
        if (bVar.equals(aVar.aNL.aOx) && aVar.prepared) {
            this.aNc.a(aVar.aNL.aOx.bhq, this.aMW, false);
            int G = this.aMW.G(j);
            if (G == -1 || this.aMW.aPe[G] == aVar.aNL.aOy) {
                AppMethodBeat.o(94818);
                return true;
            }
        }
        AppMethodBeat.o(94818);
        return false;
    }

    private void A(long j) {
        long j2;
        AppMethodBeat.i(94819);
        if (this.aNF == null) {
            j2 = 60000000 + j;
        } else {
            j2 = this.aNF.pX() + j;
        }
        this.aNC = j2;
        this.aNo.ai(this.aNC);
        for (r v : this.aNv) {
            v.v(this.aNC);
        }
        AppMethodBeat.o(94819);
    }

    private void pU() {
        AppMethodBeat.i(94820);
        aG(true);
        this.aNn.onStopped();
        setState(1);
        AppMethodBeat.o(94820);
    }

    private void ms() {
        AppMethodBeat.i(94821);
        aG(true);
        this.aNn.pM();
        setState(1);
        synchronized (this) {
            try {
                this.released = true;
                notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(94821);
            }
        }
    }

    private void aG(boolean z) {
        AppMethodBeat.i(94822);
        this.handler.removeMessages(2);
        this.aNw = false;
        this.aNo.stop();
        this.aNt = null;
        this.aNs = null;
        this.aNC = 60000000;
        for (r rVar : this.aNv) {
            try {
                a(rVar);
                rVar.disable();
            } catch (e | RuntimeException e) {
            }
        }
        this.aNv = new r[0];
        a(this.aNF != null ? this.aNF : this.aND);
        this.aND = null;
        this.aNE = null;
        this.aNF = null;
        aF(false);
        if (z) {
            if (this.aNu != null) {
                this.aNu.rY();
                this.aNu = null;
            }
            this.aNr.aNc = null;
            this.aNc = null;
        }
        AppMethodBeat.o(94822);
    }

    private void c(com.google.android.exoplayer2.f.c[] cVarArr) {
        AppMethodBeat.i(94823);
        try {
            for (com.google.android.exoplayer2.f.c cVar : cVarArr) {
                cVar.aMN.c(cVar.aMO, cVar.aMP);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                try {
                    this.aNy++;
                    notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(94823);
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.aNy++;
                notifyAll();
            }
        } finally {
            while (true) {
            }
            AppMethodBeat.o(94823);
        }
    }

    private static void a(r rVar) {
        AppMethodBeat.i(94824);
        if (rVar.getState() == 2) {
            rVar.stop();
        }
        AppMethodBeat.o(94824);
    }

    private boolean B(long j) {
        AppMethodBeat.i(94825);
        if (j == -9223372036854775807L || this.aNh.aNT < j || (this.aNF.aNN != null && (this.aNF.aNN.prepared || this.aNF.aNN.aNL.aOx.sh()))) {
            AppMethodBeat.o(94825);
            return true;
        }
        AppMethodBeat.o(94825);
        return false;
    }

    private void pV() {
        AppMethodBeat.i(94826);
        if (!(this.aND == null || this.aND.prepared || (this.aNE != null && this.aNE.aNN != this.aND))) {
            r[] rVarArr = this.aNv;
            int length = rVarArr.length;
            int i = 0;
            while (i < length) {
                if (rVarArr[i].pF()) {
                    i++;
                } else {
                    AppMethodBeat.o(94826);
                    return;
                }
            }
            this.aND.aNG.rR();
        }
        AppMethodBeat.o(94826);
    }

    private a a(a aVar, int i) {
        AppMethodBeat.i(94827);
        while (true) {
            aVar.aNL = this.aNr.a(aVar.aNL, i);
            if (aVar.aNL.aOA || aVar.aNN == null) {
                AppMethodBeat.o(94827);
            } else {
                aVar = aVar.aNN;
            }
        }
        AppMethodBeat.o(94827);
        return aVar;
    }

    private void c(Object obj, int i) {
        AppMethodBeat.i(94828);
        this.aNh = new b(0);
        d(obj, i);
        this.aNh = new b(-9223372036854775807L);
        setState(4);
        aG(false);
        AppMethodBeat.o(94828);
    }

    private void d(Object obj, int i) {
        AppMethodBeat.i(94829);
        this.eventHandler.obtainMessage(6, new d(this.aNc, obj, this.aNh, i)).sendToTarget();
        AppMethodBeat.o(94829);
    }

    private int a(int i, w wVar, w wVar2) {
        AppMethodBeat.i(94830);
        int qh = wVar.qh();
        int i2 = -1;
        for (int i3 = 0; i3 < qh && i2 == -1; i3++) {
            i = wVar.a(i, this.aMW, this.aMV, this.repeatMode);
            if (i == -1) {
                break;
            }
            i2 = wVar2.ac(wVar.a(i, this.aMW, true).aNH);
        }
        AppMethodBeat.o(94830);
        return i2;
    }

    private Pair<Integer, Long> a(c cVar) {
        AppMethodBeat.i(94831);
        w wVar = cVar.aNc;
        if (wVar.isEmpty()) {
            wVar = this.aNc;
        }
        try {
            Pair<Integer, Long> a = wVar.a(this.aMV, this.aMW, cVar.aNV, cVar.aNW);
            if (this.aNc == wVar) {
                AppMethodBeat.o(94831);
                return a;
            }
            int ac = this.aNc.ac(wVar.a(((Integer) a.first).intValue(), this.aMW, true).aNH);
            Pair<Integer, Long> create;
            if (ac != -1) {
                create = Pair.create(Integer.valueOf(ac), a.second);
                AppMethodBeat.o(94831);
                return create;
            }
            int a2 = a(((Integer) a.first).intValue(), wVar, this.aNc);
            if (a2 != -1) {
                create = dv(this.aNc.a(a2, this.aMW, false).aNV);
                AppMethodBeat.o(94831);
                return create;
            }
            AppMethodBeat.o(94831);
            return null;
        } catch (IndexOutOfBoundsException e) {
            l lVar = new l(this.aNc, cVar.aNV, cVar.aNW);
            AppMethodBeat.o(94831);
            throw lVar;
        }
    }

    private Pair<Integer, Long> dv(int i) {
        AppMethodBeat.i(94832);
        Pair a = this.aNc.a(this.aMV, this.aMW, i, -9223372036854775807L);
        AppMethodBeat.o(94832);
        return a;
    }

    private void pW() {
        AppMethodBeat.i(94833);
        boolean y = this.aND.y(this.aNC);
        aF(y);
        if (y) {
            this.aND.C(this.aNC);
        }
        AppMethodBeat.o(94833);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(94834);
        while (aVar != null) {
            aVar.release();
            aVar = aVar.aNN;
        }
        AppMethodBeat.o(94834);
    }

    private void b(a aVar) {
        AppMethodBeat.i(94835);
        if (this.aNF == aVar) {
            AppMethodBeat.o(94835);
            return;
        }
        boolean[] zArr = new boolean[this.aMQ.length];
        int i = 0;
        int i2 = 0;
        while (i < this.aMQ.length) {
            boolean z;
            r rVar = this.aMQ[i];
            if (rVar.getState() != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
            f fVar = aVar.aNO.bpH.bpE[i];
            if (fVar != null) {
                i2++;
            }
            if (zArr[i] && (fVar == null || (rVar.pH() && rVar.pE() == this.aNF.aNI[i]))) {
                if (rVar == this.aNs) {
                    this.aNo.a(this.aNt);
                    this.aNt = null;
                    this.aNs = null;
                }
                a(rVar);
                rVar.disable();
            }
            i++;
        }
        this.aNF = aVar;
        this.eventHandler.obtainMessage(3, aVar.aNO).sendToTarget();
        b(zArr, i2);
        AppMethodBeat.o(94835);
    }

    private void b(boolean[] zArr, int i) {
        AppMethodBeat.i(94836);
        this.aNv = new r[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aMQ.length) {
                r rVar = this.aMQ[i4];
                f fVar = this.aNF.aNO.bpH.bpE[i4];
                if (fVar != null) {
                    int i5 = i2 + 1;
                    this.aNv[i2] = rVar;
                    if (rVar.getState() == 0) {
                        t tVar = this.aNF.aNO.bpI[i4];
                        Object obj = (this.aMY && this.state == 3) ? 1 : null;
                        boolean z = (zArr[i4] || obj == null) ? false : true;
                        Format[] formatArr = new Format[fVar.length()];
                        for (int i6 = 0; i6 < formatArr.length; i6++) {
                            formatArr[i6] = fVar.eG(i6);
                        }
                        rVar.a(tVar, formatArr, this.aNF.aNI[i4], this.aNC, z, this.aNF.pX());
                        com.google.android.exoplayer2.i.h pD = rVar.pD();
                        if (pD != null) {
                            if (this.aNt != null) {
                                e a = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                                AppMethodBeat.o(94836);
                                throw a;
                            }
                            this.aNt = pD;
                            this.aNs = rVar;
                            this.aNt.b(this.aNg);
                        }
                        if (obj != null) {
                            rVar.start();
                        }
                    }
                    i2 = i5;
                }
                i3 = i4 + 1;
            } else {
                AppMethodBeat.o(94836);
                return;
            }
        }
    }
}
