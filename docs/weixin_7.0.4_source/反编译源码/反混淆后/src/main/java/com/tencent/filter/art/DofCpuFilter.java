package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class DofCpuFilter extends BaseFilter {
    int bNA = 0;
    int bNB = 0;
    Bitmap bNf = null;
    int bNt = 0;
    int bNu = 0;
    int bNv = 0;
    int bNw = 0;
    int bNx = 0;
    int bNy = 0;
    int bNz = 0;
    int paramTEXTRUEID = 0;
    int type = 0;

    public static native void nativeRoundBlurProcess(QImage qImage, int i);

    public static native QImage nativeSacle(QImage qImage, int i);

    public static native void nativeblurBorder(Bitmap bitmap, int i);

    public DofCpuFilter(int i) {
        super(GLSLRender.bJB);
        this.type = i;
    }

    public void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86296);
        if (map.containsKey("xmin")) {
            this.bNt = ((Integer) map.get("xmin")).intValue();
        }
        if (map.containsKey("ymin")) {
            this.bNu = ((Integer) map.get("ymin")).intValue();
        }
        if (map.containsKey("xmax")) {
            this.bNv = ((Integer) map.get("xmax")).intValue();
        }
        if (map.containsKey("ymax")) {
            this.bNw = ((Integer) map.get("ymax")).intValue();
        }
        if (map.containsKey("maskbmp")) {
            this.bNf = (Bitmap) map.get("maskbmp");
        }
        AppMethodBeat.m2505o(86296);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86297);
        if (this.type == 0) {
            this.glsl_programID = GLSLRender.bKB;
            if (this.bNf != null) {
                addParam(new C25628k("inputImageTexture2", m81207n(this.bNf), 33986, true));
            }
            if (!(this.bNt == 0 && this.bNv == 0 && this.bNu == 0 && this.bNw == 0)) {
                float f3 = (float) (this.bNw - this.bNu);
                float f4 = f3 / ((float) this.bNw);
                float f5 = ((float) (this.bNw - this.bNu)) / f2;
                float f6 = ((float) (this.bNv - this.bNt)) / f;
                float abs = Math.abs((((float) this.bNu) + (f3 / 2.0f)) - (f2 / 2.0f)) / f2;
                float abs2 = Math.abs(f2 - ((float) this.bNw)) / f2;
                this.bNx = this.bNw;
                this.bNz = 0;
                if (f5 <= 0.7f || f6 <= 0.8f) {
                    this.bNy = (int) (f3 * 0.3f);
                    this.bNA = (int) (((float) this.bNy) + (0.5f * f3));
                    f4 = ((float) this.bNy) / ((float) this.bNA);
                    if (((float) this.bNA) > f2 * 0.6f) {
                        this.bNA = (int) (f2 * 0.6f);
                        this.bNy = (int) (f4 * (f2 * 0.6f));
                    } else if (((float) this.bNA) < f2 * 0.3f) {
                        this.bNA = (int) (f2 * 0.3f);
                        this.bNy = (int) (f4 * (f2 * 0.3f));
                    }
                    if (abs < abs2) {
                        this.bNz = (int) (0.1f * f3);
                        this.bNB = (int) ((f3 * 0.5f) + ((float) this.bNz));
                        f3 = ((float) this.bNz) / ((float) this.bNB);
                        if (((float) this.bNB) > f2 * 0.6f) {
                            this.bNB = (int) (f2 * 0.6f);
                            this.bNz = (int) (f3 * (f2 * 0.6f));
                        } else if (((float) this.bNB) < f2 * 0.2f) {
                            this.bNB = (int) (f2 * 0.2f);
                            this.bNz = (int) (f3 * (f2 * 0.2f));
                        }
                    } else {
                        this.bNz = 0;
                    }
                } else {
                    this.bNy = (int) ((1.0f - f4) * f3);
                    this.bNA = (int) ((f3 * (1.0f - f4)) + 50.0f);
                }
            }
            addParam(new C0933f("py", ((float) this.bNx) / f2));
            addParam(new C0933f("up_innerradius", ((float) this.bNy) / f2));
            addParam(new C0933f("down_innerradius", ((float) this.bNz) / f2));
            addParam(new C0933f("up_outerradius", ((float) this.bNA) / f2));
            addParam(new C0933f("down_outerradius", ((float) this.bNB) / f2));
            BaseFilter baseFilter = new BaseFilter(GLSLRender.bKn);
            if (this.bNf != null) {
                Bitmap copy = this.bNf.copy(this.bNf.getConfig(), false);
                nativeblurBorder(copy, 2);
                baseFilter.addParam(new C25628k("inputImageTexture3", copy, 33987, true));
            }
            setNextFilter(baseFilter, new int[]{this.srcTextureIndex});
        } else {
            this.glsl_programID = GLSLRender.bKC;
            if (this.bNf != null) {
                Bitmap copy2 = this.bNf.copy(this.bNf.getConfig(), false);
                nativeblurBorder(copy2, 2);
                addParam(new C25628k("inputImageTexture3", copy2, 33987, true));
                addParam(new C25628k("inputImageTexture2", m81207n(this.bNf), 33986, true));
            }
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86297);
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(86298);
        this.bNf = null;
        super.ClearGLSL();
        AppMethodBeat.m2505o(86298);
    }

    /* renamed from: n */
    private static Bitmap m81207n(Bitmap bitmap) {
        AppMethodBeat.m2504i(86299);
        QImage BindBitmap = QImage.BindBitmap(bitmap);
        QImage nativeSacle = nativeSacle(BindBitmap, 2);
        nativeRoundBlurProcess(nativeSacle, 4);
        BindBitmap.UnBindBitmap(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(nativeSacle.getWidth(), nativeSacle.getHeight(), Config.ARGB_8888);
        nativeSacle.ToBitmap(createBitmap);
        nativeSacle.Dispose();
        AppMethodBeat.m2505o(86299);
        return createBitmap;
    }
}
