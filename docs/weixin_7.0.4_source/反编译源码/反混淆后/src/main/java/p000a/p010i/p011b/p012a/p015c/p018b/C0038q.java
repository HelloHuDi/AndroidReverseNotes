package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.q */
public final class C0038q {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final C46865e m38a(C25093y c25093y, C8174b c8174b, C8085a c8085a) {
        AppMethodBeat.m2504i(119267);
        C25052j.m39376p(c25093y, "receiver$0");
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(c8085a, "lookupLocation");
        if (c8174b.ByQ.ByV.isEmpty()) {
            AppMethodBeat.m2505o(119267);
            return null;
        }
        C8174b ehG = c8174b.ehG();
        C25052j.m39375o(ehG, "fqName.parent()");
        C31746h dXR = c25093y.mo252g(ehG).dXR();
        C37022f ehK = c8174b.ByQ.ehK();
        C25052j.m39375o(ehK, "fqName.shortName()");
        C0036h c = dXR.mo222c(ehK, c8085a);
        if (!(c instanceof C46865e)) {
            c = null;
        }
        C46865e c46865e = (C46865e) c;
        if (c46865e != null) {
            AppMethodBeat.m2505o(119267);
            return c46865e;
        }
        ehG = c8174b.ehG();
        C25052j.m39375o(ehG, "fqName.parent()");
        c46865e = C0038q.m38a(c25093y, ehG, c8085a);
        if (c46865e != null) {
            dXR = c46865e.dZk();
            if (dXR != null) {
                ehK = c8174b.ByQ.ehK();
                C25052j.m39375o(ehK, "fqName.shortName()");
                c = dXR.mo222c(ehK, c8085a);
                if (!(c instanceof C46865e)) {
                    c = null;
                }
                c46865e = (C46865e) c;
                AppMethodBeat.m2505o(119267);
                return c46865e;
            }
        }
        c = null;
        if (c instanceof C46865e) {
        }
        c46865e = (C46865e) c;
        AppMethodBeat.m2505o(119267);
        return c46865e;
    }
}
