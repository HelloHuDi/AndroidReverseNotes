package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

public final class q extends m implements k {
    private b ehh;
    private f ehi;

    public q(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private q(String str, String str2, byte b) {
        this(str, 1, str2, null, 0, null, null);
    }

    public q(String str, int i, String str2, LinkedList<sm> linkedList, int i2, bxk bxk, byj byj) {
        AppMethodBeat.i(11435);
        a aVar = new a();
        aVar.fsJ = new sn();
        aVar.fsK = new so();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        aVar.fsI = 359;
        aVar.fsL = ErrorCode.NEEDDOWNLOAD_FALSE_6;
        aVar.fsM = 1000000176;
        this.ehh = aVar.acD();
        sn snVar = (sn) this.ehh.fsG.fsP;
        snVar.vZW = i;
        snVar.vZX = str2;
        snVar.vMR = str;
        snVar.vEG = bh.aae();
        snVar.scene = i2;
        snVar.vZZ = s.getSessionId();
        if (linkedList != null) {
            snVar.vZY = linkedList;
        }
        if (bxk != null) {
            snVar.waa = bxk;
            ab.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", Integer.valueOf(bxk.wXr), Integer.valueOf(bxk.wXt), Integer.valueOf(bxk.wXs), Integer.valueOf(bxk.wXv), Integer.valueOf(bxk.wXu), Integer.valueOf(bxk.wXw), Integer.valueOf(bxk.wXx));
        }
        if (byj != null) {
            snVar.wab = byj;
            ab.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", Integer.valueOf(byj.Scene), Integer.valueOf(byj.wXG));
        }
        ab.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", str, Integer.valueOf(i), str2, snVar.vEG, Integer.valueOf(snVar.vZY.size()), Integer.valueOf(i2));
        AppMethodBeat.o(11435);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(11436);
        if (i2 == 0 && i3 == 0) {
            sn snVar = (sn) this.ehh.fsG.fsP;
            so soVar = (so) this.ehh.fsH.fsP;
            if (!(snVar.vZW != 10 || snVar.vMR == null || soVar.wac == null || ((j) g.K(j.class)).XR().aoZ(snVar.vMR) == null)) {
                cwc cwc = soVar.wac;
                String str2 = snVar.vMR;
                if (cwc == null || bo.isNullOrNil(cwc.xrZ) || bo.isNullOrNil(cwc.xrY)) {
                    ab.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
                } else if (cwc.xrX != 1) {
                    ab.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", Integer.valueOf(cwc.xrX));
                } else {
                    String str3 = cwc.xrY;
                    String str4 = cwc.xrZ;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("<sysmsg type=\"biz_services_mute\">");
                    stringBuffer.append("<biz_services_mute>");
                    stringBuffer.append("<text><![CDATA[").append(str3).append("]]></text>");
                    stringBuffer.append("<link>");
                    stringBuffer.append("<scene>biz_services_mute</scene>");
                    stringBuffer.append("<text><![CDATA[").append(str4).append("]]></text>");
                    stringBuffer.append("</link>");
                    stringBuffer.append("</biz_services_mute>");
                    stringBuffer.append("</sysmsg>");
                    bi biVar = new bi();
                    biVar.ju(str2);
                    biVar.hO(2);
                    biVar.setType(10002);
                    biVar.eJ(bf.aaa());
                    biVar.setContent(stringBuffer.toString());
                    bf.l(biVar);
                }
            }
            if (soVar.wac != null) {
                ab.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", Integer.valueOf(snVar.vZW));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(11436);
    }

    public final int getType() {
        return 359;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11437);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11437);
        return a;
    }
}
