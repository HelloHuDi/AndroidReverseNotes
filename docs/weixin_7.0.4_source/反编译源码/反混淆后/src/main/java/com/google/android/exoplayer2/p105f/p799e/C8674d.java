package com.google.android.exoplayer2.p105f.p799e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.e.d */
final class C8674d {
    int backgroundColor;
    String bnS;
    int bnT;
    boolean bnU;
    boolean bnV;
    int bnW = -1;
    int bnX = -1;
    int bnY = -1;
    int bnZ = -1;
    int boa = -1;
    C8674d bob;
    Alignment boc;
    float fontSize;
    /* renamed from: id */
    String f2434id;

    public final int getStyle() {
        int i = 0;
        if (this.bnY == -1 && this.bnZ == -1) {
            return -1;
        }
        int i2 = this.bnY == 1 ? 1 : 0;
        if (this.bnZ == 1) {
            i = 2;
        }
        return i2 | i;
    }

    /* renamed from: aK */
    public final C8674d mo19191aK(boolean z) {
        boolean z2;
        int i = 1;
        AppMethodBeat.m2504i(95690);
        if (this.bob == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        C45039a.checkState(z2);
        if (!z) {
            i = 0;
        }
        this.bnW = i;
        AppMethodBeat.m2505o(95690);
        return this;
    }

    /* renamed from: aL */
    public final C8674d mo19192aL(boolean z) {
        boolean z2;
        int i = 1;
        AppMethodBeat.m2504i(95691);
        if (this.bob == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        C45039a.checkState(z2);
        if (!z) {
            i = 0;
        }
        this.bnX = i;
        AppMethodBeat.m2505o(95691);
        return this;
    }

    /* renamed from: eE */
    public final C8674d mo19194eE(int i) {
        AppMethodBeat.m2504i(95692);
        C45039a.checkState(this.bob == null);
        this.bnT = i;
        this.bnU = true;
        AppMethodBeat.m2505o(95692);
        return this;
    }

    /* renamed from: eF */
    public final C8674d mo19195eF(int i) {
        this.backgroundColor = i;
        this.bnV = true;
        return this;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final C8674d mo19193b(C8674d c8674d) {
        AppMethodBeat.m2504i(95693);
        if (c8674d != null) {
            if (!this.bnU && c8674d.bnU) {
                mo19194eE(c8674d.bnT);
            }
            if (this.bnY == -1) {
                this.bnY = c8674d.bnY;
            }
            if (this.bnZ == -1) {
                this.bnZ = c8674d.bnZ;
            }
            if (this.bnS == null) {
                this.bnS = c8674d.bnS;
            }
            if (this.bnW == -1) {
                this.bnW = c8674d.bnW;
            }
            if (this.bnX == -1) {
                this.bnX = c8674d.bnX;
            }
            if (this.boc == null) {
                this.boc = c8674d.boc;
            }
            if (this.boa == -1) {
                this.boa = c8674d.boa;
                this.fontSize = c8674d.fontSize;
            }
            if (!this.bnV && c8674d.bnV) {
                mo19195eF(c8674d.backgroundColor);
            }
        }
        AppMethodBeat.m2505o(95693);
        return this;
    }
}
