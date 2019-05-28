package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;
import com.tencent.view.C44569b;
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

    /* renamed from: com.tencent.filter.art.BokehFilter$a */
    public static class C8784a extends BaseFilter {
        int bNh = 1;
        float bNj = ((float) (1.0d / Math.exp(0.0d)));
        float bNk = 0.0f;
        int bNl = 1;
        int paramTEXTRUEID = -2000;
        int radius = 8;

        public C8784a(int i, float f, float f2, int i2, int i3) {
            super(GLSLRender.bJB);
            AppMethodBeat.m2504i(86284);
            this.radius = i;
            this.bNj = f;
            this.bNk = f2;
            this.bNh = i2;
            this.bNl = i3;
            if (this.bNl > 0) {
                addParam(new C0936o("inputImageTexture2", C8784a.m15602fN(this.bNh), 33986));
                addParam(new C0933f("lumi_threshold", this.bNk));
                addParam(new C0933f("lumi_weight", this.bNj));
                if (this.bNl == 1) {
                    this.glsl_programID = GLSLRender.bKc;
                    addParam(new C0935i("r", this.radius));
                    AppMethodBeat.m2505o(86284);
                    return;
                }
                this.glsl_programID = GLSLRender.bKo;
                AppMethodBeat.m2505o(86284);
                return;
            }
            this.paramTEXTRUEID = C41106g.dSO();
            AppMethodBeat.m2505o(86284);
        }

        /* renamed from: fN */
        private static String m15602fN(int i) {
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
            AppMethodBeat.m2504i(86285);
            if (this.bNl == 0) {
                Bitmap vt = C44569b.m80951vt(C8784a.m15602fN(this.bNh));
                QImage aL = C41106g.m71542aL(i, i2, i3);
                QImage BindBitmap = QImage.BindBitmap(vt);
                BokehFilter.nativeBokehProcess(aL, BindBitmap, this.radius, this.bNj, this.bNk);
                BindBitmap.UnBindBitmap(vt);
                vt.recycle();
                GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
                aL.Dispose();
            }
            AppMethodBeat.m2505o(86285);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.m2504i(86286);
            boolean renderTexture;
            if (this.paramTEXTRUEID != -2000) {
                renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
                AppMethodBeat.m2505o(86286);
                return renderTexture;
            }
            renderTexture = super.renderTexture(i, i2, i3);
            AppMethodBeat.m2505o(86286);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.m2504i(86287);
            if (this.paramTEXTRUEID != -2000) {
                C41106g.m71538Sk(this.paramTEXTRUEID);
                this.paramTEXTRUEID = -2000;
            }
            super.ClearGLSL();
            AppMethodBeat.m2505o(86287);
        }
    }

    public static native int nativeBokehProcess(QImage qImage, QImage qImage2, int i, float f, float f2);

    public BokehFilter() {
        super(GLSLRender.bKc);
        AppMethodBeat.m2504i(86288);
        AppMethodBeat.m2505o(86288);
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(86289);
        super.ClearGLSL();
        this.bNf = null;
        AppMethodBeat.m2505o(86289);
    }

    public void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86290);
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
        AppMethodBeat.m2505o(86290);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86291);
        this.glsl_programID = GLSLRender.bJB;
        this.scaleFact = Math.min(960.0f / Math.max(f, f2), 1.0f) * this.bNi;
        C8784a c8784a = new C8784a(this.radius, this.bNj, this.bNk, this.bNh, 1);
        c8784a.setScaleFact(this.scaleFact);
        setNextFilter(c8784a, null);
        c8784a.setNextFilter(new BaseFilter(GLSLRender.bJB), null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKn);
        if (this.bNf != null) {
            baseFilter.addParam(new C25628k("inputImageTexture3", this.bNf, 33987, false));
        }
        c8784a.setNextFilter(baseFilter, new int[]{-1});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86291);
    }
}
