package p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41395aj;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8079r;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31541z;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C44873aa;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36656u;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31700b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44911f.C44910a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.j.a.a.i */
public final class C8218i extends C31541z implements C31234b {
    public final C36656u AWo;
    public final C31702c AWq;
    public final C41420h AWr;
    private C44910a BHO = C44910a.COMPATIBLE;
    private final C37007i BHd;
    public final C44640e BHe;

    public final C31702c ejV() {
        return this.AWq;
    }

    public final C41420h ejW() {
        return this.AWr;
    }

    public final C44640e ejX() {
        return this.BHe;
    }

    public C8218i(C31642l c31642l, C31220ah c31220ah, C0026g c0026g, C44879w c44879w, C25082az c25082az, boolean z, C37022f c37022f, C8063a c8063a, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C36656u c36656u, C31702c c31702c, C41420h c41420h, C37007i c37007i, C44640e c44640e) {
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c44879w, "modality");
        C25052j.m39376p(c25082az, "visibility");
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8063a, "kind");
        C25052j.m39376p(c36656u, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25052j.m39376p(c37007i, "versionRequirementTable");
        super(c31642l, c31220ah, c0026g, c44879w, c25082az, z, c37022f, c8063a, C41398am.BeR, z2, z3, z6, false, z4, z5);
        AppMethodBeat.m2504i(122415);
        this.AWo = c36656u;
        this.AWq = c31702c;
        this.AWr = c41420h;
        this.BHd = c37007i;
        this.BHe = c44640e;
        AppMethodBeat.m2505o(122415);
    }

    /* renamed from: a */
    public final void mo18019a(C44873aa c44873aa, C41395aj c41395aj, C8079r c8079r, C8079r c8079r2, C44910a c44910a) {
        AppMethodBeat.m2504i(122412);
        C25052j.m39376p(c44910a, "isExperimentalCoroutineInReleaseEnvironment");
        super.mo51497a(c44873aa, c41395aj, c8079r, c8079r2);
        C37091y c37091y = C37091y.AUy;
        this.BHO = c44910a;
        AppMethodBeat.m2505o(122412);
    }

    /* renamed from: a */
    public final C31541z mo18018a(C31642l c31642l, C44879w c44879w, C25082az c25082az, C31220ah c31220ah, C8063a c8063a, C37022f c37022f) {
        AppMethodBeat.m2504i(122413);
        C25052j.m39376p(c31642l, "newOwner");
        C25052j.m39376p(c44879w, "newModality");
        C25052j.m39376p(c25082az, "newVisibility");
        C25052j.m39376p(c8063a, "kind");
        C25052j.m39376p(c37022f, "newName");
        C31541z c8218i = new C8218i(c31642l, c31220ah, dYn(), c44879w, c25082az, this.BjC, c37022f, c8063a, this.BiY, eab(), dYm(), this.Bja, this.BhV, this.AWo, this.AWq, this.AWr, this.BHd, this.BHe);
        AppMethodBeat.m2505o(122413);
        return c8218i;
    }

    public final boolean dYm() {
        AppMethodBeat.m2504i(122414);
        Boolean Ug = C31700b.BwS.mo31314Ug(this.AWo.BsW);
        C25052j.m39375o(Ug, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
        boolean booleanValue = Ug.booleanValue();
        AppMethodBeat.m2505o(122414);
        return booleanValue;
    }

    public final /* bridge */ /* synthetic */ C8185q ejU() {
        return this.AWo;
    }
}
