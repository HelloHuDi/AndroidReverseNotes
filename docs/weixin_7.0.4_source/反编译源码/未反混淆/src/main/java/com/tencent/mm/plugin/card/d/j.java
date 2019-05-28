package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    public static void c(LinkedList<pf> linkedList, int i) {
        AppMethodBeat.i(88877);
        if (linkedList == null) {
            AppMethodBeat.o(88877);
            return;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                pf pfVar = (pf) linkedList.get(i3);
                c baW = am.baW();
                String str = pfVar.cMC;
                int i4 = ((size - i3) * 10) + i;
                String str2 = pfVar.kfO;
                i2 = pfVar.kbZ;
                if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.CardInfoStorage", "cardId null");
                } else {
                    baW.bSd.hY("UserCardInfo", "update UserCardInfo set stickyIndex=" + i4 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i2 + " where card_id='" + str + "'");
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(88877);
                return;
            }
        }
    }

    public static void d(LinkedList<pf> linkedList, int i) {
        AppMethodBeat.i(88878);
        if (linkedList == null) {
            AppMethodBeat.o(88878);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                String str;
                pf pfVar = (pf) linkedList.get(i3);
                c baW = am.baW();
                String str2 = pfVar.cMC;
                if (pfVar.vWy != null) {
                    str = pfVar.vWy;
                } else {
                    str = "";
                }
                baW.bSd.hY("UserCardInfo", "update UserCardInfo set stickyIndex=" + i + ", label_wording='" + str + "' where card_id='" + str2 + "'");
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(88878);
                return;
            }
        }
    }

    public static agz Hm(String str) {
        AppMethodBeat.i(88879);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.CardStickyHelper", "jsonRet null");
            AppMethodBeat.o(88879);
            return null;
        }
        agz agz = new agz();
        try {
            JSONObject jSONObject = new JSONObject(str);
            agz.wno = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                agz.wnu = new ph();
                agz.wnu.vWA = P(jSONObject2.optJSONObject("expiring_list"));
                agz.wnu.vWB = P(jSONObject2.optJSONObject("member_card_list"));
                agz.wnu.vWC = P(jSONObject2.optJSONObject("nearby_list"));
                agz.wnu.vWD = P(jSONObject2.optJSONObject("label_list"));
                agz.wnu.vWE = P(jSONObject2.optJSONObject("first_list"));
                if (!(agz.wnu.vWE == null || agz.wnu.vWE.vWz == null)) {
                    for (int size = agz.wnu.vWE.vWz.size() - 1; size >= 0; size--) {
                        pf pfVar = (pf) agz.wnu.vWE.vWz.get(size);
                        if (!bo.isNullOrNil(pfVar.cMC)) {
                            CardInfo Gu = am.baW().Gu(pfVar.cMC);
                            if (!(Gu == null || Gu.aZD())) {
                                agz.wnu.vWE.vWz.remove(size);
                            }
                        }
                    }
                }
                agz.wnv = jSONObject2.optString("red_dot_wording");
                agz.wnw = jSONObject2.optInt("show_red_dot", 0) == 1;
                Object optString = jSONObject2.optString("title");
                if (optString == null) {
                    optString = "";
                }
                am.bbb().putValue("key_card_entrance_tips", optString);
                agz.wnx = jSONObject2.optInt("top_scene", 100);
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(88879);
        return agz;
    }

    private static pg P(JSONObject jSONObject) {
        AppMethodBeat.i(88880);
        if (jSONObject == null) {
            ab.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            AppMethodBeat.o(88880);
            return null;
        }
        pg pgVar = new pg();
        pgVar.vWz = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(b.ITEM_LIST);
            for (int i = 0; i < jSONArray.length(); i++) {
                pf pfVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    pfVar = null;
                } else {
                    pfVar = new pf();
                    pfVar.kfO = jSONObject2.optString("announcement");
                    pfVar.cMC = jSONObject2.optString("card_id");
                    pfVar.kbZ = jSONObject2.optInt("end_time", 0);
                    pfVar.vWx = jSONObject2.optInt("update_time", 0);
                    pfVar.vWy = jSONObject2.optString("label_wording");
                }
                if (pfVar == null || (((long) pfVar.kbZ) <= bo.anT() && pfVar.kbZ != 0)) {
                    ab.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    pgVar.vWz.add(pfVar);
                }
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(88880);
        return pgVar;
    }

    public static String a(Context context, int i, CardInfo cardInfo) {
        AppMethodBeat.i(88881);
        String string;
        switch (i % 10) {
            case 0:
                string = context.getString(R.string.ai3);
                AppMethodBeat.o(88881);
                return string;
            case 1:
                string = context.getString(R.string.ai2);
                AppMethodBeat.o(88881);
                return string;
            case 2:
                string = context.getString(R.string.ai1);
                AppMethodBeat.o(88881);
                return string;
            case 3:
                string = context.getString(R.string.ai0);
                AppMethodBeat.o(88881);
                return string;
            case 4:
                string = cardInfo.field_label_wording;
                AppMethodBeat.o(88881);
                return string;
            default:
                AppMethodBeat.o(88881);
                return null;
        }
    }
}
