package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleGaussionFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/GaussionBlurFragmentShader.dat");

    static {
        AppMethodBeat.i(82861);
        AppMethodBeat.o(82861);
    }

    public SimpleGaussionFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82858);
        initParams();
        AppMethodBeat.o(82858);
    }

    private void initParams() {
        AppMethodBeat.i(82859);
        addParam(new f("stepX", 0.0f));
        addParam(new f("stepY", 0.0f));
        AppMethodBeat.o(82859);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82860);
        addParam(new f("stepX", 1.0f / ((float) i2)));
        addParam(new f("stepY", 1.0f / ((float) i3)));
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.o(82860);
        return renderTexture;
    }
}
