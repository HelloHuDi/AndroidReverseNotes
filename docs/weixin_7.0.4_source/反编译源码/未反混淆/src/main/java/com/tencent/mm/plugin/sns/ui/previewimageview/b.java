package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    protected Context mContext;
    ArrayList<Object> mItems = new ArrayList();
    int rKK;

    protected b(Context context) {
        this.mContext = context;
        this.rKK = 3;
    }

    public void dy(List<?> list) {
        clear();
        dx(list);
        this.mItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        cq(obj);
        this.mItems.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        cq(obj);
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

    public void fB(int i, int i2) {
        if (i2 < getCount()) {
            ArrayList arrayList = this.mItems;
            arrayList.add(i2, arrayList.remove(i));
            notifyDataSetChanged();
        }
    }

    public boolean Es(int i) {
        return true;
    }

    public boolean Et(int i) {
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
