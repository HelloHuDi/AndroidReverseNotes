package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p000a.p001a.C17115v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C6134i;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d.C0137a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.f */
public final class C41182f extends C37037i {
    private final C31746h BGb;

    public C41182f(C31746h c31746h) {
        C25052j.m39376p(c31746h, "workerScope");
        AppMethodBeat.m2504i(122192);
        this.BGb = c31746h;
        AppMethodBeat.m2505o(122192);
    }

    /* renamed from: a */
    public final /* synthetic */ Collection mo220a(C0136d c0136d, C17126b c17126b) {
        C0136d c0136d2;
        List list;
        AppMethodBeat.m2504i(122188);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        C0137a c0137a = C0136d.BFX;
        int ejK = c0136d.BFy & C0136d.BFI;
        if (ejK == 0) {
            c0136d2 = null;
        } else {
            c0136d2 = new C0136d(ejK, c0136d.BFz);
        }
        if (c0136d2 == null) {
            list = C17115v.AUP;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : this.BGb.mo220a(c0136d2, c17126b)) {
                if (next instanceof C6134i) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        Collection collection = list;
        AppMethodBeat.m2505o(122188);
        return collection;
    }

    /* renamed from: c */
    public final C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122187);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C0036h c = this.BGb.mo222c(c37022f, c8085a);
        if (c != null) {
            C0036h c0036h;
            if (c instanceof C46865e) {
                c0036h = c;
            } else {
                c0036h = null;
            }
            C46865e c46865e = (C46865e) c0036h;
            if (c46865e != null) {
                c0036h = c46865e;
                AppMethodBeat.m2505o(122187);
                return c0036h;
            }
            if (c instanceof C17159aq) {
                c0036h = c;
            } else {
                c0036h = null;
            }
            c0036h = (C17159aq) c0036h;
            AppMethodBeat.m2505o(122187);
            return c0036h;
        }
        AppMethodBeat.m2505o(122187);
        return null;
    }

    public final Set<C37022f> eau() {
        AppMethodBeat.m2504i(122189);
        Set eau = this.BGb.eau();
        AppMethodBeat.m2505o(122189);
        return eau;
    }

    public final Set<C37022f> eav() {
        AppMethodBeat.m2504i(122190);
        Set eav = this.BGb.eav();
        AppMethodBeat.m2505o(122190);
        return eav;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122191);
        String str = "Classes from " + this.BGb;
        AppMethodBeat.m2505o(122191);
        return str;
    }
}
