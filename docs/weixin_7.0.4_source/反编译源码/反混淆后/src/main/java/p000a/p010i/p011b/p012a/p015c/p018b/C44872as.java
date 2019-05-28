package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p050j.C0214o;
import p000a.p050j.C17348n;
import p000a.p050j.C44937h;

/* renamed from: a.i.b.a.c.b.as */
public final class C44872as {

    /* renamed from: a.i.b.a.c.b.as$b */
    static final class C31632b extends C25053k implements C17126b<C31642l, C44937h<? extends C36955ar>> {
        public static final C31632b BeV = new C31632b();

        static {
            AppMethodBeat.m2504i(119298);
            AppMethodBeat.m2505o(119298);
        }

        C31632b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119297);
            C31642l c31642l = (C31642l) obj;
            C25052j.m39376p(c31642l, "it");
            List dYS = ((C8045a) c31642l).dYS();
            C25052j.m39375o(dYS, "(it as CallableDescriptor).typeParameters");
            C44937h t = C25035t.m39359t(dYS);
            AppMethodBeat.m2505o(119297);
            return t;
        }
    }

    /* renamed from: a.i.b.a.c.b.as$a */
    static final class C36956a extends C25053k implements C17126b<C31642l, Boolean> {
        public static final C36956a BeU = new C36956a();

        static {
            AppMethodBeat.m2504i(119296);
            AppMethodBeat.m2505o(119296);
        }

        C36956a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119295);
            C31642l c31642l = (C31642l) obj;
            C25052j.m39376p(c31642l, "it");
            Boolean valueOf = Boolean.valueOf(c31642l instanceof C8045a);
            AppMethodBeat.m2505o(119295);
            return valueOf;
        }
    }

    /* renamed from: a */
    public static final List<C36955ar> m82070a(C6134i c6134i) {
        List list = null;
        AppMethodBeat.m2504i(119299);
        C25052j.m39376p(c6134i, "receiver$0");
        List dYq = c6134i.dYq();
        C25052j.m39375o(dYq, "declaredTypeParameters");
        if (c6134i.dYh() || (c6134i.dXW() instanceof C8045a)) {
            C44937h H = C41434a.m72276H(c6134i);
            C17126b c17126b = C36956a.BeU;
            C25052j.m39376p(H, "receiver$0");
            C25052j.m39376p(c17126b, "predicate");
            List c = C17348n.m26862c(C17348n.m26861c(new C0214o(H, c17126b), C31632b.BeV));
            for (Object next : C41434a.m72276H(c6134i)) {
                if (next instanceof C46865e) {
                    break;
                }
            }
            Object next2 = null;
            C46865e c46865e = (C46865e) next2;
            if (c46865e != null) {
                C17313an dXY = c46865e.dXY();
                if (dXY != null) {
                    list = dXY.getParameters();
                }
            }
            if (list == null) {
                list = C17115v.AUP;
            }
            List<C36955ar> dYq2;
            if (c.isEmpty() && list.isEmpty()) {
                dYq2 = c6134i.dYq();
                C25052j.m39375o(dYq2, "declaredTypeParameters");
                AppMethodBeat.m2505o(119299);
                return dYq2;
            }
            Iterable<C36955ar> b = C25035t.m39331b((Collection) c, (Iterable) list);
            Collection arrayList = new ArrayList(C25034m.m39318d(b));
            for (C36955ar c36955ar : b) {
                C25052j.m39375o(c36955ar, "it");
                arrayList.add(new C25091c(c36955ar, c6134i, dYq.size()));
            }
            dYq2 = C25035t.m39331b((Collection) dYq, (Iterable) (List) arrayList);
            AppMethodBeat.m2505o(119299);
            return dYq2;
        }
        AppMethodBeat.m2505o(119299);
        return dYq;
    }

    /* renamed from: a */
    public static final C17152af m82069a(C46867w c46867w, C6134i c6134i, int i) {
        AppMethodBeat.m2504i(119300);
        if (c6134i == null || C25235p.m39792L(c6134i)) {
            AppMethodBeat.m2505o(119300);
            return null;
        }
        int size = c6134i.dYq().size() + i;
        if (c6134i.dYh()) {
            List subList = c46867w.ejt().subList(i, size);
            C31642l dXW = c6134i.dXW();
            if (!(dXW instanceof C6134i)) {
                dXW = null;
            }
            C17152af c17152af = new C17152af(c6134i, subList, C44872as.m82069a(c46867w, (C6134i) dXW, size));
            AppMethodBeat.m2505o(119300);
            return c17152af;
        }
        Object obj = (size == c46867w.ejt().size() || C8203d.m14485m(c6134i)) ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError((c46867w.ejt().size() - size) + " trailing arguments were found in " + c46867w + " type");
            AppMethodBeat.m2505o(119300);
            throw assertionError;
        }
        C17152af c17152af2 = new C17152af(c6134i, c46867w.ejt().subList(i, c46867w.ejt().size()), null);
        AppMethodBeat.m2505o(119300);
        return c17152af2;
    }
}
