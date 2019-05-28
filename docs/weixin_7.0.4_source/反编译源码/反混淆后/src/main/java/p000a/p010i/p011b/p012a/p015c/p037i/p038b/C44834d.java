package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.d */
public final class C44834d extends C44638m<Byte> {
    public C44834d(byte b) {
        super(Byte.valueOf(b));
        AppMethodBeat.m2504i(122074);
        AppMethodBeat.m2505o(122074);
    }

    /* renamed from: b */
    public final /* synthetic */ C46867w mo18011b(C25093y c25093y) {
        AppMethodBeat.m2504i(122072);
        C25052j.m39376p(c25093y, "module");
        C8235ad a = c25093y.dZD().mo51607a(C31622h.BYTE);
        C25052j.m39375o(a, "module.builtIns.byteType");
        C46867w c46867w = a;
        AppMethodBeat.m2505o(122072);
        return c46867w;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122073);
        String str = ((Number) getValue()).byteValue() + ".toByte()";
        AppMethodBeat.m2505o(122073);
        return str;
    }
}
