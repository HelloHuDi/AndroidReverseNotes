package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static ArrayList<MallRechargeProduct> a(String str, JSONArray jSONArray) {
        ArrayList<MallRechargeProduct> arrayList;
        AppMethodBeat.i(44183);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(e(str, jSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
                AppMethodBeat.o(44183);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.o(44183);
        return arrayList;
    }

    public static MallRechargeProduct e(String str, JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.i(44184);
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
        AppMethodBeat.o(44184);
        return mallRechargeProduct;
    }

    public static String ws(String str) {
        AppMethodBeat.i(44185);
        if (str == null) {
            AppMethodBeat.o(44185);
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            replaceAll = replaceAll.substring(2);
        }
        AppMethodBeat.o(44185);
        return replaceAll;
    }

    public static String VB(String str) {
        AppMethodBeat.i(44186);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(44186);
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
            AppMethodBeat.o(44186);
            return str2;
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(44186);
        return str2;
    }

    public static void ced() {
        AppMethodBeat.i(44187);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.TRUE);
        AppMethodBeat.o(44187);
    }

    public static boolean c(MallFunction mallFunction) {
        AppMethodBeat.i(44188);
        if (mallFunction.tDn == null || mallFunction.tDn.tBn != 1 || bo.isNullOrNil(mallFunction.tDn.tDC)) {
            AppMethodBeat.o(44188);
            return false;
        }
        g.RQ();
        if (((Boolean) g.RP().Ry().get(a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(44188);
            return false;
        }
        AppMethodBeat.o(44188);
        return true;
    }
}
