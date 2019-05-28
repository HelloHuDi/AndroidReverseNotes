package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.u;
import com.tencent.rtmp.TXLivePushConfig;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements f {
    private String Iw;
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog ehJ;
    private int jDs;
    private Boolean jEb = null;
    private int jEc = 0;
    private String token;
    private Uri uri;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class EntryReceiver extends BroadcastReceiver {
        private static ak handler;
        private String Iw;
        private String appId;
        private String appName;
        private Context context;
        private int jDs;
        private long jEe;

        public void onReceive(final Context context, final Intent intent) {
            AppMethodBeat.i(18196);
            if (context == null || intent == null) {
                AppMethodBeat.o(18196);
                return;
            }
            d.dlL();
            if (handler == null) {
                HandlerThread anM = com.tencent.mm.sdk.g.d.anM("WXEntryReceiver");
                anM.start();
                handler = new ak(anM.getLooper());
            }
            if (g.RQ().eKi.eKC) {
                handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18195);
                        long currentTimeMillis = System.currentTimeMillis();
                        EntryReceiver.a(EntryReceiver.this, context, intent);
                        ab.i("MicroMsg.WXEntryActivity", "cost:%s", (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(18195);
                    }
                });
                AppMethodBeat.o(18196);
                return;
            }
            g.RQ().a(new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(18194);
                    g.RQ().b(this);
                    EntryReceiver.a(EntryReceiver.this, context, intent);
                    AppMethodBeat.o(18194);
                }

                public final void bi(boolean z) {
                }
            });
            AppMethodBeat.o(18196);
        }

        /* JADX WARNING: Missing block: B:62:0x020a, code skipped:
            if (r0 == false) goto L_0x020c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(EntryReceiver entryReceiver, Context context, Intent intent) {
            AppMethodBeat.i(18197);
            entryReceiver.context = context;
            String n = w.n(intent, ConstantsAPI.CONTENT);
            entryReceiver.jEe = w.m(intent, ConstantsAPI.APP_SUPORT_CONTENT_TYPE);
            entryReceiver.jDs = w.a(intent, ConstantsAPI.SDK_VERSION, 0);
            if (WXEntryActivity.rM(entryReceiver.jDs)) {
                entryReceiver.Iw = w.n(intent, ConstantsAPI.APP_PACKAGE);
                if (entryReceiver.Iw == null || entryReceiver.Iw.length() <= 0) {
                    ab.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    AppMethodBeat.o(18197);
                    return;
                } else if (!WXEntryActivity.h(w.o(intent, ConstantsAPI.CHECK_SUM), WXEntryActivity.q(n, entryReceiver.jDs, entryReceiver.Iw))) {
                    ab.e("MicroMsg.WXEntryActivity", "checksum fail");
                    AppMethodBeat.o(18197);
                    return;
                } else if (n == null) {
                    ab.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                    AppMethodBeat.o(18197);
                    return;
                } else {
                    Uri parse = Uri.parse(n);
                    String authority = parse.getAuthority();
                    try {
                        entryReceiver.appId = parse.getQueryParameter("appid");
                        ab.i("MicroMsg.WXEntryActivity", "onReceive, appId = " + entryReceiver.appId);
                        com.tencent.mm.pluginsdk.model.app.f fVar;
                        if (entryReceiver.appId == null || entryReceiver.appId.length() <= 0) {
                            ab.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                            AppMethodBeat.o(18197);
                            return;
                        } else if (!aw.RK() || aw.QT()) {
                            ab.w("MicroMsg.WXEntryActivity", "not login, just save the appid : %s", entryReceiver.appId);
                            p.aiP(entryReceiver.appId);
                            AppMethodBeat.o(18197);
                            return;
                        } else if (!g.RN().eJb) {
                            ab.w("MicroMsg.WXEntryActivity", "not login accInitializing, just save the appid : %s", entryReceiver.appId);
                            p.aiP(entryReceiver.appId);
                            AppMethodBeat.o(18197);
                            return;
                        } else if ("registerapp".equals(authority)) {
                            ab.i("MicroMsg.WXEntryActivity", "handle app registeration: " + entryReceiver.Iw + ", sdkver=" + entryReceiver.jDs);
                            if (aw.RK()) {
                                com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(entryReceiver.appId, true);
                                if (p.d(entryReceiver.context, bT, entryReceiver.Iw)) {
                                    if (bT != null && bT.xy()) {
                                        a bDb = a.a.bDb();
                                        if (bDb != null) {
                                            bDb.j(entryReceiver.context, entryReceiver.appId, entryReceiver.Iw);
                                        }
                                    }
                                    Bitmap bitmap = null;
                                    try {
                                        PackageManager packageManager = entryReceiver.context.getPackageManager();
                                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(entryReceiver.Iw, 0);
                                        if (applicationInfo == null) {
                                            ab.e("MicroMsg.WXEntryActivity", "package not installed");
                                            AppMethodBeat.o(18197);
                                            return;
                                        }
                                        Bitmap bitmap2;
                                        entryReceiver.appName = applicationInfo.loadLabel(packageManager).toString();
                                        Drawable loadIcon = applicationInfo.loadIcon(packageManager);
                                        if (loadIcon instanceof BitmapDrawable) {
                                            bitmap2 = ((BitmapDrawable) loadIcon).getBitmap();
                                        } else {
                                            bitmap2 = null;
                                        }
                                        bitmap = bitmap2;
                                        if (bT != null) {
                                            am.bYJ();
                                            n = entryReceiver.appId;
                                            boolean z;
                                            if (n == null || n.length() == 0) {
                                                ab.e("MicroMsg.AppInfoStorage", "hasIcon, appId is null");
                                                z = false;
                                            } else {
                                                z = e.ct(i.dY(n, 1));
                                            }
                                        }
                                        am.bYJ().t(entryReceiver.appId, bitmap);
                                        if (bT == null) {
                                            fVar = new com.tencent.mm.pluginsdk.model.app.f();
                                            fVar.field_appId = entryReceiver.appId;
                                            fVar.field_appName = "";
                                            fVar.field_packageName = entryReceiver.Iw;
                                            fVar.field_status = 0;
                                            authority = p.bw(entryReceiver.context, entryReceiver.Iw);
                                            if (authority != null) {
                                                fVar.field_signature = authority;
                                            }
                                            fVar.field_modifyTime = System.currentTimeMillis();
                                            fVar.field_appSupportContentType = entryReceiver.jEe;
                                            boolean n2 = am.bYJ().n(fVar);
                                            b.ajU(entryReceiver.appId);
                                            if (n2 && ah.isNullOrNil(fVar.field_openId)) {
                                                ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + entryReceiver.appId);
                                                am.bYL().wy(entryReceiver.appId);
                                            }
                                            AppMethodBeat.o(18197);
                                            return;
                                        }
                                        int i;
                                        if ((bT.field_appInfoFlag & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                                            i = entryReceiver.jEe != bT.field_appSupportContentType ? 1 : 0;
                                            bT.field_appSupportContentType = entryReceiver.jEe;
                                        } else {
                                            i = 0;
                                        }
                                        if (bT.field_status == 2 || bT.field_status == 3 || bT.field_status == 4 || i != 0) {
                                            if (!bT.xy()) {
                                                b.ajU(entryReceiver.appId);
                                            }
                                            bT.field_status = 0;
                                            ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, updateRet = ".concat(String.valueOf(am.bYJ().a(bT, new String[0]))));
                                        }
                                        if (ah.isNullOrNil(bT.field_openId)) {
                                            ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + entryReceiver.appId);
                                            am.bYL().wy(entryReceiver.appId);
                                        }
                                        AppMethodBeat.o(18197);
                                        return;
                                    } catch (IncompatibleClassChangeError e) {
                                        ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                                        IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                                        AppMethodBeat.o(18197);
                                        throw e2;
                                    } catch (Throwable th) {
                                        ab.printErrStackTrace("MicroMsg.WXEntryActivity", th, "package not installed", new Object[0]);
                                    }
                                } else {
                                    ab.e("MicroMsg.WXEntryActivity", "reg fail, check app fail");
                                    am.bYI().aiH(entryReceiver.appId);
                                    AppMethodBeat.o(18197);
                                    return;
                                }
                            }
                            ab.e("MicroMsg.WXEntryActivity", "no available account");
                            AppMethodBeat.o(18197);
                            return;
                        } else {
                            if ("unregisterapp".equals(authority)) {
                                ab.d("MicroMsg.WXEntryActivity", "handle app unregisteration: " + entryReceiver.Iw + ", sdkver=" + entryReceiver.jDs);
                                if (aw.RK()) {
                                    fVar = com.tencent.mm.pluginsdk.model.app.g.bT(entryReceiver.appId, false);
                                    if (!p.d(entryReceiver.context, fVar, entryReceiver.Iw)) {
                                        ab.e("MicroMsg.WXEntryActivity", "unreg fail, check app fail");
                                        AppMethodBeat.o(18197);
                                        return;
                                    } else if (!(fVar == null || fVar.field_status == 5)) {
                                        fVar.field_status = 4;
                                        am.bYJ().a(fVar, new String[0]);
                                        b.ajV(entryReceiver.appId);
                                    }
                                } else {
                                    ab.e("MicroMsg.WXEntryActivity", "no available account");
                                    AppMethodBeat.o(18197);
                                    return;
                                }
                            }
                            AppMethodBeat.o(18197);
                            return;
                        }
                    } catch (Exception e3) {
                        ab.e("MicroMsg.WXEntryActivity", "init: %s", e3.toString());
                        AppMethodBeat.o(18197);
                        return;
                    }
                }
            }
            ab.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + entryReceiver.jDs);
            AppMethodBeat.o(18197);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(18217);
        wXEntryActivity.goBack();
        AppMethodBeat.o(18217);
    }

    static /* synthetic */ void b(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(18218);
        wXEntryActivity.aVo();
        AppMethodBeat.o(18218);
    }

    static /* synthetic */ void c(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(18219);
        wXEntryActivity.aVp();
        AppMethodBeat.o(18219);
    }

    static /* synthetic */ boolean h(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(18216);
        boolean checkSumConsistent = checkSumConsistent(bArr, bArr2);
        AppMethodBeat.o(18216);
        return checkSumConsistent;
    }

    static /* synthetic */ byte[] q(String str, int i, String str2) {
        AppMethodBeat.i(18215);
        byte[] p = p(str, i, str2);
        AppMethodBeat.o(18215);
        return p;
    }

    static /* synthetic */ boolean rM(int i) {
        AppMethodBeat.i(18214);
        boolean rL = rL(i);
        AppMethodBeat.o(18214);
        return rL;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18198);
        w.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18190);
                WXEntryActivity.a(WXEntryActivity.this);
                AppMethodBeat.o(18190);
                return false;
            }
        });
        AppMethodBeat.o(18198);
    }

    private boolean P(Intent intent) {
        AppMethodBeat.i(18199);
        this.jDs = w.a(intent, ConstantsAPI.SDK_VERSION, 0);
        this.content = w.n(intent, ConstantsAPI.CONTENT);
        if (this.content != null) {
            this.uri = Uri.parse(this.content);
            this.authority = this.uri.getAuthority();
            try {
                this.appId = this.uri.getQueryParameter("appid");
                this.Iw = w.n(intent, ConstantsAPI.APP_PACKAGE);
                this.token = w.n(intent, ConstantsAPI.TOKEN);
                AppMethodBeat.o(18199);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.WXEntryActivity", "init: %s", e.toString());
                AppMethodBeat.o(18199);
                return false;
            }
        }
        AppMethodBeat.o(18199);
        return false;
    }

    public final boolean O(Intent intent) {
        AppMethodBeat.i(18200);
        if (P(intent)) {
            if (!aw.RK() || aw.QT()) {
                ab.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", this.appId);
                p.aiP(this.appId);
            }
            if (!rL(this.jDs)) {
                ab.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.jDs);
                finish();
                AppMethodBeat.o(18200);
                return false;
            } else if (this.uri == null) {
                ab.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                AppMethodBeat.o(18200);
                return false;
            } else {
                ab.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (ah.isNullOrNil(this.appId)) {
                    ab.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    AppMethodBeat.o(18200);
                    return false;
                }
                ab.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.Iw);
                if (ah.isNullOrNil(this.Iw)) {
                    ab.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    AppMethodBeat.o(18200);
                    return false;
                } else if (checkSumConsistent(w.o(intent, ConstantsAPI.CHECK_SUM), p(this.content, this.jDs, this.Iw))) {
                    AppMethodBeat.o(18200);
                    return true;
                } else {
                    ab.e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    AppMethodBeat.o(18200);
                    return false;
                }
            }
        }
        ab.e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        AppMethodBeat.o(18200);
        return false;
    }

    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        AppMethodBeat.i(18201);
        ab.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(aVar)));
        P(intent);
        switch (aVar) {
            case LOGIN_OK:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    ab.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    AppMethodBeat.o(18201);
                    return;
                }
                int i;
                ab.i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d, token = %s", Integer.valueOf(w.k(getIntent().getExtras(), "_wxapi_command_type")), this.token);
                h hVar = h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(Build.SDK_INT);
                objArr[2] = Integer.valueOf(this.jDs);
                if (aVn()) {
                    i = 0;
                } else {
                    i = this.jEc;
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.appId;
                hVar.e(15587, objArr);
                if (!aVn()) {
                    boolean z;
                    if (this.jDs < 620824064) {
                        z = false;
                    } else {
                        c ll = com.tencent.mm.model.c.c.abi().ll("100414");
                        if (ll.isValid() && "1".equals(ll.dru().get("blockInNewSDK"))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ab.d("MicroMsg.WXEntryActivity", "blockInvalidToken block %b", Boolean.valueOf(z));
                    }
                    if (z) {
                        Fw("");
                        AppMethodBeat.o(18201);
                        return;
                    }
                }
                if (r1 == 1) {
                    ab.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    i(null);
                    finish();
                    AppMethodBeat.o(18201);
                    return;
                }
                Req req = new Req(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = req.message;
                if (wXMediaMessage == null) {
                    ab.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    i(null);
                    finish();
                    AppMethodBeat.o(18201);
                    return;
                }
                int i2;
                String format;
                if (wXMediaMessage.getType() == 38 && wXMediaMessage.mediaObject != null && (wXMediaMessage.mediaObject instanceof WXVideoFileObject)) {
                    WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) wXMediaMessage.mediaObject;
                    if (wXVideoFileObject.shareScene == 1) {
                        SharedPreferences sharedPreferences = getSharedPreferences("opensdk_shareTicket", 0);
                        if (bo.isEqual(sharedPreferences.getString(this.Iw, ""), wXVideoFileObject.shareTicket)) {
                            sharedPreferences.edit().remove(this.Iw).apply();
                        } else {
                            ab.w("MicroMsg.WXEntryActivity", "shareTicket is wrong %s/%s", sharedPreferences.getString(this.Iw, ""), wXVideoFileObject.shareTicket);
                            aVp();
                            AppMethodBeat.o(18201);
                            return;
                        }
                    }
                }
                if ((wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46 || wXMediaMessage.getType() == 45) && req.scene != 3) {
                    req.scene = 0;
                }
                if (req.scene == 2) {
                    i2 = 3;
                } else if (req.scene == 1) {
                    i2 = 2;
                } else if (req.scene == 0) {
                    i2 = 1;
                } else if (req.scene == 3) {
                    i2 = 5;
                } else {
                    i2 = 0;
                }
                if (wXMediaMessage.getType() == 1) {
                    WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), kX(wXTextObject.text), "", wXMediaMessage.getType(), ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 5) {
                    WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), kX(wXMediaMessage.description), kX(wXWebpageObject.webpageUrl), wXMediaMessage.getType(), ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                    ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).a(((WXMiniProgramObject) wXMediaMessage.mediaObject).userName, null);
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), kX(wXMediaMessage.description), kX(r0.webpageUrl), wXMediaMessage.getType(), r0.userName, kX(r0.path), ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 45) {
                    WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), kX(wXEnterpriseCardObject.cardInfo), "", wXMediaMessage.getType(), ah.nullAsNil(req.userOpenId)});
                } else {
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), kX(wXMediaMessage.description), "", wXMediaMessage.getType(), ah.nullAsNil(req.userOpenId)});
                }
                if (!(ah.isNullOrNil(wXMediaMessage.mediaTagName) || ah.isNullOrNil(format))) {
                    format = format + "&mediaTagName=" + kX(wXMediaMessage.mediaTagName);
                }
                this.ehJ = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(18191);
                        WXEntryActivity.b(WXEntryActivity.this);
                        WXEntryActivity.this.finish();
                        AppMethodBeat.o(18191);
                    }
                });
                aw.Rg().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
                aw.Rg().a(new z(format, 1, new LinkedList()), 0);
                AppMethodBeat.o(18201);
                return;
            case LOGIN_CANCEL:
                aVo();
                ab.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                break;
            case LOGIN_FAIL:
                ReportUtil.a(this, ReportUtil.c(w.aM(getIntent()), -1), false);
                finish();
                ab.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                break;
            default:
                ab.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        finish();
        AppMethodBeat.o(18201);
    }

    private static String kX(String str) {
        AppMethodBeat.i(18202);
        if (ah.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(18202);
            return str;
        }
        try {
            str = URLEncoder.encode(str);
            AppMethodBeat.o(18202);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", str, e.getMessage());
            AppMethodBeat.o(18202);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0276 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i(m mVar) {
        boolean z;
        Exception e;
        v.b y;
        AppMethodBeat.i(18203);
        Intent intent = getIntent();
        ab.i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", Integer.valueOf(w.k(getIntent().getExtras(), "_wxapi_command_type")), this.authority);
        if (!"sendreq".equals(this.authority) && !"sendresp".equals(this.authority)) {
            ab.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
            AppMethodBeat.o(18203);
            return false;
        } else if (aw.RK()) {
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(this.appId, true);
            if (bT == null) {
                ab.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                AppMethodBeat.o(18203);
                return false;
            } else if (p.a(this, bT, this.Iw, true)) {
                boolean z2;
                Req req = new Req(intent.getExtras());
                if (mVar != null) {
                    ciq ajE = ((z) mVar).ajE();
                    if (ajE == null || ah.isNullOrNil(ajE.xhx)) {
                        z2 = false;
                        z = false;
                    } else {
                        try {
                            Uri parse = Uri.parse(ajE.xhx);
                            z = "1".equals(parse.getQueryParameter("returncancel"));
                            try {
                                z2 = "1".equals(parse.getQueryParameter("checkToken"));
                            } catch (Exception e2) {
                                e = e2;
                                z2 = false;
                            }
                            try {
                                if (req.scene == 3) {
                                    intent.putExtra("SendAppMessageWrapper_UserName", parse.getQueryParameter("username"));
                                }
                            } catch (Exception e3) {
                                e = e3;
                                ab.e("MicroMsg.WXEntryActivity", "dealRequest getQueryParameter exp: %s", e.getMessage());
                                y = v.Zp().y("kWXEntryActivity_data_center_session_id", true);
                                y.j("kWXEntryActivity_data_center_app_id", bT.field_appId);
                                y.j("kWXEntryActivity_data_center_can_return_cancel", Boolean.valueOf(z));
                                y.j("kWXEntryActivity_data_center_msg_type", Integer.valueOf(req.message.getType()));
                                y.j("kWXEntryActivity_data_center_scene", Integer.valueOf(req.scene));
                                if (req.scene != 2) {
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            z2 = false;
                            z = false;
                        }
                    }
                    y = v.Zp().y("kWXEntryActivity_data_center_session_id", true);
                    y.j("kWXEntryActivity_data_center_app_id", bT.field_appId);
                    y.j("kWXEntryActivity_data_center_can_return_cancel", Boolean.valueOf(z));
                    y.j("kWXEntryActivity_data_center_msg_type", Integer.valueOf(req.message.getType()));
                    y.j("kWXEntryActivity_data_center_scene", Integer.valueOf(req.scene));
                } else {
                    z2 = false;
                }
                if (req.scene != 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (req.message != null && req.message.getType() == 5) {
                        ab.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", bT.field_appId);
                        String nW = v.nW("app_" + bT.field_appId);
                        v.Zp().y(nW, true).j("prePublishId", "app_" + bT.field_appId);
                        intent2.putExtra("reportSessionId", nW);
                    }
                    d.b((Context) this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    AppMethodBeat.o(18203);
                    return true;
                }
                if (!(mVar == null || req.message == null)) {
                    ciq ajE2 = ((z) mVar).ajE();
                    if (req.message.getType() == 7) {
                        if (!(ajE2 == null || ajE2.xhz == null || ah.isNullOrNil(ajE2.xhz.url))) {
                            ab.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", ajE2.xhz.url);
                            req.message.mediaObject = new WXWebpageObject(ajE2.xhz.url);
                            Bundle bundle = new Bundle();
                            req.toBundle(bundle);
                            intent.putExtras(bundle);
                        }
                    } else if (!(req.message.getType() != 38 || ajE2 == null || ajE2.xhz == null)) {
                        intent.putExtra("SendAppMessageWrapper_VideoTime", ajE2.xhz.wYt);
                        intent.putExtra("SendAppMessageWrapper_ShouldCompressVideo", ajE2.xhz.wYu);
                    }
                }
                intent.putExtra("SendAppMessageWrapper_TokenValid", aVn());
                intent.putExtra("SendAppMessageWrapper_BlockInvalidToken", z2);
                startActivity(new Intent(this, UIEntryStub.class).addFlags(268435456).addFlags(67108864).putExtras(intent.getExtras()));
                AppMethodBeat.o(18203);
                return true;
            } else {
                ab.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", this.appId);
                am.bYI().aiH(this.appId);
                aVp();
                String str = this.Iw;
                Signature[] bx = p.bx(this, str);
                Object obj = "";
                if (bx != null && bx.length > 0) {
                    for (Signature toByteArray : bx) {
                        obj = obj + q.aiQ(com.tencent.mm.a.g.x(toByteArray.toByteArray())) + "|";
                    }
                }
                if (obj.length() > 1) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("raw_package_name", bo.bc(str, ""));
                    jSONObject.put("package_name", bo.bc(bT.field_packageName, ""));
                    jSONObject.put("raw_signature", obj);
                    jSONObject.put("signature", bo.bc(bT.field_signature, ""));
                    jSONObject.put("scene", r4);
                } catch (Exception e5) {
                    ab.i("MicroMsg.WXEntryActivity", "doIfAppInValid, jsonException = " + e5.getMessage());
                }
                hc hcVar = new hc();
                hcVar.cBN.appId = bT.field_appId;
                hcVar.cBN.opType = 3;
                hcVar.cBN.cvq = jSONObject.toString();
                com.tencent.mm.sdk.b.a.xxA.m(hcVar);
                AppMethodBeat.o(18203);
                return false;
            }
        } else {
            ab.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            AppMethodBeat.o(18203);
            return false;
        }
    }

    private boolean aVn() {
        AppMethodBeat.i(18204);
        if (this.jEb != null) {
            boolean booleanValue = this.jEb.booleanValue();
            AppMethodBeat.o(18204);
            return booleanValue;
        } else if (ah.isNullOrNil(this.token)) {
            ab.i("MicroMsg.WXEntryActivity", "token is null");
            this.jEb = Boolean.FALSE;
            this.jEc = 1;
            AppMethodBeat.o(18204);
            return false;
        } else {
            v.b nV = v.Zp().nV(this.token);
            if (nV != null) {
                if (nV.getString("open_sdk_token_package_name", "").equals(this.Iw)) {
                    ab.i("MicroMsg.WXEntryActivity", "token check success");
                    this.jEb = Boolean.TRUE;
                    AppMethodBeat.o(18204);
                    return true;
                }
                ab.w("MicroMsg.WXEntryActivity", "token check fail %s/%s", nV.getString("open_sdk_token_package_name", ""), this.Iw);
                this.jEb = Boolean.FALSE;
                this.jEc = 3;
                AppMethodBeat.o(18204);
                return false;
            }
            this.jEb = Boolean.FALSE;
            this.jEc = 2;
            ab.i("MicroMsg.WXEntryActivity", "keyValueSet is null");
            AppMethodBeat.o(18204);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.apt;
    }

    private static boolean rL(int i) {
        return i >= Build.MIN_SDK_INT;
    }

    private static byte[] p(String str, int i, String str2) {
        AppMethodBeat.i(18205);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = com.tencent.mm.a.g.x(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        AppMethodBeat.o(18205);
        return bytes;
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(18206);
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            ab.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            AppMethodBeat.o(18206);
            return false;
        } else if (bArr.length != bArr2.length) {
            ab.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            AppMethodBeat.o(18206);
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    AppMethodBeat.o(18206);
                    return false;
                }
            }
            AppMethodBeat.o(18206);
            return true;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(18207);
        ab.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aw.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3;
            z zVar = (z) mVar;
            if (zVar.ajE() != null) {
                i3 = zVar.ajE().version;
            } else {
                i3 = 0;
            }
            ab.i("MicroMsg.WXEntryActivity", "server appversion = %d", Integer.valueOf(i3));
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(this.appId, false);
            if (bT == null) {
                ab.e("MicroMsg.WXEntryActivity", "null appinfo");
                com.tencent.mm.plugin.s.a.a.a.bYQ().Us(this.appId);
            } else {
                ab.i("MicroMsg.WXEntryActivity", "local appversion = %d", Integer.valueOf(bT.field_appVersion));
                if (bT.field_appVersion < i3) {
                    com.tencent.mm.plugin.s.a.a.a.bYQ().Us(this.appId);
                }
            }
            i(mVar);
            finish();
            AppMethodBeat.o(18207);
        } else if (u.a.a(this, i, i2, null, 4)) {
            ab.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
            AppMethodBeat.o(18207);
        } else if (com.tencent.mm.kernel.a.QT()) {
            ab.w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
            AppMethodBeat.o(18207);
        } else {
            Fw(str);
            AppMethodBeat.o(18207);
        }
    }

    private void Fw(String str) {
        AppMethodBeat.i(18208);
        findViewById(R.id.e6d).setVisibility(0);
        setMMTitle((int) R.string.eh1);
        TextView textView = (TextView) findViewById(R.id.e6e);
        if (!ah.isNullOrNil(str)) {
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            if (str.startsWith("<e>")) {
                Map z = br.z(str, "e");
                if (!(z == null || ah.isNullOrNil((String) z.get(".e.Content")))) {
                    str = (String) z.get(".e.Content");
                }
            }
            textView.setText(getString(R.string.eh2, new Object[]{str}));
        }
        Button button = (Button) findViewById(R.id.e6f);
        String t = com.tencent.mm.pluginsdk.model.app.g.t(this, this.appId);
        ab.i("MicroMsg.WXEntryActivity", "appName = %s", t);
        if (ah.isNullOrNil(t)) {
            button.setText(R.string.egz);
        } else {
            button.setText(getString(R.string.egz) + t);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18192);
                WXEntryActivity.c(WXEntryActivity.this);
                WXEntryActivity.this.finish();
                AppMethodBeat.o(18192);
            }
        });
        AppMethodBeat.o(18208);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(18209);
        if (keyEvent.getRepeatCount() == 0 && keyEvent.getKeyCode() == 4) {
            ab.i("MicroMsg.WXEntryActivity", "user click back button");
            goBack();
            AppMethodBeat.o(18209);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(18209);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(18210);
        View findViewById = findViewById(R.id.e6d);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            aVo();
            AppMethodBeat.o(18210);
            return;
        }
        aVp();
        AppMethodBeat.o(18210);
    }

    private void aVo() {
        AppMethodBeat.i(18211);
        ReportUtil.a(this, ReportUtil.c(w.aM(getIntent()), -2));
        finish();
        AppMethodBeat.o(18211);
    }

    private void aVp() {
        AppMethodBeat.i(18212);
        ReportUtil.a(this, ReportUtil.c(w.aM(getIntent()), -6), false);
        finish();
        AppMethodBeat.o(18212);
    }

    public void onDestroy() {
        AppMethodBeat.i(18213);
        super.onDestroy();
        aw.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
        AppMethodBeat.o(18213);
    }
}
