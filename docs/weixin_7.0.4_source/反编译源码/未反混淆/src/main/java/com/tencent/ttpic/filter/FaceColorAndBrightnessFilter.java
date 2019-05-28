package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.a;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public class FaceColorAndBrightnessFilter extends BaseFilter {
    private static final String FOLDER = "assets://realtimeBeauty";
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceColorAndBrightnessFragmentShader.dat");
    private float alpha = 0.7f;
    private float blendAlpha = 1.0f;
    private float colorMinBase = 0.0f;
    private float colorRangeInv = 1.0f;
    private int counter = 5;
    private int[] lastCurve = new int[256];
    private boolean lastStable = true;

    static {
        AppMethodBeat.i(82330);
        AppMethodBeat.o(82330);
    }

    public FaceColorAndBrightnessFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82322);
        AppMethodBeat.o(82322);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82323);
        float[] fArr = new float[130];
        fArr[128] = 255.0f;
        fArr[GmsClientSupervisor.DEFAULT_BIND_FLAGS] = 255.0f;
        for (int i = 0; i < 256; i++) {
            this.lastCurve[i] = i;
            if (i % 2 == 0) {
                fArr[i / 2] = (float) i;
            }
        }
        addParam(new a("curve", fArr));
        addParam(new f("brightnessAlpha", 1.0f));
        Bitmap bitmapFromEncryptedFile = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(new StringBuilder(FOLDER).append(File.separator).append("lookup_table.png").toString());
        Bitmap bitmapFromEncryptedFile2 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(new StringBuilder(FOLDER).append(File.separator).append("lookup_table_gray.png").toString());
        Bitmap bitmapFromEncryptedFile3 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(new StringBuilder(FOLDER).append(File.separator).append("lookup_table_origin.png").toString());
        addParam(new k("inputImageTexture2", bitmapFromEncryptedFile2, 33986, true));
        addParam(new k("inputImageTexture3", bitmapFromEncryptedFile, 33987, true));
        addParam(new k("inputImageTexture4", bitmapFromEncryptedFile3, 33988, true));
        addParam(new f("colorRangeInv", this.colorRangeInv));
        addParam(new f("colorMinBase", this.colorMinBase));
        addParam(new f("alpha", this.alpha));
        addParam(new f(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA, this.blendAlpha));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82323);
    }

    public void setAlpha(float f) {
        AppMethodBeat.i(82324);
        this.alpha = f;
        addParam(new f("alpha", f));
        AppMethodBeat.o(82324);
    }

    public void setColorMinBase(float f) {
        AppMethodBeat.i(82325);
        this.colorMinBase = f;
        addParam(new f("colorMinBase", f));
        AppMethodBeat.o(82325);
    }

    public void setColorRangeInv(float f) {
        AppMethodBeat.i(82326);
        this.colorRangeInv = f;
        addParam(new f("colorRangeInv", f));
        AppMethodBeat.o(82326);
    }

    public void setBlendAlpha(float f) {
        AppMethodBeat.i(82327);
        this.blendAlpha = f;
        addParam(new f(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA, f));
        AppMethodBeat.o(82327);
    }

    public void updateCurve(int[] iArr, boolean z) {
        int i = 0;
        AppMethodBeat.i(82328);
        if (iArr == null) {
            AppMethodBeat.o(82328);
            return;
        }
        float[] fArr = new float[130];
        fArr[128] = 255.0f;
        fArr[GmsClientSupervisor.DEFAULT_BIND_FLAGS] = 255.0f;
        if (z) {
            this.lastStable = true;
            while (i < 256) {
                this.lastCurve[i] = iArr[i];
                if (i % 2 == 0) {
                    fArr[i / 2] = (float) iArr[i];
                }
                i++;
            }
            addParam(new a("curve", fArr));
            AppMethodBeat.o(82328);
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
                    fArr[i / 2] = (float) iArr[i];
                }
                i++;
            }
            addParam(new a("curve", fArr));
            AppMethodBeat.o(82328);
            return;
        }
        this.counter = Math.max(1, this.counter - 1);
        int[] iArr2 = new int[256];
        while (i < 256) {
            iArr2[i] = ((iArr[i] - this.lastCurve[i]) / this.counter) + this.lastCurve[i];
            this.lastCurve[i] = iArr2[i];
            if (i % 2 == 0) {
                fArr[i / 2] = (float) iArr2[i];
            }
            i++;
        }
        addParam(new a("curve", fArr));
        AppMethodBeat.o(82328);
    }

    public void setBrightnessAlpha(float f) {
        AppMethodBeat.i(82329);
        addParam(new f("brightnessAlpha", f));
        AppMethodBeat.o(82329);
    }
}
