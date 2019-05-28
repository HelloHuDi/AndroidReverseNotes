package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17156ao;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C31643m;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C25177j.C8205a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a.C41431c;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.l */
public final class C25178l implements C31746h {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C25178l.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    private final C31746h BGb;
    private final C25227au BGk;
    private Map<C31642l, C31642l> BGl;
    private final C44856f BGm = C17344i.m26854g(new C25179a(this));

    /* renamed from: a.i.b.a.c.i.e.l$a */
    static final class C25179a extends C25053k implements C31214a<Collection<? extends C31642l>> {
        final /* synthetic */ C25178l BGn;

        C25179a(C25178l c25178l) {
            this.BGn = c25178l;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122207);
            Collection a = C25178l.m39667a(this.BGn, C8205a.m14503a(this.BGn.BGb, null, null, 3));
            AppMethodBeat.m2505o(122207);
            return a;
        }
    }

    static {
        AppMethodBeat.m2504i(122208);
        AppMethodBeat.m2505o(122208);
    }

    public C25178l(C31746h c31746h, C25227au c25227au) {
        C25052j.m39376p(c31746h, "workerScope");
        C25052j.m39376p(c25227au, "givenSubstitutor");
        AppMethodBeat.m2504i(122217);
        this.BGb = c31746h;
        C44922as c44922as = c25227au.Bik;
        C25052j.m39375o(c44922as, "givenSubstitutor.substitution");
        this.BGk = C41431c.m72271c(c44922as).ekr();
        AppMethodBeat.m2505o(122217);
    }

    /* renamed from: J */
    private final <D extends C31642l> D m39665J(D d) {
        AppMethodBeat.m2504i(122209);
        if (this.BGk.Bik.isEmpty()) {
            AppMethodBeat.m2505o(122209);
            return d;
        }
        if (this.BGl == null) {
            this.BGl = new HashMap();
        }
        Map map = this.BGl;
        if (map == null) {
            C25052j.dWJ();
        }
        Object obj = map.get(d);
        if (obj == null) {
            Throwable assertionError;
            if (d instanceof C17156ao) {
                C31643m f = ((C17156ao) d).mo17870f(this.BGk);
                if (f == null) {
                    assertionError = new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
                    AppMethodBeat.m2505o(122209);
                    throw assertionError;
                }
                obj = f;
                map.put(d, obj);
            } else {
                assertionError = new IllegalStateException("Unknown descriptor in scope: ".concat(String.valueOf(d)).toString());
                AppMethodBeat.m2505o(122209);
                throw assertionError;
            }
        }
        D d2 = (C31642l) obj;
        if (d2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type D");
            AppMethodBeat.m2505o(122209);
            throw c44941v;
        }
        AppMethodBeat.m2505o(122209);
        return d2;
    }

    /* renamed from: o */
    private final <D extends C31642l> Collection<D> m39668o(Collection<? extends D> collection) {
        AppMethodBeat.m2504i(122210);
        if (this.BGk.Bik.isEmpty()) {
            AppMethodBeat.m2505o(122210);
            return collection;
        } else if (collection.isEmpty()) {
            AppMethodBeat.m2505o(122210);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(C31780a.m51476UR(collection.size()));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(m39665J((C31642l) it.next()));
            }
            Collection<? extends D> collection2 = linkedHashSet;
            AppMethodBeat.m2505o(122210);
            return collection2;
        }
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122211);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection o = m39668o(this.BGb.mo219a(c37022f, c8085a));
        AppMethodBeat.m2505o(122211);
        return o;
    }

    /* renamed from: c */
    public final C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122212);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C0036h c = this.BGb.mo222c(c37022f, c8085a);
        if (c != null) {
            c = (C0036h) m39665J(c);
            AppMethodBeat.m2505o(122212);
            return c;
        }
        AppMethodBeat.m2505o(122212);
        return null;
    }

    /* renamed from: b */
    public final Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122213);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection o = m39668o(this.BGb.mo221b(c37022f, c8085a));
        AppMethodBeat.m2505o(122213);
        return o;
    }

    public final Set<C37022f> eau() {
        AppMethodBeat.m2504i(122215);
        Set eau = this.BGb.eau();
        AppMethodBeat.m2505o(122215);
        return eau;
    }

    public final Set<C37022f> eav() {
        AppMethodBeat.m2504i(122216);
        Set eav = this.BGb.eav();
        AppMethodBeat.m2505o(122216);
        return eav;
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(122214);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        Collection collection = (Collection) this.BGm.getValue();
        AppMethodBeat.m2505o(122214);
        return collection;
    }
}
