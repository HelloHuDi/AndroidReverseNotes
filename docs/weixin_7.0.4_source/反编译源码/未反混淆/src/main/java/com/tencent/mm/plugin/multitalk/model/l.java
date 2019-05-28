package com.tencent.mm.plugin.multitalk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class l implements Runnable {
    protected volatile b oGq;
    protected LinkedBlockingQueue<c> oHd = new LinkedBlockingQueue();
    protected ak[] oHe;
    volatile d oHf = new d("multitalk_network");
    private int oHg;
    private int oHh = 5;
    private int oHi;
    private int oHj;
    boolean running;

    class a implements Runnable {
        int index;

        a(int i) {
            this.index = i;
        }

        public final void run() {
            AppMethodBeat.i(54065);
            Looper.prepare();
            ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
            l.this.oHe[this.index] = new ak();
            Looper.loop();
            AppMethodBeat.o(54065);
        }
    }

    protected class b implements Runnable {
        private c oHl;

        public b(c cVar) {
            this.oHl = cVar;
        }

        public final void run() {
            AppMethodBeat.i(54066);
            if (this.oHl != null) {
                ab.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", this.oHl.username, Long.valueOf(Thread.currentThread().getId()));
                if (l.this.oGq != null) {
                    l.this.oGq.a(this.oHl.username, this.oHl.oHm, this.oHl.oHo, this.oHl.oHp, OpenGlRender.FLAG_Angle90);
                }
                try {
                    l.this.oHd.put(this.oHl);
                    AppMethodBeat.o(54066);
                    return;
                } catch (InterruptedException e) {
                }
            }
            AppMethodBeat.o(54066);
        }
    }

    public class c {
        boolean foa;
        int[] oHm;
        int oHn;
        int oHo;
        int oHp;
        String username;

        c(boolean z) {
            this.foa = z;
        }
    }

    public l(b bVar) {
        AppMethodBeat.i(54067);
        this.oGq = bVar;
        AppMethodBeat.o(54067);
    }

    public final void start() {
        int i;
        AppMethodBeat.i(54068);
        ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", Integer.valueOf(this.oHg));
        this.running = true;
        com.tencent.mm.sdk.g.d.a((Runnable) this, "MultiTalk_videoReceiver1", 1).start();
        com.tencent.mm.sdk.g.d.a((Runnable) this, "MultiTalk_videoReceiver2", 1).start();
        this.oHe = new ak[2];
        for (i = 0; i < this.oHe.length; i++) {
            com.tencent.mm.sdk.g.d.a(new a(i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.oHd.add(new c(false));
        }
        AppMethodBeat.o(54068);
    }

    public final void stop() {
        int i = 0;
        AppMethodBeat.i(54069);
        this.oGq = null;
        this.running = false;
        this.oHg = 0;
        if (this.oHe != null) {
            while (i < this.oHe.length) {
                if (this.oHe[i] != null) {
                    this.oHe[i].removeCallbacksAndMessages(null);
                    this.oHe[i].getLooper().quit();
                    this.oHe[i] = null;
                }
                i++;
            }
        }
        this.oHd.clear();
        this.oHd.add(new c(true));
        this.oHd.add(new c(true));
        AppMethodBeat.o(54069);
    }

    public final void run() {
        AppMethodBeat.i(54070);
        ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.oHh);
        while (this.running) {
            this.oHf.aiV("_total");
            c cVar = null;
            try {
                cVar = (c) this.oHd.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (cVar != null) {
                if (cVar.foa) {
                    break;
                }
                z = a(cVar);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.oHh);
                } catch (InterruptedException e2) {
                }
            }
        }
        ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
        AppMethodBeat.o(54070);
    }

    public final void zi(int i) {
        AppMethodBeat.i(54071);
        this.oHg = i;
        ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize ".concat(String.valueOf(i)));
        AppMethodBeat.o(54071);
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(54072);
            if (cVar != null) {
                if (cVar.oHm == null) {
                    cVar.oHm = new int[57600];
                }
                cVar.oHm[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    cVar.oHm[0] = 1;
                }
                f D = p.bSe().oFP.D(cVar.oHm);
                if (this.oGq == null || D.ret <= 0 || bo.isNullOrNil(D.Aqh)) {
                    if (D.ret == 0) {
                        this.oHi++;
                    }
                    this.oHf.aiV("_fail");
                    ab.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", Integer.valueOf(D.ret));
                    if ((this.oHi + this.oHj) % 100 == 0) {
                        ab.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", Float.valueOf(((float) this.oHi) / ((float) (this.oHi + this.oHj))), Float.valueOf(((float) this.oHj) / ((float) (this.oHi + this.oHj))));
                    }
                    try {
                        this.oHd.put(cVar);
                    } catch (InterruptedException e) {
                    }
                    AppMethodBeat.o(54072);
                    z = false;
                } else {
                    int Sg = this.oGq.Sg(D.Aqh);
                    cVar.username = D.Aqh;
                    cVar.oHo = D.Aql;
                    cVar.oHp = D.Aqm;
                    cVar.oHn = D.Aqk;
                    ab.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", cVar.username, Integer.valueOf(Sg));
                    if (Sg >= 0 && this.oHe[Sg % 2] != null) {
                        this.oHe[Sg % 2].post(new b(cVar));
                    }
                    this.oHf.aiV("_success");
                    this.oHj++;
                    if ((this.oHi + this.oHj) % 100 == 0) {
                        ab.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", Integer.valueOf(this.oHi / (this.oHi + this.oHj)), Integer.valueOf(this.oHj / (this.oHi + this.oHj)));
                    }
                    AppMethodBeat.o(54072);
                }
            } else {
                AppMethodBeat.o(54072);
                z = false;
            }
        }
        return z;
    }
}
