package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.p057v4.view.C0477s;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.C13450b;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b */
public final class C21963b implements OnTouchListener {
    private float hkf = Float.MIN_VALUE;
    private DummyViewPager rcV;
    private float rcW = Float.MIN_VALUE;

    public C21963b(DummyViewPager dummyViewPager) {
        this.rcV = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(37595);
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.rcW).append(",downY ").append(this.hkf);
        switch (motionEvent.getAction()) {
            case 0:
                this.hkf = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.rcV.mFakeDragging) {
                    try {
                        DummyViewPager dummyViewPager = this.rcV;
                        if (dummyViewPager.mFakeDragging) {
                            VelocityTracker velocityTracker = dummyViewPager.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) dummyViewPager.mMaximumVelocity);
                            int xVelocity = (int) velocityTracker.getXVelocity(dummyViewPager.mActivePointerId);
                            dummyViewPager.mPopulatePending = true;
                            int clientWidth = dummyViewPager.getClientWidth();
                            int scrollX = dummyViewPager.getScrollX();
                            C13450b cpZ = dummyViewPager.cpZ();
                            dummyViewPager.setCurrentItemInternal(dummyViewPager.determineTargetPage(cpZ.position, ((((float) scrollX) / ((float) clientWidth)) - cpZ.offset) / cpZ.widthFactor, xVelocity, (int) (dummyViewPager.mLastMotionX - dummyViewPager.mInitialMotionX)), true, true, xVelocity);
                            dummyViewPager.endDrag();
                            dummyViewPager.mFakeDragging = false;
                        } else {
                            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                            AppMethodBeat.m2505o(37595);
                            throw illegalStateException;
                        }
                    } catch (Exception e) {
                    }
                }
                this.hkf = Float.MIN_VALUE;
                this.rcW = Float.MIN_VALUE;
                break;
            case 2:
                if (this.hkf == Float.MIN_VALUE && this.rcW == Float.MIN_VALUE) {
                    this.hkf = motionEvent.getRawY();
                    break;
                }
                float rawY = motionEvent.getRawY() - (this.rcW == Float.MIN_VALUE ? this.hkf : this.rcW);
                this.rcW = motionEvent.getRawY();
                float f = rawY / 2.0f;
                new StringBuilder("scrollX ").append(this.rcV.getScrollX()).append(",basescrollX ").append(this.rcV.getBaseScrollX());
                if (this.rcV.getScrollX() == this.rcV.getBaseScrollX()) {
                    if (C0477s.m948n(view, (-f) > 0.0f ? 1 : -1)) {
                        new StringBuilder("scroll vertically  ").append(f).append(", move.lastMotionY ").append(motionEvent.getY());
                        break;
                    }
                    DummyViewPager dummyViewPager2 = this.rcV;
                    if (!dummyViewPager2.mIsBeingDragged) {
                        dummyViewPager2.mFakeDragging = true;
                        dummyViewPager2.setScrollState(1);
                        dummyViewPager2.mLastMotionX = 0.0f;
                        dummyViewPager2.mInitialMotionX = 0.0f;
                        if (dummyViewPager2.mVelocityTracker == null) {
                            dummyViewPager2.mVelocityTracker = VelocityTracker.obtain();
                        } else {
                            dummyViewPager2.mVelocityTracker.clear();
                        }
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                        dummyViewPager2.mVelocityTracker.addMovement(obtain);
                        obtain.recycle();
                        dummyViewPager2.mFakeDragBeginTime = uptimeMillis;
                    }
                    m33605a(view, motionEvent, f);
                    C21963b.m33606c(view, motionEvent);
                    AppMethodBeat.m2505o(37595);
                    return false;
                } else if (m33605a(view, motionEvent, f)) {
                    AppMethodBeat.m2505o(37595);
                    return false;
                }
                break;
        }
        boolean onTouchEvent = view.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(37595);
        return onTouchEvent;
    }

    /* renamed from: a */
    private boolean m33605a(View view, MotionEvent motionEvent, float f) {
        AppMethodBeat.m2504i(37596);
        if (this.rcV.mFakeDragging) {
            float scrollX;
            if (C21963b.m33604Z((float) (((int) (((float) this.rcV.getScrollX()) - f)) - this.rcV.getBaseScrollX()), (float) (this.rcV.getScrollX() - this.rcV.getBaseScrollX()))) {
                scrollX = (float) (this.rcV.getScrollX() - this.rcV.getBaseScrollX());
            } else {
                scrollX = f;
            }
            this.rcV.fakeDragBy(scrollX);
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.rcV.getScrollX());
            C21963b.m33606c(view, motionEvent);
            AppMethodBeat.m2505o(37596);
            return true;
        }
        AppMethodBeat.m2505o(37596);
        return false;
    }

    /* renamed from: c */
    private static void m33606c(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(37597);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
        AppMethodBeat.m2505o(37597);
    }

    /* renamed from: Z */
    private static boolean m33604Z(float f, float f2) {
        AppMethodBeat.m2504i(37598);
        if (Math.abs(f + f2) < Math.abs(f - f2)) {
            AppMethodBeat.m2505o(37598);
            return true;
        }
        AppMethodBeat.m2505o(37598);
        return false;
    }
}
