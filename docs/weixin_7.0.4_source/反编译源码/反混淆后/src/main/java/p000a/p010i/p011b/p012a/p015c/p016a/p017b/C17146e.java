package p000a.p010i.p011b.p012a.p015c.p016a.p017b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31637v;
import p000a.p010i.p011b.p012a.p015c.p018b.p775b.C25083c;
import p000a.p010i.p011b.p012a.p015c.p018b.p775b.C41400a;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;

/* renamed from: a.i.b.a.c.a.b.e */
public final class C17146e extends C31619g {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C17146e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    public C25093y BdE;
    public boolean BdF;
    private final C41441f BdG;

    /* renamed from: a.i.b.a.c.a.b.e$a */
    static final class C17147a extends C25053k implements C31214a<C31609f> {
        final /* synthetic */ C25212i BdD;
        final /* synthetic */ C17146e BdH;

        /* renamed from: a.i.b.a.c.a.b.e$a$2 */
        static final class C00232 extends C25053k implements C31214a<Boolean> {
            final /* synthetic */ C17147a BdI;

            C00232(C17147a c17147a) {
                this.BdI = c17147a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(119202);
                if (this.BdI.BdH.BdE == null) {
                    Throwable assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                    AppMethodBeat.m2505o(119202);
                    throw assertionError;
                }
                Boolean valueOf = Boolean.valueOf(this.BdI.BdH.BdF);
                AppMethodBeat.m2505o(119202);
                return valueOf;
            }
        }

        /* renamed from: a.i.b.a.c.a.b.e$a$1 */
        static final class C171481 extends C25053k implements C31214a<C25093y> {
            final /* synthetic */ C17147a BdI;

            C171481(C17147a c17147a) {
                this.BdI = c17147a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(119201);
                C25093y a = this.BdI.BdH.BdE;
                if (a == null) {
                    Throwable assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                    AppMethodBeat.m2505o(119201);
                    throw assertionError;
                }
                AppMethodBeat.m2505o(119201);
                return a;
            }
        }

        C17147a(C17146e c17146e, C25212i c25212i) {
            this.BdH = c17146e;
            this.BdD = c25212i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119203);
            C31637v c31637v = this.BdH.Bab;
            C25052j.m39375o(c31637v, "builtInsModule");
            C31609f c31609f = new C31609f(c31637v, this.BdD, new C171481(this), new C00232(this));
            AppMethodBeat.m2505o(119203);
            return c31609f;
        }
    }

    static {
        AppMethodBeat.m2504i(119204);
        AppMethodBeat.m2505o(119204);
    }

    public final C31609f dYG() {
        AppMethodBeat.m2504i(119205);
        C31609f c31609f = (C31609f) C17310h.m26799a(this.BdG, eQB[0]);
        AppMethodBeat.m2505o(119205);
        return c31609f;
    }

    public /* synthetic */ C17146e(C25212i c25212i, byte b) {
        this(c25212i);
    }

    private C17146e(C25212i c25212i) {
        C25052j.m39376p(c25212i, "storageManager");
        super(c25212i);
        AppMethodBeat.m2504i(119209);
        this.BdF = true;
        this.BdG = c25212i.mo31373i(new C17147a(this, c25212i));
        dXH();
        AppMethodBeat.m2505o(119209);
    }

    public final C25083c dXJ() {
        AppMethodBeat.m2504i(119206);
        C25083c dYG = dYG();
        AppMethodBeat.m2505o(119206);
        return dYG;
    }

    public final C41400a dXI() {
        AppMethodBeat.m2504i(119207);
        C41400a dYG = dYG();
        AppMethodBeat.m2505o(119207);
        return dYG;
    }

    public final /* synthetic */ Iterable dXK() {
        AppMethodBeat.m2504i(119208);
        Iterable dXK = super.dXK();
        C25052j.m39375o(dXK, "super.getClassDescriptorFactories()");
        C25212i c25212i = this.Baf;
        C25052j.m39375o(c25212i, "storageManager");
        C31637v c31637v = this.Bab;
        C25052j.m39375o(c31637v, "builtInsModule");
        Iterable d = C25035t.m39334d(dXK, new C41393d(c25212i, c31637v));
        AppMethodBeat.m2505o(119208);
        return d;
    }
}
