package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cd extends c {
    private static final int dEJ = "championUrl".hashCode();
    private static final int dEK = "championMotto".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private boolean dEH = true;
    private boolean dEI = true;
    private boolean dlm = true;
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dEJ == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (dEK == hashCode) {
                    this.field_championMotto = cursor.getString(i);
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
        if (this.dEH) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.dEI) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
