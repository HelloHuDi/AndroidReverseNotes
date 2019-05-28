package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.ui.widget.StoryAvatarDotsView */
public final class StoryAvatarDotsView extends FrameLayout {
    private int iTU = C1338a.fromDPToPix(getContext(), 19);
    /* renamed from: lz */
    private int f2996lz = C1338a.fromDPToPix(getContext(), 25);

    public StoryAvatarDotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107965);
        AppMethodBeat.m2505o(107965);
    }

    public StoryAvatarDotsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107966);
        AppMethodBeat.m2505o(107966);
    }

    public final void setIconSize(int i) {
        AppMethodBeat.m2504i(107967);
        if (i > 0 && i != this.f2996lz) {
            this.f2996lz = i;
            aOA();
        }
        AppMethodBeat.m2505o(107967);
    }

    public final void setIconGap(int i) {
        AppMethodBeat.m2504i(107968);
        if (i >= 0 && this.iTU != i) {
            this.iTU = i;
            aOA();
        }
        AppMethodBeat.m2505o(107968);
    }

    private void aOA() {
        AppMethodBeat.m2504i(107969);
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i = this.f2996lz;
                layoutParams2.height = i;
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams3.gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.iTU * childCount;
            }
            requestLayout();
            invalidate();
        }
        AppMethodBeat.m2505o(107969);
    }

    public final void setIconLayerCount(int i) {
        AppMethodBeat.m2504i(107970);
        if (i >= 0 && i != getChildCount()) {
            if (i > getChildCount()) {
                int childCount = i - getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ImageView imageView = new ImageView(getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f2996lz, this.f2996lz);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i);
            }
            aOA();
        }
        AppMethodBeat.m2505o(107970);
    }

    /* renamed from: qf */
    public final ImageView mo28298qf(int i) {
        AppMethodBeat.m2504i(107971);
        ImageView imageView = (ImageView) getChildAt((getChildCount() - 1) - i);
        AppMethodBeat.m2505o(107971);
        return imageView;
    }

    public final int getExpandDuration() {
        AppMethodBeat.m2504i(107972);
        if (getChildCount() <= 1) {
            AppMethodBeat.m2505o(107972);
            return 0;
        }
        int childCount = ((getChildCount() - 2) * 50) + 200;
        AppMethodBeat.m2505o(107972);
        return childCount;
    }
}
