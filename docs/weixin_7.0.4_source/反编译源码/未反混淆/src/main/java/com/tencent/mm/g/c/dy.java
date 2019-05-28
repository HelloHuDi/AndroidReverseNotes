package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class dy extends c {
    private static final int dFC = b.SCORE.hashCode();
    private static final int dOT = "daySec".hashCode();
    private static final int dOU = "isMute".hashCode();
    private static final int dOV = "sendCount".hashCode();
    private static final int dOW = "enterCount".hashCode();
    private static final int dOX = "disRedDotCount".hashCode();
    private static final int dOY = "stayTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diP = "chatroom".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int dom = "unReadCount".hashCode();
    private static final int dqk = "nickname".hashCode();
    private boolean dFB = true;
    private boolean dON = true;
    private boolean dOO = true;
    private boolean dOP = true;
    private boolean dOQ = true;
    private boolean dOR = true;
    private boolean dOS = true;
    private boolean diL = true;
    private boolean dnY = true;
    private boolean dqg = true;
    public String field_chatroom;
    public String field_daySec;
    public int field_disRedDotCount;
    public int field_enterCount;
    public int field_isMute;
    public String field_nickname;
    public float field_score;
    public int field_sendCount;
    public long field_stayTime;
    public int field_unReadCount;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diP == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (dOT == hashCode) {
                    this.field_daySec = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dOU == hashCode) {
                    this.field_isMute = cursor.getInt(i);
                } else if (dom == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (dOV == hashCode) {
                    this.field_sendCount = cursor.getInt(i);
                } else if (dOW == hashCode) {
                    this.field_enterCount = cursor.getInt(i);
                } else if (dOX == hashCode) {
                    this.field_disRedDotCount = cursor.getInt(i);
                } else if (dOY == hashCode) {
                    this.field_stayTime = cursor.getLong(i);
                } else if (dFC == hashCode) {
                    this.field_score = cursor.getFloat(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diL) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.dON) {
            contentValues.put("daySec", this.field_daySec);
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.dOO) {
            contentValues.put("isMute", Integer.valueOf(this.field_isMute));
        }
        if (this.dnY) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.dOP) {
            contentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
        }
        if (this.dOQ) {
            contentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
        }
        if (this.dOR) {
            contentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
        }
        if (this.dOS) {
            contentValues.put("stayTime", Long.valueOf(this.field_stayTime));
        }
        if (this.dFB) {
            contentValues.put(b.SCORE, Float.valueOf(this.field_score));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
