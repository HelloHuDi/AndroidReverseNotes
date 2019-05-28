package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.e */
public final class C43961e {
    private static final Map<Integer, Map<Integer, Object>> uDt = new HashMap();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.e$a */
    public enum C22977a {
        ;
        
        public static int uDA;
        public static int uDB;
        public static int uDC;
        public static int uDu;
        public static int uDv;
        public static int uDw;
        public static int uDx;
        public static int uDy;
        public static int uDz;

        static {
            uDu = 21;
            uDv = 22;
            uDw = 23;
            uDx = 24;
            uDy = 25;
            uDz = 26;
            uDA = 27;
            uDB = 28;
            uDC = 29;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.e$b */
    public enum C22978b {
        ;
        
        public static int uDE;
        public static int uDF;
        public static int uDG;
        public static int uDH;
        public static int uDI;
        public static int uDJ;

        static {
            uDE = 1000;
            uDF = 30;
            uDG = 31;
            uDH = 32;
            uDI = 33;
            uDJ = 34;
        }
    }

    static {
        AppMethodBeat.m2504i(8701);
        AppMethodBeat.m2505o(8701);
    }

    /* renamed from: x */
    public static void m78893x(String str, Map<Integer, Object> map) {
        AppMethodBeat.m2504i(8698);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8698);
            return;
        }
        uDt.put(Integer.valueOf(str.hashCode()), map);
        AppMethodBeat.m2505o(8698);
    }

    public static void agf(String str) {
        AppMethodBeat.m2504i(8699);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8699);
            return;
        }
        Map map = (Map) uDt.remove(Integer.valueOf(str.hashCode()));
        if (map == null || map.isEmpty()) {
            AppMethodBeat.m2505o(8699);
            return;
        }
        boolean booleanValue = ((Boolean) map.remove(Integer.valueOf(C22978b.uDE))).booleanValue();
        C4990ab.m7417i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", Boolean.valueOf(booleanValue), C43961e.m78892aI(map));
        C7060h.pYm.mo8376a(16142, r0, booleanValue, false);
        AppMethodBeat.m2505o(8699);
    }

    /* renamed from: aI */
    public static String m78892aI(Map<Integer, Object> map) {
        AppMethodBeat.m2504i(8700);
        String str;
        if (map == null || map.isEmpty()) {
            str = "";
            AppMethodBeat.m2505o(8700);
            return str;
        }
        int intValue = ((Integer) Collections.max(map.keySet())).intValue();
        intValue = Math.min(intValue, 200);
        StringBuffer stringBuffer = new StringBuffer();
        for (int intValue2 = ((Integer) Collections.min(map.keySet())).intValue(); intValue2 <= intValue; intValue2++) {
            Object obj = map.get(Integer.valueOf(intValue2));
            if (obj != null) {
                stringBuffer.append(obj);
            }
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(8700);
        return str;
    }
}
