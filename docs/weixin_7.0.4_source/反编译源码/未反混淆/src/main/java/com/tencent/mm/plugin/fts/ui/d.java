package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class d extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    private int count;
    private OnScrollListener kxp;
    private e mIj;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> mIk = new SparseArray();
    long mIl;
    a mIm;
    String query;

    public interface a {
        void U(int i, boolean z);
    }

    public abstract boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z);

    public abstract void bAL();

    public abstract com.tencent.mm.plugin.fts.a.d.a.a vZ(int i);

    public /* synthetic */ Object getItem(int i) {
        return wb(i);
    }

    public final Context getContext() {
        return this.mIj.getContext();
    }

    public d(e eVar) {
        ab.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.mIj = eVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void setCount(int i) {
        ab.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", Integer.valueOf(i));
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (wb(i) != null) {
            return wb(i).klY;
        }
        ab.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 21;
    }

    private com.tencent.mm.plugin.fts.a.d.a.a wb(int i) {
        if (this.mIk.indexOfKey(i) >= 0) {
            return (com.tencent.mm.plugin.fts.a.d.a.a) this.mIk.get(i);
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar = null;
        if (i >= 0 && i < getCount()) {
            aVar = vZ(i);
        }
        if (aVar == null) {
            return (com.tencent.mm.plugin.fts.a.d.a.a) this.mIk.get(0);
        }
        this.mIk.put(i, aVar);
        return aVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.fts.a.d.a.a wb = wb(i);
        if (view == null) {
            view = wb.Ps().a(getContext(), viewGroup);
        }
        com.tencent.mm.plugin.fts.a.d.a.a.a aVar = (com.tencent.mm.plugin.fts.a.d.a.a.a) view.getTag();
        if (!wb.mFj) {
            wb.a(getContext(), aVar, new Object[0]);
            wb.mFj = true;
        }
        wb.Ps().a(getContext(), aVar, wb, new Object[0]);
        return view;
    }

    public final void Nu(String str) {
        stopSearch();
        this.mIl = System.currentTimeMillis();
        this.query = str;
        ab.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", str);
        bAL();
    }

    public void stopSearch() {
        this.count = 0;
        this.query = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    /* Access modifiers changed, original: protected */
    public void clearCache() {
        this.mIk.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kxp != null) {
            this.kxp.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kxp != null) {
            this.kxp.onScroll(absListView, i, i2, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void T(int i, boolean z) {
        if (this.mIm != null) {
            this.mIm.U(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mIj.aqX();
        if (i < getCount()) {
            com.tencent.mm.plugin.fts.a.d.a.a wb = wb(i);
            a(view, wb, wb.Ps().a(getContext(), wb));
            this.mIj.a(wb);
        }
    }

    /* Access modifiers changed, original: protected */
    public int bAt() {
        return getCount();
    }
}
