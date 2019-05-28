package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class m implements t {
    private List<String> vbN = new ArrayList();
    public Vector<String> vcj = new Vector();
    private volatile boolean vck = false;

    public m() {
        AppMethodBeat.i(79329);
        a.bYM().a(1, (t) this);
        AppMethodBeat.o(79329);
    }

    public final void wy(String str) {
        AppMethodBeat.i(79330);
        ab.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppSettingService", "add appId is null");
            AppMethodBeat.o(79330);
            return;
        }
        if (!this.vcj.contains(str)) {
            this.vcj.add(str);
        }
        Pt();
        AppMethodBeat.o(79330);
    }

    public final void addAll(List<String> list) {
        AppMethodBeat.i(79331);
        if (list == null || list.size() == 0) {
            ab.e("MicroMsg.AppSettingService", "addAll list is null");
            AppMethodBeat.o(79331);
            return;
        }
        for (String str : list) {
            if (!(bo.isNullOrNil(str) || this.vcj.contains(str))) {
                this.vcj.add(str);
            }
        }
        Pt();
        AppMethodBeat.o(79331);
    }

    public static String aiN(String str) {
        AppMethodBeat.i(79332);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
            AppMethodBeat.o(79332);
            return null;
        }
        f bS = g.bS(str, false);
        String str2;
        if (bS == null) {
            AppMethodBeat.o(79332);
            return null;
        } else if (bS.field_openId == null || bS.field_openId.length() == 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            ac acVar = new ac(linkedList);
            b.a aVar = new b.a();
            aVar.fsJ = new dl();
            aVar.fsK = new dm();
            aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
            aVar.fsI = 452;
            aVar.fsL = 0;
            aVar.fsM = 0;
            b acD = aVar.acD();
            dl dlVar = (dl) acD.fsG.fsP;
            byte[] dhj = acVar.dhj();
            if (dhj != null) {
                dlVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
            }
            dlVar.jCt = 1;
            com.tencent.mm.ai.a.a c = x.c(acD);
            ab.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode));
            if (c.errType == 0 && c.errCode == 0) {
                acVar.bG(aa.a(((dm) c.fsy).vFq));
                acVar.a(0, c.errType, c.errCode, c.aIm, acD, new byte[0]);
                bS = g.bT(str, false);
                if (bS != null) {
                    str2 = bS.field_openId;
                    AppMethodBeat.o(79332);
                    return str2;
                }
                AppMethodBeat.o(79332);
                return null;
            }
            AppMethodBeat.o(79332);
            return null;
        } else {
            str2 = bS.field_openId;
            AppMethodBeat.o(79332);
            return str2;
        }
    }

    private void Pt() {
        int i = 20;
        AppMethodBeat.i(79333);
        if (this.vck) {
            ab.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
            AppMethodBeat.o(79333);
        } else if (this.vcj.size() <= 0) {
            ab.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
            AppMethodBeat.o(79333);
        } else {
            ab.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.vcj.size());
            int size = this.vcj.size();
            if (size <= 20) {
                i = size;
            }
            this.vck = true;
            this.vbN.addAll(this.vcj.subList(0, i));
            g.RO().eJo.a(new y(1, new ac(this.vbN)), 0);
            AppMethodBeat.o(79333);
        }
    }

    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(79334);
        if (xVar.getType() != 1) {
            AppMethodBeat.o(79334);
            return;
        }
        this.vck = false;
        ab.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ac) xVar).vcs.size());
        this.vcj.removeAll(this.vbN);
        this.vbN.clear();
        Pt();
        AppMethodBeat.o(79334);
    }
}
