package android.support.design.widget;

import android.content.Context;
import android.support.p057v4.p1154c.C17435a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
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
    /* renamed from: qM */
    private Runnable f14576qM;
    /* renamed from: qN */
    OverScroller f14577qN;
    /* renamed from: qO */
    private int f14578qO;

    /* renamed from: android.support.design.widget.HeaderBehavior$a */
    class C8330a implements Runnable {
        /* renamed from: qP */
        private final CoordinatorLayout f2206qP;
        /* renamed from: qQ */
        private final V f2207qQ;

        C8330a(CoordinatorLayout coordinatorLayout, V v) {
            this.f2206qP = coordinatorLayout;
            this.f2207qQ = v;
        }

        public final void run() {
            if (this.f2207qQ != null && HeaderBehavior.this.f14577qN != null) {
                if (HeaderBehavior.this.f14577qN.computeScrollOffset()) {
                    HeaderBehavior.this.mo51806c(this.f2206qP, this.f2207qQ, HeaderBehavior.this.f14577qN.getCurrY());
                    C0477s.m934b(this.f2207qQ, (Runnable) this);
                    return;
                }
                HeaderBehavior.this.mo18120a(this.f2206qP, this.f2207qQ);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public final boolean mo442a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
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
                if (mo18129bA() && coordinatorLayout.mo66176d(v, x, y)) {
                    this.f14578qO = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    m51575cn();
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
                        if (Math.abs(y - this.f14578qO) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.f14578qO = y;
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

    /* renamed from: b */
    public final boolean mo31556b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.mo66176d(v, (int) motionEvent.getX(), y) && mo18129bA()) {
                    this.f14578qO = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    m51575cn();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    int i = -mo18132c(v);
                    if (this.f14576qM != null) {
                        v.removeCallbacks(this.f14576qM);
                        this.f14576qM = null;
                    }
                    if (this.f14577qN == null) {
                        this.f14577qN = new OverScroller(v.getContext());
                    }
                    this.f14577qN.fling(0, mo18130bB(), 0, Math.round(yVelocity), 0, 0, i, 0);
                    if (!this.f14577qN.computeScrollOffset()) {
                        mo18120a(coordinatorLayout, v);
                        break;
                    }
                    this.f14576qM = new C8330a(coordinatorLayout, v);
                    C0477s.m934b((View) v, this.f14576qM);
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.f14578qO - findPointerIndex;
                    if (!this.mIsBeingDragged && Math.abs(i2) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        i2 = i2 > 0 ? i2 - this.mTouchSlop : i2 + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        this.f14578qO = findPointerIndex;
                        mo51805b(coordinatorLayout, v, i2, mo18133d(v), 0);
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
    /* renamed from: c */
    public final int mo51806c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo18119a(coordinatorLayout, v, i, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public int mo18119a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int bB = mo18130bB();
        if (i2 == 0 || bB < i2 || bB > i3) {
            return 0;
        }
        int clamp = C17435a.clamp(i, i2, i3);
        if (bB == clamp) {
            return 0;
        }
        mo18118G(clamp);
        return bB - clamp;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: bz */
    public int mo18131bz() {
        return mo18130bB();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo51805b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo18119a(coordinatorLayout, v, mo18131bz() - i, i2, i3);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo18120a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: bA */
    public boolean mo18129bA() {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public int mo18133d(V v) {
        return -v.getHeight();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public int mo18132c(V v) {
        return v.getHeight();
    }

    /* renamed from: cn */
    private void m51575cn() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }
}
