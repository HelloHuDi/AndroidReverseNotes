package android.support.constraint.a.a;

import android.support.constraint.a.a.f.a;
import java.util.ArrayList;

public final class d {
    protected f hf;
    protected f hg;
    protected f hh;
    protected f hi;
    protected f hj;
    protected f hk;
    protected f hl;
    protected ArrayList<f> hm;
    protected int hn;
    protected int ho;
    protected float hp = 0.0f;
    private boolean hq = false;
    protected boolean hr;
    protected boolean hs;
    protected boolean ht;
    boolean hu;
    private int mOrientation;

    public d(f fVar, int i, boolean z) {
        this.hf = fVar;
        this.mOrientation = i;
        this.hq = z;
    }

    /* Access modifiers changed, original: final */
    public final void aF() {
        boolean z = true;
        int i = this.mOrientation * 2;
        f fVar = this.hf;
        boolean z2 = false;
        f fVar2 = this.hf;
        while (!z2) {
            f fVar3;
            this.hn++;
            fVar2.jm[this.mOrientation] = null;
            fVar2.jl[this.mOrientation] = null;
            if (fVar2.iZ != 8) {
                if (this.hg == null) {
                    this.hg = fVar2;
                }
                this.hi = fVar2;
                if (fVar2.iF[this.mOrientation] == a.MATCH_CONSTRAINT && (fVar2.ie[this.mOrientation] == 0 || fVar2.ie[this.mOrientation] == 3 || fVar2.ie[this.mOrientation] == 2)) {
                    boolean z3;
                    this.ho++;
                    float f = fVar2.jk[this.mOrientation];
                    if (f > 0.0f) {
                        this.hp += fVar2.jk[this.mOrientation];
                    }
                    int i2 = this.mOrientation;
                    if (fVar2.iZ != 8 && fVar2.iF[i2] == a.MATCH_CONSTRAINT && (fVar2.ie[i2] == 0 || fVar2.ie[i2] == 3)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (f < 0.0f) {
                            this.hr = true;
                        } else {
                            this.hs = true;
                        }
                        if (this.hm == null) {
                            this.hm = new ArrayList();
                        }
                        this.hm.add(fVar2);
                    }
                    if (this.hk == null) {
                        this.hk = fVar2;
                    }
                    if (this.hl != null) {
                        this.hl.jl[this.mOrientation] = fVar2;
                    }
                    this.hl = fVar2;
                }
            }
            if (fVar != fVar2) {
                fVar.jm[this.mOrientation] = fVar2;
            }
            e eVar = fVar2.iD[i + 1].hy;
            if (eVar != null) {
                fVar3 = eVar.hw;
                if (fVar3.iD[i].hy == null || fVar3.iD[i].hy.hw != fVar2) {
                    fVar3 = null;
                }
            } else {
                fVar3 = null;
            }
            if (fVar3 != null) {
                fVar = fVar2;
                fVar2 = fVar3;
            } else {
                z2 = true;
                fVar = fVar2;
            }
        }
        this.hh = fVar2;
        if (this.mOrientation == 0 && this.hq) {
            this.hj = this.hh;
        } else {
            this.hj = this.hf;
        }
        if (!(this.hs && this.hr)) {
            z = false;
        }
        this.ht = z;
    }
}
