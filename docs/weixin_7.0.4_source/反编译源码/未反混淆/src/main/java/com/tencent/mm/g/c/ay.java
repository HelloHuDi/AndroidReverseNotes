package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ay extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int dlx = "data".hashCode();
    private static final int dvA = "interval".hashCode();
    private static final int dvy = "id".hashCode();
    private static final int dvz = "cacheKey".hashCode();
    private boolean dkE = true;
    private boolean dln = true;
    private boolean dlt = true;
    private boolean dvv = true;
    private boolean dvw = true;
    private boolean dvx = true;
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dvy == hashCode) {
                    this.field_id = cursor.getString(i);
                } else if (dvz == hashCode) {
                    this.field_cacheKey = cursor.getString(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlx == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (dvA == hashCode) {
                    this.field_interval = cursor.getInt(i);
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
        if (this.dvv) {
            contentValues.put("id", this.field_id);
        }
        if (this.dvw) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlt) {
            contentValues.put("data", this.field_data);
        }
        if (this.dvx) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
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
