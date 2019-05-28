package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.support.p069v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13954d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.c */
public final class C43698c extends C13954d {
    /* renamed from: a */
    public final void mo26186a(C4232b c4232b) {
        AppMethodBeat.m2504i(1871);
        RecyclerView recyclerView = c4232b.getRecyclerView();
        C46927h c = C13954d.m22095c(c4232b);
        if (c instanceof C29454g) {
            int kj;
            C29454g c29454g = (C29454g) c;
            if (c29454g != null) {
                kj = c29454g.mo66454kj();
            } else {
                kj = -1;
            }
            if (kj != c4232b.cFY() && c4232b.cFV().sFw) {
                c4232b.cFV().stopPlay();
                if (c29454g != null) {
                    c4232b.cFR().mo74506e(c29454g.sAX);
                }
            }
            c4232b.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        c29454g = (C29454g) c4232b.getRecyclerView().mo66337aZ(childAt);
                        if (c29454g.mo66454kj() == kj) {
                            c29454g.cFN();
                            if (!c4232b.cFV().sFw) {
                                c29454g.sGq.cGn();
                            }
                        } else {
                            c29454g.sGq.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(1871);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(1871);
    }

    /* renamed from: b */
    public final void mo26188b(C4232b c4232b) {
        AppMethodBeat.m2504i(1872);
        C46927h c = C13954d.m22095c(c4232b);
        if (c != null && (c instanceof C29454g)) {
            if (!c4232b.cFV().sFw) {
                if (c4232b.cFQ().isConnected()) {
                    c4232b.cGe();
                    c.mo47707mc(true);
                } else {
                    c.cGA().cGr();
                    c4232b.cFV().stopPlay();
                }
            }
            c.cFN();
            c4232b.mo9158FD(c.cFP());
        }
        c4232b.cFR().cGS();
        AppMethodBeat.m2505o(1872);
    }
}
