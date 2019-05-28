package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceViewBase extends SurfaceView implements Callback {
    /* renamed from: a */
    private static final C25670j f17102a = new C25670j();
    /* renamed from: b */
    protected boolean f17103b = false;
    /* renamed from: c */
    protected boolean f17104c = false;
    /* renamed from: d */
    protected final WeakReference<TXCGLSurfaceViewBase> f17105d = new WeakReference(this);
    /* renamed from: e */
    protected boolean f17106e;
    /* renamed from: f */
    protected boolean f17107f;
    /* renamed from: g */
    private C25669i f17108g;
    /* renamed from: h */
    private Renderer f17109h;
    /* renamed from: i */
    private boolean f17110i;
    /* renamed from: j */
    private C41699e f17111j;
    /* renamed from: k */
    private C37371f f17112k;
    /* renamed from: l */
    private C41700g f17113l;
    /* renamed from: m */
    private C8835k f17114m;
    /* renamed from: n */
    private int f17115n;
    /* renamed from: o */
    private int f17116o;
    /* renamed from: p */
    private boolean f17117p;

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$a */
    abstract class C8834a implements C41699e {
        /* renamed from: a */
        protected int[] f2728a;

        /* renamed from: a */
        public abstract EGLConfig mo19958a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C8834a(int[] iArr) {
            this.f2728a = m15738a(iArr);
        }

        /* renamed from: a */
        public EGLConfig mo19957a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f2728a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.f2728a, eGLConfigArr, i, iArr)) {
                    EGLConfig a = mo19958a(egl10, eGLDisplay, eGLConfigArr);
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        /* renamed from: a */
        private int[] m15738a(int[] iArr) {
            if (TXCGLSurfaceViewBase.this.f17116o != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$k */
    public interface C8835k {
        /* renamed from: a */
        GL mo19959a(GL gl);
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$b */
    class C16525b extends C8834a {
        /* renamed from: c */
        protected int f3562c;
        /* renamed from: d */
        protected int f3563d;
        /* renamed from: e */
        protected int f3564e;
        /* renamed from: f */
        protected int f3565f;
        /* renamed from: g */
        protected int f3566g;
        /* renamed from: h */
        protected int f3567h;
        /* renamed from: j */
        private int[] f3569j = new int[1];

        public C16525b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            AppMethodBeat.m2504i(67351);
            this.f3562c = i;
            this.f3563d = i2;
            this.f3564e = i3;
            this.f3565f = i4;
            this.f3566g = i5;
            this.f3567h = i6;
            AppMethodBeat.m2505o(67351);
        }

        /* renamed from: a */
        public EGLConfig mo19958a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(67352);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m25395a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m25395a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f3566g && a2 >= this.f3567h) {
                    a = m25395a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m25395a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m25395a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m25395a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f3562c && a3 == this.f3563d && a4 == this.f3564e && a2 == this.f3565f) {
                        AppMethodBeat.m2505o(67352);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.m2505o(67352);
            return null;
        }

        /* renamed from: a */
        private int m25395a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            AppMethodBeat.m2504i(67353);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f3569j)) {
                i2 = this.f3569j[0];
                AppMethodBeat.m2505o(67353);
                return i2;
            }
            AppMethodBeat.m2505o(67353);
            return i2;
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$d */
    static class C17806d implements C41700g {
        private C17806d() {
        }

        /* synthetic */ C17806d(C321731 c321731) {
            this();
        }

        /* renamed from: a */
        public EGLSurface mo32961a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.m2504i(67311);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                TXCLog.m15676e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.m15676e("TXCGLSurfaceViewBase", e.toString());
            }
            AppMethodBeat.m2505o(67311);
            return eGLSurface;
        }

        /* renamed from: a */
        public void mo32962a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(67312);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.m2505o(67312);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$m */
    class C17807m extends C16525b {
        public C17807m(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
            AppMethodBeat.m2504i(67238);
            AppMethodBeat.m2505o(67238);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$c */
    class C25668c implements C37371f {
        /* renamed from: b */
        private int f5367b;

        private C25668c() {
            this.f5367b = 12440;
        }

        /* synthetic */ C25668c(TXCGLSurfaceViewBase tXCGLSurfaceViewBase, C321731 c321731) {
            this();
        }

        /* renamed from: a */
        public EGLContext mo43431a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(67219);
            int[] iArr = new int[]{this.f5367b, TXCGLSurfaceViewBase.this.f17116o, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TXCGLSurfaceViewBase.this.f17116o == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.m2505o(67219);
            return eglCreateContext;
        }

        /* renamed from: a */
        public void mo43432a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(67220);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                TXCLog.m15676e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                C37372h.m62903a("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.m2505o(67220);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$i */
    static class C25669i extends Thread {
        /* renamed from: a */
        private boolean f5368a;
        /* renamed from: b */
        private boolean f5369b;
        /* renamed from: c */
        private boolean f5370c;
        /* renamed from: d */
        private boolean f5371d;
        /* renamed from: e */
        private boolean f5372e;
        /* renamed from: f */
        private boolean f5373f;
        /* renamed from: g */
        private boolean f5374g;
        /* renamed from: h */
        private boolean f5375h;
        /* renamed from: i */
        private boolean f5376i;
        /* renamed from: j */
        private boolean f5377j;
        /* renamed from: k */
        private boolean f5378k;
        /* renamed from: l */
        private int f5379l = 0;
        /* renamed from: m */
        private int f5380m = 0;
        /* renamed from: n */
        private int f5381n = 1;
        /* renamed from: o */
        private boolean f5382o = true;
        /* renamed from: p */
        private boolean f5383p;
        /* renamed from: q */
        private ArrayList<Runnable> f5384q = new ArrayList();
        /* renamed from: r */
        private boolean f5385r = true;
        /* renamed from: s */
        private C37372h f5386s;
        /* renamed from: t */
        private WeakReference<TXCGLSurfaceViewBase> f5387t;

        C25669i(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            AppMethodBeat.m2504i(67204);
            this.f5387t = weakReference;
            AppMethodBeat.m2505o(67204);
        }

        public void run() {
            AppMethodBeat.m2504i(67205);
            setName("GLThread " + getId());
            try {
                m40721i();
            } catch (InterruptedException e) {
            } finally {
                TXCGLSurfaceViewBase.f17102a.mo43445a(this);
                AppMethodBeat.m2505o(67205);
            }
        }

        /* renamed from: a */
        public int mo43433a() {
            AppMethodBeat.m2504i(67206);
            int c = this.f5386s.mo60186c();
            AppMethodBeat.m2505o(67206);
            return c;
        }

        /* renamed from: b */
        public C37372h mo43437b() {
            return this.f5386s;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A:{SYNTHETIC, Splitter:B:18:0x0052} */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A:{SYNTHETIC, Splitter:B:24:0x006b} */
        /* JADX WARNING: Missing block: B:141:0x0288, code skipped:
            if (r8 == null) goto L_0x02d7;
     */
        /* JADX WARNING: Missing block: B:142:0x028a, code skipped:
            r1 = 1;
     */
        /* JADX WARNING: Missing block: B:143:0x028b, code skipped:
            r2 = r1;
            r14 = r13;
     */
        /* JADX WARNING: Missing block: B:175:0x02d7, code skipped:
            r1 = r2;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: i */
        private void m40721i() {
            AppMethodBeat.m2504i(67207);
            this.f5386s = new C37372h(this.f5387t);
            this.f5375h = false;
            this.f5376i = false;
            Object obj = null;
            C25670j c25670j = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            int i = 0;
            Object obj6 = null;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            C25670j c25670j2 = null;
            while (true) {
                C25670j e = TXCGLSurfaceViewBase.f17102a;
                synchronized (e) {
                    if (this.f5368a) {
                        boolean th = this.f5384q.isEmpty();
                        if (th != null) {
                            C25670j e2;
                            try {
                                boolean z;
                                TXCGLSurfaceViewBase tXCGLSurfaceViewBase;
                                if (this.f5371d != this.f5370c) {
                                    th = this.f5370c;
                                    this.f5371d = this.f5370c;
                                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                                    z = th;
                                } else {
                                    z = th;
                                }
                                if (this.f5378k) {
                                    m40722j();
                                    m40723k();
                                    this.f5378k = false;
                                    obj6 = 1;
                                }
                                if (obj3 != null) {
                                    m40722j();
                                    m40723k();
                                    obj3 = null;
                                }
                                if (z && this.f5376i) {
                                    m40722j();
                                }
                                if (z && this.f5375h) {
                                    tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f5387t.get();
                                    if (tXCGLSurfaceViewBase == null) {
                                        th = false;
                                    } else {
                                        th = tXCGLSurfaceViewBase.f17117p;
                                    }
                                    if (!th || TXCGLSurfaceViewBase.f17102a.mo43447a()) {
                                        m40723k();
                                    }
                                }
                                if (z && TXCGLSurfaceViewBase.f17102a.mo43448b()) {
                                    this.f5386s.mo60190g();
                                }
                                if (!(this.f5372e || this.f5374g)) {
                                    if (this.f5376i) {
                                        m40722j();
                                    }
                                    this.f5374g = true;
                                    this.f5373f = false;
                                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                                }
                                if (this.f5372e && this.f5374g) {
                                    this.f5374g = false;
                                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                                }
                                if (i != 0) {
                                    obj5 = null;
                                    i = 0;
                                    this.f5383p = true;
                                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                                }
                                if (m40724l()) {
                                    if (!this.f5375h) {
                                        if (obj6 != null) {
                                            obj6 = null;
                                        } else if (TXCGLSurfaceViewBase.f17102a.mo43449b(this)) {
                                            th = this.f5386s;
                                            th.mo60184a();
                                            this.f5375h = th;
                                            obj = 1;
                                            TXCGLSurfaceViewBase.f17102a.notifyAll();
                                        }
                                    }
                                    if (this.f5375h && !this.f5376i) {
                                        this.f5376i = true;
                                        c25670j = true;
                                        obj2 = 1;
                                        obj4 = 1;
                                    }
                                    if (this.f5376i) {
                                        int i4;
                                        if (this.f5385r) {
                                            obj4 = 1;
                                            i2 = this.f5379l;
                                            i4 = this.f5380m;
                                            obj5 = 1;
                                            c25670j = true;
                                            this.f5385r = false;
                                        } else {
                                            i4 = i3;
                                        }
                                        this.f5382o = false;
                                        TXCGLSurfaceViewBase.f17102a.notifyAll();
                                        i3 = i4;
                                        if (runnable == null) {
                                            runnable.run();
                                            runnable = null;
                                        } else {
                                            GL10 gl10;
                                            if (c25670j != null) {
                                                if (this.f5386s.mo60185b()) {
                                                    c25670j = TXCGLSurfaceViewBase.f17102a;
                                                    synchronized (c25670j) {
                                                        this.f5377j = true;
                                                        e2 = TXCGLSurfaceViewBase.f17102a;
                                                        e2.notifyAll();
                                                    }
                                                    c25670j = e2;
                                                } else {
                                                    synchronized (TXCGLSurfaceViewBase.f17102a) {
                                                        this.f5377j = true;
                                                        this.f5373f = true;
                                                        TXCGLSurfaceViewBase.f17102a.notifyAll();
                                                    }
                                                }
                                            }
                                            if (obj2 != null) {
                                                GL10 gl102 = (GL10) this.f5386s.mo60187d();
                                                TXCGLSurfaceViewBase.f17102a.mo43446a(gl102);
                                                obj2 = null;
                                                gl10 = gl102;
                                            } else {
                                                Object gl103 = c25670j2;
                                            }
                                            if (obj != null) {
                                                tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f5387t.get();
                                                if (tXCGLSurfaceViewBase != null) {
                                                    tXCGLSurfaceViewBase.f17109h.onSurfaceCreated(gl103, this.f5386s.f15982d);
                                                }
                                                obj = null;
                                            }
                                            if (obj4 != null) {
                                                tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f5387t.get();
                                                if (tXCGLSurfaceViewBase != null) {
                                                    tXCGLSurfaceViewBase.f17109h.onSurfaceChanged(gl103, i2, i3);
                                                }
                                                obj4 = null;
                                            }
                                            tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f5387t.get();
                                            if (tXCGLSurfaceViewBase != null) {
                                                tXCGLSurfaceViewBase.f17109h.onDrawFrame(gl103);
                                                i4 = tXCGLSurfaceViewBase.mo52806c();
                                            } else {
                                                i4 = 12288;
                                            }
                                            switch (i4) {
                                                case 12288:
                                                    break;
                                                case 12302:
                                                    obj3 = 1;
                                                    break;
                                                default:
                                                    e = "eglSwapBuffers";
                                                    C37372h.m62904a("GLThread", e, i4);
                                                    c25670j2 = TXCGLSurfaceViewBase.f17102a;
                                                    synchronized (c25670j2) {
                                                        this.f5373f = true;
                                                        TXCGLSurfaceViewBase.f17102a.notifyAll();
                                                    }
                                            }
                                        }
                                    }
                                }
                                TXCGLSurfaceViewBase.f17102a.wait();
                                if (this.f5368a) {
                                }
                            } catch (RuntimeException e3) {
                                e2 = e3;
                                TXCGLSurfaceViewBase.f17102a.mo43450c(this);
                                throw e2;
                            } catch (Throwable th2) {
                                th = th2;
                                i = TXCGLSurfaceViewBase.f17102a;
                                synchronized (i) {
                                    try {
                                        m40722j();
                                        m40723k();
                                    } catch (Throwable th3) {
                                        while (true) {
                                            AppMethodBeat.m2505o(67207);
                                        }
                                    }
                                }
                            } finally {
                                i = 67207;
                                AppMethodBeat.m2505o(67207);
                            }
                        }
                        runnable = (Runnable) this.f5384q.remove(0);
                        if (runnable == null) {
                        }
                    }
                    synchronized (TXCGLSurfaceViewBase.f17102a) {
                        try {
                            m40722j();
                            m40723k();
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(67207);
                            }
                        }
                    }
                    return;
                }
            }
            AppMethodBeat.m2505o(i);
        }

        /* renamed from: j */
        private void m40722j() {
            AppMethodBeat.m2504i(67208);
            if (this.f5376i) {
                this.f5376i = false;
                this.f5386s.mo60189f();
            }
            AppMethodBeat.m2505o(67208);
        }

        /* renamed from: k */
        private void m40723k() {
            AppMethodBeat.m2504i(67209);
            if (this.f5375h) {
                this.f5386s.mo60190g();
                this.f5375h = false;
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f5387t.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f17107f = false;
                }
                TXCGLSurfaceViewBase.f17102a.mo43450c(this);
            }
            AppMethodBeat.m2505o(67209);
        }

        /* renamed from: c */
        public boolean mo43438c() {
            AppMethodBeat.m2504i(67210);
            if (this.f5375h && this.f5376i && m40724l()) {
                AppMethodBeat.m2505o(67210);
                return true;
            }
            AppMethodBeat.m2505o(67210);
            return false;
        }

        /* renamed from: l */
        private boolean m40724l() {
            return !this.f5371d && this.f5372e && !this.f5373f && this.f5379l > 0 && this.f5380m > 0 && (this.f5382o || this.f5381n == 1);
        }

        /* renamed from: a */
        public void mo43434a(int i) {
            AppMethodBeat.m2504i(67211);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.m2505o(67211);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5381n = i;
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67211);
                }
            }
        }

        /* renamed from: d */
        public int mo43439d() {
            int i;
            AppMethodBeat.m2504i(67212);
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    i = this.f5381n;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67212);
                }
            }
            return i;
        }

        /* renamed from: e */
        public void mo43440e() {
            AppMethodBeat.m2504i(67213);
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5372e = true;
                    this.f5377j = false;
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                    while (this.f5374g && !this.f5377j && !this.f5369b) {
                        TXCGLSurfaceViewBase.f17102a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67213);
                }
            }
            AppMethodBeat.m2505o(67213);
        }

        /* renamed from: f */
        public void mo43441f() {
            AppMethodBeat.m2504i(67214);
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5372e = false;
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                    while (!this.f5374g && !this.f5369b) {
                        TXCGLSurfaceViewBase.f17102a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67214);
                }
            }
            AppMethodBeat.m2505o(67214);
        }

        /* renamed from: a */
        public void mo43435a(int i, int i2) {
            AppMethodBeat.m2504i(67215);
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5379l = i;
                    this.f5380m = i2;
                    this.f5385r = true;
                    this.f5382o = true;
                    this.f5383p = false;
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                    while (!this.f5369b && !this.f5371d && !this.f5383p && mo43438c()) {
                        TXCGLSurfaceViewBase.f17102a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67215);
                }
            }
            AppMethodBeat.m2505o(67215);
        }

        /* renamed from: g */
        public void mo43442g() {
            AppMethodBeat.m2504i(67216);
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5368a = true;
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                    while (!this.f5369b) {
                        TXCGLSurfaceViewBase.f17102a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67216);
                }
            }
            AppMethodBeat.m2505o(67216);
        }

        /* renamed from: h */
        public void mo43443h() {
            AppMethodBeat.m2504i(67217);
            this.f5378k = true;
            TXCGLSurfaceViewBase.f17102a.notifyAll();
            AppMethodBeat.m2505o(67217);
        }

        /* renamed from: a */
        public void mo43436a(Runnable runnable) {
            AppMethodBeat.m2504i(67218);
            if (runnable == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
                AppMethodBeat.m2505o(67218);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.f17102a) {
                try {
                    this.f5384q.add(runnable);
                    TXCGLSurfaceViewBase.f17102a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67218);
                }
            }
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j */
    static class C25670j {
        /* renamed from: a */
        private static String f5388a = "GLThreadManager";
        /* renamed from: b */
        private boolean f5389b;
        /* renamed from: c */
        private int f5390c;
        /* renamed from: d */
        private boolean f5391d;
        /* renamed from: e */
        private boolean f5392e;
        /* renamed from: f */
        private boolean f5393f;
        /* renamed from: g */
        private C25669i f5394g;

        private C25670j() {
        }

        /* synthetic */ C25670j(C321731 c321731) {
            this();
        }

        /* renamed from: a */
        public synchronized void mo43445a(C25669i c25669i) {
            AppMethodBeat.m2504i(67300);
            c25669i.f5369b = true;
            if (this.f5394g == c25669i) {
                this.f5394g = null;
            }
            notifyAll();
            AppMethodBeat.m2505o(67300);
        }

        /* renamed from: b */
        public boolean mo43449b(C25669i c25669i) {
            AppMethodBeat.m2504i(67301);
            if (this.f5394g == c25669i || this.f5394g == null) {
                this.f5394g = c25669i;
                notifyAll();
                AppMethodBeat.m2505o(67301);
                return true;
            }
            m40736c();
            if (this.f5392e) {
                AppMethodBeat.m2505o(67301);
                return true;
            }
            if (this.f5394g != null) {
                this.f5394g.mo43443h();
            }
            AppMethodBeat.m2505o(67301);
            return false;
        }

        /* renamed from: c */
        public void mo43450c(C25669i c25669i) {
            AppMethodBeat.m2504i(67302);
            if (this.f5394g == c25669i) {
                this.f5394g = null;
            }
            notifyAll();
            AppMethodBeat.m2505o(67302);
        }

        /* renamed from: a */
        public synchronized boolean mo43447a() {
            return this.f5393f;
        }

        /* renamed from: b */
        public synchronized boolean mo43448b() {
            boolean z;
            AppMethodBeat.m2504i(67303);
            m40736c();
            if (this.f5392e) {
                z = false;
                AppMethodBeat.m2505o(67303);
            } else {
                z = true;
                AppMethodBeat.m2505o(67303);
            }
            return z;
        }

        /* renamed from: a */
        public synchronized void mo43446a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.m2504i(67304);
                if (!this.f5391d) {
                    m40736c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f5390c < WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                        this.f5392e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.f5392e) {
                        z = false;
                    }
                    this.f5393f = z;
                    this.f5391d = true;
                }
                AppMethodBeat.m2505o(67304);
            }
        }

        /* renamed from: c */
        private void m40736c() {
            this.f5390c = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            this.f5392e = true;
            this.f5389b = true;
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$l */
    static class C25671l extends Writer {
        /* renamed from: a */
        private StringBuilder f5395a = new StringBuilder();

        C25671l() {
            AppMethodBeat.m2504i(67306);
            AppMethodBeat.m2505o(67306);
        }

        public void close() {
            AppMethodBeat.m2504i(67307);
            m40743a();
            AppMethodBeat.m2505o(67307);
        }

        public void flush() {
            AppMethodBeat.m2504i(67308);
            m40743a();
            AppMethodBeat.m2505o(67308);
        }

        public void write(char[] cArr, int i, int i2) {
            AppMethodBeat.m2504i(67309);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    m40743a();
                } else {
                    this.f5395a.append(c);
                }
            }
            AppMethodBeat.m2505o(67309);
        }

        /* renamed from: a */
        private void m40743a() {
            AppMethodBeat.m2504i(67310);
            if (this.f5395a.length() > 0) {
                TXCLog.m15678v("TXCGLSurfaceViewBase", this.f5395a.toString());
                this.f5395a.delete(0, this.f5395a.length());
            }
            AppMethodBeat.m2505o(67310);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$1 */
    class C321731 implements Runnable {
        C321731() {
        }

        public void run() {
            AppMethodBeat.m2504i(67337);
            TXCGLSurfaceViewBase.this.mo52804b();
            AppMethodBeat.m2505o(67337);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$2 */
    class C321742 implements Runnable {
        C321742() {
        }

        public void run() {
            AppMethodBeat.m2504i(67272);
            TXCGLSurfaceViewBase.this.mo52804b();
            AppMethodBeat.m2505o(67272);
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$f */
    public interface C37371f {
        /* renamed from: a */
        EGLContext mo43431a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: a */
        void mo43432a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h */
    public static class C37372h {
        /* renamed from: a */
        EGL10 f15979a;
        /* renamed from: b */
        EGLDisplay f15980b;
        /* renamed from: c */
        EGLSurface f15981c;
        /* renamed from: d */
        EGLConfig f15982d;
        /* renamed from: e */
        EGLContext f15983e;
        /* renamed from: f */
        private WeakReference<TXCGLSurfaceViewBase> f15984f;

        public C37372h(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            this.f15984f = weakReference;
        }

        /* renamed from: a */
        public void mo60184a() {
            AppMethodBeat.m2504i(67171);
            this.f15979a = (EGL10) EGLContext.getEGL();
            this.f15980b = this.f15979a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.f15980b == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.m2505o(67171);
                throw runtimeException;
            }
            if (this.f15979a.eglInitialize(this.f15980b, new int[2])) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f15984f.get();
                if (tXCGLSurfaceViewBase == null) {
                    this.f15982d = null;
                    this.f15983e = null;
                } else {
                    this.f15982d = tXCGLSurfaceViewBase.f17111j.mo19957a(this.f15979a, this.f15980b);
                    this.f15983e = tXCGLSurfaceViewBase.f17112k.mo43431a(this.f15979a, this.f15980b, this.f15982d);
                }
                if (this.f15983e == null || this.f15983e == EGL10.EGL_NO_CONTEXT) {
                    this.f15983e = null;
                    m62902a("createContext");
                }
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f17107f = true;
                }
                this.f15981c = null;
                AppMethodBeat.m2505o(67171);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.m2505o(67171);
            throw runtimeException;
        }

        /* renamed from: b */
        public boolean mo60185b() {
            AppMethodBeat.m2504i(67172);
            RuntimeException runtimeException;
            if (this.f15979a == null) {
                runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.m2505o(67172);
                throw runtimeException;
            } else if (this.f15980b == null) {
                runtimeException = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.m2505o(67172);
                throw runtimeException;
            } else if (this.f15982d == null) {
                runtimeException = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.m2505o(67172);
                throw runtimeException;
            } else {
                m62906h();
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f15984f.get();
                if (tXCGLSurfaceViewBase != null) {
                    this.f15981c = tXCGLSurfaceViewBase.f17113l.mo32961a(this.f15979a, this.f15980b, this.f15982d, tXCGLSurfaceViewBase.getHolder());
                } else {
                    this.f15981c = null;
                }
                if (this.f15981c == null || this.f15981c == EGL10.EGL_NO_SURFACE) {
                    if (this.f15979a.eglGetError() == 12299) {
                        TXCLog.m15676e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    AppMethodBeat.m2505o(67172);
                    return false;
                } else if (this.f15979a.eglMakeCurrent(this.f15980b, this.f15981c, this.f15981c, this.f15983e)) {
                    if (tXCGLSurfaceViewBase != null) {
                        tXCGLSurfaceViewBase.f17106e = true;
                    }
                    AppMethodBeat.m2505o(67172);
                    return true;
                } else {
                    C37372h.m62904a("EGLHelper", "eglMakeCurrent", this.f15979a.eglGetError());
                    AppMethodBeat.m2505o(67172);
                    return false;
                }
            }
        }

        /* renamed from: c */
        public int mo60186c() {
            AppMethodBeat.m2504i(67173);
            int e = mo60188e();
            AppMethodBeat.m2505o(67173);
            return e;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: d */
        public GL mo60187d() {
            AppMethodBeat.m2504i(67174);
            GL gl = this.f15983e.getGL();
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f15984f.get();
            if (tXCGLSurfaceViewBase != null) {
                if (tXCGLSurfaceViewBase.f17114m != null) {
                    gl = tXCGLSurfaceViewBase.f17114m.mo19959a(gl);
                }
                if ((tXCGLSurfaceViewBase.f17115n & 3) != 0) {
                    Writer c25671l;
                    int i = 0;
                    if ((tXCGLSurfaceViewBase.f17115n & 1) != 0) {
                        i = 1;
                    }
                    if ((tXCGLSurfaceViewBase.f17115n & 2) != 0) {
                        c25671l = new C25671l();
                    } else {
                        c25671l = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i, c25671l);
                }
            }
            AppMethodBeat.m2505o(67174);
            return gl;
        }

        /* renamed from: e */
        public int mo60188e() {
            AppMethodBeat.m2504i(67175);
            if (this.f15979a.eglSwapBuffers(this.f15980b, this.f15981c)) {
                AppMethodBeat.m2505o(67175);
                return 12288;
            }
            int eglGetError = this.f15979a.eglGetError();
            AppMethodBeat.m2505o(67175);
            return eglGetError;
        }

        /* renamed from: f */
        public void mo60189f() {
            AppMethodBeat.m2504i(67176);
            m62906h();
            AppMethodBeat.m2505o(67176);
        }

        /* renamed from: h */
        private void m62906h() {
            AppMethodBeat.m2504i(67177);
            if (!(this.f15981c == null || this.f15981c == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.f15979a;
                EGLDisplay eGLDisplay = this.f15980b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f15984f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f17113l.mo32962a(this.f15979a, this.f15980b, this.f15981c);
                    tXCGLSurfaceViewBase.f17106e = false;
                }
                this.f15981c = null;
            }
            AppMethodBeat.m2505o(67177);
        }

        /* renamed from: g */
        public void mo60190g() {
            AppMethodBeat.m2504i(67178);
            if (this.f15983e != null) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f15984f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f17112k.mo43432a(this.f15979a, this.f15980b, this.f15983e);
                }
                this.f15983e = null;
            }
            if (this.f15980b != null) {
                this.f15979a.eglTerminate(this.f15980b);
                this.f15980b = null;
            }
            AppMethodBeat.m2505o(67178);
        }

        /* renamed from: a */
        private void m62902a(String str) {
            AppMethodBeat.m2504i(67179);
            C37372h.m62903a(str, this.f15979a.eglGetError());
            AppMethodBeat.m2505o(67179);
        }

        /* renamed from: a */
        public static void m62903a(String str, int i) {
            AppMethodBeat.m2504i(67180);
            RuntimeException runtimeException = new RuntimeException(C37372h.m62905b(str, i));
            AppMethodBeat.m2505o(67180);
            throw runtimeException;
        }

        /* renamed from: a */
        public static void m62904a(String str, String str2, int i) {
            AppMethodBeat.m2504i(67181);
            TXCLog.m15679w(str, C37372h.m62905b(str2, i));
            AppMethodBeat.m2505o(67181);
        }

        /* renamed from: b */
        public static String m62905b(String str, int i) {
            AppMethodBeat.m2504i(67182);
            String str2 = str + " failed: " + i;
            AppMethodBeat.m2505o(67182);
            return str2;
        }
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$e */
    public interface C41699e {
        /* renamed from: a */
        EGLConfig mo19957a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceViewBase$g */
    public interface C41700g {
        /* renamed from: a */
        EGLSurface mo32961a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: a */
        void mo32962a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public TXCGLSurfaceViewBase(Context context) {
        super(context);
        AppMethodBeat.m2504i(67313);
        mo14490a();
        AppMethodBeat.m2505o(67313);
    }

    public TXCGLSurfaceViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(67314);
        mo14490a();
        AppMethodBeat.m2505o(67314);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public int mo52806c() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(67315);
        try {
            if (this.f17108g != null) {
                this.f17108g.mo43442g();
            }
            super.finalize();
            AppMethodBeat.m2505o(67315);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(67315);
        }
    }

    /* renamed from: a */
    private void mo14490a() {
        AppMethodBeat.m2504i(67316);
        getHolder().addCallback(this);
        AppMethodBeat.m2505o(67316);
    }

    public void setGLWrapper(C8835k c8835k) {
        this.f17114m = c8835k;
    }

    public void setDebugFlags(int i) {
        this.f17115n = i;
    }

    public int getDebugFlags() {
        return this.f17115n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.f17117p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f17117p;
    }

    public void setRenderer(Renderer renderer) {
        AppMethodBeat.m2504i(67317);
        m73348f();
        if (this.f17111j == null) {
            this.f17111j = new C17807m(true);
        }
        if (this.f17112k == null) {
            this.f17112k = new C25668c(this, null);
        }
        if (this.f17113l == null) {
            this.f17113l = new C17806d();
        }
        this.f17109h = renderer;
        this.f17108g = new C25669i(this.f17105d);
        this.f17108g.start();
        AppMethodBeat.m2505o(67317);
    }

    public void setEGLContextFactory(C37371f c37371f) {
        AppMethodBeat.m2504i(67318);
        m73348f();
        this.f17112k = c37371f;
        AppMethodBeat.m2505o(67318);
    }

    public void setEGLWindowSurfaceFactory(C41700g c41700g) {
        AppMethodBeat.m2504i(67319);
        m73348f();
        this.f17113l = c41700g;
        AppMethodBeat.m2505o(67319);
    }

    public void setEGLConfigChooser(C41699e c41699e) {
        AppMethodBeat.m2504i(67320);
        m73348f();
        this.f17111j = c41699e;
        AppMethodBeat.m2505o(67320);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.m2504i(67321);
        setEGLConfigChooser(new C17807m(z));
        AppMethodBeat.m2505o(67321);
    }

    /* renamed from: a */
    public void mo67349a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(67322);
        setEGLConfigChooser(new C16525b(i, i2, i3, i4, i5, i6));
        AppMethodBeat.m2505o(67322);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.m2504i(67323);
        m73348f();
        this.f17116o = i;
        AppMethodBeat.m2505o(67323);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(67324);
        this.f17108g.mo43434a(i);
        AppMethodBeat.m2505o(67324);
    }

    public int getRenderMode() {
        AppMethodBeat.m2504i(67325);
        int d = this.f17108g.mo43439d();
        AppMethodBeat.m2505o(67325);
        return d;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(67326);
        this.f17108g.mo43440e();
        setRunInBackground(false);
        AppMethodBeat.m2505o(67326);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(67327);
        setRunInBackground(true);
        if (!this.f17103b) {
            this.f17108g.mo43436a(new C321731());
            this.f17108g.mo43441f();
        }
        AppMethodBeat.m2505o(67327);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo52804b() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(67328);
        this.f17108g.mo43435a(i2, i3);
        AppMethodBeat.m2505o(67328);
    }

    /* renamed from: b */
    public void mo67350b(boolean z) {
        AppMethodBeat.m2504i(67329);
        this.f17103b = z;
        if (!(this.f17103b || !this.f17104c || this.f17108g == null)) {
            TXCLog.m15679w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.f17108g.mo43436a(new C321742());
            this.f17108g.mo43441f();
        }
        AppMethodBeat.m2505o(67329);
    }

    /* Access modifiers changed, original: protected */
    public void setRunInBackground(boolean z) {
        this.f17104c = z;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(67330);
        super.onAttachedToWindow();
        if (this.f17110i && this.f17109h != null) {
            int d;
            if (this.f17108g != null) {
                d = this.f17108g.mo43439d();
            } else {
                d = 1;
            }
            this.f17108g = new C25669i(this.f17105d);
            if (d != 1) {
                this.f17108g.mo43434a(d);
            }
            this.f17108g.start();
        }
        this.f17110i = false;
        AppMethodBeat.m2505o(67330);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(67331);
        if (this.f17108g != null) {
            this.f17108g.mo43442g();
        }
        this.f17110i = true;
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(67331);
    }

    /* renamed from: f */
    private void m73348f() {
        AppMethodBeat.m2504i(67332);
        if (this.f17108g != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.m2505o(67332);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(67332);
    }

    /* renamed from: d */
    public int mo67351d() {
        AppMethodBeat.m2504i(67333);
        int a = this.f17108g.mo43433a();
        AppMethodBeat.m2505o(67333);
        return a;
    }

    public C37372h getEGLHelper() {
        AppMethodBeat.m2504i(67334);
        C37372h b = this.f17108g.mo43437b();
        AppMethodBeat.m2505o(67334);
        return b;
    }

    static {
        AppMethodBeat.m2504i(67335);
        AppMethodBeat.m2505o(67335);
    }
}
