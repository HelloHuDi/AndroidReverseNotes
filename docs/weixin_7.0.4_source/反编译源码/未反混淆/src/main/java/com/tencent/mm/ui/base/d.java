package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.p;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d extends p {
    public Context context;
    private int updateCount = 0;
    private Queue<View> ysn;

    public abstract View a(View view, ViewGroup viewGroup, int i);

    public abstract int bUL();

    public abstract void zU(int i);

    public d(Context context) {
        this.context = context;
        this.ysn = new LinkedList();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View a = a((View) this.ysn.poll(), viewGroup, i);
        if (a.getLayoutParams() == null) {
            a.setLayoutParams(new LayoutParams(-1, -1));
        }
        viewGroup.addView(a);
        ab.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.ysn.add(view);
        zU(i);
        ab.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", Integer.valueOf(this.ysn.size()));
    }

    public void notifyDataSetChanged() {
        this.updateCount = bUL();
        super.notifyDataSetChanged();
    }

    public int getItemPosition(Object obj) {
        if (this.updateCount <= 0) {
            return super.getItemPosition(obj);
        }
        this.updateCount--;
        return -2;
    }
}
