package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.m.d;
import com.tencent.filter.m.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.glmodel.Sphere;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public class ThreeDimFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThreeDimVertexShader.dat");
    private StickerItem item;
    private Sphere mSphere = new Sphere(3, 1.0f);
    private String materialId;

    static {
        AppMethodBeat.i(83010);
        AppMethodBeat.o(83010);
    }

    public ThreeDimFilter(StickerItem stickerItem, String str) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(83004);
        this.item = stickerItem;
        this.dataPath = str;
        this.materialId = VideoMaterialUtil.getMaterialId(str);
        initParams();
        AppMethodBeat.o(83004);
    }

    public void initParams() {
        AppMethodBeat.i(83005);
        addParam(new d("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new j("u_MVPMatrix", MatrixUtil.getMVPMatrix(2.0f, 1.0f, 3.0f)));
        AppMethodBeat.o(83005);
    }

    public void initAttribParams() {
        AppMethodBeat.i(83006);
        super.initAttribParams();
        addAttribParam(new AttributeParam("color", new float[1], 3));
        AppMethodBeat.o(83006);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(83007);
        if (pTDetectInfo.faceAngles == null || pTDetectInfo.faceAngles.length < 3) {
            AppMethodBeat.o(83007);
            return;
        }
        addParam(new d("texRotate", pTDetectInfo.faceAngles[0] * 2.0f, pTDetectInfo.faceAngles[1] * 2.0f, pTDetectInfo.faceAngles[2]));
        this.mSphere.loadGLTexture(getNextFrame(0));
        AppMethodBeat.o(83007);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(83008);
        GLES20.glDisable(3042);
        GLES20.glEnable(2929);
        GLES20.glDepthFunc(515);
        GLES20.glDepthMask(true);
        GLES20.glClear(256);
        this.mSphere.draw(getAttribParam("position").handle, getAttribParam("inputTextureCoordinate").handle, getAttribParam("color").handle, this.mSTextureHandle);
        GLES20.glDisable(2929);
        AppMethodBeat.o(83008);
        return true;
    }

    private Bitmap getNextFrame(int i) {
        AppMethodBeat.i(83009);
        new StringBuilder().append(this.materialId).append(File.separator).append(this.item.id).append("_").append(i).append(".png");
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i);
        AppMethodBeat.o(83009);
        return loadImage;
    }
}
