package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p206bu.C32427a;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.C15327com;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.col;
import com.tencent.p177mm.protocal.protobuf.cpr;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.voip.model.a.b */
public final class C35352b extends C22456n<col, C15327com> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    /* renamed from: com.tencent.mm.plugin.voip.model.a.b$1 */
    class C294891 implements C1202f {
        C294891() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4698);
            C46317a.Logi(C35352b.this.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + C35352b.this.sPK.mStatus);
            if (C35352b.this.sPK.mStatus == 1) {
                C46317a.Logi(C35352b.this.TAG, "reject ok!");
                AppMethodBeat.m2505o(4698);
            } else if (C35352b.this.sPK.mStatus != 4) {
                C46317a.Loge(C35352b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
                AppMethodBeat.m2505o(4698);
            } else if (i == 0) {
                C15327com c15327com = (C15327com) C35352b.this.cKx();
                C35352b.this.sPK.sPp.nwu = c15327com.wem;
                C35352b.this.sPK.sPp.nwv = c15327com.wen;
                C35352b.this.sPK.sPp.nwC = c15327com.xlS;
                C35352b.this.sPK.sPp.sUE = c15327com.xmf;
                C35352b.this.sPK.sPp.sUF = c15327com.xmg;
                C35352b.this.sPK.sPp.sUG = c15327com.xmh;
                C35352b.this.sPK.sPp.sUH = c15327com.xmi;
                C35352b.this.sPK.sPp.sUJ = c15327com.xmk;
                C35352b.this.sPK.sPp.sUI = c15327com.xmp;
                C35352b.this.sPK.sPp.sUi = c15327com.xlW;
                C35352b.this.sPK.sPp.sUL = c15327com.xmr;
                C35352b.this.sPK.mo26296Gn(c15327com.xlU);
                C35352b.this.sPK.sPp.sUk = c15327com.xlX;
                if (c15327com.xlY.getILen() >= 12) {
                    ByteBuffer wrap = ByteBuffer.wrap(c15327com.xlY.getBuffer().toByteArray(), 8, 4);
                    ByteOrder nativeOrder = ByteOrder.nativeOrder();
                    ByteOrder order = wrap.order();
                    int i3 = wrap.getInt();
                    C46317a.Logd(C35352b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                    C35352b.this.sPK.sPp.sUK = i3;
                }
                C46317a.Logi(C35352b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + C35352b.this.sPK.sPp.sUE + ",audioTsdEdge = " + C35352b.this.sPK.sPp.sUF + ",passthroughQosAlgorithm = " + C35352b.this.sPK.sPp.sUG + ",fastPlayRepair = " + C35352b.this.sPK.sPp.sUH + ", audioDtx = " + C35352b.this.sPK.sPp.sUJ + ", switchtcppktCnt=" + C35352b.this.sPK.sPp.sUh + ", SvrCfgListV=" + C35352b.this.sPK.sPp.sUI + ", setMaxBRForRelay=" + C35352b.this.sPK.sPp.sUL + ", RedirectreqThreshold=" + c15327com.xlT.xnx + ", BothSideSwitchFlag=" + c15327com.xlT.xny + ", WifiScanInterval=" + c15327com.xlX + ", BaseBRTuneRatio=" + C35352b.this.sPK.sPp.sUK);
                C35352b.this.sPK.sPp.sUM = c15327com.xmo;
                C35352b.this.sPK.sPp.sUN = c15327com.xms;
                C46317a.Logi(C35352b.this.TAG, "answerResp AudioAecMode5 = " + C35352b.this.sPK.sPp.sUM);
                boolean cKN = v2protocal.cKN();
                C32427a c32427a = C32427a.xtM;
                boolean dmB = C32427a.dmB();
                boolean z = C43727b.cIl() == 0;
                int i4 = C1427q.etc.erz;
                int i5 = (C35352b.this.sPK.sPp.sUi >> 4) & 7;
                int i6 = 0;
                if (cKN && i4 != 0 && dmB && z) {
                    if (i4 > 0) {
                        i6 = i4;
                    } else if (i5 >= 0) {
                        i6 = i5;
                    }
                }
                C46317a.Logi(C35352b.this.TAG, "NetSceneAnswerResp set voipbeauty local=" + cKN + ", server=" + i5 + ", blacklist=" + i4 + ", isLibReady=" + dmB + ",isLibInitOK=" + z + ", UICallback" + C35352b.this.sPK.sPq + ", finalFlag=" + i6);
                if (C35352b.this.sPK.sPq != null) {
                    C35352b.this.sPK.sPq.setVoipBeauty(i6);
                }
                C35352b.this.sPK.sPp.sVl = i6;
                C35352b.this.sPK.sPp.sVm = i5;
                C35352b.this.sPK.sOP = true;
                C46317a.Logi(C35352b.this.TAG, "answer ok, roomid =" + C35352b.this.sPK.sPp.nwu + ",memberid = " + C35352b.this.sPK.sPp.nwC);
                final cpr cpr = c15327com.xlT;
                if (cpr.nwQ > 0) {
                    cpr.nwQ--;
                    C46317a.Logi(C35352b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + cpr.nwQ + "] from answerresp relaydata");
                } else {
                    cpr.nwQ = 1;
                    C46317a.Logi(C35352b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                }
                C46317a.Logi(C35352b.this.TAG, "answer with relayData peerid.length =" + cpr.xlM.vJd.getILen());
                C46317a.Logi(C35352b.this.TAG, "answer with relayData capinfo.length =" + cpr.xlN.vJd.getILen());
                C35352b.this.sPK.mo26295Gm(cpr.xnc);
                C35352b.this.sPK.sPB.mo69415a(cpr.xnC, cpr.xnB, C35352b.this.sPK.sPp.nwu, C35352b.this.sPK.sPp.nwv);
                try {
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(4697);
                            C43727b.cIj().cKd();
                            C46317a.Logi(C35352b.this.TAG, "steve:doublelink timer started!");
                            C35352b.this.sPK.mo26298a(cpr.xnd, cpr.xne, cpr.xnl, cpr.xnE);
                            if (cpr.xlM.vJd.getBuffer() != null) {
                                C35352b.this.sPK.mo26303bo(cpr.xlM.vJd.getBuffer().toByteArray());
                            } else {
                                C4990ab.m7412e(C35352b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                            }
                            if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                                C35352b.this.sPK.mo26299a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, cpr.nwQ, cpr.xnv.getBuffer().toByteArray());
                            }
                            C35352b.this.sPK.mo26323i(cpr.xnm, cpr.xnn, cpr.xno, cpr.xnp, cpr.xnq);
                            C35352b.this.sPK.mo26294Gl(cpr.xnu);
                            if (!(cpr.xns == null || cpr.xnt == null || cpr.xns.getBuffer() == null || cpr.xnt.getBuffer() == null)) {
                                C35352b.this.sPK.mo26302b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                            }
                            if (cpr.xlN.vJd.getBuffer() != null) {
                                C35352b.this.sPK.mo26304bp(cpr.xlN.vJd.getBuffer().toByteArray());
                            } else {
                                C4990ab.m7412e(C35352b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                            }
                            C35352b.this.sPK.mo26293Gk(cpr.xnx);
                            C35352b.this.sPK.sPp.sVb = cpr.xny;
                            if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                                C35352b.this.sPK.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                            }
                            if (C35352b.this.sPK.sOR) {
                                C35352b.this.sPK.sOR = false;
                                if (C35352b.this.sPK.sON) {
                                    C46317a.Logi(C35352b.this.TAG, "channel pre-connect already success, start talk");
                                    C35352b.this.sPK.cIO();
                                } else if (C35352b.this.sPK.sOQ) {
                                    C46317a.Logi(C35352b.this.TAG, "channel pre-connect already failed");
                                    C35352b.this.sPK.mo26330v(1, -9000, "");
                                    AppMethodBeat.m2505o(4697);
                                    return;
                                } else {
                                    C46317a.Logi(C35352b.this.TAG, "channel pre-connect still connecting...");
                                }
                            } else {
                                C4990ab.m7416i(C35352b.this.TAG, "isPreConnect is false");
                            }
                            C35352b.this.sPK.cIV();
                            C35352b.this.sPK.cIT();
                            AppMethodBeat.m2505o(4697);
                        }
                    });
                    AppMethodBeat.m2505o(4698);
                } catch (Exception e) {
                    C4990ab.m7412e(C35352b.this.TAG, "get proxy ip fail..");
                    AppMethodBeat.m2505o(4698);
                }
            } else if (i == 4) {
                C35352b.this.sPK.sPp.sVH.sQe = 12;
                C35352b.this.sPK.sPp.sVH.sQf = i2;
                C35352b.this.sPK.mo26330v(1, i2, "");
                AppMethodBeat.m2505o(4698);
            } else {
                C35352b.this.sPK.sPp.sVH.sQe = 12;
                C35352b.this.sPK.sPp.sVH.sQf = i2;
                C35352b.this.sPK.mo26330v(1, -9004, "");
                AppMethodBeat.m2505o(4698);
            }
        }
    }

    public C35352b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(4699);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new col();
        c1196a.fsK = new C15327com();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipanswer";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_2;
        c1196a.fsL = 65;
        c1196a.fsM = 1000000065;
        this.ehh = c1196a.acD();
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
        int bOK = ((C12534a) C1720g.m3528K(C12534a.class)).bOK();
        C4990ab.m7417i(this.TAG, "simType: %s", Integer.valueOf(bOK));
        bOK = bOK == 0 ? 0 : bOK == 1 ? 1 : 2;
        col.xlR = bOK;
        AppMethodBeat.m2505o(4699);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_2;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4700);
        C294891 c294891 = new C294891();
        AppMethodBeat.m2505o(4700);
        return c294891;
    }
}
