package com.tencent.p177mm.wallet_core.p1576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;

/* renamed from: com.tencent.mm.wallet_core.f.b */
public final class C40941b {
    public static boolean dOm() {
        String stringBuilder;
        AppMethodBeat.m2504i(49164);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57497235128533601L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.m2505o(49164);
                    return false;
                }
                AppMethodBeat.m2505o(49164);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.m2505o(49164);
            return false;
        }
        AppMethodBeat.m2505o(49164);
        return true;
    }

    public static boolean dOn() {
        String stringBuilder;
        AppMethodBeat.m2504i(49165);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57778710156427883L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.m2505o(49165);
                    return false;
                }
                AppMethodBeat.m2505o(49165);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.m2505o(49165);
            return false;
        }
        AppMethodBeat.m2505o(49165);
        return true;
    }

    public static boolean dOo() {
        String stringBuilder;
        AppMethodBeat.m2504i(49166);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((65941484396629365L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.m2505o(49166);
                    return false;
                }
                AppMethodBeat.m2505o(49166);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((C40941b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(C40941b.m70998fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.m2505o(49166);
            return false;
        }
        AppMethodBeat.m2505o(49166);
        return true;
    }

    /* renamed from: fv */
    private static String m70998fv(String str, String str2) {
        AppMethodBeat.m2504i(49167);
        C5141c ll = C18624c.abi().mo17131ll("100327");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                C4990ab.m7420w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
                AppMethodBeat.m2505o(49167);
                return str2;
            }
            String str3 = (String) dru.get(str);
            if (str3 == null || str3.length() <= 0) {
                AppMethodBeat.m2505o(49167);
                return str2;
            }
            AppMethodBeat.m2505o(49167);
            return str3;
        }
        C4990ab.m7420w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
        AppMethodBeat.m2505o(49167);
        return str2;
    }
}
