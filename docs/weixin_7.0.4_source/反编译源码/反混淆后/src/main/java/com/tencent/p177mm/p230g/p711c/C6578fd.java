package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fd */
public abstract class C6578fd extends C4925c {
    private static final int dVR = "wallet_region".hashCode();
    private static final int dVS = "function_list".hashCode();
    private static final int dVT = "new_list".hashCode();
    private static final int dVU = "banner_list".hashCode();
    private static final int dVV = "type_name_list".hashCode();
    private static final int dVW = "isShowSetting".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dVL = true;
    private boolean dVM = true;
    private boolean dVN = true;
    private boolean dVO = true;
    private boolean dVP = true;
    private boolean dVQ = true;
    public String field_banner_list;
    public String field_function_list;
    public int field_isShowSetting;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dVR == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.dVL = true;
                } else if (dVS == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (dVT == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (dVU == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (dVV == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
                } else if (dVW == hashCode) {
                    this.field_isShowSetting = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dVL) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.dVM) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.dVN) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.dVO) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.dVP) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.dVQ) {
            contentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
