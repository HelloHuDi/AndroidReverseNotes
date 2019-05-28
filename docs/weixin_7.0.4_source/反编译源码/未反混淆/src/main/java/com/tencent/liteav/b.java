package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.e.l;
import com.tencent.liteav.basic.e.m;
import com.tencent.liteav.basic.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class b implements a, m, k {
    WeakReference<a> a;
    private Context b;
    private com.tencent.liteav.capturer.a c;
    private l d;
    private boolean e;
    private f f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private l k;
    private boolean l;

    public b(Context context, f fVar, l lVar) {
        AppMethodBeat.i(67655);
        this.c = null;
        this.g = 0;
        this.h = false;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.l = false;
        this.c = new com.tencent.liteav.capturer.a();
        try {
            this.f = (f) fVar.clone();
        } catch (CloneNotSupportedException e) {
            this.f = new f();
        }
        this.b = context;
        this.k = lVar;
        this.k.setSurfaceTextureListener(this);
        AppMethodBeat.o(67655);
    }

    public void a() {
        AppMethodBeat.i(67656);
        this.k.a(this.f.h);
        c(this.k.getSurfaceTexture());
        AppMethodBeat.o(67656);
    }

    public void a(boolean z) {
        AppMethodBeat.i(67657);
        c();
        this.k.a();
        AppMethodBeat.o(67657);
    }

    public void b() {
        AppMethodBeat.i(67658);
        c(this.k.getSurfaceTexture());
        AppMethodBeat.o(67658);
    }

    public void c() {
        AppMethodBeat.i(67659);
        this.c.b();
        this.e = false;
        AppMethodBeat.o(67659);
    }

    public void b(boolean z) {
        AppMethodBeat.i(67660);
        if (this.e && this.c != null) {
            f fVar = this.f;
            boolean z2 = z ? !this.f.m : this.f.m;
            fVar.m = z2;
            this.c.b();
            this.k.a(false);
            this.c.a(g());
            this.c.a(this.k.getSurfaceTexture());
            if (this.c.c(this.f.m) == 0) {
                this.e = true;
                a(1003, "打开摄像头成功");
            } else {
                this.e = false;
                a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
            }
            this.l = false;
        }
        AppMethodBeat.o(67660);
    }

    public boolean d() {
        return this.e;
    }

    public int e() {
        AppMethodBeat.i(67661);
        int a = this.c.a();
        AppMethodBeat.o(67661);
        return a;
    }

    public boolean a(int i) {
        AppMethodBeat.i(67662);
        boolean c = this.c.c(i);
        AppMethodBeat.o(67662);
        return c;
    }

    public void a(float f) {
        AppMethodBeat.i(67663);
        this.c.a(f);
        AppMethodBeat.o(67663);
    }

    public void b(int i) {
        AppMethodBeat.i(67664);
        this.i = i;
        h();
        AppMethodBeat.o(67664);
    }

    public void a(l lVar) {
        this.d = lVar;
    }

    public void c(final boolean z) {
        AppMethodBeat.i(67665);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66823);
                b.this.f.L = z;
                AppMethodBeat.o(66823);
            }
        });
        AppMethodBeat.o(67665);
    }

    public boolean d(boolean z) {
        AppMethodBeat.i(67666);
        boolean a = this.c.a(z);
        AppMethodBeat.o(67666);
        return a;
    }

    public void a(c cVar) {
        AppMethodBeat.i(67667);
        if (this.k != null) {
            this.k.a(cVar.a, cVar.h, this.g, cVar.d, cVar.e);
        }
        AppMethodBeat.o(67667);
    }

    public void e(boolean z) {
        this.h = z;
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(67668);
        this.k.a(runnable);
        AppMethodBeat.o(67668);
    }

    public EGLContext f() {
        AppMethodBeat.i(67669);
        EGLContext gLContext = this.k.getGLContext();
        AppMethodBeat.o(67669);
        return gLContext;
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.i(67670);
        com.tencent.liteav.basic.util.b.a(this.a, i, bundle);
        AppMethodBeat.o(67670);
    }

    public void a(a aVar) {
        AppMethodBeat.i(67671);
        this.a = new WeakReference(aVar);
        AppMethodBeat.o(67671);
    }

    public void c(int i) {
        AppMethodBeat.i(67672);
        this.j = i;
        h();
        AppMethodBeat.o(67672);
    }

    public void a(int i, int i2) {
        this.f.a = i;
        this.f.b = i2;
    }

    public void d(int i) {
        AppMethodBeat.i(67673);
        this.f.k = i;
        this.f.a();
        AppMethodBeat.o(67673);
    }

    public void a(float f, float f2) {
        AppMethodBeat.i(67674);
        if (this.c != null && this.f.D) {
            this.c.a(f, f2);
        }
        AppMethodBeat.o(67674);
    }

    private void c(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67675);
        if (!(surfaceTexture == null || this.e || this.c == null)) {
            this.c.a(surfaceTexture);
            this.c.b(this.f.h);
            this.c.d(this.f.l);
            this.c.b(this.f.D);
            this.c.a(g());
            if (this.c.c(this.f.m) == 0) {
                this.e = true;
                a(1003, "打开摄像头成功");
                this.l = false;
                if (this.h && !com.tencent.liteav.audio.b.a().c()) {
                    com.tencent.liteav.audio.b.a().a(this.b);
                    this.h = false;
                    AppMethodBeat.o(67675);
                    return;
                }
            }
            this.e = false;
            a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
        }
        AppMethodBeat.o(67675);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(67676);
        com.tencent.liteav.basic.util.b.a(this.a, i, str);
        AppMethodBeat.o(67676);
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67677);
        c(surfaceTexture);
        if (this.d != null) {
            this.d.a(surfaceTexture);
        }
        AppMethodBeat.o(67677);
    }

    public void b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67678);
        if (this.d != null) {
            this.d.r();
        }
        AppMethodBeat.o(67678);
    }

    public int a(int i, float[] fArr) {
        boolean z = true;
        AppMethodBeat.i(67679);
        if (this.e) {
            if (!this.l) {
                com.tencent.liteav.basic.util.b.a(this.a, 1007, "首帧画面采集完成");
                this.l = true;
            }
            if (this.d != null) {
                c cVar = new c();
                cVar.d = this.c.e();
                cVar.e = this.c.f();
                cVar.f = this.f.a;
                cVar.g = this.f.b;
                cVar.i = this.c.c();
                if (!this.c.d()) {
                    z = this.f.L;
                } else if (this.f.L) {
                    z = false;
                }
                cVar.h = z;
                cVar.a = i;
                cVar.c = fArr;
                cVar.j = this.g;
                cVar.b = 4;
                if (cVar.i == 0 || cVar.i == 180) {
                    cVar.f = this.f.b;
                    cVar.g = this.f.a;
                } else {
                    cVar.f = this.f.a;
                    cVar.g = this.f.b;
                }
                cVar.k = com.tencent.liteav.basic.util.b.a(cVar.d, cVar.e, this.f.b, this.f.a);
                this.d.b(cVar);
            }
            AppMethodBeat.o(67679);
        } else {
            AppMethodBeat.o(67679);
        }
        return 0;
    }

    private int g() {
        if (this.f.M) {
            return 7;
        }
        switch (this.f.k) {
            case 0:
                return 4;
            case 1:
                return 5;
            case 2:
                return 6;
            case 6:
                return 3;
            default:
                return 7;
        }
    }

    private void h() {
        AppMethodBeat.i(67680);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67089);
                if (b.this.i != -1) {
                    b.this.g = b.this.i;
                    b.this.i = -1;
                }
                if (b.this.j != -1) {
                    b.this.f.l = b.this.j;
                    b.this.c.d(b.this.f.l);
                    b.this.j = -1;
                }
                AppMethodBeat.o(67089);
            }
        });
        AppMethodBeat.o(67680);
    }
}
