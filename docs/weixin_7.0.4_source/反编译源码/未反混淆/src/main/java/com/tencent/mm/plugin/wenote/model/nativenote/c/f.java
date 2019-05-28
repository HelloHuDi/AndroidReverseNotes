package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f {
    public static View f(RecyclerView recyclerView, int i) {
        AppMethodBeat.i(26928);
        if (recyclerView == null) {
            AppMethodBeat.o(26928);
            return null;
        }
        View bW;
        try {
            i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                bW = ((LinearLayoutManager) layoutManager).bW(i);
                AppMethodBeat.o(26928);
                return bW;
            }
        } catch (Exception e) {
        }
        bW = null;
        AppMethodBeat.o(26928);
        return bW;
    }

    public static c er(View view) {
        AppMethodBeat.i(26929);
        if (view == null) {
            AppMethodBeat.o(26929);
            return null;
        }
        WXRTEditText wXRTEditText = (WXRTEditText) view.findViewById(R.id.djo);
        WXRTEditText wXRTEditText2 = (WXRTEditText) view.findViewById(R.id.djl);
        WXRTEditText wXRTEditText3 = (WXRTEditText) view.findViewById(R.id.djn);
        c cVar = wXRTEditText != null ? new c(wXRTEditText) : (wXRTEditText2 == null || wXRTEditText3 == null) ? null : new c(wXRTEditText2, wXRTEditText3);
        AppMethodBeat.o(26929);
        return cVar;
    }
}
