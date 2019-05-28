package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.VideoFilterBase;

public class VideoFrameUtil {
    public static h renderProcessBySwitchFbo(int i, int i2, int i3, VideoFilterBase videoFilterBase, h hVar, h hVar2) {
        h hVar3;
        AppMethodBeat.i(84038);
        if (hVar.texture[0] == i) {
            hVar3 = hVar2;
        } else {
            hVar3 = hVar;
        }
        videoFilterBase.RenderProcess(i, i2, i3, -1, 0.0d, hVar3);
        AppMethodBeat.o(84038);
        return hVar3;
    }

    public static h renderProcessByCopy(int i, int i2, int i3, VideoFilterBase videoFilterBase, BaseFilter baseFilter, h hVar, h hVar2) {
        h hVar3;
        AppMethodBeat.i(84039);
        if (hVar.texture[0] == i) {
            hVar3 = hVar2;
        } else {
            hVar3 = hVar;
        }
        baseFilter.RenderProcess(i, i2, i3, -1, 0.0d, hVar3);
        videoFilterBase.OnDrawFrameGLSL();
        videoFilterBase.renderTexture(i, i2, i3);
        AppMethodBeat.o(84039);
        return hVar3;
    }
}
