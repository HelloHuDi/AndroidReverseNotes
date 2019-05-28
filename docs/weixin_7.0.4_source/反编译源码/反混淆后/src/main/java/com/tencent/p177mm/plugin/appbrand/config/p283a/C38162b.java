package com.tencent.p177mm.plugin.appbrand.config.p283a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.appbrand.config.a.b */
final class C38162b {
    int hiU = 0;
    C33132a hiV = null;
    Timer hiW = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$2 */
    public class C268402 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(86933);
            C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: stop count fail");
            C38162b.m64587a(C38162b.this);
            AppMethodBeat.m2505o(86933);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$a */
    interface C33132a {
        void ayR();

        void ayS();
    }

    C38162b() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo60901a(final C33132a c33132a) {
        AppMethodBeat.m2504i(86934);
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$1$1 */
            class C101751 extends TimerTask {

                /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$1$1$1 */
                class C101761 implements Runnable {
                    C101761() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(86930);
                        C4990ab.m7420w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                        C38162b c38162b = C38162b.this;
                        c38162b.hiU++;
                        if (C38162b.this.hiU > 3) {
                            if (C38162b.this.hiV != null) {
                                C38162b.this.hiV.ayR();
                            }
                            C38162b.this.hiW.cancel();
                            AppMethodBeat.m2505o(86930);
                            return;
                        }
                        if (C38162b.this.hiV != null) {
                            C38162b.this.hiV.ayS();
                        }
                        AppMethodBeat.m2505o(86930);
                    }
                }

                C101751() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(86931);
                    C5004al.m7441d(new C101761());
                    AppMethodBeat.m2505o(86931);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(86932);
                C38162b.m64587a(C38162b.this);
                C38162b.this.hiV = c33132a;
                C38162b.this.hiW = new Timer();
                C38162b.this.hiW.schedule(new C101751(), 500, 500);
                AppMethodBeat.m2505o(86932);
            }
        });
        AppMethodBeat.m2505o(86934);
    }
}
