package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.f.a;
import com.bumptech.glide.f.b;
import com.bumptech.glide.f.c;
import com.bumptech.glide.f.d;
import com.bumptech.glide.f.e;
import com.bumptech.glide.f.g;
import com.bumptech.glide.f.h;
import com.bumptech.glide.h.j;
import com.bumptech.glide.manager.n;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class i<TranscodeType> implements Cloneable {
    protected static final e awW = new e().b(com.bumptech.glide.c.b.i.aBk).b(g.LOW).nQ();
    private final j awX;
    private final Class<TranscodeType> awY;
    protected e awZ;
    private final c awc;
    private final e awi;
    private final e awv;
    private k<?, ? super TranscodeType> axa;
    private Object axb;
    private d<TranscodeType> axc;
    private i<TranscodeType> axd;
    private i<TranscodeType> axe;
    private Float axf;
    private boolean axg = true;
    private boolean axh;
    private boolean axi;
    private final Context context;

    /* renamed from: com.bumptech.glide.i$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xU = new int[ScaleType.values().length];

        static {
            AppMethodBeat.i(91637);
            axj = new int[g.values().length];
            try {
                axj[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                axj[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                axj[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                axj[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                xU[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                xU[ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                xU[ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                xU[ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                xU[ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                xU[ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                xU[ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                xU[ScaleType.MATRIX.ordinal()] = 8;
                AppMethodBeat.o(91637);
            } catch (NoSuchFieldError e12) {
                AppMethodBeat.o(91637);
            }
        }
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(91647);
        i lH = lH();
        AppMethodBeat.o(91647);
        return lH;
    }

    static {
        AppMethodBeat.i(91648);
        AppMethodBeat.o(91648);
    }

    protected i(c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        AppMethodBeat.i(91638);
        this.awc = cVar;
        this.awX = jVar;
        this.awY = cls;
        this.awv = jVar.awZ;
        this.context = context;
        this.axa = jVar.k(cls);
        this.awZ = this.awv;
        this.awi = cVar.awi;
        AppMethodBeat.o(91638);
    }

    private e lG() {
        AppMethodBeat.i(91640);
        e nR;
        if (this.awv == this.awZ) {
            nR = this.awZ.nR();
            AppMethodBeat.o(91640);
            return nR;
        }
        nR = this.awZ;
        AppMethodBeat.o(91640);
        return nR;
    }

    private i<TranscodeType> lH() {
        AppMethodBeat.i(91641);
        try {
            i iVar = (i) super.clone();
            iVar.awZ = iVar.awZ.nR();
            iVar.axa = iVar.axa.clone();
            AppMethodBeat.o(91641);
            return iVar;
        } catch (CloneNotSupportedException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(91641);
            throw runtimeException;
        }
    }

    private g a(g gVar) {
        AppMethodBeat.i(91643);
        g gVar2;
        switch (gVar) {
            case LOW:
                gVar2 = g.NORMAL;
                AppMethodBeat.o(91643);
                return gVar2;
            case NORMAL:
                gVar2 = g.HIGH;
                AppMethodBeat.o(91643);
                return gVar2;
            case HIGH:
            case IMMEDIATE:
                gVar2 = g.IMMEDIATE;
                AppMethodBeat.o(91643);
                return gVar2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown priority: " + this.awZ.aAk);
                AppMethodBeat.o(91643);
                throw illegalArgumentException;
        }
    }

    private b a(com.bumptech.glide.f.a.e<TranscodeType> eVar, d<TranscodeType> dVar, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, e eVar2) {
        b bVar;
        c cVar2;
        AppMethodBeat.i(91644);
        if (this.axe != null) {
            a aVar = new a(cVar);
            bVar = aVar;
            cVar2 = aVar;
        } else {
            bVar = null;
            cVar2 = cVar;
        }
        b b = b(eVar, dVar, cVar2, kVar, gVar, i, i2, eVar2);
        if (bVar == null) {
            AppMethodBeat.o(91644);
            return b;
        }
        int i3 = this.axe.awZ.aHp;
        int i4 = this.axe.awZ.aHo;
        if (j.aW(i, i2) && !this.axe.awZ.nU()) {
            i3 = eVar2.aHp;
            i4 = eVar2.aHo;
        }
        bVar.a(b, this.axe.a((com.bumptech.glide.f.a.e) eVar, (d) dVar, (c) bVar, this.axe.axa, this.axe.awZ.aAk, i3, i4, this.axe.awZ));
        AppMethodBeat.o(91644);
        return bVar;
    }

    private b b(com.bumptech.glide.f.a.e<TranscodeType> eVar, d<TranscodeType> dVar, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, e eVar2) {
        AppMethodBeat.i(91645);
        c hVar;
        if (this.axd != null) {
            if (this.axi) {
                IllegalStateException illegalStateException = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
                AppMethodBeat.o(91645);
                throw illegalStateException;
            }
            k<?, ? super TranscodeType> kVar2;
            g gVar2;
            int i3;
            int i4;
            k<?, ? super TranscodeType> kVar3 = this.axd.axa;
            if (this.axd.axg) {
                kVar2 = kVar;
            } else {
                kVar2 = kVar3;
            }
            if (this.axd.awZ.nV()) {
                gVar2 = this.axd.awZ.aAk;
            } else {
                gVar2 = a(gVar);
            }
            int i5 = this.axd.awZ.aHp;
            int i6 = this.axd.awZ.aHo;
            if (!j.aW(i, i2) || this.axd.awZ.nU()) {
                i3 = i6;
                i4 = i5;
            } else {
                i5 = eVar2.aHp;
                i3 = eVar2.aHo;
                i4 = i5;
            }
            hVar = new h(cVar);
            b a = a((com.bumptech.glide.f.a.e) eVar, (d) dVar, eVar2, hVar, (k) kVar, gVar, i, i2);
            this.axi = true;
            b a2 = this.axd.a((com.bumptech.glide.f.a.e) eVar, (d) dVar, hVar, (k) kVar2, gVar2, i4, i3, this.axd.awZ);
            this.axi = false;
            hVar.a(a, a2);
            AppMethodBeat.o(91645);
            return hVar;
        } else if (this.axf != null) {
            hVar = new h(cVar);
            hVar.a(a((com.bumptech.glide.f.a.e) eVar, (d) dVar, eVar2, hVar, (k) kVar, gVar, i, i2), a((com.bumptech.glide.f.a.e) eVar, (d) dVar, eVar2.nR().M(this.axf.floatValue()), hVar, (k) kVar, a(gVar), i, i2));
            AppMethodBeat.o(91645);
            return hVar;
        } else {
            b a3 = a((com.bumptech.glide.f.a.e) eVar, (d) dVar, eVar2, cVar, (k) kVar, gVar, i, i2);
            AppMethodBeat.o(91645);
            return a3;
        }
    }

    private b a(com.bumptech.glide.f.a.e<TranscodeType> eVar, d<TranscodeType> dVar, e eVar2, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2) {
        AppMethodBeat.i(91646);
        g a = g.a(this.context, this.awi, this.axb, this.awY, eVar2, i, i2, gVar, eVar, dVar, this.axc, cVar, this.awi.awe, kVar.axu);
        AppMethodBeat.o(91646);
        return a;
    }

    public final i<TranscodeType> a(e eVar) {
        AppMethodBeat.i(91639);
        com.bumptech.glide.h.i.d(eVar, "Argument must not be null");
        e lG = lG();
        while (lG.aHu) {
            lG = lG.nR();
        }
        if (e.aT(eVar.aHi, 2)) {
            lG.aHj = eVar.aHj;
        }
        if (e.aT(eVar.aHi, 262144)) {
            lG.aHv = eVar.aHv;
        }
        if (e.aT(eVar.aHi, 1048576)) {
            lG.aBK = eVar.aBK;
        }
        if (e.aT(eVar.aHi, 4)) {
            lG.aAl = eVar.aAl;
        }
        if (e.aT(eVar.aHi, 8)) {
            lG.aAk = eVar.aAk;
        }
        if (e.aT(eVar.aHi, 16)) {
            lG.aHk = eVar.aHk;
        }
        if (e.aT(eVar.aHi, 32)) {
            lG.aHl = eVar.aHl;
        }
        if (e.aT(eVar.aHi, 64)) {
            lG.aHm = eVar.aHm;
        }
        if (e.aT(eVar.aHi, 128)) {
            lG.aHn = eVar.aHn;
        }
        if (e.aT(eVar.aHi, 256)) {
            lG.azQ = eVar.azQ;
        }
        if (e.aT(eVar.aHi, 512)) {
            lG.aHp = eVar.aHp;
            lG.aHo = eVar.aHo;
        }
        if (e.aT(eVar.aHi, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            lG.aAb = eVar.aAb;
        }
        if (e.aT(eVar.aHi, 4096)) {
            lG.aAf = eVar.aAf;
        }
        if (e.aT(eVar.aHi, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
            lG.aHr = eVar.aHr;
        }
        if (e.aT(eVar.aHi, 16384)) {
            lG.aHs = eVar.aHs;
        }
        if (e.aT(eVar.aHi, 32768)) {
            lG.aHt = eVar.aHt;
        }
        if (e.aT(eVar.aHi, 65536)) {
            lG.aHq = eVar.aHq;
        }
        if (e.aT(eVar.aHi, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            lG.aAm = eVar.aAm;
        }
        if (e.aT(eVar.aHi, 2048)) {
            lG.aAh.putAll(eVar.aAh);
            lG.aAn = eVar.aAn;
        }
        if (e.aT(eVar.aHi, SQLiteGlobal.journalSizeLimit)) {
            lG.aAz = eVar.aAz;
        }
        if (!lG.aHq) {
            lG.aAh.clear();
            lG.aHi &= -2049;
            lG.aAm = false;
            lG.aHi &= -131073;
            lG.aAn = true;
        }
        lG.aHi |= eVar.aHi;
        lG.aAd.a(eVar.aAd);
        this.awZ = lG.nT();
        AppMethodBeat.o(91639);
        return this;
    }

    public final i<TranscodeType> Q(Object obj) {
        this.axb = obj;
        this.axh = true;
        return this;
    }

    public final <Y extends com.bumptech.glide.f.a.e<TranscodeType>> Y b(Y y) {
        AppMethodBeat.i(91642);
        e lG = lG();
        j.om();
        com.bumptech.glide.h.i.d(y, "Argument must not be null");
        if (this.axh) {
            e nS = lG.nS();
            b a = a((com.bumptech.glide.f.a.e) y, null, null, this.axa, nS.aAk, nS.aHp, nS.aHo, nS);
            b og = y.og();
            if (a.a(og)) {
                Object obj;
                if (nS.azQ || !og.isComplete()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    a.recycle();
                    if (!((b) com.bumptech.glide.h.i.d(og, "Argument must not be null")).isRunning()) {
                        og.begin();
                    }
                    AppMethodBeat.o(91642);
                    return y;
                }
            }
            this.awX.c(y);
            y.h(a);
            j jVar = this.awX;
            jVar.axp.aGW.add(y);
            n nVar = jVar.axn;
            nVar.aGR.add(a);
            if (nVar.isPaused) {
                Log.isLoggable("RequestTracker", 2);
                nVar.aGS.add(a);
            } else {
                a.begin();
            }
            AppMethodBeat.o(91642);
            return y;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call #load() before calling #into()");
        AppMethodBeat.o(91642);
        throw illegalArgumentException;
    }
}
