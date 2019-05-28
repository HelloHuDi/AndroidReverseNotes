package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.HashMap;
import java.util.Map;

public class FrameBaseFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseFragmentShader.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseVertexShader.dat");
    private Map<String, AttributeParam> mAttrParams;
    private int mRenderMode;
    private int mSTextureHandle;

    static {
        AppMethodBeat.i(82548);
        AppMethodBeat.o(82548);
    }

    public FrameBaseFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82535);
        init();
        AppMethodBeat.o(82535);
    }

    public FrameBaseFilter(String str) {
        super(VERTEX_SHADER, str);
        AppMethodBeat.i(82536);
        init();
        AppMethodBeat.o(82536);
    }

    public FrameBaseFilter(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(82537);
        init();
        AppMethodBeat.o(82537);
    }

    private void init() {
        AppMethodBeat.i(82538);
        this.mAttrParams = new HashMap();
        this.mSTextureHandle = -1;
        AppMethodBeat.o(82538);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82539);
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        setTexCords(GlUtil.ORIGIN_TEX_COORDS);
        AppMethodBeat.o(82539);
    }

    public boolean setPositions(float[] fArr) {
        AppMethodBeat.i(82540);
        addAttribParam("position", fArr);
        AppMethodBeat.o(82540);
        return true;
    }

    public boolean setTexCords(float[] fArr) {
        AppMethodBeat.i(82541);
        addAttribParam("inputTextureCoordinate", fArr);
        AppMethodBeat.o(82541);
        return true;
    }

    public void OnDrawFrameGLSL() {
        AppMethodBeat.i(82542);
        super.OnDrawFrameGLSL();
        for (AttributeParam params : this.mAttrParams.values()) {
            params.setParams(getmProgramIds());
        }
        AppMethodBeat.o(82542);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82543);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        GLES20.glDrawArrays(6, 0, 4);
        if (this.mRenderMode == 0) {
            GLES20.glFinish();
        } else if (this.mRenderMode == 1) {
            GLES20.glFlush();
        }
        AppMethodBeat.o(82543);
        return true;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82544);
        initAttribParams();
        super.ApplyGLSLFilter();
        for (AttributeParam initialParams : this.mAttrParams.values()) {
            initialParams.initialParams(getmProgramIds());
        }
        this.mSTextureHandle = GLES20.glGetUniformLocation(getmProgramIds(), "inputImageTexture");
        AppMethodBeat.o(82544);
    }

    private void addAttribParam(String str, float[] fArr) {
        AppMethodBeat.i(82545);
        addAttribParam(str, fArr, false);
        AppMethodBeat.o(82545);
    }

    private void addAttribParam(String str, float[] fArr, boolean z) {
        AppMethodBeat.i(82546);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(82546);
            return;
        }
        AttributeParam attributeParam = (AttributeParam) this.mAttrParams.get(str);
        if (attributeParam == null) {
            attributeParam = new AttributeParam(str, fArr, z);
            this.mAttrParams.put(str, attributeParam);
        }
        attributeParam.setVertices(fArr);
        AppMethodBeat.o(82546);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82547);
        super.clearGLSLSelf();
        for (AttributeParam clear : this.mAttrParams.values()) {
            clear.clear();
        }
        AppMethodBeat.o(82547);
    }

    public boolean setRenderMode(int i) {
        this.mRenderMode = i;
        return true;
    }
}
