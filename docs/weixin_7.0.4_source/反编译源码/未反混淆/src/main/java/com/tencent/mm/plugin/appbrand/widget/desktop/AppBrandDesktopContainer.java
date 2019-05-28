package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;

public class AppBrandDesktopContainer extends HeaderContainer implements OnTouchListener {
    private DynamicBackgroundGLSurfaceView iVw;
    private MMFragmentActivity iWA;
    private boolean iWB = true;
    private int iWC = 0;
    private int iWD = 0;
    private GyroView iWd;
    private b iWv;
    private AppBrandDesktopView iWw;
    private GradientColorBackgroundView iWx;
    private Rect iWy = new Rect();
    private View iWz;

    public AppBrandDesktopContainer(Context context) {
        super(context);
        AppMethodBeat.i(133713);
        init(context);
        AppMethodBeat.o(133713);
    }

    public AppBrandDesktopContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133714);
        init(context);
        AppMethodBeat.o(133714);
    }

    public AppBrandDesktopContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133715);
        init(context);
        AppMethodBeat.o(133715);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        this.iWA = mMFragmentActivity;
    }

    public void setAnimController(b bVar) {
        AppMethodBeat.i(133716);
        this.iWv = bVar;
        if (!(this.iWw == null || this.iWv == null)) {
            this.iWv.a(this.iWw);
        }
        AppMethodBeat.o(133716);
    }

    public void setFixedHeight(boolean z) {
        this.iWB = z;
    }

    public void setExtraBottomHeight(int i) {
        this.iWD = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        AppMethodBeat.i(133717);
        aPh();
        ab.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.iWC), Integer.valueOf(this.iWD));
        if (this.iWB) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec((((ViewGroup) getParent()).getMeasuredHeight() - this.iWC) - this.iWD, ErrorDialogData.SUPPRESSED);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, makeMeasureSpec);
        AppMethodBeat.o(133717);
    }

    private void aPh() {
        AppMethodBeat.i(133718);
        if (getResources().getConfiguration().orientation == 1) {
            this.iWC = getResources().getDimensionPixelSize(R.dimen.a2z);
            AppMethodBeat.o(133718);
            return;
        }
        this.iWC = getResources().getDimensionPixelSize(R.dimen.a30);
        AppMethodBeat.o(133718);
    }

    private void init(Context context) {
        AppMethodBeat.i(133719);
        ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
        aPh();
        setBackgroundColor(getResources().getColor(R.color.a3p));
        com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b bVar = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZg;
        com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPB();
        this.iWw = new AppBrandDesktopView(context);
        this.iWw.setHeaderContainer(this);
        this.iWw.setId(R.id.k);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        int leftRightMargin = this.iWw.getLeftRightMargin();
        ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view topMargin: %d, marginLeftRight: %d", Integer.valueOf(layoutParams.topMargin), Integer.valueOf(leftRightMargin));
        AppBrandDesktopView appBrandDesktopView = this.iWw;
        appBrandDesktopView.setPadding(leftRightMargin, appBrandDesktopView.getPaddingTop(), leftRightMargin, 0);
        addView(this.iWw, layoutParams);
        this.iWd = new GyroView(context);
        layoutParams = new LayoutParams((int) getResources().getDimension(R.dimen.a2x), (int) getResources().getDimension(R.dimen.a2w));
        layoutParams.gravity = 81;
        this.iWd.setId(R.id.bj);
        addView(this.iWd, layoutParams);
        AppMethodBeat.o(133719);
    }

    public final void aPi() {
        AppMethodBeat.i(133720);
        if (this.iWw != null) {
            this.iWw.setPadding(this.iWw.getLeftRightMargin(), this.iWw.getPaddingTop(), this.iWw.getLeftRightMargin(), 0);
        }
        AppMethodBeat.o(133720);
    }

    private int getStatusbarHeight() {
        AppMethodBeat.i(133721);
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i = 0;
        if (identifier > 0) {
            i = getResources().getDimensionPixelSize(identifier);
        }
        AppMethodBeat.o(133721);
        return i;
    }

    public final boolean isFullScreen() {
        return true;
    }

    public Rect getBackUpFooterRect() {
        return this.iWy;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(133722);
        if (this.iWv != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            this.iWv.onTouch(view, motionEvent);
        }
        AppMethodBeat.o(133722);
        return false;
    }

    public a getHeaderView() {
        return null;
    }

    public View getEmptyView() {
        return null;
    }

    public GyroView getGyroView() {
        return this.iWd;
    }

    public View getMaskView() {
        return this.iWz;
    }

    public final void a(Configuration configuration) {
        AppMethodBeat.i(133723);
        super.a(configuration);
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", Integer.valueOf(appBrandDesktopView.ivr), Integer.valueOf(configuration.orientation));
            if (appBrandDesktopView.iVo != null) {
                appBrandDesktopView.iXp = appBrandDesktopView.iVo.getMeasuredHeight();
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", Integer.valueOf(appBrandDesktopView.iXp));
            }
            if (appBrandDesktopView.ivr != configuration.orientation) {
                appBrandDesktopView.ivr = configuration.orientation;
                if (appBrandDesktopView.iVo != null && appBrandDesktopView.iVo.aOV()) {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
                    appBrandDesktopView.iVo.j(0, 0);
                }
                if (appBrandDesktopView.iVo != null) {
                    appBrandDesktopView.iVo.a(configuration);
                }
            }
        }
        AppMethodBeat.o(133723);
    }

    public final boolean aOV() {
        AppMethodBeat.i(133724);
        if (this.iWv != null) {
            boolean aOV = this.iWv.aOV();
            AppMethodBeat.o(133724);
            return aOV;
        }
        AppMethodBeat.o(133724);
        return false;
    }

    public final void j(long j, int i) {
        AppMethodBeat.i(133725);
        super.j(j, i);
        if (this.iWv != null) {
            this.iWv.c(j, i, false);
        }
        AppMethodBeat.o(133725);
    }

    public final void k(long j, int i) {
        AppMethodBeat.i(133726);
        super.k(j, i);
        if (this.iWv != null) {
            this.iWv.c(j, i, true);
        }
        AppMethodBeat.o(133726);
    }

    public final void e(View view, View view2) {
        AppMethodBeat.i(133727);
        this.iVw = (DynamicBackgroundGLSurfaceView) view;
        this.iWx = (GradientColorBackgroundView) view2;
        if (this.iWv != null) {
            this.iWv.e(view, view2);
        }
        AppMethodBeat.o(133727);
    }

    public void setDynamicBackgroundView(View view) {
        AppMethodBeat.i(133728);
        this.iVw = (DynamicBackgroundGLSurfaceView) view;
        if (this.iWv != null) {
            this.iWv.e(this.iVw, this.iWx);
        }
        AppMethodBeat.o(133728);
    }

    public final void onResume() {
        AppMethodBeat.i(133729);
        super.onResume();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
            appBrandDesktopView.isPaused = false;
            if (appBrandDesktopView.anv) {
                ab.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
                appBrandDesktopView.setLayoutFrozen(false);
            }
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b", Boolean.valueOf(appBrandDesktopView.iXF), Boolean.valueOf(appBrandDesktopView.iXJ));
            if (appBrandDesktopView.iXF && appBrandDesktopView.iXJ) {
                if (b.aPe() && appBrandDesktopView.iVo != null && appBrandDesktopView.iVo.aOV()) {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
                    ((View) appBrandDesktopView.iVo.getParent()).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(R.color.a3p));
                    View backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGradientView();
                    if (backgroundGradientView != null) {
                        backgroundGradientView.setVisibility(0);
                    }
                    View backgroundGLSurfaceView = appBrandDesktopView.iVo.getBackgroundGLSurfaceView();
                    if (backgroundGLSurfaceView instanceof DynamicBackgroundGLSurfaceView) {
                        backgroundGLSurfaceView.setVisibility(0);
                        if (appBrandDesktopView.iXO) {
                            ((DynamicBackgroundGLSurfaceView) backgroundGLSurfaceView).onResume();
                            appBrandDesktopView.iXO = false;
                        }
                        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
                        appBrandDesktopView.postDelayed(new AnonymousClass2(backgroundGLSurfaceView), 100);
                    }
                }
                appBrandDesktopView.iXI = true;
                appBrandDesktopView.iXJ = true;
            }
            appBrandDesktopView.aPp();
        }
        AppMethodBeat.o(133729);
    }

    public final void onPause() {
        AppMethodBeat.i(133730);
        super.onPause();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            appBrandDesktopView.isPaused = true;
            appBrandDesktopView.iXH = false;
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", Boolean.valueOf(appBrandDesktopView.iXF), Boolean.valueOf(appBrandDesktopView.iXI), Boolean.valueOf(appBrandDesktopView.iXH));
            if (appBrandDesktopView.iXF && appBrandDesktopView.iXI) {
                appBrandDesktopView.iXJ = true;
                ViewParent parent;
                View backgroundGradientView;
                if (appBrandDesktopView.iXH) {
                    appBrandDesktopView.iXO = false;
                    if (appBrandDesktopView.iVo != null && b.aPe()) {
                        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
                        parent = appBrandDesktopView.iVo.getParent();
                        if (parent instanceof View) {
                            ((View) parent).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(R.color.a3p));
                        }
                        backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGradientView();
                        if (backgroundGradientView != null) {
                            backgroundGradientView.setAlpha(1.0f);
                            backgroundGradientView.setVisibility(0);
                        }
                        if (appBrandDesktopView.iVo != null) {
                            backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGLSurfaceView();
                            if (!(backgroundGradientView == null || appBrandDesktopView.iXl == null)) {
                                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
                                appBrandDesktopView.iXl.removeView(backgroundGradientView);
                            }
                        }
                        appBrandDesktopView.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(133838);
                                AppBrandDesktopView.v(AppBrandDesktopView.this);
                                AppMethodBeat.o(133838);
                            }
                        }, 200);
                    }
                } else if (appBrandDesktopView.iVo != null && b.aPe()) {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
                    parent = appBrandDesktopView.iVo.getParent();
                    if (parent instanceof View) {
                        ((View) parent).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(R.color.a3p));
                    }
                    backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGradientView();
                    if (backgroundGradientView != null) {
                        backgroundGradientView.setVisibility(0);
                        backgroundGradientView.setAlpha(1.0f);
                    }
                    View backgroundGLSurfaceView = appBrandDesktopView.iVo.getBackgroundGLSurfaceView();
                    if (backgroundGLSurfaceView instanceof DynamicBackgroundGLSurfaceView) {
                        ((DynamicBackgroundGLSurfaceView) backgroundGLSurfaceView).setShowGradientView(true);
                        ((DynamicBackgroundGLSurfaceView) backgroundGLSurfaceView).iZQ.onPause();
                        appBrandDesktopView.iXO = true;
                    }
                    AppMethodBeat.o(133730);
                    return;
                }
            }
        }
        AppMethodBeat.o(133730);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133731);
        super.onDestroy();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", Integer.valueOf(appBrandDesktopView.hashCode()));
            try {
                if (appBrandDesktopView.iXm != null) {
                    RecentAppBrandViewContainer recentAppBrandViewContainer = appBrandDesktopView.iXm;
                    if (recentAppBrandViewContainer.iYR != null) {
                        recentAppBrandViewContainer.removeCallbacks(recentAppBrandViewContainer.iYR);
                    }
                }
                if (appBrandDesktopView.iXt != null) {
                    appBrandDesktopView.removeCallbacks(appBrandDesktopView.iXt);
                    appBrandDesktopView.iXt = null;
                }
                if (appBrandDesktopView.iXu != null) {
                    appBrandDesktopView.removeCallbacks(appBrandDesktopView.iXu);
                    appBrandDesktopView.iXu = null;
                }
                if (appBrandDesktopView.iXL != null) {
                    ((af) g.K(af.class)).d(appBrandDesktopView.iXL);
                }
                if (appBrandDesktopView.iXM != null) {
                    ((ag) g.K(ag.class)).d(appBrandDesktopView.iXM);
                }
                appBrandDesktopView.iXN = false;
                AppMethodBeat.o(133731);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo onDestroy exception", new Object[0]);
            }
        }
        AppMethodBeat.o(133731);
    }

    public View getBackgroundGLSurfaceView() {
        return this.iVw;
    }

    public View getBackgroundGradientView() {
        return this.iWx;
    }

    public int getExtraBottomHeight() {
        return this.iWD;
    }
}
