package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a.a;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    protected Context mContext;
    protected SparseArray<a> yDr;
    protected Runnable yDs;

    public abstract a sb(int i);

    public abstract Object[] sc(int i);

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.yDr = new SparseArray();
        this.yDs = new Runnable() {
            public final void run() {
                AppMethodBeat.i(107303);
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(107303);
            }
        };
    }

    public int getCount() {
        return this.yDr.size();
    }

    public int getItemViewType(int i) {
        if (getItem(i) == null) {
            ab.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", Integer.valueOf(getCount()), Integer.valueOf(i));
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
    public a getItem(int i) {
        if (i < 0 || i > getCount()) {
            ab.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", Integer.valueOf(i));
            return null;
        }
        a aVar = (a) this.yDr.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = sb(i);
        this.yDr.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a se = getItem(i);
        if (se == null) {
            ab.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.ui.base.sortview.a.b aVY = se.aVY();
            if (aVY == null) {
                ab.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a aVZ;
                if (view == null) {
                    view = aVY.c(this.mContext, view);
                    aVZ = se.aVZ();
                    aVY.a(view, aVZ);
                    view.setTag(aVZ);
                } else {
                    aVZ = (a) view.getTag();
                }
                Object[] sc = sc(i);
                Assert.assertNotNull(aVZ);
                if (!se.dAG()) {
                    se.a(this.mContext, aVZ, sc);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                aVY.a(this.mContext, aVZ, se);
                long currentTimeMillis4 = System.currentTimeMillis();
                ab.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a se = getItem(i);
        if (se != null) {
            com.tencent.mm.ui.base.sortview.a.b aVY = se.aVY();
            if (aVY == null || aVY.a(this.mContext, se, sc(i))) {
            }
        }
    }
}
