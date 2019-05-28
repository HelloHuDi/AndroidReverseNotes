package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;

public final class j extends g {
    public j(View view, b bVar) {
        super(view, bVar);
    }

    public final void cGz() {
        AppMethodBeat.i(2012);
        if (this.sGq == null) {
            this.sGq = new e(this.sDN.bKU(), this.sDN, this);
            this.sGq.setOnlyFS(true);
            this.sGr.removeAllViews();
            this.sGr.addView(this.sGq, new LayoutParams(this.sDN.cFW().x, this.sDN.cFW().y));
        }
        this.sGq.a(this.sAX, cFP());
        AppMethodBeat.o(2012);
    }
}
