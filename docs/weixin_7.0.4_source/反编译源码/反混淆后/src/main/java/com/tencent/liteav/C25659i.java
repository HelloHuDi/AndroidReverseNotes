package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C8803c;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.screencapture.C17811c;
import com.tencent.liteav.screencapture.C8840a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.i */
public class C25659i implements C45108k, C17811c {
    /* renamed from: a */
    private static final String f5328a = C25659i.class.getSimpleName();
    /* renamed from: b */
    private C37369l f5329b;
    /* renamed from: c */
    private C8840a f5330c = null;
    /* renamed from: d */
    private EGLContext f5331d = null;
    /* renamed from: e */
    private int f5332e;
    /* renamed from: f */
    private int f5333f;
    /* renamed from: g */
    private int f5334g;
    /* renamed from: h */
    private int f5335h;
    /* renamed from: i */
    private int f5336i;
    /* renamed from: j */
    private final Queue<Runnable> f5337j = new LinkedList();

    static {
        AppMethodBeat.m2504i(66321);
        AppMethodBeat.m2505o(66321);
    }

    public C25659i(Context context, C25658f c25658f) {
        int i = 720;
        AppMethodBeat.m2504i(66309);
        this.f5330c = new C8840a(context, c25658f.f5301N);
        this.f5330c.mo19981a((C17811c) this);
        boolean a = c25658f.mo43387a();
        this.f5332e = c25658f.f5309h;
        if (c25658f.f5302a > ActUtil.HEIGHT || c25658f.f5303b > ActUtil.HEIGHT) {
            this.f5333f = a ? Math.max(c25658f.f5302a, c25658f.f5303b) : Math.min(c25658f.f5302a, c25658f.f5303b);
            this.f5334g = a ? Math.min(c25658f.f5302a, c25658f.f5303b) : Math.max(c25658f.f5302a, c25658f.f5303b);
        } else {
            this.f5333f = a ? ActUtil.HEIGHT : 720;
            if (!a) {
                i = ActUtil.HEIGHT;
            }
            this.f5334g = i;
        }
        this.f5335h = c25658f.f5302a;
        this.f5336i = c25658f.f5303b;
        AppMethodBeat.m2505o(66309);
    }

    /* renamed from: a */
    public void mo43389a() {
        AppMethodBeat.m2504i(66310);
        this.f5330c.mo19973a(this.f5333f, this.f5334g, this.f5332e);
        this.f5330c.mo19984a(true);
        AppMethodBeat.m2505o(66310);
    }

    /* renamed from: a */
    public void mo43397a(boolean z) {
        AppMethodBeat.m2504i(66311);
        this.f5330c.mo19982a(null);
        this.f5330c.mo19984a(false);
        AppMethodBeat.m2505o(66311);
    }

    /* renamed from: c */
    public void mo43402c() {
        AppMethodBeat.m2504i(66312);
        this.f5330c.mo19984a(false);
        AppMethodBeat.m2505o(66312);
    }

    /* renamed from: b */
    public void mo43399b() {
        AppMethodBeat.m2504i(66313);
        this.f5330c.mo19984a(true);
        AppMethodBeat.m2505o(66313);
    }

    /* renamed from: b */
    public void mo43401b(boolean z) {
    }

    /* renamed from: d */
    public boolean mo43406d() {
        return true;
    }

    /* renamed from: e */
    public int mo43408e() {
        return 0;
    }

    /* renamed from: f */
    public EGLContext mo43410f() {
        return this.f5331d;
    }

    /* renamed from: a */
    public boolean mo43398a(int i) {
        return false;
    }

    /* renamed from: a */
    public void mo43390a(float f) {
    }

    /* renamed from: b */
    public void mo43400b(int i) {
    }

    /* renamed from: a */
    public void mo43395a(C37369l c37369l) {
        this.f5329b = c37369l;
    }

    /* renamed from: c */
    public void mo43404c(boolean z) {
    }

    /* renamed from: d */
    public boolean mo43407d(boolean z) {
        return false;
    }

    /* renamed from: a */
    public void mo43394a(C8803c c8803c) {
    }

    /* renamed from: e */
    public void mo43409e(boolean z) {
    }

    /* renamed from: a */
    public void mo43396a(Runnable runnable) {
        AppMethodBeat.m2504i(66314);
        if (this.f5330c != null) {
            this.f5330c.mo19983a(runnable);
        }
        AppMethodBeat.m2505o(66314);
    }

    /* renamed from: a */
    public void mo43393a(C0946a c0946a) {
        AppMethodBeat.m2504i(66315);
        if (this.f5330c != null) {
            this.f5330c.mo19980a(c0946a);
        }
        AppMethodBeat.m2505o(66315);
    }

    /* renamed from: c */
    public void mo43403c(int i) {
    }

    /* renamed from: a */
    public void mo43392a(int i, int i2) {
        this.f5335h = i;
        this.f5336i = i2;
    }

    /* renamed from: d */
    public void mo43405d(int i) {
    }

    /* renamed from: a */
    public void mo43391a(float f, float f2) {
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66316);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66316);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m40665a(Queue<Runnable> queue) {
        AppMethodBeat.m2504i(66316);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66316);
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo32966a(int i, EGLContext eGLContext) {
        AppMethodBeat.m2504i(66317);
        if (i == 0) {
            this.f5331d = eGLContext;
            AppMethodBeat.m2505o(66317);
            return;
        }
        this.f5331d = null;
        TXCLog.m15676e(f5328a, "Start screen capture failed");
        AppMethodBeat.m2505o(66317);
    }

    /* renamed from: a */
    public void mo32965a(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.m2504i(66318);
        do {
        } while (m40665a(this.f5337j));
        if (i != 0) {
            TXCLog.m15676e(f5328a, "onScreenCaptureFrame failed");
        } else if (this.f5329b != null) {
            m40666f(i3 < i4);
            C8803c c8803c = new C8803c();
            c8803c.f2655d = i3;
            c8803c.f2656e = i4;
            c8803c.f2657f = this.f5335h;
            c8803c.f2658g = this.f5336i;
            c8803c.f2652a = i2;
            c8803c.f2653b = 0;
            c8803c.f2660i = 0;
            c8803c.f2662k = C17778b.m27738a(c8803c.f2655d, c8803c.f2656e, this.f5335h, this.f5336i);
            this.f5329b.mo60182b(c8803c);
            AppMethodBeat.m2505o(66318);
            return;
        }
        AppMethodBeat.m2505o(66318);
    }

    /* renamed from: a */
    public void mo32967a(Object obj) {
        AppMethodBeat.m2504i(66319);
        do {
        } while (m40665a(this.f5337j));
        if (this.f5329b != null) {
            this.f5329b.mo60183r();
        }
        AppMethodBeat.m2505o(66319);
    }

    /* renamed from: f */
    private void m40666f(boolean z) {
        AppMethodBeat.m2504i(66320);
        if (z) {
            if (this.f5335h > this.f5336i) {
                mo43392a(this.f5336i, this.f5335h);
                AppMethodBeat.m2505o(66320);
                return;
            }
        } else if (this.f5335h < this.f5336i) {
            mo43392a(this.f5336i, this.f5335h);
        }
        AppMethodBeat.m2505o(66320);
    }
}
