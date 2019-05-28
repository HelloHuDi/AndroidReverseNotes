package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ck */
public abstract class C9524ck extends C4925c {
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

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
