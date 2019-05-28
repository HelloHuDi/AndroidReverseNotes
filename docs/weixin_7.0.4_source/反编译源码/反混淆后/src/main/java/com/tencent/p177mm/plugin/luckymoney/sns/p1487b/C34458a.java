package com.tencent.p177mm.plugin.luckymoney.sns.p1487b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.luckymoney.sns.b.a */
public final class C34458a {
    public static int bMi() {
        AppMethodBeat.m2504i(42551);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(42551);
        return intValue;
    }

    /* renamed from: xV */
    public static void m56484xV(int i) {
        AppMethodBeat.m2504i(42552);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(42552);
    }

    public static String bMj() {
        AppMethodBeat.m2504i(42553);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(42553);
        return str;
    }

    public static String bMk() {
        AppMethodBeat.m2504i(42554);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(42554);
        return str;
    }
}
