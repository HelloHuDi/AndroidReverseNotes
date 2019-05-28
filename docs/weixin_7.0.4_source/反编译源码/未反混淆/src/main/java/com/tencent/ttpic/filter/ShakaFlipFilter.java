package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;

public class ShakaFlipFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"translateX", "translateY"};

    public ShakaFlipFilter() {
        super(PROGRAM_TYPE.SHAKA_FLIP);
    }

    public void initParams() {
        AppMethodBeat.i(82837);
        setParams(0.0f, 0.0f);
        AppMethodBeat.o(82837);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f, float f2) {
        AppMethodBeat.i(82838);
        addParam(new f(VideoMaterialUtil.CRAZYFACE_X, f));
        addParam(new f(VideoMaterialUtil.CRAZYFACE_Y, f2));
        AppMethodBeat.o(82838);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.i(82839);
        setParams(((Float) map.get("translateX")).floatValue(), ((Float) map.get("translateY")).floatValue());
        AppMethodBeat.o(82839);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
