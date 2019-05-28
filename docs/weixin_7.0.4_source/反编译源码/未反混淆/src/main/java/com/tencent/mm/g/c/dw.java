package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw extends c {
    private static final int dNR = "locaMsgId".hashCode();
    private static final int dNS = "receiveStatus".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dvo = "transferId".hashCode();
    private boolean dNP = true;
    private boolean dNQ = true;
    private boolean doh = true;
    private boolean dvn = true;
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_transferId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dvo == hashCode) {
                    this.field_transferId = cursor.getString(i);
                    this.dvn = true;
                } else if (dNR == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i);
                } else if (dNS == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dvn) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.dNP) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.dNQ) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.doh) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
