package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@a(dFp = com.tencent.mm.ui.chatting.c.b.b.class)
public class b extends a implements com.tencent.mm.ui.chatting.c.b.b {
    private com.tencent.mm.plugin.wallet.a pQU = null;
    private ar yNS = null;
    private final k.a yNT = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31178);
            ab.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
            ((h) b.this.cgL.aF(h.class)).dCT();
            AppMethodBeat.o(31178);
        }
    };
    private final k.a yNU = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31179);
            ab.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
            ((h) b.this.cgL.aF(h.class)).dCT();
            AppMethodBeat.o(31179);
        }
    };

    public b() {
        AppMethodBeat.i(31181);
        AppMethodBeat.o(31181);
    }

    private void dDi() {
        AppMethodBeat.i(31182);
        if (this.yNS != null) {
            ar.b(this.yNS);
        }
        if (aw.RK()) {
            am.aUq().d(this.yNT);
            am.bYJ().d(this.yNU);
        }
        AppMethodBeat.o(31182);
    }

    public final void q(f fVar) {
        AppMethodBeat.i(31183);
        if (fVar == null) {
            ab.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", bo.dpG());
            AppMethodBeat.o(31183);
            return;
        }
        if (!(fVar == null || !f.vbQ.equals(fVar.field_appId) || this.pQU == null)) {
            this.pQU.bs(2, this.cgL.sRl.field_username);
        }
        if (fVar.dhx()) {
            if (fVar == null || !fVar.dhx()) {
                ab.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
                AppMethodBeat.o(31183);
            } else if (this.cgL.sRl == null || bo.isNullOrNil(this.cgL.sRl.field_username)) {
                ab.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
                AppMethodBeat.o(31183);
            } else {
                ab.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(fVar.dnv), fVar.field_packageName, fVar.field_appId);
                if (fVar.dnv == 2 && !bo.isNullOrNil(fVar.dnu)) {
                    r(fVar);
                    AppMethodBeat.o(31183);
                } else if (fVar.dnv != 3) {
                    if (fVar.dnv == 1) {
                        ab.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", fVar.dnu);
                        r.a.vax.a(this.cgL.yTx.getContext(), fVar.dnu, false, new v() {
                            public final Object dgT() {
                                return b.this.cgL.sRl.field_username;
                            }

                            public final Object dgU() {
                                AppMethodBeat.i(31180);
                                com.tencent.mm.plugin.wallet.a a = b.this.pQU;
                                AppMethodBeat.o(31180);
                                return a;
                            }
                        });
                    }
                    AppMethodBeat.o(31183);
                } else if (bo.isNullOrNil(fVar.field_openId)) {
                    am.bYL().wy(fVar.field_appId);
                    ab.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
                    AppMethodBeat.o(31183);
                } else if (this.yNS == null || bo.isNullOrNil(fVar.field_packageName)) {
                    ab.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
                    r(fVar);
                    AppMethodBeat.o(31183);
                } else {
                    ab.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", Boolean.valueOf(this.yNS.im(fVar.field_packageName, fVar.field_openId)));
                    if (!this.yNS.im(fVar.field_packageName, fVar.field_openId)) {
                        r(fVar);
                    }
                    AppMethodBeat.o(31183);
                }
            }
        } else if (fVar.field_status == 3) {
            ab.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + fVar.field_packageName);
            AppMethodBeat.o(31183);
        } else {
            if (!this.yNS.im(fVar.field_packageName, fVar.field_openId) && fVar.field_status == 5) {
                ab.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", fVar.dni);
                if (bo.isNullOrNil(fVar.dni)) {
                    AppMethodBeat.o(31183);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", fVar.dni);
                d.b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(31183);
        }
    }

    private void r(f fVar) {
        AppMethodBeat.i(31184);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            ab.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
            AppMethodBeat.o(31184);
        } else if (bo.isNullOrNil(fVar.dnu)) {
            ab.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
            AppMethodBeat.o(31184);
        } else {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = this.cgL.yTx.getContext().getSharedPreferences(ah.doA(), 0);
            this.cgL.yTx.getContext();
            String g = aa.g(sharedPreferences);
            if ("language_default".equalsIgnoreCase(g) && Locale.getDefault() != null) {
                g = Locale.getDefault().toString();
            }
            if (t.kH(this.cgL.getTalkerUserName())) {
                aw.ZK();
                u oa = c.XV().oa(this.cgL.getTalkerUserName());
                if (oa != null) {
                    size = oa.afg().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.cgL.sRl.field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.dnu, Integer.valueOf(size), g}));
                    d.b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(31184);
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            intent.putExtra("forceHideShare", true);
            bundle.putString("sendAppMsgToUserName", this.cgL.sRl.field_username);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.dnu, Integer.valueOf(size), g}));
            d.b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(31184);
        }
    }

    private static String aO(Context context, String str) {
        String str2;
        AppMethodBeat.i(31187);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.o(31187);
                return str2;
            }
        } catch (NameNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(31187);
        return str2;
    }

    public final void a(o oVar) {
        AppMethodBeat.i(31188);
        bv.aaq().c(38, Integer.valueOf(1));
        String str = oVar.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        wXMediaMessage.title = bVar.getName();
        wXMediaMessage.description = bo.ga(bVar.length());
        f fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        am.bYJ().b((com.tencent.mm.sdk.e.c) fVar, new String[0]);
        l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.cgL.getTalkerUserName(), 2, null);
        AppMethodBeat.o(31188);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31189);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 210:
                if (i2 == -1) {
                    long longExtra = intent.getLongExtra("App_MsgId", 0);
                    aw.ZK();
                    a(c.XO().jf(longExtra), null);
                }
                AppMethodBeat.o(31189);
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
                    ab.i(str, str2, objArr);
                    if (!bo.isNullOrNil(stringExtra3)) {
                        if (this.yNS != null && !bo.isNullOrNil(stringExtra)) {
                            if (!bo.isNullOrNil(stringExtra2)) {
                                ab.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", Boolean.valueOf(this.yNS.im(stringExtra, stringExtra2)));
                                if (!this.yNS.im(stringExtra, stringExtra2)) {
                                    r(g.bT(stringExtra3, true));
                                    break;
                                }
                            }
                            am.bYL().wy(stringExtra3);
                            ab.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
                            AppMethodBeat.o(31189);
                            return;
                        }
                        r(g.bT(stringExtra3, true));
                        AppMethodBeat.o(31189);
                        return;
                    }
                    ab.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
                    AppMethodBeat.o(31189);
                    return;
                }
                break;
        }
        AppMethodBeat.o(31189);
    }

    public final void dxC() {
        AppMethodBeat.i(31192);
        dDi();
        AppMethodBeat.o(31192);
    }

    public final void dDh() {
        AppMethodBeat.i(31193);
        super.dDh();
        dDi();
        AppMethodBeat.o(31193);
    }

    public final void a(bi biVar, aj ajVar) {
        String oz;
        com.tencent.mm.af.j.b me;
        f bT;
        Intent intent;
        AppMethodBeat.i(31185);
        String str = biVar.field_content;
        if (biVar.field_isSend == 0) {
            com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
            int i = biVar.field_isSend;
            if (!((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn() && aVar.dFw() && str != null && i == 0) {
                oz = bf.oz(str);
                me = com.tencent.mm.af.j.b.me(oz);
                bT = g.bT(me.appId, true);
                if (bT != null || !p.u(this.cgL.yTx.getContext(), bT.field_packageName)) {
                    oz = p.C(this.cgL.yTx.getContext(), me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    intent = new Intent();
                    intent.putExtra("rawUrl", oz);
                    d.b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(31185);
                } else if (bT.field_status == 3) {
                    ab.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + bT.field_packageName);
                    AppMethodBeat.o(31185);
                    return;
                } else if (!p.b(this.cgL.yTx.getContext(), bT)) {
                    ab.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", bT.field_appName);
                    Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.c62, new Object[]{g.b(this.cgL.yTx.getContext(), bT, null)}), 1).show();
                    AppMethodBeat.o(31185);
                    return;
                } else if (a(biVar, bT)) {
                    AppMethodBeat.o(31185);
                    return;
                } else {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = me.extInfo;
                    if (me.csD != null && me.csD.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                        wXAppExtendObject.filePath = aiE == null ? null : aiE.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = Build.SDK_INT;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = me.title;
                    wXMediaMessage.description = me.description;
                    wXMediaMessage.messageAction = me.messageAction;
                    wXMediaMessage.messageExt = me.messageExt;
                    wXMediaMessage.thumbData = e.e(com.tencent.mm.at.o.ahl().sj(biVar.field_imgPath), 0, -1);
                    new as(this.cgL.yTx.getContext()).a(bT.field_packageName, wXMediaMessage, bT.field_appId, bT.field_openId, ajVar);
                    AppMethodBeat.o(31185);
                    return;
                }
            }
        }
        oz = str;
        me = com.tencent.mm.af.j.b.me(oz);
        bT = g.bT(me.appId, true);
        if (bT != null) {
        }
        oz = p.C(this.cgL.yTx.getContext(), me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        intent = new Intent();
        intent.putExtra("rawUrl", oz);
        d.b(this.cgL.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(31185);
    }

    private boolean a(bi biVar, f fVar) {
        AppMethodBeat.i(31186);
        if (biVar.field_talker.endsWith("@qqim") && fVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            ab.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, aO(this.cgL.yTx.getContext(), TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            aw.ZK();
            Object obj = c.Ry().get(9, null);
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
                    ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
                }
            }
            try {
                this.cgL.yTx.startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(31186);
            return true;
        }
        AppMethodBeat.o(31186);
        return false;
    }

    public final void dxz() {
        AppMethodBeat.i(31190);
        this.pQU = com.tencent.mm.plugin.wallet.a.dq(this.cgL.sRl.field_username, 1);
        this.pQU.bs(1, this.cgL.sRl.field_username);
        am.aUq().c(this.yNT);
        am.bYJ().c(this.yNU);
        if (this.yNS == null) {
            this.yNS = new ar(this.cgL);
        }
        ar.a(this.yNS);
        AppMethodBeat.o(31190);
    }

    public final void dxB() {
        AppMethodBeat.i(31191);
        ao.clear();
        AppMethodBeat.o(31191);
    }
}
