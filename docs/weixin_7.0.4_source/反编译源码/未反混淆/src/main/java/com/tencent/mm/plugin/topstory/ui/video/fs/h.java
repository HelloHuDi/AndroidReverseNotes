package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.rtmp.TXLiveConstants;

public final class h extends d {
    public final void a(b bVar) {
        AppMethodBeat.i(2004);
        RecyclerView recyclerView = bVar.getRecyclerView();
        com.tencent.mm.plugin.topstory.ui.video.h c = d.c(bVar);
        if (c instanceof j) {
            int kj;
            j jVar = (j) c;
            if (jVar != null) {
                kj = jVar.kj();
            } else {
                kj = -1;
            }
            if (kj != bVar.cFY() && bVar.cFV().sFw) {
                bVar.cFV().stopPlay();
                if (jVar != null) {
                    bVar.cFR().e(jVar.sAX);
                }
            }
            bVar.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        jVar = (j) bVar.getRecyclerView().aZ(childAt);
                        if (jVar.kj() == kj) {
                            jVar.cFN();
                            if (!bVar.cFV().sFw) {
                                jVar.sGq.cGn();
                            }
                        } else {
                            jVar.sGq.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(2004);
                    return;
                }
            }
        }
        AppMethodBeat.o(2004);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        com.tencent.mm.plugin.topstory.ui.video.h c = d.c(bVar);
        if (c instanceof j) {
            if (!bVar.cFV().sFw) {
                if (bVar.cFQ().isConnected()) {
                    c.mc(true);
                } else {
                    c.cGA().cGr();
                    bVar.cFV().stopPlay();
                }
            }
            c.cFN();
            bVar.FD(c.cFP());
            bVar.cFR().cGS();
        }
        AppMethodBeat.o(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
    }
}
