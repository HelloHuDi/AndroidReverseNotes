package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.model.WMElement;
import com.tencent.view.g;

public class NightRGBStretchImpFilter extends BaseFilter {
    private static final String TAG = NightRGBStretchImpFilter.class.getSimpleName();
    private int[] mHistogram;
    private float param;
    private int paramTEXTRUEID = 0;
    private float recordParam = 0.5f;

    static {
        AppMethodBeat.i(82684);
        AppMethodBeat.o(82684);
    }

    public NightRGBStretchImpFilter() {
        super(GLSLRender.bLl);
        AppMethodBeat.i(82678);
        initParams();
        AppMethodBeat.o(82678);
    }

    private void initParams() {
        AppMethodBeat.i(82679);
        this.param = 0.0f;
        addParam(new f("param", 0.5f));
        addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 2.0f));
        AppMethodBeat.o(82679);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82680);
        this.paramTEXTRUEID = g.dSO();
        super.ApplyGLSLFilter();
        AppMethodBeat.o(82680);
    }

    public void beforeRender(int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(82681);
        if (this.mHistogram == null || this.mHistogram.length < 256) {
            AppMethodBeat.o(82681);
            return;
        }
        int i5;
        if (((double) this.param) > 0.5d) {
            float f = this.param;
            if (((double) f) > 0.6d) {
                f = 0.6f;
            }
            if (f > this.recordParam) {
                addParam(new f("param", f));
                LogUtils.e(TAG, "night filter param = ".concat(String.valueOf(f)));
                this.recordParam = f;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (i5 = 0; i5 < 256; i5++) {
            i6 += this.mHistogram[i5];
            i7 += this.mHistogram[i5] * i5;
        }
        if (i6 == 0) {
            AppMethodBeat.o(82681);
            return;
        }
        float f2;
        int i8;
        int i9 = i7 / i6;
        int i10 = (int) (((float) i6) * 0.001f);
        int i11 = (int) (((float) i6) * 0.99f);
        i5 = 0;
        i7 = 0;
        while (i7 < 256) {
            i5 += this.mHistogram[i7];
            if (i5 > i10) {
                i6 = i7;
                break;
            }
            i7++;
        }
        i6 = 0;
        for (i7++; i7 < 256; i7++) {
            i5 += this.mHistogram[i7];
            if (i5 > i11) {
                i5 = i7;
                break;
            }
        }
        i5 = 255;
        float log = (float) (Math.log(0.5d) / Math.log((double) (((float) (i9 - i6)) / ((float) (i5 - i6)))));
        if (((double) log) < 0.1d) {
            f2 = 0.1f;
        } else {
            f2 = log;
        }
        if (((double) log) > 10.0d) {
            f2 = 10.0f;
        }
        float[] fArr = new float[256];
        for (i8 = 0; i8 < i6; i8++) {
            fArr[i8] = 0.0f;
        }
        for (i8 = i6; i8 < i5; i8++) {
            fArr[i8] = (float) Math.pow((double) (((float) (i8 - i6)) / ((float) (i5 - i6))), (double) f2);
        }
        while (i5 < 256) {
            fArr[i5] = 1.0f;
            i5++;
        }
        int[] iArr = new int[256];
        while (i4 < 256) {
            iArr[i4] = (int) (fArr[i4] * 255.0f);
            i4++;
        }
        GLES20.glActiveTexture(33984);
        GLSLRender.nativeTextCure(iArr, this.paramTEXTRUEID);
        AppMethodBeat.o(82681);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82682);
        setTextureParam(this.paramTEXTRUEID, 1);
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.o(82682);
        return renderTexture;
    }

    public void ClearGLSL() {
        AppMethodBeat.i(82683);
        g.Sk(this.paramTEXTRUEID);
        super.ClearGLSL();
        AppMethodBeat.o(82683);
    }

    public void setHistogram(int[] iArr) {
        this.mHistogram = iArr;
        this.param = 0.0f;
        if (this.mHistogram != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < this.mHistogram.length) {
                int i4;
                i3 += this.mHistogram[i];
                if (i < 80) {
                    i4 = this.mHistogram[i] + i2;
                } else {
                    i4 = i2;
                }
                i++;
                i2 = i4;
            }
            if (i3 != 0) {
                this.param = (((float) i2) * 1.0f) / ((float) i3);
            }
        }
    }

    public void reset() {
        this.recordParam = 0.5f;
    }

    public boolean needRender() {
        return ((double) this.param) > 0.5d;
    }
}
