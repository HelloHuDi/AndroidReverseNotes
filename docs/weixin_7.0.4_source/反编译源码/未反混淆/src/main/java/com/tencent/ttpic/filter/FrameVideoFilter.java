package com.tencent.ttpic.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class FrameVideoFilter extends FrameBaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameVideoFragmentShader.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LeftRightVertexShader.dat");

    static {
        AppMethodBeat.i(82550);
        AppMethodBeat.o(82550);
    }

    public FrameVideoFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82549);
        super.initAttribParams();
        setTexCords(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        AppMethodBeat.o(82549);
    }
}
