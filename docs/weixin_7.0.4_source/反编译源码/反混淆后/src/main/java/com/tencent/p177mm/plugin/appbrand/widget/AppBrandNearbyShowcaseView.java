package com.tencent.p177mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView */
public final class AppBrandNearbyShowcaseView extends FrameLayout {
    private int iTU = C1338a.fromDPToPix(getContext(), 19);
    /* renamed from: lz */
    private int f15039lz = C1338a.fromDPToPix(getContext(), 25);

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(93789);
        AppMethodBeat.m2505o(93789);
    }

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(93790);
        AppMethodBeat.m2505o(93790);
    }

    public final void setIconSize(int i) {
        AppMethodBeat.m2504i(93791);
        if (i > 0 && i != this.f15039lz) {
            this.f15039lz = i;
            aOA();
        }
        AppMethodBeat.m2505o(93791);
    }

    public final void setIconGap(int i) {
        AppMethodBeat.m2504i(93792);
        if (i >= 0 && this.iTU != i) {
            this.iTU = i;
            aOA();
        }
        AppMethodBeat.m2505o(93792);
    }

    private void aOA() {
        AppMethodBeat.m2504i(93793);
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i = this.f15039lz;
                layoutParams2.height = i;
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams3.gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.iTU * childCount;
            }
            requestLayout();
            invalidate();
        }
        AppMethodBeat.m2505o(93793);
    }

    public final void setIconLayerCount(int i) {
        AppMethodBeat.m2504i(93794);
        if (i >= 0 && i != getChildCount()) {
            if (i > getChildCount()) {
                int childCount = i - getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ImageView imageView = new ImageView(getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f15039lz, this.f15039lz);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i);
            }
            aOA();
        }
        AppMethodBeat.m2505o(93794);
    }

    /* renamed from: qf */
    public final ImageView mo54072qf(int i) {
        AppMethodBeat.m2504i(93795);
        ImageView imageView = (ImageView) getChildAt((getChildCount() - 1) - i);
        AppMethodBeat.m2505o(93795);
        return imageView;
    }

    /* renamed from: eO */
    public final void mo54070eO(boolean z) {
        AppMethodBeat.m2504i(93796);
        if (getChildCount() > 1) {
            int i = 200;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (z) {
                    childAt.animate().setDuration((long) i).translationX((float) ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin).start();
                } else {
                    childAt.setTranslationX((float) ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin);
                }
                i += 50;
            }
        }
        AppMethodBeat.m2505o(93796);
    }

    public final void aOB() {
        int i = 1;
        AppMethodBeat.m2504i(93797);
        if (getChildCount() > 1) {
            int i2 = 200;
            while (i < getChildCount()) {
                getChildAt(i).animate().setDuration((long) i2).translationX(0.0f).start();
                i2 += 50;
                i++;
            }
        }
        AppMethodBeat.m2505o(93797);
    }

    public final int getExpandDuration() {
        AppMethodBeat.m2504i(93798);
        if (getChildCount() <= 1) {
            AppMethodBeat.m2505o(93798);
            return 0;
        }
        int childCount = ((getChildCount() - 2) * 50) + 200;
        AppMethodBeat.m2505o(93798);
        return childCount;
    }
}
