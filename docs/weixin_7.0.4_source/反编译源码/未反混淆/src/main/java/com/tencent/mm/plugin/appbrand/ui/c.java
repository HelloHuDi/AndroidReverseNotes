package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ViewConstructor"})
final class c extends com.tencent.mm.ui.statusbar.b implements j, q {
    private o gOq;
    private ThreeDotsLoadingView iDW;
    private ImageView iFV;
    private ImageView iFW;
    private TextView iFX;
    private LinearLayout iFY;
    private com.tencent.mm.plugin.appbrand.widget.actionbar.b iFZ;
    private TextView iGa;
    private com.tencent.mm.plugin.appbrand.config.a.a.b iGb = com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT;
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
    private ImageView kU;

    public class a extends TimerTask {
        private float progress = 50.0f;

        public final void run() {
            AppMethodBeat.i(132944);
            if (this.progress >= 100.0f) {
                cancel();
                AppMethodBeat.o(132944);
                return;
            }
            this.progress += 0.33f;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132943);
                    if (c.this.iGm.getVisibility() == 0) {
                        c.this.iGo.setProgress(a.this.progress);
                    }
                    AppMethodBeat.o(132943);
                }
            });
            AppMethodBeat.o(132944);
        }
    }

    public class b extends TimerTask {
        private int progress = 50;

        public final void run() {
            AppMethodBeat.i(132946);
            if (this.progress >= 100) {
                cancel();
                AppMethodBeat.o(132946);
                return;
            }
            this.progress++;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132945);
                    if (c.this.iGa.getVisibility() == 0) {
                        c.this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(b.this.progress)}));
                        if (b.this.progress == 100) {
                            c.this.iGd = true;
                            if (c.this.iGe != null) {
                                c.this.iGe.run();
                                c.this.iGe = null;
                            }
                        }
                    }
                    AppMethodBeat.o(132945);
                }
            });
            AppMethodBeat.o(132946);
        }
    }

    public c(Context context, o oVar) {
        super(context);
        AppMethodBeat.i(132947);
        this.gOq = oVar;
        ab.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.dm, this);
        this.iGm = (RelativeLayout) findViewById(R.id.vy);
        this.iGn = (ImageView) findViewById(R.id.vz);
        this.iGo = (BootstrapProgressBar) findViewById(R.id.w0);
        e.aBD().cY(999, 1);
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_splashscreen, false) && this.gOq != null) {
            final long yz = bo.yz();
            AppBrandInitConfigWC atI = this.gOq.atI();
            final String str = atI.hgL;
            if (com.tencent.magicbrush.c.isNullOrNil(str)) {
                e.aBD().cY(1000, 0);
            } else {
                this.iGg = true;
                ab.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", str);
                e.aBD().cY(1000, 1);
            }
            final AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.game.preload.a.a() {
                public final void a(final Bitmap bitmap, final long j) {
                    AppMethodBeat.i(132934);
                    ab.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
                    c.this.iGh = true;
                    if (c.this.iGn != null) {
                        m.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(132933);
                                if (bitmap != null) {
                                    c.this.iGn.setImageBitmap(bitmap);
                                    if (c.this.iGi) {
                                        c.d(c.this);
                                    }
                                    e.aBD().cY(1002, (int) bo.az(yz));
                                    e.aBD().cY(1001, (int) j);
                                }
                                AppMethodBeat.o(132933);
                            }
                        });
                    }
                    AppMethodBeat.o(132934);
                }
            };
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132935);
                    com.tencent.mm.plugin.appbrand.game.preload.a.aBu();
                    String str = c.this.gOq.mAppId;
                    String str2 = str;
                    com.tencent.mm.plugin.appbrand.game.preload.a.a aVar = anonymousClass1;
                    if (!(com.tencent.magicbrush.c.isNullOrNil(str) || com.tencent.magicbrush.c.isNullOrNil(str2))) {
                        Closeable fileInputStream;
                        str = com.tencent.mm.plugin.appbrand.game.preload.a.fqf + File.separator + str + File.separator;
                        com.tencent.mm.sdk.platformtools.j.aih(str);
                        String str3 = str + ag.ck(str2);
                        ab.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", str3);
                        if (new File(str3).exists()) {
                            try {
                                fileInputStream = new FileInputStream(str3);
                            } catch (FileNotFoundException e) {
                                ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e, "", new Object[0]);
                                fileInputStream = null;
                            }
                            if (fileInputStream != null) {
                                try {
                                    aVar.a(d.decodeStream(fileInputStream), (long) fileInputStream.available());
                                } catch (IOException e2) {
                                    ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e2, "read contentLength", new Object[0]);
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.appbrand.game.preload.a.bW(str3, str2);
                            try {
                                fileInputStream = new FileInputStream(str3);
                            } catch (FileNotFoundException e3) {
                                ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e3, "", new Object[0]);
                                fileInputStream = null;
                            }
                            if (fileInputStream != null) {
                                try {
                                    aVar.a(d.decodeStream(fileInputStream), (long) fileInputStream.available());
                                } catch (IOException e22) {
                                    ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e22, "read contentLength", new Object[0]);
                                }
                            }
                        }
                        com.tencent.magicbrush.c.b(fileInputStream);
                    }
                    AppMethodBeat.o(132935);
                }
            });
            if (bo.isNullOrNil(atI.hgM)) {
                this.iGj = getContext().getResources().getColor(R.color.f6);
                this.iGo.setProgressColor(this.iGj);
            } else {
                this.iGj = Color.parseColor(atI.hgM);
                this.iGo.setProgressColor(this.iGj);
                ab.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", Integer.valueOf(this.iGj));
            }
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132936);
                    c.this.iGi = true;
                    ab.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
                    if (c.this.iGh) {
                        c.d(c.this);
                    }
                    AppMethodBeat.o(132936);
                }
            }, 1000);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132937);
                    if (c.this.iGh) {
                        AppMethodBeat.o(132937);
                        return;
                    }
                    c.this.iGk = true;
                    c.this.iGf.setVisibility(0);
                    c.this.iDW.setVisibility(0);
                    c.this.iGa.setVisibility(0);
                    c.l(c.this);
                    AppMethodBeat.o(132937);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        this.iGf = (RelativeLayout) findViewById(R.id.vp);
        this.kU = (ImageView) findViewById(R.id.vv);
        this.kU.setImageDrawable(com.tencent.mm.modelappbrand.a.a.abQ());
        this.iFX = (TextView) findViewById(R.id.vq);
        this.iFV = (ImageView) findViewById(R.id.vx);
        this.iDW = (ThreeDotsLoadingView) findViewById(R.id.vs);
        this.iFW = (ImageView) findViewById(R.id.vr);
        this.iFY = (LinearLayout) findViewById(R.id.vo);
        this.iGa = (TextView) findViewById(R.id.vt);
        this.iGc = (TextView) findViewById(R.id.vu);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iFW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iFV.getLayoutParams();
        this.iFZ = com.tencent.mm.plugin.appbrand.widget.actionbar.f.a.dh(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 21;
        layoutParams4.rightMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.ra);
        layoutParams4.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rb);
        this.iFY.addView(this.iFZ.getActionView(), layoutParams4);
        if (this.gOq.atI().hgD == 1) {
            this.iFW.setVisibility(0);
        } else {
            this.iFW.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.iGo.getLayoutParams();
        this.iGb = com.tencent.mm.plugin.appbrand.config.a.a.t(this.gOq.atM()).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
        ab.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", this.iGb);
        if (this.iGb == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR || this.iGb == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED || this.iGb == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT || this.iGb == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT) {
            if (this.iFW.getVisibility() == 0) {
                layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rg);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rc);
                layoutParams2.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rj);
                this.iFW.setLayoutParams(layoutParams2);
            } else {
                layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rk);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
            }
            layoutParams5.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.r7);
            layoutParams5.width = com.tencent.mm.bz.a.am(getContext(), R.dimen.r8);
        } else {
            if (this.iFW.getVisibility() == 0) {
                layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.ri);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
                layoutParams2.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rl);
                this.iFW.setLayoutParams(layoutParams2);
            } else {
                layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rh);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
            }
            layoutParams5.width = com.tencent.mm.bz.a.am(getContext(), R.dimen.r_);
            layoutParams5.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.r9);
        }
        this.iDW.setLayoutParams(layoutParams);
        this.iGo.setLayoutParams(layoutParams5);
        this.iFV.setLayoutParams(layoutParams3);
        K(-1, true);
        this.iFZ.setBackgroundColor(0);
        this.iFZ.setForegroundStyle("black");
        this.iFZ.setNavBackOrClose(false);
        AnonymousClass7 anonymousClass7 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(132942);
                com.tencent.mm.plugin.appbrand.g.a(c.this.gOq.mAppId, com.tencent.mm.plugin.appbrand.g.d.CLOSE);
                c.this.gOq.finish();
                AppMethodBeat.o(132942);
            }
        };
        this.iFZ.setCloseButtonClickListener(anonymousClass7);
        this.iFZ.setBackButtonClickListener(anonymousClass7);
        n.q(getContext(), true);
        if (this.iGg) {
            this.iDW.setVisibility(4);
            this.iGa.setVisibility(4);
            AppMethodBeat.o(132947);
            return;
        }
        this.iDW.dKS();
        AppMethodBeat.o(132947);
    }

    public final void cz(String str, String str2) {
        AppMethodBeat.i(132948);
        com.tencent.mm.modelappbrand.a.b.abR().a(this.kU, str, null, f.fqH);
        this.iFX.setText(str2);
        AppMethodBeat.o(132948);
    }

    public final void aHS() {
        AppMethodBeat.i(132949);
        ab.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132940);
                final ViewParent parent = c.this.getParent();
                if (parent instanceof ViewGroup) {
                    ViewPropertyAnimator animate = c.this.animate();
                    animate.setStartDelay((long) (((float) animate.getDuration()) * 0.8f));
                    animate.setDuration((long) (((float) animate.getDuration()) * 1.0f));
                    animate.setListener(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(132939);
                            c.this.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(132938);
                                    c.this.setVisibility(8);
                                    ((ViewGroup) parent).removeView(c.this);
                                    AppMethodBeat.o(132938);
                                }
                            });
                            AppMethodBeat.o(132939);
                        }
                    });
                    animate.alpha(0.0f).start();
                    AppMethodBeat.o(132940);
                    return;
                }
                AppMethodBeat.o(132940);
            }
        });
        AppMethodBeat.o(132949);
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(132950);
        super.onLayout(z, i, i2, i3, i4);
        com.tencent.mm.plugin.appbrand.config.a.a.b dI = com.tencent.mm.plugin.appbrand.config.a.a.t(this.gOq.atM()).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
        if (dI != this.iGb) {
            this.iGb = dI;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDW.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iFW.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iGo.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iFV.getLayoutParams();
            if (dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT) {
                if (this.iFW.getVisibility() == 0) {
                    layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rg);
                    layoutParams4.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rc);
                    layoutParams2.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rj);
                    this.iFW.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rk);
                    layoutParams4.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
                }
                layoutParams3.width = com.tencent.mm.bz.a.am(getContext(), R.dimen.r8);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.r7);
            } else {
                if (this.iFW.getVisibility() == 0) {
                    layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.ri);
                    layoutParams4.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
                    layoutParams2.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rl);
                    this.iFW.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.topMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rh);
                    layoutParams4.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.rd);
                }
                layoutParams3.width = com.tencent.mm.bz.a.am(getContext(), R.dimen.r_);
                layoutParams3.bottomMargin = com.tencent.mm.bz.a.am(getContext(), R.dimen.r9);
            }
            this.iGo.setLayoutParams(layoutParams3);
            this.iDW.setLayoutParams(layoutParams);
            this.iFV.setLayoutParams(layoutParams4);
            requestLayout();
        }
        AppMethodBeat.o(132950);
    }

    public final void setProgress(int i) {
        AppMethodBeat.i(132951);
        if (this.iGg) {
            if (this.iGh || !this.iGk) {
                if (i < 100) {
                    if (this.iGm.getVisibility() == 0) {
                        this.iGo.setProgress((float) (i / 2));
                        AppMethodBeat.o(132951);
                        return;
                    }
                } else if (!this.iGq) {
                    this.iGq = true;
                    new Timer(true).scheduleAtFixedRate(new a(), 0, (long) (1000 / this.iGl));
                }
            } else if (i < 100) {
                this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(i / 2)}));
                AppMethodBeat.o(132951);
                return;
            } else if (!this.iGp) {
                this.iGp = true;
                new Timer(true).scheduleAtFixedRate(new b(), 0, 100);
                AppMethodBeat.o(132951);
                return;
            }
        } else if (i < 100) {
            this.iGa.setText(String.format("%d%%", new Object[]{Integer.valueOf(i / 2)}));
            AppMethodBeat.o(132951);
            return;
        } else if (!this.iGp) {
            this.iGp = true;
            new Timer(true).scheduleAtFixedRate(new b(), 0, 50);
            AppMethodBeat.o(132951);
            return;
        }
        AppMethodBeat.o(132951);
    }

    public final void nm(final int i) {
        AppMethodBeat.i(132952);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132941);
                ab.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + i);
                if (i == 3) {
                    if (c.this.iGd) {
                        c.this.iGc.setVisibility(0);
                        c.this.iGc.setText(R.string.uu);
                        c.this.iGa.setVisibility(4);
                        AppMethodBeat.o(132941);
                        return;
                    }
                    c.this.iGe = this;
                }
                AppMethodBeat.o(132941);
            }
        });
        AppMethodBeat.o(132952);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(132953);
        if (cVar.iGi && cVar.iGh) {
            ab.i("MicroMsg.AppBrandGameUILoadingSplash", "showCutomView");
            cVar.iGm.setVisibility(0);
            cVar.iGf.setVisibility(4);
            cVar.iGo.bringToFront();
            cVar.iFY.bringToFront();
            AppMethodBeat.o(132953);
            return;
        }
        AppMethodBeat.o(132953);
    }

    static /* synthetic */ void l(c cVar) {
        AppMethodBeat.i(132954);
        cVar.iDW.dKS();
        AppMethodBeat.o(132954);
    }
}
