package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class i implements k, c {
    private static final String a = i.class.getSimpleName();
    private l b;
    private a c = null;
    private EGLContext d = null;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Queue<Runnable> j = new LinkedList();

    static {
        AppMethodBeat.i(66321);
        AppMethodBeat.o(66321);
    }

    public i(Context context, f fVar) {
        int i = 720;
        AppMethodBeat.i(66309);
        this.c = new a(context, fVar.N);
        this.c.a((c) this);
        boolean a = fVar.a();
        this.e = fVar.h;
        if (fVar.a > ActUtil.HEIGHT || fVar.b > ActUtil.HEIGHT) {
            this.f = a ? Math.max(fVar.a, fVar.b) : Math.min(fVar.a, fVar.b);
            this.g = a ? Math.min(fVar.a, fVar.b) : Math.max(fVar.a, fVar.b);
        } else {
            this.f = a ? ActUtil.HEIGHT : 720;
            if (!a) {
                i = ActUtil.HEIGHT;
            }
            this.g = i;
        }
        this.h = fVar.a;
        this.i = fVar.b;
        AppMethodBeat.o(66309);
    }

    public void a() {
        AppMethodBeat.i(66310);
        this.c.a(this.f, this.g, this.e);
        this.c.a(true);
        AppMethodBeat.o(66310);
    }

    public void a(boolean z) {
        AppMethodBeat.i(66311);
        this.c.a(null);
        this.c.a(false);
        AppMethodBeat.o(66311);
    }

    public void c() {
        AppMethodBeat.i(66312);
        this.c.a(false);
        AppMethodBeat.o(66312);
    }

    public void b() {
        AppMethodBeat.i(66313);
        this.c.a(true);
        AppMethodBeat.o(66313);
    }

    public void b(boolean z) {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return 0;
    }

    public EGLContext f() {
        return this.d;
    }

    public boolean a(int i) {
        return false;
    }

    public void a(float f) {
    }

    public void b(int i) {
    }

    public void a(l lVar) {
        this.b = lVar;
    }

    public void c(boolean z) {
    }

    public boolean d(boolean z) {
        return false;
    }

    public void a(com.tencent.liteav.basic.g.c cVar) {
    }

    public void e(boolean z) {
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(66314);
        if (this.c != null) {
            this.c.a(runnable);
        }
        AppMethodBeat.o(66314);
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(66315);
        if (this.c != null) {
            this.c.a(aVar);
        }
        AppMethodBeat.o(66315);
    }

    public void c(int i) {
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void d(int i) {
    }

    public void a(float f, float f2) {
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(66316);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.o(66316);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        AppMethodBeat.i(66316);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66316);
            }
        }
        return false;
    }

    public void a(int i, EGLContext eGLContext) {
        AppMethodBeat.i(66317);
        if (i == 0) {
            this.d = eGLContext;
            AppMethodBeat.o(66317);
            return;
        }
        this.d = null;
        TXCLog.e(a, "Start screen capture failed");
        AppMethodBeat.o(66317);
    }

    public void a(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.i(66318);
        do {
        } while (a(this.j));
        if (i != 0) {
            TXCLog.e(a, "onScreenCaptureFrame failed");
        } else if (this.b != null) {
            f(i3 < i4);
            com.tencent.liteav.basic.g.c cVar = new com.tencent.liteav.basic.g.c();
            cVar.d = i3;
            cVar.e = i4;
            cVar.f = this.h;
            cVar.g = this.i;
            cVar.a = i2;
            cVar.b = 0;
            cVar.i = 0;
            cVar.k = b.a(cVar.d, cVar.e, this.h, this.i);
            this.b.b(cVar);
            AppMethodBeat.o(66318);
            return;
        }
        AppMethodBeat.o(66318);
    }

    public void a(Object obj) {
        AppMethodBeat.i(66319);
        do {
        } while (a(this.j));
        if (this.b != null) {
            this.b.r();
        }
        AppMethodBeat.o(66319);
    }

    private void f(boolean z) {
        AppMethodBeat.i(66320);
        if (z) {
            if (this.h > this.i) {
                a(this.i, this.h);
                AppMethodBeat.o(66320);
                return;
            }
        } else if (this.h < this.i) {
            a(this.i, this.h);
        }
        AppMethodBeat.o(66320);
    }
}
