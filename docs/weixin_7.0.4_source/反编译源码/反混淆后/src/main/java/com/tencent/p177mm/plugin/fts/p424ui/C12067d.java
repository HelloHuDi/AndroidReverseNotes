package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.d */
public abstract class C12067d extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    private int count;
    private OnScrollListener kxp;
    private C28149e mIj;
    private SparseArray<C3154a> mIk = new SparseArray();
    long mIl;
    C12068a mIm;
    String query;

    /* renamed from: com.tencent.mm.plugin.fts.ui.d$a */
    public interface C12068a {
        /* renamed from: U */
        void mo7444U(int i, boolean z);
    }

    /* renamed from: a */
    public abstract boolean mo7491a(View view, C3154a c3154a, boolean z);

    public abstract void bAL();

    /* renamed from: vZ */
    public abstract C3154a mo7495vZ(int i);

    public /* synthetic */ Object getItem(int i) {
        return m19990wb(i);
    }

    public final Context getContext() {
        return this.mIj.getContext();
    }

    public C12067d(C28149e c28149e) {
        C4990ab.m7416i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.mIj = c28149e;
    }

    /* Access modifiers changed, original: protected|final */
    public final void setCount(int i) {
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", Integer.valueOf(i));
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (m19990wb(i) != null) {
            return m19990wb(i).klY;
        }
        C4990ab.m7413e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 21;
    }

    /* renamed from: wb */
    private C3154a m19990wb(int i) {
        if (this.mIk.indexOfKey(i) >= 0) {
            return (C3154a) this.mIk.get(i);
        }
        C3154a c3154a = null;
        if (i >= 0 && i < getCount()) {
            c3154a = mo7495vZ(i);
        }
        if (c3154a == null) {
            return (C3154a) this.mIk.get(0);
        }
        this.mIk.put(i, c3154a);
        return c3154a;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3154a wb = m19990wb(i);
        if (view == null) {
            view = wb.mo7412Ps().mo7420a(getContext(), viewGroup);
        }
        C3155a c3155a = (C3155a) view.getTag();
        if (!wb.mFj) {
            wb.mo7413a(getContext(), c3155a, new Object[0]);
            wb.mFj = true;
        }
        wb.mo7412Ps().mo7421a(getContext(), c3155a, wb, new Object[0]);
        return view;
    }

    /* renamed from: Nu */
    public final void mo23893Nu(String str) {
        stopSearch();
        this.mIl = System.currentTimeMillis();
        this.query = str;
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", str);
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
    /* renamed from: T */
    public final void mo23894T(int i, boolean z) {
        if (this.mIm != null) {
            this.mIm.mo7444U(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mIj.aqX();
        if (i < getCount()) {
            C3154a wb = m19990wb(i);
            mo7491a(view, wb, wb.mo7412Ps().mo7422a(getContext(), wb));
            this.mIj.mo7441a(wb);
        }
    }

    /* Access modifiers changed, original: protected */
    public int bAt() {
        return getCount();
    }
}
