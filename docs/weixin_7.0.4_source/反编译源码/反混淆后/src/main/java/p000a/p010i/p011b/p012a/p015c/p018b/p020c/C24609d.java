package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36965o;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C8066ag.C8067a;
import p000a.p010i.p011b.p012a.p015c.p037i.C8202c;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C41444ag;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.d */
public abstract class C24609d extends C17168k implements C17159aq {
    protected List<? extends C36955ar> Bhf;
    private final C24611b Bhg = new C24611b(this);
    protected final C25082az Bhh;

    /* renamed from: a.i.b.a.c.b.c.d$a */
    static final class C24610a extends C25053k implements C17126b<C41447az, Boolean> {
        final /* synthetic */ C24609d Bhi;

        C24610a(C24609d c24609d) {
            this.Bhi = c24609d;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.m2504i(119383);
            C41447az c41447az = (C41447az) obj;
            C25052j.m39375o(c41447az, "type");
            if (!C25239y.m39807an(c41447az)) {
                C0036h dYs = c41447az.ejw().dYs();
                Object obj2 = (!(dYs instanceof C36955ar) || (C25052j.m39373j(((C36955ar) dYs).dXW(), this.Bhi) ^ 1) == 0) ? null : 1;
                if (obj2 != null) {
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.m2505o(119383);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(119383);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.d$b */
    public static final class C24611b implements C17313an {
        final /* synthetic */ C24609d Bhi;

        C24611b(C24609d c24609d) {
            this.Bhi = c24609d;
        }

        public final List<C36955ar> getParameters() {
            AppMethodBeat.m2504i(119384);
            List eao = this.Bhi.eao();
            AppMethodBeat.m2505o(119384);
            return eao;
        }

        public final boolean dYu() {
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119387);
            String str = "[typealias " + this.Bhi.dZg().name + ']';
            AppMethodBeat.m2505o(119387);
            return str;
        }

        public final /* bridge */ /* synthetic */ C0036h dYs() {
            return this.Bhi;
        }

        public final Collection<C46867w> eap() {
            AppMethodBeat.m2504i(119385);
            Collection eap = this.Bhi.dZP().ejw().eap();
            C25052j.m39375o(eap, "declarationDescriptor.un…pe.constructor.supertypes");
            AppMethodBeat.m2505o(119385);
            return eap;
        }

        public final C31619g dZD() {
            AppMethodBeat.m2504i(119386);
            C31619g G = C41434a.m72275G(this.Bhi);
            AppMethodBeat.m2505o(119386);
            return G;
        }
    }

    public abstract C25212i eak();

    public abstract List<C36955ar> eao();

    public final /* synthetic */ C31642l dZd() {
        return eam();
    }

    public final /* synthetic */ C0036h dZe() {
        return eam();
    }

    public final /* synthetic */ C36965o ean() {
        return eam();
    }

    public C24609d(C31642l c31642l, C0026g c0026g, C37022f c37022f, C41398am c41398am, C25082az c25082az) {
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c41398am, "sourceElement");
        C25052j.m39376p(c25082az, "visibilityImpl");
        super(c31642l, c0026g, c37022f, c41398am);
        this.Bhh = c25082az;
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        C25052j.m39376p(c44877n, "visitor");
        return c44877n.mo13674a((C17159aq) this, (Object) d);
    }

    public final boolean dYh() {
        return C17316av.m26822b((C46867w) dZP(), (C17126b) new C24610a(this));
    }

    public final Collection<C25086af> eal() {
        C46865e dZR = dZR();
        if (dZR == null) {
            return C17115v.AUP;
        }
        Collection<C36963d> dYb = dZR.dYb();
        C25052j.m39375o(dYb, "classDescriptor.constructors");
        Collection arrayList = new ArrayList();
        for (C36963d c36963d : dYb) {
            Object obj;
            C8067a c8067a = C8066ag.Bjq;
            C25212i eak = eak();
            C17159aq c17159aq = this;
            C25052j.m39375o(c36963d, "it");
            C25052j.m39376p(eak, "storageManager");
            C25052j.m39376p(c17159aq, "typeAliasDescriptor");
            C25052j.m39376p(c36963d, "constructor");
            C25227au a = C8067a.m14244a(c17159aq);
            if (a == null) {
                obj = null;
            } else {
                C36963d a2 = c36963d.mo58972a(a);
                if (a2 == null) {
                    obj = null;
                } else {
                    C0026g dYn = c36963d.dYn();
                    C8063a dYZ = c36963d.dYZ();
                    C25052j.m39375o(dYZ, "constructor.kind");
                    C41398am dYo = c17159aq.dYo();
                    C25052j.m39375o(dYo, "typeAliasDescriptor.source");
                    C8066ag c8066ag = new C8066ag(eak, c17159aq, a2, null, dYn, dYZ, dYo, (byte) 0);
                    List a3 = C36961p.m61735a((C8083t) c8066ag, c36963d.dYV(), a, false, false, null);
                    if (a3 == null) {
                        obj = null;
                    } else {
                        C41396ak a4;
                        C25052j.m39375o(a3, "FunctionDescriptorImpl.g…         ) ?: return null");
                        C8235ad ak = C44924t.m82162ak(a2.dYT().ekn());
                        C8235ad dZf = c17159aq.dZf();
                        C25052j.m39375o(dZf, "typeAliasDescriptor.defaultType");
                        C8235ad b = C41444ag.m72305b(ak, dZf);
                        C41396ak dYR = c36963d.dYR();
                        if (dYR != null) {
                            C8045a c8045a = c8066ag;
                            C25052j.m39375o(dYR, "it");
                            C46867w b2 = a.mo42079b(dYR.dZS(), C0163ba.INVARIANT);
                            C0027a c0027a = C0026g.BfJ;
                            a4 = C8202c.m14457a(c8045a, b2, C0027a.eai());
                        } else {
                            a4 = null;
                        }
                        c8066ag.mo58963a(a4, null, c17159aq.dYq(), a3, b, C44879w.FINAL, c17159aq.dYf());
                        C25086af obj2 = c8066ag;
                    }
                }
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return (List) arrayList;
    }

    public final List<C36955ar> dYq() {
        List list = this.Bhf;
        if (list == null) {
            C25052j.avw("declaredTypeParametersImpl");
        }
        return list;
    }

    public final C44879w dYd() {
        return C44879w.FINAL;
    }

    public final C25082az dYf() {
        return this.Bhh;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final boolean dYm() {
        return false;
    }

    public final C17313an dXY() {
        return this.Bhg;
    }

    public String toString() {
        return "typealias " + this.BgZ.name;
    }

    private C17159aq eam() {
        C36965o ean = super.dZd();
        if (ean != null) {
            return (C17159aq) ean;
        }
        throw new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
}
