package a.i.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    private static final Object AYw = new Object() {
        public final String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean BNx = false;

    public static class b extends RuntimeException {
        public b(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    static final class a {
        final Throwable xEP;

        /* synthetic */ a(Throwable th, byte b) {
            this(th);
        }

        private a(Throwable th) {
            this.xEP = th;
        }

        public final String toString() {
            AppMethodBeat.i(122974);
            String th = this.xEP.toString();
            AppMethodBeat.o(122974);
            return th;
        }
    }

    static {
        AppMethodBeat.i(122978);
        AppMethodBeat.o(122978);
    }

    public static <V> Object dW(V v) {
        if (v == null) {
            return AYw;
        }
        return v;
    }

    public static Object s(Throwable th) {
        AppMethodBeat.i(122975);
        a aVar = new a(th, (byte) 0);
        AppMethodBeat.o(122975);
        return aVar;
    }

    public static <V> V dX(Object obj) {
        AppMethodBeat.i(122976);
        V dY = dY(obj);
        if (dY == AYw) {
            AppMethodBeat.o(122976);
            return null;
        }
        AppMethodBeat.o(122976);
        return dY;
    }

    public static <V> V dY(Object obj) {
        AppMethodBeat.i(122977);
        if (obj instanceof a) {
            Throwable th = ((a) obj).xEP;
            if (BNx && c.r(th)) {
                b bVar = new b(th);
                AppMethodBeat.o(122977);
                throw bVar;
            }
            a.f.b.j.p(th, "e");
            AppMethodBeat.o(122977);
            throw th;
        }
        AppMethodBeat.o(122977);
        return obj;
    }
}
