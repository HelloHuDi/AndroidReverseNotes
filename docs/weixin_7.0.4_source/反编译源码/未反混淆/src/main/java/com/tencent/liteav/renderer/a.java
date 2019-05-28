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

public class a extends e implements OnFrameAvailableListener {
    g a;
    a b;
    private final int n = 0;
    private final int o = 0;
    private final int p = 0;
    private final int q = 0;
    private b r;
    private SurfaceTexture s;
    private c t;
    private boolean u;
    private float[] v = new float[16];
    private c w;
    private ArrayList<Long> x = new ArrayList();
    private TXCYuvTextureRender y;
    private final Queue<Runnable> z = new LinkedList();

    public interface a {
        void d(int i);
    }

    public a() {
        AppMethodBeat.i(67153);
        AppMethodBeat.o(67153);
    }

    public void a(g gVar) {
        this.a = gVar;
    }

    public void a(a aVar) {
        AppMethodBeat.i(67154);
        this.b = aVar;
        if (!(aVar == null || this.y == null)) {
            this.y.setHasFrameBuffer(this.g, this.h);
        }
        AppMethodBeat.o(67154);
    }

    public void a(long j, int i, int i2) {
        AppMethodBeat.i(67155);
        synchronized (this) {
            try {
                this.x.add(Long.valueOf(j));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67155);
            }
        }
        super.a(j, i, i2);
    }

    public void a(int i, int i2, int i3, boolean z, int i4) {
        AppMethodBeat.i(67156);
        GLES20.glViewport(0, 0, k(), l());
        if (this.w != null) {
            this.w.a(i, z, i4);
        }
        super.a(i, i2, i3, z, i4);
        AppMethodBeat.o(67156);
    }

    public SurfaceTexture a() {
        return this.s;
    }

    public EGLContext b() {
        AppMethodBeat.i(67157);
        if (this.r != null) {
            EGLContext a = this.r.a();
            AppMethodBeat.o(67157);
            return a;
        }
        AppMethodBeat.o(67157);
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67158);
        g();
        AppMethodBeat.o(67158);
    }

    /* Access modifiers changed, original: protected */
    public void b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67159);
        h();
        AppMethodBeat.o(67159);
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, int i2) {
        AppMethodBeat.i(67160);
        super.a(i, i2);
        if (this.y != null) {
            this.y.setVideoSize(i, i2);
        }
        if (this.t != null) {
            this.t.a(i, i2);
        }
        AppMethodBeat.o(67160);
    }

    /* Access modifiers changed, original: 0000 */
    public void c() {
        AppMethodBeat.i(67161);
        r();
        if (this.d != null) {
            this.d.a(this.e, this.f);
            this.d.b(this.g, this.h);
        }
        if (this.t != null) {
            this.t.b();
            this.s = new SurfaceTexture(this.t.a());
            this.s.setOnFrameAvailableListener(this);
        }
        if (this.y != null) {
            this.y.createTexture();
        }
        if (!(this.b == null || this.y == null)) {
            this.y.setHasFrameBuffer(this.g, this.h);
        }
        if (this.w != null) {
            this.w.b();
        }
        if (this.l != null) {
            this.l.a(this.s);
        }
        AppMethodBeat.o(67161);
    }

    private void r() {
        AppMethodBeat.i(67162);
        this.t = new c(true);
        this.y = new TXCYuvTextureRender();
        this.w = new c(false);
        AppMethodBeat.o(67162);
    }

    /* Access modifiers changed, original: 0000 */
    public void d() {
        AppMethodBeat.i(67163);
        try {
            if (this.l != null) {
                this.l.b(this.s);
            }
        } catch (Exception e) {
        }
        if (this.t != null) {
            this.t.c();
            this.t = null;
        }
        if (this.y != null) {
            this.y.onSurfaceDestroy();
            this.y = null;
        }
        if (this.w != null) {
            this.w.c();
            this.w = null;
        }
        AppMethodBeat.o(67163);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean e() {
        AppMethodBeat.i(67164);
        do {
        } while (a(this.z));
        boolean s = s();
        AppMethodBeat.o(67164);
        return s;
    }

    /* Access modifiers changed, original: 0000 */
    public SurfaceTexture f() {
        AppMethodBeat.i(67165);
        if (this.c != null) {
            SurfaceTexture surfaceTexture = this.c.getSurfaceTexture();
            AppMethodBeat.o(67165);
            return surfaceTexture;
        }
        AppMethodBeat.o(67165);
        return null;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    public void g() {
        AppMethodBeat.i(67166);
        if (this.r == null) {
            this.r = new b(new WeakReference(this));
            this.r.start();
            TXCLog.w("TXCVideoRender", "play:vrender: start render thread");
            AppMethodBeat.o(67166);
            return;
        }
        TXCLog.w("TXCVideoRender", "play:vrender: render thread is running");
        AppMethodBeat.o(67166);
    }

    /* Access modifiers changed, original: protected */
    public void h() {
        AppMethodBeat.i(67167);
        if (this.r != null) {
            this.r.b();
            this.r = null;
            TXCLog.w("TXCVideoRender", "play:vrender: quit render thread");
        }
        this.s = null;
        AppMethodBeat.o(67167);
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code skipped:
            android.opengl.GLES20.glViewport(0, 0, k(), l());
     */
    /* JADX WARNING: Missing block: B:8:0x0022, code skipped:
            if (r0 == false) goto L_0x0098;
     */
    /* JADX WARNING: Missing block: B:10:0x0026, code skipped:
            if (r11.s == null) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:11:0x0028, code skipped:
            r11.s.updateTexImage();
            r11.s.getTransformMatrix(r11.v);
     */
    /* JADX WARNING: Missing block: B:13:0x0036, code skipped:
            if (r11.a == null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:14:0x0038, code skipped:
            r11.a.a(r11.t.a(), r11.v);
     */
    /* JADX WARNING: Missing block: B:16:0x0047, code skipped:
            if (r11.i != 1) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code skipped:
            if (r11.r == null) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:19:0x004d, code skipped:
            a(r11.r.a(), r11.t.a(), r11.v, true);
     */
    /* JADX WARNING: Missing block: B:20:0x005e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(67168);
     */
    /* JADX WARNING: Missing block: B:33:0x008e, code skipped:
            if (r11.t == null) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:34:0x0090, code skipped:
            r11.t.a(r11.s);
     */
    /* JADX WARNING: Missing block: B:36:0x009a, code skipped:
            if (r4 == 0) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:38:0x009e, code skipped:
            if (r11.y == null) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:40:0x00a2, code skipped:
            if (r11.b == null) goto L_0x00d8;
     */
    /* JADX WARNING: Missing block: B:41:0x00a4, code skipped:
            r11.y.setHasFrameBuffer(r11.g, r11.h);
            r0 = r11.y.drawToTexture(r4);
            r11.b.d(r0);
     */
    /* JADX WARNING: Missing block: B:43:0x00ba, code skipped:
            if (r11.i != 1) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:44:0x00bc, code skipped:
            if (r0 != -1) goto L_0x00cd;
     */
    /* JADX WARNING: Missing block: B:45:0x00be, code skipped:
            r11.y.setHasFrameBuffer(r11.g, r11.h);
            r0 = r11.y.drawToTexture(r4);
     */
    /* JADX WARNING: Missing block: B:46:0x00cd, code skipped:
            a(r11.r.a(), r0, null, false);
     */
    /* JADX WARNING: Missing block: B:48:0x00da, code skipped:
            if (r11.i != 0) goto L_0x00e1;
     */
    /* JADX WARNING: Missing block: B:49:0x00dc, code skipped:
            r11.y.drawFrame(r4);
     */
    /* JADX WARNING: Missing block: B:50:0x00e1, code skipped:
            r0 = -1;
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean s() {
        AppMethodBeat.i(67168);
        synchronized (this) {
            try {
                boolean z;
                long j;
                if (this.u) {
                    z = this.u;
                    this.u = false;
                    j = 0;
                } else if (this.x.isEmpty()) {
                    AppMethodBeat.o(67168);
                    return false;
                } else {
                    j = ((Long) this.x.get(0)).longValue();
                    this.x.remove(0);
                    z = false;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(67168);
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(67169);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.o(67169);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        AppMethodBeat.i(67169);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67169);
            }
        }
        return false;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.u = true;
        }
    }

    public void finalize() {
        AppMethodBeat.i(67170);
        super.finalize();
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
        try {
            h();
            AppMethodBeat.o(67170);
        } catch (Exception e) {
            AppMethodBeat.o(67170);
        }
    }
}
