package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;

public abstract class ej extends c {
    private static final int dRd = "snsID".hashCode();
    private static final int dRe = "parentID".hashCode();
    private static final int dRf = "curActionBuf".hashCode();
    private static final int dRg = "refActionBuf".hashCode();
    private static final int dRh = "commentSvrID".hashCode();
    private static final int dRi = Columns.CLIENTID.hashCode();
    private static final int dRj = "commentflag".hashCode();
    private static final int dRk = "isSilence".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dov = "isSend".hashCode();
    private static final int dqH = "isRead".hashCode();
    private static final int dqy = "talker".hashCode();
    private boolean dQV = true;
    private boolean dQW = true;
    private boolean dQX = true;
    private boolean dQY = true;
    private boolean dQZ = true;
    private boolean dRa = true;
    private boolean dRb = true;
    private boolean dRc = true;
    private boolean djH = true;
    private boolean djK = true;
    private boolean doh = true;
    private boolean dqn = true;
    private boolean dqw = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dRd == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (dRe == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (dqH == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dov == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (dRf == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (dRg == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (dRh == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (dRi == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (dRj == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (dRk == hashCode) {
                    this.field_isSilence = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dQV) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.dQW) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.dqw) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.djH) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.dqn) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.doh) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.dQX) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.dQY) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.dQZ) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.dRa) {
            contentValues.put(Columns.CLIENTID, this.field_clientId);
        }
        if (this.dRb) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.dRc) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
