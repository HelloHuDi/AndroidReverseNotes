package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static List<e> cD(List<e> list) {
        AppMethodBeat.i(23935);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            ab.e("MicroMsg.NewBizInfoUtil", "serviceInfoList is null, err");
            AppMethodBeat.o(23935);
            return arrayList;
        }
        for (e eVar : list) {
            if (eVar.type == 0) {
                List<e> list2 = eVar.pqE;
                eVar.pqE = new ArrayList();
                for (e eVar2 : list2) {
                    if (eVar2.type == 2 || eVar2.type == 5) {
                        eVar.pqE.add(eVar2);
                    }
                }
                if (eVar.pqE.size() > 0) {
                    arrayList.add(eVar);
                }
            } else if (eVar.type == 2) {
                arrayList.add(eVar);
            } else if (eVar.type == 5) {
                arrayList.add(eVar);
            }
        }
        AppMethodBeat.o(23935);
        return arrayList;
    }

    public static void a(e eVar, Context context, String str) {
        AppMethodBeat.i(23936);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", eVar.value);
        intent.putExtra("geta8key_username", str);
        intent.putExtra("geta8key_scene", 59);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23936);
    }

    public static void b(e eVar, Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(23937);
        if (bo.isNullOrNil(eVar.value)) {
            ab.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", eVar.id);
            AppMethodBeat.o(23937);
            return;
        }
        ab.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", eVar.value);
        try {
            JSONObject jSONObject = new JSONObject(eVar.value);
            com.tencent.mm.aj.d qX = f.qX(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1102;
            appBrandStatObject.cst = str;
            e eVar2 = (e) g.K(e.class);
            String optString = jSONObject.optString("userName");
            String optString2 = jSONObject.optString("pagePath");
            if (qX != null) {
                str2 = qX.field_appId;
            }
            eVar2.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str2);
            AppMethodBeat.o(23937);
        } catch (JSONException e) {
            AppMethodBeat.o(23937);
        }
    }

    public static int Bk(int i) {
        switch (i) {
            case 17:
            case 41:
                return 2;
            case 30:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                return 4;
            case 39:
            case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                return 3;
            case 42:
            case 43:
            case com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX /*57*/:
                return 1;
            default:
                return 0;
        }
    }

    public static int aW(int i, String str) {
        AppMethodBeat.i(23938);
        if (str == null || !t.mZ(str)) {
            switch (i) {
                case 1:
                case 2:
                    AppMethodBeat.o(23938);
                    return i;
                case 6:
                case 7:
                case 9:
                case 11:
                case 12:
                case 13:
                    AppMethodBeat.o(23938);
                    return 3;
                default:
                    AppMethodBeat.o(23938);
                    return 0;
            }
        }
        AppMethodBeat.o(23938);
        return 3;
    }
}
