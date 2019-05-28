package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.VideoFilterBase;

public class VideoFrameUtil {
    public static C41672h renderProcessBySwitchFbo(int i, int i2, int i3, VideoFilterBase videoFilterBase, C41672h c41672h, C41672h c41672h2) {
        C41672h c41672h3;
        AppMethodBeat.m2504i(84038);
        if (c41672h.texture[0] == i) {
            c41672h3 = c41672h2;
        } else {
            c41672h3 = c41672h;
        }
        videoFilterBase.RenderProcess(i, i2, i3, -1, 0.0d, c41672h3);
        AppMethodBeat.m2505o(84038);
        return c41672h3;
    }

    public static C41672h renderProcessByCopy(int i, int i2, int i3, VideoFilterBase videoFilterBase, BaseFilter baseFilter, C41672h c41672h, C41672h c41672h2) {
        C41672h c41672h3;
        AppMethodBeat.m2504i(84039);
        if (c41672h.texture[0] == i) {
            c41672h3 = c41672h2;
        } else {
            c41672h3 = c41672h;
        }
        baseFilter.RenderProcess(i, i2, i3, -1, 0.0d, c41672h3);
        videoFilterBase.OnDrawFrameGLSL();
        videoFilterBase.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(84039);
        return c41672h3;
    }
}
