package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C45562b;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.protocal.protobuf.C40518ez;
import com.tencent.p177mm.protocal.protobuf.C46540fa;
import com.tencent.p177mm.protocal.protobuf.aej;
import com.tencent.p177mm.protocal.protobuf.aek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ac */
public final class C14871ac extends C40442x {
    List<String> vcs;

    public C14871ac(List<String> list) {
        AppMethodBeat.m2504i(79377);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aej();
        c1196a.fsK = new aek();
        c1196a.uri = "/cgi-bin/micromsg-bin/getappsetting";
        c1196a.fsI = C45562b.CTRL_INDEX;
        this.lty = c1196a.acD();
        this.vcs = list;
        C4990ab.m7410d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                C46540fa c46540fa = new C46540fa();
                c46540fa.mZr = str;
                linkedList.add(c46540fa);
            }
        }
        if (linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        aej aej = (aej) this.lty.fsG.fsP;
        aej.wmn = linkedList;
        aej.wmm = linkedList.size();
        AppMethodBeat.m2505o(79377);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79378);
        C4990ab.m7410d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aek aek = (aek) this.lty.fsH.fsP;
            C4990ab.m7410d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + aek.wmm);
            LinkedList linkedList = aek.wmo;
            if (linkedList == null || linkedList.size() == 0) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                AppMethodBeat.m2505o(79378);
                return;
            }
            C35796i bYJ = C34832a.bYJ();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C40518ez c40518ez = (C40518ez) it.next();
                C40439f bT = C46494g.m87739bT(c40518ez.mZr, false);
                if (bT != null) {
                    bT.field_authFlag = c40518ez.vGY;
                    bT.field_openId = c40518ez.nbm;
                    C4990ab.m7410d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bYJ.mo56566a(bT, new String[0]) + ", appId = " + c40518ez.mZr);
                }
            }
            AppMethodBeat.m2505o(79378);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.m2505o(79378);
    }

    public final byte[] dhj() {
        AppMethodBeat.m2504i(79379);
        try {
            byte[] ZT = ((C6295b) this.lty.acF()).mo5742ZT();
            AppMethodBeat.m2505o(79379);
            return ZT;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            AppMethodBeat.m2505o(79379);
            return null;
        }
    }

    /* renamed from: bG */
    public final void mo9871bG(byte[] bArr) {
        AppMethodBeat.m2504i(79380);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            AppMethodBeat.m2505o(79380);
            return;
        }
        try {
            this.lty.fsH.mo5744P(bArr);
            AppMethodBeat.m2505o(79380);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            AppMethodBeat.m2505o(79380);
        }
    }

    public final int getType() {
        return 1;
    }
}
