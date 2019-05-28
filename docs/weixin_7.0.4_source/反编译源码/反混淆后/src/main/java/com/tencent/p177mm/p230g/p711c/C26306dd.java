package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dd */
public abstract class C26306dd extends C4925c {
    private static final int dLK = "reqkey".hashCode();
    private static final int dLL = "ack_key".hashCode();
    private static final int dLM = "receive_time".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private boolean dLH = true;
    private boolean dLI = true;
    private boolean dLJ = true;
    private boolean diU = true;
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dLK == hashCode) {
                    this.field_reqkey = cursor.getString(i);
                    this.dLH = true;
                } else if (dLL == hashCode) {
                    this.field_ack_key = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dLM == hashCode) {
                    this.field_receive_time = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dLH) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.dLI) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dLJ) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
