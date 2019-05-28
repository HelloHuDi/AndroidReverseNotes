package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C44480ak;

@TargetApi(14)
/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ix */
public class C31059ix extends TextureView implements SurfaceTextureListener, C44514gg {
    /* renamed from: a */
    private C31061iz f14168a;
    /* renamed from: b */
    private SurfaceTexture f14169b;
    /* renamed from: c */
    private C31060iy f14170c;

    public C31059ix(Context context, C44480ak c44480ak) {
        super(context);
        AppMethodBeat.m2504i(99892);
        this.f14168a = new C31061iz(this, getContext().getApplicationContext(), c44480ak);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(99892);
    }

    @TargetApi(16)
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(99893);
        if (this.f14169b == null) {
            this.f14169b = surfaceTexture;
        } else if (this.f14170c != null) {
            this.f14169b = surfaceTexture;
            this.f14170c.mo50403a(surfaceTexture);
        }
        if (this.f14168a != null) {
            this.f14168a.mo12500a(null, null);
            this.f14168a.mo12499a(null, i, i2);
        }
        if (this.f14170c == null) {
            this.f14170c = new C31060iy(surfaceTexture, this.f14168a);
            this.f14170c.start();
        }
        AppMethodBeat.m2505o(99893);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(99894);
        if (this.f14168a != null) {
            this.f14168a.mo12499a(null, i, i2);
            if (this.f14170c != null) {
                this.f14170c.mo50406d();
            }
        }
        AppMethodBeat.m2505o(99894);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: a_ */
    public void mo12502a_() {
        AppMethodBeat.m2504i(99895);
        if (this.f14170c != null) {
            synchronized (this.f14170c) {
                try {
                    this.f14170c.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99895);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(99895);
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(99896);
        if (this.f14168a != null) {
            this.f14168a.mo12505e();
        }
        if (this.f14170c != null) {
            this.f14170c.mo50404b();
        }
        AppMethodBeat.m2505o(99896);
    }

    /* renamed from: f */
    public void mo12506f() {
        AppMethodBeat.m2504i(99897);
        if (this.f14168a != null) {
            this.f14168a.mo12506f();
        }
        if (this.f14170c != null) {
            this.f14170c.mo50402a();
        }
        AppMethodBeat.m2505o(99897);
    }

    /* renamed from: g */
    public void mo12507g() {
        AppMethodBeat.m2504i(99898);
        if (this.f14168a != null) {
            this.f14168a.mo12507g();
        }
        if (this.f14170c != null) {
            this.f14170c.mo50405c();
        }
        AppMethodBeat.m2505o(99898);
    }

    public void setZOrderMediaOverlay(boolean z) {
    }

    public C41052ge getVectorMapDelegate() {
        return this.f14168a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99899);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f14168a != null) {
            this.f14168a.mo50433a(i, i2);
        }
        AppMethodBeat.m2505o(99899);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99900);
        if (this.f14168a != null) {
            boolean a = this.f14168a.mo50453a(motionEvent);
            AppMethodBeat.m2505o(99900);
            return a;
        }
        AppMethodBeat.m2505o(99900);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99901);
        if (this.f14168a == null || !this.f14168a.mo50462b(motionEvent)) {
            boolean dispatchHoverEvent = super.dispatchHoverEvent(motionEvent);
            AppMethodBeat.m2505o(99901);
            return dispatchHoverEvent;
        }
        AppMethodBeat.m2505o(99901);
        return true;
    }
}
