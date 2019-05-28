package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.p;

public abstract class a<T> extends p<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean eBB;

    public abstract boolean bdn();

    public abstract int bdo();

    public abstract int getShowCount();

    public a(Context context, T t) {
        super(context, t);
        pN(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.eBB = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
