package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C0933f;
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
        AppMethodBeat.m2504i(82837);
        setParams(0.0f, 0.0f);
        AppMethodBeat.m2505o(82837);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f, float f2) {
        AppMethodBeat.m2504i(82838);
        addParam(new C0933f(VideoMaterialUtil.CRAZYFACE_X, f));
        addParam(new C0933f(VideoMaterialUtil.CRAZYFACE_Y, f2));
        AppMethodBeat.m2505o(82838);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.m2504i(82839);
        setParams(((Float) map.get("translateX")).floatValue(), ((Float) map.get("translateY")).floatValue());
        AppMethodBeat.m2505o(82839);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
