package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C41943m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.q */
public final class C46510q {
    /* renamed from: fT */
    public static C14979e m87801fT(Context context) {
        AppMethodBeat.m2504i(70463);
        C14979e videoSightView;
        if (C5046bo.m7532bc(C1427q.etn.esB, "").equals("surface")) {
            C4990ab.m7416i("MicroMsg.VideoViewFactory", "match full type surface");
            VideoSurfaceView videoSurfaceView = new VideoSurfaceView(context);
            AppMethodBeat.m2505o(70463);
            return videoSurfaceView;
        } else if (C41943m.m74078Mx()) {
            C4990ab.m7416i("MicroMsg.VideoViewFactory", "IS MTK platform");
            videoSightView = new VideoSightView(context);
            AppMethodBeat.m2505o(70463);
            return videoSightView;
        } else {
            C4990ab.m7416i("MicroMsg.VideoViewFactory", "default settings, use sightview");
            videoSightView = new VideoSightView(context);
            AppMethodBeat.m2505o(70463);
            return videoSightView;
        }
    }
}
