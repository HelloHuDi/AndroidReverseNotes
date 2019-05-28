package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class n extends BaseAdapter {
    protected int scene;
    private SparseArray<a> xHR;
    public l zmV;
    private boolean zmW;
    boolean zmX;

    public abstract a mP(int i);

    public n(l lVar, boolean z, int i, boolean z2) {
        this.zmV = lVar;
        this.zmW = z;
        this.xHR = new SparseArray();
        this.scene = i;
        this.zmX = z2;
    }

    public n(l lVar, boolean z, int i) {
        this(lVar, z, i, false);
    }

    public boolean clI() {
        return this.zmW;
    }

    public final void qE(boolean z) {
        this.zmW = z;
        notifyDataSetChanged();
    }

    /* renamed from: Pn */
    public final a getItem(int i) {
        if (this.xHR.indexOfKey(i) >= 0) {
            return (a) this.xHR.get(i);
        }
        if (i < 0 || i >= getCount()) {
            ab.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        a mP = mP(i);
        if (mP != null) {
            mP.jLx = c(mP);
            this.xHR.put(i, mP);
            ab.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(mP.klY), Integer.valueOf(i));
            return mP;
        }
        ab.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return mP;
    }

    /* Access modifiers changed, original: protected */
    public boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            return getItem(i).klY;
        }
        ab.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a Pn = getItem(i);
        if (view == null) {
            view = Pn.aou().a(this.zmV.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!Pn.zpA) {
            Pn.a(this.zmV.getActivity(), aVar);
            Pn.zpA = true;
        }
        Pn.zmW = clI();
        Pn.aou().a(this.zmV.getActivity(), aVar, Pn, this.zmV.b(Pn), this.zmV.a(Pn));
        return view;
    }

    public final void clearCache() {
        if (this.xHR != null) {
            this.xHR.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean Po(int i) {
        return false;
    }
}
