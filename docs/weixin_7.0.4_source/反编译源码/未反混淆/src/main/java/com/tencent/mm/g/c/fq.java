package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fq extends c {
    private static final int dYK = "domin".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlF = "recordId".hashCode();
    private boolean dYJ = true;
    private boolean diZ = true;
    private boolean djw = true;
    private boolean dkE = true;
    private boolean dlC = true;
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlF == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.dlC = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dYK == hashCode) {
                    this.field_domin = cursor.getString(i);
                } else if (djA == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (djh == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlC) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dYJ) {
            contentValues.put("domin", this.field_domin);
        }
        if (this.djw) {
            contentValues.put("key", this.field_key);
        }
        if (this.diZ) {
            contentValues.put("value", this.field_value);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
