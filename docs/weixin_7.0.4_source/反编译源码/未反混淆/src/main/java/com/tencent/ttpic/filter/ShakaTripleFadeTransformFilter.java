package com.tencent.ttpic.filter;

import com.tencent.filter.m.a;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaTripleFadeTransformFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"scaleUp", "scaleMid", "scaleDown", "alphaUp", "alphaMid", "alphaDown"};

    public ShakaTripleFadeTransformFilter() {
        super(PROGRAM_TYPE.SHAKA_TRIPLE_FACE_TRANSFORM);
    }

    public void initParams() {
        AppMethodBeat.i(82849);
        addParam(new i("layers", 1));
        addParam(new a("scales", new float[]{1.0f, 0.0f, 0.0f, 0.0f}));
        addParam(new a("alphaRatios", new float[]{1.0f, 0.0f, 0.0f, 0.0f}));
        AppMethodBeat.o(82849);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(int i, float[] fArr, float[] fArr2) {
        AppMethodBeat.i(82850);
        addParam(new i("layers", i));
        addParam(new a("scales", fArr));
        addParam(new a("alphaRatios", fArr2));
        AppMethodBeat.o(82850);
    }

    public void setParameterDic(Map<String, Float> map) {
        int i;
        AppMethodBeat.i(82851);
        float[] fArr = new float[]{((Float) map.get("scaleUp")).floatValue(), ((Float) map.get("scaleMid")).floatValue(), ((Float) map.get("scaleDown")).floatValue()};
        float[] fArr2 = new float[]{((Float) map.get("alphaUp")).floatValue(), ((Float) map.get("alphaMid")).floatValue(), ((Float) map.get("alphaDown")).floatValue()};
        float f = 0.0f;
        for (i = 0; i < 3; i++) {
            f += fArr2[i];
        }
        for (i = 0; i < 3; i++) {
            fArr2[i] = fArr2[i] / f;
        }
        setParams(3, fArr, fArr2);
        AppMethodBeat.o(82851);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 1.0f;
    }
}
