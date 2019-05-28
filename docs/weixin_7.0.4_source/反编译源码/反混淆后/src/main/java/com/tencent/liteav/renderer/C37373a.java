package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.renderer.a */
public class C37373a extends C45115e implements OnFrameAvailableListener {
    /* renamed from: a */
    C25672g f15985a;
    /* renamed from: b */
    C8836a f15986b;
    /* renamed from: n */
    private final int f15987n = 0;
    /* renamed from: o */
    private final int f15988o = 0;
    /* renamed from: p */
    private final int f15989p = 0;
    /* renamed from: q */
    private final int f15990q = 0;
    /* renamed from: r */
    private C37374b f15991r;
    /* renamed from: s */
    private SurfaceTexture f15992s;
    /* renamed from: t */
    private C45114c f15993t;
    /* renamed from: u */
    private boolean f15994u;
    /* renamed from: v */
    private float[] f15995v = new float[16];
    /* renamed from: w */
    private C45114c f15996w;
    /* renamed from: x */
    private ArrayList<Long> f15997x = new ArrayList();
    /* renamed from: y */
    private TXCYuvTextureRender f15998y;
    /* renamed from: z */
    private final Queue<Runnable> f15999z = new LinkedList();

    /* renamed from: com.tencent.liteav.renderer.a$a */
    public interface C8836a {
        /* renamed from: d */
        void mo19968d(int i);
    }

    public C37373a() {
        AppMethodBeat.m2504i(67153);
        AppMethodBeat.m2505o(67153);
    }

    /* renamed from: a */
    public void mo60197a(C25672g c25672g) {
        this.f15985a = c25672g;
    }

    /* renamed from: a */
    public void mo60196a(C8836a c8836a) {
        AppMethodBeat.m2504i(67154);
        this.f15986b = c8836a;
        if (!(c8836a == null || this.f15998y == null)) {
            this.f15998y.setHasFrameBuffer(this.f17832g, this.f17833h);
        }
        AppMethodBeat.m2505o(67154);
    }

    /* renamed from: a */
    public void mo60194a(long j, int i, int i2) {
        AppMethodBeat.m2504i(67155);
        synchronized (this) {
            try {
                this.f15997x.add(Long.valueOf(j));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67155);
            }
        }
        super.mo60194a(j, i, i2);
    }

    /* renamed from: a */
    public void mo60193a(int i, int i2, int i3, boolean z, int i4) {
        AppMethodBeat.m2504i(67156);
        GLES20.glViewport(0, 0, mo72918k(), mo72919l());
        if (this.f15996w != null) {
            this.f15996w.mo72900a(i, z, i4);
        }
        super.mo60193a(i, i2, i3, z, i4);
        AppMethodBeat.m2505o(67156);
    }

    /* renamed from: a */
    public SurfaceTexture mo60191a() {
        return this.f15992s;
    }

    /* renamed from: b */
    public EGLContext mo60198b() {
        AppMethodBeat.m2504i(67157);
        if (this.f15991r != null) {
            EGLContext a = this.f15991r.mo60208a();
            AppMethodBeat.m2505o(67157);
            return a;
        }
        AppMethodBeat.m2505o(67157);
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo60195a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67158);
        mo60204g();
        AppMethodBeat.m2505o(67158);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo60199b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67159);
        mo60205h();
        AppMethodBeat.m2505o(67159);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo60192a(int i, int i2) {
        AppMethodBeat.m2504i(67160);
        super.mo60192a(i, i2);
        if (this.f15998y != null) {
            this.f15998y.setVideoSize(i, i2);
        }
        if (this.f15993t != null) {
            this.f15993t.mo72899a(i, i2);
        }
        AppMethodBeat.m2505o(67160);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo60200c() {
        AppMethodBeat.m2504i(67161);
        m62915r();
        if (this.f17829d != null) {
            this.f17829d.mo60212a(this.f17830e, this.f17831f);
            this.f17829d.mo60214b(this.f17832g, this.f17833h);
        }
        if (this.f15993t != null) {
            this.f15993t.mo72903b();
            this.f15992s = new SurfaceTexture(this.f15993t.mo72898a());
            this.f15992s.setOnFrameAvailableListener(this);
        }
        if (this.f15998y != null) {
            this.f15998y.createTexture();
        }
        if (!(this.f15986b == null || this.f15998y == null)) {
            this.f15998y.setHasFrameBuffer(this.f17832g, this.f17833h);
        }
        if (this.f15996w != null) {
            this.f15996w.mo72903b();
        }
        if (this.f17837l != null) {
            this.f17837l.mo19969a(this.f15992s);
        }
        AppMethodBeat.m2505o(67161);
    }

    /* renamed from: r */
    private void m62915r() {
        AppMethodBeat.m2504i(67162);
        this.f15993t = new C45114c(true);
        this.f15998y = new TXCYuvTextureRender();
        this.f15996w = new C45114c(false);
        AppMethodBeat.m2505o(67162);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo60201d() {
        AppMethodBeat.m2504i(67163);
        try {
            if (this.f17837l != null) {
                this.f17837l.mo19970b(this.f15992s);
            }
        } catch (Exception e) {
        }
        if (this.f15993t != null) {
            this.f15993t.mo72904c();
            this.f15993t = null;
        }
        if (this.f15998y != null) {
            this.f15998y.onSurfaceDestroy();
            this.f15998y = null;
        }
        if (this.f15996w != null) {
            this.f15996w.mo72904c();
            this.f15996w = null;
        }
        AppMethodBeat.m2505o(67163);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public boolean mo60202e() {
        AppMethodBeat.m2504i(67164);
        do {
        } while (m62914a(this.f15999z));
        boolean s = m62916s();
        AppMethodBeat.m2505o(67164);
        return s;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public SurfaceTexture mo60203f() {
        AppMethodBeat.m2504i(67165);
        if (this.f17828c != null) {
            SurfaceTexture surfaceTexture = this.f17828c.getSurfaceTexture();
            AppMethodBeat.m2505o(67165);
            return surfaceTexture;
        }
        AppMethodBeat.m2505o(67165);
        return null;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo60204g() {
        AppMethodBeat.m2504i(67166);
        if (this.f15991r == null) {
            this.f15991r = new C37374b(new WeakReference(this));
            this.f15991r.start();
            TXCLog.m15679w("TXCVideoRender", "play:vrender: start render thread");
            AppMethodBeat.m2505o(67166);
            return;
        }
        TXCLog.m15679w("TXCVideoRender", "play:vrender: render thread is running");
        AppMethodBeat.m2505o(67166);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public void mo60205h() {
        AppMethodBeat.m2504i(67167);
        if (this.f15991r != null) {
            this.f15991r.mo60209b();
            this.f15991r = null;
            TXCLog.m15679w("TXCVideoRender", "play:vrender: quit render thread");
        }
        this.f15992s = null;
        AppMethodBeat.m2505o(67167);
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code skipped:
            android.opengl.GLES20.glViewport(0, 0, mo72918k(), mo72919l());
     */
    /* JADX WARNING: Missing block: B:8:0x0022, code skipped:
            if (r0 == false) goto L_0x0098;
     */
    /* JADX WARNING: Missing block: B:10:0x0026, code skipped:
            if (r11.f15992s == null) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:11:0x0028, code skipped:
            r11.f15992s.updateTexImage();
            r11.f15992s.getTransformMatrix(r11.f15995v);
     */
    /* JADX WARNING: Missing block: B:13:0x0036, code skipped:
            if (r11.f15985a == null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:14:0x0038, code skipped:
            r11.f15985a.mo43454a(r11.f15993t.mo72898a(), r11.f15995v);
     */
    /* JADX WARNING: Missing block: B:16:0x0047, code skipped:
            if (r11.f17834i != 1) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code skipped:
            if (r11.f15991r == null) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:19:0x004d, code skipped:
            mo72911a(r11.f15991r.mo60208a(), r11.f15993t.mo72898a(), r11.f15995v, true);
     */
    /* JADX WARNING: Missing block: B:20:0x005e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67168);
     */
    /* JADX WARNING: Missing block: B:33:0x008e, code skipped:
            if (r11.f15993t == null) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:34:0x0090, code skipped:
            r11.f15993t.mo72901a(r11.f15992s);
     */
    /* JADX WARNING: Missing block: B:36:0x009a, code skipped:
            if (r4 == 0) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:38:0x009e, code skipped:
            if (r11.f15998y == null) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:40:0x00a2, code skipped:
            if (r11.f15986b == null) goto L_0x00d8;
     */
    /* JADX WARNING: Missing block: B:41:0x00a4, code skipped:
            r11.f15998y.setHasFrameBuffer(r11.f17832g, r11.f17833h);
            r0 = r11.f15998y.drawToTexture(r4);
            r11.f15986b.mo19968d(r0);
     */
    /* JADX WARNING: Missing block: B:43:0x00ba, code skipped:
            if (r11.f17834i != 1) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:44:0x00bc, code skipped:
            if (r0 != -1) goto L_0x00cd;
     */
    /* JADX WARNING: Missing block: B:45:0x00be, code skipped:
            r11.f15998y.setHasFrameBuffer(r11.f17832g, r11.f17833h);
            r0 = r11.f15998y.drawToTexture(r4);
     */
    /* JADX WARNING: Missing block: B:46:0x00cd, code skipped:
            mo72911a(r11.f15991r.mo60208a(), r0, null, false);
     */
    /* JADX WARNING: Missing block: B:48:0x00da, code skipped:
            if (r11.f17834i != 0) goto L_0x00e1;
     */
    /* JADX WARNING: Missing block: B:49:0x00dc, code skipped:
            r11.f15998y.drawFrame(r4);
     */
    /* JADX WARNING: Missing block: B:50:0x00e1, code skipped:
            r0 = -1;
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: s */
    private boolean m62916s() {
        AppMethodBeat.m2504i(67168);
        synchronized (this) {
            try {
                boolean z;
                long j;
                if (this.f15994u) {
                    z = this.f15994u;
                    this.f15994u = false;
                    j = 0;
                } else if (this.f15997x.isEmpty()) {
                    AppMethodBeat.m2505o(67168);
                    return false;
                } else {
                    j = ((Long) this.f15997x.get(0)).longValue();
                    this.f15997x.remove(0);
                    z = false;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(67168);
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67169);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67169);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m62914a(Queue<Runnable> queue) {
        AppMethodBeat.m2504i(67169);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67169);
            }
        }
        return false;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.f15994u = true;
        }
    }

    public void finalize() {
        AppMethodBeat.m2504i(67170);
        super.finalize();
        TXCLog.m15679w("TXCVideoRender", "play:vrender: quit render thread when finalize");
        try {
            mo60205h();
            AppMethodBeat.m2505o(67170);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67170);
        }
    }
}
