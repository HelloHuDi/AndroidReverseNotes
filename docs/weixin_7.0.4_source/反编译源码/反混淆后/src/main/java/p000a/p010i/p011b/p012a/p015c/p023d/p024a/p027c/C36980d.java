package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a.C0046a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f.C41415h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f.C8119d;

/* renamed from: a.i.b.a.c.d.a.c.d */
public final class C36980d {
    final EnumMap<C0046a, C41415h> Bnl;

    public C36980d(EnumMap<C0046a, C41415h> enumMap) {
        C25052j.m39376p(enumMap, "nullabilityQualifiers");
        AppMethodBeat.m2504i(119827);
        this.Bnl = enumMap;
        AppMethodBeat.m2505o(119827);
    }

    /* renamed from: b */
    public final C8119d mo58982b(C0046a c0046a) {
        AppMethodBeat.m2504i(119826);
        C41415h c41415h = (C41415h) this.Bnl.get(c0046a);
        if (c41415h == null) {
            AppMethodBeat.m2505o(119826);
            return null;
        }
        C25052j.m39375o(c41415h, "nullabilityQualifiers[ap…ilityType] ?: return null");
        C8119d c8119d = new C8119d(c41415h.BpP, null, false, c41415h.BpQ);
        AppMethodBeat.m2505o(119826);
        return c8119d;
    }
}
