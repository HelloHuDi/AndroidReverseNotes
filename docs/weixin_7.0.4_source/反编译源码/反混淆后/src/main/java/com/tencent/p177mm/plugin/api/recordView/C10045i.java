package com.tencent.p177mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.mm.plugin.api.recordView.i */
final class C10045i implements Renderer {
    static float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static float[] gLu = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    ByteBuffer buffer;
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
    FloatBuffer eZi;
    int eZj;
    int eZk;
    private int fcn = 0;
    private int fco = 0;
    boolean fdb;
    byte[] frameData = null;
    private boolean gLA = false;
    float[] gLB = eZY;
    private float[] gLC;
    int gLD;
    private boolean gLv = false;
    int gLw = 0;
    int gLx = 0;
    private int gLy;
    private float[] gLz = new float[16];
    int rotate = 0;

    /* renamed from: com.tencent.mm.plugin.api.recordView.i$a */
    public interface C10046a {
        void asB();

        ByteBuffer getBuffer();
    }

    public C10045i(int i, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.m2504i(76395);
        float[] fArr = eZZ;
        this.gLC = Arrays.copyOf(fArr, fArr.length);
        this.fdb = false;
        this.gLD = 0;
        this.eZj = 0;
        this.eZk = 0;
        this.buffer = null;
        this.eZj = C26715b.m42548Vh();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        if (iArr[0] == 0) {
            C4990ab.m7412e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
            i5 = 0;
        } else {
            i5 = iArr[0];
        }
        this.eZk = i5;
        GLES20.glBindFramebuffer(36160, this.eZk);
        GLES20.glBindTexture(3553, this.eZj);
        GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i, i2, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.eZj, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glViewport(0, 0, i3, i4);
        AppMethodBeat.m2505o(76395);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(76396);
        C4990ab.m7417i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", this);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.eZH = C26715b.m42547U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.eZH == 0) {
            C4990ab.m7412e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
        }
        this.eZI = GLES20.glGetAttribLocation(this.eZH, "a_position");
        this.eZJ = GLES20.glGetAttribLocation(this.eZH, "a_texCoord");
        this.eZR = GLES20.glGetUniformLocation(this.eZH, "y_texture");
        this.eZS = GLES20.glGetUniformLocation(this.eZH, "uv_texture");
        this.gLy = GLES20.glGetUniformLocation(this.eZH, "uMatrix");
        this.eZM = C26715b.m42548Vh();
        this.eZN = C26715b.m42548Vh();
        this.eZi = ByteBuffer.allocateDirect(this.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZi.put(this.gLB);
        this.eZi.position(0);
        this.eZh = ByteBuffer.allocateDirect(eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZh.put(eZZ);
        this.eZh.position(0);
        C4990ab.m7417i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(this.eZM), Integer.valueOf(this.eZN), this);
        AppMethodBeat.m2505o(76396);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(76397);
        C4990ab.m7417i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i), Integer.valueOf(i2), this);
        if (!(i == this.fcn && i2 == this.fco)) {
            C4990ab.m7416i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.fcn = i;
            this.fco = i2;
            float f = (((float) this.fcn) / ((float) this.fco)) / 2.0f;
            gLu = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
        }
        AppMethodBeat.m2505o(76397);
    }

    public final void onDrawFrame(GL10 gl10) {
        AppMethodBeat.m2504i(76398);
        if (this.buffer == null) {
            AppMethodBeat.m2505o(76398);
            return;
        }
        C5046bo.m7588yz();
        this.gLv = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.gLA) {
            C4990ab.m7416i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
            this.gLA = false;
            this.gLv = false;
            this.frameData = null;
            this.gLw = -1;
            this.gLx = -1;
            AppMethodBeat.m2505o(76398);
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
            int i = this.rotate;
            Matrix.setRotateM(this.gLz, 0, (float) i, 0.0f, 0.0f, -1.0f);
            if (i == 90 || i == 270) {
                Matrix.scaleM(this.gLz, 0, -1.0f, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.gLz, 0, 1.0f, -1.0f, 1.0f);
            }
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
        long yz = C5046bo.m7588yz();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.fcn, this.fco, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.buffer);
        C4990ab.m7411d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(76398);
    }
}
