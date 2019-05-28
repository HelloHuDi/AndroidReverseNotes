package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cd */
public abstract class C18466cd extends C4925c {
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

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
