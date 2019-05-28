package com.tencent.toybrick.c;

import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b;
import com.tencent.toybrick.ui.BaseToyUI;

public abstract class f<S extends f, T extends a> {
    BaseToyUI AGA;
    public Runnable AGB;
    public String AGC;
    public b.a<S> AGD;
    public boolean isVisible;
    public Handler mMainHandler;

    /* renamed from: com.tencent.toybrick.c.f$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ BaseToyUI.a AGE;

        public AnonymousClass1(BaseToyUI.a aVar) {
            this.AGE = aVar;
        }

        public final void run() {
            AppMethodBeat.i(113217);
            ai.d("ToyBrick", "requestUpdate! ToyBrick:%s type:%s", f.this.AGC, this.AGE);
            AppMethodBeat.o(113217);
        }
    }

    public abstract void a(T t);

    public abstract T fy(View view);

    public abstract int getLayoutResource();
}
