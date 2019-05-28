package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C40570sn;
import com.tencent.p177mm.protocal.protobuf.C40571so;
import com.tencent.p177mm.protocal.protobuf.C44168sm;
import com.tencent.p177mm.protocal.protobuf.bxk;
import com.tencent.p177mm.protocal.protobuf.byj;
import com.tencent.p177mm.protocal.protobuf.cwc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.aj.q */
public final class C41744q extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C41744q(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private C41744q(String str, String str2, byte b) {
        this(str, 1, str2, null, 0, null, null);
    }

    public C41744q(String str, int i, String str2, LinkedList<C44168sm> linkedList, int i2, bxk bxk, byj byj) {
        AppMethodBeat.m2504i(11435);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40570sn();
        c1196a.fsK = new C40571so();
        c1196a.uri = "/cgi-bin/micromsg-bin/clickcommand";
        c1196a.fsI = 359;
        c1196a.fsL = ErrorCode.NEEDDOWNLOAD_FALSE_6;
        c1196a.fsM = 1000000176;
        this.ehh = c1196a.acD();
        C40570sn c40570sn = (C40570sn) this.ehh.fsG.fsP;
        c40570sn.vZW = i;
        c40570sn.vZX = str2;
        c40570sn.vMR = str;
        c40570sn.vEG = C1831bh.aae();
        c40570sn.scene = i2;
        c40570sn.vZZ = C30309s.getSessionId();
        if (linkedList != null) {
            c40570sn.vZY = linkedList;
        }
        if (bxk != null) {
            c40570sn.waa = bxk;
            C4990ab.m7411d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", Integer.valueOf(bxk.wXr), Integer.valueOf(bxk.wXt), Integer.valueOf(bxk.wXs), Integer.valueOf(bxk.wXv), Integer.valueOf(bxk.wXu), Integer.valueOf(bxk.wXw), Integer.valueOf(bxk.wXx));
        }
        if (byj != null) {
            c40570sn.wab = byj;
            C4990ab.m7411d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", Integer.valueOf(byj.Scene), Integer.valueOf(byj.wXG));
        }
        C4990ab.m7417i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", str, Integer.valueOf(i), str2, c40570sn.vEG, Integer.valueOf(c40570sn.vZY.size()), Integer.valueOf(i2));
        AppMethodBeat.m2505o(11435);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11436);
        if (i2 == 0 && i3 == 0) {
            C40570sn c40570sn = (C40570sn) this.ehh.fsG.fsP;
            C40571so c40571so = (C40571so) this.ehh.fsH.fsP;
            if (!(c40570sn.vZW != 10 || c40570sn.vMR == null || c40571so.wac == null || ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c40570sn.vMR) == null)) {
                cwc cwc = c40571so.wac;
                String str2 = c40570sn.vMR;
                if (cwc == null || C5046bo.isNullOrNil(cwc.xrZ) || C5046bo.isNullOrNil(cwc.xrY)) {
                    C4990ab.m7420w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
                } else if (cwc.xrX != 1) {
                    C4990ab.m7421w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", Integer.valueOf(cwc.xrX));
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
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo14794ju(str2);
                    c7620bi.mo14781hO(2);
                    c7620bi.setType(10002);
                    c7620bi.mo14775eJ(C1829bf.aaa());
                    c7620bi.setContent(stringBuffer.toString());
                    C1829bf.m3752l(c7620bi);
                }
            }
            if (c40571so.wac != null) {
                C4990ab.m7411d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", Integer.valueOf(c40570sn.vZW));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(11436);
    }

    public final int getType() {
        return 359;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11437);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11437);
        return a;
    }
}
