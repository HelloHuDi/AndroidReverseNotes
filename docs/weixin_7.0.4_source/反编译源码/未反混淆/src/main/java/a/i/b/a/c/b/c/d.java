package a.i.b.a.c.b.c;

import a.a.v;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.o;
import a.i.b.a.c.b.t;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.c;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ag;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class d extends k implements aq {
    protected List<? extends ar> Bhf;
    private final b Bhg = new b(this);
    protected final az Bhh;

    static final class a extends k implements a.f.a.b<a.i.b.a.c.l.az, Boolean> {
        final /* synthetic */ d Bhi;

        a(d dVar) {
            this.Bhi = dVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.i(119383);
            a.i.b.a.c.l.az azVar = (a.i.b.a.c.l.az) obj;
            j.o(azVar, "type");
            if (!y.an(azVar)) {
                h dYs = azVar.ejw().dYs();
                Object obj2 = (!(dYs instanceof ar) || (j.j(((ar) dYs).dXW(), this.Bhi) ^ 1) == 0) ? null : 1;
                if (obj2 != null) {
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(119383);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(119383);
            return valueOf;
        }
    }

    public static final class b implements an {
        final /* synthetic */ d Bhi;

        b(d dVar) {
            this.Bhi = dVar;
        }

        public final List<ar> getParameters() {
            AppMethodBeat.i(119384);
            List eao = this.Bhi.eao();
            AppMethodBeat.o(119384);
            return eao;
        }

        public final boolean dYu() {
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(119387);
            String str = "[typealias " + this.Bhi.dZg().name + ']';
            AppMethodBeat.o(119387);
            return str;
        }

        public final /* bridge */ /* synthetic */ h dYs() {
            return this.Bhi;
        }

        public final Collection<w> eap() {
            AppMethodBeat.i(119385);
            Collection eap = this.Bhi.dZP().ejw().eap();
            j.o(eap, "declarationDescriptor.un…pe.constructor.supertypes");
            AppMethodBeat.o(119385);
            return eap;
        }

        public final g dZD() {
            AppMethodBeat.i(119386);
            g G = a.i.b.a.c.i.c.a.G(this.Bhi);
            AppMethodBeat.o(119386);
            return G;
        }
    }

    public abstract i eak();

    public abstract List<ar> eao();

    public final /* synthetic */ l dZd() {
        return eam();
    }

    public final /* synthetic */ h dZe() {
        return eam();
    }

    public final /* synthetic */ o ean() {
        return eam();
    }

    public d(l lVar, a.i.b.a.c.b.a.g gVar, f fVar, am amVar, az azVar) {
        j.p(lVar, "containingDeclaration");
        j.p(gVar, "annotations");
        j.p(fVar, "name");
        j.p(amVar, "sourceElement");
        j.p(azVar, "visibilityImpl");
        super(lVar, gVar, fVar, amVar);
        this.Bhh = azVar;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        j.p(nVar, "visitor");
        return nVar.a((aq) this, (Object) d);
    }

    public final boolean dYh() {
        return av.b((w) dZP(), (a.f.a.b) new a(this));
    }

    public final Collection<af> eal() {
        e dZR = dZR();
        if (dZR == null) {
            return v.AUP;
        }
        Collection<a.i.b.a.c.b.d> dYb = dZR.dYb();
        j.o(dYb, "classDescriptor.constructors");
        Collection arrayList = new ArrayList();
        for (a.i.b.a.c.b.d dVar : dYb) {
            Object obj;
            a.i.b.a.c.b.c.ag.a aVar = ag.Bjq;
            i eak = eak();
            aq aqVar = this;
            j.o(dVar, "it");
            j.p(eak, "storageManager");
            j.p(aqVar, "typeAliasDescriptor");
            j.p(dVar, "constructor");
            au a = a.i.b.a.c.b.c.ag.a.a(aqVar);
            if (a == null) {
                obj = null;
            } else {
                a.i.b.a.c.b.d a2 = dVar.a(a);
                if (a2 == null) {
                    obj = null;
                } else {
                    a.i.b.a.c.b.a.g dYn = dVar.dYn();
                    a.i.b.a.c.b.b.a dYZ = dVar.dYZ();
                    j.o(dYZ, "constructor.kind");
                    am dYo = aqVar.dYo();
                    j.o(dYo, "typeAliasDescriptor.source");
                    ag agVar = new ag(eak, aqVar, a2, null, dYn, dYZ, dYo, (byte) 0);
                    List a3 = p.a((t) agVar, dVar.dYV(), a, false, false, null);
                    if (a3 == null) {
                        obj = null;
                    } else {
                        ak a4;
                        j.o(a3, "FunctionDescriptorImpl.g…         ) ?: return null");
                        ad ak = a.i.b.a.c.l.t.ak(a2.dYT().ekn());
                        ad dZf = aqVar.dZf();
                        j.o(dZf, "typeAliasDescriptor.defaultType");
                        ad b = ag.b(ak, dZf);
                        ak dYR = dVar.dYR();
                        if (dYR != null) {
                            a.i.b.a.c.b.a aVar2 = agVar;
                            j.o(dYR, "it");
                            w b2 = a.b(dYR.dZS(), ba.INVARIANT);
                            a.i.b.a.c.b.a.g.a aVar3 = a.i.b.a.c.b.a.g.BfJ;
                            a4 = c.a(aVar2, b2, a.i.b.a.c.b.a.g.a.eai());
                        } else {
                            a4 = null;
                        }
                        agVar.a(a4, null, aqVar.dYq(), a3, b, a.i.b.a.c.b.w.FINAL, aqVar.dYf());
                        af obj2 = agVar;
                    }
                }
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return (List) arrayList;
    }

    public final List<ar> dYq() {
        List list = this.Bhf;
        if (list == null) {
            j.avw("declaredTypeParametersImpl");
        }
        return list;
    }

    public final a.i.b.a.c.b.w dYd() {
        return a.i.b.a.c.b.w.FINAL;
    }

    public final az dYf() {
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

    public final an dXY() {
        return this.Bhg;
    }

    public String toString() {
        return "typealias " + this.BgZ.name;
    }

    private aq eam() {
        o ean = super.dZd();
        if (ean != null) {
            return (aq) ean;
        }
        throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
}
