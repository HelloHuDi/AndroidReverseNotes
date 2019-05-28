package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PtvFilterOpenglFrameBuffer {
    public static final boolean DEBUG_ON = true;
    private int[] mFrameBufferId = new int[1];
    private boolean mNeedDepth;
    private boolean mNeedStencil;
    private int[] mRenderBufferDepth = new int[1];
    private int[] mRenderBufferStencil = new int[1];
    private int[] mStatusCheck = new int[1];
    private int mVideoHeight;
    private int mVideoWidth;

    public PtvFilterOpenglFrameBuffer() {
        AppMethodBeat.m2504i(83241);
        AppMethodBeat.m2505o(83241);
    }

    private void initReanderBuffer() {
        AppMethodBeat.m2504i(83242);
        if (this.mNeedDepth) {
            GLES20.glGenRenderbuffers(1, this.mRenderBufferDepth, 0);
            checkErrorCode("glGenRenderbuffers");
            GLES20.glBindRenderbuffer(36161, this.mRenderBufferDepth[0]);
            checkErrorCode("glBindRenderbuffer:0");
            GLES20.glRenderbufferStorage(36161, 33189, this.mVideoWidth, this.mVideoHeight);
            checkErrorCode("glRenderbufferStorage:0");
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mRenderBufferDepth[0]);
            checkErrorCode("glFramebufferRenderbuffer:0");
        }
        if (this.mNeedStencil) {
            GLES20.glGenRenderbuffers(1, this.mRenderBufferStencil, 0);
            checkErrorCode("glGenRenderbuffers");
            GLES20.glBindRenderbuffer(36161, this.mRenderBufferStencil[0]);
            checkErrorCode("glBindRenderbuffer:0");
            GLES20.glRenderbufferStorage(36161, 36168, this.mVideoWidth, this.mVideoHeight);
            GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, this.mRenderBufferStencil[0]);
        }
        AppMethodBeat.m2505o(83242);
    }

    public void initSharedTextureMemory(int i, int i2, int i3) {
        AppMethodBeat.m2504i(83243);
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
        GLES20.glBindTexture(3553, i);
        checkErrorCode("glBindTexture");
        GLES20.glTexParameteri(3553, 10240, 9728);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(3553, 10241, 9728);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(3553, 10242, 33071);
        checkErrorCode("glTexParameteri");
        GLES20.glTexParameteri(3553, 10243, 33071);
        checkErrorCode("glTexParameteri");
        GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.mVideoWidth, this.mVideoHeight, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
        checkErrorCode("glTexImage2D");
        GLES20.glBindTexture(3553, 0);
        checkErrorCode("glBindTexture");
        AppMethodBeat.m2505o(83243);
    }

    public boolean initFrameBuffer(boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(83244);
        this.mNeedDepth = z;
        this.mNeedStencil = z2;
        checkErrorCode("glIsTexture");
        GLES20.glGenFramebuffers(1, this.mFrameBufferId, 0);
        checkErrorCode("glGenFramebuffers");
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
        checkErrorCode("glBindFramebuffer");
        initReanderBuffer();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkErrorCode("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            checkErrorCode("glCheckFramebufferStatus: status=".concat(String.valueOf(glCheckFramebufferStatus)));
            AppMethodBeat.m2505o(83244);
            return false;
        }
        makeCurrentFrameBuffer();
        AppMethodBeat.m2505o(83244);
        return true;
    }

    public void makeCurrentFrameBuffer() {
        AppMethodBeat.m2504i(83245);
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
        GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
        GLLogMsg("[makeCurrentFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0] + " mFrameBufferId[0]=" + this.mFrameBufferId[0]);
        checkErrorCode("glBindFramebuffer: [makeCurrentFrameBuffer]mFrameBufferId=" + this.mFrameBufferId[0]);
        AppMethodBeat.m2505o(83245);
    }

    public void restoreToWindFrameBuffer() {
        AppMethodBeat.m2504i(83246);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
        GLLogMsg("[restoreToWindFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0]);
        checkErrorCode("glBindFramebuffer: [restoreToWindFrameBuffer]mFrameBufferId=0");
        AppMethodBeat.m2505o(83246);
    }

    public void release() {
        AppMethodBeat.m2504i(83247);
        restoreToWindFrameBuffer();
        if (this.mNeedDepth) {
            GLES20.glDeleteRenderbuffers(1, this.mRenderBufferDepth, 0);
        }
        if (this.mNeedStencil) {
            GLES20.glDeleteRenderbuffers(1, this.mRenderBufferStencil, 0);
        }
        GLES20.glDeleteFramebuffers(1, this.mFrameBufferId, 0);
        this.mFrameBufferId[0] = 0;
        this.mRenderBufferDepth[0] = 0;
        this.mRenderBufferStencil[0] = 0;
        AppMethodBeat.m2505o(83247);
    }

    public static void checkErrorCode(String str) {
        AppMethodBeat.m2504i(83248);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            GLLogMsg("checkErrorCode: errFunc =" + str + "err=" + glGetError);
        }
        AppMethodBeat.m2505o(83248);
    }

    public static void GLLogMsg(String str) {
    }
}
