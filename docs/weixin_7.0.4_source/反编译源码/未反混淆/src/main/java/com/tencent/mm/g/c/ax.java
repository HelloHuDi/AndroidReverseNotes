package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ax extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dvt = "bakLogId".hashCode();
    private static final int dvu = "valueStr".hashCode();
    private boolean dvr;
    private boolean dvs;
    public int field_bakLogId;
    public String field_valueStr;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dvt == hashCode) {
                    this.field_bakLogId = cursor.getInt(i);
                } else if (dvu == hashCode) {
                    this.field_valueStr = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dvr) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.dvs) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
