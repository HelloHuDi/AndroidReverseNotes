package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public class NightFilter extends BaseFilter {
    private static final String TAG = NightFilter.class.getSimpleName();
    private NightRGBStretchImpFilter adjustFilter = null;
    float strenth = 0.5f;

    static {
        AppMethodBeat.i(82677);
        AppMethodBeat.o(82677);
    }

    public NightFilter() {
        super(GLSLRender.bJB);
    }

    public void setAdjustParam(float f) {
        AppMethodBeat.i(82674);
        this.strenth = f;
        if (this.adjustFilter != null) {
            this.adjustFilter.addParam(new f("param", this.strenth));
        }
        AppMethodBeat.o(82674);
    }

    public boolean isAdjustFilter() {
        return true;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82675);
        this.glsl_programID = GLSLRender.bJB;
        this.adjustFilter = new NightRGBStretchImpFilter();
        this.adjustFilter.addParam(new f("param", this.strenth));
        if (this.strenth >= 0.5f) {
            this.adjustFilter.addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 2.0f));
        } else {
            this.adjustFilter.addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 1.0f));
        }
        setNextFilter(this.adjustFilter, new int[]{this.srcTextureIndex + 1});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82675);
    }

    public void ClearGLSL() {
        AppMethodBeat.i(82676);
        this.adjustFilter = null;
        super.ClearGLSL();
        AppMethodBeat.o(82676);
    }
}
