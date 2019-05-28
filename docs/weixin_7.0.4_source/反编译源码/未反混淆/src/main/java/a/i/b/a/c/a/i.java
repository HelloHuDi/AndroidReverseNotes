package a.i.b.a.c.a;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.aa;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.y;
import a.i.b.a.c.i.e.h;
import a.i.k;
import a.k.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static final b Bcn = new b();
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(i.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), v.a(new t(v.aN(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.aN(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    private final f Bce;
    private final a Bcf = new a(1);
    private final a Bcg = new a(1);
    private final a Bch = new a(2);
    private final a Bci = new a(3);
    private final a Bcj = new a(1);
    private final a Bck = new a(2);
    private final a Bcl = new a(3);
    private final aa Bcm;

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class c extends a.f.b.k implements a.f.a.a<h> {
        final /* synthetic */ y Bcp;

        c(y yVar) {
            this.Bcp = yVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119107);
            h dXR = this.Bcp.g(j.dXT()).dXR();
            AppMethodBeat.o(119107);
            return dXR;
        }
    }

    static final class a {
        final int Bco;

        public a(int i) {
            this.Bco = i;
        }
    }

    static {
        AppMethodBeat.i(119108);
        AppMethodBeat.o(119108);
    }

    public i(y yVar, aa aaVar) {
        j.p(yVar, "module");
        j.p(aaVar, "notFoundClasses");
        AppMethodBeat.i(119110);
        this.Bcm = aaVar;
        this.Bce = a.i.a(a.k.PUBLICATION, new c(yVar));
        AppMethodBeat.o(119110);
    }

    public final e dXS() {
        AppMethodBeat.i(119109);
        a aVar = this.Bcf;
        Object obj = eQB[1];
        j.p(this, "types");
        j.p(obj, "property");
        String capitalize = u.capitalize(obj.getName());
        int i = aVar.Bco;
        a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(capitalize);
        j.o(avX, "Name.identifier(className)");
        a.i.b.a.c.b.h c = ((h) this.Bce.getValue()).c(avX, a.i.b.a.c.c.a.c.FROM_REFLECTION);
        if (!(c instanceof e)) {
            c = null;
        }
        e eVar = (e) c;
        if (eVar == null) {
            eVar = this.Bcm.a(new a.i.b.a.c.f.a(j.dXT(), avX), a.a.k.listOf(Integer.valueOf(i)));
        }
        AppMethodBeat.o(119109);
        return eVar;
    }
}
