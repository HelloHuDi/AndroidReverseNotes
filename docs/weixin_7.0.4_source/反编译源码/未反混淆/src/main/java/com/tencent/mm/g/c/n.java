package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class n extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLocalUsageRecordUpdateTimeIndex ON AppBrandLocalUsageRecord(updateTime)"};
    private static final int diR = "rowid".hashCode();
    private static final int dlH = "versionType".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean dlE = true;
    private boolean dlm = true;
    private boolean dln = true;
    public long field_updateTime;
    public String field_username;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dlH == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dlE) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
