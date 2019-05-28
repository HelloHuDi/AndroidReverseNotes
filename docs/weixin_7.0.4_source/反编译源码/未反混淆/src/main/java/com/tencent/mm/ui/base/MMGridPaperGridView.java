package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class MMGridPaperGridView extends GridView {
    private int mCount;
    private int mIndex;
    private OnItemClickListener suz = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(106639);
            if (MMGridPaperGridView.this.yvi == null) {
                ab.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
                AppMethodBeat.o(106639);
                return;
            }
            MMGridPaperGridView.this.yvi;
            MMGridPaperGridView.this.yve;
            AppMethodBeat.o(106639);
        }
    };
    private int yvc;
    private int yvd;
    private int yve;
    private int yvf = -1;
    private boolean yvg = false;
    private a yvh;
    private j yvi;
    private OnItemLongClickListener yvj = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(106640);
            if (MMGridPaperGridView.this.yvi == null) {
                ab.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
                AppMethodBeat.o(106640);
            } else {
                MMGridPaperGridView.this.yvi;
                MMGridPaperGridView.this.yve;
                AppMethodBeat.o(106640);
            }
            return false;
        }
    };

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MMGridPaperGridView mMGridPaperGridView, byte b) {
            this();
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(106641);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106641);
                return false;
            }
            MMGridPaperGridView.this.yvi;
            MMGridPaperGridView.this.yve;
            AppMethodBeat.o(106641);
            return true;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(106642);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106642);
            } else {
                MMGridPaperGridView.this.yvi;
                MMGridPaperGridView.this.yve;
                AppMethodBeat.o(106642);
            }
            return 0;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(106643);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106643);
            } else {
                MMGridPaperGridView.this.yvi;
                AppMethodBeat.o(106643);
            }
            return 1;
        }

        public final int getCount() {
            AppMethodBeat.i(106644);
            if (MMGridPaperGridView.this.mCount < 0 || MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106644);
                return 0;
            }
            int c = MMGridPaperGridView.this.mCount;
            AppMethodBeat.o(106644);
            return c;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(106645);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106645);
                return null;
            }
            Object item = MMGridPaperGridView.this.yvi.getItem(MMGridPaperGridView.this.yve + i);
            AppMethodBeat.o(106645);
            return item;
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(106646);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.o(106646);
                return 0;
            }
            long itemId = MMGridPaperGridView.this.yvi.getItemId(MMGridPaperGridView.this.yve + i);
            AppMethodBeat.o(106646);
            return itemId;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.i(106647);
            long yz = bo.yz();
            String str = "MicroMsg.MMGridPaperGridView";
            String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(MMGridPaperGridView.this.mIndex);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(MMGridPaperGridView.this.yvg);
            ab.v(str, str2, objArr);
            if (MMGridPaperGridView.this.yvg) {
                view = null;
            }
            View d = MMGridPaperGridView.this.yvi == null ? null : MMGridPaperGridView.this.yvi.d(MMGridPaperGridView.this.yve + i, view);
            if (d != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (-1 == MMGridPaperGridView.this.yvf || MMGridPaperGridView.this.yve + i != MMGridPaperGridView.this.yvf) {
                d.setVisibility(0);
            } else {
                d.setVisibility(4);
            }
            ab.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(bo.az(yz)), Integer.valueOf(MMGridPaperGridView.this.yvf), Integer.valueOf(MMGridPaperGridView.this.yve + i));
            AppMethodBeat.o(106647);
            return d;
        }
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106648);
        AppMethodBeat.o(106648);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106649);
        AppMethodBeat.o(106649);
    }

    public final int getIndex() {
        return this.mIndex;
    }

    public final void a(int i, int i2, int i3, j jVar) {
        boolean z = true;
        AppMethodBeat.i(106650);
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (jVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        this.mIndex = i;
        this.yvc = i2;
        this.yvd = i3;
        this.yvi = jVar;
        this.mCount = this.yvc * this.yvd;
        this.yve = this.mIndex * this.mCount;
        if (this.yvi != null && this.yvi.getCount() - this.yve < this.mCount) {
            this.mCount = this.yvi.getCount() - this.yve;
        }
        if (getAdapter() == null) {
            ab.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.yvh = new a(this, (byte) 0);
            setAdapter(this.yvh);
        }
        setNumColumns(this.yvd);
        setColumnWidth(3);
        setOnItemClickListener(this.suz);
        setOnItemLongClickListener(this.yvj);
        AppMethodBeat.o(106650);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(106651);
        if (this.yvh != null) {
            this.yvh.notifyDataSetChanged();
        }
        AppMethodBeat.o(106651);
    }

    public final void setHiddenIndex(int i) {
        this.yvf = i;
    }

    public final void setClearMode(boolean z) {
        this.yvg = z;
    }
}
