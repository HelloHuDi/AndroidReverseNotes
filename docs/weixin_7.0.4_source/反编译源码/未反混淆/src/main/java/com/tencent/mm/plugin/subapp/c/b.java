package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.d;
import junit.framework.Assert;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    f ehi;
    private int endFlag = 0;
    private int fXD = 0;
    private boolean fZa = false;
    long fZf;
    String fileName;
    ap frk = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(25250);
            g abp = d.cDE().abp(b.this.fileName);
            if (abp == null || !abp.ame()) {
                ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
                b.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                b.this.ehi.onSceneEnd(3, -1, "doScene failed", b.this);
                AppMethodBeat.o(25250);
                return false;
            }
            if (!(3 == abp.field_status || 8 == abp.field_status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - abp.field_lastmodifytime > 30) {
                    ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
                    b.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    b.this.ehi.onSceneEnd(3, -1, "doScene failed", b.this);
                    AppMethodBeat.o(25250);
                    return false;
                } else if (currentTimeMillis - b.this.fZf < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (currentTimeMillis - b.this.fZf));
                    AppMethodBeat.o(25250);
                    return true;
                } else {
                    c.a Fo = h.abm(b.this.fileName).Fo(abp.field_offset);
                    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + Fo.cqs + " stat:" + abp.field_status);
                    if (Fo.cqs < 2000) {
                        AppMethodBeat.o(25250);
                        return true;
                    }
                }
            }
            if (b.this.a(b.this.ftf, b.this.ehi) == -1) {
                b.this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                b.this.ehi.onSceneEnd(3, -1, "doScene failed", b.this);
            }
            AppMethodBeat.o(25250);
            return false;
        }
    }, true);
    int retCode = 0;

    public b(String str) {
        boolean z = true;
        AppMethodBeat.i(25251);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        AppMethodBeat.o(25251);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25252);
        this.ehi = fVar;
        this.fZa = false;
        if (this.fileName == null) {
            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(25252);
            return -1;
        }
        g abp = d.cDE().abp(this.fileName);
        if (abp == null || !abp.ame()) {
            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.o(25252);
            return -1;
        }
        boolean z;
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + abp.field_nettimes);
        String str = this.fileName;
        if (str == null) {
            z = false;
        } else {
            g abp2 = d.cDE().abp(str);
            if (abp2 == null) {
                z = false;
            } else if (abp2.field_nettimes >= 80) {
                z = false;
            } else {
                abp2.field_nettimes++;
                abp2.bJt = 16384;
                z = h.a(abp2);
            }
        }
        if (z) {
            int i;
            c.a aVar;
            int i2;
            c.a aVar2 = new c.a();
            if (abp.field_status == 8) {
                ab.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
                this.endFlag = 1;
                h.uS(abp.field_filename);
                i = 1;
                aVar = aVar2;
            } else {
                if (abp.field_status == 3) {
                    this.fZa = true;
                }
                c abm = h.abm(this.fileName);
                if (abm == null) {
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(25252);
                    return -1;
                }
                aVar2 = abm.Fo(abp.field_offset);
                ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + aVar2.ret + " readlen:" + aVar2.cqs + " newOff:" + aVar2.fXD + " netOff:" + abp.field_offset + " line:" + g.getLine());
                if (aVar2.ret < 0) {
                    ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + aVar2.ret + " readlen:" + aVar2.cqs + " newOff:" + aVar2.fXD + " netOff:" + abp.field_offset);
                    h.um(this.fileName);
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(25252);
                    return -1;
                }
                this.fXD = aVar2.fXD;
                if (this.fXD < abp.field_offset || this.fXD >= 469000) {
                    ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXD + " OldtOff:" + abp.field_offset);
                    h.um(this.fileName);
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(25252);
                    return -1;
                }
                this.endFlag = 0;
                if (aVar2.cqs != 0 || this.fZa) {
                    if (this.fZa) {
                        if (abp.field_totallen <= 0) {
                            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + abp.field_totallen);
                            h.um(this.fileName);
                            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.o(25252);
                            return -1;
                        } else if (abp.field_totallen > this.fXD && aVar2.cqs < 6000) {
                            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + aVar2.cqs + " newOff:" + aVar2.fXD + " netOff:" + abp.field_offset + " totalLen:" + abp.field_totallen);
                            h.um(this.fileName);
                            this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.o(25252);
                            return -1;
                        } else if (abp.field_totallen <= this.fXD) {
                            this.endFlag = 1;
                        }
                    }
                    i = 0;
                    aVar = aVar2;
                } else {
                    ab.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    h.um(this.fileName);
                    this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.o(25252);
                    return -1;
                }
            }
            int i3 = abp.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.fXD - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            ab.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + abp.field_msgid);
            com.tencent.mm.ai.b.a aVar3 = new com.tencent.mm.ai.b.a();
            aVar3.fsJ = new clx();
            aVar3.fsK = new cly();
            aVar3.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            aVar3.fsI = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
            aVar3.fsL = 157;
            aVar3.fsM = 1000000157;
            this.ehh = aVar3.acD();
            clx clx = (clx) this.ehh.fsG.fsP;
            clx.ndG = r.Yz();
            clx.ndF = abp.field_user;
            clx.vOq = abp.field_offset;
            clx.vFF = abp.field_clientid;
            clx.wdp = i2;
            clx.fJT = this.endFlag;
            clx.ptF = abp.field_msgid;
            clx.wdq = i;
            clx.xjF = (int) (abp.field_createtime / 1000);
            clx.wEz = 1;
            if (i != 1) {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(aVar.buf, 0, aVar.cqs);
                clx.wdn = aVar.cqs;
            } else {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bt.b.bI(new byte[1]));
                clx.wdn = 1;
            }
            ab.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + abp.field_msgid);
            ab.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + clx.ptF + " user:" + clx.ndF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
            ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + abp.field_msgid + " file:" + this.fileName + " readBytes:" + aVar.cqs + " neTTTOff:" + abp.field_offset + " neWWWOff:" + this.fXD + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + abp.field_status);
            ab.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + clx.toString());
            this.fZf = System.currentTimeMillis();
            i3 = a(eVar, this.ehh, this);
            AppMethodBeat.o(25252);
            return i3;
        }
        ab.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
        h.um(this.fileName);
        this.retCode = g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.o(25252);
        return -1;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        AppMethodBeat.i(25253);
        clx clx = (clx) ((com.tencent.mm.ai.b) qVar).fsG.fsP;
        ab.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
        com.tencent.mm.ai.m.b bVar = com.tencent.mm.ai.m.b.EOk;
        AppMethodBeat.o(25253);
        return bVar;
    }

    public final int acn() {
        return 240;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(25254);
        h.um(this.fileName);
        AppMethodBeat.o(25254);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25255);
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        clx clx = (clx) ((com.tencent.mm.ai.b) qVar).fsG.fsP;
        cly cly = (cly) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + cly.toString());
        if (i2 == 4 && i3 == -22) {
            g abp = d.cDE().abp(this.fileName);
            if (abp != null) {
                if (abp.field_status == 3) {
                    aw.ZK();
                    bi jf = c.XO().jf((long) abp.field_msglocalid);
                    jf.setContent(f.d(abp.field_human, (long) abp.field_voicelenght, false));
                    jf.setStatus(2);
                    aw.ZK();
                    c.XO().a((long) abp.field_msglocalid, jf);
                }
                abp.field_status = 97;
                abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                abp.bJt = 320;
                h.a(abp);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25255);
        } else if (i2 == 4 && i3 != 0) {
            h.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25255);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + cly.ptF + " toUser:" + clx.ndF);
            String str2 = this.fileName;
            int i5 = this.fXD;
            long j = cly.ptF;
            String str3 = cly.vFF;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                ab.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                g abp2 = d.cDE().abp(str2);
                if (abp2 == null) {
                    i4 = -1;
                } else {
                    abp2.field_offset = i5;
                    abp2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    abp2.bJt = d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
                    if (bo.isNullOrNil(abp2.field_clientid) && str3 != null) {
                        abp2.field_clientid = str3;
                        abp2.bJt |= 512;
                    }
                    if (abp2.field_msgid == 0 && j != 0) {
                        abp2.field_msgid = j;
                        abp2.bJt |= 4;
                    }
                    i4 = 0;
                    ab.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + abp2.field_totallen + "  newOffset " + i5 + "  " + abp2.field_status);
                    if (abp2.field_totallen <= i5 && abp2.field_status == 3 && i6 == 1) {
                        abp2.field_status = 99;
                        abp2.bJt |= 64;
                        aw.ZK();
                        bi jf2 = c.XO().jf((long) abp2.field_msglocalid);
                        jf2.ju(abp2.field_user);
                        jf2.eI(abp2.field_msgid);
                        jf2.setStatus(2);
                        jf2.setContent(f.d(abp2.field_human, (long) abp2.field_voicelenght, false));
                        aw.ZK();
                        c.XO().a((long) abp2.field_msglocalid, jf2);
                        ab.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + abp2.field_totallen + " status:" + abp2.field_status + " netTimes:" + abp2.field_nettimes);
                        i4 = 1;
                        h.uO(str2);
                    }
                    if (!h.a(abp2)) {
                        i4 = -4;
                    }
                }
            }
            ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.fileName + " MsgSvrId:" + cly.ptF + " clientId:" + cly.vFF + " neWWOff:" + this.fXD + " neTTTT:" + cly.wdn);
            if (i4 < 0) {
                h.um(this.fileName);
                ab.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + i4);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(25255);
            } else if (i4 == 1) {
                ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(25255);
            } else {
                long j2 = this.fZa ? 0 : 500;
                ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + j2);
                this.frk.ae(j2, j2);
                AppMethodBeat.o(25255);
            }
        } else {
            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25255);
        }
    }

    public final int getType() {
        return ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
    }
}
