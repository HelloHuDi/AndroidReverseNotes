package com.tencent.mm.au;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, String> fHA = null;
    private static String fHB = null;
    private static Map<String, a> fHz = null;

    public static class a {
        public String fHC;
        public String fHD;
        public String fHE;
        public String fHF;
        public int fHG;

        public a(String str, String str2, String str3, String str4, int i) {
            this.fHC = str;
            this.fHD = str2;
            this.fHE = str3;
            this.fHF = str4;
            this.fHG = i;
        }
    }

    public static boolean ahK() {
        AppMethodBeat.i(59951);
        if (aa.don() || aa.dor().equals("en")) {
            AppMethodBeat.o(59951);
            return false;
        }
        AppMethodBeat.o(59951);
        return true;
    }

    public static boolean ahM() {
        AppMethodBeat.i(59953);
        if (r.Yy() == 0 && bo.gT(ah.getContext())) {
            AppMethodBeat.o(59953);
            return false;
        }
        AppMethodBeat.o(59953);
        return true;
    }

    public static boolean ahN() {
        return false;
    }

    public static boolean ahO() {
        AppMethodBeat.i(59954);
        if (aa.dor().equals("zh_CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.o(59954);
                return true;
            }
            AppMethodBeat.o(59954);
            return false;
        }
        AppMethodBeat.o(59954);
        return true;
    }

    public static boolean ahP() {
        AppMethodBeat.i(139034);
        boolean gT = bo.gT(ah.getContext());
        AppMethodBeat.o(139034);
        return gT;
    }

    private static void sL(String str) {
        AppMethodBeat.i(59956);
        fHz = new HashMap();
        fHA = new HashMap();
        String[] split = bo.nullAsNil(str).trim().split(",");
        for (String trim : split) {
            String[] split2 = trim.trim().split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split2.length < 4) {
                ab.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split2);
            } else {
                a aVar;
                if (aa.dop()) {
                    aVar = new a(split2[0], split2[1], split2[2], split2[3], a.sK(split2[2]));
                } else {
                    aVar = new a(split2[0], split2[1], split2[2], split2[3], split2[3].charAt(0));
                }
                fHz.put(aVar.fHC + aVar.fHD, aVar);
                fHA.put(aVar.fHC, aVar.fHD);
            }
        }
        AppMethodBeat.o(59956);
    }

    public static a k(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(59957);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null || fHA == null) {
            fHB = str3;
            sL(str2);
        }
        a aVar = (a) fHz.get(str.toUpperCase() + ((String) fHA.get(str.toUpperCase())));
        AppMethodBeat.o(59957);
        return aVar;
    }

    public static List<a> G(Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(59958);
        try {
            str2 = context.getResources().getConfiguration().locale.getLanguage();
            if (str2 == null || !str2.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str2;
            sL(str);
        }
        ArrayList arrayList = new ArrayList(fHz.values());
        AppMethodBeat.o(59958);
        return arrayList;
    }

    public static boolean sM(String str) {
        AppMethodBeat.i(59959);
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            AppMethodBeat.o(59959);
            return false;
        }
        AppMethodBeat.o(59959);
        return true;
    }

    public static String sN(String str) {
        AppMethodBeat.i(59960);
        String str2;
        if (str.startsWith("+886") || str.startsWith("+86")) {
            str2 = "zh-TW";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+852") || str.startsWith("+853")) {
            str2 = "zh-HK";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+81")) {
            str2 = "ja";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+82")) {
            str2 = "ko";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+66")) {
            str2 = "th";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+84")) {
            str2 = "vi";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+62")) {
            str2 = "id";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+55")) {
            str2 = "pt";
            AppMethodBeat.o(59960);
            return str2;
        } else if (str.startsWith("+34")) {
            str2 = "es-419";
            AppMethodBeat.o(59960);
            return str2;
        } else {
            str2 = "en";
            AppMethodBeat.o(59960);
            return str2;
        }
    }

    public static String l(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(59961);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str3;
            sL(str2);
        }
        for (a aVar : fHz.values()) {
            if (aVar.fHD.equals(str)) {
                str3 = aVar.fHE;
                AppMethodBeat.o(59961);
                return str3;
            }
        }
        str3 = "";
        AppMethodBeat.o(59961);
        return str3;
    }

    public static String m(Context context, String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(59962);
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(fHB)) {
                fHz = null;
            }
        } catch (Exception e) {
        }
        if (fHz == null) {
            fHB = str3;
            sL(str2);
        }
        for (a aVar : fHz.values()) {
            if (aVar.fHD.equals(str)) {
                str3 = aVar.fHC;
                AppMethodBeat.o(59962);
                return str3;
            }
        }
        str3 = "";
        AppMethodBeat.o(59962);
        return str3;
    }

    public static boolean sO(String str) {
        AppMethodBeat.i(59963);
        if (bo.isNullOrNil(str) || !new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(str.toUpperCase())) {
            AppMethodBeat.o(59963);
            return false;
        }
        AppMethodBeat.o(59963);
        return true;
    }

    public static boolean sP(String str) {
        AppMethodBeat.i(59964);
        if (bo.isNullOrNil(str) || !new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(str)) {
            AppMethodBeat.o(59964);
            return false;
        }
        AppMethodBeat.o(59964);
        return true;
    }

    public static boolean ahL() {
        AppMethodBeat.i(59952);
        boolean gT = bo.gT(ah.getContext());
        AppMethodBeat.o(59952);
        return gT;
    }
}
