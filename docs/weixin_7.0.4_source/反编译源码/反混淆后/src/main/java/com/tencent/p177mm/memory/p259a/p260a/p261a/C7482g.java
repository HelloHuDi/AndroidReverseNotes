package com.tencent.p177mm.memory.p259a.p260a.p261a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.memory.a.a.a.g */
public final class C7482g<T, V> extends C6656e<T, V, C1801a<V>, V> {

    /* renamed from: com.tencent.mm.memory.a.a.a.g$a */
    static class C1801a<T> {
        WeakReference<T> bSI = null;
        T obj = null;

        /* renamed from: com.tencent.mm.memory.a.a.a.g$a$1 */
        class C18001 implements Runnable {
            C18001() {
            }

            public final void run() {
                C1801a.this.obj = null;
            }
        }

        public C1801a(T t) {
            AppMethodBeat.m2504i(115472);
            this.obj = t;
            this.bSI = new WeakReference(t);
            C5004al.m7442n(new C18001(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(115472);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aV */
    public final /* synthetic */ Object mo14876aV(Object obj) {
        AppMethodBeat.m2504i(115473);
        C1801a c1801a = (C1801a) obj;
        if (c1801a != null) {
            Object obj2;
            if (c1801a.obj != null) {
                obj2 = c1801a.obj;
                AppMethodBeat.m2505o(115473);
                return obj2;
            } else if (!(c1801a.bSI == null || c1801a.bSI.get() == null)) {
                obj2 = c1801a.bSI.get();
                AppMethodBeat.m2505o(115473);
                return obj2;
            }
        }
        AppMethodBeat.m2505o(115473);
        return null;
    }

    public C7482g() {
        super(10);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: o */
    public final V mo14879o(T t, V v) {
        return v;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Xn */
    public final T mo14873Xn() {
        return null;
    }

    public final Map<T, V> snapshot() {
        return null;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aX */
    public final /* synthetic */ Object mo14877aX(Object obj) {
        AppMethodBeat.m2504i(115474);
        C1801a c1801a = new C1801a(obj);
        AppMethodBeat.m2505o(115474);
        return c1801a;
    }
}
