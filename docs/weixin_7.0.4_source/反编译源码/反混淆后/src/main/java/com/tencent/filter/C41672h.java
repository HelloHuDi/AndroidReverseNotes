package com.tencent.filter;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.C16371i;
import com.tencent.util.C36572f;
import com.tencent.view.C41106g;
import com.tencent.view.C44569b;

/* renamed from: com.tencent.filter.h */
public final class C41672h {
    public C41672h bJA;
    boolean bJy = false;
    public int[] bJz = new int[]{0};
    public int height;
    public boolean needReleaseFrmae = false;
    public int[] texture = new int[]{0};
    public int width;

    public C41672h() {
        AppMethodBeat.m2504i(86364);
        AppMethodBeat.m2505o(86364);
    }

    public C41672h(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(86365);
        this.texture[0] = i2;
        this.bJz[0] = i;
        this.width = i3;
        this.height = i4;
        AppMethodBeat.m2505o(86365);
    }

    public final int getTextureId() {
        return this.texture[0];
    }

    /* renamed from: wE */
    public final int mo67192wE() {
        return this.bJz[0];
    }

    /* renamed from: a */
    public final void mo67189a(int i, int i2, int i3, double d) {
        AppMethodBeat.m2504i(86366);
        C41106g.checkGlError("before glBindFramebuffer");
        if (i == 0) {
            GLES20.glBindFramebuffer(36160, 0);
            if (d <= 0.0d) {
                GLES20.glViewport(0, 0, i2, i3);
                AppMethodBeat.m2505o(86366);
                return;
            }
            double d2 = (double) i3;
            double d3 = ((double) i3) * d;
            if (((double) i2) > d3) {
                d3 = (double) i2;
                d2 = ((double) i2) / d;
            }
            GLES20.glViewport(((int) (-(d3 - ((double) i2)))) / 2, ((int) (-(d2 - ((double) i3)))) / 2, (int) d3, (int) d2);
            AppMethodBeat.m2505o(86366);
            return;
        }
        if (i == -2 && C44569b.AIH >= 0) {
            int nativeCheckMagicEngine = GLSLRender.nativeCheckMagicEngine(5, C44569b.AIH);
            C44569b.AIH = nativeCheckMagicEngine;
            if (nativeCheckMagicEngine >= 0) {
                GLSLRender.nativeBeginUseEglImage(i2, i3, C44569b.AIH);
                this.texture[0] = 0;
                AppMethodBeat.m2505o(86366);
                return;
            }
        }
        if (!((i <= 0 || this.texture[0] == i) && this.width == i2 && this.height == i3)) {
            if (this.bJz[0] != 0) {
                GLES20.glBindFramebuffer(36160, this.bJz[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
            }
            if (this.bJy && this.texture[0] != 0) {
                GLES20.glDeleteTextures(1, this.texture, 0);
            }
            this.texture[0] = 0;
        }
        this.width = i2;
        this.height = i3;
        if (this.bJz[0] <= 0) {
            GLES20.glGenFramebuffers(1, this.bJz, 0);
        }
        if (i > 0 && this.texture[0] != i) {
            this.bJy = false;
            this.texture[0] = i;
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.texture[0]);
            if (!C36572f.dSJ().mo58341aI(this.texture[0], this.width, this.height)) {
                C36572f.dSJ().mo58342aJ(this.texture[0], this.width, this.height);
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.width, this.height, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                C36572f.dSJ().mo58345ig(this.width, this.height);
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.bJz[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
            GLES20.glViewport(0, 0, this.width, this.height);
            C16371i.m25186k("Frame", "new frame buffer");
        } else if (this.texture[0] <= 0) {
            this.bJy = true;
            GLES20.glActiveTexture(33984);
            this.texture[0] = C36572f.dSJ().mo58344if(this.width, this.height);
            GLES20.glBindTexture(3553, this.texture[0]);
            if (!C36572f.dSJ().mo58341aI(this.texture[0], this.width, this.height)) {
                C36572f.dSJ().mo58342aJ(this.texture[0], this.width, this.height);
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.width, this.height, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                C36572f.dSJ().mo58345ig(this.width, this.height);
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.bJz[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
            GLES20.glViewport(0, 0, this.width, this.height);
            C16371i.m25186k("Frame", "new frame buffer auto");
        } else {
            GLES20.glBindFramebuffer(36160, this.bJz[0]);
            GLES20.glViewport(0, 0, this.width, this.height);
        }
        C41106g.checkGlError("glBindFramebuffer");
        AppMethodBeat.m2505o(86366);
    }

    public final void clear() {
        AppMethodBeat.m2504i(86367);
        if (this.bJz[0] != 0) {
            GLES20.glBindFramebuffer(36160, this.bJz[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
            GLES20.glDeleteFramebuffers(1, this.bJz, 0);
            this.bJz[0] = 0;
        }
        mo67193wF();
        if (this.bJA != null) {
            this.bJA.clear();
        }
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.m2505o(86367);
    }

    /* renamed from: wF */
    public final void mo67193wF() {
        AppMethodBeat.m2504i(86368);
        C16371i.m25186k("Frame", "frame clear");
        if (this.texture[0] != 0) {
            if (this.bJy) {
                C36572f.dSJ().mo58340Sh(this.texture[0]);
                C36572f.dSJ().mo58346ih(this.width, this.height);
            }
            this.texture[0] = 0;
        }
        AppMethodBeat.m2505o(86368);
    }
}
