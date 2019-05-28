package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.manager.C25466n;
import com.bumptech.glide.p086c.p088b.C31938i;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p791f.C17553b;
import com.bumptech.glide.p791f.C25460c;
import com.bumptech.glide.p791f.C31244a;
import com.bumptech.glide.p791f.C41570e;
import com.bumptech.glide.p791f.C41572h;
import com.bumptech.glide.p791f.C44645g;
import com.bumptech.glide.p791f.C8559d;
import com.bumptech.glide.p791f.p1156a.C17551e;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.bumptech.glide.i */
public final class C8562i<TranscodeType> implements Cloneable {
    protected static final C41570e awW = new C41570e().mo66585b(C31938i.aBk).mo66586b(C37192g.LOW).mo66591nQ();
    private final C8565j awX;
    private final Class<TranscodeType> awY;
    protected C41570e awZ;
    private final C8555c awc;
    private final C37191e awi;
    private final C41570e awv;
    private C25465k<?, ? super TranscodeType> axa;
    private Object axb;
    private C8559d<TranscodeType> axc;
    private C8562i<TranscodeType> axd;
    private C8562i<TranscodeType> axe;
    private Float axf;
    private boolean axg = true;
    private boolean axh;
    private boolean axi;
    private final Context context;

    /* renamed from: com.bumptech.glide.i$1 */
    static /* synthetic */ class C85631 {
        /* renamed from: xU */
        static final /* synthetic */ int[] f2426xU = new int[ScaleType.values().length];

        static {
            AppMethodBeat.m2504i(91637);
            axj = new int[C37192g.values().length];
            try {
                axj[C37192g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                axj[C37192g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                axj[C37192g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                axj[C37192g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2426xU[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2426xU[ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2426xU[ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2426xU[ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2426xU[ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2426xU[ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2426xU[ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2426xU[ScaleType.MATRIX.ordinal()] = 8;
                AppMethodBeat.m2505o(91637);
            } catch (NoSuchFieldError e12) {
                AppMethodBeat.m2505o(91637);
            }
        }
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(91647);
        C8562i lH = m15223lH();
        AppMethodBeat.m2505o(91647);
        return lH;
    }

    static {
        AppMethodBeat.m2504i(91648);
        AppMethodBeat.m2505o(91648);
    }

    protected C8562i(C8555c c8555c, C8565j c8565j, Class<TranscodeType> cls, Context context) {
        AppMethodBeat.m2504i(91638);
        this.awc = c8555c;
        this.awX = c8565j;
        this.awY = cls;
        this.awv = c8565j.awZ;
        this.context = context;
        this.axa = c8565j.mo18676k(cls);
        this.awZ = this.awv;
        this.awi = c8555c.awi;
        AppMethodBeat.m2505o(91638);
    }

    /* renamed from: lG */
    private C41570e m15222lG() {
        AppMethodBeat.m2504i(91640);
        C41570e nR;
        if (this.awv == this.awZ) {
            nR = this.awZ.mo66592nR();
            AppMethodBeat.m2505o(91640);
            return nR;
        }
        nR = this.awZ;
        AppMethodBeat.m2505o(91640);
        return nR;
    }

    /* renamed from: lH */
    private C8562i<TranscodeType> m15223lH() {
        AppMethodBeat.m2504i(91641);
        try {
            C8562i c8562i = (C8562i) super.clone();
            c8562i.awZ = c8562i.awZ.mo66592nR();
            c8562i.axa = c8562i.axa.clone();
            AppMethodBeat.m2505o(91641);
            return c8562i;
        } catch (CloneNotSupportedException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(91641);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    private C37192g m15220a(C37192g c37192g) {
        AppMethodBeat.m2504i(91643);
        C37192g c37192g2;
        switch (c37192g) {
            case LOW:
                c37192g2 = C37192g.NORMAL;
                AppMethodBeat.m2505o(91643);
                return c37192g2;
            case NORMAL:
                c37192g2 = C37192g.HIGH;
                AppMethodBeat.m2505o(91643);
                return c37192g2;
            case HIGH:
            case IMMEDIATE:
                c37192g2 = C37192g.IMMEDIATE;
                AppMethodBeat.m2505o(91643);
                return c37192g2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown priority: " + this.awZ.aAk);
                AppMethodBeat.m2505o(91643);
                throw illegalArgumentException;
        }
    }

    /* renamed from: a */
    private C17553b m15218a(C17551e<TranscodeType> c17551e, C8559d<TranscodeType> c8559d, C25460c c25460c, C25465k<?, ? super TranscodeType> c25465k, C37192g c37192g, int i, int i2, C41570e c41570e) {
        C17553b c17553b;
        C25460c c25460c2;
        AppMethodBeat.m2504i(91644);
        if (this.axe != null) {
            C31244a c31244a = new C31244a(c25460c);
            c17553b = c31244a;
            c25460c2 = c31244a;
        } else {
            c17553b = null;
            c25460c2 = c25460c;
        }
        C17553b b = m15221b(c17551e, c8559d, c25460c2, c25465k, c37192g, i, i2, c41570e);
        if (c17553b == null) {
            AppMethodBeat.m2505o(91644);
            return b;
        }
        int i3 = this.axe.awZ.aHp;
        int i4 = this.axe.awZ.aHo;
        if (C45002j.m82415aW(i, i2) && !this.axe.awZ.mo66595nU()) {
            i3 = c41570e.aHp;
            i4 = c41570e.aHo;
        }
        c17553b.mo51200a(b, this.axe.m15218a((C17551e) c17551e, (C8559d) c8559d, (C25460c) c17553b, this.axe.axa, this.axe.awZ.aAk, i3, i4, this.axe.awZ));
        AppMethodBeat.m2505o(91644);
        return c17553b;
    }

    /* renamed from: b */
    private C17553b m15221b(C17551e<TranscodeType> c17551e, C8559d<TranscodeType> c8559d, C25460c c25460c, C25465k<?, ? super TranscodeType> c25465k, C37192g c37192g, int i, int i2, C41570e c41570e) {
        AppMethodBeat.m2504i(91645);
        C25460c c41572h;
        if (this.axd != null) {
            if (this.axi) {
                IllegalStateException illegalStateException = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
                AppMethodBeat.m2505o(91645);
                throw illegalStateException;
            }
            C25465k<?, ? super TranscodeType> c25465k2;
            C37192g c37192g2;
            int i3;
            int i4;
            C25465k<?, ? super TranscodeType> c25465k3 = this.axd.axa;
            if (this.axd.axg) {
                c25465k2 = c25465k;
            } else {
                c25465k2 = c25465k3;
            }
            if (this.axd.awZ.mo66596nV()) {
                c37192g2 = this.axd.awZ.aAk;
            } else {
                c37192g2 = m15220a(c37192g);
            }
            int i5 = this.axd.awZ.aHp;
            int i6 = this.axd.awZ.aHo;
            if (!C45002j.m82415aW(i, i2) || this.axd.awZ.mo66595nU()) {
                i3 = i6;
                i4 = i5;
            } else {
                i5 = c41570e.aHp;
                i3 = c41570e.aHo;
                i4 = i5;
            }
            c41572h = new C41572h(c25460c);
            C17553b a = m15219a((C17551e) c17551e, (C8559d) c8559d, c41570e, c41572h, (C25465k) c25465k, c37192g, i, i2);
            this.axi = true;
            C17553b a2 = this.axd.m15218a((C17551e) c17551e, (C8559d) c8559d, c41572h, (C25465k) c25465k2, c37192g2, i4, i3, this.axd.awZ);
            this.axi = false;
            c41572h.mo66599a(a, a2);
            AppMethodBeat.m2505o(91645);
            return c41572h;
        } else if (this.axf != null) {
            c41572h = new C41572h(c25460c);
            c41572h.mo66599a(m15219a((C17551e) c17551e, (C8559d) c8559d, c41570e, c41572h, (C25465k) c25465k, c37192g, i, i2), m15219a((C17551e) c17551e, (C8559d) c8559d, c41570e.mo66592nR().mo66582M(this.axf.floatValue()), c41572h, (C25465k) c25465k, m15220a(c37192g), i, i2));
            AppMethodBeat.m2505o(91645);
            return c41572h;
        } else {
            C17553b a3 = m15219a((C17551e) c17551e, (C8559d) c8559d, c41570e, c25460c, (C25465k) c25465k, c37192g, i, i2);
            AppMethodBeat.m2505o(91645);
            return a3;
        }
    }

    /* renamed from: a */
    private C17553b m15219a(C17551e<TranscodeType> c17551e, C8559d<TranscodeType> c8559d, C41570e c41570e, C25460c c25460c, C25465k<?, ? super TranscodeType> c25465k, C37192g c37192g, int i, int i2) {
        AppMethodBeat.m2504i(91646);
        C44645g a = C44645g.m81156a(this.context, this.awi, this.axb, this.awY, c41570e, i, i2, c37192g, c17551e, c8559d, this.axc, c25460c, this.awi.awe, c25465k.axu);
        AppMethodBeat.m2505o(91646);
        return a;
    }

    /* renamed from: a */
    public final C8562i<TranscodeType> mo18670a(C41570e c41570e) {
        AppMethodBeat.m2504i(91639);
        C8561i.m15217d(c41570e, "Argument must not be null");
        C41570e lG = m15222lG();
        while (lG.aHu) {
            lG = lG.mo66592nR();
        }
        if (C41570e.m72768aT(c41570e.aHi, 2)) {
            lG.aHj = c41570e.aHj;
        }
        if (C41570e.m72768aT(c41570e.aHi, 262144)) {
            lG.aHv = c41570e.aHv;
        }
        if (C41570e.m72768aT(c41570e.aHi, 1048576)) {
            lG.aBK = c41570e.aBK;
        }
        if (C41570e.m72768aT(c41570e.aHi, 4)) {
            lG.aAl = c41570e.aAl;
        }
        if (C41570e.m72768aT(c41570e.aHi, 8)) {
            lG.aAk = c41570e.aAk;
        }
        if (C41570e.m72768aT(c41570e.aHi, 16)) {
            lG.aHk = c41570e.aHk;
        }
        if (C41570e.m72768aT(c41570e.aHi, 32)) {
            lG.aHl = c41570e.aHl;
        }
        if (C41570e.m72768aT(c41570e.aHi, 64)) {
            lG.aHm = c41570e.aHm;
        }
        if (C41570e.m72768aT(c41570e.aHi, 128)) {
            lG.aHn = c41570e.aHn;
        }
        if (C41570e.m72768aT(c41570e.aHi, 256)) {
            lG.azQ = c41570e.azQ;
        }
        if (C41570e.m72768aT(c41570e.aHi, 512)) {
            lG.aHp = c41570e.aHp;
            lG.aHo = c41570e.aHo;
        }
        if (C41570e.m72768aT(c41570e.aHi, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            lG.aAb = c41570e.aAb;
        }
        if (C41570e.m72768aT(c41570e.aHi, 4096)) {
            lG.aAf = c41570e.aAf;
        }
        if (C41570e.m72768aT(c41570e.aHi, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
            lG.aHr = c41570e.aHr;
        }
        if (C41570e.m72768aT(c41570e.aHi, 16384)) {
            lG.aHs = c41570e.aHs;
        }
        if (C41570e.m72768aT(c41570e.aHi, 32768)) {
            lG.aHt = c41570e.aHt;
        }
        if (C41570e.m72768aT(c41570e.aHi, 65536)) {
            lG.aHq = c41570e.aHq;
        }
        if (C41570e.m72768aT(c41570e.aHi, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            lG.aAm = c41570e.aAm;
        }
        if (C41570e.m72768aT(c41570e.aHi, 2048)) {
            lG.aAh.putAll(c41570e.aAh);
            lG.aAn = c41570e.aAn;
        }
        if (C41570e.m72768aT(c41570e.aHi, SQLiteGlobal.journalSizeLimit)) {
            lG.aAz = c41570e.aAz;
        }
        if (!lG.aHq) {
            lG.aAh.clear();
            lG.aHi &= -2049;
            lG.aAm = false;
            lG.aHi &= -131073;
            lG.aAn = true;
        }
        lG.aHi |= c41570e.aHi;
        lG.aAd.mo52070a(c41570e.aAd);
        this.awZ = lG.mo66594nT();
        AppMethodBeat.m2505o(91639);
        return this;
    }

    /* renamed from: Q */
    public final C8562i<TranscodeType> mo18669Q(Object obj) {
        this.axb = obj;
        this.axh = true;
        return this;
    }

    /* renamed from: b */
    public final <Y extends C17551e<TranscodeType>> Y mo18671b(Y y) {
        AppMethodBeat.m2504i(91642);
        C41570e lG = m15222lG();
        C45002j.m82426om();
        C8561i.m15217d(y, "Argument must not be null");
        if (this.axh) {
            C41570e nS = lG.mo66593nS();
            C17553b a = m15218a((C17551e) y, null, null, this.axa, nS.aAk, nS.aHp, nS.aHo, nS);
            C17553b og = y.mo31978og();
            if (a.mo31980a(og)) {
                Object obj;
                if (nS.azQ || !og.isComplete()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    a.recycle();
                    if (!((C17553b) C8561i.m15217d(og, "Argument must not be null")).isRunning()) {
                        og.begin();
                    }
                    AppMethodBeat.m2505o(91642);
                    return y;
                }
            }
            this.awX.mo18674c(y);
            y.mo31977h(a);
            C8565j c8565j = this.awX;
            c8565j.axp.aGW.add(y);
            C25466n c25466n = c8565j.axn;
            c25466n.aGR.add(a);
            if (c25466n.isPaused) {
                Log.isLoggable("RequestTracker", 2);
                c25466n.aGS.add(a);
            } else {
                a.begin();
            }
            AppMethodBeat.m2505o(91642);
            return y;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call #load() before calling #into()");
        AppMethodBeat.m2505o(91642);
        throw illegalArgumentException;
    }
}
