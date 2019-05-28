package android.support.constraint.a.a;

import android.support.constraint.a.a.f.a;
import android.support.constraint.a.e;
import android.support.constraint.a.f;
import android.support.constraint.a.h;
import java.util.ArrayList;

public final class b extends j {
    public int hc = 0;
    private ArrayList<m> hd = new ArrayList(4);
    public boolean he = true;

    public final boolean aC() {
        return true;
    }

    public final void aD() {
        super.aD();
        this.hd.clear();
    }

    public final void u(int i) {
        if (this.iG != null && ((g) this.iG).z(2)) {
            m mVar;
            switch (this.hc) {
                case 0:
                    mVar = this.iu.hv;
                    break;
                case 1:
                    mVar = this.ix.hv;
                    break;
                case 2:
                    mVar = this.iw.hv;
                    break;
                case 3:
                    mVar = this.iy.hv;
                    break;
                default:
                    return;
            }
            mVar.type = 5;
            if (this.hc == 0 || this.hc == 1) {
                this.iw.hv.a(null, 0.0f);
                this.iy.hv.a(null, 0.0f);
            } else {
                this.iu.hv.a(null, 0.0f);
                this.ix.hv.a(null, 0.0f);
            }
            this.hd.clear();
            for (int i2 = 0; i2 < this.hn; i2++) {
                f fVar = this.kh[i2];
                if (this.he || fVar.aC()) {
                    Object obj;
                    switch (this.hc) {
                        case 0:
                            obj = fVar.iu.hv;
                            break;
                        case 1:
                            obj = fVar.ix.hv;
                            break;
                        case 2:
                            obj = fVar.iw.hv;
                            break;
                        case 3:
                            obj = fVar.iy.hv;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj != null) {
                        this.hd.add(obj);
                        obj.a(mVar);
                    }
                }
            }
        }
    }

    public final void aE() {
        m mVar;
        float f = Float.MAX_VALUE;
        switch (this.hc) {
            case 0:
                mVar = this.iu.hv;
                break;
            case 1:
                mVar = this.ix.hv;
                f = 0.0f;
                break;
            case 2:
                mVar = this.iw.hv;
                break;
            case 3:
                mVar = this.iy.hv;
                f = 0.0f;
                break;
            default:
                return;
        }
        int size = this.hd.size();
        m mVar2 = null;
        int i = 0;
        while (i < size) {
            m mVar3 = (m) this.hd.get(i);
            if (mVar3.state == 1) {
                if (this.hc == 0 || this.hc == 2) {
                    if (mVar3.km < f) {
                        f = mVar3.km;
                        mVar3 = mVar3.kl;
                    }
                    mVar3 = mVar2;
                } else {
                    if (mVar3.km > f) {
                        f = mVar3.km;
                        mVar3 = mVar3.kl;
                    }
                    mVar3 = mVar2;
                }
                i++;
                mVar2 = mVar3;
            } else {
                return;
            }
        }
        if (e.au() != null) {
            f au = e.au();
            au.gC++;
        }
        mVar.kl = mVar2;
        mVar.km = f;
        mVar.bf();
        switch (this.hc) {
            case 0:
                this.ix.hv.a(mVar2, f);
                return;
            case 1:
                this.iu.hv.a(mVar2, f);
                return;
            case 2:
                this.iy.hv.a(mVar2, f);
                return;
            case 3:
                this.iw.hv.a(mVar2, f);
                return;
            default:
                return;
        }
    }

    public final void a(e eVar) {
        int i;
        this.iD[0] = this.iu;
        this.iD[2] = this.iw;
        this.iD[1] = this.ix;
        this.iD[3] = this.iy;
        for (i = 0; i < this.iD.length; i++) {
            this.iD[i].hE = eVar.g(this.iD[i]);
        }
        if (this.hc >= 0 && this.hc < 4) {
            e eVar2 = this.iD[this.hc];
            for (i = 0; i < this.hn; i++) {
                f fVar = this.kh[i];
                if (this.he || fVar.aC()) {
                    if ((this.hc != 0 && this.hc != 1) || fVar.aW() != a.MATCH_CONSTRAINT) {
                        if ((this.hc == 2 || this.hc == 3) && fVar.aX() == a.MATCH_CONSTRAINT) {
                            i = 1;
                            break;
                        }
                    }
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (this.hc == 0 || this.hc == 1) {
                if (this.iG.aW() == a.WRAP_CONTENT) {
                    i = 0;
                }
            } else if (this.iG.aX() == a.WRAP_CONTENT) {
                i = 0;
            }
            for (int i2 = 0; i2 < this.hn; i2++) {
                f fVar2 = this.kh[i2];
                if (this.he || fVar2.aC()) {
                    h g = eVar.g(fVar2.iD[this.hc]);
                    fVar2.iD[this.hc].hE = g;
                    h hVar;
                    android.support.constraint.a.b ax;
                    h ay;
                    if (this.hc == 0 || this.hc == 2) {
                        hVar = eVar2.hE;
                        ax = eVar.ax();
                        ay = eVar.ay();
                        ay.gP = 0;
                        ax.b(hVar, g, ay, 0);
                        if (i != 0) {
                            eVar.a(ax, (int) (ax.fI.b(ay) * -1.0f), 1);
                        }
                        eVar.b(ax);
                    } else {
                        hVar = eVar2.hE;
                        ax = eVar.ax();
                        ay = eVar.ay();
                        ay.gP = 0;
                        ax.a(hVar, g, ay, 0);
                        if (i != 0) {
                            eVar.a(ax, (int) (ax.fI.b(ay) * -1.0f), 1);
                        }
                        eVar.b(ax);
                    }
                }
            }
            if (this.hc == 0) {
                eVar.c(this.ix.hE, this.iu.hE, 0, 6);
                if (i == 0) {
                    eVar.c(this.iu.hE, this.iG.ix.hE, 0, 5);
                }
            } else if (this.hc == 1) {
                eVar.c(this.iu.hE, this.ix.hE, 0, 6);
                if (i == 0) {
                    eVar.c(this.iu.hE, this.iG.iu.hE, 0, 5);
                }
            } else if (this.hc == 2) {
                eVar.c(this.iy.hE, this.iw.hE, 0, 6);
                if (i == 0) {
                    eVar.c(this.iw.hE, this.iG.iy.hE, 0, 5);
                }
            } else if (this.hc == 3) {
                eVar.c(this.iw.hE, this.iy.hE, 0, 6);
                if (i == 0) {
                    eVar.c(this.iw.hE, this.iG.iw.hE, 0, 5);
                }
            }
        }
    }
}
