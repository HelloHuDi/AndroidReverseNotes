package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C5841cp;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iv */
public class C46794iv implements C44513gf {
    /* renamed from: a */
    private C31061iz f18238a;

    public C46794iv(C31061iz c31061iz) {
        this.f18238a = c31061iz;
    }

    /* renamed from: a */
    public boolean mo12458a(float f, float f2) {
        AppMethodBeat.m2504i(99876);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99876);
            return false;
        } else if (!this.f18238a.f14194H) {
            AppMethodBeat.m2505o(99876);
            return false;
        } else if (this.f18238a.f14276k == null || !this.f18238a.f14194H) {
            AppMethodBeat.m2505o(99876);
            return false;
        } else {
            boolean a = this.f18238a.f14276k.mo29185a(f, f2);
            AppMethodBeat.m2505o(99876);
            return a;
        }
    }

    /* renamed from: b */
    public boolean mo12463b(float f, float f2) {
        AppMethodBeat.m2504i(99877);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99877);
            return false;
        } else if (this.f18238a.f14194H) {
            if (!this.f18238a.mo50469d(f, f2)) {
                this.f18238a.mo50461b(f, f2);
            }
            if (this.f18238a.f14276k == null || !this.f18238a.f14194H) {
                AppMethodBeat.m2505o(99877);
                return false;
            }
            boolean b = this.f18238a.f14276k.mo29186b(f, f2);
            AppMethodBeat.m2505o(99877);
            return b;
        } else {
            AppMethodBeat.m2505o(99877);
            return false;
        }
    }

    /* renamed from: c */
    public boolean mo12465c(float f, float f2) {
        AppMethodBeat.m2504i(99878);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99878);
            return false;
        } else if (!this.f18238a.f14194H) {
            AppMethodBeat.m2505o(99878);
            return false;
        } else if (this.f18238a.f14276k != null) {
            boolean c = this.f18238a.f14276k.mo29187c(f, f2);
            AppMethodBeat.m2505o(99878);
            return c;
        } else {
            AppMethodBeat.m2505o(99878);
            return false;
        }
    }

    /* renamed from: d */
    public boolean mo12467d(float f, float f2) {
        AppMethodBeat.m2504i(99879);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99879);
            return false;
        } else if (!this.f18238a.f14194H) {
            AppMethodBeat.m2505o(99879);
            return false;
        } else if (this.f18238a.f14276k != null) {
            boolean d = this.f18238a.f14276k.mo29188d(f, f2);
            AppMethodBeat.m2505o(99879);
            return d;
        } else {
            AppMethodBeat.m2505o(99879);
            return false;
        }
    }

    /* renamed from: e */
    public boolean mo12468e(float f, float f2) {
        AppMethodBeat.m2504i(99880);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99880);
            return false;
        } else if (this.f18238a.f14194H) {
            this.f18238a.mo50452a(f, f2);
            if (this.f18238a.f14276k != null) {
                boolean e = this.f18238a.f14276k.mo29189e(f, f2);
                AppMethodBeat.m2505o(99880);
                return e;
            }
            AppMethodBeat.m2505o(99880);
            return false;
        } else {
            AppMethodBeat.m2505o(99880);
            return false;
        }
    }

    /* renamed from: f */
    public boolean mo12469f(float f, float f2) {
        return false;
    }

    /* renamed from: g */
    public boolean mo12470g(float f, float f2) {
        return false;
    }

    /* renamed from: h */
    public boolean mo12471h(float f, float f2) {
        return false;
    }

    /* renamed from: b */
    public boolean mo12462b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo12464c() {
        return false;
    }

    /* renamed from: a */
    public boolean mo12457a(float f) {
        return false;
    }

    /* renamed from: d */
    public boolean mo12466d() {
        return false;
    }

    /* renamed from: a */
    public boolean mo12460a(PointF pointF, PointF pointF2, float f) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12459a(PointF pointF, PointF pointF2, double d, double d2) {
        return false;
    }

    /* renamed from: i */
    public boolean mo12472i(float f, float f2) {
        AppMethodBeat.m2504i(99881);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99881);
            return false;
        } else if (this.f18238a.f14194H) {
            C31061iz c31061iz = this.f18238a;
            c31061iz.f14198L++;
            if (this.f18238a.f14276k != null) {
                boolean f3 = this.f18238a.f14276k.mo29190f(f, f2);
                AppMethodBeat.m2505o(99881);
                return f3;
            }
            AppMethodBeat.m2505o(99881);
            return false;
        } else {
            AppMethodBeat.m2505o(99881);
            return false;
        }
    }

    /* renamed from: j */
    public boolean mo12473j(float f, float f2) {
        AppMethodBeat.m2504i(99882);
        if (this.f18238a == null) {
            AppMethodBeat.m2505o(99882);
            return false;
        } else if (this.f18238a.f14194H) {
            int i;
            C31061iz c31061iz = this.f18238a;
            if (this.f18238a.f14198L > 0) {
                C31061iz c31061iz2 = this.f18238a;
                i = c31061iz2.f14198L - 1;
                c31061iz2.f14198L = i;
            } else {
                i = 0;
            }
            c31061iz.f14198L = i;
            if (this.f18238a.f14197K && this.f18238a.f14196J && this.f18238a.f14198L == 0) {
                C5841cp p = this.f18238a.mo50479p();
                if (p == null) {
                    AppMethodBeat.m2505o(99882);
                    return false;
                }
                this.f18238a.onCameraChangeFinished(p);
            }
            if (this.f18238a.f14276k != null) {
                boolean g = this.f18238a.f14276k.mo29191g(f, f2);
                AppMethodBeat.m2505o(99882);
                return g;
            }
            AppMethodBeat.m2505o(99882);
            return false;
        } else {
            AppMethodBeat.m2505o(99882);
            return false;
        }
    }

    /* renamed from: a */
    public void mo12455a() {
    }

    /* renamed from: k */
    public boolean mo12474k(float f, float f2) {
        return false;
    }
}
