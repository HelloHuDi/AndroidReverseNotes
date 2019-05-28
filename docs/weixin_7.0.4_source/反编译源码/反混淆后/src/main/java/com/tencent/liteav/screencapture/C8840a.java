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
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C16517h;
import com.tencent.liteav.basic.p141e.C32141b;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p141e.C37353j;
import com.tencent.liteav.basic.p141e.C45103k;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.screencapture.C25675b.C8846a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.screencapture.a */
public class C8840a {
    /* renamed from: a */
    protected Handler f2733a = null;
    /* renamed from: b */
    protected volatile HandlerThread f2734b = null;
    /* renamed from: c */
    protected volatile C8842a f2735c = null;
    /* renamed from: d */
    protected volatile WeakReference<C17811c> f2736d = null;
    /* renamed from: e */
    protected volatile int f2737e = 0;
    /* renamed from: f */
    protected int f2738f = 720;
    /* renamed from: g */
    protected int f2739g = ActUtil.HEIGHT;
    /* renamed from: h */
    protected int f2740h = 20;
    /* renamed from: i */
    protected boolean f2741i = false;
    /* renamed from: j */
    private Object f2742j = null;
    /* renamed from: k */
    private boolean f2743k = false;
    /* renamed from: l */
    private int f2744l = this.f2738f;
    /* renamed from: m */
    private int f2745m = this.f2739g;
    /* renamed from: n */
    private Context f2746n = null;
    /* renamed from: o */
    private C8846a f2747o = new C88411();

    /* renamed from: com.tencent.liteav.screencapture.a$1 */
    class C88411 implements C8846a {
        C88411() {
        }

        /* renamed from: a */
        public void mo19989a(int i) {
            AppMethodBeat.m2504i(66801);
            C8840a.this.mo19986b(i);
            C8840a.this.mo19987b(105, C8840a.this.f2744l, C8840a.this.f2745m);
            AppMethodBeat.m2505o(66801);
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.a$a */
    protected class C8842a extends Handler {
        /* renamed from: a */
        public int f2749a = 0;
        /* renamed from: b */
        public int[] f2750b = null;
        /* renamed from: c */
        public Surface f2751c = null;
        /* renamed from: d */
        public SurfaceTexture f2752d = null;
        /* renamed from: e */
        public int f2753e = 720;
        /* renamed from: f */
        public int f2754f = ActUtil.HEIGHT;
        /* renamed from: g */
        public int f2755g = 25;
        /* renamed from: h */
        protected boolean f2756h = false;
        /* renamed from: i */
        protected long f2757i = 0;
        /* renamed from: j */
        protected long f2758j = 0;
        /* renamed from: k */
        protected C32141b f2759k = null;
        /* renamed from: l */
        protected C16517h f2760l = null;
        /* renamed from: m */
        float[] f2761m = new float[16];

        /* renamed from: com.tencent.liteav.screencapture.a$a$1 */
        class C88431 implements OnFrameAvailableListener {

            /* renamed from: com.tencent.liteav.screencapture.a$a$1$1 */
            class C88391 implements Runnable {
                C88391() {
                }

                public void run() {
                    AppMethodBeat.m2504i(66762);
                    C8842a.this.f2756h = true;
                    C8840a.this.mo19975a(102);
                    AppMethodBeat.m2505o(66762);
                }
            }

            C88431() {
            }

            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.m2504i(66765);
                C8840a.this.mo19978a(104, new C88391());
                surfaceTexture.setOnFrameAvailableListener(null);
                AppMethodBeat.m2505o(66765);
            }
        }

        public C8842a(Looper looper, C8840a c8840a) {
            super(looper);
            AppMethodBeat.m2504i(66790);
            AppMethodBeat.m2505o(66790);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(66791);
            if (message == null) {
                AppMethodBeat.m2505o(66791);
            } else if (this.f2749a == C8840a.this.f2737e || 101 == message.what) {
                switch (message.what) {
                    case 100:
                        mo19990a(message);
                        break;
                    case 101:
                        mo19993b(message);
                        break;
                    case 102:
                        try {
                            mo19995c(message);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 103:
                        mo19997d(message);
                        break;
                    case 105:
                        mo19998e(message);
                        break;
                }
                if (!(message == null || message.obj == null)) {
                    ((Runnable) message.obj).run();
                }
                AppMethodBeat.m2505o(66791);
            } else {
                AppMethodBeat.m2505o(66791);
            }
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public void mo19990a(Message message) {
            AppMethodBeat.m2504i(66792);
            this.f2757i = 0;
            this.f2758j = 0;
            if (mo19991a()) {
                C8840a.this.mo19979a(0, this.f2759k.mo52724c());
                AppMethodBeat.m2505o(66792);
                return;
            }
            mo19992b();
            C8840a.this.mo19985b();
            C8840a.this.mo19979a(20000003, null);
            AppMethodBeat.m2505o(66792);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: b */
        public void mo19993b(Message message) {
            AppMethodBeat.m2504i(66793);
            C17811c c = C8840a.this.mo19988c();
            if (c != null) {
                c.mo32967a(C8840a.this.f2742j);
            }
            mo19992b();
            AppMethodBeat.m2505o(66793);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: c */
        public void mo19995c(Message message) {
            AppMethodBeat.m2504i(66794);
            C8840a.this.mo19977a(102, 5);
            if (!C8840a.this.f2741i) {
                AppMethodBeat.m2505o(66794);
            } else if (this.f2756h) {
                long nanoTime = System.nanoTime();
                if (nanoTime < this.f2758j + ((((this.f2757i * 1000) * 1000) * 1000) / ((long) this.f2755g))) {
                    AppMethodBeat.m2505o(66794);
                    return;
                }
                if (this.f2758j == 0) {
                    this.f2758j = nanoTime;
                } else if (nanoTime > this.f2758j + 1000000000) {
                    this.f2757i = 0;
                    this.f2758j = nanoTime;
                }
                this.f2757i++;
                if (this.f2752d == null || this.f2750b == null) {
                    AppMethodBeat.m2505o(66794);
                    return;
                }
                this.f2752d.getTransformMatrix(this.f2761m);
                try {
                    this.f2752d.updateTexImage();
                } catch (Exception e) {
                    TXCLog.m15676e("ScreenCapture", "onMsgRend Exception " + e.getMessage());
                }
                this.f2760l.mo19874a(this.f2761m);
                GLES20.glViewport(0, 0, this.f2753e, this.f2754f);
                C8840a.this.mo19976a(0, this.f2760l.mo3840b(this.f2750b[0]), this.f2753e, this.f2754f, TXCTimeUtil.getTimeTick());
                AppMethodBeat.m2505o(66794);
            } else {
                this.f2757i = 0;
                this.f2758j = System.nanoTime();
                AppMethodBeat.m2505o(66794);
            }
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: d */
        public void mo19997d(Message message) {
            if (message != null) {
                this.f2755g = message.arg1 <= 0 ? 1 : message.arg1;
                this.f2757i = 0;
                this.f2758j = 0;
            }
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: e */
        public void mo19998e(Message message) {
            AppMethodBeat.m2504i(66795);
            if (message == null) {
                AppMethodBeat.m2505o(66795);
                return;
            }
            this.f2753e = message.arg1;
            this.f2754f = message.arg2;
            mo19994c();
            this.f2760l.mo3839a(this.f2753e, this.f2754f);
            mo19996d();
            TXCLog.m15675d("ScreenCapture", String.format("set screen capture size[%d/%d]", new Object[]{Integer.valueOf(C8840a.this.f2744l), Integer.valueOf(C8840a.this.f2745m)}));
            AppMethodBeat.m2505o(66795);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public boolean mo19991a() {
            AppMethodBeat.m2504i(66796);
            TXCLog.m15675d("ScreenCapture", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.f2753e), Integer.valueOf(this.f2754f)}));
            this.f2759k = C32141b.m52280a(null, null, null, this.f2753e, this.f2754f);
            if (this.f2759k == null) {
                AppMethodBeat.m2505o(66796);
                return false;
            }
            this.f2760l = new C16517h();
            if (this.f2760l.mo19876a()) {
                this.f2760l.mo19873a(true);
                this.f2760l.mo3839a(this.f2753e, this.f2754f);
                this.f2760l.mo19875a(C45103k.f17758e, C45103k.m82749a(C37353j.NORMAL, false, false));
                mo19996d();
                AppMethodBeat.m2505o(66796);
                return true;
            }
            AppMethodBeat.m2505o(66796);
            return false;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: b */
        public void mo19992b() {
            AppMethodBeat.m2504i(66797);
            mo19994c();
            if (this.f2760l != null) {
                this.f2760l.mo19883d();
                this.f2760l = null;
            }
            if (this.f2759k != null) {
                this.f2759k.mo52723b();
                this.f2759k = null;
            }
            AppMethodBeat.m2505o(66797);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: c */
        public void mo19994c() {
            AppMethodBeat.m2504i(66798);
            if (this.f2752d != null) {
                this.f2752d.setOnFrameAvailableListener(null);
                this.f2752d.release();
                this.f2756h = false;
                this.f2752d = null;
            }
            C25675b.m40746a().mo43458a(this.f2751c);
            if (this.f2751c != null) {
                this.f2751c.release();
                this.f2751c = null;
            }
            if (this.f2750b != null) {
                GLES20.glDeleteTextures(1, this.f2750b, 0);
                this.f2750b = null;
            }
            AppMethodBeat.m2505o(66798);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: d */
        public void mo19996d() {
            AppMethodBeat.m2504i(66799);
            this.f2750b = new int[1];
            this.f2750b[0] = C32144i.m52319b();
            if (this.f2750b[0] <= 0) {
                this.f2750b = null;
                AppMethodBeat.m2505o(66799);
                return;
            }
            this.f2752d = new SurfaceTexture(this.f2750b[0]);
            this.f2751c = new Surface(this.f2752d);
            this.f2752d.setDefaultBufferSize(this.f2753e, this.f2754f);
            this.f2752d.setOnFrameAvailableListener(new C88431());
            C25675b.m40746a().mo43461a(this.f2751c, this.f2753e, this.f2754f);
            AppMethodBeat.m2505o(66799);
        }
    }

    public C8840a(Context context, boolean z) {
        AppMethodBeat.m2504i(66744);
        this.f2746n = context;
        this.f2733a = new Handler(Looper.getMainLooper());
        this.f2743k = z;
        if (VERSION.SDK_INT >= 21) {
            C25675b.m40746a().mo43457a(context);
        }
        AppMethodBeat.m2505o(66744);
    }

    /* renamed from: a */
    public int mo19973a(int i, int i2, int i3) {
        int rotation;
        AppMethodBeat.m2504i(66745);
        if (this.f2743k) {
            rotation = ((WindowManager) this.f2746n.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                if (i > i2) {
                    this.f2738f = i2;
                    this.f2739g = i;
                } else {
                    this.f2738f = i;
                    this.f2739g = i2;
                }
            } else if (i < i2) {
                this.f2738f = i2;
                this.f2739g = i;
            } else {
                this.f2738f = i;
                this.f2739g = i2;
            }
        } else {
            this.f2738f = i;
            this.f2739g = i2;
            rotation = 0;
        }
        TXCLog.m15675d("ScreenCapture", String.format("start screen capture orientation[%d] input size[%d/%d] output size[%d/%d]", new Object[]{Integer.valueOf(rotation), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f2738f), Integer.valueOf(this.f2739g)}));
        this.f2740h = i3;
        if (VERSION.SDK_INT < 21) {
            mo19979a(20000004, null);
            AppMethodBeat.m2505o(66745);
            return 20000004;
        }
        this.f2744l = this.f2738f;
        this.f2745m = this.f2739g;
        mo19974a();
        if (this.f2743k) {
            C25675b.m40746a().mo43460a(this.f2747o);
        }
        AppMethodBeat.m2505o(66745);
        return 0;
    }

    /* renamed from: a */
    public void mo19982a(Object obj) {
        AppMethodBeat.m2504i(66746);
        C25675b.m40746a().mo43463b(this.f2747o);
        this.f2742j = obj;
        mo19985b();
        AppMethodBeat.m2505o(66746);
    }

    /* renamed from: a */
    public void mo19984a(final boolean z) {
        AppMethodBeat.m2504i(66747);
        synchronized (this) {
            try {
                if (this.f2735c != null) {
                    this.f2735c.post(new Runnable() {
                        public void run() {
                            C8840a.this.f2741i = z;
                        }
                    });
                } else {
                    this.f2741i = z;
                }
            } finally {
                AppMethodBeat.m2505o(66747);
            }
        }
    }

    /* renamed from: a */
    public void mo19981a(C17811c c17811c) {
        AppMethodBeat.m2504i(66748);
        this.f2736d = new WeakReference(c17811c);
        AppMethodBeat.m2505o(66748);
    }

    /* renamed from: a */
    public void mo19980a(C0946a c0946a) {
        AppMethodBeat.m2504i(66749);
        C25675b.m40746a().mo43459a(c0946a);
        AppMethodBeat.m2505o(66749);
    }

    /* renamed from: a */
    public synchronized void mo19983a(Runnable runnable) {
        AppMethodBeat.m2504i(66750);
        if (this.f2735c != null) {
            this.f2735c.post(runnable);
        }
        AppMethodBeat.m2505o(66750);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19974a() {
        AppMethodBeat.m2504i(66751);
        mo19985b();
        synchronized (this) {
            try {
                this.f2734b = new HandlerThread("ScreenCaptureGLThread");
                this.f2734b.start();
                this.f2735c = new C8842a(this.f2734b.getLooper(), this);
                this.f2737e++;
                this.f2735c.f2749a = this.f2737e;
                this.f2735c.f2753e = this.f2744l;
                this.f2735c.f2754f = this.f2745m;
                this.f2735c.f2755g = this.f2740h <= 0 ? 1 : this.f2740h;
            } finally {
                AppMethodBeat.m2505o(66751);
            }
        }
        mo19975a(100);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo19985b() {
        AppMethodBeat.m2504i(66752);
        synchronized (this) {
            try {
                this.f2737e++;
                if (this.f2735c != null) {
                    final HandlerThread handlerThread = this.f2734b;
                    final C8842a c8842a = this.f2735c;
                    mo19978a(101, new Runnable() {

                        /* renamed from: com.tencent.liteav.screencapture.a$3$1 */
                        class C09721 implements Runnable {
                            C09721() {
                            }

                            public void run() {
                                AppMethodBeat.m2504i(66767);
                                if (c8842a != null) {
                                    c8842a.removeCallbacksAndMessages(null);
                                }
                                if (handlerThread != null) {
                                    if (VERSION.SDK_INT >= 18) {
                                        handlerThread.quitSafely();
                                        AppMethodBeat.m2505o(66767);
                                        return;
                                    }
                                    handlerThread.quit();
                                }
                                AppMethodBeat.m2505o(66767);
                            }
                        }

                        public void run() {
                            AppMethodBeat.m2504i(66766);
                            C8840a.this.f2733a.post(new C09721());
                            AppMethodBeat.m2505o(66766);
                        }
                    });
                }
                this.f2735c = null;
                this.f2734b = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66752);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public C17811c mo19988c() {
        AppMethodBeat.m2504i(66753);
        if (this.f2736d == null) {
            AppMethodBeat.m2505o(66753);
            return null;
        }
        C17811c c17811c = (C17811c) this.f2736d.get();
        AppMethodBeat.m2505o(66753);
        return c17811c;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19977a(int i, long j) {
        AppMethodBeat.m2504i(66754);
        synchronized (this) {
            try {
                if (this.f2735c != null) {
                    this.f2735c.sendEmptyMessageDelayed(i, j);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66754);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19975a(int i) {
        AppMethodBeat.m2504i(66755);
        synchronized (this) {
            try {
                if (this.f2735c != null) {
                    this.f2735c.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66755);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo19987b(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66756);
        synchronized (this) {
            try {
                if (this.f2735c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.arg1 = i2;
                    message.arg2 = i3;
                    this.f2735c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66756);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19978a(int i, Runnable runnable) {
        AppMethodBeat.m2504i(66757);
        synchronized (this) {
            try {
                if (this.f2735c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.obj = runnable;
                    this.f2735c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66757);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19979a(int i, EGLContext eGLContext) {
        AppMethodBeat.m2504i(66758);
        C17811c c = mo19988c();
        if (c != null) {
            c.mo32966a(i, eGLContext);
        }
        AppMethodBeat.m2505o(66758);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19976a(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.m2504i(66759);
        C17811c c = mo19988c();
        if (c != null) {
            c.mo32965a(i, i2, i3, i4, j);
        }
        AppMethodBeat.m2505o(66759);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo19986b(int i) {
        AppMethodBeat.m2504i(66760);
        if (i == 0) {
            this.f2744l = this.f2738f < this.f2739g ? this.f2738f : this.f2739g;
            this.f2745m = this.f2738f < this.f2739g ? this.f2739g : this.f2738f;
        } else {
            this.f2744l = this.f2738f < this.f2739g ? this.f2739g : this.f2738f;
            this.f2745m = this.f2738f < this.f2739g ? this.f2738f : this.f2739g;
        }
        TXCLog.m15675d("ScreenCapture", String.format("reset screen capture angle[%d] output size[%d/%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f2744l), Integer.valueOf(this.f2745m)}));
        AppMethodBeat.m2505o(66760);
    }
}
