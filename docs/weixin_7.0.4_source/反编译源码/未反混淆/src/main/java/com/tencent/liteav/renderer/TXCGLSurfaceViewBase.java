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
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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
    private static final j a = new j();
    protected boolean b = false;
    protected boolean c = false;
    protected final WeakReference<TXCGLSurfaceViewBase> d = new WeakReference(this);
    protected boolean e;
    protected boolean f;
    private i g;
    private Renderer h;
    private boolean i;
    private e j;
    private f k;
    private g l;
    private k m;
    private int n;
    private int o;
    private boolean p;

    abstract class a implements e {
        protected int[] a;

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                    EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] a(int[] iArr) {
            if (TXCGLSurfaceViewBase.this.o != 2) {
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

    public interface k {
        GL a(GL gl);
    }

    class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j = new int[1];

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            AppMethodBeat.i(67351);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            AppMethodBeat.o(67351);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(67352);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    a = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.c && a3 == this.d && a4 == this.e && a2 == this.f) {
                        AppMethodBeat.o(67352);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(67352);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            AppMethodBeat.i(67353);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                i2 = this.j[0];
                AppMethodBeat.o(67353);
                return i2;
            }
            AppMethodBeat.o(67353);
            return i2;
        }
    }

    static class d implements g {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(67311);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.e("TXCGLSurfaceViewBase", e.toString());
            }
            AppMethodBeat.o(67311);
            return eGLSurface;
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(67312);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(67312);
        }
    }

    class m extends b {
        public m(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
            AppMethodBeat.i(67238);
            AppMethodBeat.o(67238);
        }
    }

    class c implements f {
        private int b;

        private c() {
            this.b = 12440;
        }

        /* synthetic */ c(TXCGLSurfaceViewBase tXCGLSurfaceViewBase, AnonymousClass1 anonymousClass1) {
            this();
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(67219);
            int[] iArr = new int[]{this.b, TXCGLSurfaceViewBase.this.o, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TXCGLSurfaceViewBase.this.o == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(67219);
            return eglCreateContext;
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(67220);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                TXCLog.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(67220);
        }
    }

    static class i extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList();
        private boolean r = true;
        private h s;
        private WeakReference<TXCGLSurfaceViewBase> t;

        i(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            AppMethodBeat.i(67204);
            this.t = weakReference;
            AppMethodBeat.o(67204);
        }

        public void run() {
            AppMethodBeat.i(67205);
            setName("GLThread " + getId());
            try {
                i();
            } catch (InterruptedException e) {
            } finally {
                TXCGLSurfaceViewBase.a.a(this);
                AppMethodBeat.o(67205);
            }
        }

        public int a() {
            AppMethodBeat.i(67206);
            int c = this.s.c();
            AppMethodBeat.o(67206);
            return c;
        }

        public h b() {
            return this.s;
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
        private void i() {
            AppMethodBeat.i(67207);
            this.s = new h(this.t);
            this.h = false;
            this.i = false;
            Object obj = null;
            j jVar = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            int i = 0;
            Object obj6 = null;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            j jVar2 = null;
            while (true) {
                j e = TXCGLSurfaceViewBase.a;
                synchronized (e) {
                    if (this.a) {
                        boolean th = this.q.isEmpty();
                        if (th != null) {
                            j e2;
                            try {
                                boolean z;
                                TXCGLSurfaceViewBase tXCGLSurfaceViewBase;
                                if (this.d != this.c) {
                                    th = this.c;
                                    this.d = this.c;
                                    TXCGLSurfaceViewBase.a.notifyAll();
                                    z = th;
                                } else {
                                    z = th;
                                }
                                if (this.k) {
                                    j();
                                    k();
                                    this.k = false;
                                    obj6 = 1;
                                }
                                if (obj3 != null) {
                                    j();
                                    k();
                                    obj3 = null;
                                }
                                if (z && this.i) {
                                    j();
                                }
                                if (z && this.h) {
                                    tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                                    if (tXCGLSurfaceViewBase == null) {
                                        th = false;
                                    } else {
                                        th = tXCGLSurfaceViewBase.p;
                                    }
                                    if (!th || TXCGLSurfaceViewBase.a.a()) {
                                        k();
                                    }
                                }
                                if (z && TXCGLSurfaceViewBase.a.b()) {
                                    this.s.g();
                                }
                                if (!(this.e || this.g)) {
                                    if (this.i) {
                                        j();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    TXCGLSurfaceViewBase.a.notifyAll();
                                }
                                if (this.e && this.g) {
                                    this.g = false;
                                    TXCGLSurfaceViewBase.a.notifyAll();
                                }
                                if (i != 0) {
                                    obj5 = null;
                                    i = 0;
                                    this.p = true;
                                    TXCGLSurfaceViewBase.a.notifyAll();
                                }
                                if (l()) {
                                    if (!this.h) {
                                        if (obj6 != null) {
                                            obj6 = null;
                                        } else if (TXCGLSurfaceViewBase.a.b(this)) {
                                            th = this.s;
                                            th.a();
                                            this.h = th;
                                            obj = 1;
                                            TXCGLSurfaceViewBase.a.notifyAll();
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        jVar = true;
                                        obj2 = 1;
                                        obj4 = 1;
                                    }
                                    if (this.i) {
                                        int i4;
                                        if (this.r) {
                                            obj4 = 1;
                                            i2 = this.l;
                                            i4 = this.m;
                                            obj5 = 1;
                                            jVar = true;
                                            this.r = false;
                                        } else {
                                            i4 = i3;
                                        }
                                        this.o = false;
                                        TXCGLSurfaceViewBase.a.notifyAll();
                                        i3 = i4;
                                        if (runnable == null) {
                                            runnable.run();
                                            runnable = null;
                                        } else {
                                            GL10 gl10;
                                            if (jVar != null) {
                                                if (this.s.b()) {
                                                    jVar = TXCGLSurfaceViewBase.a;
                                                    synchronized (jVar) {
                                                        this.j = true;
                                                        e2 = TXCGLSurfaceViewBase.a;
                                                        e2.notifyAll();
                                                    }
                                                    jVar = e2;
                                                } else {
                                                    synchronized (TXCGLSurfaceViewBase.a) {
                                                        this.j = true;
                                                        this.f = true;
                                                        TXCGLSurfaceViewBase.a.notifyAll();
                                                    }
                                                }
                                            }
                                            if (obj2 != null) {
                                                GL10 gl102 = (GL10) this.s.d();
                                                TXCGLSurfaceViewBase.a.a(gl102);
                                                obj2 = null;
                                                gl10 = gl102;
                                            } else {
                                                Object gl103 = jVar2;
                                            }
                                            if (obj != null) {
                                                tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                                                if (tXCGLSurfaceViewBase != null) {
                                                    tXCGLSurfaceViewBase.h.onSurfaceCreated(gl103, this.s.d);
                                                }
                                                obj = null;
                                            }
                                            if (obj4 != null) {
                                                tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                                                if (tXCGLSurfaceViewBase != null) {
                                                    tXCGLSurfaceViewBase.h.onSurfaceChanged(gl103, i2, i3);
                                                }
                                                obj4 = null;
                                            }
                                            tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                                            if (tXCGLSurfaceViewBase != null) {
                                                tXCGLSurfaceViewBase.h.onDrawFrame(gl103);
                                                i4 = tXCGLSurfaceViewBase.c();
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
                                                    h.a("GLThread", e, i4);
                                                    jVar2 = TXCGLSurfaceViewBase.a;
                                                    synchronized (jVar2) {
                                                        this.f = true;
                                                        TXCGLSurfaceViewBase.a.notifyAll();
                                                    }
                                            }
                                        }
                                    }
                                }
                                TXCGLSurfaceViewBase.a.wait();
                                if (this.a) {
                                }
                            } catch (RuntimeException e3) {
                                e2 = e3;
                                TXCGLSurfaceViewBase.a.c(this);
                                throw e2;
                            } catch (Throwable th2) {
                                th = th2;
                                i = TXCGLSurfaceViewBase.a;
                                synchronized (i) {
                                    try {
                                        j();
                                        k();
                                    } catch (Throwable th3) {
                                        while (true) {
                                            AppMethodBeat.o(67207);
                                        }
                                    }
                                }
                            } finally {
                                i = 67207;
                                AppMethodBeat.o(67207);
                            }
                        }
                        runnable = (Runnable) this.q.remove(0);
                        if (runnable == null) {
                        }
                    }
                    synchronized (TXCGLSurfaceViewBase.a) {
                        try {
                            j();
                            k();
                        } finally {
                            while (true) {
                                AppMethodBeat.o(67207);
                            }
                        }
                    }
                    return;
                }
            }
            AppMethodBeat.o(i);
        }

        private void j() {
            AppMethodBeat.i(67208);
            if (this.i) {
                this.i = false;
                this.s.f();
            }
            AppMethodBeat.o(67208);
        }

        private void k() {
            AppMethodBeat.i(67209);
            if (this.h) {
                this.s.g();
                this.h = false;
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f = false;
                }
                TXCGLSurfaceViewBase.a.c(this);
            }
            AppMethodBeat.o(67209);
        }

        public boolean c() {
            AppMethodBeat.i(67210);
            if (this.h && this.i && l()) {
                AppMethodBeat.o(67210);
                return true;
            }
            AppMethodBeat.o(67210);
            return false;
        }

        private boolean l() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i) {
            AppMethodBeat.i(67211);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(67211);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.n = i;
                    TXCGLSurfaceViewBase.a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67211);
                }
            }
        }

        public int d() {
            int i;
            AppMethodBeat.i(67212);
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    i = this.n;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67212);
                }
            }
            return i;
        }

        public void e() {
            AppMethodBeat.i(67213);
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.e = true;
                    this.j = false;
                    TXCGLSurfaceViewBase.a.notifyAll();
                    while (this.g && !this.j && !this.b) {
                        TXCGLSurfaceViewBase.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(67213);
                }
            }
            AppMethodBeat.o(67213);
        }

        public void f() {
            AppMethodBeat.i(67214);
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.e = false;
                    TXCGLSurfaceViewBase.a.notifyAll();
                    while (!this.g && !this.b) {
                        TXCGLSurfaceViewBase.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(67214);
                }
            }
            AppMethodBeat.o(67214);
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(67215);
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.l = i;
                    this.m = i2;
                    this.r = true;
                    this.o = true;
                    this.p = false;
                    TXCGLSurfaceViewBase.a.notifyAll();
                    while (!this.b && !this.d && !this.p && c()) {
                        TXCGLSurfaceViewBase.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(67215);
                }
            }
            AppMethodBeat.o(67215);
        }

        public void g() {
            AppMethodBeat.i(67216);
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.a = true;
                    TXCGLSurfaceViewBase.a.notifyAll();
                    while (!this.b) {
                        TXCGLSurfaceViewBase.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(67216);
                }
            }
            AppMethodBeat.o(67216);
        }

        public void h() {
            AppMethodBeat.i(67217);
            this.k = true;
            TXCGLSurfaceViewBase.a.notifyAll();
            AppMethodBeat.o(67217);
        }

        public void a(Runnable runnable) {
            AppMethodBeat.i(67218);
            if (runnable == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
                AppMethodBeat.o(67218);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.a) {
                try {
                    this.q.add(runnable);
                    TXCGLSurfaceViewBase.a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67218);
                }
            }
        }
    }

    static class j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void a(i iVar) {
            AppMethodBeat.i(67300);
            iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
            AppMethodBeat.o(67300);
        }

        public boolean b(i iVar) {
            AppMethodBeat.i(67301);
            if (this.g == iVar || this.g == null) {
                this.g = iVar;
                notifyAll();
                AppMethodBeat.o(67301);
                return true;
            }
            c();
            if (this.e) {
                AppMethodBeat.o(67301);
                return true;
            }
            if (this.g != null) {
                this.g.h();
            }
            AppMethodBeat.o(67301);
            return false;
        }

        public void c(i iVar) {
            AppMethodBeat.i(67302);
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
            AppMethodBeat.o(67302);
        }

        public synchronized boolean a() {
            return this.f;
        }

        public synchronized boolean b() {
            boolean z;
            AppMethodBeat.i(67303);
            c();
            if (this.e) {
                z = false;
                AppMethodBeat.o(67303);
            } else {
                z = true;
                AppMethodBeat.o(67303);
            }
            return z;
        }

        public synchronized void a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(67304);
                if (!this.d) {
                    c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.c < WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                        this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.e) {
                        z = false;
                    }
                    this.f = z;
                    this.d = true;
                }
                AppMethodBeat.o(67304);
            }
        }

        private void c() {
            this.c = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            this.e = true;
            this.b = true;
        }
    }

    static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
            AppMethodBeat.i(67306);
            AppMethodBeat.o(67306);
        }

        public void close() {
            AppMethodBeat.i(67307);
            a();
            AppMethodBeat.o(67307);
        }

        public void flush() {
            AppMethodBeat.i(67308);
            a();
            AppMethodBeat.o(67308);
        }

        public void write(char[] cArr, int i, int i2) {
            AppMethodBeat.i(67309);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    a();
                } else {
                    this.a.append(c);
                }
            }
            AppMethodBeat.o(67309);
        }

        private void a() {
            AppMethodBeat.i(67310);
            if (this.a.length() > 0) {
                TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
                this.a.delete(0, this.a.length());
            }
            AppMethodBeat.o(67310);
        }
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<TXCGLSurfaceViewBase> f;

        public h(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            this.f = weakReference;
        }

        public void a() {
            AppMethodBeat.i(67171);
            this.a = (EGL10) EGLContext.getEGL();
            this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.b == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.o(67171);
                throw runtimeException;
            }
            if (this.a.eglInitialize(this.b, new int[2])) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f.get();
                if (tXCGLSurfaceViewBase == null) {
                    this.d = null;
                    this.e = null;
                } else {
                    this.d = tXCGLSurfaceViewBase.j.a(this.a, this.b);
                    this.e = tXCGLSurfaceViewBase.k.a(this.a, this.b, this.d);
                }
                if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                    this.e = null;
                    a("createContext");
                }
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f = true;
                }
                this.c = null;
                AppMethodBeat.o(67171);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.o(67171);
            throw runtimeException;
        }

        public boolean b() {
            AppMethodBeat.i(67172);
            RuntimeException runtimeException;
            if (this.a == null) {
                runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.o(67172);
                throw runtimeException;
            } else if (this.b == null) {
                runtimeException = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.o(67172);
                throw runtimeException;
            } else if (this.d == null) {
                runtimeException = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.o(67172);
                throw runtimeException;
            } else {
                h();
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f.get();
                if (tXCGLSurfaceViewBase != null) {
                    this.c = tXCGLSurfaceViewBase.l.a(this.a, this.b, this.d, tXCGLSurfaceViewBase.getHolder());
                } else {
                    this.c = null;
                }
                if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                    if (this.a.eglGetError() == 12299) {
                        TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    AppMethodBeat.o(67172);
                    return false;
                } else if (this.a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
                    if (tXCGLSurfaceViewBase != null) {
                        tXCGLSurfaceViewBase.e = true;
                    }
                    AppMethodBeat.o(67172);
                    return true;
                } else {
                    a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                    AppMethodBeat.o(67172);
                    return false;
                }
            }
        }

        public int c() {
            AppMethodBeat.i(67173);
            int e = e();
            AppMethodBeat.o(67173);
            return e;
        }

        /* Access modifiers changed, original: 0000 */
        public GL d() {
            AppMethodBeat.i(67174);
            GL gl = this.e.getGL();
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f.get();
            if (tXCGLSurfaceViewBase != null) {
                if (tXCGLSurfaceViewBase.m != null) {
                    gl = tXCGLSurfaceViewBase.m.a(gl);
                }
                if ((tXCGLSurfaceViewBase.n & 3) != 0) {
                    Writer lVar;
                    int i = 0;
                    if ((tXCGLSurfaceViewBase.n & 1) != 0) {
                        i = 1;
                    }
                    if ((tXCGLSurfaceViewBase.n & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i, lVar);
                }
            }
            AppMethodBeat.o(67174);
            return gl;
        }

        public int e() {
            AppMethodBeat.i(67175);
            if (this.a.eglSwapBuffers(this.b, this.c)) {
                AppMethodBeat.o(67175);
                return 12288;
            }
            int eglGetError = this.a.eglGetError();
            AppMethodBeat.o(67175);
            return eglGetError;
        }

        public void f() {
            AppMethodBeat.i(67176);
            h();
            AppMethodBeat.o(67176);
        }

        private void h() {
            AppMethodBeat.i(67177);
            if (!(this.c == null || this.c == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.l.a(this.a, this.b, this.c);
                    tXCGLSurfaceViewBase.e = false;
                }
                this.c = null;
            }
            AppMethodBeat.o(67177);
        }

        public void g() {
            AppMethodBeat.i(67178);
            if (this.e != null) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.k.a(this.a, this.b, this.e);
                }
                this.e = null;
            }
            if (this.b != null) {
                this.a.eglTerminate(this.b);
                this.b = null;
            }
            AppMethodBeat.o(67178);
        }

        private void a(String str) {
            AppMethodBeat.i(67179);
            a(str, this.a.eglGetError());
            AppMethodBeat.o(67179);
        }

        public static void a(String str, int i) {
            AppMethodBeat.i(67180);
            RuntimeException runtimeException = new RuntimeException(b(str, i));
            AppMethodBeat.o(67180);
            throw runtimeException;
        }

        public static void a(String str, String str2, int i) {
            AppMethodBeat.i(67181);
            TXCLog.w(str, b(str2, i));
            AppMethodBeat.o(67181);
        }

        public static String b(String str, int i) {
            AppMethodBeat.i(67182);
            String str2 = str + " failed: " + i;
            AppMethodBeat.o(67182);
            return str2;
        }
    }

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public TXCGLSurfaceViewBase(Context context) {
        super(context);
        AppMethodBeat.i(67313);
        a();
        AppMethodBeat.o(67313);
    }

    public TXCGLSurfaceViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67314);
        a();
        AppMethodBeat.o(67314);
    }

    /* Access modifiers changed, original: protected */
    public int c() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(67315);
        try {
            if (this.g != null) {
                this.g.g();
            }
            super.finalize();
            AppMethodBeat.o(67315);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(67315);
        }
    }

    private void a() {
        AppMethodBeat.i(67316);
        getHolder().addCallback(this);
        AppMethodBeat.o(67316);
    }

    public void setGLWrapper(k kVar) {
        this.m = kVar;
    }

    public void setDebugFlags(int i) {
        this.n = i;
    }

    public int getDebugFlags() {
        return this.n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public void setRenderer(Renderer renderer) {
        AppMethodBeat.i(67317);
        f();
        if (this.j == null) {
            this.j = new m(true);
        }
        if (this.k == null) {
            this.k = new c(this, null);
        }
        if (this.l == null) {
            this.l = new d();
        }
        this.h = renderer;
        this.g = new i(this.d);
        this.g.start();
        AppMethodBeat.o(67317);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(67318);
        f();
        this.k = fVar;
        AppMethodBeat.o(67318);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(67319);
        f();
        this.l = gVar;
        AppMethodBeat.o(67319);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(67320);
        f();
        this.j = eVar;
        AppMethodBeat.o(67320);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(67321);
        setEGLConfigChooser(new m(z));
        AppMethodBeat.o(67321);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(67322);
        setEGLConfigChooser(new b(i, i2, i3, i4, i5, i6));
        AppMethodBeat.o(67322);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.i(67323);
        f();
        this.o = i;
        AppMethodBeat.o(67323);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(67324);
        this.g.a(i);
        AppMethodBeat.o(67324);
    }

    public int getRenderMode() {
        AppMethodBeat.i(67325);
        int d = this.g.d();
        AppMethodBeat.o(67325);
        return d;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(67326);
        this.g.e();
        setRunInBackground(false);
        AppMethodBeat.o(67326);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(67327);
        setRunInBackground(true);
        if (!this.b) {
            this.g.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67337);
                    TXCGLSurfaceViewBase.this.b();
                    AppMethodBeat.o(67337);
                }
            });
            this.g.f();
        }
        AppMethodBeat.o(67327);
    }

    /* Access modifiers changed, original: protected */
    public void b() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(67328);
        this.g.a(i2, i3);
        AppMethodBeat.o(67328);
    }

    public void b(boolean z) {
        AppMethodBeat.i(67329);
        this.b = z;
        if (!(this.b || !this.c || this.g == null)) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.g.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67272);
                    TXCGLSurfaceViewBase.this.b();
                    AppMethodBeat.o(67272);
                }
            });
            this.g.f();
        }
        AppMethodBeat.o(67329);
    }

    /* Access modifiers changed, original: protected */
    public void setRunInBackground(boolean z) {
        this.c = z;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(67330);
        super.onAttachedToWindow();
        if (this.i && this.h != null) {
            int d;
            if (this.g != null) {
                d = this.g.d();
            } else {
                d = 1;
            }
            this.g = new i(this.d);
            if (d != 1) {
                this.g.a(d);
            }
            this.g.start();
        }
        this.i = false;
        AppMethodBeat.o(67330);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(67331);
        if (this.g != null) {
            this.g.g();
        }
        this.i = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(67331);
    }

    private void f() {
        AppMethodBeat.i(67332);
        if (this.g != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(67332);
            throw illegalStateException;
        }
        AppMethodBeat.o(67332);
    }

    public int d() {
        AppMethodBeat.i(67333);
        int a = this.g.a();
        AppMethodBeat.o(67333);
        return a;
    }

    public h getEGLHelper() {
        AppMethodBeat.i(67334);
        h b = this.g.b();
        AppMethodBeat.o(67334);
        return b;
    }

    static {
        AppMethodBeat.i(67335);
        AppMethodBeat.o(67335);
    }
}
