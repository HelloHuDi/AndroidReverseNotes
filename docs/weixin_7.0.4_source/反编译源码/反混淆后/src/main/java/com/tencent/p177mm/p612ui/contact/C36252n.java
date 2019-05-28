package com.tencent.p177mm.p612ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.contact.n */
public abstract class C36252n extends BaseAdapter {
    protected int scene;
    private SparseArray<C5445a> xHR;
    public C36251l zmV;
    private boolean zmW;
    boolean zmX;

    /* renamed from: mP */
    public abstract C5445a mo8217mP(int i);

    public C36252n(C36251l c36251l, boolean z, int i, boolean z2) {
        this.zmV = c36251l;
        this.zmW = z;
        this.xHR = new SparseArray();
        this.scene = i;
        this.zmX = z2;
    }

    public C36252n(C36251l c36251l, boolean z, int i) {
        this(c36251l, z, i, false);
    }

    public boolean clI() {
        return this.zmW;
    }

    /* renamed from: qE */
    public final void mo57126qE(boolean z) {
        this.zmW = z;
        notifyDataSetChanged();
    }

    /* renamed from: Pn */
    public final C5445a getItem(int i) {
        if (this.xHR.indexOfKey(i) >= 0) {
            return (C5445a) this.xHR.get(i);
        }
        if (i < 0 || i >= getCount()) {
            C4990ab.m7413e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        C5445a mP = mo8217mP(i);
        if (mP != null) {
            mP.jLx = mo39696c(mP);
            this.xHR.put(i, mP);
            C4990ab.m7411d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(mP.klY), Integer.valueOf(i));
            return mP;
        }
        C4990ab.m7413e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return mP;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public boolean mo39696c(C5445a c5445a) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            return getItem(i).klY;
        }
        C4990ab.m7413e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C5445a Pn = getItem(i);
        if (view == null) {
            view = Pn.aou().mo11086a(this.zmV.getActivity(), viewGroup);
        }
        C5446a c5446a = (C5446a) view.getTag();
        Assert.assertNotNull(c5446a);
        if (!Pn.zpA) {
            Pn.mo11082a(this.zmV.getActivity(), c5446a);
            Pn.zpA = true;
        }
        Pn.zmW = clI();
        Pn.aou().mo11087a(this.zmV.getActivity(), c5446a, Pn, this.zmV.mo39661b(Pn), this.zmV.mo7897a(Pn));
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

    /* renamed from: Po */
    public boolean mo39695Po(int i) {
        return false;
    }
}
