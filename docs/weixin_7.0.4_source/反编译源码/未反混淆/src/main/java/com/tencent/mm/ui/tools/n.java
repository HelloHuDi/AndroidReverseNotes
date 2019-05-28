package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class n implements Runnable {
    public ListView Ej;
    public int mMode;
    public long zGO = System.currentTimeMillis();
    public int zGP;
    public int zGQ;
    public int zGR;
    private final int zGS;
    public int zGT;

    public n(ListView listView) {
        AppMethodBeat.i(107753);
        this.Ej = listView;
        this.zGS = ViewConfiguration.get(this.Ej.getContext()).getScaledFadingEdgeLength();
        ab.d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.zGS));
        AppMethodBeat.o(107753);
    }

    public final void run() {
        AppMethodBeat.i(107754);
        if (System.currentTimeMillis() - this.zGO > 10000) {
            AppMethodBeat.o(107754);
            return;
        }
        int height = this.Ej.getHeight();
        int firstVisiblePosition = this.Ej.getFirstVisiblePosition();
        int childCount;
        switch (this.mMode) {
            case 1:
                childCount = this.Ej.getChildCount() - 1;
                firstVisiblePosition += childCount;
                if (childCount < 0) {
                    AppMethodBeat.o(107754);
                    return;
                }
                if (firstVisiblePosition == this.zGQ) {
                    if (this.zGT > 20) {
                        this.Ej.setSelection(this.zGP);
                        ab.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.Ej.post(this);
                        this.zGT++;
                        ab.d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.o(107754);
                        return;
                    }
                }
                this.zGT = 0;
                View childAt = this.Ej.getChildAt(childCount);
                int height2 = childAt.getHeight();
                childCount = height - childAt.getTop();
                if (firstVisiblePosition < this.Ej.getCount() - 1) {
                    height = this.zGS;
                } else {
                    height = this.Ej.getPaddingBottom();
                }
                this.Ej.smoothScrollBy(height + (height2 - childCount), this.zGR);
                this.zGQ = firstVisiblePosition;
                if (firstVisiblePosition < this.zGP) {
                    this.Ej.post(this);
                    AppMethodBeat.o(107754);
                    return;
                }
                break;
            case 2:
                if (firstVisiblePosition == this.zGQ) {
                    if (this.zGT > 20) {
                        this.Ej.setSelection(this.zGP);
                        ab.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.Ej.post(this);
                        this.zGT++;
                        ab.d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.o(107754);
                        return;
                    }
                }
                this.zGT = 0;
                View childAt2 = this.Ej.getChildAt(0);
                if (childAt2 != null) {
                    childCount = childAt2.getTop();
                    if (firstVisiblePosition > 0) {
                        height = this.zGS;
                    } else {
                        height = this.Ej.getPaddingTop();
                    }
                    this.Ej.smoothScrollBy(childCount - height, this.zGR);
                    this.zGQ = firstVisiblePosition;
                    if (firstVisiblePosition > this.zGP) {
                        this.Ej.post(this);
                        break;
                    }
                }
                AppMethodBeat.o(107754);
                return;
                break;
        }
        AppMethodBeat.o(107754);
    }
}
