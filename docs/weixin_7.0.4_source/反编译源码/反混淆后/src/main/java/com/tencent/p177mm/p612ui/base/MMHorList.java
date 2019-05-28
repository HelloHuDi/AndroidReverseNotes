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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.ui.base.MMHorList */
public class MMHorList extends AdapterView<ListAdapter> {
    private boolean oOm = false;
    private int offset;
    private boolean yvA = false;
    private boolean yvB = false;
    private int yvC = 0;
    private int yvD = 0;
    private boolean yvE = false;
    private DataSetObserver yvF = new C155202();
    private OnGestureListener yvG = new C155183();
    private C15517a yvl;
    private int yvm;
    private int yvn;
    private int yvo;
    private int yvp;
    private int yvq = 536870912;
    private Queue<View> yvr = new LinkedList();
    private boolean yvs = false;
    private boolean yvt = false;
    protected Scroller yvu;
    private GestureDetector yvv;
    private OnItemSelectedListener yvw;
    private OnItemClickListener yvx;
    private ListAdapter yvy;
    private Runnable yvz = new C155191();

    /* renamed from: com.tencent.mm.ui.base.MMHorList$a */
    public interface C15517a {
        void aQe();

        void cEF();

        void cEG();
    }

    /* renamed from: com.tencent.mm.ui.base.MMHorList$3 */
    class C155183 extends SimpleOnGestureListener {
        C155183() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106656);
            boolean dzt = MMHorList.this.dzt();
            AppMethodBeat.m2505o(106656);
            return dzt;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106657);
            boolean bp = MMHorList.this.mo27653bp(f);
            AppMethodBeat.m2505o(106657);
            return bp;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(106658);
            MMHorList.this.yvp = MMHorList.this.yvp + ((int) f);
            MMHorList.this.requestLayout();
            AppMethodBeat.m2505o(106658);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106659);
            Rect rect = new Rect();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= MMHorList.this.getChildCount()) {
                    break;
                }
                View childAt = MMHorList.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (MMHorList.this.yvx != null) {
                        MMHorList.this.yvx.onItemClick(MMHorList.this, childAt, (MMHorList.this.yvm + 1) + i2, MMHorList.this.yvy.getItemId((MMHorList.this.yvm + 1) + i2));
                    }
                    if (MMHorList.this.yvw != null) {
                        MMHorList.this.yvw.onItemSelected(MMHorList.this, childAt, (MMHorList.this.yvm + 1) + i2, MMHorList.this.yvy.getItemId((MMHorList.this.yvm + 1) + i2));
                    }
                } else {
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(106659);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMHorList$1 */
    class C155191 implements Runnable {
        C155191() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106653);
            MMHorList.this.requestLayout();
            AppMethodBeat.m2505o(106653);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMHorList$2 */
    class C155202 extends DataSetObserver {
        C155202() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(106654);
            MMHorList.this.yvs = true;
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
            AppMethodBeat.m2505o(106654);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(106655);
            MMHorList.m23834b(MMHorList.this);
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
            AppMethodBeat.m2505o(106655);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m23834b(MMHorList mMHorList) {
        AppMethodBeat.m2504i(106675);
        mMHorList.reset();
        AppMethodBeat.m2505o(106675);
    }

    public void setHorListLitener(C15517a c15517a) {
        this.yvl = c15517a;
    }

    public void setCenterInParent(boolean z) {
        this.yvA = z;
    }

    public void setOverScrollEnabled(boolean z) {
        this.yvB = z;
    }

    public void setItemWidth(int i) {
        this.yvC = i;
    }

    private void init() {
        AppMethodBeat.m2504i(106660);
        this.yvu = new Scroller(getContext());
        this.yvm = -1;
        this.yvn = 0;
        this.offset = 0;
        this.yvo = 0;
        this.yvp = 0;
        this.yvs = false;
        this.yvq = 536870912;
        this.yvv = new GestureDetector(getContext(), this.yvG);
        AppMethodBeat.m2505o(106660);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106661);
        init();
        AppMethodBeat.m2505o(106661);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.yvw = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.yvx = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106662);
        init();
        AppMethodBeat.m2505o(106662);
    }

    public ListAdapter getAdapter() {
        return this.yvy;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(106663);
        if (this.yvy == null) {
            listAdapter.registerDataSetObserver(this.yvF);
        }
        this.yvy = listAdapter;
        reset();
        AppMethodBeat.m2505o(106663);
    }

    private int getChildViewTotalWidth() {
        AppMethodBeat.m2504i(106664);
        int count = this.yvy.getCount() * this.yvC;
        AppMethodBeat.m2505o(106664);
        return count;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106665);
        super.onLayout(z, i, i2, i3, i4);
        if (this.yvy == null) {
            AppMethodBeat.m2505o(106665);
            return;
        }
        int i5;
        int i6;
        this.yvt = true;
        if (this.yvs) {
            i5 = this.yvo;
            init();
            removeAllViewsInLayout();
            this.yvp = i5;
            if (this.yvA) {
                this.yvD = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
                this.offset = this.yvD;
            }
            this.yvs = false;
        }
        if (this.yvu.computeScrollOffset()) {
            this.yvp = this.yvu.getCurrX();
        }
        if (!this.yvB) {
            if (this.yvp < 0) {
                this.yvp = 0;
                this.yvu.forceFinished(true);
            }
            if (this.yvp > this.yvq) {
                this.yvp = this.yvq;
                this.yvu.forceFinished(true);
            }
        } else if (getChildViewTotalWidth() > getWidth()) {
            if (this.yvp < getWidth() * -1) {
                this.yvp = (getWidth() * -1) + 1;
                this.yvu.forceFinished(true);
            }
            if (this.yvp > this.yvq + getWidth()) {
                this.yvp = (this.yvq + getWidth()) - 1;
                this.yvu.forceFinished(true);
            }
        } else {
            if (this.yvp < (getWidth() * -1) + this.yvD) {
                this.yvp = ((getWidth() * -1) + this.yvD) + 1;
                this.yvu.forceFinished(true);
            }
            if (this.yvp > getWidth() - this.yvD) {
                this.yvp = (getWidth() - this.yvD) - 1;
                this.yvu.forceFinished(true);
            }
        }
        int i7 = this.yvo - this.yvp;
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i7 <= 0) {
            this.offset += childAt.getMeasuredWidth();
            this.yvr.offer(childAt);
            removeViewInLayout(childAt);
            this.yvm++;
            childAt = getChildAt(0);
            this.yvt = true;
        }
        childAt = getChildAt(getChildCount() - 1);
        while (childAt != null && childAt.getLeft() + i7 >= getWidth()) {
            this.yvr.offer(childAt);
            removeViewInLayout(childAt);
            this.yvn--;
            childAt = getChildAt(getChildCount() - 1);
            this.yvt = true;
        }
        childAt = getChildAt(getChildCount() - 1);
        if (childAt != null) {
            i5 = childAt.getRight();
        } else {
            i5 = 0;
        }
        while (true) {
            i6 = i5;
            if (i6 + i7 >= getWidth() || this.yvn >= this.yvy.getCount()) {
                childAt = getChildAt(0);
            } else {
                childAt = this.yvy.getView(this.yvn, (View) this.yvr.poll(), this);
                m23833ai(childAt, -1);
                i5 = childAt.getMeasuredWidth() + i6;
                if (this.yvn == this.yvy.getCount() - 1) {
                    this.yvq = (this.yvo + i5) - getWidth();
                }
                this.yvn++;
            }
        }
        childAt = getChildAt(0);
        if (childAt != null) {
            i5 = childAt.getLeft();
        } else {
            i5 = 0;
        }
        while (true) {
            i6 = i5;
            if (i6 + i7 > 0 && this.yvm >= 0) {
                View view = this.yvy.getView(this.yvm, (View) this.yvr.poll(), this);
                m23833ai(view, 0);
                i5 = i6 - view.getMeasuredWidth();
                this.yvm--;
                this.offset -= view.getMeasuredWidth();
            }
        }
        if (getChildCount() > 0 && this.yvt) {
            this.offset += i7;
            i6 = this.offset;
            for (i5 = 0; i5 < getChildCount(); i5++) {
                View childAt2 = getChildAt(i5);
                int measuredWidth = childAt2.getMeasuredWidth();
                childAt2.layout(i6, 0, i6 + measuredWidth, childAt2.getMeasuredHeight());
                i6 += measuredWidth;
            }
        }
        this.yvo = this.yvp;
        if (this.yvu.isFinished()) {
            if (this.yvl != null && this.yvE) {
                this.yvl.aQe();
                this.yvE = false;
            }
            AppMethodBeat.m2505o(106665);
            return;
        }
        post(this.yvz);
        AppMethodBeat.m2505o(106665);
    }

    /* renamed from: ai */
    private void m23833ai(View view, int i) {
        AppMethodBeat.m2504i(106666);
        this.yvt = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(getHeight(), C8415j.INVALID_ID));
        AppMethodBeat.m2505o(106666);
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106667);
        if (this.yvy != null && this.yvy.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), C8415j.INVALID_ID));
                AppMethodBeat.m2505o(106667);
                return;
            }
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(106667);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106668);
        boolean onTouchEvent = this.yvv.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.oOm = true;
            if (this.yvl != null) {
                this.yvl.cEF();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.yvB) {
                if (getChildViewTotalWidth() > getWidth()) {
                    if (this.yvo < 0) {
                        this.yvu.forceFinished(true);
                        this.yvu.startScroll(this.yvo, 0, 0 - this.yvo, 0);
                        requestLayout();
                    } else if (this.yvo > this.yvq) {
                        this.yvu.forceFinished(true);
                        this.yvu.startScroll(this.yvo, 0, this.yvq - this.yvo, 0);
                        requestLayout();
                    }
                } else if (this.yvo != this.yvD * -1) {
                    this.yvu.forceFinished(true);
                    this.yvu.startScroll(this.yvo, 0, 0 - this.yvo, 0);
                    requestLayout();
                }
            }
            this.oOm = false;
            if (this.yvl != null) {
                this.yvl.cEG();
            }
        }
        AppMethodBeat.m2505o(106668);
        return onTouchEvent;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dzt() {
        AppMethodBeat.m2504i(106669);
        this.yvu.forceFinished(true);
        AppMethodBeat.m2505o(106669);
        return true;
    }

    /* renamed from: NI */
    public final void mo27652NI(int i) {
        AppMethodBeat.m2504i(106670);
        this.yvu.forceFinished(true);
        this.yvu.startScroll(this.yvo, 0, i - this.yvo, 0);
        this.yvE = true;
        requestLayout();
        AppMethodBeat.m2505o(106670);
    }

    public int getCurrentPosition() {
        return this.yvo;
    }

    public boolean getIsTouching() {
        return this.oOm;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bp */
    public final boolean mo27653bp(float f) {
        AppMethodBeat.m2504i(106671);
        this.yvu.fling(this.yvp, 0, (int) (-f), 0, 0, this.yvq, 0, 0);
        requestLayout();
        AppMethodBeat.m2505o(106671);
        return true;
    }

    private void reset() {
        AppMethodBeat.m2504i(106672);
        init();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.m2505o(106672);
    }
}
