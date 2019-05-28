package com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b */
public final class C19514b {
    public static int iaT = 18;
    public static int iaU = 10;
    private static int iaV = 3;

    /* renamed from: cO */
    public static float m30236cO(Context context) {
        AppMethodBeat.m2504i(126597);
        float fromDPToPix = ((float) C1338a.fromDPToPix(context, iaT)) * 2.0f;
        AppMethodBeat.m2505o(126597);
        return fromDPToPix;
    }

    /* renamed from: E */
    public static int m30235E(Context context, int i) {
        AppMethodBeat.m2504i(139053);
        int fromDPToPix = C1338a.fromDPToPix(context, i);
        AppMethodBeat.m2505o(139053);
        return fromDPToPix;
    }

    public static int aGd() {
        return iaV;
    }
}
