package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cj */
public abstract class C26304cj extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diN = "payMsgId".hashCode();
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private boolean diJ = true;
    private boolean diM = true;
    public long field_msgId;
    public String field_payMsgId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diN == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.diJ = true;
                } else if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diJ) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
