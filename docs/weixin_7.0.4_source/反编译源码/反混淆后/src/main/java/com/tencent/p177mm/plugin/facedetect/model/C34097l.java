package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.model.l */
public final class C34097l {
    /* renamed from: vm */
    public static int m55892vm(int i) {
        AppMethodBeat.m2504i(249);
        if (i < 90000 && i != 0) {
            C4990ab.m7416i("MicroMsg.FaceJSAPITranslateCenter", "hy: server error. not translate");
            AppMethodBeat.m2505o(249);
            return i;
        } else if (i > 90099) {
            C4990ab.m7416i("MicroMsg.FaceJSAPITranslateCenter", "hy: already translated");
            AppMethodBeat.m2505o(249);
            return i;
        } else {
            switch (i) {
                case 0:
                    AppMethodBeat.m2505o(249);
                    return 0;
                case 90001:
                    AppMethodBeat.m2505o(249);
                    return 90109;
                case 90002:
                case 90003:
                case 90004:
                case 90005:
                case 90006:
                case 90024:
                case 90025:
                    AppMethodBeat.m2505o(249);
                    return 90100;
                case 90008:
                case 90009:
                case 90010:
                    AppMethodBeat.m2505o(249);
                    return 90101;
                case 90011:
                case 90013:
                    AppMethodBeat.m2505o(249);
                    return 90102;
                case 90015:
                    AppMethodBeat.m2505o(249);
                    return 90104;
                case 90016:
                    AppMethodBeat.m2505o(249);
                    return 90106;
                case 90017:
                    AppMethodBeat.m2505o(249);
                    return 90107;
                case 90019:
                case 90020:
                case 90021:
                    AppMethodBeat.m2505o(249);
                    return 90103;
                case 90022:
                    AppMethodBeat.m2505o(249);
                    return 90105;
                case 90023:
                    AppMethodBeat.m2505o(249);
                    return 90108;
                default:
                    AppMethodBeat.m2505o(249);
                    return 90199;
            }
        }
    }
}
