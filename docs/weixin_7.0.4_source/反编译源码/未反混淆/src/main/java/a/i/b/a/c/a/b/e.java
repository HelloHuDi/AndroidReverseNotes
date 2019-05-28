package a.i.b.a.c.a.b;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.b.c;
import a.i.b.a.c.b.y;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.h;
import a.i.b.a.c.k.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends g {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    public y BdE;
    public boolean BdF;
    private final f BdG;

    static final class a extends a.f.b.k implements a.f.a.a<f> {
        final /* synthetic */ i BdD;
        final /* synthetic */ e BdH;

        /* renamed from: a.i.b.a.c.a.b.e$a$2 */
        static final class AnonymousClass2 extends a.f.b.k implements a.f.a.a<Boolean> {
            final /* synthetic */ a BdI;

            AnonymousClass2(a aVar) {
                this.BdI = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119202);
                if (this.BdI.BdH.BdE == null) {
                    Throwable assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                    AppMethodBeat.o(119202);
                    throw assertionError;
                }
                Boolean valueOf = Boolean.valueOf(this.BdI.BdH.BdF);
                AppMethodBeat.o(119202);
                return valueOf;
            }
        }

        /* renamed from: a.i.b.a.c.a.b.e$a$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ a BdI;

            AnonymousClass1(a aVar) {
                this.BdI = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119201);
                y a = this.BdI.BdH.BdE;
                if (a == null) {
                    Throwable assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                    AppMethodBeat.o(119201);
                    throw assertionError;
                }
                AppMethodBeat.o(119201);
                return a;
            }
        }

        a(e eVar, i iVar) {
            this.BdH = eVar;
            this.BdD = iVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119203);
            a.i.b.a.c.b.c.v vVar = this.BdH.Bab;
            j.o(vVar, "builtInsModule");
            f fVar = new f(vVar, this.BdD, new AnonymousClass1(this), new AnonymousClass2(this));
            AppMethodBeat.o(119203);
            return fVar;
        }
    }

    static {
        AppMethodBeat.i(119204);
        AppMethodBeat.o(119204);
    }

    public final f dYG() {
        AppMethodBeat.i(119205);
        f fVar = (f) h.a(this.BdG, eQB[0]);
        AppMethodBeat.o(119205);
        return fVar;
    }

    public /* synthetic */ e(i iVar, byte b) {
        this(iVar);
    }

    private e(i iVar) {
        j.p(iVar, "storageManager");
        super(iVar);
        AppMethodBeat.i(119209);
        this.BdF = true;
        this.BdG = iVar.i(new a(this, iVar));
        dXH();
        AppMethodBeat.o(119209);
    }

    public final c dXJ() {
        AppMethodBeat.i(119206);
        c dYG = dYG();
        AppMethodBeat.o(119206);
        return dYG;
    }

    public final a.i.b.a.c.b.b.a dXI() {
        AppMethodBeat.i(119207);
        a.i.b.a.c.b.b.a dYG = dYG();
        AppMethodBeat.o(119207);
        return dYG;
    }

    public final /* synthetic */ Iterable dXK() {
        AppMethodBeat.i(119208);
        Iterable dXK = super.dXK();
        j.o(dXK, "super.getClassDescriptorFactories()");
        i iVar = this.Baf;
        j.o(iVar, "storageManager");
        a.i.b.a.c.b.c.v vVar = this.Bab;
        j.o(vVar, "builtInsModule");
        Iterable d = a.a.t.d(dXK, new d(iVar, vVar));
        AppMethodBeat.o(119208);
        return d;
    }
}
