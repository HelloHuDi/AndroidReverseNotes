package android.support.constraint.a.a;

import android.support.constraint.a.a.e.c;
import android.support.constraint.a.e;
import android.support.constraint.a.f;
import android.support.constraint.a.h;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class m extends o {
    float gQ;
    e kj;
    m kk;
    m kl;
    public float km;
    private m kn;
    private float ko;
    private n kp = null;
    private int kq = 1;
    private n kr = null;
    private int ks = 1;
    float offset;
    int type = 0;

    public m(e eVar) {
        this.kj = eVar;
    }

    public final String toString() {
        if (this.state != 1) {
            return "{ " + this.kj + " UNRESOLVED} type: " + D(this.type);
        }
        if (this.kl == this) {
            return "[" + this.kj + ", RESOLVED: " + this.km + "]  type: " + D(this.type);
        }
        return "[" + this.kj + ", RESOLVED: " + this.kl + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.km + "] type: " + D(this.type);
    }

    public final void a(m mVar, float f) {
        if (this.state == 0 || !(this.kl == mVar || this.km == f)) {
            this.kl = mVar;
            this.km = f;
            if (this.state == 1) {
                invalidate();
            }
            bf();
        }
    }

    private static String D(int i) {
        if (i == 1) {
            return "DIRECT";
        }
        if (i == 2) {
            return "CENTER";
        }
        if (i == 3) {
            return "MATCH";
        }
        if (i == 4) {
            return "CHAIN";
        }
        if (i == 5) {
            return "BARRIER";
        }
        return "UNCONNECTED";
    }

    public final void aE() {
        if (this.state != 1 && this.type != 4) {
            if (this.kp != null) {
                if (this.kp.state == 1) {
                    this.offset = ((float) this.kq) * this.kp.value;
                } else {
                    return;
                }
            }
            if (this.kr != null) {
                if (this.kr.state == 1) {
                    this.ko = ((float) this.ks) * this.kr.value;
                } else {
                    return;
                }
            }
            if (this.type == 1 && (this.kk == null || this.kk.state == 1)) {
                if (this.kk == null) {
                    this.kl = this;
                    this.km = this.offset;
                } else {
                    this.kl = this.kk.kl;
                    this.km = this.kk.km + this.offset;
                }
                bf();
            } else if (this.type == 2 && this.kk != null && this.kk.state == 1 && this.kn != null && this.kn.kk != null && this.kn.kk.state == 1) {
                float f;
                float width;
                if (e.au() != null) {
                    f au = e.au();
                    au.gz++;
                }
                this.kl = this.kk.kl;
                this.kn.kl = this.kn.kk.kl;
                Object obj = (this.kj.hx == c.RIGHT || this.kj.hx == c.BOTTOM) ? 1 : null;
                if (obj != null) {
                    f = this.kk.km - this.kn.kk.km;
                } else {
                    f = this.kn.kk.km - this.kk.km;
                }
                if (this.kj.hx == c.LEFT || this.kj.hx == c.RIGHT) {
                    width = f - ((float) this.kj.hw.getWidth());
                    f = this.kj.hw.iV;
                } else {
                    width = f - ((float) this.kj.hw.getHeight());
                    f = this.kj.hw.iW;
                }
                int aH = this.kj.aH();
                int aH2 = this.kn.kj.aH();
                if (this.kj.hy == this.kn.kj.hy) {
                    f = 0.5f;
                    aH2 = 0;
                    aH = 0;
                }
                width = (width - ((float) aH)) - ((float) aH2);
                if (obj != null) {
                    this.kn.km = (((float) aH2) + this.kn.kk.km) + (width * f);
                    this.km = (this.kk.km - ((float) aH)) - ((1.0f - f) * width);
                } else {
                    this.km = (this.kk.km + ((float) aH)) + (width * f);
                    this.kn.km = (this.kn.kk.km - ((float) aH2)) - ((1.0f - f) * width);
                }
                bf();
                this.kn.bf();
            } else if (this.type == 3 && this.kk != null && this.kk.state == 1 && this.kn != null && this.kn.kk != null && this.kn.kk.state == 1) {
                if (e.au() != null) {
                    f au2 = e.au();
                    au2.gA++;
                }
                this.kl = this.kk.kl;
                this.kn.kl = this.kn.kk.kl;
                this.km = this.kk.km + this.offset;
                this.kn.km = this.kn.kk.km + this.kn.offset;
                bf();
                this.kn.bf();
            } else if (this.type == 5) {
                this.kj.hw.aE();
            }
        }
    }

    public final void reset() {
        super.reset();
        this.kk = null;
        this.offset = 0.0f;
        this.kp = null;
        this.kq = 1;
        this.kr = null;
        this.ks = 1;
        this.kl = null;
        this.km = 0.0f;
        this.gQ = 0.0f;
        this.kn = null;
        this.ko = 0.0f;
        this.type = 0;
    }

    public final void a(m mVar, int i) {
        this.type = 1;
        this.kk = mVar;
        this.offset = (float) i;
        this.kk.a(this);
    }

    public final void b(m mVar, int i) {
        this.kk = mVar;
        this.offset = (float) i;
        this.kk.a(this);
    }

    public final void a(m mVar, int i, n nVar) {
        this.kk = mVar;
        this.kk.a(this);
        this.kp = nVar;
        this.kq = i;
        this.kp.a(this);
    }

    public final void b(m mVar, float f) {
        this.kn = mVar;
        this.ko = f;
    }

    public final void b(m mVar, int i, n nVar) {
        this.kn = mVar;
        this.kr = nVar;
        this.ks = i;
    }

    /* Access modifiers changed, original: final */
    public final void c(e eVar) {
        h hVar = this.kj.hE;
        if (this.kl == null) {
            eVar.a(hVar, (int) (this.km + 0.5f));
        } else {
            eVar.c(hVar, eVar.g(this.kl.kj), (int) (this.km + 0.5f), 6);
        }
    }
}
