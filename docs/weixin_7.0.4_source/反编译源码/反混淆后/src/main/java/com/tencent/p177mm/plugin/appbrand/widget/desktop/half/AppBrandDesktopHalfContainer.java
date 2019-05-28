package com.tencent.p177mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.C1097814;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b.C10986a;
import com.tencent.p177mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer */
public class AppBrandDesktopHalfContainer extends HeaderContainer implements OnTouchListener, C10986a {
    /* renamed from: Ek */
    private View f17559Ek;
    private GyroView iWd;
    private C10985b iWv;
    private Rect iWy = new Rect();
    private AppBrandDesktopHalfView jan;

    public AppBrandDesktopHalfContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134115);
        init(context);
        AppMethodBeat.m2505o(134115);
    }

    public AppBrandDesktopHalfContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(134116);
        init(context);
        AppMethodBeat.m2505o(134116);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(134117);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(134117);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(134118);
        this.jan = new AppBrandDesktopHalfView(context);
        this.jan.setId(2131820554);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.jan.setLayoutParams(layoutParams);
        this.f17559Ek = this.jan.findViewById(2131821164);
        addView(this.jan);
        m81411do(context);
        AppMethodBeat.m2505o(134118);
    }

    public C45717a getHeaderView() {
        return this.jan;
    }

    public View getEmptyView() {
        return this.f17559Ek;
    }

    public GyroView getGyroView() {
        return this.iWd;
    }

    public View getMaskView() {
        return null;
    }

    /* renamed from: do */
    private void m81411do(Context context) {
        AppMethodBeat.m2504i(134119);
        this.iWd = new GyroView(context);
        LayoutParams layoutParams = new LayoutParams((int) getResources().getDimension(C25738R.dimen.a2x), (int) getResources().getDimension(C25738R.dimen.a2w));
        layoutParams.gravity = 81;
        this.iWd.setId(2131820627);
        this.iWd.setVisibility(8);
        addView(this.iWd, layoutParams);
        AppMethodBeat.m2505o(134119);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void setAnimController(C10985b c10985b) {
        AppMethodBeat.m2504i(134120);
        this.iWv = c10985b;
        if (this.iWv != null) {
            this.iWv.mo22616a(this);
        }
        AppMethodBeat.m2505o(134120);
    }

    public void setFixedHeight(boolean z) {
    }

    public Rect getBackUpFooterRect() {
        return this.iWy;
    }

    public final boolean isFullScreen() {
        if (this.jan != null) {
        }
        return false;
    }

    public final void aPs() {
    }

    /* renamed from: qj */
    public final void mo22635qj(int i) {
        AppMethodBeat.m2504i(134121);
        if (this.jan != null) {
            this.jan.mo22635qj(i);
        }
        AppMethodBeat.m2505o(134121);
    }

    /* renamed from: qk */
    public final void mo22636qk(int i) {
        AppMethodBeat.m2504i(134122);
        mo22635qj(i);
        AppMethodBeat.m2505o(134122);
    }

    public final void aPt() {
    }

    public final void onResume() {
        AppMethodBeat.m2504i(134123);
        super.onResume();
        if (this.jan != null) {
            AppBrandDesktopHalfView appBrandDesktopHalfView = this.jan;
            appBrandDesktopHalfView.cAY = false;
            appBrandDesktopHalfView.setLayoutFrozen(false);
            appBrandDesktopHalfView.postDelayed(new C1097814(), 10);
        }
        AppMethodBeat.m2505o(134123);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(134124);
        super.onPause();
        if (this.jan != null) {
            this.jan.cAY = true;
        }
        AppMethodBeat.m2505o(134124);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
    }

    /* renamed from: e */
    public final void mo54109e(View view, View view2) {
    }

    public void setDynamicBackgroundView(View view) {
    }

    public View getBackgroundGradientView() {
        return null;
    }

    public View getBackgroundGLSurfaceView() {
        return null;
    }

    public final boolean aOV() {
        return false;
    }

    public final void aPi() {
    }

    public void setExtraBottomHeight(int i) {
    }

    public int getExtraBottomHeight() {
        return 0;
    }
}
