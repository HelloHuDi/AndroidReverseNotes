package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ft extends c {
    private static final int dLV = "appid".hashCode();
    private static final int dZv = "jsExceptionCount".hashCode();
    private static final int dZw = "crashCount".hashCode();
    private static final int dZx = "beginTimestamp".hashCode();
    private static final int dZy = "pkgVersion".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dLT = true;
    private boolean dZr = true;
    private boolean dZs = true;
    private boolean dZt = true;
    private boolean dZu = true;
    public String field_appid;
    public long field_beginTimestamp;
    public int field_crashCount;
    public int field_jsExceptionCount;
    public int field_pkgVersion;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dLV == hashCode) {
                    this.field_appid = cursor.getString(i);
                    this.dLT = true;
                } else if (dZv == hashCode) {
                    this.field_jsExceptionCount = cursor.getInt(i);
                } else if (dZw == hashCode) {
                    this.field_crashCount = cursor.getInt(i);
                } else if (dZx == hashCode) {
                    this.field_beginTimestamp = cursor.getLong(i);
                } else if (dZy == hashCode) {
                    this.field_pkgVersion = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dLT) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.dZr) {
            contentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
        }
        if (this.dZs) {
            contentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
        }
        if (this.dZt) {
            contentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
        }
        if (this.dZu) {
            contentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
