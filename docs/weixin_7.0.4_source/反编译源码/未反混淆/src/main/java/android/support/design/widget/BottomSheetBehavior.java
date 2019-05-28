package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.s;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    int mActivePointerId;
    int mState = 4;
    private VelocityTracker mVelocityTracker;
    private float nd;
    private int ne;
    private boolean nf;
    private int ng;
    int nh;
    int ni;
    public boolean nj;
    private boolean nk;
    t nl;
    private boolean nm;
    private int nn;
    private boolean no;
    int np;
    WeakReference<V> nq;
    WeakReference<View> nr;
    public a ns;
    private int nt;
    boolean nu;
    private final android.support.v4.widget.t.a nv = new android.support.v4.widget.t.a() {
        public final boolean b(View view, int i) {
            if (BottomSheetBehavior.this.mState == 1) {
                return false;
            }
            if (BottomSheetBehavior.this.nu) {
                return false;
            }
            if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i) {
                View view2 = (View) BottomSheetBehavior.this.nr.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.nq != null && BottomSheetBehavior.this.nq.get() == view;
        }

        public final void b(View view, int i, int i2) {
            BottomSheetBehavior.this.M(i2);
        }

        public final void N(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.L(1);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = BottomSheetBehavior.this.nh;
            } else if (BottomSheetBehavior.this.nj && BottomSheetBehavior.this.a(view, f2)) {
                i2 = 5;
                i = BottomSheetBehavior.this.np;
            } else if (f2 == 0.0f) {
                i = view.getTop();
                if (Math.abs(i - BottomSheetBehavior.this.nh) < Math.abs(i - BottomSheetBehavior.this.ni)) {
                    i = BottomSheetBehavior.this.nh;
                } else {
                    i = BottomSheetBehavior.this.ni;
                    i2 = 4;
                }
            } else {
                i = BottomSheetBehavior.this.ni;
                i2 = 4;
            }
            if (BottomSheetBehavior.this.nl.D(view.getLeft(), i)) {
                BottomSheetBehavior.this.L(2);
                s.b(view, new b(view, i2));
                return;
            }
            BottomSheetBehavior.this.L(i2);
        }

        public final int c(View view, int i) {
            return android.support.v4.c.a.clamp(i, BottomSheetBehavior.this.nh, BottomSheetBehavior.this.nj ? BottomSheetBehavior.this.np : BottomSheetBehavior.this.ni);
        }

        public final int d(View view, int i) {
            return view.getLeft();
        }

        public final int bL() {
            if (BottomSheetBehavior.this.nj) {
                return BottomSheetBehavior.this.np - BottomSheetBehavior.this.nh;
            }
            return BottomSheetBehavior.this.ni - BottomSheetBehavior.this.nh;
        }
    };

    public static abstract class a {
        public abstract void O(int i);

        public abstract void h(float f);
    }

    class b implements Runnable {
        private final View mView;
        private final int nz;

        b(View view, int i) {
            this.mView = view;
            this.nz = i;
        }

        public final void run() {
            if (BottomSheetBehavior.this.nl == null || !BottomSheetBehavior.this.nl.eX()) {
                BottomSheetBehavior.this.L(this.nz);
            } else {
                s.b(this.mView, (Runnable) this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(0);
        if (peekValue == null || peekValue.data != -1) {
            K(obtainStyledAttributes.getDimensionPixelSize(0, -1));
        } else {
            K(peekValue.data);
        }
        this.nj = obtainStyledAttributes.getBoolean(1, false);
        this.nk = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        this.nd = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.mState);
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (View) v, savedState.LC);
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (s.al(coordinatorLayout) && !s.al(v)) {
            s.e((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.e(v, i);
        this.np = coordinatorLayout.getHeight();
        if (this.nf) {
            if (this.ng == 0) {
                this.ng = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.ys);
            }
            max = Math.max(this.ng, this.np - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.ne;
        }
        this.nh = Math.max(0, this.np - v.getHeight());
        this.ni = Math.max(this.np - max, this.nh);
        if (this.mState == 3) {
            s.q(v, this.nh);
        } else if (this.nj && this.mState == 5) {
            s.q(v, this.np);
        } else if (this.mState == 4) {
            s.q(v, this.ni);
        } else if (this.mState == 1 || this.mState == 2) {
            s.q(v, top - v.getTop());
        }
        if (this.nl == null) {
            this.nl = t.a(coordinatorLayout, this.nv);
        }
        this.nq = new WeakReference(v);
        this.nr = new WeakReference(i(v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            View view;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            switch (actionMasked) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.nt = (int) motionEvent.getY();
                    view = this.nr != null ? (View) this.nr.get() : null;
                    if (view != null && coordinatorLayout.d(view, x, this.nt)) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.nu = true;
                    }
                    boolean z = this.mActivePointerId == -1 && !coordinatorLayout.d(v, x, this.nt);
                    this.nm = z;
                    break;
                case 1:
                case 3:
                    this.nu = false;
                    this.mActivePointerId = -1;
                    if (this.nm) {
                        this.nm = false;
                        return false;
                    }
                    break;
            }
            if (!this.nm && this.nl.f(motionEvent)) {
                return true;
            }
            view = (View) this.nr.get();
            if (actionMasked != 2 || view == null || this.nm || this.mState == 1 || coordinatorLayout.d(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.nt) - motionEvent.getY()) <= ((float) this.nl.mTouchSlop)) {
                return false;
            }
            return true;
        }
        this.nm = true;
        return false;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        if (this.nl != null) {
            this.nl.g(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.nm && Math.abs(((float) this.nt) - motionEvent.getY()) > ((float) this.nl.mTouchSlop)) {
            this.nl.u((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.nm) {
            return false;
        }
        return true;
    }

    public final boolean J(int i) {
        this.nn = 0;
        this.no = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void a(V v, View view, int i, int[] iArr) {
        if (view == ((View) this.nr.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.nh) {
                    iArr[1] = top - this.nh;
                    s.q(v, -iArr[1]);
                    L(3);
                } else {
                    iArr[1] = i;
                    s.q(v, -i);
                    L(1);
                }
            } else if (i < 0 && !view.canScrollVertically(-1)) {
                if (i2 <= this.ni || this.nj) {
                    iArr[1] = i;
                    s.q(v, -i);
                    L(1);
                } else {
                    iArr[1] = top - this.ni;
                    s.q(v, -iArr[1]);
                    L(4);
                }
            }
            M(v.getTop());
            this.nn = i;
            this.no = true;
        }
    }

    public final void a(V v, View view) {
        int i = 3;
        if (v.getTop() == this.nh) {
            L(3);
        } else if (this.nr != null && view == this.nr.get() && this.no) {
            int i2;
            if (this.nn > 0) {
                i2 = this.nh;
            } else {
                if (this.nj) {
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.nd);
                    if (a((View) v, this.mVelocityTracker.getYVelocity(this.mActivePointerId))) {
                        i = 5;
                        i2 = this.np;
                    }
                }
                if (this.nn == 0) {
                    i2 = v.getTop();
                    if (Math.abs(i2 - this.nh) < Math.abs(i2 - this.ni)) {
                        i2 = this.nh;
                    } else {
                        i2 = this.ni;
                        i = 4;
                    }
                } else {
                    i2 = this.ni;
                    i = 4;
                }
            }
            if (this.nl.h((View) v, v.getLeft(), i2)) {
                L(2);
                s.b((View) v, new b(v, i));
            } else {
                L(i);
            }
            this.no = false;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.nr.get() && (this.mState != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public final void K(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.nf) {
                this.nf = true;
            }
            z = false;
        } else {
            if (this.nf || this.ne != i) {
                this.nf = false;
                this.ne = Math.max(0, i);
                this.ni = this.np - i;
            }
            z = false;
        }
        if (z && this.mState == 4 && this.nq != null) {
            View view = (View) this.nq.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.nq != null) {
                final View view = (View) this.nq.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && parent.isLayoutRequested() && s.av(view)) {
                        view.post(new Runnable() {
                            public final void run() {
                                BottomSheetBehavior.this.a(view, i);
                            }
                        });
                    } else {
                        a(view, i);
                    }
                }
            } else if (i == 4 || i == 3 || (this.nj && i == 5)) {
                this.mState = i;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void L(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.nq.get()) != null && this.ns != null) {
                this.ns.O(i);
            }
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(View view, float f) {
        if (this.nk) {
            return true;
        }
        if (view.getTop() < this.ni) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.ni)) / ((float) this.ne) <= 0.5f) {
            return false;
        }
        return true;
    }

    private View i(View view) {
        if (s.aq(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View i2 = i(viewGroup.getChildAt(i));
                if (i2 != null) {
                    return i2;
                }
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.ni;
        } else if (i == 3) {
            i2 = this.nh;
        } else if (this.nj && i == 5) {
            i2 = this.np;
        } else {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i)));
        }
        if (this.nl.h(view, view.getLeft(), i2)) {
            L(2);
            s.b(view, new b(view, i));
            return;
        }
        L(i);
    }

    /* Access modifiers changed, original: final */
    public final void M(int i) {
        if (((View) this.nq.get()) != null && this.ns != null) {
            if (i > this.ni) {
                this.ns.h(((float) (this.ni - i)) / ((float) (this.np - this.ni)));
            } else {
                this.ns.h(((float) (this.ni - i)) / ((float) (this.ni - this.nh)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> j(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof d) {
            Behavior behavior = ((d) layoutParams).pH;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
