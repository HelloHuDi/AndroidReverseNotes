package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31824m;
import p000a.C44847aa;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.p017b.C41391c;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C31630k;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C17230p;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b.C44883g;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25231ax;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.f.s */
public final class C25119s {
    private static final C17189b BqL;
    private static final C17189b BqM;

    /* renamed from: a */
    public static final C46867w m39501a(C46867w c46867w, C17126b<? super Integer, C8119d> c17126b) {
        AppMethodBeat.m2504i(120200);
        C25052j.m39376p(c46867w, "receiver$0");
        C25052j.m39376p(c17126b, "qualifiers");
        C17214k a = C25119s.m39499a(c46867w.ekn(), (C17126b) c17126b, 0);
        C46867w dZS = a.dZS();
        if (a.Bqi) {
            AppMethodBeat.m2505o(120200);
            return dZS;
        }
        AppMethodBeat.m2505o(120200);
        return null;
    }

    /* renamed from: U */
    public static final boolean m39496U(C46867w c46867w) {
        AppMethodBeat.m2504i(120201);
        C25052j.m39376p(c46867w, "receiver$0");
        C0026g dYn = c46867w.dYn();
        C8174b c8174b = C17230p.Blv;
        C25052j.m39375o(c8174b, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        if (dYn.mo53i(c8174b) != null) {
            AppMethodBeat.m2505o(120201);
            return true;
        }
        AppMethodBeat.m2505o(120201);
        return false;
    }

    /* renamed from: a */
    private static final C17214k m39499a(C41447az c41447az, C17126b<? super Integer, C8119d> c17126b, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(120202);
        C17214k c17214k;
        if (C25239y.m39807an(c41447az)) {
            c17214k = new C17214k(c41447az, 1, false);
            AppMethodBeat.m2505o(120202);
            return c17214k;
        } else if (c41447az instanceof C17325q) {
            C41417o a = C25119s.m39500a(((C17325q) c41447az).BJx, c17126b, i, C44890q.FLEXIBLE_LOWER);
            C41417o a2 = C25119s.m39500a(((C17325q) c41447az).BJy, c17126b, i, C44890q.FLEXIBLE_UPPER);
            if (a.Bqh == a2.Bqh) {
                int i2 = 1;
            } else {
                boolean i22 = false;
            }
            if (C44847aa.AUz && i22 == 0) {
                Throwable assertionError = new AssertionError("Different tree sizes of bounds: lower = (" + ((C17325q) c41447az).BJx + ", " + a.Bqh + "), upper = (" + ((C17325q) c41447az).BJy + ", " + a2.Bqh + ')');
                AppMethodBeat.m2505o(120202);
                throw assertionError;
            }
            C46867w aG;
            C41447az c44883g;
            if (a.Bqi || a2.Bqi) {
                z = true;
            }
            C46867w aG2 = C25231ax.m39779aG(a.BqF);
            if (aG2 == null) {
                aG = C25231ax.m39779aG(a2.BqF);
            } else {
                aG = aG2;
            }
            if (z) {
                if (c41447az instanceof C44883g) {
                    c44883g = new C44883g(a.BqF, a2.BqF);
                } else {
                    c44883g = C17326x.m26839a(a.BqF, a2.BqF);
                }
                c44883g = C25231ax.m39780b(c44883g, aG);
            } else {
                c44883g = c41447az;
            }
            C17214k c17214k2 = new C17214k(c44883g, a.Bqh, z);
            AppMethodBeat.m2505o(120202);
            return c17214k2;
        } else if (c41447az instanceof C8235ad) {
            c17214k = C25119s.m39500a((C8235ad) c41447az, c17126b, i, C44890q.INFLEXIBLE);
            AppMethodBeat.m2505o(120202);
            return c17214k;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(120202);
            throw c31824m;
        }
    }

    /* renamed from: a */
    private static final C41417o m39500a(C8235ad c8235ad, C17126b<? super Integer, C8119d> c17126b, int i, C44890q c44890q) {
        AppMethodBeat.m2504i(120203);
        C41417o c41417o;
        if (C25119s.m39502a(c44890q) || !c8235ad.ejt().isEmpty()) {
            C0036h dYs = c8235ad.ejw().dYs();
            if (dYs == null) {
                c41417o = new C41417o(c8235ad, 1, false);
                AppMethodBeat.m2505o(120203);
                return c41417o;
            }
            C25052j.m39375o(dYs, "constructor.declarationD…pleResult(this, 1, false)");
            C8119d c8119d = (C8119d) c17126b.mo50am(Integer.valueOf(i));
            C25118c a = C25119s.m39497a(dYs, c8119d, c44890q);
            dYs = (C0036h) a.result;
            C0026g c0026g = a.BpA;
            C17313an dXY = dYs.dXY();
            C25052j.m39375o(dXY, "enhancedClassifier.typeConstructor");
            int i2 = i + 1;
            Object obj = c0026g != null ? 1 : null;
            Iterable ejt = c8235ad.ejt();
            Collection arrayList = new ArrayList(C25034m.m39318d(ejt));
            int i3 = 0;
            int i4 = i2;
            for (Object next : ejt) {
                Object next2;
                int i5;
                i2 = i3 + 1;
                if (i3 < 0) {
                    C7987l.dWs();
                }
                C41446ap c41446ap = (C41446ap) next2;
                if (c41446ap.ekp()) {
                    i5 = i4 + 1;
                    C17313an dXY2 = dYs.dXY();
                    C25052j.m39375o(dXY2, "enhancedClassifier.typeConstructor");
                    next2 = C17316av.m26823e((C36955ar) dXY2.getParameters().get(i3));
                } else {
                    C17214k a2 = C25119s.m39499a(c41446ap.dZS().ekn(), (C17126b) c17126b, i4);
                    if (obj != null || a2.Bqi) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    i5 = a2.Bqh + i4;
                    C46867w dZS = a2.dZS();
                    C0163ba ekq = c41446ap.ekq();
                    C25052j.m39375o(ekq, "arg.projectionKind");
                    next2 = C41448a.m72310a(dZS, ekq, (C36955ar) dXY.getParameters().get(i3));
                }
                arrayList.add(next2);
                i3 = i2;
                i4 = i5;
            }
            List list = (List) arrayList;
            a = C25119s.m39498a((C46867w) c8235ad, c8119d, c44890q);
            boolean booleanValue = ((Boolean) a.result).booleanValue();
            C0026g c0026g2 = a.BpA;
            Object obj2 = (obj == null && c0026g2 == null) ? null : 1;
            int i6 = i4 - i;
            if (obj2 == null) {
                c41417o = new C41417o(c8235ad, i6, false);
                AppMethodBeat.m2505o(120203);
                return c41417o;
            }
            C8235ad c41413f;
            C8235ad c = C17326x.m26840c(C25119s.m39506fX(C25035t.m39350k(C7987l.listOf(c8235ad.dYn(), c0026g, c0026g2))), dXY, list, booleanValue);
            if (c8119d.BpD) {
                c41413f = new C41413f(c);
            } else {
                c41413f = c;
            }
            Object obj3 = (c0026g2 == null || !c8119d.BpE) ? null : 1;
            C41447az b = obj3 != null ? C25231ax.m39780b(c8235ad, c41413f) : c41413f;
            if (b == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
                AppMethodBeat.m2505o(120203);
                throw c44941v;
            }
            C41417o c41417o2 = new C41417o((C8235ad) b, i6, true);
            AppMethodBeat.m2505o(120203);
            return c41417o2;
        }
        c41417o = new C41417o(c8235ad, 1, false);
        AppMethodBeat.m2505o(120203);
        return c41417o;
    }

    /* renamed from: fX */
    private static final C0026g m39506fX(List<? extends C0026g> list) {
        AppMethodBeat.m2504i(120204);
        C0026g c0026g;
        switch (list.size()) {
            case 0:
                Throwable illegalStateException = new IllegalStateException("At least one Annotations object expected".toString());
                AppMethodBeat.m2505o(120204);
                throw illegalStateException;
            case 1:
                c0026g = (C0026g) C25035t.m39341fN(list);
                AppMethodBeat.m2505o(120204);
                return c0026g;
            default:
                c0026g = new C31630k(C25035t.m39352m(list));
                AppMethodBeat.m2505o(120204);
                return c0026g;
        }
    }

    /* renamed from: a */
    private static final boolean m39502a(C44890q c44890q) {
        return c44890q != C44890q.INFLEXIBLE;
    }

    /* renamed from: dC */
    private static final <T> C25118c<T> m39503dC(T t) {
        AppMethodBeat.m2504i(120205);
        C25118c c25118c = new C25118c(t, null);
        AppMethodBeat.m2505o(120205);
        return c25118c;
    }

    /* renamed from: dD */
    private static final <T> C25118c<T> m39504dD(T t) {
        AppMethodBeat.m2504i(120206);
        C25118c c25118c = new C25118c(t, BqL);
        AppMethodBeat.m2505o(120206);
        return c25118c;
    }

    /* renamed from: dE */
    private static final <T> C25118c<T> m39505dE(T t) {
        AppMethodBeat.m2504i(120207);
        C25118c c25118c = new C25118c(t, BqM);
        AppMethodBeat.m2505o(120207);
        return c25118c;
    }

    /* renamed from: a */
    private static final C25118c<C0036h> m39497a(C0036h c0036h, C8119d c8119d, C44890q c44890q) {
        AppMethodBeat.m2504i(120208);
        C25118c<C0036h> dE;
        if (!C25119s.m39502a(c44890q)) {
            C25118c dC = C25119s.m39503dC(c0036h);
            AppMethodBeat.m2505o(120208);
            return dC;
        } else if (c0036h instanceof C46865e) {
            C41391c c41391c = C41391c.Bdq;
            C41412e c41412e = c8119d.BpC;
            if (c41412e != null) {
                switch (C8125t.eQZ[c41412e.ordinal()]) {
                    case 1:
                        if (c44890q == C44890q.FLEXIBLE_LOWER && C41391c.m72181h((C46865e) c0036h)) {
                            dE = C25119s.m39505dE(C41391c.m72183j((C46865e) c0036h));
                            AppMethodBeat.m2505o(120208);
                            return dE;
                        }
                    case 2:
                        if (c44890q == C44890q.FLEXIBLE_UPPER && C41391c.m72182i((C46865e) c0036h)) {
                            dE = C25119s.m39505dE(C41391c.m72184k((C46865e) c0036h));
                            AppMethodBeat.m2505o(120208);
                            return dE;
                        }
                }
            }
            dE = C25119s.m39503dC(c0036h);
            AppMethodBeat.m2505o(120208);
            return dE;
        } else {
            dE = C25119s.m39503dC(c0036h);
            AppMethodBeat.m2505o(120208);
            return dE;
        }
    }

    /* renamed from: a */
    private static final C25118c<Boolean> m39498a(C46867w c46867w, C8119d c8119d, C44890q c44890q) {
        AppMethodBeat.m2504i(120209);
        if (C25119s.m39502a(c44890q)) {
            C25118c<Boolean> dD;
            C41414g c41414g = c8119d.BpB;
            if (c41414g != null) {
                switch (C8125t.pCY[c41414g.ordinal()]) {
                    case 1:
                        dD = C25119s.m39504dD(Boolean.TRUE);
                        AppMethodBeat.m2505o(120209);
                        return dD;
                    case 2:
                        dD = C25119s.m39504dD(Boolean.FALSE);
                        AppMethodBeat.m2505o(120209);
                        return dD;
                }
            }
            dD = C25119s.m39503dC(Boolean.valueOf(c46867w.eci()));
            AppMethodBeat.m2505o(120209);
            return dD;
        }
        C25118c dC = C25119s.m39503dC(Boolean.valueOf(c46867w.eci()));
        AppMethodBeat.m2505o(120209);
        return dC;
    }

    static {
        AppMethodBeat.m2504i(120210);
        C8174b c8174b = C17230p.Blv;
        C25052j.m39375o(c8174b, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        BqL = new C17189b(c8174b);
        c8174b = C17230p.Blw;
        C25052j.m39375o(c8174b, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        BqM = new C17189b(c8174b);
        AppMethodBeat.m2505o(120210);
    }
}
