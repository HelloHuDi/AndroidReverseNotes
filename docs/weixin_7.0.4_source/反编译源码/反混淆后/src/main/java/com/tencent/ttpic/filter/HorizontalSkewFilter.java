package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class HorizontalSkewFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"adjust"};

    enum PARAM_KEY {
        ADJUST("adjust");
        
        public final String value;

        static {
            AppMethodBeat.m2505o(82604);
        }

        private PARAM_KEY(String str) {
            this.value = str;
        }
    }

    public HorizontalSkewFilter() {
        super(PROGRAM_TYPE.SHAKA_HORIZONTAL_SKEW);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82605);
        setParams(1.0f);
        AppMethodBeat.m2505o(82605);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f) {
        AppMethodBeat.m2504i(82606);
        addParam(new C0933f("adjust", f));
        AppMethodBeat.m2505o(82606);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.m2504i(82607);
        setParams(((Float) map.get("adjust")).floatValue());
        AppMethodBeat.m2505o(82607);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
