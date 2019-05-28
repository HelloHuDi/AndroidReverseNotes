package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31824m;
import p000a.C31826o;
import p000a.C8312u;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C25096l;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C44836ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.d.a.c.b.e */
public final class C25111e extends C44922as {
    private static final C17179a Bpo = C25109d.m39487a(C25096l.COMMON, false, null, 3).mo31271a(C25108b.FLEXIBLE_LOWER_BOUND);
    private static final C17179a Bpp = C25109d.m39487a(C25096l.COMMON, false, null, 3).mo31271a(C25108b.FLEXIBLE_UPPER_BOUND);
    public static final C25111e Bpq = new C25111e();

    static {
        AppMethodBeat.m2504i(120062);
        AppMethodBeat.m2505o(120062);
    }

    private C25111e() {
    }

    /* renamed from: O */
    public final /* synthetic */ C41446ap mo31386O(C46867w c46867w) {
        AppMethodBeat.m2504i(120057);
        C25052j.m39376p(c46867w, "key");
        C41446ap c44836ar = new C44836ar(m39491P(c46867w));
        AppMethodBeat.m2505o(120057);
        return c44836ar;
    }

    /* renamed from: P */
    private final C46867w m39491P(C46867w c46867w) {
        C0036h dYs;
        AppMethodBeat.m2504i(120058);
        while (true) {
            dYs = c46867w.ejw().dYs();
            if (!(dYs instanceof C36955ar)) {
                break;
            }
            c46867w = C25109d.m39490b((C36955ar) dYs);
        }
        if (dYs instanceof C46865e) {
            C41447az c44883g;
            C31826o a = m39493a(C44924t.m82162ak(c46867w), (C46865e) dYs, Bpo);
            C8235ad c8235ad = (C8235ad) a.first;
            boolean booleanValue = ((Boolean) a.second).booleanValue();
            a = m39493a(C44924t.m82163al(c46867w), (C46865e) dYs, Bpp);
            C8235ad c8235ad2 = (C8235ad) a.first;
            boolean booleanValue2 = ((Boolean) a.second).booleanValue();
            if (booleanValue || booleanValue2) {
                c44883g = new C44883g(c8235ad, c8235ad2);
            } else {
                c44883g = C17326x.m26839a(c8235ad, c8235ad2);
            }
            C46867w c46867w2 = c44883g;
            AppMethodBeat.m2505o(120058);
            return c46867w2;
        }
        Throwable illegalStateException = new IllegalStateException("Unexpected declaration kind: ".concat(String.valueOf(dYs)).toString());
        AppMethodBeat.m2505o(120058);
        throw illegalStateException;
    }

    /* renamed from: a */
    private final C31826o<C8235ad, Boolean> m39493a(C8235ad c8235ad, C46865e c46865e, C17179a c17179a) {
        AppMethodBeat.m2504i(120059);
        C31826o<C8235ad, Boolean> I;
        if (c8235ad.ejw().getParameters().isEmpty()) {
            C31826o I2 = C8312u.m14628I(c8235ad, Boolean.FALSE);
            AppMethodBeat.m2505o(120059);
            return I2;
        } else if (C31619g.m51123n(c8235ad)) {
            C41446ap c41446ap = (C41446ap) c8235ad.ejt().get(0);
            C0163ba ekq = c41446ap.ekq();
            C46867w dZS = c41446ap.dZS();
            C25052j.m39375o(dZS, "componentTypeProjection.type");
            I = C8312u.m14628I(C17326x.m26840c(c8235ad.dYn(), c8235ad.ejw(), C25033k.listOf(new C44836ar(ekq, m39491P(dZS))), c8235ad.eci()), Boolean.FALSE);
            AppMethodBeat.m2505o(120059);
            return I;
        } else if (C25239y.m39807an(c8235ad)) {
            I = C8312u.m14628I(C25235p.awn("Raw error type: " + c8235ad.ejw()), Boolean.FALSE);
            AppMethodBeat.m2505o(120059);
            return I;
        } else {
            C0026g dYn = c8235ad.dYn();
            C17313an ejw = c8235ad.ejw();
            List parameters = c8235ad.ejw().getParameters();
            C25052j.m39375o(parameters, "type.constructor.parameters");
            Iterable<C36955ar> iterable = parameters;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C36955ar c36955ar : iterable) {
                C25052j.m39375o(c36955ar, "parameter");
                arrayList.add(C25111e.m39494b(c36955ar, c17179a));
            }
            List list = (List) arrayList;
            boolean eci = c8235ad.eci();
            C31746h a = c46865e.mo31262a(Bpq);
            C25052j.m39375o(a, "declaration.getMemberScope(RawSubstitution)");
            I = C8312u.m14628I(C17326x.m26838a(dYn, ejw, list, eci, a), Boolean.TRUE);
            AppMethodBeat.m2505o(120059);
            return I;
        }
    }

    /* renamed from: b */
    private static /* synthetic */ C41446ap m39494b(C36955ar c36955ar, C17179a c17179a) {
        AppMethodBeat.m2504i(120061);
        C41446ap a = C25111e.m39492a(c36955ar, c17179a, C25109d.m39490b(c36955ar));
        AppMethodBeat.m2505o(120061);
        return a;
    }

    public final boolean isEmpty() {
        return false;
    }

    /* renamed from: a */
    public static C41446ap m39492a(C36955ar c36955ar, C17179a c17179a, C46867w c46867w) {
        AppMethodBeat.m2504i(120060);
        C25052j.m39376p(c36955ar, "parameter");
        C25052j.m39376p(c17179a, "attr");
        C25052j.m39376p(c46867w, "erasedUpperBound");
        C41446ap c44836ar;
        switch (C36976f.eQZ[c17179a.BoX.ordinal()]) {
            case 1:
                c44836ar = new C44836ar(C0163ba.INVARIANT, c46867w);
                AppMethodBeat.m2505o(120060);
                return c44836ar;
            case 2:
            case 3:
                if (c36955ar.dZh().BKm) {
                    List parameters = c46867w.ejw().getParameters();
                    C25052j.m39375o(parameters, "erasedUpperBound.constructor.parameters");
                    if ((!((Collection) parameters).isEmpty() ? 1 : null) != null) {
                        c44836ar = new C44836ar(C0163ba.OUT_VARIANCE, c46867w);
                        AppMethodBeat.m2505o(120060);
                        return c44836ar;
                    }
                    c44836ar = C25109d.m39488a(c36955ar, c17179a);
                    AppMethodBeat.m2505o(120060);
                    return c44836ar;
                }
                c44836ar = new C44836ar(C0163ba.INVARIANT, C41434a.m72275G(c36955ar).dXL());
                AppMethodBeat.m2505o(120060);
                return c44836ar;
            default:
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(120060);
                throw c31824m;
        }
    }
}
