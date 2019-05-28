package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ff */
public abstract class C6580ff extends C4925c {
    private static final int dDu = "receiveTime".hashCode();
    private static final int dNS = "receiveStatus".hashCode();
    private static final int dWn = "mNativeUrl".hashCode();
    private static final int dWo = "hbType".hashCode();
    private static final int dWp = "receiveAmount".hashCode();
    private static final int dWq = "hbStatus".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dDm = true;
    private boolean dNQ = true;
    private boolean dWj = true;
    private boolean dWk = true;
    private boolean dWl = true;
    private boolean dWm = true;
    public int field_hbStatus;
    public int field_hbType;
    public String field_mNativeUrl;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dWn == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i);
                    this.dWj = true;
                } else if (dWo == hashCode) {
                    this.field_hbType = cursor.getInt(i);
                } else if (dWp == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i);
                } else if (dDu == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (dNS == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (dWq == hashCode) {
                    this.field_hbStatus = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dWj) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.dWk) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.dWl) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.dDm) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.dNQ) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.dWm) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
