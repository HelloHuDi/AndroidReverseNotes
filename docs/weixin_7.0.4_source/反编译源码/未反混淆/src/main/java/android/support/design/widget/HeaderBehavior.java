package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private int mActivePointerId = -1;
    private boolean mIsBeingDragged;
    private int mTouchSlop = -1;
    private VelocityTracker mVelocityTracker;
    private Runnable qM;
    OverScroller qN;
    private int qO;

    class a implements Runnable {
        private final CoordinatorLayout qP;
        private final V qQ;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.qP = coordinatorLayout;
            this.qQ = v;
        }

        public final void run() {
            if (this.qQ != null && HeaderBehavior.this.qN != null) {
                if (HeaderBehavior.this.qN.computeScrollOffset()) {
                    HeaderBehavior.this.c(this.qP, this.qQ, HeaderBehavior.this.qN.getCurrY());
                    s.b(this.qQ, (Runnable) this);
                    return;
                }
                HeaderBehavior.this.a(this.qP, this.qQ);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (bA() && coordinatorLayout.d(v, x, y)) {
                    this.qO = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    cn();
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                y = this.mActivePointerId;
                if (y != -1) {
                    y = motionEvent.findPointerIndex(y);
                    if (y != -1) {
                        y = (int) motionEvent.getY(y);
                        if (Math.abs(y - this.qO) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.qO = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.d(v, (int) motionEvent.getX(), y) && bA()) {
                    this.qO = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    cn();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    int i = -c(v);
                    if (this.qM != null) {
                        v.removeCallbacks(this.qM);
                        this.qM = null;
                    }
                    if (this.qN == null) {
                        this.qN = new OverScroller(v.getContext());
                    }
                    this.qN.fling(0, bB(), 0, Math.round(yVelocity), 0, 0, i, 0);
                    if (!this.qN.computeScrollOffset()) {
                        a(coordinatorLayout, v);
                        break;
                    }
                    this.qM = new a(coordinatorLayout, v);
                    s.b((View) v, this.qM);
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.qO - findPointerIndex;
                    if (!this.mIsBeingDragged && Math.abs(i2) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        i2 = i2 > 0 ? i2 - this.mTouchSlop : i2 + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        this.qO = findPointerIndex;
                        b(coordinatorLayout, v, i2, d(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return true;
    }

    /* Access modifiers changed, original: final */
    public final int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
    }

    /* Access modifiers changed, original: 0000 */
    public int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int bB = bB();
        if (i2 == 0 || bB < i2 || bB > i3) {
            return 0;
        }
        int clamp = android.support.v4.c.a.clamp(i, i2, i3);
        if (bB == clamp) {
            return 0;
        }
        G(clamp);
        return bB - clamp;
    }

    /* Access modifiers changed, original: 0000 */
    public int bz() {
        return bB();
    }

    /* Access modifiers changed, original: final */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, bz() - i, i2, i3);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* Access modifiers changed, original: 0000 */
    public boolean bA() {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public int d(V v) {
        return -v.getHeight();
    }

    /* Access modifiers changed, original: 0000 */
    public int c(V v) {
        return v.getHeight();
    }

    private void cn() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }
}
