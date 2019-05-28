package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI */
public class MailWebViewUI extends MMActivity {
    private String cdu;
    private C46607d ext = new C46607d(this);
    private C7306ak handler;
    private long pvG;
    private MMWebView pzf;
    private C21523a pzg = new C434091();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI$3 */
    class C215433 extends C36592s {
        C215433() {
        }

        /* renamed from: a */
        public final void mo37025a(WebView webView, float f, float f2) {
            AppMethodBeat.m2504i(68395);
            MailWebViewUI.this.pzf.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
            AppMethodBeat.m2505o(68395);
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(68396);
            if (str.startsWith("weixin://private/getcontentwidth/")) {
                C4990ab.m7410d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
                MailWebViewUI.m77479b(MailWebViewUI.this, str);
                AppMethodBeat.m2505o(68396);
            } else {
                webView.loadUrl(str);
                AppMethodBeat.m2505o(68396);
            }
            return true;
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(68397);
            super.mo5992b(webView, str);
            C30152u.m47744a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
            AppMethodBeat.m2505o(68397);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI$5 */
    class C215445 implements OnMenuItemClickListener {
        C215445() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68399);
            MailWebViewUI.this.finish();
            AppMethodBeat.m2505o(68399);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI$4 */
    class C347554 extends C6031l {
        C347554() {
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(68398);
            String akn = C30152u.akn(consoleMessage != null ? consoleMessage.message() : null);
            if (akn.startsWith("weixin://private/getcontentwidth/")) {
                C4990ab.m7410d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(akn)));
                MailWebViewUI.m77479b(MailWebViewUI.this, akn);
                AppMethodBeat.m2505o(68398);
                return true;
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(68398);
            return onConsoleMessage;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI$1 */
    class C434091 extends C21523a {
        C434091() {
        }

        public final void onSuccess(final String str, Map map) {
            AppMethodBeat.m2504i(68392);
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68390);
                    MailWebViewUI.m77477a(MailWebViewUI.this, str);
                    AppMethodBeat.m2505o(68390);
                }
            });
            AppMethodBeat.m2505o(68392);
        }

        public final void onError(int i, final String str) {
            AppMethodBeat.m2504i(68393);
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68391);
                    Toast.makeText(MailWebViewUI.this, str, 0).show();
                    AppMethodBeat.m2505o(68391);
                }
            });
            AppMethodBeat.m2505o(68393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailWebViewUI$2 */
    class C434102 implements Runnable {
        C434102() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68394);
            MailWebViewUI.m77478b(MailWebViewUI.this);
            AppMethodBeat.m2505o(68394);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MailWebViewUI() {
        AppMethodBeat.m2504i(68401);
        AppMethodBeat.m2505o(68401);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68402);
        super.onResume();
        WebView.enablePlatformNotifications();
        AppMethodBeat.m2505o(68402);
    }

    public void onPause() {
        AppMethodBeat.m2504i(68403);
        super.onPause();
        WebView.disablePlatformNotifications();
        AppMethodBeat.m2505o(68403);
    }

    public final int getLayoutId() {
        return 2130970428;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68404);
        super.onCreate(bundle);
        this.handler = new C7306ak();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.ext.connect(new C434102());
        AppMethodBeat.m2505o(68404);
    }

    public void onStop() {
        AppMethodBeat.m2504i(68405);
        this.pzf.stopLoading();
        super.onStop();
        AppMethodBeat.m2505o(68405);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68406);
        this.pzf.setVisibility(8);
        this.pzf.destroy();
        this.pzf = null;
        this.ext.release();
        super.onDestroy();
        AppMethodBeat.m2505o(68406);
    }

    public final void initView() {
        AppMethodBeat.m2504i(68407);
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.pzf = C30798a.m49145in(this.mController.ylL);
        this.pzf.setBackgroundDrawable(C1338a.m2864g(this, C25738R.color.f12200vs));
        ((FrameLayout) findViewById(2131821064)).addView(this.pzf);
        this.pzf.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            this.pzf.dKI();
        }
        this.pzf.getSettings().dUd();
        this.pzf.getSettings().setSupportZoom(true);
        this.pzf.getSettings().setBuiltInZoomControls(true);
        this.pzf.setWebViewClient(new C215433());
        this.pzf.setWebChromeClient(new C347554());
        this.pzf.dKH();
        setBackBtn(new C215445());
        AppMethodBeat.m2505o(68407);
    }

    /* renamed from: a */
    static /* synthetic */ void m77477a(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.m2504i(68408);
        if (mailWebViewUI.pzf == null || str == null) {
            AppMethodBeat.m2505o(68408);
        } else if (mailWebViewUI.cdu == null) {
            mailWebViewUI.pzf.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
            AppMethodBeat.m2505o(68408);
        } else {
            mailWebViewUI.pzf.loadDataWithBaseURL(mailWebViewUI.cdu, str, "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.m2505o(68408);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m77478b(MailWebViewUI mailWebViewUI) {
        AppMethodBeat.m2504i(68409);
        String stringExtra = mailWebViewUI.getIntent().getStringExtra(ShareConstants.MEDIA_URI);
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.cdu = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String bc = C5046bo.m7532bc(mailWebViewUI.getIntent().getStringExtra(C8741b.METHOD), "get");
        if (bc == null || bc.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            C4990ab.m7412e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            AppMethodBeat.m2505o(68409);
            return;
        }
        C28746c c28746c = new C28746c();
        c28746c.puQ = false;
        c28746c.toBundle(new Bundle());
        try {
            if (bc.equals("get")) {
                mailWebViewUI.pvG = ((Long) new ReadMailProxy(mailWebViewUI.ext, mailWebViewUI.pzg).REMOTE_CALL("get", stringExtra, hashMap, r5)).longValue();
                AppMethodBeat.m2505o(68409);
                return;
            }
            mailWebViewUI.pvG = ((Long) new ReadMailProxy(mailWebViewUI.ext, mailWebViewUI.pzg).REMOTE_CALL("post", stringExtra, hashMap, r5)).longValue();
            AppMethodBeat.m2505o(68409);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", bc, e.getMessage());
            AppMethodBeat.m2505o(68409);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m77479b(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.m2504i(68410);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            AppMethodBeat.m2505o(68410);
            return;
        }
        String substring = str.substring(33);
        final int i = C5046bo.getInt(substring, 480);
        C4990ab.m7410d("MicroMsg.QQMail.WebViewUI", "getContentWidth:".concat(String.valueOf(substring)));
        mailWebViewUI.pzf.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68400);
                View view = (View) MailWebViewUI.this.pzf.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < MailWebViewUI.this.pzf.getScale()) {
                            i--;
                            if (i <= 0) {
                                break;
                            }
                            MailWebViewUI.this.pzf.zoomOut();
                        }
                    }
                }
                AppMethodBeat.m2505o(68400);
            }
        });
        AppMethodBeat.m2505o(68410);
    }
}
