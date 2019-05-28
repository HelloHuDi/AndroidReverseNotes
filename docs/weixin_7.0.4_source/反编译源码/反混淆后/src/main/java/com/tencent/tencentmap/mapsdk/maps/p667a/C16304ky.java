package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ky */
public final class C16304ky implements C36529kt, C31074kv {
    /* renamed from: a */
    private final float f3480a;
    /* renamed from: b */
    private final float f3481b;
    /* renamed from: c */
    private final float f3482c;
    /* renamed from: d */
    private final float f3483d;

    protected C16304ky(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(100280);
        this.f3480a = Math.min(f, f3);
        this.f3481b = Math.min(f2, f4);
        this.f3482c = Math.max(f, f3);
        this.f3483d = Math.max(f2, f4);
        AppMethodBeat.m2505o(100280);
    }

    /* renamed from: c */
    public final float mo29568c() {
        return this.f3480a;
    }

    /* renamed from: d */
    public final float mo29570d() {
        return this.f3481b;
    }

    /* renamed from: e */
    public final float mo29571e() {
        return this.f3482c;
    }

    /* renamed from: f */
    public final float mo29573f() {
        return this.f3483d;
    }

    /* renamed from: g */
    public final float mo29574g() {
        return (this.f3482c - this.f3480a) * (this.f3483d - this.f3481b);
    }

    /* renamed from: b */
    public final C16304ky mo29567b(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100281);
        C16304ky c16304ky2 = new C16304ky(Math.min(this.f3480a, c16304ky.f3480a), Math.min(this.f3481b, c16304ky.f3481b), Math.max(this.f3482c, c16304ky.f3482c), Math.max(this.f3483d, c16304ky.f3483d));
        AppMethodBeat.m2505o(100281);
        return c16304ky2;
    }

    /* renamed from: a */
    public static C16304ky m25121a(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(100282);
        C16304ky c16304ky = new C16304ky((float) d, (float) d2, (float) d3, (float) d4);
        AppMethodBeat.m2505o(100282);
        return c16304ky;
    }

    /* renamed from: a */
    public static C16304ky m25122a(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(100283);
        C16304ky c16304ky = new C16304ky(f, f2, f3, f4);
        AppMethodBeat.m2505o(100283);
        return c16304ky;
    }

    /* renamed from: a */
    public final boolean mo29566a(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100284);
        if (Math.min(this.f3482c, c16304ky.f3482c) < Math.max(this.f3480a, c16304ky.f3480a)) {
            AppMethodBeat.m2505o(100284);
            return false;
        }
        if (Math.min(this.f3483d, c16304ky.f3483d) >= Math.max(this.f3481b, c16304ky.f3481b)) {
            AppMethodBeat.m2505o(100284);
            return true;
        }
        AppMethodBeat.m2505o(100284);
        return false;
    }

    /* renamed from: a */
    public final C16304ky mo29565a() {
        return this;
    }

    public final String toString() {
        AppMethodBeat.m2504i(100285);
        String str = "Rectangle [x1=" + this.f3480a + ", y1=" + this.f3481b + ", x2=" + this.f3482c + ", y2=" + this.f3483d + "]";
        AppMethodBeat.m2505o(100285);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(100286);
        int hashCode = Arrays.hashCode(new Object[]{Float.valueOf(this.f3480a), Float.valueOf(this.f3481b), Float.valueOf(this.f3482c), Float.valueOf(this.f3483d)});
        AppMethodBeat.m2505o(100286);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100287);
        if (obj == null) {
            AppMethodBeat.m2505o(100287);
            return false;
        } else if (obj instanceof C16304ky) {
            C16304ky c16304ky = (C16304ky) obj;
            if (m25123a(this.f3480a, c16304ky.f3480a) && m25123a(this.f3482c, c16304ky.f3482c) && m25123a(this.f3481b, c16304ky.f3481b) && m25123a(this.f3483d, c16304ky.f3483d)) {
                AppMethodBeat.m2505o(100287);
                return true;
            }
            AppMethodBeat.m2505o(100287);
            return false;
        } else {
            AppMethodBeat.m2505o(100287);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m25123a(float f, float f2) {
        AppMethodBeat.m2504i(100288);
        if (Float.floatToIntBits(f) == Float.floatToIntBits(f2)) {
            AppMethodBeat.m2505o(100288);
            return true;
        }
        AppMethodBeat.m2505o(100288);
        return false;
    }

    /* renamed from: c */
    public final float mo29569c(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100289);
        if (mo29566a(c16304ky)) {
            float g = C16304ky.m25122a(Math.max(this.f3480a, c16304ky.f3480a), Math.max(this.f3481b, c16304ky.f3481b), Math.min(this.f3482c, c16304ky.f3482c), Math.min(this.f3483d, c16304ky.f3483d)).mo29574g();
            AppMethodBeat.m2505o(100289);
            return g;
        }
        AppMethodBeat.m2505o(100289);
        return 0.0f;
    }

    /* renamed from: h */
    public final float mo29575h() {
        return ((this.f3482c - this.f3480a) * 2.0f) + ((this.f3483d - this.f3481b) * 2.0f);
    }

    /* renamed from: b */
    public final C36529kt mo29553b() {
        return this;
    }
}
