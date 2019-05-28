package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C0055n;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0062w;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31673x;
import p000a.p010i.p011b.p012a.p015c.p044k.C41439d;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;

/* renamed from: a.i.b.a.c.d.a.c.i */
public final class C17185i implements C31669m {
    final C31642l Bht;
    final int BnA;
    final C0057h Bnn;
    final Map<C0062w, Integer> Bny;
    private final C41439d<C0062w, C0055n> Bnz = this.Bnn.Bnv.Baf.mo31372g(new C8114a(this));

    /* renamed from: a.i.b.a.c.d.a.c.i$a */
    static final class C8114a extends C25053k implements C17126b<C0062w, C0055n> {
        final /* synthetic */ C17185i BnB;

        C8114a(C17185i c17185i) {
            this.BnB = c17185i;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119843);
            C0062w c0062w = (C0062w) obj;
            C25052j.m39376p(c0062w, "typeParameter");
            Integer num = (Integer) this.BnB.Bny.get(c0062w);
            if (num != null) {
                int intValue = num.intValue();
                C0057h c0057h = this.BnB.Bnn;
                C31669m c31669m = this.BnB;
                C25052j.m39376p(c0057h, "receiver$0");
                C25052j.m39376p(c31669m, "typeParameterResolver");
                C0055n c0055n = new C0055n(new C0057h(c0057h.Bnv, c31669m, c0057h.Bnx), c0062w, this.BnB.BnA + intValue, this.BnB.Bht);
                AppMethodBeat.m2505o(119843);
                return c0055n;
            }
            AppMethodBeat.m2505o(119843);
            return null;
        }
    }

    public C17185i(C0057h c0057h, C31642l c31642l, C31673x c31673x, int i) {
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c31673x, "typeParameterOwner");
        AppMethodBeat.m2504i(119845);
        this.Bnn = c0057h;
        this.Bht = c31642l;
        this.BnA = i;
        this.Bny = C31780a.m51479x(c31673x.dYS());
        AppMethodBeat.m2505o(119845);
    }

    /* renamed from: a */
    public final C36955ar mo31278a(C0062w c0062w) {
        AppMethodBeat.m2504i(119844);
        C25052j.m39376p(c0062w, "javaTypeParameter");
        C0055n c0055n = (C0055n) this.Bnz.mo50am(c0062w);
        C36955ar c36955ar;
        if (c0055n != null) {
            c36955ar = c0055n;
            AppMethodBeat.m2505o(119844);
            return c36955ar;
        }
        c36955ar = this.Bnn.Bnw.mo31278a(c0062w);
        AppMethodBeat.m2505o(119844);
        return c36955ar;
    }
}
