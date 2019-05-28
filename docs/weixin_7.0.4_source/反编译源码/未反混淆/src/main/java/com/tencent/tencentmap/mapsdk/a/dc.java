package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dc {
    public final db a;
    public final db b;

    public static final class a {
        private double a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;

        public final a a(db dbVar) {
            AppMethodBeat.i(100991);
            this.a = Math.min(this.a, dbVar.a);
            this.b = Math.max(this.b, dbVar.a);
            double d = dbVar.b;
            if (Double.isNaN(this.c)) {
                this.c = d;
            } else {
                if (!a(d)) {
                    if (dc.a(this.c, d) < dc.b(this.d, d)) {
                        this.c = d;
                    }
                }
                AppMethodBeat.o(100991);
                return this;
            }
            this.d = d;
            AppMethodBeat.o(100991);
            return this;
        }

        public final a a(Iterable<db> iterable) {
            AppMethodBeat.i(100992);
            if (iterable != null) {
                for (db a : iterable) {
                    a(a);
                }
            }
            AppMethodBeat.o(100992);
            return this;
        }

        private boolean a(double d) {
            if (this.c <= this.d) {
                if (this.c > d || d > this.d) {
                    return false;
                }
                return true;
            } else if (this.c <= d || d <= this.d) {
                return true;
            } else {
                return false;
            }
        }

        public final dc a() {
            AppMethodBeat.i(100993);
            dc dcVar = new dc(new db(this.a, this.c), new db(this.b, this.d));
            AppMethodBeat.o(100993);
            return dcVar;
        }
    }

    public dc(db dbVar, db dbVar2) {
        this.a = dbVar;
        this.b = dbVar2;
    }

    public static a a() {
        AppMethodBeat.i(100994);
        a aVar = new a();
        AppMethodBeat.o(100994);
        return aVar;
    }

    private static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100995);
        if (this == obj) {
            AppMethodBeat.o(100995);
            return true;
        } else if (obj instanceof dc) {
            dc dcVar = (dc) obj;
            if (this.a.equals(dcVar.a) && this.b.equals(dcVar.b)) {
                AppMethodBeat.o(100995);
                return true;
            }
            AppMethodBeat.o(100995);
            return false;
        } else {
            AppMethodBeat.o(100995);
            return false;
        }
    }

    static double a(double d, double d2) {
        AppMethodBeat.i(100996);
        double c = c(d, d2);
        AppMethodBeat.o(100996);
        return c;
    }

    static double b(double d, double d2) {
        AppMethodBeat.i(100997);
        double d3 = d(d, d2);
        AppMethodBeat.o(100997);
        return d3;
    }
}
