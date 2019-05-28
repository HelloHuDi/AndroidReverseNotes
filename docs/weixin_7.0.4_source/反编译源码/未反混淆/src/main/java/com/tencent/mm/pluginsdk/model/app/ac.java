package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac extends x {
    List<String> vcs;

    public ac(List<String> list) {
        AppMethodBeat.i(79377);
        a aVar = new a();
        aVar.fsJ = new aej();
        aVar.fsK = new aek();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        aVar.fsI = b.CTRL_INDEX;
        this.lty = aVar.acD();
        this.vcs = list;
        ab.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                fa faVar = new fa();
                faVar.mZr = str;
                linkedList.add(faVar);
            }
        }
        if (linkedList.size() == 0) {
            ab.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        aej aej = (aej) this.lty.fsG.fsP;
        aej.wmn = linkedList;
        aej.wmm = linkedList.size();
        AppMethodBeat.o(79377);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79378);
        ab.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aek aek = (aek) this.lty.fsH.fsP;
            ab.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + aek.wmm);
            LinkedList linkedList = aek.wmo;
            if (linkedList == null || linkedList.size() == 0) {
                ab.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                AppMethodBeat.o(79378);
                return;
            }
            i bYJ = com.tencent.mm.plugin.s.a.bYJ();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ez ezVar = (ez) it.next();
                f bT = g.bT(ezVar.mZr, false);
                if (bT != null) {
                    bT.field_authFlag = ezVar.vGY;
                    bT.field_openId = ezVar.nbm;
                    ab.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bYJ.a(bT, new String[0]) + ", appId = " + ezVar.mZr);
                }
            }
            AppMethodBeat.o(79378);
            return;
        }
        ab.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(79378);
    }

    public final byte[] dhj() {
        AppMethodBeat.i(79379);
        try {
            byte[] ZT = ((b) this.lty.acF()).ZT();
            AppMethodBeat.o(79379);
            return ZT;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            AppMethodBeat.o(79379);
            return null;
        }
    }

    public final void bG(byte[] bArr) {
        AppMethodBeat.i(79380);
        if (bArr == null) {
            ab.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            AppMethodBeat.o(79380);
            return;
        }
        try {
            this.lty.fsH.P(bArr);
            AppMethodBeat.o(79380);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            AppMethodBeat.o(79380);
        }
    }

    public final int getType() {
        return 1;
    }
}
