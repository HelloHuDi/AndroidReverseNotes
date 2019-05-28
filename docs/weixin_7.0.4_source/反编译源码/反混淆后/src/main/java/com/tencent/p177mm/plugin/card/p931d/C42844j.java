package com.tencent.p177mm.plugin.card.p931d;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.model.C27587c;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.protocal.protobuf.C15372pg;
import com.tencent.p177mm.protocal.protobuf.C30213ph;
import com.tencent.p177mm.protocal.protobuf.C35945pf;
import com.tencent.p177mm.protocal.protobuf.agz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.j */
public final class C42844j {
    /* renamed from: c */
    public static void m76051c(LinkedList<C35945pf> linkedList, int i) {
        AppMethodBeat.m2504i(88877);
        if (linkedList == null) {
            AppMethodBeat.m2505o(88877);
            return;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                C35945pf c35945pf = (C35945pf) linkedList.get(i3);
                C27587c baW = C42852am.baW();
                String str = c35945pf.cMC;
                int i4 = ((size - i3) * 10) + i;
                String str2 = c35945pf.kfO;
                i2 = c35945pf.kbZ;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.CardInfoStorage", "cardId null");
                } else {
                    baW.bSd.mo10108hY("UserCardInfo", "update UserCardInfo set stickyIndex=" + i4 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i2 + " where card_id='" + str + "'");
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(88877);
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m76052d(LinkedList<C35945pf> linkedList, int i) {
        AppMethodBeat.m2504i(88878);
        if (linkedList == null) {
            AppMethodBeat.m2505o(88878);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                String str;
                C35945pf c35945pf = (C35945pf) linkedList.get(i3);
                C27587c baW = C42852am.baW();
                String str2 = c35945pf.cMC;
                if (c35945pf.vWy != null) {
                    str = c35945pf.vWy;
                } else {
                    str = "";
                }
                baW.bSd.mo10108hY("UserCardInfo", "update UserCardInfo set stickyIndex=" + i + ", label_wording='" + str + "' where card_id='" + str2 + "'");
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(88878);
                return;
            }
        }
    }

    /* renamed from: Hm */
    public static agz m76048Hm(String str) {
        AppMethodBeat.m2504i(88879);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.CardStickyHelper", "jsonRet null");
            AppMethodBeat.m2505o(88879);
            return null;
        }
        agz agz = new agz();
        try {
            JSONObject jSONObject = new JSONObject(str);
            agz.wno = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                agz.wnu = new C30213ph();
                agz.wnu.vWA = C42844j.m76049P(jSONObject2.optJSONObject("expiring_list"));
                agz.wnu.vWB = C42844j.m76049P(jSONObject2.optJSONObject("member_card_list"));
                agz.wnu.vWC = C42844j.m76049P(jSONObject2.optJSONObject("nearby_list"));
                agz.wnu.vWD = C42844j.m76049P(jSONObject2.optJSONObject("label_list"));
                agz.wnu.vWE = C42844j.m76049P(jSONObject2.optJSONObject("first_list"));
                if (!(agz.wnu.vWE == null || agz.wnu.vWE.vWz == null)) {
                    for (int size = agz.wnu.vWE.vWz.size() - 1; size >= 0; size--) {
                        C35945pf c35945pf = (C35945pf) agz.wnu.vWE.vWz.get(size);
                        if (!C5046bo.isNullOrNil(c35945pf.cMC)) {
                            CardInfo Gu = C42852am.baW().mo45383Gu(c35945pf.cMC);
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
                C42852am.bbb().putValue("key_card_entrance_tips", optString);
                agz.wnx = jSONObject2.optInt("top_scene", 100);
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(88879);
        return agz;
    }

    /* renamed from: P */
    private static C15372pg m76049P(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88880);
        if (jSONObject == null) {
            C4990ab.m7420w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            AppMethodBeat.m2505o(88880);
            return null;
        }
        C15372pg c15372pg = new C15372pg();
        c15372pg.vWz = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(C8741b.ITEM_LIST);
            for (int i = 0; i < jSONArray.length(); i++) {
                C35945pf c35945pf;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    c35945pf = null;
                } else {
                    c35945pf = new C35945pf();
                    c35945pf.kfO = jSONObject2.optString("announcement");
                    c35945pf.cMC = jSONObject2.optString("card_id");
                    c35945pf.kbZ = jSONObject2.optInt("end_time", 0);
                    c35945pf.vWx = jSONObject2.optInt("update_time", 0);
                    c35945pf.vWy = jSONObject2.optString("label_wording");
                }
                if (c35945pf == null || (((long) c35945pf.kbZ) <= C5046bo.anT() && c35945pf.kbZ != 0)) {
                    C4990ab.m7416i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    c15372pg.vWz.add(c35945pf);
                }
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(88880);
        return c15372pg;
    }

    /* renamed from: a */
    public static String m76050a(Context context, int i, CardInfo cardInfo) {
        AppMethodBeat.m2504i(88881);
        String string;
        switch (i % 10) {
            case 0:
                string = context.getString(C25738R.string.ai3);
                AppMethodBeat.m2505o(88881);
                return string;
            case 1:
                string = context.getString(C25738R.string.ai2);
                AppMethodBeat.m2505o(88881);
                return string;
            case 2:
                string = context.getString(C25738R.string.ai1);
                AppMethodBeat.m2505o(88881);
                return string;
            case 3:
                string = context.getString(C25738R.string.ai0);
                AppMethodBeat.m2505o(88881);
                return string;
            case 4:
                string = cardInfo.field_label_wording;
                AppMethodBeat.m2505o(88881);
                return string;
            default:
                AppMethodBeat.m2505o(88881);
                return null;
        }
    }
}
