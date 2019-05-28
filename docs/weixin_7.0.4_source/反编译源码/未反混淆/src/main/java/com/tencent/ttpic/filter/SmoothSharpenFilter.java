package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothSharpenFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader.dat");
    public static final String FRAGMENT_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader2.dat");

    static {
        AppMethodBeat.i(82938);
        AppMethodBeat.o(82938);
    }

    public SmoothSharpenFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82933);
        initParams();
        AppMethodBeat.o(82933);
    }

    public SmoothSharpenFilter(int i) {
        super(FRAGMENT_SHADER2);
        AppMethodBeat.i(82934);
        initParams();
        AppMethodBeat.o(82934);
    }

    public void initParams() {
        AppMethodBeat.i(82935);
        addParam(new f("sharpFactor", 0.12f));
        addParam(new n("inputImageTexture2", 0, 33986));
        AppMethodBeat.o(82935);
    }

    public void updateTexture(int i) {
        AppMethodBeat.i(82936);
        addParam(new n("inputImageTexture2", i, 33986));
        AppMethodBeat.o(82936);
    }

    public void updateFactor(float f) {
        AppMethodBeat.i(82937);
        addParam(new f("sharpFactor", 0.12f * f));
        AppMethodBeat.o(82937);
    }
}
