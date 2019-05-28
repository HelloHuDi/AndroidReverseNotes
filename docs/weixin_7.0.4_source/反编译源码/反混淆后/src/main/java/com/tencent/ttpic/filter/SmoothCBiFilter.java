package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothCBiFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCBiFragmentShader.dat");
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCBiVertexShader.dat");

    static {
        AppMethodBeat.m2504i(82917);
        AppMethodBeat.m2505o(82917);
    }

    public SmoothCBiFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82914);
        initParams();
        AppMethodBeat.m2505o(82914);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82915);
        addParam(new C0933f("texelWidthOffset", 0.0f));
        addParam(new C0933f("texelHeightOffset", 0.0f));
        addParam(new C0933f("distanceNormalizationFactor", 4.0f));
        AppMethodBeat.m2505o(82915);
    }

    public void updateSize(float f, float f2) {
        AppMethodBeat.m2504i(82916);
        addParam(new C0933f("texelWidthOffset", 4.0f / f));
        addParam(new C0933f("texelHeightOffset", 4.0f / f2));
        AppMethodBeat.m2505o(82916);
    }
}
