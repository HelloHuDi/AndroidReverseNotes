package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.eu */
public abstract class C6576eu extends C4925c {
    private static final int dTk = "contactLabels".hashCode();
    private static final int dTl = "conDescription".hashCode();
    private static final int dTm = "conPhone".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dtB = "conRemark".hashCode();
    private static final int dtL = "encryptUsername".hashCode();
    private boolean dTh = true;
    private boolean dTi = true;
    private boolean dTj = true;
    private boolean dtk = true;
    private boolean dtu = true;
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dtL == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.dtu = true;
                } else if (dtB == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (dTk == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (dTl == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (dTm == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.dtu) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.dtk) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.dTh) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.dTi) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.dTj) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
