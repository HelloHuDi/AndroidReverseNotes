package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p048n.C44929i;
import p000a.p010i.p011b.p012a.p015c.p048n.C44929i.C17332b;

/* renamed from: a.i.b.a.c.i.k */
public final class C31754k {

    /* renamed from: a.i.b.a.c.i.k$a */
    public static final class C31755a extends C25053k implements C17126b<D, D> {
        public static final C31755a BEE = new C31755a();

        static {
            AppMethodBeat.m2504i(122038);
            AppMethodBeat.m2505o(122038);
        }

        C31755a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122037);
            C8045a c8045a = (C8045a) obj;
            C25052j.m39376p(c8045a, "receiver$0");
            AppMethodBeat.m2505o(122037);
            return c8045a;
        }
    }

    /* renamed from: a.i.b.a.c.i.k$b */
    static final class C31756b extends C25053k implements C17126b<H, C37091y> {
        final /* synthetic */ C44929i BEF;

        C31756b(C44929i c44929i) {
            this.BEF = c44929i;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122039);
            C44929i c44929i = this.BEF;
            C25052j.m39375o(obj, "it");
            c44929i.add(obj);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(122039);
            return c37091y;
        }
    }

    /* renamed from: b */
    public static final <H> Collection<H> m51428b(Collection<? extends H> collection, C17126b<? super H, ? extends C8045a> c17126b) {
        AppMethodBeat.m2504i(122040);
        C25052j.m39376p(collection, "receiver$0");
        C25052j.m39376p(c17126b, "descriptorByHandle");
        if (collection.size() <= 1) {
            AppMethodBeat.m2505o(122040);
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        C17332b c17332b = C44929i.BNv;
        C44929i ekD = C17332b.ekD();
        while (true) {
            if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                Object fJ = C25035t.m39337fJ(linkedList);
                c17332b = C44929i.BNv;
                C44929i ekD2 = C17332b.ekD();
                Collection a = C31747j.m51401a(fJ, (Collection) linkedList, (C17126b) c17126b, (C17126b) new C31756b(ekD2));
                C25052j.m39375o(a, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
                Object h;
                if (a.size() == 1 && ekD2.isEmpty()) {
                    h = C25035t.m39345h((Iterable) a);
                    C25052j.m39375o(h, "overridableGroup.single()");
                    ekD.add(h);
                } else {
                    fJ = C31747j.m51398a(a, (C17126b) c17126b);
                    C25052j.m39375o(fJ, "OverridingUtil.selectMos…roup, descriptorByHandle)");
                    C8045a c8045a = (C8045a) c17126b.mo50am(fJ);
                    for (Object next : a) {
                        C25052j.m39375o(next, "it");
                        if (!C31747j.m51417f(c8045a, (C8045a) c17126b.mo50am(next))) {
                            ekD2.add(next);
                        }
                    }
                    if (ekD2.isEmpty()) {
                        h = null;
                    } else {
                        h = 1;
                    }
                    if (h != null) {
                        ekD.addAll(ekD2);
                    }
                    ekD.add(fJ);
                }
            } else {
                Collection<H> collection2 = ekD;
                AppMethodBeat.m2505o(122040);
                return collection2;
            }
        }
    }
}
