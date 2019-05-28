package com.tencent.p177mm.p612ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.n */
public final class C24053n implements Runnable {
    /* renamed from: Ej */
    public ListView f4440Ej;
    public int mMode;
    public long zGO = System.currentTimeMillis();
    public int zGP;
    public int zGQ;
    public int zGR;
    private final int zGS;
    public int zGT;

    public C24053n(ListView listView) {
        AppMethodBeat.m2504i(107753);
        this.f4440Ej = listView;
        this.zGS = ViewConfiguration.get(this.f4440Ej.getContext()).getScaledFadingEdgeLength();
        C4990ab.m7411d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.zGS));
        AppMethodBeat.m2505o(107753);
    }

    public final void run() {
        AppMethodBeat.m2504i(107754);
        if (System.currentTimeMillis() - this.zGO > 10000) {
            AppMethodBeat.m2505o(107754);
            return;
        }
        int height = this.f4440Ej.getHeight();
        int firstVisiblePosition = this.f4440Ej.getFirstVisiblePosition();
        int childCount;
        switch (this.mMode) {
            case 1:
                childCount = this.f4440Ej.getChildCount() - 1;
                firstVisiblePosition += childCount;
                if (childCount < 0) {
                    AppMethodBeat.m2505o(107754);
                    return;
                }
                if (firstVisiblePosition == this.zGQ) {
                    if (this.zGT > 20) {
                        this.f4440Ej.setSelection(this.zGP);
                        C4990ab.m7410d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.f4440Ej.post(this);
                        this.zGT++;
                        C4990ab.m7411d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.m2505o(107754);
                        return;
                    }
                }
                this.zGT = 0;
                View childAt = this.f4440Ej.getChildAt(childCount);
                int height2 = childAt.getHeight();
                childCount = height - childAt.getTop();
                if (firstVisiblePosition < this.f4440Ej.getCount() - 1) {
                    height = this.zGS;
                } else {
                    height = this.f4440Ej.getPaddingBottom();
                }
                this.f4440Ej.smoothScrollBy(height + (height2 - childCount), this.zGR);
                this.zGQ = firstVisiblePosition;
                if (firstVisiblePosition < this.zGP) {
                    this.f4440Ej.post(this);
                    AppMethodBeat.m2505o(107754);
                    return;
                }
                break;
            case 2:
                if (firstVisiblePosition == this.zGQ) {
                    if (this.zGT > 20) {
                        this.f4440Ej.setSelection(this.zGP);
                        C4990ab.m7410d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.f4440Ej.post(this);
                        this.zGT++;
                        C4990ab.m7411d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.m2505o(107754);
                        return;
                    }
                }
                this.zGT = 0;
                View childAt2 = this.f4440Ej.getChildAt(0);
                if (childAt2 != null) {
                    childCount = childAt2.getTop();
                    if (firstVisiblePosition > 0) {
                        height = this.zGS;
                    } else {
                        height = this.f4440Ej.getPaddingTop();
                    }
                    this.f4440Ej.smoothScrollBy(childCount - height, this.zGR);
                    this.zGQ = firstVisiblePosition;
                    if (firstVisiblePosition > this.zGP) {
                        this.f4440Ej.post(this);
                        break;
                    }
                }
                AppMethodBeat.m2505o(107754);
                return;
                break;
        }
        AppMethodBeat.m2505o(107754);
    }
}
