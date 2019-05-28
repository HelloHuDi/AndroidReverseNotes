package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.bx */
public abstract class C9522bx extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int djh = "value".hashCode();
    private boolean diZ = true;
    private boolean djw = true;
    public String field_key;
    public byte[] field_value;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djA == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.djw = true;
                } else if (djh == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djw) {
            contentValues.put("key", this.field_key);
        }
        if (this.diZ) {
            contentValues.put("value", this.field_value);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
