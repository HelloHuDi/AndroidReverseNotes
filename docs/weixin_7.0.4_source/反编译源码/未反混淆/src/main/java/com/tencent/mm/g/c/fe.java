package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe extends c {
    private static final int dWd = "wallet_tpa_country".hashCode();
    private static final int dWe = "wallet_type".hashCode();
    private static final int dWf = "wallet_name".hashCode();
    private static final int dWg = "wallet_selected".hashCode();
    private static final int dWh = "wallet_balance".hashCode();
    private static final int dWi = "wallet_tpa_country_mask".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dVX = true;
    private boolean dVY = true;
    private boolean dVZ = true;
    private boolean dWa = true;
    private boolean dWb = true;
    private boolean dWc = true;
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dWd == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.dVX = true;
                } else if (dWe == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (dWf == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (dWg == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (dWh == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (dWi == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dVX) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.dVY) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.dVZ) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.dWa) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.dWb) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.dWc) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
