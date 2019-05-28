package a.i.b.a.c.l.a;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.a.a.c;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ao;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.k.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;

public final class t {

    static final class a extends k implements b<String, StringBuilder> {
        final /* synthetic */ StringBuilder BLj;

        a(StringBuilder stringBuilder) {
            this.BLj = stringBuilder;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122809);
            StringBuilder awq = awq((String) obj);
            AppMethodBeat.o(122809);
            return awq;
        }

        public final StringBuilder awq(String str) {
            AppMethodBeat.i(122810);
            j.p(str, "receiver$0");
            StringBuilder append = this.BLj.append(str);
            j.o(append, "append(value)");
            append = q.i(append);
            AppMethodBeat.o(122810);
            return append;
        }
    }

    public static final w a(w wVar, w wVar2, r rVar) {
        AppMethodBeat.i(122811);
        j.p(wVar, "subtype");
        j.p(wVar2, "supertype");
        j.p(rVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new n(wVar, null));
        an ejw = wVar2.ejw();
        while (!arrayDeque.isEmpty()) {
            n nVar = (n) arrayDeque.poll();
            w wVar3 = nVar.AYl;
            an ejw2 = wVar3.ejw();
            if (rVar.b(ejw2, ejw)) {
                boolean eci = wVar3.eci();
                w wVar4 = wVar3;
                n nVar2 = nVar.BKD;
                while (nVar2 != null) {
                    Object obj;
                    w aK;
                    boolean z;
                    w wVar5 = nVar2.AYl;
                    Iterable<ap> ejt = wVar5.ejt();
                    if (!((ejt instanceof Collection) && ((Collection) ejt).isEmpty())) {
                        for (ap ekq : ejt) {
                            if (ekq.ekq() != ba.INVARIANT) {
                                obj = 1;
                                continue;
                            } else {
                                obj = null;
                                continue;
                            }
                            if (obj != null) {
                                obj = 1;
                                break;
                            }
                        }
                    }
                    obj = null;
                    a.i.b.a.c.l.ao.a aVar;
                    if (obj != null) {
                        aVar = ao.BJQ;
                        wVar3 = c.c(a.i.b.a.c.l.ao.a.au(wVar5)).ekr().b(wVar4, ba.INVARIANT);
                        j.o(wVar3, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        aK = aK(wVar3);
                    } else {
                        aVar = ao.BJQ;
                        aK = a.i.b.a.c.l.ao.a.au(wVar5).ekr().b(wVar4, ba.INVARIANT);
                        j.o(aK, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                    }
                    if (eci || wVar5.eci()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    nVar2 = nVar2.BKD;
                    wVar4 = aK;
                    eci = z;
                }
                an ejw3 = wVar4.ejw();
                if (rVar.b(ejw3, ejw)) {
                    wVar3 = av.a(wVar4, eci);
                    AppMethodBeat.o(122811);
                    return wVar3;
                }
                Throwable assertionError = new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + d(ejw3) + ", \n\nsupertype: " + d(ejw) + " \n" + rVar.b(ejw3, ejw));
                AppMethodBeat.o(122811);
                throw assertionError;
            }
            for (w wVar32 : ejw2.eap()) {
                j.o(wVar32, "immediateSupertype");
                arrayDeque.add(new n(wVar32, nVar));
            }
        }
        AppMethodBeat.o(122811);
        return null;
    }

    private static final w aK(w wVar) {
        AppMethodBeat.i(122812);
        w wVar2 = (w) a.i.b.a.c.l.d.b.aO(wVar).BLn;
        AppMethodBeat.o(122812);
        return wVar2;
    }

    private static final String d(an anVar) {
        AppMethodBeat.i(122813);
        StringBuilder stringBuilder = new StringBuilder();
        a aVar = new a(stringBuilder);
        aVar.awq("type: ".concat(String.valueOf(anVar)));
        aVar.awq("hashCode: " + anVar.hashCode());
        aVar.awq("javaClass: " + anVar.getClass().getCanonicalName());
        for (l dYs = anVar.dYs(); dYs != null; dYs = dYs.dXW()) {
            aVar.awq("fqName: " + a.i.b.a.c.h.c.BBL.k(dYs));
            aVar.awq("javaClass: " + dYs.getClass().getCanonicalName());
        }
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(122813);
        return stringBuilder2;
    }
}
