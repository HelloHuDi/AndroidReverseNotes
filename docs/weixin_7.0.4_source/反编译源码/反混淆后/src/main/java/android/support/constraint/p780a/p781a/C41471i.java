package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.p781a.C17368f.C17370a;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.i */
public final class C41471i extends C17368f {
    /* renamed from: jZ */
    protected float f16626jZ = -1.0f;
    /* renamed from: ka */
    protected int f16627ka = -1;
    /* renamed from: kb */
    protected int f16628kb = -1;
    /* renamed from: kc */
    private C25284e f16629kc = this.f3657iw;
    /* renamed from: kd */
    private boolean f16630kd = false;
    /* renamed from: ke */
    private int f16631ke = 0;
    /* renamed from: kf */
    private C41475l f16632kf = new C41475l();
    /* renamed from: kg */
    private int f16633kg = 8;
    private int mOrientation = 0;

    public C41471i() {
        int i = 0;
        this.f3618iE.clear();
        this.f3618iE.add(this.f16629kc);
        int length = this.f3617iD.length;
        while (i < length) {
            this.f3617iD[i] = this.f16629kc;
            i++;
        }
    }

    /* renamed from: aC */
    public final boolean mo31450aC() {
        return true;
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.f3618iE.clear();
            if (this.mOrientation == 1) {
                this.f16629kc = this.f3656iu;
            } else {
                this.f16629kc = this.f3657iw;
            }
            this.f3618iE.add(this.f16629kc);
            int length = this.f3617iD.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f3617iD[i2] = this.f16629kc;
            }
        }
    }

    /* renamed from: a */
    public final C25284e mo31445a(C25287c c25287c) {
        switch (c25287c) {
            case LEFT:
            case RIGHT:
                if (this.mOrientation == 1) {
                    return this.f16629kc;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.mOrientation == 0) {
                    return this.f16629kc;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(c25287c.name());
    }

    /* renamed from: aT */
    public final ArrayList<C25284e> mo31464aT() {
        return this.f3618iE;
    }

    /* renamed from: g */
    public final void mo66143g(float f) {
        if (f > -1.0f) {
            this.f16626jZ = f;
            this.f16627ka = -1;
            this.f16628kb = -1;
        }
    }

    /* renamed from: B */
    public final void mo66141B(int i) {
        if (i >= 0) {
            this.f16626jZ = -1.0f;
            this.f16627ka = i;
            this.f16628kb = -1;
        }
    }

    /* renamed from: C */
    public final void mo66142C(int i) {
        if (i >= 0) {
            this.f16626jZ = -1.0f;
            this.f16627ka = -1;
            this.f16628kb = i;
        }
    }

    /* renamed from: u */
    public final void mo31492u(int i) {
        C17368f c17368f = this.f3620iG;
        if (c17368f != null) {
            int i2;
            if (this.mOrientation == 1) {
                this.f3657iw.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, 0);
                this.f3659iy.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, 0);
                if (this.f16627ka != -1) {
                    this.f3656iu.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, this.f16627ka);
                    this.f3658ix.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, this.f16627ka);
                    return;
                } else if (this.f16628kb != -1) {
                    this.f3656iu.f5029hv.mo66148a(c17368f.f3658ix.f5029hv, -this.f16628kb);
                    this.f3658ix.f5029hv.mo66148a(c17368f.f3658ix.f5029hv, -this.f16628kb);
                    return;
                } else if (this.f16626jZ != -1.0f && c17368f.mo31467aW() == C17370a.FIXED) {
                    i2 = (int) (((float) c17368f.mWidth) * this.f16626jZ);
                    this.f3656iu.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, i2);
                    this.f3658ix.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, i2);
                    return;
                } else {
                    return;
                }
            }
            this.f3656iu.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, 0);
            this.f3658ix.f5029hv.mo66148a(c17368f.f3656iu.f5029hv, 0);
            if (this.f16627ka != -1) {
                this.f3657iw.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, this.f16627ka);
                this.f3659iy.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, this.f16627ka);
            } else if (this.f16628kb != -1) {
                this.f3657iw.f5029hv.mo66148a(c17368f.f3659iy.f5029hv, -this.f16628kb);
                this.f3659iy.f5029hv.mo66148a(c17368f.f3659iy.f5029hv, -this.f16628kb);
            } else if (this.f16626jZ != -1.0f && c17368f.mo31468aX() == C17370a.FIXED) {
                i2 = (int) (((float) c17368f.mHeight) * this.f16626jZ);
                this.f3657iw.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, i2);
                this.f3659iy.f5029hv.mo66148a(c17368f.f3657iw.f5029hv, i2);
            }
        }
    }

    /* renamed from: a */
    public final void mo31449a(C17377e c17377e) {
        int i = 1;
        C31242g c31242g = (C31242g) this.f3620iG;
        if (c31242g != null) {
            Object a;
            Object a2 = c31242g.mo31445a(C25287c.LEFT);
            C25284e a3 = c31242g.mo31445a(C25287c.RIGHT);
            int i2 = this.f3620iG != null ? this.f3620iG.f3619iF[0] == C17370a.WRAP_CONTENT ? 1 : 0 : 0;
            if (this.mOrientation == 0) {
                C25284e a4 = c31242g.mo31445a(C25287c.TOP);
                a = c31242g.mo31445a(C25287c.BOTTOM);
                if (this.f3620iG == null) {
                    i = 0;
                } else if (this.f3620iG.f3619iF[1] != C17370a.WRAP_CONTENT) {
                    i = 0;
                }
                a2 = a4;
            } else {
                i = i2;
                C25284e a5 = a3;
            }
            C41479h g;
            if (this.f16627ka != -1) {
                g = c17377e.mo31526g(this.f16629kc);
                c17377e.mo31524c(g, c17377e.mo31526g(a2), this.f16627ka, 6);
                if (i != 0) {
                    c17377e.mo31517a(c17377e.mo31526g(a5), g, 0, 5);
                }
            } else if (this.f16628kb != -1) {
                g = c17377e.mo31526g(this.f16629kc);
                C41479h g2 = c17377e.mo31526g(a5);
                c17377e.mo31524c(g, g2, -this.f16628kb, 6);
                if (i != 0) {
                    c17377e.mo31517a(g, c17377e.mo31526g(a2), 0, 5);
                    c17377e.mo31517a(g2, g, 0, 5);
                }
            } else if (this.f16626jZ != -1.0f) {
                c17377e.mo31521b(C17377e.m26931a(c17377e, c17377e.mo31526g(this.f16629kc), c17377e.mo31526g(a2), c17377e.mo31526g(a5), this.f16626jZ, this.f16630kd));
            }
        }
    }

    /* renamed from: aY */
    public final void mo31469aY() {
        if (this.f3620iG != null) {
            int h = C17377e.m26939h(this.f16629kc);
            if (this.mOrientation == 1) {
                setX(h);
                setY(0);
                setHeight(this.f3620iG.getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(h);
            setWidth(this.f3620iG.getWidth());
            setHeight(0);
        }
    }
}
