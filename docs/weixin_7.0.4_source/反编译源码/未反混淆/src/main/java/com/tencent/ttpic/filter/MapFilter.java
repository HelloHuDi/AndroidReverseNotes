package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class MapFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MapFragmentShader.dat");

    static {
        AppMethodBeat.i(82660);
        AppMethodBeat.o(82660);
    }

    public MapFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82658);
        initParam();
        AppMethodBeat.o(82658);
    }

    public void initParam() {
        AppMethodBeat.i(82659);
        addParam(new h("map"));
        AppMethodBeat.o(82659);
    }
}
