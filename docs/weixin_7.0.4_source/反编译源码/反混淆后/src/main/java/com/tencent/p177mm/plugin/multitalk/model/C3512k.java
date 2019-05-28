package com.tencent.p177mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.multitalk.model.k */
public final class C3512k {
    public C7306ak oGX;
    public C3514a oGY = new C3514a(this, (byte) 0);
    C46088b oGq;

    /* renamed from: com.tencent.mm.plugin.multitalk.model.k$1 */
    class C35131 implements Runnable {
        C35131() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54060);
            Looper.prepare();
            C4990ab.m7416i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
            C3512k.this.oGX = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(54060);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.k$a */
    public class C3514a {
        public int angle;
        public boolean eBB;
        /* renamed from: h */
        public int f1273h;
        public Bitmap mQQ;
        public int oHa;
        public int oHb;
        public int[] oHc;
        /* renamed from: w */
        public int f1274w;

        private C3514a() {
        }

        /* synthetic */ C3514a(C3512k c3512k, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.k$b */
    public class C3515b implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(54061);
            C3512k.this.oGY.eBB = true;
            if (C3512k.this.oGY.mQQ != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (C3512k.this.oGq != null) {
                    C3512k.this.oGq.mo36755a(C1853r.m3846Yz(), C3512k.this.oGY.mQQ, C3512k.this.oGY.oHb, C3512k.this.oGY.angle);
                }
                if (System.currentTimeMillis() - currentTimeMillis > 30) {
                    C4990ab.m7411d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                C3512k.this.oGY.eBB = false;
            }
            try {
                Thread.sleep(20);
                AppMethodBeat.m2505o(54061);
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
                AppMethodBeat.m2505o(54061);
            }
        }
    }

    public C3512k(C46088b c46088b) {
        AppMethodBeat.m2504i(54062);
        this.oGq = c46088b;
        AppMethodBeat.m2505o(54062);
    }

    public final void start() {
        AppMethodBeat.m2504i(54063);
        C7305d.m12285a(new C35131(), "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
        AppMethodBeat.m2505o(54063);
    }

    public final void stop() {
        AppMethodBeat.m2504i(54064);
        this.oGq = null;
        this.oGY.eBB = false;
        this.oGY.oHc = null;
        if (this.oGX != null) {
            this.oGX.removeCallbacksAndMessages(null);
            this.oGX.getLooper().quit();
            this.oGX = null;
        }
        AppMethodBeat.m2505o(54064);
    }
}
