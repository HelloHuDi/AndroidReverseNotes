package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.game.preload.C10251a;
import com.tencent.p177mm.plugin.appbrand.game.preload.C10251a.C10252a;
import com.tencent.p177mm.plugin.appbrand.game.preload.C38233e;
import com.tencent.p177mm.plugin.appbrand.game.preload.p1470ui.BootstrapProgressBar;
import com.tencent.p177mm.plugin.appbrand.launching.C38422j;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C33578f.C33579a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.c */
final class C10838c extends C7355b implements C38422j, C27333q {
    private C41243o gOq;
    private ThreeDotsLoadingView iDW;
    private ImageView iFV;
    private ImageView iFW;
    private TextView iFX;
    private LinearLayout iFY;
    private C10933b iFZ;
    private TextView iGa;
    private C26839b iGb = C26839b.PORTRAIT;
    private TextView iGc;
    private boolean iGd;
    private Runnable iGe = null;
    private RelativeLayout iGf;
    private boolean iGg = false;
    private boolean iGh = false;
    private boolean iGi = false;
    private int iGj;
    private boolean iGk = false;
    private int iGl = 30;
    private RelativeLayout iGm;
    private ImageView iGn;
    private BootstrapProgressBar iGo;
    private boolean iGp;
    private boolean iGq;
    /* renamed from: kU */
    private ImageView f2882kU;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$4 */
    class C108394 implements Runnable {
        C108394() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132937);
            if (C10838c.this.iGh) {
                AppMethodBeat.m2505o(132937);
                return;
            }
            C10838c.this.iGk = true;
            C10838c.this.iGf.setVisibility(0);
            C10838c.this.iDW.setVisibility(0);
            C10838c.this.iGa.setVisibility(0);
            C10838c.m18547l(C10838c.this);
            AppMethodBeat.m2505o(132937);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$a */
    public class C10840a extends TimerTask {
        private float progress = 50.0f;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$a$1 */
        class C108411 implements Runnable {
            C108411() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132943);
                if (C10838c.this.iGm.getVisibility() == 0) {
                    C10838c.this.iGo.setProgress(C10840a.this.progress);
                }
                AppMethodBeat.m2505o(132943);
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(132944);
            if (this.progress >= 100.0f) {
                cancel();
                AppMethodBeat.m2505o(132944);
                return;
            }
            this.progress += 0.33f;
            C5004al.m7441d(new C108411());
            AppMethodBeat.m2505o(132944);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$5 */
    class C108425 implements Runnable {
        C108425() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132940);
            final ViewParent parent = C10838c.this.getParent();
            if (parent instanceof ViewGroup) {
                ViewPropertyAnimator animate = C10838c.this.animate();
                animate.setStartDelay((long) (((float) animate.getDuration()) * 0.8f));
                animate.setDuration((long) (((float) animate.getDuration()) * 1.0f));
                animate.setListener(new AnimatorListenerAdapter() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$5$1$1 */
                    class C108441 implements Runnable {
                        C108441() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(132938);
                            C10838c.this.setVisibility(8);
                            ((ViewGroup) parent).removeView(C10838c.this);
                            AppMethodBeat.m2505o(132938);
                        }
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.m2504i(132939);
                        C10838c.this.post(new C108441());
                        AppMethodBeat.m2505o(132939);
                    }
                });
                animate.alpha(0.0f).start();
                AppMethodBeat.m2505o(132940);
                return;
            }
            AppMethodBeat.m2505o(132940);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$7 */
    class C108457 implements OnClickListener {
        C108457() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(132942);
            C33183g.m54275a(C10838c.this.gOq.mAppId, C33184d.CLOSE);
            C10838c.this.gOq.finish();
            AppMethodBeat.m2505o(132942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$b */
    public class C10846b extends TimerTask {
        private int progress = 50;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$b$1 */
        class C108471 implements Runnable {
            C108471() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132945);
                if (C10838c.this.iGa.getVisibility() == 0) {
                    C10838c.this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(C10846b.this.progress)}));
                    if (C10846b.this.progress == 100) {
                        C10838c.this.iGd = true;
                        if (C10838c.this.iGe != null) {
                            C10838c.this.iGe.run();
                            C10838c.this.iGe = null;
                        }
                    }
                }
                AppMethodBeat.m2505o(132945);
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(132946);
            if (this.progress >= 100) {
                cancel();
                AppMethodBeat.m2505o(132946);
                return;
            }
            this.progress++;
            C5004al.m7441d(new C108471());
            AppMethodBeat.m2505o(132946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c$3 */
    class C108493 implements Runnable {
        C108493() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132936);
            C10838c.this.iGi = true;
            C4990ab.m7416i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (C10838c.this.iGh) {
                C10838c.m18539d(C10838c.this);
            }
            AppMethodBeat.m2505o(132936);
        }
    }

    public C10838c(Context context, C41243o c41243o) {
        super(context);
        AppMethodBeat.m2504i(132947);
        this.gOq = c41243o;
        C4990ab.m7416i("MicroMsg.AppBrandGameUILoadingSplash", "init");
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(2130968736, this);
        this.iGm = (RelativeLayout) findViewById(2131821382);
        this.iGn = (ImageView) findViewById(2131821383);
        this.iGo = (BootstrapProgressBar) findViewById(2131821384);
        C38233e.aBD().mo60956cY(999, 1);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_splashscreen, false) && this.gOq != null) {
            final long yz = C5046bo.m7588yz();
            AppBrandInitConfigWC atI = this.gOq.atI();
            final String str = atI.hgL;
            if (C37414c.isNullOrNil(str)) {
                C38233e.aBD().mo60956cY(1000, 0);
            } else {
                this.iGg = true;
                C4990ab.m7417i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", str);
                C38233e.aBD().mo60956cY(1000, 1);
            }
            final C108481 c108481 = new C10252a() {
                /* renamed from: a */
                public final void mo21686a(final Bitmap bitmap, final long j) {
                    AppMethodBeat.m2504i(132934);
                    C4990ab.m7416i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
                    C10838c.this.iGh = true;
                    if (C10838c.this.iGn != null) {
                        C45673m.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(132933);
                                if (bitmap != null) {
                                    C10838c.this.iGn.setImageBitmap(bitmap);
                                    if (C10838c.this.iGi) {
                                        C10838c.m18539d(C10838c.this);
                                    }
                                    C38233e.aBD().mo60956cY(1002, (int) C5046bo.m7525az(yz));
                                    C38233e.aBD().mo60956cY(1001, (int) j);
                                }
                                AppMethodBeat.m2505o(132933);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(132934);
                }
            };
            C26006a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132935);
                    C10251a.aBu();
                    String str = C10838c.this.gOq.mAppId;
                    String str2 = str;
                    C10252a c10252a = c108481;
                    if (!(C37414c.isNullOrNil(str) || C37414c.isNullOrNil(str2))) {
                        Closeable fileInputStream;
                        str = C10251a.fqf + File.separator + str + File.separator;
                        C15428j.aih(str);
                        String str3 = str + C4995ag.m7428ck(str2);
                        C4990ab.m7417i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", str3);
                        if (new File(str3).exists()) {
                            try {
                                fileInputStream = new FileInputStream(str3);
                            } catch (FileNotFoundException e) {
                                C4990ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e, "", new Object[0]);
                                fileInputStream = null;
                            }
                            if (fileInputStream != null) {
                                try {
                                    c10252a.mo21686a(C5056d.decodeStream(fileInputStream), (long) fileInputStream.available());
                                } catch (IOException e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e2, "read contentLength", new Object[0]);
                                }
                            }
                        } else {
                            C10251a.m17902bW(str3, str2);
                            try {
                                fileInputStream = new FileInputStream(str3);
                            } catch (FileNotFoundException e3) {
                                C4990ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e3, "", new Object[0]);
                                fileInputStream = null;
                            }
                            if (fileInputStream != null) {
                                try {
                                    c10252a.mo21686a(C5056d.decodeStream(fileInputStream), (long) fileInputStream.available());
                                } catch (IOException e22) {
                                    C4990ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e22, "read contentLength", new Object[0]);
                                }
                            }
                        }
                        C37414c.m63042b(fileInputStream);
                    }
                    AppMethodBeat.m2505o(132935);
                }
            });
            if (C5046bo.isNullOrNil(atI.hgM)) {
                this.iGj = getContext().getResources().getColor(C25738R.color.f11734f6);
                this.iGo.setProgressColor(this.iGj);
            } else {
                this.iGj = Color.parseColor(atI.hgM);
                this.iGo.setProgressColor(this.iGj);
                C4990ab.m7417i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", Integer.valueOf(this.iGj));
            }
            C5004al.m7442n(new C108493(), 1000);
            C5004al.m7442n(new C108394(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        this.iGf = (RelativeLayout) findViewById(2131821373);
        this.f2882kU = (ImageView) findViewById(2131821379);
        this.f2882kU.setImageDrawable(C32804a.abQ());
        this.iFX = (TextView) findViewById(2131821374);
        this.iFV = (ImageView) findViewById(2131821381);
        this.iDW = (ThreeDotsLoadingView) findViewById(2131821376);
        this.iFW = (ImageView) findViewById(2131821375);
        this.iFY = (LinearLayout) findViewById(2131821372);
        this.iGa = (TextView) findViewById(2131821377);
        this.iGc = (TextView) findViewById(2131821378);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iFW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iFV.getLayoutParams();
        this.iFZ = C33579a.m54831dh(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 21;
        layoutParams4.rightMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10139ra);
        layoutParams4.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10140rb);
        this.iFY.addView(this.iFZ.getActionView(), layoutParams4);
        if (this.gOq.atI().hgD == 1) {
            this.iFW.setVisibility(0);
        } else {
            this.iFW.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.iGo.getLayoutParams();
        this.iGb = C26835a.m42717t(this.gOq.atM()).mo44610dI(C26835a.ayQ());
        C4990ab.m7417i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", this.iGb);
        if (this.iGb == C26839b.LANDSCAPE_SENSOR || this.iGb == C26839b.LANDSCAPE_LOCKED || this.iGb == C26839b.LANDSCAPE_LEFT || this.iGb == C26839b.LANDSCAPE_RIGHT) {
            if (this.iFW.getVisibility() == 0) {
                layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10145rg);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10141rc);
                layoutParams2.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10148rj);
                this.iFW.setLayoutParams(layoutParams2);
            } else {
                layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10149rk);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
            }
            layoutParams5.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10135r7);
            layoutParams5.width = C1338a.m2857am(getContext(), C25738R.dimen.f10136r8);
        } else {
            if (this.iFW.getVisibility() == 0) {
                layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10147ri);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
                layoutParams2.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10150rl);
                this.iFW.setLayoutParams(layoutParams2);
            } else {
                layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10146rh);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
            }
            layoutParams5.width = C1338a.m2857am(getContext(), C25738R.dimen.f10138r_);
            layoutParams5.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10137r9);
        }
        this.iDW.setLayoutParams(layoutParams);
        this.iGo.setLayoutParams(layoutParams5);
        this.iFV.setLayoutParams(layoutParams3);
        mo15851K(-1, true);
        this.iFZ.setBackgroundColor(0);
        this.iFZ.setForegroundStyle("black");
        this.iFZ.setNavBackOrClose(false);
        C108457 c108457 = new C108457();
        this.iFZ.setCloseButtonClickListener(c108457);
        this.iFZ.setBackButtonClickListener(c108457);
        C42696n.m75623q(getContext(), true);
        if (this.iGg) {
            this.iDW.setVisibility(4);
            this.iGa.setVisibility(4);
            AppMethodBeat.m2505o(132947);
            return;
        }
        this.iDW.dKS();
        AppMethodBeat.m2505o(132947);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
        AppMethodBeat.m2504i(132948);
        C37926b.abR().mo60683a(this.f2882kU, str, null, C42201f.fqH);
        this.iFX.setText(str2);
        AppMethodBeat.m2505o(132948);
    }

    public final void aHS() {
        AppMethodBeat.m2504i(132949);
        C4990ab.m7420w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
        post(new C108425());
        AppMethodBeat.m2505o(132949);
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(132950);
        super.onLayout(z, i, i2, i3, i4);
        C26839b dI = C26835a.m42717t(this.gOq.atM()).mo44610dI(C26835a.ayQ());
        if (dI != this.iGb) {
            this.iGb = dI;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDW.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iFW.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iGo.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iFV.getLayoutParams();
            if (dI == C26839b.LANDSCAPE_SENSOR || dI == C26839b.LANDSCAPE_LOCKED || dI == C26839b.LANDSCAPE_LEFT || dI == C26839b.LANDSCAPE_RIGHT) {
                if (this.iFW.getVisibility() == 0) {
                    layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10145rg);
                    layoutParams4.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10141rc);
                    layoutParams2.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10148rj);
                    this.iFW.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10149rk);
                    layoutParams4.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
                }
                layoutParams3.width = C1338a.m2857am(getContext(), C25738R.dimen.f10136r8);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10135r7);
            } else {
                if (this.iFW.getVisibility() == 0) {
                    layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10147ri);
                    layoutParams4.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
                    layoutParams2.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10150rl);
                    this.iFW.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10146rh);
                    layoutParams4.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10142rd);
                }
                layoutParams3.width = C1338a.m2857am(getContext(), C25738R.dimen.f10138r_);
                layoutParams3.bottomMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10137r9);
            }
            this.iGo.setLayoutParams(layoutParams3);
            this.iDW.setLayoutParams(layoutParams);
            this.iFV.setLayoutParams(layoutParams4);
            requestLayout();
        }
        AppMethodBeat.m2505o(132950);
    }

    public final void setProgress(int i) {
        AppMethodBeat.m2504i(132951);
        if (this.iGg) {
            if (this.iGh || !this.iGk) {
                if (i < 100) {
                    if (this.iGm.getVisibility() == 0) {
                        this.iGo.setProgress((float) (i / 2));
                        AppMethodBeat.m2505o(132951);
                        return;
                    }
                } else if (!this.iGq) {
                    this.iGq = true;
                    new Timer(true).scheduleAtFixedRate(new C10840a(), 0, (long) (1000 / this.iGl));
                }
            } else if (i < 100) {
                this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(i / 2)}));
                AppMethodBeat.m2505o(132951);
                return;
            } else if (!this.iGp) {
                this.iGp = true;
                new Timer(true).scheduleAtFixedRate(new C10846b(), 0, 100);
                AppMethodBeat.m2505o(132951);
                return;
            }
        } else if (i < 100) {
            this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(i / 2)}));
            AppMethodBeat.m2505o(132951);
            return;
        } else if (!this.iGp) {
            this.iGp = true;
            new Timer(true).scheduleAtFixedRate(new C10846b(), 0, 50);
            AppMethodBeat.m2505o(132951);
            return;
        }
        AppMethodBeat.m2505o(132951);
    }

    /* renamed from: nm */
    public final void mo6247nm(final int i) {
        AppMethodBeat.m2504i(132952);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132941);
                C4990ab.m7416i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + i);
                if (i == 3) {
                    if (C10838c.this.iGd) {
                        C10838c.this.iGc.setVisibility(0);
                        C10838c.this.iGc.setText(C25738R.string.f9267uu);
                        C10838c.this.iGa.setVisibility(4);
                        AppMethodBeat.m2505o(132941);
                        return;
                    }
                    C10838c.this.iGe = this;
                }
                AppMethodBeat.m2505o(132941);
            }
        });
        AppMethodBeat.m2505o(132952);
    }

    /* renamed from: d */
    static /* synthetic */ void m18539d(C10838c c10838c) {
        AppMethodBeat.m2504i(132953);
        if (c10838c.iGi && c10838c.iGh) {
            C4990ab.m7416i("MicroMsg.AppBrandGameUILoadingSplash", "showCutomView");
            c10838c.iGm.setVisibility(0);
            c10838c.iGf.setVisibility(4);
            c10838c.iGo.bringToFront();
            c10838c.iFY.bringToFront();
            AppMethodBeat.m2505o(132953);
            return;
        }
        AppMethodBeat.m2505o(132953);
    }

    /* renamed from: l */
    static /* synthetic */ void m18547l(C10838c c10838c) {
        AppMethodBeat.m2504i(132954);
        c10838c.iDW.dKS();
        AppMethodBeat.m2505o(132954);
    }
}
