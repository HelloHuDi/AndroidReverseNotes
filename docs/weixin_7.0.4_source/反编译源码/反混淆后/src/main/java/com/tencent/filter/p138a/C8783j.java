package com.tencent.filter.p138a;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.a.j */
public final class C8783j extends BaseFilter {
    private static String bNN = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float debug;\n uniform float inner;\n uniform float outer;\n uniform vec2 ellipse;\n uniform vec2 center;\n uniform vec3 line1;\n uniform vec3 line2;\n void main() {\n     vec4 original = texture2D(inputImageTexture2, textureCoordinate);\n     float fx = (textureCoordinate.x - center.x);\n     float fy = (textureCoordinate.y - center.y);\n     float dist = sqrt(fx * fx * ellipse.x + fy * fy * ellipse.y);\n     if (dist < inner) {\n         gl_FragColor = original;\n     } else {\n         vec3 point = vec3(textureCoordinate.x, textureCoordinate.y, 1.0);\n         float value1 = dot(line1, point);\n         float value2 = dot(line2, point);\n         if (value1 >= 0.0 && value2 >= 0.0) {\n             gl_FragColor = original;\n         } else {\n             vec4 blur = vec4(1.0, 0.0, 0.0, 1.0);\n             if (debug == 0.0) {\n                 blur = texture2D(inputImageTexture, textureCoordinate);\n             }\n             float lineAlpha = max(-value1 / 0.15, -value2 / 0.15);\n             float alpha = (dist - inner)/outer;\n             alpha = min(lineAlpha, alpha);\n             alpha = clamp(alpha, 0.0, 1.0);\n             gl_FragColor = mix(original, blur, alpha);\n         }\n     }\n }\n";
    int aIV;
    int aIW;
    private float angle = 0.0f;
    private float bNO = 1.3333334f;
    private boolean bNP = false;
    private float bNQ = 0.0f;
    private BaseFilter bNR = null;
    private PointF center = new PointF(0.5f, 0.5f);
    private BaseFilter horizontal = null;
    private float radius = 0.35f;
    private BaseFilter vertical = null;

    public C8783j() {
        super(GLSLRender.bJB);
        AppMethodBeat.m2504i(86443);
        AppMethodBeat.m2505o(86443);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86444);
        if (map.containsKey("circle")) {
            this.bNP = ((Boolean) map.get("circle")).booleanValue();
        }
        if (map.containsKey("debug")) {
            this.bNQ = ((Float) map.get("debug")).floatValue();
            if (this.bNR != null) {
                this.bNR.addParam(new C0933f("debug", this.bNQ));
            }
        }
        if (map.containsKey("tx")) {
            this.center.x = ((Float) map.get("tx")).floatValue();
        }
        if (map.containsKey("ty")) {
            this.center.y = ((Float) map.get("ty")).floatValue();
        }
        if (map.containsKey("ratio")) {
            this.bNO = ((Float) map.get("ratio")).floatValue();
        }
        if (map.containsKey("radius")) {
            this.radius = ((Float) map.get("radius")).floatValue();
            if (this.bNR != null) {
                this.bNR.addParam(new C0933f("inner", this.radius));
            }
        }
        if (map.containsKey("angle")) {
            this.angle = ((Float) map.get("angle")).floatValue();
        }
        m15601Y(this.angle);
        AppMethodBeat.m2505o(86444);
    }

    /* renamed from: Y */
    private void m15601Y(float f) {
        AppMethodBeat.m2504i(86445);
        float f2 = (float) (((double) (f / 180.0f)) * 3.141592653589793d);
        r2 = new float[3][];
        r2[0] = new float[]{(float) Math.cos((double) f2), (float) Math.sin((double) f2), 0.0f};
        r2[1] = new float[]{-((float) Math.sin((double) f2)), (float) Math.cos((double) f2), 0.0f};
        r2[2] = new float[]{0.0f, 0.0f, 1.0f};
        float f3 = 0.9f;
        f2 = 1.5f;
        if (this.bNP) {
            f3 = 1.0f;
            f2 = 1.0f;
        }
        float[] fArr = new float[]{1.0f / (f3 * f3), 1.0f / (f2 * f2)};
        float[] fArr2 = new float[]{0.0f, 0.0f};
        fArr2[0] = (fArr[0] * r2[0][0]) + (fArr[1] * r2[0][1]);
        fArr2[1] = (fArr[0] * r2[1][0]) + (fArr[1] * r2[1][1]);
        fArr2[0] = Math.abs(fArr2[0]);
        fArr2[1] = (Math.abs(fArr2[1]) * this.bNO) * this.bNO;
        if (this.bNR != null) {
            this.bNR.addParam(new C0934g("ellipse", fArr2));
        }
        fArr2 = new float[]{-0.3f, 1.0f, 0.0f};
        float[] fArr3 = new float[]{0.3f, 1.0f, 0.0f};
        fArr = new float[3];
        fArr[0] = ((fArr2[0] * r2[0][0]) + (fArr2[1] * r2[0][1])) + (fArr2[2] * r2[0][2]);
        fArr[1] = ((fArr2[0] * r2[1][0]) + (fArr2[1] * r2[1][1])) + (fArr2[2] * r2[1][2]);
        fArr[2] = (fArr2[2] * r2[2][2]) + ((fArr2[0] * r2[2][0]) + (fArr2[1] * r2[2][1]));
        fArr2 = new float[3];
        fArr2[0] = ((fArr3[0] * r2[0][0]) + (fArr3[1] * r2[0][1])) + (fArr3[2] * r2[0][2]);
        fArr2[1] = ((fArr3[0] * r2[1][0]) + (fArr3[1] * r2[1][1])) + (fArr3[2] * r2[1][2]);
        fArr2[2] = (fArr3[2] * r2[2][2]) + ((fArr3[0] * r2[2][0]) + (fArr3[1] * r2[2][1]));
        fArr[2] = -((fArr[0] * this.center.x) + (fArr[1] * this.center.y));
        fArr2[2] = -((fArr2[0] * this.center.x) + (fArr2[1] * this.center.y));
        if (this.bNP) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = -0.15f;
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = -0.15f;
        }
        if (this.bNR != null) {
            this.bNR.addParam(new C0934g("line1", fArr));
            this.bNR.addParam(new C0934g("line2", fArr2));
        }
        fArr2 = new float[]{this.center.x, this.center.y};
        if (this.bNR != null) {
            this.bNR.addParam(new C0934g("center", fArr2));
        }
        AppMethodBeat.m2505o(86445);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86446);
        this.aIV = (int) f;
        this.aIW = (int) f2;
        this.bNO = f2 / f;
        float round = (float) Math.round(0.008333334f * f);
        int i = 0;
        if (round >= 1.0f) {
            i = (int) Math.floor(Math.sqrt((-2.0d * Math.pow((double) round, 2.0d)) * Math.log(0.00390625d * Math.sqrt(6.283185307179586d * Math.pow((double) round, 2.0d)))));
            i += i % 2;
        }
        this.horizontal = new BaseFilter(C37324aj.m62724b(i, round, true));
        this.vertical = new BaseFilter(C37324aj.m62724b(i, round, false));
        this.bNR = new BaseFilter(bNN);
        setNextFilter(this.horizontal, null);
        this.horizontal.setNextFilter(this.vertical, null);
        this.vertical.setNextFilter(this.bNR, new int[]{this.srcTextureIndex});
        this.bNR.addParam(new C0933f("debug", this.bNQ));
        this.bNR.addParam(new C0933f("outer", 0.12f));
        this.bNR.addParam(new C0933f("inner", this.radius));
        m15601Y(this.angle);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86446);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86447);
        if (!(this.aIV == i2 && this.aIW == i3)) {
            this.aIV = i2;
            this.aIW = i3;
            float round = (float) Math.round(0.008333334f * ((float) i2));
            int i4 = 0;
            if (round >= 1.0f) {
                i4 = (int) Math.floor(Math.sqrt((-2.0d * Math.pow((double) round, 2.0d)) * Math.log(0.00390625d * Math.sqrt(6.283185307179586d * Math.pow((double) round, 2.0d)))));
                i4 += i4 % 2;
            }
            this.horizontal.updateFragmentShader(C37324aj.m62724b(i4, round, true));
            this.horizontal.clearGLSLSelf();
            this.horizontal.ApplyGLSLFilter();
            this.vertical.updateFragmentShader(C37324aj.m62724b(i4, round, false));
            this.vertical.clearGLSLSelf();
            this.vertical.ApplyGLSLFilter();
            m15601Y(this.angle);
        }
        AppMethodBeat.m2505o(86447);
    }
}
