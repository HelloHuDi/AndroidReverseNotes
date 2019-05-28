package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C31826o;
import p000a.C44847aa;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b.C31647d;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b.C31648e;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C17232c;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44897r;
import p000a.p010i.p011b.p012a.p015c.p037i.C25180e;
import p000a.p010i.p011b.p012a.p015c.p037i.C25180e.C25181a;
import p000a.p010i.p011b.p012a.p015c.p037i.C25180e.C25182b;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.m */
public final class C41418m implements C25180e {
    public static final C8128a Blf = new C8128a();

    /* renamed from: a.i.b.a.c.d.a.m$a */
    public static final class C8128a {
        private C8128a() {
        }

        public /* synthetic */ C8128a(byte b) {
            this();
        }

        /* renamed from: a */
        public static boolean m14312a(C8045a c8045a, C8045a c8045a2) {
            AppMethodBeat.m2504i(119696);
            C25052j.m39376p(c8045a, "superDescriptor");
            C25052j.m39376p(c8045a2, "subDescriptor");
            if ((c8045a2 instanceof C31648e) && (c8045a instanceof C8083t)) {
                boolean z = ((C31648e) c8045a2).BhM.size() == ((C8083t) c8045a).dYV().size();
                if (!C44847aa.AUz || z) {
                    C41397al eaK = ((C31648e) c8045a2).eaK();
                    C25052j.m39375o(eaK, "subDescriptor.original");
                    List dYV = eaK.dYV();
                    C25052j.m39375o(dYV, "subDescriptor.original.valueParameters");
                    Iterable iterable = dYV;
                    C8083t dZp = ((C8083t) c8045a).dZp();
                    C25052j.m39375o(dZp, "superDescriptor.original");
                    List dYV2 = dZp.dYV();
                    C25052j.m39375o(dYV2, "superDescriptor.original.valueParameters");
                    for (C31826o c31826o : C25035t.m39325a(iterable, (Iterable) dYV2)) {
                        C41399au c41399au = (C41399au) c31826o.first;
                        C41399au c41399au2 = (C41399au) c31826o.second;
                        C8083t c8083t = (C8083t) c8045a2;
                        C25052j.m39375o(c41399au, "subParameter");
                        boolean z2 = C8128a.m14311a(c8083t, c41399au) instanceof C17232c;
                        dZp = (C8083t) c8045a;
                        C25052j.m39375o(c41399au2, "superParameter");
                        if (z2 != (C8128a.m14311a(dZp, c41399au2) instanceof C17232c)) {
                            AppMethodBeat.m2505o(119696);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(119696);
                    return false;
                }
                Throwable assertionError = new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
                AppMethodBeat.m2505o(119696);
                throw assertionError;
            }
            AppMethodBeat.m2505o(119696);
            return false;
        }

        /* renamed from: a */
        private static C31680j m14311a(C8083t c8083t, C41399au c41399au) {
            AppMethodBeat.m2504i(119697);
            C46867w dZS;
            C31680j V;
            if (C44897r.m82110b(c8083t) || C8128a.m14313f(c8083t)) {
                dZS = c41399au.dZS();
                C25052j.m39375o(dZS, "valueParameterDescriptor.type");
                V = C44897r.m82106V(C41448a.m72317az(dZS));
                AppMethodBeat.m2505o(119697);
                return V;
            }
            dZS = c41399au.dZS();
            C25052j.m39375o(dZS, "valueParameterDescriptor.type");
            V = C44897r.m82106V(dZS);
            AppMethodBeat.m2505o(119697);
            return V;
        }

        /* renamed from: f */
        private static boolean m14313f(C8083t c8083t) {
            AppMethodBeat.m2504i(119698);
            if (c8083t.dYV().size() != 1) {
                AppMethodBeat.m2505o(119698);
                return false;
            }
            C31642l dXW = c8083t.dXW();
            if (!(dXW instanceof C46865e)) {
                dXW = null;
            }
            C46865e c46865e = (C46865e) dXW;
            if (c46865e == null) {
                AppMethodBeat.m2505o(119698);
                return false;
            }
            List dYV = c8083t.dYV();
            C25052j.m39375o(dYV, "f.valueParameters");
            Object fN = C25035t.m39341fN(dYV);
            C25052j.m39375o(fN, "f.valueParameters.single()");
            C0036h dYs = ((C41399au) fN).dZS().ejw().dYs();
            if (!(dYs instanceof C46865e)) {
                dYs = null;
            }
            C46865e c46865e2 = (C46865e) dYs;
            if (c46865e2 == null) {
                AppMethodBeat.m2505o(119698);
                return false;
            } else if (C31619g.m51117d(c46865e) && C25052j.m39373j(C41434a.m72284o(c46865e), C41434a.m72284o(c46865e2))) {
                AppMethodBeat.m2505o(119698);
                return true;
            } else {
                AppMethodBeat.m2505o(119698);
                return false;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(119700);
        AppMethodBeat.m2505o(119700);
    }

    public final C25181a eaX() {
        return C25181a.CONFLICTS_ONLY;
    }

    /* renamed from: a */
    public final C25182b mo42047a(C8045a c8045a, C8045a c8045a2, C46865e c46865e) {
        boolean z;
        AppMethodBeat.m2504i(119699);
        C25052j.m39376p(c8045a, "superDescriptor");
        C25052j.m39376p(c8045a2, "subDescriptor");
        if ((c8045a instanceof C25085b) && (c8045a2 instanceof C8083t) && !C31619g.m51108b((C31642l) c8045a2)) {
            C8045a c8045a3;
            C31671d c31671d = C31671d.BkH;
            C37022f dZg = ((C8083t) c8045a2).dZg();
            C25052j.m39375o(dZg, "subDescriptor.name");
            if (!C31671d.m51232h(dZg)) {
                C41407c c41407c = C41407c.Bky;
                dZg = ((C8083t) c8045a2).dZg();
                C25052j.m39375o(dZg, "subDescriptor.name");
                if (!C41407c.m72222f(dZg)) {
                    z = false;
                }
            }
            C25085b p = C44893t.m82100p((C25085b) c8045a);
            boolean dZr = ((C8083t) c8045a2).dZr();
            if (c8045a instanceof C8083t) {
                c8045a3 = c8045a;
            } else {
                c8045a3 = null;
            }
            C8083t c8083t = (C8083t) c8045a3;
            if (c8083t == null || dZr != c8083t.dZr()) {
                z = true;
            } else {
                z = false;
            }
            if (z && (p == null || !((C8083t) c8045a2).dZr())) {
                z = true;
            } else if (!(c46865e instanceof C31647d) || ((C8083t) c8045a2).dZq() != null) {
                z = false;
            } else if (p == null || C44893t.m82096a(c46865e, (C8045a) p)) {
                z = false;
            } else {
                if ((p instanceof C8083t) && (c8045a instanceof C8083t) && C31671d.m51231e((C8083t) p) != null) {
                    String a = C44897r.m82108a((C8083t) c8045a2, false, false, 2);
                    c8083t = ((C8083t) c8045a).dZp();
                    C25052j.m39375o(c8083t, "superDescriptor.original");
                    if (C25052j.m39373j(a, C44897r.m82108a(c8083t, false, false, 2))) {
                        z = false;
                    }
                }
                z = true;
            }
        } else {
            z = false;
        }
        C25182b c25182b;
        if (z) {
            c25182b = C25182b.INCOMPATIBLE;
            AppMethodBeat.m2505o(119699);
            return c25182b;
        } else if (C8128a.m14312a(c8045a, c8045a2)) {
            c25182b = C25182b.INCOMPATIBLE;
            AppMethodBeat.m2505o(119699);
            return c25182b;
        } else {
            c25182b = C25182b.UNKNOWN;
            AppMethodBeat.m2505o(119699);
            return c25182b;
        }
    }
}
