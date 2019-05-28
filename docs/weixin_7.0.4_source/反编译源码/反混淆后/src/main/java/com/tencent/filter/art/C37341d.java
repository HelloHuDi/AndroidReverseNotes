package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.art.d */
public final class C37341d extends BaseFilter {
    Bitmap bNC;
    int type;

    public C37341d() {
        super(GLSLRender.bJB);
        this.type = 0;
        this.bNC = null;
        this.type = 0;
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86300);
        if (map.containsKey("graybitmap")) {
            this.bNC = (Bitmap) map.get("graybitmap");
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.m2505o(86300);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        BaseFilter baseFilter;
        float f3 = 852.0f;
        float f4 = 640.0f;
        AppMethodBeat.m2504i(86301);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMu, GLSLRender.bLm);
        setNextFilter(baseFilter2, null);
        if (this.bNC == null) {
            BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bMv, GLSLRender.bLr);
            baseFilter2.setNextFilter(baseFilter3, null);
            if (GLES20.glGetString(7937).indexOf("PowerVR SGX 540") != -1) {
                baseFilter = new BaseFilter(GLSLRender.bLt);
            } else {
                baseFilter = new BaseFilter(GLSLRender.bLn);
            }
            baseFilter3.setNextFilter(baseFilter, new int[]{this.srcTextureIndex + 2});
            baseFilter2 = new BaseFilter(GLSLRender.bMw, GLSLRender.bLo);
            baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 3});
            baseFilter = new BaseFilter(GLSLRender.bLp);
            baseFilter.addParam(new C0936o("inputImageTexture2", "manga/manga.png", 33986));
            baseFilter.addParam(new C0933f("height_scale", f2 / 64.0f));
            baseFilter.addParam(new C0933f("width_scale", f / 64.0f));
            baseFilter2.setNextFilter(baseFilter, null);
        } else {
            baseFilter = new BaseFilter(GLSLRender.bLs);
            baseFilter.addParam(new C0936o("inputImageTexture3", "manga/manga.png", 33987));
            baseFilter.addParam(new C25628k("inputImageTexture2", this.bNC, 33986, false));
            baseFilter.addParam(new C0933f("par", 0.45f));
            baseFilter.addParam(new C0933f("height_scale", f2 / 64.0f));
            baseFilter.addParam(new C0933f("width_scale", f / 64.0f));
            baseFilter2.setNextFilter(baseFilter, null);
        }
        baseFilter2 = new BaseFilter(GLSLRender.bLq);
        baseFilter2.addParam(new C0933f("rx", 1.0f));
        baseFilter2.addParam(new C0933f("ry", 1.0f));
        baseFilter2.addParam(new C0933f("tx", 0.0f));
        baseFilter2.addParam(new C0933f("ty", 0.0f));
        baseFilter2.addParam(new C0935i("flag", this.type));
        float f5;
        float f6;
        if (f <= 640.0f || f2 <= 852.0f) {
            f5 = 640.0f / f;
            f6 = 852.0f / f2;
            if (f5 < f6) {
                f4 = f * f6;
            } else {
                f3 = f2 * f5;
            }
        } else {
            f5 = f / 640.0f;
            f6 = f2 / 852.0f;
            if (f5 < f6) {
                f3 = f2 / f5;
            } else {
                f4 = f / f6;
            }
        }
        baseFilter2.addParam(new C0933f("w", f4));
        baseFilter2.addParam(new C0933f("h", f3));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86301);
    }

    public final void ClearGLSL() {
        AppMethodBeat.m2504i(86302);
        if (this.bNC != null) {
            this.bNC.recycle();
            this.bNC = null;
        }
        super.ClearGLSL();
        AppMethodBeat.m2505o(86302);
    }
}
