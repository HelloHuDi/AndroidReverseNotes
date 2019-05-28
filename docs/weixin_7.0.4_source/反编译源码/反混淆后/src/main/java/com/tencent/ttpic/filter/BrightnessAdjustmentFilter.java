package com.tencent.ttpic.filter;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25625a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class BrightnessAdjustmentFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/BrightnessAdjustmentFilter.dat");
    private int counter = 5;
    private int[] lastCurve = new int[256];
    private boolean lastStable = true;

    static {
        AppMethodBeat.m2504i(82067);
        AppMethodBeat.m2505o(82067);
    }

    public BrightnessAdjustmentFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82063);
        AppMethodBeat.m2505o(82063);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82064);
        float[] fArr = new float[130];
        fArr[128] = 1.0f;
        fArr[GmsClientSupervisor.DEFAULT_BIND_FLAGS] = 1.0f;
        for (int i = 0; i < 256; i++) {
            this.lastCurve[i] = i;
            if (i % 2 == 0) {
                fArr[i / 2] = ((float) i) / 255.0f;
            }
        }
        addParam(new C25625a("curve", fArr));
        addParam(new C0933f("alpha", 1.0f));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82064);
    }

    public void updateCurve(int[] iArr, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(82065);
        float[] fArr = new float[130];
        fArr[128] = 1.0f;
        fArr[GmsClientSupervisor.DEFAULT_BIND_FLAGS] = 1.0f;
        if (z) {
            this.lastStable = true;
            while (i < 256) {
                this.lastCurve[i] = iArr[i];
                if (i % 2 == 0) {
                    fArr[i / 2] = ((float) iArr[i]) / 255.0f;
                }
                i++;
            }
            addParam(new C25625a("curve", fArr));
            AppMethodBeat.m2505o(82065);
            return;
        }
        boolean z2 = iArr[128] == this.lastCurve[128];
        if (this.lastStable && !z2) {
            this.counter = 5;
        }
        this.lastStable = z2;
        if (z2) {
            while (i < 256) {
                if (i % 2 == 0) {
                    fArr[i / 2] = ((float) iArr[i]) / 255.0f;
                }
                i++;
            }
            addParam(new C25625a("curve", fArr));
            AppMethodBeat.m2505o(82065);
            return;
        }
        this.counter = Math.max(1, this.counter - 1);
        int[] iArr2 = new int[256];
        while (i < 256) {
            iArr2[i] = ((iArr[i] - this.lastCurve[i]) / this.counter) + this.lastCurve[i];
            this.lastCurve[i] = iArr2[i];
            if (i % 2 == 0) {
                fArr[i / 2] = ((float) iArr2[i]) / 255.0f;
            }
            i++;
        }
        addParam(new C25625a("curve", fArr));
        AppMethodBeat.m2505o(82065);
    }

    public void setBlendAlpha(float f) {
        AppMethodBeat.m2504i(82066);
        addParam(new C0933f("alpha", f));
        AppMethodBeat.m2505o(82066);
    }
}
