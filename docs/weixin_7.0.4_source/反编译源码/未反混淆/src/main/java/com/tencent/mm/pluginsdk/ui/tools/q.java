package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q {
    public static e fT(Context context) {
        AppMethodBeat.i(70463);
        e videoSightView;
        if (bo.bc(com.tencent.mm.compatible.e.q.etn.esB, "").equals("surface")) {
            ab.i("MicroMsg.VideoViewFactory", "match full type surface");
            VideoSurfaceView videoSurfaceView = new VideoSurfaceView(context);
            AppMethodBeat.o(70463);
            return videoSurfaceView;
        } else if (m.Mx()) {
            ab.i("MicroMsg.VideoViewFactory", "IS MTK platform");
            videoSightView = new VideoSightView(context);
            AppMethodBeat.o(70463);
            return videoSightView;
        } else {
            ab.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
            videoSightView = new VideoSightView(context);
            AppMethodBeat.o(70463);
            return videoSightView;
        }
    }
}
