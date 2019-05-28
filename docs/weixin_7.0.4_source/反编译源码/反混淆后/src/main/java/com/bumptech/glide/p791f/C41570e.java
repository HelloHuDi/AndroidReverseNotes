package com.bumptech.glide.p791f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C31938i;
import com.bumptech.glide.p086c.p092d.p093a.C37179j;
import com.bumptech.glide.p086c.p092d.p788e.C17543f;
import com.bumptech.glide.p086c.p092d.p788e.C37186c;
import com.bumptech.glide.p095h.C31974b;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p1157g.C25461a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Map;

/* renamed from: com.bumptech.glide.f.e */
public final class C41570e implements Cloneable {
    public C0779h aAb = C25461a.m40238oj();
    public C31967j aAd = new C31967j();
    public Class<?> aAf = Object.class;
    public Map<Class<?>, C31970m<?>> aAh = new C31974b();
    public C37192g aAk = C37192g.NORMAL;
    public C31938i aAl = C31938i.aBm;
    public boolean aAm;
    public boolean aAn = true;
    public boolean aAz;
    public boolean aBK;
    public boolean aCf;
    public int aHi;
    public float aHj = 1.0f;
    public Drawable aHk;
    public int aHl;
    public Drawable aHm;
    public int aHn;
    public int aHo = -1;
    public int aHp = -1;
    public boolean aHq = true;
    public Drawable aHr;
    public int aHs;
    public Theme aHt;
    public boolean aHu;
    public boolean aHv;
    public boolean azQ = true;

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(92486);
        C41570e nR = mo66592nR();
        AppMethodBeat.m2505o(92486);
        return nR;
    }

    public C41570e() {
        AppMethodBeat.m2504i(92467);
        AppMethodBeat.m2505o(92467);
    }

    /* renamed from: a */
    public static C41570e m72766a(C31938i c31938i) {
        AppMethodBeat.m2504i(92468);
        C41570e b = new C41570e().mo66585b(c31938i);
        AppMethodBeat.m2505o(92468);
        return b;
    }

    /* renamed from: e */
    public static C41570e m72769e(C0779h c0779h) {
        AppMethodBeat.m2504i(92469);
        C41570e c41570e = new C41570e();
        while (true) {
            C41570e c41570e2 = c41570e;
            if (c41570e2.aHu) {
                c41570e = c41570e2.mo66592nR();
            } else {
                c41570e2.aAb = (C0779h) C8561i.m15217d(c0779h, "Argument must not be null");
                c41570e2.aHi |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                c41570e = c41570e2.mo66594nT();
                AppMethodBeat.m2505o(92469);
                return c41570e;
            }
        }
    }

    /* renamed from: w */
    public static C41570e m72770w(Class<?> cls) {
        AppMethodBeat.m2504i(92470);
        C41570e c41570e = new C41570e();
        while (true) {
            C41570e c41570e2 = c41570e;
            if (c41570e2.aHu) {
                c41570e = c41570e2.mo66592nR();
            } else {
                c41570e2.aAf = (Class) C8561i.m15217d(cls, "Argument must not be null");
                c41570e2.aHi |= 4096;
                c41570e = c41570e2.mo66594nT();
                AppMethodBeat.m2505o(92470);
                return c41570e;
            }
        }
    }

    /* renamed from: aT */
    public static boolean m72768aT(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: M */
    public final C41570e mo66582M(float f) {
        AppMethodBeat.m2504i(92471);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        if (f < 0.0f || f > 1.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
            AppMethodBeat.m2505o(92471);
            throw illegalArgumentException;
        }
        this.aHj = f;
        this.aHi |= 2;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92471);
        return nT;
    }

    /* renamed from: nP */
    public final C41570e mo66590nP() {
        AppMethodBeat.m2504i(92472);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        this.aBK = true;
        this.aHi |= 1048576;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92472);
        return nT;
    }

    /* renamed from: b */
    public final C41570e mo66585b(C31938i c31938i) {
        AppMethodBeat.m2504i(92473);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        this.aAl = (C31938i) C8561i.m15217d(c31938i, "Argument must not be null");
        this.aHi |= 4;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92473);
        return nT;
    }

    /* renamed from: b */
    public final C41570e mo66586b(C37192g c37192g) {
        AppMethodBeat.m2504i(92474);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        this.aAk = (C37192g) C8561i.m15217d(c37192g, "Argument must not be null");
        this.aHi |= 8;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92474);
        return nT;
    }

    /* renamed from: nQ */
    public final C41570e mo66591nQ() {
        AppMethodBeat.m2504i(92475);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        this.azQ = false;
        this.aHi |= 256;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92475);
        return nT;
    }

    /* renamed from: aU */
    public final C41570e mo66584aU(int i, int i2) {
        AppMethodBeat.m2504i(92476);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        this.aHp = i;
        this.aHo = i2;
        this.aHi |= 512;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92476);
        return nT;
    }

    /* renamed from: nR */
    public final C41570e mo66592nR() {
        AppMethodBeat.m2504i(92477);
        try {
            C41570e c41570e = (C41570e) super.clone();
            c41570e.aAd = new C31967j();
            c41570e.aAd.mo52070a(this.aAd);
            c41570e.aAh = new C31974b();
            c41570e.aAh.putAll(this.aAh);
            c41570e.aCf = false;
            c41570e.aHu = false;
            AppMethodBeat.m2505o(92477);
            return c41570e;
        } catch (CloneNotSupportedException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(92477);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    public final C41570e mo66583a(C31970m<Bitmap> c31970m) {
        AppMethodBeat.m2504i(92478);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        C37179j c37179j = new C37179j(c31970m);
        this.m72767a(Bitmap.class, c31970m);
        this.m72767a(Drawable.class, c37179j);
        this.m72767a(BitmapDrawable.class, c37179j);
        this.m72767a(C37186c.class, new C17543f(c31970m));
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92478);
        return nT;
    }

    /* renamed from: a */
    private <T> C41570e m72767a(Class<T> cls, C31970m<T> c31970m) {
        AppMethodBeat.m2504i(92479);
        while (this.aHu) {
            this = this.mo66592nR();
        }
        C8561i.m15217d(cls, "Argument must not be null");
        C8561i.m15217d(c31970m, "Argument must not be null");
        this.aAh.put(cls, c31970m);
        this.aHi |= 2048;
        this.aHq = true;
        this.aHi |= 65536;
        this.aAn = false;
        this.aHi |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.aAm = true;
        C41570e nT = this.mo66594nT();
        AppMethodBeat.m2505o(92479);
        return nT;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92480);
        if (obj instanceof C41570e) {
            C41570e c41570e = (C41570e) obj;
            if (Float.compare(c41570e.aHj, this.aHj) == 0 && this.aHl == c41570e.aHl && C45002j.m82421h(this.aHk, c41570e.aHk) && this.aHn == c41570e.aHn && C45002j.m82421h(this.aHm, c41570e.aHm) && this.aHs == c41570e.aHs && C45002j.m82421h(this.aHr, c41570e.aHr) && this.azQ == c41570e.azQ && this.aHo == c41570e.aHo && this.aHp == c41570e.aHp && this.aAm == c41570e.aAm && this.aHq == c41570e.aHq && this.aHv == c41570e.aHv && this.aAz == c41570e.aAz && this.aAl.equals(c41570e.aAl) && this.aAk == c41570e.aAk && this.aAd.equals(c41570e.aAd) && this.aAh.equals(c41570e.aAh) && this.aAf.equals(c41570e.aAf) && C45002j.m82421h(this.aAb, c41570e.aAb) && C45002j.m82421h(this.aHt, c41570e.aHt)) {
                AppMethodBeat.m2505o(92480);
                return true;
            }
            AppMethodBeat.m2505o(92480);
            return false;
        }
        AppMethodBeat.m2505o(92480);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92481);
        int b = C45002j.m82416b(this.aHt, C45002j.m82416b(this.aAb, C45002j.m82416b(this.aAf, C45002j.m82416b(this.aAh, C45002j.m82416b(this.aAd, C45002j.m82416b(this.aAk, C45002j.m82416b(this.aAl, C45002j.m82417b(this.aAz, C45002j.m82417b(this.aHv, C45002j.m82417b(this.aHq, C45002j.m82417b(this.aAm, C45002j.hashCode(this.aHp, C45002j.hashCode(this.aHo, C45002j.m82417b(this.azQ, C45002j.m82416b(this.aHr, C45002j.hashCode(this.aHs, C45002j.m82416b(this.aHm, C45002j.hashCode(this.aHn, C45002j.m82416b(this.aHk, C45002j.hashCode(this.aHl, C45002j.hashCode(this.aHj)))))))))))))))))))));
        AppMethodBeat.m2505o(92481);
        return b;
    }

    /* renamed from: nS */
    public final C41570e mo66593nS() {
        AppMethodBeat.m2504i(92482);
        if (!this.aCf || this.aHu) {
            this.aHu = true;
            this.aCf = true;
            AppMethodBeat.m2505o(92482);
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        AppMethodBeat.m2505o(92482);
        throw illegalStateException;
    }

    /* renamed from: nT */
    public final C41570e mo66594nT() {
        AppMethodBeat.m2504i(92483);
        if (this.aCf) {
            IllegalStateException illegalStateException = new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
            AppMethodBeat.m2505o(92483);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(92483);
        return this;
    }

    /* renamed from: nU */
    public final boolean mo66595nU() {
        AppMethodBeat.m2504i(92484);
        boolean aW = C45002j.m82415aW(this.aHp, this.aHo);
        AppMethodBeat.m2505o(92484);
        return aW;
    }

    /* renamed from: nV */
    public final boolean mo66596nV() {
        AppMethodBeat.m2504i(92485);
        boolean aT = C41570e.m72768aT(this.aHi, 8);
        AppMethodBeat.m2505o(92485);
        return aT;
    }
}
