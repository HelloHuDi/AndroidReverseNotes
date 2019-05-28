package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6579fe;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.aa */
public final class C22582aa extends C6579fe {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: aD */
    public static C22582aa m34273aD(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46910);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletKindInfo", "json is null");
            AppMethodBeat.m2505o(46910);
            return null;
        }
        C22582aa c22582aa = new C22582aa();
        c22582aa.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        c22582aa.field_wallet_name = jSONObject.optString("wallet_name");
        c22582aa.field_wallet_selected = jSONObject.optInt("wallet_selected");
        c22582aa.field_wallet_type = jSONObject.optInt("wallet_type");
        c22582aa.field_wallet_balance = jSONObject.optInt("wallet_balance");
        c22582aa.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (C5046bo.isNullOrNil(c22582aa.field_wallet_tpa_country)) {
            C4990ab.m7412e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
            AppMethodBeat.m2505o(46910);
            return null;
        }
        AppMethodBeat.m2505o(46910);
        return c22582aa;
    }

    static {
        AppMethodBeat.m2504i(46911);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "wallet_tpa_country";
        c4924a.xDd.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "wallet_tpa_country";
        c4924a.columns[1] = "wallet_type";
        c4924a.xDd.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "wallet_name";
        c4924a.xDd.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "wallet_selected";
        c4924a.xDd.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "wallet_balance";
        c4924a.xDd.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "wallet_tpa_country_mask";
        c4924a.xDd.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46911);
    }
}
