package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8081s;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.i.b.u */
public final class C31741u extends C0128x<Integer> {
    public C31741u(int i) {
        super(Integer.valueOf(i));
        AppMethodBeat.m2504i(122119);
        AppMethodBeat.m2505o(122119);
    }

    /* renamed from: b */
    public final C46867w mo18011b(C25093y c25093y) {
        C8235ad dZf;
        C46867w c46867w;
        AppMethodBeat.m2504i(122117);
        C25052j.m39376p(c25093y, "module");
        C8173a c8173a = C31619g.Bag.BbD;
        C25052j.m39375o(c8173a, "KotlinBuiltIns.FQ_NAMES.uInt");
        C46865e a = C8081s.m14261a(c25093y, c8173a);
        if (a != null) {
            dZf = a.dZf();
            if (dZf != null) {
                c46867w = dZf;
                AppMethodBeat.m2505o(122117);
                return c46867w;
            }
        }
        dZf = C25235p.awn("Unsigned type UInt not found");
        C25052j.m39375o(dZf, "ErrorUtils.createErrorTy…ned type UInt not found\")");
        c46867w = dZf;
        AppMethodBeat.m2505o(122117);
        return c46867w;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122118);
        String str = ((Number) getValue()).intValue() + ".toUInt()";
        AppMethodBeat.m2505o(122118);
        return str;
    }
}
