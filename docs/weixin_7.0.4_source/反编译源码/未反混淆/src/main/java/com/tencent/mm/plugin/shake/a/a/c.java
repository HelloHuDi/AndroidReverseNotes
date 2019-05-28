package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.e.c {
    private static final int dGw = "createtime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dnA = "title".hashCode();
    private static final int qrB = "deeplink".hashCode();
    private static final int qrC = "iconurl".hashCode();
    private boolean dGr = true;
    private boolean dlm = true;
    private boolean dnx = true;
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean qrA = true;
    private boolean qrz = true;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (qrB == hashCode) {
                    this.field_deeplink = cursor.getString(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (qrC == hashCode) {
                    this.field_iconurl = cursor.getString(i);
                } else if (dGw == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.qrz) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.qrA) {
            contentValues.put("iconurl", this.field_iconurl);
        }
        if (this.dGr) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
