package com.tencent.p177mm.plugin.facedetect.p400c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.c.b */
public enum C34094b {
    ;

    private C34094b(String str) {
    }

    static {
        AppMethodBeat.m2505o(120);
    }

    /* renamed from: a */
    public static C39010a m55881a(Context context, C11795f c11795f, int i, int i2, Bundle bundle) {
        AppMethodBeat.m2504i(C31128d.MIC_AVROUND_BLUR);
        C4990ab.m7417i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", Integer.valueOf(i));
        C39010a c3015c;
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                c3015c = new C3015c(context, c11795f, i, i2);
                AppMethodBeat.m2505o(C31128d.MIC_AVROUND_BLUR);
                return c3015c;
            case 2:
            case 5:
                c3015c = new C20630d(context, c11795f, i, i2, bundle);
                AppMethodBeat.m2505o(C31128d.MIC_AVROUND_BLUR);
                return c3015c;
            case 6:
                c3015c = new C27920e(context, c11795f, i, i2);
                AppMethodBeat.m2505o(C31128d.MIC_AVROUND_BLUR);
                return c3015c;
            default:
                AppMethodBeat.m2505o(C31128d.MIC_AVROUND_BLUR);
                return null;
        }
    }
}
