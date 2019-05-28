package com.tencent.p177mm.p612ui.base;

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
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C0528i;
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

/* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2 */
public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    /* renamed from: Ei */
    protected ListAdapter f15082Ei;
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
    private final C30362a ysQ = new C30362a(this, (byte) 0);
    private List<Queue<View>> ysR = new ArrayList();
    private View ysS = null;
    private Integer ysT = null;
    private int ysU;
    private int ysV;
    private int ysW;
    private C36051e ysX = null;
    private int ysY = 0;
    private boolean ysZ = false;
    private C36048d yta = null;
    private C36049a ytb = C36049a.SCROLL_STATE_IDLE;
    private C0528i ytc;
    private C0528i ytd;
    private int yte;
    private boolean ytf = false;
    private boolean ytg = false;
    private DataSetObserver yth = new C360472();
    private Runnable yti = new C303613();

    @TargetApi(11)
    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$b */
    static final class C15505b {
        static {
            AppMethodBeat.m2504i(106338);
            if (VERSION.SDK_INT < 11) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 11!");
                AppMethodBeat.m2505o(106338);
                throw runtimeException;
            }
            AppMethodBeat.m2505o(106338);
        }

        /* renamed from: a */
        public static void m23822a(Scroller scroller) {
            AppMethodBeat.m2504i(106337);
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
            AppMethodBeat.m2505o(106337);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$3 */
    class C303613 implements Runnable {
        C303613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106331);
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.m2505o(106331);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$a */
    class C30362a extends SimpleOnGestureListener {
        private C30362a() {
        }

        /* synthetic */ C30362a(HorizontalListViewV2 horizontalListViewV2, byte b) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106332);
            boolean onDown = HorizontalListViewV2.this.onDown(motionEvent);
            AppMethodBeat.m2505o(106332);
            return onDown;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106333);
            boolean bp = HorizontalListViewV2.this.mo56818bp(f);
            AppMethodBeat.m2505o(106333);
            return bp;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106334);
            HorizontalListViewV2.m59323a(HorizontalListViewV2.this, Boolean.TRUE);
            HorizontalListViewV2.m59322a(HorizontalListViewV2.this, C36049a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListViewV2.m59327d(HorizontalListViewV2.this);
            HorizontalListViewV2 horizontalListViewV2 = HorizontalListViewV2.this;
            horizontalListViewV2.ysE += (int) f;
            HorizontalListViewV2.m59321a(HorizontalListViewV2.this, Math.round(f));
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.m2505o(106334);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106335);
            HorizontalListViewV2.m59327d(HorizontalListViewV2.this);
            OnItemClickListener onItemClickListener = HorizontalListViewV2.this.getOnItemClickListener();
            int a = HorizontalListViewV2.m59318a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.ytf) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                int g = HorizontalListViewV2.this.ysU + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.f15082Ei.getItemId(g));
                    AppMethodBeat.m2505o(106335);
                    return true;
                }
            }
            if (!(HorizontalListViewV2.this.mOnClickListener == null || HorizontalListViewV2.this.ytf)) {
                HorizontalListViewV2.this.mOnClickListener.onClick(HorizontalListViewV2.this);
            }
            AppMethodBeat.m2505o(106335);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106336);
            HorizontalListViewV2.m59327d(HorizontalListViewV2.this);
            int a = HorizontalListViewV2.m59318a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.ytf) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = HorizontalListViewV2.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g = HorizontalListViewV2.this.ysU + a;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.f15082Ei.getItemId(g))) {
                        HorizontalListViewV2.this.performHapticFeedback(0);
                    }
                }
            }
            AppMethodBeat.m2505o(106336);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$1 */
    class C360461 implements OnTouchListener {
        C360461() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106328);
            boolean onTouchEvent = HorizontalListViewV2.this.iay.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106328);
            return onTouchEvent;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$2 */
    class C360472 extends DataSetObserver {
        C360472() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(106329);
            HorizontalListViewV2.this.ysL = true;
            HorizontalListViewV2.this.ysZ = false;
            HorizontalListViewV2.m59327d(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.m2505o(106329);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(106330);
            HorizontalListViewV2.this.ysZ = false;
            HorizontalListViewV2.m59327d(HorizontalListViewV2.this);
            HorizontalListViewV2.m59328e(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.m2505o(106330);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$d */
    public interface C36048d {

        /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$d$a */
        public enum C36049a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING;

            static {
                AppMethodBeat.m2505o(106343);
            }
        }

        /* renamed from: a */
        void mo46398a(C36049a c36049a);
    }

    @TargetApi(14)
    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$c */
    static final class C36050c {
        static {
            AppMethodBeat.m2504i(106340);
            if (VERSION.SDK_INT < 14) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 14!");
                AppMethodBeat.m2505o(106340);
                throw runtimeException;
            }
            AppMethodBeat.m2505o(106340);
        }

        /* renamed from: b */
        public static float m59338b(Scroller scroller) {
            AppMethodBeat.m2504i(106339);
            float currVelocity = scroller.getCurrVelocity();
            AppMethodBeat.m2505o(106339);
            return currVelocity;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListViewV2$e */
    public interface C36051e {
    }

    /* renamed from: a */
    static /* synthetic */ int m59318a(HorizontalListViewV2 horizontalListViewV2, int i, int i2) {
        AppMethodBeat.m2504i(106387);
        int hf = horizontalListViewV2.m59333hf(i, i2);
        AppMethodBeat.m2505o(106387);
        return hf;
    }

    /* renamed from: d */
    static /* synthetic */ void m59327d(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.m2504i(106382);
        horizontalListViewV2.dzw();
        AppMethodBeat.m2505o(106382);
    }

    /* renamed from: e */
    static /* synthetic */ void m59328e(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.m2504i(106383);
        horizontalListViewV2.reset();
        AppMethodBeat.m2505o(106383);
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106344);
        this.ytc = new C0528i(context);
        this.ytd = new C0528i(context);
        this.iay = new GestureDetector(context, this.ysQ);
        setOnTouchListener(new C360461());
        initView();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            C15505b.m23822a(this.ysP);
        }
        AppMethodBeat.m2505o(106344);
    }

    /* renamed from: j */
    private void m59335j(Boolean bool) {
        AppMethodBeat.m2504i(106345);
        if (this.ytg != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.ytg = bool.booleanValue();
                    AppMethodBeat.m2505o(106345);
                    return;
                }
                view = (View) view.getParent();
            }
        }
        AppMethodBeat.m2505o(106345);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(106346);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.ysD);
        AppMethodBeat.m2505o(106346);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(106347);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.ysT = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
        AppMethodBeat.m2505o(106347);
    }

    public void setDivider(Drawable drawable) {
        AppMethodBeat.m2504i(106348);
        this.ahS = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
            AppMethodBeat.m2505o(106348);
            return;
        }
        setDividerWidth(0);
        AppMethodBeat.m2505o(106348);
    }

    public void setDividerWidth(int i) {
        AppMethodBeat.m2504i(106349);
        this.alv = i;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(106349);
    }

    private void initView() {
        AppMethodBeat.m2504i(106350);
        this.ysU = -1;
        this.ysV = -1;
        this.ysG = 0;
        this.ysD = 0;
        this.ysE = 0;
        this.ysF = BaseClientBuilder.API_PRIORITY_OTHER;
        setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
        AppMethodBeat.m2505o(106350);
    }

    private void reset() {
        AppMethodBeat.m2504i(106351);
        initView();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.m2505o(106351);
    }

    public void setSelection(int i) {
        this.ysW = i;
    }

    public View getSelectedView() {
        AppMethodBeat.m2504i(106352);
        int i = this.ysW;
        if (i < this.ysU || i > this.ysV) {
            AppMethodBeat.m2505o(106352);
            return null;
        }
        View childAt = getChildAt(i - this.ysU);
        AppMethodBeat.m2505o(106352);
        return childAt;
    }

    public void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        AppMethodBeat.m2504i(106353);
        if (this.f15082Ei != null) {
            this.f15082Ei.unregisterDataSetObserver(this.yth);
        }
        if (listAdapter != null) {
            this.ysZ = false;
            this.f15082Ei = listAdapter;
            this.f15082Ei.registerDataSetObserver(this.yth);
        }
        if (this.f15082Ei != null) {
            int viewTypeCount = this.f15082Ei.getViewTypeCount();
            this.ysR.clear();
            while (i < viewTypeCount) {
                this.ysR.add(new LinkedList());
                i++;
            }
        }
        reset();
        AppMethodBeat.m2505o(106353);
    }

    public ListAdapter getAdapter() {
        return this.f15082Ei;
    }

    /* renamed from: Ny */
    private View m59316Ny(int i) {
        AppMethodBeat.m2504i(106354);
        int itemViewType = this.f15082Ei.getItemViewType(i);
        if (m59317Nz(itemViewType)) {
            View view = (View) ((Queue) this.ysR.get(itemViewType)).poll();
            AppMethodBeat.m2505o(106354);
            return view;
        }
        AppMethodBeat.m2505o(106354);
        return null;
    }

    /* renamed from: i */
    private void m59334i(int i, View view) {
        AppMethodBeat.m2504i(106355);
        int itemViewType = this.f15082Ei.getItemViewType(i);
        if (m59317Nz(itemViewType)) {
            ((Queue) this.ysR.get(itemViewType)).offer(view);
        }
        AppMethodBeat.m2505o(106355);
    }

    /* renamed from: Nz */
    private boolean m59317Nz(int i) {
        AppMethodBeat.m2504i(106356);
        if (i < this.ysR.size()) {
            AppMethodBeat.m2505o(106356);
            return true;
        }
        AppMethodBeat.m2505o(106356);
        return false;
    }

    /* renamed from: ai */
    private void m59324ai(View view, int i) {
        int makeMeasureSpec;
        AppMethodBeat.m2504i(106357);
        addViewInLayout(view, i, HorizontalListViewV2.m59329eF(view), true);
        LayoutParams eF = HorizontalListViewV2.m59329eF(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.yte, getPaddingTop() + getPaddingBottom(), eF.height);
        if (eF.width > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(eF.width, ErrorDialogData.SUPPRESSED);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
        AppMethodBeat.m2505o(106357);
    }

    /* renamed from: eF */
    private static LayoutParams m59329eF(View view) {
        AppMethodBeat.m2504i(106358);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        }
        AppMethodBeat.m2505o(106358);
        return layoutParams;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106359);
        super.onLayout(z, i, i2, i3, i4);
        if (this.f15082Ei == null) {
            AppMethodBeat.m2505o(106359);
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
            if (this.ytc.f704QM.isFinished()) {
                this.ytc.mo1290aT((int) dzu());
            }
            this.ysP.forceFinished(true);
            setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
        } else if (this.ysE > this.ysF) {
            this.ysE = this.ysF;
            if (this.ytd.f704QM.isFinished()) {
                this.ytd.mo1290aT((int) dzu());
            }
            this.ysP.forceFinished(true);
            setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
        }
        int i8 = this.ysD - this.ysE;
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i8 <= 0) {
            i6 = this.ysG;
            if (m59315NA(this.ysU)) {
                i5 = leftmostChild.getMeasuredWidth();
            } else {
                i5 = this.alv + leftmostChild.getMeasuredWidth();
            }
            this.ysG = i5 + i6;
            m59334i(this.ysU, leftmostChild);
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
                m59334i(this.ysV, rightmostChild);
                removeViewInLayout(rightmostChild);
                this.ysV--;
            }
        }
        i5 = 0;
        leftmostChild = getRightmostChild();
        if (leftmostChild != null) {
            i5 = leftmostChild.getRight();
        }
        while ((i5 + i8) + this.alv < getWidth() && this.ysV + 1 < this.f15082Ei.getCount()) {
            this.ysV++;
            if (this.ysU < 0) {
                this.ysU = this.ysV;
            }
            view = this.f15082Ei.getView(this.ysV, m59316Ny(this.ysV), this);
            m59324ai(view, -1);
            i5 += (this.ysV == 0 ? 0 : this.alv) + view.getMeasuredWidth();
            if (!(this.ysX == null || this.f15082Ei == null || this.f15082Ei.getCount() - (this.ysV + 1) >= this.ysY || this.ysZ)) {
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
            view = this.f15082Ei.getView(this.ysU, m59316Ny(this.ysU), this);
            m59324ai(view, 0);
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
        if (m59315NA(this.ysV)) {
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
                        AppMethodBeat.m2505o(106359);
                        return;
                    }
                    if (!this.ysP.isFinished()) {
                        C0477s.m934b((View) this, this.yti);
                    } else if (this.ytb == C36049a.SCROLL_STATE_FLING) {
                        setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
                        AppMethodBeat.m2505o(106359);
                        return;
                    }
                    AppMethodBeat.m2505o(106359);
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
        AppMethodBeat.m2504i(106360);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ysD == 0) {
            AppMethodBeat.m2505o(106360);
            return 0.0f;
        } else if (this.ysD < horizontalFadingEdgeLength) {
            float f = ((float) this.ysD) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.m2505o(106360);
            return f;
        } else {
            AppMethodBeat.m2505o(106360);
            return 1.0f;
        }
    }

    /* Access modifiers changed, original: protected */
    public float getRightFadingEdgeStrength() {
        AppMethodBeat.m2504i(106361);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ysD == this.ysF) {
            AppMethodBeat.m2505o(106361);
            return 0.0f;
        } else if (this.ysF - this.ysD < horizontalFadingEdgeLength) {
            float f = ((float) (this.ysF - this.ysD)) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.m2505o(106361);
            return f;
        } else {
            AppMethodBeat.m2505o(106361);
            return 1.0f;
        }
    }

    private float dzu() {
        AppMethodBeat.m2504i(106362);
        if (VERSION.SDK_INT >= 14) {
            float b = C36050c.m59338b(this.ysP);
            AppMethodBeat.m2505o(106362);
            return b;
        }
        AppMethodBeat.m2505o(106362);
        return 30.0f;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106363);
        super.onMeasure(i, i2);
        this.yte = i2;
        AppMethodBeat.m2505o(106363);
    }

    private View getLeftmostChild() {
        AppMethodBeat.m2504i(106364);
        View childAt = getChildAt(0);
        AppMethodBeat.m2505o(106364);
        return childAt;
    }

    private View getRightmostChild() {
        AppMethodBeat.m2504i(106365);
        View childAt = getChildAt(getChildCount() - 1);
        AppMethodBeat.m2505o(106365);
        return childAt;
    }

    /* renamed from: hf */
    private int m59333hf(int i, int i2) {
        AppMethodBeat.m2504i(106366);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.mRect);
            if (this.mRect.contains(i, i2)) {
                AppMethodBeat.m2505o(106366);
                return i3;
            }
        }
        AppMethodBeat.m2505o(106366);
        return -1;
    }

    /* renamed from: NA */
    private boolean m59315NA(int i) {
        AppMethodBeat.m2504i(106367);
        if (i == this.f15082Ei.getCount() - 1) {
            AppMethodBeat.m2505o(106367);
            return true;
        }
        AppMethodBeat.m2505o(106367);
        return false;
    }

    private int getRenderHeight() {
        AppMethodBeat.m2504i(106368);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        AppMethodBeat.m2505o(106368);
        return height;
    }

    private int getRenderWidth() {
        AppMethodBeat.m2504i(106369);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.m2505o(106369);
        return width;
    }

    public final void dzv() {
        AppMethodBeat.m2504i(106370);
        this.ysP.startScroll(this.ysE, 0, 0 - this.ysE, 0);
        setCurrentScrollState(C36049a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.m2505o(106370);
    }

    public int getFirstVisiblePosition() {
        return this.ysU;
    }

    public int getLastVisiblePosition() {
        return this.ysV;
    }

    /* renamed from: a */
    private void m59320a(Canvas canvas, Rect rect) {
        AppMethodBeat.m2504i(106371);
        if (this.ahS != null) {
            this.ahS.setBounds(rect);
            this.ahS.draw(canvas);
        }
        AppMethodBeat.m2505o(106371);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(106372);
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.mRect;
        this.mRect.top = getPaddingTop();
        this.mRect.bottom = this.mRect.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !m59315NA(this.ysV)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.alv;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                m59320a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    m59320a(canvas, rect);
                }
            }
        }
        AppMethodBeat.m2505o(106372);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(106373);
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(106373);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bp */
    public final boolean mo56818bp(float f) {
        AppMethodBeat.m2504i(106374);
        this.ysP.fling(this.ysE, 0, (int) (-f), 0, 0, this.ysF, 0, 0);
        setCurrentScrollState(C36049a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.m2505o(106374);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106375);
        this.ytf = !this.ysP.isFinished();
        this.ysP.forceFinished(true);
        setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
        dzw();
        if (!this.ytf) {
            int hf = m59333hf((int) motionEvent.getX(), (int) motionEvent.getY());
            if (hf >= 0) {
                this.ysS = getChildAt(hf);
                if (this.ysS != null) {
                    this.ysS.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        AppMethodBeat.m2505o(106375);
        return true;
    }

    private void dzw() {
        AppMethodBeat.m2504i(106376);
        if (this.ysS != null) {
            this.ysS.setPressed(false);
            refreshDrawableState();
            this.ysS = null;
        }
        AppMethodBeat.m2505o(106376);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106377);
        if (motionEvent.getAction() == 1) {
            if (this.ysP == null || this.ysP.isFinished()) {
                setCurrentScrollState(C36049a.SCROLL_STATE_IDLE);
            }
            m59335j(Boolean.FALSE);
            dzx();
        } else if (motionEvent.getAction() == 3) {
            dzw();
            dzx();
            m59335j(Boolean.FALSE);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(106377);
        return onTouchEvent;
    }

    private void dzx() {
        AppMethodBeat.m2504i(106378);
        if (this.ytc != null) {
            this.ytc.mo1292eL();
        }
        if (this.ytd != null) {
            this.ytd.mo1292eL();
        }
        AppMethodBeat.m2505o(106378);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnScrollStateChangedListener(C36048d c36048d) {
        this.yta = c36048d;
    }

    private void setCurrentScrollState(C36049a c36049a) {
        AppMethodBeat.m2504i(106379);
        if (!(this.ytb == c36049a || this.yta == null)) {
            this.yta.mo46398a(c36049a);
        }
        this.ytb = c36049a;
        AppMethodBeat.m2505o(106379);
    }
}
