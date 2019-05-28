package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.b;
import com.tencent.mm.plugin.appbrand.widget.header.b.a;
import com.tencent.mm.ui.MMFragmentActivity;

public class AppBrandDesktopHalfContainer extends HeaderContainer implements OnTouchListener, a {
    private View Ek;
    private GyroView iWd;
    private b iWv;
    private Rect iWy = new Rect();
    private AppBrandDesktopHalfView jan;

    public AppBrandDesktopHalfContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134115);
        init(context);
        AppMethodBeat.o(134115);
    }

    public AppBrandDesktopHalfContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(134116);
        init(context);
        AppMethodBeat.o(134116);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(134117);
        super.onMeasure(i, i2);
        AppMethodBeat.o(134117);
    }

    private void init(Context context) {
        AppMethodBeat.i(134118);
        this.jan = new AppBrandDesktopHalfView(context);
        this.jan.setId(R.id.k);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.jan.setLayoutParams(layoutParams);
        this.Ek = this.jan.findViewById(R.id.q2);
        addView(this.jan);
        m23do(context);
        AppMethodBeat.o(134118);
    }

    public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView() {
        return this.jan;
    }

    public View getEmptyView() {
        return this.Ek;
    }

    public GyroView getGyroView() {
        return this.iWd;
    }

    public View getMaskView() {
        return null;
    }

    /* renamed from: do */
    private void m23do(Context context) {
        AppMethodBeat.i(134119);
        this.iWd = new GyroView(context);
        LayoutParams layoutParams = new LayoutParams((int) getResources().getDimension(R.dimen.a2x), (int) getResources().getDimension(R.dimen.a2w));
        layoutParams.gravity = 81;
        this.iWd.setId(R.id.bj);
        this.iWd.setVisibility(8);
        addView(this.iWd, layoutParams);
        AppMethodBeat.o(134119);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void setAnimController(b bVar) {
        AppMethodBeat.i(134120);
        this.iWv = bVar;
        if (this.iWv != null) {
            this.iWv.a(this);
        }
        AppMethodBeat.o(134120);
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

    public final void qj(int i) {
        AppMethodBeat.i(134121);
        if (this.jan != null) {
            this.jan.qj(i);
        }
        AppMethodBeat.o(134121);
    }

    public final void qk(int i) {
        AppMethodBeat.i(134122);
        qj(i);
        AppMethodBeat.o(134122);
    }

    public final void aPt() {
    }

    public final void onResume() {
        AppMethodBeat.i(134123);
        super.onResume();
        if (this.jan != null) {
            AppBrandDesktopHalfView appBrandDesktopHalfView = this.jan;
            appBrandDesktopHalfView.cAY = false;
            appBrandDesktopHalfView.setLayoutFrozen(false);
            appBrandDesktopHalfView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(134174);
                    AppBrandDesktopHalfView.o(AppBrandDesktopHalfView.this);
                    AppMethodBeat.o(134174);
                }
            }, 10);
        }
        AppMethodBeat.o(134123);
    }

    public final void onPause() {
        AppMethodBeat.i(134124);
        super.onPause();
        if (this.jan != null) {
            this.jan.cAY = true;
        }
        AppMethodBeat.o(134124);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
    }

    public final void e(View view, View view2) {
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
