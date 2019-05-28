package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.view.ViewPager.C0437f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.p1621a.C43566a;
import java.io.Serializable;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager */
public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int rcT;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager$1 */
    class C290811 extends C0437f {
        C290811() {
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(37593);
            super.onPageScrollStateChanged(i);
            if (i == 0) {
                DummyViewPager.this.rcT = DummyViewPager.this.getScrollX();
            }
            AppMethodBeat.m2505o(37593);
        }
    }

    public DummyViewPager(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        AppMethodBeat.m2504i(37594);
        C43566a c43566a = new C43566a();
        if (VERSION.SDK_INT >= 11) {
            if (true != (this.mPageTransformer != null)) {
                z = true;
            }
            this.mPageTransformer = c43566a;
            setChildrenDrawingOrderEnabledCompat(true);
            this.mDrawingOrder = 1;
            if (z) {
                populate();
            }
        }
        setOnPageChangeListener(new C290811());
        AppMethodBeat.m2505o(37594);
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
