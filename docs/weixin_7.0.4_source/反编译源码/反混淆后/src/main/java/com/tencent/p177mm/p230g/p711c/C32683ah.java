package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ah */
public abstract class C32683ah extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dqM = "canvasId".hashCode();
    private static final int dqN = "canvasXml".hashCode();
    private boolean djH = true;
    private boolean dqK = true;
    private boolean dqL = true;
    public long field_canvasId;
    public String field_canvasXml;
    public long field_createTime;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dqM == hashCode) {
                    this.field_canvasId = cursor.getLong(i);
                    this.dqK = true;
                } else if (dqN == hashCode) {
                    this.field_canvasXml = cursor.getString(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dqK) {
            contentValues.put("canvasId", Long.valueOf(this.field_canvasId));
        }
        if (this.dqL) {
            contentValues.put("canvasXml", this.field_canvasXml);
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
