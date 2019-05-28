package com.tencent.p177mm.p612ui.gridviewheaders;

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

/* renamed from: com.tencent.mm.ui.gridviewheaders.c */
public final class C30711c extends BaseAdapter {
    private static boolean zyn;
    /* renamed from: PL */
    private DataSetObserver f13750PL = new C158951();
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;
    final C24009b zyo;
    private GridHeadersGridView zyp;
    private final List<View> zyq = new ArrayList();
    private View[] zyr;

    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$1 */
    class C158951 extends DataSetObserver {
        C158951() {
        }

        public final void onChanged() {
            int i = 0;
            AppMethodBeat.m2504i(107329);
            C30711c c30711c = C30711c.this;
            c30711c.mCount = 0;
            int dJh = c30711c.zyo.dJh();
            if (dJh == 0) {
                c30711c.mCount = c30711c.zyo.getCount();
            } else {
                while (i < dJh) {
                    c30711c.mCount += c30711c.zyo.mo39816PA(i) + c30711c.mNumColumns;
                    i++;
                }
            }
            C30711c.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(107329);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(107330);
            C30711c.this.zyq.clear();
            C30711c.this.notifyDataSetInvalidated();
            AppMethodBeat.m2505o(107330);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$b */
    protected class C24010b extends FrameLayout {
        private int zyt;
        private int zyu;

        public C24010b(Context context) {
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
            AppMethodBeat.m2504i(107331);
            View view = (View) getTag();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(generateDefaultLayoutParams());
            }
            if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
                view.measure(MeasureSpec.makeMeasureSpec(this.zyu, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(0, 0));
            }
            setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
            AppMethodBeat.m2505o(107331);
        }

        /* Access modifiers changed, original: protected|final */
        public final LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.m2504i(107332);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            AppMethodBeat.m2505o(107332);
            return layoutParams;
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$c */
    protected class C24011c {
        protected int mPosition;
        protected int zyv;

        protected C24011c(int i, int i2) {
            this.mPosition = i;
            this.zyv = i2;
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$d */
    protected class C30710d extends FrameLayout {
        private int mNumColumns;
        private int mPosition;
        private View[] zyr;
        private boolean zyw;

        public C30710d(Context context) {
            super(context);
        }

        public final Object getTag() {
            AppMethodBeat.m2504i(107334);
            Object tag = getChildAt(0).getTag();
            AppMethodBeat.m2505o(107334);
            return tag;
        }

        public final Object getTag(int i) {
            AppMethodBeat.m2504i(107335);
            Object tag = getChildAt(0).getTag(i);
            AppMethodBeat.m2505o(107335);
            return tag;
        }

        public final View getView() {
            AppMethodBeat.m2504i(107336);
            View childAt = getChildAt(0);
            AppMethodBeat.m2505o(107336);
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
            AppMethodBeat.m2504i(107337);
            getChildAt(0).setTag(i, obj);
            AppMethodBeat.m2505o(107337);
        }

        public final void setTag(Object obj) {
            AppMethodBeat.m2504i(107338);
            getChildAt(0).setTag(obj);
            AppMethodBeat.m2505o(107338);
        }

        /* Access modifiers changed, original: protected|final */
        public final LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.m2504i(107339);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            AppMethodBeat.m2505o(107339);
            return layoutParams;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            int i3 = 0;
            AppMethodBeat.m2504i(107340);
            super.onMeasure(i, i2);
            if (this.mNumColumns == 1 || C30711c.this.zyr == null) {
                AppMethodBeat.m2505o(107340);
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
                AppMethodBeat.m2505o(107340);
                return;
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(i4, ErrorDialogData.SUPPRESSED));
            AppMethodBeat.m2505o(107340);
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$a */
    protected class C30712a extends View {
        public C30712a(Context context) {
            super(context);
        }
    }

    public C30711c(Context context, GridHeadersGridView gridHeadersGridView, C24009b c24009b) {
        AppMethodBeat.m2504i(107342);
        this.mContext = context;
        this.zyo = c24009b;
        this.zyp = gridHeadersGridView;
        c24009b.registerDataSetObserver(this.f13750PL);
        AppMethodBeat.m2505o(107342);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(107343);
        this.mCount = 0;
        int dJh = this.zyo.dJh();
        if (dJh == 0) {
            i = this.zyo.getCount();
            AppMethodBeat.m2505o(107343);
            return i;
        }
        while (i < dJh) {
            this.mCount += (this.zyo.mo39816PA(i) + m48955PC(i)) + this.mNumColumns;
            i++;
        }
        i = this.mCount;
        AppMethodBeat.m2505o(107343);
        return i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(107344);
        C24011c PD = mo49090PD(i);
        if (PD.mPosition == -1 || PD.mPosition == -2) {
            AppMethodBeat.m2505o(107344);
            return null;
        }
        Object item = this.zyo.getItem(PD.mPosition);
        AppMethodBeat.m2505o(107344);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(107345);
        C24011c PD = mo49090PD(i);
        if (PD.mPosition == -2) {
            AppMethodBeat.m2505o(107345);
            return -1;
        } else if (PD.mPosition == -1) {
            AppMethodBeat.m2505o(107345);
            return -2;
        } else {
            long itemId = this.zyo.getItemId(PD.mPosition);
            AppMethodBeat.m2505o(107345);
            return itemId;
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(107346);
        C24011c PD = mo49090PD(i);
        if (PD.mPosition == -2) {
            AppMethodBeat.m2505o(107346);
            return 1;
        } else if (PD.mPosition == -1) {
            AppMethodBeat.m2505o(107346);
            return 0;
        } else {
            int itemViewType = this.zyo.getItemViewType(PD.mPosition);
            if (itemViewType == -1) {
                AppMethodBeat.m2505o(107346);
                return itemViewType;
            }
            itemViewType += 2;
            AppMethodBeat.m2505o(107346);
            return itemViewType;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        C30710d c30710d;
        View c24010b;
        AppMethodBeat.m2504i(107347);
        if (view instanceof C30710d) {
            C30710d c30710d2 = (C30710d) view;
            childAt = c30710d2.getChildAt(0);
            c30710d = c30710d2;
        } else {
            c30710d = null;
            childAt = view;
        }
        C24011c PD = mo49090PD(i);
        if (PD.mPosition == -2) {
            c24010b = new C24010b(this.mContext);
            c24010b.setHeaderWidth(this.zyp.getWidth());
            ((C24010b) c24010b).setHeaderId(PD.zyv);
            c24010b.setTag(this.zyo.mo39817a(PD.zyv, (View) c24010b.getTag(), viewGroup));
        } else if (PD.mPosition == -1) {
            childAt = (C30712a) childAt;
            if (childAt == null) {
                childAt = new C30712a(this.mContext);
            }
            c24010b = childAt;
        } else {
            c24010b = this.zyo.getView(PD.mPosition, childAt, viewGroup);
        }
        if (c30710d == null) {
            c30710d = new C30710d(this.mContext);
        }
        c30710d.removeAllViews();
        c30710d.addView(c24010b);
        c30710d.setPosition(i);
        c30710d.setNumColumns(this.mNumColumns);
        this.zyr[i % this.mNumColumns] = c30710d;
        if (i % this.mNumColumns == 0) {
            zyn = true;
            for (int i2 = 1; i2 < this.zyr.length; i2++) {
                this.zyr[i2] = getView(i + i2, null, viewGroup);
            }
            zyn = false;
        }
        c30710d.setRowSiblings(this.zyr);
        if (!zyn && (i % this.mNumColumns == this.mNumColumns - 1 || i == getCount() - 1)) {
            m48954PB(this.mNumColumns);
        }
        AppMethodBeat.m2505o(107347);
        return c30710d;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(107348);
        int viewTypeCount = this.zyo.getViewTypeCount() + 2;
        AppMethodBeat.m2505o(107348);
        return viewTypeCount;
    }

    public final boolean hasStableIds() {
        AppMethodBeat.m2504i(107349);
        boolean hasStableIds = this.zyo.hasStableIds();
        AppMethodBeat.m2505o(107349);
        return hasStableIds;
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(107350);
        boolean isEmpty = this.zyo.isEmpty();
        AppMethodBeat.m2505o(107350);
        return isEmpty;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.m2504i(107351);
        C24011c PD = mo49090PD(i);
        if (PD.mPosition == -1 || PD.mPosition == -2) {
            AppMethodBeat.m2505o(107351);
            return false;
        }
        boolean isEnabled = this.zyo.isEnabled(PD.mPosition);
        AppMethodBeat.m2505o(107351);
        return isEnabled;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(107352);
        this.zyo.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.m2505o(107352);
    }

    public final void setNumColumns(int i) {
        AppMethodBeat.m2504i(107353);
        this.mNumColumns = i;
        m48954PB(i);
        AppMethodBeat.m2505o(107353);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(107354);
        this.zyo.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.m2505o(107354);
    }

    /* renamed from: PB */
    private void m48954PB(int i) {
        AppMethodBeat.m2504i(107355);
        this.zyr = new View[i];
        Arrays.fill(this.zyr, null);
        AppMethodBeat.m2505o(107355);
    }

    /* renamed from: PC */
    private int m48955PC(int i) {
        AppMethodBeat.m2504i(107356);
        int PA = this.zyo.mo39816PA(i) % this.mNumColumns;
        if (PA == 0) {
            AppMethodBeat.m2505o(107356);
            return 0;
        }
        PA = this.mNumColumns - PA;
        AppMethodBeat.m2505o(107356);
        return PA;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: tw */
    public final long mo49104tw(int i) {
        AppMethodBeat.m2504i(107357);
        long j = (long) mo49090PD(i).zyv;
        AppMethodBeat.m2505o(107357);
        return j;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final View mo49091a(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107358);
        if (this.zyo.dJh() == 0) {
            AppMethodBeat.m2505o(107358);
            return null;
        }
        View a = this.zyo.mo39817a(mo49090PD(i).zyv, view, viewGroup);
        AppMethodBeat.m2505o(107358);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: PD */
    public final C24011c mo49090PD(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(107359);
        int dJh = this.zyo.dJh();
        C24011c c24011c;
        if (dJh != 0) {
            int i3 = i;
            int i4 = i;
            while (i2 < dJh) {
                int PA = this.zyo.mo39816PA(i2);
                if (i4 == 0) {
                    c24011c = new C24011c(-2, i2);
                    AppMethodBeat.m2505o(107359);
                    return c24011c;
                }
                i4 -= this.mNumColumns;
                if (i4 < 0) {
                    c24011c = new C24011c(-1, i2);
                    AppMethodBeat.m2505o(107359);
                    return c24011c;
                }
                i3 -= this.mNumColumns;
                if (i4 < PA) {
                    c24011c = new C24011c(i3, i2);
                    AppMethodBeat.m2505o(107359);
                    return c24011c;
                }
                int PC = m48955PC(i2);
                i4 -= PA + PC;
                i2++;
                i3 -= PC;
            }
            c24011c = new C24011c(-1, i2);
            AppMethodBeat.m2505o(107359);
            return c24011c;
        } else if (i >= this.zyo.getCount()) {
            c24011c = new C24011c(-1, 0);
            AppMethodBeat.m2505o(107359);
            return c24011c;
        } else {
            c24011c = new C24011c(i, 0);
            AppMethodBeat.m2505o(107359);
            return c24011c;
        }
    }
}
