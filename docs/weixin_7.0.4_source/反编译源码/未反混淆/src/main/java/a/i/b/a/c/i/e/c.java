package a.i.b.a.c.i.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c {

    public static final class b extends c {
        public static final b BFx = new b();

        static {
            AppMethodBeat.i(122177);
            AppMethodBeat.o(122177);
        }

        private b() {
        }

        public final int ejB() {
            return 0;
        }
    }

    public static final class a extends c {
        private static final int BFv;
        public static final a BFw = new a();

        static {
            AppMethodBeat.i(122176);
            a.i.b.a.c.i.e.d.a aVar = d.BFX;
            int ejJ = d.BFH;
            a.i.b.a.c.i.e.d.a aVar2 = d.BFX;
            int ejH = d.BFF;
            a.i.b.a.c.i.e.d.a aVar3 = d.BFX;
            BFv = ejJ & ((ejH | d.BFG) ^ -1);
            AppMethodBeat.o(122176);
        }

        private a() {
        }

        public final int ejB() {
            return BFv;
        }
    }

    public abstract int ejB();

    public String toString() {
        return getClass().getSimpleName();
    }
}
