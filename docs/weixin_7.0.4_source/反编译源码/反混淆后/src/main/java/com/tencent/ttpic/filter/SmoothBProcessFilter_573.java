package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothBProcessFilter_573 extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessFragmentShader2_573.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessVertexShader.dat");
    private float blurAlpha = 0.5f;

    static {
        AppMethodBeat.m2504i(82904);
        AppMethodBeat.m2505o(82904);
    }

    public SmoothBProcessFilter_573() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82900);
        initParams();
        AppMethodBeat.m2505o(82900);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82901);
        addParam(new C0933f("blurAlpha", this.blurAlpha));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        addParam(new C25627n("inputImageTexture3", 0, 33987));
        AppMethodBeat.m2505o(82901);
    }

    public void updateTextures(int i, int i2) {
        AppMethodBeat.m2504i(82902);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        addParam(new C25627n("inputImageTexture3", i2, 33987));
        AppMethodBeat.m2505o(82902);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.m2504i(82903);
        this.blurAlpha = f;
        addParam(new C0933f("blurAlpha", f));
        AppMethodBeat.m2505o(82903);
    }

    public float getBlurAlpha() {
        return this.blurAlpha;
    }
}
