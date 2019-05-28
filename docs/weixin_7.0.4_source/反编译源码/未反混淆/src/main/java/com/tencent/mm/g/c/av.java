package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlH = "versionType".hashCode();
    private static final int dvq = "extJson".hashCode();
    private boolean dkE = true;
    private boolean dlE = true;
    private boolean dvp = true;
    public String field_appId;
    public String field_extJson;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlH == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (dvq == hashCode) {
                    this.field_extJson = cursor.getString(i);
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
        if (this.dlE) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.dvp) {
            contentValues.put("extJson", this.field_extJson);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
