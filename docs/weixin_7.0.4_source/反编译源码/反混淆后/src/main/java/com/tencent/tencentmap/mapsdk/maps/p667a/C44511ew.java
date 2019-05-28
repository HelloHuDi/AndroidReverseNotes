package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Build.VERSION;
import com.tencent.map.lib.p822gl.C25724e;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ew */
public class C44511ew {
    /* renamed from: a */
    public static boolean m80736a(C25724e c25724e, boolean z) {
        AppMethodBeat.m2504i(98851);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(98851);
            return false;
        }
        c25724e.setPreserveEGLContextOnPause(z);
        AppMethodBeat.m2505o(98851);
        return true;
    }
}
