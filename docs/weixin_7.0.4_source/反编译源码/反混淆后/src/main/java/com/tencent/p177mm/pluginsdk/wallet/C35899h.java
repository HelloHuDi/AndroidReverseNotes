package com.tencent.p177mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.wallet.h */
public final class C35899h {
    /* renamed from: a */
    public static boolean m58852a(Context context, Bundle bundle, boolean z, String str) {
        AppMethodBeat.m2504i(135776);
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (!C5046bo.isNullOrNil(str)) {
            intent.putExtra(ConstantsAPI.APP_PACKAGE, str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        C25985d.m41467b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        AppMethodBeat.m2505o(135776);
        return true;
    }

    /* renamed from: a */
    public static boolean m58859a(MMActivity mMActivity, C40493g c40493g, int i, C5186a c5186a) {
        AppMethodBeat.m2504i(135777);
        Intent intent = new Intent();
        intent.putExtra("appId", c40493g.appId);
        intent.putExtra("timeStamp", c40493g.timeStamp);
        intent.putExtra("nonceStr", c40493g.nonceStr);
        intent.putExtra("packageExt", c40493g.packageExt);
        intent.putExtra("signtype", c40493g.signType);
        intent.putExtra("paySignature", c40493g.cId);
        intent.putExtra("cookie", c40493g.flp);
        intent.putExtra("url", c40493g.url);
        intent.putExtra("bizUsername", c40493g.cIe);
        intent.putExtra("pay_channel", c40493g.cvS);
        intent.putExtra("pay_for_wallet_type", c40493g.vwu);
        intent.putExtra("pay_scene", c40493g.cIf);
        intent.putExtra("result_jump_mode", c40493g.vww);
        intent.putExtra("ext_info", c40493g.extInfo);
        intent.putExtra("key_wx_app_scene", c40493g.vwt);
        intent.putExtra("intent_app_brand_from_path", c40493g.vwx);
        intent.putExtra("intent_app_brand_from_username", c40493g.vwy);
        intent.putExtra("intent_app_brand_from_scene", c40493g.vwz);
        if (c5186a != null) {
            mMActivity.ifE = c5186a;
        }
        C4990ab.m7417i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", mMActivity, C5046bo.dpG());
        C25985d.m41453a((Context) mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i, false);
        AppMethodBeat.m2505o(135777);
        return true;
    }

    /* renamed from: ai */
    public static void m58860ai(Context context, int i) {
        AppMethodBeat.m2504i(135778);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", i);
        C25985d.m41467b(context, "collect", ".ui.CollectAdapterUI", intent);
        AppMethodBeat.m2505o(135778);
    }

    /* renamed from: a */
    public static boolean m58854a(Context context, String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(135779);
        boolean b = C35899h.m58863b(context, str, str2, i, i2);
        AppMethodBeat.m2505o(135779);
        return b;
    }

    /* renamed from: b */
    private static boolean m58863b(Context context, String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(135780);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(135780);
            return false;
        }
        boolean a = C35899h.m58853a(context, C35899h.m58849N(str, str2, i), i2);
        AppMethodBeat.m2505o(135780);
        return a;
    }

    /* renamed from: N */
    public static PayInfo m58849N(String str, String str2, int i) {
        AppMethodBeat.m2504i(135781);
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = str;
        payInfo.appId = str2;
        payInfo.tRb = null;
        payInfo.cIf = i;
        payInfo.aIm = null;
        payInfo.cIb = 0;
        AppMethodBeat.m2505o(135781);
        return payInfo;
    }

    /* renamed from: a */
    public static boolean m58853a(Context context, PayInfo payInfo, int i) {
        AppMethodBeat.m2504i(135782);
        boolean a = C35899h.m58856a(context, false, "", payInfo, i);
        AppMethodBeat.m2505o(135782);
        return a;
    }

    /* renamed from: a */
    private static boolean m58856a(Context context, boolean z, String str, PayInfo payInfo, int i) {
        AppMethodBeat.m2504i(135783);
        boolean b = C35899h.m58864b(context, z, str, payInfo, i);
        AppMethodBeat.m2505o(135783);
        return b;
    }

    /* renamed from: b */
    private static boolean m58864b(Context context, boolean z, String str, PayInfo payInfo, int i) {
        AppMethodBeat.m2504i(135784);
        boolean a = C35899h.m58857a(context, z, str, payInfo, null, new Intent(), i);
        AppMethodBeat.m2505o(135784);
        return a;
    }

    /* renamed from: a */
    public static boolean m58857a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i) {
        AppMethodBeat.m2504i(135785);
        boolean a = C35899h.m58858a(context, z, str, "", payInfo, str2, intent, i);
        AppMethodBeat.m2505o(135785);
        return a;
    }

    /* renamed from: a */
    public static boolean m58858a(Context context, boolean z, String str, String str2, PayInfo payInfo, String str3, Intent intent, int i) {
        AppMethodBeat.m2504i(135786);
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
        intent.putExtra("key_force_use_bind_serail", C5046bo.nullAsNil(str));
        intent.putExtra("key_is_force_use_given_card", z);
        if (context instanceof Activity) {
            intent.putExtra("key_context_hashcode", context.hashCode());
            C4990ab.m7417i("MicroMsg.WalletManager", "startPay context %s %s", context, Integer.valueOf(context.hashCode()));
        }
        if (!C5046bo.isNullOrNil(str2)) {
            intent.putExtra("key_is_use_default_card", str2);
        }
        C4990ab.m7417i("MicroMsg.WalletManager", "startPay context %s from %s", context, C5046bo.dpG());
        intent.putExtra("key_receiver_true_name", str3);
        if (C1853r.m3831YM()) {
            C25985d.m41468b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i);
        } else {
            C25985d.m41468b(context, "wallet", ".pay.ui.WalletPayUI", intent, i);
        }
        AppMethodBeat.m2505o(135786);
        return true;
    }

    /* renamed from: a */
    public static boolean m58855a(Context context, String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(135787);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(135787);
            return false;
        }
        boolean a = C35899h.m58856a(context, true, str, C35899h.m58849N(str2, str3, i), i2);
        AppMethodBeat.m2505o(135787);
        return a;
    }

    /* renamed from: b */
    public static boolean m58865b(MMActivity mMActivity, C40493g c40493g, int i, C5186a c5186a) {
        AppMethodBeat.m2504i(135788);
        Intent intent = new Intent();
        intent.putExtra("appId", c40493g.appId);
        intent.putExtra("timeStamp", c40493g.timeStamp);
        intent.putExtra("nonceStr", c40493g.nonceStr);
        intent.putExtra("packageExt", c40493g.packageExt);
        intent.putExtra("signtype", c40493g.signType);
        intent.putExtra("paySignature", c40493g.cId);
        intent.putExtra("url", c40493g.url);
        intent.putExtra("key_bind_scene", c40493g.cIg);
        intent.putExtra("pay_channel", c40493g.cvS);
        mMActivity.ifE = c5186a;
        C25985d.m41453a((Context) mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i, false);
        AppMethodBeat.m2505o(135788);
        return true;
    }

    /* renamed from: aj */
    public static boolean m58861aj(Context context, int i) {
        AppMethodBeat.m2504i(135789);
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i);
        C25985d.m41467b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        AppMethodBeat.m2505o(135789);
        return true;
    }

    /* renamed from: ak */
    public static boolean m58862ak(Context context, int i) {
        AppMethodBeat.m2504i(135790);
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i);
        if (C1853r.m3831YM()) {
            C25985d.m41467b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            C25985d.m41467b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        AppMethodBeat.m2505o(135790);
        return true;
    }

    /* renamed from: fV */
    public static boolean m58866fV(Context context) {
        AppMethodBeat.m2504i(135791);
        C25985d.m41448H(context, "mall", ".ui.MallIndexUI");
        AppMethodBeat.m2505o(135791);
        return true;
    }

    /* renamed from: a */
    public static boolean m58851a(Context context, int i, String str, int i2, C40052a c40052a) {
        AppMethodBeat.m2504i(135792);
        Intent intent = new Intent();
        intent.putExtra("scene", i);
        intent.putExtra("receiver_name", str);
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        C40052a.m68623a(c40052a, intent);
        if (C1853r.m3831YM()) {
            C25985d.m41467b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (C1853r.m3832YN()) {
            C25985d.m41467b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            C7060h.pYm.mo8381e(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            C7060h.pYm.mo8381e(11850, Integer.valueOf(7), Integer.valueOf(1));
        } else {
            C25985d.m41467b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            C7060h.pYm.mo8381e(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            C7060h.pYm.mo8381e(11850, Integer.valueOf(3), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(135792);
        return true;
    }

    /* renamed from: a */
    public static void m58850a(Context context, String str, int i, String str2, int i2) {
        AppMethodBeat.m2504i(135793);
        Intent intent = new Intent();
        intent.putExtra("key_qrcode_url", str);
        intent.putExtra("key_channel", i);
        intent.putExtra("key_web_url", str2);
        intent.putExtra("key_scene", i2);
        C25985d.m41467b(context, "collect", ".reward.ui.QrRewardSelectMoneyUI", intent);
        AppMethodBeat.m2505o(135793);
    }
}
