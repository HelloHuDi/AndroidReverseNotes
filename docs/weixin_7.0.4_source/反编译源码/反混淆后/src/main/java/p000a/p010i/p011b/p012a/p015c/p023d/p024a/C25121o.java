package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p016a.C0024d;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8079r;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p047m.p1360a.C31775a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.o */
public final class C25121o {
    public static final C8174b Blj = new C8174b("kotlin.jvm.JvmField");
    public static final C8173a Blk = C8173a.m14427n(new C8174b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    static {
        AppMethodBeat.m2504i(119716);
        AppMethodBeat.m2505o(119716);
    }

    public static boolean avH(String str) {
        AppMethodBeat.m2504i(119710);
        if (str.startsWith("get") || str.startsWith("is")) {
            AppMethodBeat.m2505o(119710);
            return true;
        }
        AppMethodBeat.m2505o(119710);
        return false;
    }

    public static boolean avI(String str) {
        AppMethodBeat.m2504i(119711);
        boolean startsWith = str.startsWith("set");
        AppMethodBeat.m2505o(119711);
        return startsWith;
    }

    public static String avJ(String str) {
        AppMethodBeat.m2504i(119712);
        if (C25121o.avL(str)) {
            AppMethodBeat.m2505o(119712);
            return str;
        }
        str = "get" + C31775a.aws(str);
        AppMethodBeat.m2505o(119712);
        return str;
    }

    public static String avK(String str) {
        AppMethodBeat.m2504i(119713);
        String str2 = "set" + (C25121o.avL(str) ? str.substring(2) : C31775a.aws(str));
        AppMethodBeat.m2505o(119713);
        return str2;
    }

    private static boolean avL(String str) {
        AppMethodBeat.m2504i(119714);
        if (!str.startsWith("is")) {
            AppMethodBeat.m2505o(119714);
            return false;
        } else if (str.length() == 2) {
            AppMethodBeat.m2505o(119714);
            return false;
        } else {
            char charAt = str.charAt(2);
            if ('a' > charAt || charAt > 'z') {
                AppMethodBeat.m2505o(119714);
                return true;
            }
            AppMethodBeat.m2505o(119714);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static boolean m39510d(C31220ah c31220ah) {
        AppMethodBeat.m2504i(119715);
        if (c31220ah.dYZ() == C8063a.FAKE_OVERRIDE) {
            AppMethodBeat.m2505o(119715);
            return false;
        }
        Object obj;
        C31642l dXW = c31220ah.dXW();
        if (C8203d.m14494u(dXW) && C8203d.m14467B(dXW.dXW())) {
            C46865e c46865e = (C46865e) dXW;
            C0024d c0024d = C0024d.AZQ;
            if (!C0024d.m24b(c46865e)) {
                obj = 1;
                if (obj == null) {
                    AppMethodBeat.m2505o(119715);
                    return true;
                }
                if (C8203d.m14494u(c31220ah.dXW())) {
                    boolean z;
                    if (c31220ah instanceof C31220ah) {
                        C8079r dZM = c31220ah.dZM();
                        if (dZM != null && dZM.dYn().mo55j(Blj)) {
                            z = true;
                            if (z) {
                                AppMethodBeat.m2505o(119715);
                                return true;
                            }
                        }
                    }
                    z = c31220ah.dYn().mo55j(Blj);
                    if (z) {
                    }
                }
                AppMethodBeat.m2505o(119715);
                return false;
            }
        }
        obj = null;
        if (obj == null) {
        }
    }
}
