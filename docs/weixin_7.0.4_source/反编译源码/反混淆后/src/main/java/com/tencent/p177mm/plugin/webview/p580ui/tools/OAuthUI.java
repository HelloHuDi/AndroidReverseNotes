package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C4592e.C4593a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.p177mm.plugin.webview.stub.C22913c;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI */
public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean ocw = false;
    private boolean urT = true;
    private Req urU;
    private C4592e urV;
    private C7564ap urW;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$5 */
    class C45705 implements OnMenuItemClickListener {
        C45705() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7421);
            OAuthUI.m58469a(OAuthUI.this);
            OAuthUI.this.finish();
            AppMethodBeat.m2505o(7421);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$6 */
    class C45716 implements OnMenuItemClickListener {
        C45716() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7422);
            if (OAuthUI.this.urV != null) {
                OAuthUI.this.urV;
            }
            OAuthUI.this.pzf.stopLoading();
            OAuthUI.this.mo30947X(false, false);
            OAuthUI.m58474c(OAuthUI.this);
            AppMethodBeat.m2505o(7422);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$7 */
    class C45727 implements C4593a {
        C45727() {
        }

        /* renamed from: a */
        public final void mo9659a(C4592e c4592e, String str, boolean z) {
            AppMethodBeat.m2504i(7423);
            C4990ab.m7416i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
            c4592e.urO = false;
            if (z) {
                Object string;
                try {
                    string = OAuthUI.this.getString(C25738R.string.da3);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                    string = null;
                }
                C4990ab.m7416i("MicroMsg.OAuthUI", "onResult, html = ".concat(String.valueOf(string)));
                if (OAuthUI.this.pzf != null) {
                    OAuthUI.this.pzf.loadUrl(string);
                    if (OAuthUI.this.ulI != null) {
                        OAuthUI.this.ulI.cXX().cOG = string;
                    }
                }
                AppMethodBeat.m2505o(7423);
                return;
            }
            if (!(C5046bo.isNullOrNil(str) || OAuthUI.this.pzf == null)) {
                OAuthUI.this.pzf.loadUrl(str);
                if (OAuthUI.this.ulI != null) {
                    OAuthUI.this.ulI.cXX().cOG = str;
                }
            }
            AppMethodBeat.m2505o(7423);
        }

        /* renamed from: d */
        public final void mo9660d(boolean z, String str, String str2, String str3) {
            AppMethodBeat.m2504i(7424);
            if (z) {
                OAuthUI.m58471a(OAuthUI.this, str2, str3, str);
                AppMethodBeat.m2505o(7424);
                return;
            }
            OAuthUI.m58473b(OAuthUI.this, str3);
            AppMethodBeat.m2505o(7424);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$2 */
    class C356262 extends C6031l {
        C356262() {
        }

        /* renamed from: d */
        public final void mo7557d(WebView webView, String str) {
            AppMethodBeat.m2504i(7418);
            super.mo7557d(webView, str);
            OAuthUI.this.setMMTitle(str);
            AppMethodBeat.m2505o(7418);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$3 */
    class C356273 extends C14579h {
        C356273() {
            super();
        }

        public final boolean aft(String str) {
            AppMethodBeat.m2504i(7419);
            C4990ab.m7416i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = ".concat(String.valueOf(str)));
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                AppMethodBeat.m2505o(7419);
            } else {
                OAuthUI.m58470a(OAuthUI.this, str);
                AppMethodBeat.m2505o(7419);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$1 */
    class C356281 implements OnMenuItemClickListener {
        C356281() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7417);
            OAuthUI.this.finish();
            AppMethodBeat.m2505o(7417);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OAuthUI$4 */
    class C356294 implements DownloadListener {
        C356294() {
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.m2504i(7420);
            OAuthUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            AppMethodBeat.m2505o(7420);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m58469a(OAuthUI oAuthUI) {
        AppMethodBeat.m2504i(7438);
        oAuthUI.cZz();
        AppMethodBeat.m2505o(7438);
    }

    /* renamed from: c */
    static /* synthetic */ void m58474c(OAuthUI oAuthUI) {
        AppMethodBeat.m2504i(7439);
        oAuthUI.cZB();
        AppMethodBeat.m2505o(7439);
    }

    public void onResume() {
        AppMethodBeat.m2504i(7426);
        super.onResume();
        WebView.enablePlatformNotifications();
        AppMethodBeat.m2505o(7426);
    }

    public void onPause() {
        AppMethodBeat.m2504i(7427);
        super.onPause();
        WebView.disablePlatformNotifications();
        AppMethodBeat.m2505o(7427);
    }

    public final int getLayoutId() {
        return 2130971216;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7428);
        super.onCreate(bundle);
        if (this.ulI != null) {
            this.ulI.cXX().cOG = "weixin://mark/oauth";
        }
        AppMethodBeat.m2505o(7428);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aMh() {
        boolean cZd;
        AppMethodBeat.m2504i(7429);
        super.aMh();
        try {
            cZd = this.icy.cZd();
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            cZd = false;
        }
        if (cZd) {
            this.pzf.setWebChromeClient(new C356262());
            this.pzf.setWebViewClient(new C356273());
            this.pzf.setDownloadListener(new C356294());
            this.pzf.dKH();
            setBackBtn(new C45705());
            addTextOptionMenu(1, getString(C25738R.string.f9216ta), new C45716());
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7414f("MicroMsg.OAuthUI", "content is null");
                AppMethodBeat.m2505o(7429);
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            C4990ab.m7416i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.icy.afh(this.appId);
            } catch (Exception e2) {
                C4990ab.m7420w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.urU = new Req(extras);
            try {
                this.uvS.daN();
            } catch (Exception e22) {
                C4990ab.m7420w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            cZB();
            AppMethodBeat.m2505o(7429);
            return;
        }
        C4990ab.m7412e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, C25738R.string.f8692c7, 1).show();
        setBackBtn(new C356281());
        enableOptionMenu(false);
        AppMethodBeat.m2505o(7429);
    }

    public void onStop() {
        AppMethodBeat.m2504i(7430);
        this.pzf.stopLoading();
        super.onStop();
        AppMethodBeat.m2505o(7430);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7431);
        try {
            this.uvS.daO();
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.urW != null) {
            this.urW.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(7431);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(7432);
        if (!this.urT && i == 4 && this.pzf.canGoBack()) {
            this.pzf.goBack();
            AppMethodBeat.m2505o(7432);
            return true;
        } else if (i == 4 && keyEvent.getRepeatCount() == 0) {
            cZz();
            finish();
            AppMethodBeat.m2505o(7432);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(7432);
            return onKeyDown;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cZz() {
        String afi;
        Exception e;
        String str = null;
        AppMethodBeat.m2504i(7433);
        C4990ab.m7416i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.ocw) {
            C4990ab.m7412e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            AppMethodBeat.m2505o(7433);
            return;
        }
        String cZg;
        this.ocw = true;
        try {
            afi = this.icy.afi(this.appId);
            try {
                cZg = this.icy.cZg();
                try {
                    str = this.icy.mo15551bF(274436, null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                cZg = str;
            }
        } catch (Exception e4) {
            e = e4;
            cZg = str;
            afi = str;
        }
        if (C5046bo.isNullOrNil(afi)) {
            Resp resp = new Resp();
            resp.transaction = this.urU.transaction;
            resp.errCode = -2;
            resp.lang = cZg;
            resp.country = str;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            C35799p.m58687at(bundle);
            Args args = new Args();
            args.targetPkgName = afi;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            AppMethodBeat.m2505o(7433);
            return;
        }
        C4990ab.m7412e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
        AppMethodBeat.m2505o(7433);
        return;
        C4990ab.m7420w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (C5046bo.isNullOrNil(afi)) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cZA() {
        return true;
    }

    public final void initView() {
        AppMethodBeat.m2504i(7434);
        super.initView();
        this.pzf.getSettings().setJavaScriptEnabled(true);
        this.pzf.setVerticalScrollBarEnabled(false);
        AppMethodBeat.m2505o(7434);
    }

    private void cZB() {
        AppMethodBeat.m2504i(7435);
        C4988aa.m7402g(getSharedPreferences(C4996ah.doA(), 0));
        this.urV = C4592e.m6958a(this, this.appId, this.urU, new C45727(), this.icy);
        AppMethodBeat.m2505o(7435);
    }

    /* renamed from: b */
    public final void mo30968b(C22913c c22913c) {
        AppMethodBeat.m2504i(7436);
        if (this.urV != null) {
            C4592e c4592e = this.urV;
            if (c4592e.urO) {
                int i = -1;
                int i2 = -1;
                String str = null;
                String str2 = null;
                String str3 = null;
                int i3 = -1;
                try {
                    i = c22913c.cYW();
                    i2 = c22913c.cYX();
                    c22913c.adx();
                    str = c22913c.getData().getString("geta8key_result_full_url");
                    str2 = c22913c.getData().getString("geta8key_result_head_img");
                    str3 = c22913c.getData().getString("geta8key_result_wording");
                    i3 = c22913c.getData().getInt("geta8key_result_action_code", -1);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                }
                C4990ab.m7416i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                if (c4592e.mzU != null) {
                    c4592e.mzU.dismiss();
                }
                c4592e.urN = false;
                c4592e.frk.stopTimer();
                boolean z;
                if ((i2 == 0 && i == 0) || i2 == -2033) {
                    if (i3 == 27) {
                        c4592e.urO = false;
                        C4593a c4593a = c4592e.urP;
                        if (i2 == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c4593a.mo9660d(z, str, str2, str3);
                        AppMethodBeat.m2505o(7436);
                        return;
                    }
                    c4592e.urP.mo9659a(c4592e, str, false);
                    AppMethodBeat.m2505o(7436);
                    return;
                } else if (i == 4 && i2 == -100) {
                    c4592e.urQ.mo30947X(true, true);
                    try {
                        c4592e.icy.mo15550ao(i, i2, c4592e.hashCode());
                        AppMethodBeat.m2505o(7436);
                        return;
                    } catch (Exception e2) {
                        C4990ab.m7420w("MicroMsg.OAuthSession", "accountExpired, ex = " + e2.getMessage());
                        AppMethodBeat.m2505o(7436);
                        return;
                    }
                } else {
                    Object obj;
                    C4593a c4593a2;
                    C4592e c4592e2;
                    if (i == 1 || i == 2 || i == 7 || i == 8) {
                        C4990ab.m7412e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
                        obj = null;
                    } else if (C5023at.isConnected(c4592e.urQ)) {
                        obj = 1;
                    } else {
                        C4990ab.m7412e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                        obj = null;
                    }
                    if (obj == null) {
                        c4593a2 = c4592e.urP;
                        str = null;
                        z = true;
                        c4592e2 = c4592e;
                    } else {
                        c4593a2 = c4592e.urP;
                        if (i2 == -1) {
                            z = true;
                            c4592e2 = c4592e;
                        } else {
                            z = false;
                            c4592e2 = c4592e;
                        }
                    }
                    c4593a2.mo9659a(c4592e2, str, z);
                }
            } else {
                C4990ab.m7420w("MicroMsg.OAuthSession", "onScenEnd, not listening");
                AppMethodBeat.m2505o(7436);
                return;
            }
        }
        AppMethodBeat.m2505o(7436);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m58470a(OAuthUI oAuthUI, String str) {
        String afi;
        Exception e;
        String str2 = null;
        AppMethodBeat.m2504i(7437);
        C4990ab.m7416i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = ".concat(String.valueOf(str)));
        if (!C5046bo.isNullOrNil(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.m2505o(7437);
                return;
            }
            String cZg;
            C4990ab.m7416i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                afi = oAuthUI.icy.afi(oAuthUI.appId);
                try {
                    cZg = oAuthUI.icy.cZg();
                    try {
                        str2 = oAuthUI.icy.mo15551bF(274436, null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cZg = str2;
                }
            } catch (Exception e4) {
                e = e4;
                cZg = str2;
                afi = str2;
            }
            if (!C5046bo.isNullOrNil(afi)) {
                C4990ab.m7412e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.m2505o(7437);
                return;
            } else if (str.toLowerCase().startsWith("http")) {
                C4990ab.m7416i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.m2505o(7437);
                return;
            } else if (oAuthUI.ocw) {
                C4990ab.m7412e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                AppMethodBeat.m2505o(7437);
                return;
            } else {
                oAuthUI.ocw = true;
                Resp resp = new Resp();
                resp.transaction = oAuthUI.urU.transaction;
                resp.lang = cZg;
                resp.country = str2;
                str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                C4990ab.m7416i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = ".concat(String.valueOf(str2)));
                if (C5046bo.isNullOrNil(str2)) {
                    resp.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    resp.errCode = -4;
                } else {
                    resp.errCode = 0;
                    resp.code = str2;
                }
                resp.state = parse.getQueryParameter("state");
                resp.errStr = parse.getQueryParameter("reason");
                resp.url = str;
                C4990ab.m7416i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                C35799p.m58687at(bundle);
                Args args = new Args();
                args.targetPkgName = afi;
                args.bundle = bundle;
                MMessageActV2.send(oAuthUI, args);
                oAuthUI.finish();
            }
        }
        AppMethodBeat.m2505o(7437);
        return;
        C4990ab.m7420w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (!C5046bo.isNullOrNil(afi)) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m58471a(OAuthUI oAuthUI, String str, String str2, final String str3) {
        AppMethodBeat.m2504i(7440);
        final View inflate = ((ViewStub) oAuthUI.findViewById(2131829182)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(C25738R.string.g0l));
        oAuthUI.setMMSubTitle(oAuthUI.getString(C25738R.string.dzd));
        oAuthUI.removeOptionMenu(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(2131824668);
        TextView textView = (TextView) oAuthUI.findViewById(2131826274);
        final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(2131824118);
        threeDotsLoadingView.dKS();
        C17927a c17927a = new C17927a();
        c17927a.eQg = 10.0f;
        c17927a.ePT = C1318a.native_oauth_default_head_img;
        C25815a.ahv().mo43766a(str, imageView, c17927a.ahG());
        if (C5046bo.isNullOrNil(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.urW = new C7564ap(new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(7425);
                OAuthUI.m58470a(OAuthUI.this, str3);
                inflate.setVisibility(8);
                threeDotsLoadingView.dKT();
                AppMethodBeat.m2505o(7425);
                return false;
            }
        }, false);
        oAuthUI.urW.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(7440);
    }

    /* renamed from: b */
    static /* synthetic */ void m58473b(OAuthUI oAuthUI, String str) {
        AppMethodBeat.m2504i(7441);
        ((ViewStub) oAuthUI.findViewById(2131829183)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(C25738R.string.g0l));
        oAuthUI.setMMSubTitle(oAuthUI.getString(C25738R.string.dzd));
        oAuthUI.removeOptionMenu(1);
        TextView textView = (TextView) oAuthUI.findViewById(2131826274);
        if (C5046bo.isNullOrNil(str)) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(7441);
            return;
        }
        textView.setText(str);
        AppMethodBeat.m2505o(7441);
    }
}
