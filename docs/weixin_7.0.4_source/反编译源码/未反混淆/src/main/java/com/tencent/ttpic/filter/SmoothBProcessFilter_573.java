package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothBProcessFilter_573 extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessFragmentShader2_573.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessVertexShader.dat");
    private float blurAlpha = 0.5f;

    static {
        AppMethodBeat.i(82904);
        AppMethodBeat.o(82904);
    }

    public SmoothBProcessFilter_573() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82900);
        initParams();
        AppMethodBeat.o(82900);
    }

    public void initParams() {
        AppMethodBeat.i(82901);
        addParam(new f("blurAlpha", this.blurAlpha));
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new n("inputImageTexture3", 0, 33987));
        AppMethodBeat.o(82901);
    }

    public void updateTextures(int i, int i2) {
        AppMethodBeat.i(82902);
        addParam(new n("inputImageTexture2", i, 33986));
        addParam(new n("inputImageTexture3", i2, 33987));
        AppMethodBeat.o(82902);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.i(82903);
        this.blurAlpha = f;
        addParam(new f("blurAlpha", f));
        AppMethodBeat.o(82903);
    }

    public float getBlurAlpha() {
        return this.blurAlpha;
    }
}
