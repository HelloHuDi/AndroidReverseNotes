package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public class FaceColorFilter extends BaseFilter {
    private static final String FOLDER = "assets://realtimeBeauty";
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceColorFragmentShader.dat");
    private float alpha = 0.7f;
    private float blendAlpha = 1.0f;
    private float colorMinBase = 0.0f;
    private float colorRangeInv = 1.0f;

    static {
        AppMethodBeat.i(82336);
        AppMethodBeat.o(82336);
    }

    public FaceColorFilter() {
        super(FRAGMENT_SHADER);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82331);
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
        AppMethodBeat.o(82331);
    }

    public void setAlpha(float f) {
        AppMethodBeat.i(82332);
        this.alpha = f;
        addParam(new f("alpha", f));
        AppMethodBeat.o(82332);
    }

    public void setColorMinBase(float f) {
        AppMethodBeat.i(82333);
        this.colorMinBase = f;
        addParam(new f("colorMinBase", f));
        AppMethodBeat.o(82333);
    }

    public void setColorRangeInv(float f) {
        AppMethodBeat.i(82334);
        this.colorRangeInv = f;
        addParam(new f("colorRangeInv", f));
        AppMethodBeat.o(82334);
    }

    public void setBlendAlpha(float f) {
        AppMethodBeat.i(82335);
        this.blendAlpha = f;
        addParam(new f(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA, f));
        AppMethodBeat.o(82335);
    }
}
