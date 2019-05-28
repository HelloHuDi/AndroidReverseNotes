package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static boolean dOm() {
        String stringBuilder;
        AppMethodBeat.i(49164);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57497235128533601L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.o(49164);
                    return false;
                }
                AppMethodBeat.o(49164);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.o(49164);
            return false;
        }
        AppMethodBeat.o(49164);
        return true;
    }

    public static boolean dOn() {
        String stringBuilder;
        AppMethodBeat.i(49165);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57778710156427883L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.o(49165);
                    return false;
                }
                AppMethodBeat.o(49165);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.o(49165);
            return false;
        }
        AppMethodBeat.o(49165);
        return true;
    }

    public static boolean dOo() {
        String stringBuilder;
        AppMethodBeat.i(49166);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((65941484396629365L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.o(49166);
                    return false;
                }
                AppMethodBeat.o(49166);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.o(49166);
            return false;
        }
        AppMethodBeat.o(49166);
        return true;
    }

    private static String fv(String str, String str2) {
        AppMethodBeat.i(49167);
        c ll = com.tencent.mm.model.c.c.abi().ll("100327");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                ab.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
                AppMethodBeat.o(49167);
                return str2;
            }
            String str3 = (String) dru.get(str);
            if (str3 == null || str3.length() <= 0) {
                AppMethodBeat.o(49167);
                return str2;
            }
            AppMethodBeat.o(49167);
            return str3;
        }
        ab.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
        AppMethodBeat.o(49167);
        return str2;
    }
}
