package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C25551n.C17683a;
import com.google.android.exoplayer2.C37253f.C37248c;
import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.C45054w.C17695b;
import com.google.android.exoplayer2.p109g.C17663i;
import com.google.android.exoplayer2.p109g.C25538h;
import com.google.android.exoplayer2.p109g.C25538h.C25539a;
import com.google.android.exoplayer2.p109g.C37259g;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p111i.C32063h;
import com.google.android.exoplayer2.p111i.C41618q;
import com.google.android.exoplayer2.p111i.C41619t;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C17685c;
import com.google.android.exoplayer2.source.C17688l;
import com.google.android.exoplayer2.source.C37279h;
import com.google.android.exoplayer2.source.C37279h.C37280a;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.source.C45052i.C37281a;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.i */
final class C45043i implements Callback, C25539a, C37280a, C37281a {
    private final C32069r[] aMQ;
    private final C25538h aMR;
    private final C17695b aMV;
    private final C17694a aMW;
    private boolean aMY;
    private int aNA;
    private C17674c aNB;
    private long aNC;
    private C17673a aND;
    private C17673a aNE;
    private C17673a aNF;
    private C45054w aNc;
    private C45045p aNg;
    private C25542b aNh;
    private final C8703s[] aNm;
    private final C8693m aNn;
    private final C41618q aNo;
    private final HandlerThread aNp;
    private final C37253f aNq;
    private final C25551n aNr;
    private C32069r aNs;
    private C32063h aNt;
    private C45052i aNu;
    private C32069r[] aNv;
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

    /* renamed from: com.google.android.exoplayer2.i$a */
    static final class C17673a {
        private final C32069r[] aMQ;
        private final C25538h aMR;
        public final C37279h aNG;
        public final Object aNH;
        public final C17688l[] aNI;
        public final boolean[] aNJ;
        public final long aNK;
        public C17683a aNL;
        public boolean aNM;
        public C17673a aNN;
        public C17663i aNO;
        private C17663i aNP;
        private final C8703s[] aNm;
        final C8693m aNn;
        private final C45052i aNu;
        public final int index;
        public boolean prepared;

        public C17673a(C32069r[] c32069rArr, C8703s[] c8703sArr, long j, C25538h c25538h, C8693m c8693m, C45052i c45052i, Object obj, int i, C17683a c17683a) {
            C37279h c17685c;
            AppMethodBeat.m2504i(94795);
            this.aMQ = c32069rArr;
            this.aNm = c8703sArr;
            this.aNK = j;
            this.aMR = c25538h;
            this.aNn = c8693m;
            this.aNu = c45052i;
            this.aNH = C45039a.checkNotNull(obj);
            this.index = i;
            this.aNL = c17683a;
            this.aNI = new C17688l[c32069rArr.length];
            this.aNJ = new boolean[c32069rArr.length];
            C37279h a = c45052i.mo42820a(c17683a.aOx, c8693m.mo19232pN());
            if (c17683a.aOy != Long.MIN_VALUE) {
                c17685c = new C17685c(a, true);
                c17685c.mo32389i(0, c17683a.aOy);
            } else {
                c17685c = a;
            }
            this.aNG = c17685c;
            AppMethodBeat.m2505o(94795);
        }

        /* renamed from: pX */
        public final long mo32365pX() {
            return this.index == 0 ? this.aNK : this.aNK - this.aNL.aNR;
        }

        /* renamed from: pY */
        public final boolean mo32366pY() {
            AppMethodBeat.m2504i(94796);
            if (!this.prepared || (this.aNM && this.aNG.mo19284rU() != Long.MIN_VALUE)) {
                AppMethodBeat.m2505o(94796);
                return false;
            }
            AppMethodBeat.m2505o(94796);
            return true;
        }

        /* renamed from: y */
        public final boolean mo32369y(long j) {
            long rV;
            AppMethodBeat.m2504i(94797);
            if (this.prepared) {
                rV = this.aNG.mo19285rV();
            } else {
                rV = 0;
            }
            if (rV == Long.MIN_VALUE) {
                AppMethodBeat.m2505o(94797);
                return false;
            }
            boolean y = this.aNn.mo19233y(rV - (j - mo32365pX()));
            AppMethodBeat.m2505o(94797);
            return y;
        }

        /* renamed from: pZ */
        public final boolean mo32367pZ() {
            AppMethodBeat.m2504i(94799);
            C17663i a = this.aMR.mo42792a(this.aNm, this.aNG.mo19282rS());
            if (a.mo32355a(this.aNP)) {
                AppMethodBeat.m2505o(94799);
                return false;
            }
            this.aNO = a;
            AppMethodBeat.m2505o(94799);
            return true;
        }

        /* renamed from: D */
        public final long mo32363D(long j) {
            AppMethodBeat.m2504i(94800);
            long a = mo32364a(j, false, new boolean[this.aMQ.length]);
            AppMethodBeat.m2505o(94800);
            return a;
        }

        /* renamed from: a */
        public final long mo32364a(long j, boolean z, boolean[] zArr) {
            int i;
            AppMethodBeat.m2504i(94801);
            C37259g c37259g = this.aNO.bpH;
            for (i = 0; i < c37259g.length; i++) {
                boolean[] zArr2 = this.aNJ;
                boolean z2 = !z && this.aNO.mo32356a(this.aNP, i);
                zArr2[i] = z2;
            }
            long a = this.aNG.mo19276a(c37259g.mo59500ti(), this.aNJ, this.aNI, zArr, j);
            this.aNP = this.aNO;
            this.aNM = false;
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aNI.length) {
                    if (this.aNI[i2] != null) {
                        C45039a.checkState(c37259g.bpE[i2] != null);
                        this.aNM = true;
                    } else {
                        C45039a.checkState(c37259g.bpE[i2] == null);
                    }
                    i = i2 + 1;
                } else {
                    this.aNn.mo19227a(this.aMQ, c37259g);
                    AppMethodBeat.m2505o(94801);
                    return a;
                }
            }
        }

        public final void release() {
            AppMethodBeat.m2504i(94802);
            try {
                if (this.aNL.aOy != Long.MIN_VALUE) {
                    this.aNu.mo42823b(((C17685c) this.aNG).aNG);
                    AppMethodBeat.m2505o(94802);
                    return;
                }
                this.aNu.mo42823b(this.aNG);
                AppMethodBeat.m2505o(94802);
            } catch (RuntimeException e) {
                AppMethodBeat.m2505o(94802);
            }
        }

        /* renamed from: C */
        public final void mo32362C(long j) {
            AppMethodBeat.m2504i(94798);
            this.aNG.mo19275Y(j - mo32365pX());
            AppMethodBeat.m2505o(94798);
        }
    }

    /* renamed from: com.google.android.exoplayer2.i$c */
    static final class C17674c {
        public final int aNV;
        public final long aNW;
        public final C45054w aNc;

        public C17674c(C45054w c45054w, int i, long j) {
            this.aNc = c45054w;
            this.aNV = i;
            this.aNW = j;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i$b */
    public static final class C25542b {
        public final C45051b aNQ;
        public final long aNR;
        public final long aNS;
        public volatile long aNT;
        public volatile long aNU;

        public C25542b(long j) {
            this(new C45051b(0), j);
            AppMethodBeat.m2504i(94803);
            AppMethodBeat.m2505o(94803);
        }

        public C25542b(C45051b c45051b, long j) {
            this(c45051b, j, -9223372036854775807L);
        }

        public C25542b(C45051b c45051b, long j, long j2) {
            this.aNQ = c45051b;
            this.aNR = j;
            this.aNS = j2;
            this.aNT = j;
            this.aNU = j;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i$d */
    public static final class C41616d {
        public final int aNX;
        public final C45054w aNc;
        public final Object aNd;
        public final C25542b aNh;

        public C41616d(C45054w c45054w, Object obj, C25542b c25542b, int i) {
            this.aNc = c45054w;
            this.aNd = obj;
            this.aNh = c25542b;
            this.aNX = i;
        }
    }

    public C45043i(C32069r[] c32069rArr, C25538h c25538h, C8693m c8693m, boolean z, int i, Handler handler, C25542b c25542b, C37253f c37253f) {
        AppMethodBeat.m2504i(94804);
        this.aMQ = c32069rArr;
        this.aMR = c25538h;
        this.aNn = c8693m;
        this.aMY = z;
        this.repeatMode = i;
        this.eventHandler = handler;
        this.aNh = c25542b;
        this.aNq = c37253f;
        this.aNm = new C8703s[c32069rArr.length];
        for (int i2 = 0; i2 < c32069rArr.length; i2++) {
            c32069rArr[i2].setIndex(i2);
            this.aNm[i2] = c32069rArr[i2].mo52404pC();
        }
        this.aNo = new C41618q();
        this.aNv = new C32069r[0];
        this.aMV = new C17695b();
        this.aMW = new C17694a();
        this.aNr = new C25551n();
        c25538h.bpF = this;
        this.aNg = C45045p.aOC;
        this.aNp = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.aNp.start();
        this.handler = new Handler(this.aNp.getLooper(), this);
        AppMethodBeat.m2505o(94804);
    }

    /* renamed from: a */
    public final void mo72555a(C45054w c45054w, int i, long j) {
        AppMethodBeat.m2504i(94805);
        this.handler.obtainMessage(3, new C17674c(c45054w, i, j)).sendToTarget();
        AppMethodBeat.m2505o(94805);
    }

    /* renamed from: b */
    public final synchronized void mo72556b(C37248c... c37248cArr) {
        AppMethodBeat.m2504i(94806);
        if (this.released) {
            AppMethodBeat.m2505o(94806);
        } else {
            int i = this.aNx;
            this.aNx = i + 1;
            this.handler.obtainMessage(11, c37248cArr).sendToTarget();
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
            AppMethodBeat.m2505o(94806);
        }
    }

    public final synchronized void release() {
        AppMethodBeat.m2504i(94807);
        if (this.released) {
            AppMethodBeat.m2505o(94807);
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
            AppMethodBeat.m2505o(94807);
        }
    }

    /* renamed from: a */
    public final void mo42822a(C45054w c45054w, Object obj) {
        AppMethodBeat.m2504i(94808);
        this.handler.obtainMessage(7, Pair.create(c45054w, obj)).sendToTarget();
        AppMethodBeat.m2505o(94808);
    }

    /* renamed from: a */
    public final void mo32388a(C37279h c37279h) {
        AppMethodBeat.m2504i(94809);
        this.handler.obtainMessage(8, c37279h).sendToTarget();
        AppMethodBeat.m2505o(94809);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:336:0x0810=Splitter:B:336:0x0810, B:96:0x022b=Splitter:B:96:0x022b} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0268 A:{LOOP_START, Catch:{ all -> 0x0881, e -> 0x008c, IOException -> 0x00dc, RuntimeException -> 0x010a }, LOOP:2: B:109:0x0268->B:113:0x0282} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x06e2 A:{Catch:{ all -> 0x0881, e -> 0x008c, IOException -> 0x00dc, RuntimeException -> 0x010a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(94810);
        long pX;
        long longValue;
        C45051b g;
        int i;
        try {
            Object obj;
            boolean z;
            C25551n c25551n;
            C17683a a;
            int a2;
            int i2;
            int intValue;
            C45051b c45051b;
            int i3;
            C17673a c17673a;
            C32069r c32069r;
            Object obj2;
            C17673a c17673a2;
            long rU;
            Pair a3;
            int i4;
            C17673a c17673a3;
            C17673a c17673a4;
            C37279h c37279h;
            switch (message.what) {
                case 0:
                    C45052i c45052i = (C45052i) message.obj;
                    if (message.arg1 != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    this.eventHandler.sendEmptyMessage(0);
                    m82600aG(true);
                    this.aNn.mo19230pL();
                    if (obj != null) {
                        this.aNh = new C25542b(-9223372036854775807L);
                    } else {
                        this.aNh = new C25542b(this.aNh.aNQ, this.aNh.aNT, this.aNh.aNS);
                    }
                    this.aNu = c45052i;
                    if (c45052i != null) {
                        c45052i.mo42821a(this.aNq, (C37281a) this);
                    }
                    setState(2);
                    this.handler.sendEmptyMessage(2);
                    AppMethodBeat.m2505o(94810);
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
                        m82610pS();
                        m82611pT();
                    } else if (this.state == 3) {
                        m82609pR();
                        this.handler.sendEmptyMessage(2);
                    } else if (this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 2:
                    Object obj3;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.aNc != null || this.aNu == null) {
                        if (this.aND == null) {
                            c25551n = this.aNr;
                            C25542b c25542b = this.aNh;
                            a = c25551n.mo42810a(c25542b.aNQ, c25542b.aNS, c25542b.aNR);
                        } else {
                            if (!this.aND.aNL.aOB && this.aND.mo32366pY() && this.aND.aNL.aOz != -9223372036854775807L && (this.aNF == null || this.aND.index - this.aNF.index != 100)) {
                                C25551n c25551n2 = this.aNr;
                                C17683a c17683a = this.aND.aNL;
                                pX = this.aND.mo32365pX();
                                long j = this.aNC;
                                if (c17683a.aOA) {
                                    a2 = c25551n2.aNc.mo72571a(c17683a.aOx.bhq, c25551n2.aMW, c25551n2.aMV, c25551n2.repeatMode);
                                    if (a2 == -1) {
                                        a = null;
                                    } else {
                                        i2 = c25551n2.aNc.mo42826a(a2, c25551n2.aMW, false).aNV;
                                        if (c25551n2.aNc.mo72574a(i2, c25551n2.aMV).aPo == a2) {
                                            Pair a4 = c25551n2.aNc.mo72573a(c25551n2.aMV, c25551n2.aMW, i2, -9223372036854775807L, Math.max(0, (c17683a.aOz + pX) - j));
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
                                        a = c25551n2.mo42810a(c25551n2.mo42813g(a2, longValue), longValue, longValue);
                                    }
                                } else {
                                    c45051b = c17683a.aOx;
                                    if (c45051b.mo72570sh()) {
                                        i3 = c45051b.bhr;
                                        c25551n2.aNc.mo42826a(c45051b.bhq, c25551n2.aMW, false);
                                        intValue = c25551n2.aMW.aPf[i3];
                                        if (intValue == -1) {
                                            a = null;
                                        } else {
                                            i2 = c45051b.bhs + 1;
                                            if (i2 >= intValue) {
                                                intValue = c25551n2.aMW.mo32395G(c17683a.aNS);
                                                if (intValue == -1) {
                                                    pX = Long.MIN_VALUE;
                                                } else {
                                                    pX = c25551n2.aMW.aPe[intValue];
                                                }
                                                a = c25551n2.mo42812c(c45051b.bhq, c17683a.aNS, pX);
                                            } else if (c25551n2.aMW.mo32396ba(i3, i2)) {
                                                a = c25551n2.mo42811b(c45051b.bhq, i3, i2, c17683a.aNS);
                                            } else {
                                                a = null;
                                            }
                                        }
                                    } else if (c17683a.aOy != Long.MIN_VALUE) {
                                        i3 = c25551n2.aMW.mo32394F(c17683a.aOy);
                                        if (c25551n2.aMW.mo32396ba(i3, 0)) {
                                            a = c25551n2.mo42811b(c45051b.bhq, i3, 0, c17683a.aOy);
                                        } else {
                                            a = null;
                                        }
                                    } else {
                                        i3 = c25551n2.aMW.mo32399qi();
                                        if (i3 != 0) {
                                            if (c25551n2.aMW.aPe[i3 - 1] == Long.MIN_VALUE && !c25551n2.aMW.mo32398dy(i3 - 1) && c25551n2.aMW.mo32396ba(i3 - 1, 0)) {
                                                a = c25551n2.mo42811b(c45051b.bhq, i3 - 1, 0, c25551n2.aMW.aOz);
                                            }
                                        }
                                        a = null;
                                    }
                                }
                            }
                            if (this.aND != null || this.aND.mo32366pY()) {
                                m82599aF(false);
                            } else if (!(this.aND == null || this.isLoading)) {
                                m82614pW();
                            }
                            if (this.aNF != null) {
                                while (this.aNF != this.aNE && this.aNC >= this.aNF.aNN.aNK) {
                                    this.aNF.release();
                                    m82601b(this.aNF.aNN);
                                    this.aNh = new C25542b(this.aNF.aNL.aOx, this.aNF.aNL.aNR, this.aNF.aNL.aNS);
                                    m82611pT();
                                    this.eventHandler.obtainMessage(5, this.aNh).sendToTarget();
                                }
                                C32069r c32069r2;
                                C17688l c17688l;
                                if (this.aNE.aNL.aOB) {
                                    for (a2 = 0; a2 < this.aMQ.length; a2++) {
                                        c32069r2 = this.aMQ[a2];
                                        c17688l = this.aNE.aNI[a2];
                                        if (c17688l != null && c32069r2.mo52406pE() == c17688l && c32069r2.mo52407pF()) {
                                            c32069r2.mo52408pG();
                                        }
                                    }
                                } else {
                                    a2 = 0;
                                    while (a2 < this.aMQ.length) {
                                        c32069r2 = this.aMQ[a2];
                                        c17688l = this.aNE.aNI[a2];
                                        if (c32069r2.mo52406pE() == c17688l && (c17688l == null || c32069r2.mo52407pF())) {
                                            a2++;
                                        }
                                    }
                                    if (this.aNE.aNN != null && this.aNE.aNN.prepared) {
                                        C17663i c17663i = this.aNE.aNO;
                                        this.aNE = this.aNE.aNN;
                                        C17663i c17663i2 = this.aNE.aNO;
                                        obj = this.aNE.aNG.mo19283rT() != -9223372036854775807L ? 1 : null;
                                        for (intValue = 0; intValue < this.aMQ.length; intValue++) {
                                            C32069r c32069r3 = this.aMQ[intValue];
                                            if (c17663i.bpH.bpE[intValue] != null) {
                                                if (obj == null) {
                                                    if (!c32069r3.mo52409pH()) {
                                                        C45035f c45035f = c17663i2.bpH.bpE[intValue];
                                                        obj3 = c17663i.bpI[intValue];
                                                        C0882t c0882t = c17663i2.bpI[intValue];
                                                        if (c45035f != null && c0882t.equals(obj3)) {
                                                            Format[] formatArr = new Format[c45035f.length()];
                                                            for (i3 = 0; i3 < formatArr.length; i3++) {
                                                                formatArr[i3] = c45035f.mo19197eG(i3);
                                                            }
                                                            c32069r3.mo52400a(formatArr, this.aNE.aNI[intValue], this.aNE.mo32365pX());
                                                        }
                                                    }
                                                }
                                                c32069r3.mo52408pG();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a == null) {
                            this.aNu.mo42824rX();
                        } else {
                            int i5;
                            if (this.aND == null) {
                                pX = 60000000;
                            } else {
                                pX = this.aND.mo32365pX() + this.aND.aNL.aOz;
                            }
                            if (this.aND == null) {
                                i5 = 0;
                            } else {
                                i5 = this.aND.index + 1;
                            }
                            c17673a = new C17673a(this.aMQ, this.aNm, pX, this.aMR, this.aNn, this.aNu, this.aNc.mo42826a(a.aOx.bhq, this.aMW, true).aNH, i5, a);
                            if (this.aND != null) {
                                this.aND.aNN = c17673a;
                            }
                            this.aND = c17673a;
                            this.aND.aNG.mo19278a(this, a.aNR);
                            m82599aF(true);
                        }
                        if (this.aND != null) {
                            break;
                        }
                        m82599aF(false);
                        if (this.aNF != null) {
                        }
                    } else {
                        this.aNu.mo42824rX();
                    }
                    if (this.aNF == null) {
                        m82613pV();
                        m82607e(elapsedRealtime, 10);
                    } else {
                        C41619t.beginSection("doSomeWork");
                        m82611pT();
                        this.aNF.aNG.mo19273W(this.aNh.aNT);
                        obj3 = 1;
                        z = true;
                        for (C32069r c32069r4 : this.aNv) {
                            c32069r4.mo32350f(this.aNC, this.aNz);
                            obj3 = (obj3 == null || !c32069r4.mo32354qf()) ? null : 1;
                            obj2 = (c32069r4.isReady() || c32069r4.mo32354qf()) ? 1 : null;
                            if (obj2 == null) {
                                c32069r4.mo52410pI();
                            }
                            if (!z || obj2 == null) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            m82613pV();
                        }
                        if (this.aNt != null) {
                            C45045p qC = this.aNt.mo52352qC();
                            if (!qC.equals(this.aNg)) {
                                this.aNg = qC;
                                this.aNo.mo66745a(this.aNt);
                                this.eventHandler.obtainMessage(7, qC).sendToTarget();
                            }
                        }
                        pX = this.aNF.aNL.aOz;
                        if (obj3 != null && ((pX == -9223372036854775807L || pX <= this.aNh.aNT) && this.aNF.aNL.aOB)) {
                            setState(4);
                            m82610pS();
                        } else if (this.state == 2) {
                            if (this.aNv.length > 0) {
                                if (z) {
                                    c17673a2 = this.aND;
                                    boolean z2 = this.aNw;
                                    pX = this.aNC;
                                    if (c17673a2.prepared) {
                                        rU = c17673a2.aNG.mo19284rU();
                                    } else {
                                        rU = c17673a2.aNL.aNR;
                                    }
                                    if (rU == Long.MIN_VALUE) {
                                        if (c17673a2.aNL.aOB) {
                                            z = true;
                                            if (z) {
                                                z = true;
                                            }
                                        } else {
                                            rU = c17673a2.aNL.aOz;
                                        }
                                    }
                                    z = c17673a2.aNn.mo19228c(rU - (pX - c17673a2.mo32365pX()), z2);
                                    if (z) {
                                    }
                                }
                                z = false;
                            } else {
                                z = m82591B(pX);
                            }
                            if (z) {
                                setState(3);
                                if (this.aMY) {
                                    m82609pR();
                                }
                            }
                        } else if (this.state == 3) {
                            if (this.aNv.length <= 0) {
                                z = m82591B(pX);
                            }
                            if (!z) {
                                this.aNw = this.aMY;
                                setState(2);
                                m82610pS();
                            }
                        }
                        if (this.state == 2) {
                            for (C32069r pI : this.aNv) {
                                pI.mo52410pI();
                            }
                        }
                        if ((this.aMY && this.state == 3) || this.state == 2) {
                            m82607e(elapsedRealtime, 10);
                        } else if (this.aNv.length == 0 || this.state == 4) {
                            this.handler.removeMessages(2);
                        } else {
                            m82607e(elapsedRealtime, 1000);
                        }
                        C41619t.endSection();
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 3:
                    C17674c c17674c = (C17674c) message.obj;
                    if (this.aNc == null) {
                        this.aNA++;
                        this.aNB = c17674c;
                    } else {
                        a3 = m82594a(c17674c);
                        if (a3 == null) {
                            this.aNh = new C25542b(0);
                            this.eventHandler.obtainMessage(4, 1, 0, this.aNh).sendToTarget();
                            this.aNh = new C25542b(-9223372036854775807L);
                            setState(4);
                            m82600aG(false);
                        } else {
                            i4 = c17674c.aNW == -9223372036854775807L ? 1 : 0;
                            i3 = ((Integer) a3.first).intValue();
                            pX = ((Long) a3.second).longValue();
                            g = this.aNr.mo42813g(i3, pX);
                            if (g.mo72570sh()) {
                                longValue = 0;
                                i = 1;
                            } else {
                                longValue = pX;
                                i = i4;
                            }
                            if (g.equals(this.aNh.aNQ) && longValue / 1000 == this.aNh.aNT / 1000) {
                                this.aNh = new C25542b(g, longValue, pX);
                                this.eventHandler.obtainMessage(4, i != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
                            } else {
                                long a5 = m82593a(g, longValue);
                                i4 = i | (longValue != a5 ? 1 : 0);
                                this.aNh = new C25542b(g, a5, pX);
                                this.eventHandler.obtainMessage(4, i4 != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
                            }
                        }
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 4:
                    C45045p c45045p = (C45045p) message.obj;
                    if (this.aNt != null) {
                        c45045p = this.aNt.mo52351b(c45045p);
                    } else {
                        c45045p = this.aNo.mo52351b(c45045p);
                    }
                    this.aNg = c45045p;
                    this.eventHandler.obtainMessage(7, c45045p).sendToTarget();
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 5:
                    m82612pU();
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 6:
                    m82608ms();
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 7:
                    Pair pair = (Pair) message.obj;
                    C45054w c45054w = this.aNc;
                    this.aNc = (C45054w) pair.first;
                    this.aNr.aNc = this.aNc;
                    Object obj4 = pair.second;
                    if (c45054w != null) {
                        intValue = this.aNh.aNQ.bhq;
                        C17673a c17673a5 = this.aNF != null ? this.aNF : this.aND;
                        if (c17673a5 != null || intValue < c45054w.mo42831qh()) {
                            i4 = this.aNc.mo42829ac(c17673a5 == null ? c45054w.mo42826a(intValue, this.aMW, true).aNH : c17673a5.aNH);
                            if (i4 == -1) {
                                a2 = m82592a(intValue, c45054w, this.aNc);
                                if (a2 == -1) {
                                    m82603c(obj4, 0);
                                } else {
                                    a3 = m82606dv(this.aNc.mo42826a(a2, this.aMW, false).aNV);
                                    i3 = ((Integer) a3.first).intValue();
                                    pX = ((Long) a3.second).longValue();
                                    this.aNc.mo42826a(i3, this.aMW, true);
                                    if (c17673a5 != null) {
                                        obj2 = this.aMW.aNH;
                                        c17673a5.aNL = c17673a5.aNL.mo32387qd();
                                        c17673a3 = c17673a5;
                                        while (c17673a3.aNN != null) {
                                            c17673a3 = c17673a3.aNN;
                                            if (c17673a3.aNH.equals(obj2)) {
                                                c17673a3.aNL = this.aNr.mo42808a(c17673a3.aNL, i3);
                                            } else {
                                                c17673a3.aNL = c17673a3.aNL.mo32387qd();
                                            }
                                        }
                                    }
                                    c45051b = new C45051b(i3);
                                    this.aNh = new C25542b(c45051b, m82593a(c45051b, pX));
                                }
                            } else {
                                if (i4 != intValue) {
                                    C25542b c25542b2 = this.aNh;
                                    C25542b c25542b3 = new C25542b(c25542b2.aNQ.mo72567em(i4), c25542b2.aNR, c25542b2.aNS);
                                    c25542b3.aNT = c25542b2.aNT;
                                    c25542b3.aNU = c25542b2.aNU;
                                    this.aNh = c25542b3;
                                }
                                if (this.aNh.aNQ.mo72570sh()) {
                                    g = this.aNr.mo42813g(i4, this.aNh.aNS);
                                    if (!(g.mo72570sh() && g.bhs == this.aNh.aNQ.bhs)) {
                                        this.aNh = new C25542b(g, m82593a(g, this.aNh.aNS), g.mo72570sh() ? this.aNh.aNS : -9223372036854775807L);
                                    }
                                }
                                if (c17673a5 != null) {
                                    c17673a = m82595a(c17673a5, i4);
                                    i3 = i4;
                                    while (c17673a.aNN != null) {
                                        c17673a4 = c17673a.aNN;
                                        i3 = this.aNc.mo72571a(i3, this.aMW, this.aMV, this.repeatMode);
                                        if (i3 == -1 || !c17673a4.aNH.equals(this.aNc.mo42826a(i3, this.aMW, true).aNH)) {
                                            obj = (this.aNE == null || this.aNE.index >= c17673a4.index) ? null : 1;
                                            if (obj == null) {
                                                this.aNh = new C25542b(this.aNF.aNL.aOx, m82593a(this.aNF.aNL.aOx, this.aNh.aNT), this.aNh.aNS);
                                            } else {
                                                this.aND = c17673a;
                                                this.aND.aNN = null;
                                                C45043i.m82596a(c17673a4);
                                            }
                                        } else {
                                            c17673a = m82595a(c17673a4, i3);
                                        }
                                    }
                                }
                            }
                        }
                        m82605d(obj4, 0);
                    } else if (this.aNA > 0) {
                        a3 = m82594a(this.aNB);
                        i4 = this.aNA;
                        this.aNA = 0;
                        this.aNB = null;
                        if (a3 == null) {
                            m82603c(obj4, i4);
                        } else {
                            i3 = ((Integer) a3.first).intValue();
                            pX = ((Long) a3.second).longValue();
                            g = this.aNr.mo42813g(i3, pX);
                            if (g.mo72570sh()) {
                                longValue = 0;
                            } else {
                                longValue = pX;
                            }
                            this.aNh = new C25542b(g, longValue, pX);
                            m82605d(obj4, i4);
                        }
                    } else {
                        if (this.aNh.aNR == -9223372036854775807L) {
                            if (this.aNc.isEmpty()) {
                                m82603c(obj4, 0);
                            } else {
                                a3 = m82606dv(0);
                                i3 = ((Integer) a3.first).intValue();
                                pX = ((Long) a3.second).longValue();
                                g = this.aNr.mo42813g(i3, pX);
                                if (g.mo72570sh()) {
                                    longValue = 0;
                                } else {
                                    longValue = pX;
                                }
                                this.aNh = new C25542b(g, longValue, pX);
                            }
                        }
                        m82605d(obj4, 0);
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 8:
                    c37279h = (C37279h) message.obj;
                    if (this.aND != null && this.aND.aNG == c37279h) {
                        C17673a c17673a6 = this.aND;
                        c17673a6.prepared = true;
                        c17673a6.mo32367pZ();
                        longValue = c17673a6.mo32363D(c17673a6.aNL.aNR);
                        a = c17673a6.aNL;
                        c17673a6.aNL = new C17683a(a.aOx, longValue, a.aOy, a.aNS, a.aOz, a.aOA, a.aOB);
                        if (this.aNF == null) {
                            this.aNE = this.aND;
                            m82590A(this.aNE.aNL.aNR);
                            m82601b(this.aNE);
                        }
                        m82614pW();
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 9:
                    c37279h = (C37279h) message.obj;
                    if (this.aND != null && this.aND.aNG == c37279h) {
                        m82614pW();
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 10:
                    if (this.aNF != null) {
                        obj = 1;
                        c17673a4 = this.aNF;
                        while (c17673a4 != null && c17673a4.prepared) {
                            if (c17673a4.mo32367pZ()) {
                                if (obj != null) {
                                    z = this.aNE != this.aNF;
                                    C45043i.m82596a(this.aNF.aNN);
                                    this.aNF.aNN = null;
                                    this.aND = this.aNF;
                                    this.aNE = this.aNF;
                                    boolean[] zArr = new boolean[this.aMQ.length];
                                    rU = this.aNF.mo32364a(this.aNh.aNT, z, zArr);
                                    if (rU != this.aNh.aNT) {
                                        this.aNh.aNT = rU;
                                        m82590A(rU);
                                    }
                                    a2 = 0;
                                    boolean[] zArr2 = new boolean[this.aMQ.length];
                                    for (i3 = 0; i3 < this.aMQ.length; i3++) {
                                        c32069r4 = this.aMQ[i3];
                                        zArr2[i3] = c32069r4.getState() != 0;
                                        C17688l c17688l2 = this.aNF.aNI[i3];
                                        if (c17688l2 != null) {
                                            a2++;
                                        }
                                        if (zArr2[i3]) {
                                            if (c17688l2 != c32069r4.mo52406pE()) {
                                                if (c32069r4 == this.aNs) {
                                                    if (c17688l2 == null) {
                                                        this.aNo.mo66745a(this.aNt);
                                                    }
                                                    this.aNt = null;
                                                    this.aNs = null;
                                                }
                                                C45043i.m82597a(c32069r4);
                                                c32069r4.disable();
                                            } else if (zArr[i3]) {
                                                c32069r4.mo52414v(this.aNC);
                                            }
                                        }
                                    }
                                    this.eventHandler.obtainMessage(3, c17673a4.aNO).sendToTarget();
                                    m82602b(zArr2, a2);
                                } else {
                                    this.aND = c17673a4;
                                    for (c17673a3 = this.aND.aNN; c17673a3 != null; c17673a3 = c17673a3.aNN) {
                                        c17673a3.release();
                                    }
                                    this.aND.aNN = null;
                                    if (this.aND.prepared) {
                                        this.aND.mo32363D(Math.max(this.aND.aNL.aNR, this.aNC - this.aND.mo32365pX()));
                                    }
                                }
                                m82614pW();
                                m82611pT();
                                this.handler.sendEmptyMessage(2);
                            } else {
                                if (c17673a4 == this.aNE) {
                                    obj = null;
                                }
                                c17673a4 = c17673a4.aNN;
                            }
                        }
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 11:
                    m82604c((C37248c[]) message.obj);
                    AppMethodBeat.m2505o(94810);
                    return true;
                case 12:
                    intValue = message.arg1;
                    this.repeatMode = intValue;
                    this.aNr.repeatMode = intValue;
                    if (this.aNF != null) {
                        c17673a3 = this.aNF;
                    } else {
                        c17673a3 = this.aND;
                    }
                    if (c17673a3 != null) {
                        while (true) {
                            i2 = this.aNc.mo72571a(c17673a3.aNL.aOx.bhq, this.aMW, this.aMV, intValue);
                            c17673a2 = c17673a3;
                            while (c17673a2.aNN != null && !c17673a2.aNL.aOA) {
                                c17673a2 = c17673a2.aNN;
                            }
                            if (i2 == -1 || c17673a2.aNN == null || c17673a2.aNN.aNL.aOx.bhq != i2) {
                                i2 = this.aND.index;
                            } else {
                                c17673a3 = c17673a2.aNN;
                            }
                        }
                        i2 = this.aND.index;
                        if (this.aNE != null) {
                            intValue = this.aNE.index;
                        } else {
                            intValue = -1;
                        }
                        if (c17673a2.aNN != null) {
                            C45043i.m82596a(c17673a2.aNN);
                            c17673a2.aNN = null;
                        }
                        c25551n = this.aNr;
                        C17683a c17683a2 = c17673a2.aNL;
                        c17673a2.aNL = c25551n.mo42809a(c17683a2, c17683a2.aOx);
                        if ((i2 <= c17673a2.index ? 1 : null) == null) {
                            this.aND = c17673a2;
                        }
                        obj = (intValue == -1 || intValue > c17673a2.index) ? null : 1;
                        if (obj == null && this.aNF != null) {
                            g = this.aNF.aNL.aOx;
                            this.aNh = new C25542b(g, m82593a(g, this.aNh.aNT), this.aNh.aNS);
                        }
                    }
                    AppMethodBeat.m2505o(94810);
                    return true;
                default:
                    AppMethodBeat.m2505o(94810);
                    return false;
            }
        } catch (C25533e e) {
            this.eventHandler.obtainMessage(8, e).sendToTarget();
            m82612pU();
            AppMethodBeat.m2505o(94810);
            return true;
        } catch (IOException e2) {
            this.eventHandler.obtainMessage(8, C25533e.m40356a(e2)).sendToTarget();
            m82612pU();
            AppMethodBeat.m2505o(94810);
            return true;
        } catch (RuntimeException e3) {
            this.eventHandler.obtainMessage(8, C25533e.m40357a(e3)).sendToTarget();
            m82612pU();
            AppMethodBeat.m2505o(94810);
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.aNh = new C25542b(g, longValue, pX);
            this.eventHandler.obtainMessage(4, i != 0 ? 1 : 0, 0, this.aNh).sendToTarget();
            AppMethodBeat.m2505o(94810);
        }
    }

    private void setState(int i) {
        AppMethodBeat.m2504i(94811);
        if (this.state != i) {
            this.state = i;
            this.eventHandler.obtainMessage(1, i, 0).sendToTarget();
        }
        AppMethodBeat.m2505o(94811);
    }

    /* renamed from: aF */
    private void m82599aF(boolean z) {
        AppMethodBeat.m2504i(94812);
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
        AppMethodBeat.m2505o(94812);
    }

    /* renamed from: pR */
    private void m82609pR() {
        int i = 0;
        AppMethodBeat.m2504i(94813);
        this.aNw = false;
        this.aNo.start();
        C32069r[] c32069rArr = this.aNv;
        int length = c32069rArr.length;
        while (i < length) {
            c32069rArr[i].start();
            i++;
        }
        AppMethodBeat.m2505o(94813);
    }

    /* renamed from: pS */
    private void m82610pS() {
        AppMethodBeat.m2504i(94814);
        this.aNo.stop();
        for (C32069r a : this.aNv) {
            C45043i.m82597a(a);
        }
        AppMethodBeat.m2505o(94814);
    }

    /* renamed from: pT */
    private void m82611pT() {
        AppMethodBeat.m2504i(94815);
        if (this.aNF == null) {
            AppMethodBeat.m2505o(94815);
            return;
        }
        long rT = this.aNF.aNG.mo19283rT();
        if (rT != -9223372036854775807L) {
            m82590A(rT);
        } else {
            if (this.aNs == null || this.aNs.mo32354qf()) {
                this.aNC = this.aNo.mo52353qy();
            } else {
                this.aNC = this.aNt.mo52353qy();
                this.aNo.mo66746ai(this.aNC);
            }
            rT = this.aNC - this.aNF.mo32365pX();
        }
        this.aNh.aNT = rT;
        this.aNz = SystemClock.elapsedRealtime() * 1000;
        if (this.aNv.length == 0) {
            rT = Long.MIN_VALUE;
        } else {
            rT = this.aNF.aNG.mo19284rU();
        }
        C25542b c25542b = this.aNh;
        if (rT == Long.MIN_VALUE) {
            rT = this.aNF.aNL.aOz;
        }
        c25542b.aNU = rT;
        AppMethodBeat.m2505o(94815);
    }

    /* renamed from: e */
    private void m82607e(long j, long j2) {
        AppMethodBeat.m2504i(94816);
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
            AppMethodBeat.m2505o(94816);
            return;
        }
        this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        AppMethodBeat.m2505o(94816);
    }

    /* renamed from: a */
    private long m82593a(C45051b c45051b, long j) {
        C17673a c17673a;
        AppMethodBeat.m2504i(94817);
        m82610pS();
        this.aNw = false;
        setState(2);
        if (this.aNF != null) {
            C17673a c17673a2 = this.aNF;
            c17673a = null;
            while (c17673a2 != null) {
                if (c17673a == null && m82598a(c45051b, j, c17673a2)) {
                    c17673a = c17673a2;
                } else {
                    c17673a2.release();
                }
                c17673a2 = c17673a2.aNN;
            }
        } else if (this.aND != null) {
            this.aND.release();
            c17673a = null;
        } else {
            c17673a = null;
        }
        if (!(this.aNF == c17673a && this.aNF == this.aNE)) {
            for (C32069r disable : this.aNv) {
                disable.disable();
            }
            this.aNv = new C32069r[0];
            this.aNt = null;
            this.aNs = null;
            this.aNF = null;
        }
        if (c17673a != null) {
            c17673a.aNN = null;
            this.aND = c17673a;
            this.aNE = c17673a;
            m82601b(c17673a);
            if (this.aNF.aNM) {
                j = this.aNF.aNG.mo19274X(j);
            }
            m82590A(j);
            m82614pW();
        } else {
            this.aND = null;
            this.aNE = null;
            this.aNF = null;
            m82590A(j);
        }
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.m2505o(94817);
        return j;
    }

    /* renamed from: a */
    private boolean m82598a(C45051b c45051b, long j, C17673a c17673a) {
        AppMethodBeat.m2504i(94818);
        if (c45051b.equals(c17673a.aNL.aOx) && c17673a.prepared) {
            this.aNc.mo42826a(c17673a.aNL.aOx.bhq, this.aMW, false);
            int G = this.aMW.mo32395G(j);
            if (G == -1 || this.aMW.aPe[G] == c17673a.aNL.aOy) {
                AppMethodBeat.m2505o(94818);
                return true;
            }
        }
        AppMethodBeat.m2505o(94818);
        return false;
    }

    /* renamed from: A */
    private void m82590A(long j) {
        long j2;
        AppMethodBeat.m2504i(94819);
        if (this.aNF == null) {
            j2 = 60000000 + j;
        } else {
            j2 = this.aNF.mo32365pX() + j;
        }
        this.aNC = j2;
        this.aNo.mo66746ai(this.aNC);
        for (C32069r v : this.aNv) {
            v.mo52414v(this.aNC);
        }
        AppMethodBeat.m2505o(94819);
    }

    /* renamed from: pU */
    private void m82612pU() {
        AppMethodBeat.m2504i(94820);
        m82600aG(true);
        this.aNn.onStopped();
        setState(1);
        AppMethodBeat.m2505o(94820);
    }

    /* renamed from: ms */
    private void m82608ms() {
        AppMethodBeat.m2504i(94821);
        m82600aG(true);
        this.aNn.mo19231pM();
        setState(1);
        synchronized (this) {
            try {
                this.released = true;
                notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(94821);
            }
        }
    }

    /* renamed from: aG */
    private void m82600aG(boolean z) {
        AppMethodBeat.m2504i(94822);
        this.handler.removeMessages(2);
        this.aNw = false;
        this.aNo.stop();
        this.aNt = null;
        this.aNs = null;
        this.aNC = 60000000;
        for (C32069r c32069r : this.aNv) {
            try {
                C45043i.m82597a(c32069r);
                c32069r.disable();
            } catch (C25533e | RuntimeException e) {
            }
        }
        this.aNv = new C32069r[0];
        C45043i.m82596a(this.aNF != null ? this.aNF : this.aND);
        this.aND = null;
        this.aNE = null;
        this.aNF = null;
        m82599aF(false);
        if (z) {
            if (this.aNu != null) {
                this.aNu.mo42825rY();
                this.aNu = null;
            }
            this.aNr.aNc = null;
            this.aNc = null;
        }
        AppMethodBeat.m2505o(94822);
    }

    /* renamed from: c */
    private void m82604c(C37248c[] c37248cArr) {
        AppMethodBeat.m2504i(94823);
        try {
            for (C37248c c37248c : c37248cArr) {
                c37248c.aMN.mo59463c(c37248c.aMO, c37248c.aMP);
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
                    AppMethodBeat.m2505o(94823);
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
            AppMethodBeat.m2505o(94823);
        }
    }

    /* renamed from: a */
    private static void m82597a(C32069r c32069r) {
        AppMethodBeat.m2504i(94824);
        if (c32069r.getState() == 2) {
            c32069r.stop();
        }
        AppMethodBeat.m2505o(94824);
    }

    /* renamed from: B */
    private boolean m82591B(long j) {
        AppMethodBeat.m2504i(94825);
        if (j == -9223372036854775807L || this.aNh.aNT < j || (this.aNF.aNN != null && (this.aNF.aNN.prepared || this.aNF.aNN.aNL.aOx.mo72570sh()))) {
            AppMethodBeat.m2505o(94825);
            return true;
        }
        AppMethodBeat.m2505o(94825);
        return false;
    }

    /* renamed from: pV */
    private void m82613pV() {
        AppMethodBeat.m2504i(94826);
        if (!(this.aND == null || this.aND.prepared || (this.aNE != null && this.aNE.aNN != this.aND))) {
            C32069r[] c32069rArr = this.aNv;
            int length = c32069rArr.length;
            int i = 0;
            while (i < length) {
                if (c32069rArr[i].mo52407pF()) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(94826);
                    return;
                }
            }
            this.aND.aNG.mo19281rR();
        }
        AppMethodBeat.m2505o(94826);
    }

    /* renamed from: a */
    private C17673a m82595a(C17673a c17673a, int i) {
        AppMethodBeat.m2504i(94827);
        while (true) {
            c17673a.aNL = this.aNr.mo42808a(c17673a.aNL, i);
            if (c17673a.aNL.aOA || c17673a.aNN == null) {
                AppMethodBeat.m2505o(94827);
            } else {
                c17673a = c17673a.aNN;
            }
        }
        AppMethodBeat.m2505o(94827);
        return c17673a;
    }

    /* renamed from: c */
    private void m82603c(Object obj, int i) {
        AppMethodBeat.m2504i(94828);
        this.aNh = new C25542b(0);
        m82605d(obj, i);
        this.aNh = new C25542b(-9223372036854775807L);
        setState(4);
        m82600aG(false);
        AppMethodBeat.m2505o(94828);
    }

    /* renamed from: d */
    private void m82605d(Object obj, int i) {
        AppMethodBeat.m2504i(94829);
        this.eventHandler.obtainMessage(6, new C41616d(this.aNc, obj, this.aNh, i)).sendToTarget();
        AppMethodBeat.m2505o(94829);
    }

    /* renamed from: a */
    private int m82592a(int i, C45054w c45054w, C45054w c45054w2) {
        AppMethodBeat.m2504i(94830);
        int qh = c45054w.mo42831qh();
        int i2 = -1;
        for (int i3 = 0; i3 < qh && i2 == -1; i3++) {
            i = c45054w.mo72571a(i, this.aMW, this.aMV, this.repeatMode);
            if (i == -1) {
                break;
            }
            i2 = c45054w2.mo42829ac(c45054w.mo42826a(i, this.aMW, true).aNH);
        }
        AppMethodBeat.m2505o(94830);
        return i2;
    }

    /* renamed from: a */
    private Pair<Integer, Long> m82594a(C17674c c17674c) {
        AppMethodBeat.m2504i(94831);
        C45054w c45054w = c17674c.aNc;
        if (c45054w.isEmpty()) {
            c45054w = this.aNc;
        }
        try {
            Pair<Integer, Long> a = c45054w.mo72572a(this.aMV, this.aMW, c17674c.aNV, c17674c.aNW);
            if (this.aNc == c45054w) {
                AppMethodBeat.m2505o(94831);
                return a;
            }
            int ac = this.aNc.mo42829ac(c45054w.mo42826a(((Integer) a.first).intValue(), this.aMW, true).aNH);
            Pair<Integer, Long> create;
            if (ac != -1) {
                create = Pair.create(Integer.valueOf(ac), a.second);
                AppMethodBeat.m2505o(94831);
                return create;
            }
            int a2 = m82592a(((Integer) a.first).intValue(), c45054w, this.aNc);
            if (a2 != -1) {
                create = m82606dv(this.aNc.mo42826a(a2, this.aMW, false).aNV);
                AppMethodBeat.m2505o(94831);
                return create;
            }
            AppMethodBeat.m2505o(94831);
            return null;
        } catch (IndexOutOfBoundsException e) {
            C25545l c25545l = new C25545l(this.aNc, c17674c.aNV, c17674c.aNW);
            AppMethodBeat.m2505o(94831);
            throw c25545l;
        }
    }

    /* renamed from: dv */
    private Pair<Integer, Long> m82606dv(int i) {
        AppMethodBeat.m2504i(94832);
        Pair a = this.aNc.mo72572a(this.aMV, this.aMW, i, -9223372036854775807L);
        AppMethodBeat.m2505o(94832);
        return a;
    }

    /* renamed from: pW */
    private void m82614pW() {
        AppMethodBeat.m2504i(94833);
        boolean y = this.aND.mo32369y(this.aNC);
        m82599aF(y);
        if (y) {
            this.aND.mo32362C(this.aNC);
        }
        AppMethodBeat.m2505o(94833);
    }

    /* renamed from: a */
    private static void m82596a(C17673a c17673a) {
        AppMethodBeat.m2504i(94834);
        while (c17673a != null) {
            c17673a.release();
            c17673a = c17673a.aNN;
        }
        AppMethodBeat.m2505o(94834);
    }

    /* renamed from: b */
    private void m82601b(C17673a c17673a) {
        AppMethodBeat.m2504i(94835);
        if (this.aNF == c17673a) {
            AppMethodBeat.m2505o(94835);
            return;
        }
        boolean[] zArr = new boolean[this.aMQ.length];
        int i = 0;
        int i2 = 0;
        while (i < this.aMQ.length) {
            boolean z;
            C32069r c32069r = this.aMQ[i];
            if (c32069r.getState() != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
            C45035f c45035f = c17673a.aNO.bpH.bpE[i];
            if (c45035f != null) {
                i2++;
            }
            if (zArr[i] && (c45035f == null || (c32069r.mo52409pH() && c32069r.mo52406pE() == this.aNF.aNI[i]))) {
                if (c32069r == this.aNs) {
                    this.aNo.mo66745a(this.aNt);
                    this.aNt = null;
                    this.aNs = null;
                }
                C45043i.m82597a(c32069r);
                c32069r.disable();
            }
            i++;
        }
        this.aNF = c17673a;
        this.eventHandler.obtainMessage(3, c17673a.aNO).sendToTarget();
        m82602b(zArr, i2);
        AppMethodBeat.m2505o(94835);
    }

    /* renamed from: b */
    private void m82602b(boolean[] zArr, int i) {
        AppMethodBeat.m2504i(94836);
        this.aNv = new C32069r[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aMQ.length) {
                C32069r c32069r = this.aMQ[i4];
                C45035f c45035f = this.aNF.aNO.bpH.bpE[i4];
                if (c45035f != null) {
                    int i5 = i2 + 1;
                    this.aNv[i2] = c32069r;
                    if (c32069r.getState() == 0) {
                        C0882t c0882t = this.aNF.aNO.bpI[i4];
                        Object obj = (this.aMY && this.state == 3) ? 1 : null;
                        boolean z = (zArr[i4] || obj == null) ? false : true;
                        Format[] formatArr = new Format[c45035f.length()];
                        for (int i6 = 0; i6 < formatArr.length; i6++) {
                            formatArr[i6] = c45035f.mo19197eG(i6);
                        }
                        c32069r.mo52399a(c0882t, formatArr, this.aNF.aNI[i4], this.aNC, z, this.aNF.mo32365pX());
                        C32063h pD = c32069r.mo52405pD();
                        if (pD != null) {
                            if (this.aNt != null) {
                                C25533e a = C25533e.m40357a(new IllegalStateException("Multiple renderer media clocks enabled."));
                                AppMethodBeat.m2505o(94836);
                                throw a;
                            }
                            this.aNt = pD;
                            this.aNs = c32069r;
                            this.aNt.mo52351b(this.aNg);
                        }
                        if (obj != null) {
                            c32069r.start();
                        }
                    }
                    i2 = i5;
                }
                i3 = i4 + 1;
            } else {
                AppMethodBeat.m2505o(94836);
                return;
            }
        }
    }
}
