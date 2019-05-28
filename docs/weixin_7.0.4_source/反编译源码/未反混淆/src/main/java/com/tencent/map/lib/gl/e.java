package com.tencent.map.lib.gl;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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

public class e extends SurfaceView implements Callback {
    private static final j a = new j();
    private final WeakReference<e> b = new WeakReference(this);
    private i c;
    private m d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

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
        private WeakReference<e> t;

        i(WeakReference<e> weakReference) {
            AppMethodBeat.i(98075);
            this.t = weakReference;
            AppMethodBeat.o(98075);
        }

        public void run() {
            AppMethodBeat.i(98076);
            setName("GLThread " + getId());
            try {
                l();
            } catch (InterruptedException e) {
            } finally {
                e.a.a(this);
                AppMethodBeat.o(98076);
            }
        }

        private void j() {
            AppMethodBeat.i(98077);
            if (this.i) {
                this.i = false;
                this.s.e();
            }
            AppMethodBeat.o(98077);
        }

        private void k() {
            AppMethodBeat.i(98078);
            if (this.h) {
                this.s.f();
                this.h = false;
                e.a.c(this);
            }
            AppMethodBeat.o(98078);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A:{SYNTHETIC, Splitter:B:20:0x0065} */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x01f8  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A:{SYNTHETIC, Splitter:B:26:0x007e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void l() {
            AppMethodBeat.i(98079);
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
                boolean th;
                int i4;
                try {
                    j c = e.a;
                    synchronized (c) {
                        e eVar;
                        if (this.a) {
                            th = this.q.isEmpty();
                            if (th) {
                                boolean z;
                                if (this.d != this.c) {
                                    th = this.c;
                                    this.d = this.c;
                                    e.a.notifyAll();
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
                                    eVar = (e) this.t.get();
                                    if (eVar == null) {
                                        th = false;
                                    } else {
                                        th = eVar.l;
                                    }
                                    if (!th || e.a.a()) {
                                        k();
                                    }
                                }
                                if (z && e.a.b()) {
                                    this.s.f();
                                }
                                if (!(this.e || this.g)) {
                                    if (this.i) {
                                        j();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    e.a.notifyAll();
                                }
                                if (this.e && this.g) {
                                    this.g = false;
                                    e.a.notifyAll();
                                }
                                if (i != 0) {
                                    obj5 = null;
                                    i = 0;
                                    this.p = true;
                                    e.a.notifyAll();
                                }
                                if (m()) {
                                    if (!this.h) {
                                        if (obj6 != null) {
                                            obj6 = null;
                                        } else if (e.a.b(this)) {
                                            try {
                                                this.s.a();
                                            } catch (RuntimeException e) {
                                                e.a.c(this);
                                            }
                                            this.h = true;
                                            obj = 1;
                                            e.a.notifyAll();
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        jVar = true;
                                        obj2 = 1;
                                        obj4 = 1;
                                    }
                                    if (this.i) {
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
                                        e.a.notifyAll();
                                        i3 = i4;
                                        if (runnable == null) {
                                            runnable.run();
                                            runnable = null;
                                        } else {
                                            GL10 gl10;
                                            if (jVar != null) {
                                                if (this.s.b()) {
                                                    j c2;
                                                    jVar = e.a;
                                                    synchronized (jVar) {
                                                        this.j = true;
                                                        c2 = e.a;
                                                        c2.notifyAll();
                                                    }
                                                    jVar = c2;
                                                } else {
                                                    synchronized (e.a) {
                                                        this.j = true;
                                                        this.f = true;
                                                        e.a.notifyAll();
                                                    }
                                                }
                                            }
                                            if (obj2 != null) {
                                                GL10 gl102 = (GL10) this.s.c();
                                                e.a.a(gl102);
                                                obj2 = null;
                                                gl10 = gl102;
                                            } else {
                                                Object gl103 = jVar2;
                                            }
                                            if (obj != null) {
                                                eVar = (e) this.t.get();
                                                if (eVar != null) {
                                                    eVar.d.a(gl103, this.s.d);
                                                }
                                                obj = null;
                                            }
                                            if (obj4 != null) {
                                                eVar = (e) this.t.get();
                                                if (eVar != null) {
                                                    eVar.d.a(gl103, i2, i3);
                                                }
                                                obj4 = null;
                                            }
                                            eVar = (e) this.t.get();
                                            if (eVar != null) {
                                                th = eVar.d.a(gl103);
                                            } else {
                                                th = false;
                                            }
                                            if (th) {
                                                i4 = this.s.d();
                                                switch (i4) {
                                                    case 12288:
                                                        break;
                                                    case 12302:
                                                        obj3 = 1;
                                                        break;
                                                    default:
                                                        c = "eglSwapBuffers";
                                                        h.a("GLThread", c, i4);
                                                        jVar2 = e.a;
                                                        synchronized (jVar2) {
                                                            this.f = true;
                                                            e.a.notifyAll();
                                                        }
                                                }
                                            }
                                            if (obj5 != null) {
                                                i4 = 1;
                                            } else {
                                                i4 = i;
                                            }
                                            i = i4;
                                            jVar2 = gl103;
                                        }
                                    }
                                }
                                e.a.wait();
                                if (this.a) {
                                }
                            }
                            runnable = (Runnable) this.q.remove(0);
                            if (runnable == null) {
                            }
                        }
                        eVar = (e) this.t.get();
                        if (eVar != null) {
                            eVar.d.j();
                        }
                        synchronized (e.a) {
                            try {
                                j();
                                k();
                            } finally {
                                while (true) {
                                    AppMethodBeat.o(98079);
                                }
                            }
                        }
                        return;
                    }
                } catch (Exception e2) {
                    i4 = e2;
                    synchronized (e.a) {
                        try {
                            j();
                            k();
                            AppMethodBeat.o(i4);
                            return;
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(98079);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = e.a;
                    synchronized (i) {
                        j();
                        k();
                    }
                } finally {
                    i = 98079;
                    AppMethodBeat.o(98079);
                }
            }
            AppMethodBeat.o(i);
        }

        public boolean a() {
            AppMethodBeat.i(98080);
            if (this.h && this.i && m()) {
                AppMethodBeat.o(98080);
                return true;
            }
            AppMethodBeat.o(98080);
            return false;
        }

        private boolean m() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i) {
            AppMethodBeat.i(98081);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(98081);
                throw illegalArgumentException;
            }
            synchronized (e.a) {
                try {
                    this.n = i;
                    e.a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(98081);
                }
            }
        }

        public int b() {
            int i;
            AppMethodBeat.i(98082);
            synchronized (e.a) {
                try {
                    i = this.n;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(98082);
                }
            }
            return i;
        }

        public void c() {
            AppMethodBeat.i(98083);
            synchronized (e.a) {
                try {
                    this.o = true;
                    e.a.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(98083);
                }
            }
        }

        public void d() {
            AppMethodBeat.i(98084);
            synchronized (e.a) {
                try {
                    this.e = true;
                    this.j = false;
                    e.a.notifyAll();
                    while (this.g && !this.j && !this.b) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98084);
                }
            }
            AppMethodBeat.o(98084);
        }

        public void e() {
            AppMethodBeat.i(98085);
            synchronized (e.a) {
                try {
                    this.e = false;
                    e.a.notifyAll();
                    while (!this.g && !this.b) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98085);
                }
            }
            AppMethodBeat.o(98085);
        }

        public void f() {
            AppMethodBeat.i(98086);
            synchronized (e.a) {
                try {
                    this.c = true;
                    e.a.notifyAll();
                    while (!this.b && !this.d) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98086);
                }
            }
            AppMethodBeat.o(98086);
        }

        public void g() {
            AppMethodBeat.i(98087);
            synchronized (e.a) {
                try {
                    this.c = false;
                    this.o = true;
                    this.p = false;
                    e.a.notifyAll();
                    while (!this.b && this.d && !this.p) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98087);
                }
            }
            AppMethodBeat.o(98087);
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(98088);
            synchronized (e.a) {
                try {
                    this.l = i;
                    this.m = i2;
                    this.r = true;
                    this.o = true;
                    this.p = false;
                    e.a.notifyAll();
                    while (!this.b && !this.d && !this.p && a()) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98088);
                }
            }
            AppMethodBeat.o(98088);
        }

        public void h() {
            AppMethodBeat.i(98089);
            synchronized (e.a) {
                try {
                    this.a = true;
                    e.a.notifyAll();
                    while (!this.b) {
                        e.a.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(98089);
                }
            }
            AppMethodBeat.o(98089);
        }

        public void i() {
            AppMethodBeat.i(98090);
            this.k = true;
            e.a.notifyAll();
            AppMethodBeat.o(98090);
        }
    }

    public interface k {
        GL a(GL gl);
    }

    static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
            AppMethodBeat.i(98096);
            AppMethodBeat.o(98096);
        }

        public void close() {
            AppMethodBeat.i(98097);
            a();
            AppMethodBeat.o(98097);
        }

        public void flush() {
            AppMethodBeat.i(98098);
            a();
            AppMethodBeat.o(98098);
        }

        public void write(char[] cArr, int i, int i2) {
            AppMethodBeat.i(98099);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    a();
                } else {
                    this.a.append(c);
                }
            }
            AppMethodBeat.o(98099);
        }

        private void a() {
            AppMethodBeat.i(98100);
            if (this.a.length() > 0) {
                this.a.delete(0, this.a.length());
            }
            AppMethodBeat.o(98100);
        }
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
            AppMethodBeat.i(98057);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            AppMethodBeat.o(98057);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(98058);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    a = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.c && a3 == this.d && a4 == this.e && a2 == this.f) {
                        AppMethodBeat.o(98058);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(98058);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            AppMethodBeat.i(98059);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                i2 = this.j[0];
                AppMethodBeat.o(98059);
                return i2;
            }
            AppMethodBeat.o(98059);
            return i2;
        }
    }

    class c implements f {
        private int b;

        private c() {
            this.b = 12440;
        }

        /* synthetic */ c(e eVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(98060);
            int[] iArr = new int[]{this.b, e.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (e.this.k == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(98060);
            return eglCreateContext;
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(98061);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(98061);
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
            AppMethodBeat.i(98062);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException | OutOfMemoryError e) {
            }
            AppMethodBeat.o(98062);
            return eGLSurface;
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(98063);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(98063);
        }
    }

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
            if (e.this.k != 2) {
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
            AppMethodBeat.i(98091);
            iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
            AppMethodBeat.o(98091);
        }

        public boolean b(i iVar) {
            AppMethodBeat.i(98092);
            if (this.g == iVar || this.g == null) {
                this.g = iVar;
                notifyAll();
                AppMethodBeat.o(98092);
                return true;
            }
            c();
            if (this.e) {
                AppMethodBeat.o(98092);
                return true;
            }
            if (this.g != null) {
                this.g.i();
            }
            AppMethodBeat.o(98092);
            return false;
        }

        public void c(i iVar) {
            AppMethodBeat.i(98093);
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
            AppMethodBeat.o(98093);
        }

        public synchronized boolean a() {
            return this.f;
        }

        public synchronized boolean b() {
            boolean z;
            AppMethodBeat.i(98094);
            c();
            if (this.e) {
                z = false;
                AppMethodBeat.o(98094);
            } else {
                z = true;
                AppMethodBeat.o(98094);
            }
            return z;
        }

        public synchronized void a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(98095);
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
                AppMethodBeat.o(98095);
            }
        }

        private void c() {
            if (!this.b) {
                this.c = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                if (this.c >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    this.e = true;
                }
                this.b = true;
            }
        }
    }

    public interface m {
        void a(GL10 gl10, int i, int i2);

        void a(GL10 gl10, EGLConfig eGLConfig);

        boolean a(GL10 gl10);

        void j();
    }

    class n extends b {
        public n(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
            AppMethodBeat.i(98101);
            AppMethodBeat.o(98101);
        }
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<e> f;

        public h(WeakReference<e> weakReference) {
            this.f = weakReference;
        }

        public void a() {
            AppMethodBeat.i(98064);
            this.a = (EGL10) EGLContext.getEGL();
            this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.b == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.o(98064);
                throw runtimeException;
            }
            if (this.a.eglInitialize(this.b, new int[2])) {
                e eVar = (e) this.f.get();
                if (eVar == null) {
                    this.d = null;
                    this.e = null;
                } else {
                    this.d = eVar.f.a(this.a, this.b);
                    this.e = eVar.g.a(this.a, this.b, this.d);
                }
                if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                    this.e = null;
                    a("createContext");
                }
                this.c = null;
                AppMethodBeat.o(98064);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.o(98064);
            throw runtimeException;
        }

        public boolean b() {
            AppMethodBeat.i(98065);
            RuntimeException runtimeException;
            if (this.a == null) {
                runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.o(98065);
                throw runtimeException;
            } else if (this.b == null) {
                runtimeException = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.o(98065);
                throw runtimeException;
            } else if (this.d == null) {
                runtimeException = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.o(98065);
                throw runtimeException;
            } else {
                g();
                e eVar = (e) this.f.get();
                if (eVar != null) {
                    this.c = eVar.h.a(this.a, this.b, this.d, eVar.getHolder());
                } else {
                    this.c = null;
                }
                if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                    this.a.eglGetError();
                    AppMethodBeat.o(98065);
                    return false;
                } else if (this.a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
                    AppMethodBeat.o(98065);
                    return true;
                } else {
                    a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                    AppMethodBeat.o(98065);
                    return false;
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        public GL c() {
            AppMethodBeat.i(98066);
            GL gl = this.e.getGL();
            e eVar = (e) this.f.get();
            if (eVar != null) {
                if (eVar.i != null) {
                    gl = eVar.i.a(gl);
                }
                if ((eVar.j & 3) != 0) {
                    Writer lVar;
                    int i = 0;
                    if ((eVar.j & 1) != 0) {
                        i = 1;
                    }
                    if ((eVar.j & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i, lVar);
                }
            }
            AppMethodBeat.o(98066);
            return gl;
        }

        public int d() {
            AppMethodBeat.i(98067);
            if (this.a.eglSwapBuffers(this.b, this.c)) {
                AppMethodBeat.o(98067);
                return 12288;
            }
            int eglGetError = this.a.eglGetError();
            AppMethodBeat.o(98067);
            return eglGetError;
        }

        public void e() {
            AppMethodBeat.i(98068);
            g();
            AppMethodBeat.o(98068);
        }

        private void g() {
            AppMethodBeat.i(98069);
            if (!(this.c == null || this.c == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                e eVar = (e) this.f.get();
                if (eVar != null) {
                    eVar.h.a(this.a, this.b, this.c);
                }
                this.c = null;
            }
            AppMethodBeat.o(98069);
        }

        public void f() {
            AppMethodBeat.i(98070);
            if (this.e != null) {
                e eVar = (e) this.f.get();
                if (eVar != null) {
                    eVar.g.a(this.a, this.b, this.e);
                }
                this.e = null;
            }
            if (this.b != null) {
                this.a.eglTerminate(this.b);
                this.b = null;
            }
            AppMethodBeat.o(98070);
        }

        private void a(String str) {
            AppMethodBeat.i(98071);
            a(str, this.a.eglGetError());
            AppMethodBeat.o(98071);
        }

        public static void a(String str, int i) {
            AppMethodBeat.i(98072);
            RuntimeException runtimeException = new RuntimeException(b(str, i));
            AppMethodBeat.o(98072);
            throw runtimeException;
        }

        public static void a(String str, String str2, int i) {
            AppMethodBeat.i(98073);
            b(str2, i);
            AppMethodBeat.o(98073);
        }

        public static String b(String str, int i) {
            AppMethodBeat.i(98074);
            String str2 = str + " failed: ";
            AppMethodBeat.o(98074);
            return str2;
        }
    }

    public e(Context context) {
        super(context);
        AppMethodBeat.i(98102);
        a();
        AppMethodBeat.o(98102);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(98103);
        try {
            if (this.c != null) {
                this.c.h();
            }
            super.finalize();
            AppMethodBeat.o(98103);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(98103);
        }
    }

    private void a() {
        AppMethodBeat.i(98104);
        getHolder().addCallback(this);
        AppMethodBeat.o(98104);
    }

    public void setGLWrapper(k kVar) {
        this.i = kVar;
    }

    public void setDebugFlags(int i) {
        this.j = i;
    }

    public int getDebugFlags() {
        return this.j;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public void setRenderer(m mVar) {
        AppMethodBeat.i(98105);
        d();
        if (this.f == null) {
            this.f = new n(true);
        }
        if (this.g == null) {
            this.g = new c(this, null);
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.d = mVar;
        this.c = new i(this.b);
        this.c.start();
        AppMethodBeat.o(98105);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(98106);
        d();
        this.g = fVar;
        AppMethodBeat.o(98106);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(98107);
        d();
        this.h = gVar;
        AppMethodBeat.o(98107);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(98108);
        d();
        this.f = eVar;
        AppMethodBeat.o(98108);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(98109);
        setEGLConfigChooser(new n(z));
        AppMethodBeat.o(98109);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(98110);
        setEGLConfigChooser(new b(i, i2, i3, i4, i5, i6));
        AppMethodBeat.o(98110);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.i(98111);
        d();
        this.k = i;
        AppMethodBeat.o(98111);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(98112);
        this.c.a(i);
        AppMethodBeat.o(98112);
    }

    public int getRenderMode() {
        AppMethodBeat.i(98113);
        int b = this.c.b();
        AppMethodBeat.o(98113);
        return b;
    }

    public void b() {
        AppMethodBeat.i(98114);
        this.c.c();
        AppMethodBeat.o(98114);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(98115);
        this.c.d();
        AppMethodBeat.o(98115);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(98116);
        this.c.e();
        AppMethodBeat.o(98116);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(98117);
        this.c.a(i2, i3);
        AppMethodBeat.o(98117);
    }

    public void f() {
        AppMethodBeat.i(98118);
        this.c.f();
        AppMethodBeat.o(98118);
    }

    public void e() {
        AppMethodBeat.i(98119);
        this.c.g();
        AppMethodBeat.o(98119);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(98120);
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            int b;
            if (this.c != null) {
                b = this.c.b();
            } else {
                b = 1;
            }
            this.c = new i(this.b);
            if (b != 1) {
                this.c.a(b);
            }
            this.c.start();
        }
        this.e = false;
        AppMethodBeat.o(98120);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(98121);
        if (this.c != null) {
            this.c.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(98121);
    }

    private void d() {
        AppMethodBeat.i(98122);
        if (this.c != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(98122);
            throw illegalStateException;
        }
        AppMethodBeat.o(98122);
    }

    static {
        AppMethodBeat.i(98123);
        AppMethodBeat.o(98123);
    }
}
