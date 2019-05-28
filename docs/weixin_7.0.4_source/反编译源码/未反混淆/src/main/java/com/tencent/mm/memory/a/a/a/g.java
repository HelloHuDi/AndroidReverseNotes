package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class g<T, V> extends e<T, V, a<V>, V> {

    static class a<T> {
        WeakReference<T> bSI = null;
        T obj = null;

        public a(T t) {
            AppMethodBeat.i(115472);
            this.obj = t;
            this.bSI = new WeakReference(t);
            al.n(new Runnable() {
                public final void run() {
                    a.this.obj = null;
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(115472);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object aV(Object obj) {
        AppMethodBeat.i(115473);
        a aVar = (a) obj;
        if (aVar != null) {
            Object obj2;
            if (aVar.obj != null) {
                obj2 = aVar.obj;
                AppMethodBeat.o(115473);
                return obj2;
            } else if (!(aVar.bSI == null || aVar.bSI.get() == null)) {
                obj2 = aVar.bSI.get();
                AppMethodBeat.o(115473);
                return obj2;
            }
        }
        AppMethodBeat.o(115473);
        return null;
    }

    public g() {
        super(10);
    }

    /* Access modifiers changed, original: protected|final */
    public final V o(T t, V v) {
        return v;
    }

    /* Access modifiers changed, original: protected|final */
    public final T Xn() {
        return null;
    }

    public final Map<T, V> snapshot() {
        return null;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object aX(Object obj) {
        AppMethodBeat.i(115474);
        a aVar = new a(obj);
        AppMethodBeat.o(115474);
        return aVar;
    }
}
