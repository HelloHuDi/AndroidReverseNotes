package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cp */
public final class C5841cp {
    /* renamed from: a */
    public C24343db f1462a;
    /* renamed from: b */
    public final float f1463b;
    /* renamed from: c */
    public final float f1464c;
    /* renamed from: d */
    public final float f1465d;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.cp$a */
    public static final class C5842a {
        /* renamed from: a */
        private C24343db f1466a;
        /* renamed from: b */
        private float f1467b;
        /* renamed from: c */
        private float f1468c = Float.MIN_VALUE;
        /* renamed from: d */
        private float f1469d = Float.MIN_VALUE;

        /* renamed from: a */
        public final C5842a mo12326a(C24343db c24343db) {
            this.f1466a = c24343db;
            return this;
        }

        /* renamed from: a */
        public final C5842a mo12325a(float f) {
            this.f1467b = f;
            return this;
        }

        /* renamed from: b */
        public final C5842a mo12328b(float f) {
            this.f1468c = f;
            return this;
        }

        /* renamed from: c */
        public final C5842a mo12329c(float f) {
            this.f1469d = f;
            return this;
        }

        /* renamed from: a */
        public final C5841cp mo12327a() {
            AppMethodBeat.m2504i(100951);
            C5841cp c5841cp = new C5841cp(this.f1466a, this.f1467b, this.f1468c, this.f1469d);
            AppMethodBeat.m2505o(100951);
            return c5841cp;
        }
    }

    C5841cp(int i, C24343db c24343db, float f, float f2, float f3) {
        this.f1462a = c24343db;
        this.f1463b = f;
        this.f1464c = f2;
        this.f1465d = f3;
    }

    public C5841cp(C24343db c24343db, float f, float f2, float f3) {
        this(1, c24343db, f, f2, f3);
    }

    /* renamed from: a */
    public static C5842a m8926a() {
        AppMethodBeat.m2504i(100952);
        C5842a c5842a = new C5842a();
        AppMethodBeat.m2505o(100952);
        return c5842a;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100953);
        if (this == obj) {
            AppMethodBeat.m2505o(100953);
            return true;
        } else if (obj instanceof C5841cp) {
            C5841cp c5841cp = (C5841cp) obj;
            if (this.f1462a.equals(c5841cp.f1462a) && Float.floatToIntBits(this.f1463b) == Float.floatToIntBits(c5841cp.f1463b) && Float.floatToIntBits(this.f1464c) == Float.floatToIntBits(c5841cp.f1464c) && Float.floatToIntBits(this.f1465d) == Float.floatToIntBits(c5841cp.f1465d)) {
                AppMethodBeat.m2505o(100953);
                return true;
            }
            AppMethodBeat.m2505o(100953);
            return false;
        } else {
            AppMethodBeat.m2505o(100953);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(100954);
        String str = "latlng:" + this.f1462a.f4615a + "," + this.f1462a.f4616b + ",zoom:" + this.f1463b + ",tilt=" + this.f1464c + ",bearing:" + this.f1465d;
        AppMethodBeat.m2505o(100954);
        return str;
    }
}
