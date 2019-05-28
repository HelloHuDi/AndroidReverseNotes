package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p037i.C31747j.C31750a;
import p000a.p010i.p011b.p012a.p015c.p037i.C31747j.C31750a.C8213a;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8229c.C0159a;

/* renamed from: a.i.b.a.c.i.b */
public final class C44906b {
    public static final C44906b BDK = new C44906b();

    /* renamed from: a.i.b.a.c.i.b$c */
    static final class C0127c extends C25053k implements C31591m<C31642l, C31642l, Boolean> {
        public static final C0127c BDP = new C0127c();

        static {
            AppMethodBeat.m2504i(121922);
            AppMethodBeat.m2505o(121922);
        }

        C0127c() {
            super(2);
        }

        /* renamed from: m */
        public final /* bridge */ /* synthetic */ Object mo212m(Object obj, Object obj2) {
            return Boolean.FALSE;
        }
    }

    /* renamed from: a.i.b.a.c.i.b$b */
    static final class C6155b implements C0159a {
        final /* synthetic */ C8045a BDM;
        final /* synthetic */ C8045a BDN;

        /* renamed from: a.i.b.a.c.i.b$b$1 */
        static final class C61561 extends C25053k implements C31591m<C31642l, C31642l, Boolean> {
            final /* synthetic */ C6155b BDO;

            C61561(C6155b c6155b) {
                this.BDO = c6155b;
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                boolean z;
                AppMethodBeat.m2504i(121920);
                C31642l c31642l = (C31642l) obj2;
                if (C25052j.m39373j((C31642l) obj, this.BDO.BDM) && C25052j.m39373j(c31642l, this.BDO.BDN)) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.m2505o(121920);
                return valueOf;
            }
        }

        C6155b(C8045a c8045a, C8045a c8045a2) {
            this.BDM = c8045a;
            this.BDN = c8045a2;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo243a(C17313an c17313an, C17313an c17313an2) {
            AppMethodBeat.m2504i(121921);
            C25052j.m39376p(c17313an, "c1");
            C25052j.m39376p(c17313an2, "c2");
            if (C25052j.m39373j(c17313an, c17313an2)) {
                AppMethodBeat.m2505o(121921);
                return true;
            }
            C0036h dYs = c17313an.dYs();
            C0036h dYs2 = c17313an2.dYs();
            if ((dYs instanceof C36955ar) && (dYs2 instanceof C36955ar)) {
                boolean a = C44906b.m82126a(C44906b.BDK, (C36955ar) dYs, (C36955ar) dYs2, new C61561(this));
                AppMethodBeat.m2505o(121921);
                return a;
            }
            AppMethodBeat.m2505o(121921);
            return false;
        }
    }

    /* renamed from: a.i.b.a.c.i.b$a */
    static final class C36658a extends C25053k implements C31591m<C31642l, C31642l, Boolean> {
        public static final C36658a BDL = new C36658a();

        static {
            AppMethodBeat.m2504i(121919);
            AppMethodBeat.m2505o(121919);
        }

        C36658a() {
            super(2);
        }

        /* renamed from: m */
        public final /* bridge */ /* synthetic */ Object mo212m(Object obj, Object obj2) {
            return Boolean.FALSE;
        }
    }

    static {
        AppMethodBeat.m2504i(121926);
        AppMethodBeat.m2505o(121926);
    }

    private C44906b() {
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m82126a(C44906b c44906b, C36955ar c36955ar, C36955ar c36955ar2, C31591m c31591m) {
        AppMethodBeat.m2504i(121927);
        boolean a = c44906b.m82124a(c36955ar, c36955ar2, c31591m);
        AppMethodBeat.m2505o(121927);
        return a;
    }

    /* renamed from: d */
    public final boolean mo72105d(C31642l c31642l, C31642l c31642l2) {
        AppMethodBeat.m2504i(121923);
        boolean j;
        if ((c31642l instanceof C46865e) && (c31642l2 instanceof C46865e)) {
            j = C25052j.m39373j(((C46865e) c31642l).dXY(), ((C46865e) c31642l2).dXY());
            AppMethodBeat.m2505o(121923);
            return j;
        } else if ((c31642l instanceof C36955ar) && (c31642l2 instanceof C36955ar)) {
            j = m82124a((C36955ar) c31642l, (C36955ar) c31642l2, (C31591m) C0127c.BDP);
            AppMethodBeat.m2505o(121923);
            return j;
        } else if ((c31642l instanceof C8045a) && (c31642l2 instanceof C8045a)) {
            C8045a c8045a = (C8045a) c31642l;
            C8045a c8045a2 = (C8045a) c31642l2;
            C25052j.m39376p(c8045a, "a");
            C25052j.m39376p(c8045a2, "b");
            if (C25052j.m39373j(c8045a, c8045a2)) {
                AppMethodBeat.m2505o(121923);
                return true;
            }
            if ((C25052j.m39373j(c8045a.dZg(), c8045a2.dZg()) ^ 1) == 0 && !C25052j.m39373j(c8045a.dXW(), c8045a2.dXW())) {
                if (C8203d.m14485m(c8045a) || C8203d.m14485m(c8045a2)) {
                    AppMethodBeat.m2505o(121923);
                    return false;
                } else if (m82125a((C31642l) c8045a, (C31642l) c8045a2, (C31591m) C36658a.BDL)) {
                    C31747j a = C31747j.m51396a((C0159a) new C6155b(c8045a, c8045a2));
                    C25052j.m39375o(a, "OverridingUtil.createWit…= a && y == b})\n        }");
                    C31750a a2 = a.mo51743a(c8045a, c8045a2, null, true);
                    C25052j.m39375o(a2, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                    if (a2.BEy == C8213a.OVERRIDABLE) {
                        C31750a a3 = a.mo51743a(c8045a2, c8045a, null, true);
                        C25052j.m39375o(a3, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                        if (a3.BEy == C8213a.OVERRIDABLE) {
                            AppMethodBeat.m2505o(121923);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(121923);
            return false;
        } else if ((c31642l instanceof C36953ab) && (c31642l2 instanceof C36953ab)) {
            j = C25052j.m39373j(((C36953ab) c31642l).dZF(), ((C36953ab) c31642l2).dZF());
            AppMethodBeat.m2505o(121923);
            return j;
        } else {
            j = C25052j.m39373j(c31642l, c31642l2);
            AppMethodBeat.m2505o(121923);
            return j;
        }
    }

    /* renamed from: a */
    private final boolean m82124a(C36955ar c36955ar, C36955ar c36955ar2, C31591m<? super C31642l, ? super C31642l, Boolean> c31591m) {
        AppMethodBeat.m2504i(121924);
        if (C25052j.m39373j(c36955ar, c36955ar2)) {
            AppMethodBeat.m2505o(121924);
            return true;
        } else if (C25052j.m39373j(c36955ar.dXW(), c36955ar2.dXW())) {
            AppMethodBeat.m2505o(121924);
            return false;
        } else if (!m82125a((C31642l) c36955ar, (C31642l) c36955ar2, (C31591m) c31591m)) {
            AppMethodBeat.m2505o(121924);
            return false;
        } else if (c36955ar.getIndex() == c36955ar2.getIndex()) {
            AppMethodBeat.m2505o(121924);
            return true;
        } else {
            AppMethodBeat.m2505o(121924);
            return false;
        }
    }

    /* renamed from: a */
    private final boolean m82125a(C31642l c31642l, C31642l c31642l2, C31591m<? super C31642l, ? super C31642l, Boolean> c31591m) {
        AppMethodBeat.m2504i(121925);
        C31642l dXW = c31642l.dXW();
        C31642l dXW2 = c31642l2.dXW();
        boolean booleanValue;
        if ((dXW instanceof C25085b) || (dXW2 instanceof C25085b)) {
            booleanValue = ((Boolean) c31591m.mo212m(dXW, dXW2)).booleanValue();
            AppMethodBeat.m2505o(121925);
            return booleanValue;
        }
        booleanValue = mo72105d(dXW, dXW2);
        AppMethodBeat.m2505o(121925);
        return booleanValue;
    }
}
