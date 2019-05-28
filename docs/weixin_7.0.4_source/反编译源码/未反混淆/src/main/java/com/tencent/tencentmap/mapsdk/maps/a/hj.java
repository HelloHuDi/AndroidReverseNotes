package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class hj {
    static final String[] a = new String[]{JNI.LIB_NAME, "txnavengine"};

    public static void a(Context context, String str) {
        AppMethodBeat.i(99543);
        try {
            System.loadLibrary(str);
            d.a("loadLibary:" + str + "  successful");
            AppMethodBeat.o(99543);
        } catch (UnsatisfiedLinkError e) {
            d.a("loadLibary:" + str + " result:" + hk.a(context, str));
            AppMethodBeat.o(99543);
        }
    }
}
