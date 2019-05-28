package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ak;

@TargetApi(14)
public class ix extends TextureView implements SurfaceTextureListener, gg {
    private iz a;
    private SurfaceTexture b;
    private iy c;

    public ix(Context context, ak akVar) {
        super(context);
        AppMethodBeat.i(99892);
        this.a = new iz(this, getContext().getApplicationContext(), akVar);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(99892);
    }

    @TargetApi(16)
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(99893);
        if (this.b == null) {
            this.b = surfaceTexture;
        } else if (this.c != null) {
            this.b = surfaceTexture;
            this.c.a(surfaceTexture);
        }
        if (this.a != null) {
            this.a.a(null, null);
            this.a.a(null, i, i2);
        }
        if (this.c == null) {
            this.c = new iy(surfaceTexture, this.a);
            this.c.start();
        }
        AppMethodBeat.o(99893);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(99894);
        if (this.a != null) {
            this.a.a(null, i, i2);
            if (this.c != null) {
                this.c.d();
            }
        }
        AppMethodBeat.o(99894);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void a_() {
        AppMethodBeat.i(99895);
        if (this.c != null) {
            synchronized (this.c) {
                try {
                    this.c.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99895);
                }
            }
            return;
        }
        AppMethodBeat.o(99895);
    }

    public void e() {
        AppMethodBeat.i(99896);
        if (this.a != null) {
            this.a.e();
        }
        if (this.c != null) {
            this.c.b();
        }
        AppMethodBeat.o(99896);
    }

    public void f() {
        AppMethodBeat.i(99897);
        if (this.a != null) {
            this.a.f();
        }
        if (this.c != null) {
            this.c.a();
        }
        AppMethodBeat.o(99897);
    }

    public void g() {
        AppMethodBeat.i(99898);
        if (this.a != null) {
            this.a.g();
        }
        if (this.c != null) {
            this.c.c();
        }
        AppMethodBeat.o(99898);
    }

    public void setZOrderMediaOverlay(boolean z) {
    }

    public ge getVectorMapDelegate() {
        return this.a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99899);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(i, i2);
        }
        AppMethodBeat.o(99899);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(99900);
        if (this.a != null) {
            boolean a = this.a.a(motionEvent);
            AppMethodBeat.o(99900);
            return a;
        }
        AppMethodBeat.o(99900);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(99901);
        if (this.a == null || !this.a.b(motionEvent)) {
            boolean dispatchHoverEvent = super.dispatchHoverEvent(motionEvent);
            AppMethodBeat.o(99901);
            return dispatchHoverEvent;
        }
        AppMethodBeat.o(99901);
        return true;
    }
}
