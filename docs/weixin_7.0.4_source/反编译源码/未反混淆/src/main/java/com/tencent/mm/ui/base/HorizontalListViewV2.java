package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.s;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter Ei;
    private Drawable ahS = null;
    private int alv = 0;
    private GestureDetector iay;
    private OnClickListener mOnClickListener;
    private Rect mRect = new Rect();
    protected int ysD;
    protected int ysE;
    private int ysF = BaseClientBuilder.API_PRIORITY_OTHER;
    private int ysG;
    private boolean ysL = false;
    protected Scroller ysP = new Scroller(getContext());
    private final a ysQ = new a(this, (byte) 0);
    private List<Queue<View>> ysR = new ArrayList();
    private View ysS = null;
    private Integer ysT = null;
    private int ysU;
    private int ysV;
    private int ysW;
    private e ysX = null;
    private int ysY = 0;
    private boolean ysZ = false;
    private d yta = null;
    private a ytb = a.SCROLL_STATE_IDLE;
    private i ytc;
    private i ytd;
    private int yte;
    private boolean ytf = false;
    private boolean ytg = false;
    private DataSetObserver yth = new DataSetObserver() {
        public final void onChanged() {
            AppMethodBeat.i(106329);
            HorizontalListViewV2.this.ysL = true;
            HorizontalListViewV2.this.ysZ = false;
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(106329);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(106330);
            HorizontalListViewV2.this.ysZ = false;
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2.e(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(106330);
        }
    };
    private Runnable yti = new Runnable() {
        public final void run() {
            AppMethodBeat.i(106331);
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(106331);
        }
    };

    @TargetApi(11)
    static final class b {
        static {
            AppMethodBeat.i(106338);
            if (VERSION.SDK_INT < 11) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 11!");
                AppMethodBeat.o(106338);
                throw runtimeException;
            }
            AppMethodBeat.o(106338);
        }

        public static void a(Scroller scroller) {
            AppMethodBeat.i(106337);
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
            AppMethodBeat.o(106337);
        }
    }

    class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(HorizontalListViewV2 horizontalListViewV2, byte b) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(106332);
            boolean onDown = HorizontalListViewV2.this.onDown(motionEvent);
            AppMethodBeat.o(106332);
            return onDown;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(106333);
            boolean bp = HorizontalListViewV2.this.bp(f);
            AppMethodBeat.o(106333);
            return bp;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(106334);
            HorizontalListViewV2.a(HorizontalListViewV2.this, Boolean.TRUE);
            HorizontalListViewV2.a(HorizontalListViewV2.this, a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2 horizontalListViewV2 = HorizontalListViewV2.this;
            horizontalListViewV2.ysE += (int) f;
            HorizontalListViewV2.a(HorizontalListViewV2.this, Math.round(f));
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(106334);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(106335);
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            OnItemClickListener onItemClickListener = HorizontalListViewV2.this.getOnItemClickListener();
            int a = HorizontalListViewV2.a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.ytf) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                int g = HorizontalListViewV2.this.ysU + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.Ei.getItemId(g));
                    AppMethodBeat.o(106335);
                    return true;
                }
            }
            if (!(HorizontalListViewV2.this.mOnClickListener == null || HorizontalListViewV2.this.ytf)) {
                HorizontalListViewV2.this.mOnClickListener.onClick(HorizontalListViewV2.this);
            }
            AppMethodBeat.o(106335);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(106336);
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            int a = HorizontalListViewV2.a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.ytf) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = HorizontalListViewV2.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g = HorizontalListViewV2.this.ysU + a;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.Ei.getItemId(g))) {
                        HorizontalListViewV2.this.performHapticFeedback(0);
                    }
                }
            }
            AppMethodBeat.o(106336);
        }
    }

    public interface d {

        public enum a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING;

            static {
                AppMethodBeat.o(106343);
            }
        }

        void a(a aVar);
    }

    @TargetApi(14)
    static final class c {
        static {
            AppMethodBeat.i(106340);
            if (VERSION.SDK_INT < 14) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 14!");
                AppMethodBeat.o(106340);
                throw runtimeException;
            }
            AppMethodBeat.o(106340);
        }

        public static float b(Scroller scroller) {
            AppMethodBeat.i(106339);
            float currVelocity = scroller.getCurrVelocity();
            AppMethodBeat.o(106339);
            return currVelocity;
        }
    }

    public interface e {
    }

    static /* synthetic */ int a(HorizontalListViewV2 horizontalListViewV2, int i, int i2) {
        AppMethodBeat.i(106387);
        int hf = horizontalListViewV2.hf(i, i2);
        AppMethodBeat.o(106387);
        return hf;
    }

    static /* synthetic */ void d(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.i(106382);
        horizontalListViewV2.dzw();
        AppMethodBeat.o(106382);
    }

    static /* synthetic */ void e(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.i(106383);
        horizontalListViewV2.reset();
        AppMethodBeat.o(106383);
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106344);
        this.ytc = new i(context);
        this.ytd = new i(context);
        this.iay = new GestureDetector(context, this.ysQ);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106328);
                boolean onTouchEvent = HorizontalListViewV2.this.iay.onTouchEvent(motionEvent);
                AppMethodBeat.o(106328);
                return onTouchEvent;
            }
        });
        initView();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.ysP);
        }
        AppMethodBeat.o(106344);
    }

    private void j(Boolean bool) {
        AppMethodBeat.i(106345);
        if (this.ytg != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.ytg = bool.booleanValue();
                    AppMethodBeat.o(106345);
                    return;
                }
                view = (View) view.getParent();
            }
        }
        AppMethodBeat.o(106345);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(106346);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.ysD);
        AppMethodBeat.o(106346);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(106347);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.ysT = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
        AppMethodBeat.o(106347);
    }

    public void setDivider(Drawable drawable) {
        AppMethodBeat.i(106348);
        this.ahS = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
            AppMethodBeat.o(106348);
            return;
        }
        setDividerWidth(0);
        AppMethodBeat.o(106348);
    }

    public void setDividerWidth(int i) {
        AppMethodBeat.i(106349);
        this.alv = i;
        requestLayout();
        invalidate();
        AppMethodBeat.o(106349);
    }

    private void initView() {
        AppMethodBeat.i(106350);
        this.ysU = -1;
        this.ysV = -1;
        this.ysG = 0;
        this.ysD = 0;
        this.ysE = 0;
        this.ysF = BaseClientBuilder.API_PRIORITY_OTHER;
        setCurrentScrollState(a.SCROLL_STATE_IDLE);
        AppMethodBeat.o(106350);
    }

    private void reset() {
        AppMethodBeat.i(106351);
        initView();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.o(106351);
    }

    public void setSelection(int i) {
        this.ysW = i;
    }

    public View getSelectedView() {
        AppMethodBeat.i(106352);
        int i = this.ysW;
        if (i < this.ysU || i > this.ysV) {
            AppMethodBeat.o(106352);
            return null;
        }
        View childAt = getChildAt(i - this.ysU);
        AppMethodBeat.o(106352);
        return childAt;
    }

    public void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        AppMethodBeat.i(106353);
        if (this.Ei != null) {
            this.Ei.unregisterDataSetObserver(this.yth);
        }
        if (listAdapter != null) {
            this.ysZ = false;
            this.Ei = listAdapter;
            this.Ei.registerDataSetObserver(this.yth);
        }
        if (this.Ei != null) {
            int viewTypeCount = this.Ei.getViewTypeCount();
            this.ysR.clear();
            while (i < viewTypeCount) {
                this.ysR.add(new LinkedList());
                i++;
            }
        }
        reset();
        AppMethodBeat.o(106353);
    }

    public ListAdapter getAdapter() {
        return this.Ei;
    }

    private View Ny(int i) {
        AppMethodBeat.i(106354);
        int itemViewType = this.Ei.getItemViewType(i);
        if (Nz(itemViewType)) {
            View view = (View) ((Queue) this.ysR.get(itemViewType)).poll();
            AppMethodBeat.o(106354);
            return view;
        }
        AppMethodBeat.o(106354);
        return null;
    }

    private void i(int i, View view) {
        AppMethodBeat.i(106355);
        int itemViewType = this.Ei.getItemViewType(i);
        if (Nz(itemViewType)) {
            ((Queue) this.ysR.get(itemViewType)).offer(view);
        }
        AppMethodBeat.o(106355);
    }

    private boolean Nz(int i) {
        AppMethodBeat.i(106356);
        if (i < this.ysR.size()) {
            AppMethodBeat.o(106356);
            return true;
        }
        AppMethodBeat.o(106356);
        return false;
    }

    private void ai(View view, int i) {
        int makeMeasureSpec;
        AppMethodBeat.i(106357);
        addViewInLayout(view, i, eF(view), true);
        LayoutParams eF = eF(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.yte, getPaddingTop() + getPaddingBottom(), eF.height);
        if (eF.width > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(eF.width, ErrorDialogData.SUPPRESSED);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
        AppMethodBeat.o(106357);
    }

    private static LayoutParams eF(View view) {
        AppMethodBeat.i(106358);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        }
        AppMethodBeat.o(106358);
        return layoutParams;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106359);
        super.onLayout(z, i, i2, i3, i4);
        if (this.Ei == null) {
            AppMethodBeat.o(106359);
            return;
        }
        int i5;
        int i6;
        View rightmostChild;
        View view;
        int measuredWidth;
        int i7;
        Object obj;
        invalidate();
        if (this.ysL) {
            i5 = this.ysD;
            initView();
            removeAllViewsInLayout();
            this.ysE = i5;
            this.ysL = false;
        }
        if (this.ysT != null) {
            this.ysE = this.ysT.intValue();
            this.ysT = null;
        }
        if (this.ysP.computeScrollOffset()) {
            this.ysE = this.ysP.getCurrX();
        }
        if (this.ysE < 0) {
            this.ysE = 0;
            if (this.ytc.QM.isFinished()) {
                this.ytc.aT((int) dzu());
            }
            this.ysP.forceFinished(true);
            setCurrentScrollState(a.SCROLL_STATE_IDLE);
        } else if (this.ysE > this.ysF) {
            this.ysE = this.ysF;
            if (this.ytd.QM.isFinished()) {
                this.ytd.aT((int) dzu());
            }
            this.ysP.forceFinished(true);
            setCurrentScrollState(a.SCROLL_STATE_IDLE);
        }
        int i8 = this.ysD - this.ysE;
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i8 <= 0) {
            i6 = this.ysG;
            if (NA(this.ysU)) {
                i5 = leftmostChild.getMeasuredWidth();
            } else {
                i5 = this.alv + leftmostChild.getMeasuredWidth();
            }
            this.ysG = i5 + i6;
            i(this.ysU, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.ysU++;
            leftmostChild = getLeftmostChild();
        }
        while (true) {
            rightmostChild = getRightmostChild();
            if (rightmostChild == null || rightmostChild.getLeft() + i8 < getWidth()) {
                i5 = 0;
                leftmostChild = getRightmostChild();
            } else {
                i(this.ysV, rightmostChild);
                removeViewInLayout(rightmostChild);
                this.ysV--;
            }
        }
        i5 = 0;
        leftmostChild = getRightmostChild();
        if (leftmostChild != null) {
            i5 = leftmostChild.getRight();
        }
        while ((i5 + i8) + this.alv < getWidth() && this.ysV + 1 < this.Ei.getCount()) {
            this.ysV++;
            if (this.ysU < 0) {
                this.ysU = this.ysV;
            }
            view = this.Ei.getView(this.ysV, Ny(this.ysV), this);
            ai(view, -1);
            i5 += (this.ysV == 0 ? 0 : this.alv) + view.getMeasuredWidth();
            if (!(this.ysX == null || this.Ei == null || this.Ei.getCount() - (this.ysV + 1) >= this.ysY || this.ysZ)) {
                this.ysZ = true;
            }
        }
        i5 = 0;
        leftmostChild = getLeftmostChild();
        if (leftmostChild != null) {
            i5 = leftmostChild.getLeft();
        }
        while ((i5 + i8) - this.alv > 0 && this.ysU > 0) {
            this.ysU--;
            view = this.Ei.getView(this.ysU, Ny(this.ysU), this);
            ai(view, 0);
            if (this.ysU == 0) {
                measuredWidth = view.getMeasuredWidth();
            } else {
                measuredWidth = this.alv + view.getMeasuredWidth();
            }
            i5 -= measuredWidth;
            i7 = this.ysG;
            if (i5 + i8 == 0) {
                measuredWidth = view.getMeasuredWidth();
            } else {
                measuredWidth = this.alv + view.getMeasuredWidth();
            }
            this.ysG = i7 - measuredWidth;
        }
        i6 = getChildCount();
        if (i6 > 0) {
            this.ysG += i8;
            measuredWidth = this.ysG;
            for (i5 = 0; i5 < i6; i5++) {
                View childAt = getChildAt(i5);
                i7 = getPaddingLeft() + measuredWidth;
                int paddingTop = getPaddingTop();
                childAt.layout(i7, paddingTop, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + paddingTop);
                measuredWidth += childAt.getMeasuredWidth() + this.alv;
            }
        }
        this.ysD = this.ysE;
        if (NA(this.ysV)) {
            rightmostChild = getRightmostChild();
            if (rightmostChild != null) {
                measuredWidth = this.ysF;
                this.ysF = ((rightmostChild.getRight() - getPaddingLeft()) + this.ysD) - getRenderWidth();
                if (this.ysF < 0) {
                    this.ysF = 0;
                }
                if (this.ysF != measuredWidth) {
                    obj = 1;
                    if (obj == null) {
                        onLayout(z, i, i2, i3, i4);
                        AppMethodBeat.o(106359);
                        return;
                    }
                    if (!this.ysP.isFinished()) {
                        s.b((View) this, this.yti);
                    } else if (this.ytb == a.SCROLL_STATE_FLING) {
                        setCurrentScrollState(a.SCROLL_STATE_IDLE);
                        AppMethodBeat.o(106359);
                        return;
                    }
                    AppMethodBeat.o(106359);
                    return;
                }
            }
        }
        obj = null;
        if (obj == null) {
        }
    }

    /* Access modifiers changed, original: protected */
    public float getLeftFadingEdgeStrength() {
        AppMethodBeat.i(106360);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ysD == 0) {
            AppMethodBeat.o(106360);
            return 0.0f;
        } else if (this.ysD < horizontalFadingEdgeLength) {
            float f = ((float) this.ysD) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.o(106360);
            return f;
        } else {
            AppMethodBeat.o(106360);
            return 1.0f;
        }
    }

    /* Access modifiers changed, original: protected */
    public float getRightFadingEdgeStrength() {
        AppMethodBeat.i(106361);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ysD == this.ysF) {
            AppMethodBeat.o(106361);
            return 0.0f;
        } else if (this.ysF - this.ysD < horizontalFadingEdgeLength) {
            float f = ((float) (this.ysF - this.ysD)) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.o(106361);
            return f;
        } else {
            AppMethodBeat.o(106361);
            return 1.0f;
        }
    }

    private float dzu() {
        AppMethodBeat.i(106362);
        if (VERSION.SDK_INT >= 14) {
            float b = c.b(this.ysP);
            AppMethodBeat.o(106362);
            return b;
        }
        AppMethodBeat.o(106362);
        return 30.0f;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106363);
        super.onMeasure(i, i2);
        this.yte = i2;
        AppMethodBeat.o(106363);
    }

    private View getLeftmostChild() {
        AppMethodBeat.i(106364);
        View childAt = getChildAt(0);
        AppMethodBeat.o(106364);
        return childAt;
    }

    private View getRightmostChild() {
        AppMethodBeat.i(106365);
        View childAt = getChildAt(getChildCount() - 1);
        AppMethodBeat.o(106365);
        return childAt;
    }

    private int hf(int i, int i2) {
        AppMethodBeat.i(106366);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.mRect);
            if (this.mRect.contains(i, i2)) {
                AppMethodBeat.o(106366);
                return i3;
            }
        }
        AppMethodBeat.o(106366);
        return -1;
    }

    private boolean NA(int i) {
        AppMethodBeat.i(106367);
        if (i == this.Ei.getCount() - 1) {
            AppMethodBeat.o(106367);
            return true;
        }
        AppMethodBeat.o(106367);
        return false;
    }

    private int getRenderHeight() {
        AppMethodBeat.i(106368);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        AppMethodBeat.o(106368);
        return height;
    }

    private int getRenderWidth() {
        AppMethodBeat.i(106369);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(106369);
        return width;
    }

    public final void dzv() {
        AppMethodBeat.i(106370);
        this.ysP.startScroll(this.ysE, 0, 0 - this.ysE, 0);
        setCurrentScrollState(a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.o(106370);
    }

    public int getFirstVisiblePosition() {
        return this.ysU;
    }

    public int getLastVisiblePosition() {
        return this.ysV;
    }

    private void a(Canvas canvas, Rect rect) {
        AppMethodBeat.i(106371);
        if (this.ahS != null) {
            this.ahS.setBounds(rect);
            this.ahS.draw(canvas);
        }
        AppMethodBeat.o(106371);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(106372);
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.mRect;
        this.mRect.top = getPaddingTop();
        this.mRect.bottom = this.mRect.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !NA(this.ysV)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.alv;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
        AppMethodBeat.o(106372);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(106373);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(106373);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bp(float f) {
        AppMethodBeat.i(106374);
        this.ysP.fling(this.ysE, 0, (int) (-f), 0, 0, this.ysF, 0, 0);
        setCurrentScrollState(a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.o(106374);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(106375);
        this.ytf = !this.ysP.isFinished();
        this.ysP.forceFinished(true);
        setCurrentScrollState(a.SCROLL_STATE_IDLE);
        dzw();
        if (!this.ytf) {
            int hf = hf((int) motionEvent.getX(), (int) motionEvent.getY());
            if (hf >= 0) {
                this.ysS = getChildAt(hf);
                if (this.ysS != null) {
                    this.ysS.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        AppMethodBeat.o(106375);
        return true;
    }

    private void dzw() {
        AppMethodBeat.i(106376);
        if (this.ysS != null) {
            this.ysS.setPressed(false);
            refreshDrawableState();
            this.ysS = null;
        }
        AppMethodBeat.o(106376);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106377);
        if (motionEvent.getAction() == 1) {
            if (this.ysP == null || this.ysP.isFinished()) {
                setCurrentScrollState(a.SCROLL_STATE_IDLE);
            }
            j(Boolean.FALSE);
            dzx();
        } else if (motionEvent.getAction() == 3) {
            dzw();
            dzx();
            j(Boolean.FALSE);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(106377);
        return onTouchEvent;
    }

    private void dzx() {
        AppMethodBeat.i(106378);
        if (this.ytc != null) {
            this.ytc.eL();
        }
        if (this.ytd != null) {
            this.ytd.eL();
        }
        AppMethodBeat.o(106378);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnScrollStateChangedListener(d dVar) {
        this.yta = dVar;
    }

    private void setCurrentScrollState(a aVar) {
        AppMethodBeat.i(106379);
        if (!(this.ytb == aVar || this.yta == null)) {
            this.yta.a(aVar);
        }
        this.ytb = aVar;
        AppMethodBeat.o(106379);
    }
}
