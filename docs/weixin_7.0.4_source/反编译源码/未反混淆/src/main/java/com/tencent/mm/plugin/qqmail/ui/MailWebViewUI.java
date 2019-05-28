package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.s;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String cdu;
    private d ext = new d(this);
    private ak handler;
    private long pvG;
    private MMWebView pzf;
    private a pzg = new a() {
        public final void onSuccess(final String str, Map map) {
            AppMethodBeat.i(68392);
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68390);
                    MailWebViewUI.a(MailWebViewUI.this, str);
                    AppMethodBeat.o(68390);
                }
            });
            AppMethodBeat.o(68392);
        }

        public final void onError(int i, final String str) {
            AppMethodBeat.i(68393);
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68391);
                    Toast.makeText(MailWebViewUI.this, str, 0).show();
                    AppMethodBeat.o(68391);
                }
            });
            AppMethodBeat.o(68393);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailWebViewUI() {
        AppMethodBeat.i(68401);
        AppMethodBeat.o(68401);
    }

    public void onResume() {
        AppMethodBeat.i(68402);
        super.onResume();
        WebView.enablePlatformNotifications();
        AppMethodBeat.o(68402);
    }

    public void onPause() {
        AppMethodBeat.i(68403);
        super.onPause();
        WebView.disablePlatformNotifications();
        AppMethodBeat.o(68403);
    }

    public final int getLayoutId() {
        return R.layout.am8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68404);
        super.onCreate(bundle);
        this.handler = new ak();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68394);
                MailWebViewUI.b(MailWebViewUI.this);
                AppMethodBeat.o(68394);
            }
        });
        AppMethodBeat.o(68404);
    }

    public void onStop() {
        AppMethodBeat.i(68405);
        this.pzf.stopLoading();
        super.onStop();
        AppMethodBeat.o(68405);
    }

    public void onDestroy() {
        AppMethodBeat.i(68406);
        this.pzf.setVisibility(8);
        this.pzf.destroy();
        this.pzf = null;
        this.ext.release();
        super.onDestroy();
        AppMethodBeat.o(68406);
    }

    public final void initView() {
        AppMethodBeat.i(68407);
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.pzf = MMWebView.a.in(this.mController.ylL);
        this.pzf.setBackgroundDrawable(com.tencent.mm.bz.a.g(this, R.color.vs));
        ((FrameLayout) findViewById(R.id.nc)).addView(this.pzf);
        this.pzf.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            this.pzf.dKI();
        }
        this.pzf.getSettings().dUd();
        this.pzf.getSettings().setSupportZoom(true);
        this.pzf.getSettings().setBuiltInZoomControls(true);
        this.pzf.setWebViewClient(new s() {
            public final void a(WebView webView, float f, float f2) {
                AppMethodBeat.i(68395);
                MailWebViewUI.this.pzf.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
                AppMethodBeat.o(68395);
            }

            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(68396);
                if (str.startsWith("weixin://private/getcontentwidth/")) {
                    ab.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
                    MailWebViewUI.b(MailWebViewUI.this, str);
                    AppMethodBeat.o(68396);
                } else {
                    webView.loadUrl(str);
                    AppMethodBeat.o(68396);
                }
                return true;
            }

            public final void b(WebView webView, String str) {
                AppMethodBeat.i(68397);
                super.b(webView, str);
                u.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
                AppMethodBeat.o(68397);
            }
        });
        this.pzf.setWebChromeClient(new l() {
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppMethodBeat.i(68398);
                String akn = u.akn(consoleMessage != null ? consoleMessage.message() : null);
                if (akn.startsWith("weixin://private/getcontentwidth/")) {
                    ab.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(akn)));
                    MailWebViewUI.b(MailWebViewUI.this, akn);
                    AppMethodBeat.o(68398);
                    return true;
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(68398);
                return onConsoleMessage;
            }
        });
        this.pzf.dKH();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68399);
                MailWebViewUI.this.finish();
                AppMethodBeat.o(68399);
                return true;
            }
        });
        AppMethodBeat.o(68407);
    }

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.i(68408);
        if (mailWebViewUI.pzf == null || str == null) {
            AppMethodBeat.o(68408);
        } else if (mailWebViewUI.cdu == null) {
            mailWebViewUI.pzf.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(68408);
        } else {
            mailWebViewUI.pzf.loadDataWithBaseURL(mailWebViewUI.cdu, str, "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.o(68408);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        AppMethodBeat.i(68409);
        String stringExtra = mailWebViewUI.getIntent().getStringExtra(ShareConstants.MEDIA_URI);
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.cdu = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String bc = bo.bc(mailWebViewUI.getIntent().getStringExtra(b.METHOD), "get");
        if (bc == null || bc.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            ab.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            AppMethodBeat.o(68409);
            return;
        }
        c cVar = new c();
        cVar.puQ = false;
        cVar.toBundle(new Bundle());
        try {
            if (bc.equals("get")) {
                mailWebViewUI.pvG = ((Long) new ReadMailProxy(mailWebViewUI.ext, mailWebViewUI.pzg).REMOTE_CALL("get", stringExtra, hashMap, r5)).longValue();
                AppMethodBeat.o(68409);
                return;
            }
            mailWebViewUI.pvG = ((Long) new ReadMailProxy(mailWebViewUI.ext, mailWebViewUI.pzg).REMOTE_CALL("post", stringExtra, hashMap, r5)).longValue();
            AppMethodBeat.o(68409);
        } catch (Exception e) {
            ab.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", bc, e.getMessage());
            AppMethodBeat.o(68409);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.i(68410);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            AppMethodBeat.o(68410);
            return;
        }
        String substring = str.substring(33);
        final int i = bo.getInt(substring, 480);
        ab.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:".concat(String.valueOf(substring)));
        mailWebViewUI.pzf.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68400);
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
                AppMethodBeat.o(68400);
            }
        });
        AppMethodBeat.o(68410);
    }
}
