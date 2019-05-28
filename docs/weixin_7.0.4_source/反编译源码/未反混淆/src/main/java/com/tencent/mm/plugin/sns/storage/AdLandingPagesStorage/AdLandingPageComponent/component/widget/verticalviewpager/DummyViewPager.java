package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a;
import java.io.Serializable;

public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int rcT;

    public DummyViewPager(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        AppMethodBeat.i(37594);
        a aVar = new a();
        if (VERSION.SDK_INT >= 11) {
            if (true != (this.mPageTransformer != null)) {
                z = true;
            }
            this.mPageTransformer = aVar;
            setChildrenDrawingOrderEnabledCompat(true);
            this.mDrawingOrder = 1;
            if (z) {
                populate();
            }
        }
        setOnPageChangeListener(new f() {
            public final void onPageScrollStateChanged(int i) {
                AppMethodBeat.i(37593);
                super.onPageScrollStateChanged(i);
                if (i == 0) {
                    DummyViewPager.this.rcT = DummyViewPager.this.getScrollX();
                }
                AppMethodBeat.o(37593);
            }
        });
        AppMethodBeat.o(37594);
    }

    public int getBaseScrollX() {
        return this.rcT;
    }

    public void setBaseScrollX(int i) {
        this.rcT = i;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
