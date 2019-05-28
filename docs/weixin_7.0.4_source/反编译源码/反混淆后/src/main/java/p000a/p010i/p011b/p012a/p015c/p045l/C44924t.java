package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31824m;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.l.t */
public final class C44924t {
    /* renamed from: ai */
    public static final boolean m82160ai(C46867w c46867w) {
        AppMethodBeat.m2504i(122591);
        C25052j.m39376p(c46867w, "receiver$0");
        boolean z = c46867w.ekn() instanceof C17325q;
        AppMethodBeat.m2505o(122591);
        return z;
    }

    /* renamed from: aj */
    public static final C17325q m82161aj(C46867w c46867w) {
        AppMethodBeat.m2504i(122592);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        if (ekn == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
            AppMethodBeat.m2505o(122592);
            throw c44941v;
        }
        C17325q c17325q = (C17325q) ekn;
        AppMethodBeat.m2505o(122592);
        return c17325q;
    }

    /* renamed from: ak */
    public static final C8235ad m82162ak(C46867w c46867w) {
        AppMethodBeat.m2504i(122593);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        C8235ad c8235ad;
        if (ekn instanceof C17325q) {
            c8235ad = ((C17325q) ekn).BJx;
            AppMethodBeat.m2505o(122593);
            return c8235ad;
        } else if (ekn instanceof C8235ad) {
            c8235ad = (C8235ad) ekn;
            AppMethodBeat.m2505o(122593);
            return c8235ad;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122593);
            throw c31824m;
        }
    }

    /* renamed from: al */
    public static final C8235ad m82163al(C46867w c46867w) {
        AppMethodBeat.m2504i(122594);
        C25052j.m39376p(c46867w, "receiver$0");
        C41447az ekn = c46867w.ekn();
        C8235ad c8235ad;
        if (ekn instanceof C17325q) {
            c8235ad = ((C17325q) ekn).BJy;
            AppMethodBeat.m2505o(122594);
            return c8235ad;
        } else if (ekn instanceof C8235ad) {
            c8235ad = (C8235ad) ekn;
            AppMethodBeat.m2505o(122594);
            return c8235ad;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122594);
            throw c31824m;
        }
    }
}
