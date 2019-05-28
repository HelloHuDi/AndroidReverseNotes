package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dc */
public final class C24345dc {
    /* renamed from: a */
    public final C24343db f4617a;
    /* renamed from: b */
    public final C24343db f4618b;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.dc$a */
    public static final class C5845a {
        /* renamed from: a */
        private double f1481a = Double.POSITIVE_INFINITY;
        /* renamed from: b */
        private double f1482b = Double.NEGATIVE_INFINITY;
        /* renamed from: c */
        private double f1483c = Double.NaN;
        /* renamed from: d */
        private double f1484d = Double.NaN;

        /* renamed from: a */
        public final C5845a mo12368a(C24343db c24343db) {
            AppMethodBeat.m2504i(100991);
            this.f1481a = Math.min(this.f1481a, c24343db.f4615a);
            this.f1482b = Math.max(this.f1482b, c24343db.f4615a);
            double d = c24343db.f4616b;
            if (Double.isNaN(this.f1483c)) {
                this.f1483c = d;
            } else {
                if (!m8968a(d)) {
                    if (C24345dc.m37561a(this.f1483c, d) < C24345dc.m37563b(this.f1484d, d)) {
                        this.f1483c = d;
                    }
                }
                AppMethodBeat.m2505o(100991);
                return this;
            }
            this.f1484d = d;
            AppMethodBeat.m2505o(100991);
            return this;
        }

        /* renamed from: a */
        public final C5845a mo12369a(Iterable<C24343db> iterable) {
            AppMethodBeat.m2504i(100992);
            if (iterable != null) {
                for (C24343db a : iterable) {
                    mo12368a(a);
                }
            }
            AppMethodBeat.m2505o(100992);
            return this;
        }

        /* renamed from: a */
        private boolean m8968a(double d) {
            if (this.f1483c <= this.f1484d) {
                if (this.f1483c > d || d > this.f1484d) {
                    return false;
                }
                return true;
            } else if (this.f1483c <= d || d <= this.f1484d) {
                return true;
            } else {
                return false;
            }
        }

        /* renamed from: a */
        public final C24345dc mo12370a() {
            AppMethodBeat.m2504i(100993);
            C24345dc c24345dc = new C24345dc(new C24343db(this.f1481a, this.f1483c), new C24343db(this.f1482b, this.f1484d));
            AppMethodBeat.m2505o(100993);
            return c24345dc;
        }
    }

    public C24345dc(C24343db c24343db, C24343db c24343db2) {
        this.f4617a = c24343db;
        this.f4618b = c24343db2;
    }

    /* renamed from: a */
    public static C5845a m37562a() {
        AppMethodBeat.m2504i(100994);
        C5845a c5845a = new C5845a();
        AppMethodBeat.m2505o(100994);
        return c5845a;
    }

    /* renamed from: c */
    private static double m37564c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: d */
    private static double m37565d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100995);
        if (this == obj) {
            AppMethodBeat.m2505o(100995);
            return true;
        } else if (obj instanceof C24345dc) {
            C24345dc c24345dc = (C24345dc) obj;
            if (this.f4617a.equals(c24345dc.f4617a) && this.f4618b.equals(c24345dc.f4618b)) {
                AppMethodBeat.m2505o(100995);
                return true;
            }
            AppMethodBeat.m2505o(100995);
            return false;
        } else {
            AppMethodBeat.m2505o(100995);
            return false;
        }
    }

    /* renamed from: a */
    static double m37561a(double d, double d2) {
        AppMethodBeat.m2504i(100996);
        double c = C24345dc.m37564c(d, d2);
        AppMethodBeat.m2505o(100996);
        return c;
    }

    /* renamed from: b */
    static double m37563b(double d, double d2) {
        AppMethodBeat.m2504i(100997);
        double d3 = C24345dc.m37565d(d, d2);
        AppMethodBeat.m2505o(100997);
        return d3;
    }
}
