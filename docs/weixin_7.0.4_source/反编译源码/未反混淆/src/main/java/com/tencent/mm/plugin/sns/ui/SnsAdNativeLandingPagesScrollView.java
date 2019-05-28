package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    private int rnF = 0;
    private int rnG = 0;
    private int rnH = 50;
    private am rnI = null;
    private long rnJ = System.currentTimeMillis();
    private Runnable rnK = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38613);
            int scrollY = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            ab.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rnG), Integer.valueOf(scrollY));
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
            ab.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rnG), Integer.valueOf(scrollY));
            SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.this.rnK, (long) SnsAdNativeLandingPagesScrollView.this.rnH);
            AppMethodBeat.o(38613);
        }
    };

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38614);
        AppMethodBeat.o(38614);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38615);
        AppMethodBeat.o(38615);
    }

    public void setScrollViewListener(am amVar) {
        this.rnI = amVar;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38616);
        super.onScrollChanged(i, i2, i3, i4);
        ab.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(38616);
    }

    public void scrollTo(int i, int i2) {
        AppMethodBeat.i(38617);
        super.scrollTo(i, i2);
        AppMethodBeat.o(38617);
    }

    public void scrollBy(int i, int i2) {
        AppMethodBeat.i(38618);
        super.scrollBy(i, i2);
        AppMethodBeat.o(38618);
    }

    public final void fling(int i) {
        AppMethodBeat.i(38619);
        super.fling(i / 3);
        AppMethodBeat.o(38619);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38620);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(38620);
        return onInterceptTouchEvent;
    }
}
