package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class f {
    public static boolean isEnabled() {
        String stringBuilder;
        AppMethodBeat.i(7476);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 4) {
            try {
                stringBuilder2.append((char) ((int) ((1074974115182L >> ((3 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((f.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.o(7476);
                    return false;
                }
                AppMethodBeat.o(7476);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((f.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.o(7476);
            return false;
        }
        AppMethodBeat.o(7476);
        return true;
    }

    public static String cZD() {
        String fv;
        AppMethodBeat.i(7477);
        StringBuilder stringBuilder = new StringBuilder(8);
        int i = 0;
        while (i < 3) {
            try {
                stringBuilder.append((char) ((int) ((1045787241 >> ((2 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                fv = fv(stringBuilder.toString(), "");
                AppMethodBeat.o(7477);
                return fv;
            }
        }
        fv = fv(stringBuilder.toString(), "");
        AppMethodBeat.o(7477);
        return fv;
    }

    public static boolean bXm() {
        String stringBuilder;
        AppMethodBeat.i(7478);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 5) {
            try {
                stringBuilder2.append((char) ((int) ((222416815156331L >> ((4 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((f.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.o(7478);
                    return false;
                }
                AppMethodBeat.o(7478);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((f.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.o(7478);
            return false;
        }
        AppMethodBeat.o(7478);
        return true;
    }

    private static String fv(String str, String str2) {
        AppMethodBeat.i(7479);
        try {
            a aVar = b.eGM;
            c ll = a.ll("100460");
            if (ll == null || !ll.isValid()) {
                ab.w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
                AppMethodBeat.o(7479);
                return str2;
            }
            Map dru = ll.dru();
            if (dru == null) {
                ab.w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
                AppMethodBeat.o(7479);
                return str2;
            }
            String str3 = (String) dru.get(str);
            if (str3 != null) {
                ab.i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", str, str3);
                AppMethodBeat.o(7479);
                return str3;
            }
            AppMethodBeat.o(7479);
            return str2;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.WebViewHelper", th, "check point 1-1, explained by src code.", new Object[0]);
            AppMethodBeat.o(7479);
            return str2;
        }
    }
}
