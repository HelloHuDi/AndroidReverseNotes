package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.h */
public final class C17280h extends C41432f<Double> {
    public C17280h(double d) {
        super(Double.valueOf(d));
        AppMethodBeat.m2504i(122086);
        AppMethodBeat.m2505o(122086);
    }

    /* renamed from: b */
    public final /* synthetic */ C46867w mo18011b(C25093y c25093y) {
        AppMethodBeat.m2504i(122084);
        C25052j.m39376p(c25093y, "module");
        C8235ad a = c25093y.dZD().mo51607a(C31622h.DOUBLE);
        C25052j.m39375o(a, "module.builtIns.doubleType");
        C46867w c46867w = a;
        AppMethodBeat.m2505o(122084);
        return c46867w;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122085);
        String str = ((Number) getValue()).doubleValue() + ".toDouble()";
        AppMethodBeat.m2505o(122085);
        return str;
    }
}
