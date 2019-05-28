package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b.C25240a;

/* renamed from: a.i.b.a.c.m.k */
public abstract class C41461k implements C44925b {
    private final C17126b<C31619g, C46867w> BMz;
    private final String description;
    private final String name;

    /* renamed from: a.i.b.a.c.m.k$a */
    public static final class C0168a extends C41461k {
        public static final C0168a BMA = new C0168a();

        /* renamed from: a.i.b.a.c.m.k$a$1 */
        static final class C01671 extends C25053k implements C17126b<C31619g, C8235ad> {
            public static final C01671 BMB = new C01671();

            static {
                AppMethodBeat.m2504i(122888);
                AppMethodBeat.m2505o(122888);
            }

            C01671() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122887);
                C31619g c31619g = (C31619g) obj;
                C25052j.m39376p(c31619g, "receiver$0");
                C8235ad a = c31619g.mo51607a(C31622h.BOOLEAN);
                C25052j.m39375o(a, "booleanType");
                AppMethodBeat.m2505o(122887);
                return a;
            }
        }

        static {
            AppMethodBeat.m2504i(122890);
            AppMethodBeat.m2505o(122890);
        }

        private C0168a() {
            super("Boolean", C01671.BMB, (byte) 0);
            AppMethodBeat.m2504i(122889);
            AppMethodBeat.m2505o(122889);
        }
    }

    /* renamed from: a.i.b.a.c.m.k$b */
    public static final class C8251b extends C41461k {
        public static final C8251b BMC = new C8251b();

        /* renamed from: a.i.b.a.c.m.k$b$1 */
        static final class C01691 extends C25053k implements C17126b<C31619g, C8235ad> {
            public static final C01691 BMD = new C01691();

            static {
                AppMethodBeat.m2504i(122892);
                AppMethodBeat.m2505o(122892);
            }

            C01691() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122891);
                C31619g c31619g = (C31619g) obj;
                C25052j.m39376p(c31619g, "receiver$0");
                C8235ad a = c31619g.mo51607a(C31622h.INT);
                C25052j.m39375o(a, "intType");
                AppMethodBeat.m2505o(122891);
                return a;
            }
        }

        static {
            AppMethodBeat.m2504i(122894);
            AppMethodBeat.m2505o(122894);
        }

        private C8251b() {
            super("Int", C01691.BMD, (byte) 0);
            AppMethodBeat.m2504i(122893);
            AppMethodBeat.m2505o(122893);
        }
    }

    /* renamed from: a.i.b.a.c.m.k$c */
    public static final class C8252c extends C41461k {
        public static final C8252c BME = new C8252c();

        /* renamed from: a.i.b.a.c.m.k$c$1 */
        static final class C82531 extends C25053k implements C17126b<C31619g, C8235ad> {
            public static final C82531 BMF = new C82531();

            static {
                AppMethodBeat.m2504i(122896);
                AppMethodBeat.m2505o(122896);
            }

            C82531() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122895);
                C31619g c31619g = (C31619g) obj;
                C25052j.m39376p(c31619g, "receiver$0");
                C8235ad dXO = c31619g.dXO();
                C25052j.m39375o(dXO, "unitType");
                AppMethodBeat.m2505o(122895);
                return dXO;
            }
        }

        static {
            AppMethodBeat.m2504i(122898);
            AppMethodBeat.m2505o(122898);
        }

        private C8252c() {
            super("Unit", C82531.BMF, (byte) 0);
            AppMethodBeat.m2504i(122897);
            AppMethodBeat.m2505o(122897);
        }
    }

    private C41461k(String str, C17126b<? super C31619g, ? extends C46867w> c17126b) {
        this.name = str;
        this.BMz = c17126b;
        this.description = "must return " + this.name;
    }

    public /* synthetic */ C41461k(String str, C17126b c17126b, byte b) {
        this(str, c17126b);
    }

    /* renamed from: i */
    public final String mo18042i(C8083t c8083t) {
        C25052j.m39376p(c8083t, "functionDescriptor");
        return C25240a.m39808a(this, c8083t);
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: h */
    public final boolean mo253h(C8083t c8083t) {
        C25052j.m39376p(c8083t, "functionDescriptor");
        return C25052j.m39373j(c8083t.dYT(), (C46867w) this.BMz.mo50am(C41434a.m72275G(c8083t)));
    }
}
