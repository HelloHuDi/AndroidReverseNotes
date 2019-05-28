package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Timer;
import java.util.TimerTask;

final class b {
    int hiU = 0;
    a hiV = null;
    Timer hiW = null;

    interface a {
        void ayR();

        void ayS();
    }

    b() {
    }

    /* Access modifiers changed, original: final */
    public final void a(final a aVar) {
        AppMethodBeat.i(86934);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86932);
                b.a(b.this);
                b.this.hiV = aVar;
                b.this.hiW = new Timer();
                b.this.hiW.schedule(new TimerTask() {
                    public final void run() {
                        AppMethodBeat.i(86931);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(86930);
                                ab.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                                b bVar = b.this;
                                bVar.hiU++;
                                if (b.this.hiU > 3) {
                                    if (b.this.hiV != null) {
                                        b.this.hiV.ayR();
                                    }
                                    b.this.hiW.cancel();
                                    AppMethodBeat.o(86930);
                                    return;
                                }
                                if (b.this.hiV != null) {
                                    b.this.hiV.ayS();
                                }
                                AppMethodBeat.o(86930);
                            }
                        });
                        AppMethodBeat.o(86931);
                    }
                }, 500, 500);
                AppMethodBeat.o(86932);
            }
        });
        AppMethodBeat.o(86934);
    }
}
