package com.tencent.p177mm.plugin.appbrand.widget.desktop;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C198142;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C1982611;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.C38583b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer */
public class AppBrandDesktopContainer extends HeaderContainer implements OnTouchListener {
    private DynamicBackgroundGLSurfaceView iVw;
    private MMFragmentActivity iWA;
    private boolean iWB = true;
    private int iWC = 0;
    private int iWD = 0;
    private GyroView iWd;
    private C10985b iWv;
    private AppBrandDesktopView iWw;
    private GradientColorBackgroundView iWx;
    private Rect iWy = new Rect();
    private View iWz;

    public AppBrandDesktopContainer(Context context) {
        super(context);
        AppMethodBeat.m2504i(133713);
        init(context);
        AppMethodBeat.m2505o(133713);
    }

    public AppBrandDesktopContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133714);
        init(context);
        AppMethodBeat.m2505o(133714);
    }

    public AppBrandDesktopContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133715);
        init(context);
        AppMethodBeat.m2505o(133715);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        this.iWA = mMFragmentActivity;
    }

    public void setAnimController(C10985b c10985b) {
        AppMethodBeat.m2504i(133716);
        this.iWv = c10985b;
        if (!(this.iWw == null || this.iWv == null)) {
            this.iWv.mo22616a(this.iWw);
        }
        AppMethodBeat.m2505o(133716);
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
        AppMethodBeat.m2504i(133717);
        aPh();
        C4990ab.m7419v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.iWC), Integer.valueOf(this.iWD));
        if (this.iWB) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec((((ViewGroup) getParent()).getMeasuredHeight() - this.iWC) - this.iWD, ErrorDialogData.SUPPRESSED);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, makeMeasureSpec);
        AppMethodBeat.m2505o(133717);
    }

    private void aPh() {
        AppMethodBeat.m2504i(133718);
        if (getResources().getConfiguration().orientation == 1) {
            this.iWC = getResources().getDimensionPixelSize(C25738R.dimen.a2z);
            AppMethodBeat.m2505o(133718);
            return;
        }
        this.iWC = getResources().getDimensionPixelSize(C25738R.dimen.a30);
        AppMethodBeat.m2505o(133718);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(133719);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
        aPh();
        setBackgroundColor(getResources().getColor(C25738R.color.a3p));
        C38583b c38583b = C38583b.iZg;
        C38583b.aPB();
        this.iWw = new AppBrandDesktopView(context);
        this.iWw.setHeaderContainer(this);
        this.iWw.setId(2131820554);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        int leftRightMargin = this.iWw.getLeftRightMargin();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view topMargin: %d, marginLeftRight: %d", Integer.valueOf(layoutParams.topMargin), Integer.valueOf(leftRightMargin));
        AppBrandDesktopView appBrandDesktopView = this.iWw;
        appBrandDesktopView.setPadding(leftRightMargin, appBrandDesktopView.getPaddingTop(), leftRightMargin, 0);
        addView(this.iWw, layoutParams);
        this.iWd = new GyroView(context);
        layoutParams = new LayoutParams((int) getResources().getDimension(C25738R.dimen.a2x), (int) getResources().getDimension(C25738R.dimen.a2w));
        layoutParams.gravity = 81;
        this.iWd.setId(2131820627);
        addView(this.iWd, layoutParams);
        AppMethodBeat.m2505o(133719);
    }

    public final void aPi() {
        AppMethodBeat.m2504i(133720);
        if (this.iWw != null) {
            this.iWw.setPadding(this.iWw.getLeftRightMargin(), this.iWw.getPaddingTop(), this.iWw.getLeftRightMargin(), 0);
        }
        AppMethodBeat.m2505o(133720);
    }

    private int getStatusbarHeight() {
        AppMethodBeat.m2504i(133721);
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i = 0;
        if (identifier > 0) {
            i = getResources().getDimensionPixelSize(identifier);
        }
        AppMethodBeat.m2505o(133721);
        return i;
    }

    public final boolean isFullScreen() {
        return true;
    }

    public Rect getBackUpFooterRect() {
        return this.iWy;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133722);
        if (this.iWv != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            this.iWv.onTouch(view, motionEvent);
        }
        AppMethodBeat.m2505o(133722);
        return false;
    }

    public C45717a getHeaderView() {
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

    /* renamed from: a */
    public final void mo54106a(Configuration configuration) {
        AppMethodBeat.m2504i(133723);
        super.mo54106a(configuration);
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", Integer.valueOf(appBrandDesktopView.ivr), Integer.valueOf(configuration.orientation));
            if (appBrandDesktopView.iVo != null) {
                appBrandDesktopView.iXp = appBrandDesktopView.iVo.getMeasuredHeight();
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", Integer.valueOf(appBrandDesktopView.iXp));
            }
            if (appBrandDesktopView.ivr != configuration.orientation) {
                appBrandDesktopView.ivr = configuration.orientation;
                if (appBrandDesktopView.iVo != null && appBrandDesktopView.iVo.aOV()) {
                    C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
                    appBrandDesktopView.iVo.mo54119j(0, 0);
                }
                if (appBrandDesktopView.iVo != null) {
                    appBrandDesktopView.iVo.mo54106a(configuration);
                }
            }
        }
        AppMethodBeat.m2505o(133723);
    }

    public final boolean aOV() {
        AppMethodBeat.m2504i(133724);
        if (this.iWv != null) {
            boolean aOV = this.iWv.aOV();
            AppMethodBeat.m2505o(133724);
            return aOV;
        }
        AppMethodBeat.m2505o(133724);
        return false;
    }

    /* renamed from: j */
    public final void mo54119j(long j, int i) {
        AppMethodBeat.m2504i(133725);
        super.mo54119j(j, i);
        if (this.iWv != null) {
            this.iWv.mo22620c(j, i, false);
        }
        AppMethodBeat.m2505o(133725);
    }

    /* renamed from: k */
    public final void mo54120k(long j, int i) {
        AppMethodBeat.m2504i(133726);
        super.mo54120k(j, i);
        if (this.iWv != null) {
            this.iWv.mo22620c(j, i, true);
        }
        AppMethodBeat.m2505o(133726);
    }

    /* renamed from: e */
    public final void mo54109e(View view, View view2) {
        AppMethodBeat.m2504i(133727);
        this.iVw = (DynamicBackgroundGLSurfaceView) view;
        this.iWx = (GradientColorBackgroundView) view2;
        if (this.iWv != null) {
            this.iWv.mo22622e(view, view2);
        }
        AppMethodBeat.m2505o(133727);
    }

    public void setDynamicBackgroundView(View view) {
        AppMethodBeat.m2504i(133728);
        this.iVw = (DynamicBackgroundGLSurfaceView) view;
        if (this.iWv != null) {
            this.iWv.mo22622e(this.iVw, this.iWx);
        }
        AppMethodBeat.m2505o(133728);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133729);
        super.onResume();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
            appBrandDesktopView.isPaused = false;
            if (appBrandDesktopView.anv) {
                C4990ab.m7418v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
                appBrandDesktopView.setLayoutFrozen(false);
            }
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b", Boolean.valueOf(appBrandDesktopView.iXF), Boolean.valueOf(appBrandDesktopView.iXJ));
            if (appBrandDesktopView.iXF && appBrandDesktopView.iXJ) {
                if (C2545b.aPe() && appBrandDesktopView.iVo != null && appBrandDesktopView.iVo.aOV()) {
                    C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
                    ((View) appBrandDesktopView.iVo.getParent()).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(C25738R.color.a3p));
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
                        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
                        appBrandDesktopView.postDelayed(new C198142(backgroundGLSurfaceView), 100);
                    }
                }
                appBrandDesktopView.iXI = true;
                appBrandDesktopView.iXJ = true;
            }
            appBrandDesktopView.aPp();
        }
        AppMethodBeat.m2505o(133729);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(133730);
        super.onPause();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            appBrandDesktopView.isPaused = true;
            appBrandDesktopView.iXH = false;
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", Boolean.valueOf(appBrandDesktopView.iXF), Boolean.valueOf(appBrandDesktopView.iXI), Boolean.valueOf(appBrandDesktopView.iXH));
            if (appBrandDesktopView.iXF && appBrandDesktopView.iXI) {
                appBrandDesktopView.iXJ = true;
                ViewParent parent;
                View backgroundGradientView;
                if (appBrandDesktopView.iXH) {
                    appBrandDesktopView.iXO = false;
                    if (appBrandDesktopView.iVo != null && C2545b.aPe()) {
                        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
                        parent = appBrandDesktopView.iVo.getParent();
                        if (parent instanceof View) {
                            ((View) parent).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(C25738R.color.a3p));
                        }
                        backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGradientView();
                        if (backgroundGradientView != null) {
                            backgroundGradientView.setAlpha(1.0f);
                            backgroundGradientView.setVisibility(0);
                        }
                        if (appBrandDesktopView.iVo != null) {
                            backgroundGradientView = appBrandDesktopView.iVo.getBackgroundGLSurfaceView();
                            if (!(backgroundGradientView == null || appBrandDesktopView.iXl == null)) {
                                C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
                                appBrandDesktopView.iXl.removeView(backgroundGradientView);
                            }
                        }
                        appBrandDesktopView.postDelayed(new C1982611(), 200);
                    }
                } else if (appBrandDesktopView.iVo != null && C2545b.aPe()) {
                    C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
                    parent = appBrandDesktopView.iVo.getParent();
                    if (parent instanceof View) {
                        ((View) parent).setBackgroundColor(appBrandDesktopView.mContext.getResources().getColor(C25738R.color.a3p));
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
                    AppMethodBeat.m2505o(133730);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(133730);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133731);
        super.onDestroy();
        if (this.iWw != null) {
            AppBrandDesktopView appBrandDesktopView = this.iWw;
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", Integer.valueOf(appBrandDesktopView.hashCode()));
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
                    ((C10118af) C1720g.m3528K(C10118af.class)).mo10117d(appBrandDesktopView.iXL);
                }
                if (appBrandDesktopView.iXM != null) {
                    ((C26767ag) C1720g.m3528K(C26767ag.class)).mo10117d(appBrandDesktopView.iXM);
                }
                appBrandDesktopView.iXN = false;
                AppMethodBeat.m2505o(133731);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo onDestroy exception", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(133731);
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
