package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import com.tencent.view.g;
import java.util.Map;

public class BokehFilter extends BaseFilter {
    public static Bitmap[] bNe = new Bitmap[]{null, null, null, null, null, null};
    Bitmap bNf = null;
    float bNg = 400.0f;
    int bNh = 1;
    float bNi = 0.5f;
    float bNj = ((float) (1.0d / Math.exp(0.0d)));
    float bNk = 0.0f;
    int radius = 8;

    public static class a extends BaseFilter {
        int bNh = 1;
        float bNj = ((float) (1.0d / Math.exp(0.0d)));
        float bNk = 0.0f;
        int bNl = 1;
        int paramTEXTRUEID = -2000;
        int radius = 8;

        public a(int i, float f, float f2, int i2, int i3) {
            super(GLSLRender.bJB);
            AppMethodBeat.i(86284);
            this.radius = i;
            this.bNj = f;
            this.bNk = f2;
            this.bNh = i2;
            this.bNl = i3;
            if (this.bNl > 0) {
                addParam(new o("inputImageTexture2", fN(this.bNh), 33986));
                addParam(new f("lumi_threshold", this.bNk));
                addParam(new f("lumi_weight", this.bNj));
                if (this.bNl == 1) {
                    this.glsl_programID = GLSLRender.bKc;
                    addParam(new i("r", this.radius));
                    AppMethodBeat.o(86284);
                    return;
                }
                this.glsl_programID = GLSLRender.bKo;
                AppMethodBeat.o(86284);
                return;
            }
            this.paramTEXTRUEID = g.dSO();
            AppMethodBeat.o(86284);
        }

        private static String fN(int i) {
            switch (i) {
                case 1:
                    return "bokeh/circle.jpg";
                case 2:
                    return "bokeh/shape2.jpg";
                case 3:
                    return "bokeh/heart.jpg";
                default:
                    return "bokeh/shape1.jpg";
            }
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.i(86285);
            if (this.bNl == 0) {
                Bitmap vt = b.vt(fN(this.bNh));
                QImage aL = g.aL(i, i2, i3);
                QImage BindBitmap = QImage.BindBitmap(vt);
                BokehFilter.nativeBokehProcess(aL, BindBitmap, this.radius, this.bNj, this.bNk);
                BindBitmap.UnBindBitmap(vt);
                vt.recycle();
                GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
                aL.Dispose();
            }
            AppMethodBeat.o(86285);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.i(86286);
            boolean renderTexture;
            if (this.paramTEXTRUEID != -2000) {
                renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
                AppMethodBeat.o(86286);
                return renderTexture;
            }
            renderTexture = super.renderTexture(i, i2, i3);
            AppMethodBeat.o(86286);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.i(86287);
            if (this.paramTEXTRUEID != -2000) {
                g.Sk(this.paramTEXTRUEID);
                this.paramTEXTRUEID = -2000;
            }
            super.ClearGLSL();
            AppMethodBeat.o(86287);
        }
    }

    public static native int nativeBokehProcess(QImage qImage, QImage qImage2, int i, float f, float f2);

    public BokehFilter() {
        super(GLSLRender.bKc);
        AppMethodBeat.i(86288);
        AppMethodBeat.o(86288);
    }

    public void ClearGLSL() {
        AppMethodBeat.i(86289);
        super.ClearGLSL();
        this.bNf = null;
        AppMethodBeat.o(86289);
    }

    public void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86290);
        if (map.containsKey("inputradius")) {
            float floatValue = ((Float) map.get("input_radius")).floatValue();
            this.bNi = 1.0f - floatValue;
            this.radius = 5;
            if (((double) this.bNi) < 0.8d && this.bNi > 0.4f) {
                this.radius = 8;
            } else if (this.bNi <= 0.4f) {
                this.bNi = 0.4f;
                this.radius = (int) ((floatValue * 6.0f) + 8.0f);
            }
        }
        if (map.containsKey("maxwidth")) {
            this.bNg = ((Float) map.get("maxwidth")).floatValue();
        }
        if (map.containsKey("maskbmp")) {
            this.bNf = (Bitmap) map.get("maskbmp");
        }
        if (map.containsKey("bokehType")) {
            this.bNh = ((Integer) map.get("bokehType")).intValue() % 6;
        }
        if (map.containsKey("lumi_threshold")) {
            this.bNk = ((Float) map.get("lumi_threshold")).floatValue();
        }
        if (map.containsKey("lumi_weight")) {
            this.bNj = (float) (1.0d / Math.exp((double) ((Float) map.get("lumi_weight")).floatValue()));
        }
        AppMethodBeat.o(86290);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86291);
        this.glsl_programID = GLSLRender.bJB;
        this.scaleFact = Math.min(960.0f / Math.max(f, f2), 1.0f) * this.bNi;
        a aVar = new a(this.radius, this.bNj, this.bNk, this.bNh, 1);
        aVar.setScaleFact(this.scaleFact);
        setNextFilter(aVar, null);
        aVar.setNextFilter(new BaseFilter(GLSLRender.bJB), null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKn);
        if (this.bNf != null) {
            baseFilter.addParam(new k("inputImageTexture3", this.bNf, 33987, false));
        }
        aVar.setNextFilter(baseFilter, new int[]{-1});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86291);
    }
}
