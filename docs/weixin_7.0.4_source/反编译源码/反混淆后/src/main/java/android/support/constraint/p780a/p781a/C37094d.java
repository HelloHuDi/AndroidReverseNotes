package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.p781a.C17368f.C17370a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.d */
public final class C37094d {
    /* renamed from: hf */
    protected C17368f f15639hf;
    /* renamed from: hg */
    protected C17368f f15640hg;
    /* renamed from: hh */
    protected C17368f f15641hh;
    /* renamed from: hi */
    protected C17368f f15642hi;
    /* renamed from: hj */
    protected C17368f f15643hj;
    /* renamed from: hk */
    protected C17368f f15644hk;
    /* renamed from: hl */
    protected C17368f f15645hl;
    /* renamed from: hm */
    protected ArrayList<C17368f> f15646hm;
    /* renamed from: hn */
    protected int f15647hn;
    /* renamed from: ho */
    protected int f15648ho;
    /* renamed from: hp */
    protected float f15649hp = 0.0f;
    /* renamed from: hq */
    private boolean f15650hq = false;
    /* renamed from: hr */
    protected boolean f15651hr;
    /* renamed from: hs */
    protected boolean f15652hs;
    /* renamed from: ht */
    protected boolean f15653ht;
    /* renamed from: hu */
    boolean f15654hu;
    private int mOrientation;

    public C37094d(C17368f c17368f, int i, boolean z) {
        this.f15639hf = c17368f;
        this.mOrientation = i;
        this.f15650hq = z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aF */
    public final void mo59119aF() {
        boolean z = true;
        int i = this.mOrientation * 2;
        C17368f c17368f = this.f15639hf;
        boolean z2 = false;
        C17368f c17368f2 = this.f15639hf;
        while (!z2) {
            C17368f c17368f3;
            this.f15647hn++;
            c17368f2.f3673jm[this.mOrientation] = null;
            c17368f2.f3672jl[this.mOrientation] = null;
            if (c17368f2.f3638iZ != 8) {
                if (this.f15640hg == null) {
                    this.f15640hg = c17368f2;
                }
                this.f15642hi = c17368f2;
                if (c17368f2.f3619iF[this.mOrientation] == C17370a.MATCH_CONSTRAINT && (c17368f2.f3642ie[this.mOrientation] == 0 || c17368f2.f3642ie[this.mOrientation] == 3 || c17368f2.f3642ie[this.mOrientation] == 2)) {
                    boolean z3;
                    this.f15648ho++;
                    float f = c17368f2.f3671jk[this.mOrientation];
                    if (f > 0.0f) {
                        this.f15649hp += c17368f2.f3671jk[this.mOrientation];
                    }
                    int i2 = this.mOrientation;
                    if (c17368f2.f3638iZ != 8 && c17368f2.f3619iF[i2] == C17370a.MATCH_CONSTRAINT && (c17368f2.f3642ie[i2] == 0 || c17368f2.f3642ie[i2] == 3)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (f < 0.0f) {
                            this.f15651hr = true;
                        } else {
                            this.f15652hs = true;
                        }
                        if (this.f15646hm == null) {
                            this.f15646hm = new ArrayList();
                        }
                        this.f15646hm.add(c17368f2);
                    }
                    if (this.f15644hk == null) {
                        this.f15644hk = c17368f2;
                    }
                    if (this.f15645hl != null) {
                        this.f15645hl.f3672jl[this.mOrientation] = c17368f2;
                    }
                    this.f15645hl = c17368f2;
                }
            }
            if (c17368f != c17368f2) {
                c17368f.f3673jm[this.mOrientation] = c17368f2;
            }
            C25284e c25284e = c17368f2.f3617iD[i + 1].f5032hy;
            if (c25284e != null) {
                c17368f3 = c25284e.f5030hw;
                if (c17368f3.f3617iD[i].f5032hy == null || c17368f3.f3617iD[i].f5032hy.f5030hw != c17368f2) {
                    c17368f3 = null;
                }
            } else {
                c17368f3 = null;
            }
            if (c17368f3 != null) {
                c17368f = c17368f2;
                c17368f2 = c17368f3;
            } else {
                z2 = true;
                c17368f = c17368f2;
            }
        }
        this.f15641hh = c17368f2;
        if (this.mOrientation == 0 && this.f15650hq) {
            this.f15643hj = this.f15641hh;
        } else {
            this.f15643hj = this.f15639hf;
        }
        if (!(this.f15652hs && this.f15651hr)) {
            z = false;
        }
        this.f15653ht = z;
    }
}
