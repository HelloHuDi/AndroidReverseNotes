package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.h;

public final class c extends d {
    public final void a(b bVar) {
        AppMethodBeat.i(1871);
        RecyclerView recyclerView = bVar.getRecyclerView();
        h c = d.c(bVar);
        if (c instanceof g) {
            int kj;
            g gVar = (g) c;
            if (gVar != null) {
                kj = gVar.kj();
            } else {
                kj = -1;
            }
            if (kj != bVar.cFY() && bVar.cFV().sFw) {
                bVar.cFV().stopPlay();
                if (gVar != null) {
                    bVar.cFR().e(gVar.sAX);
                }
            }
            bVar.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        gVar = (g) bVar.getRecyclerView().aZ(childAt);
                        if (gVar.kj() == kj) {
                            gVar.cFN();
                            if (!bVar.cFV().sFw) {
                                gVar.sGq.cGn();
                            }
                        } else {
                            gVar.sGq.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(1871);
                    return;
                }
            }
        }
        AppMethodBeat.o(1871);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(1872);
        h c = d.c(bVar);
        if (c != null && (c instanceof g)) {
            if (!bVar.cFV().sFw) {
                if (bVar.cFQ().isConnected()) {
                    bVar.cGe();
                    c.mc(true);
                } else {
                    c.cGA().cGr();
                    bVar.cFV().stopPlay();
                }
            }
            c.cFN();
            bVar.FD(c.cFP());
        }
        bVar.cFR().cGS();
        AppMethodBeat.o(1872);
    }
}
