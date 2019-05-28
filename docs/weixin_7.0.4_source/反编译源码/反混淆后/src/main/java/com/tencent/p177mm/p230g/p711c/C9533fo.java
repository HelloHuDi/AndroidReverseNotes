package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fo */
public abstract class C9533fo extends C4925c {
    private static final int dDp = "expireTime".hashCode();
    private static final int dYu = "host".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dDh = true;
    private boolean dYt = true;
    public long field_expireTime;
    public String field_host;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dYu == hashCode) {
                    this.field_host = cursor.getString(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dYt) {
            contentValues.put("host", this.field_host);
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
