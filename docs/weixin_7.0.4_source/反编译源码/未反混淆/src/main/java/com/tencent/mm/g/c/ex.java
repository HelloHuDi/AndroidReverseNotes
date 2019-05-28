package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ex extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dmP = "openId".hashCode();
    private boolean dkE = true;
    private boolean dlm = true;
    private boolean dms = true;
    public String field_appId;
    public String field_openId;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dmP == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.dms = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dms) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
