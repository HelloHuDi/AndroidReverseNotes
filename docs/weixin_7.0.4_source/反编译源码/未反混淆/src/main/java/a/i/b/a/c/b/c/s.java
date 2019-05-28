package a.i.b.a.c.b.c;

import a.a.t;
import a.f.a.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.b.n;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.k;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class s implements e {
    private an Bhx;
    private final e BiF;
    private final au BiG;
    private au BiH;
    private List<ar> BiI;
    private List<ar> BiJ;

    public final /* synthetic */ l dZd() {
        AppMethodBeat.i(119504);
        e dZm = dZm();
        AppMethodBeat.o(119504);
        return dZm;
    }

    public final /* synthetic */ h dZe() {
        AppMethodBeat.i(119503);
        e dZm = dZm();
        AppMethodBeat.o(119503);
        return dZm;
    }

    public s(e eVar, au auVar) {
        this.BiF = eVar;
        this.BiG = auVar;
    }

    private au eay() {
        AppMethodBeat.i(119475);
        if (this.BiH == null) {
            if (this.BiG.Bik.isEmpty()) {
                this.BiH = this.BiG;
            } else {
                List parameters = this.BiF.dXY().getParameters();
                this.BiI = new ArrayList(parameters.size());
                this.BiH = k.a(parameters, this.BiG.Bik, this, this.BiI);
                this.BiJ = t.b((Iterable) this.BiI, (b) new b<ar, Boolean>() {
                    public final /* synthetic */ Object am(Object obj) {
                        boolean z;
                        AppMethodBeat.i(119474);
                        if (((ar) obj).dZb()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        Boolean valueOf = Boolean.valueOf(z);
                        AppMethodBeat.o(119474);
                        return valueOf;
                    }
                });
            }
        }
        au auVar = this.BiH;
        AppMethodBeat.o(119475);
        return auVar;
    }

    public final an dXY() {
        AppMethodBeat.i(119476);
        an dXY = this.BiF.dXY();
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.o(119476);
            return dXY;
        }
        if (this.Bhx == null) {
            au eay = eay();
            Collection<w> eap = dXY.eap();
            ArrayList arrayList = new ArrayList(eap.size());
            for (w c : eap) {
                arrayList.add(eay.c(c, ba.INVARIANT));
            }
            this.Bhx = new a.i.b.a.c.l.e(this, this.BiI, arrayList, a.i.b.a.c.k.b.BIH);
        }
        dXY = this.Bhx;
        AppMethodBeat.o(119476);
        return dXY;
    }

    public final a.i.b.a.c.i.e.h a(as asVar) {
        AppMethodBeat.i(119477);
        a.i.b.a.c.i.e.h a = this.BiF.a(asVar);
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.o(119477);
            return a;
        }
        a.i.b.a.c.i.e.l lVar = new a.i.b.a.c.i.e.l(a, eay());
        AppMethodBeat.o(119477);
        return lVar;
    }

    public final a.i.b.a.c.i.e.h dXZ() {
        AppMethodBeat.i(119478);
        a.i.b.a.c.i.e.h dXZ = this.BiF.dXZ();
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.o(119478);
            return dXZ;
        }
        a.i.b.a.c.i.e.l lVar = new a.i.b.a.c.i.e.l(dXZ, eay());
        AppMethodBeat.o(119478);
        return lVar;
    }

    public final a.i.b.a.c.i.e.h dXX() {
        AppMethodBeat.i(119479);
        a.i.b.a.c.i.e.h dXX = this.BiF.dXX();
        AppMethodBeat.o(119479);
        return dXX;
    }

    public final ad dZf() {
        AppMethodBeat.i(119480);
        ad a = x.a(dYn(), this, av.ga(dXY().getParameters()));
        AppMethodBeat.o(119480);
        return a;
    }

    public final ak dZl() {
        AppMethodBeat.i(119481);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(119481);
        throw unsupportedOperationException;
    }

    public final Collection<d> dYb() {
        AppMethodBeat.i(119482);
        Collection<d> dYb = this.BiF.dYb();
        ArrayList arrayList = new ArrayList(dYb.size());
        for (d dVar : dYb) {
            arrayList.add(dVar.a(this, dVar.dYd(), dVar.dYf(), dVar.dYZ(), false).a(eay()));
        }
        AppMethodBeat.o(119482);
        return arrayList;
    }

    public final g dYn() {
        AppMethodBeat.i(119483);
        g dYn = this.BiF.dYn();
        AppMethodBeat.o(119483);
        return dYn;
    }

    public final f dZg() {
        AppMethodBeat.i(119484);
        f dZg = this.BiF.dZg();
        AppMethodBeat.o(119484);
        return dZg;
    }

    public final e dZm() {
        AppMethodBeat.i(119485);
        e dZm = this.BiF.dZm();
        AppMethodBeat.o(119485);
        return dZm;
    }

    public final l dXW() {
        AppMethodBeat.i(119486);
        l dXW = this.BiF.dXW();
        AppMethodBeat.o(119486);
        return dXW;
    }

    public final e dYa() {
        AppMethodBeat.i(119487);
        e dYa = this.BiF.dYa();
        AppMethodBeat.o(119487);
        return dYa;
    }

    public final a.i.b.a.c.b.f dYc() {
        AppMethodBeat.i(119488);
        a.i.b.a.c.b.f dYc = this.BiF.dYc();
        AppMethodBeat.o(119488);
        return dYc;
    }

    public final a.i.b.a.c.b.w dYd() {
        AppMethodBeat.i(119489);
        a.i.b.a.c.b.w dYd = this.BiF.dYd();
        AppMethodBeat.o(119489);
        return dYd;
    }

    public final az dYf() {
        AppMethodBeat.i(119490);
        az dYf = this.BiF.dYf();
        AppMethodBeat.o(119490);
        return dYf;
    }

    public final boolean dYh() {
        AppMethodBeat.i(119491);
        boolean dYh = this.BiF.dYh();
        AppMethodBeat.o(119491);
        return dYh;
    }

    public final boolean dYi() {
        AppMethodBeat.i(119492);
        boolean dYi = this.BiF.dYi();
        AppMethodBeat.o(119492);
        return dYi;
    }

    public final boolean dYj() {
        AppMethodBeat.i(119493);
        boolean dYj = this.BiF.dYj();
        AppMethodBeat.o(119493);
        return dYj;
    }

    public final boolean dYm() {
        AppMethodBeat.i(119494);
        boolean dYm = this.BiF.dYm();
        AppMethodBeat.o(119494);
        return dYm;
    }

    public final boolean dYg() {
        AppMethodBeat.i(119495);
        boolean dYg = this.BiF.dYg();
        AppMethodBeat.o(119495);
        return dYg;
    }

    public final boolean dYk() {
        AppMethodBeat.i(119496);
        boolean dYk = this.BiF.dYk();
        AppMethodBeat.o(119496);
        return dYk;
    }

    public final boolean dYl() {
        AppMethodBeat.i(119497);
        boolean dYl = this.BiF.dYl();
        AppMethodBeat.o(119497);
        return dYl;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119498);
        Object a = nVar.a((e) this, (Object) d);
        AppMethodBeat.o(119498);
        return a;
    }

    public final a.i.b.a.c.i.e.h dZk() {
        AppMethodBeat.i(119499);
        a.i.b.a.c.i.e.h dZk = this.BiF.dZk();
        AppMethodBeat.o(119499);
        return dZk;
    }

    public final d dYe() {
        AppMethodBeat.i(119500);
        d dYe = this.BiF.dYe();
        AppMethodBeat.o(119500);
        return dYe;
    }

    public final am dYo() {
        return am.BeR;
    }

    public final List<ar> dYq() {
        AppMethodBeat.i(119501);
        eay();
        List list = this.BiJ;
        AppMethodBeat.o(119501);
        return list;
    }

    public final Collection<e> dYp() {
        AppMethodBeat.i(119502);
        Collection dYp = this.BiF.dYp();
        AppMethodBeat.o(119502);
        return dYp;
    }

    public final /* synthetic */ m f(au auVar) {
        AppMethodBeat.i(119505);
        if (auVar.Bik.isEmpty()) {
            AppMethodBeat.o(119505);
            return this;
        }
        s sVar = new s(this, au.b(auVar.Bik, eay().Bik));
        AppMethodBeat.o(119505);
        return sVar;
    }
}
