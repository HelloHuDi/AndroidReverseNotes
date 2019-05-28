package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b extends n<col, com> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        AppMethodBeat.i(4699);
        a aVar = new a();
        aVar.fsJ = new col();
        aVar.fsK = new com();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_2;
        aVar.fsL = 65;
        aVar.fsM = 1000000065;
        this.ehh = aVar.acD();
        col col = (col) this.ehh.fsG.fsP;
        col.xmb = i;
        col.wem = i3;
        col.vZF = i2;
        cpx cpx = new cpx();
        cpx.jCt = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        cpx.vJd = sKBuiltinBuffer_t;
        col.xlM = cpx;
        cpx = new cpx();
        cpx.jCt = 3;
        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr2);
        cpx.vJd = sKBuiltinBuffer_t;
        col.xlN = cpx;
        col.wen = j;
        if (z2) {
            col.xmc = z ? 1 : 0;
        }
        col.xlQ = System.currentTimeMillis();
        int bOK = ((com.tencent.mm.plugin.misc.a.a) g.K(com.tencent.mm.plugin.misc.a.a.class)).bOK();
        ab.i(this.TAG, "simType: %s", Integer.valueOf(bOK));
        bOK = bOK == 0 ? 0 : bOK == 1 ? 1 : 2;
        col.xlR = bOK;
        AppMethodBeat.o(4699);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_2;
    }

    public final f cKt() {
        AppMethodBeat.i(4700);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4698);
                com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + b.this.sPK.mStatus);
                if (b.this.sPK.mStatus == 1) {
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "reject ok!");
                    AppMethodBeat.o(4698);
                } else if (b.this.sPK.mStatus != 4) {
                    com.tencent.mm.plugin.voip.a.a.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
                    AppMethodBeat.o(4698);
                } else if (i == 0) {
                    com com = (com) b.this.cKx();
                    b.this.sPK.sPp.nwu = com.wem;
                    b.this.sPK.sPp.nwv = com.wen;
                    b.this.sPK.sPp.nwC = com.xlS;
                    b.this.sPK.sPp.sUE = com.xmf;
                    b.this.sPK.sPp.sUF = com.xmg;
                    b.this.sPK.sPp.sUG = com.xmh;
                    b.this.sPK.sPp.sUH = com.xmi;
                    b.this.sPK.sPp.sUJ = com.xmk;
                    b.this.sPK.sPp.sUI = com.xmp;
                    b.this.sPK.sPp.sUi = com.xlW;
                    b.this.sPK.sPp.sUL = com.xmr;
                    b.this.sPK.Gn(com.xlU);
                    b.this.sPK.sPp.sUk = com.xlX;
                    if (com.xlY.getILen() >= 12) {
                        ByteBuffer wrap = ByteBuffer.wrap(com.xlY.getBuffer().toByteArray(), 8, 4);
                        ByteOrder nativeOrder = ByteOrder.nativeOrder();
                        ByteOrder order = wrap.order();
                        int i3 = wrap.getInt();
                        com.tencent.mm.plugin.voip.a.a.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                        b.this.sPK.sPp.sUK = i3;
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.sPK.sPp.sUE + ",audioTsdEdge = " + b.this.sPK.sPp.sUF + ",passthroughQosAlgorithm = " + b.this.sPK.sPp.sUG + ",fastPlayRepair = " + b.this.sPK.sPp.sUH + ", audioDtx = " + b.this.sPK.sPp.sUJ + ", switchtcppktCnt=" + b.this.sPK.sPp.sUh + ", SvrCfgListV=" + b.this.sPK.sPp.sUI + ", setMaxBRForRelay=" + b.this.sPK.sPp.sUL + ", RedirectreqThreshold=" + com.xlT.xnx + ", BothSideSwitchFlag=" + com.xlT.xny + ", WifiScanInterval=" + com.xlX + ", BaseBRTuneRatio=" + b.this.sPK.sPp.sUK);
                    b.this.sPK.sPp.sUM = com.xmo;
                    b.this.sPK.sPp.sUN = com.xms;
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.sPK.sPp.sUM);
                    boolean cKN = v2protocal.cKN();
                    com.tencent.mm.bu.a aVar = com.tencent.mm.bu.a.xtM;
                    boolean dmB = com.tencent.mm.bu.a.dmB();
                    boolean z = com.tencent.mm.plugin.voip.b.cIl() == 0;
                    int i4 = q.etc.erz;
                    int i5 = (b.this.sPK.sPp.sUi >> 4) & 7;
                    int i6 = 0;
                    if (cKN && i4 != 0 && dmB && z) {
                        if (i4 > 0) {
                            i6 = i4;
                        } else if (i5 >= 0) {
                            i6 = i5;
                        }
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "NetSceneAnswerResp set voipbeauty local=" + cKN + ", server=" + i5 + ", blacklist=" + i4 + ", isLibReady=" + dmB + ",isLibInitOK=" + z + ", UICallback" + b.this.sPK.sPq + ", finalFlag=" + i6);
                    if (b.this.sPK.sPq != null) {
                        b.this.sPK.sPq.setVoipBeauty(i6);
                    }
                    b.this.sPK.sPp.sVl = i6;
                    b.this.sPK.sPp.sVm = i5;
                    b.this.sPK.sOP = true;
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "answer ok, roomid =" + b.this.sPK.sPp.nwu + ",memberid = " + b.this.sPK.sPp.nwC);
                    final cpr cpr = com.xlT;
                    if (cpr.nwQ > 0) {
                        cpr.nwQ--;
                        com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + cpr.nwQ + "] from answerresp relaydata");
                    } else {
                        cpr.nwQ = 1;
                        com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "answer with relayData peerid.length =" + cpr.xlM.vJd.getILen());
                    com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "answer with relayData capinfo.length =" + cpr.xlN.vJd.getILen());
                    b.this.sPK.Gm(cpr.xnc);
                    b.this.sPK.sPB.a(cpr.xnC, cpr.xnB, b.this.sPK.sPp.nwu, b.this.sPK.sPp.nwv);
                    try {
                        g.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(4697);
                                com.tencent.mm.plugin.voip.b.cIj().cKd();
                                com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "steve:doublelink timer started!");
                                b.this.sPK.a(cpr.xnd, cpr.xne, cpr.xnl, cpr.xnE);
                                if (cpr.xlM.vJd.getBuffer() != null) {
                                    b.this.sPK.bo(cpr.xlM.vJd.getBuffer().toByteArray());
                                } else {
                                    ab.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                                }
                                if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                                    b.this.sPK.a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, cpr.nwQ, cpr.xnv.getBuffer().toByteArray());
                                }
                                b.this.sPK.i(cpr.xnm, cpr.xnn, cpr.xno, cpr.xnp, cpr.xnq);
                                b.this.sPK.Gl(cpr.xnu);
                                if (!(cpr.xns == null || cpr.xnt == null || cpr.xns.getBuffer() == null || cpr.xnt.getBuffer() == null)) {
                                    b.this.sPK.b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                                }
                                if (cpr.xlN.vJd.getBuffer() != null) {
                                    b.this.sPK.bp(cpr.xlN.vJd.getBuffer().toByteArray());
                                } else {
                                    ab.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                                }
                                b.this.sPK.Gk(cpr.xnx);
                                b.this.sPK.sPp.sVb = cpr.xny;
                                if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                                    b.this.sPK.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                                }
                                if (b.this.sPK.sOR) {
                                    b.this.sPK.sOR = false;
                                    if (b.this.sPK.sON) {
                                        com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                                        b.this.sPK.cIO();
                                    } else if (b.this.sPK.sOQ) {
                                        com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "channel pre-connect already failed");
                                        b.this.sPK.v(1, -9000, "");
                                        AppMethodBeat.o(4697);
                                        return;
                                    } else {
                                        com.tencent.mm.plugin.voip.a.a.Logi(b.this.TAG, "channel pre-connect still connecting...");
                                    }
                                } else {
                                    ab.i(b.this.TAG, "isPreConnect is false");
                                }
                                b.this.sPK.cIV();
                                b.this.sPK.cIT();
                                AppMethodBeat.o(4697);
                            }
                        });
                        AppMethodBeat.o(4698);
                    } catch (Exception e) {
                        ab.e(b.this.TAG, "get proxy ip fail..");
                        AppMethodBeat.o(4698);
                    }
                } else if (i == 4) {
                    b.this.sPK.sPp.sVH.sQe = 12;
                    b.this.sPK.sPp.sVH.sQf = i2;
                    b.this.sPK.v(1, i2, "");
                    AppMethodBeat.o(4698);
                } else {
                    b.this.sPK.sPp.sVH.sQe = 12;
                    b.this.sPK.sPp.sVH.sQf = i2;
                    b.this.sPK.v(1, -9004, "");
                    AppMethodBeat.o(4698);
                }
            }
        };
        AppMethodBeat.o(4700);
        return anonymousClass1;
    }
}
