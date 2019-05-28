package com.tencent.mm.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class b {

    public static class a {
        public static int b(Context context, float f) {
            AppMethodBeat.i(16658);
            f fVar = new f();
            int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
            AppMethodBeat.o(16658);
            return round;
        }
    }

    public static class b {
        public static void a(ListView listView) {
            AppMethodBeat.i(16659);
            if (VERSION.SDK_INT >= 8) {
                ac acVar = new ac();
                if (listView.getFirstVisiblePosition() > 10) {
                    listView.setSelection(10);
                }
                if (VERSION.SDK_INT >= 8) {
                    listView.smoothScrollToPosition(0);
                }
                AppMethodBeat.o(16659);
                return;
            }
            ab abVar = new ab();
            listView.setSelection(0);
            AppMethodBeat.o(16659);
        }
    }
}
