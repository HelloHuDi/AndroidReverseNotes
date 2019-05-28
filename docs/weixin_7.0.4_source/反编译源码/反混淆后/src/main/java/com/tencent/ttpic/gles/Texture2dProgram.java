package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = GlUtil.TAG;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private float mColorAdjust;
    private float[] mKernel = new float[9];
    private int mProgramHandle;
    private ProgramType mProgramType;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;

    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT;

        static {
            AppMethodBeat.m2505o(50038);
        }
    }

    public Texture2dProgram(ProgramType programType) {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(50039);
        this.mProgramType = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_2D);
                break;
            case TEXTURE_EXT:
                this.mTextureTarget = GlUtil.GL_TEXTURE_EXTERNAL_OES;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_EXT_BW:
                this.mTextureTarget = GlUtil.GL_TEXTURE_EXTERNAL_OES;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_BW);
                break;
            case TEXTURE_EXT_FILT:
                this.mTextureTarget = GlUtil.GL_TEXTURE_EXTERNAL_OES;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_FILT);
                break;
            default:
                runtimeException = new RuntimeException("Unhandled type ".concat(String.valueOf(programType)));
                AppMethodBeat.m2505o(50039);
                throw runtimeException;
        }
        if (this.mProgramHandle == 0) {
            runtimeException = new RuntimeException("Unable to create program");
            AppMethodBeat.m2505o(50039);
            throw runtimeException;
        }
        new StringBuilder("Created program ").append(this.mProgramHandle).append(" (").append(programType).append(")");
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        GlUtil.checkLocation(this.maPositionLoc, "aPosition");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        GlUtil.checkLocation(this.muTexMatrixLoc, "uTexMatrix");
        this.muKernelLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
        if (this.muKernelLoc < 0) {
            this.muKernelLoc = -1;
            this.muTexOffsetLoc = -1;
            this.muColorAdjustLoc = -1;
            AppMethodBeat.m2505o(50039);
            return;
        }
        this.muTexOffsetLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
        GlUtil.checkLocation(this.muTexOffsetLoc, "uTexOffset");
        this.muColorAdjustLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
        GlUtil.checkLocation(this.muColorAdjustLoc, "uColorAdjust");
        setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
        setTexSize(256, 256);
        AppMethodBeat.m2505o(50039);
    }

    public void release() {
        AppMethodBeat.m2504i(50040);
        new StringBuilder("deleting program ").append(this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
        AppMethodBeat.m2505o(50040);
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    public int createTextureObject() {
        AppMethodBeat.m2504i(50041);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i);
        GlUtil.checkGlError("glBindTexture ".concat(String.valueOf(i)));
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        AppMethodBeat.m2505o(50041);
        return i;
    }

    public void setKernel(float[] fArr, float f) {
        AppMethodBeat.m2504i(50042);
        if (fArr.length != 9) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
            AppMethodBeat.m2505o(50042);
            throw illegalArgumentException;
        }
        System.arraycopy(fArr, 0, this.mKernel, 0, 9);
        this.mColorAdjust = f;
        AppMethodBeat.m2505o(50042);
    }

    public void setTexSize(int i, int i2) {
        float f = 1.0f / ((float) i);
        float f2 = 1.0f / ((float) i2);
        this.mTexOffset = new float[]{-f, -f2, 0.0f, -f2, f, -f2, -f, 0.0f, 0.0f, 0.0f, f, 0.0f, -f, f2, 0.0f, f2, f, f2};
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        AppMethodBeat.m2504i(50043);
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, i5);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, i3, 5126, false, i4, floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i6, floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        if (this.muKernelLoc >= 0) {
            GLES20.glUniform1fv(this.muKernelLoc, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
        AppMethodBeat.m2505o(50043);
    }
}
