package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.support.p069v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13954d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.h */
public final class C39982h extends C13954d {
    /* renamed from: a */
    public final void mo26186a(C4232b c4232b) {
        AppMethodBeat.m2504i(2004);
        RecyclerView recyclerView = c4232b.getRecyclerView();
        C46927h c = C13954d.m22095c(c4232b);
        if (c instanceof C39983j) {
            int kj;
            C39983j c39983j = (C39983j) c;
            if (c39983j != null) {
                kj = c39983j.mo66454kj();
            } else {
                kj = -1;
            }
            if (kj != c4232b.cFY() && c4232b.cFV().sFw) {
                c4232b.cFV().stopPlay();
                if (c39983j != null) {
                    c4232b.cFR().mo74506e(c39983j.sAX);
                }
            }
            c4232b.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        c39983j = (C39983j) c4232b.getRecyclerView().mo66337aZ(childAt);
                        if (c39983j.mo66454kj() == kj) {
                            c39983j.cFN();
                            if (!c4232b.cFV().sFw) {
                                c39983j.sGq.cGn();
                            }
                        } else {
                            c39983j.sGq.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(2004);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(2004);
    }

    /* renamed from: b */
    public final void mo26188b(C4232b c4232b) {
        AppMethodBeat.m2504i(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        C46927h c = C13954d.m22095c(c4232b);
        if (c instanceof C39983j) {
            if (!c4232b.cFV().sFw) {
                if (c4232b.cFQ().isConnected()) {
                    c.mo47707mc(true);
                } else {
                    c.cGA().cGr();
                    c4232b.cFV().stopPlay();
                }
            }
            c.cFN();
            c4232b.mo9158FD(c.cFP());
            c4232b.cFR().cGS();
        }
        AppMethodBeat.m2505o(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
    }
}
