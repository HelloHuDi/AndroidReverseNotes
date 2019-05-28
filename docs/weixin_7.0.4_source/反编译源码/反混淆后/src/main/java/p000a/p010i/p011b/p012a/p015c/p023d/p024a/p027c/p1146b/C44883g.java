package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.C44847aa;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p036h.C0125i;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C31771ac;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8229c;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.d.a.c.b.g */
public final class C44883g extends C17325q implements C31771ac {

    /* renamed from: a.i.b.a.c.d.a.c.b.g$a */
    static final class C36653a extends C25053k implements C31591m<String, String, Boolean> {
        public static final C36653a Bpr = new C36653a();

        static {
            AppMethodBeat.m2504i(120065);
            AppMethodBeat.m2505o(120065);
        }

        C36653a() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(120063);
            Boolean valueOf = Boolean.valueOf(C36653a.m60751iR((String) obj, (String) obj2));
            AppMethodBeat.m2505o(120063);
            return valueOf;
        }

        /* renamed from: iR */
        public static boolean m60751iR(String str, String str2) {
            AppMethodBeat.m2504i(120064);
            C25052j.m39376p(str, "first");
            C25052j.m39376p(str2, "second");
            if (C25052j.m39373j(str, C31820v.m51535b(str2, (CharSequence) "out ")) || C25052j.m39373j(str2, "*")) {
                AppMethodBeat.m2505o(120064);
                return true;
            }
            AppMethodBeat.m2505o(120064);
            return false;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.b.g$b */
    static final class C36977b extends C25053k implements C17126b<C46867w, List<? extends String>> {
        final /* synthetic */ C31724c Bps;

        C36977b(C31724c c31724c) {
            this.Bps = c31724c;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(120066);
            List Q = mo58981Q((C46867w) obj);
            AppMethodBeat.m2505o(120066);
            return Q;
        }

        /* renamed from: Q */
        public final List<String> mo58981Q(C46867w c46867w) {
            AppMethodBeat.m2504i(120067);
            C25052j.m39376p(c46867w, "type");
            Iterable<C41446ap> ejt = c46867w.ejt();
            Collection arrayList = new ArrayList(C25034m.m39318d(ejt));
            for (C41446ap a : ejt) {
                arrayList.add(this.Bps.mo13662a(a));
            }
            List list = (List) arrayList;
            AppMethodBeat.m2505o(120067);
            return list;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.b.g$d */
    static final class C36978d extends C25053k implements C17126b<String, String> {
        public static final C36978d Bpu = new C36978d();

        static {
            AppMethodBeat.m2504i(120072);
            AppMethodBeat.m2505o(120072);
        }

        C36978d() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(120071);
            String str = (String) obj;
            C25052j.m39376p(str, "it");
            String concat = "(raw) ".concat(String.valueOf(str));
            AppMethodBeat.m2505o(120071);
            return concat;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.b.g$c */
    static final class C44882c extends C25053k implements C31591m<String, String, String> {
        public static final C44882c Bpt = new C44882c();

        static {
            AppMethodBeat.m2504i(120070);
            AppMethodBeat.m2505o(120070);
        }

        C44882c() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(120068);
            String iS = C44882c.m82088iS((String) obj, (String) obj2);
            AppMethodBeat.m2505o(120068);
            return iS;
        }

        /* renamed from: iS */
        public static String m82088iS(String str, String str2) {
            AppMethodBeat.m2504i(120069);
            C25052j.m39376p(str, "receiver$0");
            C25052j.m39376p(str2, "newArgs");
            if (C31820v.m51536b((CharSequence) str, '<')) {
                str = C31820v.m51541jd(str, str) + '<' + str2 + '>' + C31820v.m51522a(str, '>');
                AppMethodBeat.m2505o(120069);
                return str;
            }
            AppMethodBeat.m2505o(120069);
            return str;
        }
    }

    public C44883g(C8235ad c8235ad, C8235ad c8235ad2) {
        C25052j.m39376p(c8235ad, "lowerBound");
        C25052j.m39376p(c8235ad2, "upperBound");
        super(c8235ad, c8235ad2);
        AppMethodBeat.m2504i(120077);
        boolean c = C8229c.BKs.mo18024c(c8235ad, c8235ad2);
        if (!C44847aa.AUz || c) {
            AppMethodBeat.m2505o(120077);
            return;
        }
        Throwable assertionError = new AssertionError("Lower bound " + c8235ad + " of a flexible type must be a subtype of the upper bound " + c8235ad2);
        AppMethodBeat.m2505o(120077);
        throw assertionError;
    }

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(120074);
        C25052j.m39376p(c0026g, "newAnnotations");
        C41447az c44883g = new C44883g(this.BJx.mo18030d(c0026g), this.BJy.mo18030d(c0026g));
        AppMethodBeat.m2505o(120074);
        return c44883g;
    }

    public final C31746h dXR() {
        AppMethodBeat.m2504i(120073);
        C0036h dYs = ejw().dYs();
        if (!(dYs instanceof C46865e)) {
            dYs = null;
        }
        C46865e c46865e = (C46865e) dYs;
        if (c46865e == null) {
            Throwable illegalStateException = new IllegalStateException(("Incorrect classifier: " + ejw().dYs()).toString());
            AppMethodBeat.m2505o(120073);
            throw illegalStateException;
        }
        C31746h a = c46865e.mo31262a(C25111e.Bpq);
        C25052j.m39375o(a, "classDescriptor.getMemberScope(RawSubstitution)");
        AppMethodBeat.m2505o(120073);
        return a;
    }

    /* renamed from: a */
    public final String mo31390a(C31724c c31724c, C0125i c0125i) {
        int i = 0;
        AppMethodBeat.m2504i(120076);
        C25052j.m39376p(c31724c, "renderer");
        C25052j.m39376p(c0125i, "options");
        C36653a c36653a = C36653a.Bpr;
        C36977b c36977b = new C36977b(c31724c);
        C44882c c44882c = C44882c.Bpt;
        String b = c31724c.mo13665b(this.BJx);
        String b2 = c31724c.mo13665b(this.BJy);
        String str;
        if (c0125i.eiS()) {
            str = "raw (" + b + ".." + b2 + ')';
            AppMethodBeat.m2505o(120076);
            return str;
        } else if (this.BJy.ejt().isEmpty()) {
            str = c31724c.mo13663a(b, b2, C41448a.m72314aL(this));
            AppMethodBeat.m2505o(120076);
            return str;
        } else {
            Object iS;
            List Q = c36977b.mo58981Q(this.BJx);
            List Q2 = c36977b.mo58981Q(this.BJy);
            String a = C25035t.m39322a((Iterable) Q, (CharSequence) ", ", null, null, 0, null, (C17126b) C36978d.Bpu, 30);
            Iterable<C31826o> a2 = C25035t.m39325a((Iterable) Q, (Iterable) Q2);
            if (!((Collection) a2).isEmpty()) {
                for (C31826o c31826o : a2) {
                    c36653a = C36653a.Bpr;
                    if (!C36653a.m60751iR((String) c31826o.first, (String) c31826o.second)) {
                        break;
                    }
                }
            }
            i = 1;
            if (i != 0) {
                iS = C44882c.m82088iS(b2, a);
            } else {
                str = b2;
            }
            String iS2 = C44882c.m82088iS(b, a);
            if (C25052j.m39373j(iS2, iS)) {
                AppMethodBeat.m2505o(120076);
                return iS2;
            }
            str = c31724c.mo13663a(iS2, iS, C41448a.m72314aL(this));
            AppMethodBeat.m2505o(120076);
            return str;
        }
    }

    public final C8235ad eby() {
        return this.BJx;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(120075);
        C41447az c44883g = new C44883g(this.BJx.mo18033rL(z), this.BJy.mo18033rL(z));
        AppMethodBeat.m2505o(120075);
        return c44883g;
    }
}
