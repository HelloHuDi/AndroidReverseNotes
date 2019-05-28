package a.i.b.a.c.d.a.b;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.ad;
import a.i.b.a.c.b.c.p;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.w;
import a.i.b.a.c.m.b;
import a.i.b.a.c.m.c;
import a.i.b.a.c.m.d;
import a.i.b.a.c.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public class e extends ad implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
    public static final a.i.b.a.c.b.a.a<au> BmA = new a.i.b.a.c.b.a.a<au>() {
    };
    private a BmB = null;

    enum a {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean BmG;
        public final boolean BmH;

        static {
            AppMethodBeat.o(119797);
        }

        private a(boolean z, boolean z2) {
            this.BmG = z;
            this.BmH = z2;
        }

        public static a ap(boolean z, boolean z2) {
            return z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    static {
        AppMethodBeat.i(119805);
        AppMethodBeat.o(119805);
    }

    private e(l lVar, al alVar, g gVar, f fVar, a.i.b.a.c.b.b.a aVar, am amVar) {
        super(lVar, alVar, gVar, fVar, aVar, amVar);
    }

    public static e a(l lVar, g gVar, f fVar, am amVar) {
        AppMethodBeat.i(119798);
        e eVar = new e(lVar, null, gVar, fVar, a.i.b.a.c.b.b.a.DECLARATION, amVar);
        AppMethodBeat.o(119798);
        return eVar;
    }

    public final ad a(ak akVar, ak akVar2, List<? extends ar> list, List<au> list2, w wVar, a.i.b.a.c.b.w wVar2, az azVar, Map<? extends a.i.b.a.c.b.a.a<?>, ?> map) {
        c bVar;
        AppMethodBeat.i(119799);
        ad a = super.a(akVar, akVar2, list, list2, wVar, wVar2, azVar, map);
        i iVar = i.BLI;
        j.p(a, "functionDescriptor");
        for (d dVar : iVar.ekt()) {
            Object obj;
            j.p(a, "functionDescriptor");
            if (dVar.BgZ == null || (j.j(a.dZg(), dVar.BgZ) ^ 1) == 0) {
                if (dVar.BLv != null) {
                    String str = a.dZg().name;
                    j.o(str, "functionDescriptor.name.asString()");
                    if (!dVar.BLv.aq(str)) {
                        obj = null;
                        continue;
                    }
                }
                if (dVar.BLw == null || dVar.BLw.contains(a.dZg())) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                j.p(a, "functionDescriptor");
                for (b i : dVar.BLy) {
                    String i2 = i.i(a);
                    if (i2 != null) {
                        bVar = new c.b(i2);
                        break;
                    }
                }
                String str2 = (String) dVar.BLx.am(a);
                bVar = str2 != null ? new c.b(str2) : c.c.BLu;
                this.BhR = bVar.cxT;
                AppMethodBeat.o(119799);
                return a;
            }
        }
        bVar = a.i.b.a.c.m.c.a.BLt;
        this.BhR = bVar.cxT;
        AppMethodBeat.o(119799);
        return a;
    }

    public final boolean eaw() {
        AppMethodBeat.i(119800);
        if ($assertionsDisabled || this.BmB != null) {
            boolean z = this.BmB.BmG;
            AppMethodBeat.o(119800);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(119800);
        throw assertionError;
    }

    public final boolean dYW() {
        AppMethodBeat.i(119801);
        if ($assertionsDisabled || this.BmB != null) {
            boolean z = this.BmB.BmH;
            AppMethodBeat.o(119801);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(119801);
        throw assertionError;
    }

    public final void ao(boolean z, boolean z2) {
        AppMethodBeat.i(119802);
        this.BmB = a.ap(z, z2);
        AppMethodBeat.o(119802);
    }

    public final /* synthetic */ p a(l lVar, t tVar, a.i.b.a.c.b.b.a aVar, f fVar, g gVar, am amVar) {
        f fVar2;
        AppMethodBeat.i(119803);
        al alVar = (al) tVar;
        if (fVar != null) {
            fVar2 = fVar;
        } else {
            fVar2 = this.BgZ;
        }
        e eVar = new e(lVar, alVar, gVar, fVar2, aVar, amVar);
        eVar.ao(eaw(), dYW());
        AppMethodBeat.o(119803);
        return eVar;
    }
}
