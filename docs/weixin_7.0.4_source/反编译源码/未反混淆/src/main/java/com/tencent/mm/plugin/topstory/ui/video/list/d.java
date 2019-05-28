package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends com.tencent.mm.plugin.topstory.ui.video.d {
    public final void a(b bVar) {
        AppMethodBeat.i(2023);
        RecyclerView recyclerView = bVar.getRecyclerView();
        v f = f(bVar);
        if (f instanceof h) {
            int cFP;
            h hVar = (h) f;
            if (hVar != null) {
                cFP = hVar.cFP();
            } else {
                cFP = -1;
            }
            if (cFP != bVar.cFY() && bVar.cFV().sFw) {
                bVar.cFV().stopPlay();
            }
            bVar.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        hVar = (h) bVar.getRecyclerView().aZ(childAt);
                        if (hVar.cFP() == cFP) {
                            hVar.cHk();
                            hVar.cFN();
                            if (!bVar.cFV().sFw) {
                                hVar.sGZ.cGn();
                            }
                        } else {
                            hVar.cHj();
                            hVar.sGZ.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(2023);
                    return;
                }
            }
        }
        AppMethodBeat.o(2023);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(2024);
        v f = f(bVar);
        if (f instanceof h) {
            h hVar = (h) f;
            if (!bVar.cFV().sFw) {
                if (bVar.cFQ().isConnected()) {
                    hVar.mc(true);
                } else {
                    hVar.sGZ.cGr();
                    bVar.cFV().stopPlay();
                }
            }
            hVar.cFN();
            bVar.FD(hVar.cFP());
            bVar.cFR().cGS();
            AppMethodBeat.o(2024);
            return;
        }
        AppMethodBeat.o(2024);
    }

    public final void a(b bVar, int i) {
        AppMethodBeat.i(2025);
        View view = null;
        for (int i2 = 0; i2 < bVar.getRecyclerView().getChildCount(); i2++) {
            view = bVar.getRecyclerView().getChildAt(i2);
            if (RecyclerView.bo(view) == i) {
                break;
            }
        }
        if (view != null) {
            bVar.getRecyclerView().a(0, bVar.cFX().bf(view) - bVar.cGd(), null);
        }
        AppMethodBeat.o(2025);
    }

    private static View e(b bVar) {
        AppMethodBeat.i(2026);
        int i = 0;
        while (i < bVar.getRecyclerView().getChildCount()) {
            View childAt = bVar.getRecyclerView().getChildAt(i);
            v aZ = bVar.getRecyclerView().aZ(childAt);
            if (childAt.getTag() == null || !childAt.getTag().equals("video") || childAt.getTop() <= 0 || aZ.kj() < 0) {
                ab.i("MicroMsg.TopStory.TopStoryHItemViewController", "findTargetPlayView index:%s, top:%s, pos:%s", Integer.valueOf(i), Integer.valueOf(childAt.getTop()), Integer.valueOf(aZ.kj()));
                i++;
            } else {
                AppMethodBeat.o(2026);
                return childAt;
            }
        }
        AppMethodBeat.o(2026);
        return null;
    }

    public static v f(b bVar) {
        AppMethodBeat.i(2027);
        View e = e(bVar);
        if (e != null) {
            v aZ = bVar.getRecyclerView().aZ(e);
            AppMethodBeat.o(2027);
            return aZ;
        }
        AppMethodBeat.o(2027);
        return null;
    }
}
