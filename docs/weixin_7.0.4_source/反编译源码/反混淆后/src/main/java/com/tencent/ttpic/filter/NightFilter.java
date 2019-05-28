package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public class NightFilter extends BaseFilter {
    private static final String TAG = NightFilter.class.getSimpleName();
    private NightRGBStretchImpFilter adjustFilter = null;
    float strenth = 0.5f;

    static {
        AppMethodBeat.m2504i(82677);
        AppMethodBeat.m2505o(82677);
    }

    public NightFilter() {
        super(GLSLRender.bJB);
    }

    public void setAdjustParam(float f) {
        AppMethodBeat.m2504i(82674);
        this.strenth = f;
        if (this.adjustFilter != null) {
            this.adjustFilter.addParam(new C0933f("param", this.strenth));
        }
        AppMethodBeat.m2505o(82674);
    }

    public boolean isAdjustFilter() {
        return true;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82675);
        this.glsl_programID = GLSLRender.bJB;
        this.adjustFilter = new NightRGBStretchImpFilter();
        this.adjustFilter.addParam(new C0933f("param", this.strenth));
        if (this.strenth >= 0.5f) {
            this.adjustFilter.addParam(new C0933f(WMElement.ANIMATE_TYPE_SCALE, 2.0f));
        } else {
            this.adjustFilter.addParam(new C0933f(WMElement.ANIMATE_TYPE_SCALE, 1.0f));
        }
        setNextFilter(this.adjustFilter, new int[]{this.srcTextureIndex + 1});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82675);
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(82676);
        this.adjustFilter = null;
        super.ClearGLSL();
        AppMethodBeat.m2505o(82676);
    }
}
