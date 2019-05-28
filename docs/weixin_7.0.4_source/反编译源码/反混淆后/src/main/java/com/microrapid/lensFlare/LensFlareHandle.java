package com.microrapid.lensFlare;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.C16371i;

public class LensFlareHandle {
    final long bCj;
    private boolean bCk;
    int bCl;
    int bCm;
    boolean hasInit;
    private float strength;

    private native void nativeDispose(long j);

    private native void nativeInitLightSource(long j, QImage qImage);

    private native long nativeLensFlare();

    private native void nativeQImageCopy(QImage qImage, QImage qImage2);

    private native void nativeUpdateStrength(long j, float f);

    public native int nativeAttachLightSourceCrossGPUOne(long j, QImage qImage, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6, float[] fArr7, float[] fArr8, float[] fArr9, float[] fArr10, float[] fArr11);

    public native void nativeBlurImage(long j, QImage qImage);

    public native QImage nativeGetPatternImage(long j);

    public native void nativeGrayProcess(Bitmap bitmap);

    public native boolean nativeIsLightSourceExisted(long j, QImage qImage);

    public native void nativeLightSourceCrossImgSingle(long j, QImage qImage);

    public native boolean nativeLightSourceCrossImgTotalCPU(long j, QImage qImage);

    public native QImage nativePostProcessForBg(long j, QImage qImage);

    public native QImage nativePreProcessLensImgNoLightSource(long j, QImage qImage, float[] fArr);

    public native QImage nativePreProcessLensImgWithLightSource(long j, QImage qImage, float[] fArr);

    public native void nativeRefineLabelmapEx(long j);

    public native void nativeUpdateCrossNumStrength(long j, float f);

    public native void nativeUpdateCrossSizeStrength(long j, float f);

    public native void nativeUpdateOpType(long j, int i);

    public native void nativeUpdatePatternImage(long j, QImage qImage);

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(86250);
        dispose();
        super.finalize();
        AppMethodBeat.m2505o(86250);
    }

    public LensFlareHandle() {
        AppMethodBeat.m2504i(86251);
        this.bCk = false;
        this.hasInit = false;
        this.bCl = 0;
        this.strength = 0.5f;
        this.bCm = 2;
        this.bCj = nativeLensFlare();
        this.bCk = true;
        AppMethodBeat.m2505o(86251);
    }

    public final void dispose() {
        AppMethodBeat.m2504i(86252);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.hasInit = false;
            this.bCk = false;
        }
        AppMethodBeat.m2505o(86252);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vT */
    public final void mo67076vT() {
        AppMethodBeat.m2504i(86253);
        if (this.bCk) {
            AppMethodBeat.m2505o(86253);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("use bad addr");
        AppMethodBeat.m2505o(86253);
        throw runtimeException;
    }

    /* renamed from: p */
    private static float m73040p(float f) {
        if (f < 0.1f) {
            return 0.1f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* renamed from: bn */
    static void m73039bn(String str) {
        AppMethodBeat.m2504i(86254);
        C16371i.m25185j("test", str);
        AppMethodBeat.m2505o(86254);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo67058a(QImage qImage, float f, float f2) {
        AppMethodBeat.m2504i(86255);
        float p = m73040p(this.strength * 0.8f);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bMx, GLSLRender.bLx);
        baseFilter.addParam(new C0935i("uSamples", 32));
        baseFilter.addParam(new C0933f("uDispersal", 0.3f));
        baseFilter.addParam(new C0933f("uHaloWidth", p));
        baseFilter.addParam(new C0933f("uDistortion", 2.0f));
        baseFilter.addParam(new C0933f("px", f));
        baseFilter.addParam(new C0933f("py", f2));
        baseFilter.ApplyGLSLFilter(false, (float) qImage.getWidth(), (float) qImage.getHeight());
        C41672h c41672h = new C41672h();
        baseFilter.RendProcessImage(qImage, c41672h);
        baseFilter.ClearGLSL();
        c41672h.clear();
        AppMethodBeat.m2505o(86255);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo67057a(QImage qImage) {
        AppMethodBeat.m2504i(86256);
        nativeInitLightSource(this.bCj, qImage);
        AppMethodBeat.m2505o(86256);
    }
}
