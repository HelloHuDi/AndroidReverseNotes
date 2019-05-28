package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a.C41431c;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao.C8238a;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1148d.C41451b;
import p000a.p051k.C31819q;

/* renamed from: a.i.b.a.c.l.a.t */
public final class C25221t {

    /* renamed from: a.i.b.a.c.l.a.t$a */
    static final class C25222a extends C25053k implements C17126b<String, StringBuilder> {
        final /* synthetic */ StringBuilder BLj;

        C25222a(StringBuilder stringBuilder) {
            this.BLj = stringBuilder;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122809);
            StringBuilder awq = awq((String) obj);
            AppMethodBeat.m2505o(122809);
            return awq;
        }

        public final StringBuilder awq(String str) {
            AppMethodBeat.m2504i(122810);
            C25052j.m39376p(str, "receiver$0");
            StringBuilder append = this.BLj.append(str);
            C25052j.m39375o(append, "append(value)");
            append = C31819q.m51511i(append);
            AppMethodBeat.m2505o(122810);
            return append;
        }
    }

    /* renamed from: a */
    public static final C46867w m39749a(C46867w c46867w, C46867w c46867w2, C8233r c8233r) {
        AppMethodBeat.m2504i(122811);
        C25052j.m39376p(c46867w, "subtype");
        C25052j.m39376p(c46867w2, "supertype");
        C25052j.m39376p(c8233r, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new C37044n(c46867w, null));
        C17313an ejw = c46867w2.ejw();
        while (!arrayDeque.isEmpty()) {
            C37044n c37044n = (C37044n) arrayDeque.poll();
            C46867w c46867w3 = c37044n.AYl;
            C17313an ejw2 = c46867w3.ejw();
            if (c8233r.mo18027b(ejw2, ejw)) {
                boolean eci = c46867w3.eci();
                C46867w c46867w4 = c46867w3;
                C37044n c37044n2 = c37044n.BKD;
                while (c37044n2 != null) {
                    Object obj;
                    C46867w aK;
                    boolean z;
                    C46867w c46867w5 = c37044n2.AYl;
                    Iterable<C41446ap> ejt = c46867w5.ejt();
                    if (!((ejt instanceof Collection) && ((Collection) ejt).isEmpty())) {
                        for (C41446ap ekq : ejt) {
                            if (ekq.ekq() != C0163ba.INVARIANT) {
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
                    C8238a c8238a;
                    if (obj != null) {
                        c8238a = C25225ao.BJQ;
                        c46867w3 = C41431c.m72271c(C8238a.m14559au(c46867w5)).ekr().mo42079b(c46867w4, C0163ba.INVARIANT);
                        C25052j.m39375o(c46867w3, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        aK = C25221t.m39750aK(c46867w3);
                    } else {
                        c8238a = C25225ao.BJQ;
                        aK = C8238a.m14559au(c46867w5).ekr().mo42079b(c46867w4, C0163ba.INVARIANT);
                        C25052j.m39375o(aK, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                    }
                    if (eci || c46867w5.eci()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c37044n2 = c37044n2.BKD;
                    c46867w4 = aK;
                    eci = z;
                }
                C17313an ejw3 = c46867w4.ejw();
                if (c8233r.mo18027b(ejw3, ejw)) {
                    c46867w3 = C17316av.m26811a(c46867w4, eci);
                    AppMethodBeat.m2505o(122811);
                    return c46867w3;
                }
                Throwable assertionError = new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + C25221t.m39751d(ejw3) + ", \n\nsupertype: " + C25221t.m39751d(ejw) + " \n" + c8233r.mo18027b(ejw3, ejw));
                AppMethodBeat.m2505o(122811);
                throw assertionError;
            }
            for (C46867w c46867w32 : ejw2.eap()) {
                C25052j.m39375o(c46867w32, "immediateSupertype");
                arrayDeque.add(new C37044n(c46867w32, c37044n));
            }
        }
        AppMethodBeat.m2505o(122811);
        return null;
    }

    /* renamed from: aK */
    private static final C46867w m39750aK(C46867w c46867w) {
        AppMethodBeat.m2504i(122812);
        C46867w c46867w2 = (C46867w) C41451b.m72325aO(c46867w).BLn;
        AppMethodBeat.m2505o(122812);
        return c46867w2;
    }

    /* renamed from: d */
    private static final String m39751d(C17313an c17313an) {
        AppMethodBeat.m2504i(122813);
        StringBuilder stringBuilder = new StringBuilder();
        C25222a c25222a = new C25222a(stringBuilder);
        c25222a.awq("type: ".concat(String.valueOf(c17313an)));
        c25222a.awq("hashCode: " + c17313an.hashCode());
        c25222a.awq("javaClass: " + c17313an.getClass().getCanonicalName());
        for (C31642l dYs = c17313an.dYs(); dYs != null; dYs = dYs.dXW()) {
            c25222a.awq("fqName: " + C31724c.BBL.mo13667k(dYs));
            c25222a.awq("javaClass: " + dYs.getClass().getCanonicalName());
        }
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.m2505o(122813);
        return stringBuilder2;
    }
}
