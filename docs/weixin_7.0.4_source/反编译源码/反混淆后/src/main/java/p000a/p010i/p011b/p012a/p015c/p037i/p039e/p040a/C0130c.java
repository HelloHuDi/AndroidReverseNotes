package p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.e.a.c */
public final class C0130c implements C8204d, C37036g {
    private final C0130c BGv = this;
    private final C46865e BGw = this.BGx;
    private final C46865e BGx;

    public C0130c(C46865e c46865e) {
        C25052j.m39376p(c46865e, "classDescriptor");
        AppMethodBeat.m2504i(122236);
        this.BGx = c46865e;
        AppMethodBeat.m2505o(122236);
    }

    public final /* synthetic */ C46867w dZS() {
        AppMethodBeat.m2504i(122232);
        C46867w ebq = ebq();
        AppMethodBeat.m2505o(122232);
        return ebq;
    }

    public final C46865e dZR() {
        return this.BGx;
    }

    private C8235ad ebq() {
        AppMethodBeat.m2504i(122231);
        C8235ad dZf = this.BGx.dZf();
        C25052j.m39375o(dZf, "classDescriptor.defaultType");
        AppMethodBeat.m2505o(122231);
        return dZf;
    }

    public final boolean equals(Object obj) {
        Object obj2 = null;
        AppMethodBeat.m2504i(122233);
        C46865e c46865e = this.BGx;
        C0130c c0130c = (C0130c) (!(obj instanceof C0130c) ? null : obj);
        if (c0130c != null) {
            obj2 = c0130c.BGx;
        }
        boolean j = C25052j.m39373j(c46865e, obj2);
        AppMethodBeat.m2505o(122233);
        return j;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(122234);
        int hashCode = this.BGx.hashCode();
        AppMethodBeat.m2505o(122234);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122235);
        String str = "Class{" + ebq() + '}';
        AppMethodBeat.m2505o(122235);
        return str;
    }
}
