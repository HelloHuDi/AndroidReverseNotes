package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import p000a.p001a.C25031ak;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.j.a.g */
public final class C25203g {
    private static final Set<C8173a> BGH = C25031ak.setOf(C8173a.m14427n(C31619g.Bag.Bao.ehI()));
    public static final C25202b BGI = new C25202b();
    private final C17126b<C25204a, C46865e> BGG = this.Brl.Baf.mo31372g(new C8221c(this));
    private final C8225i Brl;

    /* renamed from: a.i.b.a.c.j.a.g$c */
    static final class C8221c extends C25053k implements C17126b<C25204a, C46865e> {
        final /* synthetic */ C25203g BGK;

        C8221c(C25203g c25203g) {
            this.BGK = c25203g;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122255);
            C25204a c25204a = (C25204a) obj;
            C25052j.m39376p(c25204a, "key");
            C46865e a = C25203g.m39706a(this.BGK, c25204a);
            AppMethodBeat.m2505o(122255);
            return a;
        }
    }

    /* renamed from: a.i.b.a.c.j.a.g$b */
    public static final class C25202b {
        private C25202b() {
        }

        public /* synthetic */ C25202b(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.j.a.g$a */
    static final class C25204a {
        final C44914e BGJ;
        final C8173a BcB;

        public C25204a(C8173a c8173a, C44914e c44914e) {
            C25052j.m39376p(c8173a, "classId");
            AppMethodBeat.m2504i(122254);
            this.BcB = c8173a;
            this.BGJ = c44914e;
            AppMethodBeat.m2505o(122254);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(122252);
            if ((obj instanceof C25204a) && C25052j.m39373j(this.BcB, ((C25204a) obj).BcB)) {
                AppMethodBeat.m2505o(122252);
                return true;
            }
            AppMethodBeat.m2505o(122252);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(122253);
            int hashCode = this.BcB.hashCode();
            AppMethodBeat.m2505o(122253);
            return hashCode;
        }
    }

    public C25203g(C8225i c8225i) {
        C25052j.m39376p(c8225i, "components");
        AppMethodBeat.m2504i(122258);
        this.Brl = c8225i;
        AppMethodBeat.m2505o(122258);
    }

    /* renamed from: a */
    public final C46865e mo42062a(C8173a c8173a, C44914e c44914e) {
        AppMethodBeat.m2504i(122256);
        C25052j.m39376p(c8173a, "classId");
        C46865e c46865e = (C46865e) this.BGG.mo50am(new C25204a(c8173a, c44914e));
        AppMethodBeat.m2505o(122256);
        return c46865e;
    }

    static {
        AppMethodBeat.m2504i(122259);
        AppMethodBeat.m2505o(122259);
    }
}
