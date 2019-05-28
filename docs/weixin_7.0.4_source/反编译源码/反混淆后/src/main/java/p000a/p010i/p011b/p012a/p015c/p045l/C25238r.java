package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31824m;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p036h.C0125i;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8229c;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.l.r */
public final class C25238r extends C17325q implements C17321f {
    public static boolean BJA;
    public static final C0165a BJB = new C0165a();
    private boolean BJz;

    /* renamed from: a.i.b.a.c.l.r$a */
    public static final class C0165a {
        private C0165a() {
        }

        public /* synthetic */ C0165a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(122585);
        AppMethodBeat.m2505o(122585);
    }

    public C25238r(C8235ad c8235ad, C8235ad c8235ad2) {
        C25052j.m39376p(c8235ad, "lowerBound");
        C25052j.m39376p(c8235ad2, "upperBound");
        super(c8235ad, c8235ad2);
        AppMethodBeat.m2504i(122584);
        AppMethodBeat.m2505o(122584);
    }

    /* renamed from: R */
    public final C46867w mo31384R(C46867w c46867w) {
        C41447az c41447az;
        AppMethodBeat.m2504i(122580);
        C25052j.m39376p(c46867w, "replacement");
        C41447az ekn = c46867w.ekn();
        if (ekn instanceof C17325q) {
            c41447az = ekn;
        } else if (ekn instanceof C8235ad) {
            c41447az = C17326x.m26839a((C8235ad) ekn, ((C8235ad) ekn).mo18033rL(true));
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122580);
            throw c31824m;
        }
        C46867w a = C25231ax.m39778a(c41447az, ekn);
        AppMethodBeat.m2505o(122580);
        return a;
    }

    /* renamed from: a */
    public final String mo31390a(C31724c c31724c, C0125i c0125i) {
        AppMethodBeat.m2504i(122582);
        C25052j.m39376p(c31724c, "renderer");
        C25052j.m39376p(c0125i, "options");
        String str;
        if (c0125i.eiS()) {
            str = "(" + c31724c.mo13665b(this.BJx) + ".." + c31724c.mo13665b(this.BJy) + ')';
            AppMethodBeat.m2505o(122582);
            return str;
        }
        str = c31724c.mo13663a(c31724c.mo13665b(this.BJx), c31724c.mo13665b(this.BJy), C41448a.m72314aL(this));
        AppMethodBeat.m2505o(122582);
        return str;
    }

    public final C8235ad eby() {
        boolean z = true;
        AppMethodBeat.m2504i(122578);
        if (BJA && !this.BJz) {
            boolean z2;
            this.BJz = true;
            if (C44924t.m82160ai(this.BJx)) {
                z2 = false;
            } else {
                z2 = true;
            }
            Throwable assertionError;
            if (!C44847aa.AUz || z2) {
                if (C44924t.m82160ai(this.BJy)) {
                    z = false;
                }
                if (!C44847aa.AUz || z) {
                    int j = C25052j.m39373j(this.BJx, this.BJy) ^ 1;
                    if (C44847aa.AUz && j == 0) {
                        assertionError = new AssertionError("Lower and upper bounds are equal: " + this.BJx + " == " + this.BJy);
                        AppMethodBeat.m2505o(122578);
                        throw assertionError;
                    }
                    z2 = C8229c.BKs.mo18024c(this.BJx, this.BJy);
                    if (C44847aa.AUz && !z2) {
                        assertionError = new AssertionError("Lower bound " + this.BJx + " of a flexible type must be a subtype of the upper bound " + this.BJy);
                        AppMethodBeat.m2505o(122578);
                        throw assertionError;
                    }
                }
                assertionError = new AssertionError("Upper bound of a flexible type can not be flexible: " + this.BJy);
                AppMethodBeat.m2505o(122578);
                throw assertionError;
            }
            assertionError = new AssertionError("Lower bound of a flexible type can not be flexible: " + this.BJx);
            AppMethodBeat.m2505o(122578);
            throw assertionError;
        }
        C8235ad c8235ad = this.BJx;
        AppMethodBeat.m2505o(122578);
        return c8235ad;
    }

    public final boolean ech() {
        AppMethodBeat.m2504i(122579);
        if ((this.BJx.ejw().dYs() instanceof C36955ar) && C25052j.m39373j(this.BJx.ejw(), this.BJy.ejw())) {
            AppMethodBeat.m2505o(122579);
            return true;
        }
        AppMethodBeat.m2505o(122579);
        return false;
    }

    /* renamed from: b */
    public final C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122581);
        C25052j.m39376p(c0026g, "newAnnotations");
        C41447az a = C17326x.m26839a(this.BJx.mo18030d(c0026g), this.BJy.mo18030d(c0026g));
        AppMethodBeat.m2505o(122581);
        return a;
    }

    /* renamed from: rK */
    public final C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122583);
        C41447az a = C17326x.m26839a(this.BJx.mo18033rL(z), this.BJy.mo18033rL(z));
        AppMethodBeat.m2505o(122583);
        return a;
    }
}
