package com.tencent.mm.modelvoice;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.d;
import junit.framework.Assert;

public final class f extends m implements k {
    private b ehh;
    com.tencent.mm.ai.f ehi;
    private int endFlag;
    private int fXD;
    private boolean fZa;
    private int fZe;
    long fZf;
    public String fileName;
    ap frk;
    public int retCode;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        boolean z = true;
        AppMethodBeat.i(116578);
        this.retCode = 0;
        this.fXD = 0;
        this.fZa = false;
        this.endFlag = 0;
        this.frk = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(116577);
                p uW = q.uW(f.this.fileName);
                if (uW == null || !uW.ame()) {
                    ab.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
                    f.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    f.this.ehi.onSceneEnd(3, -1, "doScene failed", f.this);
                    AppMethodBeat.o(116577);
                    return false;
                }
                if (!(3 == uW.status || 8 == uW.status)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((currentTimeMillis / 1000) - uW.fXb > 30) {
                        ab.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
                        f.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                        f.this.ehi.onSceneEnd(3, -1, "doScene failed", f.this);
                        AppMethodBeat.o(116577);
                        return false;
                    } else if (currentTimeMillis - f.this.fZf < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                        ab.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (currentTimeMillis - f.this.fZf));
                        AppMethodBeat.o(116577);
                        return true;
                    } else {
                        g cF = q.uN(f.this.fileName).cF(uW.fVG, 6000);
                        ab.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + cF.cqs + " stat:" + uW.status);
                        if (cF.cqs < 2000) {
                            AppMethodBeat.o(116577);
                            return true;
                        }
                    }
                }
                if (f.this.a(f.this.ftf, f.this.ehi) == -1) {
                    f.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    f.this.ehi.onSceneEnd(3, -1, "doScene failed", f.this);
                }
                AppMethodBeat.o(116577);
                return false;
            }
        }, true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        ab.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.fZe = i;
        AppMethodBeat.o(116578);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(116579);
        this.ehi = fVar;
        this.fZa = false;
        if (this.fileName == null) {
            ab.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(116579);
            return -1;
        }
        p uW = q.uW(this.fileName);
        if (uW == null || !uW.ame()) {
            ab.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(116579);
            return -1;
        }
        ab.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + uW.fXf);
        if (q.uM(this.fileName)) {
            int i;
            int i2;
            g gVar = new g();
            if (uW.status == 8) {
                ab.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
                i = 1;
                this.endFlag = 0;
                q.uS(uW.fileName);
                i2 = 0;
            } else {
                if (uW.status == 3) {
                    this.fZa = true;
                }
                b uN = q.uN(this.fileName);
                if (uN == null) {
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    ab.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", this.fileName);
                    AppMethodBeat.o(116579);
                    return -1;
                }
                int format = uN.getFormat();
                ab.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(format)));
                g cF = uN.cF(uW.fVG, 6000);
                ab.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " line:" + g.getLine());
                if (cF.ret < 0) {
                    h.pYm.a(111, 241, 1, false);
                    ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG);
                    q.um(this.fileName);
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(116579);
                    return -1;
                }
                this.fXD = cF.fXD;
                if (this.fXD < uW.fVG || this.fXD >= 469000) {
                    h.pYm.a(111, 240, 1, false);
                    ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXD + " OldtOff:" + uW.fVG);
                    q.um(this.fileName);
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(116579);
                    return -1;
                }
                this.endFlag = 0;
                if (cF.cqs != 0 || this.fZa) {
                    if (this.fZa) {
                        if (uW.frO <= 0) {
                            ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + uW.frO);
                            q.um(this.fileName);
                            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.o(116579);
                            return -1;
                        } else if (uW.frO > this.fXD && cF.cqs < 6000) {
                            ab.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " totalLen:" + uW.frO);
                            q.um(this.fileName);
                            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.o(116579);
                            return -1;
                        } else if (uW.frO <= this.fXD) {
                            Integer num = (Integer) q.gak.get(q.getFullPath(this.fileName));
                            if (!(num == null || num.intValue() == 0)) {
                                g cF2 = uN.cF(0, ((Integer) q.gal.get(q.getFullPath(this.fileName))).intValue());
                                int c = q.c(num.intValue() & 255, cF2.buf, cF2.cqs);
                                if (num.intValue() != c) {
                                    ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", Integer.valueOf(c), num, Integer.valueOf(i2), Integer.valueOf(cF2.cqs));
                                    ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + uW.fVG + " totalLen:" + uW.frO);
                                    h.pYm.a(111, 173, 1, false);
                                    q.gak.put(q.getFullPath(this.fileName), Integer.valueOf(c));
                                    num = (Integer) q.gam.get(q.getFullPath(this.fileName));
                                    if (!(num == null || num.intValue() == 0 || num.intValue() == q.b(0, cF2.buf, cF2.cqs))) {
                                        ab.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", num, Integer.valueOf(q.b(0, cF2.buf, cF2.cqs)));
                                        q.um(this.fileName);
                                        this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                                        h.pYm.a(111, 174, 1, false);
                                        AppMethodBeat.o(116579);
                                        return -1;
                                    }
                                }
                            }
                            this.endFlag = 1;
                        }
                    }
                    i2 = format;
                    i = 0;
                    gVar = cF;
                } else {
                    ab.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(116579);
                    return -1;
                }
            }
            int i3 = uW.gaf;
            ab.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", Integer.valueOf(i3));
            if (i3 == 0) {
                i3 = q.uX(this.fileName);
                ab.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", Integer.valueOf(i3));
                if (i3 < 0) {
                    i3 = q.mt(this.fXD);
                    ab.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", Integer.valueOf(i3));
                }
            }
            int i4 = i3;
            b.a aVar = new b.a();
            aVar.fsJ = new clx();
            aVar.fsK = new cly();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            aVar.fsI = d.MIC_SketchMark;
            aVar.fsL = 19;
            aVar.fsM = 1000000019;
            this.ehh = aVar.acD();
            clx clx = (clx) this.ehh.fsG.fsP;
            clx.ndG = r.Yz();
            clx.ndF = uW.cIS;
            clx.vOq = uW.fVG;
            clx.vFF = uW.clientId;
            clx.wdp = i4;
            clx.fJT = this.endFlag;
            clx.ptF = uW.cKK;
            clx.wdq = i;
            clx.xjG = this.fZe;
            clx.vEG = bh.aaf();
            clx.vEG = com.tencent.mm.l.a.a.KG().F(uW.cIS, uW.fXe);
            clx.wEz = i2;
            if (i != 1) {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(gVar.buf, 0, gVar.cqs);
                clx.wdn = gVar.cqs;
            } else {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bt.b.bI(new byte[1]));
                clx.wdn = 1;
            }
            ab.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + uW.cKK);
            ab.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + clx.ptF + " user:" + clx.ndF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
            ab.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + uW.cKK + " voiceFormat:" + i2 + " file:" + this.fileName + " readBytes:" + gVar.cqs + " neTTTOff:" + uW.fVG + " neWWWOff:" + this.fXD + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + uW.status + " voiceLen:" + i4);
            this.fZf = System.currentTimeMillis();
            i3 = a(eVar, this.ehh, this);
            AppMethodBeat.o(116579);
            return i3;
        }
        ab.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.um(this.fileName);
        this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.o(116579);
        return -1;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(116580);
        clx clx = (clx) ((b) qVar).fsG.fsP;
        ab.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + clx.ptF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
        m.b bVar;
        if ((clx.ptF != 0 || clx.vOq == 0) && (!(clx.ptz == null || clx.ptz.getILen() == 0) || clx.fJT == 1 || clx.wdq == 1)) {
            bVar = m.b.EOk;
            AppMethodBeat.o(116580);
            return bVar;
        }
        bVar = m.b.EFailed;
        AppMethodBeat.o(116580);
        return bVar;
    }

    public final int acn() {
        return 60;
    }

    public final boolean acJ() {
        AppMethodBeat.i(116581);
        boolean acJ = super.acJ();
        if (acJ) {
            h.pYm.a(111, 239, 1, false);
        }
        AppMethodBeat.o(116581);
        return acJ;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(116582);
        h.pYm.a(111, 238, 1, false);
        q.um(this.fileName);
        AppMethodBeat.o(116582);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116583);
        ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        clx clx = (clx) ((b) qVar).fsG.fsP;
        cly cly = (cly) ((b) qVar).fsH.fsP;
        if (i2 == 4 && i3 == -22) {
            q.un(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116583);
        } else if (i2 == 4 && i3 != 0) {
            q.um(this.fileName);
            h.pYm.a(111, 237, 1, false);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116583);
        } else if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + cly.ptF + " toUser:" + clx.ndF);
            if (cly.ptF > 0 || ad.mR(clx.ndF)) {
                ab.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(cly.ptF), Integer.valueOf(ae.giA));
                if (CdnLogic.kMediaTypeFavoriteBigFile == ae.giz && ae.giA != 0) {
                    cly.ptF = (long) ae.giA;
                    ae.giA = 0;
                }
                int a = q.a(this.fileName, this.fXD, cly.ptF, cly.vFF, this.endFlag, this.fZe);
                ab.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a + " file:" + this.fileName + " MsgSvrId:" + cly.ptF + " clientId:" + cly.vFF + " neWWOff:" + this.fXD + " neTTTT:" + cly.wdn + " forwardflag:" + this.fZe);
                if (a < 0) {
                    q.um(this.fileName);
                    ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + a);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(116583);
                    return;
                } else if (a == 1) {
                    ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
                    com.tencent.mm.modelstat.b.fRa.j(((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf((long) q.uW(this.fileName).fXe));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(116583);
                    return;
                } else {
                    long j = this.fZa ? 0 : 500;
                    ab.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + j);
                    this.frk.ae(j, j);
                    AppMethodBeat.o(116583);
                    return;
                }
            }
            h.pYm.a(111, 235, 1, false);
            ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + cly.ptF + " netoff:" + cly.vOq);
            q.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116583);
        } else {
            h.pYm.a(111, 236, 1, false);
            ab.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116583);
        }
    }

    public final int getType() {
        return d.MIC_SketchMark;
    }
}
