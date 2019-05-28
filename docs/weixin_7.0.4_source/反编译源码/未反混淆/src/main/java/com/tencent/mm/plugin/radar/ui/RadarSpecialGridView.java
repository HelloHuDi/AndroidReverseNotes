package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0014J\u0006\u0010\"\u001a\u00020\u001aR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mOldChildHeight", "", "mOldChildWidth", "mTable", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "getMTable", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "setMTable", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;)V", "computeScrollX", "computeScrollY", "initGridView", "", "onLayout", "changed", "", "l", "t", "r", "b", "reset", "OnItemClickListener", "plugin-radar_release"})
public final class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    private a pCH;
    public RadarSpecialTableLayout pCI;
    private int pCJ;
    private int pCK;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
    public interface a {
        void f(int i, View view);
    }

    public final a getOnItemClickListener() {
        return this.pCH;
    }

    public final void setOnItemClickListener(a aVar) {
        this.pCH = aVar;
    }

    public final RadarSpecialTableLayout getMTable() {
        AppMethodBeat.i(103004);
        RadarSpecialTableLayout radarSpecialTableLayout = this.pCI;
        if (radarSpecialTableLayout == null) {
            j.avw("mTable");
        }
        AppMethodBeat.o(103004);
        return radarSpecialTableLayout;
    }

    public final void setMTable(RadarSpecialTableLayout radarSpecialTableLayout) {
        AppMethodBeat.i(103005);
        j.p(radarSpecialTableLayout, "<set-?>");
        this.pCI = radarSpecialTableLayout;
        AppMethodBeat.o(103005);
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(103007);
        Context context2 = getContext();
        j.o(context2, "context");
        this.pCI = new RadarSpecialTableLayout(context2);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        RadarSpecialTableLayout radarSpecialTableLayout = this.pCI;
        if (radarSpecialTableLayout == null) {
            j.avw("mTable");
        }
        radarSpecialTableLayout.setLayoutParams(layoutParams);
        RadarSpecialTableLayout radarSpecialTableLayout2 = this.pCI;
        if (radarSpecialTableLayout2 == null) {
            j.avw("mTable");
        }
        radarSpecialTableLayout2.setStretchAllColumns(true);
        radarSpecialTableLayout2 = this.pCI;
        if (radarSpecialTableLayout2 == null) {
            j.avw("mTable");
        }
        radarSpecialTableLayout2.setShrinkAllColumns(true);
        radarSpecialTableLayout2 = this.pCI;
        if (radarSpecialTableLayout2 == null) {
            j.avw("mTable");
        }
        radarSpecialTableLayout2.setGravity(80);
        radarSpecialTableLayout2 = this.pCI;
        if (radarSpecialTableLayout2 == null) {
            j.avw("mTable");
        }
        addView(radarSpecialTableLayout2);
        AppMethodBeat.o(103007);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int scrollX;
        int i5 = 0;
        AppMethodBeat.i(103006);
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            scrollX = getScrollX();
            j.o(childAt, "child");
            scrollX = (scrollX + childAt.getWidth()) - this.pCK;
            this.pCK = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            View childAt2 = getChildAt(0);
            int scrollY = getScrollY();
            j.o(childAt2, "child");
            scrollY = (scrollY + childAt2.getHeight()) - this.pCJ;
            this.pCJ = childAt2.getHeight();
            if (scrollY > 0) {
                i5 = scrollY;
            }
        } else {
            i5 = getScrollY();
        }
        scrollTo(scrollX, i5);
        AppMethodBeat.o(103006);
    }
}
