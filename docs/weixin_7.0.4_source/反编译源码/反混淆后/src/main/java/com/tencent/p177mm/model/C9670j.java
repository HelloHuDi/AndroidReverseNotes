package com.tencent.p177mm.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16535a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.model.j */
public final class C9670j implements C32250j {
    /* renamed from: cJ */
    public final boolean mo20993cJ(String str) {
        AppMethodBeat.m2504i(11230);
        if (C41747z.aeR().mo43729qP(str).adJ()) {
            AppMethodBeat.m2505o(11230);
            return true;
        }
        AppMethodBeat.m2505o(11230);
        return false;
    }

    /* renamed from: cK */
    public final ArrayList<String> mo20994cK(String str) {
        AppMethodBeat.m2504i(11231);
        try {
            C16529b cJ = C41747z.aeR().mo43729qP(str).mo30481cJ(false);
            if (cJ.fvE == null && cJ.fvc != null) {
                cJ.fvE = C16535a.m25409qI(cJ.fvc.optString("AcctTransferInfo"));
            }
            ArrayList arrayList = cJ.fvE.fvG;
            AppMethodBeat.m2505o(11231);
            return arrayList;
        } catch (Exception e) {
            ArrayList<String> arrayList2 = new ArrayList();
            AppMethodBeat.m2505o(11231);
            return arrayList2;
        }
    }

    /* renamed from: a */
    public final void mo20992a(Intent intent, buv buv, int i) {
        AppMethodBeat.m2504i(11232);
        String a = C1946aa.m4148a(buv.wcB);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", C1946aa.m4148a(buv.wyX));
        intent.putExtra("Contact_PyInitial", C1946aa.m4148a(buv.wce));
        intent.putExtra("Contact_QuanPin", C1946aa.m4148a(buv.wcf));
        intent.putExtra("Contact_Alias", buv.guS);
        intent.putExtra("Contact_Sex", buv.guN);
        intent.putExtra("Contact_VUser_Info", buv.wBU);
        intent.putExtra("Contact_VUser_Info_Flag", buv.wBT);
        intent.putExtra("Contact_KWeibo_flag", buv.wBX);
        intent.putExtra("Contact_KWeibo", buv.wBV);
        intent.putExtra("Contact_KWeiboNick", buv.wBW);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(buv.guW, buv.guO, buv.guP));
        intent.putExtra("Contact_Signature", buv.guQ);
        intent.putExtra("Contact_BrandList", buv.guX);
        intent.putExtra("Contact_KSnsIFlag", buv.wBZ.guY);
        intent.putExtra("Contact_KSnsBgId", buv.wBZ.gva);
        intent.putExtra("Contact_KSnsBgUrl", buv.wBZ.guZ);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", buv.wWk);
        intent.putExtra(C5495b.yfT, buv.wlF);
        intent.putExtra("Contact_BIZ_PopupInfoMsg", buv.wWl);
        C4990ab.m7417i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", buv.wlF);
        C16527d c16527d = new C16527d();
        c16527d.field_username = a;
        c16527d.field_brandList = buv.guX;
        c16527d.field_kfWorkerId = buv.wWk;
        C7285uy c7285uy = buv.wCa;
        if (c7285uy != null) {
            c16527d.field_brandFlag = c7285uy.gvb;
            c16527d.field_brandInfo = c7285uy.gvd;
            c16527d.field_extInfo = c7285uy.gvc;
            c16527d.field_brandIconURL = c7285uy.gve;
        }
        if (!C41747z.aeR().mo43726e(c16527d)) {
            C41747z.aeR().mo43724d(c16527d);
        }
        AppMethodBeat.m2505o(11232);
    }

    /* renamed from: a */
    public final void mo20991a(Intent intent, but but, int i) {
        AppMethodBeat.m2504i(11233);
        String a = C1946aa.m4148a(but.wcB);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", C1946aa.m4148a(but.wyX));
        intent.putExtra("Contact_PyInitial", C1946aa.m4148a(but.wce));
        intent.putExtra("Contact_QuanPin", C1946aa.m4148a(but.wcf));
        intent.putExtra("Contact_Alias", but.guS);
        intent.putExtra("Contact_Sex", but.guN);
        intent.putExtra("Contact_VUser_Info", but.wBU);
        intent.putExtra("Contact_VUser_Info_Flag", but.wBT);
        intent.putExtra("Contact_KWeibo_flag", but.wBX);
        intent.putExtra("Contact_KWeibo", but.wBV);
        intent.putExtra("Contact_KWeiboNick", but.wBW);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(but.guW, but.guO, but.guP));
        intent.putExtra("Contact_Signature", but.guQ);
        intent.putExtra("Contact_BrandList", but.guX);
        intent.putExtra("Contact_KSnsIFlag", but.wBZ.guY);
        intent.putExtra("Contact_KSnsBgId", but.wBZ.gva);
        intent.putExtra("Contact_KSnsBgUrl", but.wBZ.guZ);
        intent.putExtra(C5495b.yfT, but.wlF);
        C4990ab.m7417i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", but.wlF);
        C16527d c16527d = new C16527d();
        c16527d.field_username = a;
        c16527d.field_brandList = but.guX;
        C7285uy c7285uy = but.wCa;
        if (c7285uy != null) {
            c16527d.field_brandFlag = c7285uy.gvb;
            c16527d.field_brandInfo = c7285uy.gvd;
            c16527d.field_extInfo = c7285uy.gvc;
            c16527d.field_brandIconURL = c7285uy.gve;
        }
        if (!C41747z.aeR().mo43726e(c16527d)) {
            C41747z.aeR().mo43724d(c16527d);
        }
        AppMethodBeat.m2505o(11233);
    }
}
