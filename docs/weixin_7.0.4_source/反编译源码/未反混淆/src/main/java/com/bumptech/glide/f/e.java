package com.bumptech.glide.f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.i;
import com.bumptech.glide.c.d.e.c;
import com.bumptech.glide.c.d.e.f;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.m;
import com.bumptech.glide.g;
import com.bumptech.glide.g.a;
import com.bumptech.glide.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Map;

public final class e implements Cloneable {
    public h aAb = a.oj();
    public j aAd = new j();
    public Class<?> aAf = Object.class;
    public Map<Class<?>, m<?>> aAh = new b();
    public g aAk = g.NORMAL;
    public i aAl = i.aBm;
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
        AppMethodBeat.i(92486);
        e nR = nR();
        AppMethodBeat.o(92486);
        return nR;
    }

    public e() {
        AppMethodBeat.i(92467);
        AppMethodBeat.o(92467);
    }

    public static e a(i iVar) {
        AppMethodBeat.i(92468);
        e b = new e().b(iVar);
        AppMethodBeat.o(92468);
        return b;
    }

    public static e e(h hVar) {
        AppMethodBeat.i(92469);
        e eVar = new e();
        while (true) {
            e eVar2 = eVar;
            if (eVar2.aHu) {
                eVar = eVar2.nR();
            } else {
                eVar2.aAb = (h) com.bumptech.glide.h.i.d(hVar, "Argument must not be null");
                eVar2.aHi |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                eVar = eVar2.nT();
                AppMethodBeat.o(92469);
                return eVar;
            }
        }
    }

    public static e w(Class<?> cls) {
        AppMethodBeat.i(92470);
        e eVar = new e();
        while (true) {
            e eVar2 = eVar;
            if (eVar2.aHu) {
                eVar = eVar2.nR();
            } else {
                eVar2.aAf = (Class) com.bumptech.glide.h.i.d(cls, "Argument must not be null");
                eVar2.aHi |= 4096;
                eVar = eVar2.nT();
                AppMethodBeat.o(92470);
                return eVar;
            }
        }
    }

    public static boolean aT(int i, int i2) {
        return (i & i2) != 0;
    }

    public final e M(float f) {
        AppMethodBeat.i(92471);
        while (this.aHu) {
            this = this.nR();
        }
        if (f < 0.0f || f > 1.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
            AppMethodBeat.o(92471);
            throw illegalArgumentException;
        }
        this.aHj = f;
        this.aHi |= 2;
        e nT = this.nT();
        AppMethodBeat.o(92471);
        return nT;
    }

    public final e nP() {
        AppMethodBeat.i(92472);
        while (this.aHu) {
            this = this.nR();
        }
        this.aBK = true;
        this.aHi |= 1048576;
        e nT = this.nT();
        AppMethodBeat.o(92472);
        return nT;
    }

    public final e b(i iVar) {
        AppMethodBeat.i(92473);
        while (this.aHu) {
            this = this.nR();
        }
        this.aAl = (i) com.bumptech.glide.h.i.d(iVar, "Argument must not be null");
        this.aHi |= 4;
        e nT = this.nT();
        AppMethodBeat.o(92473);
        return nT;
    }

    public final e b(g gVar) {
        AppMethodBeat.i(92474);
        while (this.aHu) {
            this = this.nR();
        }
        this.aAk = (g) com.bumptech.glide.h.i.d(gVar, "Argument must not be null");
        this.aHi |= 8;
        e nT = this.nT();
        AppMethodBeat.o(92474);
        return nT;
    }

    public final e nQ() {
        AppMethodBeat.i(92475);
        while (this.aHu) {
            this = this.nR();
        }
        this.azQ = false;
        this.aHi |= 256;
        e nT = this.nT();
        AppMethodBeat.o(92475);
        return nT;
    }

    public final e aU(int i, int i2) {
        AppMethodBeat.i(92476);
        while (this.aHu) {
            this = this.nR();
        }
        this.aHp = i;
        this.aHo = i2;
        this.aHi |= 512;
        e nT = this.nT();
        AppMethodBeat.o(92476);
        return nT;
    }

    public final e nR() {
        AppMethodBeat.i(92477);
        try {
            e eVar = (e) super.clone();
            eVar.aAd = new j();
            eVar.aAd.a(this.aAd);
            eVar.aAh = new b();
            eVar.aAh.putAll(this.aAh);
            eVar.aCf = false;
            eVar.aHu = false;
            AppMethodBeat.o(92477);
            return eVar;
        } catch (CloneNotSupportedException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(92477);
            throw runtimeException;
        }
    }

    public final e a(m<Bitmap> mVar) {
        AppMethodBeat.i(92478);
        while (this.aHu) {
            this = this.nR();
        }
        com.bumptech.glide.c.d.a.j jVar = new com.bumptech.glide.c.d.a.j(mVar);
        this.a(Bitmap.class, mVar);
        this.a(Drawable.class, jVar);
        this.a(BitmapDrawable.class, jVar);
        this.a(c.class, new f(mVar));
        e nT = this.nT();
        AppMethodBeat.o(92478);
        return nT;
    }

    private <T> e a(Class<T> cls, m<T> mVar) {
        AppMethodBeat.i(92479);
        while (this.aHu) {
            this = this.nR();
        }
        com.bumptech.glide.h.i.d(cls, "Argument must not be null");
        com.bumptech.glide.h.i.d(mVar, "Argument must not be null");
        this.aAh.put(cls, mVar);
        this.aHi |= 2048;
        this.aHq = true;
        this.aHi |= 65536;
        this.aAn = false;
        this.aHi |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.aAm = true;
        e nT = this.nT();
        AppMethodBeat.o(92479);
        return nT;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92480);
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (Float.compare(eVar.aHj, this.aHj) == 0 && this.aHl == eVar.aHl && com.bumptech.glide.h.j.h(this.aHk, eVar.aHk) && this.aHn == eVar.aHn && com.bumptech.glide.h.j.h(this.aHm, eVar.aHm) && this.aHs == eVar.aHs && com.bumptech.glide.h.j.h(this.aHr, eVar.aHr) && this.azQ == eVar.azQ && this.aHo == eVar.aHo && this.aHp == eVar.aHp && this.aAm == eVar.aAm && this.aHq == eVar.aHq && this.aHv == eVar.aHv && this.aAz == eVar.aAz && this.aAl.equals(eVar.aAl) && this.aAk == eVar.aAk && this.aAd.equals(eVar.aAd) && this.aAh.equals(eVar.aAh) && this.aAf.equals(eVar.aAf) && com.bumptech.glide.h.j.h(this.aAb, eVar.aAb) && com.bumptech.glide.h.j.h(this.aHt, eVar.aHt)) {
                AppMethodBeat.o(92480);
                return true;
            }
            AppMethodBeat.o(92480);
            return false;
        }
        AppMethodBeat.o(92480);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(92481);
        int b = com.bumptech.glide.h.j.b(this.aHt, com.bumptech.glide.h.j.b(this.aAb, com.bumptech.glide.h.j.b(this.aAf, com.bumptech.glide.h.j.b(this.aAh, com.bumptech.glide.h.j.b(this.aAd, com.bumptech.glide.h.j.b(this.aAk, com.bumptech.glide.h.j.b(this.aAl, com.bumptech.glide.h.j.b(this.aAz, com.bumptech.glide.h.j.b(this.aHv, com.bumptech.glide.h.j.b(this.aHq, com.bumptech.glide.h.j.b(this.aAm, com.bumptech.glide.h.j.hashCode(this.aHp, com.bumptech.glide.h.j.hashCode(this.aHo, com.bumptech.glide.h.j.b(this.azQ, com.bumptech.glide.h.j.b(this.aHr, com.bumptech.glide.h.j.hashCode(this.aHs, com.bumptech.glide.h.j.b(this.aHm, com.bumptech.glide.h.j.hashCode(this.aHn, com.bumptech.glide.h.j.b(this.aHk, com.bumptech.glide.h.j.hashCode(this.aHl, com.bumptech.glide.h.j.hashCode(this.aHj)))))))))))))))))))));
        AppMethodBeat.o(92481);
        return b;
    }

    public final e nS() {
        AppMethodBeat.i(92482);
        if (!this.aCf || this.aHu) {
            this.aHu = true;
            this.aCf = true;
            AppMethodBeat.o(92482);
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        AppMethodBeat.o(92482);
        throw illegalStateException;
    }

    public final e nT() {
        AppMethodBeat.i(92483);
        if (this.aCf) {
            IllegalStateException illegalStateException = new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
            AppMethodBeat.o(92483);
            throw illegalStateException;
        }
        AppMethodBeat.o(92483);
        return this;
    }

    public final boolean nU() {
        AppMethodBeat.i(92484);
        boolean aW = com.bumptech.glide.h.j.aW(this.aHp, this.aHo);
        AppMethodBeat.o(92484);
        return aW;
    }

    public final boolean nV() {
        AppMethodBeat.i(92485);
        boolean aT = aT(this.aHi, 8);
        AppMethodBeat.o(92485);
        return aT;
    }
}
