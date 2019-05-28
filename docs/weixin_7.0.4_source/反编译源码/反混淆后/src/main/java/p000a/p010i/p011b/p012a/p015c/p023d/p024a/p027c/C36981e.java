package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0029b;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C0042c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17187d;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p044k.C41439d;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p050j.C16496l;
import p000a.p050j.C16496l.C0212a;
import p000a.p050j.C16496l.C16497b;
import p000a.p050j.C17348n;
import p000a.p050j.C25271f;
import p000a.p050j.C31818p;
import p000a.p050j.C44937h;

/* renamed from: a.i.b.a.c.d.a.c.e */
public final class C36981e implements C0026g {
    private final C41439d<C41408a, C44869c> Bnm = this.Bnn.Bnv.Baf.mo31372g(new C31221a(this));
    private final C0057h Bnn;
    private final C17187d Bno;

    /* renamed from: a.i.b.a.c.d.a.c.e$a */
    static final class C31221a extends C25053k implements C17126b<C41408a, C44869c> {
        final /* synthetic */ C36981e Bnp;

        C31221a(C36981e c36981e) {
            this.Bnp = c36981e;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119828);
            C41408a c41408a = (C41408a) obj;
            C25052j.m39376p(c41408a, "annotation");
            C0042c c0042c = C0042c.Bmf;
            C44869c a = C0042c.m39a(c41408a, this.Bnp.Bnn);
            AppMethodBeat.m2505o(119828);
            return a;
        }
    }

    public C36981e(C0057h c0057h, C17187d c17187d) {
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c17187d, "annotationOwner");
        AppMethodBeat.m2504i(119832);
        this.Bnn = c0057h;
        this.Bno = c17187d;
        AppMethodBeat.m2505o(119832);
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(119833);
        C25052j.m39376p(c8174b, "fqName");
        boolean b = C0029b.m33b(this, c8174b);
        AppMethodBeat.m2505o(119833);
        return b;
    }

    /* JADX WARNING: Missing block: B:3:0x001e, code skipped:
            if (r0 == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public final C44869c mo53i(C8174b c8174b) {
        C44869c c44869c;
        AppMethodBeat.m2504i(119829);
        C25052j.m39376p(c8174b, "fqName");
        C41408a m = this.Bno.mo18057m(c8174b);
        if (m != null) {
            c44869c = (C44869c) this.Bnm.mo50am(m);
        }
        C0042c c0042c = C0042c.Bmf;
        c44869c = C0042c.m40a(c8174b, this.Bno, this.Bnn);
        AppMethodBeat.m2505o(119829);
        return c44869c;
    }

    public final Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(119830);
        C44937h d = C17348n.m26863d(C25035t.m39359t(this.Bno.ebC()), this.Bnm);
        C0042c c0042c = C0042c.Bmf;
        C8174b c8174b = C31619g.Bag.BaK;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.deprecated");
        C44869c a = C0042c.m40a(c8174b, this.Bno, this.Bnn);
        C25052j.m39376p(d, "receiver$0");
        C44937h[] c44937hArr = new C44937h[2];
        c44937hArr[0] = d;
        c44937hArr[1] = C16496l.m25323Z(a);
        C44937h Z = C16496l.m25323Z(c44937hArr);
        C25052j.m39376p(Z, "receiver$0");
        C17126b c17126b = C0212a.BOG;
        if (Z instanceof C31818p) {
            C31818p c31818p = (C31818p) Z;
            C25052j.m39376p(c17126b, "iterator");
            d = new C25271f(c31818p.BOr, c31818p.BOz, c17126b);
        } else {
            d = new C25271f(Z, C16497b.BOH, c17126b);
        }
        Iterator it = C17348n.m26859b(d).iterator();
        AppMethodBeat.m2505o(119830);
        return it;
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(119831);
        if (this.Bno.ebC().isEmpty()) {
            AppMethodBeat.m2505o(119831);
            return true;
        }
        AppMethodBeat.m2505o(119831);
        return false;
    }
}
