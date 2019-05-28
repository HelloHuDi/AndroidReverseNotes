package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.j */
public final class C39983j extends C29454g {
    public C39983j(View view, C4232b c4232b) {
        super(view, c4232b);
    }

    public final void cGz() {
        AppMethodBeat.m2504i(2012);
        if (this.sGq == null) {
            this.sGq = new C29445e(this.sDN.bKU(), this.sDN, this);
            this.sGq.setOnlyFS(true);
            this.sGr.removeAllViews();
            this.sGr.addView(this.sGq, new LayoutParams(this.sDN.cFW().x, this.sDN.cFW().y));
        }
        this.sGq.mo56046a(this.sAX, cFP());
        AppMethodBeat.m2505o(2012);
    }
}
