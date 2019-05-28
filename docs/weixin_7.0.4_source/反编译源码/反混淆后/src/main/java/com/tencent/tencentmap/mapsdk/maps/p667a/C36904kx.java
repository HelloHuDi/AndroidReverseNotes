package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kx */
public final class C36904kx implements C36529kt {
    /* renamed from: a */
    private final C16304ky f15626a;

    protected C36904kx(float f, float f2) {
        AppMethodBeat.m2504i(100272);
        this.f15626a = C16304ky.m25122a(f, f2, f, f2);
        AppMethodBeat.m2505o(100272);
    }

    /* renamed from: a */
    public static C36904kx m61663a(double d, double d2) {
        AppMethodBeat.m2504i(100273);
        C36904kx c36904kx = new C36904kx((float) d, (float) d2);
        AppMethodBeat.m2505o(100273);
        return c36904kx;
    }

    /* renamed from: a */
    public final C16304ky mo29565a() {
        return this.f15626a;
    }

    /* renamed from: a */
    public final boolean mo29566a(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100274);
        boolean a = this.f15626a.mo29566a(c16304ky);
        AppMethodBeat.m2505o(100274);
        return a;
    }

    /* renamed from: b */
    public final float mo58930b() {
        AppMethodBeat.m2504i(100275);
        float c = this.f15626a.mo29568c();
        AppMethodBeat.m2505o(100275);
        return c;
    }

    /* renamed from: c */
    public final float mo58931c() {
        AppMethodBeat.m2504i(100276);
        float d = this.f15626a.mo29570d();
        AppMethodBeat.m2505o(100276);
        return d;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(100277);
        int hashCode = Arrays.hashCode(new Object[]{this.f15626a});
        AppMethodBeat.m2505o(100277);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100278);
        if (obj == null) {
            AppMethodBeat.m2505o(100278);
            return false;
        } else if (obj instanceof C36904kx) {
            C36904kx c36904kx = (C36904kx) obj;
            if (this.f15626a == c36904kx.mo29565a() || (this.f15626a != null && this.f15626a.equals(c36904kx.mo29565a()))) {
                AppMethodBeat.m2505o(100278);
                return true;
            }
            AppMethodBeat.m2505o(100278);
            return false;
        } else {
            AppMethodBeat.m2505o(100278);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(100279);
        String str = "Point [x=" + mo58930b() + ", y=" + mo58931c() + "]";
        AppMethodBeat.m2505o(100279);
        return str;
    }
}
