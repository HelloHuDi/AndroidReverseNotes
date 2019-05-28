package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cu */
public abstract class C6574cu extends C4925c {
    private static final int dIL = "loan_jump_url".hashCode();
    private static final int dIM = "red_dot_index".hashCode();
    private static final int dIN = "is_show_entry".hashCode();
    private static final int dIO = "tips".hashCode();
    private static final int dIP = "is_overdue".hashCode();
    private static final int dIQ = "available_otb".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnA = "title".hashCode();
    private boolean dIF = true;
    private boolean dIG = true;
    private boolean dIH = true;
    private boolean dII = true;
    private boolean dIJ = true;
    private boolean dIK = true;
    private boolean dnx = true;
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                    this.dnx = true;
                } else if (dIL == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i);
                } else if (dIM == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i);
                } else if (dIN == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i);
                } else if (dIO == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (dIP == hashCode) {
                    this.field_is_overdue = cursor.getInt(i);
                } else if (dIQ == hashCode) {
                    this.field_available_otb = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dIF) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.dIG) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.dIH) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.dII) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.dIJ) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.dIK) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
