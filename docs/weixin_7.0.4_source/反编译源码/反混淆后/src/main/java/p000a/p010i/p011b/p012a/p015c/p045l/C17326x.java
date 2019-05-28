package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao.C8238a;

/* renamed from: a.i.b.a.c.l.x */
public final class C17326x {
    public static final C17326x BJI = new C17326x();

    static {
        AppMethodBeat.m2504i(122609);
        AppMethodBeat.m2505o(122609);
    }

    private C17326x() {
    }

    /* renamed from: c */
    public static final C8235ad m26840c(C0026g c0026g, C17313an c17313an, List<? extends C41446ap> list, boolean z) {
        AppMethodBeat.m2504i(122605);
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c17313an, "constructor");
        C25052j.m39376p(list, "arguments");
        C0036h dYs;
        C8235ad a;
        if (!c0026g.isEmpty() || !list.isEmpty() || z || c17313an.dYs() == null) {
            C31746h dXR;
            dYs = c17313an.dYs();
            if (dYs instanceof C36955ar) {
                dXR = dYs.dZf().dXR();
            } else if (dYs instanceof C46865e) {
                if (list.isEmpty()) {
                    dXR = ((C46865e) dYs).dZf().dXR();
                } else {
                    C46865e c46865e = (C46865e) dYs;
                    C8238a c8238a = C25225ao.BJQ;
                    dXR = c46865e.mo31262a(C8238a.m14558a(c17313an, list));
                    C25052j.m39375o(dXR, "descriptor.getMemberScop…(constructor, arguments))");
                }
            } else if (dYs instanceof C17159aq) {
                dXR = C25235p.m39798cw("Scope for abbreviation: " + ((C17159aq) dYs).dZg(), true);
                C25052j.m39375o(dXR, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
            } else {
                Throwable illegalStateException = new IllegalStateException("Unsupported classifier: " + dYs + " for constructor: " + c17313an);
                AppMethodBeat.m2505o(122605);
                throw illegalStateException;
            }
            a = C17326x.m26838a(c0026g, c17313an, list, z, dXR);
            AppMethodBeat.m2505o(122605);
            return a;
        }
        dYs = c17313an.dYs();
        if (dYs == null) {
            C25052j.dWJ();
        }
        C25052j.m39375o(dYs, "constructor.declarationDescriptor!!");
        a = dYs.dZf();
        C25052j.m39375o(a, "constructor.declarationDescriptor!!.defaultType");
        AppMethodBeat.m2505o(122605);
        return a;
    }

    /* renamed from: a */
    public static final C8235ad m26838a(C0026g c0026g, C17313an c17313an, List<? extends C41446ap> list, boolean z, C31746h c31746h) {
        AppMethodBeat.m2504i(122606);
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c17313an, "constructor");
        C25052j.m39376p(list, "arguments");
        C25052j.m39376p(c31746h, "memberScope");
        C25223ae c25223ae = new C25223ae(c17313an, list, z, c31746h);
        C8235ad c8235ad;
        if (c0026g.isEmpty()) {
            c8235ad = c25223ae;
            AppMethodBeat.m2505o(122606);
            return c8235ad;
        }
        c8235ad = new C41452d(c25223ae, c0026g);
        AppMethodBeat.m2505o(122606);
        return c8235ad;
    }

    /* renamed from: a */
    public static final C8235ad m26837a(C0026g c0026g, C46865e c46865e, List<? extends C41446ap> list) {
        AppMethodBeat.m2504i(122607);
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c46865e, "descriptor");
        C25052j.m39376p(list, "arguments");
        C17313an dXY = c46865e.dXY();
        C25052j.m39375o(dXY, "descriptor.typeConstructor");
        C8235ad c = C17326x.m26840c(c0026g, dXY, list, false);
        AppMethodBeat.m2505o(122607);
        return c;
    }

    /* renamed from: a */
    public static final C41447az m26839a(C8235ad c8235ad, C8235ad c8235ad2) {
        AppMethodBeat.m2504i(122608);
        C25052j.m39376p(c8235ad, "lowerBound");
        C25052j.m39376p(c8235ad2, "upperBound");
        if (C25052j.m39373j(c8235ad, c8235ad2)) {
            C41447az c41447az = c8235ad;
            AppMethodBeat.m2505o(122608);
            return c41447az;
        }
        C41447az c25238r = new C25238r(c8235ad, c8235ad2);
        AppMethodBeat.m2505o(122608);
        return c25238r;
    }
}
