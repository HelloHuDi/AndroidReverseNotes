package com.tencent.p177mm.p190at;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C26258v;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* renamed from: com.tencent.mm.at.b */
public final class C25820b implements C9017a {
    private C25821a fCU;
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
    C7564ap fDg = new C7564ap(new C179321(), false);
    C4884c fDh = new C179332();
    C4884c fDi = new C179343();

    /* renamed from: com.tencent.mm.at.b$1 */
    class C179321 implements C5015a {
        C179321() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78151);
            long uidRxBytes = TrafficStats.getUidRxBytes(C25820b.this.fDe);
            long uidTxBytes = TrafficStats.getUidTxBytes(C25820b.this.fDe);
            long j = (uidRxBytes - C25820b.this.fDc) + (uidTxBytes - C25820b.this.fDd);
            C4990ab.m7410d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / 1024));
            if (j <= 20480) {
                C25820b.this.fDb = false;
                C25820b.this.start();
            } else {
                C25820b.this.fDc = uidRxBytes;
                C25820b.this.fDd = uidTxBytes;
                C25820b.this.fDg.mo16770ae(1000, 1000);
            }
            AppMethodBeat.m2505o(78151);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.at.b$2 */
    class C179332 extends C4884c<C18322me> {
        C179332() {
            AppMethodBeat.m2504i(78152);
            this.xxI = C18322me.class.getName().hashCode();
            AppMethodBeat.m2505o(78152);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i;
            AppMethodBeat.m2504i(78153);
            C18322me c18322me = (C18322me) c4883b;
            C25820b c25820b = C25820b.this;
            int i2 = C25820b.this.fDa;
            if (c18322me.cHX.cHY) {
                i = 1;
            } else {
                i = -1;
            }
            c25820b.fDa = i + i2;
            if (C25820b.this.fDa < 0) {
                C25820b.this.fDa = 0;
                C4990ab.m7412e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "req pause: " + c18322me.cHX.cHY + " count:" + C25820b.this.fDa);
            C25820b.this.start();
            AppMethodBeat.m2505o(78153);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.at.b$3 */
    class C179343 extends C4884c<C26258v> {
        C179343() {
            AppMethodBeat.m2504i(78154);
            this.xxI = C26258v.class.getName().hashCode();
            AppMethodBeat.m2505o(78154);
        }

        /* renamed from: a */
        private boolean m28182a(C26258v c26258v) {
            AppMethodBeat.m2504i(78155);
            C25820b.this.fDf = c26258v.csQ.mode;
            C4990ab.m7410d("MicroMsg.AutoGetBigImgLogic", "mode = " + C25820b.this.fDf);
            C37938c.afC();
            if (!C37938c.afD()) {
                synchronized (C25820b.this.fCV) {
                    try {
                        C25820b.this.fCV.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(78155);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(78155);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.at.b$a */
    static class C25821a extends C7306ak {
        private WeakReference<C25820b> fDk;

        public C25821a(C25820b c25820b, Looper looper) {
            super(looper);
            AppMethodBeat.m2504i(78157);
            this.fDk = new WeakReference(c25820b);
            AppMethodBeat.m2505o(78157);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(78158);
            C25820b c25820b = (C25820b) this.fDk.get();
            if (c25820b != null && 1 == message.what) {
                boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_voip_pause_other_preload_android, false);
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 2;
                C4879a.xxA.mo10055m(c26250ui);
                if (!((c26250ui.cQy.cQz || C35973a.m59176Oo()) && a)) {
                    if (!c25820b.fCY && System.currentTimeMillis() - c25820b.fCZ > 1200000) {
                        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
                        AppMethodBeat.m2505o(78158);
                        return;
                    } else if (c25820b.fCW != 0 || c25820b.fCV.size() <= 0 || c25820b.fDa != 0 || c25820b.fDb) {
                        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + c25820b.fCW + " size: " + c25820b.fCV.size() + " cnt: " + c25820b.fDa + " pauseOnMonitor: " + c25820b.fDb);
                        AppMethodBeat.m2505o(78158);
                        return;
                    } else {
                        synchronized (c25820b.fCV) {
                            try {
                                c25820b.fCW = ((Long) c25820b.fCV.pop()).longValue();
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(78158);
                            }
                        }
                        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c25820b.fCW);
                        C25822e fI = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
                        if (fI.dJA == 1) {
                            C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", c25820b.fCW + " already has hd thumb");
                            c25820b.fCW = 0;
                            c25820b.start();
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + c25820b.fCW + "  image_" + jf.field_msgId);
                        C37461f.afx().fyQ.add("image_" + jf.field_msgId);
                        C32291o.ahm().mo33467a(fI.fDy, jf.field_msgId, 0, Long.valueOf(c25820b.fCW), c25820b.fCX, c25820b);
                    }
                }
            }
            AppMethodBeat.m2505o(78158);
        }
    }

    public C25820b(Looper looper) {
        int i;
        AppMethodBeat.m2504i(78159);
        this.fCU = new C25821a(this, looper);
        this.fCV = new Stack();
        this.fDe = Process.myUid();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(327681, null);
        if (num == null || 3 == num.intValue()) {
            i = 1;
        } else {
            i = num.intValue();
        }
        this.fDf = i;
        C4879a.xxA.mo10052c(this.fDh);
        C4879a.xxA.mo10052c(this.fDi);
        AppMethodBeat.m2505o(78159);
    }

    public final void start() {
        AppMethodBeat.m2504i(78160);
        this.fCU.sendEmptyMessage(1);
        AppMethodBeat.m2505o(78160);
    }

    /* renamed from: cE */
    public final void mo43784cE(boolean z) {
        AppMethodBeat.m2504i(78161);
        C4990ab.m7410d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(z)));
        this.fCY = z;
        this.fCZ = System.currentTimeMillis();
        AppMethodBeat.m2505o(78161);
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
    }

    /* renamed from: a */
    public static void m41100a(long j, long j2, boolean z) {
        AppMethodBeat.m2504i(78162);
        if (!z) {
            C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
            AppMethodBeat.m2505o(78162);
        } else if (C5023at.isWifi(C4996ah.getContext())) {
            C4990ab.m7418v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            AppMethodBeat.m2505o(78162);
        } else {
            long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = C5046bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            C4990ab.m7411d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(anl));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            AppMethodBeat.m2505o(78162);
        }
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78163);
        if (i3 == 0 && i4 == 0) {
            C25820b.m41100a(j, j2, true);
            ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, true, false);
        } else {
            C4990ab.m7412e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
            ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, false, false);
        }
        this.fCW = 0;
        C37938c.afC();
        if (C37938c.afD()) {
            this.fDc = TrafficStats.getUidRxBytes(this.fDe);
            this.fDd = TrafficStats.getUidTxBytes(this.fDe);
            this.fDg.mo16770ae(1000, 1000);
            AppMethodBeat.m2505o(78163);
            return;
        }
        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.fCV) {
            try {
                this.fCV.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78163);
            }
        }
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(78164);
        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
        ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, false, true);
        AppMethodBeat.m2505o(78164);
    }
}
