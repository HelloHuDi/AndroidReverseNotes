package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i extends BaseFilter {
    Bitmap bCr;
    private int type;

    public i() {
        super(GLSLRender.bJB);
        this.type = 0;
        this.bCr = null;
        this.type = 0;
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86369);
        if (map.containsKey("image")) {
            this.bCr = (Bitmap) map.get("image");
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.o(86369);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86370);
        if (this.bCr == null) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86370);
            return;
        }
        addParam(new k("inputImageTexture2", this.bCr, 33986, false));
        if (this.type == 0) {
            this.glsl_programID = GLSLRender.bKA;
            float floor = (float) Math.floor(((double) (f / ((float) this.bCr.getWidth()))) + 0.999999d);
            addParam(new f("height_scale", (float) Math.floor(((double) (f2 / ((float) this.bCr.getHeight()))) + 0.999999d)));
            addParam(new f("width_scale", floor));
        } else {
            float f3;
            this.glsl_vertextshaderID = GLSLRender.bMr;
            this.glsl_programID = GLSLRender.bKz;
            float height = ((float) this.bCr.getHeight()) / ((float) this.bCr.getWidth());
            if (this.type == 1) {
                this.glsl_vertextshaderID = GLSLRender.bMs;
                if (f2 > f * height) {
                    height = ((f2 - (height * f)) / 2.0f) / f2;
                    f3 = 0.0f;
                } else {
                    f3 = ((f - (f2 / height)) / 2.0f) / f;
                    height = 0.0f;
                }
            } else if (this.type == 2) {
                this.glsl_vertextshaderID = GLSLRender.bMt;
                if (f2 < f * height) {
                    height = (((f * height) - f2) / 2.0f) / (height * f);
                    f3 = 0.0f;
                } else {
                    f3 = (((f2 / height) - f) / 2.0f) / (f2 / height);
                    height = 0.0f;
                }
            } else {
                height = 0.0f;
                f3 = 0.0f;
            }
            addParam(new f("height_offset", height));
            addParam(new f("width_offset", f3));
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86370);
    }

    public final void ClearGLSL() {
        AppMethodBeat.i(86371);
        if (this.bCr != null) {
            this.bCr.recycle();
            this.bCr = null;
        }
        super.ClearGLSL();
        AppMethodBeat.o(86371);
    }
}
