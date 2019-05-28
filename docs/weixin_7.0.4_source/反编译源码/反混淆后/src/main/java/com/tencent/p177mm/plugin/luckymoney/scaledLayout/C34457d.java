package com.tencent.p177mm.plugin.luckymoney.scaledLayout;

import android.support.p069v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.d */
public final class C34457d {
    /* renamed from: a */
    public static void m56483a(RecyclerView recyclerView, ViewPagerLayoutManager viewPagerLayoutManager, int i) {
        AppMethodBeat.m2504i(42484);
        int qY = viewPagerLayoutManager.mo36594qY(i);
        if (viewPagerLayoutManager.mOrientation == 1) {
            recyclerView.mo66329a(0, qY, null);
            AppMethodBeat.m2505o(42484);
            return;
        }
        recyclerView.mo66329a(qY, 0, null);
        AppMethodBeat.m2505o(42484);
    }
}
