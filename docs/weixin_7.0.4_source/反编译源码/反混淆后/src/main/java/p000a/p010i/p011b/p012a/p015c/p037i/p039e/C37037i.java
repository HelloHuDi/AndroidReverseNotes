package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.C17115v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25081aw;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p048n.C8256d;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.i */
public abstract class C37037i implements C31746h {
    /* renamed from: c */
    public C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        return null;
    }

    public Set<C37022f> eau() {
        Collection arrayList = new ArrayList();
        for (Object next : mo220a(C0136d.BFS, C8256d.eku())) {
            if (next instanceof C41397al) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (C41397al dZg : (List) arrayList) {
            linkedHashSet.add(dZg.dZg());
        }
        return (Set) linkedHashSet;
    }

    public Set<C37022f> eav() {
        Collection arrayList = new ArrayList();
        for (Object next : mo220a(C0136d.BFT, C8256d.eku())) {
            if (next instanceof C25081aw) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (C25081aw dZg : (List) arrayList) {
            linkedHashSet.add(dZg.dZg());
        }
        return (Set) linkedHashSet;
    }

    /* renamed from: a */
    public Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        return C17115v.AUP;
    }

    /* renamed from: b */
    public Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        return C17115v.AUP;
    }

    /* renamed from: a */
    public Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        return C17115v.AUP;
    }

    /* renamed from: d */
    public void mo41969d(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C25177j c25177j = this;
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        c25177j.mo221b(c37022f, c8085a);
    }
}
