package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dnF = "sortId".hashCode();
    private boolean dkE = true;
    private boolean dnC = true;
    private boolean dnD = true;
    public String field_appId;
    public long field_flag;
    public int field_sortId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnE == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dnF == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnC) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dnD) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
