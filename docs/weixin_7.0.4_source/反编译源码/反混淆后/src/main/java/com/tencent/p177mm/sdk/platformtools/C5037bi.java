package com.tencent.p177mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.bi */
final class C5037bi {
    C5037bi() {
    }

    @TargetApi(8)
    /* renamed from: c */
    public static void m7493c(ListView listView) {
        AppMethodBeat.m2504i(93591);
        if (listView.getFirstVisiblePosition() > 10) {
            listView.setSelection(10);
        }
        if (VERSION.SDK_INT >= 8) {
            listView.smoothScrollToPosition(0);
        }
        AppMethodBeat.m2505o(93591);
    }

    @TargetApi(8)
    /* renamed from: d */
    public static void m7494d(ListView listView, int i) {
        AppMethodBeat.m2504i(93592);
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
            listView.setSelection(i + 10);
        } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
            listView.setSelection(i - 10);
        }
        if (VERSION.SDK_INT >= 8) {
            listView.smoothScrollToPosition(i);
        }
        AppMethodBeat.m2505o(93592);
    }
}
