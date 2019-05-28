package com.tencent.p177mm.p612ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.applet.a */
public final class C23576a implements OnScrollListener {
    private OnScrollListener vgR;

    public C23576a() {
        this((byte) 0);
    }

    private C23576a(byte b) {
        this.vgR = null;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(106221);
        if (this.vgR != null) {
            this.vgR.onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.m2505o(106221);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(106222);
        if (this.vgR != null) {
            this.vgR.onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.m2505o(106222);
    }
}
