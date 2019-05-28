package com.tencent.p177mm.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
/* renamed from: com.tencent.mm.platformtools.b */
public final class C37985b {

    /* renamed from: com.tencent.mm.platformtools.b$a */
    public static class C9786a {
        /* renamed from: b */
        public static int m17425b(Context context, float f) {
            AppMethodBeat.m2504i(16658);
            C9789f c9789f = new C9789f();
            int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
            AppMethodBeat.m2505o(16658);
            return round;
        }
    }

    /* renamed from: com.tencent.mm.platformtools.b$b */
    public static class C9787b {
        /* renamed from: a */
        public static void m17426a(ListView listView) {
            AppMethodBeat.m2504i(16659);
            if (VERSION.SDK_INT >= 8) {
                C26525ac c26525ac = new C26525ac();
                if (listView.getFirstVisiblePosition() > 10) {
                    listView.setSelection(10);
                }
                if (VERSION.SDK_INT >= 8) {
                    listView.smoothScrollToPosition(0);
                }
                AppMethodBeat.m2505o(16659);
                return;
            }
            C26524ab c26524ab = new C26524ab();
            listView.setSelection(0);
            AppMethodBeat.m2505o(16659);
        }
    }
}
