package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.g */
public class C29454g extends C46927h implements C43695a {
    public C29445e sGq;
    public FrameLayout sGr;

    public C29454g(View view, C4232b c4232b) {
        super(view, c4232b);
    }

    /* renamed from: ej */
    public final void mo47705ej(View view) {
        AppMethodBeat.m2504i(1945);
        this.sGr = (FrameLayout) view.findViewById(2131828298);
        AppMethodBeat.m2505o(1945);
    }

    /* renamed from: mc */
    public final void mo47707mc(boolean z) {
        AppMethodBeat.m2504i(1946);
        super.mo47707mc(z);
        this.sDN.mo9158FD(mo66454kj());
        if (this.sGq.mo56045O(z, false)) {
            cFO();
            cFN();
        }
        AppMethodBeat.m2505o(1946);
    }

    public void cGz() {
        AppMethodBeat.m2504i(1947);
        if (this.sGq == null) {
            LayoutParams layoutParams;
            this.sGq = new C29445e(this.sDN.bKU(), this.sDN, this);
            this.sGr.removeAllViews();
            if (this.sDN.cGb()) {
                layoutParams = new FrameLayout.LayoutParams(this.sDN.cFW().x, this.sDN.cFW().y);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.sDN.cFW().y, this.sDN.cFW().x);
            }
            this.sGr.addView(this.sGq, layoutParams);
        }
        this.sGq.mo56046a(this.sAX, cFP());
        AppMethodBeat.m2505o(1947);
    }

    public final int cFP() {
        AppMethodBeat.m2504i(138957);
        int kj = mo66454kj();
        AppMethodBeat.m2505o(138957);
        return kj;
    }

    public final View getWowView() {
        AppMethodBeat.m2504i(1949);
        View wowView = this.sGq.getControlBar().getWowView();
        AppMethodBeat.m2505o(1949);
        return wowView;
    }

    public final C35305f cGA() {
        return this.sGq;
    }

    /* renamed from: FN */
    public final void mo47701FN(int i) {
        AppMethodBeat.m2504i(1950);
        mo76163a(this.sDN, this.sDN.bKU(), this.sGq, i);
        AppMethodBeat.m2505o(1950);
    }
}
