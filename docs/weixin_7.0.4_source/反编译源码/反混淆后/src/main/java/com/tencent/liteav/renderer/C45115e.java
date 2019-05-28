package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C32143d;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.renderer.e */
public class C45115e extends C32147a implements SurfaceTextureListener {
    /* renamed from: a */
    private static final float[] f17826a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    /* renamed from: b */
    private SurfaceTexture f17827b;
    /* renamed from: c */
    protected TextureView f17828c;
    /* renamed from: d */
    protected C37375d f17829d;
    /* renamed from: e */
    protected int f17830e = 0;
    /* renamed from: f */
    protected int f17831f = 0;
    /* renamed from: g */
    protected int f17832g = 0;
    /* renamed from: h */
    protected int f17833h = 0;
    /* renamed from: i */
    protected volatile int f17834i = -1;
    /* renamed from: j */
    protected int f17835j = 0;
    /* renamed from: k */
    protected int f17836k = 0;
    /* renamed from: l */
    protected C8837f f17837l;
    /* renamed from: m */
    WeakReference<C0946a> f17838m;
    /* renamed from: n */
    private long f17839n;
    /* renamed from: o */
    private int f17840o = 800;
    /* renamed from: p */
    private C32143d f17841p;
    /* renamed from: q */
    private C0971h f17842q;
    /* renamed from: r */
    private Surface f17843r;
    /* renamed from: s */
    private int f17844s = 0;
    /* renamed from: t */
    private int f17845t;
    /* renamed from: u */
    private int[] f17846u;
    /* renamed from: v */
    private boolean f17847v = false;
    /* renamed from: w */
    private boolean f17848w = false;
    /* renamed from: x */
    private C17810a f17849x = new C17810a();

    /* renamed from: com.tencent.liteav.renderer.e$a */
    public static class C17810a {
        /* renamed from: a */
        public long f4269a;
        /* renamed from: b */
        public long f4270b;
        /* renamed from: c */
        public long f4271c;
        /* renamed from: d */
        public long f4272d;
        /* renamed from: e */
        public long f4273e;
        /* renamed from: f */
        public long f4274f;
        /* renamed from: g */
        public long f4275g;
        /* renamed from: h */
        public long f4276h;
        /* renamed from: i */
        public long f4277i;
        /* renamed from: j */
        public int f4278j;
        /* renamed from: k */
        public int f4279k;
    }

    /* renamed from: a */
    public void mo72905a(int i) {
        if (i > 0) {
            this.f17840o = i;
        }
    }

    public C45115e() {
        AppMethodBeat.m2504i(67273);
        AppMethodBeat.m2505o(67273);
    }

    /* renamed from: a */
    public void mo72910a(C8837f c8837f) {
        this.f17837l = c8837f;
    }

    /* renamed from: a */
    public void mo72909a(C0946a c0946a) {
        AppMethodBeat.m2504i(67274);
        this.f17838m = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67274);
    }

    /* renamed from: a */
    public void mo72908a(TextureView textureView) {
        AppMethodBeat.m2504i(67275);
        m82881b(textureView);
        AppMethodBeat.m2505o(67275);
    }

    /* renamed from: a */
    public void mo72907a(Surface surface) {
        AppMethodBeat.m2504i(67276);
        m82880b(surface);
        AppMethodBeat.m2505o(67276);
    }

    /* renamed from: a */
    public void mo60194a(long j, int i, int i2) {
        AppMethodBeat.m2504i(67277);
        mo60192a(i, i2);
        mo60198b();
        AppMethodBeat.m2505o(67277);
    }

    /* renamed from: a */
    public void mo72906a(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(67278);
        mo60192a(i, i2);
        mo60198b();
        AppMethodBeat.m2505o(67278);
    }

    /* renamed from: a */
    public void mo60193a(int i, int i2, int i3, boolean z, int i4) {
        AppMethodBeat.m2504i(67279);
        mo60192a(i2, i3);
        AppMethodBeat.m2505o(67279);
    }

    /* renamed from: i */
    public void mo72916i() {
        AppMethodBeat.m2504i(67280);
        this.f17848w = true;
        this.f17847v = false;
        mo72927q();
        AppMethodBeat.m2505o(67280);
    }

    /* renamed from: j */
    public void mo72917j() {
        AppMethodBeat.m2504i(67281);
        this.f17847v = false;
        this.f17848w = false;
        this.f17846u = null;
        if (this.f17834i == 1) {
            this.f17834i = -1;
            if (this.f17841p != null) {
                this.f17841p.mo52730a();
                this.f17841p = null;
            }
        }
        AppMethodBeat.m2505o(67281);
    }

    /* renamed from: b */
    public void mo72913b(int i, int i2) {
        AppMethodBeat.m2504i(67282);
        mo60192a(i, i2);
        AppMethodBeat.m2505o(67282);
    }

    /* renamed from: b */
    public void mo72912b(int i) {
        AppMethodBeat.m2504i(67283);
        this.f17845t = i;
        if (this.f17829d != null) {
            this.f17829d.mo60211a(i);
        }
        AppMethodBeat.m2505o(67283);
    }

    /* renamed from: c */
    public void mo72914c(int i) {
        AppMethodBeat.m2504i(67284);
        this.f17844s = i;
        if (this.f17829d != null) {
            this.f17829d.mo60215c(i);
        }
        AppMethodBeat.m2505o(67284);
    }

    /* renamed from: a */
    public SurfaceTexture mo60191a() {
        return null;
    }

    /* renamed from: k */
    public int mo72918k() {
        AppMethodBeat.m2504i(67285);
        int width;
        if (this.f17828c != null) {
            width = this.f17828c.getWidth();
            AppMethodBeat.m2505o(67285);
            return width;
        } else if (this.f17843r != null) {
            width = this.f17835j;
            AppMethodBeat.m2505o(67285);
            return width;
        } else {
            AppMethodBeat.m2505o(67285);
            return 0;
        }
    }

    /* renamed from: l */
    public int mo72919l() {
        AppMethodBeat.m2504i(67286);
        int height;
        if (this.f17828c != null) {
            height = this.f17828c.getHeight();
            AppMethodBeat.m2505o(67286);
            return height;
        } else if (this.f17843r != null) {
            height = this.f17836k;
            AppMethodBeat.m2505o(67286);
            return height;
        } else {
            AppMethodBeat.m2505o(67286);
            return 0;
        }
    }

    /* renamed from: m */
    public int mo72920m() {
        return this.f17832g;
    }

    /* renamed from: n */
    public int mo72921n() {
        return this.f17833h;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo60195a(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo60199b(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo60204g() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public void mo60205h() {
    }

    /* renamed from: b */
    private void m82881b(TextureView textureView) {
        int i = 0;
        AppMethodBeat.m2504i(67287);
        this.f17834i = 0;
        if ((this.f17828c == null && textureView != null) || !(this.f17828c == null || this.f17828c.equals(textureView))) {
            i = 1;
        }
        TXCLog.m15679w("TXCVideoRender", "play:vrender: set video view @old=" + this.f17828c + ",new=" + textureView);
        if (i != 0) {
            if (this.f17828c != null && this.f17827b == null) {
                mo60199b(this.f17828c.getSurfaceTexture());
            }
            this.f17828c = textureView;
            if (this.f17828c != null) {
                this.f17830e = this.f17828c.getWidth();
                this.f17831f = this.f17828c.getHeight();
                this.f17829d = new C37375d(this.f17828c);
                this.f17829d.mo60214b(this.f17832g, this.f17833h);
                this.f17829d.mo60212a(this.f17830e, this.f17831f);
                this.f17828c.setSurfaceTextureListener(this);
                if (this.f17827b != null) {
                    if (VERSION.SDK_INT >= 16 && this.f17828c.getSurfaceTexture() != this.f17827b) {
                        this.f17828c.setSurfaceTexture(this.f17827b);
                        AppMethodBeat.m2505o(67287);
                        return;
                    }
                } else if (this.f17828c.isAvailable()) {
                    mo60195a(this.f17828c.getSurfaceTexture());
                }
            }
        }
        AppMethodBeat.m2505o(67287);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo60192a(int i, int i2) {
        AppMethodBeat.m2504i(67288);
        if (!((this.f17832g == i && this.f17833h == i2) || (this.f17832g == i && this.f17833h == i2))) {
            this.f17832g = i;
            this.f17833h = i2;
            if (this.f17829d != null) {
                this.f17829d.mo60214b(this.f17832g, this.f17833h);
            }
        }
        AppMethodBeat.m2505o(67288);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(67289);
        TXCLog.m15679w("TXCVideoRender", "play:vrender: texture available @".concat(String.valueOf(surfaceTexture)));
        this.f17830e = i;
        this.f17831f = i2;
        if (this.f17829d != null) {
            this.f17829d.mo60212a(this.f17830e, this.f17831f);
        }
        if (this.f17827b != null) {
            if (VERSION.SDK_INT >= 16 && this.f17828c.getSurfaceTexture() != this.f17827b) {
                this.f17828c.setSurfaceTexture(this.f17827b);
            }
            this.f17827b = null;
            AppMethodBeat.m2505o(67289);
            return;
        }
        mo60195a(surfaceTexture);
        AppMethodBeat.m2505o(67289);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(67290);
        TXCLog.m15679w("TXCVideoRender", "play:vrender: texture size change new:" + i + "," + i2 + " old:" + this.f17830e + "," + this.f17831f);
        this.f17830e = i;
        this.f17831f = i2;
        if (this.f17829d != null) {
            this.f17829d.mo60212a(this.f17830e, this.f17831f);
        }
        AppMethodBeat.m2505o(67290);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67291);
        try {
            TXCLog.m15679w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.f17848w);
            if (this.f17848w) {
                this.f17827b = surfaceTexture;
            } else {
                this.f17849x.f4269a = 0;
                mo60199b(surfaceTexture);
            }
        } catch (Exception e) {
        }
        if (this.f17827b == null) {
            AppMethodBeat.m2505o(67291);
            return true;
        }
        AppMethodBeat.m2505o(67291);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: b */
    private void m82880b(Surface surface) {
        AppMethodBeat.m2504i(67292);
        this.f17834i = 1;
        this.f17843r = surface;
        mo60204g();
        AppMethodBeat.m2505o(67292);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: o */
    public void mo72922o() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: p */
    public void mo72926p() {
        AppMethodBeat.m2504i(67293);
        if (this.f17841p != null) {
            this.f17841p.mo52730a();
            this.f17841p = null;
        }
        if (this.f17842q != null) {
            this.f17842q.mo3904c();
            this.f17842q = null;
        }
        AppMethodBeat.m2505o(67293);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo72911a(EGLContext eGLContext, int i, float[] fArr, boolean z) {
        AppMethodBeat.m2504i(67294);
        if (this.f17834i == 1) {
            int[] a = m82876a(i, this.f17832g, this.f17833h, z);
            this.f17846u = a;
            int i2 = a[0];
            int i3 = a[1];
            int i4 = a[2];
            if (this.f17843r != null) {
                if (!(this.f17841p == null || this.f17841p.mo52735b() == this.f17843r)) {
                    this.f17841p.mo52730a();
                    this.f17841p = null;
                }
                if (this.f17841p == null && this.f17834i == 1) {
                    this.f17841p = new C32143d();
                    this.f17841p.mo52734a(eGLContext, this.f17843r);
                }
                if (this.f17841p != null && this.f17834i == 1) {
                    this.f17841p.mo52731a(i2, false, 0, this.f17835j, this.f17836k, i3, i4, false);
                    AppMethodBeat.m2505o(67294);
                    return;
                }
            } else if (this.f17841p != null) {
                this.f17841p.mo52730a();
                this.f17841p = null;
            }
        }
        AppMethodBeat.m2505o(67294);
    }

    /* renamed from: a */
    private int[] m82876a(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(67295);
        if (!(this.f17842q == null || this.f17842q.mo3900a() == z)) {
            this.f17842q.mo3904c();
            this.f17842q = null;
        }
        if (this.f17842q == null) {
            this.f17842q = new C0971h(Boolean.valueOf(z));
            this.f17842q.mo3901b();
        }
        if (!z) {
            this.f17842q.mo3899a(f17826a);
        }
        int i4 = this.f17835j;
        int i5 = this.f17836k;
        if (this.f17845t == 0) {
            this.f17842q.mo3897a(C0971h.f1145a);
        } else {
            this.f17842q.mo3897a(C0971h.f1146b);
        }
        this.f17842q.mo3902b(this.f17844s);
        this.f17842q.mo3903b(i2, i3);
        this.f17842q.mo3898a(i4, i5);
        int[] iArr = new int[]{this.f17842q.mo3906d(i), i4, i5};
        AppMethodBeat.m2505o(67295);
        return iArr;
    }

    /* renamed from: c */
    public void mo72915c(final int i, final int i2) {
        AppMethodBeat.m2504i(67296);
        if (!(i == this.f17835j && i2 == this.f17836k)) {
            if (this.f17841p == null || this.f17834i != 1 || this.f17846u == null) {
                this.f17835j = i;
                this.f17836k = i2;
            } else {
                this.f17841p.mo52733a(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(67305);
                        C45115e.this.f17835j = i;
                        C45115e.this.f17836k = i2;
                        C45115e.this.f17841p.mo52731a(C45115e.this.f17846u[0], false, 0, C45115e.this.f17835j, C45115e.this.f17836k, C45115e.this.f17846u[1], C45115e.this.f17846u[2], true);
                        AppMethodBeat.m2505o(67305);
                    }
                });
                AppMethodBeat.m2505o(67296);
                return;
            }
        }
        AppMethodBeat.m2505o(67296);
    }

    /* renamed from: q */
    public void mo72927q() {
        AppMethodBeat.m2504i(67297);
        this.f17849x.f4269a = 0;
        this.f17849x.f4270b = 0;
        this.f17849x.f4271c = 0;
        this.f17849x.f4272d = 0;
        this.f17849x.f4273e = 0;
        this.f17849x.f4274f = 0;
        this.f17849x.f4275g = 0;
        this.f17849x.f4276h = 0;
        this.f17849x.f4277i = 0;
        this.f17849x.f4278j = 0;
        this.f17849x.f4279k = 0;
        setStatusValue(6001, Long.valueOf(0));
        setStatusValue(6002, Double.valueOf(0.0d));
        setStatusValue(6003, Long.valueOf(0));
        setStatusValue(6005, Long.valueOf(0));
        setStatusValue(6006, Long.valueOf(0));
        setStatusValue(6004, Long.valueOf(0));
        AppMethodBeat.m2505o(67297);
    }

    /* renamed from: a */
    private long m82875a(long j) {
        AppMethodBeat.m2504i(67298);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (j > timeTick) {
            AppMethodBeat.m2505o(67298);
            return 0;
        }
        timeTick -= j;
        AppMethodBeat.m2505o(67298);
        return timeTick;
    }

    /* renamed from: b */
    private void mo60198b() {
        AppMethodBeat.m2504i(67299);
        if (!this.f17847v) {
            C17778b.m27745a(this.f17838m, this.f17839n, 2003, "渲染首个视频数据包(IDR)");
            setStatusValue(6001, Long.valueOf(TXCTimeUtil.getTimeTick()));
            this.f17847v = true;
        }
        C17810a c17810a = this.f17849x;
        c17810a.f4271c++;
        if (this.f17849x.f4269a == 0) {
            this.f17849x.f4269a = TXCTimeUtil.getTimeTick();
        } else {
            long timeTick = TXCTimeUtil.getTimeTick() - this.f17849x.f4269a;
            if (timeTick >= 1000) {
                setStatusValue(6002, Double.valueOf((((double) (this.f17849x.f4271c - this.f17849x.f4270b)) * 1000.0d) / ((double) timeTick)));
                this.f17849x.f4270b = this.f17849x.f4271c;
                C17810a c17810a2 = this.f17849x;
                c17810a2.f4269a = timeTick + c17810a2.f4269a;
            }
        }
        if (this.f17849x.f4272d != 0) {
            this.f17849x.f4277i = m82875a(this.f17849x.f4272d);
            if (this.f17849x.f4277i > 500) {
                c17810a = this.f17849x;
                c17810a.f4273e++;
                setStatusValue(6003, Long.valueOf(this.f17849x.f4273e));
                if (this.f17849x.f4277i > this.f17849x.f4276h) {
                    this.f17849x.f4276h = this.f17849x.f4277i;
                    setStatusValue(6005, Long.valueOf(this.f17849x.f4276h));
                }
                c17810a = this.f17849x;
                c17810a.f4275g += this.f17849x.f4277i;
                setStatusValue(6006, Long.valueOf(this.f17849x.f4275g));
                TXCLog.m15679w("TXCVideoRender", "render frame count:" + this.f17849x.f4271c + " block time:" + this.f17849x.f4277i + "> 500");
            }
            if (this.f17849x.f4277i > ((long) this.f17840o)) {
                TXCLog.m15679w("TXCVideoRender", "render frame count:" + this.f17849x.f4271c + " block time:" + this.f17849x.f4277i + "> " + this.f17840o);
            }
            if (this.f17849x.f4277i > 1000) {
                c17810a = this.f17849x;
                c17810a.f4274f++;
                setStatusValue(6004, Long.valueOf(this.f17849x.f4274f));
                TXCLog.m15679w("TXCVideoRender", "render frame count:" + this.f17849x.f4271c + " block time:" + this.f17849x.f4277i + "> 1000");
                C17778b.m27745a(this.f17838m, this.f17839n, (int) TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG, "当前视频播放出现卡顿" + this.f17849x.f4277i + "ms");
            }
        }
        this.f17849x.f4272d = TXCTimeUtil.getTimeTick();
        this.f17849x.f4279k = this.f17833h;
        this.f17849x.f4278j = this.f17832g;
        AppMethodBeat.m2505o(67299);
    }
}
