package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static final Map<Integer, Map<Integer, Object>> uDt = new HashMap();

    public enum a {
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

    public enum b {
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
        AppMethodBeat.i(8701);
        AppMethodBeat.o(8701);
    }

    public static void x(String str, Map<Integer, Object> map) {
        AppMethodBeat.i(8698);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8698);
            return;
        }
        uDt.put(Integer.valueOf(str.hashCode()), map);
        AppMethodBeat.o(8698);
    }

    public static void agf(String str) {
        AppMethodBeat.i(8699);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8699);
            return;
        }
        Map map = (Map) uDt.remove(Integer.valueOf(str.hashCode()));
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(8699);
            return;
        }
        boolean booleanValue = ((Boolean) map.remove(Integer.valueOf(b.uDE))).booleanValue();
        ab.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", Boolean.valueOf(booleanValue), aI(map));
        h.pYm.a(16142, r0, booleanValue, false);
        AppMethodBeat.o(8699);
    }

    public static String aI(Map<Integer, Object> map) {
        AppMethodBeat.i(8700);
        String str;
        if (map == null || map.isEmpty()) {
            str = "";
            AppMethodBeat.o(8700);
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
        AppMethodBeat.o(8700);
        return str;
    }
}
