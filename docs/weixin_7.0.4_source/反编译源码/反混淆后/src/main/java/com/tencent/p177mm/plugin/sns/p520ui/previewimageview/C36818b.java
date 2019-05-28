package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.b */
public abstract class C36818b extends C35140a {
    protected Context mContext;
    ArrayList<Object> mItems = new ArrayList();
    int rKK;

    protected C36818b(Context context) {
        this.mContext = context;
        this.rKK = 3;
    }

    /* renamed from: dy */
    public void mo25899dy(List<?> list) {
        clear();
        mo55766dx(list);
        this.mItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        mo55765cq(obj);
        this.mItems.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        mo55765cq(obj);
        this.mItems.add(i, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mItems.size();
    }

    public Object getItem(int i) {
        return this.mItems.get(i);
    }

    public final int getColumnCount() {
        return this.rKK;
    }

    /* renamed from: fB */
    public void mo25900fB(int i, int i2) {
        if (i2 < getCount()) {
            ArrayList arrayList = this.mItems;
            arrayList.add(i2, arrayList.remove(i));
            notifyDataSetChanged();
        }
    }

    /* renamed from: Es */
    public boolean mo25894Es(int i) {
        return true;
    }

    /* renamed from: Et */
    public boolean mo25895Et(int i) {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final Context getContext() {
        return this.mContext;
    }

    public void clear() {
        this.rKJ.clear();
        this.mItems.clear();
        notifyDataSetChanged();
    }
}
