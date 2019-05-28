package com.tencent.p177mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.k */
public final class C20155k extends C7563j<ShareCardInfo> {
    public static final String[] fnj = new String[]{C7563j.m13217a(ShareCardInfo.ccO, "ShareCardInfo")};
    public C4927e bSd;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.model.k$1 */
    public static /* synthetic */ class C201561 {
        public static final /* synthetic */ int[] kdd = new int[C11290a.values().length];

        static {
            AppMethodBeat.m2504i(88073);
            try {
                kdd[C11290a.NORMAL_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kdd[C11290a.INVALID_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kdd[C11290a.CAN_GIFT_TYPE.ordinal()] = 3;
                AppMethodBeat.m2505o(88073);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(88073);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(88083);
        AppMethodBeat.m2505o(88083);
    }

    /* renamed from: sT */
    public static String m31174sT(int i) {
        AppMethodBeat.m2504i(88074);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList sQ = C42856b.m76087sQ(i);
        String str;
        if (sQ == null || sQ.size() <= 0) {
            str = "";
            AppMethodBeat.m2505o(88074);
            return str;
        }
        stringBuilder.append(" (");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < sQ.size()) {
                if (i3 != 0) {
                    stringBuilder.append(" OR ");
                }
                stringBuilder.append("card_id").append(" = '" + ((String) sQ.get(i3)) + "' ");
                i2 = i3 + 1;
            } else {
                stringBuilder.append(") AND ");
                str = stringBuilder.toString();
                AppMethodBeat.m2505o(88074);
                return str;
            }
        }
    }

    public C20155k(C4927e c4927e) {
        super(c4927e, ShareCardInfo.ccO, "ShareCardInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: GG */
    public final ArrayList<String> mo35393GG(String str) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.m2504i(88075);
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), limit is 99");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 99");
        Cursor a = this.bSd.mo10104a("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
            AppMethodBeat.m2505o(88075);
        } else {
            int columnIndex = a.getColumnIndex("from_username");
            if (columnIndex == -1) {
                C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                a.close();
                AppMethodBeat.m2505o(88075);
            } else {
                arrayList = new ArrayList();
                while (a.moveToNext()) {
                    String string = a.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        C4990ab.m7412e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is ".concat(String.valueOf(str)));
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                a.close();
                AppMethodBeat.m2505o(88075);
            }
        }
        return arrayList;
    }

    /* renamed from: GH */
    public final int mo35394GH(String str) {
        int i = 0;
        AppMethodBeat.m2504i(88076);
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor a = this.bSd.mo10104a("select count(*) from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
            AppMethodBeat.m2505o(88076);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(88076);
        }
        return i;
    }

    /* renamed from: GI */
    public final String mo35395GI(String str) {
        AppMethodBeat.m2504i(88077);
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor a = this.bSd.mo10104a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        String str2;
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            str2 = "";
            AppMethodBeat.m2505o(88077);
            return str2;
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            a.close();
            str2 = "";
            AppMethodBeat.m2505o(88077);
            return str2;
        }
        str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(columnIndex);
        }
        a.close();
        AppMethodBeat.m2505o(88077);
        return str2;
    }

    /* renamed from: dq */
    public final String mo35399dq(String str, String str2) {
        AppMethodBeat.m2504i(88078);
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor a = this.bSd.mo10104a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        String str3;
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            str3 = "";
            AppMethodBeat.m2505o(88078);
            return str3;
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            a.close();
            str3 = "";
            AppMethodBeat.m2505o(88078);
            return str3;
        }
        str3 = "";
        while (a.moveToNext()) {
            str3 = a.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
        }
        a.close();
        AppMethodBeat.m2505o(88078);
        return str3;
    }

    /* renamed from: sU */
    public final boolean mo35400sU(int i) {
        AppMethodBeat.m2504i(88079);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean hY = this.bSd.mo10108hY("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (hY ? 1 : 0));
        AppMethodBeat.m2505o(88079);
        return hY;
    }

    /* renamed from: N */
    public final boolean mo35398N(String str, int i, int i2) {
        AppMethodBeat.m2504i(88080);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean hY = this.bSd.mo10108hY("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (hY ? 1 : 0));
        AppMethodBeat.m2505o(88080);
        return hY;
    }

    /* renamed from: GJ */
    public final void mo35396GJ(String str) {
        AppMethodBeat.m2504i(88081);
        this.bSd.mo10108hY("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
        AppMethodBeat.m2505o(88081);
    }

    /* renamed from: GK */
    public final ShareCardInfo mo35397GK(String str) {
        AppMethodBeat.m2504i(88082);
        C4925c shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        if (super.mo10102b(shareCardInfo, new String[0])) {
            AppMethodBeat.m2505o(88082);
            return shareCardInfo;
        }
        AppMethodBeat.m2505o(88082);
        return null;
    }
}
