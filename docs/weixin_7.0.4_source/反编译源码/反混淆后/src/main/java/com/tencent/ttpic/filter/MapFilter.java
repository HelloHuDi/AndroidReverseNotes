package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C8786h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class MapFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MapFragmentShader.dat");

    static {
        AppMethodBeat.m2504i(82660);
        AppMethodBeat.m2505o(82660);
    }

    public MapFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82658);
        initParam();
        AppMethodBeat.m2505o(82658);
    }

    public void initParam() {
        AppMethodBeat.m2504i(82659);
        addParam(new C8786h("map"));
        AppMethodBeat.m2505o(82659);
    }
}
