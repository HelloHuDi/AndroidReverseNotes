package com.tencent.mm.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e;
import java.util.ArrayList;

public final class j implements com.tencent.mm.api.j {
    public final boolean cJ(String str) {
        AppMethodBeat.i(11230);
        if (z.aeR().qP(str).adJ()) {
            AppMethodBeat.o(11230);
            return true;
        }
        AppMethodBeat.o(11230);
        return false;
    }

    public final ArrayList<String> cK(String str) {
        AppMethodBeat.i(11231);
        try {
            b cJ = z.aeR().qP(str).cJ(false);
            if (cJ.fvE == null && cJ.fvc != null) {
                cJ.fvE = a.qI(cJ.fvc.optString("AcctTransferInfo"));
            }
            ArrayList arrayList = cJ.fvE.fvG;
            AppMethodBeat.o(11231);
            return arrayList;
        } catch (Exception e) {
            ArrayList<String> arrayList2 = new ArrayList();
            AppMethodBeat.o(11231);
            return arrayList2;
        }
    }

    public final void a(Intent intent, buv buv, int i) {
        AppMethodBeat.i(11232);
        String a = aa.a(buv.wcB);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", aa.a(buv.wyX));
        intent.putExtra("Contact_PyInitial", aa.a(buv.wce));
        intent.putExtra("Contact_QuanPin", aa.a(buv.wcf));
        intent.putExtra("Contact_Alias", buv.guS);
        intent.putExtra("Contact_Sex", buv.guN);
        intent.putExtra("Contact_VUser_Info", buv.wBU);
        intent.putExtra("Contact_VUser_Info_Flag", buv.wBT);
        intent.putExtra("Contact_KWeibo_flag", buv.wBX);
        intent.putExtra("Contact_KWeibo", buv.wBV);
        intent.putExtra("Contact_KWeiboNick", buv.wBW);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(buv.guW, buv.guO, buv.guP));
        intent.putExtra("Contact_Signature", buv.guQ);
        intent.putExtra("Contact_BrandList", buv.guX);
        intent.putExtra("Contact_KSnsIFlag", buv.wBZ.guY);
        intent.putExtra("Contact_KSnsBgId", buv.wBZ.gva);
        intent.putExtra("Contact_KSnsBgUrl", buv.wBZ.guZ);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", buv.wWk);
        intent.putExtra(e.b.yfT, buv.wlF);
        intent.putExtra("Contact_BIZ_PopupInfoMsg", buv.wWl);
        ab.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", buv.wlF);
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = buv.guX;
        dVar.field_kfWorkerId = buv.wWk;
        uy uyVar = buv.wCa;
        if (uyVar != null) {
            dVar.field_brandFlag = uyVar.gvb;
            dVar.field_brandInfo = uyVar.gvd;
            dVar.field_extInfo = uyVar.gvc;
            dVar.field_brandIconURL = uyVar.gve;
        }
        if (!z.aeR().e(dVar)) {
            z.aeR().d(dVar);
        }
        AppMethodBeat.o(11232);
    }

    public final void a(Intent intent, but but, int i) {
        AppMethodBeat.i(11233);
        String a = aa.a(but.wcB);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", aa.a(but.wyX));
        intent.putExtra("Contact_PyInitial", aa.a(but.wce));
        intent.putExtra("Contact_QuanPin", aa.a(but.wcf));
        intent.putExtra("Contact_Alias", but.guS);
        intent.putExtra("Contact_Sex", but.guN);
        intent.putExtra("Contact_VUser_Info", but.wBU);
        intent.putExtra("Contact_VUser_Info_Flag", but.wBT);
        intent.putExtra("Contact_KWeibo_flag", but.wBX);
        intent.putExtra("Contact_KWeibo", but.wBV);
        intent.putExtra("Contact_KWeiboNick", but.wBW);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(but.guW, but.guO, but.guP));
        intent.putExtra("Contact_Signature", but.guQ);
        intent.putExtra("Contact_BrandList", but.guX);
        intent.putExtra("Contact_KSnsIFlag", but.wBZ.guY);
        intent.putExtra("Contact_KSnsBgId", but.wBZ.gva);
        intent.putExtra("Contact_KSnsBgUrl", but.wBZ.guZ);
        intent.putExtra(e.b.yfT, but.wlF);
        ab.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", but.wlF);
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = but.guX;
        uy uyVar = but.wCa;
        if (uyVar != null) {
            dVar.field_brandFlag = uyVar.gvb;
            dVar.field_brandInfo = uyVar.gvd;
            dVar.field_extInfo = uyVar.gvc;
            dVar.field_brandIconURL = uyVar.gve;
        }
        if (!z.aeR().e(dVar)) {
            z.aeR().d(dVar);
        }
        AppMethodBeat.o(11233);
    }
}
