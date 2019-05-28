package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ab extends x {
    private static final String[] vcr = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ab(List<String> list) {
        int i = 0;
        AppMethodBeat.i(79372);
        a aVar = new a();
        aVar.fsJ = new aef();
        aVar.fsK = new aeg();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        this.lty = aVar.acD();
        aef aef = (aef) this.lty.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!bo.isNullOrNil(str)) {
                    linkedList.add(aa.vy(str));
                }
                i++;
            }
        }
        aef.wmi = linkedList;
        aef.jBv = linkedList.size();
        AppMethodBeat.o(79372);
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79373);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((aeg) this.lty.fsH.fsP).wmj;
            if (!(linkedList == null || linkedList.isEmpty())) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    jx jxVar = (jx) it.next();
                    if (jxVar != null) {
                        a(g.bT(jxVar.fKh, false), jxVar);
                    }
                }
            }
            AppMethodBeat.o(79373);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(79373);
    }

    private static void a(f fVar, jx jxVar) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(79374);
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = jxVar.fKh;
            i = 1;
        } else {
            i = 0;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", jxVar.fKh, Integer.valueOf(jxVar.mZx), Long.valueOf(jxVar.vML));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag));
        if (!fVar.dhx() || bo.isNullOrNil(fVar.field_appName)) {
            fVar.field_appName = jxVar.Name;
        }
        if (!fVar.dhx() || bo.isNullOrNil(fVar.field_appName_en)) {
            fVar.field_appName_en = jxVar.vMv;
        }
        if (!fVar.dhx() || bo.isNullOrNil(fVar.field_appName_tw)) {
            fVar.field_appName_tw = jxVar.vMx;
        }
        fVar.field_appDiscription = jxVar.vEA;
        fVar.field_appDiscription_en = jxVar.vMw;
        fVar.field_appDiscription_tw = jxVar.vMy;
        fVar.field_appWatermarkUrl = jxVar.vMC;
        fVar.field_packageName = jxVar.vDo;
        fVar.field_signature = p.aiO(jxVar.vMD);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", jxVar.vMD, fVar.field_signature);
        fVar.field_appType = jxVar.vME;
        if (!bo.isNullOrNil(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = jxVar.mZx;
        fVar.field_appVersion = jxVar.vMG;
        fVar.ig(jxVar.vMF);
        fVar.field_appWatermarkUrl = jxVar.vMC;
        if (!(bo.isNullOrNil(jxVar.vMJ) || bo.isNullOrNil(jxVar.vMK))) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", fVar.field_appName, jxVar.vMJ, jxVar.vMK);
            fVar.ih(jxVar.vMJ);
            fVar.ik(jxVar.vMK);
        }
        fVar.il(jxVar.vDp);
        fVar.field_svrAppSupportContentType = jxVar.vML;
        if (jxVar.vMH > fVar.dnb) {
            fVar.dnc = 1;
            fVar.dmv = true;
        }
        fVar.dnb = jxVar.vMH;
        fVar.dmv = true;
        String str = jxVar.vDo;
        String str2 = jxVar.vDo;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + jxVar.vDo + "appid: " + fVar.field_appId);
        }
        if (fVar.xy()) {
            b.ajV(fVar.field_appId);
        }
        i bYJ = com.tencent.mm.plugin.s.a.bYJ();
        if (i != 0) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = jxVar.vMA;
            if (fVar.field_appId != null) {
                while (i3 < vcr.length) {
                    if (fVar.field_appId.equals(vcr[i3])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i3++;
                }
            }
            if (bYJ.n(fVar)) {
                com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 1);
                com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 2);
                com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 3);
                com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 4);
                com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 5);
                AppMethodBeat.o(79374);
                return;
            }
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            AppMethodBeat.o(79374);
            return;
        }
        boolean a;
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : vcr) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        i = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? 1 : (jxVar == null || jxVar.vMI == null || jxVar.vMI.length() == 0) ? 0 : !fVar.field_appIconUrl.equals(jxVar.vMA) ? 1 : 0;
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", fVar.field_appIconUrl, jxVar.vMA);
            fVar.field_appIconUrl = jxVar.vMA;
            a = bYJ.a(fVar, new String[0]);
            com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 1);
            com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 2);
            com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 3);
            com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 4);
            com.tencent.mm.plugin.s.a.bYH().dW(fVar.field_appId, 5);
        } else {
            a = bYJ.a(fVar, new String[0]);
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + a + ", appid = " + jxVar.fKh);
        AppMethodBeat.o(79374);
    }

    public final byte[] dhj() {
        AppMethodBeat.i(79375);
        try {
            byte[] ZT = ((com.tencent.mm.ai.b.b) this.lty.acF()).ZT();
            AppMethodBeat.o(79375);
            return ZT;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            AppMethodBeat.o(79375);
            return null;
        }
    }

    public final void bG(byte[] bArr) {
        AppMethodBeat.i(79376);
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            AppMethodBeat.o(79376);
            return;
        }
        try {
            this.lty.fsH.P(bArr);
            AppMethodBeat.o(79376);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
            AppMethodBeat.o(79376);
        }
    }
}
