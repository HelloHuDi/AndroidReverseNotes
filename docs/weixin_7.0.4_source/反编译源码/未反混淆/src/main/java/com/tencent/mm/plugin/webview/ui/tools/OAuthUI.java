package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.e.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean ocw = false;
    private boolean urT = true;
    private Req urU;
    private e urV;
    private ap urW;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(OAuthUI oAuthUI) {
        AppMethodBeat.i(7438);
        oAuthUI.cZz();
        AppMethodBeat.o(7438);
    }

    static /* synthetic */ void c(OAuthUI oAuthUI) {
        AppMethodBeat.i(7439);
        oAuthUI.cZB();
        AppMethodBeat.o(7439);
    }

    public void onResume() {
        AppMethodBeat.i(7426);
        super.onResume();
        WebView.enablePlatformNotifications();
        AppMethodBeat.o(7426);
    }

    public void onPause() {
        AppMethodBeat.i(7427);
        super.onPause();
        WebView.disablePlatformNotifications();
        AppMethodBeat.o(7427);
    }

    public final int getLayoutId() {
        return R.layout.b7f;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7428);
        super.onCreate(bundle);
        if (this.ulI != null) {
            this.ulI.cXX().cOG = "weixin://mark/oauth";
        }
        AppMethodBeat.o(7428);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aMh() {
        boolean cZd;
        AppMethodBeat.i(7429);
        super.aMh();
        try {
            cZd = this.icy.cZd();
        } catch (Exception e) {
            ab.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            cZd = false;
        }
        if (cZd) {
            this.pzf.setWebChromeClient(new l() {
                public final void d(WebView webView, String str) {
                    AppMethodBeat.i(7418);
                    super.d(webView, str);
                    OAuthUI.this.setMMTitle(str);
                    AppMethodBeat.o(7418);
                }
            });
            this.pzf.setWebViewClient(new h() {
                public final boolean aft(String str) {
                    AppMethodBeat.i(7419);
                    ab.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = ".concat(String.valueOf(str)));
                    if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                        AppMethodBeat.o(7419);
                    } else {
                        OAuthUI.a(OAuthUI.this, str);
                        AppMethodBeat.o(7419);
                    }
                    return true;
                }
            });
            this.pzf.setDownloadListener(new DownloadListener() {
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    AppMethodBeat.i(7420);
                    OAuthUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    AppMethodBeat.o(7420);
                }
            });
            this.pzf.dKH();
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(7421);
                    OAuthUI.a(OAuthUI.this);
                    OAuthUI.this.finish();
                    AppMethodBeat.o(7421);
                    return true;
                }
            });
            addTextOptionMenu(1, getString(R.string.ta), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(7422);
                    if (OAuthUI.this.urV != null) {
                        OAuthUI.this.urV;
                    }
                    OAuthUI.this.pzf.stopLoading();
                    OAuthUI.this.X(false, false);
                    OAuthUI.c(OAuthUI.this);
                    AppMethodBeat.o(7422);
                    return false;
                }
            });
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bo.isNullOrNil(string)) {
                ab.f("MicroMsg.OAuthUI", "content is null");
                AppMethodBeat.o(7429);
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            ab.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.icy.afh(this.appId);
            } catch (Exception e2) {
                ab.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.urU = new Req(extras);
            try {
                this.uvS.daN();
            } catch (Exception e22) {
                ab.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            cZB();
            AppMethodBeat.o(7429);
            return;
        }
        ab.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.string.c7, 1).show();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7417);
                OAuthUI.this.finish();
                AppMethodBeat.o(7417);
                return true;
            }
        });
        enableOptionMenu(false);
        AppMethodBeat.o(7429);
    }

    public void onStop() {
        AppMethodBeat.i(7430);
        this.pzf.stopLoading();
        super.onStop();
        AppMethodBeat.o(7430);
    }

    public void onDestroy() {
        AppMethodBeat.i(7431);
        try {
            this.uvS.daO();
        } catch (Exception e) {
            ab.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.urW != null) {
            this.urW.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.o(7431);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(7432);
        if (!this.urT && i == 4 && this.pzf.canGoBack()) {
            this.pzf.goBack();
            AppMethodBeat.o(7432);
            return true;
        } else if (i == 4 && keyEvent.getRepeatCount() == 0) {
            cZz();
            finish();
            AppMethodBeat.o(7432);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(7432);
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
        AppMethodBeat.i(7433);
        ab.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.ocw) {
            ab.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            AppMethodBeat.o(7433);
            return;
        }
        String cZg;
        this.ocw = true;
        try {
            afi = this.icy.afi(this.appId);
            try {
                cZg = this.icy.cZg();
                try {
                    str = this.icy.bF(274436, null);
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
        if (bo.isNullOrNil(afi)) {
            Resp resp = new Resp();
            resp.transaction = this.urU.transaction;
            resp.errCode = -2;
            resp.lang = cZg;
            resp.country = str;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.at(bundle);
            Args args = new Args();
            args.targetPkgName = afi;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            AppMethodBeat.o(7433);
            return;
        }
        ab.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
        AppMethodBeat.o(7433);
        return;
        ab.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (bo.isNullOrNil(afi)) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cZA() {
        return true;
    }

    public final void initView() {
        AppMethodBeat.i(7434);
        super.initView();
        this.pzf.getSettings().setJavaScriptEnabled(true);
        this.pzf.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(7434);
    }

    private void cZB() {
        AppMethodBeat.i(7435);
        aa.g(getSharedPreferences(ah.doA(), 0));
        this.urV = e.a(this, this.appId, this.urU, new a() {
            public final void a(e eVar, String str, boolean z) {
                AppMethodBeat.i(7423);
                ab.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
                eVar.urO = false;
                if (z) {
                    Object string;
                    try {
                        string = OAuthUI.this.getString(R.string.da3);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                        string = null;
                    }
                    ab.i("MicroMsg.OAuthUI", "onResult, html = ".concat(String.valueOf(string)));
                    if (OAuthUI.this.pzf != null) {
                        OAuthUI.this.pzf.loadUrl(string);
                        if (OAuthUI.this.ulI != null) {
                            OAuthUI.this.ulI.cXX().cOG = string;
                        }
                    }
                    AppMethodBeat.o(7423);
                    return;
                }
                if (!(bo.isNullOrNil(str) || OAuthUI.this.pzf == null)) {
                    OAuthUI.this.pzf.loadUrl(str);
                    if (OAuthUI.this.ulI != null) {
                        OAuthUI.this.ulI.cXX().cOG = str;
                    }
                }
                AppMethodBeat.o(7423);
            }

            public final void d(boolean z, String str, String str2, String str3) {
                AppMethodBeat.i(7424);
                if (z) {
                    OAuthUI.a(OAuthUI.this, str2, str3, str);
                    AppMethodBeat.o(7424);
                    return;
                }
                OAuthUI.b(OAuthUI.this, str3);
                AppMethodBeat.o(7424);
            }
        }, this.icy);
        AppMethodBeat.o(7435);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(7436);
        if (this.urV != null) {
            e eVar = this.urV;
            if (eVar.urO) {
                int i = -1;
                int i2 = -1;
                String str = null;
                String str2 = null;
                String str3 = null;
                int i3 = -1;
                try {
                    i = cVar.cYW();
                    i2 = cVar.cYX();
                    cVar.adx();
                    str = cVar.getData().getString("geta8key_result_full_url");
                    str2 = cVar.getData().getString("geta8key_result_head_img");
                    str3 = cVar.getData().getString("geta8key_result_wording");
                    i3 = cVar.getData().getInt("geta8key_result_action_code", -1);
                } catch (Exception e) {
                    ab.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                }
                ab.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                if (eVar.mzU != null) {
                    eVar.mzU.dismiss();
                }
                eVar.urN = false;
                eVar.frk.stopTimer();
                boolean z;
                if ((i2 == 0 && i == 0) || i2 == -2033) {
                    if (i3 == 27) {
                        eVar.urO = false;
                        a aVar = eVar.urP;
                        if (i2 == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar.d(z, str, str2, str3);
                        AppMethodBeat.o(7436);
                        return;
                    }
                    eVar.urP.a(eVar, str, false);
                    AppMethodBeat.o(7436);
                    return;
                } else if (i == 4 && i2 == -100) {
                    eVar.urQ.X(true, true);
                    try {
                        eVar.icy.ao(i, i2, eVar.hashCode());
                        AppMethodBeat.o(7436);
                        return;
                    } catch (Exception e2) {
                        ab.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e2.getMessage());
                        AppMethodBeat.o(7436);
                        return;
                    }
                } else {
                    Object obj;
                    a aVar2;
                    e eVar2;
                    if (i == 1 || i == 2 || i == 7 || i == 8) {
                        ab.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
                        obj = null;
                    } else if (at.isConnected(eVar.urQ)) {
                        obj = 1;
                    } else {
                        ab.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                        obj = null;
                    }
                    if (obj == null) {
                        aVar2 = eVar.urP;
                        str = null;
                        z = true;
                        eVar2 = eVar;
                    } else {
                        aVar2 = eVar.urP;
                        if (i2 == -1) {
                            z = true;
                            eVar2 = eVar;
                        } else {
                            z = false;
                            eVar2 = eVar;
                        }
                    }
                    aVar2.a(eVar2, str, z);
                }
            } else {
                ab.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
                AppMethodBeat.o(7436);
                return;
            }
        }
        AppMethodBeat.o(7436);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        String afi;
        Exception e;
        String str2 = null;
        AppMethodBeat.i(7437);
        ab.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = ".concat(String.valueOf(str)));
        if (!bo.isNullOrNil(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.o(7437);
                return;
            }
            String cZg;
            ab.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                afi = oAuthUI.icy.afi(oAuthUI.appId);
                try {
                    cZg = oAuthUI.icy.cZg();
                    try {
                        str2 = oAuthUI.icy.bF(274436, null);
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
            if (!bo.isNullOrNil(afi)) {
                ab.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.o(7437);
                return;
            } else if (str.toLowerCase().startsWith("http")) {
                ab.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.pzf.loadUrl(str);
                AppMethodBeat.o(7437);
                return;
            } else if (oAuthUI.ocw) {
                ab.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                AppMethodBeat.o(7437);
                return;
            } else {
                oAuthUI.ocw = true;
                Resp resp = new Resp();
                resp.transaction = oAuthUI.urU.transaction;
                resp.lang = cZg;
                resp.country = str2;
                str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                ab.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = ".concat(String.valueOf(str2)));
                if (bo.isNullOrNil(str2)) {
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
                ab.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                p.at(bundle);
                Args args = new Args();
                args.targetPkgName = afi;
                args.bundle = bundle;
                MMessageActV2.send(oAuthUI, args);
                oAuthUI.finish();
            }
        }
        AppMethodBeat.o(7437);
        return;
        ab.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (!bo.isNullOrNil(afi)) {
        }
    }

    static /* synthetic */ void a(OAuthUI oAuthUI, String str, String str2, final String str3) {
        AppMethodBeat.i(7440);
        final View inflate = ((ViewStub) oAuthUI.findViewById(R.id.fkh)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.string.g0l));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.string.dzd));
        oAuthUI.removeOptionMenu(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(R.id.c_g);
        TextView textView = (TextView) oAuthUI.findViewById(R.id.dfw);
        final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(R.id.bvl);
        threeDotsLoadingView.dKS();
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.eQg = 10.0f;
        aVar.ePT = R.raw.native_oauth_default_head_img;
        com.tencent.mm.at.a.a.ahv().a(str, imageView, aVar.ahG());
        if (bo.isNullOrNil(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.urW = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(7425);
                OAuthUI.a(OAuthUI.this, str3);
                inflate.setVisibility(8);
                threeDotsLoadingView.dKT();
                AppMethodBeat.o(7425);
                return false;
            }
        }, false);
        oAuthUI.urW.ae(1000, 1000);
        AppMethodBeat.o(7440);
    }

    static /* synthetic */ void b(OAuthUI oAuthUI, String str) {
        AppMethodBeat.i(7441);
        ((ViewStub) oAuthUI.findViewById(R.id.fki)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.string.g0l));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.string.dzd));
        oAuthUI.removeOptionMenu(1);
        TextView textView = (TextView) oAuthUI.findViewById(R.id.dfw);
        if (bo.isNullOrNil(str)) {
            textView.setVisibility(8);
            AppMethodBeat.o(7441);
            return;
        }
        textView.setText(str);
        AppMethodBeat.o(7441);
    }
}
