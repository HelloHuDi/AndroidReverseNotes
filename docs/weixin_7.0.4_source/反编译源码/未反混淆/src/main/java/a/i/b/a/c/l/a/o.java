package a.i.b.a.c.l.a;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.at;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import a.i.b.a.c.n.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;

public final class o {
    int BKE;
    private boolean BKF;
    ArrayDeque<ad> BKG;
    Set<ad> BKH;
    final boolean BKI;
    private final boolean BKJ;

    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        static {
            AppMethodBeat.o(122763);
        }
    }

    public static abstract class c {

        public static final class d extends c {
            public static final d BKV = new d();

            static {
                AppMethodBeat.i(122776);
                AppMethodBeat.o(122776);
            }

            private d() {
                super();
            }

            public final ad aJ(w wVar) {
                AppMethodBeat.i(122775);
                j.p(wVar, "type");
                ad al = t.al(wVar);
                AppMethodBeat.o(122775);
                return al;
            }
        }

        public static final class a extends c {
            public static final a BKT = new a();

            static {
                AppMethodBeat.i(122770);
                AppMethodBeat.o(122770);
            }

            private a() {
                super();
            }

            public final ad aJ(w wVar) {
                AppMethodBeat.i(122769);
                j.p(wVar, "type");
                ad ak = t.ak(wVar);
                AppMethodBeat.o(122769);
                return ak;
            }
        }

        public static final class b extends c {
            private final au BGk;

            public b(au auVar) {
                j.p(auVar, "substitutor");
                super();
                AppMethodBeat.i(122772);
                this.BGk = auVar;
                AppMethodBeat.o(122772);
            }

            public final ad aJ(w wVar) {
                AppMethodBeat.i(122771);
                j.p(wVar, "type");
                w b = this.BGk.b((w) t.ak(wVar), ba.INVARIANT);
                j.o(b, "substitutor.safeSubstitu…le(), Variance.INVARIANT)");
                ad av = at.av(b);
                AppMethodBeat.o(122771);
                return av;
            }
        }

        public static final class c extends c {
            public static final c BKU = new c();

            static {
                AppMethodBeat.i(122774);
                AppMethodBeat.o(122774);
            }

            private c() {
                super();
            }

            public final /* synthetic */ ad aJ(w wVar) {
                AppMethodBeat.i(122773);
                j.p(wVar, "type");
                Throwable unsupportedOperationException = new UnsupportedOperationException("Should not be called");
                AppMethodBeat.o(122773);
                throw unsupportedOperationException;
            }
        }

        public abstract ad aJ(w wVar);

        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public enum b {
        TAKE_FIRST_FOR_SUBTYPING,
        FORCE_NOT_SUBTYPE,
        CHECK_ANY_OF_THEM,
        INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;

        static {
            AppMethodBeat.o(122766);
        }
    }

    private o(boolean z) {
        this.BKI = z;
        this.BKJ = true;
    }

    public /* synthetic */ o(boolean z, byte b) {
        this(z);
    }

    public static Boolean b(az azVar, az azVar2) {
        AppMethodBeat.i(122777);
        j.p(azVar, "subType");
        j.p(azVar2, "superType");
        AppMethodBeat.o(122777);
        return null;
    }

    public static boolean c(an anVar, an anVar2) {
        AppMethodBeat.i(122778);
        j.p(anVar, "a");
        j.p(anVar2, "b");
        boolean j = j.j(anVar, anVar2);
        AppMethodBeat.o(122778);
        return j;
    }

    public static a a(ad adVar, e eVar) {
        AppMethodBeat.i(122779);
        j.p(adVar, "subType");
        j.p(eVar, "superType");
        a aVar = a.CHECK_SUBTYPE_AND_LOWER;
        AppMethodBeat.o(122779);
        return aVar;
    }

    /* Access modifiers changed, original: final */
    public final void initialize() {
        AppMethodBeat.i(122780);
        boolean z = !this.BKF;
        if (!aa.AUz || z) {
            this.BKF = true;
            if (this.BKG == null) {
                this.BKG = new ArrayDeque(4);
            }
            if (this.BKH == null) {
                a.i.b.a.c.n.i.b bVar = i.BNv;
                this.BKH = a.i.b.a.c.n.i.b.ekD();
            }
            AppMethodBeat.o(122780);
            return;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(122780);
        throw assertionError;
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.i(122781);
        ArrayDeque arrayDeque = this.BKG;
        if (arrayDeque == null) {
            j.dWJ();
        }
        arrayDeque.clear();
        Set set = this.BKH;
        if (set == null) {
            j.dWJ();
        }
        set.clear();
        this.BKF = false;
        AppMethodBeat.o(122781);
    }

    public final boolean e(az azVar) {
        AppMethodBeat.i(122782);
        j.p(azVar, "receiver$0");
        if (this.BKJ && (azVar.ejw() instanceof k)) {
            AppMethodBeat.o(122782);
            return true;
        }
        AppMethodBeat.o(122782);
        return false;
    }
}
