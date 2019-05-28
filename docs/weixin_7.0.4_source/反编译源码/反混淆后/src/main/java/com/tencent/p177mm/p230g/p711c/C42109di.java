package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.di */
public abstract class C42109di extends C4925c {
    private static final int dMm = "msgContentXml".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int dqH = "isRead".hashCode();
    private boolean dMl = true;
    private boolean diM = true;
    private boolean dqw = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.diM = true;
                } else if (dMm == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (dqH == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.dMl) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.dqw) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
