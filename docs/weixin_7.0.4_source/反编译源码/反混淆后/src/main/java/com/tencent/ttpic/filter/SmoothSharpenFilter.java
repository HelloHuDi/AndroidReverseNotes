package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothSharpenFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader.dat");
    public static final String FRAGMENT_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader2.dat");

    static {
        AppMethodBeat.m2504i(82938);
        AppMethodBeat.m2505o(82938);
    }

    public SmoothSharpenFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82933);
        initParams();
        AppMethodBeat.m2505o(82933);
    }

    public SmoothSharpenFilter(int i) {
        super(FRAGMENT_SHADER2);
        AppMethodBeat.m2504i(82934);
        initParams();
        AppMethodBeat.m2505o(82934);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82935);
        addParam(new C0933f("sharpFactor", 0.12f));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(82935);
    }

    public void updateTexture(int i) {
        AppMethodBeat.m2504i(82936);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82936);
    }

    public void updateFactor(float f) {
        AppMethodBeat.m2504i(82937);
        addParam(new C0933f("sharpFactor", 0.12f * f));
        AppMethodBeat.m2505o(82937);
    }
}
