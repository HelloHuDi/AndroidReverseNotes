package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.storage.ac.a;

public final class k {
    private static k owl = new k();
    public SightParams owm;

    static {
        AppMethodBeat.i(76593);
        AppMethodBeat.o(76593);
    }

    public static k bPR() {
        return owl;
    }

    public final SightParams bPS() {
        return this.owm;
    }

    public static d p(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76591);
        d dVar = null;
        switch (j.ouz.etz) {
            case 1:
                dVar = new l(videoTransPara);
                break;
            case 2:
                dVar = new n(videoTransPara);
                break;
        }
        AppMethodBeat.o(76591);
        return dVar;
    }

    public static int bPT() {
        return j.ouz.videoBitrate;
    }

    public static int bPU() {
        return j.ouz.fay;
    }

    public static boolean isDebug() {
        AppMethodBeat.i(76592);
        if (CaptureMMProxy.getInstance().getInt(a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, 0) == 1) {
            AppMethodBeat.o(76592);
            return true;
        }
        AppMethodBeat.o(76592);
        return false;
    }

    public static String bPV() {
        switch (j.ouz.etz) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
