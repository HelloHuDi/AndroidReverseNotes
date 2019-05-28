package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<cpp, cpq> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        AppMethodBeat.i(4717);
        a aVar = new a();
        aVar.fsJ = new cpp();
        aVar.fsK = new cpq();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_TRUE;
        this.ehh = aVar.acD();
        cpp cpp = (cpp) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= list.size()) {
                break;
            }
            linkedList.add(new bts().alV((String) list.get(i5)));
            i4 = i5 + 1;
        }
        cpp.wPm = r.Yz();
        cpp.xmX = linkedList;
        cpp.xmW = linkedList.size();
        cpp.vZF = i;
        cpp.xcr = 0;
        cpp.xmL = i2;
        cpp.wOQ = i3;
        cpx cpx = new cpx();
        cpx.jCt = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        cpx.vJd = sKBuiltinBuffer_t;
        cpp.xlM = cpx;
        cpx = new cpx();
        cpx.jCt = 3;
        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr2);
        cpx.vJd = sKBuiltinBuffer_t;
        cpp.xlN = cpx;
        cpp.xlQ = System.currentTimeMillis();
        i4 = ((com.tencent.mm.plugin.misc.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.misc.a.a.class)).bOK();
        ab.i("MicroMsg.NetSceneVoipInvite", "simType: %s", Integer.valueOf(i4));
        i4 = i4 == 0 ? 0 : i4 == 1 ? 1 : 2;
        cpp.xlR = i4;
        AppMethodBeat.o(4717);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_TRUE;
    }

    public final f cKt() {
        AppMethodBeat.i(4718);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4716);
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + g.this.sPK.mStatus);
                if (g.this.sPK.mStatus != 2) {
                    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.sPK.mStatus + " should:2");
                    AppMethodBeat.o(4716);
                    return;
                }
                int i3;
                cpq cpq = (cpq) g.this.cKx();
                g.this.sPK.sPp.sUE = cpq.xmf;
                g.this.sPK.sPp.sUF = cpq.xmg;
                g.this.sPK.sPp.sUG = cpq.xmh;
                g.this.sPK.sPp.sUH = cpq.xmi;
                g.this.sPK.sPp.sUJ = cpq.xmk;
                g.this.sPK.sPp.sUI = cpq.xmp;
                g.this.sPK.sPp.sVk = cpq.xna;
                g.this.sPK.sPp.sUi = cpq.xlW;
                g.this.sPK.sPp.sUL = cpq.xmr;
                g.this.sPK.Gn(cpq.xlU);
                g.this.sPK.sPp.sUk = cpq.xlX;
                if (cpq.xlY != null && cpq.xlY.getILen() >= 12) {
                    ByteBuffer wrap = ByteBuffer.wrap(cpq.xlY.getBuffer().toByteArray(), 8, 4);
                    ByteOrder nativeOrder = ByteOrder.nativeOrder();
                    ByteOrder order = wrap.order();
                    i3 = wrap.getInt();
                    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                    g.this.sPK.sPp.sUK = i3;
                }
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.sPK.sPp.sUE + ",audioTsdEdge = " + g.this.sPK.sPp.sUF + ",passthroughQosAlgorithm = " + g.this.sPK.sPp.sUG + ",fastPlayRepair = " + g.this.sPK.sPp.sUH + ", audioDtx = " + g.this.sPK.sPp.sUJ + ",switchtcpPktCnt = " + g.this.sPK.sPp.sUh + ",SvrCfgListV = " + g.this.sPK.sPp.sUI + ", setMaxBRForRelay=" + g.this.sPK.sPp.sUL + ",EnableDataAccept = " + g.this.sPK.sPp.sVk + ",WifiScanInterval = " + g.this.sPK.sPp.sUk + ",BaseBRTuneRatio=" + g.this.sPK.sPp.sUK);
                g.this.sPK.sPp.sUM = cpq.xmo;
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.sPK.sPp.sUM);
                g.this.sPK.sPp.sUN = cpq.xms;
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.sPK.sPp.sUN);
                i3 = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
                if (i == 0) {
                    g.this.sPK.setStatus(4);
                    g.this.sPK.sPp.nwu = cpq.wem;
                    g.this.sPK.sPp.nwv = cpq.wen;
                    g.this.sPK.sPp.nwC = cpq.wPb;
                    h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(1), Integer.valueOf(i3));
                    if (cpq.xmZ > 0) {
                        long j = (long) (cpq.xmZ * 1000);
                        g.this.sPK.sPD.ae(j, j);
                    }
                    b.cIj().cKd();
                    boolean cKN = v2protocal.cKN();
                    com.tencent.mm.bu.a aVar = com.tencent.mm.bu.a.xtM;
                    boolean dmB = com.tencent.mm.bu.a.dmB();
                    boolean z = b.cIl() == 0;
                    int i4 = q.etc.erz;
                    int i5 = (g.this.sPK.sPp.sUi >> 4) & 7;
                    int i6 = 0;
                    if (cKN && i4 != 0 && dmB && z) {
                        if (i4 > 0) {
                            i6 = i4;
                        } else if (i5 >= 0) {
                            i6 = i5;
                        }
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "NetSceneInviteResp set voipbeauty local=" + cKN + ", server=" + i5 + ", blacklist=" + i4 + ", isLibReady=" + dmB + ",isLibInitOK=" + z + ", UICallback" + g.this.sPK.sPq + ", finalFlag=" + i6);
                    if (g.this.sPK.sPq != null) {
                        g.this.sPK.sPq.setVoipBeauty(i6);
                    }
                    g.this.sPK.sPp.sVl = i6;
                    g.this.sPK.sPp.sVm = i5;
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.sPK.sPp.nwu + ",memberid = " + g.this.sPK.sPp.nwC + "VoipSyncInterval = " + cpq.xmZ);
                    g.this.sPK.sPq.cJy();
                    com.tencent.mm.plugin.voip.a.a.c(b.cIj().cJZ(), b.cIj().cKa(), 0, 1);
                    AppMethodBeat.o(4716);
                } else if (i == 4) {
                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + cpq.wem + "," + cpq.wen);
                    switch (i2) {
                        case 211:
                            g.this.sPK.sPp.sVH.sQe = 12;
                            g.this.sPK.sPp.sVH.sQq = 12;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(8), Integer.valueOf(i3));
                            break;
                        case d.MIC_PTU_MEISHI /*233*/:
                            g.this.sPK.sPp.sVH.sQe = 12;
                            g.this.sPK.sPp.sVH.sQq = 1;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(3), Integer.valueOf(i3));
                            break;
                        case d.MIC_PTU_FENGJING /*234*/:
                            g.this.sPK.sPp.sVH.sQe = 13;
                            g.this.sPK.sPp.sVH.sQq = 11;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(4), Integer.valueOf(i3));
                            break;
                        case d.MIC_PTU_AUTOLEVEL /*235*/:
                            g.this.sPK.sPp.sVH.sQe = 13;
                            g.this.sPK.sPp.sVH.sQq = 2;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(2), Integer.valueOf(i3));
                            break;
                        case 236:
                            g.this.sPK.sPp.sVH.sQe = 12;
                            g.this.sPK.sPp.sVH.sQq = 10;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(7), Integer.valueOf(i3));
                            break;
                        case d.MIC_PTU_LENGMEIREN /*237*/:
                            g.this.sPK.sPp.sVH.sQe = 13;
                            g.this.sPK.sPp.sVH.sQq = 9;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(2), Integer.valueOf(i3));
                            break;
                        case d.MIC_PTU_SHIGUANG /*238*/:
                            g.this.sPK.sOP = true;
                            g.this.sPK.sOR = false;
                            g.this.sPK.sOQ = false;
                            g.this.sPK.sPp.sUD = 0;
                            g.this.sPK.sPp.sUC = 0;
                            g.this.sPK.setStatus(3);
                            g.this.sPK.sPp.nwu = cpq.wem;
                            g.this.sPK.sPp.nwv = cpq.wen;
                            g.this.sPK.sPp.nwC = cpq.wPb;
                            g.this.sPK.sPq.Gu(((cpp) ((g) mVar).cKy()).xcr);
                            AppMethodBeat.o(4716);
                            return;
                        case d.MIC_PTU_QINGCONG /*241*/:
                            ab.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + cpq.xnb + " seconds!");
                            b.cIj().sSW = System.currentTimeMillis();
                            if (cpq.xnb == 0) {
                                b.cIj().sSX = 30000;
                                break;
                            } else {
                                b.cIj().sSX = (long) (cpq.xnb * 1000);
                                break;
                            }
                        default:
                            g.this.sPK.sPp.sVH.sQe = 12;
                            g.this.sPK.sPp.sVH.sQq = 99;
                            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(5), Integer.valueOf(i3));
                            break;
                    }
                    g.this.sPK.sPp.sVH.sQf = i2;
                    g.this.sPK.v(1, i2, str);
                    AppMethodBeat.o(4716);
                } else {
                    g.this.sPK.sPp.sVH.sQe = 12;
                    g.this.sPK.sPp.sVH.sQf = i2;
                    g.this.sPK.sPp.sVH.sQq = 99;
                    h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(9), Integer.valueOf(i3));
                    g.this.sPK.v(1, -9004, "");
                    AppMethodBeat.o(4716);
                }
            }
        };
        AppMethodBeat.o(4718);
        return anonymousClass1;
    }
}
