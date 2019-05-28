package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv extends c {
    private static final int dAm = "subtype".hashCode();
    private static final int dIU = "bubbleMd5".hashCode();
    private static final int dIV = "coverMd5".hashCode();
    private static final int dIW = "minilogoMd5".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlS = "version".hashCode();
    private boolean dAk = true;
    private boolean dIR = true;
    private boolean dIS = true;
    private boolean dIT = true;
    private boolean dlM = true;
    public String field_bubbleMd5;
    public String field_coverMd5;
    public String field_minilogoMd5;
    public int field_subtype;
    public int field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dAm == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                    this.dAk = true;
                } else if (dIU == hashCode) {
                    this.field_bubbleMd5 = cursor.getString(i);
                } else if (dIV == hashCode) {
                    this.field_coverMd5 = cursor.getString(i);
                } else if (dIW == hashCode) {
                    this.field_minilogoMd5 = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dAk) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.dIR) {
            contentValues.put("bubbleMd5", this.field_bubbleMd5);
        }
        if (this.dIS) {
            contentValues.put("coverMd5", this.field_coverMd5);
        }
        if (this.dIT) {
            contentValues.put("minilogoMd5", this.field_minilogoMd5);
        }
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
