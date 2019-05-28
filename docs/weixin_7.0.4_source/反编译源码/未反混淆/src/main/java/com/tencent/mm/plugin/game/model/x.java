package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class x {
    public static c a(e eVar) {
        c cVar = null;
        AppMethodBeat.i(111358);
        if (eVar == null) {
            ab.e("MicroMsg.GamePBData", "Invalid pb object");
            AppMethodBeat.o(111358);
        } else if (bo.isNullOrNil(eVar.mZr)) {
            ab.e("MicroMsg.GamePBData", "No AppID field, abort");
            AppMethodBeat.o(111358);
        } else {
            ab.i("MicroMsg.GamePBData", "Parsing AppID: %s", eVar.mZr);
            cVar = new c();
            cVar.field_appId = eVar.mZr;
            cVar.field_appName = eVar.Name;
            cVar.field_appIconUrl = eVar.mZs;
            cVar.field_appType = ",1,";
            cVar.field_packageName = eVar.mZu;
            cVar.field_appVersion = eVar.Version;
            cVar.field_appInfoFlag = eVar.mZx;
            if (eVar.mZw != null) {
                cVar.ih(eVar.mZw.nac);
                cVar.ik(eVar.mZw.nad);
                cVar.hq(eVar.mZw.nag);
                cVar.il(eVar.mZw.nae);
                cVar.mVD = eVar.mZw.nai;
                cVar.mVE = (long) eVar.mZw.nah;
                cVar.cBA = eVar.mZw.naj;
            }
            if (!(eVar.mZw == null || eVar.mZw.naf == null)) {
                cVar.iq(eVar.mZw.naf.nac);
                cVar.ir(eVar.mZw.naf.ndR);
                cVar.io(eVar.mZw.naf.ndS);
                cVar.ip(eVar.mZw.naf.ndT);
                cVar.hr(eVar.mZw.naf.ndV);
            }
            cVar.mVk = eVar.Desc;
            cVar.mVj = eVar.mZt;
            cVar.status = eVar.jBT;
            cVar.mVm = eVar.mZm;
            cVar.versionCode = eVar.mZv;
            cVar.ctu = eVar.mZo;
            cVar.mVo = eVar.mZy;
            cVar.mVw = eVar.mZD;
            if (!(eVar.mZw == null || eVar.mZw.naf == null)) {
                cVar.mVp = eVar.mZw.naf.ndU;
                cVar.mVq = eVar.mZw.naf.ndW;
                cVar.mVr = eVar.mZw.naf.ndX;
            }
            cVar.egi = eVar.mZF;
            cVar.mVF = eVar.mZG;
            AppMethodBeat.o(111358);
        }
        return cVar;
    }
}
