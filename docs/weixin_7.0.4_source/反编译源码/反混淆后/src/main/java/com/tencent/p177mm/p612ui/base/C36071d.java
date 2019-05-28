package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.support.p057v4.view.C25365p;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.ui.base.d */
public abstract class C36071d extends C25365p {
    public Context context;
    private int updateCount = 0;
    private Queue<View> ysn;

    /* renamed from: a */
    public abstract View mo56916a(View view, ViewGroup viewGroup, int i);

    public abstract int bUL();

    /* renamed from: zU */
    public abstract void mo56918zU(int i);

    public C36071d(Context context) {
        this.context = context;
        this.ysn = new LinkedList();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View a = mo56916a((View) this.ysn.poll(), viewGroup, i);
        if (a.getLayoutParams() == null) {
            a.setLayoutParams(new LayoutParams(-1, -1));
        }
        viewGroup.addView(a);
        C4990ab.m7419v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.ysn.add(view);
        mo56918zU(i);
        C4990ab.m7411d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", Integer.valueOf(this.ysn.size()));
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
