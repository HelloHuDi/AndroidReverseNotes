package com.tencent.p177mm.p612ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.gridviewheaders.C30711c.C24010b;
import com.tencent.p177mm.p612ui.gridviewheaders.C30711c.C30710d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView */
public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    /* renamed from: PL */
    private DataSetObserver f16214PL;
    /* renamed from: Up */
    private OnItemSelectedListener f16215Up;
    private OnItemClickListener arw;
    protected int ath;
    private C7306ak mHandler;
    private int mNumColumns;
    private int mScrollState;
    private int mTouchSlop;
    private OnItemLongClickListener oiQ;
    private OnScrollListener rLS;
    protected boolean ysL;
    private int ysw;
    private int ysx;
    private Runnable yxd;
    private final Rect zyA;
    private boolean zyB;
    private boolean zyC;
    private int zyD;
    private long zyE;
    private int zyF;
    private float zyG;
    private boolean zyH;
    private int zyI;
    C40873c zyJ;
    C30708d zyK;
    private C30709e zyL;
    private View zyM;
    protected C30711c zyN;
    protected int zyO;
    private boolean zyP;
    public C40872a zyx;
    public C40874b zyy;
    private boolean zyz;

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C158921();
        boolean zyU;

        /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$SavedState$1 */
        static class C158921 implements Creator<SavedState> {
            C158921() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(107366);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.m2505o(107366);
                return savedState;
            }
        }

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.m2504i(107370);
            AppMethodBeat.m2505o(107370);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.m2504i(107367);
            this.zyU = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(107367);
        }

        public String toString() {
            AppMethodBeat.m2504i(107368);
            String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.zyU + "}";
            AppMethodBeat.m2505o(107368);
            return str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(107369);
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.zyU ? 1 : 0));
            AppMethodBeat.m2505o(107369);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$f */
    class C15893f {
        private int yxj;

        private C15893f() {
        }

        /* synthetic */ C15893f(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void dJk() {
            AppMethodBeat.m2504i(107371);
            this.yxj = GridHeadersGridView.m70826b(GridHeadersGridView.this);
            AppMethodBeat.m2505o(107371);
        }

        public final boolean dJl() {
            AppMethodBeat.m2504i(107372);
            if (GridHeadersGridView.this.hasWindowFocus() && GridHeadersGridView.m70827c(GridHeadersGridView.this) == this.yxj) {
                AppMethodBeat.m2505o(107372);
                return true;
            }
            AppMethodBeat.m2505o(107372);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$1 */
    class C240071 extends DataSetObserver {
        C240071() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(107360);
            GridHeadersGridView.m70825a(GridHeadersGridView.this);
            AppMethodBeat.m2505o(107360);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(107361);
            GridHeadersGridView.m70825a(GridHeadersGridView.this);
            AppMethodBeat.m2505o(107361);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$d */
    public interface C30708d {
        boolean dJj();
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$e */
    class C30709e extends C15893f implements Runnable {
        int zyT;

        private C30709e() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ C30709e(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(107365);
            if (GridHeadersGridView.this.ysL) {
                AppMethodBeat.m2505o(107365);
                return;
            }
            if (GridHeadersGridView.this.zyN != null && GridHeadersGridView.this.zyN.getCount() > 0 && this.zyT != -1 && this.zyT < GridHeadersGridView.this.zyN.getCount() && dJl()) {
                View PE = GridHeadersGridView.this.mo64420PE(this.zyT);
                if (PE != null) {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    GridHeadersGridView.m70824a(GridHeadersGridView.this, this.zyT);
                    if (gridHeadersGridView.zyJ != null) {
                        gridHeadersGridView.playSoundEffect(0);
                        if (PE != null) {
                            PE.sendAccessibilityEvent(1);
                        }
                        gridHeadersGridView.zyJ.mo23152de(PE);
                    }
                }
            }
            AppMethodBeat.m2505o(107365);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$a */
    class C40872a extends C15893f implements Runnable {
        private C40872a() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ C40872a(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(107363);
            View PE = GridHeadersGridView.this.mo64420PE(GridHeadersGridView.this.zyO);
            if (PE != null) {
                boolean z;
                GridHeadersGridView.m70824a(GridHeadersGridView.this, GridHeadersGridView.this.zyO);
                if (!dJl() || GridHeadersGridView.this.ysL) {
                    z = false;
                } else {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    if (gridHeadersGridView.zyK != null) {
                        z = gridHeadersGridView.zyK.dJj();
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (PE != null) {
                            PE.sendAccessibilityEvent(2);
                        }
                        gridHeadersGridView.performHapticFeedback(0);
                    }
                }
                if (z) {
                    GridHeadersGridView.this.ath = -2;
                    GridHeadersGridView.this.setPressed(false);
                    PE.setPressed(false);
                    AppMethodBeat.m2505o(107363);
                    return;
                }
                GridHeadersGridView.this.ath = 2;
            }
            AppMethodBeat.m2505o(107363);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$c */
    public interface C40873c {
        /* renamed from: de */
        void mo23152de(View view);
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$b */
    final class C40874b implements Runnable {
        C40874b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107364);
            if (GridHeadersGridView.this.ath == 0) {
                GridHeadersGridView.this.ath = 1;
                View PE = GridHeadersGridView.this.mo64420PE(GridHeadersGridView.this.zyO);
                if (!(PE == null || PE.hasFocusable())) {
                    if (GridHeadersGridView.this.ysL) {
                        GridHeadersGridView.this.ath = 2;
                    } else {
                        PE.setPressed(true);
                        GridHeadersGridView.this.setPressed(true);
                        GridHeadersGridView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        if (GridHeadersGridView.this.isLongClickable()) {
                            if (GridHeadersGridView.this.zyx == null) {
                                GridHeadersGridView.this.zyx = new C40872a(GridHeadersGridView.this, (byte) 0);
                            }
                            GridHeadersGridView.this.zyx.dJk();
                            GridHeadersGridView.this.mHandler.postDelayed(GridHeadersGridView.this.zyx, (long) longPressTimeout);
                            AppMethodBeat.m2505o(107364);
                            return;
                        }
                        GridHeadersGridView.this.ath = 2;
                        AppMethodBeat.m2505o(107364);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(107364);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m70825a(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.m2504i(107401);
        gridHeadersGridView.reset();
        AppMethodBeat.m2505o(107401);
    }

    /* renamed from: b */
    static /* synthetic */ int m70826b(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.m2504i(107403);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.m2505o(107403);
        return windowAttachCount;
    }

    /* renamed from: c */
    static /* synthetic */ int m70827c(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.m2504i(107404);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.m2505o(107404);
        return windowAttachCount;
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107373);
        this.mHandler = new C7306ak();
        this.zyz = true;
        this.zyA = new Rect();
        this.zyE = -1;
        this.f16214PL = new C240071();
        this.zyI = 1;
        this.mScrollState = 0;
        this.zyP = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.zyH) {
            this.mNumColumns = -1;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.m2505o(107373);
    }

    /* renamed from: PE */
    public final View mo64420PE(int i) {
        AppMethodBeat.m2504i(107374);
        View view;
        if (i == -2) {
            view = this.zyM;
            AppMethodBeat.m2505o(107374);
            return view;
        }
        try {
            view = (View) getChildAt(i).getTag();
            AppMethodBeat.m2505o(107374);
            return view;
        } catch (Exception e) {
            AppMethodBeat.m2505o(107374);
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.zyM;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.zyP;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(107375);
        this.arw.onItemClick(adapterView, view, this.zyN.mo49090PD(i).mPosition, j);
        AppMethodBeat.m2505o(107375);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(107376);
        boolean onItemLongClick = this.oiQ.onItemLongClick(adapterView, view, this.zyN.mo49090PD(i).mPosition, j);
        AppMethodBeat.m2505o(107376);
        return onItemLongClick;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(107377);
        this.f16215Up.onItemSelected(adapterView, view, this.zyN.mo49090PD(i).mPosition, j);
        AppMethodBeat.m2505o(107377);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        AppMethodBeat.m2504i(107378);
        this.f16215Up.onNothingSelected(adapterView);
        AppMethodBeat.m2505o(107378);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(107379);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.zyz = savedState.zyU;
        requestLayout();
        AppMethodBeat.m2505o(107379);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(107380);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.zyU = this.zyz;
        AppMethodBeat.m2505o(107380);
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(107381);
        if (this.rLS != null) {
            this.rLS.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            m70823PF(i);
        }
        AppMethodBeat.m2505o(107381);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(107382);
        if (this.rLS != null) {
            this.rLS.onScrollStateChanged(absListView, i);
        }
        this.mScrollState = i;
        AppMethodBeat.m2505o(107382);
    }

    public void setAdapter(ListAdapter listAdapter) {
        C24009b c24009b;
        AppMethodBeat.m2504i(107384);
        if (!(this.zyN == null || this.f16214PL == null)) {
            this.zyN.unregisterDataSetObserver(this.f16214PL);
        }
        if (!this.zyC) {
            this.zyB = true;
        }
        Object c24009b2;
        if (listAdapter instanceof C24009b) {
            c24009b2 = (C24009b) listAdapter;
        } else if (listAdapter instanceof C46688e) {
            c24009b2 = new C40876f((C46688e) listAdapter);
        } else {
            c24009b2 = new C24970d(listAdapter);
        }
        this.zyN = new C30711c(getContext(), this, c24009b2);
        this.zyN.registerDataSetObserver(this.f16214PL);
        reset();
        super.setAdapter(this.zyN);
        AppMethodBeat.m2505o(107384);
    }

    public void setAreHeadersSticky(boolean z) {
        AppMethodBeat.m2504i(107385);
        if (z != this.zyz) {
            this.zyz = z;
            requestLayout();
        }
        AppMethodBeat.m2505o(107385);
    }

    public void setClipToPadding(boolean z) {
        AppMethodBeat.m2504i(107386);
        super.setClipToPadding(z);
        this.zyB = z;
        this.zyC = true;
        AppMethodBeat.m2505o(107386);
    }

    public void setColumnWidth(int i) {
        AppMethodBeat.m2504i(107387);
        super.setColumnWidth(i);
        this.zyD = i;
        AppMethodBeat.m2505o(107387);
    }

    public void setHorizontalSpacing(int i) {
        AppMethodBeat.m2504i(107388);
        super.setHorizontalSpacing(i);
        this.ysw = i;
        AppMethodBeat.m2505o(107388);
    }

    public void setNumColumns(int i) {
        AppMethodBeat.m2504i(107389);
        super.setNumColumns(i);
        this.zyH = true;
        this.mNumColumns = i;
        if (!(i == -1 || this.zyN == null)) {
            this.zyN.setNumColumns(i);
        }
        AppMethodBeat.m2505o(107389);
    }

    public void setOnHeaderClickListener(C40873c c40873c) {
        this.zyJ = c40873c;
    }

    public void setOnHeaderLongClickListener(C30708d c30708d) {
        AppMethodBeat.m2504i(107390);
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.zyK = c30708d;
        AppMethodBeat.m2505o(107390);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(107391);
        this.arw = onItemClickListener;
        super.setOnItemClickListener(this);
        AppMethodBeat.m2505o(107391);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.m2504i(107392);
        this.oiQ = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
        AppMethodBeat.m2505o(107392);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        AppMethodBeat.m2504i(107393);
        this.f16215Up = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
        AppMethodBeat.m2505o(107393);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rLS = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.zyP = !z;
    }

    public void setVerticalSpacing(int i) {
        AppMethodBeat.m2504i(107394);
        super.setVerticalSpacing(i);
        this.ysx = i;
        AppMethodBeat.m2505o(107394);
    }

    private int getHeaderHeight() {
        AppMethodBeat.m2504i(107395);
        if (this.zyM != null) {
            int measuredHeight = this.zyM.getMeasuredHeight();
            AppMethodBeat.m2505o(107395);
            return measuredHeight;
        }
        AppMethodBeat.m2505o(107395);
        return 0;
    }

    private void dJi() {
        AppMethodBeat.m2504i(107396);
        if (this.zyM == null) {
            AppMethodBeat.m2505o(107396);
            return;
        }
        int makeMeasureSpec;
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), ErrorDialogData.SUPPRESSED);
        LayoutParams layoutParams = this.zyM.getLayoutParams();
        if (layoutParams == null || layoutParams.height <= 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, ErrorDialogData.SUPPRESSED);
        }
        this.zyM.measure(makeMeasureSpec2, makeMeasureSpec);
        this.zyM.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zyM.getMeasuredHeight());
        AppMethodBeat.m2505o(107396);
    }

    private void reset() {
        this.zyF = 0;
        this.zyM = null;
        this.zyE = Long.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: PF */
    private void m70823PF(int i) {
        AppMethodBeat.m2504i(107397);
        if (this.zyN == null || this.zyN.getCount() == 0 || !this.zyz) {
            AppMethodBeat.m2505o(107397);
        } else if (((C30710d) getChildAt(0)) == null) {
            AppMethodBeat.m2505o(107397);
        } else {
            long tw;
            int i2;
            int childCount;
            int i3 = i - this.zyI;
            if (i3 < 0) {
                i3 = i;
            }
            int i4 = this.zyI + i;
            if (i4 >= this.zyN.getCount()) {
                i4 = i;
            }
            if (this.ysx != 0) {
                if (this.ysx < 0) {
                    this.zyN.mo49104tw(i);
                    if (getChildAt(this.zyI).getTop() <= 0) {
                        tw = this.zyN.mo49104tw(i4);
                        i2 = i4;
                    } else {
                        tw = this.zyN.mo49104tw(i);
                        i2 = i;
                    }
                } else {
                    i4 = getChildAt(0).getTop();
                    if (i4 > 0 && i4 < this.ysx) {
                        tw = this.zyN.mo49104tw(i3);
                        i2 = i3;
                    }
                }
                if (this.zyE != tw) {
                    this.zyM = this.zyN.mo49091a(i2, this.zyM, this);
                    dJi();
                    this.zyE = tw;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    View view = null;
                    int i5 = 99999;
                    i2 = 0;
                    while (i2 < childCount) {
                        View view2 = (C30710d) super.getChildAt(i2);
                        if (this.zyB) {
                            i4 = view2.getTop() - getPaddingTop();
                        } else {
                            i4 = view2.getTop();
                        }
                        if (i4 < 0 || !(view2.getView() instanceof C24010b) || i4 >= i5) {
                            i4 = i5;
                            view2 = view;
                        }
                        i2 += this.zyI;
                        i5 = i4;
                        view = view2;
                    }
                    i3 = getHeaderHeight();
                    if (view == null) {
                        this.zyF = i3;
                        if (this.zyB) {
                            this.zyF += getPaddingTop();
                        }
                    } else if (i == 0 && super.getChildAt(0).getTop() > 0 && !this.zyB) {
                        this.zyF = 0;
                        AppMethodBeat.m2505o(107397);
                        return;
                    } else if (this.zyB) {
                        this.zyF = Math.min(view.getTop(), getPaddingTop() + i3);
                        this.zyF = this.zyF < getPaddingTop() ? i3 + getPaddingTop() : this.zyF;
                        AppMethodBeat.m2505o(107397);
                        return;
                    } else {
                        this.zyF = Math.min(view.getTop(), i3);
                        if (this.zyF >= 0) {
                            i3 = this.zyF;
                        }
                        this.zyF = i3;
                        AppMethodBeat.m2505o(107397);
                        return;
                    }
                }
                AppMethodBeat.m2505o(107397);
            }
            tw = this.zyN.mo49104tw(i);
            i2 = i;
            if (this.zyE != tw) {
            }
            childCount = getChildCount();
            if (childCount != 0) {
            }
            AppMethodBeat.m2505o(107397);
        }
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        Object obj;
        AppMethodBeat.m2504i(107398);
        if (VERSION.SDK_INT < 8) {
            m70823PF(getFirstVisiblePosition());
        }
        if (this.zyM != null && this.zyz && this.zyM.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int headerHeight = getHeaderHeight();
        int i = this.zyF - headerHeight;
        if (obj != null && this.zyP) {
            this.zyA.left = getPaddingLeft();
            this.zyA.right = getWidth() - getPaddingRight();
            this.zyA.top = this.zyF;
            this.zyA.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.zyA);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.zyI;
            i2 += this.zyI;
        }
        firstVisiblePosition = 0;
        while (true) {
            int i3 = firstVisiblePosition;
            if (i3 >= arrayList.size()) {
                break;
            }
            C30710d c30710d = (C30710d) getChildAt(((Integer) arrayList.get(i3)).intValue());
            try {
                View view = (View) c30710d.getTag();
                Object obj2 = (((long) ((C24010b) c30710d.getChildAt(0)).getHeaderId()) == this.zyE && c30710d.getTop() < 0 && this.zyz) ? 1 : null;
                if (view.getVisibility() == 0 && obj2 == null) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (ErrorDialogData.SUPPRESSED - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), c30710d.getHeight());
                    this.zyA.left = getPaddingLeft();
                    this.zyA.right = getWidth() - getPaddingRight();
                    this.zyA.bottom = c30710d.getBottom();
                    this.zyA.top = c30710d.getTop();
                    canvas.save();
                    canvas.clipRect(this.zyA);
                    canvas.translate((float) getPaddingLeft(), (float) c30710d.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                firstVisiblePosition = i3 + 1;
            } catch (Exception e) {
                AppMethodBeat.m2505o(107398);
                return;
            }
        }
        if (obj != null && this.zyP) {
            canvas.restore();
        } else if (obj == null) {
            AppMethodBeat.m2505o(107398);
            return;
        }
        if (this.zyM.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.zyM.measure(MeasureSpec.makeMeasureSpec(getWidth(), (ErrorDialogData.SUPPRESSED - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
            this.zyM.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zyM.getHeight());
        }
        this.zyA.left = getPaddingLeft();
        this.zyA.right = getWidth() - getPaddingRight();
        this.zyA.bottom = i + headerHeight;
        if (this.zyB) {
            this.zyA.top = getPaddingTop();
        } else {
            this.zyA.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.zyA);
        canvas.translate((float) getPaddingLeft(), (float) i);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.zyF)) / ((float) headerHeight)), 31);
        this.zyM.draw(canvas);
        canvas.restore();
        canvas.restore();
        AppMethodBeat.m2505o(107398);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1;
        AppMethodBeat.m2504i(107399);
        if (this.mNumColumns == -1) {
            if (this.zyD > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.zyD;
                if (i4 > 0) {
                    while (i4 != 1 && (this.zyD * i4) + ((i4 - 1) * this.ysw) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.zyI = i3;
        } else {
            this.zyI = this.mNumColumns;
        }
        if (this.zyN != null) {
            this.zyN.setNumColumns(this.zyI);
        }
        dJi();
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(107399);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = -2;
        AppMethodBeat.m2504i(107383);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.zyy == null) {
                    this.zyy = new C40874b();
                }
                this.mHandler.postDelayed(this.zyx, (long) ViewConfiguration.getTapTimeout());
                int y = (int) motionEvent.getY();
                this.zyG = (float) y;
                float f = (float) y;
                if (this.zyM == null || f > ((float) this.zyM.getBottom())) {
                    y = getFirstVisiblePosition();
                    i = 0;
                    while (y <= getLastVisiblePosition()) {
                        if (getItemIdAtPosition(y) == -1) {
                            View childAt = getChildAt(i);
                            int bottom = childAt.getBottom();
                            int top = childAt.getTop();
                            if (f <= ((float) bottom) && f >= ((float) top)) {
                            }
                        }
                        y += this.zyI;
                        i += this.zyI;
                    }
                    i = -1;
                }
                this.zyO = i;
                if (!(this.zyO == -1 || this.mScrollState == 2)) {
                    this.ath = 0;
                }
            case 1:
                if (!(this.ath == -2 || this.ath == -1 || this.zyO == -1)) {
                    final View PE = mo64420PE(this.zyO);
                    if (!(PE == null || PE.hasFocusable())) {
                        if (this.ath != 0) {
                            PE.setPressed(false);
                        }
                        if (this.zyL == null) {
                            this.zyL = new C30709e(this, (byte) 0);
                        }
                        final C30709e c30709e = this.zyL;
                        c30709e.zyT = this.zyO;
                        c30709e.dJk();
                        if (this.ath == 0 && this.ath == 1) {
                            if (!this.ysL) {
                                c30709e.run();
                                z = true;
                                break;
                            }
                        }
                        this.mHandler.removeCallbacks(this.ath == 0 ? this.zyy : this.zyx);
                        if (!this.ysL) {
                            this.ath = 1;
                            PE.setPressed(true);
                            setPressed(true);
                            if (this.yxd != null) {
                                removeCallbacks(this.yxd);
                            }
                            this.yxd = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(107362);
                                    GridHeadersGridView.this.ath = -1;
                                    PE.setPressed(false);
                                    GridHeadersGridView.this.setPressed(false);
                                    if (!GridHeadersGridView.this.ysL) {
                                        c30709e.run();
                                    }
                                    AppMethodBeat.m2505o(107362);
                                }
                            };
                            this.mHandler.postDelayed(this.yxd, (long) ViewConfiguration.getPressedStateDuration());
                            z = true;
                            break;
                        }
                        this.ath = -1;
                    }
                    this.ath = -1;
                }
                break;
            case 2:
                if (this.zyO != -1 && Math.abs(motionEvent.getY() - this.zyG) > ((float) this.mTouchSlop)) {
                    this.ath = -1;
                    View PE2 = mo64420PE(this.zyO);
                    if (PE2 != null) {
                        PE2.setPressed(false);
                    }
                    if (this.zyx != null) {
                        this.mHandler.removeCallbacks(this.zyx);
                    }
                    this.zyO = -1;
                }
                z = false;
                break;
        }
        z = false;
        if (z) {
            AppMethodBeat.m2505o(107383);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107383);
        return dispatchTouchEvent;
    }

    /* renamed from: a */
    static /* synthetic */ long m70824a(GridHeadersGridView gridHeadersGridView, int i) {
        AppMethodBeat.m2504i(107402);
        long j;
        if (i == -2) {
            j = gridHeadersGridView.zyE;
            AppMethodBeat.m2505o(107402);
            return j;
        }
        j = gridHeadersGridView.zyN.mo49104tw(gridHeadersGridView.getFirstVisiblePosition() + i);
        AppMethodBeat.m2505o(107402);
        return j;
    }
}
