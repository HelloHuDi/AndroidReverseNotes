package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a extends v {
    protected k uSJ;

    public abstract void a(c cVar, int i, int i2);

    public abstract int dfW();

    public a(View view, k kVar) {
        super(view);
        this.uSJ = kVar;
    }
}
