package com.tencent.p177mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C32628se.C18390a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.modelappbrand.a */
public final class C42202a {
    /* renamed from: pi */
    public static boolean m74445pi(String str) {
        AppMethodBeat.m2504i(51125);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51125);
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject != null) {
                if (optJSONObject.optInt("openWxaByBizQRCode", 0) > 0) {
                    AppMethodBeat.m2505o(51125);
                    return true;
                }
                AppMethodBeat.m2505o(51125);
                return false;
            }
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(51125);
        return false;
    }

    /* renamed from: a */
    private static void m74440a(C32628se c32628se, C8910b c8910b) {
        c32628se.cOf.appId = c8910b.fiQ;
        c32628se.cOf.userName = c8910b.fiP;
        c32628se.cOf.cOh = c8910b.fiO;
        c32628se.cOf.cOi = c8910b.fiZ;
        c32628se.cOf.cOk = c8910b.fiS;
        c32628se.cOf.axy = c8910b.fja;
        c32628se.cOf.cOl = c8910b.fiZ != 0;
    }

    /* renamed from: a */
    public static void m74442a(String str, String str2, boolean z, C8910b c8910b, Bundle bundle) {
        AppMethodBeat.m2504i(51126);
        C32628se c32628se = new C32628se();
        C42202a.m74440a(c32628se, c8910b);
        C42202a.m74443b(c32628se, c8910b);
        c32628se.cOf.scene = z ? 1008 : 1007;
        c32628se.cOf.cst = str + (z ? VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.concat(String.valueOf(str2)) : "") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c8910b.fiU;
        c32628se.cOf.cvs = bundle;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(51126);
    }

    /* renamed from: a */
    public static void m74441a(String str, int i, C8910b c8910b, Bundle bundle) {
        AppMethodBeat.m2504i(51127);
        C32628se c32628se = new C32628se();
        C42202a.m74440a(c32628se, c8910b);
        C42202a.m74443b(c32628se, c8910b);
        c32628se.cOf.scene = i;
        if (i == FilterEnum4Shaka.MIC_WEISHI_CHAZHI) {
            c32628se.cOf.cst = str;
        }
        c32628se.cOf.cvs = bundle;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(51127);
    }

    /* renamed from: b */
    public static void m74444b(String str, String str2, boolean z, C8910b c8910b, Bundle bundle) {
        int i = 2;
        AppMethodBeat.m2504i(51128);
        if (TextUtils.isEmpty(c8910b.fiV)) {
            C4990ab.m7413e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", str, str2, Boolean.valueOf(z));
            C42202a.m74442a(str, str2, z, c8910b, bundle);
            AppMethodBeat.m2505o(51128);
            return;
        }
        C32628se c32628se = new C32628se();
        C42202a.m74440a(c32628se, c8910b);
        C42202a.m74443b(c32628se, c8910b);
        c32628se.cOf.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
        c32628se.cOf.cst = c8910b.fiU;
        C18390a c18390a = c32628se.cOf;
        if (!z) {
            i = 1;
        }
        c18390a.cOq = i;
        C18390a c18390a2 = c32628se.cOf;
        if (z) {
            str2 = str;
        }
        c18390a2.cOr = str2;
        c32628se.cOf.cOn.bQi = c8910b.fiV;
        c32628se.cOf.cOn.bQh = str;
        c32628se.cOf.cvs = bundle;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(51128);
    }

    /* renamed from: b */
    private static void m74443b(C32628se c32628se, C8910b c8910b) {
        AppMethodBeat.m2504i(51129);
        if (c8910b != null) {
            C41728a c41728a = (C41728a) c8910b.mo20333X(C41728a.class);
            if (!(c41728a == null || C5046bo.isNullOrNil(c41728a.ffk))) {
                c32628se.cOf.cOv = c41728a.ffk;
            }
        }
        AppMethodBeat.m2505o(51129);
    }

    public static boolean abu() {
        AppMethodBeat.m2504i(51130);
        if (C1720g.m3531RK()) {
            C5141c ll = C18624c.abi().mo17131ll("100360");
            if (ll.isValid() && "1".equals(ll.dru().get("isOpenFTSSearchMiniGameEntry"))) {
                AppMethodBeat.m2505o(51130);
                return true;
            }
            AppMethodBeat.m2505o(51130);
            return false;
        }
        AppMethodBeat.m2505o(51130);
        return false;
    }
}
