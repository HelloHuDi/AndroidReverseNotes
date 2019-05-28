package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17315at;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p048n.C44929i;
import p000a.p010i.p011b.p012a.p015c.p048n.C44929i.C17332b;

/* renamed from: a.i.b.a.c.l.a.o */
public final class C44919o {
    int BKE;
    private boolean BKF;
    ArrayDeque<C8235ad> BKG;
    Set<C8235ad> BKH;
    final boolean BKI;
    private final boolean BKJ;

    /* renamed from: a.i.b.a.c.l.a.o$a */
    public enum C37045a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        static {
            AppMethodBeat.m2505o(122763);
        }
    }

    /* renamed from: a.i.b.a.c.l.a.o$c */
    public static abstract class C37046c {

        /* renamed from: a.i.b.a.c.l.a.o$c$d */
        public static final class C17311d extends C37046c {
            public static final C17311d BKV = new C17311d();

            static {
                AppMethodBeat.m2504i(122776);
                AppMethodBeat.m2505o(122776);
            }

            private C17311d() {
                super();
            }

            /* renamed from: aJ */
            public final C8235ad mo31381aJ(C46867w c46867w) {
                AppMethodBeat.m2504i(122775);
                C25052j.m39376p(c46867w, "type");
                C8235ad al = C44924t.m82163al(c46867w);
                AppMethodBeat.m2505o(122775);
                return al;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.o$c$a */
        public static final class C37047a extends C37046c {
            public static final C37047a BKT = new C37047a();

            static {
                AppMethodBeat.m2504i(122770);
                AppMethodBeat.m2505o(122770);
            }

            private C37047a() {
                super();
            }

            /* renamed from: aJ */
            public final C8235ad mo31381aJ(C46867w c46867w) {
                AppMethodBeat.m2504i(122769);
                C25052j.m39376p(c46867w, "type");
                C8235ad ak = C44924t.m82162ak(c46867w);
                AppMethodBeat.m2505o(122769);
                return ak;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.o$c$b */
        public static final class C37048b extends C37046c {
            private final C25227au BGk;

            public C37048b(C25227au c25227au) {
                C25052j.m39376p(c25227au, "substitutor");
                super();
                AppMethodBeat.m2504i(122772);
                this.BGk = c25227au;
                AppMethodBeat.m2505o(122772);
            }

            /* renamed from: aJ */
            public final C8235ad mo31381aJ(C46867w c46867w) {
                AppMethodBeat.m2504i(122771);
                C25052j.m39376p(c46867w, "type");
                C46867w b = this.BGk.mo42079b((C46867w) C44924t.m82162ak(c46867w), C0163ba.INVARIANT);
                C25052j.m39375o(b, "substitutor.safeSubstitu…le(), Variance.INVARIANT)");
                C8235ad av = C17315at.m26809av(b);
                AppMethodBeat.m2505o(122771);
                return av;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.o$c$c */
        public static final class C37049c extends C37046c {
            public static final C37049c BKU = new C37049c();

            static {
                AppMethodBeat.m2504i(122774);
                AppMethodBeat.m2505o(122774);
            }

            private C37049c() {
                super();
            }

            /* renamed from: aJ */
            public final /* synthetic */ C8235ad mo31381aJ(C46867w c46867w) {
                AppMethodBeat.m2504i(122773);
                C25052j.m39376p(c46867w, "type");
                Throwable unsupportedOperationException = new UnsupportedOperationException("Should not be called");
                AppMethodBeat.m2505o(122773);
                throw unsupportedOperationException;
            }
        }

        /* renamed from: aJ */
        public abstract C8235ad mo31381aJ(C46867w c46867w);

        private C37046c() {
        }

        public /* synthetic */ C37046c(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.l.a.o$b */
    public enum C44918b {
        TAKE_FIRST_FOR_SUBTYPING,
        FORCE_NOT_SUBTYPE,
        CHECK_ANY_OF_THEM,
        INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;

        static {
            AppMethodBeat.m2505o(122766);
        }
    }

    private C44919o(boolean z) {
        this.BKI = z;
        this.BKJ = true;
    }

    public /* synthetic */ C44919o(boolean z, byte b) {
        this(z);
    }

    /* renamed from: b */
    public static Boolean m82147b(C41447az c41447az, C41447az c41447az2) {
        AppMethodBeat.m2504i(122777);
        C25052j.m39376p(c41447az, "subType");
        C25052j.m39376p(c41447az2, "superType");
        AppMethodBeat.m2505o(122777);
        return null;
    }

    /* renamed from: c */
    public static boolean m82148c(C17313an c17313an, C17313an c17313an2) {
        AppMethodBeat.m2504i(122778);
        C25052j.m39376p(c17313an, "a");
        C25052j.m39376p(c17313an2, "b");
        boolean j = C25052j.m39373j(c17313an, c17313an2);
        AppMethodBeat.m2505o(122778);
        return j;
    }

    /* renamed from: a */
    public static C37045a m82146a(C8235ad c8235ad, C31767e c31767e) {
        AppMethodBeat.m2504i(122779);
        C25052j.m39376p(c8235ad, "subType");
        C25052j.m39376p(c31767e, "superType");
        C37045a c37045a = C37045a.CHECK_SUBTYPE_AND_LOWER;
        AppMethodBeat.m2505o(122779);
        return c37045a;
    }

    /* Access modifiers changed, original: final */
    public final void initialize() {
        AppMethodBeat.m2504i(122780);
        boolean z = !this.BKF;
        if (!C44847aa.AUz || z) {
            this.BKF = true;
            if (this.BKG == null) {
                this.BKG = new ArrayDeque(4);
            }
            if (this.BKH == null) {
                C17332b c17332b = C44929i.BNv;
                this.BKH = C17332b.ekD();
            }
            AppMethodBeat.m2505o(122780);
            return;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.m2505o(122780);
        throw assertionError;
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.m2504i(122781);
        ArrayDeque arrayDeque = this.BKG;
        if (arrayDeque == null) {
            C25052j.dWJ();
        }
        arrayDeque.clear();
        Set set = this.BKH;
        if (set == null) {
            C25052j.dWJ();
        }
        set.clear();
        this.BKF = false;
        AppMethodBeat.m2505o(122781);
    }

    /* renamed from: e */
    public final boolean mo72115e(C41447az c41447az) {
        AppMethodBeat.m2504i(122782);
        C25052j.m39376p(c41447az, "receiver$0");
        if (this.BKJ && (c41447az.ejw() instanceof C8231k)) {
            AppMethodBeat.m2505o(122782);
            return true;
        }
        AppMethodBeat.m2505o(122782);
        return false;
    }
}
