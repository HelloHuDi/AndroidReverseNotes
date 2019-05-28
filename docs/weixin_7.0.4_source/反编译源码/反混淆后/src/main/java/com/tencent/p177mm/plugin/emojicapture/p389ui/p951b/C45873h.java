package com.tencent.p177mm.plugin.emojicapture.p389ui.p951b;

import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p386d.C2954a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27808c.C20448a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.PTSegmentor;
import com.tencent.ttpic.PTSticker;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoTemplateParser;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.h */
public final class C45873h {
    private boolean eNa;
    private boolean eYS;
    private int eZM;
    private int eZN;
    private int eZO;
    private int eZP;
    private int eZQ;
    private int eZR;
    private int eZS;
    private int eZT;
    private ByteBuffer eZU;
    private ByteBuffer eZV;
    private FloatBuffer eZh;
    private FloatBuffer eZi;
    private float[] gLB;
    private int gLw;
    private int gLx;
    private float[] gLz;
    private int iZn;
    private int iZo;
    private int lpA;
    private int lpB;
    private int lpC;
    private int lpD;
    private int lpE;
    private int lpF;
    private int lpG;
    private int lpH;
    private int lpI;
    private int lpJ;
    private FloatBuffer lpK;
    private FloatBuffer lpL;
    private FloatBuffer lpM;
    private float[] lpN;
    private float[] lpO;
    private float[] lpP;
    private int lpQ;
    private int lpR;
    private int lpS;
    private C2954a lpT;
    private int lpU;
    private byte[] lpV;
    private IntBuffer lpW;
    private int lpu = C34006c.lht;
    private int lpv;
    private int lpw;
    private int lpx;
    private int lpy;
    private int lpz;
    private int rotate;

    public C45873h() {
        AppMethodBeat.m2504i(2560);
        C11617a c11617a = C34006c.lhw;
        c11617a = C34006c.lhw;
        this.lpv = C34006c.lht;
        this.gLz = new float[16];
        this.gLB = C27808c.eZY;
        this.lpO = C27808c.eZY;
        this.lpW = IntBuffer.allocate(this.lpu * this.lpv);
        this.eNa = false;
        AppMethodBeat.m2505o(2560);
    }

    public final void boi() {
        AppMethodBeat.m2504i(2561);
        if (this.eNa) {
            AppMethodBeat.m2505o(2561);
            return;
        }
        long yz = C5046bo.m7588yz();
        C20448a c20448a = C27808c.loN;
        this.eZO = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
        if (this.eZO == 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "checkInit, load yuvProgramId failed!");
        }
        this.eZQ = GLES20.glGetAttribLocation(this.eZO, "a_position");
        this.eZP = GLES20.glGetAttribLocation(this.eZO, "a_texCoord");
        this.eZR = GLES20.glGetUniformLocation(this.eZO, "y_texture");
        this.eZS = GLES20.glGetUniformLocation(this.eZO, "uv_texture");
        this.eZT = GLES20.glGetUniformLocation(this.eZO, "uMatrix");
        c20448a = C27808c.loN;
        this.eZM = C20448a.m31602Vh();
        c20448a = C27808c.loN;
        this.eZN = C20448a.m31602Vh();
        c20448a = C27808c.loN;
        this.lpB = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
        this.lpE = GLES20.glGetAttribLocation(this.lpB, "a_position");
        this.lpD = GLES20.glGetAttribLocation(this.lpB, "a_texCoord");
        this.lpH = GLES20.glGetUniformLocation(this.lpB, "size");
        this.lpI = GLES20.glGetUniformLocation(this.lpB, "radius");
        this.lpF = GLES20.glGetUniformLocation(this.lpB, "texture");
        this.lpG = GLES20.glGetUniformLocation(this.lpB, "uMatrix");
        this.lpJ = GLES20.glGetUniformLocation(this.lpB, "calcRoundCorner");
        c20448a = C27808c.loN;
        this.lpC = C20448a.m31602Vh();
        c20448a = C27808c.loN;
        this.lpw = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        if (this.lpw == 0) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "checkInit, load externalProgramId failed");
        }
        this.lpy = GLES20.glGetAttribLocation(this.lpw, "a_position");
        this.lpx = GLES20.glGetAttribLocation(this.lpw, "a_texCoord");
        this.lpz = GLES20.glGetUniformLocation(this.lpw, "texture");
        this.lpA = GLES20.glGetUniformLocation(this.lpw, "uMatrix");
        c20448a = C27808c.loN;
        this.lpS = C20448a.m31602Vh();
        float[] fArr = C27808c.eZY;
        this.gLB = Arrays.copyOf(fArr, fArr.length);
        this.eZi = ByteBuffer.allocateDirect(this.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZi.put(this.gLB);
        this.eZi.position(0);
        fArr = C27808c.eZZ;
        this.lpN = Arrays.copyOf(fArr, fArr.length);
        this.eZh = ByteBuffer.allocateDirect(C27808c.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.eZh.put(this.lpN);
        this.eZh.position(0);
        fArr = C27808c.eZZ;
        this.lpP = Arrays.copyOf(fArr, fArr.length);
        this.lpK = ByteBuffer.allocateDirect(this.lpP.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.lpK.put(this.lpP);
        this.lpK.position(0);
        fArr = C27808c.eZY;
        this.lpO = Arrays.copyOf(fArr, fArr.length);
        this.lpL = ByteBuffer.allocateDirect(this.lpO.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.lpL.put(this.lpO);
        this.lpL.position(0);
        c20448a = C27808c.loN;
        this.lpQ = C20448a.m31603Vi();
        c20448a = C27808c.loN;
        this.lpR = C20448a.m31603Vi();
        c20448a = C27808c.loN;
        this.lpU = C20448a.m31602Vh();
        if (this.lpT != null) {
            this.lpT.clear();
        }
        this.lpT = new C2954a();
        C2954a c2954a = this.lpT;
        int i = this.lpS;
        int i2 = this.lpU;
        try {
            C4990ab.m7417i("MicroMsg.EmojiFilterProcess", "initial %s, %d", c2954a, Long.valueOf(Thread.currentThread().getId()));
            c2954a.lhm.init();
            PTSegmentor.getInstance().init();
            c2954a.lhj.ApplyGLSLFilter(true, (float) c2954a.eYW, (float) c2954a.eYX);
            c2954a.mSwapCopyFilter.ApplyGLSLFilter(true, (float) c2954a.eYW, (float) c2954a.eYX);
            c2954a.lhh.ApplyGLSLFilter(true, (float) c2954a.eYW, (float) c2954a.eYX);
            c2954a.mSmoothBFilters.initial();
            c2954a.mSmoothBFilters.updateBlurAlpha(0.4f);
            c2954a.mBeautyFaceList.initial();
            c2954a.mBeautyParam.changeFaceMeshSet(1);
            c2954a.mBeautyTransformList.initial();
            c2954a.mCopyFilter.ApplyGLSLFilter(true, (float) c2954a.eYW, (float) c2954a.eYX);
            VideoFilterUtil.setRenderMode(c2954a.lhj, 1);
            VideoFilterUtil.setRenderMode(c2954a.lhh, 1);
            VideoFilterUtil.setRenderMode(c2954a.mCopyFilter, 1);
            c2954a.mBeautyTransformList.setRenderMode(1);
            c2954a.mBeautyFaceList.setRenderMode(1);
            c2954a.mSmoothBFilters.setRenderMode(1);
            c2954a.mRemodelFilter.setRenderMode(1);
            if (c2954a.mPTSticker != null) {
                c2954a.mPTSticker.setRenderMode(1);
            }
            int i3 = 50;
            int i4 = 20;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            if (C5047bp.dpL()) {
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
                i3 = sharedPreferences.getInt("skin", 50);
                i4 = sharedPreferences.getInt("shape", 20);
                i5 = sharedPreferences.getInt("faceV", 0);
                i6 = sharedPreferences.getInt("eye", 0);
                i7 = sharedPreferences.getInt("nose", 0);
                i8 = sharedPreferences.getInt("chin", 0);
            }
            c2954a.mo7161a(TYPE.BEAUTY, i3);
            c2954a.mo7161a(TYPE.BASIC3, i4);
            c2954a.mo7161a(TYPE.FACE_V, i5);
            c2954a.mo7161a(TYPE.EYE, i6);
            c2954a.mo7161a(TYPE.NOSE, i7);
            c2954a.mo7161a(TYPE.CHIN, i8);
            c2954a.eYQ = i;
            c2954a.lhn = i2;
            c20448a = C27808c.loN;
            c2954a.lhp = C20448a.m31603Vi();
            for (i8 = 0; i8 < c2954a.mSwapFrames.length; i8++) {
                c2954a.mSwapFrames[i8] = new C41672h();
            }
            C4990ab.m7411d("MicroMsg.EmojiFilterProcess", "initial end %s", c2954a);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "initial error", new Object[0]);
            C34007d c34007d = C34007d.lhz;
            C34007d.bmX();
        }
        this.eNa = true;
        C4990ab.m7417i("MicroMsg.FilterRenderer", "init cost %s", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(2561);
    }

    public final void updateSize(int i, int i2) {
        this.iZn = i;
        this.iZo = i2;
    }

    /* renamed from: a */
    public final void mo73691a(byte[] bArr, boolean z, int i, int i2, int i3) {
        AppMethodBeat.m2504i(2562);
        if (this.lpT == null) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "drawFrame, emojiFilterProcessTex is null!!");
            AppMethodBeat.m2505o(2562);
            return;
        }
        this.gLw = i;
        this.gLx = i2;
        this.eYS = z;
        this.rotate = i3;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (!(this.eZO == 0 || this.eZM == -1 || this.eZN == -1 || this.gLw <= 0 || this.gLx <= 0 || bArr == null || bArr.length != ((this.gLw * this.gLx) / 2) * 3)) {
            if (this.eZU == null || this.eZV == null || this.eZU.capacity() != this.gLx * this.gLw || this.eZV.capacity() != (this.gLw * this.gLx) / 2) {
                this.eZU = ByteBuffer.allocateDirect(this.gLx * this.gLw);
                this.eZV = ByteBuffer.allocateDirect((this.gLw * this.gLx) / 2);
                this.eZU.order(ByteOrder.nativeOrder());
                this.eZV.order(ByteOrder.nativeOrder());
            }
            this.eZU.position(0);
            this.eZU.put(bArr, 0, this.gLw * this.gLx);
            this.eZU.position(0);
            this.eZV.position(0);
            this.eZV.put(bArr, this.gLw * this.gLx, (this.gLw * this.gLx) / 2);
            this.eZV.position(0);
            int min = Math.min(this.gLw, this.gLx);
            C27808c.m44188y(this.lpQ, this.lpS, this.lpu, this.lpv);
            GLES20.glViewport(0, 0, this.lpu, this.lpv);
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
            if (this.rotate > 0) {
                Matrix.setRotateM(this.gLz, 0, (float) this.rotate, 0.0f, 0.0f, -1.0f);
                Matrix.scaleM(this.gLz, 0, -1.0f, 1.0f, 1.0f);
            }
            if (this.eYS) {
                Matrix.scaleM(this.gLz, 0, 1.0f, -1.0f, 1.0f);
            }
            GLES20.glUniformMatrix4fv(this.eZT, 1, false, this.gLz, 0);
            this.eZi.position(0);
            GLES20.glVertexAttribPointer(this.eZQ, 2, 5126, false, 0, this.eZi);
            GLES20.glEnableVertexAttribArray(this.eZQ);
            float f;
            float f2;
            if (this.rotate == 90 || this.rotate == 270) {
                f = (((float) (this.gLw - min)) / 2.0f) / ((float) this.gLw);
                f2 = 1.0f - f;
                this.lpN[0] = f;
                this.lpN[2] = f2;
                this.lpN[4] = f;
                this.lpN[6] = f2;
            } else {
                f = (((float) (this.gLx - min)) / 2.0f) / ((float) this.gLx);
                f2 = 1.0f - f;
                this.lpN[1] = f;
                this.lpN[3] = f2;
                this.lpN[5] = f;
                this.lpN[7] = f2;
            }
            this.eZh.put(this.lpN);
            this.eZh.position(0);
            GLES20.glVertexAttribPointer(this.eZP, 2, 5126, false, 0, this.eZh);
            GLES20.glEnableVertexAttribArray(this.eZP);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.eZQ);
            GLES20.glDisableVertexAttribArray(this.eZP);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glUseProgram(0);
        }
        this.lpT.mo7163ch(this.lpu, this.lpv);
        this.lpT.eYQ = this.lpS;
        try {
            this.lpT.bmD();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FilterRenderer", e, "filterProcess error: %s", e.getMessage());
        }
        m84987uH(this.lpU);
        C45873h.clearStatus();
        AppMethodBeat.m2505o(2562);
    }

    /* renamed from: b */
    public final void mo73692b(int i, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(2563);
        if (this.lpT == null) {
            C4990ab.m7412e("MicroMsg.FilterRenderer", "drawFrame, emojiFilterProcessTex is null!!");
            AppMethodBeat.m2505o(2563);
        } else if (i <= 0) {
            C4990ab.m7413e("MicroMsg.FilterRenderer", "drawFrame, externalTextureId error:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(2563);
        } else {
            this.gLw = i2;
            this.gLx = i3;
            this.eYS = z;
            this.rotate = i4;
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            if (this.lpB == 0 || this.gLw <= 0 || this.gLx <= 0) {
                C4990ab.m7417i("MicroMsg.FilterRenderer", "skip %s, %s, %s", Integer.valueOf(this.lpB), Integer.valueOf(this.gLw), Integer.valueOf(this.gLx));
            } else {
                int min = Math.min(this.gLw, this.gLx);
                C27808c.m44188y(this.lpQ, this.lpS, this.lpu, this.lpv);
                GLES20.glViewport(0, 0, this.lpu, this.lpv);
                GLES20.glUseProgram(this.lpw);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071.0f);
                GLES20.glUniform1i(this.lpz, 0);
                Matrix.setIdentityM(this.gLz, 0);
                if (this.rotate > 0) {
                    Matrix.setRotateM(this.gLz, 0, (float) this.rotate, 0.0f, 0.0f, -1.0f);
                    Matrix.scaleM(this.gLz, 0, -1.0f, this.eYS ? -1.0f : 1.0f, 1.0f);
                }
                GLES20.glUniformMatrix4fv(this.lpA, 1, false, this.gLz, 0);
                this.eZi.position(0);
                GLES20.glVertexAttribPointer(this.lpy, 2, 5126, false, 0, this.eZi);
                GLES20.glEnableVertexAttribArray(this.lpy);
                float f;
                float f2;
                if (this.rotate == 90 || this.rotate == 270) {
                    f = (((float) (this.gLw - min)) / 2.0f) / ((float) this.gLw);
                    f2 = 1.0f - f;
                    this.lpN[0] = f;
                    this.lpN[2] = f2;
                    this.lpN[4] = f;
                    this.lpN[6] = f2;
                } else {
                    f = (((float) (this.gLx - min)) / 2.0f) / ((float) this.gLx);
                    f2 = 1.0f - f;
                    this.lpN[1] = f;
                    this.lpN[3] = f2;
                    this.lpN[5] = f;
                    this.lpN[7] = f2;
                }
                this.eZh.put(this.lpN);
                this.eZh.position(0);
                GLES20.glVertexAttribPointer(this.lpx, 2, 5126, false, 0, this.eZh);
                GLES20.glEnableVertexAttribArray(this.lpx);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.lpy);
                GLES20.glDisableVertexAttribArray(this.lpx);
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glUseProgram(0);
                GLES20.glFinish();
            }
            this.lpT.mo7163ch(this.lpu, this.lpv);
            this.lpT.eYQ = this.lpS;
            try {
                this.lpT.bmD();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FilterRenderer", e, "filterProcess error: %s", e.getMessage());
            }
            m84987uH(this.lpU);
            C45873h.clearStatus();
            AppMethodBeat.m2505o(2563);
        }
    }

    /* renamed from: a */
    public final void mo73690a(C42971b c42971b) {
        VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector = null;
        AppMethodBeat.m2504i(2564);
        C2954a c2954a = this.lpT;
        if (c2954a.mPTSticker != null) {
            c2954a.mPTSticker.destroy();
        }
        if (c42971b == null) {
            c2954a.mPTSticker = null;
            C4990ab.m7416i("MicroMsg.EmojiFilterProcess", "changeSticker: null");
            AppMethodBeat.m2505o(2564);
            return;
        }
        c2954a.mPTSticker = null;
        C4990ab.m7417i("MicroMsg.EmojiFilterProcess", "changeSticker: %s", c42971b);
        String str = c42971b.lhL;
        PTFaceDetector pTFaceDetector = c2954a.lhm.xtP;
        if (pTFaceDetector != null) {
            videoPreviewFaceOutlineDetector = pTFaceDetector.getFaceDetector();
        }
        if (videoPreviewFaceOutlineDetector != null) {
            c2954a.mPTSticker = new PTSticker(str, videoPreviewFaceOutlineDetector);
            c2954a.mPTSticker.init();
        }
        if (!TextUtils.isEmpty(str)) {
            C4990ab.m7417i("MicroMsg.EmojiFilterProcess", "changeVideoFilter: %s", VideoTemplateParser.parseVideoMaterial(str).getTipsText());
        }
        AppMethodBeat.m2505o(2564);
    }

    public final int boj() {
        return this.lpU;
    }

    /* renamed from: uH */
    private void m84987uH(int i) {
        AppMethodBeat.m2504i(2565);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.lpM == null) {
            this.lpM = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        GLES20.glViewport(0, 0, this.iZn, this.iZo);
        GLES20.glUseProgram(this.lpB);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.lpF, 0);
        Matrix.setIdentityM(this.gLz, 0);
        GLES20.glUniformMatrix4fv(this.lpG, 1, false, this.gLz, 0);
        this.lpM.put((float) this.iZn);
        this.lpM.put((float) this.iZo);
        this.lpM.position(0);
        GLES20.glUniform2fv(this.lpH, 1, this.lpM);
        GLES20.glUniform1f(this.lpI, C34006c.m55705us(Math.max(this.iZn, this.iZo)));
        GLES20.glUniform1i(this.lpJ, 1);
        this.lpL.put(C27808c.eZY);
        this.lpL.position(0);
        GLES20.glVertexAttribPointer(this.lpE, 2, 5126, false, 0, this.lpL);
        GLES20.glEnableVertexAttribArray(this.lpE);
        this.lpK.put(C27808c.eZZ);
        this.lpK.position(0);
        GLES20.glVertexAttribPointer(this.lpD, 2, 5126, false, 0, this.lpK);
        GLES20.glEnableVertexAttribArray(this.lpD);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.lpE);
        GLES20.glDisableVertexAttribArray(this.lpD);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.m2505o(2565);
    }

    private static void clearStatus() {
        AppMethodBeat.m2504i(2566);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.m2505o(2566);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(2567);
        C4990ab.m7417i("MicroMsg.FilterRenderer", "destroy, init:%s", Boolean.valueOf(this.eNa));
        if (this.eNa) {
            if (this.lpT != null) {
                this.lpT.clear();
                this.lpT = null;
            }
            GLES20.glDeleteTextures(5, new int[]{this.eZM, this.eZN, this.lpC, this.lpS, this.lpU}, 0);
            GLES20.glDeleteFramebuffers(2, new int[]{this.lpQ, this.lpR}, 0);
            GLES20.glDeleteProgram(this.eZO);
            GLES20.glDeleteProgram(this.lpB);
            GLES20.glDeleteProgram(this.lpw);
            this.lpV = null;
            this.eNa = false;
            AppMethodBeat.m2505o(2567);
            return;
        }
        AppMethodBeat.m2505o(2567);
    }
}
