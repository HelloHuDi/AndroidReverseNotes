package com.tencent.p177mm.p1179au;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.au.b */
public final class C17950b {
    private static Map<String, String> fHA = null;
    private static String fHB = null;
    private static Map<String, C17951a> fHz = null;

    /* renamed from: com.tencent.mm.au.b$a */
    public static class C17951a {
        public String fHC;
        public String fHD;
        public String fHE;
        public String fHF;
        public int fHG;

        public C17951a(String str, String str2, String str3, String str4, int i) {
            this.fHC = str;
            this.fHD = str2;
            this.fHE = str3;
            this.fHF = str4;
            this.fHG = i;
        }
    }

    public static boolean ahK() {
        AppMethodBeat.m2504i(59951);
        if (C4988aa.don() || C4988aa.dor().equals("en")) {
            AppMethodBeat.m2505o(59951);
            return false;
        }
        AppMethodBeat.m2505o(59951);
        return true;
    }

    public static boolean ahM() {
        AppMethodBeat.m2504i(59953);
        if (C1853r.m3845Yy() == 0 && C5046bo.m7558gT(C4996ah.getContext())) {
            AppMethodBeat.m2505o(59953);
            return false;
        }
        AppMethodBeat.m2505o(59953);
        return true;
    }

    public static boolean ahN() {
        return false;
    }

    public static boolean ahO() {
        AppMethodBeat.m2504i(59954);
        if (C4988aa.dor().equals("zh_CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.m2505o(59954);
                return true;
            }
            AppMethodBeat.m2505o(59954);
            return false;
        }
        AppMethodBeat.m2505o(59954);
        return true;
    }

    public static boolean ahP() {
        AppMethodBeat.m2504i(139034);
        boolean gT = C5046bo.m7558gT(C4996ah.getContext());
        AppMethodBeat.m2505o(139034);
        return gT;
    }

    /* renamed from: sL */
    private static void m28213sL(String str) {
        AppMethodBeat.m2504i(59956);
        fHz = new HashMap();
        fHA = new HashMap();
        String[] split = C5046bo.nullAsNil(str).trim().split(",");
        for (String trim : split) {
            String[] split2 = trim.trim().split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split2.length < 4) {
                C4990ab.m7413e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split2);
            } else {
                C17951a c17951a;
                if (C4988aa.dop()) {
                    c17951a = new C17951a(split2[0], split2[1], split2[2], split2[3], C17949a.m28208sK(split2[2]));
                } else {
                    c17951a = new C17951a(split2[0], split2[1], split2[2], split2[3], split2[3].charAt(0));
                }
                fHz.put(c17951a.fHC + c17951a.fHD, c17951a);
                fHA.put(c17951a.fHC, c17951a.fHD);
            }
        }
        AppMethodBeat.m2505o(59956);
    }

    /* renamed from: k */
    public static C17951a m28210k(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(59957);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null || fHA == null) {
            fHB = str3;
            C17950b.m28213sL(str2);
        }
        C17951a c17951a = (C17951a) fHz.get(str.toUpperCase() + ((String) fHA.get(str.toUpperCase())));
        AppMethodBeat.m2505o(59957);
        return c17951a;
    }

    /* renamed from: G */
    public static List<C17951a> m28209G(Context context, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(59958);
        try {
            str2 = context.getResources().getConfiguration().locale.getLanguage();
            if (str2 == null || !str2.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str2;
            C17950b.m28213sL(str);
        }
        ArrayList arrayList = new ArrayList(fHz.values());
        AppMethodBeat.m2505o(59958);
        return arrayList;
    }

    /* renamed from: sM */
    public static boolean m28214sM(String str) {
        AppMethodBeat.m2504i(59959);
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            AppMethodBeat.m2505o(59959);
            return false;
        }
        AppMethodBeat.m2505o(59959);
        return true;
    }

    /* renamed from: sN */
    public static String m28215sN(String str) {
        AppMethodBeat.m2504i(59960);
        String str2;
        if (str.startsWith("+886") || str.startsWith("+86")) {
            str2 = "zh-TW";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+852") || str.startsWith("+853")) {
            str2 = "zh-HK";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+81")) {
            str2 = "ja";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+82")) {
            str2 = "ko";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+66")) {
            str2 = "th";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+84")) {
            str2 = "vi";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+62")) {
            str2 = "id";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+55")) {
            str2 = "pt";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else if (str.startsWith("+34")) {
            str2 = "es-419";
            AppMethodBeat.m2505o(59960);
            return str2;
        } else {
            str2 = "en";
            AppMethodBeat.m2505o(59960);
            return str2;
        }
    }

    /* renamed from: l */
    public static String m28211l(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(59961);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str3;
            C17950b.m28213sL(str2);
        }
        for (C17951a c17951a : fHz.values()) {
            if (c17951a.fHD.equals(str)) {
                str3 = c17951a.fHE;
                AppMethodBeat.m2505o(59961);
                return str3;
            }
        }
        str3 = "";
        AppMethodBeat.m2505o(59961);
        return str3;
    }

    /* renamed from: m */
    public static String m28212m(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(59962);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str3;
            C17950b.m28213sL(str2);
        }
        for (C17951a c17951a : fHz.values()) {
            if (c17951a.fHD.equals(str)) {
                str3 = c17951a.fHC;
                AppMethodBeat.m2505o(59962);
                return str3;
            }
        }
        str3 = "";
        AppMethodBeat.m2505o(59962);
        return str3;
    }

    /* renamed from: sO */
    public static boolean m28216sO(String str) {
        AppMethodBeat.m2504i(59963);
        if (C5046bo.isNullOrNil(str) || !new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(str.toUpperCase())) {
            AppMethodBeat.m2505o(59963);
            return false;
        }
        AppMethodBeat.m2505o(59963);
        return true;
    }

    /* renamed from: sP */
    public static boolean m28217sP(String str) {
        AppMethodBeat.m2504i(59964);
        if (C5046bo.isNullOrNil(str) || !new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(str)) {
            AppMethodBeat.m2505o(59964);
            return false;
        }
        AppMethodBeat.m2505o(59964);
        return true;
    }

    public static boolean ahL() {
        AppMethodBeat.m2504i(59952);
        boolean gT = C5046bo.m7558gT(C4996ah.getContext());
        AppMethodBeat.m2505o(59952);
        return gT;
    }
}
