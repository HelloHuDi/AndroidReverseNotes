package com.tencent.luggage.i.a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;

public interface a {
    void a(e eVar);

    void onPluginDestroy(String str, int i);

    void onPluginReady(String str, int i, SurfaceTexture surfaceTexture);

    void onPluginTouch(String str, int i, MotionEvent motionEvent);

    e yp();
}
