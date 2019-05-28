package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;

public final class a implements r {
    public final boolean a(Context context, String str, boolean z) {
        AppMethodBeat.i(15609);
        boolean a = a(context, str, z, null);
        AppMethodBeat.o(15609);
        return a;
    }

    public final boolean a(Context context, String str, boolean z, v vVar) {
        AppMethodBeat.i(15610);
        if (context == null) {
            ab.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            AppMethodBeat.o(15610);
            return false;
        } else if (str.startsWith("http")) {
            w(context, str);
            AppMethodBeat.o(15610);
            return true;
        } else if (b(context, str, z, vVar)) {
            AppMethodBeat.o(15610);
            return false;
        } else {
            ab.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            AppMethodBeat.o(15610);
            return false;
        }
    }

    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        AppMethodBeat.i(15611);
        boolean a = a(context, str, z, null, bundle);
        AppMethodBeat.o(15611);
        return a;
    }

    public final boolean b(Context context, String str, boolean z, v vVar) {
        AppMethodBeat.i(15612);
        boolean a = a(context, str, z, vVar, null);
        AppMethodBeat.o(15612);
        return a;
    }

    private boolean a(Context context, String str, boolean z, v vVar, Bundle bundle) {
        AppMethodBeat.i(15613);
        boolean c;
        if (context == null) {
            ab.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            AppMethodBeat.o(15613);
            return false;
        } else if (str == null) {
            ab.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            AppMethodBeat.o(15613);
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            c = c(context, str, new Object[0]);
            AppMethodBeat.o(15613);
            return c;
        } else {
            c = e.Cl().b(context, str, z, vVar, bundle);
            AppMethodBeat.o(15613);
            return c;
        }
    }

    private static void w(Context context, String str) {
        AppMethodBeat.i(15614);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            AppMethodBeat.o(15614);
        } catch (Exception e) {
            ab.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e.getMessage());
            AppMethodBeat.o(15614);
        }
    }

    public final boolean c(Context context, String str, Object... objArr) {
        AppMethodBeat.i(15615);
        if (str == null) {
            ab.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            AppMethodBeat.o(15615);
            return false;
        } else if (context == null) {
            ab.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            AppMethodBeat.o(15615);
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            String replace = str.replace("weixin://openSpecificView/", "");
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            String string;
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("newfriend")) {
                d.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                d.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                d.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                d.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                d.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.J(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) {
                d.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                d.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.hX(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString("url");
                } else {
                    string = replace;
                }
                intent.putExtra("k_expose_url", string);
                intent.putExtra("k_username", com.tencent.mm.model.r.Yz());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString(Constants.EXTINFO);
                } else {
                    string = replace;
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", string);
                d.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                ab.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
                ik ikVar = new ik();
                ikVar.cDz.context = context;
                com.tencent.mm.sdk.b.a.xxA.m(ikVar);
            } else if (replace.equalsIgnoreCase("uploadlog")) {
                int i;
                String str2;
                String str3;
                Object[] objArr2;
                boolean z;
                Intent intent3;
                replace = com.tencent.mm.model.r.Yz();
                if (bo.isNullOrNil(replace)) {
                    replace = "weixin";
                }
                if (bundle != null) {
                    try {
                        i = bo.getInt(bundle.getString(Constants.EXTINFO), 0);
                    } catch (Exception e) {
                    }
                    str2 = "MicroMsg.MMURIJumpHandler";
                    str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                    objArr2 = new Object[2];
                    z = aw.RK() && !aw.QT();
                    objArr2[0] = Boolean.valueOf(z);
                    objArr2[1] = Integer.valueOf(i);
                    ab.i(str2, str3, objArr2);
                    intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                    intent3.putExtra("key_user", replace);
                    intent3.putExtra("key_time", i);
                    context.startActivity(intent3);
                }
                i = 0;
                str2 = "MicroMsg.MMURIJumpHandler";
                str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                objArr2 = new Object[2];
                if (!aw.RK()) {
                }
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                ab.i(str2, str3, objArr2);
                intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            } else {
                AppMethodBeat.o(15615);
                return false;
            }
            AppMethodBeat.o(15615);
            return true;
        }
    }
}
