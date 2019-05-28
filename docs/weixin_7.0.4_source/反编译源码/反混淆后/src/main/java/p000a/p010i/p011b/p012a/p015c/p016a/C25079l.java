package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.a.l */
public enum C25079l {
    UBYTE(r3),
    USHORT(r3),
    UINT(r3),
    ULONG(r3);
    
    final C37022f BbZ;
    final C8173a BcA;
    final C8173a BcB;

    private C25079l(C8173a c8173a) {
        C25052j.m39376p(c8173a, "classId");
        AppMethodBeat.m2504i(119116);
        this.BcB = c8173a;
        C37022f ehK = this.BcB.ByN.ByQ.ehK();
        C25052j.m39375o(ehK, "classId.shortClassName");
        this.BbZ = ehK;
        this.BcA = new C8173a(this.BcB.BcW, C37022f.avX(this.BbZ.name + "Array"));
        AppMethodBeat.m2505o(119116);
    }

    static {
        AppMethodBeat.m2505o(119115);
    }
}
