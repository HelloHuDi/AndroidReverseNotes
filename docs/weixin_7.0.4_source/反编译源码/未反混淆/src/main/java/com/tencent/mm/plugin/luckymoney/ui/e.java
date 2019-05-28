package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.r;
import java.util.LinkedList;
import java.util.List;

public abstract class e extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<r> nSx = new LinkedList();

    public e(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public final void ck(List<r> list) {
        if (list == null) {
            this.nSx = new LinkedList();
        } else {
            this.nSx = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.nSx.size();
    }

    public final void a(r rVar) {
        this.nSx.remove(rVar);
    }

    /* renamed from: yb */
    public final r getItem(int i) {
        return (r) this.nSx.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
