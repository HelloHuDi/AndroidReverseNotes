package com.tencent.map.lib.p822gl;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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

/* renamed from: com.tencent.map.lib.gl.e */
public class C25724e extends SurfaceView implements Callback {
    /* renamed from: a */
    private static final C25723j f5437a = new C25723j();
    /* renamed from: b */
    private final WeakReference<C25724e> f5438b = new WeakReference(this);
    /* renamed from: c */
    private C8890i f5439c;
    /* renamed from: d */
    private C25725m f5440d;
    /* renamed from: e */
    private boolean f5441e;
    /* renamed from: f */
    private C25728e f5442f;
    /* renamed from: g */
    private C25730f f5443g;
    /* renamed from: h */
    private C25727g f5444h;
    /* renamed from: i */
    private C8891k f5445i;
    /* renamed from: j */
    private int f5446j;
    /* renamed from: k */
    private int f5447k;
    /* renamed from: l */
    private boolean f5448l;

    /* renamed from: com.tencent.map.lib.gl.e$i */
    static class C8890i extends Thread {
        /* renamed from: a */
        private boolean f2816a;
        /* renamed from: b */
        private boolean f2817b;
        /* renamed from: c */
        private boolean f2818c;
        /* renamed from: d */
        private boolean f2819d;
        /* renamed from: e */
        private boolean f2820e;
        /* renamed from: f */
        private boolean f2821f;
        /* renamed from: g */
        private boolean f2822g;
        /* renamed from: h */
        private boolean f2823h;
        /* renamed from: i */
        private boolean f2824i;
        /* renamed from: j */
        private boolean f2825j;
        /* renamed from: k */
        private boolean f2826k;
        /* renamed from: l */
        private int f2827l = 0;
        /* renamed from: m */
        private int f2828m = 0;
        /* renamed from: n */
        private int f2829n = 1;
        /* renamed from: o */
        private boolean f2830o = true;
        /* renamed from: p */
        private boolean f2831p;
        /* renamed from: q */
        private ArrayList<Runnable> f2832q = new ArrayList();
        /* renamed from: r */
        private boolean f2833r = true;
        /* renamed from: s */
        private C25731h f2834s;
        /* renamed from: t */
        private WeakReference<C25724e> f2835t;

        C8890i(WeakReference<C25724e> weakReference) {
            AppMethodBeat.m2504i(98075);
            this.f2835t = weakReference;
            AppMethodBeat.m2505o(98075);
        }

        public void run() {
            AppMethodBeat.m2504i(98076);
            setName("GLThread " + getId());
            try {
                m16011l();
            } catch (InterruptedException e) {
            } finally {
                C25724e.f5437a.mo43568a(this);
                AppMethodBeat.m2505o(98076);
            }
        }

        /* renamed from: j */
        private void m16009j() {
            AppMethodBeat.m2504i(98077);
            if (this.f2824i) {
                this.f2824i = false;
                this.f2834s.mo43599e();
            }
            AppMethodBeat.m2505o(98077);
        }

        /* renamed from: k */
        private void m16010k() {
            AppMethodBeat.m2504i(98078);
            if (this.f2823h) {
                this.f2834s.mo43600f();
                this.f2823h = false;
                C25724e.f5437a.mo43573c(this);
            }
            AppMethodBeat.m2505o(98078);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A:{SYNTHETIC, Splitter:B:20:0x0065} */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x01f8  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A:{SYNTHETIC, Splitter:B:26:0x007e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: l */
        private void m16011l() {
            AppMethodBeat.m2504i(98079);
            this.f2834s = new C25731h(this.f2835t);
            this.f2823h = false;
            this.f2824i = false;
            Object obj = null;
            C25723j c25723j = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            int i = 0;
            Object obj6 = null;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            C25723j c25723j2 = null;
            while (true) {
                boolean th;
                int i4;
                try {
                    C25723j c = C25724e.f5437a;
                    synchronized (c) {
                        C25724e c25724e;
                        if (this.f2816a) {
                            th = this.f2832q.isEmpty();
                            if (th) {
                                boolean z;
                                if (this.f2819d != this.f2818c) {
                                    th = this.f2818c;
                                    this.f2819d = this.f2818c;
                                    C25724e.f5437a.notifyAll();
                                    z = th;
                                } else {
                                    z = th;
                                }
                                if (this.f2826k) {
                                    m16009j();
                                    m16010k();
                                    this.f2826k = false;
                                    obj6 = 1;
                                }
                                if (obj3 != null) {
                                    m16009j();
                                    m16010k();
                                    obj3 = null;
                                }
                                if (z && this.f2824i) {
                                    m16009j();
                                }
                                if (z && this.f2823h) {
                                    c25724e = (C25724e) this.f2835t.get();
                                    if (c25724e == null) {
                                        th = false;
                                    } else {
                                        th = c25724e.f5448l;
                                    }
                                    if (!th || C25724e.f5437a.mo43570a()) {
                                        m16010k();
                                    }
                                }
                                if (z && C25724e.f5437a.mo43571b()) {
                                    this.f2834s.mo43600f();
                                }
                                if (!(this.f2820e || this.f2822g)) {
                                    if (this.f2824i) {
                                        m16009j();
                                    }
                                    this.f2822g = true;
                                    this.f2821f = false;
                                    C25724e.f5437a.notifyAll();
                                }
                                if (this.f2820e && this.f2822g) {
                                    this.f2822g = false;
                                    C25724e.f5437a.notifyAll();
                                }
                                if (i != 0) {
                                    obj5 = null;
                                    i = 0;
                                    this.f2831p = true;
                                    C25724e.f5437a.notifyAll();
                                }
                                if (m16012m()) {
                                    if (!this.f2823h) {
                                        if (obj6 != null) {
                                            obj6 = null;
                                        } else if (C25724e.f5437a.mo43572b(this)) {
                                            try {
                                                this.f2834s.mo43595a();
                                            } catch (RuntimeException e) {
                                                C25724e.f5437a.mo43573c(this);
                                            }
                                            this.f2823h = true;
                                            obj = 1;
                                            C25724e.f5437a.notifyAll();
                                        }
                                    }
                                    if (this.f2823h && !this.f2824i) {
                                        this.f2824i = true;
                                        c25723j = true;
                                        obj2 = 1;
                                        obj4 = 1;
                                    }
                                    if (this.f2824i) {
                                        if (this.f2833r) {
                                            obj4 = 1;
                                            i2 = this.f2827l;
                                            i4 = this.f2828m;
                                            obj5 = 1;
                                            c25723j = true;
                                            this.f2833r = false;
                                        } else {
                                            i4 = i3;
                                        }
                                        this.f2830o = false;
                                        C25724e.f5437a.notifyAll();
                                        i3 = i4;
                                        if (runnable == null) {
                                            runnable.run();
                                            runnable = null;
                                        } else {
                                            GL10 gl10;
                                            if (c25723j != null) {
                                                if (this.f2834s.mo43596b()) {
                                                    C25723j c2;
                                                    c25723j = C25724e.f5437a;
                                                    synchronized (c25723j) {
                                                        this.f2825j = true;
                                                        c2 = C25724e.f5437a;
                                                        c2.notifyAll();
                                                    }
                                                    c25723j = c2;
                                                } else {
                                                    synchronized (C25724e.f5437a) {
                                                        this.f2825j = true;
                                                        this.f2821f = true;
                                                        C25724e.f5437a.notifyAll();
                                                    }
                                                }
                                            }
                                            if (obj2 != null) {
                                                GL10 gl102 = (GL10) this.f2834s.mo43597c();
                                                C25724e.f5437a.mo43569a(gl102);
                                                obj2 = null;
                                                gl10 = gl102;
                                            } else {
                                                Object gl103 = c25723j2;
                                            }
                                            if (obj != null) {
                                                c25724e = (C25724e) this.f2835t.get();
                                                if (c25724e != null) {
                                                    c25724e.f5440d.mo12500a(gl103, this.f2834s.f5453d);
                                                }
                                                obj = null;
                                            }
                                            if (obj4 != null) {
                                                c25724e = (C25724e) this.f2835t.get();
                                                if (c25724e != null) {
                                                    c25724e.f5440d.mo12499a(gl103, i2, i3);
                                                }
                                                obj4 = null;
                                            }
                                            c25724e = (C25724e) this.f2835t.get();
                                            if (c25724e != null) {
                                                th = c25724e.f5440d.mo12501a(gl103);
                                            } else {
                                                th = false;
                                            }
                                            if (th) {
                                                i4 = this.f2834s.mo43598d();
                                                switch (i4) {
                                                    case 12288:
                                                        break;
                                                    case 12302:
                                                        obj3 = 1;
                                                        break;
                                                    default:
                                                        c = "eglSwapBuffers";
                                                        C25731h.m40849a("GLThread", c, i4);
                                                        c25723j2 = C25724e.f5437a;
                                                        synchronized (c25723j2) {
                                                            this.f2821f = true;
                                                            C25724e.f5437a.notifyAll();
                                                        }
                                                }
                                            }
                                            if (obj5 != null) {
                                                i4 = 1;
                                            } else {
                                                i4 = i;
                                            }
                                            i = i4;
                                            c25723j2 = gl103;
                                        }
                                    }
                                }
                                C25724e.f5437a.wait();
                                if (this.f2816a) {
                                }
                            }
                            runnable = (Runnable) this.f2832q.remove(0);
                            if (runnable == null) {
                            }
                        }
                        c25724e = (C25724e) this.f2835t.get();
                        if (c25724e != null) {
                            c25724e.f5440d.mo12510j();
                        }
                        synchronized (C25724e.f5437a) {
                            try {
                                m16009j();
                                m16010k();
                            } finally {
                                while (true) {
                                    AppMethodBeat.m2505o(98079);
                                }
                            }
                        }
                        return;
                    }
                } catch (Exception e2) {
                    i4 = e2;
                    synchronized (C25724e.f5437a) {
                        try {
                            m16009j();
                            m16010k();
                            AppMethodBeat.m2505o(i4);
                            return;
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(98079);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = C25724e.f5437a;
                    synchronized (i) {
                        m16009j();
                        m16010k();
                    }
                } finally {
                    i = 98079;
                    AppMethodBeat.m2505o(98079);
                }
            }
            AppMethodBeat.m2505o(i);
        }

        /* renamed from: a */
        public boolean mo20253a() {
            AppMethodBeat.m2504i(98080);
            if (this.f2823h && this.f2824i && m16012m()) {
                AppMethodBeat.m2505o(98080);
                return true;
            }
            AppMethodBeat.m2505o(98080);
            return false;
        }

        /* renamed from: m */
        private boolean m16012m() {
            return !this.f2819d && this.f2820e && !this.f2821f && this.f2827l > 0 && this.f2828m > 0 && (this.f2830o || this.f2829n == 1);
        }

        /* renamed from: a */
        public void mo20251a(int i) {
            AppMethodBeat.m2504i(98081);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.m2505o(98081);
                throw illegalArgumentException;
            }
            synchronized (C25724e.f5437a) {
                try {
                    this.f2829n = i;
                    C25724e.f5437a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(98081);
                }
            }
        }

        /* renamed from: b */
        public int mo20254b() {
            int i;
            AppMethodBeat.m2504i(98082);
            synchronized (C25724e.f5437a) {
                try {
                    i = this.f2829n;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(98082);
                }
            }
            return i;
        }

        /* renamed from: c */
        public void mo20255c() {
            AppMethodBeat.m2504i(98083);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2830o = true;
                    C25724e.f5437a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(98083);
                }
            }
        }

        /* renamed from: d */
        public void mo20256d() {
            AppMethodBeat.m2504i(98084);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2820e = true;
                    this.f2825j = false;
                    C25724e.f5437a.notifyAll();
                    while (this.f2822g && !this.f2825j && !this.f2817b) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98084);
                }
            }
            AppMethodBeat.m2505o(98084);
        }

        /* renamed from: e */
        public void mo20257e() {
            AppMethodBeat.m2504i(98085);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2820e = false;
                    C25724e.f5437a.notifyAll();
                    while (!this.f2822g && !this.f2817b) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98085);
                }
            }
            AppMethodBeat.m2505o(98085);
        }

        /* renamed from: f */
        public void mo20258f() {
            AppMethodBeat.m2504i(98086);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2818c = true;
                    C25724e.f5437a.notifyAll();
                    while (!this.f2817b && !this.f2819d) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98086);
                }
            }
            AppMethodBeat.m2505o(98086);
        }

        /* renamed from: g */
        public void mo20259g() {
            AppMethodBeat.m2504i(98087);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2818c = false;
                    this.f2830o = true;
                    this.f2831p = false;
                    C25724e.f5437a.notifyAll();
                    while (!this.f2817b && this.f2819d && !this.f2831p) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98087);
                }
            }
            AppMethodBeat.m2505o(98087);
        }

        /* renamed from: a */
        public void mo20252a(int i, int i2) {
            AppMethodBeat.m2504i(98088);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2827l = i;
                    this.f2828m = i2;
                    this.f2833r = true;
                    this.f2830o = true;
                    this.f2831p = false;
                    C25724e.f5437a.notifyAll();
                    while (!this.f2817b && !this.f2819d && !this.f2831p && mo20253a()) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98088);
                }
            }
            AppMethodBeat.m2505o(98088);
        }

        /* renamed from: h */
        public void mo20260h() {
            AppMethodBeat.m2504i(98089);
            synchronized (C25724e.f5437a) {
                try {
                    this.f2816a = true;
                    C25724e.f5437a.notifyAll();
                    while (!this.f2817b) {
                        C25724e.f5437a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98089);
                }
            }
            AppMethodBeat.m2505o(98089);
        }

        /* renamed from: i */
        public void mo20261i() {
            AppMethodBeat.m2504i(98090);
            this.f2826k = true;
            C25724e.f5437a.notifyAll();
            AppMethodBeat.m2505o(98090);
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$k */
    public interface C8891k {
        /* renamed from: a */
        GL mo20263a(GL gl);
    }

    /* renamed from: com.tencent.map.lib.gl.e$l */
    static class C8892l extends Writer {
        /* renamed from: a */
        private StringBuilder f2836a = new StringBuilder();

        C8892l() {
            AppMethodBeat.m2504i(98096);
            AppMethodBeat.m2505o(98096);
        }

        public void close() {
            AppMethodBeat.m2504i(98097);
            m16025a();
            AppMethodBeat.m2505o(98097);
        }

        public void flush() {
            AppMethodBeat.m2504i(98098);
            m16025a();
            AppMethodBeat.m2505o(98098);
        }

        public void write(char[] cArr, int i, int i2) {
            AppMethodBeat.m2504i(98099);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    m16025a();
                } else {
                    this.f2836a.append(c);
                }
            }
            AppMethodBeat.m2505o(98099);
        }

        /* renamed from: a */
        private void m16025a() {
            AppMethodBeat.m2504i(98100);
            if (this.f2836a.length() > 0) {
                this.f2836a.delete(0, this.f2836a.length());
            }
            AppMethodBeat.m2505o(98100);
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$b */
    class C17854b extends C25722a {
        /* renamed from: c */
        protected int f4298c;
        /* renamed from: d */
        protected int f4299d;
        /* renamed from: e */
        protected int f4300e;
        /* renamed from: f */
        protected int f4301f;
        /* renamed from: g */
        protected int f4302g;
        /* renamed from: h */
        protected int f4303h;
        /* renamed from: j */
        private int[] f4305j = new int[1];

        public C17854b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            AppMethodBeat.m2504i(98057);
            this.f4298c = i;
            this.f4299d = i2;
            this.f4300e = i3;
            this.f4301f = i4;
            this.f4302g = i5;
            this.f4303h = i6;
            AppMethodBeat.m2505o(98057);
        }

        /* renamed from: a */
        public EGLConfig mo33218a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(98058);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m27948a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m27948a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f4302g && a2 >= this.f4303h) {
                    a = m27948a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m27948a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m27948a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m27948a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f4298c && a3 == this.f4299d && a4 == this.f4300e && a2 == this.f4301f) {
                        AppMethodBeat.m2505o(98058);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.m2505o(98058);
            return null;
        }

        /* renamed from: a */
        private int m27948a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            AppMethodBeat.m2504i(98059);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f4305j)) {
                i2 = this.f4305j[0];
                AppMethodBeat.m2505o(98059);
                return i2;
            }
            AppMethodBeat.m2505o(98059);
            return i2;
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$c */
    class C17855c implements C25730f {
        /* renamed from: b */
        private int f4307b;

        private C17855c() {
            this.f4307b = 12440;
        }

        /* synthetic */ C17855c(C25724e c25724e, C257291 c257291) {
            this();
        }

        /* renamed from: a */
        public EGLContext mo12515a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(98060);
            int[] iArr = new int[]{this.f4307b, C25724e.this.f5447k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (C25724e.this.f5447k == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.m2505o(98060);
            return eglCreateContext;
        }

        /* renamed from: a */
        public void mo12516a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(98061);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                C25731h.m40848a("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.m2505o(98061);
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$d */
    static class C17856d implements C25727g {
        private C17856d() {
        }

        /* synthetic */ C17856d(C257291 c257291) {
            this();
        }

        /* renamed from: a */
        public EGLSurface mo12513a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.m2504i(98062);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException | OutOfMemoryError e) {
            }
            AppMethodBeat.m2505o(98062);
            return eGLSurface;
        }

        /* renamed from: a */
        public void mo12514a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(98063);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.m2505o(98063);
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$a */
    abstract class C25722a implements C25728e {
        /* renamed from: a */
        protected int[] f5428a;

        /* renamed from: a */
        public abstract EGLConfig mo33218a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C25722a(int[] iArr) {
            this.f5428a = m40813a(iArr);
        }

        /* renamed from: a */
        public EGLConfig mo43567a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f5428a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.f5428a, eGLConfigArr, i, iArr)) {
                    EGLConfig a = mo33218a(egl10, eGLDisplay, eGLConfigArr);
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
        private int[] m40813a(int[] iArr) {
            if (C25724e.this.f5447k != 2) {
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

    /* renamed from: com.tencent.map.lib.gl.e$j */
    static class C25723j {
        /* renamed from: a */
        private static String f5430a = "GLThreadManager";
        /* renamed from: b */
        private boolean f5431b;
        /* renamed from: c */
        private int f5432c;
        /* renamed from: d */
        private boolean f5433d;
        /* renamed from: e */
        private boolean f5434e;
        /* renamed from: f */
        private boolean f5435f;
        /* renamed from: g */
        private C8890i f5436g;

        private C25723j() {
        }

        /* synthetic */ C25723j(C257291 c257291) {
            this();
        }

        /* renamed from: a */
        public synchronized void mo43568a(C8890i c8890i) {
            AppMethodBeat.m2504i(98091);
            c8890i.f2817b = true;
            if (this.f5436g == c8890i) {
                this.f5436g = null;
            }
            notifyAll();
            AppMethodBeat.m2505o(98091);
        }

        /* renamed from: b */
        public boolean mo43572b(C8890i c8890i) {
            AppMethodBeat.m2504i(98092);
            if (this.f5436g == c8890i || this.f5436g == null) {
                this.f5436g = c8890i;
                notifyAll();
                AppMethodBeat.m2505o(98092);
                return true;
            }
            m40816c();
            if (this.f5434e) {
                AppMethodBeat.m2505o(98092);
                return true;
            }
            if (this.f5436g != null) {
                this.f5436g.mo20261i();
            }
            AppMethodBeat.m2505o(98092);
            return false;
        }

        /* renamed from: c */
        public void mo43573c(C8890i c8890i) {
            AppMethodBeat.m2504i(98093);
            if (this.f5436g == c8890i) {
                this.f5436g = null;
            }
            notifyAll();
            AppMethodBeat.m2505o(98093);
        }

        /* renamed from: a */
        public synchronized boolean mo43570a() {
            return this.f5435f;
        }

        /* renamed from: b */
        public synchronized boolean mo43571b() {
            boolean z;
            AppMethodBeat.m2504i(98094);
            m40816c();
            if (this.f5434e) {
                z = false;
                AppMethodBeat.m2505o(98094);
            } else {
                z = true;
                AppMethodBeat.m2505o(98094);
            }
            return z;
        }

        /* renamed from: a */
        public synchronized void mo43569a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.m2504i(98095);
                if (!this.f5433d) {
                    m40816c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f5432c < WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                        this.f5434e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.f5434e) {
                        z = false;
                    }
                    this.f5435f = z;
                    this.f5433d = true;
                }
                AppMethodBeat.m2505o(98095);
            }
        }

        /* renamed from: c */
        private void m40816c() {
            if (!this.f5431b) {
                this.f5432c = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                if (this.f5432c >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    this.f5434e = true;
                }
                this.f5431b = true;
            }
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$m */
    public interface C25725m {
        /* renamed from: a */
        void mo12499a(GL10 gl10, int i, int i2);

        /* renamed from: a */
        void mo12500a(GL10 gl10, EGLConfig eGLConfig);

        /* renamed from: a */
        boolean mo12501a(GL10 gl10);

        /* renamed from: j */
        void mo12510j();
    }

    /* renamed from: com.tencent.map.lib.gl.e$n */
    class C25726n extends C17854b {
        public C25726n(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
            AppMethodBeat.m2504i(98101);
            AppMethodBeat.m2505o(98101);
        }
    }

    /* renamed from: com.tencent.map.lib.gl.e$g */
    public interface C25727g {
        /* renamed from: a */
        EGLSurface mo12513a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: a */
        void mo12514a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.tencent.map.lib.gl.e$e */
    public interface C25728e {
        /* renamed from: a */
        EGLConfig mo43567a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.tencent.map.lib.gl.e$f */
    public interface C25730f {
        /* renamed from: a */
        EGLContext mo12515a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: a */
        void mo12516a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.tencent.map.lib.gl.e$h */
    static class C25731h {
        /* renamed from: a */
        EGL10 f5450a;
        /* renamed from: b */
        EGLDisplay f5451b;
        /* renamed from: c */
        EGLSurface f5452c;
        /* renamed from: d */
        EGLConfig f5453d;
        /* renamed from: e */
        EGLContext f5454e;
        /* renamed from: f */
        private WeakReference<C25724e> f5455f;

        public C25731h(WeakReference<C25724e> weakReference) {
            this.f5455f = weakReference;
        }

        /* renamed from: a */
        public void mo43595a() {
            AppMethodBeat.m2504i(98064);
            this.f5450a = (EGL10) EGLContext.getEGL();
            this.f5451b = this.f5450a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.f5451b == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.m2505o(98064);
                throw runtimeException;
            }
            if (this.f5450a.eglInitialize(this.f5451b, new int[2])) {
                C25724e c25724e = (C25724e) this.f5455f.get();
                if (c25724e == null) {
                    this.f5453d = null;
                    this.f5454e = null;
                } else {
                    this.f5453d = c25724e.f5442f.mo43567a(this.f5450a, this.f5451b);
                    this.f5454e = c25724e.f5443g.mo12515a(this.f5450a, this.f5451b, this.f5453d);
                }
                if (this.f5454e == null || this.f5454e == EGL10.EGL_NO_CONTEXT) {
                    this.f5454e = null;
                    m40847a("createContext");
                }
                this.f5452c = null;
                AppMethodBeat.m2505o(98064);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.m2505o(98064);
            throw runtimeException;
        }

        /* renamed from: b */
        public boolean mo43596b() {
            AppMethodBeat.m2504i(98065);
            RuntimeException runtimeException;
            if (this.f5450a == null) {
                runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.m2505o(98065);
                throw runtimeException;
            } else if (this.f5451b == null) {
                runtimeException = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.m2505o(98065);
                throw runtimeException;
            } else if (this.f5453d == null) {
                runtimeException = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.m2505o(98065);
                throw runtimeException;
            } else {
                m40851g();
                C25724e c25724e = (C25724e) this.f5455f.get();
                if (c25724e != null) {
                    this.f5452c = c25724e.f5444h.mo12513a(this.f5450a, this.f5451b, this.f5453d, c25724e.getHolder());
                } else {
                    this.f5452c = null;
                }
                if (this.f5452c == null || this.f5452c == EGL10.EGL_NO_SURFACE) {
                    this.f5450a.eglGetError();
                    AppMethodBeat.m2505o(98065);
                    return false;
                } else if (this.f5450a.eglMakeCurrent(this.f5451b, this.f5452c, this.f5452c, this.f5454e)) {
                    AppMethodBeat.m2505o(98065);
                    return true;
                } else {
                    C25731h.m40849a("EGLHelper", "eglMakeCurrent", this.f5450a.eglGetError());
                    AppMethodBeat.m2505o(98065);
                    return false;
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: c */
        public GL mo43597c() {
            AppMethodBeat.m2504i(98066);
            GL gl = this.f5454e.getGL();
            C25724e c25724e = (C25724e) this.f5455f.get();
            if (c25724e != null) {
                if (c25724e.f5445i != null) {
                    gl = c25724e.f5445i.mo20263a(gl);
                }
                if ((c25724e.f5446j & 3) != 0) {
                    Writer c8892l;
                    int i = 0;
                    if ((c25724e.f5446j & 1) != 0) {
                        i = 1;
                    }
                    if ((c25724e.f5446j & 2) != 0) {
                        c8892l = new C8892l();
                    } else {
                        c8892l = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i, c8892l);
                }
            }
            AppMethodBeat.m2505o(98066);
            return gl;
        }

        /* renamed from: d */
        public int mo43598d() {
            AppMethodBeat.m2504i(98067);
            if (this.f5450a.eglSwapBuffers(this.f5451b, this.f5452c)) {
                AppMethodBeat.m2505o(98067);
                return 12288;
            }
            int eglGetError = this.f5450a.eglGetError();
            AppMethodBeat.m2505o(98067);
            return eglGetError;
        }

        /* renamed from: e */
        public void mo43599e() {
            AppMethodBeat.m2504i(98068);
            m40851g();
            AppMethodBeat.m2505o(98068);
        }

        /* renamed from: g */
        private void m40851g() {
            AppMethodBeat.m2504i(98069);
            if (!(this.f5452c == null || this.f5452c == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.f5450a;
                EGLDisplay eGLDisplay = this.f5451b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                C25724e c25724e = (C25724e) this.f5455f.get();
                if (c25724e != null) {
                    c25724e.f5444h.mo12514a(this.f5450a, this.f5451b, this.f5452c);
                }
                this.f5452c = null;
            }
            AppMethodBeat.m2505o(98069);
        }

        /* renamed from: f */
        public void mo43600f() {
            AppMethodBeat.m2504i(98070);
            if (this.f5454e != null) {
                C25724e c25724e = (C25724e) this.f5455f.get();
                if (c25724e != null) {
                    c25724e.f5443g.mo12516a(this.f5450a, this.f5451b, this.f5454e);
                }
                this.f5454e = null;
            }
            if (this.f5451b != null) {
                this.f5450a.eglTerminate(this.f5451b);
                this.f5451b = null;
            }
            AppMethodBeat.m2505o(98070);
        }

        /* renamed from: a */
        private void m40847a(String str) {
            AppMethodBeat.m2504i(98071);
            C25731h.m40848a(str, this.f5450a.eglGetError());
            AppMethodBeat.m2505o(98071);
        }

        /* renamed from: a */
        public static void m40848a(String str, int i) {
            AppMethodBeat.m2504i(98072);
            RuntimeException runtimeException = new RuntimeException(C25731h.m40850b(str, i));
            AppMethodBeat.m2505o(98072);
            throw runtimeException;
        }

        /* renamed from: a */
        public static void m40849a(String str, String str2, int i) {
            AppMethodBeat.m2504i(98073);
            C25731h.m40850b(str2, i);
            AppMethodBeat.m2505o(98073);
        }

        /* renamed from: b */
        public static String m40850b(String str, int i) {
            AppMethodBeat.m2504i(98074);
            String str2 = str + " failed: ";
            AppMethodBeat.m2505o(98074);
            return str2;
        }
    }

    public C25724e(Context context) {
        super(context);
        AppMethodBeat.m2504i(98102);
        m40824a();
        AppMethodBeat.m2505o(98102);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(98103);
        try {
            if (this.f5439c != null) {
                this.f5439c.mo20260h();
            }
            super.finalize();
            AppMethodBeat.m2505o(98103);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(98103);
        }
    }

    /* renamed from: a */
    private void m40824a() {
        AppMethodBeat.m2504i(98104);
        getHolder().addCallback(this);
        AppMethodBeat.m2505o(98104);
    }

    public void setGLWrapper(C8891k c8891k) {
        this.f5445i = c8891k;
    }

    public void setDebugFlags(int i) {
        this.f5446j = i;
    }

    public int getDebugFlags() {
        return this.f5446j;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.f5448l = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f5448l;
    }

    public void setRenderer(C25725m c25725m) {
        AppMethodBeat.m2504i(98105);
        mo12503d();
        if (this.f5442f == null) {
            this.f5442f = new C25726n(true);
        }
        if (this.f5443g == null) {
            this.f5443g = new C17855c(this, null);
        }
        if (this.f5444h == null) {
            this.f5444h = new C17856d();
        }
        this.f5440d = c25725m;
        this.f5439c = new C8890i(this.f5438b);
        this.f5439c.start();
        AppMethodBeat.m2505o(98105);
    }

    public void setEGLContextFactory(C25730f c25730f) {
        AppMethodBeat.m2504i(98106);
        mo12503d();
        this.f5443g = c25730f;
        AppMethodBeat.m2505o(98106);
    }

    public void setEGLWindowSurfaceFactory(C25727g c25727g) {
        AppMethodBeat.m2504i(98107);
        mo12503d();
        this.f5444h = c25727g;
        AppMethodBeat.m2505o(98107);
    }

    public void setEGLConfigChooser(C25728e c25728e) {
        AppMethodBeat.m2504i(98108);
        mo12503d();
        this.f5442f = c25728e;
        AppMethodBeat.m2505o(98108);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.m2504i(98109);
        setEGLConfigChooser(new C25726n(z));
        AppMethodBeat.m2505o(98109);
    }

    /* renamed from: a */
    public void mo43574a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(98110);
        setEGLConfigChooser(new C17854b(i, i2, i3, i4, i5, i6));
        AppMethodBeat.m2505o(98110);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.m2504i(98111);
        mo12503d();
        this.f5447k = i;
        AppMethodBeat.m2505o(98111);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(98112);
        this.f5439c.mo20251a(i);
        AppMethodBeat.m2505o(98112);
    }

    public int getRenderMode() {
        AppMethodBeat.m2504i(98113);
        int b = this.f5439c.mo20254b();
        AppMethodBeat.m2505o(98113);
        return b;
    }

    /* renamed from: b */
    public void mo43575b() {
        AppMethodBeat.m2504i(98114);
        this.f5439c.mo20255c();
        AppMethodBeat.m2505o(98114);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(98115);
        this.f5439c.mo20256d();
        AppMethodBeat.m2505o(98115);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(98116);
        this.f5439c.mo20257e();
        AppMethodBeat.m2505o(98116);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(98117);
        this.f5439c.mo20252a(i2, i3);
        AppMethodBeat.m2505o(98117);
    }

    /* renamed from: f */
    public void mo12506f() {
        AppMethodBeat.m2504i(98118);
        this.f5439c.mo20258f();
        AppMethodBeat.m2505o(98118);
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(98119);
        this.f5439c.mo20259g();
        AppMethodBeat.m2505o(98119);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(98120);
        super.onAttachedToWindow();
        if (this.f5441e && this.f5440d != null) {
            int b;
            if (this.f5439c != null) {
                b = this.f5439c.mo20254b();
            } else {
                b = 1;
            }
            this.f5439c = new C8890i(this.f5438b);
            if (b != 1) {
                this.f5439c.mo20251a(b);
            }
            this.f5439c.start();
        }
        this.f5441e = false;
        AppMethodBeat.m2505o(98120);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(98121);
        if (this.f5439c != null) {
            this.f5439c.mo20260h();
        }
        this.f5441e = true;
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(98121);
    }

    /* renamed from: d */
    private void mo12503d() {
        AppMethodBeat.m2504i(98122);
        if (this.f5439c != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.m2505o(98122);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(98122);
    }

    static {
        AppMethodBeat.m2504i(98123);
        AppMethodBeat.m2505o(98123);
    }
}
