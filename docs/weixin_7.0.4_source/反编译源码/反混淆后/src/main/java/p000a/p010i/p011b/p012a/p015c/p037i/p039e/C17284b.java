package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.android.gms.common.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.C44628q;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C6134i;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p047m.p1437b.C31776a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.b */
public final class C17284b implements C31746h {
    public static final C17285a BFu = new C17285a();
    private final List<C31746h> BFt;
    private final String ByG;

    /* renamed from: a.i.b.a.c.i.e.b$a */
    public static final class C17285a {
        private C17285a() {
        }

        public /* synthetic */ C17285a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(122175);
        AppMethodBeat.m2505o(122175);
    }

    public C17284b(String str, List<? extends C31746h> list) {
        C25052j.m39376p(str, "debugName");
        C25052j.m39376p(list, Constants.KEY_SCOPES);
        AppMethodBeat.m2504i(122174);
        this.ByG = str;
        this.BFt = list;
        AppMethodBeat.m2505o(122174);
    }

    /* renamed from: c */
    public final C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122168);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C0036h c0036h = null;
        for (C31746h c : this.BFt) {
            C0036h c2 = c.mo222c(c37022f, c8085a);
            if (c2 != null) {
                if (!(c2 instanceof C6134i) || !((C6134i) c2).dYk()) {
                    AppMethodBeat.m2505o(122168);
                    return c2;
                } else if (c0036h == null) {
                    c0036h = c2;
                }
            }
        }
        AppMethodBeat.m2505o(122168);
        return c0036h;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122169);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = C44629x.AUR;
            AppMethodBeat.m2505o(122169);
            return collection;
        }
        Collection<C31220ah> collection2;
        Collection<C31220ah> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = C31776a.m51470b(collection2, ((C31746h) it.next()).mo219a(c37022f, c8085a));
        }
        if (collection2 == null) {
            collection3 = C44629x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.m2505o(122169);
        return collection3;
    }

    /* renamed from: b */
    public final Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122170);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = C44629x.AUR;
            AppMethodBeat.m2505o(122170);
            return collection;
        }
        Collection<C41397al> collection2;
        Collection<C41397al> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = C31776a.m51470b(collection2, ((C31746h) it.next()).mo221b(c37022f, c8085a));
        }
        if (collection2 == null) {
            collection3 = C44629x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.m2505o(122170);
        return collection3;
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(122171);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = C44629x.AUR;
            AppMethodBeat.m2505o(122171);
            return collection;
        }
        Collection<C31642l> collection2;
        Collection<C31642l> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = C31776a.m51470b(collection2, ((C31746h) it.next()).mo220a(c0136d, c17126b));
        }
        if (collection2 == null) {
            collection3 = C44629x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.m2505o(122171);
        return collection3;
    }

    public final Set<C37022f> eau() {
        AppMethodBeat.m2504i(122172);
        Collection linkedHashSet = new LinkedHashSet();
        for (C31746h eau : this.BFt) {
            C44628q.m81054a(linkedHashSet, (Iterable) eau.eau());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(122172);
        return set;
    }

    public final Set<C37022f> eav() {
        AppMethodBeat.m2504i(122173);
        Collection linkedHashSet = new LinkedHashSet();
        for (C31746h eav : this.BFt) {
            C44628q.m81054a(linkedHashSet, (Iterable) eav.eav());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(122173);
        return set;
    }

    public final String toString() {
        return this.ByG;
    }
}
