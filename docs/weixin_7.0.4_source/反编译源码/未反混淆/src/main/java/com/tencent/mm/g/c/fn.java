package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn extends c {
    private static final int dSs = "timeStamp".hashCode();
    private static final int dYr = "link".hashCode();
    private static final int dYs = "imgUrl".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlF = "recordId".hashCode();
    private static final int dmb = "source".hashCode();
    private static final int dnA = "title".hashCode();
    private boolean dSm = true;
    private boolean dYp = true;
    private boolean dYq = true;
    private boolean dlC = true;
    private boolean dlY = true;
    private boolean dnx = true;
    public String field_imgUrl;
    public String field_link;
    public String field_recordId;
    public String field_source;
    public long field_timeStamp;
    public String field_title;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlF == hashCode) {
                    this.field_recordId = cursor.getString(i);
                    this.dlC = true;
                } else if (dYr == hashCode) {
                    this.field_link = cursor.getString(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dmb == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (dYs == hashCode) {
                    this.field_imgUrl = cursor.getString(i);
                } else if (dSs == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlC) {
            contentValues.put("recordId", this.field_recordId);
        }
        if (this.dYp) {
            contentValues.put("link", this.field_link);
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dlY) {
            contentValues.put("source", this.field_source);
        }
        if (this.dYq) {
            contentValues.put("imgUrl", this.field_imgUrl);
        }
        if (this.dSm) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
