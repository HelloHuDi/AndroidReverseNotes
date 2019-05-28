package com.tencent.p177mm.plugin.base.stub;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C41999hc;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44095b;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.rtmp.TXLivePushConfig;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.plugin.base.stub.WXEntryActivity */
public class WXEntryActivity extends AutoLoginActivity implements C1202f {
    /* renamed from: Iw */
    private String f16160Iw;
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog ehJ;
    private int jDs;
    private Boolean jEb = null;
    private int jEc = 0;
    private String token;
    private Uri uri;

    /* renamed from: com.tencent.mm.plugin.base.stub.WXEntryActivity$2 */
    class C111712 implements OnCancelListener {
        C111712() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(18191);
            WXEntryActivity.m65585b(WXEntryActivity.this);
            WXEntryActivity.this.finish();
            AppMethodBeat.m2505o(18191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXEntryActivity$3 */
    class C111723 implements OnClickListener {
        C111723() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18192);
            WXEntryActivity.m65586c(WXEntryActivity.this);
            WXEntryActivity.this.finish();
            AppMethodBeat.m2505o(18192);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXEntryActivity$1 */
    class C274961 implements OnMenuItemClickListener {
        C274961() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18190);
            WXEntryActivity.m65584a(WXEntryActivity.this);
            AppMethodBeat.m2505o(18190);
            return false;
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    /* renamed from: com.tencent.mm.plugin.base.stub.WXEntryActivity$EntryReceiver */
    public static class EntryReceiver extends BroadcastReceiver {
        private static C7306ak handler;
        /* renamed from: Iw */
        private String f16161Iw;
        private String appId;
        private String appName;
        private Context context;
        private int jDs;
        private long jEe;

        public void onReceive(final Context context, final Intent intent) {
            AppMethodBeat.m2504i(18196);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(18196);
                return;
            }
            C25985d.dlL();
            if (handler == null) {
                HandlerThread anM = C7305d.anM("WXEntryReceiver");
                anM.start();
                handler = new C7306ak(anM.getLooper());
            }
            if (C1720g.m3537RQ().eKi.eKC) {
                handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18195);
                        long currentTimeMillis = System.currentTimeMillis();
                        EntryReceiver.m65596a(EntryReceiver.this, context, intent);
                        C4990ab.m7417i("MicroMsg.WXEntryActivity", "cost:%s", (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(18195);
                    }
                });
                AppMethodBeat.m2505o(18196);
                return;
            }
            C1720g.m3537RQ().mo5252a(new C1675g() {
                /* renamed from: BR */
                public final void mo5176BR() {
                    AppMethodBeat.m2504i(18194);
                    C1720g.m3537RQ().mo5255b(this);
                    EntryReceiver.m65596a(EntryReceiver.this, context, intent);
                    AppMethodBeat.m2505o(18194);
                }

                /* renamed from: bi */
                public final void mo5177bi(boolean z) {
                }
            });
            AppMethodBeat.m2505o(18196);
        }

        /* JADX WARNING: Missing block: B:62:0x020a, code skipped:
            if (r0 == false) goto L_0x020c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        static /* synthetic */ void m65596a(EntryReceiver entryReceiver, Context context, Intent intent) {
            AppMethodBeat.m2504i(18197);
            entryReceiver.context = context;
            String n = C5068w.m7689n(intent, ConstantsAPI.CONTENT);
            entryReceiver.jEe = C5068w.m7688m(intent, ConstantsAPI.APP_SUPORT_CONTENT_TYPE);
            entryReceiver.jDs = C5068w.m7682a(intent, ConstantsAPI.SDK_VERSION, 0);
            if (WXEntryActivity.m65593rM(entryReceiver.jDs)) {
                entryReceiver.f16161Iw = C5068w.m7689n(intent, ConstantsAPI.APP_PACKAGE);
                if (entryReceiver.f16161Iw == null || entryReceiver.f16161Iw.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    AppMethodBeat.m2505o(18197);
                    return;
                } else if (!WXEntryActivity.m65587h(C5068w.m7690o(intent, ConstantsAPI.CHECK_SUM), WXEntryActivity.m65591q(n, entryReceiver.jDs, entryReceiver.f16161Iw))) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "checksum fail");
                    AppMethodBeat.m2505o(18197);
                    return;
                } else if (n == null) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                    AppMethodBeat.m2505o(18197);
                    return;
                } else {
                    Uri parse = Uri.parse(n);
                    String authority = parse.getAuthority();
                    try {
                        entryReceiver.appId = parse.getQueryParameter("appid");
                        C4990ab.m7416i("MicroMsg.WXEntryActivity", "onReceive, appId = " + entryReceiver.appId);
                        C40439f c40439f;
                        if (entryReceiver.appId == null || entryReceiver.appId.length() <= 0) {
                            C4990ab.m7412e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                            AppMethodBeat.m2505o(18197);
                            return;
                        } else if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
                            C4990ab.m7421w("MicroMsg.WXEntryActivity", "not login, just save the appid : %s", entryReceiver.appId);
                            C35799p.aiP(entryReceiver.appId);
                            AppMethodBeat.m2505o(18197);
                            return;
                        } else if (!C1720g.m3534RN().eJb) {
                            C4990ab.m7421w("MicroMsg.WXEntryActivity", "not login accInitializing, just save the appid : %s", entryReceiver.appId);
                            C35799p.aiP(entryReceiver.appId);
                            AppMethodBeat.m2505o(18197);
                            return;
                        } else if ("registerapp".equals(authority)) {
                            C4990ab.m7416i("MicroMsg.WXEntryActivity", "handle app registeration: " + entryReceiver.f16161Iw + ", sdkver=" + entryReceiver.jDs);
                            if (C9638aw.m17179RK()) {
                                C40439f bT = C46494g.m87739bT(entryReceiver.appId, true);
                                if (C35799p.m58692d(entryReceiver.context, bT, entryReceiver.f16161Iw)) {
                                    if (bT != null && bT.mo63847xy()) {
                                        C43155a bDb = C20928a.bDb();
                                        if (bDb != null) {
                                            bDb.mo36281j(entryReceiver.context, entryReceiver.appId, entryReceiver.f16161Iw);
                                        }
                                    }
                                    Bitmap bitmap = null;
                                    try {
                                        PackageManager packageManager = entryReceiver.context.getPackageManager();
                                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(entryReceiver.f16161Iw, 0);
                                        if (applicationInfo == null) {
                                            C4990ab.m7412e("MicroMsg.WXEntryActivity", "package not installed");
                                            AppMethodBeat.m2505o(18197);
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
                                            C14877am.bYJ();
                                            n = entryReceiver.appId;
                                            boolean z;
                                            if (n == null || n.length() == 0) {
                                                C4990ab.m7412e("MicroMsg.AppInfoStorage", "hasIcon, appId is null");
                                                z = false;
                                            } else {
                                                z = C1173e.m2561ct(C35796i.m58670dY(n, 1));
                                            }
                                        }
                                        C14877am.bYJ().mo56574t(entryReceiver.appId, bitmap);
                                        if (bT == null) {
                                            c40439f = new C40439f();
                                            c40439f.field_appId = entryReceiver.appId;
                                            c40439f.field_appName = "";
                                            c40439f.field_packageName = entryReceiver.f16161Iw;
                                            c40439f.field_status = 0;
                                            authority = C35799p.m58690bw(entryReceiver.context, entryReceiver.f16161Iw);
                                            if (authority != null) {
                                                c40439f.field_signature = authority;
                                            }
                                            c40439f.field_modifyTime = System.currentTimeMillis();
                                            c40439f.field_appSupportContentType = entryReceiver.jEe;
                                            boolean n2 = C14877am.bYJ().mo56573n(c40439f);
                                            C44095b.ajU(entryReceiver.appId);
                                            if (n2 && C42252ah.isNullOrNil(c40439f.field_openId)) {
                                                C4990ab.m7410d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + entryReceiver.appId);
                                                C14877am.bYL().mo9878wy(entryReceiver.appId);
                                            }
                                            AppMethodBeat.m2505o(18197);
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
                                            if (!bT.mo63847xy()) {
                                                C44095b.ajU(entryReceiver.appId);
                                            }
                                            bT.field_status = 0;
                                            C4990ab.m7410d("MicroMsg.WXEntryActivity", "handleAppRegisteration, updateRet = ".concat(String.valueOf(C14877am.bYJ().mo56566a(bT, new String[0]))));
                                        }
                                        if (C42252ah.isNullOrNil(bT.field_openId)) {
                                            C4990ab.m7410d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + entryReceiver.appId);
                                            C14877am.bYL().mo9878wy(entryReceiver.appId);
                                        }
                                        AppMethodBeat.m2505o(18197);
                                        return;
                                    } catch (IncompatibleClassChangeError e) {
                                        C4990ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                                        IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                                        AppMethodBeat.m2505o(18197);
                                        throw e2;
                                    } catch (Throwable th) {
                                        C4990ab.printErrStackTrace("MicroMsg.WXEntryActivity", th, "package not installed", new Object[0]);
                                    }
                                } else {
                                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "reg fail, check app fail");
                                    C14877am.bYI().aiH(entryReceiver.appId);
                                    AppMethodBeat.m2505o(18197);
                                    return;
                                }
                            }
                            C4990ab.m7412e("MicroMsg.WXEntryActivity", "no available account");
                            AppMethodBeat.m2505o(18197);
                            return;
                        } else {
                            if ("unregisterapp".equals(authority)) {
                                C4990ab.m7410d("MicroMsg.WXEntryActivity", "handle app unregisteration: " + entryReceiver.f16161Iw + ", sdkver=" + entryReceiver.jDs);
                                if (C9638aw.m17179RK()) {
                                    c40439f = C46494g.m87739bT(entryReceiver.appId, false);
                                    if (!C35799p.m58692d(entryReceiver.context, c40439f, entryReceiver.f16161Iw)) {
                                        C4990ab.m7412e("MicroMsg.WXEntryActivity", "unreg fail, check app fail");
                                        AppMethodBeat.m2505o(18197);
                                        return;
                                    } else if (!(c40439f == null || c40439f.field_status == 5)) {
                                        c40439f.field_status = 4;
                                        C14877am.bYJ().mo56566a(c40439f, new String[0]);
                                        C44095b.ajV(entryReceiver.appId);
                                    }
                                } else {
                                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "no available account");
                                    AppMethodBeat.m2505o(18197);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(18197);
                            return;
                        }
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.WXEntryActivity", "init: %s", e3.toString());
                        AppMethodBeat.m2505o(18197);
                        return;
                    }
                }
            }
            C4990ab.m7412e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + entryReceiver.jDs);
            AppMethodBeat.m2505o(18197);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m65584a(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.m2504i(18217);
        wXEntryActivity.goBack();
        AppMethodBeat.m2505o(18217);
    }

    /* renamed from: b */
    static /* synthetic */ void m65585b(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.m2504i(18218);
        wXEntryActivity.aVo();
        AppMethodBeat.m2505o(18218);
    }

    /* renamed from: c */
    static /* synthetic */ void m65586c(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.m2504i(18219);
        wXEntryActivity.aVp();
        AppMethodBeat.m2505o(18219);
    }

    /* renamed from: h */
    static /* synthetic */ boolean m65587h(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(18216);
        boolean checkSumConsistent = WXEntryActivity.checkSumConsistent(bArr, bArr2);
        AppMethodBeat.m2505o(18216);
        return checkSumConsistent;
    }

    /* renamed from: q */
    static /* synthetic */ byte[] m65591q(String str, int i, String str2) {
        AppMethodBeat.m2504i(18215);
        byte[] p = WXEntryActivity.m65590p(str, i, str2);
        AppMethodBeat.m2505o(18215);
        return p;
    }

    /* renamed from: rM */
    static /* synthetic */ boolean m65593rM(int i) {
        AppMethodBeat.m2504i(18214);
        boolean rL = WXEntryActivity.m65592rL(i);
        AppMethodBeat.m2505o(18214);
        return rL;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18198);
        C5068w.m7685b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new C274961());
        AppMethodBeat.m2505o(18198);
    }

    /* renamed from: P */
    private boolean m65583P(Intent intent) {
        AppMethodBeat.m2504i(18199);
        this.jDs = C5068w.m7682a(intent, ConstantsAPI.SDK_VERSION, 0);
        this.content = C5068w.m7689n(intent, ConstantsAPI.CONTENT);
        if (this.content != null) {
            this.uri = Uri.parse(this.content);
            this.authority = this.uri.getAuthority();
            try {
                this.appId = this.uri.getQueryParameter("appid");
                this.f16160Iw = C5068w.m7689n(intent, ConstantsAPI.APP_PACKAGE);
                this.token = C5068w.m7689n(intent, ConstantsAPI.TOKEN);
                AppMethodBeat.m2505o(18199);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WXEntryActivity", "init: %s", e.toString());
                AppMethodBeat.m2505o(18199);
                return false;
            }
        }
        AppMethodBeat.m2505o(18199);
        return false;
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        AppMethodBeat.m2504i(18200);
        if (m65583P(intent)) {
            if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
                C4990ab.m7421w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", this.appId);
                C35799p.aiP(this.appId);
            }
            if (!WXEntryActivity.m65592rL(this.jDs)) {
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.jDs);
                finish();
                AppMethodBeat.m2505o(18200);
                return false;
            } else if (this.uri == null) {
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                AppMethodBeat.m2505o(18200);
                return false;
            } else {
                C4990ab.m7416i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (C42252ah.isNullOrNil(this.appId)) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    AppMethodBeat.m2505o(18200);
                    return false;
                }
                C4990ab.m7416i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.f16160Iw);
                if (C42252ah.isNullOrNil(this.f16160Iw)) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    AppMethodBeat.m2505o(18200);
                    return false;
                } else if (WXEntryActivity.checkSumConsistent(C5068w.m7690o(intent, ConstantsAPI.CHECK_SUM), WXEntryActivity.m65590p(this.content, this.jDs, this.f16160Iw))) {
                    AppMethodBeat.m2505o(18200);
                    return true;
                } else {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    AppMethodBeat.m2505o(18200);
                    return false;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        AppMethodBeat.m2505o(18200);
        return false;
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(18201);
        C4990ab.m7410d("MicroMsg.WXEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(c4737a)));
        m65583P(intent);
        switch (c4737a) {
            case LOGIN_OK:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    AppMethodBeat.m2505o(18201);
                    return;
                }
                int i;
                C4990ab.m7417i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d, token = %s", Integer.valueOf(C5068w.m7686k(getIntent().getExtras(), "_wxapi_command_type")), this.token);
                C7060h c7060h = C7060h.pYm;
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
                c7060h.mo8381e(15587, objArr);
                if (!aVn()) {
                    boolean z;
                    if (this.jDs < 620824064) {
                        z = false;
                    } else {
                        C5141c ll = C18624c.abi().mo17131ll("100414");
                        if (ll.isValid() && "1".equals(ll.dru().get("blockInNewSDK"))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C4990ab.m7411d("MicroMsg.WXEntryActivity", "blockInvalidToken block %b", Boolean.valueOf(z));
                    }
                    if (z) {
                        m65582Fw("");
                        AppMethodBeat.m2505o(18201);
                        return;
                    }
                }
                if (r1 == 1) {
                    C4990ab.m7416i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    m65588i(null);
                    finish();
                    AppMethodBeat.m2505o(18201);
                    return;
                }
                Req req = new Req(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = req.message;
                if (wXMediaMessage == null) {
                    C4990ab.m7412e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    m65588i(null);
                    finish();
                    AppMethodBeat.m2505o(18201);
                    return;
                }
                int i2;
                String format;
                if (wXMediaMessage.getType() == 38 && wXMediaMessage.mediaObject != null && (wXMediaMessage.mediaObject instanceof WXVideoFileObject)) {
                    WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) wXMediaMessage.mediaObject;
                    if (wXVideoFileObject.shareScene == 1) {
                        SharedPreferences sharedPreferences = getSharedPreferences("opensdk_shareTicket", 0);
                        if (C5046bo.isEqual(sharedPreferences.getString(this.f16160Iw, ""), wXVideoFileObject.shareTicket)) {
                            sharedPreferences.edit().remove(this.f16160Iw).apply();
                        } else {
                            C4990ab.m7421w("MicroMsg.WXEntryActivity", "shareTicket is wrong %s/%s", sharedPreferences.getString(this.f16160Iw, ""), wXVideoFileObject.shareTicket);
                            aVp();
                            AppMethodBeat.m2505o(18201);
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
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), WXEntryActivity.m65589kX(wXTextObject.text), "", wXMediaMessage.getType(), C42252ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 5) {
                    WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), WXEntryActivity.m65589kX(wXMediaMessage.description), WXEntryActivity.m65589kX(wXWebpageObject.webpageUrl), wXMediaMessage.getType(), C42252ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                    ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(((WXMiniProgramObject) wXMediaMessage.mediaObject).userName, null);
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), WXEntryActivity.m65589kX(wXMediaMessage.description), WXEntryActivity.m65589kX(r0.webpageUrl), wXMediaMessage.getType(), r0.userName, WXEntryActivity.m65589kX(r0.path), C42252ah.nullAsNil(req.userOpenId)});
                } else if (wXMediaMessage.getType() == 45) {
                    WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), WXEntryActivity.m65589kX(wXEnterpriseCardObject.cardInfo), "", wXMediaMessage.getType(), C42252ah.nullAsNil(req.userOpenId)});
                } else {
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&userOpenid=%s", new Object[]{this.appId, Integer.valueOf(i2), WXEntryActivity.m65589kX(wXMediaMessage.description), "", wXMediaMessage.getType(), C42252ah.nullAsNil(req.userOpenId)});
                }
                if (!(C42252ah.isNullOrNil(wXMediaMessage.mediaTagName) || C42252ah.isNullOrNil(format))) {
                    format = format + "&mediaTagName=" + WXEntryActivity.m65589kX(wXMediaMessage.mediaTagName);
                }
                this.ehJ = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.f9260un), true, new C111712());
                C9638aw.m17182Rg().mo14539a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
                C9638aw.m17182Rg().mo14541a(new C26475z(format, 1, new LinkedList()), 0);
                AppMethodBeat.m2505o(18201);
                return;
            case LOGIN_CANCEL:
                aVo();
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                break;
            case LOGIN_FAIL:
                ReportUtil.m79192a(this, ReportUtil.m79195c(C5068w.m7684aM(getIntent()), -1), false);
                finish();
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                break;
            default:
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(c4737a)));
                break;
        }
        finish();
        AppMethodBeat.m2505o(18201);
    }

    /* renamed from: kX */
    private static String m65589kX(String str) {
        AppMethodBeat.m2504i(18202);
        if (C42252ah.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(18202);
            return str;
        }
        try {
            str = URLEncoder.encode(str);
            AppMethodBeat.m2505o(18202);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", str, e.getMessage());
            AppMethodBeat.m2505o(18202);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0276 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private boolean m65588i(C1207m c1207m) {
        boolean z;
        Exception e;
        C32800b y;
        AppMethodBeat.m2504i(18203);
        Intent intent = getIntent();
        C4990ab.m7417i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", Integer.valueOf(C5068w.m7686k(getIntent().getExtras(), "_wxapi_command_type")), this.authority);
        if (!"sendreq".equals(this.authority) && !"sendresp".equals(this.authority)) {
            C4990ab.m7412e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
            AppMethodBeat.m2505o(18203);
            return false;
        } else if (C9638aw.m17179RK()) {
            C40439f bT = C46494g.m87739bT(this.appId, true);
            if (bT == null) {
                C4990ab.m7420w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                AppMethodBeat.m2505o(18203);
                return false;
            } else if (C35799p.m58686a(this, bT, this.f16160Iw, true)) {
                boolean z2;
                Req req = new Req(intent.getExtras());
                if (c1207m != null) {
                    ciq ajE = ((C26475z) c1207m).ajE();
                    if (ajE == null || C42252ah.isNullOrNil(ajE.xhx)) {
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
                                C4990ab.m7413e("MicroMsg.WXEntryActivity", "dealRequest getQueryParameter exp: %s", e.getMessage());
                                y = C37922v.m64076Zp().mo60676y("kWXEntryActivity_data_center_session_id", true);
                                y.mo53356j("kWXEntryActivity_data_center_app_id", bT.field_appId);
                                y.mo53356j("kWXEntryActivity_data_center_can_return_cancel", Boolean.valueOf(z));
                                y.mo53356j("kWXEntryActivity_data_center_msg_type", Integer.valueOf(req.message.getType()));
                                y.mo53356j("kWXEntryActivity_data_center_scene", Integer.valueOf(req.scene));
                                if (req.scene != 2) {
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            z2 = false;
                            z = false;
                        }
                    }
                    y = C37922v.m64076Zp().mo60676y("kWXEntryActivity_data_center_session_id", true);
                    y.mo53356j("kWXEntryActivity_data_center_app_id", bT.field_appId);
                    y.mo53356j("kWXEntryActivity_data_center_can_return_cancel", Boolean.valueOf(z));
                    y.mo53356j("kWXEntryActivity_data_center_msg_type", Integer.valueOf(req.message.getType()));
                    y.mo53356j("kWXEntryActivity_data_center_scene", Integer.valueOf(req.scene));
                } else {
                    z2 = false;
                }
                if (req.scene != 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (req.message != null && req.message.getType() == 5) {
                        C4990ab.m7411d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", bT.field_appId);
                        String nW = C37922v.m64078nW("app_" + bT.field_appId);
                        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "app_" + bT.field_appId);
                        intent2.putExtra("reportSessionId", nW);
                    }
                    C25985d.m41467b((Context) this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    AppMethodBeat.m2505o(18203);
                    return true;
                }
                if (!(c1207m == null || req.message == null)) {
                    ciq ajE2 = ((C26475z) c1207m).ajE();
                    if (req.message.getType() == 7) {
                        if (!(ajE2 == null || ajE2.xhz == null || C42252ah.isNullOrNil(ajE2.xhz.url))) {
                            C4990ab.m7417i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", ajE2.xhz.url);
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
                AppMethodBeat.m2505o(18203);
                return true;
            } else {
                C4990ab.m7413e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", this.appId);
                C14877am.bYI().aiH(this.appId);
                aVp();
                String str = this.f16160Iw;
                Signature[] bx = C35799p.m58691bx(this, str);
                Object obj = "";
                if (bx != null && bx.length > 0) {
                    for (Signature toByteArray : bx) {
                        obj = obj + C35800q.aiQ(C1178g.m2591x(toByteArray.toByteArray())) + "|";
                    }
                }
                if (obj.length() > 1) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("raw_package_name", C5046bo.m7532bc(str, ""));
                    jSONObject.put("package_name", C5046bo.m7532bc(bT.field_packageName, ""));
                    jSONObject.put("raw_signature", obj);
                    jSONObject.put("signature", C5046bo.m7532bc(bT.field_signature, ""));
                    jSONObject.put("scene", r4);
                } catch (Exception e5) {
                    C4990ab.m7416i("MicroMsg.WXEntryActivity", "doIfAppInValid, jsonException = " + e5.getMessage());
                }
                C41999hc c41999hc = new C41999hc();
                c41999hc.cBN.appId = bT.field_appId;
                c41999hc.cBN.opType = 3;
                c41999hc.cBN.cvq = jSONObject.toString();
                C4879a.xxA.mo10055m(c41999hc);
                AppMethodBeat.m2505o(18203);
                return false;
            }
        } else {
            C4990ab.m7420w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            AppMethodBeat.m2505o(18203);
            return false;
        }
    }

    private boolean aVn() {
        AppMethodBeat.m2504i(18204);
        if (this.jEb != null) {
            boolean booleanValue = this.jEb.booleanValue();
            AppMethodBeat.m2505o(18204);
            return booleanValue;
        } else if (C42252ah.isNullOrNil(this.token)) {
            C4990ab.m7416i("MicroMsg.WXEntryActivity", "token is null");
            this.jEb = Boolean.FALSE;
            this.jEc = 1;
            AppMethodBeat.m2505o(18204);
            return false;
        } else {
            C32800b nV = C37922v.m64076Zp().mo60674nV(this.token);
            if (nV != null) {
                if (nV.getString("open_sdk_token_package_name", "").equals(this.f16160Iw)) {
                    C4990ab.m7416i("MicroMsg.WXEntryActivity", "token check success");
                    this.jEb = Boolean.TRUE;
                    AppMethodBeat.m2505o(18204);
                    return true;
                }
                C4990ab.m7421w("MicroMsg.WXEntryActivity", "token check fail %s/%s", nV.getString("open_sdk_token_package_name", ""), this.f16160Iw);
                this.jEb = Boolean.FALSE;
                this.jEc = 3;
                AppMethodBeat.m2505o(18204);
                return false;
            }
            this.jEb = Boolean.FALSE;
            this.jEc = 2;
            C4990ab.m7416i("MicroMsg.WXEntryActivity", "keyValueSet is null");
            AppMethodBeat.m2505o(18204);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130970561;
    }

    /* renamed from: rL */
    private static boolean m65592rL(int i) {
        return i >= Build.MIN_SDK_INT;
    }

    /* renamed from: p */
    private static byte[] m65590p(String str, int i, String str2) {
        AppMethodBeat.m2504i(18205);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = C1178g.m2591x(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        AppMethodBeat.m2505o(18205);
        return bytes;
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(18206);
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            C4990ab.m7412e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            AppMethodBeat.m2505o(18206);
            return false;
        } else if (bArr.length != bArr2.length) {
            C4990ab.m7412e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            AppMethodBeat.m2505o(18206);
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    AppMethodBeat.m2505o(18206);
                    return false;
                }
            }
            AppMethodBeat.m2505o(18206);
            return true;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(18207);
        C4990ab.m7417i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C9638aw.m17182Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3;
            C26475z c26475z = (C26475z) c1207m;
            if (c26475z.ajE() != null) {
                i3 = c26475z.ajE().version;
            } else {
                i3 = 0;
            }
            C4990ab.m7417i("MicroMsg.WXEntryActivity", "server appversion = %d", Integer.valueOf(i3));
            C40439f bT = C46494g.m87739bT(this.appId, false);
            if (bT == null) {
                C4990ab.m7412e("MicroMsg.WXEntryActivity", "null appinfo");
                C3753a.bYQ().mo25135Us(this.appId);
            } else {
                C4990ab.m7417i("MicroMsg.WXEntryActivity", "local appversion = %d", Integer.valueOf(bT.field_appVersion));
                if (bT.field_appVersion < i3) {
                    C3753a.bYQ().mo25135Us(this.appId);
                }
            }
            m65588i(c1207m);
            finish();
            AppMethodBeat.m2505o(18207);
        } else if (C30784a.m49123a(this, i, i2, null, 4)) {
            C4990ab.m7416i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
            AppMethodBeat.m2505o(18207);
        } else if (C1668a.m3393QT()) {
            C4990ab.m7420w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
            AppMethodBeat.m2505o(18207);
        } else {
            m65582Fw(str);
            AppMethodBeat.m2505o(18207);
        }
    }

    /* renamed from: Fw */
    private void m65582Fw(String str) {
        AppMethodBeat.m2504i(18208);
        findViewById(2131827254).setVisibility(0);
        setMMTitle((int) C25738R.string.eh1);
        TextView textView = (TextView) findViewById(2131827255);
        if (!C42252ah.isNullOrNil(str)) {
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            if (str.startsWith("<e>")) {
                Map z = C5049br.m7595z(str, "e");
                if (!(z == null || C42252ah.isNullOrNil((String) z.get(".e.Content")))) {
                    str = (String) z.get(".e.Content");
                }
            }
            textView.setText(getString(C25738R.string.eh2, new Object[]{str}));
        }
        Button button = (Button) findViewById(2131827256);
        String t = C46494g.m87756t(this, this.appId);
        C4990ab.m7417i("MicroMsg.WXEntryActivity", "appName = %s", t);
        if (C42252ah.isNullOrNil(t)) {
            button.setText(C25738R.string.egz);
        } else {
            button.setText(getString(C25738R.string.egz) + t);
        }
        button.setOnClickListener(new C111723());
        AppMethodBeat.m2505o(18208);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(18209);
        if (keyEvent.getRepeatCount() == 0 && keyEvent.getKeyCode() == 4) {
            C4990ab.m7416i("MicroMsg.WXEntryActivity", "user click back button");
            goBack();
            AppMethodBeat.m2505o(18209);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(18209);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(18210);
        View findViewById = findViewById(2131827254);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            aVo();
            AppMethodBeat.m2505o(18210);
            return;
        }
        aVp();
        AppMethodBeat.m2505o(18210);
    }

    private void aVo() {
        AppMethodBeat.m2504i(18211);
        ReportUtil.m79191a(this, ReportUtil.m79195c(C5068w.m7684aM(getIntent()), -2));
        finish();
        AppMethodBeat.m2505o(18211);
    }

    private void aVp() {
        AppMethodBeat.m2504i(18212);
        ReportUtil.m79192a(this, ReportUtil.m79195c(C5068w.m7684aM(getIntent()), -6), false);
        finish();
        AppMethodBeat.m2505o(18212);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18213);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
        AppMethodBeat.m2505o(18213);
    }
}
