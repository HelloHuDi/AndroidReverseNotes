package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.actionbar.g;
import com.tencent.mm.plugin.appbrand.widget.i.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.xweb.c.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class w extends com.tencent.luggage.sdk.a.a.a {
    private o gOq;
    protected g itm;
    private AppBrandRecentView itn;
    public final c ito = new c(hashCode());
    private long itp = System.currentTimeMillis();
    private long itq;
    private long itr;
    private boolean its = false;
    private cc itt = null;
    private boolean itu = false;
    private boolean itv = false;
    private boolean itw = false;

    static final class b extends t {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAppRouteResized";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class a extends com.tencent.mm.plugin.appbrand.jsapi.b {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public /* synthetic */ com.tencent.luggage.sdk.b.b xL() {
        AppMethodBeat.i(132436);
        o runtime = getRuntime();
        AppMethodBeat.o(132436);
        return runtime;
    }

    public w() {
        boolean z = false;
        AppMethodBeat.i(132398);
        if (bp.dpL() || f.IS_FLAVOR_RED) {
            z = true;
        }
        this.gNV = z;
        AppMethodBeat.o(132398);
    }

    public final void a(Context context, i iVar) {
        AppMethodBeat.i(132399);
        this.gOq = (o) iVar;
        super.a(context, iVar);
        c cVar = this.ito;
        cVar.mAppId = iVar.mAppId;
        cVar.iAS.start();
        aIb();
        getActionBar().setCloseButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(132375);
                com.tencent.mm.plugin.appbrand.report.c.a(w.this.getAppId(), w.this.getURL(), 22, "", bo.anT(), 1, 0);
                AppMethodBeat.o(132375);
            }
        });
        this.hvM = new com.tencent.mm.plugin.appbrand.permission.a((o) iVar, this);
        AppMethodBeat.o(132399);
    }

    public final void xO() {
        AppMethodBeat.i(132400);
        ab.i("MicroMsg.AppBrandPageViewWC", "[wxa_reload] onWebViewTrimmed %s", getURL());
        super.xO();
        this.itu = false;
        this.its = false;
        AppMethodBeat.o(132400);
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        AppMethodBeat.i(132401);
        super.initView();
        if (aJz() instanceof MMWebView) {
            ((MMWebView) aJz()).getIsX5Kernel();
        }
        aJy().a(new ai() {
            /* Access modifiers changed, original: final */
            public final void aJY() {
                AppMethodBeat.i(132385);
                com.tencent.mm.plugin.webview.ui.tools.widget.o.JV(1);
                AppMethodBeat.o(132385);
            }

            /* Access modifiers changed, original: final */
            public final void aDI() {
                AppMethodBeat.i(132386);
                com.tencent.mm.plugin.webview.ui.tools.widget.o.JV(2);
                AppMethodBeat.o(132386);
            }
        });
        AppMethodBeat.o(132401);
    }

    public aj cF(Context context) {
        AppMethodBeat.i(132402);
        if (context == null) {
            context = ah.getContext();
        }
        aa aaVar = new aa(context, this.isX);
        AppMethodBeat.o(132402);
        return aaVar;
    }

    public Map<String, m> aub() {
        AppMethodBeat.i(132403);
        Map aCi = q.aCi();
        AppMethodBeat.o(132403);
        return aCi;
    }

    public o getRuntime() {
        AppMethodBeat.i(132404);
        o oVar = (o) super.xL();
        AppMethodBeat.o(132404);
        return oVar;
    }

    public final s atK() {
        AppMethodBeat.i(132405);
        s sVar = (s) super.xM();
        AppMethodBeat.o(132405);
        return sVar;
    }

    public void xN() {
        AppMethodBeat.i(132406);
        super.xN();
        if (this.itn != null) {
            this.itn.release();
        }
        if (this.itm != null) {
            g gVar = this.itm;
            gVar.dismiss();
            if (gVar.iVi != null) {
                gVar.iVi.removeAllViews();
                gVar.iVi = null;
            }
        }
        AppMethodBeat.o(132406);
    }

    /* Access modifiers changed, original: protected */
    public void aIb() {
        AppMethodBeat.i(132407);
        com.tencent.mm.kernel.g.K(d.class);
        if (getRuntime().atD()) {
            AppMethodBeat.o(132407);
            return;
        }
        this.itn = ((d) com.tencent.mm.kernel.g.K(d.class)).a(this.mContext, com.tencent.mm.plugin.appbrand.widget.recentview.d.b.TYPE_MENU, new com.tencent.mm.plugin.appbrand.widget.recentview.d.a() {
            public final LocalUsageInfo aJZ() {
                AppMethodBeat.i(132387);
                if (w.this.isRunning()) {
                    LocalUsageInfo localUsageInfo = new LocalUsageInfo(w.this.getRuntime().atI().username, w.this.getRuntime().atH().appId, w.this.getRuntime().atH().hhd.gVt, w.this.getRuntime().atH().hhd.gVu, w.this.getRuntime().atH().cwz, w.this.getRuntime().atH().bQo, w.this.getRuntime().atH().hgW, false, w.this.getRuntime().atH().xE(), 0);
                    AppMethodBeat.o(132387);
                    return localUsageInfo;
                }
                AppMethodBeat.o(132387);
                return null;
            }
        });
        this.itm = new g(this.mContext);
        this.itm.setWidth(-1);
        this.itm.setBackgroundDrawable(new ColorDrawable());
        if (this.itn != null) {
            this.itn.refresh();
            this.itm.setHeight(this.itn.getLayoutParams().height);
            this.itn.setBackground(com.tencent.mm.bz.a.g(this.mContext, R.drawable.bu));
            this.itm.setContentView(this.itn);
            this.itn.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b() {
                public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                    AppMethodBeat.i(132389);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(132388);
                            w.this.itm.dismiss();
                            AppMethodBeat.o(132388);
                        }
                    }, 100);
                    if (aVar.type == 1) {
                        LocalUsageInfo localUsageInfo = aVar.iXW;
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
                        appBrandStatObject.cst = w.this.getAppId();
                        com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT.a(w.this.mContext, localUsageInfo.username, null, null, localUsageInfo.har, -1, appBrandStatObject, null, null);
                        AppMethodBeat.o(132389);
                        return true;
                    }
                    AppMethodBeat.o(132389);
                    return false;
                }

                public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                    return false;
                }
            });
        } else {
            ab.w("MicroMsg.AppBrandPageViewWC", "AppBrandRecentView is null, appId: %s", getAppId());
        }
        getActionBar().setCapsuleHomeButtonLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(132390);
                if (w.this.getRuntime().ya().bQn.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG) {
                    AppMethodBeat.o(132390);
                } else if (w.this.itn == null || w.this.itn.getCount() == 0) {
                    AppMethodBeat.o(132390);
                } else {
                    w.this.itn.refresh();
                    w.this.itm.showAsDropDown(view);
                    com.tencent.mm.plugin.appbrand.report.c.a(w.this.getAppId(), w.this.getURL(), 21, "", bo.anT(), 1, 0);
                    AppMethodBeat.o(132390);
                }
                return true;
            }
        });
        AppMethodBeat.o(132407);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJC() {
        boolean z = false;
        AppMethodBeat.i(132408);
        super.aJC();
        com.tencent.mm.plugin.appbrand.config.a.d pageConfig = getPageConfig();
        boolean a = getRuntime().xY().a((com.tencent.mm.plugin.appbrand.jsapi.c) this, new a());
        if (!(pageConfig.hfy && a)) {
            z = true;
        }
        super.ew(z);
        if (a && pageConfig.hfy && getRuntime().atI().bQe == 7 && !getActionBar().isFullscreenMode()) {
            com.tencent.mm.plugin.appbrand.widget.i.b bVar = new com.tencent.mm.plugin.appbrand.widget.i.b(pageConfig.hfx, new com.tencent.mm.plugin.appbrand.widget.i.c() {
                public final void a(String str, com.tencent.mm.plugin.appbrand.widget.i.d dVar) {
                    AppMethodBeat.i(132391);
                    super.a(str, dVar);
                    ab.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(132391);
                }
            });
            bVar.a((e) new e() {
                public final void a(Bitmap bitmap, com.tencent.mm.plugin.appbrand.widget.i.d dVar) {
                    AppMethodBeat.i(132393);
                    super.a(bitmap, dVar);
                    al.d(new com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass4(bitmap, new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(132392);
                            ab.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
                            com.tencent.mm.plugin.appbrand.page.b.d.c(w.this);
                            AppMethodBeat.o(132392);
                        }
                    }));
                    AppMethodBeat.o(132393);
                }
            });
            bVar.aSg();
        } else {
            ab.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + a + " navigationBarRightButtonHide:" + pageConfig.hfy + " appServiceType:" + getRuntime().atI().bQe + " isFullscreenMode:" + getActionBar().isFullscreenMode());
        }
        if (com.tencent.mm.plugin.appbrand.weishi.e.E(getRuntime())) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132396);
                    if (w.this.isG != null) {
                        ab.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
                        w.this.isG.setNavResetStyleListener(new com.tencent.mm.plugin.appbrand.widget.actionbar.b.a() {
                            public final void a(ImageView imageView, View view) {
                                AppMethodBeat.i(132394);
                                if (imageView != null) {
                                    imageView.clearColorFilter();
                                    imageView.setImageDrawable(com.tencent.mm.svg.a.a.f(w.this.mContext.getResources(), R.raw.app_brand_weishi_video_btn_close));
                                }
                                if (view != null) {
                                    view.setBackground(null);
                                }
                                AppMethodBeat.o(132394);
                            }
                        });
                        w.this.isG.setFullscreenMode(true);
                        w.this.isG.setForegroundStyle(false);
                        w.this.isG.eP(false);
                        w.this.isG.aON();
                        w.this.isG.setBackButtonClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(132395);
                                ab.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
                                com.tencent.mm.plugin.appbrand.weishi.e.aOz();
                                if (w.this.gOq != null) {
                                    com.tencent.mm.plugin.appbrand.g.a(w.this.getAppId(), com.tencent.mm.plugin.appbrand.g.d.CLOSE);
                                    w.this.gOq.close();
                                }
                                AppMethodBeat.o(132395);
                            }
                        });
                    }
                    if (w.this.isF != null) {
                        w.this.isF.setForceTopInsetsHeight(w.this.mContext.getResources().getDimensionPixelSize(R.dimen.u3));
                    }
                    AppMethodBeat.o(132396);
                }
            });
        }
        AppMethodBeat.o(132408);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.page.b.c aBq() {
        AppMethodBeat.i(132409);
        if (com.tencent.mm.plugin.appbrand.weishi.e.E(getRuntime())) {
            com.tencent.mm.plugin.appbrand.weishi.c cVar = new com.tencent.mm.plugin.appbrand.weishi.c(this);
            AppMethodBeat.o(132409);
            return cVar;
        }
        com.tencent.mm.plugin.appbrand.page.b.c aBq = super.aBq();
        AppMethodBeat.o(132409);
        return aBq;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.t.a aJS() {
        AppMethodBeat.i(132410);
        View findViewById = getContentView().findViewById(R.id.a2);
        if (findViewById instanceof com.tencent.mm.plugin.appbrand.jsapi.t.a) {
            com.tencent.mm.plugin.appbrand.jsapi.t.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.t.a) findViewById;
            AppMethodBeat.o(132410);
            return aVar;
        }
        AppMethodBeat.o(132410);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<n> aJx() {
        boolean z = true;
        AppMethodBeat.i(132411);
        String appId = getAppId();
        LinkedList linkedList = new LinkedList();
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
            WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.ShareAppMsg.ordinal(), false);
            AppMethodBeat.o(132411);
            return linkedList;
        }
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.CopyPath.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.BackToHome.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.ShareAppMsg.ordinal(), true);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.StickInWeChat.ordinal(), false);
        AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(appId);
        if (com.tencent.mm.sdk.a.b.dnO() || !(wJ == null || wJ.hhd.gVt == 1)) {
            z = false;
        }
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.SendToDesktop.ordinal(), z);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.ModfiyCollection.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.AboutUs.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.EnableDebug.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.EnablePerformancePanel.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.DumpPerformanceTrace.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.ShowPkgInfo.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.OpenGamePreload.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.DebugRestart.ordinal(), false);
        WxaMenuHelper.c(linkedList, com.tencent.mm.plugin.appbrand.menu.o.Exit.ordinal(), false);
        AppMethodBeat.o(132411);
        return linkedList;
    }

    public boolean AA(String str) {
        AppMethodBeat.i(132412);
        this.itw = false;
        this.ito.DB(str);
        this.itq = System.currentTimeMillis();
        boolean AA = super.AA(str);
        AppMethodBeat.o(132412);
        return AA;
    }

    /* Access modifiers changed, original: protected */
    public void aBa() {
        AppMethodBeat.i(132413);
        super.aBa();
        this.gOq.gPr.y(4, System.currentTimeMillis() - this.itr);
        AppBrandPerformanceManager.a(getRuntime(), 203, System.currentTimeMillis() - this.itq);
        com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.itq, System.currentTimeMillis(), "");
        this.ito.aLj();
        AppMethodBeat.o(132413);
    }

    /* Access modifiers changed, original: protected */
    public void aBb() {
        AppMethodBeat.i(132414);
        super.aBb();
        this.ito.wU();
        AppMethodBeat.o(132414);
    }

    /* Access modifiers changed, original: protected */
    public void aBc() {
        AppMethodBeat.i(132415);
        super.aBc();
        if (this.itm != null) {
            this.itm.dismiss();
        }
        this.ito.wW();
        AppMethodBeat.o(132415);
    }

    public final void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.i(132416);
        super.onConfigurationChanged(configuration);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132397);
                w.this.isT.onOrientationChanged(configuration.orientation);
                AppMethodBeat.o(132397);
            }
        });
        AppMethodBeat.o(132416);
    }

    /* Access modifiers changed, original: protected */
    public void aBd() {
        AppMethodBeat.i(132417);
        super.aBd();
        c cVar = this.ito;
        cVar.iAS.aLh();
        l lVar = cVar.iAS;
        lVar.quit();
        lVar.mStopped = true;
        if (this.isJ instanceof h) {
            h hVar = (h) this.isJ;
            if (hVar.hasEnteredFullscreen()) {
                ab.i("MicroMsg.AppBrandPageViewWC", "performPageDestroy, leave fullscreen");
                hVar.leaveFullscreen();
            }
        }
        AppMethodBeat.o(132417);
    }

    /* Access modifiers changed, original: protected|final */
    public final void De(String str) {
        AppMethodBeat.i(132418);
        this.itr = System.currentTimeMillis();
        aJV();
        if (this.gOq.gNO.aIy()) {
            String CC = this.gOq.gNO.CC(com.tencent.luggage.g.h.bO(str));
            aBx().evaluateJavascript(aw.a(this.gOq, CC + (CC.endsWith("/") ? "" : "/") + "page-frame.js"), null);
        }
        AppMethodBeat.o(132418);
    }

    public final void bN(String str) {
        AppMethodBeat.i(132419);
        super.bN(str);
        com.tencent.mm.plugin.appbrand.report.c.br(getAppId(), 27);
        AppMethodBeat.o(132419);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJH() {
        AppMethodBeat.i(132420);
        if (getRuntime().ya().bQn.scene == FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
            aJJ();
        } else if (getRuntime().atD() || getRuntime().atJ().getPageCount() != 1) {
            aJI();
        } else {
            aJJ();
        }
        if (com.tencent.mm.plugin.appbrand.weishi.e.E(this.gOq)) {
            getActionBar().aON();
        }
        AppMethodBeat.o(132420);
    }

    public View aBl() {
        AppMethodBeat.i(132421);
        if (aJQ()) {
            View appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
            appBrandActionHeaderLayout.setAppId(getAppId());
            appBrandActionHeaderLayout.setActionHeaderStyle(this.isO);
            ab.w("MicroMsg.AppBrandPageViewWC", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), this.isP);
            if (!TextUtils.isEmpty(this.isP)) {
                appBrandActionHeaderLayout.setStatusDescription(this.isP);
            }
            appBrandActionHeaderLayout.cI(getRuntime().atI().iconUrl, getRuntime().atI().cwz);
            AppMethodBeat.o(132421);
            return appBrandActionHeaderLayout;
        }
        View aBl = super.aBl();
        AppMethodBeat.o(132421);
        return aBl;
    }

    /* Access modifiers changed, original: protected */
    public void aL(List<n> list) {
        AppMethodBeat.i(132423);
        new p(this, list).aJm();
        AppMethodBeat.o(132423);
    }

    public final void aJT() {
        AppMethodBeat.i(132424);
        new p(this, this.irD).aJm();
        AppMethodBeat.o(132424);
    }

    public final String aJA() {
        AppMethodBeat.i(132425);
        String str = "https://servicewechat.com/";
        if (this.gOq == null) {
            str = str + "preload/";
        } else {
            str = str + String.format(Locale.US, "%s/%d/", new Object[]{getAppId(), Integer.valueOf(this.gOq.atH().hhd.gVu)});
        }
        AppMethodBeat.o(132425);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void atV() {
        AppMethodBeat.i(132426);
        aJU();
        this.itu = true;
        AppMethodBeat.o(132426);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
        AppMethodBeat.i(132427);
        if (aJz() instanceof MMWebView) {
            MMWebView mMWebView = (MMWebView) aJz();
            com.tencent.mm.plugin.appbrand.n.xb(getAppId()).gPe.set(mMWebView.getIsX5Kernel());
            com.tencent.mm.plugin.appbrand.report.c.eA(mMWebView.getIsX5Kernel());
        }
        aBx().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[]{aJB()}), null);
        if (this.itu) {
            this.itu = false;
        } else {
            aJU();
        }
        String str = "";
        if (this.gOq.atH().bQp && !this.gOq.yd()) {
            str = WxaCommLibRuntimeReader.xu("WAVConsole.js");
        }
        if (bo.isNullOrNil(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "";
            if (AppBrandPerformanceManager.b(getRuntime())) {
                str2 = WxaCommLibRuntimeReader.xu("WAPerf.js");
            }
            stringBuilder = stringBuilder.append(str2);
            str2 = "";
            if (this.gOq.yd()) {
                str2 = ";" + WxaCommLibRuntimeReader.xu("WARemoteDebug.js");
            }
            aBx().evaluateJavascript(stringBuilder.append(str2).toString(), null);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            final boolean atU = atU();
            aBx().evaluateJavascript(str, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(132378);
                    if (w.this.atU() || w.this.isRunning()) {
                        com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                        com.tencent.mm.plugin.appbrand.report.quality.b.a(atU, w.this.getAppId(), currentTimeMillis, "WAVConsole.js", (long) str.length());
                    }
                    AppMethodBeat.o(132378);
                }
            });
        }
        aJV();
        if (!this.itv) {
            this.itv = true;
            this.gOq.gPr.y(3, System.currentTimeMillis() - this.itp);
            com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "WebViewInit+PageFrameLoad", this.itp, System.currentTimeMillis(), "");
        }
        AppMethodBeat.o(132427);
    }

    private void aJU() {
        AppMethodBeat.i(132428);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 1, 1, false);
        com.tencent.mm.plugin.appbrand.s.n.a(aBx(), com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/android.js"), null);
        String xu = WxaCommLibRuntimeReader.xu("WAWebview.js");
        final long currentTimeMillis = System.currentTimeMillis();
        final int length = xu == null ? 0 : xu.length();
        final boolean atU = atU();
        com.tencent.mm.plugin.appbrand.s.n.a(aBx(), xu, new com.tencent.mm.plugin.appbrand.s.n.a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(132376);
                if (w.this.atU() || w.this.isRunning()) {
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    com.tencent.mm.plugin.appbrand.report.quality.b.a(atU, w.this.getAppId(), currentTimeMillis, "WAWebview.js", (long) length);
                }
                com.tencent.mm.plugin.report.service.h.pYm.a(370, 3, 1, false);
                AppMethodBeat.o(132376);
            }

            public final void lo(String str) {
                int i = 0;
                AppMethodBeat.i(132377);
                ab.e("MicroMsg.AppBrandPageViewWC", "Inject SDK Page Script Failed: %s", str);
                com.tencent.mm.plugin.report.service.h.pYm.a(370, 2, 1, false);
                com.tencent.mm.plugin.appbrand.report.c.br(w.this.getAppId(), 24);
                int i2 = -1;
                if (w.this.gOq != null) {
                    i = w.this.gOq.atH().hhd.gVu;
                    i2 = w.this.gOq.atH().hhd.gVt;
                }
                com.tencent.mm.plugin.appbrand.report.c.a(w.this.getAppId(), i, i2, 370, 2);
                AppMethodBeat.o(132377);
            }
        });
        AppMethodBeat.o(132428);
    }

    private void aJV() {
        AppMethodBeat.i(132430);
        if (this.its) {
            AppMethodBeat.o(132430);
            return;
        }
        if (this.gOq.gNO.aIy()) {
            String a = aw.a(this.gOq, "app-wxss.js");
            if (TextUtils.isEmpty(a)) {
                AppMethodBeat.o(132430);
                return;
            }
            aBx().evaluateJavascript(a, null);
        } else {
            aBx().evaluateJavascript(v.Di(aw.a(this.gOq, "page-frame.html")), null);
        }
        this.its = true;
        AppMethodBeat.o(132430);
    }

    public final void ew(boolean z) {
        AppMethodBeat.i(132431);
        com.tencent.mm.plugin.appbrand.permission.e xY = getRuntime().xY();
        if (xY.b((s) super.xM(), p.class) || xY.b(this, p.class)) {
            super.ew(z);
            AppMethodBeat.o(132431);
            return;
        }
        super.ew(true);
        AppMethodBeat.o(132431);
    }

    public final void h(JSONObject jSONObject) {
        AppMethodBeat.i(132432);
        super.h(jSONObject);
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        com.tencent.mm.plugin.appbrand.e.d.a(com.tencent.mm.plugin.appbrand.u.a.aSj(), jSONObject);
        com.tencent.mm.plugin.appbrand.e.d.b(com.tencent.mm.plugin.appbrand.u.a.aSk(), jSONObject);
        AppMethodBeat.o(132432);
    }

    /* Access modifiers changed, original: protected */
    public am cG(final Context context) {
        AppMethodBeat.i(132433);
        AnonymousClass4 anonymousClass4 = new am() {
            private boolean foreground = false;
            private int itA;
            private int itB;
            private final com.tencent.mm.plugin.appbrand.config.a.a.b[] itC = new com.tencent.mm.plugin.appbrand.config.a.a.b[]{com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT, com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT, com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED, com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR};
            private final t itD = new t();
            private boolean itz = false;

            private boolean di(int i, int i2) {
                AppMethodBeat.i(132380);
                com.tencent.mm.plugin.appbrand.config.a.a.b yV = com.tencent.mm.plugin.appbrand.config.a.a.yV(w.this.isQ);
                if (yV == null) {
                    yV = com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT;
                }
                if (org.apache.commons.b.a.contains(this.itC, yV)) {
                    if (i > i2) {
                        AppMethodBeat.o(132380);
                        return true;
                    }
                    AppMethodBeat.o(132380);
                    return false;
                } else if (com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT != yV) {
                    AppMethodBeat.o(132380);
                    return true;
                } else if (i2 > i) {
                    AppMethodBeat.o(132380);
                    return true;
                } else {
                    AppMethodBeat.o(132380);
                    return false;
                }
            }

            public final void aJW() {
                AppMethodBeat.i(132381);
                int width = w.this.aBk().getWidth();
                int height = w.this.aBk().getHeight();
                if (width <= 0 || height <= 0) {
                    ab.e("MicroMsg.AppBrandPageViewWC", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", Integer.valueOf(width), Integer.valueOf(height), w.this.getAppId(), w.this.getURL());
                    AppMethodBeat.o(132381);
                    return;
                }
                boolean z;
                boolean z2;
                int i;
                boolean z3 = (width == this.itA && height == this.itB) ? false : true;
                this.itA = width;
                this.itB = height;
                int[] d = com.tencent.mm.plugin.appbrand.s.w.d(w.this);
                if (di(width, height) && di(d[0], d[1])) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.itA == 0 || this.itB == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                ab.i("MicroMsg.AppBrandPageViewWC", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", w.this.getAppId(), w.this.getURL(), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(this.foreground), Boolean.valueOf(this.itz));
                if ((z2 && z3 && z) || (w.this.itw && z)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    this.itz = false;
                    AppMethodBeat.o(132381);
                } else if (this.foreground) {
                    aJX();
                    AppMethodBeat.o(132381);
                } else {
                    this.itz = true;
                    AppMethodBeat.o(132381);
                }
            }

            public final void aAS() {
                AppMethodBeat.i(132382);
                if (this.itz) {
                    ab.i("MicroMsg.AppBrandPageViewWC", "onForeground dispatch ViewDidResize appId[%s] url[%s]", w.this.getAppId(), w.this.getURL());
                    aJX();
                    this.itz = false;
                }
                w.this.isT.onOrientationChanged(context.getResources().getConfiguration().orientation);
                this.foreground = true;
                AppMethodBeat.o(132382);
            }

            private void aJX() {
                AppMethodBeat.i(132383);
                if (!w.this.isRunning()) {
                    AppMethodBeat.o(132383);
                } else if (w.this.itw) {
                    a(new b());
                    ab.i("MicroMsg.AppBrandPageViewWC", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", w.this.getAppId(), w.this.getURL(), w.this.isQ);
                    w.this.itw = false;
                    AppMethodBeat.o(132383);
                } else {
                    a(this.itD);
                    AppMethodBeat.o(132383);
                }
            }

            private <EVENT extends t> void a(EVENT event) {
                AppMethodBeat.i(132384);
                com.tencent.mm.plugin.appbrand.config.a.d pageConfig = w.this.getPageConfig();
                if (pageConfig == null) {
                    AppMethodBeat.o(132384);
                    return;
                }
                int[] d = com.tencent.mm.plugin.appbrand.s.w.d(w.this.atK());
                Map h = w.h(w.this);
                h.put("originalPageOrientation", pageConfig.hfD);
                h.put("lastPageOrientation", w.this.isQ);
                event.a(w.this, w.this.hashCode(), w.this.aBk().getWidth(), w.this.aBk().getHeight(), d[0], d[1], context.getResources().getConfiguration().orientation, h);
                AppMethodBeat.o(132384);
            }

            public final void aAT() {
                this.foreground = false;
            }
        };
        AppMethodBeat.o(132433);
        return anonymousClass4;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJK() {
        AppMethodBeat.i(132434);
        boolean aJK = super.aJK();
        this.itw = aJK;
        AppMethodBeat.o(132434);
        return aJK;
    }

    public boolean isFullScreen() {
        AppMethodBeat.i(132422);
        if (this.isT.aBt() == com.tencent.mm.plugin.appbrand.page.b.c.b.HIDDEN) {
            AppMethodBeat.o(132422);
            return true;
        }
        AppMethodBeat.o(132422);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aJP() {
        AppMethodBeat.i(132429);
        String xu = WxaCommLibRuntimeReader.xu("WAPageFrame.html");
        AppMethodBeat.o(132429);
        return xu;
    }

    public final /* bridge */ /* synthetic */ com.tencent.luggage.sdk.a.a.b xM() {
        AppMethodBeat.i(132435);
        s sVar = (s) super.xM();
        AppMethodBeat.o(132435);
        return sVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.appbrand.q xT() {
        AppMethodBeat.i(132438);
        s sVar = (s) super.xM();
        AppMethodBeat.o(132438);
        return sVar;
    }
}
