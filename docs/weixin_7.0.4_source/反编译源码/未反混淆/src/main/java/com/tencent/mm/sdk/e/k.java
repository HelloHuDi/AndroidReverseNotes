package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class k implements g {
    protected final l<a, m> xDf = new l<a, m>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(52516);
            m mVar = (m) obj2;
            ((a) obj).a(mVar.ctq, mVar);
            AppMethodBeat.o(52516);
        }
    };
    private final l<Object, String> xDg = new l<Object, String>() {
        /* Access modifiers changed, original: protected|final|bridge|synthetic */
        public final /* bridge */ /* synthetic */ void w(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, m mVar);
    }

    public void lock() {
        this.xDf.lock();
    }

    public void unlock() {
        this.xDf.unlock();
    }

    public void c(a aVar) {
        this.xDf.a(aVar, Looper.getMainLooper());
    }

    public void a(a aVar, Looper looper) {
        this.xDf.a(aVar, looper);
    }

    public void d(a aVar) {
        this.xDf.remove(aVar);
    }

    public final void doNotify() {
        this.xDf.cF(new m("*"));
        this.xDf.doNotify();
    }

    public final void anF(String str) {
        this.xDf.cF(new m(str));
        this.xDf.doNotify();
    }

    public void b(String str, int i, Object obj) {
        m mVar = new m();
        mVar.ctq = str;
        mVar.hsh = i;
        mVar.obj = obj;
        mVar.xDr = this;
        this.xDf.cF(mVar);
        this.xDf.doNotify();
    }
}
