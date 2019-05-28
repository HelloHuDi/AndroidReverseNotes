package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class en extends c {
    private static final int dRW = "tagId".hashCode();
    private static final int dRX = "tagName".hashCode();
    private static final int dRY = "memberList".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dwA = "count".hashCode();
    private boolean dRT = true;
    private boolean dRU = true;
    private boolean dRV = true;
    private boolean dwa = true;
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dRW == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (dRX == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (dwA == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (dRY == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dRT) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.dRU) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.dwa) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.dRV) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
