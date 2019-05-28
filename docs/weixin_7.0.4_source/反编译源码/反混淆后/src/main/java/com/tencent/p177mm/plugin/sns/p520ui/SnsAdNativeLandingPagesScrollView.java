package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.support.p057v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView */
public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    private int rnF = 0;
    private int rnG = 0;
    private int rnH = 50;
    private C43591am rnI = null;
    private long rnJ = System.currentTimeMillis();
    private Runnable rnK = new C220001();

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView$1 */
    class C220001 implements Runnable {
        C220001() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38613);
            int scrollY = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            C4990ab.m7421w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rnG), Integer.valueOf(scrollY));
            if (scrollY != SnsAdNativeLandingPagesScrollView.this.rnG) {
                if (SnsAdNativeLandingPagesScrollView.this.rnI != null) {
                    SnsAdNativeLandingPagesScrollView.this.rnI;
                    SnsAdNativeLandingPagesScrollView.this.rnF;
                }
                SnsAdNativeLandingPagesScrollView.this.rnJ = System.currentTimeMillis();
            }
            if (SnsAdNativeLandingPagesScrollView.this.rnG - scrollY == 0) {
                if (SnsAdNativeLandingPagesScrollView.this.rnI != null) {
                    SnsAdNativeLandingPagesScrollView.this.rnI;
                    SnsAdNativeLandingPagesScrollView.this.rnG;
                    SnsAdNativeLandingPagesScrollView.this.rnF;
                }
                SnsAdNativeLandingPagesScrollView.this.rnF = SnsAdNativeLandingPagesScrollView.this.rnG;
            }
            SnsAdNativeLandingPagesScrollView.this.rnG = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            C4990ab.m7421w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rnG), Integer.valueOf(scrollY));
            SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.this.rnK, (long) SnsAdNativeLandingPagesScrollView.this.rnH);
            AppMethodBeat.m2505o(38613);
        }
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38614);
        AppMethodBeat.m2505o(38614);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38615);
        AppMethodBeat.m2505o(38615);
    }

    public void setScrollViewListener(C43591am c43591am) {
        this.rnI = c43591am;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38616);
        super.onScrollChanged(i, i2, i3, i4);
        C4990ab.m7421w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(38616);
    }

    public void scrollTo(int i, int i2) {
        AppMethodBeat.m2504i(38617);
        super.scrollTo(i, i2);
        AppMethodBeat.m2505o(38617);
    }

    public void scrollBy(int i, int i2) {
        AppMethodBeat.m2504i(38618);
        super.scrollBy(i, i2);
        AppMethodBeat.m2505o(38618);
    }

    public final void fling(int i) {
        AppMethodBeat.m2504i(38619);
        super.fling(i / 3);
        AppMethodBeat.m2505o(38619);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(38620);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(38620);
        return onInterceptTouchEvent;
    }
}
