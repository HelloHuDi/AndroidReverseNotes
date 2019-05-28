package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int tDq = -256;
    public static int tDr = 621019136;
    public static int tDs = 637534720;

    public static ArrayList<MallNews> C(JSONArray jSONArray) {
        AppMethodBeat.i(47007);
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
            AppMethodBeat.o(47007);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            AppMethodBeat.o(47007);
            return null;
        }
    }

    public static ArrayList<a> D(JSONArray jSONArray) {
        AppMethodBeat.i(47008);
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.tDi = jSONObject.optInt("banner_id");
                aVar.tDj = jSONObject.optString("banner_title");
                aVar.tDk = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            AppMethodBeat.o(47008);
            return arrayList;
        } catch (JSONException e) {
            ab.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            AppMethodBeat.o(47008);
            return null;
        }
    }

    public static SparseArray<String> E(JSONArray jSONArray) {
        AppMethodBeat.i(47009);
        try {
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            AppMethodBeat.o(47009);
            return sparseArray;
        } catch (JSONException e) {
            ab.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            AppMethodBeat.o(47009);
            return null;
        }
    }

    public static boolean dS(List<a> list) {
        AppMethodBeat.i(47010);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(270342, Integer.valueOf(0))).intValue();
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ab.d("MicroMsg.MallLogic", "i:" + size + ", lastClickedListMaxId:" + intValue + ", actId:" + ((a) list.get(size)).tDi);
                if (((a) list.get(size)).tDi > intValue) {
                    AppMethodBeat.o(47010);
                    return true;
                }
            }
        }
        AppMethodBeat.o(47010);
        return false;
    }

    public static void dT(List<a> list) {
        AppMethodBeat.i(47011);
        if (list == null || list.size() <= 0) {
            ab.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            AppMethodBeat.o(47011);
            return;
        }
        int i = ((a) list.get(0)).tDi;
        ab.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
        g.RQ();
        g.RP().Ry().set(270342, Integer.valueOf(i));
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(47011);
    }

    public static ArrayList<MallFunction> F(JSONArray jSONArray) {
        ArrayList<MallFunction> arrayList;
        AppMethodBeat.i(47012);
        try {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            ab.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(length)));
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
            ab.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            arrayList = null;
        }
        AppMethodBeat.o(47012);
        return arrayList;
    }

    public static String cQS() {
        String networkCountryIso;
        AppMethodBeat.i(47013);
        TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            networkCountryIso = telephonyManager.getNetworkCountryIso();
        } else {
            networkCountryIso = str;
        }
        AppMethodBeat.o(47013);
        return networkCountryIso;
    }

    public static void Hs(int i) {
        boolean z;
        AppMethodBeat.i(47014);
        if ((d.vxo & tDq) == i) {
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                ab.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && r.YI()) {
                    ab.d("MicroMsg.MallLogic", "Show mall entry redot");
                    c.PK().x(262156, true);
                    g.RQ();
                    g.RP().Ry().set(270343, Integer.valueOf(i));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(47014);
            }
        }
        z = false;
        ab.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.PK().x(262156, true);
        g.RQ();
        g.RP().Ry().set(270343, Integer.valueOf(i));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(47014);
    }
}
