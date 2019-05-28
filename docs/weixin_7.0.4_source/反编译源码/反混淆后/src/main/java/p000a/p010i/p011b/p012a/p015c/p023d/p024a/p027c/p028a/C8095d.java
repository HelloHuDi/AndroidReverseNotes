package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.C25035t;
import p000a.p001a.C44628q;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C6134i;
import p000a.p010i.p011b.p012a.p015c.p021c.C17171a;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0060t;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p047m.p1437b.C31776a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.c.a.d */
public final class C8095d implements C31746h {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8095d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    final C31653j BnN;
    private final C41441f BnO = this.Bnn.Bnv.Baf.mo31373i(new C0051a(this));
    private final C36974h BnP;
    private final C0057h Bnn;

    /* renamed from: a.i.b.a.c.d.a.c.a.d$a */
    static final class C0051a extends C25053k implements C31214a<List<? extends C31746h>> {
        final /* synthetic */ C8095d BnQ;

        C0051a(C8095d c8095d) {
            this.BnQ = c8095d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119863);
            Collection arrayList = new ArrayList();
            for (C8143n a : this.BnQ.BnP.ebv().values()) {
                C31746h a2 = this.BnQ.Bnn.Bnv.BmT.mo121a((C36953ab) this.BnQ.BnP, a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            List m = C25035t.m39352m((List) arrayList);
            AppMethodBeat.m2505o(119863);
            return m;
        }
    }

    static {
        AppMethodBeat.m2504i(119864);
        AppMethodBeat.m2505o(119864);
    }

    private final List<C31746h> ebp() {
        AppMethodBeat.m2504i(119865);
        List list = (List) C17310h.m26799a(this.BnO, eQB[0]);
        AppMethodBeat.m2505o(119865);
        return list;
    }

    public C8095d(C0057h c0057h, C0060t c0060t, C36974h c36974h) {
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c0060t, "jPackage");
        C25052j.m39376p(c36974h, "packageFragment");
        AppMethodBeat.m2504i(119873);
        this.Bnn = c0057h;
        this.BnP = c36974h;
        this.BnN = new C31653j(this.Bnn, c0060t, this.BnP);
        AppMethodBeat.m2505o(119873);
    }

    /* renamed from: c */
    public final C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(119866);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        m14285d(c37022f, c8085a);
        C46865e e = this.BnN.mo51639e(c37022f, c8085a);
        if (e != null) {
            C0036h c0036h = e;
            AppMethodBeat.m2505o(119866);
            return c0036h;
        }
        C0036h c0036h2 = null;
        for (C31746h c : ebp()) {
            C0036h c2 = c.mo222c(c37022f, c8085a);
            if (c2 != null) {
                if (!(c2 instanceof C6134i) || !((C6134i) c2).dYk()) {
                    AppMethodBeat.m2505o(119866);
                    return c2;
                } else if (c0036h2 == null) {
                    c0036h2 = c2;
                }
            }
        }
        AppMethodBeat.m2505o(119866);
        return c0036h2;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        Collection<C31220ah> collection;
        AppMethodBeat.m2504i(119867);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        m14285d(c37022f, c8085a);
        C31653j c31653j = this.BnN;
        List ebp = ebp();
        Collection<C31220ah> a = c31653j.mo219a(c37022f, c8085a);
        Iterator it = ebp.iterator();
        while (true) {
            collection = a;
            if (!it.hasNext()) {
                break;
            }
            a = C31776a.m51470b(collection, ((C31746h) it.next()).mo219a(c37022f, c8085a));
        }
        a = collection == null ? C44629x.AUR : collection;
        AppMethodBeat.m2505o(119867);
        return a;
    }

    /* renamed from: b */
    public final Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        Collection<C41397al> collection;
        AppMethodBeat.m2504i(119868);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        m14285d(c37022f, c8085a);
        C31653j c31653j = this.BnN;
        List ebp = ebp();
        Collection<C41397al> b = c31653j.mo221b(c37022f, c8085a);
        Iterator it = ebp.iterator();
        while (true) {
            collection = b;
            if (!it.hasNext()) {
                break;
            }
            b = C31776a.m51470b(collection, ((C31746h) it.next()).mo221b(c37022f, c8085a));
        }
        b = collection == null ? C44629x.AUR : collection;
        AppMethodBeat.m2505o(119868);
        return b;
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        Collection<C31642l> collection;
        AppMethodBeat.m2504i(119869);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        C31653j c31653j = this.BnN;
        List ebp = ebp();
        Collection<C31642l> a = c31653j.mo220a(c0136d, c17126b);
        Iterator it = ebp.iterator();
        while (true) {
            collection = a;
            if (!it.hasNext()) {
                break;
            }
            a = C31776a.m51470b(collection, ((C31746h) it.next()).mo220a(c0136d, c17126b));
        }
        if (collection == null) {
            a = C44629x.AUR;
        } else {
            a = collection;
        }
        AppMethodBeat.m2505o(119869);
        return a;
    }

    public final Set<C37022f> eau() {
        AppMethodBeat.m2504i(119870);
        Collection linkedHashSet = new LinkedHashSet();
        for (C31746h eau : ebp()) {
            C44628q.m81054a(linkedHashSet, (Iterable) eau.eau());
        }
        ((Set) linkedHashSet).addAll(this.BnN.eau());
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(119870);
        return set;
    }

    public final Set<C37022f> eav() {
        AppMethodBeat.m2504i(119871);
        Collection linkedHashSet = new LinkedHashSet();
        for (C31746h eav : ebp()) {
            C44628q.m81054a(linkedHashSet, (Iterable) eav.eav());
        }
        ((Set) linkedHashSet).addAll(this.BnN.eav());
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(119871);
        return set;
    }

    /* renamed from: d */
    private void m14285d(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(119872);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C17171a.m26542a(this.Bnn.Bnv.Bnc, c8085a, (C36953ab) this.BnP, c37022f);
        AppMethodBeat.m2505o(119872);
    }
}
