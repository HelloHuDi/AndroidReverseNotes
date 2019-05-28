package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class cp extends c {
    private static final int dGA = "sayhiencryptuser".hashCode();
    private static final int dGw = "createtime".hashCode();
    private static final int dGx = "sayhiuser".hashCode();
    private static final int dGy = "sayhicontent".hashCode();
    private static final int dGz = "imgpath".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dkD = "ticket".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dqy = "talker".hashCode();
    private static final int dxo = "svrid".hashCode();
    private boolean dGr = true;
    private boolean dGs = true;
    private boolean dGt = true;
    private boolean dGu = true;
    private boolean dGv = true;
    private boolean diU = true;
    private boolean djK = true;
    private boolean djP = true;
    private boolean dkA = true;
    private boolean dkB = true;
    private boolean dnC = true;
    private boolean doh = true;
    private boolean dqn = true;
    private boolean dwC = true;
    public String field_content;
    public long field_createtime;
    public int field_flag;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiencryptuser;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public String field_ticket;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dxo == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.dwC = true;
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (dGw == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dGx == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (dGy == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (dGz == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (dGA == hashCode) {
                    this.field_sayhiencryptuser = cursor.getString(i);
                } else if (dkD == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dwC) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.dGr) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.dqn) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.dGs) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.dGt) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.dGu) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.doh) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.dGv) {
            contentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
        }
        if (this.dkB) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
