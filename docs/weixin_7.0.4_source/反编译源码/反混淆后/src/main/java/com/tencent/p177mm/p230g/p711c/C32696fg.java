package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fg */
public abstract class C32696fg extends C4925c {
    private static final int dWA = "pref_url".hashCode();
    private static final int dWB = "is_show".hashCode();
    private static final int dWC = "pref_desc".hashCode();
    private static final int dWD = "tinyapp_username".hashCode();
    private static final int dWE = "tinyapp_path".hashCode();
    private static final int dWy = "pref_key".hashCode();
    private static final int dWz = "pref_title".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dri = "logo_url".hashCode();
    private static final int dro = "jump_type".hashCode();
    private boolean dWr = true;
    private boolean dWs = true;
    private boolean dWt = true;
    private boolean dWu = true;
    private boolean dWv = true;
    private boolean dWw = true;
    private boolean dWx = true;
    private boolean dqP = true;
    private boolean dqV = true;
    public int field_is_show;
    public int field_jump_type;
    public String field_logo_url;
    public String field_pref_desc;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;
    public String field_tinyapp_path;
    public String field_tinyapp_username;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dWy == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.dWr = true;
                } else if (dWz == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (dWA == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (dWB == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (dWC == hashCode) {
                    this.field_pref_desc = cursor.getString(i);
                } else if (dri == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (dro == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (dWD == hashCode) {
                    this.field_tinyapp_username = cursor.getString(i);
                } else if (dWE == hashCode) {
                    this.field_tinyapp_path = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dWr) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.dWs) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.dWt) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.dWu) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.dWv) {
            contentValues.put("pref_desc", this.field_pref_desc);
        }
        if (this.dqP) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.dqV) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.dWw) {
            contentValues.put("tinyapp_username", this.field_tinyapp_username);
        }
        if (this.dWx) {
            contentValues.put("tinyapp_path", this.field_tinyapp_path);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
