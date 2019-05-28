package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j.a.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.plugin.appbrand.report.model.g;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.c;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.soter.core.biometric.FaceManager;

@SuppressLint({"ViewConstructor"})
public class r extends q {
    private volatile g isi = aHU();
    private f isj;
    public boolean isk = false;
    public boolean isl = false;
    private long ism;
    private long isn;
    private long iso;
    private String isp;
    private long isq = 0;
    private boolean isr = false;

    public r(Context context, o oVar) {
        super(context, oVar);
        AppMethodBeat.i(132351);
        AppMethodBeat.o(132351);
    }

    /* Access modifiers changed, original: protected */
    public g aHU() {
        AppMethodBeat.i(132352);
        b bVar = new b(getRuntime());
        AppMethodBeat.o(132352);
        return bVar;
    }

    public o getRuntime() {
        AppMethodBeat.i(132353);
        o oVar = (o) super.getRuntime();
        AppMethodBeat.o(132353);
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085 A:{Catch:{ Throwable -> 0x00c5 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Az(String str) {
        QualitySessionRuntime qualitySessionRuntime = null;
        AppMethodBeat.i(132354);
        super.Az(str);
        if (getRuntime().atH().bQp) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132339);
                    r.this.aJq();
                    AppMethodBeat.o(132339);
                }
            }, 10000);
        }
        try {
            a.aLz();
            j.p(this, "pagecontainer");
            bs bsVar = new bs();
            QualitySessionRuntime DG = a.DG(getAppId());
            if (DG != null) {
                aj aJz;
                aa aaVar;
                int i;
                bsVar.gr(DG.igT);
                bsVar.gs(DG.appId);
                bsVar.ddd = (long) DG.iDa;
                bsVar.ddN = bs.a.gT(DG.iCZ);
                bsVar.ddz = (long) DG.apptype;
                bsVar.cVR = (long) DG.scene;
                bsVar.dC(DG.iDk);
                bsVar.dD(bo.anU());
                bsVar.dB(bsVar.ddC - bsVar.ddB);
                n currentPage = getCurrentPage();
                if (currentPage != null) {
                    u currentPageView = currentPage.getCurrentPageView();
                    if (currentPageView != null) {
                        aJz = currentPageView.aJz();
                        if (aJz instanceof aa) {
                            Object obj = aJz;
                        }
                        aaVar = (aa) qualitySessionRuntime;
                        if (aaVar != null) {
                            if (aaVar.isSysKernel()) {
                                i = 4;
                            } else if (aaVar.getIsX5Kernel()) {
                                i = 2;
                            } else if (aaVar.isXWalkKernel()) {
                                i = 3;
                            }
                            bsVar.dbX = (long) i;
                            bsVar.ajK();
                            qualitySessionRuntime = DG;
                        }
                        i = -1;
                        bsVar.dbX = (long) i;
                        bsVar.ajK();
                        qualitySessionRuntime = DG;
                    }
                }
                aJz = null;
                if (aJz instanceof aa) {
                }
                aaVar = (aa) qualitySessionRuntime;
                if (aaVar != null) {
                }
                i = -1;
                bsVar.dbX = (long) i;
                bsVar.ajK();
                qualitySessionRuntime = DG;
            }
            c.a(qualitySessionRuntime, "Null session with " + getAppId());
        } catch (Throwable th) {
            ab.w("MicroMsg.AppBrandPageContainer", "pagecontainerInitReport %s", th);
        }
        aJs();
        AppMethodBeat.o(132354);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(132355);
        if (this.isj != null) {
            this.isj.dismiss();
            this.isj = null;
            AppMethodBeat.o(132355);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(132355);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(String str, aq aqVar, final q.a aVar) {
        AppMethodBeat.i(132356);
        com.tencent.mm.plugin.appbrand.j.a aVar2 = getRuntime().gNO;
        if (aVar2.aIy()) {
            a(str, aqVar, aVar, false);
        } else {
            aVar2.a(str, false, new com.tencent.mm.plugin.appbrand.j.a.b() {
                public final void a(d dVar) {
                    AppMethodBeat.i(132341);
                    r.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(132340);
                            aVar.proceed();
                            AppMethodBeat.o(132340);
                        }
                    });
                    AppMethodBeat.o(132341);
                }
            });
        }
        AppMethodBeat.o(132356);
        return true;
    }

    private void a(String str, aq aqVar, q.a aVar, boolean z) {
        long j;
        AppMethodBeat.i(132357);
        h hVar = h.pYm;
        if (z) {
            j = 5;
        } else {
            j = 1;
        }
        hVar.k(937, j, 1);
        final boolean z2 = z;
        final q.a aVar2 = aVar;
        final String str2 = str;
        final aq aqVar2 = aqVar;
        getRuntime().gNO.a(str, true, new com.tencent.mm.plugin.appbrand.j.a.b() {
            public final void a(d dVar) {
                AppMethodBeat.i(132347);
                h hVar;
                long j;
                switch (dVar) {
                    case OK:
                        hVar = h.pYm;
                        if (z2) {
                            j = 6;
                        } else {
                            j = 2;
                        }
                        hVar.k(937, j, 1);
                        r.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(132342);
                                if (z2) {
                                    aVar2.aJr();
                                }
                                aVar2.proceed();
                                AppMethodBeat.o(132342);
                            }
                        });
                        AppMethodBeat.o(132347);
                        return;
                    case CANCEL:
                        hVar = h.pYm;
                        if (z2) {
                            j = 8;
                        } else {
                            j = 4;
                        }
                        hVar.k(937, j, 1);
                        r.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(132343);
                                if (z2 && r.this.isj != null) {
                                    r.this.isj.cancel();
                                    r.this.isj = null;
                                }
                                aVar2.cancel();
                                AppMethodBeat.o(132343);
                            }
                        });
                        AppMethodBeat.o(132347);
                        return;
                    case FAIL:
                        hVar = h.pYm;
                        if (z2) {
                            j = 7;
                        } else {
                            j = 3;
                        }
                        hVar.k(937, j, 1);
                        r.this.runOnUiThread(new Runnable() {
                            /* JADX WARNING: Missing block: B:8:0x007d, code skipped:
            if (r0 == null) goto L_0x007f;
     */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                AppBrandInitConfig yf;
                                AppMethodBeat.i(132346);
                                final f a = r.this.isj;
                                r.this.isj = new f(r.this.getContext());
                                AnonymousClass1 anonymousClass1 = new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(132344);
                                        switch (i) {
                                            case -1:
                                                r.a(r.this, str2, aqVar2, aVar2);
                                                break;
                                        }
                                        AppMethodBeat.o(132344);
                                    }
                                };
                                r.this.isj.setPositiveButton(anonymousClass1);
                                r.this.isj.setNegativeButton(anonymousClass1);
                                f a2 = r.this.isj;
                                r rVar = r.this;
                                AnonymousClass2 anonymousClass2 = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(132345);
                                        if (a != null) {
                                            a.aJc();
                                        }
                                        AppMethodBeat.o(132345);
                                    }
                                };
                                j.p(rVar, "pageContainer");
                                a2.ira = rVar;
                                rVar.addView(a2, new LayoutParams(-1, -1));
                                a2.bringToFront();
                                i runtime = rVar.getRuntime();
                                if (runtime == null) {
                                    j.dWJ();
                                }
                                com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar = a2.irc;
                                if (bVar != null) {
                                    String str;
                                    yf = runtime.yf();
                                    if (yf != null) {
                                        str = yf.cwz;
                                    }
                                    str = "";
                                    bVar.setMainTitle(str);
                                    bVar.setBackgroundColor(0);
                                    bVar.setForegroundStyle(true);
                                    bVar.eP(true);
                                }
                                ImageView imageView = a2.ird;
                                if (imageView != null) {
                                    String str2;
                                    ColorMatrix colorMatrix = new ColorMatrix();
                                    colorMatrix.setSaturation(0.0f);
                                    imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                                    com.tencent.mm.modelappbrand.a.b abR = com.tencent.mm.modelappbrand.a.b.abR();
                                    yf = runtime.yf();
                                    if (yf != null) {
                                        str2 = yf.iconUrl;
                                    } else {
                                        str2 = null;
                                    }
                                    abR.a(imageView, str2, com.tencent.mm.modelappbrand.a.a.abQ(), (f) com.tencent.mm.modelappbrand.a.f.fqH);
                                }
                                Animation animation = a2.iqZ;
                                if (animation != null) {
                                    animation.cancel();
                                }
                                a2.iqZ = AnimationUtils.loadAnimation(a2.getContext(), MMFragmentActivity.a.ync);
                                Animation animation2 = a2.iqZ;
                                if (animation2 == null) {
                                    j.dWJ();
                                }
                                animation2.setAnimationListener(new f.d(a2, anonymousClass2));
                                animation = a2.iqZ;
                                if (animation == null) {
                                    j.dWJ();
                                }
                                a2.startAnimation(animation);
                                AppMethodBeat.o(132346);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(132347);
            }
        });
        AppMethodBeat.o(132357);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(n nVar, n nVar2) {
        AppMethodBeat.i(132358);
        super.a(nVar, nVar2);
        this.isi.aHW();
        this.isi.a((w) nVar2.getCurrentPageView(), (w) nVar.getCurrentPageView(), aq.NAVIGATE_BACK);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132348);
                r.a(r.this, aq.NAVIGATE_BACK);
                AppMethodBeat.o(132348);
            }
        });
        AppMethodBeat.o(132358);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(n nVar, n nVar2, aq aqVar, String str) {
        boolean z = false;
        AppMethodBeat.i(132359);
        super.a(nVar, nVar2, aqVar, str);
        this.isq = System.currentTimeMillis();
        if (!getRuntime().xy()) {
            if (aqVar == aq.AUTO_RE_LAUNCH || aqVar == aq.APP_LAUNCH) {
                if (!str.startsWith(getRuntime().getAppConfig().ayw())) {
                    z = true;
                }
                this.isr = z;
                AppMethodBeat.o(132359);
                return;
            } else if (aqVar == aq.RE_LAUNCH && str.startsWith(getRuntime().getAppConfig().ayw())) {
                this.isr = false;
            }
        }
        AppMethodBeat.o(132359);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(n nVar, n nVar2, final aq aqVar) {
        w wVar = null;
        AppMethodBeat.i(132360);
        super.a(nVar, nVar2, aqVar);
        this.isi.a(System.currentTimeMillis() - this.isq, aqVar);
        ab.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", Long.valueOf(r2));
        if (this.isj != null) {
            this.isj.aJc();
            this.isj = null;
        }
        g gVar = this.isi;
        w wVar2 = (w) nVar2.getCurrentPageView();
        if (nVar != null) {
            wVar = (w) nVar.getCurrentPageView();
        }
        gVar.a(wVar2, wVar, aqVar);
        if (!(aq.SWITCH_TAB == aqVar || aq.NAVIGATE_TO == aqVar)) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132349);
                    r.a(r.this, aqVar);
                    AppMethodBeat.o(132349);
                }
            });
        }
        if (nVar != null && aqVar == aq.NAVIGATE_TO && getRuntime().ya().bQn.scene == FaceManager.FACE_ACQUIRED_NO_FOCUS && this.isk && !this.isl) {
            Object aBm = nVar.getCurrentPageView() == null ? "" : nVar.getCurrentPageView().aBm();
            if (this.isp != null && this.isp.equals(aBm)) {
                ab.i("MicroMsg.AppBrandPageContainer", "statPageTime");
                this.ism = ((w) nVar.getCurrentPageView()).ito.aLk();
                this.isl = true;
            }
        }
        AppMethodBeat.o(132360);
    }

    /* Access modifiers changed, original: protected */
    public void onReady() {
        AppMethodBeat.i(132361);
        super.onReady();
        MainProcessTask reportStorageSizeTask = new ReportStorageSizeTask();
        reportStorageSizeTask.appId = getRuntime().mAppId;
        AppBrandMainProcessService.a(reportStorageSizeTask);
        AppMethodBeat.o(132361);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.i(132362);
        super.onDestroy();
        if (getPageCount() > 0) {
            this.isi.a((w) getCurrentPage().getCurrentPageView());
        }
        if (this.isj != null) {
            this.isj.cleanup();
            this.isj = null;
        }
        AppMethodBeat.o(132362);
    }

    public void wU() {
        AppMethodBeat.i(132363);
        super.wU();
        if (getPageCount() > 0) {
            this.isi.c((w) getCurrentPage().getCurrentPageView());
        }
        aJs();
        AppMethodBeat.o(132363);
    }

    public void wW() {
        AppMethodBeat.i(132364);
        super.wW();
        if (getPageCount() > 0) {
            this.isi.b((w) getCurrentPage().getCurrentPageView());
        }
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null || getRuntime().ya().bQn.scene != FaceManager.FACE_ACQUIRED_NO_FOCUS)) {
            if (this.isk && !this.isl) {
                String aBm = getCurrentPage().getCurrentPageView().aBm();
                if (this.isp != null && this.isp.equals(aBm)) {
                    ab.i("MicroMsg.AppBrandPageContainer", "statPageTime onBackground");
                    com.tencent.mm.plugin.appbrand.report.model.c cVar = ((w) getCurrentPage().getCurrentPageView()).ito;
                    this.ism = cVar == null ? 0 : cVar.aLk();
                    this.isl = true;
                }
            }
            this.iso = System.currentTimeMillis() - this.isn;
            if (this.isk && this.isl && getRuntime().ya().bQn != null) {
                ab.i("MicroMsg.AppBrandPageContainer", "report pageStayTime:%d, appStayTime:%d", Long.valueOf(this.ism), Long.valueOf(this.iso));
                com.tencent.mm.plugin.appbrand.appusage.a.i.b(1, this.ism, this.iso, getRuntime().ya().bQn.iAp);
            }
        }
        AppMethodBeat.o(132364);
    }

    public g getReporter() {
        return this.isi;
    }

    /* Access modifiers changed, original: protected|final */
    public final n b(String str, aq aqVar) {
        AppMethodBeat.i(132365);
        n b = super.b(str, aqVar);
        at.cr(b);
        AppMethodBeat.o(132365);
        return b;
    }

    public u aHV() {
        AppMethodBeat.i(132366);
        u uVar = null;
        if (getRuntime().getAppConfig().heY || !e.aLR()) {
            uVar = e.DK(getAppId());
        }
        if (uVar != null) {
            AppMethodBeat.o(132366);
            return uVar;
        }
        uVar = new w();
        AppMethodBeat.o(132366);
        return uVar;
    }

    public boolean aAW() {
        return this.isr;
    }

    public final Object f(n nVar) {
        AppMethodBeat.i(132367);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.df);
        AppMethodBeat.o(132367);
        return loadAnimation;
    }

    public final Object g(n nVar) {
        AppMethodBeat.i(132368);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dc);
        AppMethodBeat.o(132368);
        return loadAnimation;
    }

    public final Object h(n nVar) {
        AppMethodBeat.i(132369);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.db);
        AppMethodBeat.o(132369);
        return loadAnimation;
    }

    public final Object i(n nVar) {
        AppMethodBeat.i(132370);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dg);
        AppMethodBeat.o(132370);
        return loadAnimation;
    }

    private void aJs() {
        AppMethodBeat.i(132371);
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null || getRuntime().ya().bQn.scene != FaceManager.FACE_ACQUIRED_NO_FOCUS)) {
            AppBrandRecommendStatObj appBrandRecommendStatObj = getRuntime().ya().bQn == null ? null : getRuntime().ya().bQn.iAp;
            if (appBrandRecommendStatObj != null) {
                ab.i("MicroMsg.AppBrandPageContainer", "recommendStatObj is got");
                if (!TextUtils.isEmpty(appBrandRecommendStatObj.iAb) && !TextUtils.isEmpty(appBrandRecommendStatObj.iAc)) {
                    this.isp = appBrandRecommendStatObj.iAb + "?" + appBrandRecommendStatObj.iAc;
                } else if (TextUtils.isEmpty(appBrandRecommendStatObj.iAb)) {
                    this.isp = getRuntime().atc();
                } else {
                    this.isp = appBrandRecommendStatObj.iAb;
                }
                this.isk = true;
                this.isn = System.currentTimeMillis();
            }
        }
        AppMethodBeat.o(132371);
    }
}
