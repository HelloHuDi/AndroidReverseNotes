package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.e.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class e extends com.tencent.liteav.basic.module.a implements SurfaceTextureListener {
    private static final float[] a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private SurfaceTexture b;
    protected TextureView c;
    protected d d;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 0;
    protected volatile int i = -1;
    protected int j = 0;
    protected int k = 0;
    protected f l;
    WeakReference<com.tencent.liteav.basic.d.a> m;
    private long n;
    private int o = 800;
    private d p;
    private h q;
    private Surface r;
    private int s = 0;
    private int t;
    private int[] u;
    private boolean v = false;
    private boolean w = false;
    private a x = new a();

    public static class a {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public int j;
        public int k;
    }

    public void a(int i) {
        if (i > 0) {
            this.o = i;
        }
    }

    public e() {
        AppMethodBeat.i(67273);
        AppMethodBeat.o(67273);
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(67274);
        this.m = new WeakReference(aVar);
        AppMethodBeat.o(67274);
    }

    public void a(TextureView textureView) {
        AppMethodBeat.i(67275);
        b(textureView);
        AppMethodBeat.o(67275);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(67276);
        b(surface);
        AppMethodBeat.o(67276);
    }

    public void a(long j, int i, int i2) {
        AppMethodBeat.i(67277);
        a(i, i2);
        b();
        AppMethodBeat.o(67277);
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(67278);
        a(i, i2);
        b();
        AppMethodBeat.o(67278);
    }

    public void a(int i, int i2, int i3, boolean z, int i4) {
        AppMethodBeat.i(67279);
        a(i2, i3);
        AppMethodBeat.o(67279);
    }

    public void i() {
        AppMethodBeat.i(67280);
        this.w = true;
        this.v = false;
        q();
        AppMethodBeat.o(67280);
    }

    public void j() {
        AppMethodBeat.i(67281);
        this.v = false;
        this.w = false;
        this.u = null;
        if (this.i == 1) {
            this.i = -1;
            if (this.p != null) {
                this.p.a();
                this.p = null;
            }
        }
        AppMethodBeat.o(67281);
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(67282);
        a(i, i2);
        AppMethodBeat.o(67282);
    }

    public void b(int i) {
        AppMethodBeat.i(67283);
        this.t = i;
        if (this.d != null) {
            this.d.a(i);
        }
        AppMethodBeat.o(67283);
    }

    public void c(int i) {
        AppMethodBeat.i(67284);
        this.s = i;
        if (this.d != null) {
            this.d.c(i);
        }
        AppMethodBeat.o(67284);
    }

    public SurfaceTexture a() {
        return null;
    }

    public int k() {
        AppMethodBeat.i(67285);
        int width;
        if (this.c != null) {
            width = this.c.getWidth();
            AppMethodBeat.o(67285);
            return width;
        } else if (this.r != null) {
            width = this.j;
            AppMethodBeat.o(67285);
            return width;
        } else {
            AppMethodBeat.o(67285);
            return 0;
        }
    }

    public int l() {
        AppMethodBeat.i(67286);
        int height;
        if (this.c != null) {
            height = this.c.getHeight();
            AppMethodBeat.o(67286);
            return height;
        } else if (this.r != null) {
            height = this.k;
            AppMethodBeat.o(67286);
            return height;
        } else {
            AppMethodBeat.o(67286);
            return 0;
        }
    }

    public int m() {
        return this.g;
    }

    public int n() {
        return this.h;
    }

    /* Access modifiers changed, original: protected */
    public void a(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    public void b(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    public void g() {
    }

    /* Access modifiers changed, original: protected */
    public void h() {
    }

    private void b(TextureView textureView) {
        int i = 0;
        AppMethodBeat.i(67287);
        this.i = 0;
        if ((this.c == null && textureView != null) || !(this.c == null || this.c.equals(textureView))) {
            i = 1;
        }
        TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.c + ",new=" + textureView);
        if (i != 0) {
            if (this.c != null && this.b == null) {
                b(this.c.getSurfaceTexture());
            }
            this.c = textureView;
            if (this.c != null) {
                this.e = this.c.getWidth();
                this.f = this.c.getHeight();
                this.d = new d(this.c);
                this.d.b(this.g, this.h);
                this.d.a(this.e, this.f);
                this.c.setSurfaceTextureListener(this);
                if (this.b != null) {
                    if (VERSION.SDK_INT >= 16 && this.c.getSurfaceTexture() != this.b) {
                        this.c.setSurfaceTexture(this.b);
                        AppMethodBeat.o(67287);
                        return;
                    }
                } else if (this.c.isAvailable()) {
                    a(this.c.getSurfaceTexture());
                }
            }
        }
        AppMethodBeat.o(67287);
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, int i2) {
        AppMethodBeat.i(67288);
        if (!((this.g == i && this.h == i2) || (this.g == i && this.h == i2))) {
            this.g = i;
            this.h = i2;
            if (this.d != null) {
                this.d.b(this.g, this.h);
            }
        }
        AppMethodBeat.o(67288);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(67289);
        TXCLog.w("TXCVideoRender", "play:vrender: texture available @".concat(String.valueOf(surfaceTexture)));
        this.e = i;
        this.f = i2;
        if (this.d != null) {
            this.d.a(this.e, this.f);
        }
        if (this.b != null) {
            if (VERSION.SDK_INT >= 16 && this.c.getSurfaceTexture() != this.b) {
                this.c.setSurfaceTexture(this.b);
            }
            this.b = null;
            AppMethodBeat.o(67289);
            return;
        }
        a(surfaceTexture);
        AppMethodBeat.o(67289);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(67290);
        TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + i + "," + i2 + " old:" + this.e + "," + this.f);
        this.e = i;
        this.f = i2;
        if (this.d != null) {
            this.d.a(this.e, this.f);
        }
        AppMethodBeat.o(67290);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67291);
        try {
            TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.w);
            if (this.w) {
                this.b = surfaceTexture;
            } else {
                this.x.a = 0;
                b(surfaceTexture);
            }
        } catch (Exception e) {
        }
        if (this.b == null) {
            AppMethodBeat.o(67291);
            return true;
        }
        AppMethodBeat.o(67291);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void b(Surface surface) {
        AppMethodBeat.i(67292);
        this.i = 1;
        this.r = surface;
        g();
        AppMethodBeat.o(67292);
    }

    /* Access modifiers changed, original: protected */
    public void o() {
    }

    /* Access modifiers changed, original: protected */
    public void p() {
        AppMethodBeat.i(67293);
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        if (this.q != null) {
            this.q.c();
            this.q = null;
        }
        AppMethodBeat.o(67293);
    }

    /* Access modifiers changed, original: protected */
    public void a(EGLContext eGLContext, int i, float[] fArr, boolean z) {
        AppMethodBeat.i(67294);
        if (this.i == 1) {
            int[] a = a(i, this.g, this.h, z);
            this.u = a;
            int i2 = a[0];
            int i3 = a[1];
            int i4 = a[2];
            if (this.r != null) {
                if (!(this.p == null || this.p.b() == this.r)) {
                    this.p.a();
                    this.p = null;
                }
                if (this.p == null && this.i == 1) {
                    this.p = new d();
                    this.p.a(eGLContext, this.r);
                }
                if (this.p != null && this.i == 1) {
                    this.p.a(i2, false, 0, this.j, this.k, i3, i4, false);
                    AppMethodBeat.o(67294);
                    return;
                }
            } else if (this.p != null) {
                this.p.a();
                this.p = null;
            }
        }
        AppMethodBeat.o(67294);
    }

    private int[] a(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(67295);
        if (!(this.q == null || this.q.a() == z)) {
            this.q.c();
            this.q = null;
        }
        if (this.q == null) {
            this.q = new h(Boolean.valueOf(z));
            this.q.b();
        }
        if (!z) {
            this.q.a(a);
        }
        int i4 = this.j;
        int i5 = this.k;
        if (this.t == 0) {
            this.q.a(h.a);
        } else {
            this.q.a(h.b);
        }
        this.q.b(this.s);
        this.q.b(i2, i3);
        this.q.a(i4, i5);
        int[] iArr = new int[]{this.q.d(i), i4, i5};
        AppMethodBeat.o(67295);
        return iArr;
    }

    public void c(final int i, final int i2) {
        AppMethodBeat.i(67296);
        if (!(i == this.j && i2 == this.k)) {
            if (this.p == null || this.i != 1 || this.u == null) {
                this.j = i;
                this.k = i2;
            } else {
                this.p.a(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(67305);
                        e.this.j = i;
                        e.this.k = i2;
                        e.this.p.a(e.this.u[0], false, 0, e.this.j, e.this.k, e.this.u[1], e.this.u[2], true);
                        AppMethodBeat.o(67305);
                    }
                });
                AppMethodBeat.o(67296);
                return;
            }
        }
        AppMethodBeat.o(67296);
    }

    public void q() {
        AppMethodBeat.i(67297);
        this.x.a = 0;
        this.x.b = 0;
        this.x.c = 0;
        this.x.d = 0;
        this.x.e = 0;
        this.x.f = 0;
        this.x.g = 0;
        this.x.h = 0;
        this.x.i = 0;
        this.x.j = 0;
        this.x.k = 0;
        setStatusValue(6001, Long.valueOf(0));
        setStatusValue(6002, Double.valueOf(0.0d));
        setStatusValue(6003, Long.valueOf(0));
        setStatusValue(6005, Long.valueOf(0));
        setStatusValue(6006, Long.valueOf(0));
        setStatusValue(6004, Long.valueOf(0));
        AppMethodBeat.o(67297);
    }

    private long a(long j) {
        AppMethodBeat.i(67298);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (j > timeTick) {
            AppMethodBeat.o(67298);
            return 0;
        }
        timeTick -= j;
        AppMethodBeat.o(67298);
        return timeTick;
    }

    private void b() {
        AppMethodBeat.i(67299);
        if (!this.v) {
            b.a(this.m, this.n, 2003, "渲染首个视频数据包(IDR)");
            setStatusValue(6001, Long.valueOf(TXCTimeUtil.getTimeTick()));
            this.v = true;
        }
        a aVar = this.x;
        aVar.c++;
        if (this.x.a == 0) {
            this.x.a = TXCTimeUtil.getTimeTick();
        } else {
            long timeTick = TXCTimeUtil.getTimeTick() - this.x.a;
            if (timeTick >= 1000) {
                setStatusValue(6002, Double.valueOf((((double) (this.x.c - this.x.b)) * 1000.0d) / ((double) timeTick)));
                this.x.b = this.x.c;
                a aVar2 = this.x;
                aVar2.a = timeTick + aVar2.a;
            }
        }
        if (this.x.d != 0) {
            this.x.i = a(this.x.d);
            if (this.x.i > 500) {
                aVar = this.x;
                aVar.e++;
                setStatusValue(6003, Long.valueOf(this.x.e));
                if (this.x.i > this.x.h) {
                    this.x.h = this.x.i;
                    setStatusValue(6005, Long.valueOf(this.x.h));
                }
                aVar = this.x;
                aVar.g += this.x.i;
                setStatusValue(6006, Long.valueOf(this.x.g));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.x.c + " block time:" + this.x.i + "> 500");
            }
            if (this.x.i > ((long) this.o)) {
                TXCLog.w("TXCVideoRender", "render frame count:" + this.x.c + " block time:" + this.x.i + "> " + this.o);
            }
            if (this.x.i > 1000) {
                aVar = this.x;
                aVar.f++;
                setStatusValue(6004, Long.valueOf(this.x.f));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.x.c + " block time:" + this.x.i + "> 1000");
                b.a(this.m, this.n, (int) TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG, "当前视频播放出现卡顿" + this.x.i + "ms");
            }
        }
        this.x.d = TXCTimeUtil.getTimeTick();
        this.x.k = this.h;
        this.x.j = this.g;
        AppMethodBeat.o(67299);
    }
}
