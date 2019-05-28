package com.tencent.p177mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p612ui.JSAPIUploadLogHelperUI;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.contact.VoipAddressUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.pluginsdk.C30156v;
import com.tencent.p177mm.pluginsdk.C44070r;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.app.plugin.a */
public final class C32261a implements C44070r {
    /* renamed from: a */
    public final boolean mo52971a(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(15609);
        boolean a = mo52973a(context, str, z, null);
        AppMethodBeat.m2505o(15609);
        return a;
    }

    /* renamed from: a */
    public final boolean mo52973a(Context context, String str, boolean z, C30156v c30156v) {
        AppMethodBeat.m2504i(15610);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            AppMethodBeat.m2505o(15610);
            return false;
        } else if (str.startsWith("http")) {
            C32261a.m52676w(context, str);
            AppMethodBeat.m2505o(15610);
            return true;
        } else if (mo52974b(context, str, z, c30156v)) {
            AppMethodBeat.m2505o(15610);
            return false;
        } else {
            C4990ab.m7421w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            AppMethodBeat.m2505o(15610);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo52972a(Context context, String str, boolean z, Bundle bundle) {
        AppMethodBeat.m2504i(15611);
        boolean a = m52675a(context, str, z, null, bundle);
        AppMethodBeat.m2505o(15611);
        return a;
    }

    /* renamed from: b */
    public final boolean mo52974b(Context context, String str, boolean z, C30156v c30156v) {
        AppMethodBeat.m2504i(15612);
        boolean a = m52675a(context, str, z, c30156v, null);
        AppMethodBeat.m2505o(15612);
        return a;
    }

    /* renamed from: a */
    private boolean m52675a(Context context, String str, boolean z, C30156v c30156v, Bundle bundle) {
        AppMethodBeat.m2504i(15613);
        boolean c;
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            AppMethodBeat.m2505o(15613);
            return false;
        } else if (str == null) {
            C4990ab.m7412e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            AppMethodBeat.m2505o(15613);
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            c = mo52975c(context, str, new Object[0]);
            AppMethodBeat.m2505o(15613);
            return c;
        } else {
            c = C1265e.m2715Cl().mo4553b(context, str, z, c30156v, bundle);
            AppMethodBeat.m2505o(15613);
            return c;
        }
    }

    /* renamed from: w */
    private static void m52676w(Context context, String str) {
        AppMethodBeat.m2504i(15614);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            AppMethodBeat.m2505o(15614);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e.getMessage());
            AppMethodBeat.m2505o(15614);
        }
    }

    /* renamed from: c */
    public final boolean mo52975c(Context context, String str, Object... objArr) {
        AppMethodBeat.m2504i(15615);
        if (str == null) {
            C4990ab.m7410d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            AppMethodBeat.m2505o(15615);
            return false;
        } else if (context == null) {
            C4990ab.m7412e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            AppMethodBeat.m2505o(15615);
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
                C25985d.m41467b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                C25985d.m41467b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                C25985d.m41467b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                C25985d.m41467b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                C25985d.m41467b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                C25985d.m41467b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                C25985d.m41467b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.m23791J(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) {
                C25985d.m41467b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                C25985d.m41467b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.m24164hX(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString("url");
                } else {
                    string = replace;
                }
                intent.putExtra("k_expose_url", string);
                intent.putExtra("k_username", C1853r.m3846Yz());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
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
                C25985d.m41467b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                C4990ab.m7416i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
                C18296ik c18296ik = new C18296ik();
                c18296ik.cDz.context = context;
                C4879a.xxA.mo10055m(c18296ik);
            } else if (replace.equalsIgnoreCase("uploadlog")) {
                int i;
                String str2;
                String str3;
                Object[] objArr2;
                boolean z;
                Intent intent3;
                replace = C1853r.m3846Yz();
                if (C5046bo.isNullOrNil(replace)) {
                    replace = "weixin";
                }
                if (bundle != null) {
                    try {
                        i = C5046bo.getInt(bundle.getString(Constants.EXTINFO), 0);
                    } catch (Exception e) {
                    }
                    str2 = "MicroMsg.MMURIJumpHandler";
                    str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                    objArr2 = new Object[2];
                    z = C9638aw.m17179RK() && !C9638aw.m17178QT();
                    objArr2[0] = Boolean.valueOf(z);
                    objArr2[1] = Integer.valueOf(i);
                    C4990ab.m7417i(str2, str3, objArr2);
                    intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                    intent3.putExtra("key_user", replace);
                    intent3.putExtra("key_time", i);
                    context.startActivity(intent3);
                }
                i = 0;
                str2 = "MicroMsg.MMURIJumpHandler";
                str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                objArr2 = new Object[2];
                if (!C9638aw.m17179RK()) {
                }
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                C4990ab.m7417i(str2, str3, objArr2);
                intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            } else {
                AppMethodBeat.m2505o(15615);
                return false;
            }
            AppMethodBeat.m2505o(15615);
            return true;
        }
    }
}
