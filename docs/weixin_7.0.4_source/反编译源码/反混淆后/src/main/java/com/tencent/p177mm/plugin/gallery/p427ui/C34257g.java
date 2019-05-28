package com.tencent.p177mm.plugin.gallery.p427ui;

import android.graphics.PointF;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.gallery.ui.g */
public final class C34257g extends LinearLayoutManager {
    /* renamed from: a */
    public final void mo1755a(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(21604);
        C281721 c281721 = new C41189ah(recyclerView.getContext()) {
            /* renamed from: bX */
            public final PointF mo22752bX(int i) {
                AppMethodBeat.m2504i(21603);
                PointF bX = C34257g.this.mo1761bX(i);
                AppMethodBeat.m2505o(21603);
                return bX;
            }

            /* renamed from: c */
            public final float mo9235c(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }
        };
        c281721.ape = i;
        mo31829a((C37139r) c281721);
        AppMethodBeat.m2505o(21604);
    }
}
