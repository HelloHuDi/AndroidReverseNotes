package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.luggage.i.a.a;
import com.tencent.luggage.i.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.e.f;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.l;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.net.URL;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkView;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author = 10000, fComment = "checked", lastDate = "20180919", reviewer = 10000, vComment = {EType.HTTPSCHECK})
public final class aa extends MMWebView implements c, aj {
    private r icr;
    private b ics;
    private c isR;
    private af iug;
    private ad iuh;
    private ae iui;
    private ab iuj;
    private Animator iuk;
    private boolean iul;
    private String ium;
    private f iun;
    private s iuo;
    private l iup;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aa(Context context, ab abVar) {
        super(new MutableContextWrapper(context));
        AppMethodBeat.i(132472);
        this.iuh = null;
        this.iul = false;
        this.iuo = new s() {
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(132443);
                aa.this.iuj;
                AppMethodBeat.o(132443);
            }

            public final void b(WebView webView, String str) {
                AppMethodBeat.i(132444);
                aa.this.iuj.hTn.aJM();
                AppMethodBeat.o(132444);
            }

            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(132445);
                ab.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", str);
                AppMethodBeat.o(132445);
                return true;
            }

            public final void a(WebView webView, j jVar, SslError sslError) {
                AppMethodBeat.i(132446);
                if (sslError.getPrimaryError() != 3) {
                    jVar.cancel();
                    AppMethodBeat.o(132446);
                } else if (aa.this.iuj.a(sslError.getCertificate())) {
                    jVar.proceed();
                    AppMethodBeat.o(132446);
                } else {
                    jVar.cancel();
                    AppMethodBeat.o(132446);
                }
            }

            public final o c(WebView webView, String str) {
                AppMethodBeat.i(132447);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(132447);
                    return null;
                }
                o a = aa.a(aa.this, str);
                AppMethodBeat.o(132447);
                return a;
            }

            public final o a(WebView webView, n nVar) {
                AppMethodBeat.i(132448);
                if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                    AppMethodBeat.o(132448);
                    return null;
                }
                o a = aa.a(aa.this, nVar.getUrl().toString());
                AppMethodBeat.o(132448);
                return a;
            }

            public final o a(WebView webView, n nVar, Bundle bundle) {
                AppMethodBeat.i(132449);
                if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                    AppMethodBeat.o(132449);
                    return null;
                }
                o a = aa.a(aa.this, nVar.getUrl().toString());
                AppMethodBeat.o(132449);
                return a;
            }

            public final void a(WebView webView, int i, String str, String str2) {
                AppMethodBeat.i(132450);
                ab.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
                AppMethodBeat.o(132450);
            }

            public final void a(WebView webView, n nVar, o oVar) {
                AppMethodBeat.i(132451);
                Uri url = nVar.getUrl();
                String uri = url == null ? BuildConfig.COMMAND : url.toString();
                ab.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", uri, oVar.mMimeType, Integer.valueOf(oVar.mStatusCode));
                AppMethodBeat.o(132451);
            }
        };
        this.iup = new l() {
            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                AppMethodBeat.i(132452);
                try {
                    if (aa.this.isR != null) {
                        aa.this.isR.G(view, 90);
                        aa.this.isR.iqP = customViewCallback;
                    }
                    AppMethodBeat.o(132452);
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e.getMessage());
                    AppMethodBeat.o(132452);
                }
            }

            public final void onHideCustomView() {
                AppMethodBeat.i(132453);
                try {
                    if (aa.this.isR != null) {
                        aa.this.isR.aIZ();
                    }
                    AppMethodBeat.o(132453);
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e.getMessage());
                    AppMethodBeat.o(132453);
                }
            }
        };
        this.icr = new r() {
            public final boolean A(MotionEvent motionEvent) {
                AppMethodBeat.i(132454);
                boolean Q = aa.this.Q(motionEvent);
                AppMethodBeat.o(132454);
                return Q;
            }

            public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                AppMethodBeat.i(132455);
                boolean c = aa.this.c(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(132455);
                return c;
            }

            public final void aGs() {
                AppMethodBeat.i(132456);
                aa.this.dKK();
                AppMethodBeat.o(132456);
            }

            @TargetApi(9)
            public final void d(int i, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(132457);
                aa.this.e(i, i2, z, z2);
                AppMethodBeat.o(132457);
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                AppMethodBeat.i(132458);
                if (aa.this.iug != null) {
                    aa.this.iug.onScrollChanged(i, i2, i3, i4, view);
                }
                aa.this.iuj;
                aa.this.M(i, i2, i3, i4);
                AppMethodBeat.o(132458);
            }

            public final boolean B(MotionEvent motionEvent) {
                AppMethodBeat.i(132459);
                boolean R = aa.this.R(motionEvent);
                AppMethodBeat.o(132459);
                return R;
            }

            public final boolean C(MotionEvent motionEvent) {
                AppMethodBeat.i(132460);
                boolean S = aa.this.S(motionEvent);
                AppMethodBeat.o(132460);
                return S;
            }
        };
        this.ics = new b() {
            public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(132461);
                boolean A = aa.this.icr.A(motionEvent);
                AppMethodBeat.o(132461);
                return A;
            }

            public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(132462);
                boolean C = aa.this.icr.C(motionEvent);
                AppMethodBeat.o(132462);
                return C;
            }

            public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(132463);
                boolean B = aa.this.icr.B(motionEvent);
                AppMethodBeat.o(132463);
                return B;
            }

            public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
                AppMethodBeat.i(132464);
                boolean b = aa.this.icr.b(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(132464);
                return b;
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                AppMethodBeat.i(132465);
                aa.this.icr.onScrollChanged(i, i2, i3, i4, view);
                AppMethodBeat.o(132465);
            }

            public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
                AppMethodBeat.i(132466);
                aa.this.icr.d(i, i2, z, z2);
                AppMethodBeat.o(132466);
            }

            public final void computeScroll(View view) {
                AppMethodBeat.i(132467);
                aa.this.icr.aGs();
                AppMethodBeat.o(132467);
            }

            public final boolean onShowLongClickPopupMenu() {
                AppMethodBeat.i(132468);
                if (WebView.getUsingTbsCoreVersion(aa.this.getContext()) >= 43011) {
                    AppMethodBeat.o(132468);
                    return false;
                }
                AppMethodBeat.o(132468);
                return true;
            }

            public final void invalidate() {
            }

            public final Object onMiscCallBack(String str, Bundle bundle) {
                AppMethodBeat.i(132469);
                if (bo.isNullOrNil(str) || bundle == null) {
                    AppMethodBeat.o(132469);
                } else {
                    ab.i("MicroMsg.AppBrandWebView", "method = %s", str);
                    AppMethodBeat.o(132469);
                }
                return null;
            }

            public final boolean shouldDiscardCurrentPage() {
                AppMethodBeat.i(132470);
                if (aa.this.iui == null) {
                    AppMethodBeat.o(132470);
                    return false;
                }
                boolean z;
                boolean xU = aa.this.iui.xU();
                String str = "MicroMsg.AppBrandWebView";
                String str2 = "shouldTrimCurrentPage: %b";
                Object[] objArr = new Object[1];
                if (!xU || aa.this.iul) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                if (!xU || aa.this.iul) {
                    AppMethodBeat.o(132470);
                    return false;
                }
                AppMethodBeat.o(132470);
                return true;
            }

            public final void hasDiscardCurrentPage(boolean z) {
                AppMethodBeat.i(132471);
                aa.this.iul = z;
                AppMethodBeat.o(132471);
            }
        };
        this.inited = true;
        this.iuj = abVar;
        getSettings().dUh();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().dUj();
        getSettings().setUserAgentString(u.bh(getContext(), getSettings().getUserAgentString()));
        this.ium = getSettings().getUserAgentString();
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.iuo);
        setWebChromeClient(this.iup);
        setWebViewCallbackClient(this.icr);
        setWebViewClientExtension(this.ics);
        getIsX5Kernel();
        getSettings().setUsingForAppBrand(1);
        ab.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
        if (com.tencent.mm.plugin.appbrand.e.b.hpK == null) {
            com.tencent.mm.plugin.appbrand.e.b.hpK = new com.tencent.mm.plugin.appbrand.e.b();
        }
        com.tencent.mm.plugin.appbrand.e.b bVar = com.tencent.mm.plugin.appbrand.e.b.hpK;
        if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand()) {
            ab.w("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
        } else if (isXWalkKernel()) {
            ab.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, webview(%s) is xweb kernel", Integer.valueOf(hashCode()));
            View webViewUI = getWebViewUI();
            if (webViewUI == null || !(webViewUI instanceof XWalkView) || bVar == null) {
                ab.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
            } else {
                XWalkView xWalkView = (XWalkView) webViewUI;
                a yq = bVar.yq();
                e eVar = new e(xWalkView);
                eVar.bSf = yq;
                yq.a(eVar);
                xWalkView.setExtendPluginClient(eVar);
                ab.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
                Object obj = yq;
                this.iun = (f) obj;
                if (this.iun != null) {
                    f fVar = this.iun;
                    if (com.tencent.mm.plugin.appbrand.e.c.hpL == null) {
                        com.tencent.mm.plugin.appbrand.e.c.hpL = new com.tencent.mm.plugin.appbrand.e.c();
                    }
                    fVar.a(com.tencent.mm.plugin.appbrand.e.c.hpL);
                }
                setBackgroundColor(-1);
                setLayoutParams(new LayoutParams(-1, -1));
                setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        return false;
                    }
                });
                setDownloadListener(new DownloadListener() {
                    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                        AppMethodBeat.i(132440);
                        ab.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", str, str4, str2);
                        AppMethodBeat.o(132440);
                    }
                });
                AppMethodBeat.o(132472);
            }
        } else {
            ab.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
        }
        ad obj2 = null;
        this.iun = (f) obj2;
        if (this.iun != null) {
        }
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(/* anonymous class already generated */);
        setDownloadListener(/* anonymous class already generated */);
        AppMethodBeat.o(132472);
    }

    public final f getWebViewPluginClientProxy() {
        return this.iun;
    }

    public final void cE(Context context) {
        AppMethodBeat.i(132473);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
            AppMethodBeat.o(132473);
            return;
        }
        AppMethodBeat.o(132473);
    }

    public final View getWrapperView() {
        return this;
    }

    public final View getContentView() {
        AppMethodBeat.i(132474);
        View view = super.getView();
        AppMethodBeat.o(132474);
        return view;
    }

    public final boolean g(Canvas canvas) {
        AppMethodBeat.i(132475);
        if (isXWalkKernel()) {
            drawCanvas(canvas);
        } else {
            draw(canvas);
        }
        AppMethodBeat.o(132475);
        return true;
    }

    public final void H(Runnable runnable) {
        AppMethodBeat.i(132476);
        if (isXWalkKernel()) {
            postDelayed(runnable, 200);
            AppMethodBeat.o(132476);
            return;
        }
        postOnAnimation(runnable);
        AppMethodBeat.o(132476);
    }

    public final void bU(String str, String str2) {
        AppMethodBeat.i(132477);
        this.iul = false;
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        AppMethodBeat.o(132477);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(132478);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132478);
            return;
        }
        evaluateJavascript("document.title=\"" + str + "\"", null);
        AppMethodBeat.o(132478);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(132479);
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(132441);
                aa.a(aa.this, str, valueCallback);
                AppMethodBeat.o(132441);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass3.run();
            AppMethodBeat.o(132479);
            return;
        }
        al.d(anonymousClass3);
        AppMethodBeat.o(132479);
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(132480);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(132480);
    }

    public final void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(132481);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(132481);
    }

    public final void setJsExceptionHandler(h hVar) {
    }

    public final <T extends com.tencent.mm.plugin.appbrand.h.j> T af(Class<T> cls) {
        return null;
    }

    public final String getUserAgentString() {
        return this.ium;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(132482);
        try {
            super.onAttachedToWindow();
            AppMethodBeat.o(132482);
        } catch (SecurityException e) {
            AppMethodBeat.o(132482);
        }
    }

    public final void destroy() {
        AppMethodBeat.i(132483);
        super.destroy();
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        if (this.isR != null) {
            this.isR.iqR.clear();
        }
        this.isR = null;
        cE(getContext().getApplicationContext());
        AppMethodBeat.o(132483);
    }

    public final void wU() {
        AppMethodBeat.i(132484);
        onResume();
        AppMethodBeat.o(132484);
    }

    public final void wW() {
        AppMethodBeat.i(132485);
        onPause();
        AppMethodBeat.o(132485);
    }

    public final void setOnScrollChangedListener(af afVar) {
        this.iug = afVar;
    }

    public final void setWebViewLayoutListener(ad adVar) {
        this.iuh = adVar;
    }

    public final void setOnTrimListener(ae aeVar) {
        this.iui = aeVar;
    }

    public final void aAM() {
        AppMethodBeat.i(132486);
        getView().scrollTo(getWebScrollX(), 0);
        AppMethodBeat.o(132486);
    }

    public final void z(int i, long j) {
        AppMethodBeat.i(132487);
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getWebScrollY(), i});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(132442);
                aa.this.getView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AppMethodBeat.o(132442);
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.start();
        this.iuk = ofInt;
        AppMethodBeat.o(132487);
    }

    public final void setFullscreenImpl(c cVar) {
        this.isR = cVar;
    }

    public final boolean aAN() {
        return this.iul;
    }

    public final boolean aAO() {
        AppMethodBeat.i(132488);
        if (isXWalkKernel() && XWalkEnvironment.getAvailableVersion() >= com.tencent.mm.plugin.appbrand.jsapi.p.e.CTRL_INDEX) {
            boolean isOverScrollStart = isOverScrollStart();
            AppMethodBeat.o(132488);
            return isOverScrollStart;
        } else if (getWebScrollY() == 0) {
            AppMethodBeat.o(132488);
            return true;
        } else {
            AppMethodBeat.o(132488);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(132489);
        super.onLayout(z, i, i2, i3, i4);
        if (this.iuh != null) {
            this.iuh.c(z, i, i2, i3, i4);
        }
        AppMethodBeat.o(132489);
    }

    public final boolean aAP() {
        return true;
    }
}
