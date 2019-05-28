package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.t;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class k implements b {
    private final a.f.a.b<g, w> BMz;
    private final String description;
    private final String name;

    public static final class a extends k {
        public static final a BMA = new a();

        static {
            AppMethodBeat.i(122890);
            AppMethodBeat.o(122890);
        }

        private a() {
            super("Boolean", AnonymousClass1.BMB, (byte) 0);
            AppMethodBeat.i(122889);
            AppMethodBeat.o(122889);
        }
    }

    public static final class b extends k {
        public static final b BMC = new b();

        static {
            AppMethodBeat.i(122894);
            AppMethodBeat.o(122894);
        }

        private b() {
            super("Int", AnonymousClass1.BMD, (byte) 0);
            AppMethodBeat.i(122893);
            AppMethodBeat.o(122893);
        }
    }

    public static final class c extends k {
        public static final c BME = new c();

        static {
            AppMethodBeat.i(122898);
            AppMethodBeat.o(122898);
        }

        private c() {
            super("Unit", AnonymousClass1.BMF, (byte) 0);
            AppMethodBeat.i(122897);
            AppMethodBeat.o(122897);
        }
    }

    private k(String str, a.f.a.b<? super g, ? extends w> bVar) {
        this.name = str;
        this.BMz = bVar;
        this.description = "must return " + this.name;
    }

    public /* synthetic */ k(String str, a.f.a.b bVar, byte b) {
        this(str, bVar);
    }

    public final String i(t tVar) {
        j.p(tVar, "functionDescriptor");
        return a.i.b.a.c.m.b.a.a(this, tVar);
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean h(t tVar) {
        j.p(tVar, "functionDescriptor");
        return j.j(tVar.dYT(), (w) this.BMz.am(a.i.b.a.c.i.c.a.G(tVar)));
    }
}
