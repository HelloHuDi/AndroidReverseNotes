package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C17153ag;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b.C31647d;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44898t;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C25213q;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.d.a.t */
public final class C44893t {

    /* renamed from: a.i.b.a.c.d.a.t$b */
    static final class C31678b extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C31678b BlM = new C31678b();

        static {
            AppMethodBeat.m2504i(119730);
            AppMethodBeat.m2505o(119730);
        }

        C31678b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119729);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            C41407c c41407c = C41407c.Bky;
            Boolean valueOf = Boolean.valueOf(C41407c.m72220b((C41397al) c25085b));
            AppMethodBeat.m2505o(119729);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.t$c */
    static final class C36992c extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C36992c BlN = new C36992c();

        static {
            AppMethodBeat.m2504i(119732);
            AppMethodBeat.m2505o(119732);
        }

        C36992c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119731);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            boolean z = C31619g.m51108b((C31642l) c25085b) && C31671d.m51233j(c25085b) != null;
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(119731);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.t$a */
    static final class C44892a extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C44892a BlL = new C44892a();

        static {
            AppMethodBeat.m2504i(119728);
            AppMethodBeat.m2505o(119728);
        }

        C44892a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119727);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            C31675e c31675e = C31675e.BkZ;
            Boolean valueOf = Boolean.valueOf(C31675e.m51237l(C41434a.m72286x(c25085b)));
            AppMethodBeat.m2505o(119727);
            return valueOf;
        }
    }

    /* renamed from: a */
    static final C8174b m82095a(C8174b c8174b, String str) {
        AppMethodBeat.m2504i(119733);
        C8174b q = c8174b.mo17976q(C37022f.avX(str));
        C25052j.m39375o(q, "child(Name.identifier(name))");
        AppMethodBeat.m2505o(119733);
        return q;
    }

    /* renamed from: b */
    static final C8174b m82097b(C8175c c8175c, String str) {
        AppMethodBeat.m2504i(119734);
        C8174b ehI = c8175c.mo17988t(C37022f.avX(str)).ehI();
        C25052j.m39375o(ehI, "child(Name.identifier(name)).toSafe()");
        AppMethodBeat.m2505o(119734);
        return ehI;
    }

    /* renamed from: v */
    static final C25122r m82104v(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(119735);
        C37022f avX = C37022f.avX(str2);
        C25052j.m39375o(avX, "Name.identifier(name)");
        C44898t c44898t = C44898t.BrJ;
        C25122r c25122r = new C25122r(avX, C44898t.m82115iV(str, str2 + '(' + str3 + ')' + str4));
        AppMethodBeat.m2505o(119735);
        return c25122r;
    }

    /* renamed from: n */
    public static final <T extends C25085b> T m82098n(T t) {
        AppMethodBeat.m2504i(119736);
        C25052j.m39376p(t, "receiver$0");
        C41407c c41407c = C41407c.Bky;
        if (!C41407c.eaU().contains(t.dZg())) {
            C31675e c31675e = C31675e.BkZ;
            if (!C31675e.eaW().contains(C41434a.m72286x(t).dZg())) {
                AppMethodBeat.m2505o(119736);
                return null;
            }
        }
        T b;
        if ((t instanceof C31220ah) || (t instanceof C17153ag)) {
            b = C41434a.m72278b(t, C44892a.BlL);
            AppMethodBeat.m2505o(119736);
            return b;
        } else if (t instanceof C41397al) {
            b = C41434a.m72278b(t, C31678b.BlM);
            AppMethodBeat.m2505o(119736);
            return b;
        } else {
            AppMethodBeat.m2505o(119736);
            return null;
        }
    }

    /* renamed from: o */
    public static final boolean m82099o(C25085b c25085b) {
        AppMethodBeat.m2504i(119737);
        C25052j.m39376p(c25085b, "receiver$0");
        if (C44893t.m82098n(c25085b) != null) {
            AppMethodBeat.m2505o(119737);
            return true;
        }
        AppMethodBeat.m2505o(119737);
        return false;
    }

    /* renamed from: p */
    public static final <T extends C25085b> T m82100p(T t) {
        AppMethodBeat.m2504i(119738);
        C25052j.m39376p(t, "receiver$0");
        C25085b n = C44893t.m82098n(t);
        if (n != null) {
            AppMethodBeat.m2505o(119738);
            return n;
        }
        C31671d c31671d = C31671d.BkH;
        C37022f dZg = t.dZg();
        C25052j.m39375o(dZg, "name");
        if (C31671d.m51232h(dZg)) {
            T b = C41434a.m72278b(t, C36992c.BlN);
            AppMethodBeat.m2505o(119738);
            return b;
        }
        AppMethodBeat.m2505o(119738);
        return null;
    }

    /* renamed from: q */
    public static final String m82101q(C25085b c25085b) {
        AppMethodBeat.m2504i(119739);
        C25052j.m39376p(c25085b, "callableMemberDescriptor");
        C25085b r = C44893t.m82102r(c25085b);
        if (r != null) {
            r = C41434a.m72286x(r);
            if (r != null) {
                String m;
                if (r instanceof C31220ah) {
                    C31675e c31675e = C31675e.BkZ;
                    m = C31675e.m51238m(r);
                    AppMethodBeat.m2505o(119739);
                    return m;
                }
                if (r instanceof C41397al) {
                    C41407c c41407c = C41407c.Bky;
                    C37022f a = C41407c.m72219a((C41397al) r);
                    if (a != null) {
                        m = a.name;
                        AppMethodBeat.m2505o(119739);
                        return m;
                    }
                }
                AppMethodBeat.m2505o(119739);
                return null;
            }
        }
        AppMethodBeat.m2505o(119739);
        return null;
    }

    /* renamed from: r */
    private static final C25085b m82102r(C25085b c25085b) {
        AppMethodBeat.m2504i(119740);
        if (C31619g.m51108b((C31642l) c25085b)) {
            C25085b n = C44893t.m82098n(c25085b);
            AppMethodBeat.m2505o(119740);
            return n;
        }
        AppMethodBeat.m2505o(119740);
        return null;
    }

    /* renamed from: a */
    public static final boolean m82096a(C46865e c46865e, C8045a c8045a) {
        AppMethodBeat.m2504i(119741);
        C25052j.m39376p(c46865e, "receiver$0");
        C25052j.m39376p(c8045a, "specialCallableDescriptor");
        C31642l dXW = c8045a.dXW();
        if (dXW == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.m2505o(119741);
            throw c44941v;
        }
        C8235ad dZf = ((C46865e) dXW).dZf();
        C25052j.m39375o(dZf, "(specialCallableDescript…ssDescriptor).defaultType");
        for (C46865e x = C8203d.m14498x(c46865e); x != null; x = C8203d.m14498x(x)) {
            if (!(x instanceof C31647d)) {
                if ((C25213q.m39735e((C46867w) x.dZf(), (C46867w) dZf) != null ? 1 : null) != null) {
                    if (C31619g.m51108b((C31642l) x)) {
                        AppMethodBeat.m2505o(119741);
                        return false;
                    }
                    AppMethodBeat.m2505o(119741);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(119741);
        return false;
    }

    /* renamed from: s */
    public static final boolean m82103s(C25085b c25085b) {
        AppMethodBeat.m2504i(119742);
        C25052j.m39376p(c25085b, "receiver$0");
        C25052j.m39376p(c25085b, "receiver$0");
        if ((C41434a.m72286x(c25085b).dXW() instanceof C31647d) || C31619g.m51108b((C31642l) c25085b)) {
            AppMethodBeat.m2505o(119742);
            return true;
        }
        AppMethodBeat.m2505o(119742);
        return false;
    }
}
