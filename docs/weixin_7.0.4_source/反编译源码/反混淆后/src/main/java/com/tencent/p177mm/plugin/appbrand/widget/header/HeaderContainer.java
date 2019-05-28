package com.tencent.p177mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer */
public abstract class HeaderContainer extends FrameLayout {
    public abstract boolean aOV();

    public abstract void aPi();

    /* renamed from: e */
    public abstract void mo54109e(View view, View view2);

    public abstract Rect getBackUpFooterRect();

    public abstract View getBackgroundGLSurfaceView();

    public abstract View getBackgroundGradientView();

    public abstract View getEmptyView();

    public abstract int getExtraBottomHeight();

    public abstract GyroView getGyroView();

    public abstract C45717a getHeaderView();

    public abstract View getMaskView();

    public abstract void setActivity(MMFragmentActivity mMFragmentActivity);

    public abstract void setAnimController(C10985b c10985b);

    public abstract void setDynamicBackgroundView(View view);

    public abstract void setExtraBottomHeight(int i);

    public abstract void setFixedHeight(boolean z);

    public HeaderContainer(Context context) {
        super(context);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFullScreen() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    /* renamed from: j */
    public void mo54119j(long j, int i) {
    }

    /* renamed from: k */
    public void mo54120k(long j, int i) {
    }

    /* renamed from: a */
    public void mo54106a(Configuration configuration) {
    }
}
