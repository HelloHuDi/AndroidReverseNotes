package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C25624m.C25632c;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothCProcessFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessFragmentShader.dat");
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessVertexShader.dat");

    static {
        AppMethodBeat.m2504i(82928);
        AppMethodBeat.m2505o(82928);
    }

    public SmoothCProcessFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82924);
        initParams();
        AppMethodBeat.m2505o(82924);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82925);
        addParam(new C0933f("blurOpacity", 0.46f));
        addParam(new C25632c("inputTextureSize", new float[]{0.0f, 0.0f}));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        addParam(new C0933f("factor1", 2.782f));
        addParam(new C0933f("factor2", 1.131f));
        addParam(new C0933f("factor3", 1.158f));
        addParam(new C0933f("factor4", 2.901f));
        addParam(new C0933f("factor5", 0.979f));
        addParam(new C0933f("factor6", 0.639f));
        addParam(new C0933f("factor7", 0.963f));
        addParam(new C0933f("filterOpacity", 0.6f));
        AppMethodBeat.m2505o(82925);
    }

    public void setTexture2(C41672h c41672h) {
        AppMethodBeat.m2504i(82926);
        addParam(new C25627n("inputImageTexture2", c41672h.texture[0], 33986));
        addParam(new C25632c("inputTextureSize", new float[]{(float) c41672h.width, (float) c41672h.height}));
        AppMethodBeat.m2505o(82926);
    }

    public void updateSmoothOpacity(float f) {
        AppMethodBeat.m2504i(82927);
        addParam(new C0933f("blurOpacity", f));
        AppMethodBeat.m2505o(82927);
    }
}
