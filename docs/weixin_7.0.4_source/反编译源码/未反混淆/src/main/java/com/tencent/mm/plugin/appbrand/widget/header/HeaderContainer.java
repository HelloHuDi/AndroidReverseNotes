package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.ui.MMFragmentActivity;

public abstract class HeaderContainer extends FrameLayout {
    public abstract boolean aOV();

    public abstract void aPi();

    public abstract void e(View view, View view2);

    public abstract Rect getBackUpFooterRect();

    public abstract View getBackgroundGLSurfaceView();

    public abstract View getBackgroundGradientView();

    public abstract View getEmptyView();

    public abstract int getExtraBottomHeight();

    public abstract GyroView getGyroView();

    public abstract a getHeaderView();

    public abstract View getMaskView();

    public abstract void setActivity(MMFragmentActivity mMFragmentActivity);

    public abstract void setAnimController(b bVar);

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

    public void j(long j, int i) {
    }

    public void k(long j, int i) {
    }

    public void a(Configuration configuration) {
    }
}
