package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.q;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Locale;

@a(1)
public class MPGdprPolicyUI extends MMActivity {
    private MMFalseProgressBar fou;
    private MMWebView fow;
    private com.tencent.mm.model.gdpr.a fox;
    private ResultReceiver foy;
    private String mAppID;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MPGdprPolicyUI mPGdprPolicyUI, boolean z) {
        AppMethodBeat.i(1512);
        mPGdprPolicyUI.cz(z);
        AppMethodBeat.o(1512);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1505);
        super.onCreate(bundle);
        try {
            if (getIntent() != null) {
                ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
                this.foy = resultReceiver;
                if (resultReceiver != null) {
                    this.fox = com.tencent.mm.model.gdpr.a.oY(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
                    if (this.fox == null) {
                        ab.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
                        cz(false);
                        finish();
                        AppMethodBeat.o(1505);
                        return;
                    }
                    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
                    AppMethodBeat.o(1505);
                    return;
                }
            }
            finish();
            AppMethodBeat.o(1505);
        } catch (Exception e) {
            ab.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", e);
            finish();
            AppMethodBeat.o(1505);
        }
    }

    private void cz(boolean z) {
        AppMethodBeat.i(1506);
        if (this.foy != null) {
            this.foy.send(z ? 1 : -1, null);
        }
        AppMethodBeat.o(1506);
    }

    public void finish() {
        AppMethodBeat.i(1507);
        super.finish();
        if (this.foy != null) {
            cz(false);
            this.foy = null;
        }
        AppMethodBeat.o(1507);
    }

    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
    public final void dealContentView(View view) {
        AppMethodBeat.i(1508);
        super.dealContentView(view);
        this.fow = f.a.uJi.du(this);
        this.fow.getSettings().dUh();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.fow.getSettings().dUj();
        this.fow.getSettings().setUserAgentString(q.a(this.mController.ylL, this.fow.getSettings().getUserAgentString(), (q.a) e.B(q.a.class)));
        this.fow.getView().setHorizontalScrollBarEnabled(false);
        this.fow.getView().setVerticalScrollBarEnabled(false);
        this.fow.getSettings().setBuiltInZoomControls(true);
        this.fow.getSettings().setUseWideViewPort(true);
        this.fow.getSettings().setLoadWithOverviewMode(true);
        this.fow.getSettings().dUc();
        this.fow.getSettings().dUb();
        this.fow.getSettings().setGeolocationEnabled(true);
        this.fow.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.fow.getSettings().dUf();
        this.fow.getSettings().setAppCachePath(this.mController.ylL.getDir("webviewcache", 0).getAbsolutePath());
        this.fow.getSettings().dUe();
        this.fow.getSettings().dUg();
        this.fow.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eSi + "databases/");
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
        this.fow.setWebViewClient(c.a.uJh.a(this.fow, new com.tencent.mm.plugin.webview.ui.tools.widget.e() {
            public final boolean aba() {
                AppMethodBeat.i(1498);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(1495);
                        MPGdprPolicyUI.this.finish();
                        AppMethodBeat.o(1495);
                    }
                });
                AppMethodBeat.o(1498);
                return true;
            }

            public final void abb() {
                AppMethodBeat.i(1499);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(1496);
                        MPGdprPolicyUI.this.fou.start();
                        AppMethodBeat.o(1496);
                    }
                });
                AppMethodBeat.o(1499);
            }

            public final void a(MMWebView mMWebView) {
                AppMethodBeat.i(1500);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(1497);
                        MPGdprPolicyUI.this.fou.finish();
                        AppMethodBeat.o(1497);
                    }
                });
                AppMethodBeat.o(1500);
            }

            public final boolean oZ(String str) {
                return false;
            }

            public final boolean c(int i, Bundle bundle) {
                AppMethodBeat.i(1501);
                if (i == 200) {
                    boolean z = bundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
                    MPGdprPolicyUI.a(MPGdprPolicyUI.this, z);
                    MPGdprPolicyUI.this.foy = null;
                    if (!(!z || bo.isNullOrNil(MPGdprPolicyUI.this.mAppID) || MPGdprPolicyUI.this.fox.foo == 0)) {
                        com.tencent.mm.ai.a aVar = new com.tencent.mm.ai.a();
                        bxx bxx = new bxx();
                        bxx.csB = MPGdprPolicyUI.this.mAppID;
                        bxx.scene = MPGdprPolicyUI.this.fox.foo;
                        b.a aVar2 = new b.a();
                        aVar2.fsJ = bxx;
                        aVar2.fsK = new bxy();
                        aVar2.fsI = 2734;
                        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
                        aVar.ehh = aVar2.acD();
                        aVar.acy();
                    }
                }
                AppMethodBeat.o(1501);
                return false;
            }
        }, bundle));
        this.fow.setWebChromeClient(com.tencent.mm.plugin.webview.ui.tools.widget.a.a.uJg.a(this.fow, new com.tencent.mm.plugin.webview.ui.tools.widget.b() {
            public final boolean pa(final String str) {
                AppMethodBeat.i(1503);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(1502);
                        MPGdprPolicyUI.this.setMMTitle(str);
                        AppMethodBeat.o(1502);
                    }
                });
                AppMethodBeat.o(1503);
                return true;
            }
        }));
        ((FrameLayout) view).addView(this.fow, -1, -1);
        this.fou = new MMFalseProgressBar(this);
        this.fou.setProgressDrawable(com.tencent.mm.bz.a.g(this, R.drawable.uw));
        ((FrameLayout) view).addView(this.fou, -1, com.tencent.mm.bz.a.fromDPToPix(this, 3));
        AppMethodBeat.o(1508);
    }

    public void onPostCreate(Bundle bundle) {
        AppMethodBeat.i(1509);
        super.onPostCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1504);
                MPGdprPolicyUI.this.finish();
                AppMethodBeat.o(1504);
                return true;
            }
        }, R.raw.actionbar_icon_dark_close);
        xE(-1);
        this.fow.loadUrl(String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[]{this.fox.fon, aa.gw(this), (String) g.RP().Ry().get(274436, null)}));
        AppMethodBeat.o(1509);
    }

    public void onDestroy() {
        AppMethodBeat.i(1510);
        super.onDestroy();
        try {
            this.fow.destroy();
        } catch (Exception e) {
            ab.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", e);
        } finally {
            this.fow = null;
            AppMethodBeat.o(1510);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(1511);
        if (i == 4 && this.fow.canGoBack()) {
            this.fow.goBack();
            AppMethodBeat.o(1511);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(1511);
        return onKeyDown;
    }
}
