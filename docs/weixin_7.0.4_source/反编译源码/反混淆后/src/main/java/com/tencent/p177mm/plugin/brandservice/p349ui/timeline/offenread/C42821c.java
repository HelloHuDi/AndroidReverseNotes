package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import android.graphics.Rect;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c */
public final class C42821c extends C25373h {
    int padding;

    public C42821c(int i) {
        this.padding = i;
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(14341);
        int bp = RecyclerView.m72548bp(view);
        rect.top = 0;
        rect.bottom = 0;
        rect.left = bp == 0 ? 0 : this.padding;
        rect.right = 0;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bp);
        objArr[1] = String.format("%d, %d, %d, %d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
        C4990ab.m7411d("MicroMsg.BizTimeLineHotViewItemDecoration", "alvinluo getItemOffsets pos: %d, rect: %s", objArr);
        AppMethodBeat.m2505o(14341);
    }
}
