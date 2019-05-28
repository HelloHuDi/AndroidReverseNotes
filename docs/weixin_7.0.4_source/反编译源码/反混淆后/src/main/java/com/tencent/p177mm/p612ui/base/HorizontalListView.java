package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.ui.base.HorizontalListView */
public class HorizontalListView extends AdapterView<ListAdapter> {
    /* renamed from: Ei */
    protected ListAdapter f2981Ei;
    protected Scroller mScroller;
    private C15504a voO;
    public boolean ysA = true;
    private int ysB = -1;
    private int ysC = 0;
    protected int ysD;
    protected int ysE;
    private int ysF = BaseClientBuilder.API_PRIORITY_OTHER;
    private int ysG = 0;
    private GestureDetector ysH;
    private Queue<View> ysI = new LinkedList();
    private OnItemSelectedListener ysJ;
    private OnItemClickListener ysK;
    private boolean ysL = false;
    private DataSetObserver ysM = new C155011();
    private OnGestureListener ysN = new C155033();

    /* renamed from: com.tencent.mm.ui.base.HorizontalListView$1 */
    class C155011 extends DataSetObserver {
        C155011() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(106309);
            synchronized (HorizontalListView.this) {
                try {
                    HorizontalListView.this.ysL = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(106309);
                }
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(106310);
            HorizontalListView.m23816b(HorizontalListView.this);
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
            AppMethodBeat.m2505o(106310);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListView$2 */
    class C155022 implements Runnable {
        C155022() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106311);
            HorizontalListView.this.requestLayout();
            AppMethodBeat.m2505o(106311);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListView$3 */
    class C155033 extends SimpleOnGestureListener {
        C155033() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106312);
            boolean dzt = HorizontalListView.this.dzt();
            AppMethodBeat.m2505o(106312);
            return dzt;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106313);
            boolean bp = HorizontalListView.this.mo27596bp(f);
            AppMethodBeat.m2505o(106313);
            return bp;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106314);
            synchronized (HorizontalListView.this) {
                try {
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    horizontalListView.ysE += (int) f;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(106314);
                }
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106315);
            Rect rect = new Rect();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (HorizontalListView.this.ysK != null) {
                        HorizontalListView.this.ysK.onItemClick(HorizontalListView.this, childAt, (HorizontalListView.this.ysB + 1) + i2, HorizontalListView.this.f2981Ei.getItemId((HorizontalListView.this.ysB + 1) + i2));
                    }
                    if (HorizontalListView.this.ysJ != null) {
                        HorizontalListView.this.ysJ.onItemSelected(HorizontalListView.this, childAt, (HorizontalListView.this.ysB + 1) + i2, HorizontalListView.this.f2981Ei.getItemId((HorizontalListView.this.ysB + 1) + i2));
                    }
                } else {
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(106315);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HorizontalListView$a */
    public interface C15504a {
        /* renamed from: o */
        boolean mo27288o(MotionEvent motionEvent);
    }

    /* renamed from: b */
    static /* synthetic */ void m23816b(HorizontalListView horizontalListView) {
        AppMethodBeat.m2504i(106327);
        horizontalListView.reset();
        AppMethodBeat.m2505o(106327);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106316);
        initView();
        AppMethodBeat.m2505o(106316);
    }

    private synchronized void initView() {
        AppMethodBeat.m2504i(106317);
        this.ysB = -1;
        this.ysC = 0;
        this.ysG = 0;
        this.ysD = 0;
        this.ysE = 0;
        this.ysF = BaseClientBuilder.API_PRIORITY_OTHER;
        this.mScroller = new Scroller(getContext());
        this.ysH = new GestureDetector(getContext(), this.ysN);
        AppMethodBeat.m2505o(106317);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.ysJ = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.ysK = onItemClickListener;
    }

    public ListAdapter getAdapter() {
        return this.f2981Ei;
    }

    public View getSelectedView() {
        return null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(106318);
        if (this.f2981Ei != null) {
            this.f2981Ei.unregisterDataSetObserver(this.ysM);
        }
        this.f2981Ei = listAdapter;
        this.f2981Ei.registerDataSetObserver(this.ysM);
        reset();
        AppMethodBeat.m2505o(106318);
    }

    private synchronized void reset() {
        AppMethodBeat.m2504i(106319);
        initView();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.m2505o(106319);
    }

    public void setSelection(int i) {
    }

    /* renamed from: ai */
    private void m23815ai(View view, int i) {
        AppMethodBeat.m2504i(106320);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(getHeight(), C8415j.INVALID_ID));
        AppMethodBeat.m2505o(106320);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r0 = getChildAt(getChildCount() - 1);
     */
    /* JADX WARNING: Missing block: B:38:0x00b9, code skipped:
            if (r0 == null) goto L_0x0196;
     */
    /* JADX WARNING: Missing block: B:39:0x00bb, code skipped:
            r0 = r0.getRight();
     */
    /* JADX WARNING: Missing block: B:40:0x00bf, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:42:0x00c6, code skipped:
            if ((r2 + r3) >= getWidth()) goto L_0x0110;
     */
    /* JADX WARNING: Missing block: B:44:0x00d0, code skipped:
            if (r7.ysC >= r7.f2981Ei.getCount()) goto L_0x0110;
     */
    /* JADX WARNING: Missing block: B:45:0x00d2, code skipped:
            r0 = r7.f2981Ei.getView(r7.ysC, (android.view.View) r7.ysI.poll(), r7);
            m23815ai(r0, -1);
            r0 = r0.getMeasuredWidth() + r2;
     */
    /* JADX WARNING: Missing block: B:46:0x00f5, code skipped:
            if (r7.ysC != (r7.f2981Ei.getCount() - 1)) goto L_0x0101;
     */
    /* JADX WARNING: Missing block: B:47:0x00f7, code skipped:
            r7.ysF = (r7.ysD + r0) - getWidth();
     */
    /* JADX WARNING: Missing block: B:49:0x0103, code skipped:
            if (r7.ysF >= 0) goto L_0x0108;
     */
    /* JADX WARNING: Missing block: B:50:0x0105, code skipped:
            r7.ysF = 0;
     */
    /* JADX WARNING: Missing block: B:51:0x0108, code skipped:
            r7.ysC++;
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:52:0x0110, code skipped:
            r0 = getChildAt(0);
     */
    /* JADX WARNING: Missing block: B:53:0x0115, code skipped:
            if (r0 == null) goto L_0x0194;
     */
    /* JADX WARNING: Missing block: B:54:0x0117, code skipped:
            r0 = r0.getLeft();
     */
    /* JADX WARNING: Missing block: B:55:0x011b, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:57:0x011e, code skipped:
            if ((r2 + r3) <= 0) goto L_0x014f;
     */
    /* JADX WARNING: Missing block: B:59:0x0122, code skipped:
            if (r7.ysB < 0) goto L_0x014f;
     */
    /* JADX WARNING: Missing block: B:60:0x0124, code skipped:
            r4 = r7.f2981Ei.getView(r7.ysB, (android.view.View) r7.ysI.poll(), r7);
            m23815ai(r4, 0);
            r0 = r2 - r4.getMeasuredWidth();
            r7.ysB--;
            r7.ysG -= r4.getMeasuredWidth();
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:62:0x0153, code skipped:
            if (getChildCount() <= 0) goto L_0x0178;
     */
    /* JADX WARNING: Missing block: B:63:0x0155, code skipped:
            r7.ysG += r3;
            r0 = r7.ysG;
     */
    /* JADX WARNING: Missing block: B:65:0x0160, code skipped:
            if (r1 >= getChildCount()) goto L_0x0178;
     */
    /* JADX WARNING: Missing block: B:66:0x0162, code skipped:
            r2 = getChildAt(r1);
            r3 = r2.getMeasuredWidth();
            r2.layout(r0, 0, r0 + r3, r2.getMeasuredHeight());
            r0 = r0 + r3;
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:67:0x0178, code skipped:
            r7.ysD = r7.ysE;
     */
    /* JADX WARNING: Missing block: B:68:0x0182, code skipped:
            if (r7.mScroller.isFinished() != false) goto L_0x018c;
     */
    /* JADX WARNING: Missing block: B:69:0x0184, code skipped:
            post(new com.tencent.p177mm.p612ui.base.HorizontalListView.C155022(r7));
     */
    /* JADX WARNING: Missing block: B:70:0x018c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(106321);
     */
    /* JADX WARNING: Missing block: B:71:0x0194, code skipped:
            r0 = 0;
     */
    /* JADX WARNING: Missing block: B:72:0x0196, code skipped:
            r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(106321);
            super.onLayout(z, i, i2, i3, i4);
            if (this.f2981Ei == null) {
                AppMethodBeat.m2505o(106321);
            } else {
                if (this.ysL) {
                    int i6 = this.ysD;
                    initView();
                    removeAllViewsInLayout();
                    this.ysE = i6;
                    this.ysL = false;
                }
                if (this.mScroller.computeScrollOffset()) {
                    this.ysE = this.mScroller.getCurrX();
                }
                if (this.ysE <= 0) {
                    this.ysE = 0;
                    this.mScroller.forceFinished(true);
                }
                if (this.ysE >= this.ysF) {
                    this.ysE = this.ysF;
                    this.mScroller.forceFinished(true);
                }
                int i7 = this.ysD - this.ysE;
                View childAt = getChildAt(0);
                while (childAt != null && childAt.getRight() + i7 <= 0) {
                    this.ysG += childAt.getMeasuredWidth();
                    this.ysI.offer(childAt);
                    removeViewInLayout(childAt);
                    this.ysB++;
                    childAt = getChildAt(0);
                }
                while (true) {
                    childAt = getChildAt(getChildCount() - 1);
                    if (childAt == null || childAt.getLeft() + i7 < getWidth()) {
                        break;
                    }
                    this.ysI.offer(childAt);
                    removeViewInLayout(childAt);
                    this.ysC--;
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106322);
        if (this.voO != null) {
            this.voO.mo27288o(motionEvent);
        }
        int dispatchTouchEvent = super.dispatchTouchEvent(motionEvent) | this.ysH.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(106322);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bp */
    public final boolean mo27596bp(float f) {
        AppMethodBeat.m2504i(106323);
        synchronized (this) {
            try {
                this.mScroller.fling(this.ysE, 0, (int) (-f), 0, 0, this.ysF, 0, 0);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(106323);
            }
        }
        requestLayout();
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dzt() {
        AppMethodBeat.m2504i(106324);
        this.mScroller.forceFinished(true);
        AppMethodBeat.m2505o(106324);
        return true;
    }

    public void setDispatchTouchListener(C15504a c15504a) {
        this.voO = c15504a;
    }
}
