package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class ClarityMaskFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ClarityMaskFragmentShader2.dat");
    public static final String VERTEX_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ClarityMaskVertexShader2.dat");

    static {
        AppMethodBeat.m2504i(82113);
        AppMethodBeat.m2505o(82113);
    }

    public ClarityMaskFilter() {
        super(VERTEX_SHADER2, FRAGMENT_SHADER2);
        AppMethodBeat.m2504i(82109);
        initParams();
        AppMethodBeat.m2505o(82109);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82110);
        addParam(new C0933f("sharpFactor", 0.12f));
        addParam(new C0933f("texelWidthOffset", 0.0013888889f));
        addParam(new C0933f("texelHeightOffset", 7.8125E-4f));
        AppMethodBeat.m2505o(82110);
    }

    public void updateSize(int i, int i2) {
        AppMethodBeat.m2504i(82111);
        if (i > 0 && i2 > 0) {
            addParam(new C0933f("texelWidthOffset", 1.0f / ((float) i)));
            addParam(new C0933f("texelHeightOffset", 1.0f / ((float) i2)));
        }
        AppMethodBeat.m2505o(82111);
    }

    public void updateFactor(float f) {
        AppMethodBeat.m2504i(82112);
        addParam(new C0933f("sharpFactor", 0.12f * f));
        AppMethodBeat.m2505o(82112);
    }
}
