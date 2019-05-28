package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dth = "hit".hashCode();
    private static final int dti = "hitTimeMS".hashCode();
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dtf = true;
    private boolean dtg = true;
    public String field_appId;
    public int field_hit;
    public long field_hitTimeMS;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dth == hashCode) {
                    this.field_hit = cursor.getInt(i);
                } else if (dti == hashCode) {
                    this.field_hitTimeMS = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dtf) {
            contentValues.put("hit", Integer.valueOf(this.field_hit));
        }
        if (this.dtg) {
            contentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
