package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bk extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dqy = "talker".hashCode();
    private static final int dyW = "encryptTalker".hashCode();
    private static final int dzo = "msgContent".hashCode();
    private static final int dzp = "svrId".hashCode();
    private static final int dzq = "chatroomName".hashCode();
    private boolean djH = true;
    private boolean djK = true;
    private boolean doh = true;
    private boolean dqn = true;
    private boolean dyH = true;
    private boolean dzl = true;
    private boolean dzm = true;
    private boolean dzn = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzo == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (dyW == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (dzp == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dzq == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.dzl) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.doh) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.dqn) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.dyH) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.dzm) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.dzn) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
