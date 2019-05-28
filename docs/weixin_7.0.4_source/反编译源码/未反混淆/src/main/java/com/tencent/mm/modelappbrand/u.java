package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.Map;

public final class u {
    private static Map<String, Long> fpN = new HashMap();
    private static Map<String, Long> fpO = new HashMap();
    private static Map<String, Long> fpP = new HashMap();
    private static Map<String, Long> fpQ = new HashMap();
    private static Map<String, a> fpR = new HashMap();

    public static final class a {
        public String csB;
        public int fmr;
        public String fpS;
        public int fpT;
        public boolean fpU;
    }

    static {
        AppMethodBeat.i(70641);
        AppMethodBeat.o(70641);
    }

    public static void pp(String str) {
        AppMethodBeat.i(70630);
        a aVar = (a) fpR.get(str);
        if (aVar != null) {
            if (aVar.fpU) {
                i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
                AppMethodBeat.o(70630);
                return;
            }
            aVar.fpU = true;
        }
        v.kT(20);
        ad eZ = new ad().eZ(pr(str));
        eZ.cYw = (long) pq(str);
        eZ.cYs = 12;
        eZ.cYu = 1;
        eZ = eZ.eY(str);
        eZ.cYt = System.currentTimeMillis();
        eZ.fa(at.gB(ah.getContext())).ajK();
        AppMethodBeat.o(70630);
    }

    public static void a(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(70631);
        a aVar = (a) fpR.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.csB = str2;
        aVar.fmr = i;
        aVar.fpT = i2;
        aVar.fpS = str3;
        fpR.put(str, aVar);
        AppMethodBeat.o(70631);
    }

    public static int pq(String str) {
        AppMethodBeat.i(70632);
        a aVar = (a) fpR.get(str);
        if (aVar != null) {
            int i = aVar.fmr;
            AppMethodBeat.o(70632);
            return i;
        }
        AppMethodBeat.o(70632);
        return 0;
    }

    public static String pr(String str) {
        AppMethodBeat.i(70633);
        a aVar = (a) fpR.get(str);
        if (aVar != null) {
            str = aVar.fpS;
            AppMethodBeat.o(70633);
            return str;
        }
        AppMethodBeat.o(70633);
        return str;
    }

    public static int pt(String str) {
        AppMethodBeat.i(70634);
        a aVar = (a) fpR.get(str);
        if (aVar != null) {
            int i = aVar.fpT;
            AppMethodBeat.o(70634);
            return i;
        }
        AppMethodBeat.o(70634);
        return 0;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70635);
        ab.i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(70635);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70636);
        ab.i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(70636);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70637);
        ab.e("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(70637);
    }

    public static void pu(String str) {
        AppMethodBeat.i(70638);
        ab.i("SearchWidgetStartTrace", "realInsert %s", str);
        AppMethodBeat.o(70638);
    }

    public static void B(String str, boolean z) {
        AppMethodBeat.i(70639);
        ab.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", str, Boolean.valueOf(z));
        if (z) {
            if ((fpN.containsKey(str) ? ((Long) fpN.get(str)).longValue() : 0) > 0) {
                System.currentTimeMillis();
                AppMethodBeat.o(70639);
                return;
            }
            ab.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", str);
        }
        AppMethodBeat.o(70639);
    }

    public static void abL() {
        AppMethodBeat.i(70640);
        ab.i("SearchWidgetStartTrace", "hasInitData %s", Boolean.TRUE);
        AppMethodBeat.o(70640);
    }
}
