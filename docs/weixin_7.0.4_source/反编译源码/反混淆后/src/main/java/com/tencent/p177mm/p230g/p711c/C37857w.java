package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.w */
public abstract class C37857w extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnK = "sessionName".hashCode();
    private static final int dnN = "msgListDataId".hashCode();
    private boolean dnH = true;
    private boolean dnM = true;
    public String field_msgListDataId;
    public String field_sessionName;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnN == hashCode) {
                    this.field_msgListDataId = cursor.getString(i);
                    this.dnM = true;
                } else if (dnK == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnM) {
            contentValues.put("msgListDataId", this.field_msgListDataId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.dnH) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
