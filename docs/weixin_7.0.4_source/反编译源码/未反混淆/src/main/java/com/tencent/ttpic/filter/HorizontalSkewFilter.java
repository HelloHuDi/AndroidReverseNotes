package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class HorizontalSkewFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"adjust"};

    enum PARAM_KEY {
        ADJUST("adjust");
        
        public final String value;

        static {
            AppMethodBeat.o(82604);
        }

        private PARAM_KEY(String str) {
            this.value = str;
        }
    }

    public HorizontalSkewFilter() {
        super(PROGRAM_TYPE.SHAKA_HORIZONTAL_SKEW);
    }

    public void initParams() {
        AppMethodBeat.i(82605);
        setParams(1.0f);
        AppMethodBeat.o(82605);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f) {
        AppMethodBeat.i(82606);
        addParam(new f("adjust", f));
        AppMethodBeat.o(82606);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.i(82607);
        setParams(((Float) map.get("adjust")).floatValue());
        AppMethodBeat.o(82607);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
