package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C37097a.C37096a;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p057v4.p1154c.C17435a;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C0553t;
import android.support.p057v4.widget.C0553t.C0552a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    int mActivePointerId;
    int mState = 4;
    private VelocityTracker mVelocityTracker;
    /* renamed from: nd */
    private float f4907nd;
    /* renamed from: ne */
    private int f4908ne;
    /* renamed from: nf */
    private boolean f4909nf;
    /* renamed from: ng */
    private int f4910ng;
    /* renamed from: nh */
    int f4911nh;
    /* renamed from: ni */
    int f4912ni;
    /* renamed from: nj */
    public boolean f4913nj;
    /* renamed from: nk */
    private boolean f4914nk;
    /* renamed from: nl */
    C0553t f4915nl;
    /* renamed from: nm */
    private boolean f4916nm;
    /* renamed from: nn */
    private int f4917nn;
    /* renamed from: no */
    private boolean f4918no;
    /* renamed from: np */
    int f4919np;
    /* renamed from: nq */
    WeakReference<V> f4920nq;
    /* renamed from: nr */
    WeakReference<View> f4921nr;
    /* renamed from: ns */
    public C24632a f4922ns;
    /* renamed from: nt */
    private int f4923nt;
    /* renamed from: nu */
    boolean f4924nu;
    /* renamed from: nv */
    private final C0552a f4925nv = new C173812();

    /* renamed from: android.support.design.widget.BottomSheetBehavior$2 */
    class C173812 extends C0552a {
        C173812() {
        }

        /* renamed from: b */
        public final boolean mo1218b(View view, int i) {
            if (BottomSheetBehavior.this.mState == 1) {
                return false;
            }
            if (BottomSheetBehavior.this.f4924nu) {
                return false;
            }
            if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i) {
                View view2 = (View) BottomSheetBehavior.this.f4921nr.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.f4920nq != null && BottomSheetBehavior.this.f4920nq.get() == view;
        }

        /* renamed from: b */
        public final void mo1217b(View view, int i, int i2) {
            BottomSheetBehavior.this.mo41464M(i2);
        }

        /* renamed from: N */
        public final void mo1215N(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.mo41463L(1);
            }
        }

        /* renamed from: a */
        public final void mo1216a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = BottomSheetBehavior.this.f4911nh;
            } else if (BottomSheetBehavior.this.f4913nj && BottomSheetBehavior.this.mo41466a(view, f2)) {
                i2 = 5;
                i = BottomSheetBehavior.this.f4919np;
            } else if (f2 == 0.0f) {
                i = view.getTop();
                if (Math.abs(i - BottomSheetBehavior.this.f4911nh) < Math.abs(i - BottomSheetBehavior.this.f4912ni)) {
                    i = BottomSheetBehavior.this.f4911nh;
                } else {
                    i = BottomSheetBehavior.this.f4912ni;
                    i2 = 4;
                }
            } else {
                i = BottomSheetBehavior.this.f4912ni;
                i2 = 4;
            }
            if (BottomSheetBehavior.this.f4915nl.mo1316D(view.getLeft(), i)) {
                BottomSheetBehavior.this.mo41463L(2);
                C0477s.m934b(view, new C24633b(view, i2));
                return;
            }
            BottomSheetBehavior.this.mo41463L(i2);
        }

        /* renamed from: c */
        public final int mo1219c(View view, int i) {
            return C17435a.clamp(i, BottomSheetBehavior.this.f4911nh, BottomSheetBehavior.this.f4913nj ? BottomSheetBehavior.this.f4919np : BottomSheetBehavior.this.f4912ni);
        }

        /* renamed from: d */
        public final int mo1220d(View view, int i) {
            return view.getLeft();
        }

        /* renamed from: bL */
        public final int mo1315bL() {
            if (BottomSheetBehavior.this.f4913nj) {
                return BottomSheetBehavior.this.f4919np - BottomSheetBehavior.this.f4911nh;
            }
            return BottomSheetBehavior.this.f4912ni - BottomSheetBehavior.this.f4911nh;
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$a */
    public static abstract class C24632a {
        /* renamed from: O */
        public abstract void mo31604O(int i);

        /* renamed from: h */
        public abstract void mo31605h(float f);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$b */
    class C24633b implements Runnable {
        private final View mView;
        /* renamed from: nz */
        private final int f4927nz;

        C24633b(View view, int i) {
            this.mView = view;
            this.f4927nz = i;
        }

        public final void run() {
            if (BottomSheetBehavior.this.f4915nl == null || !BottomSheetBehavior.this.f4915nl.mo1322eX()) {
                BottomSheetBehavior.this.mo41463L(this.f4927nz);
            } else {
                C0477s.m934b(this.mView, (Runnable) this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C246341();
        final int state;

        /* renamed from: android.support.design.widget.BottomSheetBehavior$SavedState$1 */
        static class C246341 implements ClassLoaderCreator<SavedState> {
            C246341() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(0);
        if (peekValue == null || peekValue.data != -1) {
            mo41462K(obtainStyledAttributes.getDimensionPixelSize(0, -1));
        } else {
            mo41462K(peekValue.data);
        }
        this.f4913nj = obtainStyledAttributes.getBoolean(1, false);
        this.f4914nk = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        this.f4907nd = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: b */
    public final Parcelable mo18127b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo18127b(coordinatorLayout, v), this.mState);
    }

    /* renamed from: a */
    public final void mo18121a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo18121a(coordinatorLayout, (View) v, savedState.f507LC);
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    /* renamed from: a */
    public final boolean mo18124a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (C0477s.m920al(coordinatorLayout) && !C0477s.m920al(v)) {
            C0477s.m942e((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.mo66179e(v, i);
        this.f4919np = coordinatorLayout.getHeight();
        if (this.f4909nf) {
            if (this.f4910ng == 0) {
                this.f4910ng = coordinatorLayout.getResources().getDimensionPixelSize(C25738R.dimen.f10349ys);
            }
            max = Math.max(this.f4910ng, this.f4919np - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.f4908ne;
        }
        this.f4911nh = Math.max(0, this.f4919np - v.getHeight());
        this.f4912ni = Math.max(this.f4919np - max, this.f4911nh);
        if (this.mState == 3) {
            C0477s.m951q(v, this.f4911nh);
        } else if (this.f4913nj && this.mState == 5) {
            C0477s.m951q(v, this.f4919np);
        } else if (this.mState == 4) {
            C0477s.m951q(v, this.f4912ni);
        } else if (this.mState == 1 || this.mState == 2) {
            C0477s.m951q(v, top - v.getTop());
        }
        if (this.f4915nl == null) {
            this.f4915nl = C0553t.m1197a(coordinatorLayout, this.f4925nv);
        }
        this.f4920nq = new WeakReference(v);
        this.f4921nr = new WeakReference(m38321i(v));
        return true;
    }

    /* renamed from: a */
    public final boolean mo442a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
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
                    this.f4923nt = (int) motionEvent.getY();
                    view = this.f4921nr != null ? (View) this.f4921nr.get() : null;
                    if (view != null && coordinatorLayout.mo66176d(view, x, this.f4923nt)) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f4924nu = true;
                    }
                    boolean z = this.mActivePointerId == -1 && !coordinatorLayout.mo66176d(v, x, this.f4923nt);
                    this.f4916nm = z;
                    break;
                case 1:
                case 3:
                    this.f4924nu = false;
                    this.mActivePointerId = -1;
                    if (this.f4916nm) {
                        this.f4916nm = false;
                        return false;
                    }
                    break;
            }
            if (!this.f4916nm && this.f4915nl.mo1323f(motionEvent)) {
                return true;
            }
            view = (View) this.f4921nr.get();
            if (actionMasked != 2 || view == null || this.f4916nm || this.mState == 1 || coordinatorLayout.mo66176d(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f4923nt) - motionEvent.getY()) <= ((float) this.f4915nl.mTouchSlop)) {
                return false;
            }
            return true;
        }
        this.f4916nm = true;
        return false;
    }

    /* renamed from: b */
    public final boolean mo31556b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        if (this.f4915nl != null) {
            this.f4915nl.mo1324g(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f4916nm && Math.abs(((float) this.f4923nt) - motionEvent.getY()) > ((float) this.f4915nl.mTouchSlop)) {
            this.f4915nl.mo1326u((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.f4916nm) {
            return false;
        }
        return true;
    }

    /* renamed from: J */
    public final boolean mo31552J(int i) {
        this.f4917nn = 0;
        this.f4918no = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void mo31554a(V v, View view, int i, int[] iArr) {
        if (view == ((View) this.f4921nr.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.f4911nh) {
                    iArr[1] = top - this.f4911nh;
                    C0477s.m951q(v, -iArr[1]);
                    mo41463L(3);
                } else {
                    iArr[1] = i;
                    C0477s.m951q(v, -i);
                    mo41463L(1);
                }
            } else if (i < 0 && !view.canScrollVertically(-1)) {
                if (i2 <= this.f4912ni || this.f4913nj) {
                    iArr[1] = i;
                    C0477s.m951q(v, -i);
                    mo41463L(1);
                } else {
                    iArr[1] = top - this.f4912ni;
                    C0477s.m951q(v, -iArr[1]);
                    mo41463L(4);
                }
            }
            mo41464M(v.getTop());
            this.f4917nn = i;
            this.f4918no = true;
        }
    }

    /* renamed from: a */
    public final void mo31553a(V v, View view) {
        int i = 3;
        if (v.getTop() == this.f4911nh) {
            mo41463L(3);
        } else if (this.f4921nr != null && view == this.f4921nr.get() && this.f4918no) {
            int i2;
            if (this.f4917nn > 0) {
                i2 = this.f4911nh;
            } else {
                if (this.f4913nj) {
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.f4907nd);
                    if (mo41466a((View) v, this.mVelocityTracker.getYVelocity(this.mActivePointerId))) {
                        i = 5;
                        i2 = this.f4919np;
                    }
                }
                if (this.f4917nn == 0) {
                    i2 = v.getTop();
                    if (Math.abs(i2 - this.f4911nh) < Math.abs(i2 - this.f4912ni)) {
                        i2 = this.f4911nh;
                    } else {
                        i2 = this.f4912ni;
                        i = 4;
                    }
                } else {
                    i2 = this.f4912ni;
                    i = 4;
                }
            }
            if (this.f4915nl.mo1325h((View) v, v.getLeft(), i2)) {
                mo41463L(2);
                C0477s.m934b((View) v, new C24633b(v, i));
            } else {
                mo41463L(i);
            }
            this.f4918no = false;
        }
    }

    /* renamed from: a */
    public final boolean mo31555a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f4921nr.get() && (this.mState != 3 || super.mo31555a(coordinatorLayout, (View) v, view, f, f2));
    }

    /* renamed from: K */
    public final void mo41462K(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.f4909nf) {
                this.f4909nf = true;
            }
            z = false;
        } else {
            if (this.f4909nf || this.f4908ne != i) {
                this.f4909nf = false;
                this.f4908ne = Math.max(0, i);
                this.f4912ni = this.f4919np - i;
            }
            z = false;
        }
        if (z && this.mState == 4 && this.f4920nq != null) {
            View view = (View) this.f4920nq.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.f4920nq != null) {
                final View view = (View) this.f4920nq.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && parent.isLayoutRequested() && C0477s.m930av(view)) {
                        view.post(new Runnable() {
                            public final void run() {
                                BottomSheetBehavior.this.mo41465a(view, i);
                            }
                        });
                    } else {
                        mo41465a(view, i);
                    }
                }
            } else if (i == 4 || i == 3 || (this.f4913nj && i == 5)) {
                this.mState = i;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: L */
    public final void mo41463L(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.f4920nq.get()) != null && this.f4922ns != null) {
                this.f4922ns.mo31604O(i);
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
    /* renamed from: a */
    public final boolean mo41466a(View view, float f) {
        if (this.f4914nk) {
            return true;
        }
        if (view.getTop() < this.f4912ni) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f4912ni)) / ((float) this.f4908ne) <= 0.5f) {
            return false;
        }
        return true;
    }

    /* renamed from: i */
    private View m38321i(View view) {
        if (C0477s.m925aq(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View i2 = m38321i(viewGroup.getChildAt(i));
                if (i2 != null) {
                    return i2;
                }
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo41465a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.f4912ni;
        } else if (i == 3) {
            i2 = this.f4911nh;
        } else if (this.f4913nj && i == 5) {
            i2 = this.f4919np;
        } else {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i)));
        }
        if (this.f4915nl.mo1325h(view, view.getLeft(), i2)) {
            mo41463L(2);
            C0477s.m934b(view, new C24633b(view, i));
            return;
        }
        mo41463L(i);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: M */
    public final void mo41464M(int i) {
        if (((View) this.f4920nq.get()) != null && this.f4922ns != null) {
            if (i > this.f4912ni) {
                this.f4922ns.mo31605h(((float) (this.f4912ni - i)) / ((float) (this.f4919np - this.f4912ni)));
            } else {
                this.f4922ns.mo31605h(((float) (this.f4912ni - i)) / ((float) (this.f4912ni - this.f4911nh)));
            }
        }
    }

    /* renamed from: j */
    public static <V extends View> BottomSheetBehavior<V> m38322j(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof C31839d) {
            Behavior behavior = ((C31839d) layoutParams).f14560pH;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
