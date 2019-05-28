package com.tencent.p177mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.mall.b */
public final class C29636b {
    public static int tDq = -256;
    public static int tDr = 621019136;
    public static int tDs = 637534720;

    /* renamed from: C */
    public static ArrayList<MallNews> m47005C(JSONArray jSONArray) {
        AppMethodBeat.m2504i(47007);
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.tDx = jSONObject.optString("activity_icon_link");
                mallNews.tDv = jSONObject.optString("activity_msg_content");
                mallNews.tDz = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            AppMethodBeat.m2505o(47007);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            AppMethodBeat.m2505o(47007);
            return null;
        }
    }

    /* renamed from: D */
    public static ArrayList<C14237a> m47006D(JSONArray jSONArray) {
        AppMethodBeat.m2504i(47008);
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C14237a c14237a = new C14237a();
                c14237a.tDi = jSONObject.optInt("banner_id");
                c14237a.tDj = jSONObject.optString("banner_title");
                c14237a.tDk = jSONObject.optString("banner_link");
                arrayList.add(c14237a);
            }
            AppMethodBeat.m2505o(47008);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.m7420w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            AppMethodBeat.m2505o(47008);
            return null;
        }
    }

    /* renamed from: E */
    public static SparseArray<String> m47007E(JSONArray jSONArray) {
        AppMethodBeat.m2504i(47009);
        try {
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            AppMethodBeat.m2505o(47009);
            return sparseArray;
        } catch (JSONException e) {
            C4990ab.m7420w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            AppMethodBeat.m2505o(47009);
            return null;
        }
    }

    /* renamed from: dS */
    public static boolean m47010dS(List<C14237a> list) {
        AppMethodBeat.m2504i(47010);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(270342, Integer.valueOf(0))).intValue();
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C4990ab.m7410d("MicroMsg.MallLogic", "i:" + size + ", lastClickedListMaxId:" + intValue + ", actId:" + ((C14237a) list.get(size)).tDi);
                if (((C14237a) list.get(size)).tDi > intValue) {
                    AppMethodBeat.m2505o(47010);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(47010);
        return false;
    }

    /* renamed from: dT */
    public static void m47011dT(List<C14237a> list) {
        AppMethodBeat.m2504i(47011);
        if (list == null || list.size() <= 0) {
            C4990ab.m7420w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            AppMethodBeat.m2505o(47011);
            return;
        }
        int i = ((C14237a) list.get(0)).tDi;
        C4990ab.m7410d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(270342, Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(47011);
    }

    /* renamed from: F */
    public static ArrayList<MallFunction> m47008F(JSONArray jSONArray) {
        ArrayList<MallFunction> arrayList;
        AppMethodBeat.m2504i(47012);
        try {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            C4990ab.m7410d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(length)));
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.pFP = jSONObject.getString("func_id");
                mallFunction.cOI = jSONObject.getString("func_name");
                mallFunction.tDl = jSONObject.optString("func_icon_url");
                mallFunction.olO = jSONObject.optString("hd_icon_url");
                mallFunction.olP = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.cRS = jSONObject.optString("native_url");
                mallFunction.nmz = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.tDo = jSONObject.optString("third_party_disclaimer");
                mallFunction.tDp = jSONObject.optInt("download_restrict", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.tDm = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.tDm.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.pFP;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.ssr = jSONObject2.optString("activity_id");
                    mallNews.cxb = jSONObject2.optString("activity_ticket");
                    mallNews.tDv = jSONObject2.optString("activity_msg_content");
                    mallNews.tDw = jSONObject2.optString("activity_link");
                    mallNews.tDx = jSONObject2.optString("activity_icon_link");
                    mallNews.tDy = jSONObject2.optInt("activity_expired_time");
                    mallNews.tDz = jSONObject2.optString("activity_tips");
                    mallNews.tBn = jSONObject2.optInt("activity_type");
                    mallNews.tDC = jSONObject2.optString("activity_url");
                    mallNews.tDA = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.tDn = mallNews;
                }
                arrayList.add(mallFunction);
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            arrayList = null;
        }
        AppMethodBeat.m2505o(47012);
        return arrayList;
    }

    public static String cQS() {
        String networkCountryIso;
        AppMethodBeat.m2504i(47013);
        TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            networkCountryIso = telephonyManager.getNetworkCountryIso();
        } else {
            networkCountryIso = str;
        }
        AppMethodBeat.m2505o(47013);
        return networkCountryIso;
    }

    /* renamed from: Hs */
    public static void m47009Hs(int i) {
        boolean z;
        AppMethodBeat.m2504i(47014);
        if ((C7243d.vxo & tDq) == i) {
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                C4990ab.m7410d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && C1853r.m3827YI()) {
                    C4990ab.m7410d("MicroMsg.MallLogic", "Show mall entry redot");
                    C16112c.m24429PK().mo28556x(262156, true);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(270343, Integer.valueOf(i));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.m2505o(47014);
            }
        }
        z = false;
        C4990ab.m7410d("MicroMsg.MallLogic", "Show mall entry redot");
        C16112c.m24429PK().mo28556x(262156, true);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(270343, Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(47014);
    }
}
