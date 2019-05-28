package com.tencent.p177mm.modelvoice;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clx;
import com.tencent.p177mm.protocal.protobuf.cly;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.f */
public final class C45461f extends C1207m implements C1918k {
    private C7472b ehh;
    C1202f ehi;
    private int endFlag;
    private int fXD;
    private boolean fZa;
    private int fZe;
    long fZf;
    public String fileName;
    C7564ap frk;
    public int retCode;

    /* renamed from: com.tencent.mm.modelvoice.f$1 */
    class C66951 implements C5015a {
        C66951() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116577);
            C32849p uW = C32850q.m53736uW(C45461f.this.fileName);
            if (uW == null || !uW.ame()) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + C45461f.this.fileName);
                C45461f.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                C45461f.this.ehi.onSceneEnd(3, -1, "doScene failed", C45461f.this);
                AppMethodBeat.m2505o(116577);
                return false;
            }
            if (!(3 == uW.status || 8 == uW.status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - uW.fXb > 30) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + C45461f.this.fileName);
                    C45461f.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    C45461f.this.ehi.onSceneEnd(3, -1, "doScene failed", C45461f.this);
                    AppMethodBeat.m2505o(116577);
                    return false;
                } else if (currentTimeMillis - C45461f.this.fZf < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + C45461f.this.fileName + " but last send time:" + (currentTimeMillis - C45461f.this.fZf));
                    AppMethodBeat.m2505o(116577);
                    return true;
                } else {
                    C37965g cF = C32850q.m53727uN(C45461f.this.fileName).mo5461cF(uW.fVG, 6000);
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + C45461f.this.fileName + " readByte:" + cF.cqs + " stat:" + uW.status);
                    if (cF.cqs < 2000) {
                        AppMethodBeat.m2505o(116577);
                        return true;
                    }
                }
            }
            if (C45461f.this.mo4456a(C45461f.this.ftf, C45461f.this.ehi) == -1) {
                C45461f.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                C45461f.this.ehi.onSceneEnd(3, -1, "doScene failed", C45461f.this);
            }
            AppMethodBeat.m2505o(116577);
            return false;
        }
    }

    public C45461f(String str) {
        this(str, 0);
    }

    public C45461f(String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(116578);
        this.retCode = 0;
        this.fXD = 0;
        this.fZa = false;
        this.endFlag = 0;
        this.frk = new C7564ap(new C66951(), true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.fZe = i;
        AppMethodBeat.m2505o(116578);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116579);
        this.ehi = c1202f;
        this.fZa = false;
        if (this.fileName == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(116579);
            return -1;
        }
        C32849p uW = C32850q.m53736uW(this.fileName);
        if (uW == null || !uW.ame()) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(116579);
            return -1;
        }
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + uW.fXf);
        if (C32850q.m53726uM(this.fileName)) {
            int i;
            int i2;
            C37965g c37965g = new C37965g();
            if (uW.status == 8) {
                C4990ab.m7418v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
                i = 1;
                this.endFlag = 0;
                C32850q.m53732uS(uW.fileName);
                i2 = 0;
            } else {
                if (uW.status == 3) {
                    this.fZa = true;
                }
                C26497b uN = C32850q.m53727uN(this.fileName);
                if (uN == null) {
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    C4990ab.m7413e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", this.fileName);
                    AppMethodBeat.m2505o(116579);
                    return -1;
                }
                int format = uN.getFormat();
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(format)));
                C37965g cF = uN.mo5461cF(uW.fVG, 6000);
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " line:" + C1447g.getLine());
                if (cF.ret < 0) {
                    C7060h.pYm.mo8378a(111, 241, 1, false);
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG);
                    C32850q.m53738um(this.fileName);
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(116579);
                    return -1;
                }
                this.fXD = cF.fXD;
                if (this.fXD < uW.fVG || this.fXD >= 469000) {
                    C7060h.pYm.mo8378a(111, 240, 1, false);
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXD + " OldtOff:" + uW.fVG);
                    C32850q.m53738um(this.fileName);
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(116579);
                    return -1;
                }
                this.endFlag = 0;
                if (cF.cqs != 0 || this.fZa) {
                    if (this.fZa) {
                        if (uW.frO <= 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + uW.frO);
                            C32850q.m53738um(this.fileName);
                            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.m2505o(116579);
                            return -1;
                        } else if (uW.frO > this.fXD && cF.cqs < 6000) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " totalLen:" + uW.frO);
                            C32850q.m53738um(this.fileName);
                            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.m2505o(116579);
                            return -1;
                        } else if (uW.frO <= this.fXD) {
                            Integer num = (Integer) C32850q.gak.get(C32850q.getFullPath(this.fileName));
                            if (!(num == null || num.intValue() == 0)) {
                                C37965g cF2 = uN.mo5461cF(0, ((Integer) C32850q.gal.get(C32850q.getFullPath(this.fileName))).intValue());
                                int c = C32850q.m53719c(num.intValue() & 255, cF2.buf, cF2.cqs);
                                if (num.intValue() != c) {
                                    C4990ab.m7413e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", Integer.valueOf(c), num, Integer.valueOf(i2), Integer.valueOf(cF2.cqs));
                                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " totalLen:" + uW.frO);
                                    C7060h.pYm.mo8378a(111, 173, 1, false);
                                    C32850q.gak.put(C32850q.getFullPath(this.fileName), Integer.valueOf(c));
                                    num = (Integer) C32850q.gam.get(C32850q.getFullPath(this.fileName));
                                    if (!(num == null || num.intValue() == 0 || num.intValue() == C32850q.m53718b(0, cF2.buf, cF2.cqs))) {
                                        C4990ab.m7413e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", num, Integer.valueOf(C32850q.m53718b(0, cF2.buf, cF2.cqs)));
                                        C32850q.m53738um(this.fileName);
                                        this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                                        C7060h.pYm.mo8378a(111, 174, 1, false);
                                        AppMethodBeat.m2505o(116579);
                                        return -1;
                                    }
                                }
                            }
                            this.endFlag = 1;
                        }
                    }
                    i2 = format;
                    i = 0;
                    c37965g = cF;
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(116579);
                    return -1;
                }
            }
            int i3 = uW.gaf;
            C4990ab.m7417i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", Integer.valueOf(i3));
            if (i3 == 0) {
                i3 = C32850q.m53737uX(this.fileName);
                C4990ab.m7417i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", Integer.valueOf(i3));
                if (i3 < 0) {
                    i3 = C32850q.m53723mt(this.fXD);
                    C4990ab.m7417i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", Integer.valueOf(i3));
                }
            }
            int i4 = i3;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new clx();
            c1196a.fsK = new cly();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            c1196a.fsI = C31128d.MIC_SketchMark;
            c1196a.fsL = 19;
            c1196a.fsM = 1000000019;
            this.ehh = c1196a.acD();
            clx clx = (clx) this.ehh.fsG.fsP;
            clx.ndG = C1853r.m3846Yz();
            clx.ndF = uW.cIS;
            clx.vOq = uW.fVG;
            clx.vFF = uW.clientId;
            clx.wdp = i4;
            clx.fJT = this.endFlag;
            clx.ptF = uW.cKK;
            clx.wdq = i;
            clx.xjG = this.fZe;
            clx.vEG = C1831bh.aaf();
            clx.vEG = C26350a.m41930KG().mo35237F(uW.cIS, uW.fXe);
            clx.wEz = i2;
            if (i != 1) {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(c37965g.buf, 0, c37965g.cqs);
                clx.wdn = c37965g.cqs;
            } else {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(C1332b.m2847bI(new byte[1]));
                clx.wdn = 1;
            }
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + uW.cKK);
            C4990ab.m7418v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + clx.ptF + " user:" + clx.ndF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
            C4990ab.m7416i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + uW.cKK + " voiceFormat:" + i2 + " file:" + this.fileName + " readBytes:" + c37965g.cqs + " neTTTOff:" + uW.fVG + " neWWWOff:" + this.fXD + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + uW.status + " voiceLen:" + i4);
            this.fZf = System.currentTimeMillis();
            i3 = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(116579);
            return i3;
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        C32850q.m53738um(this.fileName);
        this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.m2505o(116579);
        return -1;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(116580);
        clx clx = (clx) ((C7472b) c1929q).fsG.fsP;
        C4990ab.m7418v("MicroMsg.NetSceneUploadVoice", "check msgId:" + clx.ptF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
        C1206b c1206b;
        if ((clx.ptF != 0 || clx.vOq == 0) && (!(clx.ptz == null || clx.ptz.getILen() == 0) || clx.fJT == 1 || clx.wdq == 1)) {
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(116580);
            return c1206b;
        }
        c1206b = C1206b.EFailed;
        AppMethodBeat.m2505o(116580);
        return c1206b;
    }

    public final int acn() {
        return 60;
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(116581);
        boolean acJ = super.acJ();
        if (acJ) {
            C7060h.pYm.mo8378a(111, 239, 1, false);
        }
        AppMethodBeat.m2505o(116581);
        return acJ;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(116582);
        C7060h.pYm.mo8378a(111, 238, 1, false);
        C32850q.m53738um(this.fileName);
        AppMethodBeat.m2505o(116582);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116583);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        clx clx = (clx) ((C7472b) c1929q).fsG.fsP;
        cly cly = (cly) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 4 && i3 == -22) {
            C32850q.m53739un(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116583);
        } else if (i2 == 4 && i3 != 0) {
            C32850q.m53738um(this.fileName);
            C7060h.pYm.mo8378a(111, 237, 1, false);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116583);
        } else if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + cly.ptF + " toUser:" + clx.ndF);
            if (cly.ptF > 0 || C7616ad.m13548mR(clx.ndF)) {
                C4990ab.m7411d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(cly.ptF), Integer.valueOf(C1947ae.giA));
                if (CdnLogic.kMediaTypeFavoriteBigFile == C1947ae.giz && C1947ae.giA != 0) {
                    cly.ptF = (long) C1947ae.giA;
                    C1947ae.giA = 0;
                }
                int a = C32850q.m53710a(this.fileName, this.fXD, cly.ptF, cly.vFF, this.endFlag, this.fZe);
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a + " file:" + this.fileName + " MsgSvrId:" + cly.ptF + " clientId:" + cly.vFF + " neWWOff:" + this.fXD + " neTTTT:" + cly.wdn + " forwardflag:" + this.fZe);
                if (a < 0) {
                    C32850q.m53738um(this.fileName);
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + a);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(116583);
                    return;
                } else if (a == 1) {
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
                    C45457b.fRa.mo73265j(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) C32850q.m53736uW(this.fileName).fXe));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(116583);
                    return;
                } else {
                    long j = this.fZa ? 0 : 500;
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + j);
                    this.frk.mo16770ae(j, j);
                    AppMethodBeat.m2505o(116583);
                    return;
                }
            }
            C7060h.pYm.mo8378a(111, 235, 1, false);
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + cly.ptF + " netoff:" + cly.vOq);
            C32850q.m53738um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116583);
        } else {
            C7060h.pYm.mo8378a(111, 236, 1, false);
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116583);
        }
    }

    public final int getType() {
        return C31128d.MIC_SketchMark;
    }
}
