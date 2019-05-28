package com.tencent.p177mm.p612ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.base.sortview.b */
public abstract class C36083b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    protected Context mContext;
    protected SparseArray<C46635a> yDr;
    protected Runnable yDs;

    /* renamed from: com.tencent.mm.ui.base.sortview.b$1 */
    class C360841 implements Runnable {
        C360841() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107303);
            C36083b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(107303);
        }
    }

    /* renamed from: sb */
    public abstract C46635a mo56928sb(int i);

    /* renamed from: sc */
    public abstract Object[] mo35290sc(int i);

    public C36083b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.yDr = new SparseArray();
        this.yDs = new C360841();
    }

    public int getCount() {
        return this.yDr.size();
    }

    public int getItemViewType(int i) {
        if (getItem(i) == null) {
            C4990ab.m7411d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", Integer.valueOf(getCount()), Integer.valueOf(i));
            return 0;
        } else if (getItem(i) == null) {
            return 0;
        } else {
            return getItem(i).type;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    /* renamed from: se */
    public C46635a getItem(int i) {
        if (i < 0 || i > getCount()) {
            C4990ab.m7413e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", Integer.valueOf(i));
            return null;
        }
        C46635a c46635a = (C46635a) this.yDr.get(i);
        if (c46635a != null) {
            return c46635a;
        }
        c46635a = mo56928sb(i);
        this.yDr.put(i, c46635a);
        return c46635a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        C46635a se = getItem(i);
        if (se == null) {
            C4990ab.m7412e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            C36082b aVY = se.aVY();
            if (aVY == null) {
                C4990ab.m7412e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                C40676a aVZ;
                if (view == null) {
                    view = aVY.mo22882c(this.mContext, view);
                    aVZ = se.aVZ();
                    aVY.mo22880a(view, aVZ);
                    view.setTag(aVZ);
                } else {
                    aVZ = (C40676a) view.getTag();
                }
                Object[] sc = mo35290sc(i);
                Assert.assertNotNull(aVZ);
                if (!se.dAG()) {
                    se.mo35282a(this.mContext, aVZ, sc);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                aVY.mo22879a(this.mContext, aVZ, se);
                long currentTimeMillis4 = System.currentTimeMillis();
                C4990ab.m7411d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C46635a se = getItem(i);
        if (se != null) {
            C36082b aVY = se.aVY();
            if (aVY == null || aVY.mo22881a(this.mContext, se, mo35290sc(i))) {
            }
        }
    }
}
