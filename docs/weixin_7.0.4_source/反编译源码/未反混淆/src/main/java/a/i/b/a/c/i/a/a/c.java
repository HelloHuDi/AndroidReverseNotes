package a.i.b.a.c.i.a.a;

import a.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.h;
import a.i.b.a.c.l.u;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.z;
import a.o;
import a.v;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class c {

    static final class a extends k implements a.f.a.a<w> {
        final /* synthetic */ ap BEK;

        a(ap apVar) {
            this.BEK = apVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122060);
            w dZS = this.BEK.dZS();
            j.o(dZS, "this@createCapturedIfNeeded.type");
            AppMethodBeat.o(122060);
            return dZS;
        }
    }

    public static final class b extends h {
        final /* synthetic */ as BEL;
        final /* synthetic */ boolean BEM = true;

        b(as asVar, as asVar2) {
            this.BEL = asVar;
            super(asVar2);
        }

        public final boolean ejx() {
            return this.BEM;
        }

        public final ap O(w wVar) {
            ap apVar = null;
            AppMethodBeat.i(122061);
            j.p(wVar, "key");
            ap O = super.O(wVar);
            if (O != null) {
                a.i.b.a.c.b.h dYs = wVar.ejw().dYs();
                if (dYs instanceof ar) {
                    Object apVar2 = dYs;
                }
                apVar2 = c.a(O, (ar) apVar2);
                AppMethodBeat.o(122061);
                return apVar2;
            }
            AppMethodBeat.o(122061);
            return null;
        }
    }

    private static w b(ap apVar) {
        AppMethodBeat.i(122062);
        j.p(apVar, "typeProjection");
        w aVar = new a(apVar);
        AppMethodBeat.o(122062);
        return aVar;
    }

    public static final boolean ae(w wVar) {
        AppMethodBeat.i(122063);
        j.p(wVar, "receiver$0");
        boolean z = wVar.ejw() instanceof b;
        AppMethodBeat.o(122063);
        return z;
    }

    public static /* synthetic */ as c(as asVar) {
        AppMethodBeat.i(122064);
        j.p(asVar, "receiver$0");
        as uVar;
        if (asVar instanceof u) {
            ar[] arVarArr = ((u) asVar).BJE;
            ap[] apVarArr = ((u) asVar).BJF;
            ar[] arVarArr2 = ((u) asVar).BJE;
            j.p(apVarArr, "receiver$0");
            j.p(arVarArr2, FacebookRequestErrorClassification.KEY_OTHER);
            int min = Math.min(apVarArr.length, arVarArr2.length);
            ArrayList arrayList = new ArrayList(min);
            for (int i = 0; i < min; i++) {
                arrayList.add(a.u.I(apVarArr[i], arVarArr2[i]));
            }
            Iterable<o> iterable = arrayList;
            Collection arrayList2 = new ArrayList(m.d(iterable));
            for (o oVar : iterable) {
                arrayList2.add(a((ap) oVar.first, (ar) oVar.second));
            }
            Object[] toArray = ((List) arrayList2).toArray(new ap[0]);
            if (toArray == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(122064);
                throw vVar;
            }
            uVar = new u(arVarArr, (ap[]) toArray, true);
            AppMethodBeat.o(122064);
            return uVar;
        }
        uVar = new b(asVar, asVar);
        AppMethodBeat.o(122064);
        return uVar;
    }

    static final ap a(ap apVar, ar arVar) {
        AppMethodBeat.i(122065);
        ap arVar2;
        if (arVar == null || apVar.ekq() == ba.INVARIANT) {
            AppMethodBeat.o(122065);
            return apVar;
        } else if (arVar.dZh() != apVar.ekq()) {
            arVar2 = new a.i.b.a.c.l.ar(b(apVar));
            AppMethodBeat.o(122065);
            return arVar2;
        } else if (apVar.ekp()) {
            i iVar = a.i.b.a.c.k.b.BIH;
            j.o(iVar, "LockBasedStorageManager.NO_LOCKS");
            arVar2 = new a.i.b.a.c.l.ar(new z(iVar, new a(apVar)));
            AppMethodBeat.o(122065);
            return arVar2;
        } else {
            arVar2 = new a.i.b.a.c.l.ar(apVar.dZS());
            AppMethodBeat.o(122065);
            return arVar2;
        }
    }
}
