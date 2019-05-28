package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;

public abstract class a {
    Context jiq;
    int jis = 0;
    protected c uKz;

    public abstract int aRA();

    public abstract int aRy();

    public abstract int aRz();

    public abstract int getPageCount();

    public abstract int getRowCount();

    public abstract int getRowSpacing();

    public abstract View qN(int i);

    public final void setPanelManager(c cVar) {
        this.uKz = cVar;
    }
}
