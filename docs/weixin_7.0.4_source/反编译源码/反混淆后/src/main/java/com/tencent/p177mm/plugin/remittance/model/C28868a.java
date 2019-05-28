package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44141lp;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.protocal.protobuf.abv;
import com.tencent.p177mm.protocal.protobuf.abw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.a */
public final class C28868a {
    /* renamed from: a */
    public static JSONObject m45887a(C44141lp c44141lp) {
        AppMethodBeat.m2504i(44713);
        JSONObject jSONObject;
        if (c44141lp == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.m2505o(44713);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            LinkedList linkedList = c44141lp.vPg;
            abw abw = new abw();
            jSONObject.put("favor_info_list", C28868a.m45888cP(linkedList));
            linkedList = c44141lp.vPh;
            abv abv = new abv();
            jSONObject.put("favor_compose_result_list", C28868a.m45889cQ(linkedList));
            jSONObject.put("default_fav_compose_id", c44141lp.vPi);
            jSONObject.put("favor_resp_sign", c44141lp.vPj);
            jSONObject.put("no_compose_wording", c44141lp.vPk);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(44713);
        return jSONObject;
    }

    /* renamed from: cP */
    private static JSONArray m45888cP(List<abw> list) {
        AppMethodBeat.m2504i(44714);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.m2505o(44714);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i = 0;
            for (abw a : list) {
                jSONArray2.put(i, C28868a.m45885a(a));
                i++;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(44714);
        return jSONArray2;
    }

    /* renamed from: a */
    private static JSONObject m45885a(abw abw) {
        AppMethodBeat.m2504i(44715);
        JSONObject jSONObject;
        if (abw == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.m2505o(44715);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("fav_type", abw.wji);
            jSONObject.put("fav_sub_type", abw.wjj);
            jSONObject.put("fav_property", abw.wjk);
            jSONObject.put("favor_type_desc", abw.wjl);
            jSONObject.put("fav_id", abw.wjm);
            jSONObject.put("fav_name", abw.wjn);
            jSONObject.put("fav_desc", abw.wjo);
            jSONObject.put("favor_use_manual", abw.wjp);
            jSONObject.put("favor_remarks", abw.wjq);
            jSONObject.put("fav_price", abw.wjr);
            jSONObject.put("real_fav_fee", abw.wjs);
            jSONObject.put("fav_scope_type", abw.wjt);
            jSONObject.put("business_receipt_no", abw.wju);
            jSONObject.put("unavailable", abw.wjv);
            AppMethodBeat.m2505o(44715);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(44715);
            return jSONObject;
        }
    }

    /* renamed from: cQ */
    private static JSONArray m45889cQ(List<abv> list) {
        AppMethodBeat.m2504i(44716);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.m2505o(44716);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i = 0;
            for (abv a : list) {
                jSONArray2.put(i, C28868a.m45884a(a));
                i++;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(44716);
        return jSONArray2;
    }

    /* renamed from: a */
    public static JSONObject m45884a(abv abv) {
        AppMethodBeat.m2504i(44717);
        JSONObject jSONObject;
        if (abv == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.m2505o(44717);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("favor_compose_id", abv.wjd);
            LinkedList linkedList = abv.vPg;
            abw abw = new abw();
            jSONObject.put("favor_info_list,", C28868a.m45888cP(linkedList));
            jSONObject.put("show_favor_amount,", abv.wje);
            jSONObject.put("show_pay_amount,", abv.wjf);
            jSONObject.put("total_favor_amount,", abv.wjg);
            jSONObject.put("favor_desc", abv.pOz);
            jSONObject.put("compose_sort_flag", abv.wjh);
            jSONObject.put("extend_str", abv.vWF);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(44717);
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m45886a(C46532cz c46532cz) {
        AppMethodBeat.m2504i(44718);
        JSONObject jSONObject;
        if (c46532cz == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.m2505o(44718);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", c46532cz.cIb);
            jSONObject.put("favor_compose_info", C28868a.m45884a(c46532cz.vFe));
            jSONObject.put("f2f_id", c46532cz.vFb);
            jSONObject.put("payok_checksign", c46532cz.vFd);
            jSONObject.put("receiver_openid", c46532cz.pPZ);
            jSONObject.put("receiver_username", c46532cz.vFf);
            jSONObject.put("scan_scene", c46532cz.pOA);
            jSONObject.put("scene", c46532cz.scene);
            jSONObject.put("total_amount", c46532cz.vFg);
            jSONObject.put("trans_id", c46532cz.vFc);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(44718);
        return jSONObject;
    }
}
