package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.c */
public final class C12866c {
    /* renamed from: cD */
    public static List<C39530e> m20862cD(List<C39530e> list) {
        AppMethodBeat.m2504i(23935);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            C4990ab.m7412e("MicroMsg.NewBizInfoUtil", "serviceInfoList is null, err");
            AppMethodBeat.m2505o(23935);
            return arrayList;
        }
        for (C39530e c39530e : list) {
            if (c39530e.type == 0) {
                List<C39530e> list2 = c39530e.pqE;
                c39530e.pqE = new ArrayList();
                for (C39530e c39530e2 : list2) {
                    if (c39530e2.type == 2 || c39530e2.type == 5) {
                        c39530e.pqE.add(c39530e2);
                    }
                }
                if (c39530e.pqE.size() > 0) {
                    arrayList.add(c39530e);
                }
            } else if (c39530e.type == 2) {
                arrayList.add(c39530e);
            } else if (c39530e.type == 5) {
                arrayList.add(c39530e);
            }
        }
        AppMethodBeat.m2505o(23935);
        return arrayList;
    }

    /* renamed from: a */
    public static void m20859a(C39530e c39530e, Context context, String str) {
        AppMethodBeat.m2504i(23936);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", c39530e.value);
        intent.putExtra("geta8key_username", str);
        intent.putExtra("geta8key_scene", 59);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(23936);
    }

    /* renamed from: b */
    public static void m20861b(C39530e c39530e, Context context, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(23937);
        if (C5046bo.isNullOrNil(c39530e.value)) {
            C4990ab.m7411d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", c39530e.f16178id);
            AppMethodBeat.m2505o(23937);
            return;
        }
        C4990ab.m7411d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", c39530e.value);
        try {
            JSONObject jSONObject = new JSONObject(c39530e.value);
            C16527d qX = C17903f.m28104qX(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1102;
            appBrandStatObject.cst = str;
            C45691e c45691e = (C45691e) C1720g.m3528K(C45691e.class);
            String optString = jSONObject.optString("userName");
            String optString2 = jSONObject.optString("pagePath");
            if (qX != null) {
                str2 = qX.field_appId;
            }
            c45691e.mo68046a(context, optString, null, 0, 0, optString2, appBrandStatObject, str2);
            AppMethodBeat.m2505o(23937);
        } catch (JSONException e) {
            AppMethodBeat.m2505o(23937);
        }
    }

    /* renamed from: Bk */
    public static int m20858Bk(int i) {
        switch (i) {
            case 17:
            case 41:
                return 2;
            case 30:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                return 4;
            case 39:
            case C31128d.MIC_COLORPENCIL /*87*/:
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                return 3;
            case 42:
            case 43:
            case C19410e.CTRL_INDEX /*57*/:
                return 1;
            default:
                return 0;
        }
    }

    /* renamed from: aW */
    public static int m20860aW(int i, String str) {
        AppMethodBeat.m2504i(23938);
        if (str == null || !C1855t.m3913mZ(str)) {
            switch (i) {
                case 1:
                case 2:
                    AppMethodBeat.m2505o(23938);
                    return i;
                case 6:
                case 7:
                case 9:
                case 11:
                case 12:
                case 13:
                    AppMethodBeat.m2505o(23938);
                    return 3;
                default:
                    AppMethodBeat.m2505o(23938);
                    return 0;
            }
        }
        AppMethodBeat.m2505o(23938);
        return 3;
    }
}
