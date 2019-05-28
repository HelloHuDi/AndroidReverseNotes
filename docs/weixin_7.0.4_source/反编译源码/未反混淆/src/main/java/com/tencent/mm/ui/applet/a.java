package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements OnScrollListener {
    private OnScrollListener vgR;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.vgR = null;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(106221);
        if (this.vgR != null) {
            this.vgR.onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.o(106221);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(106222);
        if (this.vgR != null) {
            this.vgR.onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.o(106222);
    }
}
