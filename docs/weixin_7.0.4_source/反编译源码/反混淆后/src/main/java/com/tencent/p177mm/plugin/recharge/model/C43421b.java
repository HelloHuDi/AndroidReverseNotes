package com.tencent.p177mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.recharge.model.b */
public final class C43421b {
    /* renamed from: a */
    public static ArrayList<MallRechargeProduct> m77504a(String str, JSONArray jSONArray) {
        ArrayList<MallRechargeProduct> arrayList;
        AppMethodBeat.m2504i(44183);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(C43421b.m77506e(str, jSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(44183);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.m2505o(44183);
        return arrayList;
    }

    /* renamed from: e */
    public static MallRechargeProduct m77506e(String str, JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.m2504i(44184);
        MallRechargeProduct mallRechargeProduct = new MallRechargeProduct(jSONObject.optInt("need_getlatestinfo", 1) == 1);
        mallRechargeProduct.pFP = str;
        mallRechargeProduct.cwg = jSONObject.getString("product_id");
        mallRechargeProduct.lcC = jSONObject.getString("product_name");
        mallRechargeProduct.pFQ = jSONObject.optString("product_desc");
        mallRechargeProduct.pFR = ((float) jSONObject.getInt("product_min_price")) / 100.0f;
        mallRechargeProduct.pFS = ((float) jSONObject.getInt("product_max_price")) / 100.0f;
        mallRechargeProduct.appId = jSONObject.optString("app_id");
        if (jSONObject.getInt("is_infinite") == 1) {
            z = true;
        } else {
            z = false;
        }
        mallRechargeProduct.pFT = z;
        mallRechargeProduct.pFU = jSONObject.getInt("left_count");
        mallRechargeProduct.pFV = jSONObject.getInt("discount");
        if (jSONObject.optInt("is_default_choose", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        mallRechargeProduct.isDefault = z;
        mallRechargeProduct.pFX = true;
        mallRechargeProduct.fmR = jSONObject.optInt("product_type", 0);
        AppMethodBeat.m2505o(44184);
        return mallRechargeProduct;
    }

    /* renamed from: ws */
    public static String m77507ws(String str) {
        AppMethodBeat.m2504i(44185);
        if (str == null) {
            AppMethodBeat.m2505o(44185);
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            replaceAll = replaceAll.substring(2);
        }
        AppMethodBeat.m2505o(44185);
        return replaceAll;
    }

    /* renamed from: VB */
    public static String m77503VB(String str) {
        AppMethodBeat.m2504i(44186);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(44186);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder(str.replaceAll(" ", ""));
        int length = stringBuilder.length();
        if (length >= 4) {
            stringBuilder.insert(3, ' ');
            if (length >= 8) {
                stringBuilder.insert(8, ' ');
            }
            str2 = stringBuilder.toString();
            AppMethodBeat.m2505o(44186);
            return str2;
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(44186);
        return str2;
    }

    public static void ced() {
        AppMethodBeat.m2504i(44187);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.TRUE);
        AppMethodBeat.m2505o(44187);
    }

    /* renamed from: c */
    public static boolean m77505c(MallFunction mallFunction) {
        AppMethodBeat.m2504i(44188);
        if (mallFunction.tDn == null || mallFunction.tDn.tBn != 1 || C5046bo.isNullOrNil(mallFunction.tDn.tDC)) {
            AppMethodBeat.m2505o(44188);
            return false;
        }
        C1720g.m3537RQ();
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.m2505o(44188);
            return false;
        }
        AppMethodBeat.m2505o(44188);
        return true;
    }
}
