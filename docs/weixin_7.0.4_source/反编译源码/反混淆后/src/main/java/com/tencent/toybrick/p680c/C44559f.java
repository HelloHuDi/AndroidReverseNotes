package com.tencent.toybrick.p680c;

import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.toybrick.p1113g.C46821b.C31114a;
import com.tencent.toybrick.p1427ui.BaseToyUI;
import com.tencent.toybrick.p1427ui.BaseToyUI.C31116a;
import com.tencent.toybrick.p1578f.C41100a;

/* renamed from: com.tencent.toybrick.c.f */
public abstract class C44559f<S extends C44559f, T extends C41100a> {
    BaseToyUI AGA;
    public Runnable AGB;
    public String AGC;
    public C31114a<S> AGD;
    public boolean isVisible;
    public Handler mMainHandler;

    /* renamed from: com.tencent.toybrick.c.f$1 */
    public class C59681 implements Runnable {
        final /* synthetic */ C31116a AGE;

        public C59681(C31116a c31116a) {
            this.AGE = c31116a;
        }

        public final void run() {
            AppMethodBeat.m2504i(113217);
            C5227ai.m7971d("ToyBrick", "requestUpdate! ToyBrick:%s type:%s", C44559f.this.AGC, this.AGE);
            AppMethodBeat.m2505o(113217);
        }
    }

    /* renamed from: a */
    public abstract void mo29716a(T t);

    /* renamed from: fy */
    public abstract T mo29718fy(View view);

    public abstract int getLayoutResource();
}
