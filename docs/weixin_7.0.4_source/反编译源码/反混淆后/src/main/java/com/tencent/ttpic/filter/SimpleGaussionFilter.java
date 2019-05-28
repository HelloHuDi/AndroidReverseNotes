package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleGaussionFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/GaussionBlurFragmentShader.dat");

    static {
        AppMethodBeat.m2504i(82861);
        AppMethodBeat.m2505o(82861);
    }

    public SimpleGaussionFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82858);
        initParams();
        AppMethodBeat.m2505o(82858);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82859);
        addParam(new C0933f("stepX", 0.0f));
        addParam(new C0933f("stepY", 0.0f));
        AppMethodBeat.m2505o(82859);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82860);
        addParam(new C0933f("stepX", 1.0f / ((float) i2)));
        addParam(new C0933f("stepY", 1.0f / ((float) i3)));
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(82860);
        return renderTexture;
    }
}
