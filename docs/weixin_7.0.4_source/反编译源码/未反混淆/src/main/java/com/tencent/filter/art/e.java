package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;
import com.tencent.view.g;

public final class e extends BaseFilter {
    private BaseFilter bND = null;
    float strenth = 0.5f;

    public static class a extends BaseFilter {
        int paramTEXTRUEID = 0;

        public a() {
            super(GLSLRender.bLl);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86303);
            this.paramTEXTRUEID = g.dSO();
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86303);
        }

        public final void beforeRender(int i, int i2, int i3) {
            int i4;
            float f;
            int i5;
            int i6 = 0;
            AppMethodBeat.i(86304);
            QImage aL = g.aL(i, i2, i3);
            int[] nativeGetArrayHistogram = aL.nativeGetArrayHistogram();
            aL.Dispose();
            int i7 = 0;
            int i8 = 0;
            for (i4 = 0; i4 < 256; i4++) {
                i7 += nativeGetArrayHistogram[i4];
                i8 += nativeGetArrayHistogram[i4] * i4;
            }
            int i9 = i8 / i7;
            int i10 = (int) (((float) i7) * 0.001f);
            int i11 = (int) (((float) i7) * 0.99f);
            i4 = 0;
            i8 = 0;
            while (i8 < 256) {
                i4 += nativeGetArrayHistogram[i8];
                if (i4 > i10) {
                    i7 = i8;
                    break;
                }
                i8++;
            }
            i7 = 0;
            for (i8++; i8 < 256; i8++) {
                i4 += nativeGetArrayHistogram[i8];
                if (i4 > i11) {
                    i4 = i8;
                    break;
                }
            }
            i4 = 255;
            float log = (float) (Math.log(0.5d) / Math.log((double) (((float) (i9 - i7)) / ((float) (i4 - i7)))));
            if (((double) log) < 0.1d) {
                f = 0.1f;
            } else {
                f = log;
            }
            if (((double) log) > 10.0d) {
                f = 10.0f;
            }
            float[] fArr = new float[256];
            for (i5 = 0; i5 < i7; i5++) {
                fArr[i5] = 0.0f;
            }
            for (i5 = i7; i5 < i4; i5++) {
                fArr[i5] = (float) Math.pow((double) (((float) (i5 - i7)) / ((float) (i4 - i7))), (double) f);
            }
            while (i4 < 256) {
                fArr[i4] = 1.0f;
                i4++;
            }
            int[] iArr = new int[256];
            while (i6 < 256) {
                iArr[i6] = (int) (fArr[i6] * 255.0f);
                i6++;
            }
            GLES20.glActiveTexture(33984);
            GLSLRender.nativeTextCure(iArr, this.paramTEXTRUEID);
            AppMethodBeat.o(86304);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.i(86305);
            setTextureParam(this.paramTEXTRUEID, 1);
            boolean renderTexture = super.renderTexture(i, i2, i3);
            AppMethodBeat.o(86305);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.i(86306);
            g.Sk(this.paramTEXTRUEID);
            super.ClearGLSL();
            AppMethodBeat.o(86306);
        }
    }

    public e() {
        super(GLSLRender.bJB);
    }

    public final void setAdjustParam(float f) {
        AppMethodBeat.i(86307);
        this.strenth = f;
        if (this.bND != null) {
            this.bND.addParam(new f("param", this.strenth));
        }
        AppMethodBeat.o(86307);
    }

    public final boolean isAdjustFilter() {
        return true;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86308);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f2, f), 1.0f);
        setNextFilter(baseFilter, null);
        this.bND = new a();
        this.bND.addParam(new f("param", this.strenth));
        if (this.strenth >= 0.5f) {
            this.bND.addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 2.0f));
        } else {
            this.bND.addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 1.0f));
        }
        baseFilter.setNextFilter(this.bND, new int[]{this.srcTextureIndex + 1});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86308);
    }

    public final void ClearGLSL() {
        AppMethodBeat.i(86309);
        this.bND = null;
        super.ClearGLSL();
        AppMethodBeat.o(86309);
    }
}
