package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements OnTouchListener {
    private float hkf = Float.MIN_VALUE;
    private DummyViewPager rcV;
    private float rcW = Float.MIN_VALUE;

    public b(DummyViewPager dummyViewPager) {
        this.rcV = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(37595);
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
                            b cpZ = dummyViewPager.cpZ();
                            dummyViewPager.setCurrentItemInternal(dummyViewPager.determineTargetPage(cpZ.position, ((((float) scrollX) / ((float) clientWidth)) - cpZ.offset) / cpZ.widthFactor, xVelocity, (int) (dummyViewPager.mLastMotionX - dummyViewPager.mInitialMotionX)), true, true, xVelocity);
                            dummyViewPager.endDrag();
                            dummyViewPager.mFakeDragging = false;
                        } else {
                            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                            AppMethodBeat.o(37595);
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
                    if (s.n(view, (-f) > 0.0f ? 1 : -1)) {
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
                    a(view, motionEvent, f);
                    c(view, motionEvent);
                    AppMethodBeat.o(37595);
                    return false;
                } else if (a(view, motionEvent, f)) {
                    AppMethodBeat.o(37595);
                    return false;
                }
                break;
        }
        boolean onTouchEvent = view.onTouchEvent(motionEvent);
        AppMethodBeat.o(37595);
        return onTouchEvent;
    }

    private boolean a(View view, MotionEvent motionEvent, float f) {
        AppMethodBeat.i(37596);
        if (this.rcV.mFakeDragging) {
            float scrollX;
            if (Z((float) (((int) (((float) this.rcV.getScrollX()) - f)) - this.rcV.getBaseScrollX()), (float) (this.rcV.getScrollX() - this.rcV.getBaseScrollX()))) {
                scrollX = (float) (this.rcV.getScrollX() - this.rcV.getBaseScrollX());
            } else {
                scrollX = f;
            }
            this.rcV.fakeDragBy(scrollX);
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.rcV.getScrollX());
            c(view, motionEvent);
            AppMethodBeat.o(37596);
            return true;
        }
        AppMethodBeat.o(37596);
        return false;
    }

    private static void c(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(37597);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
        AppMethodBeat.o(37597);
    }

    private static boolean Z(float f, float f2) {
        AppMethodBeat.i(37598);
        if (Math.abs(f + f2) < Math.abs(f - f2)) {
            AppMethodBeat.o(37598);
            return true;
        }
        AppMethodBeat.o(37598);
        return false;
    }
}
