package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cm extends c {
    private static final int dGa = "countryCode".hashCode();
    private static final int dGb = "callTimeCount".hashCode();
    private static final int dGc = "lastCallTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dFX = true;
    private boolean dFY = true;
    private boolean dFZ = true;
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dGa == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.dFX = true;
                } else if (dGb == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (dGc == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFX) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.dFY) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.dFZ) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
