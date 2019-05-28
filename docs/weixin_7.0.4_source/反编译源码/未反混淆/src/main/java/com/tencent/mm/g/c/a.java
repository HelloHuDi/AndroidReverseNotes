package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    public static final String[] diI = new String[0];
    private static final int diN = "payMsgId".hashCode();
    private static final int diO = "insertmsg".hashCode();
    private static final int diP = "chatroom".hashCode();
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private boolean diJ = true;
    private boolean diK = true;
    private boolean diL = true;
    private boolean diM = true;
    public String field_chatroom;
    public boolean field_insertmsg;
    public long field_msgId;
    public String field_payMsgId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diN == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.diJ = true;
                } else if (diO == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (diP == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diJ) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.diK) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.diL) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
