package a.i.b.a.c.l.a;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.l.a.o.c;
import a.i.b.a.c.l.a.o.c.a;
import a.i.b.a.c.l.a.o.c.d;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ag;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;

public final class l {
    public static final l BKB = new l();

    static {
        AppMethodBeat.i(122758);
        AppMethodBeat.o(122758);
    }

    private l() {
    }

    public static boolean d(az azVar) {
        AppMethodBeat.i(122755);
        j.p(azVar, "type");
        boolean a = a(new o(false, (byte) 0), t.ak(azVar), a.BKT);
        AppMethodBeat.o(122755);
        return a;
    }

    private static boolean a(o oVar, ad adVar, c cVar) {
        boolean z;
        AppMethodBeat.i(122756);
        if ((!j.c(adVar) || adVar.eci()) && !ag.ap(adVar)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(122756);
            return true;
        }
        oVar.initialize();
        ArrayDeque arrayDeque = oVar.BKG;
        if (arrayDeque == null) {
            j.dWJ();
        }
        Set set = oVar.BKH;
        if (set == null) {
            j.dWJ();
        }
        arrayDeque.push(adVar);
        while (true) {
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                oVar.clear();
                AppMethodBeat.o(122756);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + adVar + ". Supertypes = " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.o(122756);
                throw illegalStateException;
            } else {
                ad adVar2 = (ad) arrayDeque.pop();
                j.o(adVar2, "current");
                if (set.add(adVar2)) {
                    c cVar2;
                    if (adVar2.eci()) {
                        cVar2 = c.c.BKU;
                    } else {
                        cVar2 = cVar;
                    }
                    c cVar3 = (j.j(cVar2, c.c.BKU) ^ 1) != 0 ? cVar2 : null;
                    if (cVar3 != null) {
                        for (w wVar : adVar2.ejw().eap()) {
                            j.o(wVar, "supertype");
                            ad aJ = cVar3.aJ(wVar);
                            if ((!j.c(aJ) || aJ.eci()) && !ag.ap(aJ)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                oVar.clear();
                                AppMethodBeat.o(122756);
                                return true;
                            }
                            arrayDeque.add(aJ);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private static boolean d(o oVar, ad adVar, an anVar) {
        boolean z;
        AppMethodBeat.i(122757);
        if (adVar.eci() || !j.j(adVar.ejw(), anVar)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(122757);
            return true;
        }
        oVar.initialize();
        ArrayDeque arrayDeque = oVar.BKG;
        if (arrayDeque == null) {
            j.dWJ();
        }
        Set set = oVar.BKH;
        if (set == null) {
            j.dWJ();
        }
        arrayDeque.push(adVar);
        while (true) {
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                oVar.clear();
                AppMethodBeat.o(122757);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + adVar + ". Supertypes = " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.o(122757);
                throw illegalStateException;
            } else {
                ad adVar2 = (ad) arrayDeque.pop();
                j.o(adVar2, "current");
                if (set.add(adVar2)) {
                    c cVar = adVar2.eci() ? c.c.BKU : a.BKT;
                    if ((j.j(cVar, c.c.BKU) ^ 1) == 0) {
                        cVar = null;
                    }
                    if (cVar != null) {
                        for (w wVar : adVar2.ejw().eap()) {
                            j.o(wVar, "supertype");
                            ad aJ = cVar.aJ(wVar);
                            if (aJ.eci() || !j.j(aJ.ejw(), anVar)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                oVar.clear();
                                AppMethodBeat.o(122757);
                                return true;
                            }
                            arrayDeque.add(aJ);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public static boolean c(o oVar, ad adVar, ad adVar2) {
        AppMethodBeat.i(122754);
        j.p(oVar, "context");
        j.p(adVar, "subType");
        j.p(adVar2, "superType");
        boolean z = j.e(adVar) || j.d(adVar) || oVar.e(adVar);
        Throwable assertionError;
        if (!aa.AUz || z) {
            z = j.d(adVar2) || oVar.e(adVar2);
            if (aa.AUz && !z) {
                assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(adVar2)));
                AppMethodBeat.o(122754);
                throw assertionError;
            } else if (adVar2.eci()) {
                AppMethodBeat.o(122754);
                return true;
            } else if (ag.ap(adVar)) {
                AppMethodBeat.o(122754);
                return true;
            } else if (a(oVar, adVar, a.BKT)) {
                AppMethodBeat.o(122754);
                return true;
            } else if (ag.ap(adVar2)) {
                AppMethodBeat.o(122754);
                return false;
            } else if (a(oVar, adVar2, d.BKV)) {
                AppMethodBeat.o(122754);
                return false;
            } else if (j.c(adVar)) {
                AppMethodBeat.o(122754);
                return false;
            } else {
                boolean d = d(oVar, adVar, adVar2.ejw());
                AppMethodBeat.o(122754);
                return d;
            }
        }
        assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(adVar2)));
        AppMethodBeat.o(122754);
        throw assertionError;
    }
}
