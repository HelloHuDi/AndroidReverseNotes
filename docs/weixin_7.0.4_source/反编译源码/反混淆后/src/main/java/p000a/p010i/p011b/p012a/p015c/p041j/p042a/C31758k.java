package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37014ae;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C44899j;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44640e;

/* renamed from: a.i.b.a.c.j.a.k */
public final class C31758k {
    public final C31702c AWq;
    public final C41420h AWr;
    private final C31698a BGE;
    public final C25205w BHb;
    public final C0147q BHc = new C0147q(this);
    final C37007i BHd;
    final C44640e BHe;
    public final C31642l Bht;
    public final C8225i Brl;

    public C31758k(C8225i c8225i, C31702c c31702c, C31642l c31642l, C41420h c41420h, C37007i c37007i, C31698a c31698a, C44640e c44640e, C25205w c25205w, List<C37014ae> list) {
        C25052j.m39376p(c8225i, "components");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c41420h, "typeTable");
        C25052j.m39376p(c37007i, "versionRequirementTable");
        C25052j.m39376p(c31698a, "metadataVersion");
        C25052j.m39376p(list, "typeParameters");
        AppMethodBeat.m2504i(122269);
        this.Brl = c8225i;
        this.AWq = c31702c;
        this.Bht = c31642l;
        this.AWr = c41420h;
        this.BHd = c37007i;
        this.BGE = c31698a;
        this.BHe = c44640e;
        this.BHb = new C25205w(this, c25205w, list, "Deserializer for " + this.Bht.dZg(), (byte) 0);
        AppMethodBeat.m2505o(122269);
    }

    /* renamed from: a */
    public static /* synthetic */ C31758k m51431a(C31758k c31758k, C31642l c31642l, List list) {
        AppMethodBeat.m2504i(122268);
        C31758k a = c31758k.mo51745a(c31642l, list, c31758k.AWq, c31758k.AWr, c31758k.BHd, c31758k.BGE);
        AppMethodBeat.m2505o(122268);
        return a;
    }

    /* renamed from: a */
    public final C31758k mo51745a(C31642l c31642l, List<C37014ae> list, C31702c c31702c, C41420h c41420h, C37007i c37007i, C31698a c31698a) {
        AppMethodBeat.m2504i(122267);
        C25052j.m39376p(c31642l, "descriptor");
        C25052j.m39376p(list, "typeParameterProtos");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25052j.m39376p(c37007i, "versionRequirementTable");
        C25052j.m39376p(c31698a, "metadataVersion");
        C8225i c8225i = this.Brl;
        C25052j.m39376p(c31698a, "version");
        C31758k c31758k = new C31758k(c8225i, c31702c, c31642l, c41420h, C44899j.m82119a(c31698a) ? c37007i : this.BHd, c31698a, this.BHe, this.BHb, list);
        AppMethodBeat.m2505o(122267);
        return c31758k;
    }
}
