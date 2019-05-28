package com.tencent.p177mm.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.platformtools.r */
public final class C37987r {
    /* renamed from: ci */
    public static void m64279ci(View view) {
        AppMethodBeat.m2504i(16669);
        if (view == null) {
            AppMethodBeat.m2505o(16669);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            C26528u c26528u = new C26528u();
            if (VERSION.SDK_INT >= 11) {
                view.setLayerType(1, null);
            }
        }
        AppMethodBeat.m2505o(16669);
    }
}
