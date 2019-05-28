package android.support.constraint.a.a;

import android.support.constraint.a.h;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class e {
    int hA = -1;
    b hB = b.NONE;
    private a hC = a.RELAXED;
    int hD = 0;
    public h hE;
    public m hv = new m(this);
    final f hw;
    final c hx;
    public e hy;
    public int hz = 0;

    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    public enum a {
        RELAXED,
        STRICT
    }

    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, c cVar) {
        this.hw = fVar;
        this.hx = cVar;
    }

    public final void aG() {
        if (this.hE == null) {
            this.hE = new h(android.support.constraint.a.h.a.UNRESTRICTED);
        } else {
            this.hE.reset();
        }
    }

    public final int aH() {
        if (this.hw.iZ == 8) {
            return 0;
        }
        if (this.hA < 0 || this.hy == null || this.hy.hw.iZ != 8) {
            return this.hz;
        }
        return this.hA;
    }

    public final void reset() {
        this.hy = null;
        this.hz = 0;
        this.hA = -1;
        this.hB = b.STRONG;
        this.hD = 0;
        this.hC = a.RELAXED;
        this.hv.reset();
    }

    public final boolean a(e eVar, int i, int i2, b bVar, int i3, boolean z) {
        if (eVar == null) {
            this.hy = null;
            this.hz = 0;
            this.hA = -1;
            this.hB = b.NONE;
            this.hD = 2;
            return true;
        } else if (!z && !a(eVar)) {
            return false;
        } else {
            this.hy = eVar;
            if (i > 0) {
                this.hz = i;
            } else {
                this.hz = 0;
            }
            this.hA = i2;
            this.hB = bVar;
            this.hD = i3;
            return true;
        }
    }

    public final boolean isConnected() {
        return this.hy != null;
    }

    private boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        c cVar = eVar.hx;
        if (cVar != this.hx) {
            boolean z;
            switch (this.hx) {
                case CENTER:
                    if (cVar == c.BASELINE || cVar == c.CENTER_X || cVar == c.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    if (cVar == c.LEFT || cVar == c.RIGHT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (eVar.hw instanceof i) {
                        if (z || cVar == c.CENTER_X) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case TOP:
                case BOTTOM:
                    if (cVar == c.TOP || cVar == c.BOTTOM) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (eVar.hw instanceof i) {
                        if (z || cVar == c.CENTER_Y) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.hx.name());
            }
            return z;
        } else if (this.hx != c.BASELINE || (eVar.hw.aS() && this.hw.aS())) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        return this.hw.ja + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.hx.toString();
    }
}
