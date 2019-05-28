package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;

public class g extends h implements a {
    public e sGq;
    public FrameLayout sGr;

    public g(View view, b bVar) {
        super(view, bVar);
    }

    public final void ej(View view) {
        AppMethodBeat.i(1945);
        this.sGr = (FrameLayout) view.findViewById(R.id.exl);
        AppMethodBeat.o(1945);
    }

    public final void mc(boolean z) {
        AppMethodBeat.i(1946);
        super.mc(z);
        this.sDN.FD(kj());
        if (this.sGq.O(z, false)) {
            cFO();
            cFN();
        }
        AppMethodBeat.o(1946);
    }

    public void cGz() {
        AppMethodBeat.i(1947);
        if (this.sGq == null) {
            LayoutParams layoutParams;
            this.sGq = new e(this.sDN.bKU(), this.sDN, this);
            this.sGr.removeAllViews();
            if (this.sDN.cGb()) {
                layoutParams = new FrameLayout.LayoutParams(this.sDN.cFW().x, this.sDN.cFW().y);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.sDN.cFW().y, this.sDN.cFW().x);
            }
            this.sGr.addView(this.sGq, layoutParams);
        }
        this.sGq.a(this.sAX, cFP());
        AppMethodBeat.o(1947);
    }

    public final int cFP() {
        AppMethodBeat.i(138957);
        int kj = kj();
        AppMethodBeat.o(138957);
        return kj;
    }

    public final View getWowView() {
        AppMethodBeat.i(1949);
        View wowView = this.sGq.getControlBar().getWowView();
        AppMethodBeat.o(1949);
        return wowView;
    }

    public final f cGA() {
        return this.sGq;
    }

    public final void FN(int i) {
        AppMethodBeat.i(1950);
        a(this.sDN, this.sDN.bKU(), this.sGq, i);
        AppMethodBeat.o(1950);
    }
}
