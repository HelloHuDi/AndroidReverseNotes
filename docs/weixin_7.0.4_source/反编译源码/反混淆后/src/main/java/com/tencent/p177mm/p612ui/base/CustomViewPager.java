package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.mogic.WxViewPager;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.CustomViewPager */
public class CustomViewPager extends WxViewPager {
    private static final String TAG = "MicroMsg.CustomViewPager";
    private boolean mCanSlide = true;
    private boolean mCanSlideBySide = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanSlide(boolean z) {
        this.mCanSlide = z;
    }

    public void setCanSlideBySide(boolean z) {
        this.mCanSlideBySide = z;
    }

    public boolean isGutterDrag(float f, float f2) {
        AppMethodBeat.m2504i(106259);
        if (this.mCanSlideBySide) {
            boolean isGutterDrag = super.isGutterDrag(f, f2);
            AppMethodBeat.m2505o(106259);
            return isGutterDrag;
        }
        AppMethodBeat.m2505o(106259);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(106260);
        if (this.mCanSlide) {
            try {
                z = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.m2505o(106260);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "get a Exception", new Object[z]);
                AppMethodBeat.m2505o(106260);
            }
        } else {
            AppMethodBeat.m2505o(106260);
        }
        return z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(106261);
        if (this.mCanSlide) {
            try {
                z = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(106261);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "get a Exception", new Object[z]);
                AppMethodBeat.m2505o(106261);
            }
        } else {
            AppMethodBeat.m2505o(106261);
        }
        return z;
    }
}
