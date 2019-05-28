package a.i.b.a.c.d.a.c;

import a.a.t;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.k.d;
import a.j.f;
import a.j.h;
import a.j.l;
import a.j.n;
import a.j.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class e implements g {
    private final d<a.i.b.a.c.d.a.e.a, c> Bnm = this.Bnn.Bnv.Baf.g(new a(this));
    private final h Bnn;
    private final a.i.b.a.c.d.a.e.d Bno;

    static final class a extends k implements b<a.i.b.a.c.d.a.e.a, c> {
        final /* synthetic */ e Bnp;

        a(e eVar) {
            this.Bnp = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119828);
            a.i.b.a.c.d.a.e.a aVar = (a.i.b.a.c.d.a.e.a) obj;
            j.p(aVar, "annotation");
            a.i.b.a.c.d.a.a.c cVar = a.i.b.a.c.d.a.a.c.Bmf;
            c a = a.i.b.a.c.d.a.a.c.a(aVar, this.Bnp.Bnn);
            AppMethodBeat.o(119828);
            return a;
        }
    }

    public e(h hVar, a.i.b.a.c.d.a.e.d dVar) {
        j.p(hVar, "c");
        j.p(dVar, "annotationOwner");
        AppMethodBeat.i(119832);
        this.Bnn = hVar;
        this.Bno = dVar;
        AppMethodBeat.o(119832);
    }

    public final boolean j(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119833);
        j.p(bVar, "fqName");
        boolean b = g.b.b(this, bVar);
        AppMethodBeat.o(119833);
        return b;
    }

    /* JADX WARNING: Missing block: B:3:0x001e, code skipped:
            if (r0 == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c i(a.i.b.a.c.f.b bVar) {
        c cVar;
        AppMethodBeat.i(119829);
        j.p(bVar, "fqName");
        a.i.b.a.c.d.a.e.a m = this.Bno.m(bVar);
        if (m != null) {
            cVar = (c) this.Bnm.am(m);
        }
        a.i.b.a.c.d.a.a.c cVar2 = a.i.b.a.c.d.a.a.c.Bmf;
        cVar = a.i.b.a.c.d.a.a.c.a(bVar, this.Bno, this.Bnn);
        AppMethodBeat.o(119829);
        return cVar;
    }

    public final Iterator<c> iterator() {
        AppMethodBeat.i(119830);
        h d = n.d(t.t(this.Bno.ebC()), this.Bnm);
        a.i.b.a.c.d.a.a.c cVar = a.i.b.a.c.d.a.a.c.Bmf;
        a.i.b.a.c.f.b bVar = a.i.b.a.c.a.g.Bag.BaK;
        j.o(bVar, "KotlinBuiltIns.FQ_NAMES.deprecated");
        c a = a.i.b.a.c.d.a.a.c.a(bVar, this.Bno, this.Bnn);
        j.p(d, "receiver$0");
        h[] hVarArr = new h[2];
        hVarArr[0] = d;
        hVarArr[1] = l.Z(a);
        h Z = l.Z(hVarArr);
        j.p(Z, "receiver$0");
        b bVar2 = a.j.l.a.BOG;
        if (Z instanceof p) {
            p pVar = (p) Z;
            j.p(bVar2, "iterator");
            d = new f(pVar.BOr, pVar.BOz, bVar2);
        } else {
            d = new f(Z, l.b.BOH, bVar2);
        }
        Iterator it = n.b(d).iterator();
        AppMethodBeat.o(119830);
        return it;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(119831);
        if (this.Bno.ebC().isEmpty()) {
            AppMethodBeat.o(119831);
            return true;
        }
        AppMethodBeat.o(119831);
        return false;
    }
}
