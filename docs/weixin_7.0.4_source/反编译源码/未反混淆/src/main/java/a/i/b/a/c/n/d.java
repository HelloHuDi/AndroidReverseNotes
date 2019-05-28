package a.i.b.a.c.n;

import a.f.a.m;
import a.f.a.q;
import a.f.b.k;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static final a.f.a.b<Object, Object> BMM = f.BMX;
    private static final a.f.a.b<Object, Boolean> BMN = b.BMT;
    private static final a.f.a.b<Object, Object> BMO = a.BMS;
    private static final a.f.a.b<Object, y> BMP = c.BMU;
    private static final m<Object, Object, y> BMQ = d.BMV;
    private static final q<Object, Object, Object, y> BMR = e.BMW;

    static final class b extends k implements a.f.a.b<Object, Boolean> {
        public static final b BMT = new b();

        static {
            AppMethodBeat.i(122929);
            AppMethodBeat.o(122929);
        }

        b() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object am(Object obj) {
            return Boolean.TRUE;
        }
    }

    static final class d extends k implements m<Object, Object, y> {
        public static final d BMV = new d();

        static {
            AppMethodBeat.i(122931);
            AppMethodBeat.o(122931);
        }

        d() {
            super(2);
        }

        public final /* bridge */ /* synthetic */ Object m(Object obj, Object obj2) {
            return y.AUy;
        }
    }

    static final class a extends k implements a.f.a.b {
        public static final a BMS = new a();

        static {
            AppMethodBeat.i(122928);
            AppMethodBeat.o(122928);
        }

        a() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object am(Object obj) {
            return null;
        }
    }

    static final class c extends k implements a.f.a.b<Object, y> {
        public static final c BMU = new c();

        static {
            AppMethodBeat.i(122930);
            AppMethodBeat.o(122930);
        }

        c() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object am(Object obj) {
            return y.AUy;
        }
    }

    static final class f extends k implements a.f.a.b<Object, Object> {
        public static final f BMX = new f();

        static {
            AppMethodBeat.i(122933);
            AppMethodBeat.o(122933);
        }

        f() {
            super(1);
        }

        public final Object am(Object obj) {
            return obj;
        }
    }

    static final class e extends k implements q<Object, Object, Object, y> {
        public static final e BMW = new e();

        static {
            AppMethodBeat.i(122932);
            AppMethodBeat.o(122932);
        }

        e() {
            super(3);
        }

        public final /* bridge */ /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            return y.AUy;
        }
    }

    public static final <T> a.f.a.b<T, Boolean> eku() {
        return BMN;
    }

    public static final m<Object, Object, y> ekv() {
        return BMQ;
    }

    public static final q<Object, Object, Object, y> ekw() {
        return BMR;
    }
}
