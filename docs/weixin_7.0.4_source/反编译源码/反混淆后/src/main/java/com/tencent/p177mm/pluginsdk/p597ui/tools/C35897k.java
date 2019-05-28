package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@TargetApi(11)
/* renamed from: com.tencent.mm.pluginsdk.ui.tools.k */
public final class C35897k {
    /* renamed from: a */
    public static void m58842a(ListView listView, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(105869);
        if (listView == null) {
            AppMethodBeat.m2505o(105869);
            return;
        }
        C4990ab.m7417i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
        listView.setItemChecked(i, true);
        listView.setSelectionFromTop(i, i2);
        AppMethodBeat.m2505o(105869);
    }
}
