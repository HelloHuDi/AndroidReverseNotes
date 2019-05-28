package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44095b;
import com.tencent.p177mm.protocal.protobuf.C40536jx;
import com.tencent.p177mm.protocal.protobuf.aef;
import com.tencent.p177mm.protocal.protobuf.aeg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ab */
public final class C4730ab extends C40442x {
    private static final String[] vcr = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public C4730ab(List<String> list) {
        int i = 0;
        AppMethodBeat.m2504i(79372);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aef();
        c1196a.fsK = new aeg();
        c1196a.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        this.lty = c1196a.acD();
        aef aef = (aef) this.lty.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!C5046bo.isNullOrNil(str)) {
                    linkedList.add(C1946aa.m4154vy(str));
                }
                i++;
            }
        }
        aef.wmi = linkedList;
        aef.jBv = linkedList.size();
        AppMethodBeat.m2505o(79372);
    }

    public final int getType() {
        return 7;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79373);
        C4990ab.m7410d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((aeg) this.lty.fsH.fsP).wmj;
            if (!(linkedList == null || linkedList.isEmpty())) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C40536jx c40536jx = (C40536jx) it.next();
                    if (c40536jx != null) {
                        C4730ab.m7077a(C46494g.m87739bT(c40536jx.fKh, false), c40536jx);
                    }
                }
            }
            AppMethodBeat.m2505o(79373);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.m2505o(79373);
    }

    /* renamed from: a */
    private static void m7077a(C40439f c40439f, C40536jx c40536jx) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(79374);
        if (c40439f == null) {
            c40439f = new C40439f();
            c40439f.field_appId = c40536jx.fKh;
            i = 1;
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", c40536jx.fKh, Integer.valueOf(c40536jx.mZx), Long.valueOf(c40536jx.vML));
        C4990ab.m7417i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", c40439f.field_appId, c40439f.field_appName, Integer.valueOf(c40439f.field_status), Integer.valueOf(c40439f.field_appInfoFlag));
        if (!c40439f.dhx() || C5046bo.isNullOrNil(c40439f.field_appName)) {
            c40439f.field_appName = c40536jx.Name;
        }
        if (!c40439f.dhx() || C5046bo.isNullOrNil(c40439f.field_appName_en)) {
            c40439f.field_appName_en = c40536jx.vMv;
        }
        if (!c40439f.dhx() || C5046bo.isNullOrNil(c40439f.field_appName_tw)) {
            c40439f.field_appName_tw = c40536jx.vMx;
        }
        c40439f.field_appDiscription = c40536jx.vEA;
        c40439f.field_appDiscription_en = c40536jx.vMw;
        c40439f.field_appDiscription_tw = c40536jx.vMy;
        c40439f.field_appWatermarkUrl = c40536jx.vMC;
        c40439f.field_packageName = c40536jx.vDo;
        c40439f.field_signature = C35799p.aiO(c40536jx.vMD);
        C4990ab.m7417i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", c40536jx.vMD, c40439f.field_signature);
        c40439f.field_appType = c40536jx.vME;
        if (!C5046bo.isNullOrNil(c40439f.field_appType) && (c40439f.field_appType.startsWith("1") || c40439f.field_appType.startsWith("6"))) {
            c40439f.field_appType = "," + c40439f.field_appType;
        }
        c40439f.field_appInfoFlag = c40536jx.mZx;
        c40439f.field_appVersion = c40536jx.vMG;
        c40439f.mo44075ig(c40536jx.vMF);
        c40439f.field_appWatermarkUrl = c40536jx.vMC;
        if (!(C5046bo.isNullOrNil(c40536jx.vMJ) || C5046bo.isNullOrNil(c40536jx.vMK))) {
            C4990ab.m7417i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", c40439f.field_appName, c40536jx.vMJ, c40536jx.vMK);
            c40439f.mo44076ih(c40536jx.vMJ);
            c40439f.mo44079ik(c40536jx.vMK);
        }
        c40439f.mo44080il(c40536jx.vDp);
        c40439f.field_svrAppSupportContentType = c40536jx.vML;
        if (c40536jx.vMH > c40439f.dnb) {
            c40439f.dnc = 1;
            c40439f.dmv = true;
        }
        c40439f.dnb = c40536jx.vMH;
        c40439f.dmv = true;
        String str = c40536jx.vDo;
        String str2 = c40536jx.vDo;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + c40536jx.vDo + "appid: " + c40439f.field_appId);
        }
        if (c40439f.mo63847xy()) {
            C44095b.ajV(c40439f.field_appId);
        }
        C35796i bYJ = C34832a.bYJ();
        if (i != 0) {
            c40439f.field_status = i2 != 0 ? 3 : 4;
            c40439f.field_modifyTime = System.currentTimeMillis();
            c40439f.field_appIconUrl = c40536jx.vMA;
            if (c40439f.field_appId != null) {
                while (i3 < vcr.length) {
                    if (c40439f.field_appId.equals(vcr[i3])) {
                        c40439f.field_status = -1;
                        break;
                    }
                    i3++;
                }
            }
            if (bYJ.mo56573n(c40439f)) {
                C34832a.bYH().mo48331dW(c40439f.field_appId, 1);
                C34832a.bYH().mo48331dW(c40439f.field_appId, 2);
                C34832a.bYH().mo48331dW(c40439f.field_appId, 3);
                C34832a.bYH().mo48331dW(c40439f.field_appId, 4);
                C34832a.bYH().mo48331dW(c40439f.field_appId, 5);
                AppMethodBeat.m2505o(79374);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            AppMethodBeat.m2505o(79374);
            return;
        }
        boolean a;
        c40439f.field_status = i2 != 0 ? 3 : c40439f.field_status;
        if (c40439f.field_appId != null) {
            for (Object equals : vcr) {
                if (c40439f.field_appId.equals(equals)) {
                    c40439f.field_status = -1;
                    break;
                }
            }
        }
        i = (c40439f == null || c40439f.field_appIconUrl == null || c40439f.field_appIconUrl.length() == 0) ? 1 : (c40536jx == null || c40536jx.vMI == null || c40536jx.vMI.length() == 0) ? 0 : !c40439f.field_appIconUrl.equals(c40536jx.vMA) ? 1 : 0;
        if (i != 0) {
            C4990ab.m7417i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", c40439f.field_appIconUrl, c40536jx.vMA);
            c40439f.field_appIconUrl = c40536jx.vMA;
            a = bYJ.mo56566a(c40439f, new String[0]);
            C34832a.bYH().mo48331dW(c40439f.field_appId, 1);
            C34832a.bYH().mo48331dW(c40439f.field_appId, 2);
            C34832a.bYH().mo48331dW(c40439f.field_appId, 3);
            C34832a.bYH().mo48331dW(c40439f.field_appId, 4);
            C34832a.bYH().mo48331dW(c40439f.field_appId, 5);
        } else {
            a = bYJ.mo56566a(c40439f, new String[0]);
        }
        C4990ab.m7416i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + a + ", appid = " + c40536jx.fKh);
        AppMethodBeat.m2505o(79374);
    }

    public final byte[] dhj() {
        AppMethodBeat.m2504i(79375);
        try {
            byte[] ZT = ((C6295b) this.lty.acF()).mo5742ZT();
            AppMethodBeat.m2505o(79375);
            return ZT;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            AppMethodBeat.m2505o(79375);
            return null;
        }
    }

    /* renamed from: bG */
    public final void mo9871bG(byte[] bArr) {
        AppMethodBeat.m2504i(79376);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            AppMethodBeat.m2505o(79376);
            return;
        }
        try {
            this.lty.fsH.mo5744P(bArr);
            AppMethodBeat.m2505o(79376);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
            AppMethodBeat.m2505o(79376);
        }
    }
}
