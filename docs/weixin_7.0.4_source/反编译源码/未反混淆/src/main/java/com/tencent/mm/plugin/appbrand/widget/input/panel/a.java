package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;

public abstract class a {
    Context jiq;
    protected c jir;
    int jis = 0;

    public abstract int aRA();

    public abstract int aRy();

    public abstract int aRz();

    public abstract int getPageCount();

    public abstract int getRowCount();

    public abstract int getRowSpacing();

    public abstract View qN(int i);

    public final void setPanelManager(c cVar) {
        this.jir = cVar;
    }

    a() {
    }
}
