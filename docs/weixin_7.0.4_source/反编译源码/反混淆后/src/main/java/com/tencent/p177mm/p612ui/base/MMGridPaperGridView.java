package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.base.MMGridPaperGridView */
public final class MMGridPaperGridView extends GridView {
    private int mCount;
    private int mIndex;
    private OnItemClickListener suz = new C442621();
    private int yvc;
    private int yvd;
    private int yve;
    private int yvf = -1;
    private boolean yvg = false;
    private C15516a yvh;
    private C30392j yvi;
    private OnItemLongClickListener yvj = new C442632();

    /* renamed from: com.tencent.mm.ui.base.MMGridPaperGridView$a */
    class C15516a extends BaseAdapter {
        private C15516a() {
        }

        /* synthetic */ C15516a(MMGridPaperGridView mMGridPaperGridView, byte b) {
            this();
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(106641);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106641);
                return false;
            }
            MMGridPaperGridView.this.yvi;
            MMGridPaperGridView.this.yve;
            AppMethodBeat.m2505o(106641);
            return true;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(106642);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106642);
            } else {
                MMGridPaperGridView.this.yvi;
                MMGridPaperGridView.this.yve;
                AppMethodBeat.m2505o(106642);
            }
            return 0;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.m2504i(106643);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106643);
            } else {
                MMGridPaperGridView.this.yvi;
                AppMethodBeat.m2505o(106643);
            }
            return 1;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(106644);
            if (MMGridPaperGridView.this.mCount < 0 || MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106644);
                return 0;
            }
            int c = MMGridPaperGridView.this.mCount;
            AppMethodBeat.m2505o(106644);
            return c;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(106645);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106645);
                return null;
            }
            Object item = MMGridPaperGridView.this.yvi.getItem(MMGridPaperGridView.this.yve + i);
            AppMethodBeat.m2505o(106645);
            return item;
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(106646);
            if (MMGridPaperGridView.this.yvi == null) {
                AppMethodBeat.m2505o(106646);
                return 0;
            }
            long itemId = MMGridPaperGridView.this.yvi.getItemId(MMGridPaperGridView.this.yve + i);
            AppMethodBeat.m2505o(106646);
            return itemId;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.m2504i(106647);
            long yz = C5046bo.m7588yz();
            String str = "MicroMsg.MMGridPaperGridView";
            String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(MMGridPaperGridView.this.mIndex);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(MMGridPaperGridView.this.yvg);
            C4990ab.m7419v(str, str2, objArr);
            if (MMGridPaperGridView.this.yvg) {
                view = null;
            }
            View d = MMGridPaperGridView.this.yvi == null ? null : MMGridPaperGridView.this.yvi.mo48755d(MMGridPaperGridView.this.yve + i, view);
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
            C4990ab.m7419v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(MMGridPaperGridView.this.yvf), Integer.valueOf(MMGridPaperGridView.this.yve + i));
            AppMethodBeat.m2505o(106647);
            return d;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaperGridView$1 */
    class C442621 implements OnItemClickListener {
        C442621() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(106639);
            if (MMGridPaperGridView.this.yvi == null) {
                C4990ab.m7420w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
                AppMethodBeat.m2505o(106639);
                return;
            }
            MMGridPaperGridView.this.yvi;
            MMGridPaperGridView.this.yve;
            AppMethodBeat.m2505o(106639);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaperGridView$2 */
    class C442632 implements OnItemLongClickListener {
        C442632() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(106640);
            if (MMGridPaperGridView.this.yvi == null) {
                C4990ab.m7420w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
                AppMethodBeat.m2505o(106640);
            } else {
                MMGridPaperGridView.this.yvi;
                MMGridPaperGridView.this.yve;
                AppMethodBeat.m2505o(106640);
            }
            return false;
        }
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106648);
        AppMethodBeat.m2505o(106648);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106649);
        AppMethodBeat.m2505o(106649);
    }

    public final int getIndex() {
        return this.mIndex;
    }

    /* renamed from: a */
    public final void mo69945a(int i, int i2, int i3, C30392j c30392j) {
        boolean z = true;
        AppMethodBeat.m2504i(106650);
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (c30392j != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        this.mIndex = i;
        this.yvc = i2;
        this.yvd = i3;
        this.yvi = c30392j;
        this.mCount = this.yvc * this.yvd;
        this.yve = this.mIndex * this.mCount;
        if (this.yvi != null && this.yvi.getCount() - this.yve < this.mCount) {
            this.mCount = this.yvi.getCount() - this.yve;
        }
        if (getAdapter() == null) {
            C4990ab.m7420w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.yvh = new C15516a(this, (byte) 0);
            setAdapter(this.yvh);
        }
        setNumColumns(this.yvd);
        setColumnWidth(3);
        setOnItemClickListener(this.suz);
        setOnItemLongClickListener(this.yvj);
        AppMethodBeat.m2505o(106650);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(106651);
        if (this.yvh != null) {
            this.yvh.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(106651);
    }

    public final void setHiddenIndex(int i) {
        this.yvf = i;
    }

    public final void setClearMode(boolean z) {
        this.yvg = z;
    }
}
