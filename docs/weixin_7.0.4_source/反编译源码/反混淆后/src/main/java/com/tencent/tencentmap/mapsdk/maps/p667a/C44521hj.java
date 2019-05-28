package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.p822gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hj */
public class C44521hj {
    /* renamed from: a */
    static final String[] f17435a = new String[]{JNI.LIB_NAME, "txnavengine"};

    /* renamed from: a */
    public static void m80786a(Context context, String str) {
        AppMethodBeat.m2504i(99543);
        try {
            System.loadLibrary(str);
            C1015d.m2288a("loadLibary:" + str + "  successful");
            AppMethodBeat.m2505o(99543);
        } catch (UnsatisfiedLinkError e) {
            C1015d.m2288a("loadLibary:" + str + " result:" + C24387hk.m37836a(context, str));
            AppMethodBeat.m2505o(99543);
        }
    }
}
