package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements Renderer {
    static float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static float[] gLu = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private int eZH;
    private int eZI;
    private int eZJ;
    private int eZM;
    private int eZN;
    private int eZR;
    private int eZS;
    ByteBuffer eZU;
    ByteBuffer eZV;
    private FloatBuffer eZh;
    private FloatBuffer eZi;
    private int fcn = 0;
    private int fco = 0;
    private boolean fdb = false;
    private byte[] frameData = null;
    boolean gLA = false;
    private float[] gLB = eZY;
    boolean gLv = false;
    private int gLw = 0;
    private int gLx = 0;
    private int gLy;
    private float[] gLz = new float[16];
    private int rotate = 0;

    public b() {
        AppMethodBeat.i(55314);
        Point bPg = d.bPg();
        float f = (((float) bPg.x) / ((float) bPg.y)) / 2.0f;
        gLu = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
        AppMethodBeat.o(55314);
    }

    public final void b(byte[] bArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(55315);
        try {
            int i4;
            if (this.gLx == i2 && this.gLw == i && this.rotate == i3 && this.fdb == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i4 != 0) {
                ab.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.TRUE, this);
            }
            this.frameData = bArr;
            this.gLw = i;
            this.gLx = i2;
            this.rotate = i3;
            this.fdb = z;
            if (i4 != 0) {
                this.eZU = ByteBuffer.allocateDirect(i2 * i);
                this.eZV = ByteBuffer.allocateDirect((i * i2) / 2);
                this.eZU.order(ByteOrder.nativeOrder());
                this.eZV.order(ByteOrder.nativeOrder());
                if (z) {
                    this.gLB = gLu;
                } else {
                    this.gLB = eZY;
                }
                if (this.gLB != null) {
                    this.eZi.put(this.gLB);
                    this.eZi.position(0);
                }
            }
            if (!(this.eZU == null || this.eZV == null)) {
                this.eZU.put(bArr, 0, i * i2);
                this.eZU.position(0);
                this.eZV.put(bArr, i * i2, (i * i2) / 2);
                this.eZV.position(0);
            }
            AppMethodBeat.o(55315);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", e.getMessage());
            AppMethodBeat.o(55315);
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(55316);
        ab.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", this);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.eZH = com.tencent.mm.plugin.api.recordView.b.U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.eZH == 0) {
            ab.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.eZI = GLES20.glGetAttribLocation(this.eZH, "a_position");
        this.eZJ = GLES20.glGetAttribLocation(this.eZH, "a_texCoord");
        this.eZR = GLES20.glGetUniformLocation(this.eZH, "y_texture");
        this.eZS = GLES20.glGetUniformLocation(this.eZH, "uv_texture");
        this.gLy = GLES20.glGetUniformLocation(this.eZH, "uMatrix");
        this.eZM = com.tencent.mm.plugin.api.recordView.b.Vh();
        this.eZN = com.tencent.mm.plugin.api.recordView.b.Vh();
        this.eZi = ByteBuffer.allocateDirect(this.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZi.put(this.gLB);
        this.eZi.position(0);
        this.eZh = ByteBuffer.allocateDirect(eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZh.put(eZZ);
        this.eZh.position(0);
        ab.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(this.eZM), Integer.valueOf(this.eZN), this);
        AppMethodBeat.o(55316);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(55317);
        ab.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i), Integer.valueOf(i2), this);
        if (!(i == this.fcn && i2 == this.fco)) {
            ab.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.fcn = i;
            this.fco = i2;
        }
        AppMethodBeat.o(55317);
    }

    public final void onDrawFrame(GL10 gl10) {
        AppMethodBeat.i(55318);
        bo.yz();
        this.gLv = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.gLA) {
            ab.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.gLA = false;
            this.gLv = false;
            this.frameData = null;
            this.gLw = -1;
            this.gLx = -1;
            AppMethodBeat.o(55318);
            return;
        }
        if (!(this.eZH == 0 || this.eZM == -1 || this.eZN == -1 || this.gLw <= 0 || this.gLx <= 0 || this.frameData == null)) {
            GLES20.glUseProgram(this.eZH);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.eZM);
            GLES20.glTexImage2D(3553, 0, 6409, this.gLw, this.gLx, 0, 6409, GLType.GL_UNSIGNED_BYTE, this.eZU);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.eZR, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.eZN);
            GLES20.glTexImage2D(3553, 0, 6410, this.gLw / 2, this.gLx / 2, 0, 6410, GLType.GL_UNSIGNED_BYTE, this.eZV);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.eZS, 1);
            Matrix.setIdentityM(this.gLz, 0);
            Matrix.setRotateM(this.gLz, 0, (float) this.rotate, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.gLy, 1, false, this.gLz, 0);
            this.eZi.position(0);
            GLES20.glVertexAttribPointer(this.eZI, 2, 5126, false, 0, this.eZi);
            GLES20.glEnableVertexAttribArray(this.eZI);
            this.eZh.position(0);
            GLES20.glVertexAttribPointer(this.eZJ, 2, 5126, false, 0, this.eZh);
            GLES20.glEnableVertexAttribArray(this.eZJ);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.eZI);
            GLES20.glDisableVertexAttribArray(this.eZJ);
            GLES20.glBindTexture(3553, 0);
        }
        this.gLv = false;
        AppMethodBeat.o(55318);
    }
}
