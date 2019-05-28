package com.tencent.p177mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6578fd;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C14237a;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C29636b;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.w */
public final class C35482w extends C6578fd {
    public static C4924a ccO;
    public ArrayList<MallFunction> okP = new ArrayList();
    private ArrayList<MallNews> okQ = new ArrayList();
    private ArrayList<C14237a> okR = new ArrayList();
    public SparseArray<String> okS = new SparseArray();

    public C35482w() {
        AppMethodBeat.m2504i(46897);
        AppMethodBeat.m2505o(46897);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(46898);
        super.mo8995d(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!C5046bo.isNullOrNil(str)) {
                this.okP = C29636b.m47008F(new JSONArray(str));
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!C5046bo.isNullOrNil(str2)) {
                this.okQ = C29636b.m47005C(new JSONArray(str2));
            }
        } catch (Exception e2) {
            this.okQ = null;
            C4990ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!C5046bo.isNullOrNil(str3)) {
                this.okR = C29636b.m47006D(new JSONArray(str3));
            }
        } catch (Exception e22) {
            this.okR = null;
            C4990ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!C5046bo.isNullOrNil(str4)) {
                this.okS = C29636b.m47007E(new JSONArray(str4));
            }
            AppMethodBeat.m2505o(46898);
        } catch (Exception e222) {
            this.okS = null;
            C4990ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
            AppMethodBeat.m2505o(46898);
        }
    }

    static {
        AppMethodBeat.m2504i(46899);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "wallet_region";
        c4924a.xDd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "wallet_region";
        c4924a.columns[1] = "function_list";
        c4924a.xDd.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "new_list";
        c4924a.xDd.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "banner_list";
        c4924a.xDd.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "type_name_list";
        c4924a.xDd.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isShowSetting";
        c4924a.xDd.put("isShowSetting", "INTEGER");
        stringBuilder.append(" isShowSetting INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46899);
    }
}
