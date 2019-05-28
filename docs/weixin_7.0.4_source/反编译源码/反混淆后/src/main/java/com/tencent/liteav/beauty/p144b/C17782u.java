package com.tencent.liteav.beauty.p144b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.u */
public class C17782u {
    /* renamed from: b */
    private static final String f4151b = C17782u.class.getSimpleName();
    /* renamed from: a */
    OnFrameAvailableListener f4152a;
    /* renamed from: c */
    private SurfaceTexture f4153c;
    /* renamed from: d */
    private int f4154d = -1;
    /* renamed from: e */
    private boolean f4155e = false;
    /* renamed from: f */
    private MediaExtractor f4156f;
    /* renamed from: g */
    private AssetFileDescriptor f4157g;
    /* renamed from: h */
    private int f4158h = -1;
    /* renamed from: i */
    private int f4159i = -1;
    /* renamed from: j */
    private int f4160j = -1;
    /* renamed from: k */
    private int f4161k = -1;
    /* renamed from: l */
    private long f4162l;
    /* renamed from: m */
    private MediaCodec f4163m;
    /* renamed from: n */
    private boolean f4164n = false;
    /* renamed from: o */
    private boolean f4165o;
    /* renamed from: p */
    private Handler f4166p;
    /* renamed from: q */
    private Object f4167q = new Object();

    /* renamed from: com.tencent.liteav.beauty.b.u$1 */
    class C177831 implements Runnable {
        C177831() {
        }

        public void run() {
            AppMethodBeat.m2504i(66978);
            synchronized (C17782u.this.f4167q) {
                try {
                    C17782u.m27765b(C17782u.this);
                    C17782u.this.f4167q.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66978);
                }
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m27765b(C17782u c17782u) {
        AppMethodBeat.m2504i(67033);
        c17782u.m27766c();
        AppMethodBeat.m2505o(67033);
    }

    C17782u() {
        AppMethodBeat.m2504i(67029);
        AppMethodBeat.m2505o(67029);
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo32898a() {
        AppMethodBeat.m2504i(67030);
        synchronized (this.f4167q) {
            try {
                if (this.f4166p != null) {
                    if (Looper.myLooper() == this.f4166p.getLooper()) {
                        m27766c();
                    } else {
                        C177831 c177831 = new C177831();
                        this.f4166p.removeCallbacksAndMessages(null);
                        this.f4166p.post(c177831);
                        this.f4166p.getLooper().quitSafely();
                        while (true) {
                            try {
                                this.f4167q.wait();
                                break;
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(67030);
                }
            }
        }
        AppMethodBeat.m2505o(67030);
    }

    /* renamed from: b */
    private void m27764b() {
        AppMethodBeat.m2504i(67031);
        if (this.f4155e) {
            this.f4155e = false;
            if (this.f4156f != null) {
                this.f4156f.release();
                this.f4156f = null;
            }
            try {
                this.f4163m.stop();
                try {
                    this.f4163m.release();
                } catch (Exception e) {
                } finally {
                    this.f4163m = null;
                    AppMethodBeat.m2505o(67031);
                }
                return;
            } catch (Exception e2) {
                try {
                    this.f4163m.release();
                    return;
                } catch (Exception e3) {
                    return;
                } finally {
                    this.f4163m = null;
                    AppMethodBeat.m2505o(67031);
                }
            } catch (Throwable th) {
                try {
                    this.f4163m.release();
                    this.f4163m = null;
                } catch (Exception e4) {
                    this.f4163m = null;
                } catch (Throwable th2) {
                    this.f4163m = null;
                    AppMethodBeat.m2505o(67031);
                }
                AppMethodBeat.m2505o(67031);
            }
        }
        AppMethodBeat.m2505o(67031);
    }

    /* renamed from: c */
    private void m27766c() {
        AppMethodBeat.m2504i(67032);
        m27764b();
        this.f4152a = null;
        this.f4162l = 0;
        this.f4165o = false;
        if (this.f4153c != null) {
            this.f4153c.release();
            this.f4153c = null;
        }
        synchronized (this.f4167q) {
            try {
                if (this.f4166p != null) {
                    this.f4166p.removeCallbacksAndMessages(null);
                    this.f4166p.getLooper().quit();
                    this.f4166p = null;
                    this.f4167q.notify();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(67032);
                }
            }
        }
        if (this.f4157g != null) {
            try {
                this.f4157g.close();
            } catch (Exception e) {
            }
            this.f4157g = null;
        }
        AppMethodBeat.m2505o(67032);
    }

    static {
        AppMethodBeat.m2504i(67034);
        AppMethodBeat.m2505o(67034);
    }
}
