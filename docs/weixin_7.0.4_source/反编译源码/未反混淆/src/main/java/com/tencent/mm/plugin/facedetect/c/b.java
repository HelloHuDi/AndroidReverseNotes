package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public enum b {
    ;

    private b(String str) {
    }

    static {
        AppMethodBeat.o(120);
    }

    public static a a(Context context, f fVar, int i, int i2, Bundle bundle) {
        AppMethodBeat.i(d.MIC_AVROUND_BLUR);
        ab.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", Integer.valueOf(i));
        a cVar;
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                cVar = new c(context, fVar, i, i2);
                AppMethodBeat.o(d.MIC_AVROUND_BLUR);
                return cVar;
            case 2:
            case 5:
                cVar = new d(context, fVar, i, i2, bundle);
                AppMethodBeat.o(d.MIC_AVROUND_BLUR);
                return cVar;
            case 6:
                cVar = new e(context, fVar, i, i2);
                AppMethodBeat.o(d.MIC_AVROUND_BLUR);
                return cVar;
            default:
                AppMethodBeat.o(d.MIC_AVROUND_BLUR);
                return null;
        }
    }
}
