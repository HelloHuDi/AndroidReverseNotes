package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.e.h;
import com.tencent.liteav.basic.e.i;
import com.tencent.liteav.basic.e.j;
import com.tencent.liteav.basic.e.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a {
    protected Handler a = null;
    protected volatile HandlerThread b = null;
    protected volatile a c = null;
    protected volatile WeakReference<c> d = null;
    protected volatile int e = 0;
    protected int f = 720;
    protected int g = ActUtil.HEIGHT;
    protected int h = 20;
    protected boolean i = false;
    private Object j = null;
    private boolean k = false;
    private int l = this.f;
    private int m = this.g;
    private Context n = null;
    private com.tencent.liteav.screencapture.b.a o = new com.tencent.liteav.screencapture.b.a() {
        public void a(int i) {
            AppMethodBeat.i(66801);
            a.this.b(i);
            a.this.b(105, a.this.l, a.this.m);
            AppMethodBeat.o(66801);
        }
    };

    protected class a extends Handler {
        public int a = 0;
        public int[] b = null;
        public Surface c = null;
        public SurfaceTexture d = null;
        public int e = 720;
        public int f = ActUtil.HEIGHT;
        public int g = 25;
        protected boolean h = false;
        protected long i = 0;
        protected long j = 0;
        protected b k = null;
        protected h l = null;
        float[] m = new float[16];

        public a(Looper looper, a aVar) {
            super(looper);
            AppMethodBeat.i(66790);
            AppMethodBeat.o(66790);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(66791);
            if (message == null) {
                AppMethodBeat.o(66791);
            } else if (this.a == a.this.e || 101 == message.what) {
                switch (message.what) {
                    case 100:
                        a(message);
                        break;
                    case 101:
                        b(message);
                        break;
                    case 102:
                        try {
                            c(message);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 103:
                        d(message);
                        break;
                    case 105:
                        e(message);
                        break;
                }
                if (!(message == null || message.obj == null)) {
                    ((Runnable) message.obj).run();
                }
                AppMethodBeat.o(66791);
            } else {
                AppMethodBeat.o(66791);
            }
        }

        /* Access modifiers changed, original: protected */
        public void a(Message message) {
            AppMethodBeat.i(66792);
            this.i = 0;
            this.j = 0;
            if (a()) {
                a.this.a(0, this.k.c());
                AppMethodBeat.o(66792);
                return;
            }
            b();
            a.this.b();
            a.this.a(20000003, null);
            AppMethodBeat.o(66792);
        }

        /* Access modifiers changed, original: protected */
        public void b(Message message) {
            AppMethodBeat.i(66793);
            c c = a.this.c();
            if (c != null) {
                c.a(a.this.j);
            }
            b();
            AppMethodBeat.o(66793);
        }

        /* Access modifiers changed, original: protected */
        public void c(Message message) {
            AppMethodBeat.i(66794);
            a.this.a(102, 5);
            if (!a.this.i) {
                AppMethodBeat.o(66794);
            } else if (this.h) {
                long nanoTime = System.nanoTime();
                if (nanoTime < this.j + ((((this.i * 1000) * 1000) * 1000) / ((long) this.g))) {
                    AppMethodBeat.o(66794);
                    return;
                }
                if (this.j == 0) {
                    this.j = nanoTime;
                } else if (nanoTime > this.j + 1000000000) {
                    this.i = 0;
                    this.j = nanoTime;
                }
                this.i++;
                if (this.d == null || this.b == null) {
                    AppMethodBeat.o(66794);
                    return;
                }
                this.d.getTransformMatrix(this.m);
                try {
                    this.d.updateTexImage();
                } catch (Exception e) {
                    TXCLog.e("ScreenCapture", "onMsgRend Exception " + e.getMessage());
                }
                this.l.a(this.m);
                GLES20.glViewport(0, 0, this.e, this.f);
                a.this.a(0, this.l.b(this.b[0]), this.e, this.f, TXCTimeUtil.getTimeTick());
                AppMethodBeat.o(66794);
            } else {
                this.i = 0;
                this.j = System.nanoTime();
                AppMethodBeat.o(66794);
            }
        }

        /* Access modifiers changed, original: protected */
        public void d(Message message) {
            if (message != null) {
                this.g = message.arg1 <= 0 ? 1 : message.arg1;
                this.i = 0;
                this.j = 0;
            }
        }

        /* Access modifiers changed, original: protected */
        public void e(Message message) {
            AppMethodBeat.i(66795);
            if (message == null) {
                AppMethodBeat.o(66795);
                return;
            }
            this.e = message.arg1;
            this.f = message.arg2;
            c();
            this.l.a(this.e, this.f);
            d();
            TXCLog.d("ScreenCapture", String.format("set screen capture size[%d/%d]", new Object[]{Integer.valueOf(a.this.l), Integer.valueOf(a.this.m)}));
            AppMethodBeat.o(66795);
        }

        /* Access modifiers changed, original: protected */
        public boolean a() {
            AppMethodBeat.i(66796);
            TXCLog.d("ScreenCapture", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.f)}));
            this.k = b.a(null, null, null, this.e, this.f);
            if (this.k == null) {
                AppMethodBeat.o(66796);
                return false;
            }
            this.l = new h();
            if (this.l.a()) {
                this.l.a(true);
                this.l.a(this.e, this.f);
                this.l.a(k.e, k.a(j.NORMAL, false, false));
                d();
                AppMethodBeat.o(66796);
                return true;
            }
            AppMethodBeat.o(66796);
            return false;
        }

        /* Access modifiers changed, original: protected */
        public void b() {
            AppMethodBeat.i(66797);
            c();
            if (this.l != null) {
                this.l.d();
                this.l = null;
            }
            if (this.k != null) {
                this.k.b();
                this.k = null;
            }
            AppMethodBeat.o(66797);
        }

        /* Access modifiers changed, original: protected */
        public void c() {
            AppMethodBeat.i(66798);
            if (this.d != null) {
                this.d.setOnFrameAvailableListener(null);
                this.d.release();
                this.h = false;
                this.d = null;
            }
            b.a().a(this.c);
            if (this.c != null) {
                this.c.release();
                this.c = null;
            }
            if (this.b != null) {
                GLES20.glDeleteTextures(1, this.b, 0);
                this.b = null;
            }
            AppMethodBeat.o(66798);
        }

        /* Access modifiers changed, original: protected */
        public void d() {
            AppMethodBeat.i(66799);
            this.b = new int[1];
            this.b[0] = i.b();
            if (this.b[0] <= 0) {
                this.b = null;
                AppMethodBeat.o(66799);
                return;
            }
            this.d = new SurfaceTexture(this.b[0]);
            this.c = new Surface(this.d);
            this.d.setDefaultBufferSize(this.e, this.f);
            this.d.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(66765);
                    a.this.a(104, new Runnable() {
                        public void run() {
                            AppMethodBeat.i(66762);
                            a.this.h = true;
                            a.this.a(102);
                            AppMethodBeat.o(66762);
                        }
                    });
                    surfaceTexture.setOnFrameAvailableListener(null);
                    AppMethodBeat.o(66765);
                }
            });
            b.a().a(this.c, this.e, this.f);
            AppMethodBeat.o(66799);
        }
    }

    public a(Context context, boolean z) {
        AppMethodBeat.i(66744);
        this.n = context;
        this.a = new Handler(Looper.getMainLooper());
        this.k = z;
        if (VERSION.SDK_INT >= 21) {
            b.a().a(context);
        }
        AppMethodBeat.o(66744);
    }

    public int a(int i, int i2, int i3) {
        int rotation;
        AppMethodBeat.i(66745);
        if (this.k) {
            rotation = ((WindowManager) this.n.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                if (i > i2) {
                    this.f = i2;
                    this.g = i;
                } else {
                    this.f = i;
                    this.g = i2;
                }
            } else if (i < i2) {
                this.f = i2;
                this.g = i;
            } else {
                this.f = i;
                this.g = i2;
            }
        } else {
            this.f = i;
            this.g = i2;
            rotation = 0;
        }
        TXCLog.d("ScreenCapture", String.format("start screen capture orientation[%d] input size[%d/%d] output size[%d/%d]", new Object[]{Integer.valueOf(rotation), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f), Integer.valueOf(this.g)}));
        this.h = i3;
        if (VERSION.SDK_INT < 21) {
            a(20000004, null);
            AppMethodBeat.o(66745);
            return 20000004;
        }
        this.l = this.f;
        this.m = this.g;
        a();
        if (this.k) {
            b.a().a(this.o);
        }
        AppMethodBeat.o(66745);
        return 0;
    }

    public void a(Object obj) {
        AppMethodBeat.i(66746);
        b.a().b(this.o);
        this.j = obj;
        b();
        AppMethodBeat.o(66746);
    }

    public void a(final boolean z) {
        AppMethodBeat.i(66747);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.post(new Runnable() {
                        public void run() {
                            a.this.i = z;
                        }
                    });
                } else {
                    this.i = z;
                }
            } finally {
                AppMethodBeat.o(66747);
            }
        }
    }

    public void a(c cVar) {
        AppMethodBeat.i(66748);
        this.d = new WeakReference(cVar);
        AppMethodBeat.o(66748);
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(66749);
        b.a().a(aVar);
        AppMethodBeat.o(66749);
    }

    public synchronized void a(Runnable runnable) {
        AppMethodBeat.i(66750);
        if (this.c != null) {
            this.c.post(runnable);
        }
        AppMethodBeat.o(66750);
    }

    /* Access modifiers changed, original: protected */
    public void a() {
        AppMethodBeat.i(66751);
        b();
        synchronized (this) {
            try {
                this.b = new HandlerThread("ScreenCaptureGLThread");
                this.b.start();
                this.c = new a(this.b.getLooper(), this);
                this.e++;
                this.c.a = this.e;
                this.c.e = this.l;
                this.c.f = this.m;
                this.c.g = this.h <= 0 ? 1 : this.h;
            } finally {
                AppMethodBeat.o(66751);
            }
        }
        a(100);
    }

    /* Access modifiers changed, original: protected */
    public void b() {
        AppMethodBeat.i(66752);
        synchronized (this) {
            try {
                this.e++;
                if (this.c != null) {
                    final HandlerThread handlerThread = this.b;
                    final a aVar = this.c;
                    a(101, new Runnable() {
                        public void run() {
                            AppMethodBeat.i(66766);
                            a.this.a.post(new Runnable() {
                                public void run() {
                                    AppMethodBeat.i(66767);
                                    if (aVar != null) {
                                        aVar.removeCallbacksAndMessages(null);
                                    }
                                    if (handlerThread != null) {
                                        if (VERSION.SDK_INT >= 18) {
                                            handlerThread.quitSafely();
                                            AppMethodBeat.o(66767);
                                            return;
                                        }
                                        handlerThread.quit();
                                    }
                                    AppMethodBeat.o(66767);
                                }
                            });
                            AppMethodBeat.o(66766);
                        }
                    });
                }
                this.c = null;
                this.b = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66752);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public c c() {
        AppMethodBeat.i(66753);
        if (this.d == null) {
            AppMethodBeat.o(66753);
            return null;
        }
        c cVar = (c) this.d.get();
        AppMethodBeat.o(66753);
        return cVar;
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, long j) {
        AppMethodBeat.i(66754);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.sendEmptyMessageDelayed(i, j);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66754);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(int i) {
        AppMethodBeat.i(66755);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66755);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void b(int i, int i2, int i3) {
        AppMethodBeat.i(66756);
        synchronized (this) {
            try {
                if (this.c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.arg1 = i2;
                    message.arg2 = i3;
                    this.c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66756);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, Runnable runnable) {
        AppMethodBeat.i(66757);
        synchronized (this) {
            try {
                if (this.c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.obj = runnable;
                    this.c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66757);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, EGLContext eGLContext) {
        AppMethodBeat.i(66758);
        c c = c();
        if (c != null) {
            c.a(i, eGLContext);
        }
        AppMethodBeat.o(66758);
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.i(66759);
        c c = c();
        if (c != null) {
            c.a(i, i2, i3, i4, j);
        }
        AppMethodBeat.o(66759);
    }

    /* Access modifiers changed, original: protected */
    public void b(int i) {
        AppMethodBeat.i(66760);
        if (i == 0) {
            this.l = this.f < this.g ? this.f : this.g;
            this.m = this.f < this.g ? this.g : this.f;
        } else {
            this.l = this.f < this.g ? this.g : this.f;
            this.m = this.f < this.g ? this.f : this.g;
        }
        TXCLog.d("ScreenCapture", String.format("reset screen capture angle[%d] output size[%d/%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.l), Integer.valueOf(this.m)}));
        AppMethodBeat.o(66760);
    }
}
