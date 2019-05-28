package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fe;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class aa extends fe {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public static aa aD(JSONObject jSONObject) {
        AppMethodBeat.i(46910);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletKindInfo", "json is null");
            AppMethodBeat.o(46910);
            return null;
        }
        aa aaVar = new aa();
        aaVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        aaVar.field_wallet_name = jSONObject.optString("wallet_name");
        aaVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        aaVar.field_wallet_type = jSONObject.optInt("wallet_type");
        aaVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        aaVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (bo.isNullOrNil(aaVar.field_wallet_tpa_country)) {
            ab.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
            AppMethodBeat.o(46910);
            return null;
        }
        AppMethodBeat.o(46910);
        return aaVar;
    }

    static {
        AppMethodBeat.i(46911);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_tpa_country";
        aVar.xDd.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "wallet_tpa_country";
        aVar.columns[1] = "wallet_type";
        aVar.xDd.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "wallet_name";
        aVar.xDd.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wallet_selected";
        aVar.xDd.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wallet_balance";
        aVar.xDd.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wallet_tpa_country_mask";
        aVar.xDd.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46911);
    }
}
