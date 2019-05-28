package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.p177mm.plugin.luckymoney.model.C21206r;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.e */
public abstract class C39343e extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<C21206r> nSx = new LinkedList();

    public C39343e(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    /* renamed from: ck */
    public final void mo62229ck(List<C21206r> list) {
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

    /* renamed from: a */
    public final void mo62228a(C21206r c21206r) {
        this.nSx.remove(c21206r);
    }

    /* renamed from: yb */
    public final C21206r getItem(int i) {
        return (C21206r) this.nSx.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
