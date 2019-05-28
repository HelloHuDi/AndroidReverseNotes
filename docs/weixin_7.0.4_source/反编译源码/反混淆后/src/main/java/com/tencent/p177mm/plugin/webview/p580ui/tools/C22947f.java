package com.tencent.p177mm.plugin.webview.p580ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.f */
public final class C22947f {
    public static boolean isEnabled() {
        String stringBuilder;
        AppMethodBeat.m2504i(7476);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 4) {
            try {
                stringBuilder2.append((char) ((int) ((1074974115182L >> ((3 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((C22947f.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(C22947f.m34829fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.m2505o(7476);
                    return false;
                }
                AppMethodBeat.m2505o(7476);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((C22947f.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(C22947f.m34829fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.m2505o(7476);
            return false;
        }
        AppMethodBeat.m2505o(7476);
        return true;
    }

    public static String cZD() {
        String fv;
        AppMethodBeat.m2504i(7477);
        StringBuilder stringBuilder = new StringBuilder(8);
        int i = 0;
        while (i < 3) {
            try {
                stringBuilder.append((char) ((int) ((1045787241 >> ((2 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                fv = C22947f.m34829fv(stringBuilder.toString(), "");
                AppMethodBeat.m2505o(7477);
                return fv;
            }
        }
        fv = C22947f.m34829fv(stringBuilder.toString(), "");
        AppMethodBeat.m2505o(7477);
        return fv;
    }

    public static boolean bXm() {
        String stringBuilder;
        AppMethodBeat.m2504i(7478);
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 5) {
            try {
                stringBuilder2.append((char) ((int) ((222416815156331L >> ((4 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((C22947f.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(C22947f.m34829fv(stringBuilder, stringBuilder2.toString()))) {
                    AppMethodBeat.m2505o(7478);
                    return false;
                }
                AppMethodBeat.m2505o(7478);
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((C22947f.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(C22947f.m34829fv(stringBuilder, stringBuilder2.toString()))) {
            AppMethodBeat.m2505o(7478);
            return false;
        }
        AppMethodBeat.m2505o(7478);
        return true;
    }

    /* renamed from: fv */
    private static String m34829fv(String str, String str2) {
        AppMethodBeat.m2504i(7479);
        try {
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100460");
            if (ll == null || !ll.isValid()) {
                C4990ab.m7420w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
                AppMethodBeat.m2505o(7479);
                return str2;
            }
            Map dru = ll.dru();
            if (dru == null) {
                C4990ab.m7420w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
                AppMethodBeat.m2505o(7479);
                return str2;
            }
            String str3 = (String) dru.get(str);
            if (str3 != null) {
                C4990ab.m7417i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", str, str3);
                AppMethodBeat.m2505o(7479);
                return str3;
            }
            AppMethodBeat.m2505o(7479);
            return str2;
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewHelper", th, "check point 1-1, explained by src code.", new Object[0]);
            AppMethodBeat.m2505o(7479);
            return str2;
        }
    }
}
