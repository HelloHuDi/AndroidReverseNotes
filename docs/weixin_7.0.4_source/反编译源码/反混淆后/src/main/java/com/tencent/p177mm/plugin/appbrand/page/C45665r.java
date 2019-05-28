package com.tencent.p177mm.plugin.appbrand.page;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p230g.p232b.p233a.C32670bs;
import com.tencent.p177mm.p230g.p232b.p233a.C32670bs.C9506a;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C42371i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C10278d;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42457b;
import com.tencent.p177mm.plugin.appbrand.page.C19632f.C19634d;
import com.tencent.p177mm.plugin.appbrand.page.C38470q.C38468a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.p177mm.plugin.appbrand.report.model.C10714b;
import com.tencent.p177mm.plugin.appbrand.report.model.C10718c;
import com.tencent.p177mm.plugin.appbrand.report.model.C38497g;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C33519c;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.biometric.FaceManager;
import p000a.p005f.p007b.C25052j;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.r */
public class C45665r extends C38470q {
    private volatile C38497g isi = aHU();
    private C19632f isj;
    public boolean isk = false;
    public boolean isl = false;
    private long ism;
    private long isn;
    private long iso;
    private String isp;
    private long isq = 0;
    private boolean isr = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.r$1 */
    class C196471 implements Runnable {
        C196471() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132339);
            C45665r.this.aJq();
            AppMethodBeat.m2505o(132339);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.r$4 */
    class C426514 implements Runnable {
        C426514() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132348);
            C45665r.m84339a(C45665r.this, C2412aq.NAVIGATE_BACK);
            AppMethodBeat.m2505o(132348);
        }
    }

    public C45665r(Context context, C41243o c41243o) {
        super(context, c41243o);
        AppMethodBeat.m2504i(132351);
        AppMethodBeat.m2505o(132351);
    }

    /* Access modifiers changed, original: protected */
    public C38497g aHU() {
        AppMethodBeat.m2504i(132352);
        C10714b c10714b = new C10714b(getRuntime());
        AppMethodBeat.m2505o(132352);
        return c10714b;
    }

    public C41243o getRuntime() {
        AppMethodBeat.m2504i(132353);
        C41243o c41243o = (C41243o) super.getRuntime();
        AppMethodBeat.m2505o(132353);
        return c41243o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085 A:{Catch:{ Throwable -> 0x00c5 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Az */
    public void mo21667Az(String str) {
        QualitySessionRuntime qualitySessionRuntime = null;
        AppMethodBeat.m2504i(132354);
        super.mo21667Az(str);
        if (getRuntime().atH().bQp) {
            C5004al.m7442n(new C196471(), 10000);
        }
        try {
            C27285a.aLz();
            C25052j.m39376p(this, "pagecontainer");
            C32670bs c32670bs = new C32670bs();
            QualitySessionRuntime DG = C27285a.m43319DG(getAppId());
            if (DG != null) {
                C27221aj aJz;
                C31324aa c31324aa;
                int i;
                c32670bs.mo53199gr(DG.igT);
                c32670bs.mo53200gs(DG.appId);
                c32670bs.ddd = (long) DG.iDa;
                c32670bs.ddN = C9506a.m16929gT(DG.iCZ);
                c32670bs.ddz = (long) DG.apptype;
                c32670bs.cVR = (long) DG.scene;
                c32670bs.mo53197dC(DG.iDk);
                c32670bs.mo53198dD(C5046bo.anU());
                c32670bs.mo53196dB(c32670bs.ddC - c32670bs.ddB);
                C19640n currentPage = getCurrentPage();
                if (currentPage != null) {
                    C44709u currentPageView = currentPage.getCurrentPageView();
                    if (currentPageView != null) {
                        aJz = currentPageView.aJz();
                        if (aJz instanceof C31324aa) {
                            Object obj = aJz;
                        }
                        c31324aa = (C31324aa) qualitySessionRuntime;
                        if (c31324aa != null) {
                            if (c31324aa.isSysKernel()) {
                                i = 4;
                            } else if (c31324aa.getIsX5Kernel()) {
                                i = 2;
                            } else if (c31324aa.isXWalkKernel()) {
                                i = 3;
                            }
                            c32670bs.dbX = (long) i;
                            c32670bs.ajK();
                            qualitySessionRuntime = DG;
                        }
                        i = -1;
                        c32670bs.dbX = (long) i;
                        c32670bs.ajK();
                        qualitySessionRuntime = DG;
                    }
                }
                aJz = null;
                if (aJz instanceof C31324aa) {
                }
                c31324aa = (C31324aa) qualitySessionRuntime;
                if (c31324aa != null) {
                }
                i = -1;
                c32670bs.dbX = (long) i;
                c32670bs.ajK();
                qualitySessionRuntime = DG;
            }
            C33519c.m54745a(qualitySessionRuntime, "Null session with " + getAppId());
        } catch (Throwable th) {
            C4990ab.m7421w("MicroMsg.AppBrandPageContainer", "pagecontainerInitReport %s", th);
        }
        aJs();
        AppMethodBeat.m2505o(132354);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(132355);
        if (this.isj != null) {
            this.isj.dismiss();
            this.isj = null;
            AppMethodBeat.m2505o(132355);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(132355);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo61160a(String str, C2412aq c2412aq, final C38468a c38468a) {
        AppMethodBeat.m2504i(132356);
        C42458a c42458a = getRuntime().gNO;
        if (c42458a.aIy()) {
            m84341a(str, c2412aq, c38468a, false);
        } else {
            c42458a.mo44656a(str, false, new C42457b() {

                /* renamed from: com.tencent.mm.plugin.appbrand.page.r$2$1 */
                class C426501 implements Runnable {
                    C426501() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(132340);
                        c38468a.proceed();
                        AppMethodBeat.m2505o(132340);
                    }
                }

                /* renamed from: a */
                public final void mo44661a(C10278d c10278d) {
                    AppMethodBeat.m2504i(132341);
                    C45665r.this.runOnUiThread(new C426501());
                    AppMethodBeat.m2505o(132341);
                }
            });
        }
        AppMethodBeat.m2505o(132356);
        return true;
    }

    /* renamed from: a */
    private void m84341a(String str, C2412aq c2412aq, C38468a c38468a, boolean z) {
        long j;
        AppMethodBeat.m2504i(132357);
        C7060h c7060h = C7060h.pYm;
        if (z) {
            j = 5;
        } else {
            j = 1;
        }
        c7060h.mo15419k(937, j, 1);
        final boolean z2 = z;
        final C38468a c38468a2 = c38468a;
        final String str2 = str;
        final C2412aq c2412aq2 = c2412aq;
        getRuntime().gNO.mo44656a(str, true, new C42457b() {

            /* renamed from: com.tencent.mm.plugin.appbrand.page.r$3$2 */
            class C196482 implements Runnable {
                C196482() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(132343);
                    if (z2 && C45665r.this.isj != null) {
                        C45665r.this.isj.cancel();
                        C45665r.this.isj = null;
                    }
                    c38468a2.cancel();
                    AppMethodBeat.m2505o(132343);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.page.r$3$3 */
            class C196493 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.appbrand.page.r$3$3$1 */
                class C196511 implements OnClickListener {
                    C196511() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(132344);
                        switch (i) {
                            case -1:
                                C45665r.m84340a(C45665r.this, str2, c2412aq2, c38468a2);
                                break;
                        }
                        AppMethodBeat.m2505o(132344);
                    }
                }

                C196493() {
                }

                /* JADX WARNING: Missing block: B:8:0x007d, code skipped:
            if (r0 == null) goto L_0x007f;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    AppBrandInitConfig yf;
                    AppMethodBeat.m2504i(132346);
                    final C19632f a = C45665r.this.isj;
                    C45665r.this.isj = new C19632f(C45665r.this.getContext());
                    C196511 c196511 = new C196511();
                    C45665r.this.isj.setPositiveButton(c196511);
                    C45665r.this.isj.setNegativeButton(c196511);
                    C19632f a2 = C45665r.this.isj;
                    C45665r c45665r = C45665r.this;
                    C196502 c196502 = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(132345);
                            if (a != null) {
                                a.aJc();
                            }
                            AppMethodBeat.m2505o(132345);
                        }
                    };
                    C25052j.m39376p(c45665r, "pageContainer");
                    a2.ira = c45665r;
                    c45665r.addView(a2, new LayoutParams(-1, -1));
                    a2.bringToFront();
                    C6750i runtime = c45665r.getRuntime();
                    if (runtime == null) {
                        C25052j.dWJ();
                    }
                    C10933b c10933b = a2.irc;
                    if (c10933b != null) {
                        String str;
                        yf = runtime.mo15035yf();
                        if (yf != null) {
                            str = yf.cwz;
                        }
                        str = "";
                        c10933b.setMainTitle(str);
                        c10933b.setBackgroundColor(0);
                        c10933b.setForegroundStyle(true);
                        c10933b.mo22482eP(true);
                    }
                    ImageView imageView = a2.ird;
                    if (imageView != null) {
                        String str2;
                        ColorMatrix colorMatrix = new ColorMatrix();
                        colorMatrix.setSaturation(0.0f);
                        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                        C37926b abR = C37926b.abR();
                        yf = runtime.mo15035yf();
                        if (yf != null) {
                            str2 = yf.iconUrl;
                        } else {
                            str2 = null;
                        }
                        abR.mo60683a(imageView, str2, C32804a.abQ(), (C37932f) C42201f.fqH);
                    }
                    Animation animation = a2.iqZ;
                    if (animation != null) {
                        animation.cancel();
                    }
                    a2.iqZ = AnimationUtils.loadAnimation(a2.getContext(), C5206a.ync);
                    Animation animation2 = a2.iqZ;
                    if (animation2 == null) {
                        C25052j.dWJ();
                    }
                    animation2.setAnimationListener(new C19634d(a2, c196502));
                    animation = a2.iqZ;
                    if (animation == null) {
                        C25052j.dWJ();
                    }
                    a2.startAnimation(animation);
                    AppMethodBeat.m2505o(132346);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.page.r$3$1 */
            class C272351 implements Runnable {
                C272351() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(132342);
                    if (z2) {
                        c38468a2.aJr();
                    }
                    c38468a2.proceed();
                    AppMethodBeat.m2505o(132342);
                }
            }

            /* renamed from: a */
            public final void mo44661a(C10278d c10278d) {
                AppMethodBeat.m2504i(132347);
                C7060h c7060h;
                long j;
                switch (c10278d) {
                    case OK:
                        c7060h = C7060h.pYm;
                        if (z2) {
                            j = 6;
                        } else {
                            j = 2;
                        }
                        c7060h.mo15419k(937, j, 1);
                        C45665r.this.runOnUiThread(new C272351());
                        AppMethodBeat.m2505o(132347);
                        return;
                    case CANCEL:
                        c7060h = C7060h.pYm;
                        if (z2) {
                            j = 8;
                        } else {
                            j = 4;
                        }
                        c7060h.mo15419k(937, j, 1);
                        C45665r.this.runOnUiThread(new C196482());
                        AppMethodBeat.m2505o(132347);
                        return;
                    case FAIL:
                        c7060h = C7060h.pYm;
                        if (z2) {
                            j = 7;
                        } else {
                            j = 3;
                        }
                        c7060h.mo15419k(937, j, 1);
                        C45665r.this.runOnUiThread(new C196493());
                        break;
                }
                AppMethodBeat.m2505o(132347);
            }
        });
        AppMethodBeat.m2505o(132357);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61157a(C19640n c19640n, C19640n c19640n2) {
        AppMethodBeat.m2504i(132358);
        super.mo61157a(c19640n, c19640n2);
        this.isi.aHW();
        this.isi.mo6358a((C27242w) c19640n2.getCurrentPageView(), (C27242w) c19640n.getCurrentPageView(), C2412aq.NAVIGATE_BACK);
        post(new C426514());
        AppMethodBeat.m2505o(132358);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61159a(C19640n c19640n, C19640n c19640n2, C2412aq c2412aq, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(132359);
        super.mo61159a(c19640n, c19640n2, c2412aq, str);
        this.isq = System.currentTimeMillis();
        if (!getRuntime().mo65903xy()) {
            if (c2412aq == C2412aq.AUTO_RE_LAUNCH || c2412aq == C2412aq.APP_LAUNCH) {
                if (!str.startsWith(getRuntime().getAppConfig().ayw())) {
                    z = true;
                }
                this.isr = z;
                AppMethodBeat.m2505o(132359);
                return;
            } else if (c2412aq == C2412aq.RE_LAUNCH && str.startsWith(getRuntime().getAppConfig().ayw())) {
                this.isr = false;
            }
        }
        AppMethodBeat.m2505o(132359);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61158a(C19640n c19640n, C19640n c19640n2, final C2412aq c2412aq) {
        C27242w c27242w = null;
        AppMethodBeat.m2504i(132360);
        super.mo61158a(c19640n, c19640n2, c2412aq);
        this.isi.mo22128a(System.currentTimeMillis() - this.isq, c2412aq);
        C4990ab.m7417i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", Long.valueOf(r2));
        if (this.isj != null) {
            this.isj.aJc();
            this.isj = null;
        }
        C38497g c38497g = this.isi;
        C27242w c27242w2 = (C27242w) c19640n2.getCurrentPageView();
        if (c19640n != null) {
            c27242w = (C27242w) c19640n.getCurrentPageView();
        }
        c38497g.mo6358a(c27242w2, c27242w, c2412aq);
        if (!(C2412aq.SWITCH_TAB == c2412aq || C2412aq.NAVIGATE_TO == c2412aq)) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132349);
                    C45665r.m84339a(C45665r.this, c2412aq);
                    AppMethodBeat.m2505o(132349);
                }
            });
        }
        if (c19640n != null && c2412aq == C2412aq.NAVIGATE_TO && getRuntime().mo43491ya().bQn.scene == FaceManager.FACE_ACQUIRED_NO_FOCUS && this.isk && !this.isl) {
            Object aBm = c19640n.getCurrentPageView() == null ? "" : c19640n.getCurrentPageView().aBm();
            if (this.isp != null && this.isp.equals(aBm)) {
                C4990ab.m7416i("MicroMsg.AppBrandPageContainer", "statPageTime");
                this.ism = ((C27242w) c19640n.getCurrentPageView()).ito.aLk();
                this.isl = true;
            }
        }
        AppMethodBeat.m2505o(132360);
    }

    /* Access modifiers changed, original: protected */
    public void onReady() {
        AppMethodBeat.m2504i(132361);
        super.onReady();
        MainProcessTask reportStorageSizeTask = new ReportStorageSizeTask();
        reportStorageSizeTask.appId = getRuntime().mAppId;
        AppBrandMainProcessService.m54349a(reportStorageSizeTask);
        AppMethodBeat.m2505o(132361);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(132362);
        super.onDestroy();
        if (getPageCount() > 0) {
            this.isi.mo22129a((C27242w) getCurrentPage().getCurrentPageView());
        }
        if (this.isj != null) {
            this.isj.cleanup();
            this.isj = null;
        }
        AppMethodBeat.m2505o(132362);
    }

    /* renamed from: wU */
    public void mo21679wU() {
        AppMethodBeat.m2504i(132363);
        super.mo21679wU();
        if (getPageCount() > 0) {
            this.isi.mo6360c((C27242w) getCurrentPage().getCurrentPageView());
        }
        aJs();
        AppMethodBeat.m2505o(132363);
    }

    /* renamed from: wW */
    public void mo21680wW() {
        AppMethodBeat.m2504i(132364);
        super.mo21680wW();
        if (getPageCount() > 0) {
            this.isi.mo6359b((C27242w) getCurrentPage().getCurrentPageView());
        }
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null || getRuntime().mo43491ya().bQn.scene != FaceManager.FACE_ACQUIRED_NO_FOCUS)) {
            if (this.isk && !this.isl) {
                String aBm = getCurrentPage().getCurrentPageView().aBm();
                if (this.isp != null && this.isp.equals(aBm)) {
                    C4990ab.m7416i("MicroMsg.AppBrandPageContainer", "statPageTime onBackground");
                    C10718c c10718c = ((C27242w) getCurrentPage().getCurrentPageView()).ito;
                    this.ism = c10718c == null ? 0 : c10718c.aLk();
                    this.isl = true;
                }
            }
            this.iso = System.currentTimeMillis() - this.isn;
            if (this.isk && this.isl && getRuntime().mo43491ya().bQn != null) {
                C4990ab.m7417i("MicroMsg.AppBrandPageContainer", "report pageStayTime:%d, appStayTime:%d", Long.valueOf(this.ism), Long.valueOf(this.iso));
                C42371i.m74963b(1, this.ism, this.iso, getRuntime().mo43491ya().bQn.iAp);
            }
        }
        AppMethodBeat.m2505o(132364);
    }

    public C38497g getReporter() {
        return this.isi;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final C19640n mo61163b(String str, C2412aq c2412aq) {
        AppMethodBeat.m2504i(132365);
        C19640n b = super.mo61163b(str, c2412aq);
        C33468at.m54677cr(b);
        AppMethodBeat.m2505o(132365);
        return b;
    }

    public C44709u aHV() {
        AppMethodBeat.m2504i(132366);
        C44709u c44709u = null;
        if (getRuntime().getAppConfig().heY || !C27310e.aLR()) {
            c44709u = C27310e.m43368DK(getAppId());
        }
        if (c44709u != null) {
            AppMethodBeat.m2505o(132366);
            return c44709u;
        }
        c44709u = new C27242w();
        AppMethodBeat.m2505o(132366);
        return c44709u;
    }

    public boolean aAW() {
        return this.isr;
    }

    /* renamed from: f */
    public final Object mo61166f(C19640n c19640n) {
        AppMethodBeat.m2504i(132367);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8403df);
        AppMethodBeat.m2505o(132367);
        return loadAnimation;
    }

    /* renamed from: g */
    public final Object mo61167g(C19640n c19640n) {
        AppMethodBeat.m2504i(132368);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8402dc);
        AppMethodBeat.m2505o(132368);
        return loadAnimation;
    }

    /* renamed from: h */
    public final Object mo61175h(C19640n c19640n) {
        AppMethodBeat.m2504i(132369);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8401db);
        AppMethodBeat.m2505o(132369);
        return loadAnimation;
    }

    /* renamed from: i */
    public final Object mo61176i(C19640n c19640n) {
        AppMethodBeat.m2504i(132370);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8404dg);
        AppMethodBeat.m2505o(132370);
        return loadAnimation;
    }

    private void aJs() {
        AppMethodBeat.m2504i(132371);
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null || getRuntime().mo43491ya().bQn.scene != FaceManager.FACE_ACQUIRED_NO_FOCUS)) {
            AppBrandRecommendStatObj appBrandRecommendStatObj = getRuntime().mo43491ya().bQn == null ? null : getRuntime().mo43491ya().bQn.iAp;
            if (appBrandRecommendStatObj != null) {
                C4990ab.m7416i("MicroMsg.AppBrandPageContainer", "recommendStatObj is got");
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
        AppMethodBeat.m2505o(132371);
    }
}
