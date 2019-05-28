package a.i.b.a.c.d.a;

import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.r;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.b;
import a.i.b.a.c.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o {
    public static final b Blj = new b("kotlin.jvm.JvmField");
    public static final a Blk = a.n(new b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    static {
        AppMethodBeat.i(119716);
        AppMethodBeat.o(119716);
    }

    public static boolean avH(String str) {
        AppMethodBeat.i(119710);
        if (str.startsWith("get") || str.startsWith("is")) {
            AppMethodBeat.o(119710);
            return true;
        }
        AppMethodBeat.o(119710);
        return false;
    }

    public static boolean avI(String str) {
        AppMethodBeat.i(119711);
        boolean startsWith = str.startsWith("set");
        AppMethodBeat.o(119711);
        return startsWith;
    }

    public static String avJ(String str) {
        AppMethodBeat.i(119712);
        if (avL(str)) {
            AppMethodBeat.o(119712);
            return str;
        }
        str = "get" + a.i.b.a.c.m.a.a.aws(str);
        AppMethodBeat.o(119712);
        return str;
    }

    public static String avK(String str) {
        AppMethodBeat.i(119713);
        String str2 = "set" + (avL(str) ? str.substring(2) : a.i.b.a.c.m.a.a.aws(str));
        AppMethodBeat.o(119713);
        return str2;
    }

    private static boolean avL(String str) {
        AppMethodBeat.i(119714);
        if (!str.startsWith("is")) {
            AppMethodBeat.o(119714);
            return false;
        } else if (str.length() == 2) {
            AppMethodBeat.o(119714);
            return false;
        } else {
            char charAt = str.charAt(2);
            if ('a' > charAt || charAt > 'z') {
                AppMethodBeat.o(119714);
                return true;
            }
            AppMethodBeat.o(119714);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(ah ahVar) {
        AppMethodBeat.i(119715);
        if (ahVar.dYZ() == a.i.b.a.c.b.b.a.FAKE_OVERRIDE) {
            AppMethodBeat.o(119715);
            return false;
        }
        Object obj;
        l dXW = ahVar.dXW();
        if (d.u(dXW) && d.B(dXW.dXW())) {
            e eVar = (e) dXW;
            a.i.b.a.c.a.d dVar = a.i.b.a.c.a.d.AZQ;
            if (!a.i.b.a.c.a.d.b(eVar)) {
                obj = 1;
                if (obj == null) {
                    AppMethodBeat.o(119715);
                    return true;
                }
                if (d.u(ahVar.dXW())) {
                    boolean z;
                    if (ahVar instanceof ah) {
                        r dZM = ahVar.dZM();
                        if (dZM != null && dZM.dYn().j(Blj)) {
                            z = true;
                            if (z) {
                                AppMethodBeat.o(119715);
                                return true;
                            }
                        }
                    }
                    z = ahVar.dYn().j(Blj);
                    if (z) {
                    }
                }
                AppMethodBeat.o(119715);
                return false;
            }
        }
        obj = null;
        if (obj == null) {
        }
    }
}
