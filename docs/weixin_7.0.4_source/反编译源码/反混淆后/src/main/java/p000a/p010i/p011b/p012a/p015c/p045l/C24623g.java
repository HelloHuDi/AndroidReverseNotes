package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8231k;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8232l;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.l.g */
public final class C24623g extends C17324i implements C17321f {
    public static final C17322a BJi = new C17322a();
    final C8235ad BJh;

    /* renamed from: a.i.b.a.c.l.g$a */
    public static final class C17322a {
        private C17322a() {
        }

        public /* synthetic */ C17322a(byte b) {
            this();
        }

        /* renamed from: a */
        public static C24623g m26830a(C41447az c41447az) {
            AppMethodBeat.m2504i(122499);
            C25052j.m39376p(c41447az, "type");
            if (c41447az instanceof C24623g) {
                C24623g c24623g = (C24623g) c41447az;
                AppMethodBeat.m2505o(122499);
                return c24623g;
            } else if (C17322a.m26831b(c41447az)) {
                if (c41447az instanceof C17325q) {
                    boolean j = C25052j.m39373j(((C17325q) c41447az).BJx.ejw(), ((C17325q) c41447az).BJy.ejw());
                    if (C44847aa.AUz && !j) {
                        Throwable assertionError = new AssertionError("DefinitelyNotNullType for flexible type (" + c41447az + ") can be created only from type variable with the same constructor for bounds");
                        AppMethodBeat.m2505o(122499);
                        throw assertionError;
                    }
                }
                C24623g c24623g2 = new C24623g(C44924t.m82162ak(c41447az), (byte) 0);
                AppMethodBeat.m2505o(122499);
                return c24623g2;
            } else {
                AppMethodBeat.m2505o(122499);
                return null;
            }
        }

        /* renamed from: b */
        private static boolean m26831b(C41447az c41447az) {
            AppMethodBeat.m2504i(122500);
            C25052j.m39376p(c41447az, "type");
            if (C41448a.m72319h(c41447az)) {
                C8232l c8232l = C8232l.BKB;
                if (!C8232l.m14541d(c41447az)) {
                    AppMethodBeat.m2505o(122500);
                    return true;
                }
            }
            AppMethodBeat.m2505o(122500);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(122509);
        AppMethodBeat.m2505o(122509);
    }

    private C24623g(C8235ad c8235ad) {
        this.BJh = c8235ad;
    }

    public /* synthetic */ C24623g(C8235ad c8235ad, byte b) {
        this(c8235ad);
    }

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122504);
        C41447az g = m38302g(c0026g);
        AppMethodBeat.m2505o(122504);
        return g;
    }

    /* renamed from: d */
    public final /* synthetic */ C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122505);
        C8235ad g = m38302g(c0026g);
        AppMethodBeat.m2505o(122505);
        return g;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122507);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(122507);
        return rL;
    }

    /* Access modifiers changed, original: protected|final */
    public final C8235ad eby() {
        return this.BJh;
    }

    public final boolean eci() {
        return false;
    }

    /* renamed from: R */
    public final C46867w mo31384R(C46867w c46867w) {
        C41447az c41447az;
        AppMethodBeat.m2504i(122502);
        C25052j.m39376p(c46867w, "replacement");
        C41447az ekn = c46867w.ekn();
        C25052j.m39376p(ekn, "receiver$0");
        C24623g a = C17322a.m26830a(ekn);
        if (a != null) {
            c41447az = a;
        } else {
            c41447az = ekn.mo18032rK(false);
        }
        C46867w c46867w2 = c41447az;
        AppMethodBeat.m2505o(122502);
        return c46867w2;
    }

    /* renamed from: g */
    private C24623g m38302g(C0026g c0026g) {
        AppMethodBeat.m2504i(122503);
        C25052j.m39376p(c0026g, "newAnnotations");
        C24623g c24623g = new C24623g(this.BJh.mo18030d(c0026g));
        AppMethodBeat.m2505o(122503);
        return c24623g;
    }

    /* renamed from: rL */
    public final C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122506);
        C8235ad rL;
        if (z) {
            rL = this.BJh.mo18033rL(z);
            AppMethodBeat.m2505o(122506);
            return rL;
        }
        rL = this;
        AppMethodBeat.m2505o(122506);
        return rL;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122508);
        String str = this.BJh + "!!";
        AppMethodBeat.m2505o(122508);
        return str;
    }

    public final boolean ech() {
        AppMethodBeat.m2504i(122501);
        if ((this.BJh.ejw() instanceof C8231k) || (this.BJh.ejw().dYs() instanceof C36955ar)) {
            AppMethodBeat.m2505o(122501);
            return true;
        }
        AppMethodBeat.m2505o(122501);
        return false;
    }
}
