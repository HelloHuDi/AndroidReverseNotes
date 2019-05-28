package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.z */
public abstract class C18486z extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dok = "bizChatId".hashCode();
    private static final int dol = "brandUserName".hashCode();
    private static final int dom = "unReadCount".hashCode();
    private static final int don = "newUnReadCount".hashCode();
    private static final int doo = "lastMsgID".hashCode();
    private static final int dop = "lastMsgTime".hashCode();
    private static final int doq = "digest".hashCode();
    private static final int dor = "digestUser".hashCode();
    private static final int dos = "atCount".hashCode();
    private static final int dot = "editingMsg".hashCode();
    private static final int dou = "chatType".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dow = "msgType".hashCode();
    private static final int dox = "msgCount".hashCode();
    private boolean diU = true;
    private boolean djP = true;
    private boolean dnC = true;
    private boolean dnW = true;
    private boolean dnX = true;
    private boolean dnY = true;
    private boolean dnZ = true;
    private boolean doa = true;
    private boolean dob = true;
    private boolean doc = true;
    private boolean dod = true;
    private boolean doe = true;
    private boolean dof = true;
    private boolean dog = true;
    private boolean doh = true;
    private boolean doi = true;
    private boolean doj = true;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dok == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.dnW = true;
                } else if (dol == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (dom == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (don == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (doo == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (dop == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (doq == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (dor == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (dos == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (dot == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (dou == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (dow == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (dox == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dnW) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.dnX) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.dnY) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.dnZ) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.doa) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.dob) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.doc) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.dod) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.doe) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.dof) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.dog) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.doh) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.doi) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.doj) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.dnC) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
