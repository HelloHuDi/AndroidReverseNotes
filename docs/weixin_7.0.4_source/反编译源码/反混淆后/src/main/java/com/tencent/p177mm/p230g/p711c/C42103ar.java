package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ar */
public abstract class C42103ar extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int duE = "labelID".hashCode();
    private static final int duF = "labelName".hashCode();
    private static final int duG = "labelPYFull".hashCode();
    private static final int duH = "labelPYShort".hashCode();
    private static final int duI = "isTemporary".hashCode();
    private boolean djH = true;
    private boolean duA = true;
    private boolean duB = true;
    private boolean duC = true;
    private boolean duD = true;
    private boolean duz = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (duE == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.duz = true;
                } else if (duF == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (duG == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (duH == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (duI == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.duz) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.duA) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.duB) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.duC) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.duD) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
