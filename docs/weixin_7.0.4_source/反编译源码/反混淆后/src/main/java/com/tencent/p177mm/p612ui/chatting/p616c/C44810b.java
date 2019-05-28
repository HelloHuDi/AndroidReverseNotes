package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.chatting.C15584as;
import com.tencent.p177mm.p612ui.chatting.C31490ar;
import com.tencent.p177mm.p612ui.chatting.C44290ao;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36133b;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.pluginsdk.C30156v;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14988o;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@C15590a(dFp = C36133b.class)
/* renamed from: com.tencent.mm.ui.chatting.c.b */
public class C44810b extends C44291a implements C36133b {
    private C40052a pQU = null;
    private C31490ar yNS = null;
    private final C4931a yNT = new C448111();
    private final C4931a yNU = new C442952();

    /* renamed from: com.tencent.mm.ui.chatting.c.b$3 */
    class C407213 implements C30156v {
        C407213() {
        }

        public final Object dgT() {
            return C44810b.this.cgL.sRl.field_username;
        }

        public final Object dgU() {
            AppMethodBeat.m2504i(31180);
            C40052a a = C44810b.this.pQU;
            AppMethodBeat.m2505o(31180);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.b$2 */
    class C442952 implements C4931a {
        C442952() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31179);
            C4990ab.m7418v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
            ((C15612h) C44810b.this.cgL.mo74857aF(C15612h.class)).dCT();
            AppMethodBeat.m2505o(31179);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.b$1 */
    class C448111 implements C4931a {
        C448111() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31178);
            C4990ab.m7418v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
            ((C15612h) C44810b.this.cgL.mo74857aF(C15612h.class)).dCT();
            AppMethodBeat.m2505o(31178);
        }
    }

    public C44810b() {
        AppMethodBeat.m2504i(31181);
        AppMethodBeat.m2505o(31181);
    }

    private void dDi() {
        AppMethodBeat.m2504i(31182);
        if (this.yNS != null) {
            C31490ar.m50972b(this.yNS);
        }
        if (C9638aw.m17179RK()) {
            C14877am.aUq().mo10117d(this.yNT);
            C14877am.bYJ().mo10117d(this.yNU);
        }
        AppMethodBeat.m2505o(31182);
    }

    /* renamed from: q */
    public final void mo57003q(C40439f c40439f) {
        AppMethodBeat.m2504i(31183);
        if (c40439f == null) {
            C4990ab.m7413e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", C5046bo.dpG());
            AppMethodBeat.m2505o(31183);
            return;
        }
        if (!(c40439f == null || !C40439f.vbQ.equals(c40439f.field_appId) || this.pQU == null)) {
            this.pQU.mo63379bs(2, this.cgL.sRl.field_username);
        }
        if (c40439f.dhx()) {
            if (c40439f == null || !c40439f.dhx()) {
                C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
                AppMethodBeat.m2505o(31183);
            } else if (this.cgL.sRl == null || C5046bo.isNullOrNil(this.cgL.sRl.field_username)) {
                C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
                AppMethodBeat.m2505o(31183);
            } else {
                C4990ab.m7417i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(c40439f.dnv), c40439f.field_packageName, c40439f.field_appId);
                if (c40439f.dnv == 2 && !C5046bo.isNullOrNil(c40439f.dnu)) {
                    m81941r(c40439f);
                    AppMethodBeat.m2505o(31183);
                } else if (c40439f.dnv != 3) {
                    if (c40439f.dnv == 1) {
                        C4990ab.m7417i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", c40439f.dnu);
                        C23257a.vax.mo52973a(this.cgL.yTx.getContext(), c40439f.dnu, false, new C407213());
                    }
                    AppMethodBeat.m2505o(31183);
                } else if (C5046bo.isNullOrNil(c40439f.field_openId)) {
                    C14877am.bYL().mo9878wy(c40439f.field_appId);
                    C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
                    AppMethodBeat.m2505o(31183);
                } else if (this.yNS == null || C5046bo.isNullOrNil(c40439f.field_packageName)) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
                    m81941r(c40439f);
                    AppMethodBeat.m2505o(31183);
                } else {
                    C4990ab.m7417i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", Boolean.valueOf(this.yNS.mo51422im(c40439f.field_packageName, c40439f.field_openId)));
                    if (!this.yNS.mo51422im(c40439f.field_packageName, c40439f.field_openId)) {
                        m81941r(c40439f);
                    }
                    AppMethodBeat.m2505o(31183);
                }
            }
        } else if (c40439f.field_status == 3) {
            C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + c40439f.field_packageName);
            AppMethodBeat.m2505o(31183);
        } else {
            if (!this.yNS.mo51422im(c40439f.field_packageName, c40439f.field_openId) && c40439f.field_status == 5) {
                C4990ab.m7411d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", c40439f.dni);
                if (C5046bo.isNullOrNil(c40439f.dni)) {
                    AppMethodBeat.m2505o(31183);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", c40439f.dni);
                C25985d.m41467b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(31183);
        }
    }

    /* renamed from: r */
    private void m81941r(C40439f c40439f) {
        AppMethodBeat.m2504i(31184);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
            AppMethodBeat.m2505o(31184);
        } else if (C5046bo.isNullOrNil(c40439f.dnu)) {
            C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
            AppMethodBeat.m2505o(31184);
        } else {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = this.cgL.yTx.getContext().getSharedPreferences(C4996ah.doA(), 0);
            this.cgL.yTx.getContext();
            String g = C4988aa.m7402g(sharedPreferences);
            if ("language_default".equalsIgnoreCase(g) && Locale.getDefault() != null) {
                g = Locale.getDefault().toString();
            }
            if (C1855t.m3896kH(this.cgL.getTalkerUserName())) {
                C9638aw.m17190ZK();
                C7577u oa = C18628c.m29087XV().mo14885oa(this.cgL.getTalkerUserName());
                if (oa != null) {
                    size = oa.afg().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", c40439f.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.cgL.sRl.field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{c40439f.dnu, Integer.valueOf(size), g}));
                    C25985d.m41467b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(31184);
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", c40439f.field_appId);
            bundle.putBoolean("isFromService", true);
            intent.putExtra("forceHideShare", true);
            bundle.putString("sendAppMsgToUserName", this.cgL.sRl.field_username);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{c40439f.dnu, Integer.valueOf(size), g}));
            C25985d.m41467b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(31184);
        }
    }

    /* renamed from: aO */
    private static String m81940aO(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(31187);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.m2505o(31187);
                return str2;
            }
        } catch (NameNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.m2505o(31187);
        return str2;
    }

    /* renamed from: a */
    public final void mo57001a(C14988o c14988o) {
        AppMethodBeat.m2504i(31188);
        C37907bv.aaq().mo60662c(38, Integer.valueOf(1));
        String str = c14988o.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        C5728b c5728b = new C5728b(str);
        wXMediaMessage.title = c5728b.getName();
        wXMediaMessage.description = C5046bo.m7565ga(c5728b.length());
        C40439f c40439f = new C40439f();
        c40439f.field_appId = "wx4310bbd51be7d979";
        C14877am.bYJ().mo10102b((C4925c) c40439f, new String[0]);
        C4733l.m7090a(wXMediaMessage, c40439f.field_appId, c40439f.field_appName, this.cgL.getTalkerUserName(), 2, null);
        AppMethodBeat.m2505o(31188);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31189);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 210:
                if (i2 == -1) {
                    long longExtra = intent.getLongExtra("App_MsgId", 0);
                    C9638aw.m17190ZK();
                    mo57002a(C18628c.m29080XO().mo15340jf(longExtra), null);
                }
                AppMethodBeat.m2505o(31189);
                return;
            case 222:
                if (i2 == -1 && intent != null) {
                    boolean z;
                    String stringExtra = intent.getStringExtra("service_app_package_name");
                    String stringExtra2 = intent.getStringExtra("service_app_openid");
                    String stringExtra3 = intent.getStringExtra("service_app_appid");
                    String str = "MicroMsg.ChattingUI.AppMsgComponent";
                    String str2 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                    Object[] objArr = new Object[4];
                    if (this.yNS != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = stringExtra;
                    objArr[2] = stringExtra3;
                    objArr[3] = stringExtra2;
                    C4990ab.m7417i(str, str2, objArr);
                    if (!C5046bo.isNullOrNil(stringExtra3)) {
                        if (this.yNS != null && !C5046bo.isNullOrNil(stringExtra)) {
                            if (!C5046bo.isNullOrNil(stringExtra2)) {
                                C4990ab.m7411d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", Boolean.valueOf(this.yNS.mo51422im(stringExtra, stringExtra2)));
                                if (!this.yNS.mo51422im(stringExtra, stringExtra2)) {
                                    m81941r(C46494g.m87739bT(stringExtra3, true));
                                    break;
                                }
                            }
                            C14877am.bYL().mo9878wy(stringExtra3);
                            C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
                            AppMethodBeat.m2505o(31189);
                            return;
                        }
                        m81941r(C46494g.m87739bT(stringExtra3, true));
                        AppMethodBeat.m2505o(31189);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
                    AppMethodBeat.m2505o(31189);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(31189);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31192);
        dDi();
        AppMethodBeat.m2505o(31192);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31193);
        super.dDh();
        dDi();
        AppMethodBeat.m2505o(31193);
    }

    /* renamed from: a */
    public final void mo57002a(C7620bi c7620bi, C14875aj c14875aj) {
        String oz;
        C8910b me;
        C40439f bT;
        Intent intent;
        AppMethodBeat.m2504i(31185);
        String str = c7620bi.field_content;
        if (c7620bi.field_isSend == 0) {
            C46650a c46650a = this.cgL;
            int i = c7620bi.field_isSend;
            if (!((C36135d) c46650a.mo74857aF(C36135d.class)).dDn() && c46650a.dFw() && str != null && i == 0) {
                oz = C1829bf.m3763oz(str);
                me = C8910b.m16064me(oz);
                bT = C46494g.m87739bT(me.appId, true);
                if (bT != null || !C35799p.m58695u(this.cgL.yTx.getContext(), bT.field_packageName)) {
                    oz = C35799p.m58685C(this.cgL.yTx.getContext(), me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    intent = new Intent();
                    intent.putExtra("rawUrl", oz);
                    C25985d.m41467b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(31185);
                } else if (bT.field_status == 3) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + bT.field_packageName);
                    AppMethodBeat.m2505o(31185);
                    return;
                } else if (!C35799p.m58689b(this.cgL.yTx.getContext(), bT)) {
                    C4990ab.m7413e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", bT.field_appName);
                    Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.c62, new Object[]{C46494g.m87733b(this.cgL.yTx.getContext(), bT, null)}), 1).show();
                    AppMethodBeat.m2505o(31185);
                    return;
                } else if (m81939a(c7620bi, bT)) {
                    AppMethodBeat.m2505o(31185);
                    return;
                } else {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = me.extInfo;
                    if (me.csD != null && me.csD.length() > 0) {
                        C30065b aiE = C14877am.aUq().aiE(me.csD);
                        wXAppExtendObject.filePath = aiE == null ? null : aiE.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = Build.SDK_INT;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = me.title;
                    wXMediaMessage.description = me.description;
                    wXMediaMessage.messageAction = me.messageAction;
                    wXMediaMessage.messageExt = me.messageExt;
                    wXMediaMessage.thumbData = C5730e.m8632e(C32291o.ahl().mo73119sj(c7620bi.field_imgPath), 0, -1);
                    new C15584as(this.cgL.yTx.getContext()).mo27753a(bT.field_packageName, wXMediaMessage, bT.field_appId, bT.field_openId, c14875aj);
                    AppMethodBeat.m2505o(31185);
                    return;
                }
            }
        }
        oz = str;
        me = C8910b.m16064me(oz);
        bT = C46494g.m87739bT(me.appId, true);
        if (bT != null) {
        }
        oz = C35799p.m58685C(this.cgL.yTx.getContext(), me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        intent = new Intent();
        intent.putExtra("rawUrl", oz);
        C25985d.m41467b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(31185);
    }

    /* renamed from: a */
    private boolean m81939a(C7620bi c7620bi, C40439f c40439f) {
        AppMethodBeat.m2504i(31186);
        if (c7620bi.field_talker.endsWith("@qqim") && c40439f.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            C4990ab.m7410d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, C44810b.m81940aO(this.cgL.yTx.getContext(), TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            C9638aw.m17190ZK();
            Object obj = C18628c.m29072Ry().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent.putExtra("tencent_gif", bytes);
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
                }
            }
            try {
                this.cgL.yTx.startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.m2505o(31186);
            return true;
        }
        AppMethodBeat.m2505o(31186);
        return false;
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31190);
        this.pQU = C40052a.m68625dq(this.cgL.sRl.field_username, 1);
        this.pQU.mo63379bs(1, this.cgL.sRl.field_username);
        C14877am.aUq().mo10116c(this.yNT);
        C14877am.bYJ().mo10116c(this.yNU);
        if (this.yNS == null) {
            this.yNS = new C31490ar(this.cgL);
        }
        C31490ar.m50969a(this.yNS);
        AppMethodBeat.m2505o(31190);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31191);
        C44290ao.clear();
        AppMethodBeat.m2505o(31191);
    }
}
