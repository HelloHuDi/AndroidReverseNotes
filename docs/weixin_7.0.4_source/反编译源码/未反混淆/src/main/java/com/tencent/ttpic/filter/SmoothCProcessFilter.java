package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.c;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothCProcessFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessFragmentShader.dat");
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessVertexShader.dat");

    static {
        AppMethodBeat.i(82928);
        AppMethodBeat.o(82928);
    }

    public SmoothCProcessFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82924);
        initParams();
        AppMethodBeat.o(82924);
    }

    private void initParams() {
        AppMethodBeat.i(82925);
        addParam(new f("blurOpacity", 0.46f));
        addParam(new c("inputTextureSize", new float[]{0.0f, 0.0f}));
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new f("factor1", 2.782f));
        addParam(new f("factor2", 1.131f));
        addParam(new f("factor3", 1.158f));
        addParam(new f("factor4", 2.901f));
        addParam(new f("factor5", 0.979f));
        addParam(new f("factor6", 0.639f));
        addParam(new f("factor7", 0.963f));
        addParam(new f("filterOpacity", 0.6f));
        AppMethodBeat.o(82925);
    }

    public void setTexture2(h hVar) {
        AppMethodBeat.i(82926);
        addParam(new n("inputImageTexture2", hVar.texture[0], 33986));
        addParam(new c("inputTextureSize", new float[]{(float) hVar.width, (float) hVar.height}));
        AppMethodBeat.o(82926);
    }

    public void updateSmoothOpacity(float f) {
        AppMethodBeat.i(82927);
        addParam(new f("blurOpacity", f));
        AppMethodBeat.o(82927);
    }
}
