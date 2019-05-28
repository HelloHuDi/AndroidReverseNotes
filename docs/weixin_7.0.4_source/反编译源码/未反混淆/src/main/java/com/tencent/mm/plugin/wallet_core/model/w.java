package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fd;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class w extends fd {
    public static a ccO;
    public ArrayList<MallFunction> okP = new ArrayList();
    private ArrayList<MallNews> okQ = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> okR = new ArrayList();
    public SparseArray<String> okS = new SparseArray();

    public w() {
        AppMethodBeat.i(46897);
        AppMethodBeat.o(46897);
    }

    public final a Ag() {
        return ccO;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(46898);
        super.d(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!bo.isNullOrNil(str)) {
                this.okP = b.F(new JSONArray(str));
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!bo.isNullOrNil(str2)) {
                this.okQ = b.C(new JSONArray(str2));
            }
        } catch (Exception e2) {
            this.okQ = null;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!bo.isNullOrNil(str3)) {
                this.okR = b.D(new JSONArray(str3));
            }
        } catch (Exception e22) {
            this.okR = null;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!bo.isNullOrNil(str4)) {
                this.okS = b.E(new JSONArray(str4));
            }
            AppMethodBeat.o(46898);
        } catch (Exception e222) {
            this.okS = null;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
            AppMethodBeat.o(46898);
        }
    }

    static {
        AppMethodBeat.i(46899);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xDd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "wallet_region";
        aVar.columns[1] = "function_list";
        aVar.xDd.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "new_list";
        aVar.xDd.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "banner_list";
        aVar.xDd.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "type_name_list";
        aVar.xDd.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "isShowSetting";
        aVar.xDd.put("isShowSetting", "INTEGER");
        stringBuilder.append(" isShowSetting INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46899);
    }
}
