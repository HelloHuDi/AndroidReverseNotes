package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.subapp.p1039c.C35265c.C13899a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clx;
import com.tencent.p177mm.protocal.protobuf.cly;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.c.b */
public final class C46290b extends C1207m implements C1918k {
    private C7472b ehh;
    C1202f ehi;
    private int endFlag = 0;
    private int fXD = 0;
    private boolean fZa = false;
    long fZf;
    String fileName;
    C7564ap frk = new C7564ap(new C138981(), true);
    int retCode = 0;

    /* renamed from: com.tencent.mm.plugin.subapp.c.b$1 */
    class C138981 implements C5015a {
        C138981() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25250);
            C29385g abp = C41315d.cDE().abp(C46290b.this.fileName);
            if (abp == null || !abp.ame()) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + C46290b.this.fileName);
                C46290b.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                C46290b.this.ehi.onSceneEnd(3, -1, "doScene failed", C46290b.this);
                AppMethodBeat.m2505o(25250);
                return false;
            }
            if (!(3 == abp.field_status || 8 == abp.field_status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - abp.field_lastmodifytime > 30) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + C46290b.this.fileName);
                    C46290b.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    C46290b.this.ehi.onSceneEnd(3, -1, "doScene failed", C46290b.this);
                    AppMethodBeat.m2505o(25250);
                    return false;
                } else if (currentTimeMillis - C46290b.this.fZf < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + C46290b.this.fileName + " but last send time:" + (currentTimeMillis - C46290b.this.fZf));
                    AppMethodBeat.m2505o(25250);
                    return true;
                } else {
                    C13899a Fo = C22335h.abm(C46290b.this.fileName).mo55981Fo(abp.field_offset);
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + C46290b.this.fileName + " readByte:" + Fo.cqs + " stat:" + abp.field_status);
                    if (Fo.cqs < 2000) {
                        AppMethodBeat.m2505o(25250);
                        return true;
                    }
                }
            }
            if (C46290b.this.mo4456a(C46290b.this.ftf, C46290b.this.ehi) == -1) {
                C46290b.this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                C46290b.this.ehi.onSceneEnd(3, -1, "doScene failed", C46290b.this);
            }
            AppMethodBeat.m2505o(25250);
            return false;
        }
    }

    public C46290b(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(25251);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        AppMethodBeat.m2505o(25251);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25252);
        this.ehi = c1202f;
        this.fZa = false;
        if (this.fileName == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(25252);
            return -1;
        }
        C29385g abp = C41315d.cDE().abp(this.fileName);
        if (abp == null || !abp.ame()) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
            AppMethodBeat.m2505o(25252);
            return -1;
        }
        boolean z;
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + abp.field_nettimes);
        String str = this.fileName;
        if (str == null) {
            z = false;
        } else {
            C29385g abp2 = C41315d.cDE().abp(str);
            if (abp2 == null) {
                z = false;
            } else if (abp2.field_nettimes >= 80) {
                z = false;
            } else {
                abp2.field_nettimes++;
                abp2.bJt = 16384;
                z = C22335h.m34030a(abp2);
            }
        }
        if (z) {
            int i;
            C13899a c13899a;
            int i2;
            C13899a c13899a2 = new C13899a();
            if (abp.field_status == 8) {
                C4990ab.m7418v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
                this.endFlag = 1;
                C22335h.m34033uS(abp.field_filename);
                i = 1;
                c13899a = c13899a2;
            } else {
                if (abp.field_status == 3) {
                    this.fZa = true;
                }
                C35265c abm = C22335h.abm(this.fileName);
                if (abm == null) {
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(25252);
                    return -1;
                }
                c13899a2 = abm.mo55981Fo(abp.field_offset);
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + c13899a2.ret + " readlen:" + c13899a2.cqs + " newOff:" + c13899a2.fXD + " netOff:" + abp.field_offset + " line:" + C1447g.getLine());
                if (c13899a2.ret < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + c13899a2.ret + " readlen:" + c13899a2.cqs + " newOff:" + c13899a2.fXD + " netOff:" + abp.field_offset);
                    C22335h.m34034um(this.fileName);
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(25252);
                    return -1;
                }
                this.fXD = c13899a2.fXD;
                if (this.fXD < abp.field_offset || this.fXD >= 469000) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXD + " OldtOff:" + abp.field_offset);
                    C22335h.m34034um(this.fileName);
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(25252);
                    return -1;
                }
                this.endFlag = 0;
                if (c13899a2.cqs != 0 || this.fZa) {
                    if (this.fZa) {
                        if (abp.field_totallen <= 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + abp.field_totallen);
                            C22335h.m34034um(this.fileName);
                            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.m2505o(25252);
                            return -1;
                        } else if (abp.field_totallen > this.fXD && c13899a2.cqs < 6000) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + c13899a2.cqs + " newOff:" + c13899a2.fXD + " netOff:" + abp.field_offset + " totalLen:" + abp.field_totallen);
                            C22335h.m34034um(this.fileName);
                            this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                            AppMethodBeat.m2505o(25252);
                            return -1;
                        } else if (abp.field_totallen <= this.fXD) {
                            this.endFlag = 1;
                        }
                    }
                    i = 0;
                    c13899a = c13899a2;
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    C22335h.m34034um(this.fileName);
                    this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                    AppMethodBeat.m2505o(25252);
                    return -1;
                }
            }
            int i3 = abp.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.fXD - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + abp.field_msgid);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new clx();
            c1196a.fsK = new cly();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            c1196a.fsI = ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
            c1196a.fsL = 157;
            c1196a.fsM = 1000000157;
            this.ehh = c1196a.acD();
            clx clx = (clx) this.ehh.fsG.fsP;
            clx.ndG = C1853r.m3846Yz();
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
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(c13899a.buf, 0, c13899a.cqs);
                clx.wdn = c13899a.cqs;
            } else {
                clx.ptz = new SKBuiltinBuffer_t().setBuffer(C1332b.m2847bI(new byte[1]));
                clx.wdn = 1;
            }
            C4990ab.m7418v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + abp.field_msgid);
            C4990ab.m7418v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + clx.ptF + " user:" + clx.ndF + " offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + abp.field_msgid + " file:" + this.fileName + " readBytes:" + c13899a.cqs + " neTTTOff:" + abp.field_offset + " neWWWOff:" + this.fXD + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + abp.field_status);
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + clx.toString());
            this.fZf = System.currentTimeMillis();
            i3 = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(25252);
            return i3;
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
        C22335h.m34034um(this.fileName);
        this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
        AppMethodBeat.m2505o(25252);
        return -1;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(25253);
        clx clx = (clx) ((C7472b) c1929q).fsG.fsP;
        C4990ab.m7418v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + clx.vOq + " dataLen:" + clx.ptz.getILen() + " endFlag:" + clx.fJT);
        C1206b c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(25253);
        return c1206b;
    }

    public final int acn() {
        return 240;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(25254);
        C22335h.m34034um(this.fileName);
        AppMethodBeat.m2505o(25254);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25255);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        clx clx = (clx) ((C7472b) c1929q).fsG.fsP;
        cly cly = (cly) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + cly.toString());
        if (i2 == 4 && i3 == -22) {
            C29385g abp = C41315d.cDE().abp(this.fileName);
            if (abp != null) {
                if (abp.field_status == 3) {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf((long) abp.field_msglocalid);
                    jf.setContent(C39938f.m68400d(abp.field_human, (long) abp.field_voicelenght, false));
                    jf.setStatus(2);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a((long) abp.field_msglocalid, jf);
                }
                abp.field_status = 97;
                abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                abp.bJt = 320;
                C22335h.m34030a(abp);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25255);
        } else if (i2 == 4 && i3 != 0) {
            C22335h.m34034um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25255);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + cly.ptF + " toUser:" + clx.ndF);
            String str2 = this.fileName;
            int i5 = this.fXD;
            long j = cly.ptF;
            String str3 = cly.vFF;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                C29385g abp2 = C41315d.cDE().abp(str2);
                if (abp2 == null) {
                    i4 = -1;
                } else {
                    abp2.field_offset = i5;
                    abp2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    abp2.bJt = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
                    if (C5046bo.isNullOrNil(abp2.field_clientid) && str3 != null) {
                        abp2.field_clientid = str3;
                        abp2.bJt |= 512;
                    }
                    if (abp2.field_msgid == 0 && j != 0) {
                        abp2.field_msgid = j;
                        abp2.bJt |= 4;
                    }
                    i4 = 0;
                    C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + abp2.field_totallen + "  newOffset " + i5 + "  " + abp2.field_status);
                    if (abp2.field_totallen <= i5 && abp2.field_status == 3 && i6 == 1) {
                        abp2.field_status = 99;
                        abp2.bJt |= 64;
                        C9638aw.m17190ZK();
                        C7620bi jf2 = C18628c.m29080XO().mo15340jf((long) abp2.field_msglocalid);
                        jf2.mo14794ju(abp2.field_user);
                        jf2.mo14774eI(abp2.field_msgid);
                        jf2.setStatus(2);
                        jf2.setContent(C39938f.m68400d(abp2.field_human, (long) abp2.field_voicelenght, false));
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a((long) abp2.field_msglocalid, jf2);
                        C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + abp2.field_totallen + " status:" + abp2.field_status + " netTimes:" + abp2.field_nettimes);
                        i4 = 1;
                        C22335h.m34032uO(str2);
                    }
                    if (!C22335h.m34030a(abp2)) {
                        i4 = -4;
                    }
                }
            }
            C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.fileName + " MsgSvrId:" + cly.ptF + " clientId:" + cly.vFF + " neWWOff:" + this.fXD + " neTTTT:" + cly.wdn);
            if (i4 < 0) {
                C22335h.m34034um(this.fileName);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + i4);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(25255);
            } else if (i4 == 1) {
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(25255);
            } else {
                long j2 = this.fZa ? 0 : 500;
                C4990ab.m7410d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + j2);
                this.frk.mo16770ae(j2, j2);
                AppMethodBeat.m2505o(25255);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25255);
        }
    }

    public final int getType() {
        return ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
    }
}
