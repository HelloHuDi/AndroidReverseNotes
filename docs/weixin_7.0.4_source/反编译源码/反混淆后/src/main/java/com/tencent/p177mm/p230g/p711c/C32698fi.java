package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

/* renamed from: com.tencent.mm.g.c.fi */
public abstract class C32698fi extends C4925c {
    private static final int dWh = "wallet_balance".hashCode();
    private static final int dXA = "cre_name".hashCode();
    private static final int dXB = "lqt_state".hashCode();
    private static final int dXC = "paymenu_use_new".hashCode();
    private static final int dXD = "is_show_lqb".hashCode();
    private static final int dXE = "is_open_lqb".hashCode();
    private static final int dXF = "lqb_open_url".hashCode();
    private static final int dXG = "lqt_cell_is_show".hashCode();
    private static final int dXH = "lqt_cell_icon".hashCode();
    private static final int dXI = "lqt_cell_is_open_lqt".hashCode();
    private static final int dXJ = "lqt_cell_lqt_open_url".hashCode();
    private static final int dXK = "lqt_cell_lqt_title".hashCode();
    private static final int dXL = "lqt_cell_lqt_wording".hashCode();
    private static final int dXM = "forget_passwd_url".hashCode();
    private static final int dXN = "unipay_order_state".hashCode();
    private static final int dXO = "bank_priority".hashCode();
    private static final int dXP = "wallet_entrance_balance_switch_state".hashCode();
    private static final int dXQ = "soter_pay_open_type".hashCode();
    private static final int dXm = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int dXn = "is_reg".hashCode();
    private static final int dXo = "true_name".hashCode();
    private static final int dXp = "card_num".hashCode();
    private static final int dXq = "isDomesticUser".hashCode();
    private static final int dXr = "cre_type".hashCode();
    private static final int dXs = "main_card_bind_serialno".hashCode();
    private static final int dXt = "ftf_pay_url".hashCode();
    private static final int dXu = "switchConfig".hashCode();
    private static final int dXv = "reset_passwd_flag".hashCode();
    private static final int dXw = "find_passwd_url".hashCode();
    private static final int dXx = "is_open_touch".hashCode();
    private static final int dXy = "lct_wording".hashCode();
    private static final int dXz = "lct_url".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dWH = true;
    private boolean dWI = true;
    private boolean dWJ = true;
    private boolean dWK = true;
    private boolean dWL = true;
    private boolean dWM = true;
    private boolean dWN = true;
    private boolean dWO = true;
    private boolean dWP = true;
    private boolean dWQ = true;
    private boolean dWR = true;
    private boolean dWS = true;
    private boolean dWT = true;
    private boolean dWU = true;
    private boolean dWV = true;
    private boolean dWW = true;
    private boolean dWX = true;
    private boolean dWY = true;
    private boolean dWZ = true;
    private boolean dWb = true;
    private boolean dXa = true;
    private boolean dXb = true;
    private boolean dXc = true;
    private boolean dXd = true;
    private boolean dXe = true;
    private boolean dXf = true;
    private boolean dXg = true;
    private boolean dXh = true;
    private boolean dXi = true;
    private boolean dXj = true;
    private boolean dXk = true;
    private boolean dXl = true;
    public String field_bank_priority;
    public int field_card_num;
    public String field_cre_name;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_forget_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_lqb;
    public int field_is_open_touch;
    public int field_is_reg;
    public int field_is_show_lqb;
    public String field_lct_url;
    public String field_lct_wording;
    public String field_lqb_open_url;
    public String field_lqt_cell_icon;
    public int field_lqt_cell_is_open_lqt;
    public int field_lqt_cell_is_show;
    public String field_lqt_cell_lqt_open_url;
    public String field_lqt_cell_lqt_title;
    public String field_lqt_cell_lqt_wording;
    public int field_lqt_state;
    public String field_main_card_bind_serialno;
    public int field_paymenu_use_new;
    public String field_reset_passwd_flag;
    public int field_soter_pay_open_type;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;
    public int field_unipay_order_state;
    public long field_wallet_balance;
    public int field_wallet_entrance_balance_switch_state;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dXm == hashCode) {
                    this.field_uin = cursor.getString(i);
                    this.dWH = true;
                } else if (dXn == hashCode) {
                    this.field_is_reg = cursor.getInt(i);
                } else if (dXo == hashCode) {
                    this.field_true_name = cursor.getString(i);
                } else if (dXp == hashCode) {
                    this.field_card_num = cursor.getInt(i);
                } else if (dXq == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i) != 0;
                } else if (dXr == hashCode) {
                    this.field_cre_type = cursor.getInt(i);
                } else if (dXs == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i);
                } else if (dXt == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i);
                } else if (dXu == hashCode) {
                    this.field_switchConfig = cursor.getInt(i);
                } else if (dXv == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i);
                } else if (dXw == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i);
                } else if (dXx == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i);
                } else if (dXy == hashCode) {
                    this.field_lct_wording = cursor.getString(i);
                } else if (dXz == hashCode) {
                    this.field_lct_url = cursor.getString(i);
                } else if (dXA == hashCode) {
                    this.field_cre_name = cursor.getString(i);
                } else if (dXB == hashCode) {
                    this.field_lqt_state = cursor.getInt(i);
                } else if (dXC == hashCode) {
                    this.field_paymenu_use_new = cursor.getInt(i);
                } else if (dXD == hashCode) {
                    this.field_is_show_lqb = cursor.getInt(i);
                } else if (dXE == hashCode) {
                    this.field_is_open_lqb = cursor.getInt(i);
                } else if (dXF == hashCode) {
                    this.field_lqb_open_url = cursor.getString(i);
                } else if (dXG == hashCode) {
                    this.field_lqt_cell_is_show = cursor.getInt(i);
                } else if (dXH == hashCode) {
                    this.field_lqt_cell_icon = cursor.getString(i);
                } else if (dXI == hashCode) {
                    this.field_lqt_cell_is_open_lqt = cursor.getInt(i);
                } else if (dXJ == hashCode) {
                    this.field_lqt_cell_lqt_open_url = cursor.getString(i);
                } else if (dXK == hashCode) {
                    this.field_lqt_cell_lqt_title = cursor.getString(i);
                } else if (dXL == hashCode) {
                    this.field_lqt_cell_lqt_wording = cursor.getString(i);
                } else if (dXM == hashCode) {
                    this.field_forget_passwd_url = cursor.getString(i);
                } else if (dXN == hashCode) {
                    this.field_unipay_order_state = cursor.getInt(i);
                } else if (dXO == hashCode) {
                    this.field_bank_priority = cursor.getString(i);
                } else if (dWh == hashCode) {
                    this.field_wallet_balance = cursor.getLong(i);
                } else if (dXP == hashCode) {
                    this.field_wallet_entrance_balance_switch_state = cursor.getInt(i);
                } else if (dXQ == hashCode) {
                    this.field_soter_pay_open_type = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dWH) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.dWI) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.dWJ) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.dWK) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.dWL) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.dWM) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.dWN) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.dWO) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.dWP) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.dWQ) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.dWR) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.dWS) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.dWT) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.dWU) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.dWV) {
            contentValues.put("cre_name", this.field_cre_name);
        }
        if (this.dWW) {
            contentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
        }
        if (this.dWX) {
            contentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
        }
        if (this.dWY) {
            contentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
        }
        if (this.dWZ) {
            contentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
        }
        if (this.dXa) {
            contentValues.put("lqb_open_url", this.field_lqb_open_url);
        }
        if (this.dXb) {
            contentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
        }
        if (this.dXc) {
            contentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
        }
        if (this.dXd) {
            contentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
        }
        if (this.dXe) {
            contentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
        }
        if (this.dXf) {
            contentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
        }
        if (this.dXg) {
            contentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
        }
        if (this.dXh) {
            contentValues.put("forget_passwd_url", this.field_forget_passwd_url);
        }
        if (this.dXi) {
            contentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
        }
        if (this.dXj) {
            contentValues.put("bank_priority", this.field_bank_priority);
        }
        if (this.dWb) {
            contentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
        }
        if (this.dXk) {
            contentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
        }
        if (this.dXl) {
            contentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
