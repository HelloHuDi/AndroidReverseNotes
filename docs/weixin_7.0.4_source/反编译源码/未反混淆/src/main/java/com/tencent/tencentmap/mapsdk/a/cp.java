package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cp {
    public db a;
    public final float b;
    public final float c;
    public final float d;

    public static final class a {
        private db a;
        private float b;
        private float c = Float.MIN_VALUE;
        private float d = Float.MIN_VALUE;

        public final a a(db dbVar) {
            this.a = dbVar;
            return this;
        }

        public final a a(float f) {
            this.b = f;
            return this;
        }

        public final a b(float f) {
            this.c = f;
            return this;
        }

        public final a c(float f) {
            this.d = f;
            return this;
        }

        public final cp a() {
            AppMethodBeat.i(100951);
            cp cpVar = new cp(this.a, this.b, this.c, this.d);
            AppMethodBeat.o(100951);
            return cpVar;
        }
    }

    cp(int i, db dbVar, float f, float f2, float f3) {
        this.a = dbVar;
        this.b = f;
        this.c = f2;
        this.d = f3;
    }

    public cp(db dbVar, float f, float f2, float f3) {
        this(1, dbVar, f, f2, f3);
    }

    public static a a() {
        AppMethodBeat.i(100952);
        a aVar = new a();
        AppMethodBeat.o(100952);
        return aVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100953);
        if (this == obj) {
            AppMethodBeat.o(100953);
            return true;
        } else if (obj instanceof cp) {
            cp cpVar = (cp) obj;
            if (this.a.equals(cpVar.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(cpVar.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(cpVar.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(cpVar.d)) {
                AppMethodBeat.o(100953);
                return true;
            }
            AppMethodBeat.o(100953);
            return false;
        } else {
            AppMethodBeat.o(100953);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(100954);
        String str = "latlng:" + this.a.a + "," + this.a.b + ",zoom:" + this.b + ",tilt=" + this.c + ",bearing:" + this.d;
        AppMethodBeat.o(100954);
        return str;
    }
}
