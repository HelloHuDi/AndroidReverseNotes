package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.f */
public final class C8211f {
    /* renamed from: D */
    private static boolean m14511D(C31642l c31642l) {
        AppMethodBeat.m2504i(121982);
        C25052j.m39376p(c31642l, "receiver$0");
        if ((c31642l instanceof C46865e) && ((C46865e) c31642l).dYj()) {
            AppMethodBeat.m2505o(121982);
            return true;
        }
        AppMethodBeat.m2505o(121982);
        return false;
    }

    /* renamed from: aa */
    private static C41399au m14512aa(C46867w c46867w) {
        AppMethodBeat.m2504i(121983);
        C25052j.m39376p(c46867w, "receiver$0");
        C0036h dYs = c46867w.ejw().dYs();
        if (!(dYs instanceof C46865e)) {
            dYs = null;
        }
        C46865e c46865e = (C46865e) dYs;
        if (c46865e != null) {
            C25052j.m39376p(c46865e, "receiver$0");
            if (c46865e.dYj()) {
                C36963d dYe = c46865e.dYe();
                if (dYe != null) {
                    List dYV = dYe.dYV();
                    if (dYV != null) {
                        C41399au c41399au = (C41399au) C25035t.m39342fO(dYV);
                        AppMethodBeat.m2505o(121983);
                        return c41399au;
                    }
                }
                AppMethodBeat.m2505o(121983);
                return null;
            }
            AppMethodBeat.m2505o(121983);
            return null;
        }
        AppMethodBeat.m2505o(121983);
        return null;
    }

    /* renamed from: ab */
    public static final boolean m14513ab(C46867w c46867w) {
        AppMethodBeat.m2504i(121984);
        C25052j.m39376p(c46867w, "receiver$0");
        C0036h dYs = c46867w.ejw().dYs();
        if (dYs != null) {
            boolean D = C8211f.m14511D(dYs);
            AppMethodBeat.m2505o(121984);
            return D;
        }
        AppMethodBeat.m2505o(121984);
        return false;
    }

    /* renamed from: ac */
    public static final C46867w m14514ac(C46867w c46867w) {
        AppMethodBeat.m2504i(121985);
        C25052j.m39376p(c46867w, "receiver$0");
        C41399au aa = C8211f.m14512aa(c46867w);
        if (aa == null) {
            AppMethodBeat.m2505o(121985);
            return null;
        }
        C31746h dXR = c46867w.dXR();
        C37022f dZg = aa.dZg();
        C25052j.m39375o(dZg, "parameter.name");
        C31220ah c31220ah = (C31220ah) C25035t.m39347i((Iterable) dXR.mo219a(dZg, C0039c.FOR_ALREADY_TRACKED));
        if (c31220ah != null) {
            C46867w dZS = c31220ah.dZS();
            AppMethodBeat.m2505o(121985);
            return dZS;
        }
        AppMethodBeat.m2505o(121985);
        return null;
    }
}
