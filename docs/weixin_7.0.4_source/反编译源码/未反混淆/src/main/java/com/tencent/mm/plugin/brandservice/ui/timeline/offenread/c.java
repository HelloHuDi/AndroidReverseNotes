package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends h {
    int padding;

    public c(int i) {
        this.padding = i;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(14341);
        int bp = RecyclerView.bp(view);
        rect.top = 0;
        rect.bottom = 0;
        rect.left = bp == 0 ? 0 : this.padding;
        rect.right = 0;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bp);
        objArr[1] = String.format("%d, %d, %d, %d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
        ab.d("MicroMsg.BizTimeLineHotViewItemDecoration", "alvinluo getItemOffsets pos: %d, rect: %s", objArr);
        AppMethodBeat.o(14341);
    }
}
