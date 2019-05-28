package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build.VERSION;
import com.tencent.map.lib.gl.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ew {
    public static boolean a(e eVar, boolean z) {
        AppMethodBeat.i(98851);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(98851);
            return false;
        }
        eVar.setPreserveEGLContextOnPause(z);
        AppMethodBeat.o(98851);
        return true;
    }
}
