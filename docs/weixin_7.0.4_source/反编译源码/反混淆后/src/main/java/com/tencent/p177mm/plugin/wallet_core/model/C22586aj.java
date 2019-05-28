package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32698fi;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.aj */
public final class C22586aj extends C32698fi {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
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
        AppMethodBeat.m2504i(46962);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[32];
        c4924a.columns = new String[33];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        c4924a.xDd.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = OpenSDKTool4Assistant.EXTRA_UIN;
        c4924a.columns[1] = "is_reg";
        c4924a.xDd.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "true_name";
        c4924a.xDd.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "card_num";
        c4924a.xDd.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "isDomesticUser";
        c4924a.xDd.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "cre_type";
        c4924a.xDd.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "main_card_bind_serialno";
        c4924a.xDd.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "ftf_pay_url";
        c4924a.xDd.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "switchConfig";
        c4924a.xDd.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "reset_passwd_flag";
        c4924a.xDd.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "find_passwd_url";
        c4924a.xDd.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "is_open_touch";
        c4924a.xDd.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "lct_wording";
        c4924a.xDd.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "lct_url";
        c4924a.xDd.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "cre_name";
        c4924a.xDd.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "lqt_state";
        c4924a.xDd.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[16] = "paymenu_use_new";
        c4924a.xDd.put("paymenu_use_new", "INTEGER");
        stringBuilder.append(" paymenu_use_new INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "is_show_lqb";
        c4924a.xDd.put("is_show_lqb", "INTEGER");
        stringBuilder.append(" is_show_lqb INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[18] = "is_open_lqb";
        c4924a.xDd.put("is_open_lqb", "INTEGER");
        stringBuilder.append(" is_open_lqb INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[19] = "lqb_open_url";
        c4924a.xDd.put("lqb_open_url", "TEXT");
        stringBuilder.append(" lqb_open_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[20] = "lqt_cell_is_show";
        c4924a.xDd.put("lqt_cell_is_show", "INTEGER");
        stringBuilder.append(" lqt_cell_is_show INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[21] = "lqt_cell_icon";
        c4924a.xDd.put("lqt_cell_icon", "TEXT");
        stringBuilder.append(" lqt_cell_icon TEXT");
        stringBuilder.append(", ");
        c4924a.columns[22] = "lqt_cell_is_open_lqt";
        c4924a.xDd.put("lqt_cell_is_open_lqt", "INTEGER");
        stringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[23] = "lqt_cell_lqt_open_url";
        c4924a.xDd.put("lqt_cell_lqt_open_url", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_open_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[24] = "lqt_cell_lqt_title";
        c4924a.xDd.put("lqt_cell_lqt_title", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[25] = "lqt_cell_lqt_wording";
        c4924a.xDd.put("lqt_cell_lqt_wording", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[26] = "forget_passwd_url";
        c4924a.xDd.put("forget_passwd_url", "TEXT");
        stringBuilder.append(" forget_passwd_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[27] = "unipay_order_state";
        c4924a.xDd.put("unipay_order_state", "INTEGER");
        stringBuilder.append(" unipay_order_state INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[28] = "bank_priority";
        c4924a.xDd.put("bank_priority", "TEXT");
        stringBuilder.append(" bank_priority TEXT");
        stringBuilder.append(", ");
        c4924a.columns[29] = "wallet_balance";
        c4924a.xDd.put("wallet_balance", "LONG");
        stringBuilder.append(" wallet_balance LONG");
        stringBuilder.append(", ");
        c4924a.columns[30] = "wallet_entrance_balance_switch_state";
        c4924a.xDd.put("wallet_entrance_balance_switch_state", "INTEGER");
        stringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[31] = "soter_pay_open_type";
        c4924a.xDd.put("soter_pay_open_type", "INTEGER");
        stringBuilder.append(" soter_pay_open_type INTEGER");
        c4924a.columns[32] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46962);
    }
}
