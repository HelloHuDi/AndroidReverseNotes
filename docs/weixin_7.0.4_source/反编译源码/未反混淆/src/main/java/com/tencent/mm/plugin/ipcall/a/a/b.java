package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class b extends a implements com.tencent.mm.plugin.ipcall.a.a.a.a {
    protected boolean fVc = false;
    private ak mHandler = new ak(Looper.getMainLooper());
    public a nws = null;

    public interface a {
        void a(int i, m mVar, int i2, int i3);

        void b(int i, m mVar, int i2, int i3);
    }

    public abstract void b(c cVar);

    public abstract int bHD();

    public abstract void bHE();

    public abstract void bHF();

    public abstract void onStop();

    public final void init() {
        a((com.tencent.mm.plugin.ipcall.a.a.a.a) this);
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    public final void a(c cVar) {
        super.a(cVar);
        this.fVc = true;
        ab.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", Integer.valueOf(getServiceType()));
    }

    public final void stop() {
        this.fVc = false;
        onStop();
        ab.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", Integer.valueOf(getServiceType()));
    }

    public final void a(int i, Object obj, int i2, int i3) {
        ab.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i), Boolean.valueOf(this.fVc), Integer.valueOf(bHD()));
        bHE();
        if (this.nws != null) {
            this.nws.a(i, (m) obj, i2, i3);
        }
        if (this.fVc) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21791);
                    b.this.b(b.this.nvN);
                    AppMethodBeat.o(21791);
                }
            }, (long) bHD());
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        ab.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i), Boolean.valueOf(this.fVc), Integer.valueOf(bHD()));
        bHF();
        if (this.nws != null) {
            this.nws.b(i, (m) obj, i2, i3);
        }
        if (this.fVc) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21792);
                    b.this.b(b.this.nvN);
                    AppMethodBeat.o(21792);
                }
            }, (long) bHD());
        }
    }
}
