package a.i.b.a.c.l.a;

import a.f.b.j;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ag;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public static final m BKC = new m();

    static {
        AppMethodBeat.i(122761);
        AppMethodBeat.o(122761);
    }

    private m() {
    }

    public final boolean a(az azVar, az azVar2) {
        AppMethodBeat.i(122759);
        j.p(azVar, "a");
        j.p(azVar2, "b");
        if (azVar == azVar2) {
            AppMethodBeat.o(122759);
            return true;
        } else if ((azVar instanceof ad) && (azVar2 instanceof ad)) {
            boolean c = c((ad) azVar, (ad) azVar2);
            AppMethodBeat.o(122759);
            return c;
        } else if (!(azVar instanceof q) || !(azVar2 instanceof q)) {
            AppMethodBeat.o(122759);
            return false;
        } else if (c(((q) azVar).BJx, ((q) azVar2).BJx) && c(((q) azVar).BJy, ((q) azVar2).BJy)) {
            AppMethodBeat.o(122759);
            return true;
        } else {
            AppMethodBeat.o(122759);
            return false;
        }
    }

    public final boolean c(ad adVar, ad adVar2) {
        AppMethodBeat.i(122760);
        j.p(adVar, "a");
        j.p(adVar2, "b");
        if (adVar.eci() != adVar2.eci() || ag.ap(adVar) != ag.ap(adVar2) || (j.j(adVar.ejw(), adVar2.ejw()) ^ 1) != 0 || adVar.ejt().size() != adVar2.ejt().size()) {
            AppMethodBeat.o(122760);
            return false;
        } else if (adVar.ejt() == adVar2.ejt()) {
            AppMethodBeat.o(122760);
            return true;
        } else {
            int size = adVar.ejt().size();
            for (int i = 0; i < size; i++) {
                ap apVar = (ap) adVar.ejt().get(i);
                ap apVar2 = (ap) adVar2.ejt().get(i);
                if (apVar.ekp() != apVar2.ekp()) {
                    AppMethodBeat.o(122760);
                    return false;
                }
                if (!apVar.ekp()) {
                    if (apVar.ekq() != apVar2.ekq()) {
                        AppMethodBeat.o(122760);
                        return false;
                    } else if (!a(apVar.dZS().ekn(), apVar2.dZS().ekn())) {
                        AppMethodBeat.o(122760);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(122760);
            return true;
        }
    }
}
