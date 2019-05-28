package com.tencent.p177mm.plugin.voip.video.p1045a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.view.C41106g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.mm.plugin.voip.video.a.b */
public final class C46325b {
    public static final float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] tbQ = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public volatile boolean eNa = false;
    private boolean eYS;
    public int eZM;
    public int eZN;
    public int eZO;
    public int eZP;
    public int eZQ;
    public int eZR;
    public int eZS;
    public int eZT;
    private ByteBuffer eZU;
    private ByteBuffer eZV;
    public FloatBuffer eZh;
    public FloatBuffer eZi;
    public float[] gLB = eZY;
    private int gLw;
    private int gLx;
    private float[] gLz = new float[16];
    private int iZn;
    private int iZo;
    public int lpC;
    public int lpD;
    public int lpE;
    public int lpF;
    public int lpG;
    public FloatBuffer lpK;
    public FloatBuffer lpL;
    public float[] lpO = eZY;
    public float[] lpP;
    public int lpQ;
    public int lpR;
    public int lpS;
    public int lpU;
    public byte[] lpV;
    private int rotate;
    public byte[] sWh;
    public int tbR;
    private ByteBuffer tbS;
    private int tbT;
    private int tbU;
    public volatile C43737a tbV = new C43737a();
    private boolean tbW = false;

    public C46325b() {
        AppMethodBeat.m2504i(5125);
        AppMethodBeat.m2505o(5125);
    }

    public final void updateSize(int i, int i2) {
        this.iZn = i;
        this.iZo = i2;
    }

    /* renamed from: c */
    public final synchronized void mo74527c(byte[] bArr, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(5126);
        Object obj;
        if (this.gLw == i && this.gLx == i2) {
            obj = null;
        } else {
            obj = 1;
        }
        this.gLw = i;
        this.gLx = i2;
        int i5 = (i3 >> 2) & 3;
        if (i5 == 3) {
            this.rotate = 270;
        } else if (i5 == 1) {
            this.rotate = 90;
        }
        this.eYS = ((i3 >> 4) & 1) == 1;
        this.tbW = OpenGlRender.taQ != 1;
        if (this.tbV == null && i4 != 0) {
            this.tbV = new C43737a();
            this.tbV.initial(this.lpS, this.lpU);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.tbW) {
            if (!(this.eZO == 0 || this.eZM == -1 || this.eZN == -1 || this.gLw <= 0 || this.gLx <= 0 || bArr == null)) {
                if (this.eZU == null || this.eZV == null || this.eZU.capacity() != this.gLx * this.gLw || this.eZV.capacity() != (this.gLw * this.gLx) / 2) {
                    this.eZU = ByteBuffer.allocateDirect(this.gLx * this.gLw);
                    this.eZV = ByteBuffer.allocateDirect((this.gLw * this.gLx) / 2);
                    this.eZU.order(ByteOrder.nativeOrder());
                    this.eZV.order(ByteOrder.nativeOrder());
                }
                this.eZU.put(bArr, 0, this.gLw * this.gLx);
                this.eZU.position(0);
                this.eZV.put(bArr, this.gLw * this.gLx, (this.gLw * this.gLx) / 2);
                this.eZV.position(0);
                GLES20.glBindFramebuffer(36160, this.lpQ);
                GLES20.glBindTexture(3553, this.lpS);
                this.tbT = this.gLw;
                this.tbU = this.gLx;
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.tbT, this.tbU, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.lpS, 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glViewport(0, 0, this.tbT, this.tbU);
                GLES20.glUseProgram(this.eZO);
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
                if (this.eYS) {
                    Matrix.scaleM(this.gLz, 0, -1.0f, 1.0f, 1.0f);
                } else {
                    Matrix.scaleM(this.gLz, 0, 1.0f, 1.0f, 1.0f);
                }
                GLES20.glUniformMatrix4fv(this.eZT, 1, false, this.gLz, 0);
                this.eZi.position(0);
                GLES20.glVertexAttribPointer(this.eZQ, 2, 5126, false, 0, this.eZi);
                GLES20.glEnableVertexAttribArray(this.eZQ);
                this.eZh.position(0);
                GLES20.glVertexAttribPointer(this.eZP, 2, 5126, false, 0, this.eZh);
                GLES20.glEnableVertexAttribArray(this.eZP);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.eZQ);
                GLES20.glDisableVertexAttribArray(this.eZP);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glUseProgram(0);
                GLES20.glFinish();
            }
        } else if (!(this.tbR == 0 || this.lpS == -1 || this.gLw <= 0 || this.gLx <= 0 || bArr == null)) {
            if (this.tbS == null || this.tbS.capacity() != (this.gLx * this.gLw) * 4) {
                this.tbS = ByteBuffer.allocateDirect((this.gLx * this.gLw) * 4);
                this.tbS.order(ByteOrder.nativeOrder());
            }
            this.tbS.put(bArr, 0, (this.gLw * this.gLx) * 4);
            this.tbS.position(0);
            GLES20.glBindFramebuffer(36160, this.lpQ);
            GLES20.glBindTexture(3553, this.lpS);
            i5 = (this.rotate == 180 || this.rotate == 0) ? this.gLw : this.gLx;
            this.tbT = i5;
            i5 = (this.rotate == 180 || this.rotate == 0) ? this.gLx : this.gLw;
            this.tbU = i5;
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.tbT, this.tbU, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glBindTexture(3553, 0);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.lpS, 0);
            GLES20.glUseProgram(this.tbR);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.lpC);
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.tbT, this.tbU, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.tbS);
            GLES20.glUniform1i(this.lpF, 0);
            Matrix.setIdentityM(this.gLz, 0);
            Matrix.setRotateM(this.gLz, 0, (float) this.rotate, 0.0f, 0.0f, -1.0f);
            if (this.eYS) {
                Matrix.scaleM(this.gLz, 0, 1.0f, -1.0f, 1.0f);
            }
            GLES20.glUniformMatrix4fv(this.lpG, 1, false, this.gLz, 0);
            this.eZi.position(0);
            GLES20.glVertexAttribPointer(this.lpE, 2, 5126, false, 0, this.eZi);
            GLES20.glEnableVertexAttribArray(this.lpE);
            this.eZh.position(0);
            GLES20.glVertexAttribPointer(this.lpD, 2, 5126, false, 0, this.eZh);
            GLES20.glEnableVertexAttribArray(this.lpD);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.lpE);
            GLES20.glDisableVertexAttribArray(this.lpD);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        if (i4 != 0 && (this.lpV == null || obj != null)) {
            C4990ab.m7417i("MicroMsg.FilterRenderer", "%s frameSizeChange %s %s %s %s", Integer.valueOf(hashCode()), Integer.valueOf(this.tbT), Integer.valueOf(this.tbU), Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
            this.lpV = new byte[((this.tbT * this.tbU) * 4)];
            this.tbV.lho = this.lpV;
        }
        int i6;
        int i7;
        float f;
        int i8;
        int i9;
        float f2;
        float f3;
        float f4;
        if (i4 != 0) {
            Object obj2;
            C43737a c43737a = this.tbV;
            int i10 = this.tbT;
            int i11 = this.tbU;
            c43737a.eYW = i10;
            c43737a.eYX = i11;
            C43737a c43737a2 = this.tbV;
            if ((i4 & 4) != 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (!(obj2 == null || c43737a2.mPTFilter == null)) {
                BenchUtil.benchStart("PTFilter");
                BenchUtil.benchEnd("PTFilter");
                C4990ab.m7411d(C43737a.TAG, "%s mFilterOutTex: %s", Integer.valueOf(c43737a2.hashCode()), Integer.valueOf(c43737a2.tbK));
            }
            if (!(c43737a2.tbH == null || c43737a2.tbJ == 0 || c43737a2.tbO == 0)) {
                C41106g.m71540a(c43737a2.tbJ, c43737a2.eYW, c43737a2.eYX, c43737a2.lho, c43737a2.tbO);
            }
            byte[] bArr2 = this.tbV.lho;
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            if (this.tbR != 0 && this.tbT > 0 && this.tbU > 0 && bArr2 != null) {
                if (this.tbS == null || this.tbS.capacity() != (this.tbT * this.tbU) * 4) {
                    this.tbS = ByteBuffer.allocateDirect((this.tbT * this.tbU) * 4);
                    this.tbS.order(ByteOrder.nativeOrder());
                }
                this.tbS.put(bArr2, 0, bArr2.length);
                this.tbS.position(0);
                GLES20.glViewport(0, 0, this.iZn, this.iZo);
                GLES20.glUseProgram(this.tbR);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.lpC);
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.tbT, this.tbU, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.tbS);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glUniform1i(this.lpF, 0);
                i6 = (this.rotate == 0 || this.rotate == 180) ? this.tbT : this.tbU;
                i7 = (this.rotate == 0 || this.rotate == 180) ? this.tbU : this.tbT;
                if (((float) i6) / ((float) i7) < ((float) this.iZn) / ((float) this.iZo)) {
                    f = ((float) this.iZn) / ((float) i6);
                } else {
                    f = ((float) this.iZo) / ((float) i7);
                }
                i8 = (int) (((float) this.iZn) / f);
                i9 = (int) (((float) this.iZo) / f);
                Matrix.setIdentityM(this.gLz, 0);
                if (this.rotate > 0) {
                    Matrix.setRotateM(this.gLz, 0, (float) Math.abs(this.rotate - 180), 0.0f, 0.0f, -1.0f);
                }
                GLES20.glUniformMatrix4fv(this.lpG, 1, false, this.gLz, 0);
                this.lpL.put(this.lpO);
                this.lpL.position(0);
                GLES20.glVertexAttribPointer(this.lpE, 2, 5126, false, 0, this.lpL);
                GLES20.glEnableVertexAttribArray(this.lpE);
                f = (((float) (i6 - i8)) / 2.0f) / ((float) i6);
                f2 = 1.0f - f;
                f3 = (((float) (i7 - i9)) / 2.0f) / ((float) i7);
                f4 = 1.0f - f3;
                this.lpP[0] = f3;
                this.lpP[1] = f;
                this.lpP[2] = f4;
                this.lpP[3] = f;
                this.lpP[4] = f3;
                this.lpP[5] = f2;
                this.lpP[6] = f4;
                this.lpP[7] = f2;
                this.lpK.put(this.lpP);
                this.lpK.position(0);
                GLES20.glVertexAttribPointer(this.lpD, 2, 5126, false, 0, this.lpK);
                GLES20.glEnableVertexAttribArray(this.lpD);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.lpE);
                GLES20.glDisableVertexAttribArray(this.lpD);
                GLES20.glBindTexture(3553, 0);
                GLES20.glUseProgram(0);
            }
        } else {
            i5 = this.lpS;
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.iZn, this.iZo);
            GLES20.glUseProgram(this.tbR);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i5);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.lpF, 0);
            i6 = (this.rotate == 0 || this.rotate == 180) ? this.tbT : this.tbU;
            i7 = (this.rotate == 0 || this.rotate == 180) ? this.tbU : this.tbT;
            if (((float) i6) / ((float) i7) < ((float) this.iZn) / ((float) this.iZo)) {
                f = ((float) this.iZn) / ((float) i6);
            } else {
                f = ((float) this.iZo) / ((float) i7);
            }
            i8 = (int) (((float) this.iZn) / f);
            i9 = (int) (((float) this.iZo) / f);
            Matrix.setIdentityM(this.gLz, 0);
            if (this.rotate > 0) {
                Matrix.setRotateM(this.gLz, 0, (float) Math.abs(this.rotate - 180), 0.0f, 0.0f, -1.0f);
            }
            GLES20.glUniformMatrix4fv(this.lpG, 1, false, this.gLz, 0);
            this.lpL.put(this.lpO);
            this.lpL.position(0);
            GLES20.glVertexAttribPointer(this.lpE, 2, 5126, false, 0, this.lpL);
            GLES20.glEnableVertexAttribArray(this.lpE);
            f = (((float) (i6 - i8)) / 2.0f) / ((float) i6);
            f2 = 1.0f - f;
            f3 = (((float) (i7 - i9)) / 2.0f) / ((float) i7);
            f4 = 1.0f - f3;
            this.lpP[0] = f3;
            this.lpP[1] = f;
            this.lpP[2] = f4;
            this.lpP[3] = f;
            this.lpP[4] = f3;
            this.lpP[5] = f2;
            this.lpP[6] = f4;
            this.lpP[7] = f2;
            this.lpK.put(this.lpP);
            this.lpK.position(0);
            GLES20.glVertexAttribPointer(this.lpD, 2, 5126, false, 0, this.lpK);
            GLES20.glEnableVertexAttribArray(this.lpD);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.lpE);
            GLES20.glDisableVertexAttribArray(this.lpD);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.m2505o(5126);
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(5127);
        C4990ab.m7411d("MicroMsg.FilterRenderer", "%s reset", Integer.valueOf(hashCode()));
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        if (this.tbV != null) {
            this.tbV.clear();
            this.tbV = null;
        }
        this.lpV = null;
        AppMethodBeat.m2505o(5127);
    }

    public final synchronized void destroy() {
        AppMethodBeat.m2504i(5128);
        if (this.eNa) {
            C4990ab.m7417i("MicroMsg.FilterRenderer", "%s do destroy", Integer.valueOf(hashCode()));
            if (this.tbV != null) {
                this.tbV.clear();
                this.tbV = null;
            }
            GLES20.glDeleteTextures(5, new int[]{this.eZM, this.eZN, this.lpC, this.lpS, this.lpU}, 0);
            GLES20.glDeleteFramebuffers(2, new int[]{this.lpQ, this.lpR}, 0);
            GLES20.glDeleteProgram(this.eZO);
            GLES20.glDeleteProgram(this.tbR);
            this.lpV = null;
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glFinish();
            if (this.eZU != null) {
                this.eZU.clear();
            }
            if (this.eZV != null) {
                this.eZV.clear();
            }
            this.eZU = null;
            this.eZV = null;
            this.eNa = false;
            AppMethodBeat.m2505o(5128);
        } else {
            AppMethodBeat.m2505o(5128);
        }
    }

    /* renamed from: Vh */
    public static int m87012Vh() {
        AppMethodBeat.m2504i(5129);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        int i = iArr[0];
        AppMethodBeat.m2505o(5129);
        return i;
    }

    /* renamed from: M */
    private static int m87010M(String str, int i) {
        AppMethodBeat.m2504i(5130);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            C4990ab.m7412e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.m2505o(5130);
            return 0;
        }
        AppMethodBeat.m2505o(5130);
        return glCreateShader;
    }

    /* renamed from: U */
    public static int m87011U(String str, String str2) {
        AppMethodBeat.m2504i(5131);
        int[] iArr = new int[1];
        int M = C46325b.m87010M(str, 35633);
        if (M == 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "load vertex shader failed");
            AppMethodBeat.m2505o(5131);
            return 0;
        }
        int M2 = C46325b.m87010M(str2, 35632);
        if (M2 == 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "load fragment shader failed");
            AppMethodBeat.m2505o(5131);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, M);
        GLES20.glAttachShader(glCreateProgram, M2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "link program failed");
            AppMethodBeat.m2505o(5131);
            return 0;
        }
        GLES20.glDeleteShader(M);
        GLES20.glDeleteShader(M2);
        AppMethodBeat.m2505o(5131);
        return glCreateProgram;
    }

    /* renamed from: Vi */
    public static int m87013Vi() {
        AppMethodBeat.m2504i(5132);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        if (iArr[0] == 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "gen frame buffer error");
            AppMethodBeat.m2505o(5132);
            return 0;
        }
        int i = iArr[0];
        AppMethodBeat.m2505o(5132);
        return i;
    }

    public final byte[] cLS() {
        AppMethodBeat.m2504i(5133);
        if (this.tbV == null || this.tbV.lho == null) {
            AppMethodBeat.m2505o(5133);
            return null;
        }
        if (this.sWh == null || this.sWh.length != this.tbV.lho.length) {
            this.sWh = new byte[this.tbV.lho.length];
        }
        System.arraycopy(this.tbV.lho, 0, this.sWh, 0, this.tbV.lho.length);
        byte[] bArr = this.sWh;
        AppMethodBeat.m2505o(5133);
        return bArr;
    }
}
