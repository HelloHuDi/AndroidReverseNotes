package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static void a(RecyclerView recyclerView, ViewPagerLayoutManager viewPagerLayoutManager, int i) {
        AppMethodBeat.i(42484);
        int qY = viewPagerLayoutManager.qY(i);
        if (viewPagerLayoutManager.mOrientation == 1) {
            recyclerView.a(0, qY, null);
            AppMethodBeat.o(42484);
            return;
        }
        recyclerView.a(qY, 0, null);
        AppMethodBeat.o(42484);
    }
}
