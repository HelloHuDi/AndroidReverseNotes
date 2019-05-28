package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class aj extends fi {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final boolean cQg() {
        return this.field_is_reg == 1;
    }

    public final boolean cQh() {
        return this.field_is_reg == 2;
    }

    public final boolean cQi() {
        return this.field_is_reg == 0;
    }

    public final boolean cQj() {
        return this.field_is_reg == -1;
    }

    public final boolean cQk() {
        return this.field_is_open_touch == 1;
    }

    static {
        AppMethodBeat.i(46962);
        a aVar = new a();
        aVar.xDb = new Field[32];
        aVar.columns = new String[33];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.xDd.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.columns[1] = "is_reg";
        aVar.xDd.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "true_name";
        aVar.xDd.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "card_num";
        aVar.xDd.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isDomesticUser";
        aVar.xDd.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "cre_type";
        aVar.xDd.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "main_card_bind_serialno";
        aVar.xDd.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "ftf_pay_url";
        aVar.xDd.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "switchConfig";
        aVar.xDd.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reset_passwd_flag";
        aVar.xDd.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "find_passwd_url";
        aVar.xDd.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "is_open_touch";
        aVar.xDd.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "lct_wording";
        aVar.xDd.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lct_url";
        aVar.xDd.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "cre_name";
        aVar.xDd.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "lqt_state";
        aVar.xDd.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "paymenu_use_new";
        aVar.xDd.put("paymenu_use_new", "INTEGER");
        stringBuilder.append(" paymenu_use_new INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "is_show_lqb";
        aVar.xDd.put("is_show_lqb", "INTEGER");
        stringBuilder.append(" is_show_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "is_open_lqb";
        aVar.xDd.put("is_open_lqb", "INTEGER");
        stringBuilder.append(" is_open_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "lqb_open_url";
        aVar.xDd.put("lqb_open_url", "TEXT");
        stringBuilder.append(" lqb_open_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "lqt_cell_is_show";
        aVar.xDd.put("lqt_cell_is_show", "INTEGER");
        stringBuilder.append(" lqt_cell_is_show INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "lqt_cell_icon";
        aVar.xDd.put("lqt_cell_icon", "TEXT");
        stringBuilder.append(" lqt_cell_icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "lqt_cell_is_open_lqt";
        aVar.xDd.put("lqt_cell_is_open_lqt", "INTEGER");
        stringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "lqt_cell_lqt_open_url";
        aVar.xDd.put("lqt_cell_lqt_open_url", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_open_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "lqt_cell_lqt_title";
        aVar.xDd.put("lqt_cell_lqt_title", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "lqt_cell_lqt_wording";
        aVar.xDd.put("lqt_cell_lqt_wording", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "forget_passwd_url";
        aVar.xDd.put("forget_passwd_url", "TEXT");
        stringBuilder.append(" forget_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "unipay_order_state";
        aVar.xDd.put("unipay_order_state", "INTEGER");
        stringBuilder.append(" unipay_order_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "bank_priority";
        aVar.xDd.put("bank_priority", "TEXT");
        stringBuilder.append(" bank_priority TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "wallet_balance";
        aVar.xDd.put("wallet_balance", "LONG");
        stringBuilder.append(" wallet_balance LONG");
        stringBuilder.append(", ");
        aVar.columns[30] = "wallet_entrance_balance_switch_state";
        aVar.xDd.put("wallet_entrance_balance_switch_state", "INTEGER");
        stringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "soter_pay_open_type";
        aVar.xDd.put("soter_pay_open_type", "INTEGER");
        stringBuilder.append(" soter_pay_open_type INTEGER");
        aVar.columns[32] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46962);
    }
}
