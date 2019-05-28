package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class n implements h {
    private final l<b, a> xDf = new l<b, a>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(52519);
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (n.this.apK()) {
                bVar.a(aVar.xDt, aVar.xDu, aVar.obj);
            }
            AppMethodBeat.o(52519);
        }
    };

    class a {
        Object obj;
        int xDt;
        n xDu;

        a(int i, n nVar, Object obj) {
            this.xDt = i;
            this.obj = obj;
            this.xDu = nVar;
        }
    }

    public interface b {
        void a(int i, n nVar, Object obj);
    }

    public abstract boolean apK();

    public final void a(b bVar) {
        if (bVar != null) {
            this.xDf.a(bVar, Looper.getMainLooper());
        }
    }

    public final void a(b bVar, Looper looper) {
        this.xDf.a(bVar, looper);
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.xDf.remove(bVar);
        }
    }

    public final void b(int i, n nVar, Object obj) {
        this.xDf.cF(new a(i, nVar, obj));
        this.xDf.doNotify();
    }
}
