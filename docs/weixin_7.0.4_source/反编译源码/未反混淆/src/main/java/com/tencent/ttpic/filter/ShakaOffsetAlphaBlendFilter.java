package com.tencent.ttpic.filter;

import com.tencent.filter.m.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaOffsetAlphaBlendFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"translateXup", "translateYup", "translateXdown", "translateYdown"};

    public ShakaOffsetAlphaBlendFilter() {
        super(PROGRAM_TYPE.SHAKA_OFFSET_ALPHA_BLEND);
    }

    private void setParams(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(82846);
        addParam(new b("offset1", f, f2));
        addParam(new b("offset2", f3, f4));
        AppMethodBeat.o(82846);
    }

    public void initParams() {
        AppMethodBeat.i(82847);
        setParams(0.0f, 0.0f, 0.0f, 0.0f);
        AppMethodBeat.o(82847);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.i(82848);
        setParams(((Float) map.get("translateXup")).floatValue(), ((Float) map.get("translateYup")).floatValue(), ((Float) map.get("translateXdown")).floatValue(), ((Float) map.get("translateYdown")).floatValue());
        AppMethodBeat.o(82848);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
