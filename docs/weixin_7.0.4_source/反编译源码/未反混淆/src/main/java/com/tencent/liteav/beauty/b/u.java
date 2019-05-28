package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class u {
    private static final String b = u.class.getSimpleName();
    OnFrameAvailableListener a;
    private SurfaceTexture c;
    private int d = -1;
    private boolean e = false;
    private MediaExtractor f;
    private AssetFileDescriptor g;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private long l;
    private MediaCodec m;
    private boolean n = false;
    private boolean o;
    private Handler p;
    private Object q = new Object();

    static /* synthetic */ void b(u uVar) {
        AppMethodBeat.i(67033);
        uVar.c();
        AppMethodBeat.o(67033);
    }

    u() {
        AppMethodBeat.i(67029);
        AppMethodBeat.o(67029);
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a() {
        AppMethodBeat.i(67030);
        synchronized (this.q) {
            try {
                if (this.p != null) {
                    if (Looper.myLooper() == this.p.getLooper()) {
                        c();
                    } else {
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public void run() {
                                AppMethodBeat.i(66978);
                                synchronized (u.this.q) {
                                    try {
                                        u.b(u.this);
                                        u.this.q.notify();
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(66978);
                                    }
                                }
                            }
                        };
                        this.p.removeCallbacksAndMessages(null);
                        this.p.post(anonymousClass1);
                        this.p.getLooper().quitSafely();
                        while (true) {
                            try {
                                this.q.wait();
                                break;
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(67030);
                }
            }
        }
        AppMethodBeat.o(67030);
    }

    private void b() {
        AppMethodBeat.i(67031);
        if (this.e) {
            this.e = false;
            if (this.f != null) {
                this.f.release();
                this.f = null;
            }
            try {
                this.m.stop();
                try {
                    this.m.release();
                } catch (Exception e) {
                } finally {
                    this.m = null;
                    AppMethodBeat.o(67031);
                }
                return;
            } catch (Exception e2) {
                try {
                    this.m.release();
                    return;
                } catch (Exception e3) {
                    return;
                } finally {
                    this.m = null;
                    AppMethodBeat.o(67031);
                }
            } catch (Throwable th) {
                try {
                    this.m.release();
                    this.m = null;
                } catch (Exception e4) {
                    this.m = null;
                } catch (Throwable th2) {
                    this.m = null;
                    AppMethodBeat.o(67031);
                }
                AppMethodBeat.o(67031);
            }
        }
        AppMethodBeat.o(67031);
    }

    private void c() {
        AppMethodBeat.i(67032);
        b();
        this.a = null;
        this.l = 0;
        this.o = false;
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        synchronized (this.q) {
            try {
                if (this.p != null) {
                    this.p.removeCallbacksAndMessages(null);
                    this.p.getLooper().quit();
                    this.p = null;
                    this.q.notify();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(67032);
                }
            }
        }
        if (this.g != null) {
            try {
                this.g.close();
            } catch (Exception e) {
            }
            this.g = null;
        }
        AppMethodBeat.o(67032);
    }

    static {
        AppMethodBeat.i(67034);
        AppMethodBeat.o(67034);
    }
}
