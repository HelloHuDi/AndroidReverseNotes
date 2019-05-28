package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc extends c {
    private static final int dVI = "bulletin_scene".hashCode();
    private static final int dVJ = "bulletin_content".hashCode();
    private static final int dVK = "bulletin_url".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dVF = true;
    private boolean dVG = true;
    private boolean dVH = true;
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dVI == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.dVF = true;
                } else if (dVJ == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (dVK == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dVF) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.dVG) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.dVH) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
