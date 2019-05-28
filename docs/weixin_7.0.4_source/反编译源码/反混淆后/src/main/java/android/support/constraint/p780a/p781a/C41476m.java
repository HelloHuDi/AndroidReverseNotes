package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: android.support.constraint.a.a.m */
public final class C41476m extends C25288o {
    /* renamed from: gQ */
    float f16638gQ;
    /* renamed from: kj */
    C25284e f16639kj;
    /* renamed from: kk */
    C41476m f16640kk;
    /* renamed from: kl */
    C41476m f16641kl;
    /* renamed from: km */
    public float f16642km;
    /* renamed from: kn */
    private C41476m f16643kn;
    /* renamed from: ko */
    private float f16644ko;
    /* renamed from: kp */
    private C17372n f16645kp = null;
    /* renamed from: kq */
    private int f16646kq = 1;
    /* renamed from: kr */
    private C17372n f16647kr = null;
    /* renamed from: ks */
    private int f16648ks = 1;
    float offset;
    int type = 0;

    public C41476m(C25284e c25284e) {
        this.f16639kj = c25284e;
    }

    public final String toString() {
        if (this.state != 1) {
            return "{ " + this.f16639kj + " UNRESOLVED} type: " + C41476m.m72394D(this.type);
        }
        if (this.f16641kl == this) {
            return "[" + this.f16639kj + ", RESOLVED: " + this.f16642km + "]  type: " + C41476m.m72394D(this.type);
        }
        return "[" + this.f16639kj + ", RESOLVED: " + this.f16641kl + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.f16642km + "] type: " + C41476m.m72394D(this.type);
    }

    /* renamed from: a */
    public final void mo66147a(C41476m c41476m, float f) {
        if (this.state == 0 || !(this.f16641kl == c41476m || this.f16642km == f)) {
            this.f16641kl = c41476m;
            this.f16642km = f;
            if (this.state == 1) {
                invalidate();
            }
            mo42144bf();
        }
    }

    /* renamed from: D */
    private static String m72394D(int i) {
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

    /* renamed from: aE */
    public final void mo42143aE() {
        if (this.state != 1 && this.type != 4) {
            if (this.f16645kp != null) {
                if (this.f16645kp.state == 1) {
                    this.offset = ((float) this.f16646kq) * this.f16645kp.value;
                } else {
                    return;
                }
            }
            if (this.f16647kr != null) {
                if (this.f16647kr.state == 1) {
                    this.f16644ko = ((float) this.f16648ks) * this.f16647kr.value;
                } else {
                    return;
                }
            }
            if (this.type == 1 && (this.f16640kk == null || this.f16640kk.state == 1)) {
                if (this.f16640kk == null) {
                    this.f16641kl = this;
                    this.f16642km = this.offset;
                } else {
                    this.f16641kl = this.f16640kk.f16641kl;
                    this.f16642km = this.f16640kk.f16642km + this.offset;
                }
                mo42144bf();
            } else if (this.type == 2 && this.f16640kk != null && this.f16640kk.state == 1 && this.f16643kn != null && this.f16643kn.f16640kk != null && this.f16643kn.f16640kk.state == 1) {
                float f;
                float width;
                if (C17377e.m26934au() != null) {
                    C41477f au = C17377e.m26934au();
                    au.f16678gz++;
                }
                this.f16641kl = this.f16640kk.f16641kl;
                this.f16643kn.f16641kl = this.f16643kn.f16640kk.f16641kl;
                Object obj = (this.f16639kj.f5031hx == C25287c.RIGHT || this.f16639kj.f5031hx == C25287c.BOTTOM) ? 1 : null;
                if (obj != null) {
                    f = this.f16640kk.f16642km - this.f16643kn.f16640kk.f16642km;
                } else {
                    f = this.f16643kn.f16640kk.f16642km - this.f16640kk.f16642km;
                }
                if (this.f16639kj.f5031hx == C25287c.LEFT || this.f16639kj.f5031hx == C25287c.RIGHT) {
                    width = f - ((float) this.f16639kj.f5030hw.getWidth());
                    f = this.f16639kj.f5030hw.f3634iV;
                } else {
                    width = f - ((float) this.f16639kj.f5030hw.getHeight());
                    f = this.f16639kj.f5030hw.f3635iW;
                }
                int aH = this.f16639kj.mo42138aH();
                int aH2 = this.f16643kn.f16639kj.mo42138aH();
                if (this.f16639kj.f5032hy == this.f16643kn.f16639kj.f5032hy) {
                    f = 0.5f;
                    aH2 = 0;
                    aH = 0;
                }
                width = (width - ((float) aH)) - ((float) aH2);
                if (obj != null) {
                    this.f16643kn.f16642km = (((float) aH2) + this.f16643kn.f16640kk.f16642km) + (width * f);
                    this.f16642km = (this.f16640kk.f16642km - ((float) aH)) - ((1.0f - f) * width);
                } else {
                    this.f16642km = (this.f16640kk.f16642km + ((float) aH)) + (width * f);
                    this.f16643kn.f16642km = (this.f16643kn.f16640kk.f16642km - ((float) aH2)) - ((1.0f - f) * width);
                }
                mo42144bf();
                this.f16643kn.mo42144bf();
            } else if (this.type == 3 && this.f16640kk != null && this.f16640kk.state == 1 && this.f16643kn != null && this.f16643kn.f16640kk != null && this.f16643kn.f16640kk.state == 1) {
                if (C17377e.m26934au() != null) {
                    C41477f au2 = C17377e.m26934au();
                    au2.f16649gA++;
                }
                this.f16641kl = this.f16640kk.f16641kl;
                this.f16643kn.f16641kl = this.f16643kn.f16640kk.f16641kl;
                this.f16642km = this.f16640kk.f16642km + this.offset;
                this.f16643kn.f16642km = this.f16643kn.f16640kk.f16642km + this.f16643kn.offset;
                mo42144bf();
                this.f16643kn.mo42144bf();
            } else if (this.type == 5) {
                this.f16639kj.f5030hw.mo31452aE();
            }
        }
    }

    public final void reset() {
        super.reset();
        this.f16640kk = null;
        this.offset = 0.0f;
        this.f16645kp = null;
        this.f16646kq = 1;
        this.f16647kr = null;
        this.f16648ks = 1;
        this.f16641kl = null;
        this.f16642km = 0.0f;
        this.f16638gQ = 0.0f;
        this.f16643kn = null;
        this.f16644ko = 0.0f;
        this.type = 0;
    }

    /* renamed from: a */
    public final void mo66148a(C41476m c41476m, int i) {
        this.type = 1;
        this.f16640kk = c41476m;
        this.offset = (float) i;
        this.f16640kk.mo42142a(this);
    }

    /* renamed from: b */
    public final void mo66151b(C41476m c41476m, int i) {
        this.f16640kk = c41476m;
        this.offset = (float) i;
        this.f16640kk.mo42142a(this);
    }

    /* renamed from: a */
    public final void mo66149a(C41476m c41476m, int i, C17372n c17372n) {
        this.f16640kk = c41476m;
        this.f16640kk.mo42142a(this);
        this.f16645kp = c17372n;
        this.f16646kq = i;
        this.f16645kp.mo42142a(this);
    }

    /* renamed from: b */
    public final void mo66150b(C41476m c41476m, float f) {
        this.f16643kn = c41476m;
        this.f16644ko = f;
    }

    /* renamed from: b */
    public final void mo66152b(C41476m c41476m, int i, C17372n c17372n) {
        this.f16643kn = c41476m;
        this.f16647kr = c17372n;
        this.f16648ks = i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo66153c(C17377e c17377e) {
        C41479h c41479h = this.f16639kj.f5028hE;
        if (this.f16641kl == null) {
            c17377e.mo31515a(c41479h, (int) (this.f16642km + 0.5f));
        } else {
            c17377e.mo31524c(c41479h, c17377e.mo31526g(this.f16641kl.f16639kj), (int) (this.f16642km + 0.5f), 6);
        }
    }
}
