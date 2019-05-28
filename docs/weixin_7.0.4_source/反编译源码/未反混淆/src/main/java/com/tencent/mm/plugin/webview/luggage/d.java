package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cj.c;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.plugin.webview.ui.tools.bag.o;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.l;
import com.tencent.xweb.s;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends n {
    private static final Pattern uiv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern uiw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private boolean icm = true;
    private a kOi = new a() {
        public final void a(n nVar, String str) {
            AppMethodBeat.i(6037);
            d.this.bE(str);
            AppMethodBeat.o(6037);
        }

        public final void b(n nVar, String str) {
            AppMethodBeat.i(6038);
            d.this.bF(str);
            AppMethodBeat.o(6038);
        }

        public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(6039);
            if (c.iv(d.this.mContext)) {
                try {
                    int i = bundle.getInt("resourceType");
                    if (i == 1 || i == 7) {
                        ab.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                        d.this.aed(webResourceRequest.getUrl().toString());
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", e.getMessage());
                } catch (Throwable th) {
                    ab.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            AppMethodBeat.o(6039);
            return null;
        }
    };
    protected ak mHandler;
    public String mTH;
    protected FrameLayout odV;
    protected com.tencent.mm.plugin.webview.luggage.d.a uhQ;
    protected j uhR;
    protected LinearLayout uhS;
    protected k uhT;
    private WebViewKeyboardLinearLayout uhU;
    private WebViewInputFooter uhV;
    public WebViewSearchContentInputFooter uhW;
    private FrameLayout uhX;
    private MMFalseProgressBar uhY;
    protected MovingImageButton uhZ;
    protected FrameLayout uia;
    private g uib;
    private com.tencent.mm.plugin.webview.ui.tools.d uic;
    protected h uie;
    private CustomViewCallback uif;
    private FrameLayout uig;
    private ProgressBar uih;
    protected LuggageGetA8Key uii;
    public q uij;
    protected com.tencent.mm.plugin.webview.luggage.permission.c uik;
    protected Map<String, String> uil;
    protected boolean uim = false;
    protected boolean uio;
    protected int uiq;
    protected String uir = "";
    protected boolean uis;
    private boolean uit;
    private boolean uiu = false;
    private LuggageGetA8Key.a uix = new LuggageGetA8Key.a() {
        public final void NN(String str) {
            AppMethodBeat.i(6033);
            d.this.NN(str);
            AppMethodBeat.o(6033);
        }

        public final void cWY() {
            d.this.uim = false;
        }

        public final void e(final String str, final String str2, final Map<String, String> map) {
            AppMethodBeat.i(6034);
            d.this.uim = false;
            d.a(d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6030);
                    d.this.e(str, str2, map);
                    AppMethodBeat.o(6030);
                }
            });
            AppMethodBeat.o(6034);
        }

        public final void ha(final String str, final String str2) {
            AppMethodBeat.i(6035);
            d.this.uim = false;
            d.a(d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6031);
                    d dVar = d.this;
                    String str = str2;
                    k kVar = dVar.bPN;
                    String str2 = ProtocolPackage.ServerEncoding;
                    kVar.bPA.loadData(str, "text/html", str2);
                    AppMethodBeat.o(6031);
                }
            });
            AppMethodBeat.o(6035);
        }

        public final void a(int i, String str, int i2, int i3, String str2) {
            AppMethodBeat.i(6036);
            d.this.uim = false;
            final int i4 = i;
            final String str3 = str;
            final int i5 = i2;
            final int i6 = i3;
            final String str4 = str2;
            d.a(d.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6032);
                    d.this.b(i4, str3, i5, i6);
                    AppMethodBeat.o(6032);
                }
            });
            AppMethodBeat.o(6036);
        }
    };

    static /* synthetic */ void cWQ() {
    }

    public d(g gVar, k kVar, Bundle bundle) {
        boolean z = true;
        super(gVar, kVar, bundle);
        AppMethodBeat.i(6048);
        if (kVar != null) {
            this.uis = true;
            this.uii = b.IG(kVar.hashCode());
        }
        String str = "MicroMsg.LuggageMMWebPage";
        String str2 = "LuggageMMWebPage create, getA8key == null ? %b";
        Object[] objArr = new Object[1];
        if (this.uii != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.uii == null) {
            this.uii = new LuggageGetA8Key();
        }
        this.mHandler = new ak();
        this.uij = new q(this);
        this.uik = new com.tencent.mm.plugin.webview.luggage.permission.c(this, this.uii);
        this.bPN.bPC = this.uik;
        this.uib = new g(this);
        this.uie = o.a(new l(this), cWO());
        h.b(this);
        if (this.uhQ != null) {
            this.uhQ.setWebViewClient(new s() {
                public final void a(WebView webView, int i, String str, String str2) {
                    AppMethodBeat.i(6019);
                    ab.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
                    d.this.bDw();
                    AppMethodBeat.o(6019);
                }

                public final void a(WebView webView, j jVar, SslError sslError) {
                    AppMethodBeat.i(6020);
                    if (d.this.uic == null) {
                        d.this.uic = new com.tencent.mm.plugin.webview.ui.tools.d(d.this.mContext, webView);
                    }
                    d.this.uic.a(d.this.getUrl(), jVar, sslError);
                    AppMethodBeat.o(6020);
                }
            });
            this.uhQ.setWebChromeClient(new l() {
                public final void d(WebView webView, String str) {
                    int i = 1;
                    AppMethodBeat.i(6022);
                    ab.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", str);
                    if (bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
                        i = 0;
                    }
                    if (i == 0) {
                        d.this.cl(str, 0);
                    }
                    AppMethodBeat.o(6022);
                }

                public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                    AppMethodBeat.i(6023);
                    ab.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
                    try {
                        if (d.this.uig != null) {
                            customViewCallback.onCustomViewHidden();
                            AppMethodBeat.o(6023);
                            return;
                        }
                        d.this.uig = new FrameLayout(d.this.mContext);
                        d.this.uig.setBackgroundResource(R.color.a5v);
                        d.this.uig.addView(view);
                        d.this.uif = customViewCallback;
                        d.this.uhR.setVisibility(8);
                        d.this.uhT.setVisibility(8);
                        d.this.odV.addView(d.this.uig);
                        AppMethodBeat.o(6023);
                    } catch (Exception e) {
                        ab.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + e.getMessage());
                        AppMethodBeat.o(6023);
                    }
                }

                public final void onHideCustomView() {
                    AppMethodBeat.i(6024);
                    ab.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
                    if (d.this.uig == null) {
                        AppMethodBeat.o(6024);
                        return;
                    }
                    try {
                        d.this.uhR.setVisibility(0);
                        if (d.this.uif != null) {
                            d.this.uif.onCustomViewHidden();
                        }
                        d.this.uhT.setVisibility(0);
                        if (d.this.uig != null) {
                            d.this.odV.removeView(d.this.uig);
                        }
                        d.this.uig.removeAllViews();
                        d.this.uig = null;
                        AppMethodBeat.o(6024);
                    } catch (Exception e) {
                        ab.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + e.getMessage());
                        AppMethodBeat.o(6024);
                    }
                }

                public final View getVideoLoadingProgressView() {
                    AppMethodBeat.i(6025);
                    ab.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
                    if (d.this.uih == null) {
                        d.this.uih = new ProgressBar(d.this.mContext);
                        d.this.uih.setIndeterminate(true);
                    }
                    ProgressBar i = d.this.uih;
                    AppMethodBeat.o(6025);
                    return i;
                }

                public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return false;
                }
            });
        }
        a((e.a) this.kOi);
        i iVar = this.bPd;
        iVar.bPw.put(new i.a() {
            public final boolean wY() {
                AppMethodBeat.i(6002);
                if (d.this.cWG()) {
                    AppMethodBeat.o(6002);
                    return true;
                } else if (d.this.uie == null || !d.this.uie.Jx(22)) {
                    AppMethodBeat.o(6002);
                    return false;
                } else {
                    AppMethodBeat.o(6002);
                    return true;
                }
            }
        }, Boolean.FALSE);
        AppMethodBeat.o(6048);
    }

    /* Access modifiers changed, original: protected */
    public View bDD() {
        AppMethodBeat.i(6050);
        this.uhT = new k(this);
        k kVar = this.uhT;
        AppMethodBeat.o(6050);
        return kVar;
    }

    /* Access modifiers changed, original: protected */
    public void bDy() {
        AppMethodBeat.i(6051);
        this.uhT.bDy();
        AppMethodBeat.o(6051);
    }

    public final void cWD() {
        AppMethodBeat.i(6052);
        this.uie.a(new t());
        AppMethodBeat.o(6052);
    }

    public void wU() {
        AppMethodBeat.i(6053);
        ab.i("MicroMsg.LuggageMMWebPage", "onForeground");
        setPageOrientation(this.bPP.getInt("screen_orientation", -1));
        hK(isFullScreen());
        bDE();
        IB("onResume");
        this.uhQ.onResume();
        this.uit = true;
        AppMethodBeat.o(6053);
    }

    public void wW() {
        AppMethodBeat.i(6054);
        ab.i("MicroMsg.LuggageMMWebPage", "onBackground");
        IB("onPause");
        this.uhT.bDz();
        this.uhQ.onPause();
        this.uit = false;
        AppMethodBeat.o(6054);
    }

    public void onDestroy() {
        AppMethodBeat.i(6055);
        if (!this.uiu) {
            this.uiu = true;
            ab.i("MicroMsg.LuggageMMWebPage", "onDestroy");
            IB("onDestroy");
            this.uie.dbc();
            this.uib.uiI = null;
            h.c(this);
            if (this.uie.dbd()) {
                k kVar = this.bPN;
                LuggageGetA8Key luggageGetA8Key = this.uii;
                m.remove(s.ujF);
                s.ujF = m.a(kVar, luggageGetA8Key);
            }
            LuggageGetA8Key luggageGetA8Key2 = this.uii;
            if (luggageGetA8Key2.uld != null) {
                luggageGetA8Key2.uld.aBW();
                luggageGetA8Key2.uld = null;
                ab.i("MicroMsg.LuggageGetA8Key", "destroy runCgiTask set null");
            }
        }
        AppMethodBeat.o(6055);
    }

    /* Access modifiers changed, original: protected */
    public void hK(boolean z) {
        AppMethodBeat.i(6058);
        if (z) {
            this.uhT.setVisibility(8);
            this.uhZ.setVisibility(0);
            com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity) this.mContext).getWindow(), true);
            AppMethodBeat.o(6058);
            return;
        }
        this.uhT.setVisibility(0);
        this.uhZ.setVisibility(8);
        com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity) this.mContext).getWindow(), false);
        AppMethodBeat.o(6058);
    }

    /* Access modifiers changed, original: protected */
    public void bDE() {
        AppMethodBeat.i(6060);
        if (!this.uio) {
            this.uiq = this.bPP.getInt("customize_status_bar_color");
            if (this.uiq != 0) {
                this.uir = this.bPP.getString("status_bar_style");
            } else {
                this.uiq = android.support.v4.content.b.i(this.mContext, R.color.dt);
            }
        }
        bDF();
        AppMethodBeat.o(6060);
    }

    public void bDF() {
        AppMethodBeat.i(6061);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6044);
                    d.this.bDF();
                    AppMethodBeat.o(6044);
                }
            });
            AppMethodBeat.o(6061);
        } else if (com.tencent.mm.plugin.webview.luggage.c.a.a(this.mContext, this.uiq, this.uir)) {
            cWE();
            AppMethodBeat.o(6061);
        } else {
            this.uiq = this.mContext.getResources().getColor(R.color.l8);
            this.uir = "";
            cWE();
            AppMethodBeat.o(6061);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cWE() {
        AppMethodBeat.i(6062);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6045);
                    d.this.uhT.bD(d.this.uiq, d.this.uir);
                    AppMethodBeat.o(6045);
                }
            });
            AppMethodBeat.o(6062);
            return;
        }
        this.uhT.bD(this.uiq, this.uir);
        AppMethodBeat.o(6062);
    }

    public final void setStatusBarColor(int i) {
        AppMethodBeat.i(6063);
        this.uio = true;
        this.uiq = i;
        bDF();
        AppMethodBeat.o(6063);
    }

    public void cl(final String str, final int i) {
        AppMethodBeat.i(6065);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6046);
                if (d.this.uhT != null) {
                    if (!bo.isNullOrNil(str)) {
                        d.this.uhT.setTitleText(str);
                    }
                    if (i != 0) {
                        d.this.uhT.setTitleColor(i);
                    }
                }
                AppMethodBeat.o(6046);
            }
        });
        AppMethodBeat.o(6065);
    }

    public final void IE(int i) {
        AppMethodBeat.i(6066);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.uhV.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            this.uhV.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(6066);
    }

    public final int cWF() {
        AppMethodBeat.i(6067);
        int dcZ;
        if (this.uhV == null) {
            AppMethodBeat.o(6067);
            return 0;
        } else if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            dcZ = this.uhV.dcZ();
            AppMethodBeat.o(6067);
            return dcZ;
        } else {
            dcZ = ((Integer) new bj<Integer>(Integer.valueOf(0)) {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(6018);
                    Integer valueOf = Integer.valueOf(d.this.uhV.dcZ());
                    AppMethodBeat.o(6018);
                    return valueOf;
                }
            }.b(this.mHandler)).intValue();
            AppMethodBeat.o(6067);
            return dcZ;
        }
    }

    public boolean wD(int i) {
        AppMethodBeat.i(6068);
        boolean dA = this.uii.dA(getUrl(), i);
        AppMethodBeat.o(6068);
        return dA;
    }

    public final boolean cWG() {
        AppMethodBeat.i(6070);
        if (this.uhT != null) {
            boolean cWG = this.uhT.cWG();
            AppMethodBeat.o(6070);
            return cWG;
        }
        AppMethodBeat.o(6070);
        return false;
    }

    public final MMWebView getWebView() {
        return this.uhQ;
    }

    public final String getTitle() {
        AppMethodBeat.i(6071);
        String title = this.uhT.getTitle();
        AppMethodBeat.o(6071);
        return title;
    }

    public final k cWH() {
        return this.uhT;
    }

    static {
        AppMethodBeat.i(6094);
        AppMethodBeat.o(6094);
    }

    public final void cWI() {
        AppMethodBeat.i(6072);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6027);
                d.this.uhQ.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new ValueCallback<String>() {
                    public final /* synthetic */ void onReceiveValue(Object obj) {
                        AppMethodBeat.i(6026);
                        String str = (String) obj;
                        ab.d("MicroMsg.LuggageMMWebPage", "get background color s = %s", str);
                        if (!bo.isNullOrNil(str)) {
                            int color = d.this.mContext.getResources().getColor(R.color.a5v);
                            String[] split;
                            if (d.uiv.matcher(str).matches()) {
                                split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                if (split.length == 4) {
                                    try {
                                        color = Color.argb(bo.getInt(bo.nullAsNil(split[3]).trim(), 0), bo.getInt(bo.nullAsNil(split[0]).trim(), 0), bo.getInt(bo.nullAsNil(split[1]).trim(), 0), bo.getInt(bo.nullAsNil(split[2]).trim(), 0));
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                                        AppMethodBeat.o(6026);
                                        return;
                                    }
                                }
                            } else if (d.uiw.matcher(str).matches()) {
                                split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                if (split.length == 3) {
                                    try {
                                        color = Color.argb(255, bo.getInt(bo.nullAsNil(split[0]).trim(), 0), bo.getInt(bo.nullAsNil(split[1]).trim(), 0), bo.getInt(bo.nullAsNil(split[2]).trim(), 0));
                                    } catch (Exception e2) {
                                        ab.e("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                                        AppMethodBeat.o(6026);
                                        return;
                                    }
                                }
                            } else {
                                ab.d("MicroMsg.LuggageMMWebPage", "handle bgColor from html, bgColor = %s, can not match", str);
                            }
                            d.this.uhR.setBackgroundColor(color);
                            d.this.uhR.setX5LogoViewVisibility(8);
                        }
                        AppMethodBeat.o(6026);
                    }
                });
                AppMethodBeat.o(6027);
            }
        });
        AppMethodBeat.o(6072);
    }

    public final void aec(final String str) {
        AppMethodBeat.i(6073);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6028);
                d.this.uhR.setBackgroundColor(com.tencent.mm.plugin.webview.ui.tools.g.bx(str, d.this.mContext.getResources().getColor(R.color.a5v)));
                d.this.uhR.setX5LogoViewVisibility(8);
                AppMethodBeat.o(6028);
            }
        });
        AppMethodBeat.o(6073);
    }

    /* Access modifiers changed, original: protected */
    public void bDw() {
    }

    public final void cWJ() {
        AppMethodBeat.i(6074);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6029);
                d.this.uhR.setPullDownEnabled(false);
                AppMethodBeat.o(6029);
            }
        });
        AppMethodBeat.o(6074);
    }

    public final boolean cWK() {
        return this.uim;
    }

    /* Access modifiers changed, original: protected */
    public boolean NQ(String str) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void bDv() {
        AppMethodBeat.i(6075);
        this.uhY.setVisibility(0);
        this.uhY.start();
        AppMethodBeat.o(6075);
    }

    /* Access modifiers changed, original: protected */
    public void bDG() {
        AppMethodBeat.i(6076);
        this.uhY.finish();
        this.uhY.setVisibility(8);
        AppMethodBeat.o(6076);
    }

    /* Access modifiers changed, original: protected */
    public void NP(String str) {
        AppMethodBeat.i(6077);
        if (this.uhQ.getX5WebViewExtension() != null) {
            this.uhR.setPullDownEnabled(true);
            this.uhR.setCurrentUrl(str);
        }
        AppMethodBeat.o(6077);
    }

    public void g(String str, Bundle bundle) {
        AppMethodBeat.i(6078);
        this.uie.afY(str);
        ab.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", str, Boolean.valueOf(this.uis));
        if (this.uis) {
            ab.i("MicroMsg.LuggageMMWebPage", "stash url");
            this.uhT.setOptionEnable(true);
            if (!bo.isNullOrNil(this.bPP.getString("title"))) {
                cl(this.bPP.getString("title"), 0);
            }
            this.icm = false;
            if (this.uii == null) {
                this.uii = new LuggageGetA8Key();
            }
            NS(str);
            AppMethodBeat.o(6078);
            return;
        }
        bDv();
        if (NQ(str)) {
            NT(str);
        } else if (!this.icm) {
            g(str, null);
            AppMethodBeat.o(6078);
            return;
        }
        NS(str);
        this.icm = false;
        AppMethodBeat.o(6078);
    }

    /* Access modifiers changed, original: protected */
    public void NT(String str) {
        AppMethodBeat.i(6079);
        ab.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", str, Long.valueOf(System.currentTimeMillis()));
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.uhQ.loadUrl(str, hashMap);
        AppMethodBeat.o(6079);
    }

    /* Access modifiers changed, original: protected */
    public void bE(String str) {
        AppMethodBeat.i(6080);
        ab.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(str)));
        if (NS(str)) {
            int ael = this.uii.ael(str);
            if (ael == 0 || ael == 2 || ael == 8) {
                this.bPN.stopLoading();
                AppMethodBeat.o(6080);
                return;
            }
        }
        com.tencent.mm.plugin.webview.model.a.c(this.uhQ);
        this.uie.afY(str);
        this.uhT.setOptionEnable(false);
        bDv();
        NP(str);
        AppMethodBeat.o(6080);
    }

    /* Access modifiers changed, original: protected */
    public void bF(String str) {
        AppMethodBeat.i(6081);
        ab.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.webview.model.a.c(this.uhQ);
        this.uhT.setOptionEnable(true);
        bDG();
        AppMethodBeat.o(6081);
    }

    public final LuggageGetA8Key cWM() {
        return this.uii;
    }

    public final com.tencent.mm.plugin.webview.luggage.permission.c cWN() {
        return this.uik;
    }

    /* Access modifiers changed, original: protected */
    public boolean NS(String str) {
        AppMethodBeat.i(6084);
        if (this.uii.aem(str)) {
            this.uim = true;
            AppMethodBeat.o(6084);
            return false;
        }
        boolean a = this.uii.a(str, this.uix);
        ab.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", str, Boolean.valueOf(a));
        this.uim = a;
        AppMethodBeat.o(6084);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aed(String str) {
        AppMethodBeat.i(6085);
        boolean a = this.uii.a(str, 5, this.uix);
        AppMethodBeat.o(6085);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void NN(String str) {
    }

    /* Access modifiers changed, original: protected */
    public void e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(6086);
        ab.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", str, str2);
        if (bo.isNullOrNil(this.mTH)) {
            this.mTH = str2;
        }
        this.uil = map;
        if (!(NQ(str) || this.uis)) {
            this.bPN.stopLoading();
            if (map == null || map.size() <= 0) {
                this.bPN.loadUrl(str2);
            } else {
                this.bPN.bPA.loadUrl(str2, map);
                AppMethodBeat.o(6086);
                return;
            }
        }
        AppMethodBeat.o(6086);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, String str, int i2, int i3) {
        AppMethodBeat.i(6087);
        ab.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i) {
            case 0:
            case 2:
            case 8:
            case 9:
                if (!NQ(str)) {
                    this.uhX.setVisibility(0);
                    break;
                }
                break;
        }
        AppMethodBeat.o(6087);
    }

    public final h cWP() {
        return this.uie;
    }

    public final void finish() {
        AppMethodBeat.i(6090);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            int indexOf = this.bPe.xh().indexOf(this);
            if (indexOf < 0) {
                AppMethodBeat.o(6090);
                return;
            }
            if (!this.bPe.xi().bJ(indexOf)) {
                ((Activity) this.mContext).finish();
            }
            AppMethodBeat.o(6090);
            return;
        }
        com.tencent.mm.ipcinvoker.l.q(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6040);
                d.this.finish();
                AppMethodBeat.o(6040);
            }
        });
        AppMethodBeat.o(6090);
    }

    public View wR() {
        AppMethodBeat.i(6049);
        this.uhQ = (com.tencent.mm.plugin.webview.luggage.d.a) this.bPN.xr();
        this.uhR = new j(this.mContext, super.wR());
        this.uhQ.setCompetitorView(this.uhR);
        this.uhQ.setSource(this.bPP.getString("KPublisherId"));
        this.odV = new FrameLayout(this.mContext);
        this.uhS = new LinearLayout(this.mContext);
        this.uhS.setBackgroundColor(-1);
        this.odV.addView(this.uhS, new LayoutParams(-1, -1));
        this.uhS.setOrientation(1);
        this.uhS.addView(bDD());
        View inflate = v.hu(this.mContext).inflate(R.layout.aaz, this.uhS, false);
        this.uhS.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        this.uia = (FrameLayout) inflate.findViewById(R.id.nc);
        this.uhY = (MMFalseProgressBar) inflate.findViewById(R.id.bhq);
        this.uhZ = (MovingImageButton) inflate.findViewById(R.id.c7l);
        this.uhZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(6021);
                d.this.bDy();
                AppMethodBeat.o(6021);
            }
        });
        this.uhU = (WebViewKeyboardLinearLayout) inflate.findViewById(R.id.c7i);
        ((FrameLayout) inflate.findViewById(R.id.d15)).addView(this.uhR, new ViewGroup.LayoutParams(-1, -1));
        this.uhV = (WebViewInputFooter) inflate.findViewById(R.id.c7j);
        this.uhV.hide();
        this.uhV.setOnTextSendListener(new WebViewInputFooter.c() {
            public final void aee(String str) {
                AppMethodBeat.i(6047);
                d.cWQ();
                if (d.this.uhV != null) {
                    d.this.uhV.hide();
                }
                AppMethodBeat.o(6047);
            }
        });
        this.uhV.setOnSmileyChosenListener(new WebViewInputFooter.a() {
            public final boolean EH(final String str) {
                AppMethodBeat.i(6004);
                d.this.bPN.a(new com.tencent.luggage.d.c() {
                    public final String name() {
                        return "onGetSmiley";
                    }

                    public final JSONObject wQ() {
                        AppMethodBeat.i(6003);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("smiley", str);
                        } catch (JSONException e) {
                        }
                        AppMethodBeat.o(6003);
                        return jSONObject;
                    }
                });
                AppMethodBeat.o(6004);
                return true;
            }
        });
        this.uhV.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b() {
            public final void cWT() {
                AppMethodBeat.i(6005);
                d.this.IE(0);
                AppMethodBeat.o(6005);
            }

            public final void cWU() {
                AppMethodBeat.i(6006);
                if (d.this.uhU != null && d.this.uhU.getKeyBoardHeight() > 0) {
                    d.this.IE(d.this.uhU.getKeyBoardHeight());
                }
                AppMethodBeat.o(6006);
            }
        });
        this.uhW = (WebViewSearchContentInputFooter) inflate.findViewById(R.id.c7k);
        this.uhW.setActionDelegate(new WebViewSearchContentInputFooter.a() {
            public final void cWV() {
                AppMethodBeat.i(6007);
                d.a(d.this, 0);
                d.this.uhQ.clearMatches();
                d.this.uhW.dcX();
                AppMethodBeat.o(6007);
            }

            public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                AppMethodBeat.i(6008);
                if (webViewSearchContentInputFooter.getVisibility() == 0) {
                    b(webViewSearchContentInputFooter);
                }
                AppMethodBeat.o(6008);
            }

            public final void cWW() {
                AppMethodBeat.i(6009);
                d.this.uhQ.findNext(false);
                AppMethodBeat.o(6009);
            }

            public final void cWX() {
                AppMethodBeat.i(6010);
                d.this.uhQ.findNext(true);
                AppMethodBeat.o(6010);
            }

            public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                AppMethodBeat.i(6011);
                d.this.uhQ.clearMatches();
                webViewSearchContentInputFooter.reset();
                d.this.uhW.t(0, 0, true);
                d.this.uhQ.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
                AppMethodBeat.o(6011);
            }

            public final boolean c(int i, KeyEvent keyEvent) {
                return false;
            }
        });
        this.uhQ.setFindListener(new FindListener() {
            public final void onFindResultReceived(int i, int i2, boolean z) {
                AppMethodBeat.i(6012);
                d.this.uhW.t(i, i2, z);
                AppMethodBeat.o(6012);
            }
        });
        this.uhX = (FrameLayout) inflate.findViewById(R.id.bhp);
        if (this.uhX != null) {
            this.uhX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(6041);
                    d.this.bPN.loadUrl(d.this.getUrl());
                    d.this.uhX.setVisibility(8);
                    AppMethodBeat.o(6041);
                }
            });
        }
        this.uhU.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(6013);
                ab.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
                if (d.this.uit) {
                    d.a(d.this, d.this.uhU, i);
                    if (i == -3) {
                        if (d.this.uhV != null && d.this.uhV.getVisibility() == 0) {
                            d.this.uhV.dda();
                        }
                        d.a(d.this, d.this.uhU.getKeyBoardHeight());
                        AppMethodBeat.o(6013);
                        return;
                    }
                    d.a(d.this, 0);
                    AppMethodBeat.o(6013);
                    return;
                }
                ab.i("MicroMsg.LuggageMMWebPage", "background ignored");
                AppMethodBeat.o(6013);
            }
        });
        this.uhQ.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(6042);
                if (d.this.uhV.isShown()) {
                    d.this.uhV.hide();
                }
                AppMethodBeat.o(6042);
                return false;
            }
        });
        FrameLayout frameLayout = this.odV;
        AppMethodBeat.o(6049);
        return frameLayout;
    }

    public void reload() {
        AppMethodBeat.i(6056);
        this.uhQ.reload();
        AppMethodBeat.o(6056);
    }

    public final void setPageOrientation(int i) {
        AppMethodBeat.i(6057);
        this.bPP.putInt("screen_orientation", i);
        ((Activity) this.mContext).setRequestedOrientation(i);
        AppMethodBeat.o(6057);
    }

    private void IB(final String str) {
        AppMethodBeat.i(6059);
        this.bPN.a(new com.tencent.luggage.d.c() {
            public final String name() {
                return "activity:state_change";
            }

            public final JSONObject wQ() {
                AppMethodBeat.i(6043);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (Exception e) {
                }
                AppMethodBeat.o(6043);
                return jSONObject;
            }
        });
        AppMethodBeat.o(6059);
    }

    public final void aBj() {
        AppMethodBeat.i(6064);
        this.uiq = android.support.v4.content.b.i(this.mContext, R.color.dt);
        this.uir = "";
        bDF();
        AppMethodBeat.o(6064);
    }

    public final boolean isFullScreen() {
        AppMethodBeat.i(6069);
        boolean z = this.bPP.getBoolean("show_full_screen", false);
        AppMethodBeat.o(6069);
        return z;
    }

    public final String getUrl() {
        if (this.bPN != null) {
            return this.bPN.mUrl;
        }
        return null;
    }

    public String xt() {
        AppMethodBeat.i(6082);
        String p = com.tencent.luggage.g.i.p(this.mContext, "luggage_mm_adapter.js");
        AppMethodBeat.o(6082);
        return p;
    }

    public final String cWL() {
        AppMethodBeat.i(6083);
        String string = this.bPP.getString("rawUrl");
        AppMethodBeat.o(6083);
        return string;
    }

    public final boolean cWO() {
        AppMethodBeat.i(6088);
        ab.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", Boolean.valueOf(this.bPP.getBoolean("forceHideShare", false)), Boolean.valueOf(this.bPP.getBoolean("showShare", true)), Boolean.valueOf(aYc()));
        if (!this.bPP.getBoolean("forceHideShare", false) && r3 && aYc()) {
            AppMethodBeat.o(6088);
            return true;
        }
        AppMethodBeat.o(6088);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYc() {
        boolean z;
        AppMethodBeat.i(6089);
        if (this.bPP.getBoolean("disable_minimize", false)) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
        AppMethodBeat.o(6089);
        return z;
    }

    static /* synthetic */ void a(d dVar, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        AppMethodBeat.i(6092);
        if (dVar.uhQ.getX5WebViewExtension() != null || VERSION.SDK_INT >= 19) {
            if (i == -3) {
                final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                dVar.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6015);
                        d.this.bPN.a(new com.tencent.luggage.d.c() {
                            public final String name() {
                                return "onGetKeyboardHeight";
                            }

                            public final JSONObject wQ() {
                                AppMethodBeat.i(6014);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("height", keyBoardHeight);
                                } catch (Exception e) {
                                }
                                AppMethodBeat.o(6014);
                                return jSONObject;
                            }
                        });
                        AppMethodBeat.o(6015);
                    }
                });
                AppMethodBeat.o(6092);
                return;
            }
            dVar.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6017);
                    d.this.bPN.a(new com.tencent.luggage.d.c() {
                        public final String name() {
                            return "onGetKeyboardHeight";
                        }

                        public final JSONObject wQ() {
                            AppMethodBeat.i(6016);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("height", 0);
                            } catch (Exception e) {
                            }
                            AppMethodBeat.o(6016);
                            return jSONObject;
                        }
                    });
                    AppMethodBeat.o(6017);
                }
            });
        }
        AppMethodBeat.o(6092);
    }
}
