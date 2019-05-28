package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.l */
public abstract class C9537l extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int dlA = "dataType".hashCode();
    private static final int dlB = "size".hashCode();
    private static final int dlx = "data".hashCode();
    private boolean djw = true;
    private boolean dlt = true;
    private boolean dly = true;
    private boolean dlz = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;

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
                } else if (dlx == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (dlA == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getInt(i);
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
        if (this.dlt) {
            contentValues.put("data", this.field_data);
        }
        if (this.dly) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.dlz) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
