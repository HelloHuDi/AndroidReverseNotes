package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.C25624m;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.shader.Shader;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.shader.ShaderManager;
import java.util.HashMap;
import java.util.Map;

public abstract class VideoFilterBase {
    public String dataPath;
    protected int height;
    private Map<String, AttributeParam> mAttrParams;
    private int mCoordNum;
    private DRAW_MODE mDrawMode;
    protected double mFaceDetScale;
    private Map<String, C25624m> mParamList;
    private int mRenderMode;
    protected int mSTextureHandle;
    private boolean needDelProgram;
    private Shader shader;
    protected int width;

    public enum SHADER_FIELD {
        CANVAS_SIZE("canvasSize"),
        FACE_DETECT_IMAGE_SIZE("faceDetectImageSize"),
        FACE_POINT("facePoints"),
        FACE_ACTION_TYPE("faceActionType"),
        FRAME_DURATION("frameDuration"),
        ELEMENT_DURATIONS("elementDurations"),
        AUDIO_POWER_SCALE("audioPowerScale");
        
        public String name;

        static {
            AppMethodBeat.m2505o(83077);
        }

        private SHADER_FIELD(String str) {
            this.name = str;
        }
    }

    public abstract void initParams();

    public VideoFilterBase(String str, String str2) {
        this(new Shader(str, str2));
        this.needDelProgram = true;
    }

    public VideoFilterBase(PROGRAM_TYPE program_type) {
        this(ShaderManager.getInstance().getShader(program_type));
    }

    private VideoFilterBase(Shader shader) {
        this.shader = shader;
        this.mAttrParams = new HashMap();
        this.mParamList = new HashMap();
        this.mSTextureHandle = -1;
        this.mCoordNum = 4;
        this.mDrawMode = DRAW_MODE.TRIANGLE_FAN;
    }

    public void updateVideoSize(int i, int i2, double d) {
        this.width = i;
        this.height = i2;
        this.mFaceDetScale = d;
    }

    public void addAttribParam(String str, float[] fArr) {
        addAttribParam(str, fArr, false);
    }

    public void addAttribParam(String str, float[] fArr, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            AttributeParam attributeParam = (AttributeParam) this.mAttrParams.get(str);
            if (attributeParam == null) {
                attributeParam = new AttributeParam(str, fArr, z);
                this.mAttrParams.put(str, attributeParam);
            }
            attributeParam.setVertices(fArr);
        }
    }

    public void addAttribParam(AttributeParam attributeParam) {
        if (attributeParam != null) {
            AttributeParam attributeParam2 = (AttributeParam) this.mAttrParams.get(attributeParam.name);
            if (attributeParam2 == null) {
                attributeParam2 = new AttributeParam(attributeParam.name, attributeParam.vertices, attributeParam.perVertexFloat, false);
                this.mAttrParams.put(attributeParam.name, attributeParam2);
            }
            attributeParam2.setVertices(attributeParam.vertices);
            attributeParam2.perVertexFloat = attributeParam.perVertexFloat;
        }
    }

    public AttributeParam getAttribParam(String str) {
        return (AttributeParam) this.mAttrParams.get(str);
    }

    public void addParam(C25624m c25624m) {
        if (c25624m != null) {
            C25624m c25624m2 = (C25624m) this.mParamList.get(c25624m.name);
            if (c25624m2 == null) {
                this.mParamList.put(c25624m.name, c25624m);
                return;
            }
            c25624m.handle = c25624m2.handle;
            this.mParamList.put(c25624m.name, c25624m);
        }
    }

    public void ApplyGLSLFilter() {
        initAttribParams();
        this.shader.compile();
        for (C25624m initialParams : this.mParamList.values()) {
            initialParams.initialParams(this.shader.getShaderProgram());
        }
        for (AttributeParam initialParams2 : this.mAttrParams.values()) {
            initialParams2.initialParams(this.shader.getShaderProgram());
        }
        this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
    }

    public void initAttribParams() {
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
    }

    public boolean renderTexture(int i, int i2, int i3) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        if (this.mDrawMode == DRAW_MODE.TRIANGLE_STRIP) {
            GLES20.glDrawArrays(5, 0, this.mCoordNum);
        } else if (this.mDrawMode == DRAW_MODE.TRIANGLES) {
            GLES20.glDrawArrays(4, 0, this.mCoordNum);
        } else if (this.mDrawMode == DRAW_MODE.TRIANGLE_FAN) {
            GLES20.glDrawArrays(6, 0, this.mCoordNum);
        } else if (this.mDrawMode == DRAW_MODE.LINES) {
            GLES20.glDrawArrays(1, 0, this.mCoordNum);
        } else if (this.mDrawMode == DRAW_MODE.POINTS) {
            GLES20.glDrawArrays(0, 0, this.mCoordNum);
        }
        if (this.mRenderMode == 0) {
            GLES20.glFinish();
        } else if (this.mRenderMode == 1) {
            GLES20.glFlush();
        }
        return true;
    }

    public void OnDrawFrameGLSL() {
        this.shader.bind();
        for (C25624m params : this.mParamList.values()) {
            params.setParams(this.shader.getShaderProgram());
        }
        for (AttributeParam attributeParam : this.mAttrParams.values()) {
            if (attributeParam.handle >= 0) {
                attributeParam.setParams(this.shader.getShaderProgram());
            }
        }
    }

    public void OnDrawFrameGLSLSuper() {
        this.shader.bind();
        for (C25624m params : this.mParamList.values()) {
            params.setParams(this.shader.getShaderProgram());
        }
    }

    public boolean setPositions(float[] fArr) {
        addAttribParam("position", fArr);
        return true;
    }

    public boolean setTexCords(float[] fArr) {
        addAttribParam("inputTextureCoordinate", fArr);
        return true;
    }

    public boolean setPositions(float[] fArr, boolean z) {
        addAttribParam("position", fArr, z);
        return true;
    }

    public boolean setTexCords(float[] fArr, boolean z) {
        addAttribParam("inputTextureCoordinate", fArr, z);
        return true;
    }

    public boolean setCoordNum(int i) {
        this.mCoordNum = i;
        return true;
    }

    public boolean setRenderMode(int i) {
        this.mRenderMode = i;
        return true;
    }

    public boolean setGrayCords(float[] fArr) {
        addAttribParam("inputGrayTextureCoordinate", fArr);
        return true;
    }

    public void setDrawMode(DRAW_MODE draw_mode) {
        this.mDrawMode = draw_mode;
    }

    public void clearGLSLSelf() {
        if (this.needDelProgram) {
            this.shader.clear();
        }
        for (C25624m clear : this.mParamList.values()) {
            clear.clear();
        }
        for (AttributeParam clear2 : this.mAttrParams.values()) {
            clear2.clear();
        }
    }

    public int getProgramIds() {
        return this.shader.getShaderProgram();
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, C41672h c41672h) {
        c41672h.mo67189a(i4, i2, i3, d);
        OnDrawFrameGLSL();
        renderTexture(i, i2, i3);
    }

    public void updateFilterShader(PROGRAM_TYPE program_type) {
        this.shader = ShaderManager.getInstance().getShader(program_type);
        this.needDelProgram = false;
    }

    public void updateFilterShader(String str, String str2) {
        this.shader = new Shader(str, str2);
        this.needDelProgram = true;
    }
}
