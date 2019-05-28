package com.tencent.mm.plugin.gallery.ui;

import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.ah;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends LinearLayoutManager {
    public final void a(RecyclerView recyclerView, int i) {
        AppMethodBeat.i(21604);
        AnonymousClass1 anonymousClass1 = new ah(recyclerView.getContext()) {
            public final PointF bX(int i) {
                AppMethodBeat.i(21603);
                PointF bX = g.this.bX(i);
                AppMethodBeat.o(21603);
                return bX;
            }

            public final float c(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }
        };
        anonymousClass1.ape = i;
        a((r) anonymousClass1);
        AppMethodBeat.o(21604);
    }
}
