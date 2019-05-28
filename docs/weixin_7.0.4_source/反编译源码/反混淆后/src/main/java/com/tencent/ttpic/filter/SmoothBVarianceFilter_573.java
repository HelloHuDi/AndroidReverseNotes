package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothBVarianceFilter_573 extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBVarianceFragmentShader2_573.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBVarianceVertexShader.dat");

    static {
        AppMethodBeat.m2504i(82913);
        AppMethodBeat.m2505o(82913);
    }

    public SmoothBVarianceFilter_573() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82910);
        initParams();
        AppMethodBeat.m2505o(82910);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82911);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(82911);
    }

    public void setTexture2(int i) {
        AppMethodBeat.m2504i(82912);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82912);
    }
}
