package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.f.i;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.aa;
import android.support.v4.view.m;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.s;
import android.support.v4.widget.h;
import android.support.v4.widget.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements m {
    static final String pk;
    static final Class<?>[] pl = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> pm = new ThreadLocal();
    static final Comparator<View> pn;
    private static final android.support.v4.f.k.a<Rect> po = new android.support.v4.f.k.c(12);
    aa mp;
    private boolean pA;
    boolean pB;
    private Drawable pC;
    OnHierarchyChangeListener pD;
    private o pE;
    private final n pF;
    private final List<View> pp;
    final h<View> pq;
    private final List<View> pr;
    final List<View> ps;
    private final int[] pt;
    private boolean pu;
    private boolean pv;
    private int[] pw;
    private View px;
    private View py;
    private e pz;

    public interface a {
        Behavior cb();
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
        SparseArray<Parcelable> pX;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.pX = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.pX.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.pX != null ? this.pX.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.pX.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.pX.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void a(d dVar) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean e(View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        @Deprecated
        public boolean J(int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2) {
            if (i2 == 0) {
                return J(i);
            }
            return false;
        }

        @Deprecated
        public void a(V v, View view) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                a((View) v, view);
            }
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        }

        @Deprecated
        public void a(V v, View view, int i, int[] iArr) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr, int i2) {
            if (i2 == 0) {
                a((View) v, view, i, iArr);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public static aa b(aa aaVar) {
            return aaVar;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public boolean a(V v, Rect rect) {
            return false;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    class c implements OnHierarchyChangeListener {
        c() {
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.pD != null) {
                CoordinatorLayout.this.pD.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.X(2);
            if (CoordinatorLayout.this.pD != null) {
                CoordinatorLayout.this.pD.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends MarginLayoutParams {
        public int anchorGravity = 0;
        public int gravity = 0;
        Behavior pH;
        boolean pI = false;
        public int pJ = -1;
        int pK = -1;
        public int pL = 0;
        public int pM = 0;
        int pN;
        int pO;
        View pP;
        View pQ;
        boolean pR;
        private boolean pS;
        private boolean pT;
        boolean pU;
        final Rect pV = new Rect();
        Object pW;

        public d() {
            super(-2, -2);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.b.a.a.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.pK = obtainStyledAttributes.getResourceId(2, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(4, 0);
            this.pJ = obtainStyledAttributes.getInteger(3, -1);
            this.pL = obtainStyledAttributes.getInt(5, 0);
            this.pM = obtainStyledAttributes.getInt(6, 0);
            this.pI = obtainStyledAttributes.hasValue(1);
            if (this.pI) {
                this.pH = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(1));
            }
            obtainStyledAttributes.recycle();
            if (this.pH != null) {
                this.pH.a(this);
            }
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(Behavior behavior) {
            if (this.pH != behavior) {
                this.pH = behavior;
                this.pW = null;
                this.pI = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean cc() {
            return this.pP == null && this.pK != -1;
        }

        /* Access modifiers changed, original: final */
        public final void i(int i, boolean z) {
            switch (i) {
                case 0:
                    this.pS = z;
                    return;
                case 1:
                    this.pT = z;
                    return;
                default:
                    return;
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean Y(int i) {
            switch (i) {
                case 0:
                    return this.pS;
                case 1:
                    return this.pT;
                default:
                    return false;
            }
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            float at = s.at((View) obj);
            float at2 = s.at(view);
            if (at > at2) {
                return -1;
            }
            if (at < at2) {
                return 1;
            }
            return 0;
        }
    }

    class e implements OnPreDrawListener {
        e() {
        }

        public final boolean onPreDraw() {
            CoordinatorLayout.this.X(0);
            return true;
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        pk = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            pn = new f();
        } else {
            pn = null;
        }
    }

    private static Rect bY() {
        Rect rect = (Rect) po.aA();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    private static void c(Rect rect) {
        rect.setEmpty();
        po.release(rect);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.n);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        int i2 = 0;
        super(context, attributeSet, i);
        this.pp = new ArrayList();
        this.pq = new h();
        this.pr = new ArrayList();
        this.ps = new ArrayList();
        this.pt = new int[2];
        this.pF = new n(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.b.a.a.CoordinatorLayout, 0, R.style.yv);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.b.a.a.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.pw = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.pw.length;
            while (i2 < length) {
                int[] iArr = this.pw;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.pC = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        ca();
        super.setOnHierarchyChangeListener(new c());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.pD = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q(false);
        if (this.pA) {
            if (this.pz == null) {
                this.pz = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.pz);
        }
        if (this.mp == null && s.al(this)) {
            s.ak(this);
        }
        this.pv = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q(false);
        if (this.pA && this.pz != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.pz);
        }
        if (this.py != null) {
            onStopNestedScroll(this.py);
        }
        this.pv = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.pC != drawable) {
            if (this.pC != null) {
                this.pC.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.pC = drawable2;
            if (this.pC != null) {
                if (this.pC.isStateful()) {
                    this.pC.setState(getDrawableState());
                }
                android.support.v4.a.a.a.b(this.pC, s.T(this));
                this.pC.setVisible(getVisibility() == 0, false);
                this.pC.setCallback(this);
            }
            s.R(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.pC;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.pC;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.pC;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.pC != null && this.pC.isVisible() != z) {
            this.pC.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.content.b.g(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public final aa getLastWindowInsets() {
        return this.mp;
    }

    private void q(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((d) childAt.getLayoutParams()).pH;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.a(this, childAt, obtain);
                } else {
                    behavior.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((d) getChildAt(i2).getLayoutParams()).pR = false;
        }
        this.px = null;
        this.pu = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        int childDrawingOrder;
        boolean z = false;
        Object obj = null;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.pr;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i2);
            } else {
                childDrawingOrder = i2;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (pn != null) {
            Collections.sort(list, pn);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            d dVar = (d) view.getLayoutParams();
            Behavior behavior = dVar.pH;
            if ((!z && obj == null) || actionMasked == 0) {
                if (!(z || behavior == null)) {
                    switch (i) {
                        case 0:
                            z = behavior.a(this, view, motionEvent);
                            break;
                        case 1:
                            z = behavior.b(this, view, motionEvent);
                            break;
                    }
                    if (z) {
                        this.px = view;
                    }
                }
                isChildrenDrawingOrderEnabled = z;
                if (dVar.pH == null) {
                    dVar.pR = false;
                }
                boolean z2 = dVar.pR;
                if (dVar.pR) {
                    childDrawingOrder = 1;
                } else {
                    int i4 = dVar.pR | 0;
                    dVar.pR = i4;
                    childDrawingOrder = i4;
                }
                obj2 = (childDrawingOrder == 0 || z2) ? null : 1;
                if (childDrawingOrder == 0 || obj2 != null) {
                    motionEvent3 = motionEvent2;
                } else {
                    list.clear();
                    return isChildrenDrawingOrderEnabled;
                }
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        behavior.a(this, view, motionEvent3);
                        obj2 = obj;
                        isChildrenDrawingOrderEnabled = z;
                        continue;
                    case 1:
                        behavior.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            } else {
                motionEvent3 = motionEvent2;
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            }
            i3++;
            motionEvent2 = motionEvent3;
            obj = obj2;
            z = isChildrenDrawingOrderEnabled;
        }
        isChildrenDrawingOrderEnabled = z;
        list.clear();
        return isChildrenDrawingOrderEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            q(true);
        }
        boolean a = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            q(true);
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2;
        if (this.px == null) {
            boolean a = a(motionEvent, 1);
            if (a) {
                z2 = a;
            } else {
                z2 = a;
                z = false;
                if (this.px != null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                } else {
                    motionEvent2 = null;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (actionMasked == 1 || actionMasked == 3) {
                    q(false);
                }
                return z;
            }
        }
        z2 = false;
        Behavior behavior = ((d) this.px.getLayoutParams()).pH;
        z = behavior != null ? behavior.b(this, this.px, motionEvent) : false;
        if (this.px != null) {
        }
        if (motionEvent2 != null) {
        }
        q(false);
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.pu) {
            q(false);
            this.pu = true;
        }
    }

    private int U(int i) {
        if (this.pw == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i);
            return 0;
        } else if (i >= 0 && i < this.pw.length) {
            return this.pw[i];
        } else {
            new StringBuilder("Keyline index ").append(i).append(" out of range for ").append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object str2;
        if (str2.startsWith(".")) {
            str2 = context.getPackageName() + str2;
        } else if (str2.indexOf(46) < 0 && !TextUtils.isEmpty(pk)) {
            str2 = pk + '.' + str2;
        }
        try {
            Map map;
            Map map2 = (Map) pm.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                pm.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str2);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str2).getConstructor(pl);
                constructor.setAccessible(true);
                map.put(str2, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str2)), e);
        }
    }

    private static d o(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.pI) {
            if (view instanceof a) {
                dVar.a(((a) view).cb());
                dVar.pI = true;
            } else {
                b bVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    try {
                        dVar.a((Behavior) bVar2.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        new StringBuilder("Default behavior class ").append(bVar2.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                dVar.pI = true;
            }
        }
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x019a A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Missing block: B:42:0x00be, code skipped:
            if (r0 == null) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bZ() {
        int i;
        ArrayList arrayList;
        this.pp.clear();
        h hVar = this.pq;
        int size = hVar.PR.size();
        for (i = 0; i < size; i++) {
            arrayList = (ArrayList) hVar.PR.valueAt(i);
            if (arrayList != null) {
                arrayList.clear();
                hVar.PQ.release(arrayList);
            }
        }
        hVar.PR.clear();
        size = getChildCount();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj;
            int obj2;
            View childAt = getChildAt(i2);
            d o = o(childAt);
            if (o.pK == -1) {
                o.pQ = null;
                o.pP = null;
            } else {
                View view;
                View parent;
                if (o.pP != null) {
                    if (o.pP.getId() != o.pK) {
                        obj2 = null;
                    } else {
                        view = o.pP;
                        parent = o.pP.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                o.pQ = null;
                                o.pP = null;
                                obj2 = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = parent;
                            }
                            parent = parent.getParent();
                        }
                        o.pQ = view;
                        obj2 = 1;
                    }
                }
                o.pP = findViewById(o.pK);
                if (o.pP != null) {
                    if (o.pP != this) {
                        view = o.pP;
                        parent = o.pP.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                o.pQ = null;
                                o.pP = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        o.pQ = view;
                    } else if (isInEditMode()) {
                        o.pQ = null;
                        o.pP = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    o.pQ = null;
                    o.pP = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(o.pK) + " to anchor view " + childAt);
                }
            }
            this.pq.I(childAt);
            for (i = 0; i < size; i++) {
                if (i != i2) {
                    View childAt2 = getChildAt(i);
                    if (childAt2 != o.pQ) {
                        int T = s.T(this);
                        obj2 = android.support.v4.view.d.getAbsoluteGravity(((d) childAt2.getLayoutParams()).pL, T);
                        if (obj2 == 0 || (android.support.v4.view.d.getAbsoluteGravity(o.pM, T) & obj2) != obj2) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 == null && (o.pH == null || !o.pH.e(childAt2))) {
                            obj2 = null;
                            if (obj2 == null) {
                                continue;
                            } else {
                                if (!this.pq.PR.containsKey(childAt2)) {
                                    this.pq.I(childAt2);
                                }
                                h hVar2 = this.pq;
                                if (hVar2.PR.containsKey(childAt2) && hVar2.PR.containsKey(childAt)) {
                                    arrayList = (ArrayList) hVar2.PR.get(childAt2);
                                    if (arrayList == null) {
                                        arrayList = (ArrayList) hVar2.PQ.aA();
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        hVar2.PR.put(childAt2, arrayList);
                                    }
                                    arrayList.add(childAt);
                                } else {
                                    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                                }
                            }
                        }
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                    }
                }
            }
        }
        this.pp.addAll(this.pq.eE());
        Collections.reverse(this.pp);
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        Object obj;
        bZ();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            Object obj2;
            View childAt = getChildAt(i3);
            h hVar = this.pq;
            int size = hVar.PR.size();
            for (i4 = 0; i4 < size; i4++) {
                ArrayList arrayList = (ArrayList) hVar.PR.valueAt(i4);
                if (arrayList != null && arrayList.contains(childAt)) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                z = true;
                break;
            }
        }
        z = false;
        if (z != this.pA) {
            if (z) {
                if (this.pv) {
                    if (this.pz == null) {
                        this.pz = new e();
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.pz);
                }
                this.pA = true;
            } else {
                if (this.pv && this.pz != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.pz);
                }
                this.pA = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i4 = getPaddingBottom();
        int T = s.T(this);
        Object obj3;
        if (T == 1) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size3 = MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop + i4;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i7 = 0;
        if (this.mp == null || !s.al(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size4 = this.pp.size();
        int i8 = 0;
        while (i8 < size4) {
            int U;
            View view = (View) this.pp.get(i8);
            if (view.getVisibility() != 8) {
                int i9;
                d dVar = (d) view.getLayoutParams();
                childCount = 0;
                if (dVar.pJ >= 0 && mode != 0) {
                    U = U(dVar.pJ);
                    paddingTop = android.support.v4.view.d.getAbsoluteGravity(W(dVar.gravity), T) & 7;
                    if ((paddingTop == 3 && obj3 == null) || (paddingTop == 5 && obj3 != null)) {
                        childCount = Math.max(0, (size2 - paddingRight) - U);
                    } else if ((paddingTop == 5 && obj3 == null) || (paddingTop == 3 && obj3 != null)) {
                        childCount = Math.max(0, U - paddingLeft);
                    }
                }
                if (obj == null || s.al(view)) {
                    i9 = i2;
                    i3 = i;
                } else {
                    paddingTop = this.mp.getSystemWindowInsetTop() + this.mp.getSystemWindowInsetBottom();
                    i3 = MeasureSpec.makeMeasureSpec(size2 - (this.mp.getSystemWindowInsetLeft() + this.mp.getSystemWindowInsetRight()), mode);
                    i9 = MeasureSpec.makeMeasureSpec(size3 - paddingTop, mode2);
                }
                Behavior behavior = dVar.pH;
                if (behavior == null || !behavior.a(this, view, i3, childCount, i9, 0)) {
                    a(view, i3, childCount, i9, 0);
                }
                i3 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i5) + dVar.leftMargin) + dVar.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i6) + dVar.topMargin) + dVar.bottomMargin);
                U = View.combineMeasuredStates(i7, view.getMeasuredState());
                i4 = i3;
            } else {
                U = i7;
                paddingTop = suggestedMinimumHeight;
                i4 = suggestedMinimumWidth;
            }
            i8++;
            i7 = U;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, WebView.NIGHT_MODE_COLOR & i7), View.resolveSizeAndState(suggestedMinimumHeight, i2, i7 << 16));
    }

    public final void e(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.cc()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.pP != null) {
            a(view, dVar.pP, i);
        } else if (dVar.pJ >= 0) {
            c(view, dVar.pJ, i);
        } else {
            f(view, i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int T = s.T(this);
        int size = this.pp.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.pp.get(i5);
            if (view.getVisibility() != 8) {
                Behavior behavior = ((d) view.getLayoutParams()).pH;
                if (behavior == null || !behavior.a(this, view, T)) {
                    e(view, T);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pB && this.pC != null) {
            int systemWindowInsetTop = this.mp != null ? this.mp.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.pC.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.pC.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        ca();
    }

    private void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            u.a((ViewGroup) this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private static void a(int i, Rect rect, Rect rect2, d dVar, int i2, int i3) {
        int i4 = dVar.gravity;
        if (i4 == 0) {
            i4 = 17;
        }
        i4 = android.support.v4.view.d.getAbsoluteGravity(i4, i);
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(V(dVar.anchorGravity), i);
        int i5 = i4 & 7;
        int i6 = i4 & 112;
        int i7 = absoluteGravity & 112;
        switch (absoluteGravity & 7) {
            case 1:
                absoluteGravity = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity = rect.right;
                break;
            default:
                absoluteGravity = rect.left;
                break;
        }
        switch (i7) {
            case 16:
                i4 = rect.top + (rect.height() / 2);
                break;
            case 80:
                i4 = rect.bottom;
                break;
            default:
                i4 = rect.top;
                break;
        }
        switch (i5) {
            case 1:
                absoluteGravity -= i2 / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity -= i2;
                break;
        }
        switch (i6) {
            case 16:
                i4 -= i3 / 2;
                break;
            case 80:
                break;
            default:
                i4 -= i3;
                break;
        }
        rect2.set(absoluteGravity, i4, absoluteGravity + i2, i4 + i3);
    }

    private void a(d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - dVar.rightMargin));
        height = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - dVar.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    private void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(i, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        view.getLayoutParams();
        Rect bY = bY();
        Rect bY2 = bY();
        try {
            u.a((ViewGroup) this, view2, bY);
            a(view, i, bY, bY2);
            view.layout(bY2.left, bY2.top, bY2.right, bY2.bottom);
        } finally {
            c(bY);
            c(bY2);
        }
    }

    private void c(View view, int i, int i2) {
        d dVar = (d) view.getLayoutParams();
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(W(dVar.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int U = U(i) - measuredWidth;
        absoluteGravity = 0;
        switch (i3) {
            case 1:
                U += measuredWidth / 2;
                break;
            case 5:
                U += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                absoluteGravity = (measuredHeight / 2) + 0;
                break;
            case 80:
                absoluteGravity = measuredHeight + 0;
                break;
        }
        U = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(U, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max = Math.max(getPaddingTop() + dVar.topMargin, Math.min(absoluteGravity, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(U, max, U + measuredWidth, max + measuredHeight);
    }

    private void f(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect bY = bY();
        bY.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (!(this.mp == null || !s.al(this) || s.al(view))) {
            bY.left += this.mp.getSystemWindowInsetLeft();
            bY.top += this.mp.getSystemWindowInsetTop();
            bY.right -= this.mp.getSystemWindowInsetRight();
            bY.bottom -= this.mp.getSystemWindowInsetBottom();
        }
        Rect bY2 = bY();
        android.support.v4.view.d.apply(V(dVar.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), bY, bY2, i);
        view.layout(bY2.left, bY2.top, bY2.right, bY2.bottom);
        c(bY);
        c(bY2);
    }

    private static int V(int i) {
        int i2;
        if ((i & 7) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            return i2 | 48;
        }
        return i2;
    }

    private static int W(int i) {
        return i == 0 ? 8388661 : i;
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0279  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void X(int i) {
        int T = s.T(this);
        int size = this.pp.size();
        Rect bY = bY();
        Rect bY2 = bY();
        Rect bY3 = bY();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.pp.get(i2);
            d dVar = (d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int measuredWidth;
                int measuredHeight;
                Behavior behavior;
                int absoluteGravity;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (dVar.pQ == ((View) this.pp.get(i3))) {
                        d dVar2 = (d) view.getLayoutParams();
                        if (dVar2.pP != null) {
                            Rect bY4 = bY();
                            Rect bY5 = bY();
                            Rect bY6 = bY();
                            u.a((ViewGroup) this, dVar2.pP, bY4);
                            a(view, false, bY5);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            a(T, bY4, bY6, dVar2, measuredWidth, measuredHeight);
                            Object obj = (bY6.left == bY5.left && bY6.top == bY5.top) ? null : 1;
                            a(dVar2, bY6, measuredWidth, measuredHeight);
                            measuredWidth = bY6.left - bY5.left;
                            measuredHeight = bY6.top - bY5.top;
                            if (measuredWidth != 0) {
                                s.r(view, measuredWidth);
                            }
                            if (measuredHeight != 0) {
                                s.q(view, measuredHeight);
                            }
                            if (obj != null) {
                                behavior = dVar2.pH;
                                if (behavior != null) {
                                    behavior.a(this, view, dVar2.pP);
                                }
                            }
                            c(bY4);
                            c(bY5);
                            c(bY6);
                        }
                    }
                }
                a(view, true, bY2);
                if (!(dVar.pL == 0 || bY2.isEmpty())) {
                    absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(dVar.pL, T);
                    switch (absoluteGravity & 112) {
                        case 48:
                            bY.top = Math.max(bY.top, bY2.bottom);
                            break;
                        case 80:
                            bY.bottom = Math.max(bY.bottom, getHeight() - bY2.top);
                            break;
                    }
                    switch (absoluteGravity & 7) {
                        case 3:
                            bY.left = Math.max(bY.left, bY2.right);
                            break;
                        case 5:
                            bY.right = Math.max(bY.right, getWidth() - bY2.left);
                            break;
                    }
                }
                if (dVar.pM != 0 && view.getVisibility() == 0 && s.as(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                    d dVar3 = (d) view.getLayoutParams();
                    Behavior behavior2 = dVar3.pH;
                    Rect bY7 = bY();
                    Rect bY8 = bY();
                    bY8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (behavior2 == null || !behavior2.a(view, bY7)) {
                        bY7.set(bY8);
                    } else if (!bY8.contains(bY7)) {
                        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + bY7.toShortString() + " | Bounds:" + bY8.toShortString());
                    }
                    c(bY8);
                    if (!bY7.isEmpty()) {
                        Object obj2;
                        measuredWidth = android.support.v4.view.d.getAbsoluteGravity(dVar3.pM, T);
                        Object obj3 = null;
                        if ((measuredWidth & 48) == 48) {
                            measuredHeight = (bY7.top - dVar3.topMargin) - dVar3.pO;
                            if (measuredHeight < bY.top) {
                                h(view, bY.top - measuredHeight);
                                obj3 = 1;
                            }
                        }
                        if ((measuredWidth & 80) == 80) {
                            measuredHeight = ((getHeight() - bY7.bottom) - dVar3.bottomMargin) + dVar3.pO;
                            if (measuredHeight < bY.bottom) {
                                h(view, measuredHeight - bY.bottom);
                                obj3 = 1;
                            }
                        }
                        if (obj3 == null) {
                            h(view, 0);
                        }
                        obj3 = null;
                        if ((measuredWidth & 3) == 3) {
                            measuredHeight = (bY7.left - dVar3.leftMargin) - dVar3.pN;
                            if (measuredHeight < bY.left) {
                                g(view, bY.left - measuredHeight);
                                obj3 = 1;
                            }
                        }
                        if ((measuredWidth & 5) == 5) {
                            absoluteGravity = dVar3.pN + ((getWidth() - bY7.right) - dVar3.rightMargin);
                            if (absoluteGravity < bY.right) {
                                g(view, absoluteGravity - bY.right);
                                obj2 = 1;
                                if (obj2 == null) {
                                    g(view, 0);
                                }
                            }
                        }
                        obj2 = obj3;
                        if (obj2 == null) {
                        }
                    }
                    c(bY7);
                }
                if (i != 2) {
                    bY3.set(((d) view.getLayoutParams()).pV);
                    if (!bY3.equals(bY2)) {
                        ((d) view.getLayoutParams()).pV.set(bY2);
                    }
                }
                for (int i4 = i2 + 1; i4 < size; i4++) {
                    View view2 = (View) this.pp.get(i4);
                    d dVar4 = (d) view2.getLayoutParams();
                    behavior = dVar4.pH;
                    if (behavior != null && behavior.e(view)) {
                        if (i == 0 && dVar4.pU) {
                            dVar4.pU = false;
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    z = true;
                                    break;
                                default:
                                    z = behavior.a(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                dVar4.pU = z;
                            }
                        }
                    }
                }
            }
        }
        c(bY);
        c(bY2);
        c(bY3);
    }

    private static void g(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.pN != i) {
            s.r(view, i - dVar.pN);
            dVar.pN = i;
        }
    }

    private static void h(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.pO != i) {
            s.q(view, i - dVar.pO);
            dVar.pO = i;
        }
    }

    public final List<View> p(View view) {
        List K = this.pq.K(view);
        this.ps.clear();
        if (K != null) {
            this.ps.addAll(K);
        }
        return this.ps;
    }

    /* Access modifiers changed, original: final */
    public final List<View> getDependencySortedChildren() {
        bZ();
        return Collections.unmodifiableList(this.pp);
    }

    public final boolean d(View view, int i, int i2) {
        Rect bY = bY();
        u.a((ViewGroup) this, view, bY);
        try {
            boolean contains = bY.contains(i, i2);
            return contains;
        } finally {
            c(bY);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return e(view, i, 0);
    }

    public final boolean e(View view, int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior behavior = dVar.pH;
                if (behavior != null) {
                    boolean a = behavior.a(this, childAt, view, i, i2);
                    i5 = i4 | a;
                    dVar.i(i2, a);
                    i3++;
                    i4 = i5;
                } else {
                    dVar.i(i2, false);
                }
            }
            i5 = i4;
            i3++;
            i4 = i5;
        }
        return i4;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        i(view2, i);
    }

    public final void i(View view, int i) {
        this.pF.Ms = i;
        this.py = view;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    public final void j(View view, int i) {
        this.pF.Ms = 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.Y(i)) {
                Behavior behavior = dVar.pH;
                if (behavior != null) {
                    behavior.a(this, childAt, view, i);
                }
                dVar.i(i, false);
                dVar.pU = false;
            }
        }
        this.py = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m(i4, 0);
    }

    public final void m(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.Y(i2)) {
                    Behavior behavior = dVar.pH;
                    if (behavior != null) {
                        behavior.b(this, childAt, i);
                        i5 = 1;
                        i3++;
                        i4 = i5;
                    }
                }
            }
            i5 = i4;
            i3++;
            i4 = i5;
        }
        if (i4 != 0) {
            X(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    public final void a(View view, int i, int i2, int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            int max;
            int max2;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.Y(i3)) {
                    Behavior behavior = dVar.pH;
                    if (behavior != null) {
                        int[] iArr2 = this.pt;
                        this.pt[1] = 0;
                        iArr2[0] = 0;
                        behavior.a(this, childAt, view, i2, this.pt, i3);
                        if (i > 0) {
                            max = Math.max(i4, this.pt[0]);
                        } else {
                            max = Math.min(i4, this.pt[0]);
                        }
                        if (i2 > 0) {
                            max2 = Math.max(i5, this.pt[1]);
                        } else {
                            max2 = Math.min(i5, this.pt[1]);
                        }
                        obj = 1;
                        i6++;
                        i5 = max2;
                        i4 = max;
                    }
                }
            }
            max2 = i5;
            max = i4;
            i6++;
            i5 = max2;
            i4 = max;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (obj != null) {
            X(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                childAt.getLayoutParams();
            }
        }
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int a;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.Y(0)) {
                    Behavior behavior = dVar.pH;
                    if (behavior != null) {
                        a = behavior.a(this, childAt, view, f, f2) | i2;
                        i++;
                        i2 = a;
                    }
                }
            }
            a = i2;
            i++;
            i2 = a;
        }
        return i2;
    }

    public int getNestedScrollAxes() {
        return this.pF.Ms;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            SparseArray sparseArray = savedState.pX;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = o(childAt).pH;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).pH;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.pX = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((d) view.getLayoutParams()).pH;
        if (behavior == null || !behavior.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void ca() {
        if (VERSION.SDK_INT >= 21) {
            if (s.al(this)) {
                if (this.pE == null) {
                    this.pE = new o() {
                        public final aa a(View view, aa aaVar) {
                            boolean z = true;
                            int i = 0;
                            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                            if (i.equals(coordinatorLayout.mp, aaVar)) {
                                return aaVar;
                            }
                            aa aaVar2;
                            coordinatorLayout.mp = aaVar;
                            boolean z2 = aaVar != null && aaVar.getSystemWindowInsetTop() > 0;
                            coordinatorLayout.pB = z2;
                            if (coordinatorLayout.pB || coordinatorLayout.getBackground() != null) {
                                z = false;
                            }
                            coordinatorLayout.setWillNotDraw(z);
                            if (aaVar.isConsumed()) {
                                aaVar2 = aaVar;
                            } else {
                                int childCount = coordinatorLayout.getChildCount();
                                aa aaVar3 = aaVar;
                                while (i < childCount) {
                                    View childAt = coordinatorLayout.getChildAt(i);
                                    if (s.al(childAt) && ((d) childAt.getLayoutParams()).pH != null) {
                                        aaVar2 = Behavior.b(aaVar3);
                                        if (aaVar2.isConsumed()) {
                                            break;
                                        }
                                    } else {
                                        aaVar2 = aaVar3;
                                    }
                                    i++;
                                    aaVar3 = aaVar2;
                                }
                                aaVar2 = aaVar3;
                            }
                            coordinatorLayout.requestLayout();
                            return aaVar2;
                        }
                    };
                }
                s.a((View) this, this.pE);
                setSystemUiVisibility(ActUtil.HEIGHT);
                return;
            }
            s.a((View) this, null);
        }
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new d();
    }
}
