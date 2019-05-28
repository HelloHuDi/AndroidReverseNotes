package com.tencent.p177mm.plugin.wenote.model.nativenote.p586c;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.f */
public final class C14729f {
    /* renamed from: f */
    public static View m22928f(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(26928);
        if (recyclerView == null) {
            AppMethodBeat.m2505o(26928);
            return null;
        }
        View bW;
        try {
            C17480i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                bW = ((LinearLayoutManager) layoutManager).mo1760bW(i);
                AppMethodBeat.m2505o(26928);
                return bW;
            }
        } catch (Exception e) {
        }
        bW = null;
        AppMethodBeat.m2505o(26928);
        return bW;
    }

    /* renamed from: er */
    public static C4669c m22927er(View view) {
        AppMethodBeat.m2504i(26929);
        if (view == null) {
            AppMethodBeat.m2505o(26929);
            return null;
        }
        WXRTEditText wXRTEditText = (WXRTEditText) view.findViewById(2131826414);
        WXRTEditText wXRTEditText2 = (WXRTEditText) view.findViewById(2131826411);
        WXRTEditText wXRTEditText3 = (WXRTEditText) view.findViewById(2131826413);
        C4669c c4669c = wXRTEditText != null ? new C4669c(wXRTEditText) : (wXRTEditText2 == null || wXRTEditText3 == null) ? null : new C4669c(wXRTEditText2, wXRTEditText3);
        AppMethodBeat.m2505o(26929);
        return c4669c;
    }
}
