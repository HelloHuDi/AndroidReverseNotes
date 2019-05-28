package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class h {
    public static boolean a(Context context, Bundle bundle, boolean z, String str) {
        AppMethodBeat.i(135776);
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (!bo.isNullOrNil(str)) {
            intent.putExtra(ConstantsAPI.APP_PACKAGE, str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d.b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        AppMethodBeat.o(135776);
        return true;
    }

    public static boolean a(MMActivity mMActivity, g gVar, int i, a aVar) {
        AppMethodBeat.i(135777);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.cId);
        intent.putExtra("cookie", gVar.flp);
        intent.putExtra("url", gVar.url);
        intent.putExtra("bizUsername", gVar.cIe);
        intent.putExtra("pay_channel", gVar.cvS);
        intent.putExtra("pay_for_wallet_type", gVar.vwu);
        intent.putExtra("pay_scene", gVar.cIf);
        intent.putExtra("result_jump_mode", gVar.vww);
        intent.putExtra("ext_info", gVar.extInfo);
        intent.putExtra("key_wx_app_scene", gVar.vwt);
        intent.putExtra("intent_app_brand_from_path", gVar.vwx);
        intent.putExtra("intent_app_brand_from_username", gVar.vwy);
        intent.putExtra("intent_app_brand_from_scene", gVar.vwz);
        if (aVar != null) {
            mMActivity.ifE = aVar;
        }
        ab.i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", mMActivity, bo.dpG());
        d.a((Context) mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i, false);
        AppMethodBeat.o(135777);
        return true;
    }

    public static void ai(Context context, int i) {
        AppMethodBeat.i(135778);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", i);
        d.b(context, "collect", ".ui.CollectAdapterUI", intent);
        AppMethodBeat.o(135778);
    }

    public static boolean a(Context context, String str, String str2, int i, int i2) {
        AppMethodBeat.i(135779);
        boolean b = b(context, str, str2, i, i2);
        AppMethodBeat.o(135779);
        return b;
    }

    private static boolean b(Context context, String str, String str2, int i, int i2) {
        AppMethodBeat.i(135780);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(135780);
            return false;
        }
        boolean a = a(context, N(str, str2, i), i2);
        AppMethodBeat.o(135780);
        return a;
    }

    public static PayInfo N(String str, String str2, int i) {
        AppMethodBeat.i(135781);
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = str;
        payInfo.appId = str2;
        payInfo.tRb = null;
        payInfo.cIf = i;
        payInfo.aIm = null;
        payInfo.cIb = 0;
        AppMethodBeat.o(135781);
        return payInfo;
    }

    public static boolean a(Context context, PayInfo payInfo, int i) {
        AppMethodBeat.i(135782);
        boolean a = a(context, false, "", payInfo, i);
        AppMethodBeat.o(135782);
        return a;
    }

    private static boolean a(Context context, boolean z, String str, PayInfo payInfo, int i) {
        AppMethodBeat.i(135783);
        boolean b = b(context, z, str, payInfo, i);
        AppMethodBeat.o(135783);
        return b;
    }

    private static boolean b(Context context, boolean z, String str, PayInfo payInfo, int i) {
        AppMethodBeat.i(135784);
        boolean a = a(context, z, str, payInfo, null, new Intent(), i);
        AppMethodBeat.o(135784);
        return a;
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i) {
        AppMethodBeat.i(135785);
        boolean a = a(context, z, str, "", payInfo, str2, intent, i);
        AppMethodBeat.o(135785);
        return a;
    }

    public static boolean a(Context context, boolean z, String str, String str2, PayInfo payInfo, String str3, Intent intent, int i) {
        AppMethodBeat.i(135786);
        if (2 == payInfo.cIf || 1 == payInfo.cIf || 4 == payInfo.cIf || 36 == payInfo.cIf) {
            payInfo.mXg = false;
        } else {
            payInfo.mXg = true;
        }
        if (payInfo.cIf == 4 || payInfo.cIf == 1 || 36 == payInfo.cIf || 8 == payInfo.cIf) {
            payInfo.vwf = true;
        } else {
            payInfo.vwf = false;
        }
        payInfo.pPw = str3;
        intent.putExtra("key_pay_info", payInfo);
        intent.putExtra("key_force_use_bind_serail", bo.nullAsNil(str));
        intent.putExtra("key_is_force_use_given_card", z);
        if (context instanceof Activity) {
            intent.putExtra("key_context_hashcode", context.hashCode());
            ab.i("MicroMsg.WalletManager", "startPay context %s %s", context, Integer.valueOf(context.hashCode()));
        }
        if (!bo.isNullOrNil(str2)) {
            intent.putExtra("key_is_use_default_card", str2);
        }
        ab.i("MicroMsg.WalletManager", "startPay context %s from %s", context, bo.dpG());
        intent.putExtra("key_receiver_true_name", str3);
        if (r.YM()) {
            d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i);
        } else {
            d.b(context, "wallet", ".pay.ui.WalletPayUI", intent, i);
        }
        AppMethodBeat.o(135786);
        return true;
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(135787);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(135787);
            return false;
        }
        boolean a = a(context, true, str, N(str2, str3, i), i2);
        AppMethodBeat.o(135787);
        return a;
    }

    public static boolean b(MMActivity mMActivity, g gVar, int i, a aVar) {
        AppMethodBeat.i(135788);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.cId);
        intent.putExtra("url", gVar.url);
        intent.putExtra("key_bind_scene", gVar.cIg);
        intent.putExtra("pay_channel", gVar.cvS);
        mMActivity.ifE = aVar;
        d.a((Context) mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i, false);
        AppMethodBeat.o(135788);
        return true;
    }

    public static boolean aj(Context context, int i) {
        AppMethodBeat.i(135789);
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i);
        d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        AppMethodBeat.o(135789);
        return true;
    }

    public static boolean ak(Context context, int i) {
        AppMethodBeat.i(135790);
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i);
        if (r.YM()) {
            d.b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            d.b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        AppMethodBeat.o(135790);
        return true;
    }

    public static boolean fV(Context context) {
        AppMethodBeat.i(135791);
        d.H(context, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(135791);
        return true;
    }

    public static boolean a(Context context, int i, String str, int i2, com.tencent.mm.plugin.wallet.a aVar) {
        AppMethodBeat.i(135792);
        Intent intent = new Intent();
        intent.putExtra("scene", i);
        intent.putExtra("receiver_name", str);
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.plugin.wallet.a.a(aVar, intent);
        if (r.YM()) {
            d.b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (r.YN()) {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.h.pYm.e(11850, Integer.valueOf(7), Integer.valueOf(1));
        } else {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.h.pYm.e(11850, Integer.valueOf(3), Integer.valueOf(1));
        }
        AppMethodBeat.o(135792);
        return true;
    }

    public static void a(Context context, String str, int i, String str2, int i2) {
        AppMethodBeat.i(135793);
        Intent intent = new Intent();
        intent.putExtra("key_qrcode_url", str);
        intent.putExtra("key_channel", i);
        intent.putExtra("key_web_url", str2);
        intent.putExtra("key_scene", i2);
        d.b(context, "collect", ".reward.ui.QrRewardSelectMoneyUI", intent);
        AppMethodBeat.o(135793);
    }
}
