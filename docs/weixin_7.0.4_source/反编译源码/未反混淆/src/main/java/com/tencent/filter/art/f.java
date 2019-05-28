package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.oscarcamera.particlesystem.AttributeConst;
import java.util.Map;

public final class f extends BaseFilter {
    private float bNE;
    private int type;

    public f() {
        super(GLSLRender.bJB);
        this.type = 0;
        this.bNE = 1.0f;
        this.type = 0;
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86311);
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        if (map.containsKey("detail")) {
            this.bNE = ((Float) map.get("detail")).floatValue();
        }
        AppMethodBeat.o(86311);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86312);
        ClearGLSL();
        if (z) {
            this.glsl_programID = GLSLRender.bJB;
            setNextFilter(null, null);
        } else {
            float[] fArr;
            float[] fArr2;
            float[] fArr3;
            this.glsl_programID = GLSLRender.bLb;
            BaseFilter baseFilter = new BaseFilter(GLSLRender.bLa);
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLc);
            baseFilter.setNextFilter(baseFilter2, null);
            baseFilter = new BaseFilter(GLSLRender.bKV);
            baseFilter.addParam(new com.tencent.filter.m.f("threshold", 0.0f));
            baseFilter2.setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bLg);
            baseFilter.setNextFilter(baseFilter2, null);
            baseFilter = new BaseFilter(GLSLRender.bLh);
            baseFilter.addParam(new com.tencent.filter.m.f("inv_2sigma2", 127.00195f));
            baseFilter.addParam(new com.tencent.filter.m.f("inv_sigma_root_2pi", 8.0E-4f));
            baseFilter.addParam(new com.tencent.filter.m.f("edge_factor", this.bNE));
            baseFilter2.setNextFilter(baseFilter, new int[]{2});
            baseFilter2 = new BaseFilter(GLSLRender.bLi);
            baseFilter2.addParam(new com.tencent.filter.m.f("par", 0.35f));
            baseFilter2.addParam(new com.tencent.filter.m.f("par_b", 0.2f));
            if (this.type == 0) {
                fArr = new float[]{0.8666667f, 0.84705883f, 0.6666667f, 1.0f};
                fArr2 = new float[]{0.87058824f, 0.30980393f, 0.16470589f, 1.0f};
                fArr3 = new float[]{0.20392157f, 0.40784314f, 0.40784314f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{1.0f, 1.0f, 1.0f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            if (this.type == 1) {
                fArr = new float[]{0.8627451f, 0.88235295f, 0.7921569f, 1.0f};
                fArr2 = new float[]{0.827451f, 0.6901961f, 0.23529412f, 1.0f};
                fArr3 = new float[]{0.44705883f, 0.40784314f, 0.31764707f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{0.8117647f, 0.9647059f, 0.9607843f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            if (this.type == 2) {
                fArr = new float[]{0.88235295f, 0.68235296f, 0.73333335f, 1.0f};
                fArr2 = new float[]{0.6313726f, 0.52156866f, 0.6901961f, 1.0f};
                fArr3 = new float[]{0.39607844f, 0.32941177f, 0.49803922f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{0.7411765f, 0.8627451f, 0.827451f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            if (this.type == 3) {
                fArr = new float[]{0.9882353f, 0.99607843f, 0.88235295f, 1.0f};
                fArr2 = new float[]{0.85490197f, 0.7372549f, 0.4392157f, 1.0f};
                fArr3 = new float[]{0.654902f, 0.45882353f, 0.47843137f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{0.9882353f, 0.99607843f, 0.88235295f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            if (this.type == 4) {
                fArr = new float[]{1.0f, 0.9529412f, 0.78431374f, 1.0f};
                fArr2 = new float[]{0.8f, 0.84313726f, 0.5372549f, 1.0f};
                fArr3 = new float[]{0.0f, 0.3254902f, 0.3529412f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{1.0f, 0.9529412f, 0.78431374f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            if (this.type == 5) {
                fArr = new float[]{1.0f, 0.9137255f, 0.6862745f, 1.0f};
                fArr2 = new float[]{0.43529412f, 0.85490197f, 0.8901961f, 1.0f};
                fArr3 = new float[]{0.9647059f, 0.36078432f, 0.53333336f, 1.0f};
                baseFilter2.addParam(new g(AttributeConst.A, new float[]{1.0f, 0.9137255f, 0.6862745f, 1.0f}));
                baseFilter2.addParam(new g(AttributeConst.B, fArr));
                baseFilter2.addParam(new g("colorC", fArr2));
                baseFilter2.addParam(new g("colorD", fArr3));
            }
            baseFilter.setNextFilter(baseFilter2, new int[]{4});
            if (GLES20.glGetString(7937).indexOf("NVIDIA Tegra") != -1) {
                baseFilter = new BaseFilter(GLSLRender.bLk);
            } else {
                baseFilter = new BaseFilter(GLSLRender.bLj);
                baseFilter.addParam(new i("radius", 2));
            }
            baseFilter.addParam(new com.tencent.filter.m.f("inv_2sigma", 4.4f));
            baseFilter2.setNextFilter(baseFilter, new int[]{4});
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86312);
    }
}
