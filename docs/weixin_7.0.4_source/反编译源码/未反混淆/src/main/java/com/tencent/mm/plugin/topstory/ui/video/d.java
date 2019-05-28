package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {
    public void a(b bVar) {
    }

    public void b(b bVar) {
    }

    public void a(b bVar, int i) {
    }

    public static final h c(b bVar) {
        v vVar;
        AppMethodBeat.i(1709);
        int childCount = bVar.getLayoutManager().getChildCount();
        if (childCount == 0) {
            vVar = null;
        } else {
            int je;
            if (bVar.getLayoutManager().getClipToPadding()) {
                je = bVar.cFX().je() + (bVar.cFX().jg() / 2);
            } else {
                je = bVar.cFX().getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            View view = null;
            while (i2 < childCount) {
                View childAt = bVar.getLayoutManager().getChildAt(i2);
                int abs = Math.abs((bVar.cFX().bf(childAt) + (bVar.cFX().bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            vVar = bVar.getRecyclerView().aZ(view);
        }
        if (vVar instanceof h) {
            h hVar = (h) vVar;
            AppMethodBeat.o(1709);
            return hVar;
        }
        AppMethodBeat.o(1709);
        return null;
    }
}
