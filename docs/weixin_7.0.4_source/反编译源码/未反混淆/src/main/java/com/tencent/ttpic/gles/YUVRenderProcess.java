package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class YUVRenderProcess {
    private static final int COORDS_PER_VERTEX = 3;
    private static int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0, \t\t-.34414, 1.772,\n1.402, \t-.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
    private static int SHORT_SIZE_BYTES = 2;
    private static final int TEXTURE_COORS_PER_VERTEX = 2;
    private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n";
    private static short[] drawIndices = new short[]{(short) 0, (short) 1, (short) 2, (short) 0, (short) 2, (short) 3};
    private static float[] squareVertices = new float[]{-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private static float[] textureVertices = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    private ShortBuffer mDrawIndicesBuffer;
    private h mEffectFrame = new h();
    private int mHeight = 720;
    private int mProgram = -1;
    private FloatBuffer mSquareVerticesBuffer;
    private FloatBuffer mTextureVerticesBuffer;
    private int mWidth = ActUtil.HEIGHT;
    private int sampleULoaction;
    private int sampleVLoaction;
    private int sampleYLoaction;
    private int sh;
    private int sw;
    private byte[] u;
    private ByteBuffer uBuf;
    private int uSize = (this.uvSize >> 1);
    private int[] uTexture = new int[1];
    private int uvSize = (this.ySize >> 1);
    private byte[] v;
    private ByteBuffer vBuf;
    private int[] vTexture = new int[1];
    private byte[] y;
    private ByteBuffer yBuf;
    private int ySize = (this.mWidth * this.mHeight);
    private int[] yTexture = new int[1];

    public YUVRenderProcess() {
        AppMethodBeat.i(83259);
        AppMethodBeat.o(83259);
    }

    public void init() {
        AppMethodBeat.i(83260);
        this.mProgram = ProgramTools.createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        initVertex();
        initTexture();
        initDataBuffer();
        AppMethodBeat.o(83260);
    }

    private void initVertex() {
        AppMethodBeat.i(83261);
        this.mSquareVerticesBuffer = ByteBuffer.allocateDirect(FLOAT_SIZE_BYTES * squareVertices.length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSquareVerticesBuffer.put(squareVertices);
        this.mSquareVerticesBuffer.position(0);
        this.mTextureVerticesBuffer = ByteBuffer.allocateDirect(FLOAT_SIZE_BYTES * textureVertices.length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVerticesBuffer.put(textureVertices);
        this.mTextureVerticesBuffer.position(0);
        this.mDrawIndicesBuffer = ByteBuffer.allocateDirect(SHORT_SIZE_BYTES * drawIndices.length).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mDrawIndicesBuffer.put(drawIndices);
        this.mDrawIndicesBuffer.position(0);
        AppMethodBeat.o(83261);
    }

    private void initTexture() {
        AppMethodBeat.i(83262);
        GLES20.glEnable(3553);
        GLES20.glActiveTexture(33984);
        GLES20.glActiveTexture(33985);
        GLES20.glActiveTexture(33986);
        ProgramTools.createTexture(this.mWidth, this.mHeight, 6409, this.yTexture);
        ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.uTexture);
        ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.vTexture);
        GLES20.glUseProgram(this.mProgram);
        this.sampleYLoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerY");
        this.sampleULoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerU");
        this.sampleVLoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerV");
        GLES20.glUniform1i(this.sampleYLoaction, 0);
        GLES20.glUniform1i(this.sampleULoaction, 1);
        GLES20.glUniform1i(this.sampleVLoaction, 2);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "position");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgram, "textureCoordinateIn");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.mSquareVerticesBuffer);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, this.mTextureVerticesBuffer);
        AppMethodBeat.o(83262);
    }

    private void drawFrame() {
        AppMethodBeat.i(83263);
        GLES20.glViewport(0, 0, this.sw, this.sh);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.yTexture[0]);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth, this.mHeight, 6409, GLType.GL_UNSIGNED_BYTE, this.yBuf);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.uTexture[0]);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth >> 1, this.mHeight >> 1, 6409, GLType.GL_UNSIGNED_BYTE, this.uBuf);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.vTexture[0]);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth >> 1, this.mHeight >> 1, 6409, GLType.GL_UNSIGNED_BYTE, this.vBuf);
        GLES20.glUniform1i(this.sampleYLoaction, 0);
        GLES20.glUniform1i(this.sampleULoaction, 1);
        GLES20.glUniform1i(this.sampleVLoaction, 2);
        GLES20.glDrawElements(4, drawIndices.length, 5123, this.mDrawIndicesBuffer);
        GLES20.glFinish();
        AppMethodBeat.o(83263);
    }

    public h queueYUV(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(83264);
        if (!(this.mWidth == i && this.mHeight == i2)) {
            this.mWidth = i;
            this.mHeight = i2;
            initDataBuffer();
            rebuildTextures();
        }
        System.arraycopy(bArr, 0, this.y, 0, this.ySize);
        System.arraycopy(bArr, this.ySize, this.v, 0, this.uSize);
        System.arraycopy(bArr, this.ySize + this.uSize, this.u, 0, this.uSize);
        this.yBuf.position(0);
        this.yBuf.put(this.y).position(0);
        this.uBuf.position(0);
        this.uBuf.put(this.u).position(0);
        this.vBuf.position(0);
        this.vBuf.put(this.v).position(0);
        this.mEffectFrame.a(-1, this.sw, this.sh, 0.0d);
        drawFrame();
        h hVar = this.mEffectFrame;
        AppMethodBeat.o(83264);
        return hVar;
    }

    private void initDataBuffer() {
        AppMethodBeat.i(83265);
        this.ySize = this.mWidth * this.mHeight;
        this.uvSize = this.ySize >> 1;
        this.uSize = this.uvSize >> 1;
        this.y = new byte[this.ySize];
        this.u = new byte[this.uSize];
        this.v = new byte[this.uSize];
        this.yBuf = ByteBuffer.allocateDirect(this.ySize);
        this.uBuf = ByteBuffer.allocateDirect(this.ySize >> 2);
        this.vBuf = ByteBuffer.allocateDirect(this.ySize >> 2);
        AppMethodBeat.o(83265);
    }

    private void rebuildTextures() {
        AppMethodBeat.i(83266);
        GLES20.glDeleteTextures(this.yTexture.length, this.yTexture, 0);
        GLES20.glDeleteTextures(this.uTexture.length, this.uTexture, 0);
        GLES20.glDeleteTextures(this.vTexture.length, this.vTexture, 0);
        ProgramTools.createTexture(this.mWidth, this.mHeight, 6409, this.yTexture);
        ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.uTexture);
        ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.vTexture);
        AppMethodBeat.o(83266);
    }

    public void changeViewPort(int i, int i2) {
        AppMethodBeat.i(83267);
        this.sw = Math.max(i, i2);
        this.sh = Math.min(i, i2);
        AppMethodBeat.o(83267);
    }

    public byte[] getY() {
        return this.y;
    }
}
