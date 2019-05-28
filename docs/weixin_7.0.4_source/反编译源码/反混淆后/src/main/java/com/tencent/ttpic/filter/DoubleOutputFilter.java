package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class DoubleOutputFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");

    static {
        AppMethodBeat.m2504i(82158);
        AppMethodBeat.m2505o(82158);
    }

    public DoubleOutputFilter() {
        super(FRAGMENT_SHADER);
    }
}
