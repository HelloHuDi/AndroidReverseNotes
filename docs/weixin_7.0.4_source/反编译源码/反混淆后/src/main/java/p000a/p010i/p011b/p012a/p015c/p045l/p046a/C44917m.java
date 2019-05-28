package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C41444ag;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.l.a.m */
public final class C44917m {
    public static final C44917m BKC = new C44917m();

    static {
        AppMethodBeat.m2504i(122761);
        AppMethodBeat.m2505o(122761);
    }

    private C44917m() {
    }

    /* renamed from: a */
    public final boolean mo72112a(C41447az c41447az, C41447az c41447az2) {
        AppMethodBeat.m2504i(122759);
        C25052j.m39376p(c41447az, "a");
        C25052j.m39376p(c41447az2, "b");
        if (c41447az == c41447az2) {
            AppMethodBeat.m2505o(122759);
            return true;
        } else if ((c41447az instanceof C8235ad) && (c41447az2 instanceof C8235ad)) {
            boolean c = mo72113c((C8235ad) c41447az, (C8235ad) c41447az2);
            AppMethodBeat.m2505o(122759);
            return c;
        } else if (!(c41447az instanceof C17325q) || !(c41447az2 instanceof C17325q)) {
            AppMethodBeat.m2505o(122759);
            return false;
        } else if (mo72113c(((C17325q) c41447az).BJx, ((C17325q) c41447az2).BJx) && mo72113c(((C17325q) c41447az).BJy, ((C17325q) c41447az2).BJy)) {
            AppMethodBeat.m2505o(122759);
            return true;
        } else {
            AppMethodBeat.m2505o(122759);
            return false;
        }
    }

    /* renamed from: c */
    public final boolean mo72113c(C8235ad c8235ad, C8235ad c8235ad2) {
        AppMethodBeat.m2504i(122760);
        C25052j.m39376p(c8235ad, "a");
        C25052j.m39376p(c8235ad2, "b");
        if (c8235ad.eci() != c8235ad2.eci() || C41444ag.m72304ap(c8235ad) != C41444ag.m72304ap(c8235ad2) || (C25052j.m39373j(c8235ad.ejw(), c8235ad2.ejw()) ^ 1) != 0 || c8235ad.ejt().size() != c8235ad2.ejt().size()) {
            AppMethodBeat.m2505o(122760);
            return false;
        } else if (c8235ad.ejt() == c8235ad2.ejt()) {
            AppMethodBeat.m2505o(122760);
            return true;
        } else {
            int size = c8235ad.ejt().size();
            for (int i = 0; i < size; i++) {
                C41446ap c41446ap = (C41446ap) c8235ad.ejt().get(i);
                C41446ap c41446ap2 = (C41446ap) c8235ad2.ejt().get(i);
                if (c41446ap.ekp() != c41446ap2.ekp()) {
                    AppMethodBeat.m2505o(122760);
                    return false;
                }
                if (!c41446ap.ekp()) {
                    if (c41446ap.ekq() != c41446ap2.ekq()) {
                        AppMethodBeat.m2505o(122760);
                        return false;
                    } else if (!mo72112a(c41446ap.dZS().ekn(), c41446ap2.dZS().ekn())) {
                        AppMethodBeat.m2505o(122760);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(122760);
            return true;
        }
    }
}
