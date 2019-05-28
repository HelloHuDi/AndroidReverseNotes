package a.i.b.a.c.b;

import a.a.ab;
import a.a.ak;
import a.a.t;
import a.a.v;
import a.a.x;
import a.f.b.j;
import a.f.b.k;
import a.h.h;
import a.i.b.a.c.b.c.ah;
import a.i.b.a.c.b.c.g;
import a.i.b.a.c.b.c.m;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class aa {
    final i Baf;
    final y BcH;
    final a.i.b.a.c.k.c<a.i.b.a.c.f.b, ab> BeH = this.Baf.f(new d(this));
    private final a.i.b.a.c.k.c<a, e> BeI = this.Baf.f(new c(this));

    static final class d extends k implements a.f.a.b<a.i.b.a.c.f.b, m> {
        final /* synthetic */ aa BeN;

        d(aa aaVar) {
            this.BeN = aaVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119289);
            a.i.b.a.c.f.b bVar = (a.i.b.a.c.f.b) obj;
            j.p(bVar, "fqName");
            m mVar = new m(this.BeN.BcH, bVar);
            AppMethodBeat.o(119289);
            return mVar;
        }
    }

    static final class a {
        final a.i.b.a.c.f.a BcB;
        final List<Integer> BeJ;

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.BeJ, r4.BeJ) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(119283);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (j.j(this.BcB, aVar.BcB)) {
                    }
                }
                AppMethodBeat.o(119283);
                return false;
            }
            AppMethodBeat.o(119283);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(119282);
            a.i.b.a.c.f.a aVar = this.BcB;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            List list = this.BeJ;
            if (list != null) {
                i = list.hashCode();
            }
            hashCode += i;
            AppMethodBeat.o(119282);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(119281);
            String str = "ClassRequest(classId=" + this.BcB + ", typeParametersCount=" + this.BeJ + ")";
            AppMethodBeat.o(119281);
            return str;
        }

        public a(a.i.b.a.c.f.a aVar, List<Integer> list) {
            j.p(aVar, "classId");
            j.p(list, "typeParametersCount");
            AppMethodBeat.i(119280);
            this.BcB = aVar;
            this.BeJ = list;
            AppMethodBeat.o(119280);
        }
    }

    public static final class b extends g {
        private final List<ar> BeK;
        private final e BeL;
        private final boolean BeM;

        public b(i iVar, l lVar, f fVar, boolean z, int i) {
            j.p(iVar, "storageManager");
            j.p(lVar, "container");
            j.p(fVar, "name");
            super(iVar, lVar, fVar, am.BeR);
            AppMethodBeat.i(119287);
            this.BeM = z;
            Iterable il = h.il(0, i);
            Collection arrayList = new ArrayList(a.a.m.d(il));
            Iterator it = il.iterator();
            while (it.hasNext()) {
                int nextInt = ((ab) it).nextInt();
                l lVar2 = this;
                a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                arrayList.add(ah.a(lVar2, a.i.b.a.c.b.a.g.a.eai(), ba.INVARIANT, f.avX("T".concat(String.valueOf(nextInt))), nextInt));
            }
            this.BeK = (List) arrayList;
            this.BeL = new e(this, this.BeK, ak.setOf(a.i.b.a.c.i.c.a.F(this).dZD().dXM()), iVar);
            AppMethodBeat.o(119287);
        }

        public final f dYc() {
            return f.CLASS;
        }

        public final w dYd() {
            return w.FINAL;
        }

        public final az dYf() {
            AppMethodBeat.i(119284);
            az azVar = ay.Bfa;
            j.o(azVar, "Visibilities.PUBLIC");
            AppMethodBeat.o(119284);
            return azVar;
        }

        public final List<ar> dYq() {
            return this.BeK;
        }

        public final boolean dYh() {
            return this.BeM;
        }

        public final boolean dYg() {
            return false;
        }

        public final boolean dYi() {
            return false;
        }

        public final boolean dYj() {
            return false;
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

        public final a.i.b.a.c.b.a.g dYn() {
            AppMethodBeat.i(119285);
            a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
            a.i.b.a.c.b.a.g eai = a.i.b.a.c.b.a.g.a.eai();
            AppMethodBeat.o(119285);
            return eai;
        }

        public final d dYe() {
            return null;
        }

        public final e dYa() {
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(119286);
            String str = "class " + this.BgZ + " (not found)";
            AppMethodBeat.o(119286);
            return str;
        }

        public final /* bridge */ /* synthetic */ an dXY() {
            return this.BeL;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXZ() {
            return a.i.b.a.c.i.e.h.b.BGh;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXX() {
            return a.i.b.a.c.i.e.h.b.BGh;
        }

        public final Collection<d> dYb() {
            return x.AUR;
        }

        public final Collection<e> dYp() {
            return v.AUP;
        }
    }

    static final class c extends k implements a.f.a.b<a, b> {
        final /* synthetic */ aa BeN;

        c(aa aaVar) {
            this.BeN = aaVar;
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x006c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119288);
            a aVar = (a) obj;
            j.p(aVar, "<name for destructuring parameter 0>");
            a.i.b.a.c.f.a aVar2 = aVar.BcB;
            List list = aVar.BeJ;
            if (aVar2.ByO) {
                Throwable unsupportedOperationException = new UnsupportedOperationException("Unresolved local class: ".concat(String.valueOf(aVar2)));
                AppMethodBeat.o(119288);
                throw unsupportedOperationException;
            }
            g gVar;
            boolean ehD;
            i iVar;
            l lVar;
            f ehK;
            Integer num;
            int intValue;
            b bVar;
            a.i.b.a.c.f.a ehC = aVar2.ehC();
            if (ehC != null) {
                aa aaVar = this.BeN;
                j.o(ehC, "outerClassId");
                e a = aaVar.a(ehC, t.j(list));
                if (a != null) {
                    gVar = a;
                    ehD = aVar2.ehD();
                    iVar = this.BeN.Baf;
                    lVar = gVar;
                    ehK = aVar2.ByN.ByQ.ehK();
                    j.o(ehK, "classId.shortClassName");
                    num = (Integer) t.fK(list);
                    if (num == null) {
                        intValue = num.intValue();
                    } else {
                        intValue = 0;
                    }
                    bVar = new b(iVar, lVar, ehK, ehD, intValue);
                    AppMethodBeat.o(119288);
                    return bVar;
                }
            }
            a.i.b.a.c.k.c cVar = this.BeN.BeH;
            a.i.b.a.c.f.b bVar2 = aVar2.BcW;
            j.o(bVar2, "classId.packageFqName");
            gVar = (g) cVar.am(bVar2);
            ehD = aVar2.ehD();
            iVar = this.BeN.Baf;
            lVar = gVar;
            ehK = aVar2.ByN.ByQ.ehK();
            j.o(ehK, "classId.shortClassName");
            num = (Integer) t.fK(list);
            if (num == null) {
            }
            bVar = new b(iVar, lVar, ehK, ehD, intValue);
            AppMethodBeat.o(119288);
            return bVar;
        }
    }

    public aa(i iVar, y yVar) {
        j.p(iVar, "storageManager");
        j.p(yVar, "module");
        AppMethodBeat.i(119291);
        this.Baf = iVar;
        this.BcH = yVar;
        AppMethodBeat.o(119291);
    }

    public final e a(a.i.b.a.c.f.a aVar, List<Integer> list) {
        AppMethodBeat.i(119290);
        j.p(aVar, "classId");
        j.p(list, "typeParametersCount");
        e eVar = (e) this.BeI.am(new a(aVar, list));
        AppMethodBeat.o(119290);
        return eVar;
    }
}
