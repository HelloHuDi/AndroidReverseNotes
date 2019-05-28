package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class l implements b {
    private final String description;

    public static final class a extends l {
        private final int n;

        public a(int i) {
            super("must have at least " + i + " value parameter" + (i > 1 ? "s" : ""), (byte) 0);
            AppMethodBeat.i(122900);
            this.n = i;
            AppMethodBeat.o(122900);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122899);
            j.p(tVar, "functionDescriptor");
            if (tVar.dYV().size() >= this.n) {
                AppMethodBeat.o(122899);
                return true;
            }
            AppMethodBeat.o(122899);
            return false;
        }
    }

    public static final class b extends l {
        private final int n = 2;

        public b() {
            super("must have exactly 2 value parameters", (byte) 0);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122901);
            j.p(tVar, "functionDescriptor");
            if (tVar.dYV().size() == this.n) {
                AppMethodBeat.o(122901);
                return true;
            }
            AppMethodBeat.o(122901);
            return false;
        }
    }

    public static final class c extends l {
        public static final c BMG = new c();

        static {
            AppMethodBeat.i(122903);
            AppMethodBeat.o(122903);
        }

        private c() {
            super("must have no value parameters", (byte) 0);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122902);
            j.p(tVar, "functionDescriptor");
            boolean isEmpty = tVar.dYV().isEmpty();
            AppMethodBeat.o(122902);
            return isEmpty;
        }
    }

    public static final class d extends l {
        public static final d BMH = new d();

        static {
            AppMethodBeat.i(122905);
            AppMethodBeat.o(122905);
        }

        private d() {
            super("must have a single value parameter", (byte) 0);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122904);
            j.p(tVar, "functionDescriptor");
            if (tVar.dYV().size() == 1) {
                AppMethodBeat.o(122904);
                return true;
            }
            AppMethodBeat.o(122904);
            return false;
        }
    }

    private l(String str) {
        this.description = str;
    }

    public /* synthetic */ l(String str, byte b) {
        this(str);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String i(t tVar) {
        j.p(tVar, "functionDescriptor");
        return a.i.b.a.c.m.b.a.a(this, tVar);
    }
}
