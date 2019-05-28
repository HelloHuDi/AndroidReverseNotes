package a.i.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.l.a.k;
import a.i.b.a.c.l.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends i implements f {
    public static final a BJi = new a();
    final ad BJh;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static g a(az azVar) {
            AppMethodBeat.i(122499);
            j.p(azVar, "type");
            if (azVar instanceof g) {
                g gVar = (g) azVar;
                AppMethodBeat.o(122499);
                return gVar;
            } else if (b(azVar)) {
                if (azVar instanceof q) {
                    boolean j = j.j(((q) azVar).BJx.ejw(), ((q) azVar).BJy.ejw());
                    if (aa.AUz && !j) {
                        Throwable assertionError = new AssertionError("DefinitelyNotNullType for flexible type (" + azVar + ") can be created only from type variable with the same constructor for bounds");
                        AppMethodBeat.o(122499);
                        throw assertionError;
                    }
                }
                g gVar2 = new g(t.ak(azVar), (byte) 0);
                AppMethodBeat.o(122499);
                return gVar2;
            } else {
                AppMethodBeat.o(122499);
                return null;
            }
        }

        private static boolean b(az azVar) {
            AppMethodBeat.i(122500);
            j.p(azVar, "type");
            if (a.i.b.a.c.l.c.a.h(azVar)) {
                l lVar = l.BKB;
                if (!l.d(azVar)) {
                    AppMethodBeat.o(122500);
                    return true;
                }
            }
            AppMethodBeat.o(122500);
            return false;
        }
    }

    static {
        AppMethodBeat.i(122509);
        AppMethodBeat.o(122509);
    }

    private g(ad adVar) {
        this.BJh = adVar;
    }

    public /* synthetic */ g(ad adVar, byte b) {
        this(adVar);
    }

    public final /* synthetic */ az b(a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(122504);
        az g = g(gVar);
        AppMethodBeat.o(122504);
        return g;
    }

    public final /* synthetic */ ad d(a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(122505);
        ad g = g(gVar);
        AppMethodBeat.o(122505);
        return g;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122507);
        az rL = rL(z);
        AppMethodBeat.o(122507);
        return rL;
    }

    /* Access modifiers changed, original: protected|final */
    public final ad eby() {
        return this.BJh;
    }

    public final boolean eci() {
        return false;
    }

    public final w R(w wVar) {
        az azVar;
        AppMethodBeat.i(122502);
        j.p(wVar, "replacement");
        az ekn = wVar.ekn();
        j.p(ekn, "receiver$0");
        g a = a.a(ekn);
        if (a != null) {
            azVar = a;
        } else {
            azVar = ekn.rK(false);
        }
        w wVar2 = azVar;
        AppMethodBeat.o(122502);
        return wVar2;
    }

    private g g(a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(122503);
        j.p(gVar, "newAnnotations");
        g gVar2 = new g(this.BJh.d(gVar));
        AppMethodBeat.o(122503);
        return gVar2;
    }

    public final ad rL(boolean z) {
        AppMethodBeat.i(122506);
        ad rL;
        if (z) {
            rL = this.BJh.rL(z);
            AppMethodBeat.o(122506);
            return rL;
        }
        rL = this;
        AppMethodBeat.o(122506);
        return rL;
    }

    public final String toString() {
        AppMethodBeat.i(122508);
        String str = this.BJh + "!!";
        AppMethodBeat.o(122508);
        return str;
    }

    public final boolean ech() {
        AppMethodBeat.i(122501);
        if ((this.BJh.ejw() instanceof k) || (this.BJh.ejw().dYs() instanceof ar)) {
            AppMethodBeat.o(122501);
            return true;
        }
        AppMethodBeat.o(122501);
        return false;
    }
}
