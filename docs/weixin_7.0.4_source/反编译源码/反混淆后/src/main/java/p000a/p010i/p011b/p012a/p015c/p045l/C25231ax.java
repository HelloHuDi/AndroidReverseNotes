package p000a.p010i.p011b.p012a.p015c.p045l;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31824m;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.l.ax */
public final class C25231ax {
    /* renamed from: aG */
    public static final C46867w m39779aG(C46867w c46867w) {
        AppMethodBeat.m2504i(122701);
        C25052j.m39376p(c46867w, "receiver$0");
        if (c46867w instanceof C25230aw) {
            C46867w ekl = ((C25230aw) c46867w).ekl();
            AppMethodBeat.m2505o(122701);
            return ekl;
        }
        AppMethodBeat.m2505o(122701);
        return null;
    }

    /* renamed from: a */
    public static final C41447az m39778a(C41447az c41447az, C46867w c46867w) {
        AppMethodBeat.m2504i(122702);
        C25052j.m39376p(c41447az, "receiver$0");
        C25052j.m39376p(c46867w, C8741b.ORIGIN);
        C41447az b = C25231ax.m39780b(c41447az, C25231ax.m39779aG(c46867w));
        AppMethodBeat.m2505o(122702);
        return b;
    }

    /* renamed from: b */
    public static final C41447az m39780b(C41447az c41447az, C46867w c46867w) {
        AppMethodBeat.m2504i(122703);
        C25052j.m39376p(c41447az, "receiver$0");
        C41447az c8236af;
        if (c46867w == null) {
            AppMethodBeat.m2505o(122703);
            return c41447az;
        } else if (c41447az instanceof C8235ad) {
            c8236af = new C8236af((C8235ad) c41447az, c46867w);
            AppMethodBeat.m2505o(122703);
            return c8236af;
        } else if (c41447az instanceof C17325q) {
            c8236af = new C37058s((C17325q) c41447az, c46867w);
            AppMethodBeat.m2505o(122703);
            return c8236af;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122703);
            throw c31824m;
        }
    }
}
