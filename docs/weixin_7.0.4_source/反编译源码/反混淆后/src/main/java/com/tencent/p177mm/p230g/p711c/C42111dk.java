package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dk */
public abstract class C42111dk extends C4925c {
    private static final int dDb = "retryCount".hashCode();
    private static final int dMo = "cardUserId".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dCI = true;
    private boolean dMn = true;
    public String field_cardUserId;
    public int field_retryCount;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dMo == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.dMn = true;
                } else if (dDb == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dMn) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.dCI) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
