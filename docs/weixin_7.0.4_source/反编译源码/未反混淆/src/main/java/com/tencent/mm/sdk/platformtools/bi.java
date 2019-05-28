package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bi {
    bi() {
    }

    @TargetApi(8)
    public static void c(ListView listView) {
        AppMethodBeat.i(93591);
        if (listView.getFirstVisiblePosition() > 10) {
            listView.setSelection(10);
        }
        if (VERSION.SDK_INT >= 8) {
            listView.smoothScrollToPosition(0);
        }
        AppMethodBeat.o(93591);
    }

    @TargetApi(8)
    public static void d(ListView listView, int i) {
        AppMethodBeat.i(93592);
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
            listView.setSelection(i + 10);
        } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
            listView.setSelection(i - 10);
        }
        if (VERSION.SDK_INT >= 8) {
            listView.smoothScrollToPosition(i);
        }
        AppMethodBeat.o(93592);
    }
}
