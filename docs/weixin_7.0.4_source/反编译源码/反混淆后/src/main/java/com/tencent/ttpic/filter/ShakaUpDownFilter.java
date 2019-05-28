package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaUpDownFilter extends ShakaFilterBase {
    private static final String[] PARAM_KEYS = new String[]{"translateL", "translateR"};

    public ShakaUpDownFilter() {
        super(PROGRAM_TYPE.SHAKA_UP_DOWN);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82852);
        setParams(0.0f, 0.0f);
        AppMethodBeat.m2505o(82852);
    }

    /* Access modifiers changed, original: protected */
    public String[] getParamKeys() {
        return PARAM_KEYS;
    }

    private void setParams(float f, float f2) {
        AppMethodBeat.m2504i(82853);
        addParam(new C0933f("l", f));
        addParam(new C0933f("r", f2));
        AppMethodBeat.m2505o(82853);
    }

    public void setParameterDic(Map<String, Float> map) {
        AppMethodBeat.m2504i(82854);
        setParams(((Float) map.get("translateL")).floatValue(), ((Float) map.get("translateR")).floatValue());
        AppMethodBeat.m2505o(82854);
    }

    /* Access modifiers changed, original: protected */
    public float getDefaultParamValue() {
        return 0.0f;
    }
}
