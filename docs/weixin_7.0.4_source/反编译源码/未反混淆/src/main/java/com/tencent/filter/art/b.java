package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends BaseFilter {
    int type;

    public b(int i) {
        super(GLSLRender.bJB);
        this.type = i;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86292);
        ClearGLSL();
        if (z) {
            this.glsl_programID = GLSLRender.bJB;
            setNextFilter(null, null);
        } else {
            this.glsl_programID = GLSLRender.bLb;
            BaseFilter baseFilter = new BaseFilter(GLSLRender.bLa);
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLc);
            baseFilter.setNextFilter(baseFilter2, null);
            baseFilter = new BaseFilter(GLSLRender.bKV);
            baseFilter.addParam(new f("threshold", 0.0f));
            baseFilter2.setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bLf);
            baseFilter.setNextFilter(baseFilter2, null);
            baseFilter = new BaseFilter(GLSLRender.bKW);
            baseFilter.addParam(new f("inv_2sigma2", 127.00195f));
            baseFilter.addParam(new f("inv_sigma_root_2pi", 8.0E-4f));
            baseFilter2.setNextFilter(baseFilter, new int[]{2});
            baseFilter2 = new BaseFilter(GLSLRender.bKZ);
            baseFilter2.addParam(new f("par", 0.15f));
            baseFilter.setNextFilter(baseFilter2, new int[]{4});
            baseFilter = new BaseFilter(GLSLRender.bKY);
            baseFilter.addParam(new f("par", 0.35f));
            baseFilter.addParam(new f("par_b", 0.2f));
            baseFilter2.setNextFilter(baseFilter, new int[]{4, 5});
            baseFilter2 = new BaseFilter(GLSLRender.bKX);
            baseFilter2.addParam(new f("inv_2sigma", 12.0f));
            baseFilter.setNextFilter(baseFilter2, new int[]{4});
            if (this.type == 1) {
                baseFilter = new BaseFilter(GLSLRender.bKU);
                baseFilter.addParam(new f("inv_2sigma2", 144.5f));
                baseFilter.addParam(new f("inv_sigma_root_2pi", 0.02f));
                baseFilter2.setNextFilter(baseFilter, new int[]{5, 4});
                baseFilter2 = new BaseFilter(GLSLRender.bKT);
                baseFilter2.addParam(new f("inv_2sigma2", 144.5f));
                baseFilter2.addParam(new f("inv_sigma_root_2pi", 0.02f));
                baseFilter.setNextFilter(baseFilter2, new int[]{4});
                baseFilter2.setNextFilter(new BaseFilter(GLSLRender.bLd), new int[]{8});
            } else if (this.type == 2) {
                baseFilter = new BaseFilter(GLSLRender.bKU);
                baseFilter.addParam(new f("inv_2sigma2", 144.5f));
                baseFilter.addParam(new f("inv_sigma_root_2pi", 0.02f));
                baseFilter2.setNextFilter(baseFilter, new int[]{5, 4});
                baseFilter2 = new BaseFilter(GLSLRender.bKT);
                baseFilter2.addParam(new f("inv_2sigma2", 144.5f));
                baseFilter2.addParam(new f("inv_sigma_root_2pi", 0.02f));
                baseFilter.setNextFilter(baseFilter2, new int[]{4});
                baseFilter2.setNextFilter(new BaseFilter(GLSLRender.bLe), new int[]{8});
            }
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86292);
    }
}
