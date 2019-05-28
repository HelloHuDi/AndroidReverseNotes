package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int duL = "labelId".hashCode();
    private static final int duM = "contactName".hashCode();
    private boolean duJ;
    private boolean duK;
    public String field_contactName;
    public String field_labelId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (duL == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (duM == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.duJ) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.duK) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
