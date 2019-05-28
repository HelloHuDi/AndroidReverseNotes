package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(17)
public class EglSurfaceBase {
    protected static final String TAG = GlUtil.TAG;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    protected EglCore mEglCore;
    private int mHeight = -1;
    private int mWidth = -1;

    protected EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    public void createWindowSurface(Object obj) {
        AppMethodBeat.m2504i(49972);
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            IllegalStateException illegalStateException = new IllegalStateException("surface already created");
            AppMethodBeat.m2505o(49972);
            throw illegalStateException;
        }
        this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
        AppMethodBeat.m2505o(49972);
    }

    public void createOffscreenSurface(int i, int i2) {
        AppMethodBeat.m2504i(49973);
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            IllegalStateException illegalStateException = new IllegalStateException("surface already created");
            AppMethodBeat.m2505o(49973);
            throw illegalStateException;
        }
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
        this.mWidth = i;
        this.mHeight = i2;
        AppMethodBeat.m2505o(49973);
    }

    public int getWidth() {
        AppMethodBeat.m2504i(49974);
        int querySurface;
        if (this.mWidth < 0) {
            querySurface = this.mEglCore.querySurface(this.mEGLSurface, 12375);
            AppMethodBeat.m2505o(49974);
            return querySurface;
        }
        querySurface = this.mWidth;
        AppMethodBeat.m2505o(49974);
        return querySurface;
    }

    public int getHeight() {
        AppMethodBeat.m2504i(49975);
        int querySurface;
        if (this.mHeight < 0) {
            querySurface = this.mEglCore.querySurface(this.mEGLSurface, 12374);
            AppMethodBeat.m2505o(49975);
            return querySurface;
        }
        querySurface = this.mHeight;
        AppMethodBeat.m2505o(49975);
        return querySurface;
    }

    public void releaseEglSurface() {
        AppMethodBeat.m2504i(49976);
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
        AppMethodBeat.m2505o(49976);
    }

    public void makeCurrent() {
        AppMethodBeat.m2504i(49977);
        this.mEglCore.makeCurrent(this.mEGLSurface);
        AppMethodBeat.m2505o(49977);
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        AppMethodBeat.m2504i(49978);
        this.mEglCore.makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
        AppMethodBeat.m2505o(49978);
    }

    public boolean swapBuffers() {
        AppMethodBeat.m2504i(49979);
        boolean swapBuffers = this.mEglCore.swapBuffers(this.mEGLSurface);
        AppMethodBeat.m2505o(49979);
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        AppMethodBeat.m2504i(49980);
        this.mEglCore.setPresentationTime(this.mEGLSurface, j);
        AppMethodBeat.m2505o(49980);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveFrame(File file) {
        Throwable th;
        AppMethodBeat.m2504i(49981);
        if (this.mEglCore.isCurrent(this.mEGLSurface)) {
            String file2 = file.toString();
            int width = getWidth();
            int height = getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect((width * height) * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocateDirect);
            GlUtil.checkGlError("glReadPixels");
            allocateDirect.rewind();
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    createBitmap.compress(CompressFormat.PNG, 90, bufferedOutputStream);
                    createBitmap.recycle();
                    bufferedOutputStream.close();
                    new StringBuilder("Saved ").append(width).append(VideoMaterialUtil.CRAZYFACE_X).append(height).append(" frame as '").append(file2).append("'");
                    AppMethodBeat.m2505o(49981);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(49981);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                AppMethodBeat.m2505o(49981);
                throw th;
            }
        }
        RuntimeException runtimeException = new RuntimeException("Expected EGL context/surface is not current");
        AppMethodBeat.m2505o(49981);
        throw runtimeException;
    }
}
