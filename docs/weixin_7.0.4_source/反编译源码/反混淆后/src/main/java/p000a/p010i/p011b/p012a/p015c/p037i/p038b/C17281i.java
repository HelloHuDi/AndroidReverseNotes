package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31826o;
import p000a.C8312u;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8081s;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.i.b.i */
public final class C17281i extends C41432f<C31826o<? extends C8173a, ? extends C37022f>> {
    private final C8173a BER;
    public final C37022f BES;

    public C17281i(C8173a c8173a, C37022f c37022f) {
        C25052j.m39376p(c8173a, "enumClassId");
        C25052j.m39376p(c37022f, "enumEntryName");
        super(C8312u.m14628I(c8173a, c37022f));
        AppMethodBeat.m2504i(122089);
        this.BER = c8173a;
        this.BES = c37022f;
        AppMethodBeat.m2505o(122089);
    }

    /* renamed from: b */
    public final C46867w mo18011b(C25093y c25093y) {
        C8235ad dZf;
        C46867w c46867w;
        AppMethodBeat.m2504i(122087);
        C25052j.m39376p(c25093y, "module");
        C46865e a = C8081s.m14261a(c25093y, this.BER);
        if (a != null) {
            if (!C8203d.m14501y((C31642l) a)) {
                a = null;
            }
            if (a != null) {
                dZf = a.dZf();
                if (dZf != null) {
                    c46867w = dZf;
                    AppMethodBeat.m2505o(122087);
                    return c46867w;
                }
            }
        }
        dZf = C25235p.awn("Containing class for error-class based enum entry " + this.BER + '.' + this.BES);
        C25052j.m39375o(dZf, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
        c46867w = dZf;
        AppMethodBeat.m2505o(122087);
        return c46867w;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122088);
        String str = this.BER.ehB() + '.' + this.BES;
        AppMethodBeat.m2505o(122088);
        return str;
    }
}
