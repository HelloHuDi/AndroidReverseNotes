package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p206bu.C32427a;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cpp;
import com.tencent.p177mm.protocal.protobuf.cpq;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.voip.model.a.g */
public final class C24844g extends C22456n<cpp, cpq> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.g$1 */
    class C140421 implements C1202f {
        C140421() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4716);
            C46317a.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + C24844g.this.sPK.mStatus);
            if (C24844g.this.sPK.mStatus != 2) {
                C46317a.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + C24844g.this.sPK.mStatus + " should:2");
                AppMethodBeat.m2505o(4716);
                return;
            }
            int i3;
            cpq cpq = (cpq) C24844g.this.cKx();
            C24844g.this.sPK.sPp.sUE = cpq.xmf;
            C24844g.this.sPK.sPp.sUF = cpq.xmg;
            C24844g.this.sPK.sPp.sUG = cpq.xmh;
            C24844g.this.sPK.sPp.sUH = cpq.xmi;
            C24844g.this.sPK.sPp.sUJ = cpq.xmk;
            C24844g.this.sPK.sPp.sUI = cpq.xmp;
            C24844g.this.sPK.sPp.sVk = cpq.xna;
            C24844g.this.sPK.sPp.sUi = cpq.xlW;
            C24844g.this.sPK.sPp.sUL = cpq.xmr;
            C24844g.this.sPK.mo26296Gn(cpq.xlU);
            C24844g.this.sPK.sPp.sUk = cpq.xlX;
            if (cpq.xlY != null && cpq.xlY.getILen() >= 12) {
                ByteBuffer wrap = ByteBuffer.wrap(cpq.xlY.getBuffer().toByteArray(), 8, 4);
                ByteOrder nativeOrder = ByteOrder.nativeOrder();
                ByteOrder order = wrap.order();
                i3 = wrap.getInt();
                C46317a.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                C24844g.this.sPK.sPp.sUK = i3;
            }
            C46317a.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + C24844g.this.sPK.sPp.sUE + ",audioTsdEdge = " + C24844g.this.sPK.sPp.sUF + ",passthroughQosAlgorithm = " + C24844g.this.sPK.sPp.sUG + ",fastPlayRepair = " + C24844g.this.sPK.sPp.sUH + ", audioDtx = " + C24844g.this.sPK.sPp.sUJ + ",switchtcpPktCnt = " + C24844g.this.sPK.sPp.sUh + ",SvrCfgListV = " + C24844g.this.sPK.sPp.sUI + ", setMaxBRForRelay=" + C24844g.this.sPK.sPp.sUL + ",EnableDataAccept = " + C24844g.this.sPK.sPp.sVk + ",WifiScanInterval = " + C24844g.this.sPK.sPp.sUk + ",BaseBRTuneRatio=" + C24844g.this.sPK.sPp.sUK);
            C24844g.this.sPK.sPp.sUM = cpq.xmo;
            C46317a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + C24844g.this.sPK.sPp.sUM);
            C24844g.this.sPK.sPp.sUN = cpq.xms;
            C46317a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + C24844g.this.sPK.sPp.sUN);
            i3 = C46317a.getNetType(C4996ah.getContext());
            if (i == 0) {
                C24844g.this.sPK.setStatus(4);
                C24844g.this.sPK.sPp.nwu = cpq.wem;
                C24844g.this.sPK.sPp.nwv = cpq.wen;
                C24844g.this.sPK.sPp.nwC = cpq.wPb;
                C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(1), Integer.valueOf(i3));
                if (cpq.xmZ > 0) {
                    long j = (long) (cpq.xmZ * 1000);
                    C24844g.this.sPK.sPD.mo16770ae(j, j);
                }
                C43727b.cIj().cKd();
                boolean cKN = v2protocal.cKN();
                C32427a c32427a = C32427a.xtM;
                boolean dmB = C32427a.dmB();
                boolean z = C43727b.cIl() == 0;
                int i4 = C1427q.etc.erz;
                int i5 = (C24844g.this.sPK.sPp.sUi >> 4) & 7;
                int i6 = 0;
                if (cKN && i4 != 0 && dmB && z) {
                    if (i4 > 0) {
                        i6 = i4;
                    } else if (i5 >= 0) {
                        i6 = i5;
                    }
                }
                C46317a.Logi("MicroMsg.NetSceneVoipInvite", "NetSceneInviteResp set voipbeauty local=" + cKN + ", server=" + i5 + ", blacklist=" + i4 + ", isLibReady=" + dmB + ",isLibInitOK=" + z + ", UICallback" + C24844g.this.sPK.sPq + ", finalFlag=" + i6);
                if (C24844g.this.sPK.sPq != null) {
                    C24844g.this.sPK.sPq.setVoipBeauty(i6);
                }
                C24844g.this.sPK.sPp.sVl = i6;
                C24844g.this.sPK.sPp.sVm = i5;
                C46317a.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + C24844g.this.sPK.sPp.nwu + ",memberid = " + C24844g.this.sPK.sPp.nwC + "VoipSyncInterval = " + cpq.xmZ);
                C24844g.this.sPK.sPq.cJy();
                C46317a.m86991c(C43727b.cIj().cJZ(), C43727b.cIj().cKa(), 0, 1);
                AppMethodBeat.m2505o(4716);
            } else if (i == 4) {
                C46317a.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + cpq.wem + "," + cpq.wen);
                switch (i2) {
                    case 211:
                        C24844g.this.sPK.sPp.sVH.sQe = 12;
                        C24844g.this.sPK.sPp.sVH.sQq = 12;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(8), Integer.valueOf(i3));
                        break;
                    case C31128d.MIC_PTU_MEISHI /*233*/:
                        C24844g.this.sPK.sPp.sVH.sQe = 12;
                        C24844g.this.sPK.sPp.sVH.sQq = 1;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(3), Integer.valueOf(i3));
                        break;
                    case C31128d.MIC_PTU_FENGJING /*234*/:
                        C24844g.this.sPK.sPp.sVH.sQe = 13;
                        C24844g.this.sPK.sPp.sVH.sQq = 11;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(4), Integer.valueOf(i3));
                        break;
                    case C31128d.MIC_PTU_AUTOLEVEL /*235*/:
                        C24844g.this.sPK.sPp.sVH.sQe = 13;
                        C24844g.this.sPK.sPp.sVH.sQq = 2;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(2), Integer.valueOf(i3));
                        break;
                    case 236:
                        C24844g.this.sPK.sPp.sVH.sQe = 12;
                        C24844g.this.sPK.sPp.sVH.sQq = 10;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(7), Integer.valueOf(i3));
                        break;
                    case C31128d.MIC_PTU_LENGMEIREN /*237*/:
                        C24844g.this.sPK.sPp.sVH.sQe = 13;
                        C24844g.this.sPK.sPp.sVH.sQq = 9;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(2), Integer.valueOf(i3));
                        break;
                    case C31128d.MIC_PTU_SHIGUANG /*238*/:
                        C24844g.this.sPK.sOP = true;
                        C24844g.this.sPK.sOR = false;
                        C24844g.this.sPK.sOQ = false;
                        C24844g.this.sPK.sPp.sUD = 0;
                        C24844g.this.sPK.sPp.sUC = 0;
                        C24844g.this.sPK.setStatus(3);
                        C24844g.this.sPK.sPp.nwu = cpq.wem;
                        C24844g.this.sPK.sPp.nwv = cpq.wen;
                        C24844g.this.sPK.sPp.nwC = cpq.wPb;
                        C24844g.this.sPK.sPq.mo30877Gu(((cpp) ((C24844g) c1207m).cKy()).xcr);
                        AppMethodBeat.m2505o(4716);
                        return;
                    case C31128d.MIC_PTU_QINGCONG /*241*/:
                        C4990ab.m7416i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + cpq.xnb + " seconds!");
                        C43727b.cIj().sSW = System.currentTimeMillis();
                        if (cpq.xnb == 0) {
                            C43727b.cIj().sSX = 30000;
                            break;
                        } else {
                            C43727b.cIj().sSX = (long) (cpq.xnb * 1000);
                            break;
                        }
                    default:
                        C24844g.this.sPK.sPp.sVH.sQe = 12;
                        C24844g.this.sPK.sPp.sVH.sQq = 99;
                        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(5), Integer.valueOf(i3));
                        break;
                }
                C24844g.this.sPK.sPp.sVH.sQf = i2;
                C24844g.this.sPK.mo26330v(1, i2, str);
                AppMethodBeat.m2505o(4716);
            } else {
                C24844g.this.sPK.sPp.sVH.sQe = 12;
                C24844g.this.sPK.sPp.sVH.sQf = i2;
                C24844g.this.sPK.sPp.sVH.sQq = 99;
                C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(9), Integer.valueOf(i3));
                C24844g.this.sPK.mo26330v(1, -9004, "");
                AppMethodBeat.m2505o(4716);
            }
        }
    }

    public C24844g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(4717);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpp();
        c1196a.fsK = new cpq();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipinvite";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_TRUE;
        this.ehh = c1196a.acD();
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
        cpp.wPm = C1853r.m3846Yz();
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
        i4 = ((C12534a) C1720g.m3528K(C12534a.class)).bOK();
        C4990ab.m7417i("MicroMsg.NetSceneVoipInvite", "simType: %s", Integer.valueOf(i4));
        i4 = i4 == 0 ? 0 : i4 == 1 ? 1 : 2;
        cpp.xlR = i4;
        AppMethodBeat.m2505o(4717);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_TRUE;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4718);
        C140421 c140421 = new C140421();
        AppMethodBeat.m2505o(4718);
        return c140421;
    }
}
