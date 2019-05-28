package com.tencent.p177mm.plugin.multitalk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.pluginsdk.p1079f.C46485d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p659pb.talkroom.sdk.C40957f;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.mm.plugin.multitalk.model.l */
public final class C21327l implements Runnable {
    protected volatile C46088b oGq;
    protected LinkedBlockingQueue<C21328c> oHd = new LinkedBlockingQueue();
    protected C7306ak[] oHe;
    volatile C46485d oHf = new C46485d("multitalk_network");
    private int oHg;
    private int oHh = 5;
    private int oHi;
    private int oHj;
    boolean running;

    /* renamed from: com.tencent.mm.plugin.multitalk.model.l$a */
    class C12648a implements Runnable {
        int index;

        C12648a(int i) {
            this.index = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(54065);
            Looper.prepare();
            C4990ab.m7416i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
            C21327l.this.oHe[this.index] = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(54065);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.l$b */
    protected class C12649b implements Runnable {
        private C21328c oHl;

        public C12649b(C21328c c21328c) {
            this.oHl = c21328c;
        }

        public final void run() {
            AppMethodBeat.m2504i(54066);
            if (this.oHl != null) {
                C4990ab.m7411d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", this.oHl.username, Long.valueOf(Thread.currentThread().getId()));
                if (C21327l.this.oGq != null) {
                    C21327l.this.oGq.mo36756a(this.oHl.username, this.oHl.oHm, this.oHl.oHo, this.oHl.oHp, OpenGlRender.FLAG_Angle90);
                }
                try {
                    C21327l.this.oHd.put(this.oHl);
                    AppMethodBeat.m2505o(54066);
                    return;
                } catch (InterruptedException e) {
                }
            }
            AppMethodBeat.m2505o(54066);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.l$c */
    public class C21328c {
        boolean foa;
        int[] oHm;
        int oHn;
        int oHo;
        int oHp;
        String username;

        C21328c(boolean z) {
            this.foa = z;
        }
    }

    public C21327l(C46088b c46088b) {
        AppMethodBeat.m2504i(54067);
        this.oGq = c46088b;
        AppMethodBeat.m2505o(54067);
    }

    public final void start() {
        int i;
        AppMethodBeat.m2504i(54068);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", Integer.valueOf(this.oHg));
        this.running = true;
        C7305d.m12285a((Runnable) this, "MultiTalk_videoReceiver1", 1).start();
        C7305d.m12285a((Runnable) this, "MultiTalk_videoReceiver2", 1).start();
        this.oHe = new C7306ak[2];
        for (i = 0; i < this.oHe.length; i++) {
            C7305d.m12285a(new C12648a(i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.oHd.add(new C21328c(false));
        }
        AppMethodBeat.m2505o(54068);
    }

    public final void stop() {
        int i = 0;
        AppMethodBeat.m2504i(54069);
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
        this.oHd.add(new C21328c(true));
        this.oHd.add(new C21328c(true));
        AppMethodBeat.m2505o(54069);
    }

    public final void run() {
        AppMethodBeat.m2504i(54070);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.oHh);
        while (this.running) {
            this.oHf.aiV("_total");
            C21328c c21328c = null;
            try {
                c21328c = (C21328c) this.oHd.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (c21328c != null) {
                if (c21328c.foa) {
                    break;
                }
                z = m32703a(c21328c);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.oHh);
                } catch (InterruptedException e2) {
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
        AppMethodBeat.m2505o(54070);
    }

    /* renamed from: zi */
    public final void mo36751zi(int i) {
        AppMethodBeat.m2504i(54071);
        this.oHg = i;
        C4990ab.m7416i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(54071);
    }

    /* renamed from: a */
    private synchronized boolean m32703a(C21328c c21328c) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(54072);
            if (c21328c != null) {
                if (c21328c.oHm == null) {
                    c21328c.oHm = new int[57600];
                }
                c21328c.oHm[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    c21328c.oHm[0] = 1;
                }
                C40957f D = C34572p.bSe().oFP.mo58356D(c21328c.oHm);
                if (this.oGq == null || D.ret <= 0 || C5046bo.isNullOrNil(D.Aqh)) {
                    if (D.ret == 0) {
                        this.oHi++;
                    }
                    this.oHf.aiV("_fail");
                    C4990ab.m7419v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", Integer.valueOf(D.ret));
                    if ((this.oHi + this.oHj) % 100 == 0) {
                        C4990ab.m7419v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", Float.valueOf(((float) this.oHi) / ((float) (this.oHi + this.oHj))), Float.valueOf(((float) this.oHj) / ((float) (this.oHi + this.oHj))));
                    }
                    try {
                        this.oHd.put(c21328c);
                    } catch (InterruptedException e) {
                    }
                    AppMethodBeat.m2505o(54072);
                    z = false;
                } else {
                    int Sg = this.oGq.mo36752Sg(D.Aqh);
                    c21328c.username = D.Aqh;
                    c21328c.oHo = D.Aql;
                    c21328c.oHp = D.Aqm;
                    c21328c.oHn = D.Aqk;
                    C4990ab.m7411d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", c21328c.username, Integer.valueOf(Sg));
                    if (Sg >= 0 && this.oHe[Sg % 2] != null) {
                        this.oHe[Sg % 2].post(new C12649b(c21328c));
                    }
                    this.oHf.aiV("_success");
                    this.oHj++;
                    if ((this.oHi + this.oHj) % 100 == 0) {
                        C4990ab.m7419v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", Integer.valueOf(this.oHi / (this.oHi + this.oHj)), Integer.valueOf(this.oHj / (this.oHi + this.oHj)));
                    }
                    AppMethodBeat.m2505o(54072);
                }
            } else {
                AppMethodBeat.m2505o(54072);
                z = false;
            }
        }
        return z;
    }
}
