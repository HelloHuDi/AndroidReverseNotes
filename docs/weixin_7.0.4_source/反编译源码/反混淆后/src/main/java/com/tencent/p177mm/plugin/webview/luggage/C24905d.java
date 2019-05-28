package com.tencent.p177mm.plugin.webview.luggage;

import android.app.Activity;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.content.C0380b;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C17821n.C17822a;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C41709g;
import com.tencent.luggage.p146d.C45123i;
import com.tencent.luggage.p146d.C45123i.C45122a;
import com.tencent.luggage.p146d.C8860e.C8862a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.base.MMFalseProgressBar;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.luggage.p1070d.C31472a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C46417a;
import com.tencent.p177mm.plugin.webview.luggage.permission.C40250b;
import com.tencent.p177mm.plugin.webview.luggage.permission.C43905c;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key.C22870a;
import com.tencent.p177mm.plugin.webview.model.C40252a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C35652d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C40291o;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MovingImageButton;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.WebViewSearchContentInputFooter.C23150a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C14683a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C29963b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C35728c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.d */
public class C24905d extends C17821n {
    private static final Pattern uiv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern uiw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private boolean icm = true;
    private C17822a kOi = new C2491617();
    protected C7306ak mHandler;
    public String mTH;
    protected FrameLayout odV;
    protected C31472a uhQ;
    protected C22829j uhR;
    protected LinearLayout uhS;
    protected C22857k uhT;
    private WebViewKeyboardLinearLayout uhU;
    private WebViewInputFooter uhV;
    public WebViewSearchContentInputFooter uhW;
    private FrameLayout uhX;
    private MMFalseProgressBar uhY;
    protected MovingImageButton uhZ;
    protected FrameLayout uia;
    private C40230g uib;
    private C35652d uic;
    protected C22935h uie;
    private CustomViewCallback uif;
    private FrameLayout uig;
    private ProgressBar uih;
    protected LuggageGetA8Key uii;
    public C46422q uij;
    protected C43905c uik;
    protected Map<String, String> uil;
    protected boolean uim = false;
    protected boolean uio;
    protected int uiq;
    protected String uir = "";
    protected boolean uis;
    private boolean uit;
    private boolean uiu = false;
    private C22870a uix = new C2491916();

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$19 */
    class C1446319 implements OnClickListener {
        C1446319() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(6041);
            C24905d.this.bPN.loadUrl(C24905d.this.getUrl());
            C24905d.this.uhX.setVisibility(8);
            AppMethodBeat.m2505o(6041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$11 */
    class C2281511 implements OnClickListener {
        C2281511() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(6021);
            C24905d.this.bDy();
            AppMethodBeat.m2505o(6021);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$12 */
    class C2281612 extends C6031l {
        C2281612() {
        }

        /* renamed from: d */
        public final void mo7557d(WebView webView, String str) {
            int i = 1;
            AppMethodBeat.m2504i(6022);
            C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", str);
            if (C5046bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
                i = 0;
            }
            if (i == 0) {
                C24905d.this.mo41795cl(str, 0);
            }
            AppMethodBeat.m2505o(6022);
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.m2504i(6023);
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
            try {
                if (C24905d.this.uig != null) {
                    customViewCallback.onCustomViewHidden();
                    AppMethodBeat.m2505o(6023);
                    return;
                }
                C24905d.this.uig = new FrameLayout(C24905d.this.mContext);
                C24905d.this.uig.setBackgroundResource(C25738R.color.a5v);
                C24905d.this.uig.addView(view);
                C24905d.this.uif = customViewCallback;
                C24905d.this.uhR.setVisibility(8);
                C24905d.this.uhT.setVisibility(8);
                C24905d.this.odV.addView(C24905d.this.uig);
                AppMethodBeat.m2505o(6023);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(6023);
            }
        }

        public final void onHideCustomView() {
            AppMethodBeat.m2504i(6024);
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
            if (C24905d.this.uig == null) {
                AppMethodBeat.m2505o(6024);
                return;
            }
            try {
                C24905d.this.uhR.setVisibility(0);
                if (C24905d.this.uif != null) {
                    C24905d.this.uif.onCustomViewHidden();
                }
                C24905d.this.uhT.setVisibility(0);
                if (C24905d.this.uig != null) {
                    C24905d.this.odV.removeView(C24905d.this.uig);
                }
                C24905d.this.uig.removeAllViews();
                C24905d.this.uig = null;
                AppMethodBeat.m2505o(6024);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(6024);
            }
        }

        public final View getVideoLoadingProgressView() {
            AppMethodBeat.m2504i(6025);
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (C24905d.this.uih == null) {
                C24905d.this.uih = new ProgressBar(C24905d.this.mContext);
                C24905d.this.uih.setIndeterminate(true);
            }
            ProgressBar i = C24905d.this.uih;
            AppMethodBeat.m2505o(6025);
            return i;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$1 */
    class C228181 extends C45122a {
        C228181() {
        }

        /* renamed from: wY */
        public final boolean mo38421wY() {
            AppMethodBeat.m2504i(6002);
            if (C24905d.this.cWG()) {
                AppMethodBeat.m2505o(6002);
                return true;
            } else if (C24905d.this.uie == null || !C24905d.this.uie.mo38526Jx(22)) {
                AppMethodBeat.m2505o(6002);
                return false;
            } else {
                AppMethodBeat.m2505o(6002);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$2 */
    class C228192 implements C14683a {
        C228192() {
        }

        /* renamed from: EH */
        public final boolean mo26953EH(final String str) {
            AppMethodBeat.m2504i(6004);
            C24905d.this.bPN.mo52826a(new C17817c() {
                public final String name() {
                    return "onGetSmiley";
                }

                /* renamed from: wQ */
                public final JSONObject mo7075wQ() {
                    AppMethodBeat.m2504i(6003);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("smiley", str);
                    } catch (JSONException e) {
                    }
                    AppMethodBeat.m2505o(6003);
                    return jSONObject;
                }
            });
            AppMethodBeat.m2505o(6004);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$3 */
    class C228203 implements C29963b {
        C228203() {
        }

        public final void cWT() {
            AppMethodBeat.m2504i(6005);
            C24905d.this.mo41774IE(0);
            AppMethodBeat.m2505o(6005);
        }

        public final void cWU() {
            AppMethodBeat.m2504i(6006);
            if (C24905d.this.uhU != null && C24905d.this.uhU.getKeyBoardHeight() > 0) {
                C24905d.this.mo41774IE(C24905d.this.uhU.getKeyBoardHeight());
            }
            AppMethodBeat.m2505o(6006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$4 */
    class C228214 implements C23150a {
        C228214() {
        }

        public final void cWV() {
            AppMethodBeat.m2504i(6007);
            C24905d.m38965a(C24905d.this, 0);
            C24905d.this.uhQ.clearMatches();
            C24905d.this.uhW.dcX();
            AppMethodBeat.m2505o(6007);
        }

        /* renamed from: a */
        public final void mo31017a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
            AppMethodBeat.m2504i(6008);
            if (webViewSearchContentInputFooter.getVisibility() == 0) {
                mo31018b(webViewSearchContentInputFooter);
            }
            AppMethodBeat.m2505o(6008);
        }

        public final void cWW() {
            AppMethodBeat.m2504i(6009);
            C24905d.this.uhQ.findNext(false);
            AppMethodBeat.m2505o(6009);
        }

        public final void cWX() {
            AppMethodBeat.m2504i(6010);
            C24905d.this.uhQ.findNext(true);
            AppMethodBeat.m2505o(6010);
        }

        /* renamed from: b */
        public final void mo31018b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
            AppMethodBeat.m2504i(6011);
            C24905d.this.uhQ.clearMatches();
            webViewSearchContentInputFooter.reset();
            C24905d.this.uhW.mo38766t(0, 0, true);
            C24905d.this.uhQ.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.m2505o(6011);
        }

        /* renamed from: c */
        public final boolean mo31019c(int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$13 */
    class C2490613 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.webview.luggage.d$13$1 */
        class C45401 implements ValueCallback<String> {
            C45401() {
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(6026);
                String str = (String) obj;
                C4990ab.m7411d("MicroMsg.LuggageMMWebPage", "get background color s = %s", str);
                if (!C5046bo.isNullOrNil(str)) {
                    int color = C24905d.this.mContext.getResources().getColor(C25738R.color.a5v);
                    String[] split;
                    if (C24905d.uiv.matcher(str).matches()) {
                        split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                        if (split.length == 4) {
                            try {
                                color = Color.argb(C5046bo.getInt(C5046bo.nullAsNil(split[3]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[0]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[1]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[2]).trim(), 0));
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                                AppMethodBeat.m2505o(6026);
                                return;
                            }
                        }
                    } else if (C24905d.uiw.matcher(str).matches()) {
                        split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                        if (split.length == 3) {
                            try {
                                color = Color.argb(255, C5046bo.getInt(C5046bo.nullAsNil(split[0]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[1]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[2]).trim(), 0));
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                                AppMethodBeat.m2505o(6026);
                                return;
                            }
                        }
                    } else {
                        C4990ab.m7411d("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, can not match", str);
                    }
                    C24905d.this.uhR.setBackgroundColor(color);
                    C24905d.this.uhR.setX5LogoViewVisibility(8);
                }
                AppMethodBeat.m2505o(6026);
            }
        }

        C2490613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6027);
            C24905d.this.uhQ.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new C45401());
            AppMethodBeat.m2505o(6027);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$25 */
    class C2490825 implements C35728c {
        C2490825() {
        }

        public final void aee(String str) {
            AppMethodBeat.m2504i(6047);
            C24905d.cWQ();
            if (C24905d.this.uhV != null) {
                C24905d.this.uhV.hide();
            }
            AppMethodBeat.m2505o(6047);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$5 */
    class C249095 implements FindListener {
        C249095() {
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(6012);
            C24905d.this.uhW.mo38766t(i, i2, z);
            AppMethodBeat.m2505o(6012);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$23 */
    class C2491123 implements Runnable {
        C2491123() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6045);
            C24905d.this.uhT.mo38438bD(C24905d.this.uiq, C24905d.this.uir);
            AppMethodBeat.m2505o(6045);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$6 */
    class C249126 implements C44246a {
        C249126() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(6013);
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
            if (C24905d.this.uit) {
                C24905d.m38966a(C24905d.this, C24905d.this.uhU, i);
                if (i == -3) {
                    if (C24905d.this.uhV != null && C24905d.this.uhV.getVisibility() == 0) {
                        C24905d.this.uhV.dda();
                    }
                    C24905d.m38965a(C24905d.this, C24905d.this.uhU.getKeyBoardHeight());
                    AppMethodBeat.m2505o(6013);
                    return;
                }
                C24905d.m38965a(C24905d.this, 0);
                AppMethodBeat.m2505o(6013);
                return;
            }
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.m2505o(6013);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$8 */
    class C249138 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.webview.luggage.d$8$1 */
        class C144661 extends C17817c {
            C144661() {
            }

            public final String name() {
                return "onGetKeyboardHeight";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(6016);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("height", 0);
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(6016);
                return jSONObject;
            }
        }

        C249138() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6017);
            C24905d.this.bPN.mo52826a(new C144661());
            AppMethodBeat.m2505o(6017);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$10 */
    class C2491410 extends C36592s {
        C2491410() {
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(6019);
            C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
            C24905d.this.bDw();
            AppMethodBeat.m2505o(6019);
        }

        /* renamed from: a */
        public final void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
            AppMethodBeat.m2504i(6020);
            if (C24905d.this.uic == null) {
                C24905d.this.uic = new C35652d(C24905d.this.mContext, webView);
            }
            C24905d.this.uic.mo56360a(C24905d.this.getUrl(), c36588j, sslError);
            AppMethodBeat.m2505o(6020);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$15 */
    class C2491515 implements Runnable {
        C2491515() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6029);
            C24905d.this.uhR.setPullDownEnabled(false);
            AppMethodBeat.m2505o(6029);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$17 */
    class C2491617 extends C17822a {
        C2491617() {
        }

        /* renamed from: a */
        public final void mo32978a(C17821n c17821n, String str) {
            AppMethodBeat.m2504i(6037);
            C24905d.this.mo23976bE(str);
            AppMethodBeat.m2505o(6037);
        }

        /* renamed from: b */
        public final void mo32979b(C17821n c17821n, String str) {
            AppMethodBeat.m2504i(6038);
            C24905d.this.mo23977bF(str);
            AppMethodBeat.m2505o(6038);
        }

        /* renamed from: a */
        public final WebResourceResponse mo32977a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.m2504i(6039);
            if (C45287c.m83505iv(C24905d.this.mContext)) {
                try {
                    int i = bundle.getInt("resourceType");
                    if (i == 1 || i == 7) {
                        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                        C24905d.this.aed(webResourceRequest.getUrl().toString());
                    }
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", e.getMessage());
                } catch (Throwable th) {
                    C4990ab.m7421w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            AppMethodBeat.m2505o(6039);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$22 */
    class C2491722 implements Runnable {
        C2491722() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6044);
            C24905d.this.bDF();
            AppMethodBeat.m2505o(6044);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$16 */
    class C2491916 extends C22870a {
        C2491916() {
        }

        /* renamed from: NN */
        public final void mo23958NN(String str) {
            AppMethodBeat.m2504i(6033);
            C24905d.this.mo23963NN(str);
            AppMethodBeat.m2505o(6033);
        }

        public final void cWY() {
            C24905d.this.uim = false;
        }

        /* renamed from: e */
        public final void mo23960e(final String str, final String str2, final Map<String, String> map) {
            AppMethodBeat.m2504i(6034);
            C24905d.this.uim = false;
            C24905d.m38967a(C24905d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6030);
                    C24905d.this.mo23978e(str, str2, map);
                    AppMethodBeat.m2505o(6030);
                }
            });
            AppMethodBeat.m2505o(6034);
        }

        /* renamed from: ha */
        public final void mo38469ha(final String str, final String str2) {
            AppMethodBeat.m2504i(6035);
            C24905d.this.uim = false;
            C24905d.m38967a(C24905d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6031);
                    C24905d c24905d = C24905d.this;
                    String str = str2;
                    C32186k c32186k = c24905d.bPN;
                    String str2 = ProtocolPackage.ServerEncoding;
                    c32186k.bPA.loadData(str, "text/html", str2);
                    AppMethodBeat.m2505o(6031);
                }
            });
            AppMethodBeat.m2505o(6035);
        }

        /* renamed from: a */
        public final void mo23959a(int i, String str, int i2, int i3, String str2) {
            AppMethodBeat.m2504i(6036);
            C24905d.this.uim = false;
            final int i4 = i;
            final String str3 = str;
            final int i5 = i2;
            final int i6 = i3;
            final String str4 = str2;
            C24905d.m38967a(C24905d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6032);
                    C24905d.this.mo41780b(i4, str3, i5, i6);
                    AppMethodBeat.m2505o(6032);
                }
            });
            AppMethodBeat.m2505o(6036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$18 */
    class C2492318 implements Runnable {
        C2492318() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6040);
            C24905d.this.finish();
            AppMethodBeat.m2505o(6040);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$20 */
    class C2492420 implements OnTouchListener {
        C2492420() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(6042);
            if (C24905d.this.uhV.isShown()) {
                C24905d.this.uhV.hide();
            }
            AppMethodBeat.m2505o(6042);
            return false;
        }
    }

    static /* synthetic */ void cWQ() {
    }

    public C24905d(C41709g c41709g, C32186k c32186k, Bundle bundle) {
        boolean z = true;
        super(c41709g, c32186k, bundle);
        AppMethodBeat.m2504i(6048);
        if (c32186k != null) {
            this.uis = true;
            this.uii = C40250b.m69030IG(c32186k.hashCode());
        }
        String str = "MicroMsg.LuggageMMWebPage";
        String str2 = "LuggageMMWebPage create, getA8key == null ? %b";
        Object[] objArr = new Object[1];
        if (this.uii != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.uii == null) {
            this.uii = new LuggageGetA8Key();
        }
        this.mHandler = new C7306ak();
        this.uij = new C46422q(this);
        this.uik = new C43905c(this, this.uii);
        this.bPN.bPC = this.uik;
        this.uib = new C40230g(this);
        this.uie = C40291o.m69086a(new C22864l(this), cWO());
        C43887h.m78713b(this);
        if (this.uhQ != null) {
            this.uhQ.setWebViewClient(new C2491410());
            this.uhQ.setWebChromeClient(new C2281612());
        }
        mo20035a((C8862a) this.kOi);
        C45123i c45123i = this.bPd;
        c45123i.bPw.put(new C228181(), Boolean.FALSE);
        AppMethodBeat.m2505o(6048);
    }

    /* Access modifiers changed, original: protected */
    public View bDD() {
        AppMethodBeat.m2504i(6050);
        this.uhT = new C22857k(this);
        C22857k c22857k = this.uhT;
        AppMethodBeat.m2505o(6050);
        return c22857k;
    }

    /* Access modifiers changed, original: protected */
    public void bDy() {
        AppMethodBeat.m2504i(6051);
        this.uhT.bDy();
        AppMethodBeat.m2505o(6051);
    }

    public final void cWD() {
        AppMethodBeat.m2504i(6052);
        this.uie.mo38527a(new C31478t());
        AppMethodBeat.m2505o(6052);
    }

    /* renamed from: wU */
    public void mo20045wU() {
        AppMethodBeat.m2504i(6053);
        C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onForeground");
        setPageOrientation(this.bPP.getInt("screen_orientation", -1));
        mo23979hK(isFullScreen());
        bDE();
        m38959IB("onResume");
        this.uhQ.onResume();
        this.uit = true;
        AppMethodBeat.m2505o(6053);
    }

    /* renamed from: wW */
    public void mo20047wW() {
        AppMethodBeat.m2504i(6054);
        C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onBackground");
        m38959IB("onPause");
        this.uhT.bDz();
        this.uhQ.onPause();
        this.uit = false;
        AppMethodBeat.m2505o(6054);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(6055);
        if (!this.uiu) {
            this.uiu = true;
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "onDestroy");
            m38959IB("onDestroy");
            this.uie.dbc();
            this.uib.uiI = null;
            C43887h.m78714c(this);
            if (this.uie.dbd()) {
                C32186k c32186k = this.bPN;
                LuggageGetA8Key luggageGetA8Key = this.uii;
                C22868m.remove(C29809s.ujF);
                C29809s.ujF = C22868m.m34710a(c32186k, luggageGetA8Key);
            }
            LuggageGetA8Key luggageGetA8Key2 = this.uii;
            if (luggageGetA8Key2.uld != null) {
                luggageGetA8Key2.uld.aBW();
                luggageGetA8Key2.uld = null;
                C4990ab.m7416i("MicroMsg.LuggageGetA8Key", "destroy runCgiTask set null");
            }
        }
        AppMethodBeat.m2505o(6055);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: hK */
    public void mo23979hK(boolean z) {
        AppMethodBeat.m2504i(6058);
        if (z) {
            this.uhT.setVisibility(8);
            this.uhZ.setVisibility(0);
            C46417a.m87415c(((Activity) this.mContext).getWindow(), true);
            AppMethodBeat.m2505o(6058);
            return;
        }
        this.uhT.setVisibility(0);
        this.uhZ.setVisibility(8);
        C46417a.m87415c(((Activity) this.mContext).getWindow(), false);
        AppMethodBeat.m2505o(6058);
    }

    /* Access modifiers changed, original: protected */
    public void bDE() {
        AppMethodBeat.m2504i(6060);
        if (!this.uio) {
            this.uiq = this.bPP.getInt("customize_status_bar_color");
            if (this.uiq != 0) {
                this.uir = this.bPP.getString("status_bar_style");
            } else {
                this.uiq = C0380b.m652i(this.mContext, C25738R.color.f11695dt);
            }
        }
        bDF();
        AppMethodBeat.m2505o(6060);
    }

    public void bDF() {
        AppMethodBeat.m2504i(6061);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new C2491722());
            AppMethodBeat.m2505o(6061);
        } else if (C46417a.m87413a(this.mContext, this.uiq, this.uir)) {
            cWE();
            AppMethodBeat.m2505o(6061);
        } else {
            this.uiq = this.mContext.getResources().getColor(C25738R.color.f11906l8);
            this.uir = "";
            cWE();
            AppMethodBeat.m2505o(6061);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cWE() {
        AppMethodBeat.m2504i(6062);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new C2491123());
            AppMethodBeat.m2505o(6062);
            return;
        }
        this.uhT.mo38438bD(this.uiq, this.uir);
        AppMethodBeat.m2505o(6062);
    }

    public final void setStatusBarColor(int i) {
        AppMethodBeat.m2504i(6063);
        this.uio = true;
        this.uiq = i;
        bDF();
        AppMethodBeat.m2505o(6063);
    }

    /* renamed from: cl */
    public void mo41795cl(final String str, final int i) {
        AppMethodBeat.m2504i(6065);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6046);
                if (C24905d.this.uhT != null) {
                    if (!C5046bo.isNullOrNil(str)) {
                        C24905d.this.uhT.setTitleText(str);
                    }
                    if (i != 0) {
                        C24905d.this.uhT.setTitleColor(i);
                    }
                }
                AppMethodBeat.m2505o(6046);
            }
        });
        AppMethodBeat.m2505o(6065);
    }

    /* renamed from: IE */
    public final void mo41774IE(int i) {
        AppMethodBeat.m2504i(6066);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.uhV.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            this.uhV.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(6066);
    }

    public final int cWF() {
        AppMethodBeat.m2504i(6067);
        int dcZ;
        if (this.uhV == null) {
            AppMethodBeat.m2505o(6067);
            return 0;
        } else if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            dcZ = this.uhV.dcZ();
            AppMethodBeat.m2505o(6067);
            return dcZ;
        } else {
            dcZ = ((Integer) new C5039bj<Integer>(Integer.valueOf(0)) {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(6018);
                    Integer valueOf = Integer.valueOf(C24905d.this.uhV.dcZ());
                    AppMethodBeat.m2505o(6018);
                    return valueOf;
                }
            }.mo10372b(this.mHandler)).intValue();
            AppMethodBeat.m2505o(6067);
            return dcZ;
        }
    }

    /* renamed from: wD */
    public boolean mo23981wD(int i) {
        AppMethodBeat.m2504i(6068);
        boolean dA = this.uii.mo74640dA(getUrl(), i);
        AppMethodBeat.m2505o(6068);
        return dA;
    }

    public final boolean cWG() {
        AppMethodBeat.m2504i(6070);
        if (this.uhT != null) {
            boolean cWG = this.uhT.cWG();
            AppMethodBeat.m2505o(6070);
            return cWG;
        }
        AppMethodBeat.m2505o(6070);
        return false;
    }

    public final MMWebView getWebView() {
        return this.uhQ;
    }

    public final String getTitle() {
        AppMethodBeat.m2504i(6071);
        String title = this.uhT.getTitle();
        AppMethodBeat.m2505o(6071);
        return title;
    }

    public final C22857k cWH() {
        return this.uhT;
    }

    static {
        AppMethodBeat.m2504i(6094);
        AppMethodBeat.m2505o(6094);
    }

    public final void cWI() {
        AppMethodBeat.m2504i(6072);
        this.mHandler.post(new C2490613());
        AppMethodBeat.m2505o(6072);
    }

    public final void aec(final String str) {
        AppMethodBeat.m2504i(6073);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6028);
                C24905d.this.uhR.setBackgroundColor(C29916g.m47394bx(str, C24905d.this.mContext.getResources().getColor(C25738R.color.a5v)));
                C24905d.this.uhR.setX5LogoViewVisibility(8);
                AppMethodBeat.m2505o(6028);
            }
        });
        AppMethodBeat.m2505o(6073);
    }

    /* Access modifiers changed, original: protected */
    public void bDw() {
    }

    public final void cWJ() {
        AppMethodBeat.m2504i(6074);
        this.mHandler.post(new C2491515());
        AppMethodBeat.m2505o(6074);
    }

    public final boolean cWK() {
        return this.uim;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NQ */
    public boolean mo23964NQ(String str) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void bDv() {
        AppMethodBeat.m2504i(6075);
        this.uhY.setVisibility(0);
        this.uhY.start();
        AppMethodBeat.m2505o(6075);
    }

    /* Access modifiers changed, original: protected */
    public void bDG() {
        AppMethodBeat.m2504i(6076);
        this.uhY.finish();
        this.uhY.setVisibility(8);
        AppMethodBeat.m2505o(6076);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NP */
    public void mo41775NP(String str) {
        AppMethodBeat.m2504i(6077);
        if (this.uhQ.getX5WebViewExtension() != null) {
            this.uhR.setPullDownEnabled(true);
            this.uhR.setCurrentUrl(str);
        }
        AppMethodBeat.m2505o(6077);
    }

    /* renamed from: g */
    public void mo20038g(String str, Bundle bundle) {
        AppMethodBeat.m2504i(6078);
        this.uie.afY(str);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", str, Boolean.valueOf(this.uis));
        if (this.uis) {
            C4990ab.m7416i("MicroMsg.LuggageMMWebPage", "stash url");
            this.uhT.setOptionEnable(true);
            if (!C5046bo.isNullOrNil(this.bPP.getString("title"))) {
                mo41795cl(this.bPP.getString("title"), 0);
            }
            this.icm = false;
            if (this.uii == null) {
                this.uii = new LuggageGetA8Key();
            }
            mo23966NS(str);
            AppMethodBeat.m2505o(6078);
            return;
        }
        bDv();
        if (mo23964NQ(str)) {
            mo23967NT(str);
        } else if (!this.icm) {
            mo20038g(str, null);
            AppMethodBeat.m2505o(6078);
            return;
        }
        mo23966NS(str);
        this.icm = false;
        AppMethodBeat.m2505o(6078);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NT */
    public void mo23967NT(String str) {
        AppMethodBeat.m2504i(6079);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", str, Long.valueOf(System.currentTimeMillis()));
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.uhQ.loadUrl(str, hashMap);
        AppMethodBeat.m2505o(6079);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: bE */
    public void mo23976bE(String str) {
        AppMethodBeat.m2504i(6080);
        C4990ab.m7410d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(str)));
        if (mo23966NS(str)) {
            int ael = this.uii.ael(str);
            if (ael == 0 || ael == 2 || ael == 8) {
                this.bPN.stopLoading();
                AppMethodBeat.m2505o(6080);
                return;
            }
        }
        C40252a.m69033c(this.uhQ);
        this.uie.afY(str);
        this.uhT.setOptionEnable(false);
        bDv();
        mo41775NP(str);
        AppMethodBeat.m2505o(6080);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: bF */
    public void mo23977bF(String str) {
        AppMethodBeat.m2504i(6081);
        C4990ab.m7410d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(str)));
        C40252a.m69033c(this.uhQ);
        this.uhT.setOptionEnable(true);
        bDG();
        AppMethodBeat.m2505o(6081);
    }

    public final LuggageGetA8Key cWM() {
        return this.uii;
    }

    public final C43905c cWN() {
        return this.uik;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NS */
    public boolean mo23966NS(String str) {
        AppMethodBeat.m2504i(6084);
        if (this.uii.aem(str)) {
            this.uim = true;
            AppMethodBeat.m2505o(6084);
            return false;
        }
        boolean a = this.uii.mo74634a(str, this.uix);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", str, Boolean.valueOf(a));
        this.uim = a;
        AppMethodBeat.m2505o(6084);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aed(String str) {
        AppMethodBeat.m2504i(6085);
        boolean a = this.uii.mo74633a(str, 5, this.uix);
        AppMethodBeat.m2505o(6085);
        return a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NN */
    public void mo23963NN(String str) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo23978e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(6086);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", str, str2);
        if (C5046bo.isNullOrNil(this.mTH)) {
            this.mTH = str2;
        }
        this.uil = map;
        if (!(mo23964NQ(str) || this.uis)) {
            this.bPN.stopLoading();
            if (map == null || map.size() <= 0) {
                this.bPN.loadUrl(str2);
            } else {
                this.bPN.bPA.loadUrl(str2, map);
                AppMethodBeat.m2505o(6086);
                return;
            }
        }
        AppMethodBeat.m2505o(6086);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo41780b(int i, String str, int i2, int i3) {
        AppMethodBeat.m2504i(6087);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i) {
            case 0:
            case 2:
            case 8:
            case 9:
                if (!mo23964NQ(str)) {
                    this.uhX.setVisibility(0);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(6087);
    }

    public final C22935h cWP() {
        return this.uie;
    }

    public final void finish() {
        AppMethodBeat.m2504i(6090);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            int indexOf = this.bPe.mo43476xh().indexOf(this);
            if (indexOf < 0) {
                AppMethodBeat.m2505o(6090);
                return;
            }
            if (!this.bPe.mo43477xi().mo60235bJ(indexOf)) {
                ((Activity) this.mContext).finish();
            }
            AppMethodBeat.m2505o(6090);
            return;
        }
        C18514l.m28819q(new C2492318());
        AppMethodBeat.m2505o(6090);
    }

    /* renamed from: wR */
    public View mo20042wR() {
        AppMethodBeat.m2504i(6049);
        this.uhQ = (C31472a) this.bPN.mo52835xr();
        this.uhR = new C22829j(this.mContext, super.mo20042wR());
        this.uhQ.setCompetitorView(this.uhR);
        this.uhQ.setSource(this.bPP.getString("KPublisherId"));
        this.odV = new FrameLayout(this.mContext);
        this.uhS = new LinearLayout(this.mContext);
        this.uhS.setBackgroundColor(-1);
        this.odV.addView(this.uhS, new LayoutParams(-1, -1));
        this.uhS.setOrientation(1);
        this.uhS.addView(bDD());
        View inflate = C5616v.m8409hu(this.mContext).inflate(2130970011, this.uhS, false);
        this.uhS.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        this.uia = (FrameLayout) inflate.findViewById(2131821064);
        this.uhY = (MMFalseProgressBar) inflate.findViewById(2131823605);
        this.uhZ = (MovingImageButton) inflate.findViewById(2131824562);
        this.uhZ.setOnClickListener(new C2281511());
        this.uhU = (WebViewKeyboardLinearLayout) inflate.findViewById(2131824559);
        ((FrameLayout) inflate.findViewById(2131825691)).addView(this.uhR, new ViewGroup.LayoutParams(-1, -1));
        this.uhV = (WebViewInputFooter) inflate.findViewById(2131824560);
        this.uhV.hide();
        this.uhV.setOnTextSendListener(new C2490825());
        this.uhV.setOnSmileyChosenListener(new C228192());
        this.uhV.setOnSmileyPanelVisibilityChangedListener(new C228203());
        this.uhW = (WebViewSearchContentInputFooter) inflate.findViewById(2131824561);
        this.uhW.setActionDelegate(new C228214());
        this.uhQ.setFindListener(new C249095());
        this.uhX = (FrameLayout) inflate.findViewById(2131823604);
        if (this.uhX != null) {
            this.uhX.setOnClickListener(new C1446319());
        }
        this.uhU.setOnkbdStateListener(new C249126());
        this.uhQ.setOnTouchListener(new C2492420());
        FrameLayout frameLayout = this.odV;
        AppMethodBeat.m2505o(6049);
        return frameLayout;
    }

    public void reload() {
        AppMethodBeat.m2504i(6056);
        this.uhQ.reload();
        AppMethodBeat.m2505o(6056);
    }

    public final void setPageOrientation(int i) {
        AppMethodBeat.m2504i(6057);
        this.bPP.putInt("screen_orientation", i);
        ((Activity) this.mContext).setRequestedOrientation(i);
        AppMethodBeat.m2505o(6057);
    }

    /* renamed from: IB */
    private void m38959IB(final String str) {
        AppMethodBeat.m2504i(6059);
        this.bPN.mo52826a(new C17817c() {
            public final String name() {
                return "activity:state_change";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(6043);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(6043);
                return jSONObject;
            }
        });
        AppMethodBeat.m2505o(6059);
    }

    public final void aBj() {
        AppMethodBeat.m2504i(6064);
        this.uiq = C0380b.m652i(this.mContext, C25738R.color.f11695dt);
        this.uir = "";
        bDF();
        AppMethodBeat.m2505o(6064);
    }

    public final boolean isFullScreen() {
        AppMethodBeat.m2504i(6069);
        boolean z = this.bPP.getBoolean("show_full_screen", false);
        AppMethodBeat.m2505o(6069);
        return z;
    }

    public final String getUrl() {
        if (this.bPN != null) {
            return this.bPN.mUrl;
        }
        return null;
    }

    /* renamed from: xt */
    public String mo30766xt() {
        AppMethodBeat.m2504i(6082);
        String p = C32192i.m52511p(this.mContext, "luggage_mm_adapter.js");
        AppMethodBeat.m2505o(6082);
        return p;
    }

    public final String cWL() {
        AppMethodBeat.m2504i(6083);
        String string = this.bPP.getString("rawUrl");
        AppMethodBeat.m2505o(6083);
        return string;
    }

    public final boolean cWO() {
        AppMethodBeat.m2504i(6088);
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", Boolean.valueOf(this.bPP.getBoolean("forceHideShare", false)), Boolean.valueOf(this.bPP.getBoolean("showShare", true)), Boolean.valueOf(aYc()));
        if (!this.bPP.getBoolean("forceHideShare", false) && r3 && aYc()) {
            AppMethodBeat.m2505o(6088);
            return true;
        }
        AppMethodBeat.m2505o(6088);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYc() {
        boolean z;
        AppMethodBeat.m2504i(6089);
        if (this.bPP.getBoolean("disable_minimize", false)) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
        AppMethodBeat.m2505o(6089);
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ void m38966a(C24905d c24905d, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        AppMethodBeat.m2504i(6092);
        if (c24905d.uhQ.getX5WebViewExtension() != null || VERSION.SDK_INT >= 19) {
            if (i == -3) {
                final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                c24905d.mHandler.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.d$7$1 */
                    class C144651 extends C17817c {
                        C144651() {
                        }

                        public final String name() {
                            return "onGetKeyboardHeight";
                        }

                        /* renamed from: wQ */
                        public final JSONObject mo7075wQ() {
                            AppMethodBeat.m2504i(6014);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("height", keyBoardHeight);
                            } catch (Exception e) {
                            }
                            AppMethodBeat.m2505o(6014);
                            return jSONObject;
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(6015);
                        C24905d.this.bPN.mo52826a(new C144651());
                        AppMethodBeat.m2505o(6015);
                    }
                });
                AppMethodBeat.m2505o(6092);
                return;
            }
            c24905d.mHandler.post(new C249138());
        }
        AppMethodBeat.m2505o(6092);
    }
}
