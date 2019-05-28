package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31824m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C0086q;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C0088r;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C25133aa.C25136a.C8152b;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31687ao;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c.C31689b;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37014ae.C36998b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;

/* renamed from: a.i.b.a.c.j.a.t */
public final class C31764t {
    public static final C31764t BHx = new C31764t();

    static {
        AppMethodBeat.m2504i(122305);
        AppMethodBeat.m2505o(122305);
    }

    private C31764t() {
    }

    /* renamed from: a */
    public static C8063a m51438a(C0086q c0086q) {
        C8063a c8063a;
        AppMethodBeat.m2504i(122299);
        if (c0086q != null) {
            switch (C44916u.eQZ[c0086q.ordinal()]) {
                case 1:
                    c8063a = C8063a.DECLARATION;
                    AppMethodBeat.m2505o(122299);
                    return c8063a;
                case 2:
                    c8063a = C8063a.FAKE_OVERRIDE;
                    AppMethodBeat.m2505o(122299);
                    return c8063a;
                case 3:
                    c8063a = C8063a.DELEGATION;
                    AppMethodBeat.m2505o(122299);
                    return c8063a;
                case 4:
                    c8063a = C8063a.SYNTHESIZED;
                    AppMethodBeat.m2505o(122299);
                    return c8063a;
            }
        }
        c8063a = C8063a.DECLARATION;
        AppMethodBeat.m2505o(122299);
        return c8063a;
    }

    /* renamed from: a */
    public static C44879w m51440a(C0088r c0088r) {
        C44879w c44879w;
        AppMethodBeat.m2504i(122300);
        if (c0088r != null) {
            switch (C44916u.pEv[c0088r.ordinal()]) {
                case 1:
                    c44879w = C44879w.FINAL;
                    AppMethodBeat.m2505o(122300);
                    return c44879w;
                case 2:
                    c44879w = C44879w.OPEN;
                    AppMethodBeat.m2505o(122300);
                    return c44879w;
                case 3:
                    c44879w = C44879w.ABSTRACT;
                    AppMethodBeat.m2505o(122300);
                    return c44879w;
                case 4:
                    c44879w = C44879w.SEALED;
                    AppMethodBeat.m2505o(122300);
                    return c44879w;
            }
        }
        c44879w = C44879w.FINAL;
        AppMethodBeat.m2505o(122300);
        return c44879w;
    }

    /* renamed from: a */
    public static C25082az m51437a(C31687ao c31687ao) {
        Object obj;
        AppMethodBeat.m2504i(122301);
        if (c31687ao != null) {
            switch (C44916u.BCf[c31687ao.ordinal()]) {
                case 1:
                    obj = C8051ay.BeZ;
                    break;
                case 2:
                    obj = C8051ay.BeW;
                    break;
                case 3:
                    obj = C8051ay.BeX;
                    break;
                case 4:
                    obj = C8051ay.BeY;
                    break;
                case 5:
                    obj = C8051ay.Bfa;
                    break;
                case 6:
                    obj = C8051ay.Bfb;
                    break;
            }
        }
        obj = C8051ay.BeW;
        C25052j.m39375o(obj, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
        AppMethodBeat.m2505o(122301);
        return obj;
    }

    /* renamed from: a */
    public static C36964f m51439a(C31689b c31689b) {
        C36964f c36964f;
        AppMethodBeat.m2504i(122302);
        if (c31689b != null) {
            switch (C44916u.BHy[c31689b.ordinal()]) {
                case 1:
                    c36964f = C36964f.CLASS;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
                case 2:
                    c36964f = C36964f.INTERFACE;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
                case 3:
                    c36964f = C36964f.ENUM_CLASS;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
                case 4:
                    c36964f = C36964f.ENUM_ENTRY;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
                case 5:
                    c36964f = C36964f.ANNOTATION_CLASS;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
                case 6:
                case 7:
                    c36964f = C36964f.OBJECT;
                    AppMethodBeat.m2505o(122302);
                    return c36964f;
            }
        }
        c36964f = C36964f.CLASS;
        AppMethodBeat.m2505o(122302);
        return c36964f;
    }

    /* renamed from: b */
    public static C0163ba m51442b(C36998b c36998b) {
        AppMethodBeat.m2504i(122303);
        C25052j.m39376p(c36998b, "variance");
        C0163ba c0163ba;
        switch (C44916u.BHA[c36998b.ordinal()]) {
            case 1:
                c0163ba = C0163ba.IN_VARIANCE;
                AppMethodBeat.m2505o(122303);
                return c0163ba;
            case 2:
                c0163ba = C0163ba.OUT_VARIANCE;
                AppMethodBeat.m2505o(122303);
                return c0163ba;
            case 3:
                c0163ba = C0163ba.INVARIANT;
                AppMethodBeat.m2505o(122303);
                return c0163ba;
            default:
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(122303);
                throw c31824m;
        }
    }

    /* renamed from: b */
    public static C0163ba m51441b(C8152b c8152b) {
        AppMethodBeat.m2504i(122304);
        C25052j.m39376p(c8152b, "projection");
        C0163ba c0163ba;
        switch (C44916u.BHB[c8152b.ordinal()]) {
            case 1:
                c0163ba = C0163ba.IN_VARIANCE;
                AppMethodBeat.m2505o(122304);
                return c0163ba;
            case 2:
                c0163ba = C0163ba.OUT_VARIANCE;
                AppMethodBeat.m2505o(122304);
                return c0163ba;
            case 3:
                c0163ba = C0163ba.INVARIANT;
                AppMethodBeat.m2505o(122304);
                return c0163ba;
            case 4:
                Throwable illegalArgumentException = new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: ".concat(String.valueOf(c8152b)));
                AppMethodBeat.m2505o(122304);
                throw illegalArgumentException;
            default:
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(122304);
                throw c31824m;
        }
    }
}
