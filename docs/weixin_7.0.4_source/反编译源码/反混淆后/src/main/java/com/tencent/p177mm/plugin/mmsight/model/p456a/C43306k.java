package com.tencent.p177mm.plugin.mmsight.model.p456a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.k */
public final class C43306k {
    private static C43306k owl = new C43306k();
    public SightParams owm;

    static {
        AppMethodBeat.m2504i(76593);
        AppMethodBeat.m2505o(76593);
    }

    public static C43306k bPR() {
        return owl;
    }

    public final SightParams bPS() {
        return this.owm;
    }

    /* renamed from: p */
    public static C43304d m77221p(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76591);
        C43304d c43304d = null;
        switch (C12563j.ouz.etz) {
            case 1:
                c43304d = new C44750l(videoTransPara);
                break;
            case 2:
                c43304d = new C12544n(videoTransPara);
                break;
        }
        AppMethodBeat.m2505o(76591);
        return c43304d;
    }

    public static int bPT() {
        return C12563j.ouz.videoBitrate;
    }

    public static int bPU() {
        return C12563j.ouz.fay;
    }

    public static boolean isDebug() {
        AppMethodBeat.m2504i(76592);
        if (CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, 0) == 1) {
            AppMethodBeat.m2505o(76592);
            return true;
        }
        AppMethodBeat.m2505o(76592);
        return false;
    }

    public static String bPV() {
        switch (C12563j.ouz.etz) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
