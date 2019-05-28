package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ev */
public abstract class C6577ev extends C4925c {
    private static final int dTp = "tableHash".hashCode();
    private static final int dTq = "tableSQLMD5".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dTn = true;
    private boolean dTo = true;
    public int field_tableHash;
    public String field_tableSQLMD5;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dTp == hashCode) {
                    this.field_tableHash = cursor.getInt(i);
                    this.dTn = true;
                } else if (dTq == hashCode) {
                    this.field_tableSQLMD5 = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dTn) {
            contentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
        }
        if (this.dTo) {
            contentValues.put("tableSQLMD5", this.field_tableSQLMD5);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
