package com.tencent.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class l extends BaseFilter {
    float bMC = 0.001f;
    float bMD = 0.999f;

    public l() {
        super(GLSLRender.bKh);
    }

    public l(float f, float f2) {
        super(GLSLRender.bKh);
        this.bMC = f;
        this.bMD = f2;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86380);
        addParam(new f("l_threshold", 0.1f));
        addParam(new f("h_threshold", 0.1f));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86380);
    }

    public final void beforeRender(int i, int i2, int i3) {
        int i4;
        AppMethodBeat.i(86381);
        QImage aL = g.aL(i, i2, i3);
        int[] nativeGetArrayHistogram = aL.nativeGetArrayHistogram();
        aL.Dispose();
        int i5 = 0;
        for (i4 = 0; i4 < 256; i4++) {
            i5 += nativeGetArrayHistogram[i4];
        }
        i4 = (int) (this.bMC * ((float) i5));
        int i6 = (int) (((float) i5) * this.bMD);
        int i7 = 0;
        int i8 = 0;
        while (i8 < 256) {
            i7 += nativeGetArrayHistogram[i8];
            if (i7 >= i4) {
                i5 = i8 + 1;
                i4 = i8;
                break;
            }
            i8++;
        }
        i4 = 0;
        i5 = i8;
        while (i5 < 256) {
            i8 = nativeGetArrayHistogram[i5] + i7;
            if (i8 >= i6) {
                break;
            }
            i5++;
            i7 = i8;
        }
        i5 = 0;
        addParam(new f("l_threshold", (float) (((double) i4) / 255.0d)));
        addParam(new f("h_threshold", (float) (((double) i5) / 255.0d)));
        AppMethodBeat.o(86381);
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(86382);
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.o(86382);
        return renderTexture;
    }
}
