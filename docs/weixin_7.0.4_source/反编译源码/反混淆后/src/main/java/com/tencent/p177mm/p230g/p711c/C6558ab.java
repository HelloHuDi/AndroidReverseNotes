package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ab */
public abstract class C6558ab extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int doX = "userId".hashCode();
    private static final int dol = "brandUserName".hashCode();
    private boolean dnX = true;
    private boolean doW = true;
    public String field_brandUserName;
    public String field_userId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dol == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.dnX = true;
                } else if (doX == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnX) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.doW) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
