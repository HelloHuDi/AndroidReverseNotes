package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.as */
public abstract class C18458as extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int duL = "labelId".hashCode();
    private static final int duM = "contactName".hashCode();
    private boolean duJ;
    private boolean duK;
    public String field_contactName;
    public String field_labelId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (duL == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (duM == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.duJ) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.duK) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
