package com.microrapid.lensFlare;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.i;

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
        AppMethodBeat.i(86250);
        dispose();
        super.finalize();
        AppMethodBeat.o(86250);
    }

    public LensFlareHandle() {
        AppMethodBeat.i(86251);
        this.bCk = false;
        this.hasInit = false;
        this.bCl = 0;
        this.strength = 0.5f;
        this.bCm = 2;
        this.bCj = nativeLensFlare();
        this.bCk = true;
        AppMethodBeat.o(86251);
    }

    public final void dispose() {
        AppMethodBeat.i(86252);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.hasInit = false;
            this.bCk = false;
        }
        AppMethodBeat.o(86252);
    }

    /* Access modifiers changed, original: final */
    public final void vT() {
        AppMethodBeat.i(86253);
        if (this.bCk) {
            AppMethodBeat.o(86253);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("use bad addr");
        AppMethodBeat.o(86253);
        throw runtimeException;
    }

    private static float p(float f) {
        if (f < 0.1f) {
            return 0.1f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    static void bn(String str) {
        AppMethodBeat.i(86254);
        i.j("test", str);
        AppMethodBeat.o(86254);
    }

    /* Access modifiers changed, original: final */
    public final void a(QImage qImage, float f, float f2) {
        AppMethodBeat.i(86255);
        float p = p(this.strength * 0.8f);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bMx, GLSLRender.bLx);
        baseFilter.addParam(new m.i("uSamples", 32));
        baseFilter.addParam(new f("uDispersal", 0.3f));
        baseFilter.addParam(new f("uHaloWidth", p));
        baseFilter.addParam(new f("uDistortion", 2.0f));
        baseFilter.addParam(new f("px", f));
        baseFilter.addParam(new f("py", f2));
        baseFilter.ApplyGLSLFilter(false, (float) qImage.getWidth(), (float) qImage.getHeight());
        h hVar = new h();
        baseFilter.RendProcessImage(qImage, hVar);
        baseFilter.ClearGLSL();
        hVar.clear();
        AppMethodBeat.o(86255);
    }

    /* Access modifiers changed, original: final */
    public final void a(QImage qImage) {
        AppMethodBeat.i(86256);
        nativeInitLightSource(this.bCj, qImage);
        AppMethodBeat.o(86256);
    }
}
