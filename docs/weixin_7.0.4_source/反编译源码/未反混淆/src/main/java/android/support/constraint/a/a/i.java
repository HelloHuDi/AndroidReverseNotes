package android.support.constraint.a.a;

import android.support.constraint.a.a.e.c;
import android.support.constraint.a.a.f.a;
import android.support.constraint.a.e;
import android.support.constraint.a.h;
import java.util.ArrayList;

public final class i extends f {
    protected float jZ = -1.0f;
    protected int ka = -1;
    protected int kb = -1;
    private e kc = this.iw;
    private boolean kd = false;
    private int ke = 0;
    private l kf = new l();
    private int kg = 8;
    private int mOrientation = 0;

    public i() {
        int i = 0;
        this.iE.clear();
        this.iE.add(this.kc);
        int length = this.iD.length;
        while (i < length) {
            this.iD[i] = this.kc;
            i++;
        }
    }

    public final boolean aC() {
        return true;
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.iE.clear();
            if (this.mOrientation == 1) {
                this.kc = this.iu;
            } else {
                this.kc = this.iw;
            }
            this.iE.add(this.kc);
            int length = this.iD.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.iD[i2] = this.kc;
            }
        }
    }

    public final e a(c cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.mOrientation == 1) {
                    return this.kc;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.mOrientation == 0) {
                    return this.kc;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    public final ArrayList<e> aT() {
        return this.iE;
    }

    public final void g(float f) {
        if (f > -1.0f) {
            this.jZ = f;
            this.ka = -1;
            this.kb = -1;
        }
    }

    public final void B(int i) {
        if (i >= 0) {
            this.jZ = -1.0f;
            this.ka = i;
            this.kb = -1;
        }
    }

    public final void C(int i) {
        if (i >= 0) {
            this.jZ = -1.0f;
            this.ka = -1;
            this.kb = i;
        }
    }

    public final void u(int i) {
        f fVar = this.iG;
        if (fVar != null) {
            int i2;
            if (this.mOrientation == 1) {
                this.iw.hv.a(fVar.iw.hv, 0);
                this.iy.hv.a(fVar.iw.hv, 0);
                if (this.ka != -1) {
                    this.iu.hv.a(fVar.iu.hv, this.ka);
                    this.ix.hv.a(fVar.iu.hv, this.ka);
                    return;
                } else if (this.kb != -1) {
                    this.iu.hv.a(fVar.ix.hv, -this.kb);
                    this.ix.hv.a(fVar.ix.hv, -this.kb);
                    return;
                } else if (this.jZ != -1.0f && fVar.aW() == a.FIXED) {
                    i2 = (int) (((float) fVar.mWidth) * this.jZ);
                    this.iu.hv.a(fVar.iu.hv, i2);
                    this.ix.hv.a(fVar.iu.hv, i2);
                    return;
                } else {
                    return;
                }
            }
            this.iu.hv.a(fVar.iu.hv, 0);
            this.ix.hv.a(fVar.iu.hv, 0);
            if (this.ka != -1) {
                this.iw.hv.a(fVar.iw.hv, this.ka);
                this.iy.hv.a(fVar.iw.hv, this.ka);
            } else if (this.kb != -1) {
                this.iw.hv.a(fVar.iy.hv, -this.kb);
                this.iy.hv.a(fVar.iy.hv, -this.kb);
            } else if (this.jZ != -1.0f && fVar.aX() == a.FIXED) {
                i2 = (int) (((float) fVar.mHeight) * this.jZ);
                this.iw.hv.a(fVar.iw.hv, i2);
                this.iy.hv.a(fVar.iw.hv, i2);
            }
        }
    }

    public final void a(e eVar) {
        int i = 1;
        g gVar = (g) this.iG;
        if (gVar != null) {
            Object a;
            Object a2 = gVar.a(c.LEFT);
            e a3 = gVar.a(c.RIGHT);
            int i2 = this.iG != null ? this.iG.iF[0] == a.WRAP_CONTENT ? 1 : 0 : 0;
            if (this.mOrientation == 0) {
                e a4 = gVar.a(c.TOP);
                a = gVar.a(c.BOTTOM);
                if (this.iG == null) {
                    i = 0;
                } else if (this.iG.iF[1] != a.WRAP_CONTENT) {
                    i = 0;
                }
                a2 = a4;
            } else {
                i = i2;
                e a5 = a3;
            }
            h g;
            if (this.ka != -1) {
                g = eVar.g(this.kc);
                eVar.c(g, eVar.g(a2), this.ka, 6);
                if (i != 0) {
                    eVar.a(eVar.g(a5), g, 0, 5);
                }
            } else if (this.kb != -1) {
                g = eVar.g(this.kc);
                h g2 = eVar.g(a5);
                eVar.c(g, g2, -this.kb, 6);
                if (i != 0) {
                    eVar.a(g, eVar.g(a2), 0, 5);
                    eVar.a(g2, g, 0, 5);
                }
            } else if (this.jZ != -1.0f) {
                eVar.b(e.a(eVar, eVar.g(this.kc), eVar.g(a2), eVar.g(a5), this.jZ, this.kd));
            }
        }
    }

    public final void aY() {
        if (this.iG != null) {
            int h = e.h(this.kc);
            if (this.mOrientation == 1) {
                setX(h);
                setY(0);
                setHeight(this.iG.getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(h);
            setWidth(this.iG.getWidth());
            setHeight(0);
        }
    }
}
