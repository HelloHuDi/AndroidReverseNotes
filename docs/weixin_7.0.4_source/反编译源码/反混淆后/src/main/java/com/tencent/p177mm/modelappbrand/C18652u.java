package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.modelappbrand.u */
public final class C18652u {
    private static Map<String, Long> fpN = new HashMap();
    private static Map<String, Long> fpO = new HashMap();
    private static Map<String, Long> fpP = new HashMap();
    private static Map<String, Long> fpQ = new HashMap();
    private static Map<String, C18653a> fpR = new HashMap();

    /* renamed from: com.tencent.mm.modelappbrand.u$a */
    public static final class C18653a {
        public String csB;
        public int fmr;
        public String fpS;
        public int fpT;
        public boolean fpU;
    }

    static {
        AppMethodBeat.m2504i(70641);
        AppMethodBeat.m2505o(70641);
    }

    /* renamed from: pp */
    public static void m29152pp(String str) {
        AppMethodBeat.m2504i(70630);
        C18653a c18653a = (C18653a) fpR.get(str);
        if (c18653a != null) {
            if (c18653a.fpU) {
                C18652u.m29151i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
                AppMethodBeat.m2505o(70630);
                return;
            }
            c18653a.fpU = true;
        }
        C26439v.m42099kT(20);
        C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(str));
        eZ.cYw = (long) C18652u.m29153pq(str);
        eZ.cYs = 12;
        eZ.cYu = 1;
        eZ = eZ.mo43950eY(str);
        eZ.cYt = System.currentTimeMillis();
        eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
        AppMethodBeat.m2505o(70630);
    }

    /* renamed from: a */
    public static void m29149a(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(70631);
        C18653a c18653a = (C18653a) fpR.get(str);
        if (c18653a == null) {
            c18653a = new C18653a();
        }
        c18653a.csB = str2;
        c18653a.fmr = i;
        c18653a.fpT = i2;
        c18653a.fpS = str3;
        fpR.put(str, c18653a);
        AppMethodBeat.m2505o(70631);
    }

    /* renamed from: pq */
    public static int m29153pq(String str) {
        AppMethodBeat.m2504i(70632);
        C18653a c18653a = (C18653a) fpR.get(str);
        if (c18653a != null) {
            int i = c18653a.fmr;
            AppMethodBeat.m2505o(70632);
            return i;
        }
        AppMethodBeat.m2505o(70632);
        return 0;
    }

    /* renamed from: pr */
    public static String m29154pr(String str) {
        AppMethodBeat.m2504i(70633);
        C18653a c18653a = (C18653a) fpR.get(str);
        if (c18653a != null) {
            str = c18653a.fpS;
            AppMethodBeat.m2505o(70633);
            return str;
        }
        AppMethodBeat.m2505o(70633);
        return str;
    }

    /* renamed from: pt */
    public static int m29155pt(String str) {
        AppMethodBeat.m2504i(70634);
        C18653a c18653a = (C18653a) fpR.get(str);
        if (c18653a != null) {
            int i = c18653a.fpT;
            AppMethodBeat.m2505o(70634);
            return i;
        }
        AppMethodBeat.m2505o(70634);
        return 0;
    }

    /* renamed from: v */
    public static void m29157v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70635);
        C4990ab.m7417i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.m2505o(70635);
    }

    /* renamed from: i */
    public static void m29151i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70636);
        C4990ab.m7417i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.m2505o(70636);
    }

    /* renamed from: e */
    public static void m29150e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70637);
        C4990ab.m7413e("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.m2505o(70637);
    }

    /* renamed from: pu */
    public static void m29156pu(String str) {
        AppMethodBeat.m2504i(70638);
        C4990ab.m7417i("SearchWidgetStartTrace", "realInsert %s", str);
        AppMethodBeat.m2505o(70638);
    }

    /* renamed from: B */
    public static void m29148B(String str, boolean z) {
        AppMethodBeat.m2504i(70639);
        C4990ab.m7417i("SearchWidgetStartTrace", "drawEnd %s,succ %s", str, Boolean.valueOf(z));
        if (z) {
            if ((fpN.containsKey(str) ? ((Long) fpN.get(str)).longValue() : 0) > 0) {
                System.currentTimeMillis();
                AppMethodBeat.m2505o(70639);
                return;
            }
            C4990ab.m7413e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", str);
        }
        AppMethodBeat.m2505o(70639);
    }

    public static void abL() {
        AppMethodBeat.m2504i(70640);
        C4990ab.m7417i("SearchWidgetStartTrace", "hasInitData %s", Boolean.TRUE);
        AppMethodBeat.m2505o(70640);
    }
}
