package com.tencent.p177mm.p836be;

import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

/* renamed from: com.tencent.mm.be.c */
public final class C37510c implements INetworkApi, C1202f {
    private float cEB;
    private float cGm;
    private int cGn;
    private int cGo;
    private String cGp;
    private String cGq;
    private C9072a fNH;
    private byte[] fNI;
    private C7564ap fNJ;
    private int fNK;
    private Object lock = new Object();
    private int scene;

    /* renamed from: com.tencent.mm.be.c$1 */
    class C323311 implements C5015a {
        C323311() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78555);
            C4990ab.m7420w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
            if (C37510c.this.fNH != null) {
                C1720g.m3535RO().eJo.mo14547c(C37510c.this.fNH);
            }
            C37510c.this.fNH = null;
            C37510c.this.fNI = null;
            synchronized (C37510c.this.lock) {
                try {
                    C37510c.this.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(78555);
                }
            }
            return false;
        }
    }

    public C37510c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        AppMethodBeat.m2504i(78556);
        C1720g.m3537RQ();
        this.fNJ = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C323311(), false);
        this.cGm = f;
        this.cEB = f2;
        this.cGn = i;
        this.cGo = i2;
        this.cGp = str;
        this.cGq = str2;
        this.fNK = i3;
        this.scene = i4;
        C1720g.m3535RO().eJo.mo14539a((int) TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, (C1202f) this);
        AppMethodBeat.m2505o(78556);
    }

    public final void finish() {
        AppMethodBeat.m2504i(78557);
        this.fNJ.stopTimer();
        if (this.fNH != null) {
            C1720g.m3535RO().eJo.mo14547c(this.fNH);
        }
        this.fNH = null;
        this.fNI = null;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78557);
            }
        }
        aiN();
    }

    private void aiN() {
        AppMethodBeat.m2504i(78558);
        C1720g.m3535RO().eJo.mo14546b((int) TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, (C1202f) this);
        AppMethodBeat.m2505o(78558);
    }

    public final byte[] httpRequest(String str, byte[] bArr) {
        AppMethodBeat.m2504i(78559);
        C4990ab.m7420w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
        byte[] bArr2 = new byte[0];
        AppMethodBeat.m2505o(78559);
        return bArr2;
    }

    public final byte[] httpRequest(byte[] bArr) {
        AppMethodBeat.m2504i(78560);
        try {
            String str = new String(bArr, "UTF-8");
            C4990ab.m7410d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(str)));
            this.fNI = null;
            this.fNH = new C9072a(this.cGm, this.cEB, this.cGn, this.cGo, this.cGp, this.cGq, this.fNK, this.scene, str);
            C1720g.m3535RO().eJo.mo14541a(this.fNH, 0);
            this.fNJ.mo16770ae(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(78560);
            }
        }
        C4990ab.m7417i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(C5046bo.m7540cb(this.fNI)));
        byte[] bArr2 = this.fNI;
        AppMethodBeat.m2505o(78560);
        return bArr2;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78561);
        this.fNJ.stopTimer();
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C9072a) {
                String bc = C5046bo.m7532bc(((C9072a) c1207m).fNi, "");
                C4990ab.m7410d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: ".concat(String.valueOf(bc)));
                try {
                    this.fNI = bc.getBytes("UTF-8");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.fNI = null;
            }
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78561);
                    }
                }
            }
        } else {
            C4990ab.m7421w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.fNI = null;
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(78561);
                    }
                }
            }
            C45183b.aiD().aiF();
            C7060h.pYm.mo8378a(345, 4, 1, false);
        }
        this.fNH = null;
        AppMethodBeat.m2505o(78561);
    }
}
