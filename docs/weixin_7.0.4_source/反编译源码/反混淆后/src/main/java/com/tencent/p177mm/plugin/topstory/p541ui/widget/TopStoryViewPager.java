package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.content.Context;
import android.support.p057v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager */
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
        AppMethodBeat.m2504i(2268);
        if (this.canScroll) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(2268);
            return onTouchEvent;
        }
        AppMethodBeat.m2505o(2268);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(2269);
        if (this.canScroll) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(2269);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.m2505o(2269);
        return false;
    }
}
