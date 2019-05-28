package android.support.p069v7.widget;

import android.support.p057v4.widget.C8415j;

/* renamed from: android.support.v7.widget.as */
final class C0691as {
    /* renamed from: Ls */
    int f1009Ls = C8415j.INVALID_ID;
    int aqm = C8415j.INVALID_ID;
    int aqn = 0;
    int aqo = 0;
    boolean aqp = false;
    /* renamed from: hq */
    boolean f1010hq = false;
    /* renamed from: xJ */
    int f1011xJ = 0;
    /* renamed from: xM */
    int f1012xM = 0;

    C0691as() {
    }

    /* renamed from: aI */
    public final void mo2003aI(int i, int i2) {
        this.aqm = i;
        this.f1009Ls = i2;
        this.aqp = true;
        if (this.f1010hq) {
            if (i2 != C8415j.INVALID_ID) {
                this.f1011xJ = i2;
            }
            if (i != C8415j.INVALID_ID) {
                this.f1012xM = i;
                return;
            }
            return;
        }
        if (i != C8415j.INVALID_ID) {
            this.f1011xJ = i;
        }
        if (i2 != C8415j.INVALID_ID) {
            this.f1012xM = i2;
        }
    }
}
