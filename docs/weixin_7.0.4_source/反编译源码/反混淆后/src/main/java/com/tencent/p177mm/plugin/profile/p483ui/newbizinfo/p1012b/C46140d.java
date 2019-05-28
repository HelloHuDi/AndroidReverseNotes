package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37846ds;
import com.tencent.p177mm.protocal.protobuf.C40540ku;
import com.tencent.p177mm.protocal.protobuf.C46560kv;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.d */
public final class C46140d extends C37846ds {
    public static C4924a fjX;
    private List<C12865b> mGC;
    private List<C28704a> pqD;
    private List<C39530e> pqb;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    public final List<C12865b> cbL() {
        AppMethodBeat.m2504i(23939);
        if (this.mGC == null) {
            this.mGC = C46140d.m86123UZ(this.field_messageListStr);
        }
        List list = this.mGC;
        AppMethodBeat.m2505o(23939);
        return list;
    }

    public final List<C39530e> cbM() {
        AppMethodBeat.m2504i(23940);
        if (this.pqb == null) {
            this.pqb = C46140d.m86121UX(this.field_serviceInfoListStr);
        }
        List list = this.pqb;
        AppMethodBeat.m2505o(23940);
        return list;
    }

    public final boolean cbN() {
        AppMethodBeat.m2504i(23941);
        if (C5046bo.isNullOrNil(this.field_allArticleWording)) {
            AppMethodBeat.m2505o(23941);
            return false;
        }
        AppMethodBeat.m2505o(23941);
        return true;
    }

    public final boolean isNormal() {
        return this.field_userRole == 1;
    }

    public final boolean cbO() {
        return this.field_showRecommendArticle == 1;
    }

    public final boolean cbP() {
        AppMethodBeat.m2504i(23942);
        if (this.field_newBanReason == null || this.field_newBanReason.isEmpty()) {
            AppMethodBeat.m2505o(23942);
            return false;
        }
        AppMethodBeat.m2505o(23942);
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

    /* renamed from: a */
    public static C46140d m86124a(String str, C40540ku c40540ku) {
        AppMethodBeat.m2504i(23943);
        C46140d c46140d = new C46140d();
        c46140d.field_username = str;
        for (C46560kv c46560kv : c40540ku.vKQ) {
            if (c46560kv.vMU.equals("OriginalArticleCount")) {
                c46140d.field_originalArticleCount = C5046bo.getInt(c46560kv.pXM, -1);
            } else if (c46560kv.vMU.equals("FriendSubscribeCount")) {
                c46140d.field_friendSubscribeCount = C5046bo.getInt(c46560kv.pXM, -1);
            } else if (c46560kv.vMU.equals("AllArticleWording")) {
                c46140d.field_allArticleWording = c46560kv.pXM;
            } else if (c46560kv.vMU.equals("HistoryArticlesUrl")) {
                c46140d.field_historyArticlesUrl = c46560kv.pXM;
            } else if (c46560kv.vMU.equals("ArticleList")) {
                c46140d.field_messageListStr = c46560kv.pXM;
                c46140d.mGC = C46140d.m86123UZ(c46140d.field_messageListStr);
            } else if (c46560kv.vMU.equals("BizAccountList")) {
                c46140d.field_bizAccountListStr = c46560kv.pXM;
                c46140d.pqD = C46140d.m86122UY(c46140d.field_bizAccountListStr);
            } else if (c46560kv.vMU.equals("MenuInfo")) {
                c46140d.field_serviceInfoListStr = c46560kv.pXM;
                c46140d.pqb = C46140d.m86121UX(c46140d.field_serviceInfoListStr);
            } else if (c46560kv.vMU.equals("UserRole")) {
                c46140d.field_userRole = C5046bo.getInt(c46560kv.pXM, 0);
            } else if (c46560kv.vMU.equals("BanReason")) {
                c46140d.field_banReason = c46560kv.pXM;
            } else if (c46560kv.vMU.equals("ShowRecommendArticle")) {
                c46140d.field_showRecommendArticle = C5046bo.getInt(c46560kv.pXM, 0);
            } else if (c46560kv.vMU.equals("ShowMenuService")) {
                c46140d.field_showService = C5046bo.getInt(c46560kv.pXM, 0);
            } else if (c46560kv.vMU.equals("UserName")) {
                c46140d.field_decryptUserName = c46560kv.pXM;
            } else if (c46560kv.vMU.equals("HiddenAvatar")) {
                c46140d.field_hiddenAvatar = C5046bo.getInt(c46560kv.pXM, 0);
            } else if (c46560kv.vMU.equals("HiddenButtonBeforeFocus")) {
                c46140d.field_hiddenButtonBeforeFocus = C5046bo.getInt(c46560kv.pXM, 0);
            } else if (c46560kv.vMU.equals("NewBanReason")) {
                c46140d.field_newBanReason = c46560kv.pXM;
            }
        }
        c46140d.field_cacheTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(23943);
        return c46140d;
    }

    /* renamed from: UX */
    private static List<C39530e> m86121UX(String str) {
        AppMethodBeat.m2504i(23944);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(23944);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("button_list"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    C39530e ai = C39530e.m67547ai(jSONArray.getJSONObject(i));
                    if (ai != null) {
                        arrayList.add(ai);
                    }
                }
            } catch (JSONException e) {
                C4990ab.m7408b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.m2505o(23944);
        }
        return arrayList;
    }

    /* renamed from: UY */
    private static List<C28704a> m86122UY(String str) {
        AppMethodBeat.m2504i(23945);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(23945);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("BizAccount"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    C28704a ag = C28704a.m45602ag(jSONArray.getJSONObject(i));
                    if (ag != null) {
                        arrayList.add(ag);
                    }
                }
            } catch (JSONException e) {
                C4990ab.m7408b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.m2505o(23945);
        }
        return arrayList;
    }

    /* renamed from: UZ */
    private static List<C12865b> m86123UZ(String str) {
        AppMethodBeat.m2504i(23946);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(23946);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("ArticleInfo"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    C12865b ah = C12865b.m20857ah(jSONArray.getJSONObject(i));
                    if (ah != null) {
                        arrayList.add(ah);
                    }
                }
            } catch (JSONException e) {
                C4990ab.m7408b("MicroMsg.ProfileInfo", "", e);
            }
            AppMethodBeat.m2505o(23946);
        }
        return arrayList;
    }

    static {
        AppMethodBeat.m2504i(23947);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "originalArticleCount";
        c4924a.xDd.put("originalArticleCount", "INTEGER default '1' ");
        stringBuilder.append(" originalArticleCount INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "friendSubscribeCount";
        c4924a.xDd.put("friendSubscribeCount", "INTEGER default '1' ");
        stringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "allArticleWording";
        c4924a.xDd.put("allArticleWording", "TEXT");
        stringBuilder.append(" allArticleWording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "historyArticlesUrl";
        c4924a.xDd.put("historyArticlesUrl", "TEXT");
        stringBuilder.append(" historyArticlesUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "userRole";
        c4924a.xDd.put("userRole", "INTEGER default '1' ");
        stringBuilder.append(" userRole INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "banReason";
        c4924a.xDd.put("banReason", "TEXT");
        stringBuilder.append(" banReason TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "showRecommendArticle";
        c4924a.xDd.put("showRecommendArticle", "INTEGER default '0' ");
        stringBuilder.append(" showRecommendArticle INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "showService";
        c4924a.xDd.put("showService", "INTEGER default '0' ");
        stringBuilder.append(" showService INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "messageListStr";
        c4924a.xDd.put("messageListStr", "TEXT");
        stringBuilder.append(" messageListStr TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "serviceInfoListStr";
        c4924a.xDd.put("serviceInfoListStr", "TEXT");
        stringBuilder.append(" serviceInfoListStr TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "bizAccountListStr";
        c4924a.xDd.put("bizAccountListStr", "TEXT");
        stringBuilder.append(" bizAccountListStr TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "cacheTime";
        c4924a.xDd.put("cacheTime", "LONG default '0' ");
        stringBuilder.append(" cacheTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "decryptUserName";
        c4924a.xDd.put("decryptUserName", "TEXT default '' ");
        stringBuilder.append(" decryptUserName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "hiddenAvatar";
        c4924a.xDd.put("hiddenAvatar", "INTEGER default '0' ");
        stringBuilder.append(" hiddenAvatar INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "hiddenButtonBeforeFocus";
        c4924a.xDd.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
        stringBuilder.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "newBanReason";
        c4924a.xDd.put("newBanReason", "TEXT");
        stringBuilder.append(" newBanReason TEXT");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(23947);
    }
}
