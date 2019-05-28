package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f implements b {
    private final String description;

    public static final class b extends f {
        public static final b BLE = new b();

        static {
            AppMethodBeat.i(122870);
            AppMethodBeat.o(122870);
        }

        private b() {
            super("must be a member or an extension function", (byte) 0);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122869);
            j.p(tVar, "functionDescriptor");
            if (tVar.dYR() == null && tVar.dYQ() == null) {
                AppMethodBeat.o(122869);
                return false;
            }
            AppMethodBeat.o(122869);
            return true;
        }
    }

    public static final class a extends f {
        public static final a BLD = new a();

        static {
            AppMethodBeat.i(122868);
            AppMethodBeat.o(122868);
        }

        private a() {
            super("must be a member function", (byte) 0);
        }

        public final boolean h(t tVar) {
            AppMethodBeat.i(122867);
            j.p(tVar, "functionDescriptor");
            if (tVar.dYR() != null) {
                AppMethodBeat.o(122867);
                return true;
            }
            AppMethodBeat.o(122867);
            return false;
        }
    }

    private f(String str) {
        this.description = str;
    }

    public /* synthetic */ f(String str, byte b) {
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
