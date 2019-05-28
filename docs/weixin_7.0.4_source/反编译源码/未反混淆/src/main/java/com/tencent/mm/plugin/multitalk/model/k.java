package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class k {
    public ak oGX;
    public a oGY = new a(this, (byte) 0);
    b oGq;

    public class a {
        public int angle;
        public boolean eBB;
        public int h;
        public Bitmap mQQ;
        public int oHa;
        public int oHb;
        public int[] oHc;
        public int w;

        private a() {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }
    }

    public class b implements Runnable {
        public final void run() {
            AppMethodBeat.i(54061);
            k.this.oGY.eBB = true;
            if (k.this.oGY.mQQ != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (k.this.oGq != null) {
                    k.this.oGq.a(r.Yz(), k.this.oGY.mQQ, k.this.oGY.oHb, k.this.oGY.angle);
                }
                if (System.currentTimeMillis() - currentTimeMillis > 30) {
                    ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                k.this.oGY.eBB = false;
            }
            try {
                Thread.sleep(20);
                AppMethodBeat.o(54061);
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
                AppMethodBeat.o(54061);
            }
        }
    }

    public k(b bVar) {
        AppMethodBeat.i(54062);
        this.oGq = bVar;
        AppMethodBeat.o(54062);
    }

    public final void start() {
        AppMethodBeat.i(54063);
        d.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54060);
                Looper.prepare();
                ab.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
                k.this.oGX = new ak();
                Looper.loop();
                AppMethodBeat.o(54060);
            }
        }, "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
        AppMethodBeat.o(54063);
    }

    public final void stop() {
        AppMethodBeat.i(54064);
        this.oGq = null;
        this.oGY.eBB = false;
        this.oGY.oHc = null;
        if (this.oGX != null) {
            this.oGX.removeCallbacksAndMessages(null);
            this.oGX.getLooper().quit();
            this.oGX = null;
        }
        AppMethodBeat.o(54064);
    }
}
