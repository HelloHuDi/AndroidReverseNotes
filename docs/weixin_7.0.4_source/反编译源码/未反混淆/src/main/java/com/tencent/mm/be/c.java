package com.tencent.mm.be;

import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

public final class c implements INetworkApi, f {
    private float cEB;
    private float cGm;
    private int cGn;
    private int cGo;
    private String cGp;
    private String cGq;
    private a fNH;
    private byte[] fNI;
    private ap fNJ;
    private int fNK;
    private Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        AppMethodBeat.i(78556);
        g.RQ();
        this.fNJ = new ap(g.RS().oAl.getLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(78555);
                ab.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
                if (c.this.fNH != null) {
                    g.RO().eJo.c(c.this.fNH);
                }
                c.this.fNH = null;
                c.this.fNI = null;
                synchronized (c.this.lock) {
                    try {
                        c.this.lock.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(78555);
                    }
                }
                return false;
            }
        }, false);
        this.cGm = f;
        this.cEB = f2;
        this.cGn = i;
        this.cGo = i2;
        this.cGp = str;
        this.cGq = str2;
        this.fNK = i3;
        this.scene = i4;
        g.RO().eJo.a((int) TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, (f) this);
        AppMethodBeat.o(78556);
    }

    public final void finish() {
        AppMethodBeat.i(78557);
        this.fNJ.stopTimer();
        if (this.fNH != null) {
            g.RO().eJo.c(this.fNH);
        }
        this.fNH = null;
        this.fNI = null;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78557);
            }
        }
        aiN();
    }

    private void aiN() {
        AppMethodBeat.i(78558);
        g.RO().eJo.b((int) TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, (f) this);
        AppMethodBeat.o(78558);
    }

    public final byte[] httpRequest(String str, byte[] bArr) {
        AppMethodBeat.i(78559);
        ab.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
        byte[] bArr2 = new byte[0];
        AppMethodBeat.o(78559);
        return bArr2;
    }

    public final byte[] httpRequest(byte[] bArr) {
        AppMethodBeat.i(78560);
        try {
            String str = new String(bArr, "UTF-8");
            ab.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(str)));
            this.fNI = null;
            this.fNH = new a(this.cGm, this.cEB, this.cGn, this.cGo, this.cGp, this.cGq, this.fNK, this.scene, str);
            g.RO().eJo.a(this.fNH, 0);
            this.fNJ.ae(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            ab.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(78560);
            }
        }
        ab.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(bo.cb(this.fNI)));
        byte[] bArr2 = this.fNI;
        AppMethodBeat.o(78560);
        return bArr2;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78561);
        this.fNJ.stopTimer();
        if (i == 0 && i2 == 0) {
            if (mVar instanceof a) {
                String bc = bo.bc(((a) mVar).fNi, "");
                ab.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: ".concat(String.valueOf(bc)));
                try {
                    this.fNI = bc.getBytes("UTF-8");
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    ab.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.fNI = null;
            }
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78561);
                    }
                }
            }
        } else {
            ab.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.fNI = null;
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(78561);
                    }
                }
            }
            b.aiD().aiF();
            h.pYm.a(345, 4, 1, false);
        }
        this.fNH = null;
        AppMethodBeat.o(78561);
    }
}
