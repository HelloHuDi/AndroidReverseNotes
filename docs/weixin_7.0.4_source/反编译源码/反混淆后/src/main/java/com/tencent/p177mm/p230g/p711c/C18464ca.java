package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ca */
public abstract class C18464ca extends C4925c {
    private static final int dDT = "reqType".hashCode();
    private static final int dDU = "cache".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dDR = true;
    private boolean dDS = true;
    public byte[] field_cache;
    public String field_reqType;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dDT == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.dDR = true;
                } else if (dDU == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dDR) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.dDS) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
