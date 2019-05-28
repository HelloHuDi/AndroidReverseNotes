package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cp;

public class iv implements gf {
    private iz a;

    public iv(iz izVar) {
        this.a = izVar;
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99876);
        if (this.a == null) {
            AppMethodBeat.o(99876);
            return false;
        } else if (!this.a.H) {
            AppMethodBeat.o(99876);
            return false;
        } else if (this.a.k == null || !this.a.H) {
            AppMethodBeat.o(99876);
            return false;
        } else {
            boolean a = this.a.k.a(f, f2);
            AppMethodBeat.o(99876);
            return a;
        }
    }

    public boolean b(float f, float f2) {
        AppMethodBeat.i(99877);
        if (this.a == null) {
            AppMethodBeat.o(99877);
            return false;
        } else if (this.a.H) {
            if (!this.a.d(f, f2)) {
                this.a.b(f, f2);
            }
            if (this.a.k == null || !this.a.H) {
                AppMethodBeat.o(99877);
                return false;
            }
            boolean b = this.a.k.b(f, f2);
            AppMethodBeat.o(99877);
            return b;
        } else {
            AppMethodBeat.o(99877);
            return false;
        }
    }

    public boolean c(float f, float f2) {
        AppMethodBeat.i(99878);
        if (this.a == null) {
            AppMethodBeat.o(99878);
            return false;
        } else if (!this.a.H) {
            AppMethodBeat.o(99878);
            return false;
        } else if (this.a.k != null) {
            boolean c = this.a.k.c(f, f2);
            AppMethodBeat.o(99878);
            return c;
        } else {
            AppMethodBeat.o(99878);
            return false;
        }
    }

    public boolean d(float f, float f2) {
        AppMethodBeat.i(99879);
        if (this.a == null) {
            AppMethodBeat.o(99879);
            return false;
        } else if (!this.a.H) {
            AppMethodBeat.o(99879);
            return false;
        } else if (this.a.k != null) {
            boolean d = this.a.k.d(f, f2);
            AppMethodBeat.o(99879);
            return d;
        } else {
            AppMethodBeat.o(99879);
            return false;
        }
    }

    public boolean e(float f, float f2) {
        AppMethodBeat.i(99880);
        if (this.a == null) {
            AppMethodBeat.o(99880);
            return false;
        } else if (this.a.H) {
            this.a.a(f, f2);
            if (this.a.k != null) {
                boolean e = this.a.k.e(f, f2);
                AppMethodBeat.o(99880);
                return e;
            }
            AppMethodBeat.o(99880);
            return false;
        } else {
            AppMethodBeat.o(99880);
            return false;
        }
    }

    public boolean f(float f, float f2) {
        return false;
    }

    public boolean g(float f, float f2) {
        return false;
    }

    public boolean h(float f, float f2) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean a(float f) {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, float f) {
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        return false;
    }

    public boolean i(float f, float f2) {
        AppMethodBeat.i(99881);
        if (this.a == null) {
            AppMethodBeat.o(99881);
            return false;
        } else if (this.a.H) {
            iz izVar = this.a;
            izVar.L++;
            if (this.a.k != null) {
                boolean f3 = this.a.k.f(f, f2);
                AppMethodBeat.o(99881);
                return f3;
            }
            AppMethodBeat.o(99881);
            return false;
        } else {
            AppMethodBeat.o(99881);
            return false;
        }
    }

    public boolean j(float f, float f2) {
        AppMethodBeat.i(99882);
        if (this.a == null) {
            AppMethodBeat.o(99882);
            return false;
        } else if (this.a.H) {
            int i;
            iz izVar = this.a;
            if (this.a.L > 0) {
                iz izVar2 = this.a;
                i = izVar2.L - 1;
                izVar2.L = i;
            } else {
                i = 0;
            }
            izVar.L = i;
            if (this.a.K && this.a.J && this.a.L == 0) {
                cp p = this.a.p();
                if (p == null) {
                    AppMethodBeat.o(99882);
                    return false;
                }
                this.a.onCameraChangeFinished(p);
            }
            if (this.a.k != null) {
                boolean g = this.a.k.g(f, f2);
                AppMethodBeat.o(99882);
                return g;
            }
            AppMethodBeat.o(99882);
            return false;
        } else {
            AppMethodBeat.o(99882);
            return false;
        }
    }

    public void a() {
    }

    public boolean k(float f, float f2) {
        return false;
    }
}
