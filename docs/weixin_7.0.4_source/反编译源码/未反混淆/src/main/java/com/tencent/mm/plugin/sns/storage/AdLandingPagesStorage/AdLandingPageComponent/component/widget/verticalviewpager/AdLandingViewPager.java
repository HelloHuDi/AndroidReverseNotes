package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

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
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.widget.i;
import android.support.v4.widget.j;
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

public class AdLandingViewPager extends ViewGroup {
    private static final Comparator<b> COMPARATOR = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final f rcO = new f();
    private static final Interpolator sInterpolator = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int mActivePointerId = -1;
    private p mAdapter;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(37504);
            AdLandingViewPager.a(AdLandingViewPager.this);
            AdLandingViewPager.this.populate();
            AppMethodBeat.o(37504);
        }
    };
    private int mExpectedAdapterCount;
    long mFakeDragBeginTime;
    boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems = new ArrayList();
    float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private i mLeftEdge;
    private Drawable mMarginDrawable;
    int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    android.support.v4.view.ViewPager.d mPageTransformer;
    boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private i mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;
    private final b rcL = new b();
    private e rcM;
    private d rcN;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.d.a(new android.support.v4.os.e<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                AppMethodBeat.i(37512);
                SavedState savedState = new SavedState(parcel, classLoader);
                AppMethodBeat.o(37512);
                return savedState;
            }
        });
        Parcelable Nt;
        ClassLoader Nu;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(37513);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.Nt, i);
            AppMethodBeat.o(37513);
        }

        public String toString() {
            AppMethodBeat.i(37514);
            String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            AppMethodBeat.o(37514);
            return str;
        }

        static {
            AppMethodBeat.i(37516);
            AppMethodBeat.o(37516);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            AppMethodBeat.i(37515);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.Nt = parcel.readParcelable(classLoader);
            this.Nu = classLoader;
            AppMethodBeat.o(37515);
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(37517);
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.Nq == layoutParams2.Nq) {
                int i = layoutParams.position - layoutParams2.position;
                AppMethodBeat.o(37517);
                return i;
            } else if (layoutParams.Nq) {
                AppMethodBeat.o(37517);
                return 1;
            } else {
                AppMethodBeat.o(37517);
                return -1;
            }
        }
    }

    static class b {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        b() {
        }
    }

    class c extends android.support.v4.view.a {
        c() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(37506);
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
            android.support.v4.view.a.d eu = android.support.v4.view.a.d.eu();
            eu.setScrollable(er());
            if (accessibilityEvent.getEventType() == 4096 && AdLandingViewPager.this.mAdapter != null) {
                eu.setItemCount(AdLandingViewPager.this.mAdapter.getCount());
                eu.setFromIndex(AdLandingViewPager.this.mCurItem);
                eu.setToIndex(AdLandingViewPager.this.mCurItem);
            }
            AppMethodBeat.o(37506);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            AppMethodBeat.i(37507);
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.setClassName(AdLandingViewPager.class.getName());
            bVar.setScrollable(er());
            if (AdLandingViewPager.this.canScrollHorizontally(1)) {
                bVar.addAction(4096);
            }
            if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
                bVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
            AppMethodBeat.o(37507);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            AppMethodBeat.i(37508);
            if (super.performAccessibilityAction(view, i, bundle)) {
                AppMethodBeat.o(37508);
                return true;
            }
            switch (i) {
                case 4096:
                    if (AdLandingViewPager.this.canScrollHorizontally(1)) {
                        AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.this.mCurItem + 1);
                        AppMethodBeat.o(37508);
                        return true;
                    }
                    AppMethodBeat.o(37508);
                    return false;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
                        AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.this.mCurItem - 1);
                        AppMethodBeat.o(37508);
                        return true;
                    }
                    AppMethodBeat.o(37508);
                    return false;
                default:
                    AppMethodBeat.o(37508);
                    return false;
            }
        }

        private boolean er() {
            AppMethodBeat.i(37509);
            if (AdLandingViewPager.this.mAdapter == null || AdLandingViewPager.this.mAdapter.getCount() <= 1) {
                AppMethodBeat.o(37509);
                return false;
            }
            AppMethodBeat.o(37509);
            return true;
        }
    }

    interface d {
    }

    class e extends DataSetObserver {
        private e() {
        }

        /* synthetic */ e(AdLandingViewPager adLandingViewPager, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(37510);
            AdLandingViewPager.this.dataSetChanged();
            AppMethodBeat.o(37510);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(37511);
            AdLandingViewPager.this.dataSetChanged();
            AppMethodBeat.o(37511);
        }
    }

    interface a {
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean Nq;
        boolean Nr;
        int Ns;
        public int gravity;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(37505);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AdLandingViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(37505);
        }
    }

    static /* synthetic */ void a(AdLandingViewPager adLandingViewPager) {
        AppMethodBeat.i(37587);
        adLandingViewPager.setScrollState(0);
        AppMethodBeat.o(37587);
    }

    static {
        AppMethodBeat.i(37588);
        AppMethodBeat.o(37588);
    }

    public AdLandingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37518);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.mScroller = new Scroller(context2, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.mTouchSlop = t.a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new i(context2);
        this.mRightEdge = new i(context2);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        s.a((View) this, new c());
        if (s.S(this) == 0) {
            s.o(this, 1);
        }
        AppMethodBeat.o(37518);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(37519);
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
        AppMethodBeat.o(37519);
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrollState(int i) {
        AppMethodBeat.i(37520);
        if (this.mScrollState == i) {
            AppMethodBeat.o(37520);
            return;
        }
        this.mScrollState = i;
        if (this.mPageTransformer != null) {
            Object obj;
            if (i != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                s.p(getChildAt(i2), obj != null ? 2 : 0);
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        AppMethodBeat.o(37520);
    }

    public void setAdapter(p pVar) {
        AppMethodBeat.i(37521);
        if (this.mAdapter != null) {
            int i;
            this.mAdapter.unregisterDataSetObserver(this.rcM);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (i = 0; i < this.mItems.size(); i++) {
                b bVar = (b) this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).Nq) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = pVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.rcM == null) {
                this.rcM = new e(this, (byte) 0);
            }
            this.mAdapter.registerDataSetObserver(this.rcM);
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
                AppMethodBeat.o(37521);
                return;
            } else if (z) {
                requestLayout();
            } else {
                populate();
                AppMethodBeat.o(37521);
                return;
            }
        }
        AppMethodBeat.o(37521);
    }

    public p getAdapter() {
        return this.mAdapter;
    }

    /* Access modifiers changed, original: 0000 */
    public void setOnAdapterChangeListener(d dVar) {
        this.rcN = dVar;
    }

    /* Access modifiers changed, original: 0000 */
    public int getClientWidth() {
        AppMethodBeat.i(37522);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(37522);
        return measuredWidth;
    }

    public void setCurrentItem(int i) {
        boolean z;
        AppMethodBeat.i(37523);
        this.mPopulatePending = false;
        if (this.mFirstLayout) {
            z = false;
        } else {
            z = true;
        }
        setCurrentItemInternal(i, z, false);
        AppMethodBeat.o(37523);
    }

    private void setCurrentItem$2563266(int i) {
        AppMethodBeat.i(37524);
        this.mPopulatePending = false;
        setCurrentItemInternal(i, true, false);
        AppMethodBeat.o(37524);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    private void setCurrentItemInternal(int i, boolean z, boolean z2) {
        AppMethodBeat.i(37525);
        setCurrentItemInternal(i, z, z2, 0);
        AppMethodBeat.o(37525);
    }

    /* Access modifiers changed, original: final */
    public final void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        AppMethodBeat.i(37526);
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(37526);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = 0; i4 < this.mItems.size(); i4++) {
                    ((b) this.mItems.get(i4)).scrolling = true;
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
                AppMethodBeat.o(37526);
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
            AppMethodBeat.o(37526);
        } else {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(37526);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int max;
        AppMethodBeat.i(37527);
        b Dx = Dx(i);
        if (Dx != null) {
            max = (int) (Math.max(this.mFirstOffset, Math.min(Dx.offset, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            fo(max, i2);
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i);
                AppMethodBeat.o(37527);
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
        AppMethodBeat.o(37527);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    /* Access modifiers changed, original: 0000 */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        AppMethodBeat.i(37528);
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
                AppMethodBeat.o(37528);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(37528);
    }

    /* Access modifiers changed, original: protected */
    public int getChildDrawingOrder(int i, int i2) {
        AppMethodBeat.i(37529);
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        int i3 = ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).Ns;
        AppMethodBeat.o(37529);
        return i3;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        AppMethodBeat.i(37530);
        if (i <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i).append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
        AppMethodBeat.o(37530);
    }

    public void setPageMargin(int i) {
        AppMethodBeat.i(37531);
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
        AppMethodBeat.o(37531);
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        AppMethodBeat.i(37532);
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
        AppMethodBeat.o(37532);
    }

    public void setPageMarginDrawable(int i) {
        AppMethodBeat.i(37533);
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
        AppMethodBeat.o(37533);
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(37534);
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            AppMethodBeat.o(37534);
            return true;
        }
        AppMethodBeat.o(37534);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(37535);
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.o(37535);
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.i(37536);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(37536);
        return sin;
    }

    private void fo(int i, int i2) {
        AppMethodBeat.i(37537);
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(37537);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i3 = i - scrollX;
        int i4 = 0 - scrollY;
        if (i3 == 0 && i4 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            AppMethodBeat.o(37537);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i5 = clientWidth / 2;
        float distanceInfluenceForSnapDuration = (((float) i5) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) clientWidth)))) + ((float) i5);
        int abs = Math.abs(i2);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i3)) / ((((float) clientWidth) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 3.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i3, i4, Math.min(clientWidth, 600));
        s.R(this);
        AppMethodBeat.o(37537);
    }

    private b fp(int i, int i2) {
        AppMethodBeat.i(37538);
        b bVar = new b();
        bVar.position = i;
        bVar.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        bVar.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i2, bVar);
        }
        AppMethodBeat.o(37538);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final void dataSetChanged() {
        boolean z;
        AppMethodBeat.i(37539);
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
            b bVar = (b) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(bVar.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (i3 == 0) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        i3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
                    if (this.mCurItem == bVar.position) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                } else if (bVar.position != itemPosition) {
                    if (bVar.position == this.mCurItem) {
                        i = itemPosition;
                    }
                    bVar.position = itemPosition;
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
                if (!layoutParams.Nq) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
        AppMethodBeat.o(37539);
    }

    /* Access modifiers changed, original: final */
    public final void populate() {
        AppMethodBeat.i(37540);
        populate(this.mCurItem);
        AppMethodBeat.o(37540);
    }

    /* JADX WARNING: Missing block: B:30:0x00f0, code skipped:
            if (r0.position == r14.mCurItem) goto L_0x00f2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populate(int i) {
        AppMethodBeat.i(37541);
        b bVar = null;
        int i2 = 2;
        if (this.mCurItem != i) {
            i2 = this.mCurItem < i ? 66 : 17;
            bVar = Dx(this.mCurItem);
            this.mCurItem = i;
        }
        int i3 = i2;
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            AppMethodBeat.o(37541);
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
            AppMethodBeat.o(37541);
        } else if (getWindowToken() == null) {
            AppMethodBeat.o(37541);
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
                AppMethodBeat.o(37541);
                throw illegalStateException;
            }
            int i4;
            b bVar2;
            b bVar3;
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.mItems.size()) {
                    break;
                }
                bVar2 = (b) this.mItems.get(i4);
                if (bVar2.position < this.mCurItem) {
                    i2 = i4 + 1;
                }
            }
            bVar2 = null;
            if (bVar2 != null || count <= 0) {
                bVar3 = bVar2;
            } else {
                bVar3 = fp(this.mCurItem, i4);
            }
            if (bVar3 != null) {
                float f;
                float f2 = 0.0f;
                int i5 = i4 - 1;
                bVar2 = i5 >= 0 ? (b) this.mItems.get(i5) : null;
                int clientWidth = getClientWidth();
                if (clientWidth <= 0) {
                    f = 0.0f;
                } else {
                    f = (2.0f - bVar3.widthFactor) + (((float) getPaddingLeft()) / ((float) clientWidth));
                }
                int i6 = this.mCurItem - 1;
                int i7 = i4;
                while (i6 >= 0) {
                    if (f2 >= f && i6 < max) {
                        if (bVar2 == null) {
                            break;
                        } else if (i6 != bVar2.position || bVar2.scrolling) {
                            i4 = i5;
                        } else {
                            this.mItems.remove(i5);
                            this.mAdapter.destroyItem((ViewGroup) this, i6, bVar2.object);
                            i4 = i5 - 1;
                            i5 = i7 - 1;
                            if (i4 >= 0) {
                                bVar2 = (b) this.mItems.get(i4);
                            } else {
                                bVar2 = null;
                            }
                            i7 = i5;
                        }
                    } else if (bVar2 == null || i6 != bVar2.position) {
                        f2 += fp(i6, i5 + 1).widthFactor;
                        i7++;
                        bVar2 = i5 >= 0 ? (b) this.mItems.get(i5) : null;
                        i4 = i5;
                    } else {
                        f2 += bVar2.widthFactor;
                        i4 = i5 - 1;
                        bVar2 = i4 >= 0 ? (b) this.mItems.get(i4) : null;
                    }
                    i6--;
                    i5 = i4;
                }
                f = bVar3.widthFactor;
                i5 = i7 + 1;
                if (f < 2.0f) {
                    float f3;
                    b bVar4 = i5 < this.mItems.size() ? (b) this.mItems.get(i5) : null;
                    if (clientWidth <= 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                    }
                    i6 = this.mCurItem + 1;
                    bVar2 = bVar4;
                    while (i6 < count) {
                        if (f >= f3 && i6 > min) {
                            if (bVar2 == null) {
                                break;
                            } else if (i6 == bVar2.position && !bVar2.scrolling) {
                                this.mItems.remove(i5);
                                this.mAdapter.destroyItem((ViewGroup) this, i6, bVar2.object);
                                bVar2 = i5 < this.mItems.size() ? (b) this.mItems.get(i5) : null;
                            }
                        } else if (bVar2 == null || i6 != bVar2.position) {
                            bVar2 = fp(i6, i5);
                            i5++;
                            f += bVar2.widthFactor;
                            bVar2 = i5 < this.mItems.size() ? (b) this.mItems.get(i5) : null;
                        } else {
                            f += bVar2.widthFactor;
                            i5++;
                            bVar2 = i5 < this.mItems.size() ? (b) this.mItems.get(i5) : null;
                        }
                        i6++;
                    }
                }
                a(bVar3, i7, bVar);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, bVar3 != null ? bVar3.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            i4 = getChildCount();
            for (int i8 = 0; i8 < i4; i8++) {
                View childAt = getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.Ns = i8;
                if (!layoutParams.Nq && layoutParams.widthFactor == 0.0f) {
                    b dD = dD(childAt);
                    if (dD != null) {
                        layoutParams.widthFactor = dD.widthFactor;
                        layoutParams.position = dD.position;
                    }
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                bVar2 = findFocus != null ? dE(findFocus) : null;
                if (bVar2 == null || bVar2.position != this.mCurItem) {
                    for (i2 = 0; i2 < getChildCount(); i2++) {
                        View childAt2 = getChildAt(i2);
                        b dD2 = dD(childAt2);
                        if (dD2 != null && dD2.position == this.mCurItem && childAt2.requestFocus(i3)) {
                            break;
                        }
                    }
                }
            }
            AppMethodBeat.o(37541);
        }
    }

    private void sortChildDrawingOrder() {
        AppMethodBeat.i(37542);
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
            Collections.sort(this.mDrawingOrderedChildren, rcO);
        }
        AppMethodBeat.o(37542);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A:{LOOP_END, LOOP:2: B:18:0x005f->B:20:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A:{LOOP_END, LOOP:5: B:33:0x00a8->B:35:0x00ac} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(b bVar, int i, b bVar2) {
        float f;
        b bVar3;
        int i2;
        AppMethodBeat.i(37543);
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            clientWidth = bVar2.position;
            float f2;
            int i3;
            int i4;
            Object obj;
            if (clientWidth < bVar.position) {
                f2 = (bVar2.offset + bVar2.widthFactor) + f;
                i3 = clientWidth + 1;
                i4 = 0;
                while (i3 <= bVar.position && i4 < this.mItems.size()) {
                    obj = this.mItems.get(i4);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i3 <= bVar3.position || i4 >= this.mItems.size() - 1) {
                            while (i3 < bVar3.position) {
                                f2 += this.mAdapter.getPageWidth(i3) + f;
                                i3++;
                            }
                        } else {
                            i4++;
                            obj = this.mItems.get(i4);
                        }
                    }
                    while (i3 < bVar3.position) {
                    }
                    bVar3.offset = f2;
                    f2 += bVar3.widthFactor + f;
                    i3++;
                }
            } else if (clientWidth > bVar.position) {
                i4 = this.mItems.size() - 1;
                f2 = bVar2.offset;
                clientWidth--;
                while (true) {
                    i3 = clientWidth;
                    if (i3 < bVar.position || i4 < 0) {
                        break;
                    }
                    obj = this.mItems.get(i4);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i3 >= bVar3.position || i4 <= 0) {
                            while (i3 > bVar3.position) {
                                f2 -= this.mAdapter.getPageWidth(i3) + f;
                                i3--;
                            }
                        } else {
                            i4--;
                            obj = this.mItems.get(i4);
                        }
                    }
                    while (i3 > bVar3.position) {
                    }
                    f2 -= bVar3.widthFactor + f;
                    bVar3.offset = f2;
                    clientWidth = i3 - 1;
                }
            }
        }
        int size = this.mItems.size();
        float f3 = bVar.offset;
        int i5 = bVar.position - 1;
        this.mFirstOffset = bVar.position == 0 ? bVar.offset : -3.4028235E38f;
        this.mLastOffset = bVar.position == count + -1 ? (bVar.offset + bVar.widthFactor) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.mItems.get(i2);
            while (i5 > bVar3.position) {
                f3 -= this.mAdapter.getPageWidth(i5) + f;
                i5--;
            }
            f3 -= bVar3.widthFactor + f;
            bVar3.offset = f3;
            if (bVar3.position == 0) {
                this.mFirstOffset = f3;
            }
            i5--;
        }
        f3 = (bVar.offset + bVar.widthFactor) + f;
        i5 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.mItems.get(i2);
            while (i5 < bVar3.position) {
                f3 += this.mAdapter.getPageWidth(i5) + f;
                i5++;
            }
            if (bVar3.position == count - 1) {
                this.mLastOffset = (bVar3.widthFactor + f3) - 1.0f;
            }
            bVar3.offset = f3;
            f3 += bVar3.widthFactor + f;
            i5++;
        }
        this.mNeedCalculatePageOffsets = false;
        AppMethodBeat.o(37543);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(37544);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.Nt = this.mAdapter.saveState();
        }
        AppMethodBeat.o(37544);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(37545);
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(savedState.Nt, savedState.Nu);
                setCurrentItemInternal(savedState.position, false, true);
                AppMethodBeat.o(37545);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.Nt;
            this.mRestoredClassLoader = savedState.Nu;
            AppMethodBeat.o(37545);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(37545);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        Object generateLayoutParams;
        AppMethodBeat.i(37546);
        if (checkLayoutParams(layoutParams)) {
            android.view.ViewGroup.LayoutParams generateLayoutParams2 = layoutParams;
        } else {
            generateLayoutParams2 = generateLayoutParams(layoutParams);
        }
        Assert.assertNotNull(generateLayoutParams2);
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams2;
        layoutParams2.Nq |= view instanceof a;
        if (!this.mInLayout) {
            super.addView(view, i, generateLayoutParams2);
            AppMethodBeat.o(37546);
        } else if (layoutParams2 == null || !layoutParams2.Nq) {
            layoutParams2.Nr = true;
            addViewInLayout(view, i, generateLayoutParams2);
            AppMethodBeat.o(37546);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot add pager decor view during layout");
            AppMethodBeat.o(37546);
            throw illegalStateException;
        }
    }

    public void removeView(View view) {
        AppMethodBeat.i(37547);
        if (this.mInLayout) {
            removeViewInLayout(view);
            AppMethodBeat.o(37547);
            return;
        }
        super.removeView(view);
        AppMethodBeat.o(37547);
    }

    private b dD(View view) {
        AppMethodBeat.i(37548);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mItems.size()) {
                b bVar = (b) this.mItems.get(i2);
                if (this.mAdapter.isViewFromObject(view, bVar.object)) {
                    AppMethodBeat.o(37548);
                    return bVar;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(37548);
                return null;
            }
        }
    }

    private b dE(View view) {
        AppMethodBeat.i(37549);
        while (true) {
            AdLandingViewPager parent = view.getParent();
            if (parent == this) {
                b dD = dD(view);
                AppMethodBeat.o(37549);
                return dD;
            } else if (parent == null || !(parent instanceof View)) {
                AppMethodBeat.o(37549);
            } else {
                view = parent;
            }
        }
        AppMethodBeat.o(37549);
        return null;
    }

    private b Dx(int i) {
        AppMethodBeat.i(37550);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mItems.size()) {
                b bVar = (b) this.mItems.get(i3);
                if (bVar.position == i) {
                    AppMethodBeat.o(37550);
                    return bVar;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(37550);
                return null;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(37551);
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        AppMethodBeat.o(37551);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int i4;
        AppMethodBeat.i(37552);
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.Nq) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & 112;
                    i3 = j.INVALID_ID;
                    i4 = j.INVALID_ID;
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
                if ((layoutParams == null || !layoutParams.Nq) && layoutParams != null) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * ((float) paddingLeft)), ErrorDialogData.SUPPRESSED), this.mChildHeightMeasureSpec);
                }
            }
        }
        AppMethodBeat.o(37552);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37553);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
        AppMethodBeat.o(37553);
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37554);
        if (i2 <= 0 || this.mItems.isEmpty()) {
            b Dx = Dx(this.mCurItem);
            int min = (int) ((Dx != null ? Math.min(Dx.offset, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
            AppMethodBeat.o(37554);
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.mScroller.isFinished()) {
            this.mScroller.startScroll(paddingLeft, 0, (int) (Dx(this.mCurItem).offset * ((float) i)), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
        }
        AppMethodBeat.o(37554);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int i5;
        AppMethodBeat.i(37555);
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
                if (layoutParams.Nq) {
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
                if (!layoutParams.Nq) {
                    b dD = dD(childAt2);
                    if (dD != null) {
                        max = ((int) (dD.offset * ((float) i5))) + paddingLeft;
                        if (layoutParams.Nr) {
                            layoutParams.Nr = false;
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
        AppMethodBeat.o(37555);
    }

    public void computeScroll() {
        AppMethodBeat.i(37556);
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            AppMethodBeat.o(37556);
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
        s.R(this);
        AppMethodBeat.o(37556);
    }

    private boolean pageScrolled(int i) {
        AppMethodBeat.i(37557);
        IllegalStateException illegalStateException;
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                AppMethodBeat.o(37557);
                return false;
            }
            illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
            AppMethodBeat.o(37557);
            throw illegalStateException;
        }
        b cpZ = cpZ();
        int clientWidth = getClientWidth();
        int i2 = this.mPageMargin + clientWidth;
        float f = ((float) this.mPageMargin) / ((float) clientWidth);
        int i3 = cpZ.position;
        float f2 = ((((float) i) / ((float) clientWidth)) - cpZ.offset) / (cpZ.widthFactor + f);
        clientWidth = (int) (((float) i2) * f2);
        this.mCalledSuper = false;
        onPageScrolled(i3, f2, clientWidth);
        if (this.mCalledSuper) {
            AppMethodBeat.o(37557);
            return true;
        }
        illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
        AppMethodBeat.o(37557);
        throw illegalStateException;
    }

    private void onPageScrolled(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        AppMethodBeat.i(37558);
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
                if (layoutParams.Nq) {
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
                if (!((LayoutParams) childAt2.getLayoutParams()).Nq) {
                    this.mPageTransformer.j(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
        AppMethodBeat.o(37558);
    }

    private void completeScroll(boolean z) {
        int scrollX;
        AppMethodBeat.i(37559);
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
            b bVar = (b) this.mItems.get(scrollX);
            if (bVar.scrolling) {
                bVar.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                s.b((View) this, this.mEndScrollRunnable);
                AppMethodBeat.o(37559);
                return;
            }
            this.mEndScrollRunnable.run();
        }
        AppMethodBeat.o(37559);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(37560);
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            AppMethodBeat.o(37560);
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                AppMethodBeat.o(37560);
                return true;
            } else if (this.mIsUnableToDrag) {
                AppMethodBeat.o(37560);
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
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
                    if (f != 0.0f) {
                        boolean z;
                        x = this.mLastMotionX;
                        if ((x >= ((float) this.mGutterSize) || f <= 0.0f) && (x <= ((float) (getWidth() - this.mGutterSize)) || f >= 0.0f)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            if (canScroll(this, false, (int) f, (int) x2, (int) y)) {
                                this.mLastMotionX = x2;
                                this.mLastMotionY = y;
                                this.mIsUnableToDrag = true;
                                AppMethodBeat.o(37560);
                                return false;
                            }
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
                        s.R(this);
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
        boolean z2 = this.mIsBeingDragged;
        AppMethodBeat.o(37560);
        return z2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(37561);
        if (this.mFakeDragging) {
            AppMethodBeat.o(37561);
            return true;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            AppMethodBeat.o(37561);
            return false;
        } else if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            AppMethodBeat.o(37561);
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
                        b cpZ = cpZ();
                        int i = cpZ.position;
                        f = ((((float) scrollX) / ((float) clientWidth)) - cpZ.offset) / cpZ.widthFactor;
                        clientWidth = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (clientWidth < 0) {
                            clientWidth = 0;
                        }
                        setCurrentItemInternal(determineTargetPage(i, f, xVelocity, (int) (motionEvent.getX(clientWidth) - this.mInitialMotionX)), true, true, xVelocity);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.mRightEdge.eL() | this.mLeftEdge.eL();
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
                        z = this.mRightEdge.eL() | this.mLeftEdge.eL();
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
                s.R(this);
            }
            AppMethodBeat.o(37561);
            return true;
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(37562);
        float f3 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        b bVar = (b) this.mItems.get(0);
        b bVar2 = (b) this.mItems.get(this.mItems.size() - 1);
        if (bVar.position != 0) {
            f4 = ((float) clientWidth) * bVar.offset;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.mAdapter.getCount() - 1) {
            f2 = bVar2.offset * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.F(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.mRightEdge.F(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        AppMethodBeat.o(37562);
        return z3;
    }

    /* Access modifiers changed, original: final */
    public final b cpZ() {
        float f;
        AppMethodBeat.i(37563);
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
        b bVar = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.mItems.size()) {
            b bVar2;
            b bVar3 = (b) this.mItems.get(i2);
            if (obj != null || bVar3.position == i + 1) {
                bVar2 = bVar3;
            } else {
                bVar3 = this.rcL;
                bVar3.offset = (f3 + f2) + f;
                bVar3.position = i + 1;
                bVar3.widthFactor = this.mAdapter.getPageWidth(bVar3.position);
                i2--;
                bVar2 = bVar3;
            }
            f3 = bVar2.offset;
            float f4 = (bVar2.widthFactor + f3) + f;
            if (obj == null && scrollX < f3) {
                AppMethodBeat.o(37563);
                return bVar;
            } else if (scrollX < f4 || i2 == this.mItems.size() - 1) {
                AppMethodBeat.o(37563);
                return bVar2;
            } else {
                i = bVar2.position;
                f2 = bVar2.widthFactor;
                i2++;
                bVar = bVar2;
                obj = null;
            }
        }
        AppMethodBeat.o(37563);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final int determineTargetPage(int i, float f, int i2, int i3) {
        AppMethodBeat.i(37564);
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i = (int) ((i >= this.mCurItem ? 0.85f : 0.15f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() > 0) {
            i = Math.max(firstItemPosForDetermine(), Math.min(i, lastItemPosForDetermine()));
        }
        AppMethodBeat.o(37564);
        return i;
    }

    private int firstItemPosForDetermine() {
        AppMethodBeat.i(37565);
        int i = ((b) this.mItems.get(0)).position;
        AppMethodBeat.o(37565);
        return i;
    }

    private int lastItemPosForDetermine() {
        AppMethodBeat.i(37566);
        int i = ((b) this.mItems.get(this.mItems.size() - 1)).position;
        AppMethodBeat.o(37566);
        return i;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(37567);
        super.draw(canvas);
        int i = 0;
        int O = s.O(this);
        if (O == 0 || (O == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            int width;
            if (!this.mLeftEdge.QM.isFinished()) {
                O = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(i, width);
                i = this.mLeftEdge.draw(canvas) | 0;
                canvas.restoreToCount(O);
            }
            if (!this.mRightEdge.QM.isFinished()) {
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
            this.mLeftEdge.QM.finish();
            this.mRightEdge.QM.finish();
        }
        if (i != 0) {
            s.R(this);
        }
        AppMethodBeat.o(37567);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(37568);
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.mPageMargin) / ((float) width);
            b bVar = (b) this.mItems.get(0);
            float f2 = bVar.offset;
            int size = this.mItems.size();
            int i = bVar.position;
            int i2 = ((b) this.mItems.get(size - 1)).position;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                float f3;
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = (b) this.mItems.get(i3);
                }
                if (i4 == bVar.position) {
                    f3 = (bVar.offset + bVar.widthFactor) * ((float) width);
                    f2 = (bVar.offset + bVar.widthFactor) + f;
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
        AppMethodBeat.o(37568);
    }

    public final void fakeDragBy(float f) {
        AppMethodBeat.i(37569);
        if (this.mFakeDragging) {
            float f2;
            float f3;
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.mFirstOffset;
            float f5 = ((float) clientWidth) * this.mLastOffset;
            b bVar = (b) this.mItems.get(0);
            b bVar2 = (b) this.mItems.get(this.mItems.size() - 1);
            if (bVar.position != 0) {
                f2 = bVar.offset * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (bVar2.position != this.mAdapter.getCount() - 1) {
                f3 = bVar2.offset * ((float) clientWidth);
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
            AppMethodBeat.o(37569);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        AppMethodBeat.o(37569);
        throw illegalStateException;
    }

    /* Access modifiers changed, original: final */
    public final void endDrag() {
        AppMethodBeat.i(37571);
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(37571);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        AppMethodBeat.i(37572);
        if (this.mAdapter == null) {
            AppMethodBeat.o(37572);
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                AppMethodBeat.o(37572);
                return true;
            }
            AppMethodBeat.o(37572);
            return false;
        } else if (i <= 0) {
            AppMethodBeat.o(37572);
            return false;
        } else if (scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            AppMethodBeat.o(37572);
            return true;
        } else {
            AppMethodBeat.o(37572);
            return false;
        }
    }

    private boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        AppMethodBeat.i(37573);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        AppMethodBeat.o(37573);
                        return true;
                    }
                }
            }
        }
        if (z && s.m(view, -i)) {
            AppMethodBeat.o(37573);
            return true;
        }
        AppMethodBeat.o(37573);
        return false;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(37574);
        if (!super.dispatchKeyEvent(keyEvent)) {
            boolean arrowScroll;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 21:
                        arrowScroll = arrowScroll(17);
                        break;
                    case 22:
                        arrowScroll = arrowScroll(66);
                        break;
                    case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        if (VERSION.SDK_INT >= 11) {
                            if (!keyEvent.hasNoModifiers()) {
                                if (keyEvent.hasModifiers(1)) {
                                    arrowScroll = arrowScroll(1);
                                    break;
                                }
                            }
                            arrowScroll = arrowScroll(2);
                            break;
                        }
                }
            }
            arrowScroll = false;
            if (!arrowScroll) {
                AppMethodBeat.o(37574);
                return false;
            }
        }
        AppMethodBeat.o(37574);
        return true;
    }

    /* JADX WARNING: Missing block: B:39:0x00c9, code skipped:
            if (r10 != 2) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int i) {
        View view;
        boolean pageLeft;
        AppMethodBeat.i(37575);
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (AdLandingViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
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
        AppMethodBeat.o(37575);
        return pageLeft;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        AppMethodBeat.i(37576);
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            AppMethodBeat.o(37576);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        AdLandingViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        AppMethodBeat.o(37576);
        return rect2;
    }

    private boolean pageLeft() {
        AppMethodBeat.i(37577);
        if (this.mCurItem > 0) {
            setCurrentItem$2563266(this.mCurItem - 1);
            AppMethodBeat.o(37577);
            return true;
        }
        AppMethodBeat.o(37577);
        return false;
    }

    private boolean pageRight() {
        AppMethodBeat.i(37578);
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            AppMethodBeat.o(37578);
            return false;
        }
        setCurrentItem$2563266(this.mCurItem + 1);
        AppMethodBeat.o(37578);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        AppMethodBeat.i(37579);
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b dD = dD(childAt);
                    if (dD != null && dD.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if (descendantFocusability != 262144 || size == arrayList.size()) {
            if (!isFocusable()) {
                AppMethodBeat.o(37579);
                return;
            } else if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                AppMethodBeat.o(37579);
                return;
            } else {
                arrayList.add(this);
            }
        }
        AppMethodBeat.o(37579);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        AppMethodBeat.i(37580);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b dD = dD(childAt);
                if (dD != null && dD.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
        AppMethodBeat.o(37580);
    }

    /* Access modifiers changed, original: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        AppMethodBeat.i(37581);
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
                b dD = dD(childAt);
                if (dD != null && dD.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    AppMethodBeat.o(37581);
                    return true;
                }
            }
            i3 += i2;
        }
        AppMethodBeat.o(37581);
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(37582);
        if (accessibilityEvent.getEventType() == 4096) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.o(37582);
            return dispatchPopulateAccessibilityEvent;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b dD = dD(childAt);
                if (dD != null && dD.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    AppMethodBeat.o(37582);
                    return true;
                }
            }
        }
        AppMethodBeat.o(37582);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(37583);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(37583);
        return layoutParams;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(37584);
        android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        AppMethodBeat.o(37584);
        return generateDefaultLayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(37585);
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            AppMethodBeat.o(37585);
            return true;
        }
        AppMethodBeat.o(37585);
        return false;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(37586);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(37586);
        return layoutParams;
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        AppMethodBeat.i(37570);
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
        AppMethodBeat.o(37570);
    }
}
