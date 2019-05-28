package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.abv;
import com.tencent.p177mm.protocal.protobuf.abw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.b */
public final class C43452b {
    /* renamed from: v */
    public static LinkedList<abv> m77574v(JSONArray jSONArray) {
        AppMethodBeat.m2504i(44719);
        LinkedList linkedList = new LinkedList();
        if (jSONArray == null) {
            AppMethodBeat.m2505o(44719);
        } else {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    abv abv = new abv();
                    abv.wjd = jSONObject.optString("favor_compose_id");
                    abv.wje = jSONObject.optLong("show_favor_amount");
                    abv.wjf = jSONObject.optLong("show_pay_amount");
                    abv.wjg = jSONObject.optString("total_favor_amount");
                    abv.pOz = jSONObject.optString("favor_desc");
                    abv.wjh = jSONObject.optLong("compose_sort_flag");
                    abv.vWF = jSONObject.optString("extend_str");
                    abv.vPg = C43452b.m77575w(jSONObject.optJSONArray("favor_info_list"));
                    linkedList.add(abv);
                    i++;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(44719);
        }
        return linkedList;
    }

    /* renamed from: w */
    public static LinkedList<abw> m77575w(JSONArray jSONArray) {
        AppMethodBeat.m2504i(44720);
        LinkedList linkedList = new LinkedList();
        if (jSONArray == null) {
            AppMethodBeat.m2505o(44720);
        } else {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    abw abw = new abw();
                    abw.wju = jSONObject.optString("business_receipt_no");
                    abw.vWF = jSONObject.optString("extend_str");
                    abw.wjo = jSONObject.optString("fav_desc");
                    abw.wjm = jSONObject.optLong("fav_id", 0);
                    abw.wjn = jSONObject.optString("fav_name");
                    abw.wjr = jSONObject.optString("fav_price");
                    abw.wjk = jSONObject.optLong("fav_property", 0);
                    abw.wjt = jSONObject.optInt("fav_scope_type", 0);
                    abw.wjj = jSONObject.optLong("fav_sub_type", 0);
                    abw.wji = jSONObject.optLong("fav_type", 0);
                    abw.wjq = jSONObject.optString("favor_remarks");
                    abw.wjl = jSONObject.optString("favor_type_desc");
                    abw.wjp = jSONObject.optString("favor_use_manual");
                    abw.wjs = jSONObject.optString("real_fav_fee");
                    abw.wjv = jSONObject.optInt("unavailable");
                    linkedList.add(abw);
                    i++;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(44720);
        }
        return linkedList;
    }
}
