package com.tencent.p177mm.p612ui.mogic;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.p057v4.p066os.C17451e;
import android.support.p057v4.p066os.C44961d;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.C44962t;
import android.support.p057v4.view.ViewPager.C0435d;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C25363d;
import android.support.p057v4.widget.C0528i;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.internal.Utility;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.mogic.WxViewPager */
public class WxViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<C15913b> COMPARATOR = new C363091();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "WxViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C363102();
    private static final C40877f sPositionComparator = new C40877f();
    private int mActivePointerId = -1;
    private C25365p mAdapter;
    private C24018d mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new C466903();
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<C15913b> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private C0528i mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private C46691e mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private C0435d mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private C0528i mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final C15913b mTempItem = new C15913b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$b */
    static class C15913b {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        C15913b() {
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$d */
    interface C24018d {
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$a */
    interface C30720a {
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$c */
    class C30721c extends C0449a {
        C30721c() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.m2504i(107455);
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(WxViewPager.class.getName());
            C25363d eu = C25363d.m40021eu();
            eu.setScrollable(m48962er());
            if (accessibilityEvent.getEventType() == 4096 && WxViewPager.this.mAdapter != null) {
                eu.setItemCount(WxViewPager.this.mAdapter.getCount());
                eu.setFromIndex(WxViewPager.this.mCurItem);
                eu.setToIndex(WxViewPager.this.mCurItem);
            }
            AppMethodBeat.m2505o(107455);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            AppMethodBeat.m2504i(107456);
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            c0445b.setClassName(WxViewPager.class.getName());
            c0445b.setScrollable(m48962er());
            if (WxViewPager.this.canScrollHorizontally(1)) {
                c0445b.addAction(4096);
            }
            if (WxViewPager.this.canScrollHorizontally(-1)) {
                c0445b.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
            AppMethodBeat.m2505o(107456);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            AppMethodBeat.m2504i(107457);
            if (super.performAccessibilityAction(view, i, bundle)) {
                AppMethodBeat.m2505o(107457);
                return true;
            }
            switch (i) {
                case 4096:
                    if (WxViewPager.this.canScrollHorizontally(1)) {
                        WxViewPager.this.setCurrentItem(WxViewPager.this.mCurItem + 1);
                        AppMethodBeat.m2505o(107457);
                        return true;
                    }
                    AppMethodBeat.m2505o(107457);
                    return false;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    if (WxViewPager.this.canScrollHorizontally(-1)) {
                        WxViewPager.this.setCurrentItem(WxViewPager.this.mCurItem - 1);
                        AppMethodBeat.m2505o(107457);
                        return true;
                    }
                    AppMethodBeat.m2505o(107457);
                    return false;
                default:
                    AppMethodBeat.m2505o(107457);
                    return false;
            }
        }

        /* renamed from: er */
        private boolean m48962er() {
            AppMethodBeat.m2504i(107458);
            if (WxViewPager.this.mAdapter == null || WxViewPager.this.mAdapter.getCount() <= 1) {
                AppMethodBeat.m2505o(107458);
                return false;
            }
            AppMethodBeat.m2505o(107458);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$1 */
    static class C363091 implements Comparator<C15913b> {
        C363091() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C15913b) obj).position - ((C15913b) obj2).position;
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$2 */
    static class C363102 implements Interpolator {
        C363102() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$f */
    static class C40877f implements Comparator<View> {
        C40877f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(107466);
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f17256Nq == layoutParams2.f17256Nq) {
                int i = layoutParams.position - layoutParams2.position;
                AppMethodBeat.m2505o(107466);
                return i;
            } else if (layoutParams.f17256Nq) {
                AppMethodBeat.m2505o(107466);
                return 1;
            } else {
                AppMethodBeat.m2505o(107466);
                return -1;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$LayoutParams */
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        /* renamed from: Nq */
        public boolean f17256Nq;
        /* renamed from: Nr */
        boolean f17257Nr;
        /* renamed from: Ns */
        int f17258Ns;
        public int gravity;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.m2504i(107454);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, WxViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(107454);
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$3 */
    class C466903 implements Runnable {
        C466903() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107453);
            WxViewPager.access$000(WxViewPager.this, 0);
            WxViewPager.this.populate();
            AppMethodBeat.m2505o(107453);
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$SavedState */
    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C44961d.m82262a(new C363111());
        /* renamed from: Nt */
        Parcelable f17921Nt;
        /* renamed from: Nu */
        ClassLoader f17922Nu;
        int position;

        /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$SavedState$1 */
        static class C363111 implements C17451e<SavedState> {
            C363111() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                AppMethodBeat.m2504i(107461);
                SavedState savedState = new SavedState(parcel, classLoader);
                AppMethodBeat.m2505o(107461);
                return savedState;
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(107462);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.f17921Nt, i);
            AppMethodBeat.m2505o(107462);
        }

        public String toString() {
            AppMethodBeat.m2504i(107463);
            String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            AppMethodBeat.m2505o(107463);
            return str;
        }

        static {
            AppMethodBeat.m2504i(107465);
            AppMethodBeat.m2505o(107465);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            AppMethodBeat.m2504i(107464);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.f17921Nt = parcel.readParcelable(classLoader);
            this.f17922Nu = classLoader;
            AppMethodBeat.m2505o(107464);
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.WxViewPager$e */
    class C46691e extends DataSetObserver {
        private C46691e() {
        }

        /* synthetic */ C46691e(WxViewPager wxViewPager, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(107459);
            WxViewPager.this.dataSetChanged();
            AppMethodBeat.m2505o(107459);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(107460);
            WxViewPager.this.dataSetChanged();
            AppMethodBeat.m2505o(107460);
        }
    }

    static /* synthetic */ void access$000(WxViewPager wxViewPager, int i) {
        AppMethodBeat.m2504i(107546);
        wxViewPager.setScrollState(i);
        AppMethodBeat.m2505o(107546);
    }

    static {
        AppMethodBeat.m2504i(107547);
        AppMethodBeat.m2505o(107547);
    }

    public WxViewPager(Context context) {
        super(context);
        AppMethodBeat.m2504i(107467);
        initViewPager();
        AppMethodBeat.m2505o(107467);
    }

    public WxViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107468);
        initViewPager();
        AppMethodBeat.m2505o(107468);
    }

    /* Access modifiers changed, original: 0000 */
    public void initViewPager() {
        AppMethodBeat.m2504i(107469);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = C44962t.m82264a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new C0528i(context);
        this.mRightEdge = new C0528i(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        C0477s.m905a((View) this, new C30721c());
        if (C0477s.m892S(this) == 0) {
            C0477s.m949o(this, 1);
        }
        AppMethodBeat.m2505o(107469);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(107470);
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(107470);
    }

    private void setScrollState(int i) {
        AppMethodBeat.m2504i(107471);
        if (this.mScrollState == i) {
            AppMethodBeat.m2505o(107471);
            return;
        }
        this.mScrollState = i;
        if (this.mPageTransformer != null) {
            enableLayers(i != 0);
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        AppMethodBeat.m2505o(107471);
    }

    public void setAdapter(C25365p c25365p) {
        AppMethodBeat.m2504i(107472);
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                C15913b c15913b = (C15913b) this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, c15913b.position, c15913b.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = c25365p;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new C46691e(this, (byte) 0);
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
                AppMethodBeat.m2505o(107472);
                return;
            } else if (z) {
                requestLayout();
            } else {
                populate();
                AppMethodBeat.m2505o(107472);
                return;
            }
        }
        AppMethodBeat.m2505o(107472);
    }

    private void removeNonDecorViews() {
        AppMethodBeat.m2504i(107473);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f17256Nq) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(107473);
                return;
            }
        }
    }

    public C25365p getAdapter() {
        return this.mAdapter;
    }

    /* Access modifiers changed, original: 0000 */
    public void setOnAdapterChangeListener(C24018d c24018d) {
        this.mAdapterChangeListener = c24018d;
    }

    private int getClientWidth() {
        AppMethodBeat.m2504i(107474);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.m2505o(107474);
        return measuredWidth;
    }

    public void setCurrentItem(int i) {
        boolean z;
        AppMethodBeat.m2504i(107475);
        this.mPopulatePending = false;
        if (this.mFirstLayout) {
            z = false;
        } else {
            z = true;
        }
        setCurrentItemInternal(i, z, false);
        AppMethodBeat.m2505o(107475);
    }

    public void setCurrentItem(int i, boolean z) {
        AppMethodBeat.m2504i(107476);
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
        AppMethodBeat.m2505o(107476);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    /* Access modifiers changed, original: 0000 */
    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(107477);
        setCurrentItemInternal(i, z, z2, 0);
        AppMethodBeat.m2505o(107477);
    }

    /* Access modifiers changed, original: 0000 */
    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        AppMethodBeat.m2504i(107478);
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.m2505o(107478);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = 0; i4 < this.mItems.size(); i4++) {
                    ((C15913b) this.mItems.get(i4)).scrolling = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3 && this.mOnPageChangeListener != null) {
                    this.mOnPageChangeListener.onPageSelected(i);
                }
                if (z3 && this.mInternalPageChangeListener != null) {
                    this.mInternalPageChangeListener.onPageSelected(i);
                }
                requestLayout();
                AppMethodBeat.m2505o(107478);
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
            AppMethodBeat.m2505o(107478);
        } else {
            setScrollingCacheEnabled(false);
            AppMethodBeat.m2505o(107478);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int max;
        AppMethodBeat.m2504i(107479);
        C15913b infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            max = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            smoothScrollTo(max, 0, i2);
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i);
                AppMethodBeat.m2505o(107479);
                return;
            }
        }
        if (z2 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (z2 && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
        completeScroll(false);
        scrollTo(max, 0);
        pageScrolled(max);
        AppMethodBeat.m2505o(107479);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageTransformer(boolean z, C0435d c0435d) {
        int i = 1;
        AppMethodBeat.m2504i(107480);
        if (VERSION.SDK_INT >= 11) {
            boolean z2;
            boolean z3 = c0435d != null;
            if (this.mPageTransformer != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = z3 != z2 ? 1 : 0;
            this.mPageTransformer = c0435d;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i = 2;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = 0;
            }
            if (i2 != 0) {
                populate();
            }
        }
        AppMethodBeat.m2505o(107480);
    }

    /* Access modifiers changed, original: 0000 */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        AppMethodBeat.m2504i(107481);
        if (VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                }
            }
            try {
                if (this.mSetChildrenDrawingOrderEnabled != null) {
                    this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(z)});
                }
                AppMethodBeat.m2505o(107481);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(107481);
    }

    /* Access modifiers changed, original: protected */
    public int getChildDrawingOrder(int i, int i2) {
        AppMethodBeat.m2504i(107482);
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        int i3 = ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).f17258Ns;
        AppMethodBeat.m2505o(107482);
        return i3;
    }

    /* Access modifiers changed, original: 0000 */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        AppMethodBeat.m2504i(107483);
        if (i <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i).append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
        AppMethodBeat.m2505o(107483);
    }

    public void setPageMargin(int i) {
        AppMethodBeat.m2504i(107484);
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
        AppMethodBeat.m2505o(107484);
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(107485);
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
        AppMethodBeat.m2505o(107485);
    }

    public void setPageMarginDrawable(int i) {
        AppMethodBeat.m2504i(107486);
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
        AppMethodBeat.m2505o(107486);
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(107487);
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            AppMethodBeat.m2505o(107487);
            return true;
        }
        AppMethodBeat.m2505o(107487);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.m2504i(107488);
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.m2505o(107488);
    }

    /* Access modifiers changed, original: 0000 */
    public float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.m2504i(107489);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.m2505o(107489);
        return sin;
    }

    /* Access modifiers changed, original: 0000 */
    public void smoothScrollTo(int i, int i2) {
        AppMethodBeat.m2504i(107490);
        smoothScrollTo(i, i2, 0);
        AppMethodBeat.m2505o(107490);
    }

    /* Access modifiers changed, original: 0000 */
    public void smoothScrollTo(int i, int i2, int i3) {
        AppMethodBeat.m2504i(107491);
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.m2505o(107491);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            AppMethodBeat.m2505o(107491);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float distanceInfluenceForSnapDuration = (((float) i6) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 3.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        C0477s.m891R(this);
        AppMethodBeat.m2505o(107491);
    }

    /* Access modifiers changed, original: 0000 */
    public C15913b addNewItem(int i, int i2) {
        AppMethodBeat.m2504i(107492);
        C15913b c15913b = new C15913b();
        c15913b.position = i;
        c15913b.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        c15913b.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(c15913b);
        } else {
            this.mItems.add(i2, c15913b);
        }
        AppMethodBeat.m2505o(107492);
        return c15913b;
    }

    /* Access modifiers changed, original: 0000 */
    public void dataSetChanged() {
        boolean z;
        AppMethodBeat.m2504i(107493);
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        int i = this.mCurItem;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = z;
        while (i2 < this.mItems.size()) {
            C15913b c15913b = (C15913b) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(c15913b.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (i3 == 0) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        i3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, c15913b.position, c15913b.object);
                    if (this.mCurItem == c15913b.position) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                } else if (c15913b.position != itemPosition) {
                    if (c15913b.position == this.mCurItem) {
                        i = itemPosition;
                    }
                    c15913b.position = itemPosition;
                    z2 = true;
                }
            }
            i2++;
        }
        if (i3 != 0) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z2) {
            i3 = getChildCount();
            for (i2 = 0; i2 < i3; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f17256Nq) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
        AppMethodBeat.m2505o(107493);
    }

    /* Access modifiers changed, original: 0000 */
    public void populate() {
        AppMethodBeat.m2504i(107494);
        populate(this.mCurItem);
        AppMethodBeat.m2505o(107494);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:30:0x00f0, code skipped:
            if (r0.position == r14.mCurItem) goto L_0x00f2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int i) {
        AppMethodBeat.m2504i(107495);
        C15913b c15913b = null;
        int i2 = 2;
        if (this.mCurItem != i) {
            i2 = this.mCurItem < i ? 66 : 17;
            c15913b = infoForPosition(this.mCurItem);
            this.mCurItem = i;
        }
        int i3 = i2;
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            AppMethodBeat.m2505o(107495);
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
            AppMethodBeat.m2505o(107495);
        } else if (getWindowToken() == null) {
            AppMethodBeat.m2505o(107495);
        } else {
            this.mAdapter.startUpdate((ViewGroup) this);
            i2 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i2);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, i2 + this.mCurItem);
            if (count != this.mExpectedAdapterCount) {
                String resourceName;
                try {
                    resourceName = getResources().getResourceName(getId());
                } catch (NotFoundException e) {
                    resourceName = Integer.toHexString(getId());
                }
                IllegalStateException illegalStateException = new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + resourceName + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
                AppMethodBeat.m2505o(107495);
                throw illegalStateException;
            }
            int i4;
            C15913b c15913b2;
            C15913b c15913b3;
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.mItems.size()) {
                    break;
                }
                c15913b2 = (C15913b) this.mItems.get(i4);
                if (c15913b2.position < this.mCurItem) {
                    i2 = i4 + 1;
                }
            }
            c15913b2 = null;
            if (c15913b2 != null || count <= 0) {
                c15913b3 = c15913b2;
            } else {
                c15913b3 = addNewItem(this.mCurItem, i4);
            }
            if (c15913b3 != null) {
                float f;
                float f2 = 0.0f;
                int i5 = i4 - 1;
                c15913b2 = i5 >= 0 ? (C15913b) this.mItems.get(i5) : null;
                int clientWidth = getClientWidth();
                if (clientWidth <= 0) {
                    f = 0.0f;
                } else {
                    f = (2.0f - c15913b3.widthFactor) + (((float) getPaddingLeft()) / ((float) clientWidth));
                }
                int i6 = this.mCurItem - 1;
                int i7 = i4;
                while (i6 >= 0) {
                    if (f2 >= f && i6 < max) {
                        if (c15913b2 == null) {
                            break;
                        } else if (i6 != c15913b2.position || c15913b2.scrolling) {
                            i4 = i5;
                        } else {
                            this.mItems.remove(i5);
                            this.mAdapter.destroyItem((ViewGroup) this, i6, c15913b2.object);
                            i4 = i5 - 1;
                            i5 = i7 - 1;
                            if (i4 >= 0) {
                                c15913b2 = (C15913b) this.mItems.get(i4);
                            } else {
                                c15913b2 = null;
                            }
                            i7 = i5;
                        }
                    } else if (c15913b2 == null || i6 != c15913b2.position) {
                        f2 += addNewItem(i6, i5 + 1).widthFactor;
                        i7++;
                        c15913b2 = i5 >= 0 ? (C15913b) this.mItems.get(i5) : null;
                        i4 = i5;
                    } else {
                        f2 += c15913b2.widthFactor;
                        i4 = i5 - 1;
                        c15913b2 = i4 >= 0 ? (C15913b) this.mItems.get(i4) : null;
                    }
                    i6--;
                    i5 = i4;
                }
                f = c15913b3.widthFactor;
                i5 = i7 + 1;
                if (f < 2.0f) {
                    float f3;
                    C15913b c15913b4 = i5 < this.mItems.size() ? (C15913b) this.mItems.get(i5) : null;
                    if (clientWidth <= 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                    }
                    i6 = this.mCurItem + 1;
                    c15913b2 = c15913b4;
                    while (i6 < count) {
                        if (f >= f3 && i6 > min) {
                            if (c15913b2 == null) {
                                break;
                            } else if (i6 == c15913b2.position && !c15913b2.scrolling) {
                                this.mItems.remove(i5);
                                this.mAdapter.destroyItem((ViewGroup) this, i6, c15913b2.object);
                                c15913b2 = i5 < this.mItems.size() ? (C15913b) this.mItems.get(i5) : null;
                            }
                        } else if (c15913b2 == null || i6 != c15913b2.position) {
                            c15913b2 = addNewItem(i6, i5);
                            i5++;
                            f += c15913b2.widthFactor;
                            c15913b2 = i5 < this.mItems.size() ? (C15913b) this.mItems.get(i5) : null;
                        } else {
                            f += c15913b2.widthFactor;
                            i5++;
                            c15913b2 = i5 < this.mItems.size() ? (C15913b) this.mItems.get(i5) : null;
                        }
                        i6++;
                    }
                }
                calculatePageOffsets(c15913b3, i7, c15913b);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, c15913b3 != null ? c15913b3.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            i4 = getChildCount();
            for (int i8 = 0; i8 < i4; i8++) {
                View childAt = getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f17258Ns = i8;
                if (!layoutParams.f17256Nq && layoutParams.widthFactor == 0.0f) {
                    C15913b infoForChild = infoForChild(childAt);
                    if (infoForChild != null) {
                        layoutParams.widthFactor = infoForChild.widthFactor;
                        layoutParams.position = infoForChild.position;
                    }
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                c15913b2 = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (c15913b2 == null || c15913b2.position != this.mCurItem) {
                    for (i2 = 0; i2 < getChildCount(); i2++) {
                        View childAt2 = getChildAt(i2);
                        C15913b infoForChild2 = infoForChild(childAt2);
                        if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(i3)) {
                            break;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(107495);
        }
    }

    private void sortChildDrawingOrder() {
        AppMethodBeat.m2504i(107496);
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
        AppMethodBeat.m2505o(107496);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A:{LOOP_END, LOOP:2: B:18:0x005f->B:20:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A:{LOOP_END, LOOP:5: B:33:0x00a8->B:35:0x00ac} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void calculatePageOffsets(C15913b c15913b, int i, C15913b c15913b2) {
        float f;
        C15913b c15913b3;
        int i2;
        AppMethodBeat.m2504i(107497);
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c15913b2 != null) {
            clientWidth = c15913b2.position;
            float f2;
            int i3;
            int i4;
            Object obj;
            if (clientWidth < c15913b.position) {
                f2 = (c15913b2.offset + c15913b2.widthFactor) + f;
                i3 = clientWidth + 1;
                i4 = 0;
                while (i3 <= c15913b.position && i4 < this.mItems.size()) {
                    obj = this.mItems.get(i4);
                    while (true) {
                        c15913b3 = (C15913b) obj;
                        if (i3 <= c15913b3.position || i4 >= this.mItems.size() - 1) {
                            while (i3 < c15913b3.position) {
                                f2 += this.mAdapter.getPageWidth(i3) + f;
                                i3++;
                            }
                        } else {
                            i4++;
                            obj = this.mItems.get(i4);
                        }
                    }
                    while (i3 < c15913b3.position) {
                    }
                    c15913b3.offset = f2;
                    f2 += c15913b3.widthFactor + f;
                    i3++;
                }
            } else if (clientWidth > c15913b.position) {
                i4 = this.mItems.size() - 1;
                f2 = c15913b2.offset;
                clientWidth--;
                while (true) {
                    i3 = clientWidth;
                    if (i3 < c15913b.position || i4 < 0) {
                        break;
                    }
                    obj = this.mItems.get(i4);
                    while (true) {
                        c15913b3 = (C15913b) obj;
                        if (i3 >= c15913b3.position || i4 <= 0) {
                            while (i3 > c15913b3.position) {
                                f2 -= this.mAdapter.getPageWidth(i3) + f;
                                i3--;
                            }
                        } else {
                            i4--;
                            obj = this.mItems.get(i4);
                        }
                    }
                    while (i3 > c15913b3.position) {
                    }
                    f2 -= c15913b3.widthFactor + f;
                    c15913b3.offset = f2;
                    clientWidth = i3 - 1;
                }
            }
        }
        int size = this.mItems.size();
        float f3 = c15913b.offset;
        int i5 = c15913b.position - 1;
        this.mFirstOffset = c15913b.position == 0 ? c15913b.offset : -3.4028235E38f;
        this.mLastOffset = c15913b.position == count + -1 ? (c15913b.offset + c15913b.widthFactor) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            c15913b3 = (C15913b) this.mItems.get(i2);
            while (i5 > c15913b3.position) {
                f3 -= this.mAdapter.getPageWidth(i5) + f;
                i5--;
            }
            f3 -= c15913b3.widthFactor + f;
            c15913b3.offset = f3;
            if (c15913b3.position == 0) {
                this.mFirstOffset = f3;
            }
            i5--;
        }
        f3 = (c15913b.offset + c15913b.widthFactor) + f;
        i5 = c15913b.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            c15913b3 = (C15913b) this.mItems.get(i2);
            while (i5 < c15913b3.position) {
                f3 += this.mAdapter.getPageWidth(i5) + f;
                i5++;
            }
            if (c15913b3.position == count - 1) {
                this.mLastOffset = (c15913b3.widthFactor + f3) - 1.0f;
            }
            c15913b3.offset = f3;
            f3 += c15913b3.widthFactor + f;
            i5++;
        }
        this.mNeedCalculatePageOffsets = false;
        AppMethodBeat.m2505o(107497);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(107498);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.f17921Nt = this.mAdapter.saveState();
        }
        AppMethodBeat.m2505o(107498);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(107499);
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(savedState.f17921Nt, savedState.f17922Nu);
                setCurrentItemInternal(savedState.position, false, true);
                AppMethodBeat.m2505o(107499);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.f17921Nt;
            this.mRestoredClassLoader = savedState.f17922Nu;
            AppMethodBeat.m2505o(107499);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.m2505o(107499);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        Object generateLayoutParams;
        AppMethodBeat.m2504i(107500);
        if (checkLayoutParams(layoutParams)) {
            LayoutParams generateLayoutParams2 = layoutParams;
        } else {
            generateLayoutParams2 = generateLayoutParams(layoutParams);
        }
        Assert.assertNotNull(generateLayoutParams2);
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams2;
        layoutParams2.f17256Nq |= view instanceof C30720a;
        if (!this.mInLayout) {
            super.addView(view, i, generateLayoutParams2);
            AppMethodBeat.m2505o(107500);
        } else if (layoutParams2.f17256Nq) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot add pager decor view during layout");
            AppMethodBeat.m2505o(107500);
            throw illegalStateException;
        } else {
            layoutParams2.f17257Nr = true;
            addViewInLayout(view, i, generateLayoutParams2);
            AppMethodBeat.m2505o(107500);
        }
    }

    public void removeView(View view) {
        AppMethodBeat.m2504i(107501);
        if (this.mInLayout) {
            removeViewInLayout(view);
            AppMethodBeat.m2505o(107501);
            return;
        }
        super.removeView(view);
        AppMethodBeat.m2505o(107501);
    }

    /* Access modifiers changed, original: 0000 */
    public C15913b infoForChild(View view) {
        AppMethodBeat.m2504i(107502);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mItems.size()) {
                C15913b c15913b = (C15913b) this.mItems.get(i2);
                if (this.mAdapter.isViewFromObject(view, c15913b.object)) {
                    AppMethodBeat.m2505o(107502);
                    return c15913b;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(107502);
                return null;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public C15913b infoForAnyChild(View view) {
        AppMethodBeat.m2504i(107503);
        while (true) {
            WxViewPager parent = view.getParent();
            if (parent == this) {
                C15913b infoForChild = infoForChild(view);
                AppMethodBeat.m2505o(107503);
                return infoForChild;
            } else if (parent == null || !(parent instanceof View)) {
                AppMethodBeat.m2505o(107503);
            } else {
                view = parent;
            }
        }
        AppMethodBeat.m2505o(107503);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public C15913b infoForPosition(int i) {
        AppMethodBeat.m2504i(107504);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mItems.size()) {
                C15913b c15913b = (C15913b) this.mItems.get(i3);
                if (c15913b.position == i) {
                    AppMethodBeat.m2505o(107504);
                    return c15913b;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(107504);
                return null;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(107505);
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        AppMethodBeat.m2505o(107505);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int i4;
        AppMethodBeat.m2504i(107506);
        setMeasuredDimension(WxViewPager.getDefaultSize(0, i), WxViewPager.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f17256Nq) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & 112;
                    i3 = C8415j.INVALID_ID;
                    i4 = C8415j.INVALID_ID;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = ErrorDialogData.SUPPRESSED;
                    } else if (obj2 != null) {
                        i4 = ErrorDialogData.SUPPRESSED;
                    }
                    if (layoutParams.width != -2) {
                        i6 = ErrorDialogData.SUPPRESSED;
                        i7 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = paddingLeft;
                        i6 = i3;
                    }
                    if (layoutParams.height != -2) {
                        i4 = ErrorDialogData.SUPPRESSED;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj == null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj == null) {
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(paddingLeft, ErrorDialogData.SUPPRESSED);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, ErrorDialogData.SUPPRESSED);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((layoutParams == null || !layoutParams.f17256Nq) && layoutParams != null) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * ((float) paddingLeft)), ErrorDialogData.SUPPRESSED), this.mChildHeightMeasureSpec);
                }
            }
        }
        AppMethodBeat.m2505o(107506);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107507);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
        AppMethodBeat.m2505o(107507);
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107508);
        if (i2 <= 0 || this.mItems.isEmpty()) {
            C15913b infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
            AppMethodBeat.m2505o(107508);
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.mScroller.isFinished()) {
            int duration = this.mScroller.getDuration() - this.mScroller.timePassed();
            C15913b infoForPosition2 = infoForPosition(this.mCurItem);
            if (infoForPosition2 != null) {
                this.mScroller.startScroll(paddingLeft, 0, (int) (infoForPosition2.offset * ((float) i)), 0, duration);
            }
        }
        AppMethodBeat.m2505o(107508);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int i5;
        AppMethodBeat.m2504i(107509);
        int childCount = getChildCount();
        int i6 = i3 - i;
        int i7 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            int max2;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f17256Nq) {
                    int i11 = layoutParams.gravity & 112;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i5 = paddingRight;
                            i10 = paddingLeft;
                            break;
                        case 3:
                            i10 = paddingLeft + childAt.getMeasuredWidth();
                            max = paddingLeft;
                            i5 = paddingRight;
                            break;
                        case 5:
                            max = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            i5 = paddingRight + childAt.getMeasuredWidth();
                            i10 = paddingLeft;
                            break;
                        default:
                            max = paddingLeft;
                            i5 = paddingRight;
                            i10 = paddingLeft;
                            break;
                    }
                    switch (i11) {
                        case 16:
                            max2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            paddingRight = paddingTop;
                            break;
                        case 48:
                            paddingRight = paddingTop + childAt.getMeasuredHeight();
                            max2 = paddingTop;
                            break;
                        case 80:
                            max2 = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            paddingRight = paddingTop;
                            break;
                        default:
                            max2 = paddingTop;
                            paddingRight = paddingTop;
                            break;
                    }
                    paddingTop = max + scrollX;
                    childAt.layout(paddingTop, max2, childAt.getMeasuredWidth() + paddingTop, childAt.getMeasuredHeight() + max2);
                    max2 = i8 + 1;
                    paddingTop = paddingRight;
                    i9++;
                    i8 = max2;
                    paddingRight = i5;
                    paddingLeft = i10;
                }
            }
            max2 = i8;
            i5 = paddingRight;
            i10 = paddingLeft;
            i9++;
            i8 = max2;
            paddingRight = i5;
            paddingLeft = i10;
        }
        i5 = (i6 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f17256Nq) {
                    C15913b infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        max = ((int) (infoForChild.offset * ((float) i5))) + paddingLeft;
                        if (layoutParams.f17257Nr) {
                            layoutParams.f17257Nr = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * ((float) i5)), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, ErrorDialogData.SUPPRESSED));
                        }
                        childAt2.layout(max, paddingTop, childAt2.getMeasuredWidth() + max, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i7 - paddingBottom;
        this.mDecorChildCount = i8;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
        AppMethodBeat.m2505o(107509);
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(107510);
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            AppMethodBeat.m2505o(107510);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C0477s.m891R(this);
        AppMethodBeat.m2505o(107510);
    }

    private boolean pageScrolled(int i) {
        AppMethodBeat.m2504i(107511);
        IllegalStateException illegalStateException;
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                AppMethodBeat.m2505o(107511);
                return false;
            }
            illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
            AppMethodBeat.m2505o(107511);
            throw illegalStateException;
        }
        C15913b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition == null) {
            AppMethodBeat.m2505o(107511);
            return false;
        }
        int clientWidth = getClientWidth();
        int i2 = this.mPageMargin + clientWidth;
        float f = ((float) this.mPageMargin) / ((float) clientWidth);
        int i3 = infoForCurrentScrollPosition.position;
        float f2 = ((((float) i) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f);
        clientWidth = (int) (((float) i2) * f2);
        this.mCalledSuper = false;
        onPageScrolled(i3, f2, clientWidth);
        if (this.mCalledSuper) {
            AppMethodBeat.m2505o(107511);
            return true;
        }
        illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
        AppMethodBeat.m2505o(107511);
        throw illegalStateException;
    }

    /* Access modifiers changed, original: protected */
    public void onPageScrolled(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        AppMethodBeat.m2504i(107512);
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f17256Nq) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i3 = paddingLeft;
                            break;
                        case 3:
                            i3 = paddingLeft + childAt.getWidth();
                            max = paddingLeft;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            break;
                        default:
                            max = paddingLeft;
                            i3 = paddingLeft;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i3 = paddingLeft;
                }
                i4++;
                paddingLeft = i3;
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mPageTransformer != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).f17256Nq) {
                    this.mPageTransformer.mo959j(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
        AppMethodBeat.m2505o(107512);
    }

    private void completeScroll(boolean z) {
        int scrollX;
        AppMethodBeat.m2504i(107513);
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.mItems.size(); scrollX++) {
            C15913b c15913b = (C15913b) this.mItems.get(scrollX);
            if (c15913b.scrolling) {
                c15913b.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                C0477s.m934b((View) this, this.mEndScrollRunnable);
                AppMethodBeat.m2505o(107513);
                return;
            }
            this.mEndScrollRunnable.run();
        }
        AppMethodBeat.m2505o(107513);
    }

    /* Access modifiers changed, original: protected */
    public boolean isGutterDrag(float f, float f2) {
        AppMethodBeat.m2504i(107514);
        if ((f >= ((float) this.mGutterSize) || f2 <= 0.0f) && (f <= ((float) (getWidth() - this.mGutterSize)) || f2 >= 0.0f)) {
            AppMethodBeat.m2505o(107514);
            return false;
        }
        AppMethodBeat.m2505o(107514);
        return true;
    }

    private void enableLayers(boolean z) {
        AppMethodBeat.m2504i(107515);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            C0477s.m950p(getChildAt(i), i2);
        }
        AppMethodBeat.m2505o(107515);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107516);
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            AppMethodBeat.m2505o(107516);
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                AppMethodBeat.m2505o(107516);
                return true;
            } else if (this.mIsUnableToDrag) {
                AppMethodBeat.m2505o(107516);
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    setScrollState(1);
                    break;
                }
                completeScroll(false);
                this.mIsBeingDragged = false;
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.mLastMotionX;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.mInitialMotionY);
                    if (!(f == 0.0f || isGutterDrag(this.mLastMotionX, f))) {
                        if (canScroll(this, false, (int) f, (int) x2, (int) y)) {
                            this.mLastMotionX = x2;
                            this.mLastMotionY = y;
                            this.mIsUnableToDrag = true;
                            AppMethodBeat.m2505o(107516);
                            return false;
                        }
                    }
                    if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                        this.mIsBeingDragged = true;
                        setScrollState(1);
                        this.mLastMotionX = f > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                        this.mLastMotionY = y;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.mTouchSlop)) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        C0477s.m891R(this);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        boolean z = this.mIsBeingDragged;
        AppMethodBeat.m2505o(107516);
        return z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(107517);
        if (this.mFakeDragging) {
            AppMethodBeat.m2505o(107517);
            return true;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            AppMethodBeat.m2505o(107517);
            return false;
        } else if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            AppMethodBeat.m2505o(107517);
            return false;
        } else {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            float x;
            int clientWidth;
            float f;
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    setScrollState(1);
                    x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    x = motionEvent.getY();
                    this.mInitialMotionY = x;
                    this.mLastMotionY = x;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    break;
                case 1:
                    if (this.mIsBeingDragged) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                        int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                        this.mPopulatePending = true;
                        clientWidth = getClientWidth();
                        int scrollX = getScrollX();
                        C15913b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                        if (infoForCurrentScrollPosition != null) {
                            int i = infoForCurrentScrollPosition.position;
                            f = ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor;
                            clientWidth = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (clientWidth < 0) {
                                clientWidth = 0;
                            }
                            setCurrentItemInternal(determineTargetPage(i, f, xVelocity, (int) (motionEvent.getX(clientWidth) - this.mInitialMotionX)), true, true, xVelocity);
                        }
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.mRightEdge.mo1292eL() | this.mLeftEdge.mo1292eL();
                        break;
                    }
                    break;
                case 2:
                    if (!this.mIsBeingDragged) {
                        clientWidth = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x2 = motionEvent.getX(clientWidth);
                        f = Math.abs(x2 - this.mLastMotionX);
                        float y = motionEvent.getY(clientWidth);
                        x = Math.abs(y - this.mLastMotionY);
                        if (f > ((float) this.mTouchSlop) && f > x) {
                            this.mIsBeingDragged = true;
                            if (x2 - this.mInitialMotionX > 0.0f) {
                                x = this.mInitialMotionX + ((float) this.mTouchSlop);
                            } else {
                                x = this.mInitialMotionX - ((float) this.mTouchSlop);
                            }
                            this.mLastMotionX = x;
                            this.mLastMotionY = y;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId))) | 0;
                        break;
                    }
                    break;
                case 3:
                    if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurItem, true, 0, false);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.mRightEdge.mo1292eL() | this.mLeftEdge.mo1292eL();
                        break;
                    }
                    break;
                case 5:
                    clientWidth = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(clientWidth);
                    this.mActivePointerId = motionEvent.getPointerId(clientWidth);
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    break;
            }
            if (z) {
                C0477s.m891R(this);
            }
            AppMethodBeat.m2505o(107517);
            return true;
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(107518);
        float f3 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        C15913b c15913b = (C15913b) this.mItems.get(0);
        C15913b c15913b2 = (C15913b) this.mItems.get(this.mItems.size() - 1);
        if (c15913b.position != 0) {
            f4 = ((float) clientWidth) * c15913b.offset;
            z = false;
        } else {
            z = true;
        }
        if (c15913b2.position != this.mAdapter.getCount() - 1) {
            f2 = c15913b2.offset * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.mo1289F(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.mRightEdge.mo1289F(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        AppMethodBeat.m2505o(107518);
        return z3;
    }

    private C15913b infoForCurrentScrollPosition() {
        float f;
        AppMethodBeat.m2504i(107519);
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        int i = -1;
        Object obj = 1;
        int i2 = 0;
        C15913b c15913b = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.mItems.size()) {
            C15913b c15913b2;
            C15913b c15913b3 = (C15913b) this.mItems.get(i2);
            if (obj != null || c15913b3.position == i + 1) {
                c15913b2 = c15913b3;
            } else {
                c15913b3 = this.mTempItem;
                c15913b3.offset = (f3 + f2) + f;
                c15913b3.position = i + 1;
                c15913b3.widthFactor = this.mAdapter.getPageWidth(c15913b3.position);
                i2--;
                c15913b2 = c15913b3;
            }
            f3 = c15913b2.offset;
            float f4 = (c15913b2.widthFactor + f3) + f;
            if (obj == null && scrollX < f3) {
                AppMethodBeat.m2505o(107519);
                return c15913b;
            } else if (scrollX < f4 || i2 == this.mItems.size() - 1) {
                AppMethodBeat.m2505o(107519);
                return c15913b2;
            } else {
                i = c15913b2.position;
                f2 = c15913b2.widthFactor;
                i2++;
                c15913b = c15913b2;
                obj = null;
            }
        }
        AppMethodBeat.m2505o(107519);
        return c15913b;
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        AppMethodBeat.m2504i(107520);
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i = (int) ((i >= this.mCurItem ? 0.6f : 0.4f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() > 0) {
            i = Math.max(firstItemPosForDetermine(), Math.min(i, lastItemPosForDetermine()));
        }
        AppMethodBeat.m2505o(107520);
        return i;
    }

    public int firstItemPosForDetermine() {
        AppMethodBeat.m2504i(107521);
        int i = ((C15913b) this.mItems.get(0)).position;
        AppMethodBeat.m2505o(107521);
        return i;
    }

    public int lastItemPosForDetermine() {
        AppMethodBeat.m2504i(107522);
        int i = ((C15913b) this.mItems.get(this.mItems.size() - 1)).position;
        AppMethodBeat.m2505o(107522);
        return i;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(107523);
        super.draw(canvas);
        int i = 0;
        int O = C0477s.m888O(this);
        if (O == 0 || (O == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            int width;
            if (!this.mLeftEdge.f704QM.isFinished()) {
                O = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(i, width);
                i = this.mLeftEdge.draw(canvas) | 0;
                canvas.restoreToCount(O);
            }
            if (!this.mRightEdge.f704QM.isFinished()) {
                O = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width));
                this.mRightEdge.setSize(height, width);
                i |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(O);
            }
        } else {
            this.mLeftEdge.f704QM.finish();
            this.mRightEdge.f704QM.finish();
        }
        if (i != 0) {
            C0477s.m891R(this);
        }
        AppMethodBeat.m2505o(107523);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107524);
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.mPageMargin) / ((float) width);
            C15913b c15913b = (C15913b) this.mItems.get(0);
            float f2 = c15913b.offset;
            int size = this.mItems.size();
            int i = c15913b.position;
            int i2 = ((C15913b) this.mItems.get(size - 1)).position;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                float f3;
                while (i4 > c15913b.position && i3 < size) {
                    i3++;
                    c15913b = (C15913b) this.mItems.get(i3);
                }
                if (i4 == c15913b.position) {
                    f3 = (c15913b.offset + c15913b.widthFactor) * ((float) width);
                    f2 = (c15913b.offset + c15913b.widthFactor) + f;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.mPageMargin) + f3 > ((float) scrollX)) {
                    this.mMarginDrawable.setBounds((int) f3, this.mTopPageBounds, (int) ((((float) this.mPageMargin) + f3) + 0.5f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f3 > ((float) (scrollX + width))) {
                    break;
                }
            }
        }
        AppMethodBeat.m2505o(107524);
    }

    public boolean beginFakeDrag() {
        AppMethodBeat.m2504i(107525);
        if (this.mIsBeingDragged) {
            AppMethodBeat.m2505o(107525);
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        AppMethodBeat.m2505o(107525);
        return true;
    }

    public void endFakeDrag() {
        AppMethodBeat.m2504i(107526);
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C15913b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            if (infoForCurrentScrollPosition != null) {
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            AppMethodBeat.m2505o(107526);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        AppMethodBeat.m2505o(107526);
        throw illegalStateException;
    }

    public void fakeDragBy(float f) {
        AppMethodBeat.m2504i(107527);
        if (this.mFakeDragging) {
            float f2;
            float f3;
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.mFirstOffset;
            float f5 = ((float) clientWidth) * this.mLastOffset;
            C15913b c15913b = (C15913b) this.mItems.get(0);
            C15913b c15913b2 = (C15913b) this.mItems.get(this.mItems.size() - 1);
            if (c15913b.position != 0) {
                f2 = c15913b.offset * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (c15913b2.position != this.mAdapter.getCount() - 1) {
                f3 = c15913b2.offset * ((float) clientWidth);
            } else {
                f3 = f5;
            }
            if (scrollX >= f2) {
                if (scrollX > f3) {
                    f2 = f3;
                } else {
                    f2 = scrollX;
                }
            }
            this.mLastMotionX += f2 - ((float) ((int) f2));
            scrollTo((int) f2, getScrollY());
            pageScrolled((int) f2);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            AppMethodBeat.m2505o(107527);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        AppMethodBeat.m2505o(107527);
        throw illegalStateException;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void endDrag() {
        AppMethodBeat.m2504i(107529);
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.m2505o(107529);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        AppMethodBeat.m2504i(107530);
        if (this.mAdapter == null) {
            AppMethodBeat.m2505o(107530);
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                AppMethodBeat.m2505o(107530);
                return true;
            }
            AppMethodBeat.m2505o(107530);
            return false;
        } else if (i <= 0) {
            AppMethodBeat.m2505o(107530);
            return false;
        } else if (scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            AppMethodBeat.m2505o(107530);
            return true;
        } else {
            AppMethodBeat.m2505o(107530);
            return false;
        }
    }

    public void setLastMotion(float f, float f2) {
        this.mLastMotionX = f;
        this.mLastMotionY = f2;
    }

    /* Access modifiers changed, original: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        AppMethodBeat.m2504i(107531);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop()) && childAt.isEnabled()) {
                        AppMethodBeat.m2505o(107531);
                        return true;
                    }
                }
            }
        }
        if (z && C0477s.m947m(view, -i)) {
            AppMethodBeat.m2505o(107531);
            return true;
        }
        AppMethodBeat.m2505o(107531);
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(107532);
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            AppMethodBeat.m2505o(107532);
            return true;
        }
        AppMethodBeat.m2505o(107532);
        return false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(107533);
        boolean z = false;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    z = arrowScroll(17);
                    break;
                case 22:
                    z = arrowScroll(66);
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    if (VERSION.SDK_INT >= 11) {
                        if (!keyEvent.hasNoModifiers()) {
                            if (keyEvent.hasModifiers(1)) {
                                z = arrowScroll(1);
                                break;
                            }
                        }
                        z = arrowScroll(2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(107533);
        return z;
    }

    /* JADX WARNING: Missing block: B:39:0x00c9, code skipped:
            if (r10 != 2) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int i) {
        View view;
        boolean pageLeft;
        AppMethodBeat.m2504i(107534);
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (WxViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (obj = findFocus.getParent(); obj instanceof ViewGroup; obj = obj.getParent()) {
                        stringBuilder.append(" => ").append(obj.getClass().getSimpleName());
                    }
                    new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        findFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findFocus == null || findFocus == view) {
            if (i == 17 || i == 1) {
                pageLeft = pageLeft();
            } else {
                if (i != 66) {
                }
                pageLeft = pageRight();
            }
        } else if (i == 17) {
            pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findFocus.requestFocus() : pageLeft();
        } else {
            if (i == 66) {
                int i2 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                int i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i2 > i3) {
                    pageLeft = findFocus.requestFocus();
                }
                pageLeft = pageRight();
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        AppMethodBeat.m2505o(107534);
        return pageLeft;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        AppMethodBeat.m2504i(107535);
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            AppMethodBeat.m2505o(107535);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        WxViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        AppMethodBeat.m2505o(107535);
        return rect2;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean pageLeft() {
        AppMethodBeat.m2504i(107536);
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, true);
            AppMethodBeat.m2505o(107536);
            return true;
        }
        AppMethodBeat.m2505o(107536);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean pageRight() {
        AppMethodBeat.m2504i(107537);
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            AppMethodBeat.m2505o(107537);
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        AppMethodBeat.m2505o(107537);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        AppMethodBeat.m2504i(107538);
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C15913b infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if (descendantFocusability != 262144 || size == arrayList.size()) {
            if (!isFocusable()) {
                AppMethodBeat.m2505o(107538);
                return;
            } else if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                AppMethodBeat.m2505o(107538);
                return;
            } else {
                arrayList.add(this);
            }
        }
        AppMethodBeat.m2505o(107538);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        AppMethodBeat.m2504i(107539);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C15913b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
        AppMethodBeat.m2505o(107539);
    }

    /* Access modifiers changed, original: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        AppMethodBeat.m2504i(107540);
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            i2 = -1;
            childCount = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                C15913b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    AppMethodBeat.m2505o(107540);
                    return true;
                }
            }
            i3 += i2;
        }
        AppMethodBeat.m2505o(107540);
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(107541);
        if (accessibilityEvent.getEventType() == 4096) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.m2505o(107541);
            return dispatchPopulateAccessibilityEvent;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C15913b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    AppMethodBeat.m2505o(107541);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(107541);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.m2504i(107542);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.m2505o(107542);
        return layoutParams;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.m2504i(107543);
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        AppMethodBeat.m2505o(107543);
        return generateDefaultLayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.m2504i(107544);
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            AppMethodBeat.m2505o(107544);
            return true;
        }
        AppMethodBeat.m2505o(107544);
        return false;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.m2504i(107545);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.m2505o(107545);
        return layoutParams;
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107528);
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                actionIndex = 1;
            } else {
                actionIndex = 0;
            }
            this.mLastMotionX = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
        AppMethodBeat.m2505o(107528);
    }
}
