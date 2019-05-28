package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40586xo;
import com.tencent.p177mm.protocal.protobuf.C44193xn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.e */
public final class C37964e extends C1207m implements C1918k {
    private static C42184aq fYY = null;
    private static List<C18717c> fYZ = new ArrayList();
    private String cIS;
    private C7472b ehh;
    private C1202f ehi;
    private String fYX;
    private boolean fZa = false;
    private boolean fZb = false;
    public String fileName;
    private C7564ap frk = new C7564ap(new C66942(), false);
    public int retCode = 0;

    /* renamed from: com.tencent.mm.modelvoice.e$2 */
    class C66942 implements C5015a {
        C66942() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116566);
            if (C37964e.this.mo4456a(C37964e.this.ftf, C37964e.this.ehi) == -1) {
                C37964e.this.ehi.onSceneEnd(3, -1, "doScene failed", C37964e.this);
            }
            AppMethodBeat.m2505o(116566);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(116576);
        AppMethodBeat.m2505o(116576);
    }

    /* renamed from: a */
    public static void m64230a(C42184aq c42184aq) {
        if (fYY == null) {
            fYY = c42184aq;
        }
    }

    /* renamed from: a */
    public static void m64231a(C18717c c18717c) {
        AppMethodBeat.m2504i(116567);
        if (!fYZ.contains(c18717c)) {
            fYZ.add(c18717c);
        }
        AppMethodBeat.m2505o(116567);
    }

    /* renamed from: b */
    public static void m64233b(C18717c c18717c) {
        AppMethodBeat.m2504i(116568);
        fYZ.remove(c18717c);
        AppMethodBeat.m2505o(116568);
    }

    private void doNotify() {
        AppMethodBeat.m2504i(116569);
        final C7620bi uV = C32850q.m53735uV(this.fileName);
        if (uV != null) {
            if (fYY != null) {
                fYY.mo27972a(uV);
            }
            for (final C18717c c18717c : fYZ) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(116565);
                        c18717c.mo33980J(uV);
                        AppMethodBeat.m2505o(116565);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(116569);
    }

    public C37964e(C32849p c32849p) {
        boolean z;
        AppMethodBeat.m2504i(116570);
        if (c32849p != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.fileName = c32849p.fileName;
        if (this.fileName != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.fYX = c32849p.fYX;
        this.cIS = c32849p.cIS;
        C4990ab.m7417i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", this.fileName, this.fYX, this.cIS);
        AppMethodBeat.m2505o(116570);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116571);
        this.ehi = c1202f;
        if (this.fileName == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(116571);
            return -1;
        }
        C32849p uW = C32850q.m53736uW(this.fileName);
        if (uW == null || !uW.amd()) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(116571);
            return -1;
        }
        C4990ab.m7416i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + uW.fXf);
        if (C32850q.m53726uM(this.fileName)) {
            int i = uW.fVG - uW.fWY;
            if (i > 0) {
                if (uW.frO == uW.fVG) {
                    this.fZa = true;
                }
                C1196a c1196a = new C1196a();
                c1196a.fsJ = new C44193xn();
                c1196a.fsK = new C40586xo();
                c1196a.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                c1196a.fsI = 128;
                c1196a.fsL = 20;
                c1196a.fsM = 1000000020;
                this.ehh = c1196a.acD();
                C44193xn c44193xn = (C44193xn) this.ehh.fsG.fsP;
                c44193xn.vFF = uW.clientId;
                c44193xn.ptF = uW.cKK;
                c44193xn.wdn = i;
                c44193xn.vOq = uW.fWY;
                if (C1855t.m3896kH(this.cIS)) {
                    c44193xn.vEf = this.cIS;
                    c44193xn.wdo = uW.gah;
                }
                C4990ab.m7417i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", c44193xn.vFF, Integer.valueOf(c44193xn.ptD), Long.valueOf(c44193xn.ptF), Integer.valueOf(c44193xn.wdn), Integer.valueOf(c44193xn.vOq), c44193xn.vEf, Long.valueOf(c44193xn.wdo));
                int a = mo4457a(c1902e, this.ehh, this);
                AppMethodBeat.m2505o(116571);
                return a;
            } else if (uW.status == 5) {
                this.fZb = true;
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + uW.fVG + " Local:" + uW.fWY);
                this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                AppMethodBeat.m2505o(116571);
                return -1;
            } else {
                C32850q.m53711a(this.fileName, uW.fWY, null);
                this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                AppMethodBeat.m2505o(116571);
                return -1;
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        C32850q.m53738um(this.fileName);
        this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.m2505o(116571);
        return -1;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(116572);
        C44193xn c44193xn = (C44193xn) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (c44193xn.ptF == 0 || c44193xn.vFF == null || c44193xn.vFF.length() == 0 || c44193xn.wdn <= 0 || c44193xn.vOq < 0) {
            C32850q.m53738um(this.fileName);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(116572);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(116572);
        return c1206b;
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(116573);
        C7060h.pYm.mo8378a(111, 233, 1, false);
        C32850q.m53738um(this.fileName);
        AppMethodBeat.m2505o(116573);
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(116574);
        boolean acJ = super.acJ();
        if (acJ) {
            C7060h.pYm.mo8378a(111, 232, 1, false);
        }
        AppMethodBeat.m2505o(116574);
        return acJ;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116575);
        C4990ab.m7416i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        C40586xo c40586xo = (C40586xo) ((C7472b) c1929q).fsH.fsP;
        if (c40586xo.wdq == 1) {
            C4990ab.m7418v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            C32850q.m53731uR(this.fileName);
            AppMethodBeat.m2505o(116575);
        } else if (i3 == -22) {
            C32850q.m53738um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116575);
        } else if (i2 == 4 && i3 != 0) {
            C7060h.pYm.mo8378a(111, 231, 1, false);
            C32850q.m53738um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116575);
        } else if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + c40586xo.ptz.getILen() + " fileOff:" + c40586xo.vOq);
            if (c40586xo.ptz.getBuffer() == null) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                C32850q.m53738um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116575);
                return;
            }
            byte[] toByteArray = c40586xo.ptz.getBuffer().toByteArray();
            if (toByteArray.length == 0) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                C32850q.m53738um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116575);
                return;
            }
            int write = C32850q.m53716aY(this.fYX, this.fileName).write(toByteArray, toByteArray.length, c40586xo.vOq);
            if (write < 0) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                C32850q.m53738um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116575);
                return;
            }
            C32850q.m53720c(this.fileName, toByteArray, toByteArray.length);
            C4990ab.m7416i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.fYX);
            write = C32850q.m53711a(this.fileName, write, null);
            if (write < 0) {
                C7060h.pYm.mo8378a(111, 229, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + write);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116575);
            } else if (write == 1) {
                doNotify();
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(116575);
            } else {
                long j = 1000;
                if (this.fZa) {
                    j = 0;
                }
                this.frk.mo16770ae(j, j);
                AppMethodBeat.m2505o(116575);
            }
        } else {
            C7060h.pYm.mo8378a(111, 230, 1, false);
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + c1929q.mo5618ZS().vyl);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116575);
        }
    }

    public final int getType() {
        return 128;
    }
}
