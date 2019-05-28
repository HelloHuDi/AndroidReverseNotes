package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class k extends j<ShareCardInfo> {
    public static final String[] fnj = new String[]{j.a(ShareCardInfo.ccO, "ShareCardInfo")};
    public e bSd;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.model.k$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kdd = new int[a.values().length];

        static {
            AppMethodBeat.i(88073);
            try {
                kdd[a.NORMAL_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kdd[a.INVALID_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kdd[a.CAN_GIFT_TYPE.ordinal()] = 3;
                AppMethodBeat.o(88073);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(88073);
            }
        }
    }

    static {
        AppMethodBeat.i(88083);
        AppMethodBeat.o(88083);
    }

    public static String sT(int i) {
        AppMethodBeat.i(88074);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList sQ = b.sQ(i);
        String str;
        if (sQ == null || sQ.size() <= 0) {
            str = "";
            AppMethodBeat.o(88074);
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
                AppMethodBeat.o(88074);
                return str;
            }
        }
    }

    public k(e eVar) {
        super(eVar, ShareCardInfo.ccO, "ShareCardInfo", null);
        this.bSd = eVar;
    }

    public final ArrayList<String> GG(String str) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(88075);
        ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), limit is 99");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 99");
        Cursor a = this.bSd.a("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
            AppMethodBeat.o(88075);
        } else {
            int columnIndex = a.getColumnIndex("from_username");
            if (columnIndex == -1) {
                ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                a.close();
                AppMethodBeat.o(88075);
            } else {
                arrayList = new ArrayList();
                while (a.moveToNext()) {
                    String string = a.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        ab.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is ".concat(String.valueOf(str)));
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                a.close();
                AppMethodBeat.o(88075);
            }
        }
        return arrayList;
    }

    public final int GH(String str) {
        int i = 0;
        AppMethodBeat.i(88076);
        ab.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor a = this.bSd.a("select count(*) from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            ab.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
            AppMethodBeat.o(88076);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(88076);
        }
        return i;
    }

    public final String GI(String str) {
        AppMethodBeat.i(88077);
        ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor a = this.bSd.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        String str2;
        if (a == null) {
            ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            str2 = "";
            AppMethodBeat.o(88077);
            return str2;
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            a.close();
            str2 = "";
            AppMethodBeat.o(88077);
            return str2;
        }
        str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(columnIndex);
        }
        a.close();
        AppMethodBeat.o(88077);
        return str2;
    }

    public final String dq(String str, String str2) {
        AppMethodBeat.i(88078);
        ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor a = this.bSd.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        String str3;
        if (a == null) {
            ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            str3 = "";
            AppMethodBeat.o(88078);
            return str3;
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            a.close();
            str3 = "";
            AppMethodBeat.o(88078);
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
        AppMethodBeat.o(88078);
        return str3;
    }

    public final boolean sU(int i) {
        AppMethodBeat.i(88079);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean hY = this.bSd.hY("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        ab.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (hY ? 1 : 0));
        AppMethodBeat.o(88079);
        return hY;
    }

    public final boolean N(String str, int i, int i2) {
        AppMethodBeat.i(88080);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean hY = this.bSd.hY("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        ab.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (hY ? 1 : 0));
        AppMethodBeat.o(88080);
        return hY;
    }

    public final void GJ(String str) {
        AppMethodBeat.i(88081);
        this.bSd.hY("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
        AppMethodBeat.o(88081);
    }

    public final ShareCardInfo GK(String str) {
        AppMethodBeat.i(88082);
        c shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        if (super.b(shareCardInfo, new String[0])) {
            AppMethodBeat.o(88082);
            return shareCardInfo;
        }
        AppMethodBeat.o(88082);
        return null;
    }
}
