package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bi */
public abstract class C6567bi extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dyB = "exptId".hashCode();
    private static final int dyG = "exptKey".hashCode();
    private boolean dyF = true;
    private boolean dyx = true;
    public int field_exptId;
    public String field_exptKey;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dyG == hashCode) {
                    this.field_exptKey = cursor.getString(i);
                    this.dyF = true;
                } else if (dyB == hashCode) {
                    this.field_exptId = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dyF) {
            contentValues.put("exptKey", this.field_exptKey);
        }
        if (this.dyx) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
