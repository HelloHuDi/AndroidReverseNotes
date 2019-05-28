package a.i.b.a.c.d.a.b;

import a.i.b.a.c.b.a.a;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.c.aa;
import a.i.b.a.c.b.c.ab;
import a.i.b.a.c.b.c.z;
import a.i.b.a.c.b.j;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.w;
import a.i.b.a.c.d.a.f.s;
import a.i.b.a.c.i.c;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class f extends z implements b {
    private final boolean BmJ;
    private final o<a<?>, ?> BmK;

    private f(l lVar, g gVar, w wVar, az azVar, boolean z, a.i.b.a.c.f.f fVar, am amVar, ah ahVar, b.a aVar, boolean z2, o<a<?>, ?> oVar) {
        super(lVar, ahVar, gVar, wVar, azVar, z, fVar, aVar, amVar, false, false, false, false, false, false);
        this.BmJ = z2;
        this.BmK = oVar;
    }

    public static f a(l lVar, g gVar, w wVar, az azVar, boolean z, a.i.b.a.c.f.f fVar, am amVar, boolean z2) {
        AppMethodBeat.i(119806);
        f fVar2 = new f(lVar, gVar, wVar, azVar, z, fVar, amVar, null, b.a.DECLARATION, z2, null);
        AppMethodBeat.o(119806);
        return fVar2;
    }

    public final z a(l lVar, w wVar, az azVar, ah ahVar, b.a aVar, a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(119807);
        f fVar2 = new f(lVar, dYn(), wVar, azVar, this.BjC, fVar, am.BeR, ahVar, aVar, this.BmJ, this.BmK);
        AppMethodBeat.o(119807);
        return fVar2;
    }

    public final boolean dYW() {
        return false;
    }

    public final b a(a.i.b.a.c.l.w wVar, List<j> list, a.i.b.a.c.l.w wVar2, o<a<?>, ?> oVar) {
        ah ahVar;
        aa aaVar;
        ak akVar;
        AppMethodBeat.i(119808);
        l dXW = dXW();
        g dYn = dYn();
        w wVar3 = this.Bhv;
        az azVar = this.BhQ;
        boolean z = this.BjC;
        a.i.b.a.c.f.f fVar = this.BgZ;
        am dYo = dYo();
        if (dZL() == this) {
            ahVar = null;
        } else {
            ahVar = dZL();
        }
        f fVar2 = new f(dXW, dYn, wVar3, azVar, z, fVar, dYo, ahVar, this.Bif, this.BmJ, oVar);
        aa aaVar2 = this.Bjb;
        if (aaVar2 != null) {
            aa aaVar3 = new aa(fVar2, aaVar2.dYn(), aaVar2.Bhv, aaVar2.BhQ, aaVar2.isDefault, aaVar2.Bhu, aaVar2.BhT, this.Bif, aaVar2, aaVar2.dYo());
            aaVar3.Big = aaVar2.Big;
            aaVar3.K(wVar2);
            aaVar = aaVar3;
        } else {
            aaVar = null;
        }
        aj ajVar = null;
        aj ajVar2 = this.Bjc;
        if (ajVar2 != null) {
            ajVar = new ab(fVar2, ajVar2.dYn(), ajVar2.dYd(), ajVar2.dYf(), ajVar2.isDefault(), ajVar2.dYm(), ajVar2.dYj(), this.Bif, ajVar2, ajVar2.dYo());
            ajVar.Big = ajVar.Big;
            ajVar.a((au) ajVar2.dYV().get(0));
        }
        fVar2.a(aaVar, ajVar, this.Bje, this.Bjf);
        fVar2.Bjd = this.Bjd;
        if (this.BjD != null) {
            fVar2.a(this.BjD);
        }
        fVar2.BiW = dYX();
        if (wVar == null) {
            akVar = null;
        } else {
            g.a aVar = g.BfJ;
            akVar = c.a((a.i.b.a.c.b.a) this, wVar, g.a.eai());
        }
        fVar2.a(wVar2, this.BeK, this.BhP, akVar);
        AppMethodBeat.o(119808);
        return fVar2;
    }

    public final boolean eab() {
        AppMethodBeat.i(119809);
        a.i.b.a.c.l.w dZS = dZS();
        if (this.BmJ && j.H(dZS) && (!s.U(dZS) || a.i.b.a.c.a.g.E(dZS))) {
            AppMethodBeat.o(119809);
            return true;
        }
        AppMethodBeat.o(119809);
        return false;
    }

    public final <V> V a(a<V> aVar) {
        AppMethodBeat.i(119810);
        if (this.BmK == null || !((a) this.BmK.first).equals(aVar)) {
            AppMethodBeat.o(119810);
            return null;
        }
        Object obj = this.BmK.second;
        AppMethodBeat.o(119810);
        return obj;
    }
}
