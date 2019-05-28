package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaNineTileFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"xMin", "xMax", "yMin", "yMax"};

    public ShakaNineTileFilter() {
        super(PROGRAM_TYPE.SHAKA_NINE_TILE);
    }

    public void initParams() {
        AppMethodBeat.i(82843);
        setParams(0.0f, 0.0f, 0.0f, 0.0f);
        AppMethodBeat.o(82843);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(82844);
        addParam(new f("x_min", f));
        addParam(new f("x_max", f2));
        addParam(new f("y_min", f3));
        addParam(new f("y_max", f4));
        AppMethodBeat.o(82844);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.i(82845);
        setParams(((Float) map.get("xMin")).floatValue(), ((Float) map.get("xMax")).floatValue(), ((Float) map.get("yMin")).floatValue(), ((Float) map.get("yMax")).floatValue());
        AppMethodBeat.o(82845);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
