package com.tencent.liteav.basic.e;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.egl.EGLContext;

public interface l {
    void a();

    void a(int i);

    void a(int i, boolean z, int i2, int i3, int i4);

    void a(Runnable runnable);

    void a(boolean z);

    EGLContext getGLContext();

    SurfaceTexture getSurfaceTexture();

    void setSurfaceTextureListener(m mVar);
}
