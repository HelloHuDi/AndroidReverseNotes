package com.tencent.p177mm.plugin.readerapp.p490ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.p177mm.p612ui.C46692p;

/* renamed from: com.tencent.mm.plugin.readerapp.ui.a */
public abstract class C43419a<T> extends C46692p<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + C43419a.class.getName());
    protected boolean eBB;

    public abstract boolean bdn();

    public abstract int bdo();

    public abstract int getShowCount();

    public C43419a(Context context, T t) {
        super(context, t);
        mo74996pN(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.eBB = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
