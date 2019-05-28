package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C25033k;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C31625i;
import p000a.p010i.p011b.p012a.p015c.p016a.C31625i.C31623b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8081s;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C44920ah;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b.C25240a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.m.e */
final class C25241e implements C44925b {
    public static final C25241e BLC = new C25241e();
    private static final String description = description;

    static {
        AppMethodBeat.m2504i(122865);
        AppMethodBeat.m2505o(122865);
    }

    private C25241e() {
    }

    /* renamed from: i */
    public final String mo18042i(C8083t c8083t) {
        AppMethodBeat.m2504i(122866);
        C25052j.m39376p(c8083t, "functionDescriptor");
        String a = C25240a.m39808a(this, c8083t);
        AppMethodBeat.m2505o(122866);
        return a;
    }

    public final String getDescription() {
        return description;
    }

    /* renamed from: h */
    public final boolean mo253h(C8083t c8083t) {
        C46867w c46867w;
        AppMethodBeat.m2504i(122864);
        C25052j.m39376p(c8083t, "functionDescriptor");
        C41399au c41399au = (C41399au) c8083t.dYV().get(1);
        C31623b c31623b = C31625i.Bcn;
        C25052j.m39375o(c41399au, "secondParameter");
        C25093y F = C41434a.m72274F(c41399au);
        C25052j.m39376p(F, "module");
        C8173a c8173a = C31619g.Bag.Bbw;
        C25052j.m39375o(c8173a, "KotlinBuiltIns.FQ_NAMES.kProperty");
        C46865e a = C8081s.m14261a(F, c8173a);
        if (a == null) {
            c46867w = null;
        } else {
            C0027a c0027a = C0026g.BfJ;
            C0026g eai = C0027a.eai();
            C17313an dXY = a.dXY();
            C25052j.m39375o(dXY, "kPropertyClass.typeConstructor");
            List parameters = dXY.getParameters();
            C25052j.m39375o(parameters, "kPropertyClass.typeConstructor.parameters");
            Object fN = C25035t.m39341fN(parameters);
            C25052j.m39375o(fN, "kPropertyClass.typeConstructor.parameters.single()");
            c46867w = C17326x.m26837a(eai, a, C25033k.listOf(new C44920ah((C36955ar) fN)));
        }
        if (c46867w != null) {
            C46867w dZS = c41399au.dZS();
            C25052j.m39375o(dZS, "secondParameter.type");
            boolean c = C41448a.m72318c(c46867w, C41448a.m72312aA(dZS));
            AppMethodBeat.m2505o(122864);
            return c;
        }
        AppMethodBeat.m2505o(122864);
        return false;
    }
}
