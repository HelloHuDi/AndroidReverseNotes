package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;

/* renamed from: com.tencent.filter.a.al */
public final class C37326al extends BaseFilter {
    float bMC = 0.001f;
    float bMD = 0.999f;

    public C37326al(float f) {
        super(GLSLRender.bKO);
        AppMethodBeat.m2504i(86490);
        this.bMC = 0.0f + (f * 0.05f);
        this.bMD = 1.0f - (f * 0.05f);
        AppMethodBeat.m2505o(86490);
    }

    public C37326al() {
        super(GLSLRender.bKO);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86491);
        addParam(new C0933f("l_threshold_r", 0.1f));
        addParam(new C0933f("h_threshold_r", 0.1f));
        addParam(new C0933f("l_threshold_g", 0.1f));
        addParam(new C0933f("h_threshold_g", 0.1f));
        addParam(new C0933f("l_threshold_b", 0.1f));
        addParam(new C0933f("h_threshold_b", 0.1f));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86491);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86492);
        QImage aL = C41106g.m71542aL(i, i2, i3);
        int[] nativeGetArrayHistogramChannels = aL.nativeGetArrayHistogramChannels();
        aL.Dispose();
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < 3) {
                int i6 = i5 * 256;
                int i7 = 0;
                for (i4 = 0; i4 < 256; i4++) {
                    i7 += nativeGetArrayHistogramChannels[i6 + i4];
                }
                i4 = (int) (this.bMC * ((float) i7));
                int i8 = (int) (((float) i7) * this.bMD);
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i11 < 256) {
                    i9 += nativeGetArrayHistogramChannels[i6 + i11];
                    if (i9 >= i4) {
                        i4 = i11 + 1;
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                i4 = i11;
                while (i4 < 256) {
                    i11 = nativeGetArrayHistogramChannels[i6 + i4] + i9;
                    if (i11 >= i8) {
                        break;
                    }
                    i4++;
                    i9 = i11;
                }
                i4 = 0;
                iArr[i5] = i10;
                iArr2[i5] = i4;
                i4 = i5 + 1;
            } else {
                addParam(new C0933f("l_threshold_r", ((float) iArr[0]) / 255.0f));
                addParam(new C0933f("h_threshold_r", ((float) iArr2[0]) / 255.0f));
                addParam(new C0933f("l_threshold_g", ((float) iArr[1]) / 255.0f));
                addParam(new C0933f("h_threshold_g", ((float) iArr2[1]) / 255.0f));
                addParam(new C0933f("l_threshold_b", ((float) iArr[2]) / 255.0f));
                addParam(new C0933f("h_threshold_b", ((float) iArr2[2]) / 255.0f));
                AppMethodBeat.m2505o(86492);
                return;
            }
        }
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86493);
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(86493);
        return renderTexture;
    }
}
