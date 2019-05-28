package p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C31643m;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44872as;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C24609d;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C25086af;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C17244ab;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44911f.C44910a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17315at;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.j.a.a.k */
public final class C25201k extends C24609d implements C44911f {
    private final C31702c AWq;
    private final C41420h AWr;
    private C44910a BHO = C44910a.COMPATIBLE;
    private final C37007i BHd;
    private final C44640e BHe;
    private C8235ad BIA;
    private C8235ad BIB;
    private final C17244ab BIC;
    private Collection<? extends C25086af> BIy;
    private C8235ad BIz;
    private final C25212i Baf;
    private List<? extends C36955ar> BiI;

    /* renamed from: f */
    public final /* synthetic */ C31643m mo17870f(C25227au c25227au) {
        C17159aq c17159aq;
        AppMethodBeat.m2504i(122424);
        C25052j.m39376p(c25227au, "substitutor");
        if (c25227au.Bik.isEmpty()) {
            c17159aq = this;
        } else {
            C25212i c25212i = this.Baf;
            C31642l dXW = dXW();
            C25052j.m39375o(dXW, "containingDeclaration");
            C0026g dYn = dYn();
            C25052j.m39375o(dYn, "annotations");
            C37022f c37022f = this.BgZ;
            C25052j.m39375o(c37022f, "name");
            C25201k c25201k = new C25201k(c25212i, dXW, dYn, c37022f, this.Bhh, this.BIC, this.AWq, this.AWr, this.BHd, this.BHe);
            List dYq = dYq();
            C46867w b = c25227au.mo42079b((C46867w) dZP(), C0163ba.INVARIANT);
            C25052j.m39375o(b, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            C8235ad av = C17315at.m26809av(b);
            b = c25227au.mo42079b((C46867w) dZQ(), C0163ba.INVARIANT);
            C25052j.m39375o(b, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            c25201k.mo42061a(dYq, av, C17315at.m26809av(b), this.BHO);
            c17159aq = c25201k;
        }
        C31643m c31643m = c17159aq;
        AppMethodBeat.m2505o(122424);
        return c31643m;
    }

    public final C25212i eak() {
        return this.Baf;
    }

    public final C31702c ejV() {
        return this.AWq;
    }

    public final C41420h ejW() {
        return this.AWr;
    }

    public final C44640e ejX() {
        return this.BHe;
    }

    public C25201k(C25212i c25212i, C31642l c31642l, C0026g c0026g, C37022f c37022f, C25082az c25082az, C17244ab c17244ab, C31702c c31702c, C41420h c41420h, C37007i c37007i, C44640e c44640e) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c25082az, "visibility");
        C25052j.m39376p(c17244ab, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25052j.m39376p(c37007i, "versionRequirementTable");
        C41398am c41398am = C41398am.BeR;
        C25052j.m39375o(c41398am, "SourceElement.NO_SOURCE");
        super(c31642l, c0026g, c37022f, c41398am, c25082az);
        AppMethodBeat.m2504i(122426);
        this.Baf = c25212i;
        this.BIC = c17244ab;
        this.AWq = c31702c;
        this.AWr = c41420h;
        this.BHd = c37007i;
        this.BHe = c44640e;
        AppMethodBeat.m2505o(122426);
    }

    public final C8235ad dZP() {
        AppMethodBeat.m2504i(122419);
        C8235ad c8235ad = this.BIz;
        if (c8235ad == null) {
            C25052j.avw("underlyingType");
        }
        AppMethodBeat.m2505o(122419);
        return c8235ad;
    }

    public final C8235ad dZQ() {
        AppMethodBeat.m2504i(122420);
        C8235ad c8235ad = this.BIA;
        if (c8235ad == null) {
            C25052j.avw("expandedType");
        }
        AppMethodBeat.m2505o(122420);
        return c8235ad;
    }

    /* JADX WARNING: Missing block: B:3:0x003d, code skipped:
            if (r1 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo42061a(List<? extends C36955ar> list, C8235ad c8235ad, C8235ad c8235ad2, C44910a c44910a) {
        C31746h dXZ;
        AppMethodBeat.m2504i(122421);
        C25052j.m39376p(list, "declaredTypeParameters");
        C25052j.m39376p(c8235ad, "underlyingType");
        C25052j.m39376p(c8235ad2, "expandedType");
        C25052j.m39376p(c44910a, "isExperimentalCoroutineInReleaseEnvironment");
        C25052j.m39376p(list, "declaredTypeParameters");
        this.Bhf = list;
        this.BIz = c8235ad;
        this.BIA = c8235ad2;
        this.BiI = C44872as.m82070a(this);
        C0036h c0036h = this;
        C46865e dZR = dZR();
        if (dZR != null) {
            dXZ = dZR.dXZ();
        }
        dXZ = C17288b.BGh;
        C8235ad a = C17316av.m26810a(c0036h, dXZ);
        C25052j.m39375o(a, "TypeUtils.makeUnsubstitu…ope ?: MemberScope.Empty)");
        this.BIB = a;
        this.BIy = eal();
        this.BHO = c44910a;
        AppMethodBeat.m2505o(122421);
    }

    public final C46865e dZR() {
        AppMethodBeat.m2504i(122422);
        if (C25239y.m39807an(dZQ())) {
            AppMethodBeat.m2505o(122422);
            return null;
        }
        C0036h dYs = dZQ().ejw().dYs();
        if (!(dYs instanceof C46865e)) {
            dYs = null;
        }
        C46865e c46865e = (C46865e) dYs;
        AppMethodBeat.m2505o(122422);
        return c46865e;
    }

    public final C8235ad dZf() {
        AppMethodBeat.m2504i(122423);
        C8235ad c8235ad = this.BIB;
        if (c8235ad == null) {
            C25052j.avw("defaultTypeImpl");
        }
        AppMethodBeat.m2505o(122423);
        return c8235ad;
    }

    public final List<C36955ar> eao() {
        AppMethodBeat.m2504i(122425);
        List list = this.BiI;
        if (list == null) {
            C25052j.avw("typeConstructorParameters");
        }
        AppMethodBeat.m2505o(122425);
        return list;
    }

    public final /* bridge */ /* synthetic */ C8185q ejU() {
        return this.BIC;
    }
}
