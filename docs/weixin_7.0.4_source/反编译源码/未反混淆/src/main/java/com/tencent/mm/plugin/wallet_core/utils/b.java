package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import org.json.JSONObject;

public final class b {
    public static void aK(JSONObject jSONObject) {
        AppMethodBeat.i(48007);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            AppMethodBeat.o(48007);
            return;
        }
        ab.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
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
            g.RQ();
            g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_TITLE_STRING_SYNC, (Object) str);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_WORDING_STRING_SYNC, (Object) str2);
        }
        ab.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        ab.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str + ", open_sns_pay_wording:" + str2);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_CAN_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt2));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_IS_WHITE_USER_INT_SYNC, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str = jSONObject.optString("set_sns_pay_title");
            str2 = jSONObject.optString("set_sns_pay_wording");
            g.RQ();
            g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, (Object) str);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, (Object) str2);
        } else {
            str2 = str4;
            str = str3;
        }
        ab.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str + ", set_sns_pay_wording:" + str2);
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(48007);
    }
}
