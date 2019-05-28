package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int dnK = "sessionName".hashCode();
    private boolean djd = true;
    private boolean dje = true;
    private boolean dnH = true;
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnK == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (djm == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.dnH) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dje) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
