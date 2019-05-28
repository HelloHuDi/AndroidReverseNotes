package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ab extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int doX = "userId".hashCode();
    private static final int dol = "brandUserName".hashCode();
    private boolean dnX = true;
    private boolean doW = true;
    public String field_brandUserName;
    public String field_userId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dol == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.dnX = true;
                } else if (doX == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnX) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.doW) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
