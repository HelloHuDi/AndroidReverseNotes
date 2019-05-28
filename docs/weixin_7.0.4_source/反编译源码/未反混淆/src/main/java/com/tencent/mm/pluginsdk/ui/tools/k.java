package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(11)
public final class k {
    public static void a(ListView listView, int i, int i2, boolean z) {
        AppMethodBeat.i(105869);
        if (listView == null) {
            AppMethodBeat.o(105869);
            return;
        }
        ab.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
        listView.setItemChecked(i, true);
        listView.setSelectionFromTop(i, i2);
        AppMethodBeat.o(105869);
    }
}
