package com.microrapid.lensFlare;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C17753c;
import com.tencent.filter.C25624m.C25625a;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C44569b;
import java.util.Map;

/* renamed from: com.microrapid.lensFlare.a */
public final class C8749a extends C17753c {
    private float param = 1.0f;
    private int type = 0;

    public final void setAdjustParam(float f) {
        this.param = f;
    }

    public final boolean isAdjustFilter() {
        return true;
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86248);
        if (map.containsKey("filterAdjustParam")) {
            this.param = ((Float) map.get("filterAdjustParam")).floatValue();
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.m2505o(86248);
    }

    public final QImage ApplyFilter(QImage qImage) {
        AppMethodBeat.m2504i(86249);
        try {
            String str;
            QImage BindBitmap;
            LensFlareHandle lensFlareHandle = new LensFlareHandle();
            lensFlareHandle.bCm = 2;
            lensFlareHandle.bCl = 1;
            lensFlareHandle.mo67076vT();
            lensFlareHandle.nativeUpdateOpType(lensFlareHandle.bCj, 1);
            switch (this.type) {
                case 1:
                    str = "lens/02star.jpg";
                    break;
                case 2:
                    str = "lens/03star.jpg";
                    break;
                case 3:
                    str = "lens/04star.jpg";
                    break;
                case 4:
                    str = "lens/05star.jpg";
                    break;
                case 5:
                    str = "lens/06sun.jpg";
                    break;
                case 6:
                    str = "lens/07sun.jpg";
                    break;
                case 7:
                    str = "lens/08sun.jpg";
                    break;
                default:
                    str = "lens/01star.jpg";
                    break;
            }
            lensFlareHandle.mo67076vT();
            Bitmap vt = C44569b.m80951vt(str);
            if (vt != null) {
                BindBitmap = QImage.BindBitmap(vt);
                lensFlareHandle.nativeUpdatePatternImage(lensFlareHandle.bCj, BindBitmap);
                BindBitmap.UnBindBitmap(vt);
                vt.recycle();
            }
            float f = 0.2f + (0.6f * this.param);
            lensFlareHandle.mo67076vT();
            lensFlareHandle.nativeUpdateCrossNumStrength(lensFlareHandle.bCj, f);
            f = 0.2f + (0.6f * this.param);
            lensFlareHandle.mo67076vT();
            lensFlareHandle.nativeUpdateCrossSizeStrength(lensFlareHandle.bCj, f);
            lensFlareHandle.mo67076vT();
            if (lensFlareHandle.nativeGetPatternImage(lensFlareHandle.bCj) != null) {
                QImage CreateImageFromQImage;
                Bitmap createBitmap;
                BaseFilter baseFilter;
                C41672h c41672h;
                if (lensFlareHandle.bCl == 0) {
                    if (!lensFlareHandle.hasInit) {
                        lensFlareHandle.mo67057a(qImage);
                        lensFlareHandle.hasInit = true;
                    }
                    float[] fArr;
                    if (lensFlareHandle.nativeIsLightSourceExisted(lensFlareHandle.bCj, qImage)) {
                        LensFlareHandle.m73039bn("processLensImage 1");
                        fArr = new float[2];
                        BindBitmap = lensFlareHandle.nativePreProcessLensImgWithLightSource(lensFlareHandle.bCj, qImage, fArr);
                        lensFlareHandle.mo67058a(BindBitmap, fArr[0], fArr[1]);
                        lensFlareHandle.nativeBlurImage(lensFlareHandle.bCj, BindBitmap);
                        CreateImageFromQImage = qImage.CreateImageFromQImage();
                        lensFlareHandle.nativeLightSourceCrossImgSingle(lensFlareHandle.bCj, CreateImageFromQImage);
                        Bitmap createBitmap2 = Bitmap.createBitmap(BindBitmap.getWidth(), BindBitmap.getHeight(), Config.ARGB_8888);
                        BindBitmap.ToBitmap(createBitmap2);
                        BindBitmap.Dispose();
                        createBitmap = Bitmap.createBitmap(CreateImageFromQImage.getWidth(), CreateImageFromQImage.getHeight(), Config.ARGB_8888);
                        CreateImageFromQImage.ToBitmap(createBitmap);
                        CreateImageFromQImage.Dispose();
                        baseFilter = new BaseFilter(GLSLRender.bMx, GLSLRender.bLy);
                        baseFilter.addParam(new C25628k("inputImageTexture2", createBitmap2, 33986, true));
                        baseFilter.addParam(new C25628k("inputImageTexture3", createBitmap, 33987, true));
                        baseFilter.ApplyGLSLFilter(false, (float) qImage.getWidth(), (float) qImage.getHeight());
                        c41672h = new C41672h();
                        baseFilter.RendProcessImage(qImage, c41672h);
                        baseFilter.ClearGLSL();
                        c41672h.clear();
                    } else {
                        LensFlareHandle.m73039bn("processLensImage 2");
                        fArr = new float[2];
                        BindBitmap = lensFlareHandle.nativePreProcessLensImgNoLightSource(lensFlareHandle.bCj, qImage, fArr);
                        lensFlareHandle.mo67058a(BindBitmap, fArr[0], fArr[1]);
                        CreateImageFromQImage = lensFlareHandle.nativePostProcessForBg(lensFlareHandle.bCj, BindBitmap);
                        BindBitmap.Dispose();
                        createBitmap = Bitmap.createBitmap(CreateImageFromQImage.getWidth(), CreateImageFromQImage.getHeight(), Config.ARGB_8888);
                        CreateImageFromQImage.ToBitmap(createBitmap);
                        CreateImageFromQImage.Dispose();
                        baseFilter = new BaseFilter(GLSLRender.bMx, GLSLRender.bLz);
                        baseFilter.addParam(new C25628k("inputImageTexture2", createBitmap, 33986, true));
                        baseFilter.ApplyGLSLFilter(false, (float) qImage.getWidth(), (float) qImage.getHeight());
                        c41672h = new C41672h();
                        baseFilter.RendProcessImage(qImage, c41672h);
                        baseFilter.ClearGLSL();
                        c41672h.clear();
                    }
                } else {
                    if (!lensFlareHandle.hasInit) {
                        lensFlareHandle.mo67057a(qImage);
                        lensFlareHandle.nativeRefineLabelmapEx(lensFlareHandle.bCj);
                        lensFlareHandle.hasInit = true;
                    }
                    if (lensFlareHandle.bCm == 2) {
                        lensFlareHandle.nativeLightSourceCrossImgTotalCPU(lensFlareHandle.bCj, qImage);
                    } else {
                        float[] fArr2 = new float[55];
                        float[] fArr3 = new float[55];
                        float[] fArr4 = new float[55];
                        float[] fArr5 = new float[55];
                        float[] fArr6 = new float[55];
                        float[] fArr7 = new float[55];
                        float[] fArr8 = new float[55];
                        float[] fArr9 = new float[55];
                        float[] fArr10 = new float[55];
                        float[] fArr11 = new float[55];
                        float[] fArr12 = new float[55];
                        lensFlareHandle.nativeAttachLightSourceCrossGPUOne(lensFlareHandle.bCj, qImage, fArr2, fArr3, fArr4, fArr5, fArr6, fArr7, fArr8, fArr9, fArr10, fArr11, fArr12);
                        CreateImageFromQImage = lensFlareHandle.nativeGetPatternImage(lensFlareHandle.bCj);
                        createBitmap = Bitmap.createBitmap(CreateImageFromQImage.getWidth(), CreateImageFromQImage.getHeight(), Config.ARGB_8888);
                        CreateImageFromQImage.ToBitmap(createBitmap);
                        lensFlareHandle.nativeGrayProcess(createBitmap);
                        baseFilter = new BaseFilter(GLSLRender.bLA);
                        baseFilter.addParam(new C25628k("inputImageTexture2", createBitmap, 33986, true));
                        baseFilter.addParam(new C25625a("rlist", fArr2));
                        baseFilter.addParam(new C25625a("glist", fArr3));
                        baseFilter.addParam(new C25625a("blist", fArr4));
                        baseFilter.addParam(new C25625a("offsetx_txlist", fArr5));
                        baseFilter.addParam(new C25625a("offsety_tylist", fArr6));
                        baseFilter.addParam(new C25625a("offsetx_rw_txlist", fArr7));
                        baseFilter.addParam(new C25625a("offsety_rh_tylist", fArr8));
                        baseFilter.addParam(new C25625a("alphaxlist", fArr9));
                        baseFilter.addParam(new C25625a("alphaylist", fArr10));
                        baseFilter.addParam(new C25625a("betaxlist", fArr11));
                        baseFilter.addParam(new C25625a("betaylist", fArr12));
                        baseFilter.ApplyGLSLFilter(false, (float) qImage.getWidth(), (float) qImage.getHeight());
                        LensFlareHandle.m73039bn("processCrosssImage ApplyGLSLFilter ");
                        c41672h = new C41672h();
                        baseFilter.RendProcessImage(qImage, c41672h);
                        baseFilter.ClearGLSL();
                        c41672h.clear();
                    }
                }
            }
            lensFlareHandle.dispose();
        } catch (Throwable th) {
            AppMethodBeat.m2505o(86249);
        }
        AppMethodBeat.m2505o(86249);
        return qImage;
    }
}
