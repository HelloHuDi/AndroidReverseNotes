package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck extends c {
    private static final int dFP = "wechatUsername".hashCode();
    private static final int dFQ = "systemAddressBookUsername".hashCode();
    private static final int dFR = "contactId".hashCode();
    private static final int dFS = "sortKey".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dFL = true;
    private boolean dFM = true;
    private boolean dFN = true;
    private boolean dFO = true;
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dFP == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (dFQ == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (dFR == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (dFS == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFL) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.dFM) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.dFN) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.dFO) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
