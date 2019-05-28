package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean pi(String str) {
        AppMethodBeat.i(51125);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51125);
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject != null) {
                if (optJSONObject.optInt("openWxaByBizQRCode", 0) > 0) {
                    AppMethodBeat.o(51125);
                    return true;
                }
                AppMethodBeat.o(51125);
                return false;
            }
        } catch (JSONException e) {
        }
        AppMethodBeat.o(51125);
        return false;
    }

    private static void a(se seVar, b bVar) {
        seVar.cOf.appId = bVar.fiQ;
        seVar.cOf.userName = bVar.fiP;
        seVar.cOf.cOh = bVar.fiO;
        seVar.cOf.cOi = bVar.fiZ;
        seVar.cOf.cOk = bVar.fiS;
        seVar.cOf.axy = bVar.fja;
        seVar.cOf.cOl = bVar.fiZ != 0;
    }

    public static void a(String str, String str2, boolean z, b bVar, Bundle bundle) {
        AppMethodBeat.i(51126);
        se seVar = new se();
        a(seVar, bVar);
        b(seVar, bVar);
        seVar.cOf.scene = z ? 1008 : 1007;
        seVar.cOf.cst = str + (z ? VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.concat(String.valueOf(str2)) : "") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bVar.fiU;
        seVar.cOf.cvs = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(51126);
    }

    public static void a(String str, int i, b bVar, Bundle bundle) {
        AppMethodBeat.i(51127);
        se seVar = new se();
        a(seVar, bVar);
        b(seVar, bVar);
        seVar.cOf.scene = i;
        if (i == FilterEnum4Shaka.MIC_WEISHI_CHAZHI) {
            seVar.cOf.cst = str;
        }
        seVar.cOf.cvs = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(51127);
    }

    public static void b(String str, String str2, boolean z, b bVar, Bundle bundle) {
        int i = 2;
        AppMethodBeat.i(51128);
        if (TextUtils.isEmpty(bVar.fiV)) {
            ab.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", str, str2, Boolean.valueOf(z));
            a(str, str2, z, bVar, bundle);
            AppMethodBeat.o(51128);
            return;
        }
        se seVar = new se();
        a(seVar, bVar);
        b(seVar, bVar);
        seVar.cOf.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
        seVar.cOf.cst = bVar.fiU;
        com.tencent.mm.g.a.se.a aVar = seVar.cOf;
        if (!z) {
            i = 1;
        }
        aVar.cOq = i;
        com.tencent.mm.g.a.se.a aVar2 = seVar.cOf;
        if (z) {
            str2 = str;
        }
        aVar2.cOr = str2;
        seVar.cOf.cOn.bQi = bVar.fiV;
        seVar.cOf.cOn.bQh = str;
        seVar.cOf.cvs = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(51128);
    }

    private static void b(se seVar, b bVar) {
        AppMethodBeat.i(51129);
        if (bVar != null) {
            com.tencent.mm.af.a aVar = (com.tencent.mm.af.a) bVar.X(com.tencent.mm.af.a.class);
            if (!(aVar == null || bo.isNullOrNil(aVar.ffk))) {
                seVar.cOf.cOv = aVar.ffk;
            }
        }
        AppMethodBeat.o(51129);
    }

    public static boolean abu() {
        AppMethodBeat.i(51130);
        if (g.RK()) {
            c ll = com.tencent.mm.model.c.c.abi().ll("100360");
            if (ll.isValid() && "1".equals(ll.dru().get("isOpenFTSSearchMiniGameEntry"))) {
                AppMethodBeat.o(51130);
                return true;
            }
            AppMethodBeat.o(51130);
            return false;
        }
        AppMethodBeat.o(51130);
        return false;
    }
}
