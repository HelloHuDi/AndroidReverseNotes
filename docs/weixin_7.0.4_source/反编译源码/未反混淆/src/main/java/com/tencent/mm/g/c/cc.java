package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cc extends c {
    private static final int dEA = "small_url".hashCode();
    private static final int dEB = "big_url".hashCode();
    private static final int dEC = "ret".hashCode();
    private static final int dED = "googleitemid".hashCode();
    private static final int dEE = "googlecgistatus".hashCode();
    private static final int dEF = "contecttype".hashCode();
    private static final int dEG = "googlenamepy".hashCode();
    private static final int dEu = "googleid".hashCode();
    private static final int dEv = "googlename".hashCode();
    private static final int dEw = "googlephotourl".hashCode();
    private static final int dEx = "googlegmail".hashCode();
    private static final int dEy = "nicknameqp".hashCode();
    private static final int dEz = "usernamepy".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dqk = "nickname".hashCode();
    private boolean dEh = true;
    private boolean dEi = true;
    private boolean dEj = true;
    private boolean dEk = true;
    private boolean dEl = true;
    private boolean dEm = true;
    private boolean dEn = true;
    private boolean dEo = true;
    private boolean dEp = true;
    private boolean dEq = true;
    private boolean dEr = true;
    private boolean dEs = true;
    private boolean dEt = true;
    private boolean diU = true;
    private boolean dlm = true;
    private boolean dqg = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dEu == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (dEv == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (dEw == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (dEx == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dEy == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (dEz == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (dEA == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (dEB == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (dEC == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dED == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.dEq = true;
                } else if (dEE == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (dEF == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (dEG == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dEh) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.dEi) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.dEj) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.dEk) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.dEl) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.dEm) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.dEn) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.dEo) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.dEp) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dEq) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.dEr) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.dEs) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.dEt) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
