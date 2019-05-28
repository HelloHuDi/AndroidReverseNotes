package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean zyn;
    private DataSetObserver PL = new DataSetObserver() {
        public final void onChanged() {
            int i = 0;
            AppMethodBeat.i(107329);
            c cVar = c.this;
            cVar.mCount = 0;
            int dJh = cVar.zyo.dJh();
            if (dJh == 0) {
                cVar.mCount = cVar.zyo.getCount();
            } else {
                while (i < dJh) {
                    cVar.mCount += cVar.zyo.PA(i) + cVar.mNumColumns;
                    i++;
                }
            }
            c.this.notifyDataSetChanged();
            AppMethodBeat.o(107329);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(107330);
            c.this.zyq.clear();
            c.this.notifyDataSetInvalidated();
            AppMethodBeat.o(107330);
        }
    };
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;
    final b zyo;
    private GridHeadersGridView zyp;
    private final List<View> zyq = new ArrayList();
    private View[] zyr;

    protected class b extends FrameLayout {
        private int zyt;
        private int zyu;

        public b(Context context) {
            super(context);
        }

        public final int getHeaderId() {
            return this.zyt;
        }

        public final void setHeaderId(int i) {
            this.zyt = i;
        }

        public final void setHeaderWidth(int i) {
            this.zyu = i;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            AppMethodBeat.i(107331);
            View view = (View) getTag();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(generateDefaultLayoutParams());
            }
            if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
                view.measure(MeasureSpec.makeMeasureSpec(this.zyu, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(0, 0));
            }
            setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
            AppMethodBeat.o(107331);
        }

        /* Access modifiers changed, original: protected|final */
        public final LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.i(107332);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            AppMethodBeat.o(107332);
            return layoutParams;
        }
    }

    protected class c {
        protected int mPosition;
        protected int zyv;

        protected c(int i, int i2) {
            this.mPosition = i;
            this.zyv = i2;
        }
    }

    protected class d extends FrameLayout {
        private int mNumColumns;
        private int mPosition;
        private View[] zyr;
        private boolean zyw;

        public d(Context context) {
            super(context);
        }

        public final Object getTag() {
            AppMethodBeat.i(107334);
            Object tag = getChildAt(0).getTag();
            AppMethodBeat.o(107334);
            return tag;
        }

        public final Object getTag(int i) {
            AppMethodBeat.i(107335);
            Object tag = getChildAt(0).getTag(i);
            AppMethodBeat.o(107335);
            return tag;
        }

        public final View getView() {
            AppMethodBeat.i(107336);
            View childAt = getChildAt(0);
            AppMethodBeat.o(107336);
            return childAt;
        }

        public final void setNumColumns(int i) {
            this.mNumColumns = i;
        }

        public final void setPosition(int i) {
            this.mPosition = i;
        }

        @SuppressLint({"NewApi"})
        public final void setRowSiblings(View[] viewArr) {
            this.zyr = viewArr;
        }

        public final void setTag(int i, Object obj) {
            AppMethodBeat.i(107337);
            getChildAt(0).setTag(i, obj);
            AppMethodBeat.o(107337);
        }

        public final void setTag(Object obj) {
            AppMethodBeat.i(107338);
            getChildAt(0).setTag(obj);
            AppMethodBeat.o(107338);
        }

        /* Access modifiers changed, original: protected|final */
        public final LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.i(107339);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            AppMethodBeat.o(107339);
            return layoutParams;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            int i3 = 0;
            AppMethodBeat.i(107340);
            super.onMeasure(i, i2);
            if (this.mNumColumns == 1 || c.this.zyr == null) {
                AppMethodBeat.o(107340);
                return;
            }
            if (this.mPosition % this.mNumColumns == 0 && !this.zyw) {
                this.zyw = true;
                for (View measure : this.zyr) {
                    measure.measure(i, i2);
                }
                this.zyw = false;
            }
            int measuredHeight = getMeasuredHeight();
            View[] viewArr = this.zyr;
            int length = viewArr.length;
            int i4 = measuredHeight;
            while (i3 < length) {
                View view = viewArr[i3];
                if (view != null) {
                    i4 = Math.max(i4, view.getMeasuredHeight());
                }
                i3++;
            }
            if (i4 == measuredHeight) {
                AppMethodBeat.o(107340);
                return;
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(i4, ErrorDialogData.SUPPRESSED));
            AppMethodBeat.o(107340);
        }
    }

    protected class a extends View {
        public a(Context context) {
            super(context);
        }
    }

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        AppMethodBeat.i(107342);
        this.mContext = context;
        this.zyo = bVar;
        this.zyp = gridHeadersGridView;
        bVar.registerDataSetObserver(this.PL);
        AppMethodBeat.o(107342);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.i(107343);
        this.mCount = 0;
        int dJh = this.zyo.dJh();
        if (dJh == 0) {
            i = this.zyo.getCount();
            AppMethodBeat.o(107343);
            return i;
        }
        while (i < dJh) {
            this.mCount += (this.zyo.PA(i) + PC(i)) + this.mNumColumns;
            i++;
        }
        i = this.mCount;
        AppMethodBeat.o(107343);
        return i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(107344);
        c PD = PD(i);
        if (PD.mPosition == -1 || PD.mPosition == -2) {
            AppMethodBeat.o(107344);
            return null;
        }
        Object item = this.zyo.getItem(PD.mPosition);
        AppMethodBeat.o(107344);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(107345);
        c PD = PD(i);
        if (PD.mPosition == -2) {
            AppMethodBeat.o(107345);
            return -1;
        } else if (PD.mPosition == -1) {
            AppMethodBeat.o(107345);
            return -2;
        } else {
            long itemId = this.zyo.getItemId(PD.mPosition);
            AppMethodBeat.o(107345);
            return itemId;
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(107346);
        c PD = PD(i);
        if (PD.mPosition == -2) {
            AppMethodBeat.o(107346);
            return 1;
        } else if (PD.mPosition == -1) {
            AppMethodBeat.o(107346);
            return 0;
        } else {
            int itemViewType = this.zyo.getItemViewType(PD.mPosition);
            if (itemViewType == -1) {
                AppMethodBeat.o(107346);
                return itemViewType;
            }
            itemViewType += 2;
            AppMethodBeat.o(107346);
            return itemViewType;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        d dVar;
        View bVar;
        AppMethodBeat.i(107347);
        if (view instanceof d) {
            d dVar2 = (d) view;
            childAt = dVar2.getChildAt(0);
            dVar = dVar2;
        } else {
            dVar = null;
            childAt = view;
        }
        c PD = PD(i);
        if (PD.mPosition == -2) {
            bVar = new b(this.mContext);
            bVar.setHeaderWidth(this.zyp.getWidth());
            ((b) bVar).setHeaderId(PD.zyv);
            bVar.setTag(this.zyo.a(PD.zyv, (View) bVar.getTag(), viewGroup));
        } else if (PD.mPosition == -1) {
            childAt = (a) childAt;
            if (childAt == null) {
                childAt = new a(this.mContext);
            }
            bVar = childAt;
        } else {
            bVar = this.zyo.getView(PD.mPosition, childAt, viewGroup);
        }
        if (dVar == null) {
            dVar = new d(this.mContext);
        }
        dVar.removeAllViews();
        dVar.addView(bVar);
        dVar.setPosition(i);
        dVar.setNumColumns(this.mNumColumns);
        this.zyr[i % this.mNumColumns] = dVar;
        if (i % this.mNumColumns == 0) {
            zyn = true;
            for (int i2 = 1; i2 < this.zyr.length; i2++) {
                this.zyr[i2] = getView(i + i2, null, viewGroup);
            }
            zyn = false;
        }
        dVar.setRowSiblings(this.zyr);
        if (!zyn && (i % this.mNumColumns == this.mNumColumns - 1 || i == getCount() - 1)) {
            PB(this.mNumColumns);
        }
        AppMethodBeat.o(107347);
        return dVar;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(107348);
        int viewTypeCount = this.zyo.getViewTypeCount() + 2;
        AppMethodBeat.o(107348);
        return viewTypeCount;
    }

    public final boolean hasStableIds() {
        AppMethodBeat.i(107349);
        boolean hasStableIds = this.zyo.hasStableIds();
        AppMethodBeat.o(107349);
        return hasStableIds;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(107350);
        boolean isEmpty = this.zyo.isEmpty();
        AppMethodBeat.o(107350);
        return isEmpty;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.i(107351);
        c PD = PD(i);
        if (PD.mPosition == -1 || PD.mPosition == -2) {
            AppMethodBeat.o(107351);
            return false;
        }
        boolean isEnabled = this.zyo.isEnabled(PD.mPosition);
        AppMethodBeat.o(107351);
        return isEnabled;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(107352);
        this.zyo.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.o(107352);
    }

    public final void setNumColumns(int i) {
        AppMethodBeat.i(107353);
        this.mNumColumns = i;
        PB(i);
        AppMethodBeat.o(107353);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(107354);
        this.zyo.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.o(107354);
    }

    private void PB(int i) {
        AppMethodBeat.i(107355);
        this.zyr = new View[i];
        Arrays.fill(this.zyr, null);
        AppMethodBeat.o(107355);
    }

    private int PC(int i) {
        AppMethodBeat.i(107356);
        int PA = this.zyo.PA(i) % this.mNumColumns;
        if (PA == 0) {
            AppMethodBeat.o(107356);
            return 0;
        }
        PA = this.mNumColumns - PA;
        AppMethodBeat.o(107356);
        return PA;
    }

    /* Access modifiers changed, original: protected|final */
    public final long tw(int i) {
        AppMethodBeat.i(107357);
        long j = (long) PD(i).zyv;
        AppMethodBeat.o(107357);
        return j;
    }

    /* Access modifiers changed, original: protected|final */
    public final View a(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107358);
        if (this.zyo.dJh() == 0) {
            AppMethodBeat.o(107358);
            return null;
        }
        View a = this.zyo.a(PD(i).zyv, view, viewGroup);
        AppMethodBeat.o(107358);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final c PD(int i) {
        int i2 = 0;
        AppMethodBeat.i(107359);
        int dJh = this.zyo.dJh();
        c cVar;
        if (dJh != 0) {
            int i3 = i;
            int i4 = i;
            while (i2 < dJh) {
                int PA = this.zyo.PA(i2);
                if (i4 == 0) {
                    cVar = new c(-2, i2);
                    AppMethodBeat.o(107359);
                    return cVar;
                }
                i4 -= this.mNumColumns;
                if (i4 < 0) {
                    cVar = new c(-1, i2);
                    AppMethodBeat.o(107359);
                    return cVar;
                }
                i3 -= this.mNumColumns;
                if (i4 < PA) {
                    cVar = new c(i3, i2);
                    AppMethodBeat.o(107359);
                    return cVar;
                }
                int PC = PC(i2);
                i4 -= PA + PC;
                i2++;
                i3 -= PC;
            }
            cVar = new c(-1, i2);
            AppMethodBeat.o(107359);
            return cVar;
        } else if (i >= this.zyo.getCount()) {
            cVar = new c(-1, 0);
            AppMethodBeat.o(107359);
            return cVar;
        } else {
            cVar = new c(i, 0);
            AppMethodBeat.o(107359);
            return cVar;
        }
    }
}
