package com.tencent.p177mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.b */
public final class C40147b {
    /* renamed from: aK */
    public static void m68846aK(JSONObject jSONObject) {
        AppMethodBeat.m2504i(48007);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            AppMethodBeat.m2505o(48007);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        int optInt = jSONObject.optInt("is_open_sns_pay", 0);
        int optInt2 = jSONObject.optInt("can_open_sns_pay", 0);
        int optInt3 = jSONObject.optInt("is_white_user", 0);
        if (optInt2 == 1) {
            str = jSONObject.optString("open_sns_pay_title");
            str2 = jSONObject.optString("open_sns_pay_wording");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_TITLE_STRING_SYNC, (Object) str);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_WORDING_STRING_SYNC, (Object) str2);
        }
        C4990ab.m7416i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        C4990ab.m7416i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str + ", open_sns_pay_wording:" + str2);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_CAN_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt2));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_IS_WHITE_USER_INT_SYNC, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str = jSONObject.optString("set_sns_pay_title");
            str2 = jSONObject.optString("set_sns_pay_wording");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, (Object) str);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, (Object) str2);
        } else {
            str2 = str4;
            str = str3;
        }
        C4990ab.m7416i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str + ", set_sns_pay_wording:" + str2);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(48007);
    }
}
