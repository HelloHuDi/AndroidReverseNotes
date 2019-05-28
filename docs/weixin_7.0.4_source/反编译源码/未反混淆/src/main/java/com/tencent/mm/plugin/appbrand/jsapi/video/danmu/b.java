package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;

public final class b {
    public static int iaT = 18;
    public static int iaU = 10;
    private static int iaV = 3;

    public static float cO(Context context) {
        AppMethodBeat.i(126597);
        float fromDPToPix = ((float) a.fromDPToPix(context, iaT)) * 2.0f;
        AppMethodBeat.o(126597);
        return fromDPToPix;
    }

    public static int E(Context context, int i) {
        AppMethodBeat.i(139053);
        int fromDPToPix = a.fromDPToPix(context, i);
        AppMethodBeat.o(139053);
        return fromDPToPix;
    }

    public static int aGd() {
        return iaV;
    }
}
