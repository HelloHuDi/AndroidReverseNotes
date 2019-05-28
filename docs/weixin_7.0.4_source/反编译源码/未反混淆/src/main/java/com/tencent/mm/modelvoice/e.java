package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends m implements k {
    private static aq fYY = null;
    private static List<c> fYZ = new ArrayList();
    private String cIS;
    private b ehh;
    private f ehi;
    private String fYX;
    private boolean fZa = false;
    private boolean fZb = false;
    public String fileName;
    private ap frk = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(116566);
            if (e.this.a(e.this.ftf, e.this.ehi) == -1) {
                e.this.ehi.onSceneEnd(3, -1, "doScene failed", e.this);
            }
            AppMethodBeat.o(116566);
            return false;
        }
    }, false);
    public int retCode = 0;

    static {
        AppMethodBeat.i(116576);
        AppMethodBeat.o(116576);
    }

    public static void a(aq aqVar) {
        if (fYY == null) {
            fYY = aqVar;
        }
    }

    public static void a(c cVar) {
        AppMethodBeat.i(116567);
        if (!fYZ.contains(cVar)) {
            fYZ.add(cVar);
        }
        AppMethodBeat.o(116567);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(116568);
        fYZ.remove(cVar);
        AppMethodBeat.o(116568);
    }

    private void doNotify() {
        AppMethodBeat.i(116569);
        final bi uV = q.uV(this.fileName);
        if (uV != null) {
            if (fYY != null) {
                fYY.a(uV);
            }
            for (final c cVar : fYZ) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(116565);
                        cVar.J(uV);
                        AppMethodBeat.o(116565);
                    }
                });
            }
        }
        AppMethodBeat.o(116569);
    }

    public e(p pVar) {
        boolean z;
        AppMethodBeat.i(116570);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.fileName = pVar.fileName;
        if (this.fileName != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.fYX = pVar.fYX;
        this.cIS = pVar.cIS;
        ab.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", this.fileName, this.fYX, this.cIS);
        AppMethodBeat.o(116570);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(116571);
        this.ehi = fVar;
        if (this.fileName == null) {
            ab.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(116571);
            return -1;
        }
        p uW = q.uW(this.fileName);
        if (uW == null || !uW.amd()) {
            ab.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(116571);
            return -1;
        }
        ab.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + uW.fXf);
        if (q.uM(this.fileName)) {
            int i = uW.fVG - uW.fWY;
            if (i > 0) {
                if (uW.frO == uW.fVG) {
                    this.fZa = true;
                }
                b.a aVar = new b.a();
                aVar.fsJ = new xn();
                aVar.fsK = new xo();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.fsI = 128;
                aVar.fsL = 20;
                aVar.fsM = 1000000020;
                this.ehh = aVar.acD();
                xn xnVar = (xn) this.ehh.fsG.fsP;
                xnVar.vFF = uW.clientId;
                xnVar.ptF = uW.cKK;
                xnVar.wdn = i;
                xnVar.vOq = uW.fWY;
                if (t.kH(this.cIS)) {
                    xnVar.vEf = this.cIS;
                    xnVar.wdo = uW.gah;
                }
                ab.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", xnVar.vFF, Integer.valueOf(xnVar.ptD), Long.valueOf(xnVar.ptF), Integer.valueOf(xnVar.wdn), Integer.valueOf(xnVar.vOq), xnVar.vEf, Long.valueOf(xnVar.wdo));
                int a = a(eVar, this.ehh, this);
                AppMethodBeat.o(116571);
                return a;
            } else if (uW.status == 5) {
                this.fZb = true;
                ab.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + uW.fVG + " Local:" + uW.fWY);
                this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                AppMethodBeat.o(116571);
                return -1;
            } else {
                q.a(this.fileName, uW.fWY, null);
                this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                AppMethodBeat.o(116571);
                return -1;
            }
        }
        ab.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.um(this.fileName);
        this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.o(116571);
        return -1;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(116572);
        xn xnVar = (xn) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (xnVar.ptF == 0 || xnVar.vFF == null || xnVar.vFF.length() == 0 || xnVar.wdn <= 0 || xnVar.vOq < 0) {
            q.um(this.fileName);
            bVar = m.b.EFailed;
            AppMethodBeat.o(116572);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(116572);
        return bVar;
    }

    public final int acn() {
        return 100;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(116573);
        h.pYm.a(111, 233, 1, false);
        q.um(this.fileName);
        AppMethodBeat.o(116573);
    }

    public final boolean acJ() {
        AppMethodBeat.i(116574);
        boolean acJ = super.acJ();
        if (acJ) {
            h.pYm.a(111, 232, 1, false);
        }
        AppMethodBeat.o(116574);
        return acJ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116575);
        ab.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        xo xoVar = (xo) ((b) qVar).fsH.fsP;
        if (xoVar.wdq == 1) {
            ab.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            q.uR(this.fileName);
            AppMethodBeat.o(116575);
        } else if (i3 == -22) {
            q.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116575);
        } else if (i2 == 4 && i3 != 0) {
            h.pYm.a(111, 231, 1, false);
            q.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116575);
        } else if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + xoVar.ptz.getILen() + " fileOff:" + xoVar.vOq);
            if (xoVar.ptz.getBuffer() == null) {
                ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116575);
                return;
            }
            byte[] toByteArray = xoVar.ptz.getBuffer().toByteArray();
            if (toByteArray.length == 0) {
                ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116575);
                return;
            }
            int write = q.aY(this.fYX, this.fileName).write(toByteArray, toByteArray.length, xoVar.vOq);
            if (write < 0) {
                ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                q.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116575);
                return;
            }
            q.c(this.fileName, toByteArray, toByteArray.length);
            ab.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.fYX);
            write = q.a(this.fileName, write, null);
            if (write < 0) {
                h.pYm.a(111, 229, 1, false);
                ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + write);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116575);
            } else if (write == 1) {
                doNotify();
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(116575);
            } else {
                long j = 1000;
                if (this.fZa) {
                    j = 0;
                }
                this.frk.ae(j, j);
                AppMethodBeat.o(116575);
            }
        } else {
            h.pYm.a(111, 230, 1, false);
            ab.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + qVar.ZS().vyl);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116575);
        }
    }

    public final int getType() {
        return 128;
    }
}
