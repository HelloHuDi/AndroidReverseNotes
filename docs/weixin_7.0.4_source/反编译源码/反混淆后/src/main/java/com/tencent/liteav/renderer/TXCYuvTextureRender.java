package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class TXCYuvTextureRender {
    private static final int BYTES_PER_FLOAT = 4;
    private static final int INVALID_TEXTURE_ID = -12345;
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final String TAG = TXCYuvTextureRender.class.getSimpleName();
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final String mFragmentShaderCode = "precision mediump float;varying vec2 vTextureCoord;uniform sampler2D uTextureSampler0;uniform sampler2D uTextureSampler1;uniform sampler2D uTextureSampler2;const vec4 Coefficient0 = vec4(1.164383561643836, 1.164383561643836, 1.164383561643836, 1.0);const vec4 Coefficient1 = vec4(0.0000, -0.21324861427373, 2.112401785714286, 1.0);const vec4 Coefficient2 = vec4(1.792741071428571, -0.532909328559444, 0.0000, 1.0);const vec4 Coefficient3 = vec4(-0.972945075016308, 0.301482665475862, -1.133402217873451, 1.0);void main() {vec4 x,y,z,result;x  = texture2D(uTextureSampler0, vTextureCoord);y = texture2D(uTextureSampler1, vTextureCoord);z = texture2D(uTextureSampler2, vTextureCoord);result = x * Coefficient0 + Coefficient3;result = (y * Coefficient1) + result;result = (z * Coefficient2) + result;gl_FragColor = result;}";
    private static final String mVertexShaderCode = "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 aPosition;attribute vec2 aTextureCoord;varying vec2 vTextureCoord;void main() {vec4 pos  = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix*vec4(aTextureCoord, 0.0, 0.0)).xy;}";
    private int mFrameBufferID = INVALID_TEXTURE_ID;
    private int mFrameBufferTextureID = INVALID_TEXTURE_ID;
    private int mHeight;
    private short[] mIndices = new short[]{(short) 0, (short) 1, (short) 2, (short) 1, (short) 3, (short) 2};
    private ShortBuffer mIndicesBuffer;
    private int[] mLastTextureIds = null;
    private float[] mMVPMatrix = new float[16];
    private boolean mNeedReLoadFrameBuffer = false;
    private int mPositionHandle;
    private int mProgram;
    private FloatBuffer mTextureBuffer = ByteBuffer.allocateDirect(this.mTextureCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private float[] mTextureCoordinates = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int mTextureCoordinatesHandle;
    private int[] mTextureIds;
    private float[] mTextureMatrix = new float[16];
    private int mTextureMatrixHandle;
    private int mTextureUnitHandle0;
    private int mTextureUnitHandle1;
    private int mTextureUnitHandle2;
    private FloatBuffer mVertexBuffer;
    private int mVertexMatrixHandle;
    private float[] mVerticesCoordinates = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;
    private int mWidth;

    private native int nativeGetWidth(long j);

    private native void nativeLoadTexture(long j, int[] iArr);

    static {
        AppMethodBeat.m2504i(67350);
        C17778b.m27756e();
        AppMethodBeat.m2505o(67350);
    }

    public TXCYuvTextureRender() {
        AppMethodBeat.m2504i(67340);
        this.mTextureBuffer.put(this.mTextureCoordinates);
        this.mTextureBuffer.position(0);
        this.mVertexBuffer = ByteBuffer.allocateDirect(this.mVerticesCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVertexBuffer.put(this.mVerticesCoordinates);
        this.mVertexBuffer.position(0);
        this.mIndicesBuffer = ByteBuffer.allocateDirect(this.mIndices.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mIndicesBuffer.put(this.mIndices);
        this.mIndicesBuffer.position(0);
        AppMethodBeat.m2505o(67340);
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    public void createTexture() {
        AppMethodBeat.m2504i(67341);
        int glCreateShader = GLES20.glCreateShader(35633);
        checkError();
        GLES20.glShaderSource(glCreateShader, mVertexShaderCode);
        checkError();
        GLES20.glCompileShader(glCreateShader);
        checkError();
        int glCreateShader2 = GLES20.glCreateShader(35632);
        checkError();
        GLES20.glShaderSource(glCreateShader2, mFragmentShaderCode);
        checkError();
        GLES20.glCompileShader(glCreateShader2);
        this.mProgram = GLES20.glCreateProgram();
        checkError();
        GLES20.glAttachShader(this.mProgram, glCreateShader);
        checkError();
        GLES20.glAttachShader(this.mProgram, glCreateShader2);
        checkError();
        GLES20.glLinkProgram(this.mProgram);
        checkError();
        this.mVertexMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMatrix");
        checkError();
        this.mTextureMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uTextureMatrix");
        checkError();
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        checkError();
        this.mTextureCoordinatesHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkError();
        this.mTextureUnitHandle0 = GLES20.glGetUniformLocation(this.mProgram, "uTextureSampler0");
        checkError();
        this.mTextureUnitHandle1 = GLES20.glGetUniformLocation(this.mProgram, "uTextureSampler1");
        checkError();
        this.mTextureUnitHandle2 = GLES20.glGetUniformLocation(this.mProgram, "uTextureSampler2");
        checkError();
        this.mTextureIds = new int[3];
        GLES20.glGenTextures(3, this.mTextureIds, 0);
        checkError();
        AppMethodBeat.m2505o(67341);
    }

    public void clearLastFrame() {
        AppMethodBeat.m2504i(67342);
        this.mLastTextureIds = null;
        TXCLog.m15677i(TAG, "clearLastFrame");
        AppMethodBeat.m2505o(67342);
    }

    public void onSurfaceDestroy() {
        AppMethodBeat.m2504i(67343);
        if (this.mTextureIds != null) {
            GLES20.glDeleteTextures(3, this.mTextureIds, 0);
            this.mTextureIds = null;
        }
        destroyFrameBuffer();
        AppMethodBeat.m2505o(67343);
    }

    public void setHasFrameBuffer(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mNeedReLoadFrameBuffer = true;
    }

    private void reloadFrameBuffer() {
        AppMethodBeat.m2504i(67344);
        if (this.mNeedReLoadFrameBuffer) {
            TXCLog.m15675d(TAG, "reloadFrameBuffer. size = " + this.mWidth + "*" + this.mHeight);
            destroyFrameBuffer();
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glGenFramebuffers(1, iArr2, 0);
            this.mFrameBufferTextureID = iArr[0];
            this.mFrameBufferID = iArr2[0];
            TXCLog.m15675d(TAG, "frameBuffer id = " + this.mFrameBufferID + ", texture id = " + this.mFrameBufferTextureID);
            GLES20.glBindTexture(3553, this.mFrameBufferTextureID);
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.mWidth, this.mHeight, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextureID, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            this.mNeedReLoadFrameBuffer = false;
            AppMethodBeat.m2505o(67344);
            return;
        }
        AppMethodBeat.m2505o(67344);
    }

    private void destroyFrameBuffer() {
        AppMethodBeat.m2504i(67345);
        if (this.mFrameBufferID != INVALID_TEXTURE_ID) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBufferID}, 0);
            this.mFrameBufferID = INVALID_TEXTURE_ID;
        }
        if (this.mFrameBufferTextureID != INVALID_TEXTURE_ID) {
            GLES20.glDeleteTextures(1, new int[]{this.mFrameBufferTextureID}, 0);
            this.mFrameBufferTextureID = INVALID_TEXTURE_ID;
        }
        AppMethodBeat.m2505o(67345);
    }

    public int drawToTexture(long j) {
        AppMethodBeat.m2504i(67346);
        reloadFrameBuffer();
        if (this.mFrameBufferID == INVALID_TEXTURE_ID) {
            TXCLog.m15675d(TAG, "invalid frame buffer id");
            AppMethodBeat.m2505o(67346);
            return INVALID_TEXTURE_ID;
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        drawFrame(j);
        GLES20.glBindFramebuffer(36160, 0);
        int i = this.mFrameBufferTextureID;
        AppMethodBeat.m2505o(67346);
        return i;
    }

    public void drawFrame(long j) {
        AppMethodBeat.m2504i(67347);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        Matrix.setIdentityM(this.mTextureMatrix, 0);
        int nativeGetWidth = nativeGetWidth(j);
        if (nativeGetWidth > 0 && nativeGetWidth % 8 != 0) {
            int i = ((nativeGetWidth + 7) / 8) * 8;
            if (i != 0) {
                Matrix.scaleM(this.mTextureMatrix, 0, (((float) (nativeGetWidth - 1)) * 1.0f) / ((float) i), 1.0f, 1.0f);
            }
        }
        if (this.mVideoHeight % 8 != 0) {
            nativeGetWidth = ((this.mVideoHeight + 7) / 8) * 8;
            if (nativeGetWidth != 0) {
                Matrix.scaleM(this.mTextureMatrix, 0, 1.0f, (((float) (this.mVideoHeight - 1)) * 1.0f) / ((float) nativeGetWidth), 1.0f);
            }
        }
        GLES20.glUseProgram(this.mProgram);
        checkError();
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        checkError();
        this.mVertexBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, this.mVertexBuffer);
        checkError();
        GLES20.glEnableVertexAttribArray(this.mTextureCoordinatesHandle);
        checkError();
        this.mTextureBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mTextureCoordinatesHandle, 2, 5126, false, 8, this.mTextureBuffer);
        checkError();
        GLES20.glUniformMatrix4fv(this.mVertexMatrixHandle, 1, false, this.mMVPMatrix, 0);
        checkError();
        GLES20.glUniformMatrix4fv(this.mTextureMatrixHandle, 1, false, this.mTextureMatrix, 0);
        checkError();
        loadTexture(j);
        GLES20.glDrawElements(4, this.mIndices.length, 5123, this.mIndicesBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinatesHandle);
        this.mLastTextureIds = this.mTextureIds;
        AppMethodBeat.m2505o(67347);
    }

    public int checkError() {
        AppMethodBeat.m2504i(67348);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("gl error=".concat(String.valueOf(glGetError)));
            AppMethodBeat.m2505o(67348);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(67348);
        return glGetError;
    }

    private void loadTexture(long j) {
        AppMethodBeat.m2504i(67349);
        GLES20.glUniform1i(this.mTextureUnitHandle0, 0);
        checkError();
        GLES20.glUniform1i(this.mTextureUnitHandle1, 1);
        checkError();
        GLES20.glUniform1i(this.mTextureUnitHandle2, 2);
        checkError();
        nativeLoadTexture(j, this.mTextureIds);
        AppMethodBeat.m2505o(67349);
    }
}
