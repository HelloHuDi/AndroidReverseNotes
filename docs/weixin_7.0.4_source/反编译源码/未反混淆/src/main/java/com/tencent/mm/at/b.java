package com.tencent.mm.at;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.lang.ref.WeakReference;
import java.util.Stack;

public final class b implements com.tencent.mm.at.d.a {
    private a fCU;
    public Stack<Long> fCV;
    long fCW = 0;
    public int fCX = 0;
    boolean fCY = false;
    public long fCZ = 0;
    int fDa = 0;
    boolean fDb = false;
    long fDc = 0;
    long fDd = 0;
    int fDe;
    int fDf;
    ap fDg = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(78151);
            long uidRxBytes = TrafficStats.getUidRxBytes(b.this.fDe);
            long uidTxBytes = TrafficStats.getUidTxBytes(b.this.fDe);
            long j = (uidRxBytes - b.this.fDc) + (uidTxBytes - b.this.fDd);
            ab.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / 1024));
            if (j <= 20480) {
                b.this.fDb = false;
                b.this.start();
            } else {
                b.this.fDc = uidRxBytes;
                b.this.fDd = uidTxBytes;
                b.this.fDg.ae(1000, 1000);
            }
            AppMethodBeat.o(78151);
            return true;
        }
    }, false);
    c fDh = new c<me>() {
        {
            AppMethodBeat.i(78152);
            this.xxI = me.class.getName().hashCode();
            AppMethodBeat.o(78152);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i;
            AppMethodBeat.i(78153);
            me meVar = (me) bVar;
            b bVar2 = b.this;
            int i2 = b.this.fDa;
            if (meVar.cHX.cHY) {
                i = 1;
            } else {
                i = -1;
            }
            bVar2.fDa = i + i2;
            if (b.this.fDa < 0) {
                b.this.fDa = 0;
                ab.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            ab.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + meVar.cHX.cHY + " count:" + b.this.fDa);
            b.this.start();
            AppMethodBeat.o(78153);
            return false;
        }
    };
    c fDi = new c<v>() {
        {
            AppMethodBeat.i(78154);
            this.xxI = v.class.getName().hashCode();
            AppMethodBeat.o(78154);
        }

        private boolean a(v vVar) {
            AppMethodBeat.i(78155);
            b.this.fDf = vVar.csQ.mode;
            ab.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.fDf);
            com.tencent.mm.modelcontrol.c.afC();
            if (!com.tencent.mm.modelcontrol.c.afD()) {
                synchronized (b.this.fCV) {
                    try {
                        b.this.fCV.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(78155);
                        }
                    }
                }
            }
            AppMethodBeat.o(78155);
            return false;
        }
    };

    static class a extends ak {
        private WeakReference<b> fDk;

        public a(b bVar, Looper looper) {
            super(looper);
            AppMethodBeat.i(78157);
            this.fDk = new WeakReference(bVar);
            AppMethodBeat.o(78157);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(78158);
            b bVar = (b) this.fDk.get();
            if (bVar != null && 1 == message.what) {
                boolean a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_voip_pause_other_preload_android, false);
                ui uiVar = new ui();
                uiVar.cQx.cAd = 2;
                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                if (!((uiVar.cQy.cQz || com.tencent.mm.r.a.Oo()) && a)) {
                    if (!bVar.fCY && System.currentTimeMillis() - bVar.fCZ > 1200000) {
                        ab.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
                        AppMethodBeat.o(78158);
                        return;
                    } else if (bVar.fCW != 0 || bVar.fCV.size() <= 0 || bVar.fDa != 0 || bVar.fDb) {
                        ab.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + bVar.fCW + " size: " + bVar.fCV.size() + " cnt: " + bVar.fDa + " pauseOnMonitor: " + bVar.fDb);
                        AppMethodBeat.o(78158);
                        return;
                    } else {
                        synchronized (bVar.fCV) {
                            try {
                                bVar.fCW = ((Long) bVar.fCV.pop()).longValue();
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(78158);
                            }
                        }
                        bi jf = ((j) g.K(j.class)).bOr().jf(bVar.fCW);
                        e fI = o.ahl().fI(jf.field_msgSvrId);
                        if (fI.dJA == 1) {
                            ab.i("MicroMsg.AutoGetBigImgLogic", bVar.fCW + " already has hd thumb");
                            bVar.fCW = 0;
                            bVar.start();
                            return;
                        }
                        ab.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + bVar.fCW + "  image_" + jf.field_msgId);
                        f.afx().fyQ.add("image_" + jf.field_msgId);
                        o.ahm().a(fI.fDy, jf.field_msgId, 0, Long.valueOf(bVar.fCW), bVar.fCX, bVar);
                    }
                }
            }
            AppMethodBeat.o(78158);
        }
    }

    public b(Looper looper) {
        int i;
        AppMethodBeat.i(78159);
        this.fCU = new a(this, looper);
        this.fCV = new Stack();
        this.fDe = Process.myUid();
        Integer num = (Integer) g.RP().Ry().get(327681, null);
        if (num == null || 3 == num.intValue()) {
            i = 1;
        } else {
            i = num.intValue();
        }
        this.fDf = i;
        com.tencent.mm.sdk.b.a.xxA.c(this.fDh);
        com.tencent.mm.sdk.b.a.xxA.c(this.fDi);
        AppMethodBeat.o(78159);
    }

    public final void start() {
        AppMethodBeat.i(78160);
        this.fCU.sendEmptyMessage(1);
        AppMethodBeat.o(78160);
    }

    public final void cE(boolean z) {
        AppMethodBeat.i(78161);
        ab.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(z)));
        this.fCY = z;
        this.fCZ = System.currentTimeMillis();
        AppMethodBeat.o(78161);
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
    }

    public static void a(long j, long j2, boolean z) {
        AppMethodBeat.i(78162);
        if (!z) {
            ab.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
            AppMethodBeat.o(78162);
        } else if (at.isWifi(ah.getContext())) {
            ab.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            AppMethodBeat.o(78162);
        } else {
            long a = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            ab.d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(anl));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            AppMethodBeat.o(78162);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(78163);
        if (i3 == 0 && i4 == 0) {
            a(j, j2, true);
            ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, true, false);
        } else {
            ab.e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
            ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, false, false);
        }
        this.fCW = 0;
        com.tencent.mm.modelcontrol.c.afC();
        if (com.tencent.mm.modelcontrol.c.afD()) {
            this.fDc = TrafficStats.getUidRxBytes(this.fDe);
            this.fDd = TrafficStats.getUidTxBytes(this.fDe);
            this.fDg.ae(1000, 1000);
            AppMethodBeat.o(78163);
            return;
        }
        ab.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.fCV) {
            try {
                this.fCV.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78163);
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.i(78164);
        ab.i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
        ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, false, true);
        AppMethodBeat.o(78164);
    }
}
