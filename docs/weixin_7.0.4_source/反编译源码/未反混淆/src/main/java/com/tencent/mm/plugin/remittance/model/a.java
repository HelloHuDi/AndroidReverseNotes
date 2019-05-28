package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static JSONObject a(lp lpVar) {
        AppMethodBeat.i(44713);
        JSONObject jSONObject;
        if (lpVar == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.o(44713);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            LinkedList linkedList = lpVar.vPg;
            abw abw = new abw();
            jSONObject.put("favor_info_list", cP(linkedList));
            linkedList = lpVar.vPh;
            abv abv = new abv();
            jSONObject.put("favor_compose_result_list", cQ(linkedList));
            jSONObject.put("default_fav_compose_id", lpVar.vPi);
            jSONObject.put("favor_resp_sign", lpVar.vPj);
            jSONObject.put("no_compose_wording", lpVar.vPk);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(44713);
        return jSONObject;
    }

    private static JSONArray cP(List<abw> list) {
        AppMethodBeat.i(44714);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.o(44714);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i = 0;
            for (abw a : list) {
                jSONArray2.put(i, a(a));
                i++;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(44714);
        return jSONArray2;
    }

    private static JSONObject a(abw abw) {
        AppMethodBeat.i(44715);
        JSONObject jSONObject;
        if (abw == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.o(44715);
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
            AppMethodBeat.o(44715);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            AppMethodBeat.o(44715);
            return jSONObject;
        }
    }

    private static JSONArray cQ(List<abv> list) {
        AppMethodBeat.i(44716);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.o(44716);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i = 0;
            for (abv a : list) {
                jSONArray2.put(i, a(a));
                i++;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(44716);
        return jSONArray2;
    }

    public static JSONObject a(abv abv) {
        AppMethodBeat.i(44717);
        JSONObject jSONObject;
        if (abv == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.o(44717);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("favor_compose_id", abv.wjd);
            LinkedList linkedList = abv.vPg;
            abw abw = new abw();
            jSONObject.put("favor_info_list,", cP(linkedList));
            jSONObject.put("show_favor_amount,", abv.wje);
            jSONObject.put("show_pay_amount,", abv.wjf);
            jSONObject.put("total_favor_amount,", abv.wjg);
            jSONObject.put("favor_desc", abv.pOz);
            jSONObject.put("compose_sort_flag", abv.wjh);
            jSONObject.put("extend_str", abv.vWF);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(44717);
        return jSONObject;
    }

    public static JSONObject a(cz czVar) {
        AppMethodBeat.i(44718);
        JSONObject jSONObject;
        if (czVar == null) {
            jSONObject = new JSONObject();
            AppMethodBeat.o(44718);
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", czVar.cIb);
            jSONObject.put("favor_compose_info", a(czVar.vFe));
            jSONObject.put("f2f_id", czVar.vFb);
            jSONObject.put("payok_checksign", czVar.vFd);
            jSONObject.put("receiver_openid", czVar.pPZ);
            jSONObject.put("receiver_username", czVar.vFf);
            jSONObject.put("scan_scene", czVar.pOA);
            jSONObject.put("scene", czVar.scene);
            jSONObject.put("total_amount", czVar.vFg);
            jSONObject.put("trans_id", czVar.vFc);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(44718);
        return jSONObject;
    }
}
