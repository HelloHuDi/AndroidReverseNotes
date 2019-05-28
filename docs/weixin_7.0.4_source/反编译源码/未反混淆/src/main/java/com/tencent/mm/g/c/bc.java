package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bc extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dye = "desc".hashCode();
    private static final int dyi = "groupID".hashCode();
    private boolean dya = true;
    private boolean dyh = true;
    public String field_desc;
    public String field_groupID;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dyi == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (dye == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dyh) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.dya) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
