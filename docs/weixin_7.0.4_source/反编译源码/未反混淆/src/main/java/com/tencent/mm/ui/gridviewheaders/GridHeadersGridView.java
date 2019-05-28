package com.tencent.mm.ui.gridviewheaders;

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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private DataSetObserver PL;
    private OnItemSelectedListener Up;
    private OnItemClickListener arw;
    protected int ath;
    private ak mHandler;
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
    c zyJ;
    d zyK;
    private e zyL;
    private View zyM;
    protected c zyN;
    protected int zyO;
    private boolean zyP;
    public a zyx;
    public b zyy;
    private boolean zyz;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(107366);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(107366);
                return savedState;
            }
        };
        boolean zyU;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(107370);
            AppMethodBeat.o(107370);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(107367);
            this.zyU = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(107367);
        }

        public String toString() {
            AppMethodBeat.i(107368);
            String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.zyU + "}";
            AppMethodBeat.o(107368);
            return str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(107369);
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.zyU ? 1 : 0));
            AppMethodBeat.o(107369);
        }
    }

    class f {
        private int yxj;

        private f() {
        }

        /* synthetic */ f(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void dJk() {
            AppMethodBeat.i(107371);
            this.yxj = GridHeadersGridView.b(GridHeadersGridView.this);
            AppMethodBeat.o(107371);
        }

        public final boolean dJl() {
            AppMethodBeat.i(107372);
            if (GridHeadersGridView.this.hasWindowFocus() && GridHeadersGridView.c(GridHeadersGridView.this) == this.yxj) {
                AppMethodBeat.o(107372);
                return true;
            }
            AppMethodBeat.o(107372);
            return false;
        }
    }

    public interface d {
        boolean dJj();
    }

    class e extends f implements Runnable {
        int zyT;

        private e() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ e(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(107365);
            if (GridHeadersGridView.this.ysL) {
                AppMethodBeat.o(107365);
                return;
            }
            if (GridHeadersGridView.this.zyN != null && GridHeadersGridView.this.zyN.getCount() > 0 && this.zyT != -1 && this.zyT < GridHeadersGridView.this.zyN.getCount() && dJl()) {
                View PE = GridHeadersGridView.this.PE(this.zyT);
                if (PE != null) {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    GridHeadersGridView.a(GridHeadersGridView.this, this.zyT);
                    if (gridHeadersGridView.zyJ != null) {
                        gridHeadersGridView.playSoundEffect(0);
                        if (PE != null) {
                            PE.sendAccessibilityEvent(1);
                        }
                        gridHeadersGridView.zyJ.de(PE);
                    }
                }
            }
            AppMethodBeat.o(107365);
        }
    }

    class a extends f implements Runnable {
        private a() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ a(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(107363);
            View PE = GridHeadersGridView.this.PE(GridHeadersGridView.this.zyO);
            if (PE != null) {
                boolean z;
                GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.zyO);
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
                    AppMethodBeat.o(107363);
                    return;
                }
                GridHeadersGridView.this.ath = 2;
            }
            AppMethodBeat.o(107363);
        }
    }

    public interface c {
        void de(View view);
    }

    final class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(107364);
            if (GridHeadersGridView.this.ath == 0) {
                GridHeadersGridView.this.ath = 1;
                View PE = GridHeadersGridView.this.PE(GridHeadersGridView.this.zyO);
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
                                GridHeadersGridView.this.zyx = new a(GridHeadersGridView.this, (byte) 0);
                            }
                            GridHeadersGridView.this.zyx.dJk();
                            GridHeadersGridView.this.mHandler.postDelayed(GridHeadersGridView.this.zyx, (long) longPressTimeout);
                            AppMethodBeat.o(107364);
                            return;
                        }
                        GridHeadersGridView.this.ath = 2;
                        AppMethodBeat.o(107364);
                        return;
                    }
                }
            }
            AppMethodBeat.o(107364);
        }
    }

    static /* synthetic */ void a(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(107401);
        gridHeadersGridView.reset();
        AppMethodBeat.o(107401);
    }

    static /* synthetic */ int b(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(107403);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.o(107403);
        return windowAttachCount;
    }

    static /* synthetic */ int c(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(107404);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.o(107404);
        return windowAttachCount;
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107373);
        this.mHandler = new ak();
        this.zyz = true;
        this.zyA = new Rect();
        this.zyE = -1;
        this.PL = new DataSetObserver() {
            public final void onChanged() {
                AppMethodBeat.i(107360);
                GridHeadersGridView.a(GridHeadersGridView.this);
                AppMethodBeat.o(107360);
            }

            public final void onInvalidated() {
                AppMethodBeat.i(107361);
                GridHeadersGridView.a(GridHeadersGridView.this);
                AppMethodBeat.o(107361);
            }
        };
        this.zyI = 1;
        this.mScrollState = 0;
        this.zyP = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.zyH) {
            this.mNumColumns = -1;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(107373);
    }

    public final View PE(int i) {
        AppMethodBeat.i(107374);
        View view;
        if (i == -2) {
            view = this.zyM;
            AppMethodBeat.o(107374);
            return view;
        }
        try {
            view = (View) getChildAt(i).getTag();
            AppMethodBeat.o(107374);
            return view;
        } catch (Exception e) {
            AppMethodBeat.o(107374);
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
        AppMethodBeat.i(107375);
        this.arw.onItemClick(adapterView, view, this.zyN.PD(i).mPosition, j);
        AppMethodBeat.o(107375);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(107376);
        boolean onItemLongClick = this.oiQ.onItemLongClick(adapterView, view, this.zyN.PD(i).mPosition, j);
        AppMethodBeat.o(107376);
        return onItemLongClick;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(107377);
        this.Up.onItemSelected(adapterView, view, this.zyN.PD(i).mPosition, j);
        AppMethodBeat.o(107377);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        AppMethodBeat.i(107378);
        this.Up.onNothingSelected(adapterView);
        AppMethodBeat.o(107378);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(107379);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.zyz = savedState.zyU;
        requestLayout();
        AppMethodBeat.o(107379);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(107380);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.zyU = this.zyz;
        AppMethodBeat.o(107380);
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(107381);
        if (this.rLS != null) {
            this.rLS.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            PF(i);
        }
        AppMethodBeat.o(107381);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(107382);
        if (this.rLS != null) {
            this.rLS.onScrollStateChanged(absListView, i);
        }
        this.mScrollState = i;
        AppMethodBeat.o(107382);
    }

    public void setAdapter(ListAdapter listAdapter) {
        b bVar;
        AppMethodBeat.i(107384);
        if (!(this.zyN == null || this.PL == null)) {
            this.zyN.unregisterDataSetObserver(this.PL);
        }
        if (!this.zyC) {
            this.zyB = true;
        }
        Object bVar2;
        if (listAdapter instanceof b) {
            bVar2 = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            bVar2 = new f((e) listAdapter);
        } else {
            bVar2 = new d(listAdapter);
        }
        this.zyN = new c(getContext(), this, bVar2);
        this.zyN.registerDataSetObserver(this.PL);
        reset();
        super.setAdapter(this.zyN);
        AppMethodBeat.o(107384);
    }

    public void setAreHeadersSticky(boolean z) {
        AppMethodBeat.i(107385);
        if (z != this.zyz) {
            this.zyz = z;
            requestLayout();
        }
        AppMethodBeat.o(107385);
    }

    public void setClipToPadding(boolean z) {
        AppMethodBeat.i(107386);
        super.setClipToPadding(z);
        this.zyB = z;
        this.zyC = true;
        AppMethodBeat.o(107386);
    }

    public void setColumnWidth(int i) {
        AppMethodBeat.i(107387);
        super.setColumnWidth(i);
        this.zyD = i;
        AppMethodBeat.o(107387);
    }

    public void setHorizontalSpacing(int i) {
        AppMethodBeat.i(107388);
        super.setHorizontalSpacing(i);
        this.ysw = i;
        AppMethodBeat.o(107388);
    }

    public void setNumColumns(int i) {
        AppMethodBeat.i(107389);
        super.setNumColumns(i);
        this.zyH = true;
        this.mNumColumns = i;
        if (!(i == -1 || this.zyN == null)) {
            this.zyN.setNumColumns(i);
        }
        AppMethodBeat.o(107389);
    }

    public void setOnHeaderClickListener(c cVar) {
        this.zyJ = cVar;
    }

    public void setOnHeaderLongClickListener(d dVar) {
        AppMethodBeat.i(107390);
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.zyK = dVar;
        AppMethodBeat.o(107390);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(107391);
        this.arw = onItemClickListener;
        super.setOnItemClickListener(this);
        AppMethodBeat.o(107391);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(107392);
        this.oiQ = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
        AppMethodBeat.o(107392);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        AppMethodBeat.i(107393);
        this.Up = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
        AppMethodBeat.o(107393);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rLS = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.zyP = !z;
    }

    public void setVerticalSpacing(int i) {
        AppMethodBeat.i(107394);
        super.setVerticalSpacing(i);
        this.ysx = i;
        AppMethodBeat.o(107394);
    }

    private int getHeaderHeight() {
        AppMethodBeat.i(107395);
        if (this.zyM != null) {
            int measuredHeight = this.zyM.getMeasuredHeight();
            AppMethodBeat.o(107395);
            return measuredHeight;
        }
        AppMethodBeat.o(107395);
        return 0;
    }

    private void dJi() {
        AppMethodBeat.i(107396);
        if (this.zyM == null) {
            AppMethodBeat.o(107396);
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
        AppMethodBeat.o(107396);
    }

    private void reset() {
        this.zyF = 0;
        this.zyM = null;
        this.zyE = Long.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void PF(int i) {
        AppMethodBeat.i(107397);
        if (this.zyN == null || this.zyN.getCount() == 0 || !this.zyz) {
            AppMethodBeat.o(107397);
        } else if (((d) getChildAt(0)) == null) {
            AppMethodBeat.o(107397);
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
                    this.zyN.tw(i);
                    if (getChildAt(this.zyI).getTop() <= 0) {
                        tw = this.zyN.tw(i4);
                        i2 = i4;
                    } else {
                        tw = this.zyN.tw(i);
                        i2 = i;
                    }
                } else {
                    i4 = getChildAt(0).getTop();
                    if (i4 > 0 && i4 < this.ysx) {
                        tw = this.zyN.tw(i3);
                        i2 = i3;
                    }
                }
                if (this.zyE != tw) {
                    this.zyM = this.zyN.a(i2, this.zyM, this);
                    dJi();
                    this.zyE = tw;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    View view = null;
                    int i5 = 99999;
                    i2 = 0;
                    while (i2 < childCount) {
                        View view2 = (d) super.getChildAt(i2);
                        if (this.zyB) {
                            i4 = view2.getTop() - getPaddingTop();
                        } else {
                            i4 = view2.getTop();
                        }
                        if (i4 < 0 || !(view2.getView() instanceof b) || i4 >= i5) {
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
                        AppMethodBeat.o(107397);
                        return;
                    } else if (this.zyB) {
                        this.zyF = Math.min(view.getTop(), getPaddingTop() + i3);
                        this.zyF = this.zyF < getPaddingTop() ? i3 + getPaddingTop() : this.zyF;
                        AppMethodBeat.o(107397);
                        return;
                    } else {
                        this.zyF = Math.min(view.getTop(), i3);
                        if (this.zyF >= 0) {
                            i3 = this.zyF;
                        }
                        this.zyF = i3;
                        AppMethodBeat.o(107397);
                        return;
                    }
                }
                AppMethodBeat.o(107397);
            }
            tw = this.zyN.tw(i);
            i2 = i;
            if (this.zyE != tw) {
            }
            childCount = getChildCount();
            if (childCount != 0) {
            }
            AppMethodBeat.o(107397);
        }
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        Object obj;
        AppMethodBeat.i(107398);
        if (VERSION.SDK_INT < 8) {
            PF(getFirstVisiblePosition());
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
            d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
            try {
                View view = (View) dVar.getTag();
                Object obj2 = (((long) ((b) dVar.getChildAt(0)).getHeaderId()) == this.zyE && dVar.getTop() < 0 && this.zyz) ? 1 : null;
                if (view.getVisibility() == 0 && obj2 == null) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (ErrorDialogData.SUPPRESSED - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                    this.zyA.left = getPaddingLeft();
                    this.zyA.right = getWidth() - getPaddingRight();
                    this.zyA.bottom = dVar.getBottom();
                    this.zyA.top = dVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.zyA);
                    canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                firstVisiblePosition = i3 + 1;
            } catch (Exception e) {
                AppMethodBeat.o(107398);
                return;
            }
        }
        if (obj != null && this.zyP) {
            canvas.restore();
        } else if (obj == null) {
            AppMethodBeat.o(107398);
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
        AppMethodBeat.o(107398);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1;
        AppMethodBeat.i(107399);
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
        AppMethodBeat.o(107399);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = -2;
        AppMethodBeat.i(107383);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.zyy == null) {
                    this.zyy = new b();
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
                    final View PE = PE(this.zyO);
                    if (!(PE == null || PE.hasFocusable())) {
                        if (this.ath != 0) {
                            PE.setPressed(false);
                        }
                        if (this.zyL == null) {
                            this.zyL = new e(this, (byte) 0);
                        }
                        final e eVar = this.zyL;
                        eVar.zyT = this.zyO;
                        eVar.dJk();
                        if (this.ath == 0 && this.ath == 1) {
                            if (!this.ysL) {
                                eVar.run();
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
                                    AppMethodBeat.i(107362);
                                    GridHeadersGridView.this.ath = -1;
                                    PE.setPressed(false);
                                    GridHeadersGridView.this.setPressed(false);
                                    if (!GridHeadersGridView.this.ysL) {
                                        eVar.run();
                                    }
                                    AppMethodBeat.o(107362);
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
                    View PE2 = PE(this.zyO);
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
            AppMethodBeat.o(107383);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(107383);
        return dispatchTouchEvent;
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        AppMethodBeat.i(107402);
        long j;
        if (i == -2) {
            j = gridHeadersGridView.zyE;
            AppMethodBeat.o(107402);
            return j;
        }
        j = gridHeadersGridView.zyN.tw(gridHeadersGridView.getFirstVisiblePosition() + i);
        AppMethodBeat.o(107402);
        return j;
    }
}
