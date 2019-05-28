package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class fd implements Cloneable {
    float a;
    Class<?> b;
    boolean c = false;
    private Interpolator d = null;

    static class a extends fd {
        double d;

        public /* synthetic */ Object clone() {
            AppMethodBeat.i(98864);
            a e = e();
            AppMethodBeat.o(98864);
            return e;
        }

        public /* synthetic */ fd d() {
            AppMethodBeat.i(98863);
            a e = e();
            AppMethodBeat.o(98863);
            return e;
        }

        a(float f, double d) {
            this.a = f;
            this.d = d;
            this.b = Double.TYPE;
            this.c = true;
        }

        a(float f) {
            this.a = f;
            this.b = Double.TYPE;
        }

        public Object a() {
            AppMethodBeat.i(98861);
            Double valueOf = Double.valueOf(this.d);
            AppMethodBeat.o(98861);
            return valueOf;
        }

        public a e() {
            AppMethodBeat.i(98862);
            a aVar = new a(b(), this.d);
            aVar.a(c());
            AppMethodBeat.o(98862);
            return aVar;
        }
    }

    static class b extends fd {
        Object d;

        public /* synthetic */ Object clone() {
            AppMethodBeat.i(98868);
            b e = e();
            AppMethodBeat.o(98868);
            return e;
        }

        public /* synthetic */ fd d() {
            AppMethodBeat.i(98867);
            b e = e();
            AppMethodBeat.o(98867);
            return e;
        }

        b(float f, Object obj) {
            AppMethodBeat.i(98865);
            this.a = f;
            this.d = obj;
            this.c = obj != null;
            this.b = this.c ? obj.getClass() : Object.class;
            AppMethodBeat.o(98865);
        }

        public Object a() {
            return this.d;
        }

        public b e() {
            AppMethodBeat.i(98866);
            b bVar = new b(b(), this.d);
            bVar.a(c());
            AppMethodBeat.o(98866);
            return bVar;
        }
    }

    public abstract Object a();

    /* renamed from: d */
    public abstract fd clone();

    public static fd a(float f, double d) {
        return new a(f, d);
    }

    public static fd a(float f) {
        return new a(f);
    }

    public static fd a(float f, Object obj) {
        return new b(f, obj);
    }

    public static fd b(float f) {
        return new b(f, null);
    }

    public float b() {
        return this.a;
    }

    public Interpolator c() {
        return this.d;
    }

    public void a(Interpolator interpolator) {
        this.d = interpolator;
    }
}
