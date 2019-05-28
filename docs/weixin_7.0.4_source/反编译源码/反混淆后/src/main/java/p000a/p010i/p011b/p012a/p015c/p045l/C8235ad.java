package p000a.p010i.p011b.p012a.p015c.p045l;

import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p051k.C8310r;

/* renamed from: a.i.b.a.c.l.ad */
public abstract class C8235ad extends C41447az {
    /* renamed from: d */
    public abstract C8235ad mo18030d(C0026g c0026g);

    /* renamed from: rL */
    public abstract C8235ad mo18033rL(boolean z);

    public C8235ad() {
        super();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (C44869c c44869c : dYn()) {
            C8310r.m14626a(stringBuilder, "[", C31724c.BBN.mo13661a(c44869c, null), "] ");
        }
        stringBuilder.append(ejw());
        if (!ejt().isEmpty()) {
            C25035t.m39320a(ejt(), stringBuilder, ", ", "<", ">", 0, null, null, 112);
        }
        if (eci()) {
            stringBuilder.append("?");
        }
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
