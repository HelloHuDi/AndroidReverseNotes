package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ds;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends ds {
    public static a fjX;
    private List<b> mGC;
    private List<a> pqD;
    private List<e> pqb;

    public final a Ag() {
        return fjX;
    }

    public final List<b> cbL() {
        AppMethodBeat.i(23939);
        if (this.mGC == null) {
            this.mGC = UZ(this.field_messageListStr);
        }
        List list = this.mGC;
        AppMethodBeat.o(23939);
        return list;
    }

    public final List<e> cbM() {
        AppMethodBeat.i(23940);
        if (this.pqb == null) {
            this.pqb = UX(this.field_serviceInfoListStr);
        }
        List list = this.pqb;
        AppMethodBeat.o(23940);
        return list;
    }

    public final boolean cbN() {
        AppMethodBeat.i(23941);
        if (bo.isNullOrNil(this.field_allArticleWording)) {
            AppMethodBeat.o(23941);
            return false;
        }
        AppMethodBeat.o(23941);
        return true;
    }

    public final boolean isNormal() {
        return this.field_userRole == 1;
    }

    public final boolean cbO() {
        return this.field_showRecommendArticle == 1;
    }

    public final boolean cbP() {
        AppMethodBeat.i(23942);
        if (this.field_newBanReason == null || this.field_newBanReason.isEmpty()) {
            AppMethodBeat.o(23942);
            return false;
        }
        AppMethodBeat.o(23942);
        return true;
    }

    public final boolean cbQ() {
        return this.field_hiddenButtonBeforeFocus == 0;
    }

    public final boolean arA() {
        return this.field_hiddenAvatar == 0;
    }

    public final boolean cbR() {
        return this.field_showService == 1;
    }

    public static d a(String str, ku kuVar) {
        AppMethodBeat.i(23943);
        d dVar = new d();
        dVar.field_username = str;
        for (kv kvVar : kuVar.vKQ) {
            if (kvVar.vMU.equals("OriginalArticleCount")) {
                dVar.field_originalArticleCount = bo.getInt(kvVar.pXM, -1);
            } else if (kvVar.vMU.equals("FriendSubscribeCount")) {
                dVar.field_friendSubscribeCount = bo.getInt(kvVar.pXM, -1);
            } else if (kvVar.vMU.equals("AllArticleWording")) {
                dVar.field_allArticleWording = kvVar.pXM;
            } else if (kvVar.vMU.equals("HistoryArticlesUrl")) {
                dVar.field_historyArticlesUrl = kvVar.pXM;
            } else if (kvVar.vMU.equals("ArticleList")) {
                dVar.field_messageListStr = kvVar.pXM;
                dVar.mGC = UZ(dVar.field_messageListStr);
            } else if (kvVar.vMU.equals("BizAccountList")) {
                dVar.field_bizAccountListStr = kvVar.pXM;
                dVar.pqD = UY(dVar.field_bizAccountListStr);
            } else if (kvVar.vMU.equals("MenuInfo")) {
                dVar.field_serviceInfoListStr = kvVar.pXM;
                dVar.pqb = UX(dVar.field_serviceInfoListStr);
            } else if (kvVar.vMU.equals("UserRole")) {
                dVar.field_userRole = bo.getInt(kvVar.pXM, 0);
            } else if (kvVar.vMU.equals("BanReason")) {
                dVar.field_banReason = kvVar.pXM;
            } else if (kvVar.vMU.equals("ShowRecommendArticle")) {
                dVar.field_showRecommendArticle = bo.getInt(kvVar.pXM, 0);
            } else if (kvVar.vMU.equals("ShowMenuService")) {
                dVar.field_showService = bo.getInt(kvVar.pXM, 0);
            } else if (kvVar.vMU.equals("UserName")) {
                dVar.field_decryptUserName = kvVar.pXM;
            } else if (kvVar.vMU.equals("HiddenAvatar")) {
                dVar.field_hiddenAvatar = bo.getInt(kvVar.pXM, 0);
            } else if (kvVar.vMU.equals("HiddenButtonBeforeFocus")) {
                dVar.field_hiddenButtonBeforeFocus = bo.getInt(kvVar.pXM, 0);
            } else if (kvVar.vMU.equals("NewBanReason")) {
                dVar.field_newBanReason = kvVar.pXM;
            }
        }
        dVar.field_cacheTime = System.currentTimeMillis();
        AppMethodBeat.o(23943);
        return dVar;
    }

    private static List<e> UX(String str) {
        AppMethodBeat.i(23944);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(23944);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("button_list"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    e ai = e.ai(jSONArray.getJSONObject(i));
                    if (ai != null) {
                        arrayList.add(ai);
                    }
                }
            } catch (JSONException e) {
                ab.b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.o(23944);
        }
        return arrayList;
    }

    private static List<a> UY(String str) {
        AppMethodBeat.i(23945);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(23945);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("BizAccount"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    a ag = a.ag(jSONArray.getJSONObject(i));
                    if (ag != null) {
                        arrayList.add(ag);
                    }
                }
            } catch (JSONException e) {
                ab.b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.o(23945);
        }
        return arrayList;
    }

    private static List<b> UZ(String str) {
        AppMethodBeat.i(23946);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(23946);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("ArticleInfo"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    b ah = b.ah(jSONArray.getJSONObject(i));
                    if (ah != null) {
                        arrayList.add(ah);
                    }
                }
            } catch (JSONException e) {
                ab.b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.o(23946);
        }
        return arrayList;
    }

    static {
        AppMethodBeat.i(23947);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "originalArticleCount";
        aVar.xDd.put("originalArticleCount", "INTEGER default '1' ");
        stringBuilder.append(" originalArticleCount INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "friendSubscribeCount";
        aVar.xDd.put("friendSubscribeCount", "INTEGER default '1' ");
        stringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "allArticleWording";
        aVar.xDd.put("allArticleWording", "TEXT");
        stringBuilder.append(" allArticleWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "historyArticlesUrl";
        aVar.xDd.put("historyArticlesUrl", "TEXT");
        stringBuilder.append(" historyArticlesUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "userRole";
        aVar.xDd.put("userRole", "INTEGER default '1' ");
        stringBuilder.append(" userRole INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "banReason";
        aVar.xDd.put("banReason", "TEXT");
        stringBuilder.append(" banReason TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showRecommendArticle";
        aVar.xDd.put("showRecommendArticle", "INTEGER default '0' ");
        stringBuilder.append(" showRecommendArticle INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showService";
        aVar.xDd.put("showService", "INTEGER default '0' ");
        stringBuilder.append(" showService INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "messageListStr";
        aVar.xDd.put("messageListStr", "TEXT");
        stringBuilder.append(" messageListStr TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "serviceInfoListStr";
        aVar.xDd.put("serviceInfoListStr", "TEXT");
        stringBuilder.append(" serviceInfoListStr TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "bizAccountListStr";
        aVar.xDd.put("bizAccountListStr", "TEXT");
        stringBuilder.append(" bizAccountListStr TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "cacheTime";
        aVar.xDd.put("cacheTime", "LONG default '0' ");
        stringBuilder.append(" cacheTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "decryptUserName";
        aVar.xDd.put("decryptUserName", "TEXT default '' ");
        stringBuilder.append(" decryptUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hiddenAvatar";
        aVar.xDd.put("hiddenAvatar", "INTEGER default '0' ");
        stringBuilder.append(" hiddenAvatar INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "hiddenButtonBeforeFocus";
        aVar.xDd.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
        stringBuilder.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "newBanReason";
        aVar.xDd.put("newBanReason", "TEXT");
        stringBuilder.append(" newBanReason TEXT");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(23947);
    }
}
