package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.a */
public abstract class C42745a {
    Context jiq;
    protected C27414c jir;
    int jis = 0;

    public abstract int aRA();

    public abstract int aRy();

    public abstract int aRz();

    public abstract int getPageCount();

    public abstract int getRowCount();

    public abstract int getRowSpacing();

    /* renamed from: qN */
    public abstract View mo35148qN(int i);

    public final void setPanelManager(C27414c c27414c) {
        this.jir = c27414c;
    }

    C42745a() {
    }
}
