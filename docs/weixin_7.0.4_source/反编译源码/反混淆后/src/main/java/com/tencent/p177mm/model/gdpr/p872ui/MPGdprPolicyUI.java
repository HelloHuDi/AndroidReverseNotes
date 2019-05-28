package com.tencent.p177mm.model.gdpr.p872ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMFalseProgressBar;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f.C23152a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C35725b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C36860e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40347c.C40348a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C4655a.C4656a;
import com.tencent.p177mm.protocal.protobuf.bxx;
import com.tencent.p177mm.protocal.protobuf.bxy;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;

@C5271a(1)
/* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI */
public class MPGdprPolicyUI extends MMActivity {
    private MMFalseProgressBar fou;
    private MMWebView fow;
    private C32791a fox;
    private ResultReceiver foy;
    private String mAppID;

    /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$1 */
    class C96641 implements C36860e {

        /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$1$2 */
        class C96652 implements Runnable {
            C96652() {
            }

            public final void run() {
                AppMethodBeat.m2504i(1496);
                MPGdprPolicyUI.this.fou.start();
                AppMethodBeat.m2505o(1496);
            }
        }

        /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$1$1 */
        class C96661 implements Runnable {
            C96661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(1495);
                MPGdprPolicyUI.this.finish();
                AppMethodBeat.m2505o(1495);
            }
        }

        /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$1$3 */
        class C96673 implements Runnable {
            C96673() {
            }

            public final void run() {
                AppMethodBeat.m2504i(1497);
                MPGdprPolicyUI.this.fou.finish();
                AppMethodBeat.m2505o(1497);
            }
        }

        C96641() {
        }

        public final boolean aba() {
            AppMethodBeat.m2504i(1498);
            MPGdprPolicyUI.this.runOnUiThread(new C96661());
            AppMethodBeat.m2505o(1498);
            return true;
        }

        public final void abb() {
            AppMethodBeat.m2504i(1499);
            MPGdprPolicyUI.this.runOnUiThread(new C96652());
            AppMethodBeat.m2505o(1499);
        }

        /* renamed from: a */
        public final void mo20981a(MMWebView mMWebView) {
            AppMethodBeat.m2504i(1500);
            MPGdprPolicyUI.this.runOnUiThread(new C96673());
            AppMethodBeat.m2505o(1500);
        }

        /* renamed from: oZ */
        public final boolean mo20985oZ(String str) {
            return false;
        }

        /* renamed from: c */
        public final boolean mo20984c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(1501);
            if (i == 200) {
                boolean z = bundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
                MPGdprPolicyUI.m83703a(MPGdprPolicyUI.this, z);
                MPGdprPolicyUI.this.foy = null;
                if (!(!z || C5046bo.isNullOrNil(MPGdprPolicyUI.this.mAppID) || MPGdprPolicyUI.this.fox.foo == 0)) {
                    C37440a c37440a = new C37440a();
                    bxx bxx = new bxx();
                    bxx.csB = MPGdprPolicyUI.this.mAppID;
                    bxx.scene = MPGdprPolicyUI.this.fox.foo;
                    C1196a c1196a = new C1196a();
                    c1196a.fsJ = bxx;
                    c1196a.fsK = new bxy();
                    c1196a.fsI = 2734;
                    c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
                    c37440a.ehh = c1196a.acD();
                    c37440a.acy();
                }
            }
            AppMethodBeat.m2505o(1501);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$2 */
    class C96682 implements C35725b {
        C96682() {
        }

        /* renamed from: pa */
        public final boolean mo20989pa(final String str) {
            AppMethodBeat.m2504i(1503);
            MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1502);
                    MPGdprPolicyUI.this.setMMTitle(str);
                    AppMethodBeat.m2505o(1502);
                }
            });
            AppMethodBeat.m2505o(1503);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI$3 */
    class C264263 implements OnMenuItemClickListener {
        C264263() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1504);
            MPGdprPolicyUI.this.finish();
            AppMethodBeat.m2505o(1504);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m83703a(MPGdprPolicyUI mPGdprPolicyUI, boolean z) {
        AppMethodBeat.m2504i(1512);
        mPGdprPolicyUI.m83706cz(z);
        AppMethodBeat.m2505o(1512);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1505);
        super.onCreate(bundle);
        try {
            if (getIntent() != null) {
                ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
                this.foy = resultReceiver;
                if (resultReceiver != null) {
                    this.fox = C32791a.m53568oY(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
                    if (this.fox == null) {
                        C4990ab.m7412e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
                        m83706cz(false);
                        finish();
                        AppMethodBeat.m2505o(1505);
                        return;
                    }
                    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
                    AppMethodBeat.m2505o(1505);
                    return;
                }
            }
            finish();
            AppMethodBeat.m2505o(1505);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", e);
            finish();
            AppMethodBeat.m2505o(1505);
        }
    }

    /* renamed from: cz */
    private void m83706cz(boolean z) {
        AppMethodBeat.m2504i(1506);
        if (this.foy != null) {
            this.foy.send(z ? 1 : -1, null);
        }
        AppMethodBeat.m2505o(1506);
    }

    public void finish() {
        AppMethodBeat.m2504i(1507);
        super.finish();
        if (this.foy != null) {
            m83706cz(false);
            this.foy = null;
        }
        AppMethodBeat.m2505o(1507);
    }

    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(1508);
        super.dealContentView(view);
        this.fow = C23152a.uJi.mo30691du(this);
        this.fow.getSettings().dUh();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.fow.getSettings().dUj();
        this.fow.getSettings().setUserAgentString(C10707q.m18380a(this.mController.ylL, this.fow.getSettings().getUserAgentString(), (C10708a) C37384e.m62985B(C10708a.class)));
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
        this.fow.getSettings().setDatabasePath(C6457e.eSi + "databases/");
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
        this.fow.setWebViewClient(C40348a.uJh.mo30692a(this.fow, new C96641(), bundle));
        this.fow.setWebChromeClient(C4656a.uJg.mo9750a(this.fow, new C96682()));
        ((FrameLayout) view).addView(this.fow, -1, -1);
        this.fou = new MMFalseProgressBar(this);
        this.fou.setProgressDrawable(C1338a.m2864g(this, C25738R.drawable.f6901uw));
        ((FrameLayout) view).addView(this.fou, -1, C1338a.fromDPToPix(this, 3));
        AppMethodBeat.m2505o(1508);
    }

    public void onPostCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1509);
        super.onPostCreate(bundle);
        setBackBtn(new C264263(), C1318a.actionbar_icon_dark_close);
        mo17446xE(-1);
        this.fow.loadUrl(String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[]{this.fox.fon, C4988aa.m7403gw(this), (String) C1720g.m3536RP().mo5239Ry().get(274436, null)}));
        AppMethodBeat.m2505o(1509);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1510);
        super.onDestroy();
        try {
            this.fow.destroy();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", e);
        } finally {
            this.fow = null;
            AppMethodBeat.m2505o(1510);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1511);
        if (i == 4 && this.fow.canGoBack()) {
            this.fow.goBack();
            AppMethodBeat.m2505o(1511);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(1511);
        return onKeyDown;
    }
}
