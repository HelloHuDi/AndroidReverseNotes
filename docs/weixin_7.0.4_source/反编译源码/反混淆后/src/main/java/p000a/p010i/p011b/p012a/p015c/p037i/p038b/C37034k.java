package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.k */
public final class C37034k extends C41432f<Float> {
    public C37034k(float f) {
        super(Float.valueOf(f));
        AppMethodBeat.m2504i(122095);
        AppMethodBeat.m2505o(122095);
    }

    /* renamed from: b */
    public final /* synthetic */ C46867w mo18011b(C25093y c25093y) {
        AppMethodBeat.m2504i(122093);
        C25052j.m39376p(c25093y, "module");
        C8235ad a = c25093y.dZD().mo51607a(C31622h.FLOAT);
        C25052j.m39375o(a, "module.builtIns.floatType");
        C46867w c46867w = a;
        AppMethodBeat.m2505o(122093);
        return c46867w;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122094);
        String str = ((Number) getValue()).floatValue() + ".toFloat()";
        AppMethodBeat.m2505o(122094);
        return str;
    }
}
