package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TopStoryViewPager extends ViewPager {
    private boolean canScroll = true;

    public TopStoryViewPager(Context context) {
        super(context);
    }

    public TopStoryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollEnable(boolean z) {
        this.canScroll = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(2268);
        if (this.canScroll) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(2268);
            return onTouchEvent;
        }
        AppMethodBeat.o(2268);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(2269);
        if (this.canScroll) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(2269);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(2269);
        return false;
    }
}
