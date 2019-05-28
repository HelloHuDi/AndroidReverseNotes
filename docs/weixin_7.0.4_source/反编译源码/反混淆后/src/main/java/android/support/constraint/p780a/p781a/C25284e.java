package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.C41479h.C41480a;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: android.support.constraint.a.a.e */
public final class C25284e {
    /* renamed from: hA */
    int f5024hA = -1;
    /* renamed from: hB */
    C25285b f5025hB = C25285b.NONE;
    /* renamed from: hC */
    private C25286a f5026hC = C25286a.RELAXED;
    /* renamed from: hD */
    int f5027hD = 0;
    /* renamed from: hE */
    public C41479h f5028hE;
    /* renamed from: hv */
    public C41476m f5029hv = new C41476m(this);
    /* renamed from: hw */
    final C17368f f5030hw;
    /* renamed from: hx */
    final C25287c f5031hx;
    /* renamed from: hy */
    public C25284e f5032hy;
    /* renamed from: hz */
    public int f5033hz = 0;

    /* renamed from: android.support.constraint.a.a.e$b */
    public enum C25285b {
        NONE,
        STRONG,
        WEAK
    }

    /* renamed from: android.support.constraint.a.a.e$a */
    public enum C25286a {
        RELAXED,
        STRICT
    }

    /* renamed from: android.support.constraint.a.a.e$c */
    public enum C25287c {
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

    public C25284e(C17368f c17368f, C25287c c25287c) {
        this.f5030hw = c17368f;
        this.f5031hx = c25287c;
    }

    /* renamed from: aG */
    public final void mo42137aG() {
        if (this.f5028hE == null) {
            this.f5028hE = new C41479h(C41480a.UNRESTRICTED);
        } else {
            this.f5028hE.reset();
        }
    }

    /* renamed from: aH */
    public final int mo42138aH() {
        if (this.f5030hw.f3638iZ == 8) {
            return 0;
        }
        if (this.f5024hA < 0 || this.f5032hy == null || this.f5032hy.f5030hw.f3638iZ != 8) {
            return this.f5033hz;
        }
        return this.f5024hA;
    }

    public final void reset() {
        this.f5032hy = null;
        this.f5033hz = 0;
        this.f5024hA = -1;
        this.f5025hB = C25285b.STRONG;
        this.f5027hD = 0;
        this.f5026hC = C25286a.RELAXED;
        this.f5029hv.reset();
    }

    /* renamed from: a */
    public final boolean mo42136a(C25284e c25284e, int i, int i2, C25285b c25285b, int i3, boolean z) {
        if (c25284e == null) {
            this.f5032hy = null;
            this.f5033hz = 0;
            this.f5024hA = -1;
            this.f5025hB = C25285b.NONE;
            this.f5027hD = 2;
            return true;
        } else if (!z && !m39848a(c25284e)) {
            return false;
        } else {
            this.f5032hy = c25284e;
            if (i > 0) {
                this.f5033hz = i;
            } else {
                this.f5033hz = 0;
            }
            this.f5024hA = i2;
            this.f5025hB = c25285b;
            this.f5027hD = i3;
            return true;
        }
    }

    public final boolean isConnected() {
        return this.f5032hy != null;
    }

    /* renamed from: a */
    private boolean m39848a(C25284e c25284e) {
        if (c25284e == null) {
            return false;
        }
        C25287c c25287c = c25284e.f5031hx;
        if (c25287c != this.f5031hx) {
            boolean z;
            switch (this.f5031hx) {
                case CENTER:
                    if (c25287c == C25287c.BASELINE || c25287c == C25287c.CENTER_X || c25287c == C25287c.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    if (c25287c == C25287c.LEFT || c25287c == C25287c.RIGHT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (c25284e.f5030hw instanceof C41471i) {
                        if (z || c25287c == C25287c.CENTER_X) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case TOP:
                case BOTTOM:
                    if (c25287c == C25287c.TOP || c25287c == C25287c.BOTTOM) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (c25284e.f5030hw instanceof C41471i) {
                        if (z || c25287c == C25287c.CENTER_Y) {
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
                    throw new AssertionError(this.f5031hx.name());
            }
            return z;
        } else if (this.f5031hx != C25287c.BASELINE || (c25284e.f5030hw.mo31463aS() && this.f5030hw.mo31463aS())) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        return this.f5030hw.f3661ja + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.f5031hx.toString();
    }
}
