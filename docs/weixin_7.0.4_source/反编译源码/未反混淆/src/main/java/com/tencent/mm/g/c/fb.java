package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb extends c {
    private static final int dIO = "tips".hashCode();
    private static final int dUT = "bindSerial".hashCode();
    private static final int dUU = "cardType".hashCode();
    private static final int dUV = "bankcardState".hashCode();
    private static final int dUW = "forbidWord".hashCode();
    private static final int dUX = "bankName".hashCode();
    private static final int dUY = "bankcardType".hashCode();
    private static final int dUZ = "bankcardTypeName".hashCode();
    private static final int dVA = "card_bottom_wording".hashCode();
    private static final int dVB = "support_lqt_turn_in".hashCode();
    private static final int dVC = "support_lqt_turn_out".hashCode();
    private static final int dVD = "is_hightlight_pre_arrive_time_wording".hashCode();
    private static final int dVE = "card_state_name".hashCode();
    private static final int dVa = "bankcardTag".hashCode();
    private static final int dVb = "bankcardTail".hashCode();
    private static final int dVc = "supportTag".hashCode();
    private static final int dVd = "mobile".hashCode();
    private static final int dVe = "trueName".hashCode();
    private static final int dVf = "bankPhone".hashCode();
    private static final int dVg = "bizUsername".hashCode();
    private static final int dVh = "onceQuotaKind".hashCode();
    private static final int dVi = "onceQuotaVirtual".hashCode();
    private static final int dVj = "dayQuotaKind".hashCode();
    private static final int dVk = "dayQuotaVirtual".hashCode();
    private static final int dVl = "fetchArriveTime".hashCode();
    private static final int dVm = "fetchArriveTimeWording".hashCode();
    private static final int dVn = "repay_url".hashCode();
    private static final int dVo = "wxcreditState".hashCode();
    private static final int dVp = "bankcardClientType".hashCode();
    private static final int dVq = "ext_msg".hashCode();
    private static final int dVr = "support_micropay".hashCode();
    private static final int dVs = "arrive_type".hashCode();
    private static final int dVt = "avail_save_wording".hashCode();
    private static final int dVu = "fetch_charge_rate".hashCode();
    private static final int dVv = "full_fetch_charge_fee".hashCode();
    private static final int dVw = "fetch_charge_info".hashCode();
    private static final int dVx = "forbid_title".hashCode();
    private static final int dVy = "forbid_url".hashCode();
    private static final int dVz = "no_micro_word".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dye = "desc".hashCode();
    private boolean dII = true;
    private boolean dUA = true;
    private boolean dUB = true;
    private boolean dUC = true;
    private boolean dUD = true;
    private boolean dUE = true;
    private boolean dUF = true;
    private boolean dUG = true;
    private boolean dUH = true;
    private boolean dUI = true;
    private boolean dUJ = true;
    private boolean dUK = true;
    private boolean dUL = true;
    private boolean dUM = true;
    private boolean dUN = true;
    private boolean dUO = true;
    private boolean dUP = true;
    private boolean dUQ = true;
    private boolean dUR = true;
    private boolean dUS = true;
    private boolean dUh = true;
    private boolean dUi = true;
    private boolean dUj = true;
    private boolean dUk = true;
    private boolean dUl = true;
    private boolean dUm = true;
    private boolean dUn = true;
    private boolean dUo = true;
    private boolean dUp = true;
    private boolean dUq = true;
    private boolean dUr = true;
    private boolean dUs = true;
    private boolean dUt = true;
    private boolean dUu = true;
    private boolean dUv = true;
    private boolean dUw = true;
    private boolean dUx = true;
    private boolean dUy = true;
    private boolean dUz = true;
    private boolean dya = true;
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public String field_card_state_name;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public int field_is_hightlight_pre_arrive_time_wording;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public int field_support_lqt_turn_in;
    public int field_support_lqt_turn_out;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dUT == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.dUh = true;
                } else if (dUU == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (dUV == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (dUW == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (dUX == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (dUY == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (dUZ == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (dVa == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (dVb == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (dVc == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (dVd == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (dVe == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (dye == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (dVf == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (dVg == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (dVh == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (dVi == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (dVj == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (dVk == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (dVl == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (dVm == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (dVn == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (dVo == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (dVp == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (dVq == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (dVr == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (dVs == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (dVt == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (dVu == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (dVv == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (dVw == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (dIO == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (dVx == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (dVy == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (dVz == hashCode) {
                    this.field_no_micro_word = cursor.getString(i);
                } else if (dVA == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i);
                } else if (dVB == hashCode) {
                    this.field_support_lqt_turn_in = cursor.getInt(i);
                } else if (dVC == hashCode) {
                    this.field_support_lqt_turn_out = cursor.getInt(i);
                } else if (dVD == hashCode) {
                    this.field_is_hightlight_pre_arrive_time_wording = cursor.getInt(i);
                } else if (dVE == hashCode) {
                    this.field_card_state_name = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dUh) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.dUi) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.dUj) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.dUk) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.dUl) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.dUm) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.dUn) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.dUo) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.dUp) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.dUq) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.dUr) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.dUs) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.dya) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.dUt) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.dUu) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.dUv) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.dUw) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.dUx) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.dUy) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.dUz) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.dUA) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.dUB) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.dUC) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.dUD) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.dUE) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.dUF) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.dUG) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.dUH) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.dUI) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.dUJ) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.dUK) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.dII) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.dUL) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.dUM) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.dUN) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.dUO) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.dUP) {
            contentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
        }
        if (this.dUQ) {
            contentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
        }
        if (this.dUR) {
            contentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
        }
        if (this.dUS) {
            contentValues.put("card_state_name", this.field_card_state_name);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
